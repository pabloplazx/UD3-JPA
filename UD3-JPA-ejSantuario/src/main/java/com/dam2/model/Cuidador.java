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
@Table(name = "cuidador")
public class Cuidador {
	
	private Integer id;
	private String nombre;
	private String rangoMagico;
	private Integer añosExperiencia;
	private List<Criatura> criaturas = new LinkedList<>();
	public Cuidador() {
		super();
	}
	public Cuidador(Integer id, String nombre, String rangoMagico, Integer añosExperiencia, List<Criatura> criaturas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.rangoMagico = rangoMagico;
		this.añosExperiencia = añosExperiencia;
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
	@Column(name = "rango_magico")
	public String getRangoMagico() {
		return rangoMagico;
	}
	public void setRangoMagico(String rangoMagico) {
		this.rangoMagico = rangoMagico;
	}
	@Column(name = "anios_experiencia")
	public Integer getAñosExperiencia() {
		return añosExperiencia;
	}
	public void setAñosExperiencia(Integer añosExperiencia) {
		this.añosExperiencia = añosExperiencia;
	}
	
	@OneToMany(mappedBy = "cuidador",
			fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	public List<Criatura> getCriaturas() {
		return criaturas;
	}
	public void setCriaturas(List<Criatura> criaturas) {
		this.criaturas = criaturas;
	}
	
	public void addCriatura(Criatura c) {
		c.setCuidador(this);
		criaturas.add(c);
	}
	
	


}
