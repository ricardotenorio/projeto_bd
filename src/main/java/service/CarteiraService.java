package service;

import dao.CarteiraDAO;
import dao.EMFactory;
import model.entity.Carteira;
import model.entity.Cliente;

import java.util.List;

public class CarteiraService {

  private CarteiraDAO dao = new CarteiraDAO(EMFactory.getInstance().getEntityManager());

  public Carteira cadastrarCarteira(Cliente cliente){
    if (cliente.getCarteira() != null) {
      throw new IllegalArgumentException("cliente já possui uma carteira");
    }

    Carteira carteira = new Carteira();
    carteira.setCliente(cliente);

    return dao.adiciona(carteira);
  }

  public Carteira atualizaCarteira(Carteira carteira){
    return dao.atualiza(carteira);
  }

  public void removeCarteira(Carteira carteira) {
    dao.remove(carteira);
  }

  public Carteira buscarPorIdCliente(Long id) {
    return dao.buscaPorIdCliente(id);
  }

  public List<Carteira> listaCarteiras(){
    return dao.listaTodos();
  }

}
