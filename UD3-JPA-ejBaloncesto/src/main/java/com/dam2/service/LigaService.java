package com.dam2.service;

import java.util.List;
import java.util.Optional;

import com.dam2.dao.GenericDAO;
import com.dam2.daoImpl.EquipoImplDao;
import com.dam2.daoImpl.ImplDao;
import com.dam2.daoImpl.JugadorImplDao;
import com.dam2.model.Equipo;
import com.dam2.model.Jugador;
import com.dam2.persistence.JpaUtil;

import jakarta.persistence.EntityManager;

public class LigaService {
	
	public Optional<Equipo> recuperarEquipoId(Integer id) {
		EntityManager em = JpaUtil.em();
		GenericDAO<Equipo, Integer> dao = new ImplDao<>(Equipo.class, em);
		Equipo e = dao.get(id);
		em.close();
		return Optional.ofNullable(e);
	}
	
	// Método que usa el JOIN FETCH del DAO para evitar la LazyInitializationException
	public Optional<Equipo> recuperarEquipoIdConJugadores(Integer id) {
		EntityManager em = JpaUtil.em();
		EquipoImplDao dao = new EquipoImplDao(em);
		Equipo e = dao.getEquipoByIdWithJugadores(id);
		em.close();
		return Optional.ofNullable(e);
	}
	
	public List<Jugador> recuperarJugadoresEquipo(Integer idEquipo) {
		EntityManager em = JpaUtil.em();
		JugadorImplDao dao = new JugadorImplDao(em);
		List<Jugador> jugs = dao.getJugadoresEquipoById(idEquipo);
		em.close();
		return jugs;
	}
	
	// Aquí está el método corregido, ahora recibe la ciudad por parámetro
	public void crearEquipoConJugadores(String nombreEquipo, String ciudadEquipo, List<String> nombresJugadores) {
		
		EntityManager em = JpaUtil.em();
		GenericDAO<Equipo, Integer> dao = new ImplDao<>(Equipo.class, em);
		
		em.getTransaction().begin(); // Abrimos transacción en la capa Service
		
		Equipo eq = new Equipo();
		eq.setNombre(nombreEquipo);
		eq.setCiudad(ciudadEquipo); // SOLUCIÓN AL ERROR DE INTEGRIDAD
		
		for (int i = 0; i < nombresJugadores.size(); i++) {
			Jugador j = new Jugador();
			j.setNombre(nombresJugadores.get(i));
			j.setDorsal(i + 1); 
			
			// Al usar el método helper, se hace el j.setEquipo(this) internamente
			eq.addJugador(j); 
		}
		
		// Guardamos el equipo y, gracias al CascadeType.PERSIST, se guardan los jugadores
		dao.create(eq);
		
		em.getTransaction().commit(); // Consolidamos en BD
		em.close(); 
	}

	public void trasladarJugador(int jugadorId, int nuevoEquipoId) {
		
		EntityManager em = JpaUtil.em();
		em.getTransaction().begin();
		
		GenericDAO<Equipo, Integer> daoE = new ImplDao<>(Equipo.class, em);
		GenericDAO<Jugador, Integer> daoJ = new ImplDao<>(Jugador.class, em);
		
		// Un objeto en estado "Managed" se actualiza automáticamente al hacer commit
		Jugador j = daoJ.get(jugadorId);
		Equipo e = daoE.get(nuevoEquipoId);
		j.setEquipo(e);
		
		em.getTransaction().commit();
		em.close();
	}
}