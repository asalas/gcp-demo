package com.cirrocode.gcp.demo.repository;

import com.cirrocode.gcp.demo.entity.Saludo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author asalas
 */
@Repository
public interface SaludoRepository extends CrudRepository<Saludo, Integer>
{
    @Query("SELECT * FROM Saludo AS s WHERE s.mensaje = :mensj")
    Saludo findByMensaje(@Param("mensj") String mensj);
}