package dao;

import model.entity.Email;

import javax.persistence.EntityManager;
import java.util.List;

public class EmailDAO {
  private GenericDAO<Email> dao;

  public EmailDAO(EntityManager manager){
    dao = new GenericDAO<Email>(manager, Email.class);
  }

  public Email adiciona(Email t) {
    return dao.adiciona(t);
  }

  public void remove(Email t) {
    dao.remove(t);
  }

  public Email atualiza(Email t) {
    return dao.atualiza(t);
  }

  public List<Email> listaTodos() {
    return dao.listaTodos();
  }

  public Email buscaPorId(Long id) {
    return dao.buscaPorId(id);
  }

  public EntityManager getEntityManager() {
    return this.dao.getEntityManager();
  }
}
