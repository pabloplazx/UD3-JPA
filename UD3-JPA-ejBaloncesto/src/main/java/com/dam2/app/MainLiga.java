package com.dam2.app;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.dam2.model.Equipo;
import com.dam2.model.Jugador;
import com.dam2.service.LigaService;
import com.dam2.persistence.JpaUtil;

public class MainLiga {

	public static void main(String[] args) {
		
		LigaService servicio = new LigaService();
		
		System.out.println("--- 1. PROBANDO CREACIÓN DE EQUIPO Y JUGADORES EN CASCADA ---");
		String[] nuevosJugadores = {"Luka Doncic", "Kyrie Irving", "Dereck Lively"};
		
		// Ahora le pasamos "Mavericks" como nombre y "Dallas" como ciudad
		servicio.crearEquipoConJugadores("Mavericks", "Dallas", Arrays.asList(nuevosJugadores));
		System.out.println("Equipo Mavericks guardado con éxito.");
		
		
		System.out.println("\n--- 2. PROBANDO RECUPERAR JUGADORES DE UN EQUIPO (ID 1) ---");
		// Usamos el ID 1 para la prueba. Si tu BD estaba vacía, el primer equipo creado tendrá ID 1.
		List<Jugador> equipoRecuperado = servicio.recuperarJugadoresEquipo(1);
		if(equipoRecuperado != null && !equipoRecuperado.isEmpty()) {
			equipoRecuperado.forEach(j -> System.out.println("- " + j.getNombre() + " (Dorsal: " + j.getDorsal() + ")"));
		} else {
			System.out.println("No se encontraron jugadores para el equipo 1.");
		}
		
		
		System.out.println("\n--- 3. PROBANDO TRASLADO DE JUGADOR ---");
		try {
			// Intenta trasladar el jugador 1 al equipo 1. (Si tienes más equipos, cambia los IDs para probar)
			servicio.trasladarJugador(1, 1);
			System.out.println("Traslado completado. Revisa tu BD.");
		} catch (Exception e) {
			System.out.println("Error en traslado (posiblemente no exista el ID): " + e.getMessage());
		}


		System.out.println("\n--- 4. PROBANDO JOIN FETCH (Recuperar Equipo ID 1 con Jugadores) ---");
		Optional<Equipo> equipoMagico = servicio.recuperarEquipoIdConJugadores(1);
		if(equipoMagico.isPresent()) {
			Equipo e = equipoMagico.get();
			System.out.println("Equipo recuperado: " + e.getNombre() + " de " + e.getCiudad());
			System.out.println("Jugadores (sin Lazy Exception gracias al JOIN FETCH):");
			e.getJugadores().forEach(j -> System.out.println(" -> " + j.getNombre()));
		} else {
			System.out.println("No se encontró el equipo con ID 1.");
		}
		
		// Siempre cerramos la factoría al terminar la aplicación
		JpaUtil.factory.close();
	}
}