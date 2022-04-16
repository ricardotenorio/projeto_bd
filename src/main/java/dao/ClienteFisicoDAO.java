package dao;


import model.entity.Cliente;
import model.entity.ClienteFisico;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteFisicoDAO extends ClienteDAO {

    private GenericDAO<ClienteFisico> dao;

    public ClienteFisicoDAO(EntityManager manager) {dao = new GenericDAO<ClienteFisico>(manager, ClienteFisico.class);}

    public ClienteFisico adiciona(ClienteFisico t) {
        return dao.adiciona(t);
    }

    public void remove(Cliente t) {
        dao.remove(t);
    }

    public Cliente atualiza(Cliente t) {
        return dao.atualiza(t);
    }

    public List<Cliente> listaTodos() {
        return dao.listaTodos();
    }

    public Cliente buscaPorId(Long id) {
        return dao.buscaPorId(id);
    }

    public EntityManager getEntityManager() {
        return this.dao.getEntityManager();
    }

}
