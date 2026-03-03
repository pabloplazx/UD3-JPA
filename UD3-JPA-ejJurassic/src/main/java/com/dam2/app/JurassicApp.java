package com.dam2.app;


import java.util.List;

import com.dam2.service.JurassicService;

import consola.Leer;

public class JurassicApp {

	public static void main(String[] args) {
		
		JurassicService service = new JurassicService();
		
		int op = 0;
		
		do {
			mostrarMenu();
			System.out.print("Introduzca opcion: ");
			op = Leer.datoInt();
			
			switch (op) {
			case 1:
				System.out.print("Cantidad minima: ");
				int minCantidad = Leer.datoInt();
				
				// Recogemos la lista que nos manda el Service
				List<Object[]> conteo = service.contarDinosauriosPorEspecie(minCantidad);
				
				if (conteo.isEmpty()) {
					System.out.println("No hay ninguna especie que supere esa cantidad.");
				} else {
					System.out.println("\n--- RESULTADOS ---");
					// Recorremos la lista. Cada 'fila' es un array con [Especie, Cantidad]
					for (Object[] fila : conteo) {
						String especie = (String) fila[0];
						Long cantidad = (Long) fila[1]; // Ojo: COUNT en JPA devuelve Long, no Integer
						
						System.out.println("Especie: " + especie + " -> Total: " + cantidad + " dinosaurios");
					}
					System.out.println("------------------\n");
				}
				break;
			case 2:
				service.buscarDinosauriosPorEncimaPesoMedio().stream().forEach(x -> System.out.println(x));
				break;
			case 3:
				System.out.print("Introduzca nivel peligrosidad: ");
				String nivelPeligro = Leer.dato();
				
				System.out.print("Introduzca sector: ");
				String nombreSector = Leer.dato();
				
				service.buscaIncidentesPorGravedadYSector(nivelPeligro, nombreSector).stream().forEach(x -> System.out.println(x));
				break;
			case 4:
				service.buscarSectoresOperativosSinDinosaurios().stream().forEach(x -> System.out.println(x));
				break;
			case 5:
				System.out.print("Id: ");
				int id = Leer.datoInt();
				System.out.print("Nuevo nombre: ");
				String nuevoNombre = Leer.dato();
				
				service.actualizarNombreDinosaurio(id, nuevoNombre);
				break;
			case 6:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción no válidada :(");
				break;
			}
		} while (op != 6);
	}
	
	private static void mostrarMenu() {
		System.out.println("1. Contar dinosaurios por especie");
		System.out.println("2. Buscar dinosaurios por encima de la media de peso");
		System.out.println("3. Buscar incidentes por gravedad y sector");
		System.out.println("4. Buscar Sectores sin dinosaurios");
		System.out.println("5. Actualizar nombre dinosaurio");
		System.out.println("6. SALIR");
		
	}
}
