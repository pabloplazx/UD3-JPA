package com.dam2.model;

import java.time.LocalDate;

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
@Table(name = "incidente")
public class Incidente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate fecha;
	private String descripcion;
	@Column(name = "nivel_peligro")
	private String nivelPeligro;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dinosaurio_id",updatable = true)
	private Dinosaurio dinosaurio;
	public Incidente() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNivelPeligro() {
		return nivelPeligro;
	}
	public void setNivelPeligro(String nivelPeligro) {
		this.nivelPeligro = nivelPeligro;
	}
	public Dinosaurio getDinosaurio() {
		return dinosaurio;
	}
	public void setDinosaurio(Dinosaurio dinosaurio) {
		this.dinosaurio = dinosaurio;
	}
	@Override
	public String toString() {
		return "Incidente [id=" + id + ", fecha=" + fecha + ", descripcion=" + descripcion + ", nivelPeligro="
				+ nivelPeligro + "]";
	}
	
}
