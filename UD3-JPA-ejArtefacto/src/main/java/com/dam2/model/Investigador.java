package com.dam2.model;

import java.time.LocalDate;
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
@Table(name = "investigador")
public class Investigador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nif;
	private String nombre;
	private String especialidad;
	@Column(name = "fecha_ingreso")
	private LocalDate fechaIngreso;
	@OneToMany(mappedBy = "investigador")
	private List<InvestigadorArtefacto> investigadorArtefactos = new ArrayList<>();
	public Investigador() {
		super();
	}
	public Investigador(Long id, String nif, String nombre, String especialidad, LocalDate fechaIngreso,
			List<InvestigadorArtefacto> investigadorArtefactos) {
		super();
		this.id = id;
		this.nif = nif;
		this.nombre = nombre;
		this.especialidad = especialidad;
		this.fechaIngreso = fechaIngreso;
		this.investigadorArtefactos = investigadorArtefactos;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public List<InvestigadorArtefacto> getInvestigadorArtefactos() {
		return investigadorArtefactos;
	}
	public void setInvestigadorArtefactos(List<InvestigadorArtefacto> investigadorArtefactos) {
		this.investigadorArtefactos = investigadorArtefactos;
	}
	public Investigador(Long id, String nif, String nombre, String especialidad, LocalDate fechaIngreso) {
		super();
		this.id = id;
		this.nif = nif;
		this.nombre = nombre;
		this.especialidad = especialidad;
		this.fechaIngreso = fechaIngreso;
	}

	
	
	

}
