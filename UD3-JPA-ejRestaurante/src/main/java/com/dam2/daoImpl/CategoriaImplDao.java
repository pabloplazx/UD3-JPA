package com.dam2.daoImpl;

import com.dam2.model.Categoria;

import jakarta.persistence.EntityManager;

public class CategoriaImplDao extends ImplDao<Categoria, Integer> {

	public CategoriaImplDao(EntityManager em) {
		super(Categoria.class, em);
	}
	
	public Categoria getCategoriaConPlatos(Integer id) {
		String jpql = "SELECT c FROM Categoria c JOIN FETCH c.platos WHERE c.id = :idCat";
		
		Categoria categoriaRecuperado = em.createQuery(jpql, Categoria.class)
				.setParameter("idCat", id)
				.getSingleResult();
		
		return categoriaRecuperado;
	}

	
}
