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
@Table(name = "departamento")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Double presupuesto;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sede_id",updatable = true)
	private Sede sede;
	@OneToMany(mappedBy = "departamento",
			fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Agente> agentes = new LinkedList<>();
	public Departamento() {
		super();
	}
	public Departamento(Long id, String nombre, Double presupuesto, Sede sede, List<Agente> agentes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.sede = sede;
		this.agentes = agentes;
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
	public Double getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(Double presupuesto) {
		this.presupuesto = presupuesto;
	}
	public Sede getSede() {
		return sede;
	}
	public void setSede(Sede sede) {
		this.sede = sede;
	}
	public List<Agente> getAgentes() {
		return agentes;
	}
	public void setAgentes(List<Agente> agentes) {
		this.agentes = agentes;
	}
	public void addAgente(Agente a) {
		a.setDepartamento(this);
		agentes.add(a);
	}
	
}
