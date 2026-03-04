package com.dam2.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "exposicion_obra")
public class ExposicionObra {

	@EmbeddedId
	private ExposicionObraId exposicionObraId;
	
	@ManyToOne
	@MapsId("exposicionId")
	@JoinColumn(name = "exposicion_id")
	private Exposicion exposicion;
	
	@ManyToOne
	@MapsId("obraId")
	@JoinColumn(name = "obra_id")
	private Obra obra;
	
	// ATRIBUTOS EXTRA
	private String posicion;
	@Column(name = "fecha_montaje", nullable = false)
	private LocalDate fechaMontaje;
	@Column(name = "valor_seguro")
	private Double valorSeguro;
	public ExposicionObra() {
		super();
	}
	public ExposicionObra(ExposicionObraId exposicionObraId, Exposicion exposicion, Obra obra, String posicion,
			LocalDate fechaMontaje, Double valorSeguro) {
		super();
		this.exposicionObraId = exposicionObraId;
		this.exposicion = exposicion;
		this.obra = obra;
		this.posicion = posicion;
		this.fechaMontaje = fechaMontaje;
		this.valorSeguro = valorSeguro;
	}
	public ExposicionObraId getExposicionObraId() {
		return exposicionObraId;
	}
	public void setExposicionObraId(ExposicionObraId exposicionObraId) {
		this.exposicionObraId = exposicionObraId;
	}
	public Exposicion getExposicion() {
		return exposicion;
	}
	public void setExposicion(Exposicion exposicion) {
		this.exposicion = exposicion;
	}
	public Obra getObra() {
		return obra;
	}
	public void setObra(Obra obra) {
		this.obra = obra;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public LocalDate getFechaMontaje() {
		return fechaMontaje;
	}
	public void setFechaMontaje(LocalDate fechaMontaje) {
		this.fechaMontaje = fechaMontaje;
	}
	public Double getValorSeguro() {
		return valorSeguro;
	}
	public void setValorSeguro(Double valorSeguro) {
		this.valorSeguro = valorSeguro;
	}
	@Override
	public int hashCode() {
		return Objects.hash(exposicionObraId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExposicionObra other = (ExposicionObra) obj;
		return Objects.equals(exposicionObraId, other.exposicionObraId);
	}
	
	
}
