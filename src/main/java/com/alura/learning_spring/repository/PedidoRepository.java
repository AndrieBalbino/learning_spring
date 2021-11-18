package com.alura.learning_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alura.learning_spring.model.Pedido;
import com.alura.learning_spring.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findByStatus(StatusPedido status);

	@Query("select p from Pedido p JOIN p.user u where u.username = :username")
	List<Pedido> findAllByUsuario(@Param("username") String username);

}
