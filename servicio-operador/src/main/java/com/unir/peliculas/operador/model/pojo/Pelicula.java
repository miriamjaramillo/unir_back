package com.unir.peliculas.operador.model.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Pelicula implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name =  "pelicula_id", unique = true  , nullable = false)
	private Long peliculaId;
	
	@Column(name = "nombre", unique = true)
	private String nombre;
	
	@Column(name = "director")
	private String director;
	
	@Column(name = "fecha")
	@Temporal(TemporalType.DATE)
	private String fecha;
	
	@Column(name = "sinopsis")
	private String sinopsis;
	
	@Column(name = "criticas")
	private String criticas;
	
	@Column(name = "duracion")
	private String duracion;
	
	@Column(name = "youtube")
	private String youtube;
	
	@Column(name = "categoria")
	private String categoria;
	
	@Column(name = "visible")
	private Boolean visible;
	
	@Column(name = "url_image")
	private String urlimage;
	
	@Column(name = "precio")
	private BigDecimal precio;
	
	@Column(name = "ejemplares")
	private Integer ejemplares;
	
	public Long getPeliculaId() {
		return peliculaId;
	}
	
	public void setPeliculaId(Long peliculaId) {
		this.peliculaId = peliculaId;
	}
	
	public Integer getEjemplares() {
		return ejemplares;
	}
	
	public void setEjemplares(Integer ejemplares) {
		this.ejemplares = ejemplares;
	}
	
	public BigDecimal getPrecio() {
		return precio;
	}
	
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}

