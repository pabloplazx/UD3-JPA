package com.dam2.app;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.dam2.model.ActorDoblaje;
import com.dam2.model.Contrato;
import com.dam2.model.Estudio;
import com.dam2.model.Proyecto;
import com.dam2.service.DoblajeService;

public class Main {

    public static void main(String[] args) {

        DoblajeService service = new DoblajeService();

        System.out.println("===== PROYECTOS POR IDIOMA =====");
        List<Proyecto> proyectosIdioma = service.buscarProyectosIdiomaOriginal("Inglés");
        proyectosIdioma.forEach(System.out::println);

        System.out.println("\n===== PROYECTOS DE ACTOR ID 1 =====");
        service.buscarProyectoActorConcreto(1)
               .forEach(System.out::println);

        System.out.println("\n===== PROYECTOS MAYOR QUE PRESUPUESTO ESTUDIO ACTOR 1 =====");
        service.buscarProyectosMayorQueEstudioDeActorEspecifico(1)
               .forEach(System.out::println);

        System.out.println("\n===== PRESUPUESTO TOTAL PROYECTOS ACTOR 1 =====");
        Optional<Double> totalPresupuesto = service.calcularPresupustoTotalProyectosAutor(1);
        totalPresupuesto.ifPresentOrElse(
                total -> System.out.println("Total: " + total),
                () -> System.out.println("No hay datos")
        );

        System.out.println("\n===== PROYECTOS SIN CONTRATO =====");
        service.obtenerProyectosSinContrato()
               .forEach(System.out::println);

        System.out.println("\n===== ESTUDIOS CON PRESUPUESTO MAYOR A 800000 =====");
        service.estudiosConMayorPresupuestoQue(800000)
               .forEach(System.out::println);

        System.out.println("\n===== ESTUDIOS ORDENADOS POR PRESUPUESTO DESC =====");
        service.estudiosOrdenadorPresupuestoDescendente()
               .forEach(System.out::println);

        System.out.println("\n===== PRESUPUESTO MEDIO ESTUDIOS =====");
        service.calcularPresupuestoMedioEstudios()
               .ifPresentOrElse(
                       media -> System.out.println("Media: " + media),
                       () -> System.out.println("No hay datos")
               );

        System.out.println("\n===== CONTRATOS ACTIVOS HOY =====");
        service.obtenerContratosActivosFechaDada(LocalDate.now())
               .forEach(System.out::println);

        System.out.println("\n===== CONTRATOS MAYOR A 60 DIAS =====");
        service.buscarContratosLargaDuracion(60)
               .forEach(System.out::println);

        System.out.println("\n===== BUSCAR ACTOR POR NOMBRE =====");
        service.buscarActorNombre("Carlos")
               .ifPresentOrElse(
                       System.out::println,
                       () -> System.out.println("Actor no encontrado")
               );

        System.out.println("\n===== ACTORES DEL ESTUDIO 1 =====");
        service.buscarActoresEstudio(1)
               .forEach(System.out::println);

        System.out.println("\n===== ACTORES CON SALARIO MAYOR A 30000 =====");
        service.buscarActoresSalarioMayor(30000)
               .forEach(System.out::println);

        System.out.println("\n===== NUMERO ACTORES ESTUDIO 1 =====");
        service.numeroActoresPorEstudio(1)
               .ifPresentOrElse(
                       num -> System.out.println("Total actores: " + num),
                       () -> System.out.println("No hay datos")
               );

        System.out.println("\n===== ACTOR MEJOR PAGADO =====");
        service.obtenerActorMejorPagado()
               .ifPresentOrElse(
                       System.out::println,
                       () -> System.out.println("No hay datos")
               );

        System.out.println("\n===== FIN DE PRUEBAS =====");
    }
}
