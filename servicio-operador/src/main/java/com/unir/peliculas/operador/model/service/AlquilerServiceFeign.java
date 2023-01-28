package com.unir.peliculas.operador.model.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
	public Alquiler agregarAlquiler(Alquiler alquiler, Long idPelicula) throws Exception {
		//Pelicula existePelicula = clienteFeign.getPeliculaPorId(idPelicula);
		
		Pelicula existePelicula = Optional.ofNullable(clienteFeign.getPeliculaPorId(idPelicula))
				.orElseThrow(() -> new Exception("No existe la pelicula con el id = " + idPelicula));
		
		Alquiler newAlquiler = new Alquiler();
		
		if (existePelicula.getEjemplares() >= alquiler.getNumeroAlquiladas() && alquiler.getOperacion().equals("ALQ") ||
				alquiler.getOperacion().equals("DEV")) {
			
			newAlquiler.setClienteNombre(alquiler.getClienteNombre());
			newAlquiler.setNumeroAlquiladas(alquiler.getNumeroAlquiladas());
			newAlquiler.setCostoUnidad(existePelicula.getPrecio());
			newAlquiler.setTotalAlquiler(alquiler.getTotalAlquiler());
			newAlquiler.setFecha(new Date());
			newAlquiler.setOperacion(alquiler.getOperacion());
			newAlquiler.setNombrePelicula(existePelicula.getNombre());
			newAlquiler.setPeliculaId(existePelicula.getPeliculaId());
			
			clienteFeign.actualizarEjemplares(idPelicula, alquiler.getNumeroAlquiladas(), alquiler.getOperacion());
		}
		
		return alquilerRepository.save(newAlquiler);
	}

	@Override
	public List<Alquiler> listarAlquiler() {
		return StreamSupport
                .stream(alquilerRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
	}

}
