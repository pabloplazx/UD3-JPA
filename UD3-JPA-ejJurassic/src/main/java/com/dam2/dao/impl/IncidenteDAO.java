package com.dam2.dao.impl;

import java.util.List;

import com.dam2.model.Incidente;

import jakarta.persistence.EntityManager;

public class IncidenteDAO extends ImplDAO<Incidente, Integer>{

	public IncidenteDAO(EntityManager em) {
		super(Incidente.class, em);
	}
	
	public List<Incidente> buscaIncidentesPorGravedadYSector(String nivelPeligro, String nombreSector) {
		
		List<Incidente> incidentes = em.createQuery(
				"SELECT i FROM Incidente i JOIN i.dinosaurio d JOIN d.sector s WHERE i.nivelPeligro = :nivelPeligro AND s.nombre = :nombreSector"
				, Incidente.class)
				.setParameter("nivelPeligro", nivelPeligro)
				.setParameter("nombreSector", nombreSector)
				.getResultList();
		
		return incidentes;
				
	}
}
