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
@Table(name = "nave")
public class Nave {
	
	private Integer id;
	private String nombre;
	private String modelo;
	private double capacidadCarga;
	private List<Piloto> pilotos = new LinkedList<>();
	private List<Encargo> encargos = new LinkedList<>();
	public Nave() {
		super();
	}
	public Nave(Integer id, String nombre, String modelo, double capacidadCarga, List<Piloto> pilotos,
			List<Encargo> encargos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.modelo = modelo;
		this.capacidadCarga = capacidadCarga;
		this.pilotos = pilotos;
		this.encargos = encargos;
	}
	
	public Nave(Integer id, String nombre, String modelo, double capacidadCarga) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.modelo = modelo;
		this.capacidadCarga = capacidadCarga;
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
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	@Column(name = "capacidad_carga")
	public double getCapacidadCarga() {
		return capacidadCarga;
	}
	public void setCapacidadCarga(double capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}
	@OneToMany(mappedBy = "nave",
			fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	public List<Piloto> getPilotos() {
		return pilotos;
	}
	public void setPilotos(List<Piloto> pilotos) {
		this.pilotos = pilotos;
	}
	@OneToMany(mappedBy = "nave",
			fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	public List<Encargo> getEncargos() {
		return encargos;
	}
	public void setEncargos(List<Encargo> encargos) {
		this.encargos = encargos;
	}
	
	public void addPiloto(Piloto p) {
		p.setNave(this);
		pilotos.add(p);
	}
	
	public void addEncargo(Encargo e) {
		e.setNave(this);
		encargos.add(e);
	}
	
	
	

}
