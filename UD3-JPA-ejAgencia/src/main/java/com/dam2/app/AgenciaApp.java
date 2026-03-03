package com.dam2.app;

import java.util.List;
import java.util.Scanner;

import com.dam2.model.Agente;
import com.dam2.model.Departamento;
import com.dam2.service.AgenciaService;

public class AgenciaApp {

	public static void main(String[] args) {
		
		AgenciaService service = new AgenciaService();
		Scanner sc = new Scanner(System.in);
		int op = 0;
		
		do {
			mostrarMenu();
			System.out.print("Introduzca opcion: ");
			
			try {
				op = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				op = 0; // Evitamos que el programa explote si meten una letra
			}
			
			switch (op) {
			case 1:
				System.out.print("Introduzca el nivel de secreto de la sede: ");
				int nivelSecreto = Integer.parseInt(sc.nextLine());
				List<Agente> agentesActivos = service.buscarAgentesActivosPorNivelSecretoSede(nivelSecreto);
				System.out.println("\n--- AGENTES ACTIVOS EN SEDE NIVEL " + nivelSecreto + " ---");
				agentesActivos.forEach(a -> System.out.println(a));
				System.out.println("----------------------------------------\n");
				break;
				
			case 2:
				List<Agente> agentesTop = service.buscarAgentesPorEncimaMediaEmisiones();
				System.out.println("\n--- AGENTES POR ENCIMA DE LA MEDIA ---");
				agentesTop.forEach(a -> System.out.println(a));
				System.out.println("--------------------------------------\n");
				break;
				
			case 3:
				System.out.print("Introduzca el presupuesto mínimo a filtrar: ");
				double presupuestoMinimo = Double.parseDouble(sc.nextLine());
				List<Object[]> presupuestos = service.sumarPresupuestosPorUbicacionSede(presupuestoMinimo);
				
				System.out.println("\n--- PRESUPUESTOS POR UBICACIÓN ---");
				if(presupuestos.isEmpty()) {
					System.out.println("Ninguna sede supera ese presupuesto.");
				} else {
					for (Object[] fila : presupuestos) {
						String ubicacion = (String) fila[0];
						Double total = (Double) fila[1];
						System.out.println("Sede: " + ubicacion + " -> Presupuesto Total: " + total + "€");
					}
				}
				System.out.println("----------------------------------\n");
				break;
				
			case 4:
				List<Departamento> deptsFantasma = service.buscarDepartamentosSinAgentes();
				System.out.println("\n--- DEPARTAMENTOS SIN AGENTES ---");
				if(deptsFantasma.isEmpty()) {
					System.out.println("Todos los departamentos tienen agentes asignados.");
				} else {
					deptsFantasma.forEach(d -> System.out.println(d));
				}
				System.out.println("---------------------------------\n");
				break;
				
			case 5:
				System.out.print("Introduzca el ID del departamento a modificar: ");
				int idDept = Integer.parseInt(sc.nextLine());
				System.out.print("Introduzca el nuevo nombre: ");
				String nuevoNombre = sc.nextLine();
				
				service.actualizarNombreDepartamento(idDept, nuevoNombre);
				break;
				
			case 6:
				System.out.println("Cerrando el sistema de la agencia...");
				break;
				
			default:
				System.out.println("Opción no válida. Inténtelo de nuevo.\n");
				break;
			}
			
		} while (op != 6);
		
		sc.close();
	}
	
	private static void mostrarMenu() {
		System.out.println("1. Buscar agentes activos por nivel secreto de sede");
		System.out.println("2. Buscar agentes por encima de la media de misiones");
		System.out.println("3. Sumar presupuestos por ubicacion sede");
		System.out.println("4. Buscar departamentos sin agentes");
		System.out.println("5. Actualizar nombre departamento");
		System.out.println("6. SALIR");
	}
}