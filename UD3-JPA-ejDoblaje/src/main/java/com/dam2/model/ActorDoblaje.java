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
@Table(name ="actor_doblaje")
public class ActorDoblaje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_actor")
	private Integer id;
	private String nombre;
	private Integer edad;
	@Column(name = "salario_base")
	private Double salarioBase;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estudio",updatable = true)
	private Estudio estudio;
	@OneToMany(mappedBy = "actor",
			fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Proyecto> proyectos = new LinkedList<>();
	public ActorDoblaje() {
		super();
	}
	public ActorDoblaje(Integer id, String nombre, Integer edad, Double salarioBase, Estudio estudio,
			List<Proyecto> proyectos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.salarioBase = salarioBase;
		this.estudio = estudio;
		this.proyectos = proyectos;
	}
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
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public Double getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}
	public Estudio getEstudio() {
		return estudio;
	}
	public void setEstudio(Estudio estudio) {
		this.estudio = estudio;
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}
	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public void addProyecto(Proyecto p) {
		p.setActor(this);
		proyectos.add(p);
	}
	public ActorDoblaje(Integer id, String nombre, Integer edad, Double salarioBase) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.salarioBase = salarioBase;
	}
	

}
