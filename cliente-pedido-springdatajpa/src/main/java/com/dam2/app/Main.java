package com.dam2.app;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dam2.app.config.AppConfig;
import com.dam2.service.ClienteService;

public class Main {

 public static void main(String[] args){

   ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
   ClienteService service = ctx.getBean(ClienteService.class);
   
   //Cliente c = service.recuperaCliente(1L);
   
   //System.out.println("Número pedidos: "+c.getPedidos());
   
//   service.recuperaClientesNombre("Cliente 1").stream()
//   	.forEach(System.out::println);
//   
//   service.recuperaClientesPorConcepto("Pedido A 1").stream()
//   	.forEach(System.out::println);
   
//   Cliente c = service.recuperaClienteConPedidos(1L);
//   System.out.println("Num pedidos " + c.getPedidos().size());
//   
   
//   	service.listaClientesConNumPedidos()
//   		.forEach(x-> System.out.println(x.getNombre()+" "+x.getNumPedidos()));
//
//  
   Scanner scan = new Scanner(System.in);
   System.out.println("Dame número:");
   int n = scan.nextInt();
   service.listaClientesConNumPedidosDTO().stream()
   	.filter(x -> x.superaPedidos(n))
   	.forEach(x->System.out.println(x.getNombre()));
 }
}
