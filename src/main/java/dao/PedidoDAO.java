package dao;

import model.entity.Carteira;
import model.entity.Pedido;

import javax.persistence.EntityManager;
import java.util.List;

public class PedidoDAO {

  private GenericDAO<Pedido> dao;

  public PedidoDAO(EntityManager manager){
    dao = new GenericDAO<Pedido>(manager, Pedido.class);
  }

  public Pedido adiciona(Pedido t) {
    EntityManager entity = getEntityManager();

    dao.beginTransaction();

    entity.persist(t);

    Carteira carteira = t.getCliente().getCarteira();
    double saldoCarteira = carteira.getSaldo();

    carteira.setSaldo(saldoCarteira - t.getValorTotal());

    int calculaPontos = (int)(t.getValorTotal() / 10);

    carteira.setPontos(carteira.getPontos() + calculaPontos);

    entity.merge(carteira);

    dao.commitTransaction();

    return dao.adiciona(t);
  }


  public void remove(Pedido t) {
    dao.remove(t);
  }

  public Pedido atualiza(Pedido t) {
    return dao.atualiza(t);
  }

  public List<Pedido> listaTodos() {
    return dao.listaTodos();
  }

  public Pedido buscaPorId(Long id) {
    return dao.buscaPorId(id);
  }

  public EntityManager getEntityManager() {
    return this.dao.getEntityManager();
  }

}
