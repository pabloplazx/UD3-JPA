package com.dam2.app;

import java.util.List;

import com.dam2.model.Investigador;
import com.dam2.model.InvestigadorArtefacto;
import com.dam2.service.AIService;

public class MainPruebas {

    public static void main(String[] args) {

        AIService s = new AIService();

        System.out.println("=== 1) Investigadores del artefacto 2 ===");
        List<Investigador> invsArt2 = s.intestigadoresDeArtefacto(2L);
        for (Investigador i : invsArt2) {
            System.out.println("- " + i.getId() + " | " + i.getNif() + " | " + i.getNombre());
        }

        System.out.println("\n=== 2) Asignaciones con más de 6 horas ===");
        List<InvestigadorArtefacto> masDe6 = s.asignacionesConMasDeXHoras(6);
        for (InvestigadorArtefacto ia : masDe6) {
            System.out.println(
                ia.getInvestigador().getId() + "-" + ia.getArtefacto().getId()
                + " | horas=" + ia.getHorasSemana()
                + " | estado=" + ia.getEstado()
            );
        }

        System.out.println("\n=== 3) Cambiar horas (investigador 1, artefacto 2) a 20 ===");
        s.cambiarHoras(1L, 2L, 20);

        System.out.println("\n=== 4) Suspender asignación (investigador 2, artefacto 2) ===");
        s.suspenderAsignacion(2L, 2L, "Suspensión de prueba desde main.");

        System.out.println("\n=== 5) Cerrar asignación (investigador 3, artefacto 4) ===");
        s.cerrarAsignacion(3L, 4L, "Cierre de prueba desde main.");

        System.out.println("\n=== 6) Asignaciones por estado 'ACTIVO' ===");
        List<InvestigadorArtefacto> activos = s.asignacionesPorEstado("ACTIVO");
        for (InvestigadorArtefacto ia : activos) {
            System.out.println(
                ia.getInvestigador().getId() + "-" + ia.getArtefacto().getId()
                + " | horas=" + ia.getHorasSemana()
                + " | estado=" + ia.getEstado()
            );
        }

        System.out.println("\n=== 7) TOP investigadores por horas activas (TOP 5) ===");
        s.topInvestigadoresPorHorasActivas(5);

        System.out.println("\n=== 8) Conteo artefactos por origen con activos ===");
        s.conteoArtefactosPorOrigenConActivos();

        System.out.println("\n=== FIN ===");
    }
}