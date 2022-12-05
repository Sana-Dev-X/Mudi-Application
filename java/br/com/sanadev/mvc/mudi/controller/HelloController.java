package br.com.sanadev.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("/hello")
	public String hello(Model request) {
		request.addAttribute("nome", "Mundo");
		
		return "hello";
	}
	
	
}
