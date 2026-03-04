package com.dam2.service;

import java.time.LocalDate;
import java.util.List;

import com.dam2.dao.impl.ArtistaDAO;
import com.dam2.dao.impl.ExposicionDAO;
import com.dam2.dao.impl.ObraDAO;
import com.dam2.model.Artista;
import com.dam2.model.Exposicion;
import com.dam2.model.Obra;
import com.dam2.persistence.JpaUtil;

import jakarta.persistence.EntityManager;

public class MuseoService {

    // ===== OBRA =====
    public List<Obra> listarPorEstado(String estado) {
        EntityManager em = JpaUtil.em();
        try {
            return new ObraDAO(em).listarPorEstado(estado);
        } finally {
            em.close();
        }
    }

    public List<Obra> listarPorArtisa(Long artistaId) {
        EntityManager em = JpaUtil.em();
        try {
            return new ObraDAO(em).listarPorArtisa(artistaId);
        } finally {
            em.close();
        }
    }

    // ===== EXPOSICION =====
    public void añadirObraAExposicion(Long exposicionId,
                                     Long obraId,
                                     String posicion,
                                     LocalDate fechaMontaje,
                                     Double valorSeguro) {
        EntityManager em = JpaUtil.em();
        try {
            ExposicionDAO dao = new ExposicionDAO(em);
            em.getTransaction().begin();
            dao.añadirObraAExposicion(exposicionId, obraId, posicion, fechaMontaje, valorSeguro);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public List<Exposicion> activasEnFecha(LocalDate fecha) {
        EntityManager em = JpaUtil.em();
        try {
            return new ExposicionDAO(em).activasEnFecha(fecha);
        } finally {
            em.close();
        }
    }

    // ===== ARTISTA =====
    public void crear(Artista a) {
        EntityManager em = JpaUtil.em();
        try {
            ArtistaDAO dao = new ArtistaDAO(em);
            em.getTransaction().begin();
            dao.crear(a);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public Artista buscarPorId(Long id) {
        EntityManager em = JpaUtil.em();
        try {
            return new ArtistaDAO(em).buscarPorId(id);
        } finally {
            em.close();
        }
    }

    public List<Artista> listarTodosArtistas() {
        EntityManager em = JpaUtil.em();
        try {
            return new ArtistaDAO(em).listarTodos();
        } finally {
            em.close();
        }
    }

    public Artista actualizarNombre(Long id, String nuevoNombre) {
        EntityManager em = JpaUtil.em();
        try {
            ArtistaDAO dao = new ArtistaDAO(em);
            em.getTransaction().begin();
            Artista res = dao.actualizarNombre(id, nuevoNombre);
            em.getTransaction().commit();
            return res;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void borrar(Long id) {
        EntityManager em = JpaUtil.em();
        try {
            ArtistaDAO dao = new ArtistaDAO(em);
            em.getTransaction().begin();
            dao.borrar(id);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}