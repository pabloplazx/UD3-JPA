package com.dam2.daoImpl;

import java.util.List;

import com.dam2.model.Plato;

import jakarta.persistence.EntityManager;

public class PlatoImplDao extends ImplDao<Plato, Integer>{

	public PlatoImplDao(EntityManager em) {
		super(Plato.class, em);
		
	}
	
	public List<Plato> getPlatosPorCategoria(String nombreCategoria) {
		String jpql = "SELECT p From Plato p WHERE p.categoria.nombre = :nom";
		
		List<Plato> platos = em.createQuery(jpql, Plato.class)
				.setParameter("nom", nombreCategoria)
				.getResultList();
		
		return platos;
	}

}
