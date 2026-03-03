package com.dam2.service;

import com.dam2.dao.impl.CriaturaDAO;
import com.dam2.dao.impl.CuidadorDAO;
import com.dam2.dao.impl.HabitatDAO;
import com.dam2.model.Criatura;
import com.dam2.persistence.JpaUtil;

import jakarta.persistence.EntityManager;

public class SantuarioService {
	
	public void registrarNuevaCriatura(Criatura criatura) {
		EntityManager em = JpaUtil.em();
		CriaturaDAO dao =
				new CriaturaDAO(em);
		dao.registrarNuevaCriatura(criatura);
		em.close();
	}
	
	public void actualizarRangoCuidador(Integer id, String nuevoRango) {
		EntityManager em = JpaUtil.em();
		CuidadorDAO dao =
				new CuidadorDAO(em);
		dao.actualizarRangoCuidador(id, nuevoRango);
		em.close();
	}
	
	public void obtenerDetallesHabitat(Integer id) {
		EntityManager em = JpaUtil.em();
		HabitatDAO dao =
				new HabitatDAO(em);
		dao.obtenerDetallesHabitat(id);
		em.close();
	}
	public void liberarCriatura(Integer id) {
		EntityManager em = JpaUtil.em();
		HabitatDAO dao =
				new HabitatDAO(em);
		dao.liberarCriatura(id);
		em.close();
	}
	
	

}
