package com.dam2.dao.impl;

import java.util.List;

import com.dam2.model.Artefacto;

import jakarta.persistence.EntityManager;

public class ArtefactoDAO extends ImplDAO<Artefacto, Integer>{

	public ArtefactoDAO(EntityManager em) {
		super(Artefacto.class, em);
	}
	
	public Artefacto crearArtefacto(String codigo, String nombre, String origen, Integer nivelRiesgo) {
		Artefacto artefacto = new Artefacto((long) 0, codigo, nombre, origen, nivelRiesgo);
		
		return artefacto;
	}
	
	public List<Artefacto> artefactosDeInvestigador(Long investigadorId) {
		return em.createQuery(
					"SELECT ia.artefacto "
					+ "FROM InvestigadorArtefacto ia "
					+ "WHERE ia.investigador.id = :investigadorId",
					Artefacto.class)
				.setParameter("investigadorId", investigadorId)
				.getResultList();
				
				
	}
	
	public List<Artefacto> artefactosSinAsignaciones() {
		
		return em.createQuery(
				"SELECT a FROM Artefacto a "
				+ "WHERE a.investigadorArtefactos IS EMPTY"
				, Artefacto.class)
				.getResultList();
				
	}
	
	
	public List<Object[]> conteoArtefactosPorOrigenConActivos() {
	    return em.createQuery(
	            "SELECT a.origen, COUNT(DISTINCT a.id) " +
	            "FROM InvestigadorArtefacto ia JOIN ia.artefacto a " +
	            "WHERE UPPER(ia.estado) = :estado " +
	            "GROUP BY a.origen " +
	            "ORDER BY COUNT(DISTINCT a.id) DESC",
	            Object[].class
	    )
	    .setParameter("estado", "ACTIVO")
	    .getResultList();
	}
}
