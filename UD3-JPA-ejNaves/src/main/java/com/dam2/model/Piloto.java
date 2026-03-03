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
@Table(name = "piloto")
public class Piloto {

	private Integer id;
	private String nombre;
	private String especie;
	private Boolean estadoLicencia;
	private Nave nave;
	public Piloto() {
		super();
	}
	public Piloto(Integer id, String nombre, String especie, Boolean estadoLicencia, Nave nave) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.especie = especie;
		this.estadoLicencia = estadoLicencia;
		this.nave = nave;
	}
	
	public Piloto(Integer id, String nombre, String especie, Boolean estadoLicencia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.especie = especie;
		this.estadoLicencia = estadoLicencia;
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
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	@Column(name = "estado_licencia")
	public Boolean getEstadoLicencia() {
		return estadoLicencia;
	}
	public void setEstadoLicencia(Boolean estadoLicencia) {
		this.estadoLicencia = estadoLicencia;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nave_id",updatable = true)
	public Nave getNave() {
		return nave;
	}
	public void setNave(Nave nave) {
		this.nave = nave;
	}
	@Override
	public String toString() {
		return "Piloto [id=" + id + ", nombre=" + nombre + ", especie=" + especie + ", estadoLicencia=" + estadoLicencia
				+ "]";
	}
	
	
	
	
	
	
	
	
}
