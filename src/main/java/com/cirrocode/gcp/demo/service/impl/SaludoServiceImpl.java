package com.cirrocode.gcp.demo.service.impl;

import com.cirrocode.gcp.demo.dao.MensajesBigQueryDAO;
import com.cirrocode.gcp.demo.entity.Saludo;
import com.cirrocode.gcp.demo.repository.SaludoRepository;
import com.cirrocode.gcp.demo.service.SaludoService;
import com.cirrocode.logging.LoggingComponent;
import io.swagger.model.HolaResponse;
import io.swagger.model.MensajesResponse;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author asalas
 */
@Service
public class SaludoServiceImpl implements SaludoService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(SaludoServiceImpl.class);
    
    @Autowired private SaludoRepository saludoRepository;
    @Autowired private MensajesBigQueryDAO mensajesBigQueryDAO;
    @Autowired private LoggingComponent loggingComponent;
    
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public HolaResponse saludar(String nombre)
    {
        String mensaje = "Hola " + nombre + ", un gusto saludarte!";
        
        Saludo saludoEntity = new Saludo();
        saludoEntity.setMensaje(mensaje);
        saludoEntity.setFechaCreacion(GregorianCalendar.getInstance().getTime());
        
        // Guardar a la BD
        this.saludoRepository.save(saludoEntity);
        
        HolaResponse response = new HolaResponse();
        response.setMensaje(mensaje);
        
        // Registrar en logging de StackDriver - Exporta a BigQuery
        this.loggingComponent.escribirMensajeLog(response);
        
        return response;
    }

    @Override
    public List<MensajesResponse> leerMensajesBigQuery()
    {
        List<MensajesResponse> results = new ArrayList<>();
        try
        {
            results = this.mensajesBigQueryDAO.leerMensajes();
        }
        catch (Exception e)
        {
            LOGGER.error("Ocurrio un error al recuperar los mensajes", e);
        }
        return results;
    }
}