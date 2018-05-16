package rn;

import java.util.List;

import entidades.Contato;

public interface ContatosRN {
	
	public List<Contato> buscarListaContatos();
	public void adicionarContato(Contato contato);
	public void removerContato(long id);
	public Contato buscarContatoPorId(long id); 
	public List<Contato> buscarContatoPorNome(String paramBusca);
	

}
