package com.dam2.dao.impl;

import java.time.LocalDate;
import java.util.List;

import com.dam2.model.Investigador;

import jakarta.persistence.EntityManager;

public class InvestigadorDAO extends ImplDAO<Investigador, Integer>{

	public InvestigadorDAO(EntityManager em) {
		super(Investigador.class, em);
	}
	
	public Investigador crearInvestigador(String nif, String nombre, String especialidad, LocalDate fechaIngreso) {
		
		Investigador investigador = new Investigador((long) 0, nif, nombre, especialidad, fechaIngreso);
		return investigador;
	}
	
	public List<Investigador> investigadoresDeArtefacto(Long artefactoId) {
		return em.createQuery(
				"SELECT ia.investigador "
				+ "FROM InvestigadorArtefacto ia "
				+ "WHERE ia.artefacto.id = :artefactoId"
				, Investigador.class)
				.setParameter("artefactoId", artefactoId)
				.getResultList();
	}
	
	public void borrarInvestigador(Long investigadorId) {
		
		Investigador i = em.find(Investigador.class, investigadorId);
		em.remove(i);
	}
	
	public List<Object[]> topInvestigadoresPorHorasActivas(int topN) {
	    return em.createQuery(
	            "SELECT i.nif, i.nombre, SUM(ia.horasSemana) " +
	            "FROM InvestigadorArtefacto ia JOIN ia.investigador i " +
	            "WHERE UPPER(ia.estado) = :estado " +
	            "GROUP BY i.nif, i.nombre " +
	            "ORDER BY SUM(ia.horasSemana) DESC",
	            Object[].class
	    )
	    .setParameter("estado", "ACTIVO")
	    .setMaxResults(topN)
	    .getResultList();
	}
}
