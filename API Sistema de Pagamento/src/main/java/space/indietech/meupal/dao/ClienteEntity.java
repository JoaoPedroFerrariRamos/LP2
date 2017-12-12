package space.indietech.meupal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class ClienteEntity {

	@Id
	@Column(name = "email")
	private String email;

	@Column(name = "nome")
	private String nome;
	
	@OneToMany
	private List<CartaoEntity> cartoes = new ArrayList<CartaoEntity>();

	public List<CartaoEntity> getCartoes() {
		return cartoes;
	}

	public void setCartoes(List<CartaoEntity> cartoes) {
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
