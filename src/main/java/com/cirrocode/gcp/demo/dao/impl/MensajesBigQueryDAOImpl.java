package com.cirrocode.gcp.demo.dao.impl;

import com.cirrocode.gcp.demo.converter.BigQueryResultMapToMensajeConverter;
import com.cirrocode.gcp.demo.dao.MensajesBigQueryDAO;
import com.cirrocode.support.DateUtils;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobId;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.QueryResponse;
import com.google.cloud.bigquery.QueryResult;
import io.swagger.model.MensajesResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author asalas
 */
@Component
public class MensajesBigQueryDAOImpl implements MensajesBigQueryDAO
{
    private static final String QUERY_LEER_MENSAJES = "";
    
    @Autowired private BigQueryResultMapToMensajeConverter bigQueryResultMapToMensajeConverter;
    
    @Override
    public List<MensajesResponse> leerMensajes() throws Exception
    {
        List<MensajesResponse> listaMensajes = new ArrayList<>();
        final List<Map<String, String>> resultList = getBigQueryResultMap(QUERY_LEER_MENSAJES);
        
        resultList.forEach((resultMap) ->
        {
            listaMensajes.add(this.bigQueryResultMapToMensajeConverter.convert(resultMap));
        });
        
        return listaMensajes;
    }    
    
    private List<Map<String, String>> getBigQueryResultMap(final String guid) throws Exception
    {
        List<Map<String, String>> resultList = new ArrayList<>();
        Map<String, String> resultMap = null;
        
        BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();        
        QueryJobConfiguration queryConfig
                = QueryJobConfiguration.newBuilder(QUERY_LEER_MENSAJES)
                        // Use standard SQL syntax for queries.
                        // See: https://cloud.google.com/bigquery/sql-reference/
                        .setUseLegacySql(false)
                        .setUseQueryCache(Boolean.TRUE)
                        .build();

        // Create a job ID so that we can safely retry.
        JobId jobId = JobId.of(UUID.randomUUID().toString());
        Job queryJob = bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());

        // Wait for the query to complete.
        queryJob = queryJob.waitFor();

        // Check for errors
        if (queryJob == null)
        {
            throw new RuntimeException("Job no longer exists");
        }
        else if (queryJob.getStatus().getError() != null)
        {
            // You can also look at queryJob.getStatus().getExecutionErrors() for all
            // errors, not just the latest one.
            throw new RuntimeException(queryJob.getStatus().getError().toString());
        }

        // Get the results.
        QueryResponse response = bigquery.getQueryResults(jobId);
        
        QueryResult result = response.getResult();
        int col = 0;
        // Print all pages of the results.
        while (result != null)
        {
            for (List<FieldValue> row : result.iterateAll())
            {
                resultMap = new HashMap<>();
                for (FieldValue val : row)
                {
                   switch(col)
                    {
                        case 0:
                            resultMap.put("timestamp", null != val.getValue() ? DateUtils.timestampBigQueryToDateString(val.getStringValue()) : "");
                            break;
                        case 1:
                            resultMap.put("gcp_mensaje", val.getStringValue());
                            break;
                    }
                    col++;
                }
                resultList.add(resultMap);
                col = 0;
            }
            result = result.getNextPage();
        }   
        
        return resultList;
    }
}
