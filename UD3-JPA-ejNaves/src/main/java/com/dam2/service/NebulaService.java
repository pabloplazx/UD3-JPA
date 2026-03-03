package com.dam2.service;

import java.util.List;
import java.util.Optional;

import com.dam2.dao.GenericDAO;
import com.dam2.dao.impl.EncargoDAO;
import com.dam2.dao.impl.ImplDAO;
import com.dam2.dao.impl.PilotoDAO;
import com.dam2.model.Nave;
import com.dam2.model.Piloto;
import com.dam2.persistence.JpaUtil;

import jakarta.persistence.EntityManager;

public class NebulaService {

	public Optional<Double> obtnerIngresosTotalesPorNave(Integer id) {
		EntityManager em = JpaUtil.em();
		EncargoDAO dao =
				new EncargoDAO(em);
		Double ingresosTotales = dao.obtnerIngresosTotalesPorNave(id);
		em.close();
		return Optional.of(ingresosTotales);
	}
	
	public List<String> rutasLucrativas(Integer limite) {
		EntityManager em = JpaUtil.em();
		EncargoDAO dao =
				new EncargoDAO(em);
		List<String> rutas = dao.rutasLucrativas(limite);
		em.close();
		return rutas;
	}
	
	public List<Piloto> buscarPilotosLicenciaActiva() {
		EntityManager em = JpaUtil.em();
		PilotoDAO dao =
				new PilotoDAO(em);
		
		List<Piloto> pilotos = dao.buscarPilotosLicenciaActiva();
		em.close();
		return pilotos;
	}
	
	public void insertarNave(Nave nave) {
		EntityManager em = JpaUtil.em();
		GenericDAO<Nave, Integer> dao =
				new ImplDAO<>(Nave.class, em);
		
		em.getTransaction().begin();
		

		
		dao.create(nave);
		
		em.getTransaction().commit();
		em.close();
				
	}
}
