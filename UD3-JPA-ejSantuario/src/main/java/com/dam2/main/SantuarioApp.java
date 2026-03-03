package com.dam2.main;

import java.util.Scanner;

import com.dam2.model.Criatura;
import com.dam2.model.Cuidador;
import com.dam2.model.Habitat;
import com.dam2.service.SantuarioService;
import com.dam2.persistence.JpaUtil;

public class SantuarioApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SantuarioService service = new SantuarioService();

        int opcion;

        do {
            System.out.println("\n1. Registrar Criatura | 2. Actualizar Cuidador | 3. Ver Hábitat | 4. Liberar | 5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1:
                    registrarCriatura(sc, service);
                    break;

                case 2:
                    actualizarCuidador(sc, service);
                    break;

                case 3:
                    verHabitat(sc, service);
                    break;

                case 4:
                    liberarCriatura(sc, service);
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);

        sc.close();
        JpaUtil.factory.close(); // MUY IMPORTANTE cerrar la factoría
    }

    private static void registrarCriatura(Scanner sc, SantuarioService service) {

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Especie: ");
        String especie = sc.nextLine();

        System.out.print("Nivel peligrosidad: ");
        Integer nivel = sc.nextInt();

        System.out.print("ID Cuidador: ");
        Integer idCuidador = sc.nextInt();

        System.out.print("ID Habitat: ");
        Integer idHabitat = sc.nextInt();
        sc.nextLine();

        Cuidador cuidador = new Cuidador();
        cuidador.setId(idCuidador);

        Habitat habitat = new Habitat();
        habitat.setId(idHabitat);

        Criatura criatura = new Criatura(null, nombre, especie, nivel, cuidador, habitat);

        service.registrarNuevaCriatura(criatura);

        System.out.println("Criatura registrada correctamente.");
    }

    private static void actualizarCuidador(Scanner sc, SantuarioService service) {

        System.out.print("ID del cuidador: ");
        Integer id = sc.nextInt();
        sc.nextLine();

        System.out.print("Nuevo rango: ");
        String nuevoRango = sc.nextLine();

        service.actualizarRangoCuidador(id, nuevoRango);

        System.out.println("Rango actualizado.");
    }

    private static void verHabitat(Scanner sc, SantuarioService service) {

        System.out.print("ID del hábitat: ");
        Integer id = sc.nextInt();
        sc.nextLine();

        service.obtenerDetallesHabitat(id);
    }

    private static void liberarCriatura(Scanner sc, SantuarioService service) {

        System.out.print("ID de la criatura a liberar: ");
        Integer id = sc.nextInt();
        sc.nextLine();

        service.liberarCriatura(id);

        System.out.println("Criatura liberada.");
    }
}