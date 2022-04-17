package service;

import dao.ClienteDAO;
import dao.EMFactory;
import model.entity.Cliente;
import model.entity.ClienteFisico;

import java.util.List;

public class ClienteService {

    private ClienteDAO dao = new ClienteDAO(EMFactory.getInstance().getEntityManager());

    public ClienteFisico cadastrarCliente(ClienteFisico cliente){
        return dao.adiciona(cliente);
    }

    public ClienteFisico atualizaCliente(ClienteFisico cliente){
        return dao.atualiza(cliente);
    }

    public void removeCliente(ClienteFisico cliente){
        dao.remove(cliente);
    }

    public ClienteFisico buscaID(long clienteID){
        return dao.buscaPorId(clienteID);
    }

    public List<ClienteFisico> listaCliente(ClienteFisico cliente){
        return dao.listaTodos();
    }
}

