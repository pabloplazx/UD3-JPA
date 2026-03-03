package com.dam2.service;

import java.util.List;

import com.dam2.dao.impl.AgenteDAO;
import com.dam2.dao.impl.DepartamentoDAO;
import com.dam2.dao.impl.SedeDAO;
import com.dam2.model.Agente;
import com.dam2.model.Departamento;
import com.dam2.persistence.JpaUtil;

import jakarta.persistence.EntityManager;

public class AgenciaService {
	
	public List<Agente> buscarAgentesActivosPorNivelSecretoSede(Integer nivelSecreto) {
		EntityManager em = JpaUtil.em();
		AgenteDAO dao = new AgenteDAO(em);
		List<Agente> resultado = dao.buscarAgentesActivosPorNivelSecretoSede(nivelSecreto);
		em.close(); // <-- SIEMPRE DESPUÉS DE LA CONSULTA
		return resultado;
	}
	
	public List<Agente> buscarAgentesPorEncimaMediaEmisiones() {
		EntityManager em = JpaUtil.em();
		AgenteDAO dao = new AgenteDAO(em);
		List<Agente> resultado = dao.buscarAgentesPorEncimaMediaEmisiones();
		em.close();
		return resultado;
	}
	
	public List<Object[]> sumarPresupuestosPorUbicacionSede(Double presupuestoMinimo){
		EntityManager em = JpaUtil.em();
		SedeDAO dao = new SedeDAO(em);
		List<Object[]> resultado = dao.sumarPresupuestosPorUbicacionSede(presupuestoMinimo);
		em.close();
		return resultado;
	}
	
	public List<Departamento> buscarDepartamentosSinAgentes() {
		EntityManager em = JpaUtil.em();
		DepartamentoDAO dao = new DepartamentoDAO(em);
		List<Departamento> resultado = dao.buscarDepartamentosSinAgentes();
		em.close();
		return resultado;
	}
	
	public void actualizarNombreDepartamento(Integer id, String nuevoNombre) {
		EntityManager em = JpaUtil.em();
		
		try {
			em.getTransaction().begin();
			
			Departamento d = em.find(Departamento.class, id);
			
			if (d != null) {
				d.setNombre(nuevoNombre);
				em.merge(d);
				em.getTransaction().commit();
				System.out.println("Nombre actualizado");
			}
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback(); // Si falla, deshacemos
			}
			e.printStackTrace();
		} finally {
			em.close(); // Pase lo que pase, cerramos
		}
	}
}
