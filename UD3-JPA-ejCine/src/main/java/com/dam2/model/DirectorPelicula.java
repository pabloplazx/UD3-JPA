package com.dam2.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "directorpelicula")
public class DirectorPelicula {

	@EmbeddedId
	private DirectorPeliculaID directorPeliculaId;
	
	@ManyToOne
	@MapsId("directorId")
	@JoinColumn(name = "director_id")
	private Director director;
	
	@ManyToOne
	@MapsId("peliculaId")
	@JoinColumn(name = "pelicula_id")
	private Pelicula pelicula;
	
	private String rol;
	@Column(name = "fecha_colaboracion")
	private LocalDate fechaColaboracion;
	private Double cache;
	public DirectorPelicula() {
		super();
	}
	public DirectorPelicula(DirectorPeliculaID directorPeliculaId, Director director, Pelicula pelicula, String rol,
			LocalDate fechaColaboracion, Double cache) {
		super();
		this.directorPeliculaId = directorPeliculaId;
		this.director = director;
		this.pelicula = pelicula;
		this.rol = rol;
		this.fechaColaboracion = fechaColaboracion;
		this.cache = cache;
	}
	public DirectorPeliculaID getDirectorPeliculaId() {
		return directorPeliculaId;
	}
	public void setDirectorPeliculaId(DirectorPeliculaID directorPeliculaId) {
		this.directorPeliculaId = directorPeliculaId;
	}
	public Director getDirector() {
		return director;
	}
	public void setDirector(Director director) {
		this.director = director;
	}
	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public LocalDate getFechaColaboracion() {
		return fechaColaboracion;
	}
	public void setFechaColaboracion(LocalDate fechaColaboracion) {
		this.fechaColaboracion = fechaColaboracion;
	}
	public Double getCache() {
		return cache;
	}
	public void setCache(Double cache) {
		this.cache = cache;
	}
	@Override
	public int hashCode() {
		return Objects.hash(director, pelicula);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DirectorPelicula other = (DirectorPelicula) obj;
		return Objects.equals(director, other.director) && Objects.equals(pelicula, other.pelicula);
	}
	
	
}
