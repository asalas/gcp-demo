package com.cirrocode.gcp.demo.converter;

import com.cirrocode.support.ObjectConverter;
import com.google.common.base.Preconditions;
import io.swagger.model.MensajesResponse;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 *
 * @author asalas
 */
@Component
public class BigQueryResultMapToMensajeConverter extends ObjectConverter<Map<String, String>, MensajesResponse>
{
    @Override
    public MensajesResponse convert(Map<String, String> bigQueryResultMap)
    {
        Preconditions.checkNotNull(bigQueryResultMap, "[bigQueryResultMap] can't be null");
        
        MensajesResponse funcionamiento = new MensajesResponse();
        funcionamiento.setFregistro(bigQueryResultMap.get("timestamp"));
        funcionamiento.setMensaje(bigQueryResultMap.get("gcp_mensaje"));
        
        return funcionamiento;
    }
}