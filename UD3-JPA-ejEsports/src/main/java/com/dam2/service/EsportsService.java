package com.dam2.service;

import java.util.List;

import com.dam2.daoImpl.ImplDao;
import com.dam2.model.Equipo;
import com.dam2.model.Jugador;
import com.dam2.persistence.JpaUtil;

import jakarta.persistence.EntityManager;

public class EsportsService {

	// 1. Método para crear en cascada
	public void fundarEquipo(String nombre, String region, List<String> nicksJugadores) {
		
		EntityManager em = JpaUtil.em(); // Pedimos un EM ligero a nuestra utilidad
		ImplDao<Equipo, Integer> dao = new ImplDao<>(Equipo.class, em);
		
		em.getTransaction().begin(); // ABRIMOS TRANSACCIÓN AQUÍ
		
		Equipo eq = new Equipo();
		eq.setNombre(nombre);
		eq.setRegion(region);
		
		for (String nick : nicksJugadores) {
			Jugador j = new Jugador();
			j.setNickname(nick);
			j.setRol("Recluta"); 
			
			// VITAL: Usamos el helper para establecer la relación en ambos sentidos
			eq.addJugador(j); 
		}
		
		// Guardamos solo el equipo. JPA guarda los jugadores por el cascade = PERSIST
		dao.create(eq); 
		
		em.getTransaction().commit(); // CONSOLIDAMOS EN BASE DE DATOS
		em.close();
	}

	// 2. Método para demostrar el estado "Persistente/Managed"
	public void cambiarRolJugador(Integer idJugador, String nuevoRol) {
		
		EntityManager em = JpaUtil.em();
		em.getTransaction().begin();
		
		ImplDao<Jugador, Integer> dao = new ImplDao<>(Jugador.class, em);
		
		// Al hacer get(), el jugador entra en estado MANAGED (Vigilado por Hibernate)
		Jugador j = (Jugador) dao.get(idJugador); 
		
		if (j != null) {
			j.setRol(nuevoRol); // Cambiamos el dato en memoria
		}
		
		// NO hace falta llamar a dao.update(). Al hacer commit, 
		// Hibernate detecta el cambio en memoria y lanza el UPDATE automáticamente.
		em.getTransaction().commit(); 
		em.close();
	}
}