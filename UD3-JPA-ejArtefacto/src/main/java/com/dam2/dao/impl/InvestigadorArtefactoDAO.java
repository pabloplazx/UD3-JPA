package com.dam2.dao.impl;

import java.util.List;

import com.dam2.model.InvestigadorArtefacto;

import jakarta.persistence.EntityManager;

public class InvestigadorArtefactoDAO extends ImplDAO<InvestigadorArtefacto, Integer>{

	public InvestigadorArtefactoDAO(EntityManager em) {
		super(InvestigadorArtefacto.class, em);
	}
	
	public List<InvestigadorArtefacto> asignacionesPorEstado(String estado) {
		return em.createQuery(
				"SELECT ia "
				+ "FROM InvestigadorArtefacto ia "
				+ "WHERE ia.estado = :estado"
				, InvestigadorArtefacto.class)
				.setParameter("estado", estado)
				.getResultList();
	}
	
	public List<InvestigadorArtefacto> asignacionesConMasDeXHoras(Integer horasMinimas) {
		return em.createQuery(
				"SELECT ia "
				+ "FROM InvestigadorArtefacto ia "
				+ "WHERE ia.horasSemana > :horasMinimas"
				, InvestigadorArtefacto.class)
				.setParameter("horasMinimas", horasMinimas)
				.getResultList();
	}
	
	public InvestigadorArtefacto suspenderAsignacion(Long investigadorId, long artefactoId, String motivoEnInforme) {
		InvestigadorArtefacto ia = em.createQuery(
				"SELECT ia "
				+ "FROM InvestigadorArtefacto ia "
				+ "WHERE ia.investigadorArtefactoId.investigadorId = :investigadorId "
				+ "AND ia.investigadorArtefactoId.artefactoId = :artefactoId", InvestigadorArtefacto.class)
				.setParameter("investigadorId", investigadorId)
				.setParameter("artefactoId", artefactoId)
				.getSingleResult();
		
		ia.setEstado("SUSPENDIDO");
		ia.setInformeFinal(motivoEnInforme);
		
		return ia;
				
	}
	
	public InvestigadorArtefacto cerrarAsignacion(Long investigadorId, long artefactoId, String motivoEnInforme) {
		InvestigadorArtefacto ia = em.createQuery(
				"SELECT ia "
				+ "FROM InvestigadorArtefacto ia "
				+ "WHERE ia.investigadorArtefactoId.investigadorId = :investigadorId "
				+ "AND ia.investigadorArtefactoId.artefactoId = :artefactoId", InvestigadorArtefacto.class)
				.setParameter("investigadorId", investigadorId)
				.setParameter("artefactoId", artefactoId)
				.getSingleResult();
		
		ia.setEstado("CERRADO");
		ia.setInformeFinal(motivoEnInforme);
		
		return ia;
				
	}
	
	public InvestigadorArtefacto cambiarHoras(Long investigadorId, Long artefactoId, Integer nuevasHoras ) {
		InvestigadorArtefacto ia = em.createQuery(
				"SELECT ia "
				+ "FROM InvestigadorArtefacto ia "
				+ "WHERE ia.investigadorArtefactoId.investigadorId = :investigadorId "
				+ "AND ia.investigadorArtefactoId.artefactoId = :artefactoId", InvestigadorArtefacto.class)
				.setParameter("investigadorId", investigadorId)
				.setParameter("artefactoId", artefactoId)
				.getSingleResult();
		
		if (ia.getEstado().equalsIgnoreCase("CERRADO")) {
			System.out.println("Al estar cerrado no se pueden cambiar las horas");
		} else {
			ia.setHorasSemana(nuevasHoras);
			System.out.println("Horas cambiadas");
		}
		
		return ia;
		
	}
}
