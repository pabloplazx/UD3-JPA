package com.dam2.dao.impl;

import java.util.List;

import com.dam2.model.Artista;

import jakarta.persistence.EntityManager;

public class ArtistaDAO extends ImplDAO<Artista, Long> {

    public ArtistaDAO(EntityManager em) {
        super(Artista.class, em);
    }

    public void crear(Artista a) {
        if (a == null) throw new IllegalArgumentException("Artista null");
        em.persist(a);
    }

    public Artista buscarPorId(Long id) {
        if (id == null) throw new IllegalArgumentException("id null");
        return em.find(Artista.class, id);
    }

    public List<Artista> listarTodos() {
        return em.createQuery("SELECT a FROM Artista a ORDER BY a.nombre", Artista.class)
                 .getResultList();
    }

    // más “real”: recibe id y actualiza dentro
    public Artista actualizarNombre(Long artistaId, String nuevoNombre) {
        if (artistaId == null) throw new IllegalArgumentException("artistaId null");
        if (nuevoNombre == null || nuevoNombre.isBlank()) throw new IllegalArgumentException("nombre vacío");

        Artista artista = em.find(Artista.class, artistaId);
        if (artista == null) throw new IllegalStateException("No existe artista con id=" + artistaId);

        artista.setNombre(nuevoNombre);
        return artista; // queda actualizado al commit
    }

    public void borrar(Long id) {
        if (id == null) throw new IllegalArgumentException("id null");
        Artista a = em.find(Artista.class, id);
        if (a != null) em.remove(a);
    }

    // --- MÉTODOS EXTRA TÍPICOS DE EXAMEN ---

    public List<Artista> buscarPorNombre(String texto) {
        return em.createQuery("""
                SELECT a
                FROM Artista a
                WHERE LOWER(a.nombre) LIKE CONCAT('%', LOWER(:texto), '%')
                ORDER BY a.nombre
                """, Artista.class)
            .setParameter("texto", texto)
            .getResultList();
    }

    public long contarArtistas() {
        return em.createQuery("SELECT COUNT(a) FROM Artista a", Long.class)
                 .getSingleResult();
    }
}