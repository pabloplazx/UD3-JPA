package com.dam2.app;

import java.time.LocalDate;
import java.util.List;

import com.dam2.model.Artista;
import com.dam2.model.Exposicion;
import com.dam2.model.Obra;
import com.dam2.service.MuseoService;

public class MainPruebaMuseo {

    public static void main(String[] args) {

        MuseoService service = new MuseoService();

        // IDs que EXISTAN en tu BD (ajústalos)
        Long artistaId = 1L;
        Long exposicionId = 1L;
        Long obraId = 2L;

        // 1) Listar artistas
        System.out.println("=== ARTISTAS ===");
        List<Artista> artistas = service.listarTodosArtistas();
        artistas.forEach(System.out::println);

        // 2) Buscar artista por id
        System.out.println("\n=== ARTISTA ID " + artistaId + " ===");
        Artista a = service.buscarPorId(artistaId);
        System.out.println(a);

        // 3) Actualizar nombre (si existe)
        if (a != null) {
            service.actualizarNombre(a.getId(), "Nombre Cambiado " + System.currentTimeMillis());
            System.out.println("✅ Artista actualizado");
        }

        // 4) Listar obras por estado
        System.out.println("\n=== OBRAS ESTADO 'BUENO' ===");
        List<Obra> obrasBueno = service.listarPorEstado("BUENO");
        obrasBueno.forEach(System.out::println);

        // 5) Listar obras por artista
        System.out.println("\n=== OBRAS DEL ARTISTA " + artistaId + " ===");
        List<Obra> obrasArtista = service.listarPorArtisa(artistaId);
        obrasArtista.forEach(System.out::println);

        // 6) Exposiciones activas en fecha
        LocalDate fecha = LocalDate.of(2026, 3, 10);
        System.out.println("\n=== EXPOSICIONES ACTIVAS EN " + fecha + " ===");
        List<Exposicion> activas = service.activasEnFecha(fecha);
        activas.forEach(System.out::println);

        // 7) Añadir obra a exposición (usa una combinación que NO exista, o tu DAO lanza excepción)
        System.out.println("\n=== AÑADIR OBRA A EXPOSICION ===");
        service.añadirObraAExposicion(exposicionId, obraId, "Muro Sur", LocalDate.now(), 18000.0);
        System.out.println("✅ Relación creada/actualizada");

        System.out.println("\n✅ FIN");
    }
}