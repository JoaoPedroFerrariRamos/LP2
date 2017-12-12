package space.indietech.meupal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AllDao {

	private EntityManager em;

	@Autowired
	public AllDao(EntityManager em) {
		this.em = em;
	}

	@Transactional
	public void cartao(CartaoEntity ce) {
		em.merge(ce);
	}

	public List<CartaoEntity> getListaCartao() {
		List<CartaoEntity> cartoes = em.createQuery("from Cartao").getResultList();
		return cartoes;
	}

	@Transactional
	public void delete(int numero) {
		CartaoEntity cartoes = new CartaoEntity();
		cartoes.setNumCartao(numero);
		cartoes = em.find(CartaoEntity.class, numero);
		if (cartoes != null) {
			em.remove(cartoes);
		}
	}

	@Transactional
	public ClienteEntity addCliente(ClienteEntity cliEntity) {
		return em.merge(cliEntity);
	}

	public List<ClienteEntity> getClientes() {

		return em.createQuery("from ClienteEntity").getResultList();
	}
	
	@Transactional
	public CartaoEntity addCartao(CartaoEntity cEnti) {
		return em.merge(cEnti);
	}

	public ClienteEntity getCliente(String emailCliente) {
		ClienteEntity cliEntity = em.find(ClienteEntity.class, emailCliente);
		if (cliEntity != null) {
			return cliEntity;
		}
		throw new RuntimeException("Cliente não achado");
	}
	
	@Transactional
	public void update(ClienteEntity cliEntity) {
		em.merge(cliEntity);
	}
	
	@Transactional
	public void update(CartaoEntity cartaoEntity) {
		em.merge(cartaoEntity);
	}

}
