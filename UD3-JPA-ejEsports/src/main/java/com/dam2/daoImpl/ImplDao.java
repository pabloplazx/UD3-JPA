package com.dam2.daoImpl;

import com.dam2.dao.GenericDao;

import jakarta.persistence.EntityManager;

public class ImplDao<T, V> implements GenericDao {
	
	Class<T> tipo;
	EntityManager em;

	public ImplDao(Class<T> tipo, EntityManager em) {
		super();
		this.tipo = tipo;
		this.em = em;
	}

	@Override
	public void create(Object object) {
		em.persist(object);
		
	}

	@Override
	public Object get(Object key) {
		return em.find(tipo, key);
	}

	@Override
	public void remove(Object object) {
		em.remove(object);
		
	}

	@Override
	public void update(Object object) {
		em.merge(object);
		
	}

}
