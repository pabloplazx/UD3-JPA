package com.dam2.model;

import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Equipo {

	private int id;
	private String nombre;
	private String region;
	private List<Jugador> jugadores = new LinkedList<>();
	public Equipo() {
		super();
	}
	public Equipo(int id, String nombre, String region, List<Jugador> jugadores) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.region = region;
		this.jugadores = jugadores;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	@OneToMany(mappedBy = "equipo",
			fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	public List<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	public void addJugador(Jugador j) {
		j.setEquipo(this);
		jugadores.add(j);
	}
	
	
	
	
	
}
