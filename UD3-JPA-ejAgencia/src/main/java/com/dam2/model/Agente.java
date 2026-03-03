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
@Table(name = "agente")
public class Agente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre_clave")
	private String nombreClave;
	private String estado;
	@Column(name = "misiones_completadas")
	private Integer misionesCompletadas;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "departamento_id",updatable = true)
	private Departamento departamento;
	public Agente() {
		super();
	}
	public Agente(Long id, String nombreClave, String estado, Integer misionesCompletadas, Departamento departamento) {
		super();
		this.id = id;
		this.nombreClave = nombreClave;
		this.estado = estado;
		this.misionesCompletadas = misionesCompletadas;
		this.departamento = departamento;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreClave() {
		return nombreClave;
	}
	public void setNombreClave(String nombreClave) {
		this.nombreClave = nombreClave;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getMisionesCompletadas() {
		return misionesCompletadas;
	}
	public void setMisionesCompletadas(Integer misionesCompletadas) {
		this.misionesCompletadas = misionesCompletadas;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
	
}
