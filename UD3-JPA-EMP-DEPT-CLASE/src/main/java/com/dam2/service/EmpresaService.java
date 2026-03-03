package com.dam2.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.dam2.dao.GenericDAO;
import com.dam2.dao.impl.DepartamentoImplDAO;
import com.dam2.dao.impl.EmpleadoImplDAO;
import com.dam2.dao.impl.ImplDAO;
import com.dam2.model.Departamento;
import com.dam2.model.Empleado;
import com.dam2.persistence.JpaUtil;

import jakarta.persistence.EntityManager;

public class EmpresaService {
	
		
	public Optional<Departamento> recuperarDepartamentoId(Integer id) {
		
		EntityManager em = JpaUtil.em();
		GenericDAO<Departamento,Integer> dao =
				new ImplDAO<>(Departamento.class,em);
		Departamento d = dao.get(id);
		em.close();
		return Optional.ofNullable(d);
		
	}
	
	public Optional<Departamento> recuperarDepartamentoIdConEmpleados(Integer id) {
		
		EntityManager em = JpaUtil.em();
		DepartamentoImplDAO dao =
				new DepartamentoImplDAO(em);
		Departamento d = dao.getDepartamentoByIdWithEmpleados(id);
		em.close();
		return Optional.ofNullable(d);
		
	}
	
	public List<Empleado> recuperarEmpleadosDepartamento(Integer idDepto){
		EntityManager em = JpaUtil.em();
		EmpleadoImplDAO dao = new EmpleadoImplDAO(em);
		List<Empleado> emps = dao.getEmpleadosDeptoById(idDepto);
		em.close();
		return emps;
	}
	
	//cascade???
	public void crearDepartamentoConEmpleados
		(String nombreDepto, List<String> nombresEmpleados) {
		EntityManager em = JpaUtil.em();
		GenericDAO<Departamento,Integer> dao =
				new ImplDAO<>(Departamento.class,em);
		em.getTransaction().begin();
		
		Departamento dept = new Departamento();
		dept.setNombre(nombreDepto);
		//List<Empleado> emps = new LinkedList<>();
		for(int i=0;i<nombresEmpleados.size();i++) {
			Empleado e = new Empleado(nombresEmpleados.get(i));
			dept.addEmpleado(e);
		}
		//dept.setEmpleados(emps);
		
		dao.create(dept);
		
		em.getTransaction().commit();		
		em.close();
		
	}
	
	public void trasladarEmpleado
		(int empleadoId, int nuevoDeptoId) {
		
		EntityManager em = JpaUtil.em();
		em.getTransaction().begin();
		GenericDAO<Departamento,Integer> daoD =
				new ImplDAO<>(Departamento.class,em);
		GenericDAO<Empleado,Integer> daoE =
				new ImplDAO<>(Empleado.class,em);
		
		Empleado e = daoE.get(empleadoId);
		Departamento d = daoD.get(nuevoDeptoId);
		e.setDepto(d);
		em.getTransaction().commit();
		em.close();
		
		
	     
	}     

}
