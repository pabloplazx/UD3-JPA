package com.dam2.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "exposiciones")
public class Exposicion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	@Column(name = "fecha_inicio")
	private LocalDate fechaInicio;
	@Column(name = "fecha_fin")
	private LocalDate fechaFin;
	private String sala;
	
	@OneToMany(mappedBy = "exposicion",
			fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<ExposicionObra> exposicionObras = new ArrayList<>();

	public Exposicion() {
		super();
	}

	public Exposicion(Long id, String nombre, LocalDate fechaInicio, LocalDate fechaFin, String sala,
			List<ExposicionObra> exposicionObras) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.sala = sala;
		this.exposicionObras = exposicionObras;
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
		Exposicion other = (Exposicion) obj;
		return Objects.equals(id, other.id);
	}
	
}
