package com.cirrocode.gcp.demo.dao;

import io.swagger.model.MensajesResponse;
import java.util.List;

/**
 *
 * @author asalas
 */
public interface MensajesBigQueryDAO
{
    List<MensajesResponse> leerMensajes() throws Exception;
}
