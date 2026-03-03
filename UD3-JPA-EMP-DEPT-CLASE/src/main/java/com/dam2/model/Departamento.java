package com.dam2.model;

import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Departamento {
	
	private Integer id;
	private String nombre;
	private List<Empleado> empleados = new LinkedList<>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@OneToMany(mappedBy = "depto",
			fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	public List<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	public void addEmpleado(Empleado e) {
		//IMPORTANTE FIJAR EL DEPARTAMENTO PARA QUE
		//SE FIJE EL CAMPO CLAVE AJENA DESDE EL EMPLEADO
		//QUE ES EL PROPIETARIO DE LA RELACIÓN
		e.setDepto(this);
		empleados.add(e);
	}

}
