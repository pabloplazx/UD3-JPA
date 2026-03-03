package com.dam2.main;

import java.util.List;

import com.dam2.model.Nave;
import com.dam2.model.Piloto;
import com.dam2.service.NebulaService;

import consola.Leer;

public class Main {

	public static void main(String[] args) {
		
		NebulaService service = new NebulaService();
		
		int op = 0;
		
		do {
			mostraMenu();
			op = Leer.datoInt();
			
			switch (op) {
			case 1:
				System.out.print("Id nave: ");
				int idNave = Leer.datoInt();
				
				Double ingresos = service.obtnerIngresosTotalesPorNave(idNave).get();
				System.out.println("Ingresos totales de la nave con id: "+idNave+" = "+ingresos);
				break;
			case 2:
				System.out.print("Introduzca limite: ");
		
				int limite = Leer.datoInt();
				
				while (limite < 0)  {
					System.out.print("Dato erroneo introduzca bien: ");
					limite = Leer.datoInt();
				}
				
				List<String> rutasLucrativas = service.rutasLucrativas(limite);
				
				for (String ruta : rutasLucrativas) {
					System.out.println(ruta);
				}
				break;
			case 3:
				List<Piloto> pilotos = service.buscarPilotosLicenciaActiva();
				
				for (Piloto piloto : pilotos) {
					System.out.println(piloto);
				}
				
				break;
			case 4:
				Nave nave = new Nave();
				nave.setNombre("Serenity");
				nave.setModelo("Clase Firefly");
				nave.setCapacidadCarga(75000.0);
				
				Piloto p1 = new Piloto(0, "Malcolm Reynolds", "Humano", true);
				Piloto p2 = new Piloto(0, "Hoban Washburne", "Humano", true);
				
				
				nave.addPiloto(p1);
				nave.addPiloto(p2);
				
				service.insertarNave(nave);
				
				break;
			case 5:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción no válida");
				break;
				
			}
		} while (op != 5);
		
	}
	
	private static void mostraMenu() {
		System.out.println("1. Obtener ingresos totales por nave");
		System.out.println("2. Rutas lucrativas");
		System.out.println("3. Buscar pilotos licencia activa");
		System.out.println("4. Insertar nave con pilotos");
		System.out.println("5. SALIR");
	}
}
