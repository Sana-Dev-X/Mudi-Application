package br.com.sanadev.mvc.mudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sanadev.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.sanadev.mvc.mudi.model.Pedido;
import br.com.sanadev.mvc.mudi.repository.PedidoRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPedido requisicao) {
		return "pedido/formulario";
	}

	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult rst) {

		if (requisicao.getNomeProduto().isBlank() || requisicao.getUrlImagem().isBlank() || requisicao.getUrlProduto().isBlank() || rst.hasErrors()) {
			
			requisicao.setErro("Erro");
			
			return "pedido/formulario";
		}

		Pedido pedido = requisicao.toPedido();
		pedidoRepository.save(pedido);
		return "redirect:/home";

	}

}
