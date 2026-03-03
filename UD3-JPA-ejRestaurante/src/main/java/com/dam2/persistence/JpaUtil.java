package com.dam2.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
	
	// 1. Creamos la Factory PESADA una sola vez (static)
	public static final EntityManagerFactory factory = 
			Persistence.createEntityManagerFactory("Esports-PU");
	
	// 2. Método rápido para pedir EntityManagers LIGEROS
	public static EntityManager em() {
		return factory.createEntityManager();
	}
}