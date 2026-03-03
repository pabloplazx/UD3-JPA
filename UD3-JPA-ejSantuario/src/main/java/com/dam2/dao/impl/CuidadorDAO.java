package com.dam2.dao.impl;

import com.dam2.model.Cuidador;

import jakarta.persistence.EntityManager;

public class CuidadorDAO extends ImplDAO<Cuidador, Integer>{

	public CuidadorDAO(EntityManager em)  {
		super(Cuidador.class, em);
	}
	
	public void actualizarRangoCuidador(Integer id, String nuevoRango) {
		
		try {
			em.getTransaction().begin();
			
			Cuidador cuidador = em.find(Cuidador.class, id);
			
			if (cuidador != null) {
				cuidador.setRangoMagico(nuevoRango);
				
				em.getTransaction().commit();
				System.out.println("Rango actualizado");
			} else {
				System.out.println("No se encontro el cuidador con id: "+id);
			}
		} catch (Exception e) {
			// Si hay que cualquier error 
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		}
		
	}
}
