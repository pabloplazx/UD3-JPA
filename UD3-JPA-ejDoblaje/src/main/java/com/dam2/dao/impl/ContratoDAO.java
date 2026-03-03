package com.dam2.dao.impl;

import java.time.LocalDate;
import java.util.List;

import com.dam2.model.Contrato;

import jakarta.persistence.EntityManager;

public class ContratoDAO extends ImplDAO<Contrato, Integer>{

	public ContratoDAO(EntityManager em)  {
		super(Contrato.class, em);
	}
	
	public List<Contrato> obtenerContratosActivosFechaDada(LocalDate fecha) {
		return em.createQuery(
				"SELECT c FROM Contrato c WHERE c.fechaInicio = :fecha",
				Contrato.class)
				.setParameter("fecha", fecha)
				.getResultList();
				
	}
	
	public List<Contrato> buscarContratosLargaDuracion(Integer diasMinimos) {
	    return em.createQuery(
	            "SELECT c FROM Contrato c WHERE FUNCTION('DATEDIFF', c.fechaFin, c.fechaInicio) > :diasMinimos", 
	            Contrato.class)
	            .setParameter("diasMinimos", diasMinimos)
	            .getResultList();
	}
	
}
