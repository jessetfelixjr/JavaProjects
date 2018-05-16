package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import entidades.Contato;

public class ContatosDAOImpl implements ContatosDAO {

	private List<Contato> contatos;

	public ContatosDAOImpl() {
		contatos = new ArrayList<Contato>();
		contatos.add(new Contato(1, "João", "Rua Abrolhos", "(13) 5461-7452"));
		contatos.add(new Contato(2, "Jessé", "Rua Brasil", "(13) 2285-1564"));
		contatos.add(new Contato(3, "Laís", "Rua Carvalho de Mendonça", "(13) 1255-4854"));
	}

	@Override
	public List<Contato> buscarListaContatos() {
		return contatos;
	}

	@Override
	public void adicionarContato(Contato contato) {
		if (contato.getId() == 0) {
			contato.setId(contatos.size() + 1);
			contatos.add(contato);
		} else {
			contatos.set((int) (contato.getId() - 1), contato);
		}

	}

	@Override
	public void removerContato(long id) {
		contatos.remove(contatos.get((int) (id - 1)));
	}

	public Contato buscarContatoPorId(long id) {
		return contatos.get((int) (id - 1));
	}

	public List<Contato> buscarContatoPorNome(String paramBusca) {
		List<Contato> result = new ArrayList<Contato>();
		for (Contato c : contatos) {
			if (StringUtils.containsIgnoreCase(c.getNome(), paramBusca)) {
				result.add(c);
			}
		}

		return result;

	}

}
