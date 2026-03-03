package main;

import java.util.List;

import com.dam2.model.Departamento;
import com.dam2.model.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Main {

	public static void main(String[] args) {
		
		//pruebaInicial();
		
		//cambiarNombreEmpleados(1);
		
		getEmpleadosByNombre("ANA_").stream()
			.forEach(System.out::println);
	}
	
	private static void cambiarNombreEmpleados(Integer id) {
		
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("EmpDept-PU");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		Departamento d = em.find(Departamento.class, id);
		
		d.getEmpleados().stream().forEach(x -> 
				x.setNombre(x.getNombre()+"_"));
		
		em.getTransaction().commit();
		
		em.close();
		
	}
	
	private static List<Empleado> getEmpleadosByNombre(String nombre){
		
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("EmpDept-PU");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		List<Empleado> empleados; 
				
		String jpql = "SELECT e FROM Empleado e"
				+ " WHERE e.nombre = :nom";
		
		Query query = em.createQuery(jpql);
		
		query.setParameter("nom", nombre);
		
		empleados = query.getResultList();
		
		em.getTransaction().commit();
		em.close();
		
		return empleados;
		
	}
	
	private static void pruebaInicial() {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("EmpDept-PU");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		Departamento dep = new Departamento();
		dep.setNombre("CASAS");
		
		em.persist(dep);
		
		//recuperar por clave:
		Empleado emp = em.find(Empleado.class,1);
		
		
//		em.getTransaction().commit();
//		em.close();
		
		//SI em ESTUVIERA CERRADO SALDRÍA LazyInitializationException
		System.out.println("El empleado está en :"
				+emp.getDepto().getNombre());
		
		//LE CAMBIO EL DEPARTAMENTO:
		
		emp.setDepto(dep);
		
		em.getTransaction().commit();
		em.getTransaction().begin();
		
		em.refresh(dep);
		System.out.println(dep.getEmpleados().size());
		
		em.getTransaction().commit();
		em.close();
	}

}
