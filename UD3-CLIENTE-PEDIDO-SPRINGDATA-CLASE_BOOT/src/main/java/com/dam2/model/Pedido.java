package com.dam2.model;

import jakarta.persistence.*;

@Entity
public class Pedido {

 @Id @GeneratedValue
 private Long id;

 private String concepto;

 @ManyToOne(fetch=FetchType.LAZY)
 @JoinColumn(name = "cliente_id")
 private Cliente cliente;

 //Esto es para no poner public, ya que la idea es
 //que solo lo use Hibernate
 //tiene que tener acceso desde el paquete, luego
 //se podría no poner nada, pero protected expresa intención
 //(según ChatGPT)
 Pedido(){}

 public Pedido(String concepto){
  this.concepto = concepto;
 }

 public Long getId(){ return id; }
 public String getConcepto(){ return concepto; }

 public Cliente getCliente(){ return cliente; }
 public void setCliente(Cliente c){ this.cliente = c; }
}
