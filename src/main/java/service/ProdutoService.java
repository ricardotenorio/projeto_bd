package service;

import dao.EMFactory;
import dao.ProdutoDAO;
import model.entity.Cliente;
import model.entity.Produto;

import java.util.List;

public class ProdutoService {

    private ProdutoDAO dao = new ProdutoDAO(EMFactory.getInstance().getEntityManager());

    public Produto cadastrarProduto(Produto produto){
        return dao.adiciona(produto);
    }

    public Produto atualizaProduto(Produto produto){
        return dao.atualiza(produto);
    }

    public Produto removeProduto(Produto produto){
        return dao.remove(produto);
    }

    public Produto buscaID(long produtoID){
        return dao.buscaPorId(produtoID);
    }

    public List<Produto> listaProduto(Produto produto){
        return dao.listaTodos();
    }
}
