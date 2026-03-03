package com.dam2.dao.impl;

import java.util.List;

import com.dam2.model.Agente;

import jakarta.persistence.EntityManager;

public class AgenteDAO extends ImplDAO<Agente, Integer> {

	public AgenteDAO(EntityManager em) {
		super(Agente.class, em);
	}
	
	public List<Agente> buscarAgentesActivosPorNivelSecretoSede(Integer nivelSecreto) {
		
		List<Agente> agentesActivos = em.createQuery(
				"SELECT a FROM Agente a "
				+ "JOIN a.departamento d "
				+ "JOIN d.sede s "
				+ "WHERE a.estado = :estado "
				+ "AND s.nivelSecreto = :nivelSecreto", 
				Agente.class)
				.setParameter("estado", "ACTIVO")
				.setParameter("nivelSecreto", nivelSecreto)
				.getResultList();
		
		return agentesActivos;
	}
	
	public List<Agente> buscarAgentesPorEncimaMediaEmisiones() {
		return em.createQuery(
				"SELECT a FROM Agente a "
				+ "WHERE a.misionesCompletadas > (SELECT AVG(a2.misionesCompletadas) FROM Agente a2",
				Agente.class)
				.getResultList();
	}
	

}
