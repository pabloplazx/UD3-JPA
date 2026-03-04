package com.dam2.model;

import java.util.ArrayList;
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
@Table(name = "obras")
public class Obra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	@Column(name = "anio")
	private Integer año;
	private String tipo;
	@Column(name = "estado_conservacion")
	private String estadoConservacion;
	
	@ManyToOne
	@JoinColumn(name = "artista_id")
	private Artista artista;
	
	@OneToMany(mappedBy = "obra",
			fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<ExposicionObra> exposicionObras = new ArrayList<>();

	public Obra() {
		super();
	}

	public Obra(Long id, String titulo, Integer año, String tipo, String estadoConservacion, Artista artista,
			List<ExposicionObra> exposicionObras) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.año = año;
		this.tipo = tipo;
		this.estadoConservacion = estadoConservacion;
		this.artista = artista;
		this.exposicionObras = exposicionObras;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAño() {
		return año;
	}

	public void setAño(Integer año) {
		this.año = año;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstadoConservacion() {
		return estadoConservacion;
	}

	public void setEstadoConservacion(String estadoConservacion) {
		this.estadoConservacion = estadoConservacion;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public List<ExposicionObra> getExposicionObras() {
		return exposicionObras;
	}

	public void setExposicionObras(List<ExposicionObra> exposicionObras) {
		this.exposicionObras = exposicionObras;
	}

	@Override
	public String toString() {
		return "Obra [id=" + id + ", titulo=" + titulo + ", año=" + año + ", tipo=" + tipo + ", estadoConservacion="
				+ estadoConservacion + "]";
	}

	
	
}
