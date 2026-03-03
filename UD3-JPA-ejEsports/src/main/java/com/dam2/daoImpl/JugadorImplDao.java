package com.dam2.daoImpl;

import java.util.List;

import com.dam2.model.Jugador;

import jakarta.persistence.EntityManager;

public class JugadorImplDao extends ImplDao<Jugador, Integer>{

	public JugadorImplDao(EntityManager em) {
		super(Jugador.class, em);
		
	}
	
	public List<Jugador> getJugadoresPorRegion(String regionBuscada) {
		String jpql = "SELECT j FROM Jugador j WHERE j.equipo.region = :reg";
		
		List<Jugador> lista = em.createQuery(jpql, Jugador.class)
				.setParameter("reg", regionBuscada)
				.getResultList();
		
		return lista;
	}

}
