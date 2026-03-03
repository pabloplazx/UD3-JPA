package com.dam2.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.dam2.model.Estudio;

import jakarta.persistence.EntityManager;

public class EstudioDAO extends ImplDAO<Estudio, Integer>{
	
	public EstudioDAO(EntityManager em) {
		super(Estudio.class, em);
	}
	
	public List<Estudio> estudiosConMayorPresupuestoQue(Integer presupuesto) {
		
		List<Estudio> estudios = em.createQuery(
				"SELECT e FROM Estudio e", Estudio.class)
				.getResultList();
		
		List<Estudio> estudiosMayorQue = new LinkedList<>();
		
		for (Estudio estudio : estudios) {
			if (estudio.getPresupuestoAnual() > presupuesto) {
				estudiosMayorQue.add(estudio);
			}
		}
		
		return estudiosMayorQue;
	}
	
	public List<Estudio> estudiosOrdenadorPresupuestoDescendente() {
		List<Estudio> estudios = em.createQuery(
				"SELECT e FROM Estudio e", Estudio.class)
				.getResultList();
		
		List<Estudio> estudiosOrdenar = new ArrayList<>();
		estudiosOrdenar = estudios;
		Collections.sort(estudiosOrdenar);
		
		return estudiosOrdenar;
	}
	
	public Double calcularPresupuestoMedioEstudios(){
		
		Double presupuestoMedio = em.createQuery(
				"SELECT AVG(e.presupuestoAnual) FROM Estudio e", Double.class)
				.getSingleResult();
		
		return presupuestoMedio;
				
	}

}
