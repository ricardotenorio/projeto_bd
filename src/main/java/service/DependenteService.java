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

    //todo remove por rg

    //todo buscaRG

    public List<Dependente> listaDependente(Dependente dependente){
        return dao.listaTodos();
    }
}
