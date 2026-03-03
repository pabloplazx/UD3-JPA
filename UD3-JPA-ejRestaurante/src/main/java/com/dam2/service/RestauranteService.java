package com.dam2.service;

import java.util.List;

import com.dam2.daoImpl.ImplDao;
import com.dam2.model.Categoria;
import com.dam2.model.Plato;
import com.dam2.persistence.JpaUtil;

import jakarta.persistence.EntityManager;

public class RestauranteService {
	
	public void crearNuevaSeccion(String nombreCat, String descripcion, List<Plato> nuevosPlatos) {
		
		EntityManager em = JpaUtil.em();
		ImplDao<Categoria, Integer> dao = new ImplDao<>(Categoria.class, em);
		
		em.getTransaction().begin(); 
		
		Categoria categoria = new Categoria();
		
		categoria.setNombre(nombreCat);
		categoria.setDescripcion(descripcion);
		
		for (Plato plato : nuevosPlatos) {
			categoria.addPlato(plato);
		}
		
		dao.create(categoria);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public void actualizarPrecioPlato(Integer idPlato, double nuevoPrecio) {
		
		EntityManager em = JpaUtil.em();
		em.getTransaction().begin();
		
		ImplDao<Plato, Integer> dao = new ImplDao<>(Plato.class, em);
		Plato plato = (Plato) dao.get(idPlato);
		
		if (plato != null) {
			plato.setPrecio(nuevoPrecio);
		}
		
		em.getTransaction().commit();
		em.close();
	}

}
