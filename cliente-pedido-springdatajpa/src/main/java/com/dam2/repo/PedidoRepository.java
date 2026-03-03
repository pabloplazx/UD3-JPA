package com.dam2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dam2.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
