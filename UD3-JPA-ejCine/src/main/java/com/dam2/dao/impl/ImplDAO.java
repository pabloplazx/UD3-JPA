package com.dam2.dao.impl;

import com.dam2.dao.GenericDAO;

import jakarta.persistence.EntityManager;

public class ImplDAO<T,V> implements GenericDAO<T,V> {
	
	Class<T> tipo;
	EntityManager em;
	
	public ImplDAO(Class<T> tipo, EntityManager em) {
		super();
		this.tipo = tipo;
		this.em = em;
	}

	@Override
	public void create(T object) {
		em.persist(object);
	}

	@Override
	public T get(V key) {
		T object = em.find(tipo, key);
		return object;
	}

	@Override
	public void remove(T object) {
		em.remove(object);
	}

	@Override
	public void update(T object) {
		em.merge(object);
	}
}
