package dao;

import java.util.List;

import entidades.Contato;

public interface ContatosDAO {
	
	List<Contato> buscarListaContatos();
	void adicionarContato(Contato contato);
	void removerContato(long id);
	Contato buscarContatoPorId(long id);
	List<Contato> buscarContatoPorNome(String paramBusca);
}
