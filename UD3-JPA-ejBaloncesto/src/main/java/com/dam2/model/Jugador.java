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
@Table(name = "jugador")
public class Jugador {
	
	private int id;
	private String nombre;
	private int dorsal;
	private Equipo equipo;
	public Jugador() {
		super();
	}
	public Jugador(int id, String nombre, int dorsal, Equipo equipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dorsal = dorsal;
		this.equipo = equipo;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Column(name = "dorsal")
	public int getDorsal() {
		return dorsal;
	}
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "equipo_id",updatable = true)
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nombre=" + nombre + ", dorsal=" + dorsal + ", equipo=" + equipo + "]";
	}

	
	
	
	
	

	
	
}