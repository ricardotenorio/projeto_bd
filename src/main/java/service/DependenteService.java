package service;

import dao.DependenteDAO;
import dao.EMFactory;
import model.entity.Dependente;

import java.util.List;

public class DependenteService {

    private DependenteDAO dao = new DependenteDAO(EMFactory.getInstance().getEntityManager());

    public Dependente cadastrarDependente(Dependente dependente){
        return dao.adiciona(dependente);
    }

    public Dependente atualizaDependente(Dependente dependente){
        return dao.atualiza(dependente);
    }

    public void removeDependente(Dependente dependente) {
        dao.remove(dependente);
    }

    public Dependente buscarPorRg(String rg) {
        return dao.buscaPorRg(rg);
    }

    public List<Dependente> listaDependente(Dependente dependente){
        return dao.listaTodos();
    }
}
