package com.dam2.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
	
	public static EntityManagerFactory factory = Persistence.createEntityManagerFactory("damPU");
	public static EntityManager em() {
		
		return factory.createEntityManager();
	}

}
