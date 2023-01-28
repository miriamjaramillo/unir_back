package com.unir.peliculas.model.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "peliculas")
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
	@Column(name = "pelicula_id", unique = true)
	private Long peliculaId;
	
	@Column(name = "nombre", unique = true)
	private String nombre;
	
	@Column(name = "director")
	private String director;
	
	@Column(name = "fecha")
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
	
	@Column(name = "urlimage")
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getCriticas() {
		return criticas;
	}

	public void setCriticas(String criticas) {
		this.criticas = criticas;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	
	public void setEjemplares(Integer ejemplares) {
		this.ejemplares = ejemplares;
	}

	public String getYoutube() {
		return youtube;
	}

	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public String getUrlimage() {
		return urlimage;
	}

	public void setUrlimage(String urlimage) {
		this.urlimage = urlimage;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Integer getEjemplares() {
		return ejemplares;
	}
	
}
