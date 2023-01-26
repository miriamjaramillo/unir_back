package com.unir.peliculas.operador.model.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.unir.peliculas.operador.clientes.PeliculaClienteRest;
import com.unir.peliculas.operador.model.pojo.Alquiler;
import com.unir.peliculas.operador.model.pojo.Pelicula;
import com.unir.peliculas.operador.model.repository.AlquilerRepository;

@Primary
@Service("serviceFeign")
public class AlquilerServiceFeign implements AlquilerService {
	
	@Autowired
	private PeliculaClienteRest clienteFeign;
	
	@Autowired
	private AlquilerRepository alquilerRepository;

	@Override
	public Pelicula findById(Long peliculaId) {
		return clienteFeign.getPeliculaPorId(peliculaId);
	}

	@Override
	public Alquiler agregarAlquiler(Alquiler alquiler) {
		Pelicula existePelicula = clienteFeign.getPeliculaPorId(alquiler.getPeliculaId());
		
		if(existePelicula == null){
			return null;
		}
		
		Alquiler newAlquiler = new Alquiler();
		newAlquiler.setCantidadPeliculas(alquiler.getCantidadPeliculas());
		newAlquiler.setClienteId(alquiler.getClienteId());
		newAlquiler.setFecha(new Date());
		return alquilerRepository.save(newAlquiler);
	}

	@Override
	public List<Alquiler> getRentByUserIdOrderFalse(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alquiler> getRentByUserIdOrderTrue(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void completarOrden(String userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarAlquiler(String id) {
		// TODO Auto-generated method stub

	}

}
