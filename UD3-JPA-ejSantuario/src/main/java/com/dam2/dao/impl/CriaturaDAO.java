package com.dam2.dao.impl;

import com.dam2.model.Criatura;

import jakarta.persistence.EntityManager;

public class CriaturaDAO extends ImplDAO<Criatura, Integer>{

	public CriaturaDAO(EntityManager em) {
		super(Criatura.class, em);
	}
	
	public void registrarNuevaCriatura(Criatura criatura) {
		
		
		try  {
			if (criatura != null) {
				em.getTransaction().begin();
				
				em.persist(criatura);
				
				System.out.println("Criatura creada");
				
			} else {
				System.out.println("Criatura vacia");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
