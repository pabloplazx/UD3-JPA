package com.dam2.model;

import java.time.LocalDate;

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
@Table(name = "contrato")
public class Contrato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contrato")
	private Integer id;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String tipo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_proyecto",updatable = true)
	private Proyecto proyecto;
	public Contrato() {
		super();
	}
	public Contrato(Integer id, LocalDate fechaInicio, LocalDate fechaFin, String tipo, Proyecto proyecto) {
		super();
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tipo = tipo;
		this.proyecto = proyecto;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	@Override
	public String toString() {
		return "Contrato [id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", tipo=" + tipo
				+ "]";
	}
	
	

}
