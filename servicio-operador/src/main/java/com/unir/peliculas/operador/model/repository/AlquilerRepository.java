package com.unir.peliculas.operador.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unir.peliculas.operador.model.pojo.Alquiler;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, Long>{

}
