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
@Table(name = "estudio")
public class Estudio implements Comparable<Estudio>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estudio")
	private Integer id;
	private String nombre;
	private String ciudad;
	@Column(name = "presupuesto_anual")
	private Double presupuestoAnual;
	@OneToMany(mappedBy = "estudio",
			fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ActorDoblaje> actores = new LinkedList<>();
	public Estudio() {
		super();
	}
	public Estudio(Integer id, String nombre, String ciudad, Double presupuestoAnual, List<ActorDoblaje> actores) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.presupuestoAnual = presupuestoAnual;
		this.actores = actores;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public Double getPresupuestoAnual() {
		return presupuestoAnual;
	}
	public void setPresupuestoAnual(Double presupuestoAnual) {
		this.presupuestoAnual = presupuestoAnual;
	}
	public List<ActorDoblaje> getActores() {
		return actores;
	}
	public void setActores(List<ActorDoblaje> actores) {
		this.actores = actores;
	}
	public void addActores(ActorDoblaje a) {
		a.setEstudio(this);
		actores.add(a);
	}
	@Override
	public int compareTo(Estudio e) {
		// TODO Auto-generated method stub
		return Double.compare(e.presupuestoAnual, this.presupuestoAnual);
	}
	@Override
	public String toString() {
		return "Estudio [id=" + id + ", nombre=" + nombre + ", ciudad=" + ciudad + ", presupuestoAnual="
				+ presupuestoAnual + "]";
	}
	
	
	
}
