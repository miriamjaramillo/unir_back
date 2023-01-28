package com.unir.peliculas.operador.model.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
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
	
	@Column(name =  "cliente_nombre")
	private String clienteNombre;
	
	@Column(name =  "numero_alquiladas")
	private Integer numeroAlquiladas;

	@Column(name =  "costo_unidad")
	private BigDecimal costoUnidad;
	
	@Column(name =  "total_alquiler")
	private BigDecimal totalAlquiler;
	
	@Column(name =  "fecha")
	private Date fecha;
	
	@Column(name =  "pelicula_id")
	private Long peliculaId;
	
	@Column(name =  "operacion")
	private String operacion;
	
	@Column(name =  "nombre_pelicula")
	private String nombrePelicula;

	public Long getAlquilerId() {
		return alquilerId;
	}

	public void setAlquilerId(Long alquilerId) {
		this.alquilerId = alquilerId;
	}

	public String getClienteNombre() {
		return clienteNombre;
	}

	public void setClienteNombre(String clienteNombre) {
		this.clienteNombre = clienteNombre;
	}

	public Integer getNumeroAlquiladas() {
		return numeroAlquiladas;
	}

	public void setNumeroAlquiladas(Integer cantidadPeliculas) {
		this.numeroAlquiladas = cantidadPeliculas;
	}

	public BigDecimal getTotalAlquiler() {
		return totalAlquiler;
	}

	public void setTotalAlquiler(BigDecimal totalAlquiler) {
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
	
	public void calculaCostoAlquiler() {
		BigDecimal total = this.operacion.equals("ALQ") ? BigDecimal.valueOf(this.numeroAlquiladas).multiply(this.costoUnidad) : BigDecimal.valueOf(0);
		this.setTotalAlquiler(total);
	}
	
	public BigDecimal getCostoUnidad() {
		calculaCostoAlquiler();
		return costoUnidad;
	}
	
	public void setCostoUnidad(BigDecimal costoUnidad) {
		this.costoUnidad = costoUnidad;
	}
	
	public String getOperacion() {
		return operacion;
	}
	
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	
	public String getNombrePelicula() {
		return nombrePelicula;
	}
	
	public void setNombrePelicula(String nombrePelicula) {
		this.nombrePelicula = nombrePelicula;
	}
}
