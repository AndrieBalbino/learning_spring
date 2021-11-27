package com.alura.learning_spring.api;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.learning_spring.dto.RequisicaoNovaOferta;
import com.alura.learning_spring.model.Oferta;
import com.alura.learning_spring.model.Pedido;
import com.alura.learning_spring.repository.PedidoRepository;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@PostMapping
	public ResponseEntity<Oferta> criarOferta(@Valid @RequestBody RequisicaoNovaOferta requisicao) {
		Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisicao.getPedidoId());
		
		if(!pedidoBuscado.isPresent()) {
			return null;
		}
		
		Pedido pedido = pedidoBuscado.get();
		Oferta novaOferta = requisicao.toOferta();
		novaOferta.setPedido(pedido);
		pedido.getOfertas().add(novaOferta);
		
		pedidoRepository.save(pedido);
		return ResponseEntity.ok().body(novaOferta);
	}
}
