package com.dam2.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Cliente {

 @Id 
 @GeneratedValue
 private Long id;

 private String nombre;

 //orphanRemoval: si quitamos un pedido de la colección
 //de pedidos que lo borre en BD
 //no confundir con CascadeType.REMOVE, no tiene nada que ver
 @OneToMany(mappedBy="cliente", fetch=FetchType.LAZY,
   cascade=CascadeType.ALL, orphanRemoval=true)
 private List<Pedido> pedidos = new ArrayList<>();

 public Cliente(){}

 public Cliente(String nombre){
  this.nombre = nombre;
 }

 public Long getId(){ return id; }
 public String getNombre(){ return nombre; }
 public List<Pedido> getPedidos(){ return pedidos; }

 public void addPedido(Pedido p){
  pedidos.add(p);
  p.setCliente(this);
 }

@Override
public String toString() {
	return "Cliente [id=" + id + ", nombre=" + nombre + "]";
}
 
 
}
