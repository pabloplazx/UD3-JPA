package com.dam2.daoImpl;

import java.util.List;

import com.dam2.model.Jugador;

import jakarta.persistence.EntityManager;

public class JugadorImplDao extends ImplDao<Jugador, Integer>{

	public JugadorImplDao(EntityManager em) {
		super(Jugador.class, em);
		
	}
	
	public List<Jugador> getJugadoresEquipoById(Integer id) {
		List<Jugador> emps = em.createQuery(
				"SELECT e FROM Jugador e WHERE e.equipo.id =:id"
				, tipo)
				.setParameter("id", id)
				.getResultList();
		
		return emps;
				
	}

}
