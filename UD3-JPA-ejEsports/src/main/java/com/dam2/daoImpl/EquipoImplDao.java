package com.dam2.daoImpl;

import com.dam2.model.Equipo;

import jakarta.persistence.EntityManager;

public class EquipoImplDao extends ImplDao<Equipo, Integer> {
	
	public EquipoImplDao(EntityManager em) {
		super(Equipo.class, em);
	}
	
	public Equipo getEquipoConRoster(Integer id) {
		// EL SECRETO ESTÁ EN LA LÍNEA (JPQL)
		//String jpql = "SELECT e FROM Equipo LEFT JOIN FETCH e.jugadores WHERE e.id = :idEq";
		String jpql = "SELECT e FROM Equipo e JOIN FETCH e.jugadores j WHERE e.id = :idEq";
		
		Equipo equipoRecuperado = em.createQuery(jpql, Equipo.class)
				.setParameter("idEq", id)
				.getSingleResult();
		
		return equipoRecuperado;
	}

}
