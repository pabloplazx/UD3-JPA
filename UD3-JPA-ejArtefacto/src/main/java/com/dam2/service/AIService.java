package com.dam2.service;

import java.time.LocalDate;
import java.util.List;

import com.dam2.dao.impl.ArtefactoDAO;
import com.dam2.dao.impl.InvestigadorArtefactoDAO;
import com.dam2.dao.impl.InvestigadorDAO;
import com.dam2.model.Artefacto;
import com.dam2.model.Investigador;
import com.dam2.model.InvestigadorArtefacto;
import com.dam2.persistence.JpaUtil;

import jakarta.persistence.EntityManager;

public class AIService {

    // ---------- CREAR INVESTIGADOR ----------
    public void crearInvestigador(String nif, String nombre, String especialidad, LocalDate fechaIngreso) {
        EntityManager em = JpaUtil.em();
        try {
            em.getTransaction().begin();

            InvestigadorDAO dao = new InvestigadorDAO(em);
            Investigador investigador = dao.crearInvestigador(nif, nombre, especialidad, fechaIngreso);

            em.persist(investigador);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            // Aquí se cierra el CONTEXTO DE PERSISTENCIA
            em.close();
        }
    }

    // ---------- CREAR ARTEFACTO ----------
    public void crearArtefacto(String codigo, String nombre, String origen, Integer nivelRiesgo) {
        EntityManager em = JpaUtil.em();
        try {
            em.getTransaction().begin();

            ArtefactoDAO dao = new ArtefactoDAO(em);
            Artefacto a = dao.crearArtefacto(codigo, nombre, origen, nivelRiesgo);

            em.persist(a);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            // Cierre del contexto de persistencia
            em.close();
        }
    }

    // ---------- LECTURAS ----------
    public List<Investigador> intestigadoresDeArtefacto(Long artefactoId) {
        EntityManager em = JpaUtil.em();
        try {
            InvestigadorDAO dao = new InvestigadorDAO(em);
            List<Investigador> res = dao.investigadoresDeArtefacto(artefactoId);
            // Fuerza materialización antes de cerrar (por seguridad)
            res.size();
            return res;
        } finally {
            // Cierre del contexto de persistencia
            em.close();
        }
    }

    public List<InvestigadorArtefacto> asignacionesPorEstado(String estado) {
        EntityManager em = JpaUtil.em();
        try {
            InvestigadorArtefactoDAO dao = new InvestigadorArtefactoDAO(em);
            List<InvestigadorArtefacto> res = dao.asignacionesPorEstado(estado);
            res.size();
            return res;
        } finally {
            em.close();
        }
    }

    public List<InvestigadorArtefacto> asignacionesConMasDeXHoras(Integer horasMinimas) {
        EntityManager em = JpaUtil.em();
        try {
            InvestigadorArtefactoDAO dao = new InvestigadorArtefactoDAO(em);
            List<InvestigadorArtefacto> res = dao.asignacionesConMasDeXHoras(horasMinimas);
            res.size();
            return res;
        } finally {
            em.close();
        }
    }

    public List<Artefacto> artefactosSinAsignaciones() {
        EntityManager em = JpaUtil.em();
        try {
            ArtefactoDAO dao = new ArtefactoDAO(em);
            List<Artefacto> res = dao.artefactosSinAsignaciones();
            res.size();
            return res;
        } finally {
            em.close();
        }
    }

    // ---------- MODIFICACIONES (con transacción + commit) ----------
    public void suspenderAsignacion(Long investigadorId, long artefactoId, String motivoEnInforme) {
        EntityManager em = JpaUtil.em();
        try {
            em.getTransaction().begin();

            InvestigadorArtefactoDAO dao = new InvestigadorArtefactoDAO(em);
            dao.suspenderAsignacion(investigadorId, artefactoId, motivoEnInforme);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void cerrarAsignacion(Long investigadorId, long artefactoId, String informeFinal) {
        EntityManager em = JpaUtil.em();
        try {
            em.getTransaction().begin();

            InvestigadorArtefactoDAO dao = new InvestigadorArtefactoDAO(em);
            dao.cerrarAsignacion(investigadorId, artefactoId, informeFinal);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void cambiarHoras(Long investigadorId, Long artefactoId, Integer nuevasHoras) {
        EntityManager em = JpaUtil.em();
        try {
            em.getTransaction().begin();

            InvestigadorArtefactoDAO dao = new InvestigadorArtefactoDAO(em);
            dao.cambiarHoras(investigadorId, artefactoId, nuevasHoras);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    // ---------- BORRADOS (con transacción + commit) ----------
    public void borrarInvestigador(Long investigadorId) {
        EntityManager em = JpaUtil.em();
        try {
            em.getTransaction().begin();

            InvestigadorDAO dao = new InvestigadorDAO(em);
            dao.borrarInvestigador(investigadorId);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void borrarArtefacto(Long artefactoId) {
        EntityManager em = JpaUtil.em();
        try {
            em.getTransaction().begin();

            Artefacto a = em.find(Artefacto.class, artefactoId);
            if (a != null) em.remove(a);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    // ---------- REPORTES ----------
    public void topInvestigadoresPorHorasActivas(Integer topN) {
        EntityManager em = JpaUtil.em();
        try {
            InvestigadorDAO dao = new InvestigadorDAO(em);
            List<Object[]> ranking = dao.topInvestigadoresPorHorasActivas(topN);

            for (Object[] row : ranking) {
                String nif = (String) row[0];
                String nombre = (String) row[1];
                Long totalHoras = (Long) row[2];
                System.out.println(nif + " - " + nombre + " -> " + totalHoras);
            }
        } finally {
            em.close();
        }
    }

    public void conteoArtefactosPorOrigenConActivos() {
        EntityManager em = JpaUtil.em();
        try {
            ArtefactoDAO dao = new ArtefactoDAO(em);
            List<Object[]> r = dao.conteoArtefactosPorOrigenConActivos();

            for (Object[] row : r) {
                System.out.println(row[0] + " -> " + row[1]);
            }
        } finally {
            em.close();
        }
    }
}