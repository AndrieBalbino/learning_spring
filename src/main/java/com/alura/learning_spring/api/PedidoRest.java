package com.alura.learning_spring.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.learning_spring.model.Pedido;
import com.alura.learning_spring.model.StatusPedido;
import com.alura.learning_spring.repository.PedidoRepository;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoRest {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("aguardando")
	public List<Pedido> getPedidosAguardandoOfertas(){
		Sort sort = Sort.by("id").descending();
		PageRequest page = PageRequest.of(0, 10, sort);
		
		return pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, page);
	}
}
