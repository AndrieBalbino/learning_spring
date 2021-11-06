package com.alura.learning_spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alura.learning_spring.dto.RequisicaoNovoPedido;
import com.alura.learning_spring.model.Pedido;
import com.alura.learning_spring.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPedido requisicaoNovoPedido) {
		return "pedido/form_pedido";
	}

	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPedido requisicaoNovoPedido, BindingResult result) {
		if(result.hasErrors())
			return "pedido/form_pedido";
		
		Pedido pedido = requisicaoNovoPedido.toPedido();
		pedidoRepository.save(pedido);
		
		return "pedido/form_pedido";
	}
}
