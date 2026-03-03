package com.dam2.app;

import java.util.Arrays;
import java.util.List;

import com.dam2.daoImpl.EquipoImplDao;
import com.dam2.daoImpl.JugadorImplDao;
import com.dam2.model.Equipo;
import com.dam2.model.Jugador;
import com.dam2.persistence.JpaUtil;
import com.dam2.service.EsportsService;

import jakarta.persistence.EntityManager;

public class MainEsports {

	public static void main(String[] args) {
		
		EsportsService servicio = new EsportsService();
		
		System.out.println("--- 1. FUNDANDO EQUIPO EN CASCADA ---");
		// Creamos una lista de jugadores para nuestro equipo
		List<String> rosterKarmine = Arrays.asList("Cabochard", "Bo", "Saken", "Upset", "Targamas");
		
		// Al llamar a este método, el Service abrirá la transacción, el DAO hará el persist() 
		// y la cascada guardará automáticamente a los 5 jugadores.
		servicio.fundarEquipo("Karmine Corp", "Europa", rosterKarmine);
		System.out.println("Equipo Karmine Corp guardado con sus 5 jugadores en la BD.");

		
		System.out.println("\n--- 2. CAMBIANDO EL ROL DE UN JUGADOR (ESTADO MANAGED) ---");
		// Le cambiamos el rol al jugador con ID 1 (Cabochard).
		// Verás en consola que Hibernate lanza el UPDATE automáticamente al hacer commit, 
		// porque el objeto estaba siendo vigilado por el EntityManager.
		servicio.cambiarRolJugador(1, "Toplaner");
		System.out.println("Rol actualizado correctamente.");

		
		System.out.println("\n--- 3. PROBANDO JPQL: JUGADORES POR REGIÓN ---");
		// Para probar los DAOs directamente, abrimos un EntityManager ligero
		EntityManager em = JpaUtil.em(); 
		JugadorImplDao jugadorDao = new JugadorImplDao(em);
		
		// Esta consulta navegará desde el Jugador hasta su Equipo para filtrar
		List<Jugador> jugadoresEuropa = jugadorDao.getJugadoresPorRegion("Europa");
		System.out.println("Jugadores compitiendo en Europa:");
		jugadoresEuropa.forEach(j -> System.out.println("- " + j.getNickname() + " (" + j.getRol() + ")"));

		
		System.out.println("\n--- 4. PROBANDO JPQL: JOIN FETCH ---");
		EquipoImplDao equipoDao = new EquipoImplDao(em);
		
		// Recuperamos el equipo 1 forzando a que traiga a sus jugadores de golpe
		Equipo equipoRecuperado = equipoDao.getEquipoConRoster(1); 
		
		System.out.println("Equipo recuperado: " + equipoRecuperado.getNombre());
		System.out.println("Roster completo (sin LazyException gracias al FETCH):");
		equipoRecuperado.getJugadores().forEach(j -> System.out.println(" -> " + j.getNickname()));
		
		// Cerramos el EntityManager ligero
		em.close();
		
		// ¡MUY IMPORTANTE! Apagamos la factoría pesada al terminar el programa
		JpaUtil.factory.close();
	}
}