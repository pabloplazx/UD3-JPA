package com.dam2.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dam2.dto.ClienteNumPedidos;
import com.dam2.dto.ClienteNumPedidosDTO;
import com.dam2.model.Cliente;
import com.dam2.repo.ClienteRepository;

//ESTO INDICA QUE ES BEAN GESTIONADO POR SPRING
//EN CONCRETO UN BEAN DE TIPO SERVICE (MÁS BIEN INFORMATIVO)

@Service
public class ClienteService {

	//GESTIÓN BEANS DE SPRING
	//SE PODRÍA PONER @Autowired y funciona igual, pero te vuelves
	//dependiente de Spring. Si no está Spring no podrías instanciar sin
	//repositorio, mala idea....
 private final ClienteRepository clientes;

 public ClienteService(ClienteRepository clientes){
  this.clientes = clientes;
 }
 
 @Transactional
 public Cliente recuperaCliente(Long id) {
	 
	 
	 
	 return clientes.findById(id).get();
 }
 
 public List<Cliente> recuperaClientesNombre(String nombre){
	 
	 return clientes.findByNombre(nombre);
 }
 
 public List<Cliente> recuperaClientesPorConcepto(String concepto){
	 
	 return clientes.findClientesByConcepto(concepto);
 }
 

 public Cliente recuperaClienteConPedidos(Long id) {
	 return clientes.findClienteByIdWithPedidos(id);
 }
 
 public List<ClienteNumPedidos> listaClientesConNumPedidos(){
	 return clientes.getClientesNumPedidos();
 }
 
 public List<ClienteNumPedidosDTO> listaClientesConNumPedidosDTO(){
	 return clientes.getClientesNumPedidosDTO();
 }

 
}
