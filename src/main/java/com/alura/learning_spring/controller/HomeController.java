package com.alura.learning_spring.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.alura.learning_spring.model.Pedido;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home(Model model) {
		Pedido pedido = new Pedido();
		
		pedido.setNomeProduto("Smart Lâmpada Wi-Fi");
		pedido.setUrlImagem("https://m.media-amazon.com/images/I/71gze3HhCTL._AC_SL1500_.jpg");
		pedido.setUrlProduto("https://www.amazon.com.br/L%C3%A2mpada-Positivo-Casa-Inteligente-Compat%C3%ADvel/dp/B082FTRR76/?_encoding=UTF8&pd_rd_w=3dhjC&pf_rd_p=d797ba21-8ae9-409d-90c8-d2391dabe596&pf_rd_r=GBPY6F0WGJQ1YF9389GP&pd_rd_r=2986d54d-52dc-4021-b61c-29a25d341ded&pd_rd_wg=1XuIK&ref_=pd_gw_crs_zg_bs_16191000011");
		pedido.setDescricao("Positivo Casa Inteligente, branco quente e frio");
	
		List<Pedido> pedidos = Arrays.asList(pedido);
		
		model.addAttribute("pedidos", pedidos);
		
		return "home";
	}

}
