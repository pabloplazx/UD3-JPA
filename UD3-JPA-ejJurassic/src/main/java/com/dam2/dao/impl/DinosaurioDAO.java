package com.dam2.dao.impl;

import java.util.List;

import com.dam2.model.Dinosaurio;

import jakarta.persistence.EntityManager;

public class DinosaurioDAO extends ImplDAO<Dinosaurio, Integer>{
	
	public DinosaurioDAO(EntityManager em) {
		super(Dinosaurio.class, em);
	}
	
	public List<Object[]> contarDinosauriosPorEspecie(int minCantidad) {
	    // Fíjate que quitamos el Dinosaurio.class del createQuery
	    List<Object[]> resultados = em.createQuery(
	            "SELECT d.especie, COUNT(d) FROM Dinosaurio d GROUP BY d.especie HAVING COUNT(d) > :minCantidad")
	            .setParameter("minCantidad", minCantidad)
	            .getResultList();
	    
	    return resultados;
	}
	
	public List<Dinosaurio> buscarDinosauriosPorEncimaPesoMedio() {
		List<Dinosaurio> dinosaurios = em.createQuery(
				"SELECT d FROM Dinosaurio d WHERE d.peso > (SELECT AVG(d2.peso) FROM Dinosaurio d2)",
				Dinosaurio.class)
				.getResultList();
		
		return dinosaurios;
	}

}
