package com.dam2.daoImpl;

import com.dam2.model.Equipo;

import jakarta.persistence.EntityManager;

public class EquipoImplDao extends ImplDao<Equipo, Integer>{

	public EquipoImplDao(EntityManager em) {
		super(Equipo.class, em);
	}
	
	public Equipo getEquipoByIdWithJugadores(Integer id) {
		Equipo eq = em.createQuery(
				"SELECT d FROM Equipo d LEFT JOIN FETCH d.jugadores WHERE d.id = :id",
				tipo)
				.setParameter("id", id)
				.getSingleResult();
		
		return eq;
				
	}

	

}
