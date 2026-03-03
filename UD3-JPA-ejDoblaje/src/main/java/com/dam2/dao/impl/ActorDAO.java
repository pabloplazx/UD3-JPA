package com.dam2.dao.impl;

import java.util.List;

import com.dam2.model.ActorDoblaje;

import jakarta.persistence.EntityManager;

public class ActorDAO extends ImplDAO<ActorDoblaje, Integer>{
	
	public ActorDAO(EntityManager em) {
		super(ActorDoblaje.class, em);
	}
	
	public ActorDoblaje buscarActorNombre(String nombre) {
		
		ActorDoblaje actor = em.createQuery(
				"SELECT a FROM ActorDoblaje a WHERE a.nombre = :nombre"
				,ActorDoblaje.class)
				.setParameter("nombre", nombre)
				.getSingleResult();
		
		return actor;
		
	}
	
	public List<ActorDoblaje> buscarActoresEstudio(Integer idEstudio) {
		return em.createQuery(
				"SELECT a FROM ActorDoblaje a WHERE a.estudio.id = :idEstudio"
				, ActorDoblaje.class)
				.getResultList();
				
	}
	
	public List<ActorDoblaje> buscarActoresSalarioMayor(Integer salario) {
		return em.createQuery(
				"SELECT a FROM ActorDoblaje a WHERE a.salarioBase > :salario"
				, ActorDoblaje.class)
				.getResultList();
	}
	
	public Integer numeroActoresPorEstudio(Integer idEstudio) {
		/*
		 * 		List<ActorDoblaje> actores = em.createQuery(
				"SELECT a FROM ActorDoblaje a WHERE a.estudio.id = :idEstudio"
				, ActorDoblaje.class)
				.setParameter("idEstudio", idEstudio)
				.getResultList();
		 */
		/*
		 * 		List<ActorDoblaje> actores = em.createQuery(
				"COUNT a FROM ActorDoblaje a WHERE a.estudio.id = :idEstudio"
				, ActorDoblaje.class)
				.setParameter("idEstudio", idEstudio)
				.getResultList();
		 */
		
		Integer cantidadActores = em.createQuery(
				"SELECT COUNT(a) FROM ActorDoblaje a WHERE a.estudio.id = :idEstudio"
				, Integer.class)
				.setParameter("idEstudio", idEstudio)
				.getSingleResult();
		
		return cantidadActores;
	}
	
	public ActorDoblaje obtenerActorMejorPagado() {
		List<ActorDoblaje> actores = em.createQuery(
				"SELECT a FROM ActorDoblaje a"
				, ActorDoblaje.class)
				.getResultList();
		
		double salarioMaximo = Double.MIN_VALUE;
		
		
		
		for (ActorDoblaje actor : actores) {
			if (actor.getSalarioBase() > salarioMaximo) {
				salarioMaximo = actor.getSalarioBase();
			}
		}
		
		ActorDoblaje actorMejorPagado = new ActorDoblaje();
		
		for (ActorDoblaje a : actores) {
			if (a.getSalarioBase() == salarioMaximo) {
				actorMejorPagado = a;
			}
		}
		
		return actorMejorPagado;
	}

}
