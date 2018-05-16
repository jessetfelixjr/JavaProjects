package rn;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ContatosDAO;
import dao.ContatosDAOImpl;
import entidades.Contato;

@Service("contatosRN")
@Transactional
public class ContatosRNImpl implements ContatosRN {

	private ContatosDAO dao = new ContatosDAOImpl();
	
	public List<Contato> buscarListaContatos(){
		return dao.buscarListaContatos();
	}

	public void adicionarContato(Contato contato) {
		dao.adicionarContato(contato);
	}

	public void removerContato(long id) {
		dao.removerContato(id);
	}
	
	public Contato buscarContatoPorId(long id) {
		return dao.buscarContatoPorId(id);
	}

	public List<Contato> buscarContatoPorNome(String paramBusca) {
		return dao.buscarContatoPorNome(paramBusca);
	}
	
}
