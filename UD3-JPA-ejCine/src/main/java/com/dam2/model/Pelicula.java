package com.dam2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pelicula")
public class Pelicula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codigo;
	private String titulo;
	@Column(name = "duracion_min")
	private Integer duracionMin;
	private String genero;
	@OneToMany(mappedBy = "pelicula")
	private List<DirectorPelicula> directorPeliculas = new ArrayList<>();
	@OneToMany(mappedBy = "pelicula")
	private List<Pase> pases = new ArrayList<>();
	public Pelicula() {
		super();
	}
	public Pelicula(Long id, String codigo, String titulo, Integer duracionMin, String genero,
			List<DirectorPelicula> directorPeliculas, List<Pase> pases) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.titulo = titulo;
		this.duracionMin = duracionMin;
		this.genero = genero;
		this.directorPeliculas = directorPeliculas;
		this.pases = pases;
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
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getDuracionMin() {
		return duracionMin;
	}
	public void setDuracionMin(Integer duracionMin) {
		this.duracionMin = duracionMin;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public List<DirectorPelicula> getDirectorPeliculas() {
		return directorPeliculas;
	}
	public void setDirectorPeliculas(List<DirectorPelicula> directorPeliculas) {
		this.directorPeliculas = directorPeliculas;
	}
	public List<Pase> getPases() {
		return pases;
	}
	public void setPases(List<Pase> pases) {
		this.pases = pases;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", codigo=" + codigo + ", titulo=" + titulo + ", duracionMin=" + duracionMin
				+ ", genero=" + genero + "]";
	}

	
	
	

}
