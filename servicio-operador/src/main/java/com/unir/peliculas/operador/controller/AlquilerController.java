package com.unir.peliculas.operador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.unir.peliculas.operador.model.pojo.Alquiler;
import com.unir.peliculas.operador.model.service.AlquilerServiceFeign;

@RestController
@RequestMapping("alquiler")
public class AlquilerController {
	
	@Autowired
	@Qualifier("serviceFeign")
	private AlquilerServiceFeign alquilerService;
	
	@RequestMapping(value = "/{idPelicula}", method = RequestMethod.POST)
    public ResponseEntity<?> agregarAlquiler(@PathVariable(value = "idPelicula") Long idPelicula, @RequestBody Alquiler alquilerRequest) throws Exception{
        Alquiler alquilerPelicula = alquilerService.agregarAlquiler(alquilerRequest, idPelicula);
        return new ResponseEntity<>(alquilerPelicula,HttpStatus.CREATED);
    }
	
	@GetMapping("/listar")
	public List<Alquiler> obtenerAlquiler() {
		return alquilerService.listarAlquiler();
	}

}
