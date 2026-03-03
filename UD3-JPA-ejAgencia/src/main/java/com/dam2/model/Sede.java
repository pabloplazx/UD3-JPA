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
@Table(name = "sede")
public class Sede {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ubicacion;
	@Column(name = "nivel_secreto")
	private Integer nivelSecreto;
	private Boolean activa;
	@OneToMany(mappedBy = "sede",
			fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Departamento> departamentos = new LinkedList<>();
	public Sede() {
		super();
	}
	public Sede(Long id, String ubicacion, Integer nivelSecreto, Boolean activa, List<Departamento> departamentos) {
		super();
		this.id = id;
		this.ubicacion = ubicacion;
		this.nivelSecreto = nivelSecreto;
		this.activa = activa;
		this.departamentos = departamentos;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public Integer getNivelSecreto() {
		return nivelSecreto;
	}
	public void setNivelSecreto(Integer nivelSecreto) {
		this.nivelSecreto = nivelSecreto;
	}
	public Boolean getActiva() {
		return activa;
	}
	public void setActiva(Boolean activa) {
		this.activa = activa;
	}
	public List<Departamento> getDepartamentos() {
		return departamentos;
	}
	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}
	
	public void addDepartamento(Departamento d) {
		d.setSede(this);
		departamentos.add(d);
	}
}
