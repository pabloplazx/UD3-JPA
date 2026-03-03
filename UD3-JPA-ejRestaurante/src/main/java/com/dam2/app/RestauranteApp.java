package com.dam2.app;

import java.util.ArrayList;
import java.util.List;

import com.dam2.daoImpl.CategoriaImplDao;
import com.dam2.daoImpl.PlatoImplDao;
import com.dam2.model.Categoria;
import com.dam2.model.Plato;
import com.dam2.persistence.JpaUtil;
import com.dam2.service.RestauranteService;

import jakarta.persistence.EntityManager;

public class RestauranteApp {
	
	public static void main(String[] args) {
		
		RestauranteService servicio = new RestauranteService();
		
		System.out.println("1. Fundar categoría");
		
		List<Plato> platos = new ArrayList<>();
		Plato plato1 = new Plato(0, "Entrecot a la parrilla", 18.5, null);
		Plato plato2 = new Plato(0, "Costillas BBQ", 15.0, null);
		
		servicio.crearNuevaSeccion("Carnes", "Diferente conjunto de carnes", platos);
		System.out.println("Categoría de carnes creada y sus 2 platos");
		
		System.out.println("2. Cambiar el precio de un plato ");
		servicio.actualizarPrecioPlato(1, 9.5);
		System.out.println("Plato actualizar");
		
		System.out.println("3. Probando JPQL: Platos por categoria");
		EntityManager em = JpaUtil.em();
		PlatoImplDao platoDao = new PlatoImplDao(em);
		
		List<Plato> platosCategoria = platoDao.getPlatosPorCategoria("Entrantes");
		for (Plato plato : platosCategoria) {
			System.out.println(plato);
		}
		
		System.out.println("4. Probando JPQL: JOING FETCH ");
		CategoriaImplDao categoriaDao = new CategoriaImplDao(em);
		
		Categoria categoriaRecuperado = categoriaDao.getCategoriaConPlatos(1);
		
		System.out.println("Categoria recuperada :	"+categoriaRecuperado.getNombre());
		System.out.println("Platos");
		for (Plato plato : categoriaRecuperado.getPlatos()) {
			System.out.println(plato);
		}
		
		em.close();
		
		JpaUtil.factory.close();
		
	}

}
