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
@Table(name = "habitat")
public class Habitat {
	
	private Integer id;
	private String nombre;
	private String clima;
	private Integer capacidadMaxima;
	private List<Criatura> criaturas = new LinkedList<>();
	public Habitat() {
		super();
	}
	public Habitat(Integer id, String nombre, String clima, Integer capacidadMaxima, List<Criatura> criaturas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.clima = clima;
		this.capacidadMaxima = capacidadMaxima;
		this.criaturas = criaturas;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	public String getClima() {
		return clima;
	}
	public void setClima(String clima) {
		this.clima = clima;
	}
	@Column(name = "capacidad_maxima")
	public Integer getCapacidadMaxima() {
		return capacidadMaxima;
	}
	public void setCapacidadMaxima(Integer capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}
	@OneToMany(mappedBy = "habitat",
			fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	public List<Criatura> getCriaturas() {
		return criaturas;
	}
	public void setCriaturas(List<Criatura> criaturas) {
		this.criaturas = criaturas;
	}
	
	public void addCriatura(Criatura c) {
		c.setHabitat(this);
		criaturas.add(c);
	}
	@Override
	public String toString() {
		return "Habitat [id=" + id + ", nombre=" + nombre + ", clima=" + clima + ", capacidadMaxima=" + capacidadMaxima
				+ "]";
	}
	
	

	
	
	

}
