package com.dam2.dao.impl;

import java.util.List;

import com.dam2.model.Empleado;

import jakarta.persistence.EntityManager;

public class EmpleadoImplDAO extends ImplDAO<Empleado,Integer>{

	public EmpleadoImplDAO(EntityManager em) {
		super(Empleado.class, em);
		
	}
	
	public List<Empleado> getEmpleadosDeptoById(Integer id){
		
		List<Empleado> emps = em.createQuery(
				"SELECT e FROM Empleado e WHERE e.depto.id =:id"
				,tipo)
		    .setParameter("id", id)
		    .getResultList();
		return emps;
	}
	

}
