package com.dam2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "director")
public class Director {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String dni;
	private String nombre;
	private String pais;
	@OneToMany(mappedBy = "director")
	private List<DirectorPelicula> directorpeliculas = new ArrayList<>();
	public Director() {
		super();
	}
	public Director(Long id, String dni, String nombre, String pais, List<DirectorPelicula> directorpeliculas) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.pais = pais;
		this.directorpeliculas = directorpeliculas;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public List<DirectorPelicula> getDirectorpeliculas() {
		return directorpeliculas;
	}
	public void setDirectorpeliculas(List<DirectorPelicula> directorpeliculas) {
		this.directorpeliculas = directorpeliculas;
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
		Director other = (Director) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Director [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", pais=" + pais + "]";
	}
	

}
