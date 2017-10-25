package com.cirrocode.gcp.demo.repository;

import com.cirrocode.gcp.demo.entity.Saludo;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author asalas
 */
public interface SaludoRepository extends CrudRepository<Saludo, Integer>
{
    
}