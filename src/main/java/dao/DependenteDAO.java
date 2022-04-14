package dao;

import model.entity.Cliente;
import model.entity.Dependente;

import javax.persistence.EntityManager;
import java.util.List;

public class DependenteDAO {private GenericDAO<Dependente> dao;

  public DependenteDAO(EntityManager manager){
    dao = new GenericDAO<Dependente>(manager, Dependente.class);
  }

  public Dependente adiciona(Dependente t) {
    return dao.adiciona(t);
  }

  public void remove(Dependente t) {
    dao.remove(t);
  }

  public Dependente atualiza(Dependente t) {
    return dao.atualiza(t);
  }

  public List<Dependente> listaTodos() {
    return dao.listaTodos();
  }

  public Dependente buscaPorId(Long id) {
    return dao.buscaPorId(id);
  }

  public EntityManager getEntityManager() {
    return this.dao.getEntityManager();
  }

}