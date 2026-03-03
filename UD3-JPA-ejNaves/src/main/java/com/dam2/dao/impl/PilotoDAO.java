package com.dam2.dao.impl;

import java.util.List;

import com.dam2.model.Piloto;

import jakarta.persistence.EntityManager;

public class PilotoDAO extends ImplDAO<Piloto, Integer>{
	
	public PilotoDAO(EntityManager em) {
		super(Piloto.class, em);
	}
	
	public List<Piloto> buscarPilotosLicenciaActiva() {
		List<Piloto> pilotos = em.createQuery(
				"SELECT p FROM Piloto p WHERE p.estadoLicencia = :estado",
				tipo)
				.setParameter("estado", true)
				.getResultList();
		
		return pilotos;
			
				
	}

}
