package com.cirrocode.logging;

import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.Payload;
import io.swagger.model.HolaResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 *
 * @author asalas
 */
@Component
@Scope("singleton")
public class LoggingComponent
{
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingComponent.class);

    private LoggingOptions options;
    private Logging logging;

    @PostConstruct
    public void init()
    {
        this.options = LoggingOptions.getDefaultInstance();
        this.logging = options.getService();
    }

    @Async
    public void escribirMensajeLog(final HolaResponse holaResponse)
    {
        List<LogEntry> entries = new ArrayList<>();
        Map<String, Object> jsonMap;
        try
        {
            jsonMap = new HashMap<>();
            jsonMap.put("gcp_mensaje", holaResponse.getMensaje());                

            entries.add(LogEntry.of(Payload.JsonPayload.of(jsonMap)));

            this.logging.write(
                    entries,
                    Logging.WriteOption.logName("gcp-demo-log"), // nombre personalizado
                    Logging.WriteOption.resource(MonitoredResource.newBuilder("gae_app") // todos las apps son app_gae
                            .addLabel("project_id", options.getProjectId())// Toma el ID del proyecto en ejecucion
                            .addLabel("module_id", "gcp-demo") // Nombre del servicio en app.yaml
                            .build()));
        } 
        catch (Exception e)
        {
            LOGGER.error("Ocurrio un error al hacer logging.", e);
        }
    }    
}