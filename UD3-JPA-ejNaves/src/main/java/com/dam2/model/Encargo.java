package com.dam2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "encargo")
public class Encargo {

	private Integer id;
	private String planetaDestino;
	private String riesgo;
	private Double recompensa;
	private String estado;
	private Nave nave;
	public Encargo() {
		super();
	}
	public Encargo(Integer id, String planetaDestino, String riesgo, Double recompensa, Nave nave) {
		super();
		this.id = id;
		this.planetaDestino = planetaDestino;
		this.riesgo = riesgo;
		this.recompensa = recompensa;
		this.nave = nave;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "planeta_destino")
	public String getPlanetaDestino() {
		return planetaDestino;
	}
	public void setPlanetaDestino(String planetaDestino) {
		this.planetaDestino = planetaDestino;
	}
	public String getRiesgo() {
		return riesgo;
	}
	public void setRiesgo(String riesgo) {
		this.riesgo = riesgo;
	}
	public Double getRecompensa() {
		return recompensa;
	}
	public void setRecompensa(Double recompensa) {
		this.recompensa = recompensa;
	}
	@Column(name = "estado")
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nave_id",updatable = true)
	public Nave getNave() {
		return nave;
	}
	public void setNave(Nave nave) {
		this.nave = nave;
	}
	@Override
	public String toString() {
		return "Encargo [id=" + id + ", planetaDestino=" + planetaDestino + ", riesgo=" + riesgo + ", recompensa="
				+ recompensa + ", nave=" + nave + "]";
	}
	
	
	
}
