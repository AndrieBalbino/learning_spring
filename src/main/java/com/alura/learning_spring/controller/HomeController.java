package com.alura.learning_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alura.learning_spring.model.Pedido;
import com.alura.learning_spring.model.StatusPedido;
import com.alura.learning_spring.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public String home(Model model) {	
		Sort sort = Sort.by("dataEntrega").descending();
		PageRequest page = PageRequest.of(0, 10, sort);
		
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE, page);
		model.addAttribute("pedidos", pedidos);
		return "home";
	}
	
}
