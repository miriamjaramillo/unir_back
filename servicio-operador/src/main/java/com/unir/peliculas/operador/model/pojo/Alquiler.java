package com.unir.peliculas.operador.model.pojo;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "alquiler")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Alquiler implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name =  "alquiler_id", unique = true  , nullable = false)
	private Long alquilerId;
	
	@Column(name =  "cliente_id")
	private Long clienteId;
	
	@Column(name =  "orden")
	private boolean orden;
	
	@Column(name =  "cantidad_peliculas")
	private Integer cantidadPeliculas;

	@Column(name =  "costo_unidad")
	private Double costoUnidad;
	
	@Column(name =  "total_alquiler")
	private Double totalAlquiler;
	
	@Column(name =  "fecha")
	private Date fecha;
	
	@Column(name =  "pelicula_id")
	private Long peliculaId;

	public Long getAlquilerId() {
		return alquilerId;
	}

	public void setAlquilerId(Long alquilerId) {
		this.alquilerId = alquilerId;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public boolean isOrden() {
		return orden;
	}

	public void setOrden(boolean orden) {
		this.orden = orden;
	}

	public Integer getCantidadPeliculas() {
		return cantidadPeliculas;
	}

	public void setCantidadPeliculas(Integer cantidadPeliculas) {
		this.cantidadPeliculas = cantidadPeliculas;
	}

	public Double getCostoUnidad() {
		return costoUnidad;
	}

	public void setCostoUnidad(Double costoUnidad) {
		this.costoUnidad = costoUnidad;
	}

	public Double getTotalAlquiler() {
		return totalAlquiler;
	}

	public void setTotalAlquiler(Double totalAlquiler) {
		this.totalAlquiler = totalAlquiler;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getPeliculaId() {
		return peliculaId;
	}

	public void setPeliculaId(Long peliculaId) {
		this.peliculaId = peliculaId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
