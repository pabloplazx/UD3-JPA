package com.dam2.model;

import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "sector")
public class Sector {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	@Column(name = "nivel_seguridad")
	private Integer nivelSeguridad;
	private Boolean operativo;
	@OneToMany(mappedBy = "sector",
			fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Dinosaurio> dinosaurios = new LinkedList<>();
	public Sector() {
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
	public Integer getNivelSeguridad() {
		return nivelSeguridad;
	}
	public void setNivelSeguridad(Integer nivelSeguridad) {
		this.nivelSeguridad = nivelSeguridad;
	}
	public Boolean getOperativo() {
		return operativo;
	}
	public void setOperativo(Boolean operativo) {
		this.operativo = operativo;
	}
	public List<Dinosaurio> getDinosaurios() {
		return dinosaurios;
	}
	public void setDinosaurios(List<Dinosaurio> dinosaurios) {
		this.dinosaurios = dinosaurios;
	}
	@Override
	public String toString() {
		return "Sector [id=" + id + ", nombre=" + nombre + ", nivelSeguridad=" + nivelSeguridad + ", operativo="
				+ operativo + "]";
	}
	
	
	
	
	

}
