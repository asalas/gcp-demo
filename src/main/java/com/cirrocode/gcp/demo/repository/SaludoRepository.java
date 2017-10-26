package com.cirrocode.gcp.demo.repository;

import com.cirrocode.gcp.demo.entity.Saludo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author asalas
 */
@Repository
public interface SaludoRepository extends CrudRepository<Saludo, Integer>
{
    
}