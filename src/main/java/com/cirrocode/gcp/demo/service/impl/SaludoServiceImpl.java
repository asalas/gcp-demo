package com.cirrocode.gcp.demo.service.impl;

import com.cirrocode.gcp.demo.entity.Saludo;
import com.cirrocode.gcp.demo.repository.SaludoRepository;
import com.cirrocode.gcp.demo.service.SaludoService;
import java.util.GregorianCalendar;
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
    @Autowired private SaludoRepository saludoRepository;
    
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public String saludar(String nombre)
    {
        String mensaje = "Hola " + nombre + ", un gusto saludarte!";
        
        Saludo saludoEntity = new Saludo();
        saludoEntity.setMensaje(mensaje);
        saludoEntity.setFechaCreacion(GregorianCalendar.getInstance().getTime());
        
        this.saludoRepository.save(saludoEntity);
        
        return mensaje;
    }
}