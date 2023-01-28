package com.unir.peliculas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.unir.peliculas.data.PeliculaRepository;
import com.unir.peliculas.model.pojo.Pelicula;
import com.unir.peliculas.model.request.CreatePeliculaRequest;

@Service
public class PeliculasServiceImpl implements PeliculasService{
	@Autowired
	private PeliculaRepository repository;
	
	@Override
	public List<Pelicula> getPeliculas(){
		List<Pelicula> peliculas = repository.findAll();
		return peliculas.isEmpty()?null:peliculas;
	}

	@Override
	public List<Pelicula> getPeliculasBySearch(String informacion){
		//List<Pelicula> peliculas = repository.findAll();
		List<Pelicula> peliculas = repository.findNameByAllAtributtes(informacion);
		return peliculas.isEmpty()?null:peliculas;
	}

	
	@Override
	public Pelicula createPelicula(CreatePeliculaRequest request) {
		if (request != null && StringUtils.hasLength(request.getNombre().trim())
				&& StringUtils.hasLength(request.getDirector().trim())
				&& StringUtils.hasLength(request.getFecha().trim()) 
				&& StringUtils.hasLength(request.getSinopsis().trim())
				&& StringUtils.hasLength(request.getCriticas().trim())
				&& StringUtils.hasLength(request.getDuracion().trim())
				&& StringUtils.hasLength(request.getYoutube().trim())
				&& StringUtils.hasLength(request.getCategoria().trim())				
				&& StringUtils.hasLength(request.getUrlimage().trim())
				//&& request.getVisible() != null
				) 
		{

			/*Pelicula pelicula = Pelicula.builder().
					nombre(request.getNombre()).
					director(request.getDirector()).
					fecha(request.getFecha()).
					sinopsis(request.getSinopsis()).
					criticas(request.getCriticas()).
					duracion(request.getDuracion()).
					youtube(request.getYoutube()).
					categoria(request.getCategoria()).
					visible(request.getVisible()).
					urlimage(request.getUrlimage()).
					build();*/

			return repository.save(null);
		} else {
			return null;
		}
	}

	@Override
	public Pelicula getPeliculaById(Long peliculaId) throws Exception {		
		return (Pelicula) Optional.ofNullable(repository.findByPeliculaId(peliculaId))
				.orElseThrow(() ->  
				new Exception("Pelicula no encontrada : " + peliculaId)
		);
	}

	@Override
	public Pelicula updateEjemplaresById(Long peliculaId, Integer numEjemplares, String operacion) throws Exception {
		Pelicula existePelicula = getPeliculaById(peliculaId);
		
		if (existePelicula != null) {
			Integer totalEjemplares = operacion.equals("ALQ") ? (existePelicula.getEjemplares() - numEjemplares) : (existePelicula.getEjemplares() + numEjemplares);
			existePelicula.setEjemplares(totalEjemplares);
			return repository.save(existePelicula);
		}
		return null;
	}
}
