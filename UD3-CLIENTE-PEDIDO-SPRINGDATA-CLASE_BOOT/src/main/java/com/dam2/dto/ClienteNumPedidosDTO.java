package com.dam2.dto;

public class ClienteNumPedidosDTO {
	
	private Long id;
	private String nombre;
	private Long numPedidos;
	
	public ClienteNumPedidosDTO(Long id, String nombre, Long numPedidos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.numPedidos = numPedidos;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getNumPedidos() {
		return numPedidos;
	}
	public void setNumPedidos(Long numPedidos) {
		this.numPedidos = numPedidos;
	}
	
	public boolean superaPedidos(int n) {
		return numPedidos > n;
	}
	

}
