package com.dam2.model;

import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "dinosaurio")
public class Dinosaurio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String especie;
	private Double peso;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sector_id",updatable = true)
	private Sector sector;
	@OneToMany(mappedBy = "dinosaurio",
			fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Incidente> incidentes = new LinkedList<>();
	public Dinosaurio() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Sector getSector() {
		return sector;
	}
	public void setSector(Sector sector) {
		this.sector = sector;
	}
	public List<Incidente> getIncidentes() {
		return incidentes;
	}
	public void setIncidentes(List<Incidente> incidentes) {
		this.incidentes = incidentes;
	}
	@Override
	public String toString() {
		return "Dinosaurio [id=" + id + ", nombre=" + nombre + ", especie=" + especie + ", peso=" + peso + "]";
	}
	
}
