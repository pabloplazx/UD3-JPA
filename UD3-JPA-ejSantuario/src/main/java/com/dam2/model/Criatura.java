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
@Table(name = "criatura")
public class Criatura {
	
	private Integer id;
	private String nombre;
	private String especie;
	private Integer nivelPeligrosidad;
	private Cuidador cuidador;
	private Habitat habitat;
	public Criatura() {
		super();
	}
	public Criatura(Integer id, String nombre, String especie, Integer nivelPeligrosidad, Cuidador cuidador,
			Habitat habitat) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.especie = especie;
		this.nivelPeligrosidad = nivelPeligrosidad;
		this.cuidador = cuidador;
		this.habitat = habitat;
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
	@Column(name = "nivel_peligrosidad")
	public Integer getNivelPeligrosidad() {
		return nivelPeligrosidad;
	}
	public void setNivelPeligrosidad(Integer nivelPeligrosidad) {
		this.nivelPeligrosidad = nivelPeligrosidad;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cuidador_id") 
	public Cuidador getCuidador() {
		return cuidador;
	}
	public void setCuidador(Cuidador cuidador) {
		this.cuidador = cuidador;
	}

	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "habitat_id")  
	public Habitat getHabitat() {
		return habitat;
	}
	public void setHabitat(Habitat habitat) {
		this.habitat = habitat;
	}
	
	
	

}
