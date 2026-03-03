package com.dam2.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pase")
public class Pase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate fecha;
	private LocalDateTime hora;
	private Double precio;
	@Column(name = "entradas_vendidas")
	private Integer entradasVendidas;
	@ManyToOne
	@JoinColumn(name = "pelicula_id")
	private Pelicula pelicula;
	@ManyToOne
	@JoinColumn(name = "sala_id")
	private Sala sala;
	public Pase() {
		super();
	}
	public Pase(Long id, LocalDate fecha, LocalDateTime hora, Double precio, Integer entradasVendidas,
			Pelicula pelicula, Sala sala) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.precio = precio;
		this.entradasVendidas = entradasVendidas;
		this.pelicula = pelicula;
		this.sala = sala;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalDateTime getHora() {
		return hora;
	}
	public void setHora(LocalDateTime hora) {
		this.hora = hora;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getEntradasVendidas() {
		return entradasVendidas;
	}
	public void setEntradasVendidas(Integer entradasVendidas) {
		this.entradasVendidas = entradasVendidas;
	}
	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
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
		Pase other = (Pase) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Pase [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", precio=" + precio + ", entradasVendidas="
				+ entradasVendidas + ", pelicula=" + pelicula + ", sala=" + sala + "]";
	}
	
	
}
