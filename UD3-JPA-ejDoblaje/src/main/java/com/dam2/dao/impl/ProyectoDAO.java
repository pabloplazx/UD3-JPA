package com.dam2.dao.impl;

import java.util.List;

import com.dam2.model.Proyecto;

import jakarta.persistence.EntityManager;

public class ProyectoDAO extends ImplDAO<Proyecto, Integer> {

    public ProyectoDAO(EntityManager em) {
        super(Proyecto.class, em);
    }

    // 1️⃣ Buscar proyectos por idioma original
    public List<Proyecto> buscarProyectosIdiomaOriginal(String idiomaOriginal) {
        return em.createQuery(
                "SELECT p FROM Proyecto p WHERE p.idiomaOriginal = :idiomaOriginal",
                Proyecto.class)
                .setParameter("idiomaOriginal", idiomaOriginal)
                .getResultList();
    }

    // 2️⃣ Buscar proyectos de un actor concreto
    public List<Proyecto> buscarProyectoActorConcreto(Integer idActor) {
        return em.createQuery(
                "SELECT p FROM Proyecto p WHERE p.actor.id = :idActor",
                Proyecto.class)
                .setParameter("idActor", idActor)
                .getResultList();
    }

    // 3️⃣ Proyectos cuyo presupuesto sea mayor que el presupuesto anual del estudio del actor indicado
    public List<Proyecto> buscarProyectosMayorQueEstudioDeActorEspecifico(Integer idActor) {
        return em.createQuery(
                "SELECT p FROM Proyecto p " +
                "JOIN p.actor a " +
                "WHERE a.id = :idActor " +
                "AND p.presupuesto > a.estudio.presupuestoAnual",
                Proyecto.class)
                .setParameter("idActor", idActor)
                .getResultList();
    }

    // 4️⃣ Calcular presupuesto total de proyectos de un actor
    public Double calcularPresupustoTotalProyectosAutor(Integer idActor) {
        return em.createQuery(
                "SELECT SUM(p.presupuesto) FROM Proyecto p WHERE p.actor.id = :idActor",
                Double.class)
                .setParameter("idActor", idActor)
                .getSingleResult();
    }

    // 5️⃣ Obtener proyectos sin contrato (según tu modelo 1:N)
    public List<Proyecto> obtenerProyectoSinContrato() {
        return em.createQuery(
                "SELECT p FROM Proyecto p WHERE p.contratos IS EMPTY",
                Proyecto.class)
                .getResultList();
    }
}