package com.dam2.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "artefacto")
public class Artefacto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codigo;
	private String nombre;
	private String origen;
	@Column(name = "nivel_riesgo")
	private Integer nivelRiesgo;
	@OneToMany(mappedBy = "artefacto")
	private List<InvestigadorArtefacto> investadorArtefactos = new ArrayList<>();
	public Artefacto() {
		super();
	}
	public Artefacto(Long id, String codigo, String nombre, String origen, Integer nivelRiesgo,
			List<InvestigadorArtefacto> investadorArtefactos) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.origen = origen;
		this.nivelRiesgo = nivelRiesgo;
		this.investadorArtefactos = investadorArtefactos;
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
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public Integer getNivelRiesgo() {
		return nivelRiesgo;
	}
	public void setNivelRiesgo(Integer nivelRiesgo) {
		this.nivelRiesgo = nivelRiesgo;
	}
	public List<InvestigadorArtefacto> getInvestadorArtefactos() {
		return investadorArtefactos;
	}
	public void setInvestadorArtefactos(List<InvestigadorArtefacto> investadorArtefactos) {
		this.investadorArtefactos = investadorArtefactos;
	}
	public Artefacto(Long id, String codigo, String nombre, String origen, Integer nivelRiesgo) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.origen = origen;
		this.nivelRiesgo = nivelRiesgo;
	}
	
	

	
	
}
