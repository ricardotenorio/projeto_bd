package service;

import dao.ClienteDAO;
import dao.EMFactory;
import model.entity.Cliente;

import java.util.List;

public class ClienteService {

    private ClienteDAO dao = new ClienteDAO(EMFactory.getInstance().getEntityManager());

    public Cliente cadastrarCliente(Cliente cliente){
        return dao.adiciona(cliente);
    }

    public Cliente atualizaCliente(Cliente cliente){
        return dao.atualiza(cliente);
    }

    public void removeCliente(Cliente cliente){
        dao.remove(cliente);
    }

    public Cliente buscaID(long clienteID){
        return dao.buscaPorId(clienteID);
    }

    public List<Cliente> listaCliente(Cliente cliente){
        return dao.listaTodos();
    }
}

