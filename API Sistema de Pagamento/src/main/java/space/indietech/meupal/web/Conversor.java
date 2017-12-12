package space.indietech.meupal.web;

import java.util.ArrayList;
import java.util.List;

import space.indietech.meupal.business.CartaoBo;
import space.indietech.meupal.business.ClienteBo;
import space.indietech.meupal.dao.CartaoEntity;
import space.indietech.meupal.dao.ClienteEntity;

public class Conversor {

	public static ClienteBo converteDTOtoBo(ClienteDTO cliente) {
		ClienteBo bo = new ClienteBo();
		bo.setNome(cliente.getNome());
		bo.setEmail(cliente.getEmail());
		return bo;
	}

	public static ClienteEntity converterBOtoEntity(ClienteBo bo) {
		ClienteEntity ce = new ClienteEntity();
		ce.setNome(bo.getNome());
		ce.setEmail(bo.getEmail());
		ce.setCartoes(converterListaCartaoBOtoEntity(bo.getCartoes()));
		return ce;
	}

	private static List<CartaoEntity> converterListaCartaoBOtoEntity(List<CartaoBo> list) {
		List<CartaoEntity> cEnti = new ArrayList<>();
		for (CartaoBo cartaoBo : list) {
			CartaoEntity carEnti = new CartaoEntity();
			carEnti.setNomeCartao(cartaoBo.getNomeCartao());
			carEnti.setNumCartao(cartaoBo.getNumCartao());
			carEnti.setSaldo(cartaoBo.getSaldo());
			cEnti.add(carEnti);
		}
		return cEnti;
	}

	public static ClienteBo converterEntityToBO(ClienteEntity cliEntity) {
		ClienteBo bo = new ClienteBo();
		bo.setNome(cliEntity.getNome());
		bo.setEmail(cliEntity.getEmail());
		bo.setCartoes(converterListaCartoesEntityToBO(cliEntity.getCartoes()));
		return bo;
	}

	public static ClienteDTO converterBOtoDTO(ClienteBo bo) {
		ClienteDTO cDto = new ClienteDTO();
		cDto.setNome(bo.getNome());
		cDto.setEmail(bo.getEmail());
		cDto.setCartoes(converterListaCartaoBOtoDTO(bo.getCartoes()));
		return cDto;
	}

	public static List<CartaoDTO> converterListaCartaoBOtoDTO(List<CartaoBo> cartoes) {
		List<CartaoDTO> DTOs = new ArrayList<>();
		for (CartaoBo cartaoBo : cartoes) {
			CartaoDTO dto = new CartaoDTO();
			dto.setNomeCartao(cartaoBo.getNomeCartao());
			dto.setNumCartao(cartaoBo.getNumCartao());
			dto.setSaldo(cartaoBo.getSaldo());
			DTOs.add(dto);
		}
		return DTOs;
	}

	public static List<CartaoBo> converterListaCartoesEntityToBO(List<CartaoEntity> cartoes) {
		List<CartaoBo> bos = new ArrayList<>();
		for (CartaoEntity cartaoEntity : cartoes) {
			CartaoBo bo = new CartaoBo();
			bo.setNomeCartao(cartaoEntity.getNomeCartao());
			bo.setNumCartao(cartaoEntity.getNumCartao());
			bo.setSaldo(cartaoEntity.getSaldo());
			bos.add(bo);
		}
		return bos;
	}

	public static List<ClienteDTO> converterListaBOtoDTO(List<ClienteBo> clientes) {
		List<ClienteDTO> dtos = new ArrayList<>();
		for (ClienteBo clienteBo : clientes) {
			ClienteDTO dto = new ClienteDTO();
			dto.setNome(clienteBo.getNome());
			dto.setEmail(clienteBo.getEmail());
			dto.setCartoes(converterListaCartaoBOtoDTO(clienteBo.getCartoes()));
			dtos.add(dto);
		}
		return dtos;
	}

	public static List<ClienteBo> converterListaEntityToBO(List<ClienteEntity> clientes) {
		List<ClienteBo> bos = new ArrayList<>();
		for (ClienteEntity clienteEntity : clientes) {
			ClienteBo bo = new ClienteBo();
			bo.setNome(clienteEntity.getNome());
			bo.setEmail(clienteEntity.getEmail());
			bo.setCartoes(converterListaCartoesEntityToBO(clienteEntity.getCartoes()));
			bos.add(bo);
		}
		return bos;
	}

	public static CartaoBo converteDTOtoBo(CartaoDTO cartao) {
		CartaoBo bo = new CartaoBo();
		bo.setNomeCartao(cartao.getNomeCartao());
		bo.setNumCartao(cartao.getNumCartao());
		bo.setSaldo(cartao.getSaldo());

		return bo;
	}

	public static CartaoEntity converterBOtoEntity(CartaoBo cartaoBo) {
		CartaoEntity cEnti = new CartaoEntity();
		cEnti.setNomeCartao(cartaoBo.getNomeCartao());
		cEnti.setNumCartao(cartaoBo.getNumCartao());
		cEnti.setSaldo(cartaoBo.getSaldo());

		return cEnti;
	}

	public static CartaoBo converterEntityToBO(CartaoEntity cEntity) {
		CartaoBo bo = new CartaoBo();
		bo.setNomeCartao(cEntity.getNomeCartao());
		bo.setNumCartao(cEntity.getNumCartao());
		bo.setSaldo(cEntity.getSaldo());

		return bo;
	}

	public static CartaoDTO converterBOtoDTO(CartaoBo bo) {
		CartaoDTO dto = new CartaoDTO();
		dto.setNomeCartao(bo.getNomeCartao());
		dto.setNumCartao(bo.getNumCartao());
		dto.setSaldo(bo.getSaldo());
		return dto;
	}

}
