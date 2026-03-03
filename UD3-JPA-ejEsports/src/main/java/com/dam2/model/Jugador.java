package com.dam2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Jugador {
	
	private int id;
	private String nickname;
	private String rol;
	private Equipo equipo;
	
	public Jugador() {
		super();
	}
	public Jugador(int id, String nickname, String rol, Equipo equipo) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.rol = rol;
		this.equipo = equipo;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "nickname")
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Column(name = "rol")
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "equipo_id",updatable = true)
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	
	

}
