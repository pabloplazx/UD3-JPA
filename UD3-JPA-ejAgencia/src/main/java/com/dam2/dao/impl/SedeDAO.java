package com.dam2.dao.impl;

import java.util.List;

import com.dam2.model.Sede;

import jakarta.persistence.EntityManager;

public class SedeDAO extends ImplDAO<Sede, Integer>{
	
	public SedeDAO(EntityManager em) {
		super(Sede.class, em);
	}
	
	public List<Object[]> sumarPresupuestosPorUbicacionSede(Double presupuestoMinimo) {
	    return em.createQuery(
	            "SELECT s.ubicacion, SUM(d.presupuesto) FROM Departamento d " +
	            "JOIN d.sede s " +
	            "GROUP BY s.ubicacion " +
	            "HAVING SUM(d.presupuesto) > :presupuestoMinimo", Object[].class)
	            .setParameter("presupuestoMinimo", presupuestoMinimo)
	            .getResultList();
	}
	
	

}
