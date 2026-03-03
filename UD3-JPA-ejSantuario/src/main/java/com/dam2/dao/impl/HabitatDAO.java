package com.dam2.dao.impl;


import com.dam2.model.Criatura;
import com.dam2.model.Habitat;

import jakarta.persistence.EntityManager;

public class HabitatDAO extends ImplDAO<Habitat, Integer>{

	public HabitatDAO(EntityManager em) {
		super(Habitat.class, em);
	}
	
	public void obtenerDetallesHabitat(Integer id) {
		
		em.getTransaction().begin();
		
		Habitat habitat = em.find(Habitat.class, id);
		
		if (habitat != null) {
			System.out.println(habitat);
		}
	}
	
	public void liberarCriatura(Integer id) {
		
		em.getTransaction().begin();
		
		Criatura criatura = em.find(Criatura.class, id);
		
		em.remove(criatura);
		System.out.println("Criatura eliminada");
	}
}
