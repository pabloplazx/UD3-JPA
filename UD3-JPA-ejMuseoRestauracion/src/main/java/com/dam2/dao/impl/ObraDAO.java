package com.dam2.dao.impl;

import java.util.List;

import com.dam2.model.Obra;

import jakarta.persistence.EntityManager;

public class ObraDAO extends ImplDAO<Obra, Long> {

    public ObraDAO(EntityManager em) {
        super(Obra.class, em);
    }

    public List<Obra> listarPorEstado(String estado) {
        return em.createQuery("""
                SELECT o
                FROM Obra o
                WHERE o.estadoConservacion = :estado
                ORDER BY o.titulo
                """, Obra.class)
            .setParameter("estado", estado)
            .getResultList();
    }

    // OJO: tu método se llama listarPorArtisa, pero lo dejo igual por compatibilidad
    public List<Obra> listarPorArtisa(Long artistaId) {
        return em.createQuery("""
                SELECT o
                FROM Obra o
                WHERE o.artista.id = :artistaId
                ORDER BY o.titulo
                """, Obra.class)
            .setParameter("artistaId", artistaId)
            .getResultList();
    }

    // ===== Métodos extra "examen" =====

    public List<Obra> buscarPorTitulo(String texto) {
        return em.createQuery("""
                SELECT o
                FROM Obra o
                WHERE LOWER(o.titulo) LIKE CONCAT('%', LOWER(:texto), '%')
                ORDER BY o.titulo
                """, Obra.class)
            .setParameter("texto", texto)
            .getResultList();
    }

    // IMPORTANTE: aquí usamos o.año (con ñ) porque así se llama tu atributo
    public List<Obra> obrasEntreAnios(Integer desde, Integer hasta) {
        return em.createQuery("""
                SELECT o
                FROM Obra o
                WHERE o.año BETWEEN :desde AND :hasta
                ORDER BY o.año, o.titulo
                """, Obra.class)
            .setParameter("desde", desde)
            .setParameter("hasta", hasta)
            .getResultList();
    }

    public long contarPorEstado(String estado) {
        return em.createQuery("""
                SELECT COUNT(o)
                FROM Obra o
                WHERE o.estadoConservacion = :estado
                """, Long.class)
            .setParameter("estado", estado)
            .getSingleResult();
    }
}