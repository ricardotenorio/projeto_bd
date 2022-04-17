package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.entity.Cliente;
import model.entity.ClienteFisico;

public class ClienteDAO {
	
	private GenericDAO<ClienteFisico> dao;
	
	public ClienteDAO(EntityManager manager){
		dao = new GenericDAO<ClienteFisico>(manager, ClienteFisico.class);
	}

	public ClienteFisico adiciona(ClienteFisico t) {
		return dao.adiciona(t);
	}

	public void remove(ClienteFisico t) {
		dao.remove(t);
	}

	public ClienteFisico atualiza(ClienteFisico t) {
		return dao.atualiza(t);
	}

	public List<ClienteFisico> listaTodos() {
		return dao.listaTodos();
	}

	public ClienteFisico buscaPorId(Long id) {
		return dao.buscaPorId(id);
	}

	public EntityManager getEntityManager() {
		return this.dao.getEntityManager();
	}

}

