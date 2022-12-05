package br.com.sanadev.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sanadev.mvc.mudi.model.Pedido;
import br.com.sanadev.mvc.mudi.model.StatusPedido;
import br.com.sanadev.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	
	@Autowired
	private PedidoRepository repository;
	
	@GetMapping
	public String home(Model model) {
		
		model.addAttribute("listaPedidos",repository.findAll());
		return "home";
		
	}
	
	@GetMapping("/{status}")
	public String porStatus(@PathVariable("status") String status, Model model) {
		
		List<Pedido> listaPedidos = repository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		
		model.addAttribute( "listaPedidos",listaPedidos);
		model.addAttribute("status",status);
		return "home";
		
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
}
