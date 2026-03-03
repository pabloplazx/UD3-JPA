package com.dam2.dao.impl;

import java.util.LinkedList;
import java.util.List;

import com.dam2.model.Departamento;

import jakarta.persistence.EntityManager;

public class DepartamentoDAO extends ImplDAO<Departamento, Integer>{
	
	public DepartamentoDAO(EntityManager em) {
		super(Departamento.class, em);
	}
	
	public List<Departamento> buscarDepartamentosSinAgentes(){
		List<Departamento> departamentos = em.createQuery(
				"SELECT d FROM Departamento d", Departamento.class)
				.getResultList();
		
		List<Departamento> departamentosSinAgentes = new LinkedList<>();
		
		for (Departamento dep : departamentos) {
			if (dep.getAgentes().isEmpty()) {
				departamentosSinAgentes.add(dep);
			}
		}
		
		return departamentosSinAgentes;

	}

}
