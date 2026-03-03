package com.dam2.dao.impl;

import java.util.List;

import com.dam2.model.Sector;

import jakarta.persistence.EntityManager;

public class SectorDAO extends ImplDAO<Sector, Integer>{
	
	public SectorDAO(EntityManager em) {
		super(Sector.class, em);
	}
	
	public List<Sector> buscarSectoresOperativosSinDinosaurios() {
		
		List<Sector> sectores = em.createQuery(
				"SELECT s FROM Sector s WHERE s.operativo = true AND s.dinosaurios IS EMPTY"
				, Sector.class)
				.getResultList();
		
		return sectores;
	}

}
