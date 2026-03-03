package com.dam2.dao.impl;

import java.util.List;

import com.dam2.model.Encargo;
// import com.dam2.model.Nave; (Ya no lo necesitas aquí)

import jakarta.persistence.EntityManager;

public class EncargoDAO extends ImplDAO<Encargo, Integer>{

	public EncargoDAO(EntityManager em)  {
		super(Encargo.class, em);
	}
	
	public Double obtnerIngresosTotalesPorNave(Integer id) {
		double ingresosTotales = 0;
		
		// CAMBIOS APLICADOS AQUÍ: Alias 'e', parámetro ':idNave', filtro de estado y Encargo.class
		List<Encargo> encargos = em.createQuery(
				"SELECT e FROM Encargo e WHERE e.nave.id = :idNave AND e.estado = 'ENTREGADO'", 
				Encargo.class)
				.setParameter("idNave", id)
				.getResultList();
		
		for (Encargo encargo : encargos) {
			ingresosTotales += encargo.getRecompensa();
		}
		
		return ingresosTotales;
	}
	
	// CAMBIO APLICADO: El retorno ahora es List<Object[]>
	public List<String> rutasLucrativas(Integer limite) {
		
		// Le pedimos SOLO el nombre del planeta.
		// JPA agrupará y sumará por detrás para ordenarlos, pero no nos devolverá el número.
		String jpql = "SELECT e.planetaDestino " +
		              "FROM Encargo e " +
		              "WHERE e.estado = 'ENTREGADO' " +
		              "GROUP BY e.planetaDestino " +
		              "ORDER BY SUM(e.recompensa) DESC";
		
		// Ahora el tipo de retorno es directo y sencillo: String.class
		return em.createQuery(jpql, String.class)
		         .setMaxResults(limite) 
		         .getResultList();
	}

}