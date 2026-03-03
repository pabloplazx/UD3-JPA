package com.dam2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dam2.dto.ClienteNumPedidos;
import com.dam2.dto.ClienteNumPedidosDTO;
import com.dam2.model.Cliente;

//ANOTACIÓN OPCIONAL
//@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

	//MÉTODOS PROPIOS:
	List<Cliente> findByNombre(String nombre);
	
	@Query("""
			
			SELECT c
			FROM Cliente c
			JOIN c.pedidos p
			WHERE p.concepto LIKE CONCAT('%', :concepto, '%')
			""")
	List<Cliente> findClientesByConcepto(@Param("concepto") String concepto);
	
	//si no ponemos el fecth no carga los pedidos en el objeto cliente:
	@Query("""
			
			SELECT c
			FROM Cliente c
			JOIN FETCH c.pedidos p
			WHERE c.id = :id
			""")
	Cliente findClienteByIdWithPedidos(@Param("id") Long id);
	
	@Query("""
			SELECT c.id as id,c.nombre as nombre, COUNT(p) as numPedidos
			FROM Cliente c
			JOIN c.pedidos p
			GROUP BY c.id,c.nombre
			
			""")
	List<ClienteNumPedidos> getClientesNumPedidos();
	
	@Query("""
			SELECT new com.dam2.dto.ClienteNumPedidosDTO
				(c.id,
				c.nombre,
				COUNT(p) )
			FROM Cliente c
			JOIN c.pedidos p
			GROUP BY c.id,c.nombre
			
			""")
	List<ClienteNumPedidosDTO> getClientesNumPedidosDTO();
 
}
