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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "proyecto")
public class Proyecto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_proyecto")
	private Integer id;
	private String titulo;
	private String idiomaOriginal;
	private Double presupuesto;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_actor",updatable = true)
	private ActorDoblaje actor;
	@OneToMany(mappedBy = "proyecto",
			fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Contrato> contratos = new LinkedList<>();
	public Proyecto() {
		super();
	}
	public Proyecto(Integer id, String titulo, String idiomaOriginal, Double presupuesto, ActorDoblaje actor,
			List<Contrato> contratos) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.idiomaOriginal = idiomaOriginal;
		this.presupuesto = presupuesto;
		this.actor = actor;
		this.contratos = contratos;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getIdiomaOriginal() {
		return idiomaOriginal;
	}
	public void setIdiomaOriginal(String idiomaOriginal) {
		this.idiomaOriginal = idiomaOriginal;
	}
	public Double getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(Double presupuesto) {
		this.presupuesto = presupuesto;
	}
	public ActorDoblaje getActor() {
		return actor;
	}
	public void setActor(ActorDoblaje actor) {
		this.actor = actor;
	}
	public List<Contrato> getContratos() {
		return contratos;
	}
	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}
	public void addContrato(Contrato c) {
		c.setProyecto(this);
		contratos.add(c);
	}
	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", titulo=" + titulo + ", idiomaOriginal=" + idiomaOriginal + ", presupuesto="
				+ presupuesto + "]";
	}
	
	
	
}
