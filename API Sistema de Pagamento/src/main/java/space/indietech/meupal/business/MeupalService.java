package space.indietech.meupal.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import space.indietech.meupal.dao.AllDao;
import space.indietech.meupal.web.Conversor;

@Component
public class MeupalService {

	private AllDao dao;

	@Autowired
	public MeupalService(AllDao dao) {
		super();
		this.dao = dao;
	}

	public ClienteBo addCliente(ClienteBo bo) {
		bo.setCartoes(new ArrayList<>());
		bo = Conversor.converterEntityToBO(dao.addCliente(Conversor.converterBOtoEntity(bo)));
		return bo;
	}

	public List<ClienteBo> getClientes() {
		return Conversor.converterListaEntityToBO(dao.getClientes());
	}

	public CartaoBo addCartao(CartaoBo cartaoBo, String emailCliente) {
		cartaoBo = Conversor.converterEntityToBO(dao.addCartao(Conversor.converterBOtoEntity(cartaoBo)));
		ClienteBo bo = getClientePorEmail(emailCliente);
		bo.getCartoes().add(cartaoBo);
		updateCliente(bo);
		bo = getClientePorEmail(emailCliente);
		return cartaoBo;

	}

	public void updateCliente(ClienteBo bo) {
		dao.update(Conversor.converterBOtoEntity(bo));
	}

	public ClienteBo getClientePorEmail(String emailCliente) {
		return Conversor.converterEntityToBO(dao.getCliente(emailCliente));
	}
}
