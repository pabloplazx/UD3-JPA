package com.dam2.dao.impl;

import java.time.LocalDate;
import java.util.List;

import com.dam2.model.Exposicion;
import com.dam2.model.ExposicionObra;
import com.dam2.model.ExposicionObraId;
import com.dam2.model.Obra;

import jakarta.persistence.EntityManager;

public class ExposicionDAO extends ImplDAO<Exposicion, Long> {

    public ExposicionDAO(EntityManager em) {
        super(Exposicion.class, em);
    }

    public void añadirObraAExposicion(Long exposicionId,
                                     Long obraId,
                                     String posicion,
                                     LocalDate fechaMontaje,
                                     Double valorSeguro) {

        Exposicion expo = em.find(Exposicion.class, exposicionId);
        Obra obra = em.find(Obra.class, obraId);

        if (expo == null || obra == null) {
            throw new IllegalArgumentException("Exposición u obra no existe");
        }

        // Defaults para NOT NULL
        if (fechaMontaje == null) fechaMontaje = LocalDate.now();
        if (posicion == null || posicion.isBlank()) posicion = "SIN_POSICION";
        if (valorSeguro == null) valorSeguro = 0.0;

        ExposicionObraId id = new ExposicionObraId(exposicionId, obraId);

        ExposicionObra eo = em.find(ExposicionObra.class, id);

        if (eo == null) {
            eo = new ExposicionObra();
            eo.setExposicionObraId(id);
            eo.setExposicion(expo);
            eo.setObra(obra);

            // ✅ MUY IMPORTANTE: setear campos NOT NULL ANTES del persist
            eo.setPosicion(posicion);
            eo.setFechaMontaje(fechaMontaje);
            eo.setValorSeguro(valorSeguro);

            em.persist(eo);

        } else {
            // si ya existe, actualiza
            eo.setPosicion(posicion);
            eo.setFechaMontaje(fechaMontaje);
            eo.setValorSeguro(valorSeguro);
        }
    }

    public List<Exposicion> activasEnFecha(LocalDate fecha) {
        if (fecha == null) fecha = LocalDate.now();

        return em.createQuery("""
                SELECT e
                FROM Exposicion e
                WHERE e.fechaInicio <= :fecha
                  AND e.fechaFin >= :fecha
                ORDER BY e.fechaInicio
                """, Exposicion.class)
            .setParameter("fecha", fecha)
            .getResultList();
    }
}