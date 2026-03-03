package com.dam2.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.dam2.dao.impl.ActorDAO;
import com.dam2.dao.impl.ContratoDAO;
import com.dam2.dao.impl.EstudioDAO;
import com.dam2.dao.impl.ProyectoDAO;
import com.dam2.model.ActorDoblaje;
import com.dam2.model.Contrato;
import com.dam2.model.Estudio;
import com.dam2.model.Proyecto;
import com.dam2.persistence.JpaUtil;

import jakarta.persistence.EntityManager;

public class DoblajeService {

	public List<Proyecto> buscarProyectosIdiomaOriginal(String idiomaOriginal) {
		EntityManager em = JpaUtil.em();
		ProyectoDAO dao = 
				new ProyectoDAO(em);
		return dao.buscarProyectosIdiomaOriginal(idiomaOriginal);
	}
	
	public List<Proyecto> buscarProyectoActorConcreto(Integer idAutor) {
		EntityManager em = JpaUtil.em();
		ProyectoDAO dao = 
				new ProyectoDAO(em);
		return dao.buscarProyectoActorConcreto(idAutor);
	}
	
	public List<Proyecto> buscarProyectosMayorQueEstudioDeActorEspecifico(Integer idActor) {
		EntityManager em = JpaUtil.em();
		ProyectoDAO dao = 
				new ProyectoDAO(em);
		return dao.buscarProyectosMayorQueEstudioDeActorEspecifico(idActor);
	}
	
	public Optional<Double> calcularPresupustoTotalProyectosAutor(Integer idAutor) {
		EntityManager em = JpaUtil.em();
		ProyectoDAO dao = 
				new ProyectoDAO(em);
		return Optional.ofNullable(dao.calcularPresupustoTotalProyectosAutor(idAutor));
	}
	
	public List<Proyecto> obtenerProyectosSinContrato() {
		EntityManager em = JpaUtil.em();
		ProyectoDAO dao = 
				new ProyectoDAO(em);
		return dao.obtenerProyectoSinContrato();
	}
	
	public List<Estudio> estudiosConMayorPresupuestoQue(Integer presupuesto) {
		EntityManager em = JpaUtil.em();
		EstudioDAO dao =
				new EstudioDAO(em);
		return dao.estudiosConMayorPresupuestoQue(presupuesto);
	}
	
	public List<Estudio> estudiosOrdenadorPresupuestoDescendente() {
		EntityManager em = JpaUtil.em();
		EstudioDAO dao =
				new EstudioDAO(em);
		return dao.estudiosOrdenadorPresupuestoDescendente();
	}
	
	public Optional<Double> calcularPresupuestoMedioEstudios(){
		EntityManager em = JpaUtil.em();
		EstudioDAO dao =
				new EstudioDAO(em);
		
		return Optional.ofNullable(dao.calcularPresupuestoMedioEstudios());
	}
	
	public List<Contrato> obtenerContratosActivosFechaDada(LocalDate fecha) {
		EntityManager em = JpaUtil.em();
		ContratoDAO dao =
				new ContratoDAO(em);
		return dao.obtenerContratosActivosFechaDada(fecha);
		
	}
	
	public List<Contrato> buscarContratosLargaDuracion(Integer diasMinimos) {
		EntityManager em = JpaUtil.em();
		ContratoDAO dao =
				new ContratoDAO(em);
		return dao.buscarContratosLargaDuracion(diasMinimos);
	}
	
	public Optional<ActorDoblaje> buscarActorNombre(String nombre) {
		EntityManager em = JpaUtil.em();
		ActorDAO dao =
				new ActorDAO(em);
		return Optional.ofNullable(dao.buscarActorNombre(nombre));
	}
	
	public List<ActorDoblaje> buscarActoresEstudio(Integer idEstudio) {
		EntityManager em = JpaUtil.em();
		ActorDAO dao =
				new ActorDAO(em);
		return dao.buscarActoresEstudio(idEstudio);
	}
	public List<ActorDoblaje> buscarActoresSalarioMayor(Integer salario) {
		EntityManager em = JpaUtil.em();
		ActorDAO dao =
				new ActorDAO(em);
		return dao.buscarActoresSalarioMayor(salario);
	}
	
	public Optional<Integer> numeroActoresPorEstudio(Integer idEstudio)	{
		EntityManager em = JpaUtil.em();
		ActorDAO dao =
				new ActorDAO(em);
		return Optional.ofNullable(dao.numeroActoresPorEstudio(idEstudio));
		
	}
	
	public Optional<ActorDoblaje> obtenerActorMejorPagado() {
		EntityManager em = JpaUtil.em();
		ActorDAO dao =
				new ActorDAO(em);
		return Optional.ofNullable(dao.obtenerActorMejorPagado());
	}
}
