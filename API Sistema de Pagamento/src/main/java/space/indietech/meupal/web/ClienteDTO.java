package space.indietech.meupal.web;

import java.util.List;

import space.indietech.meupal.dao.CartaoEntity;

public class ClienteDTO {

	private String email;

	private String nome;

	private List<CartaoDTO> cartoes;

	public List<CartaoDTO> getCartoes() {
		return cartoes;
	}

	public void setCartoes(List<CartaoDTO> cartoes) {
		this.cartoes = cartoes;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
