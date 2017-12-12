package space.indietech.meupal.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import space.indietech.meupal.business.CartaoBo;
import space.indietech.meupal.business.ClienteBo;
import space.indietech.meupal.business.MeupalService;

@RestController
@RequestMapping(value = "/meupal")
public class MeupalRest {

	private MeupalService service;

	@Autowired
	public MeupalRest(MeupalService service) {
		super();
		this.service = service;
	}

	@PostMapping("/cliente")
	public ResponseEntity<ClienteDTO> addCliente(@RequestBody ClienteDTO cliente) {
		ClienteBo bo = Conversor.converteDTOtoBo(cliente);
		bo = service.addCliente(bo);
		cliente = Conversor.converterBOtoDTO(bo);
		return ResponseEntity.ok(cliente);
	}

	@GetMapping("/cliente")
	public ResponseEntity<List<ClienteDTO>> pegaClientes() {
		return ResponseEntity.ok(Conversor.converterListaBOtoDTO(service.getClientes()));
	}

	@PostMapping("/cartao/{emailCliente}")
	public ResponseEntity<CartaoDTO> addCartao(@RequestBody CartaoDTO cartao,
			@PathVariable("emailCliente") String emailCliente) {
		try {
			CartaoBo bo = service.addCartao(Conversor.converteDTOtoBo(cartao), emailCliente);
			cartao = Conversor.converterBOtoDTO(bo);
			return ResponseEntity.ok(cartao);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/cliente/{email}")
	public ResponseEntity<ClienteDTO> getClientePorEmail(@PathVariable("email") String email) {
		try {
			ClienteDTO clibo = Conversor.converterBOtoDTO(service.getClientePorEmail(email));
			return ResponseEntity.ok(clibo);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();

		}
	}

}
