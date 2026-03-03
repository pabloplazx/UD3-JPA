package com.dam2.dao.impl;

import com.dam2.dao.GenericDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ImplDAO<T,V> implements GenericDAO<T,V> {

	Class<T> tipo;
	EntityManager em;
	
	public ImplDAO(Class<T> tipo, EntityManager em){
		this.tipo = tipo;
		this.em = em;
	}
	
	//AQUÍ NO PONEMOS LA TRANSACCIÓN PORQUE
	//ES EL SERVCIO EL QUE DECIDE QUÉ SE METE
	//EN TRANSACCIÓN Y QUÉ NO
	@Override
	public void create(T object) {
		//em.getTransaction().begin();
		em.persist(object);
		//em.getTransaction().commit();
		
		
		
	}

	@Override
	public T get(V key) {
		
		T object = em.find(tipo, key);
		return object;
	}

	@Override
	public void remove(T object) {
		//em.getTransaction().begin();
		em.remove(object);
		//em.getTransaction().commit();
		
	}

	@Override
	public void update(T object) {
		//em.getTransaction().begin();
		em.merge(object);
		//em.getTransaction().commit();
		
	}

}
