package dao;

import model.entity.Carteira;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CarteiraDAO {

  private GenericDAO<Carteira> dao;

  public CarteiraDAO(EntityManager manager){
    dao = new GenericDAO<Carteira>(manager, Carteira.class);
  }

  public Carteira adiciona(Carteira t) {
    return dao.adiciona(t);
  }

  public void remove(Carteira t) {
    dao.remove(t);
  }

  public Carteira atualiza(Carteira t) {
    return dao.atualiza(t);
  }

  public List<Carteira> listaTodos() {
    return dao.listaTodos();
  }

  public Carteira buscaPorIdCliente(Long id) {
    Query query = getEntityManager().createQuery("SELECT c FROM Carteira as c WHERE d.id_cliente = " + id);
    Carteira carteiraEncontrada = (Carteira)(query.getResultList().get(0));

    return carteiraEncontrada;
  }

  public EntityManager getEntityManager() {
    return this.dao.getEntityManager();
  }

}