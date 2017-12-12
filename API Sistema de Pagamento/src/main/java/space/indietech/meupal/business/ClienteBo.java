package space.indietech.meupal.business;

import java.util.List;

import space.indietech.meupal.dao.CartaoEntity;

public class ClienteBo {

	private String email;

	private String nome;

	private List<CartaoBo> cartoes;

	public List<CartaoBo> getCartoes() {
		return cartoes;
	}

	public void setCartoes(List<CartaoBo> cartoes) {
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
