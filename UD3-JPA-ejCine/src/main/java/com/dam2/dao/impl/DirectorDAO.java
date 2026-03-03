package com.dam2.dao.impl;

import com.dam2.model.Director;

import jakarta.persistence.EntityManager;

public class DirectorDAO extends ImplDAO<Director, Integer> {
	
	public DirectorDAO(EntityManager em) {
		super(Director.class, em);
	}

}
