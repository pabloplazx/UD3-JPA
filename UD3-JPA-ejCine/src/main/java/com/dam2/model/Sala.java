package com.dam2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "sala")
public class Sala {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codigo;
	private String nombre;
	private Integer capacidad;
	@OneToMany(mappedBy = "pase")
	private List<Pase> pases = new ArrayList<>();
	public Sala() {
		super();
	}
	public Sala(Long id, String codigo, String nombre, Integer capacidad, List<Pase> pases) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.pases = pases;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
	public List<Pase> getPases() {
		return pases;
	}
	public void setPases(List<Pase> pases) {
		this.pases = pases;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Sala [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", capacidad=" + capacidad + "]";
	}
	
	
}
