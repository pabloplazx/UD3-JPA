package com.dam2.dao.impl;

import java.util.Optional;

import com.dam2.model.Departamento;

import jakarta.persistence.EntityManager;

public class DepartamentoImplDAO extends ImplDAO<Departamento,Integer>{

	public DepartamentoImplDAO(EntityManager em) {
		super(Departamento.class, em);
		
	}
	
	public Departamento getDepartamentoByIdWithEmpleados(Integer id){
		
		Departamento dep = em.createQuery(
		        "SELECT d FROM Departamento d LEFT JOIN FETCH d.empleados WHERE d.id = :id",
		        tipo)
		    .setParameter("id", id)
		    .getSingleResult();

		return dep;
		
	}
	

}
