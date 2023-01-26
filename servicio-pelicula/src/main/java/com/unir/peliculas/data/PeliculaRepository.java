package com.unir.peliculas.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.unir.peliculas.model.pojo.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
	Pelicula findByPeliculaId(Long peliculaId);
	
	List<Pelicula> findByCategoria(String categoria);
	
	 @Query(value="SELECT * FROM peliculas r "
	 		+ "where r.categoria = :atributo "
	 		+ "or LOWER(r.nombre) LIKE LOWER(CONCAT('%',:atributo,'%'))"
	 		+ "or LOWER(r.director) LIKE LOWER(CONCAT('%',:atributo,'%'))",nativeQuery=true)
	 List<Pelicula> findNameByAllAtributtes(@Param("atributo") String atributo);
}
