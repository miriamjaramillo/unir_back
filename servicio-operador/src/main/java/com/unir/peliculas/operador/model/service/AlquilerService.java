package com.unir.peliculas.operador.model.service;

import java.util.List;

import com.unir.peliculas.operador.model.pojo.Alquiler;

public interface AlquilerService {

	public Alquiler agregarAlquiler(Alquiler alquiler, Long idPelicula) throws Exception;
	public List<Alquiler> listarAlquiler();
}
