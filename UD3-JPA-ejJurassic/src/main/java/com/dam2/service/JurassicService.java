package com.dam2.service;

import java.util.List;
import java.util.Optional;

import com.dam2.dao.impl.DinosaurioDAO;
import com.dam2.dao.impl.IncidenteDAO;
import com.dam2.dao.impl.SectorDAO;
import com.dam2.model.Dinosaurio;
import com.dam2.model.Incidente;
import com.dam2.model.Sector;
import com.dam2.persistence.JpaUtil;

import jakarta.persistence.EntityManager;

public class JurassicService {
	
	public List<Object[]> contarDinosauriosPorEspecie(Integer minCantidad) {
		EntityManager em = JpaUtil.em();
		DinosaurioDAO dao = new DinosaurioDAO(em);
		
		// 1. Ejecutamos la consulta y guardamos la lista de resultados
		List<Object[]> resultados = dao.contarDinosauriosPorEspecie(minCantidad);
		
		// 2. Cerramos la conexión
		em.close(); 
		
		// 3. Devolvemos la lista al menú principal
		return resultados;
	}
	public List<Dinosaurio> buscarDinosauriosPorEncimaPesoMedio() {
		EntityManager em = JpaUtil.em();
		DinosaurioDAO dao = new DinosaurioDAO(em);
		
		// 1. Ejecutamos la consulta y guardamos el resultado
		List<Dinosaurio> resultado = dao.buscarDinosauriosPorEncimaPesoMedio(); 
		
		// 2. Ahora sí, cerramos el EntityManager
		em.close(); 
		
		// 3. Devolvemos el resultado
		return resultado; 
	}
	
	public List<Incidente> buscaIncidentesPorGravedadYSector(String nivelPeligro, String nombreSector) {
		EntityManager em = JpaUtil.em();
		IncidenteDAO dao = new IncidenteDAO(em);
		
		List<Incidente> resultado = dao.buscaIncidentesPorGravedadYSector(nivelPeligro, nombreSector);
		
		em.close();
		return resultado;
	}
	
	public List<Sector> buscarSectoresOperativosSinDinosaurios() {
		EntityManager em = JpaUtil.em();
		SectorDAO dao = new SectorDAO(em);	
		
		List<Sector> resultado = dao.buscarSectoresOperativosSinDinosaurios();
		
		em.close();
		return resultado;
	}
	
	public void actualizarNombreDinosaurio(Integer id, String nuevoNombre) {
		EntityManager em = JpaUtil.em();
		
		try {
			// ¡MUY IMPORTANTE! Para modificar datos hay que iniciar transacción
			em.getTransaction().begin(); 
			
			// Cambia Integer por Long si al final cambiaste los IDs en tu modelo como comentamos
			Dinosaurio d = em.find(Dinosaurio.class, id); 
			
			if (d != null) {
				d.setNombre(nuevoNombre);
				em.merge(d);
				em.getTransaction().commit(); // Guardamos los cambios en BD
				System.out.println("Nombre actualizado correctamente");
			} else {
				System.out.println("No se encontró el dinosaurio con ID " + id);
			}
			
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback(); // Si falla, deshacemos
			}
			e.printStackTrace();
		} finally {
			em.close(); // Pase lo que pase, cerramos
		}
	}
}