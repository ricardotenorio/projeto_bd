package builder;

import model.entity.ClienteFisico;
import model.entity.Produto;

public class ProdutoBuilder {

  private String nome;
  private String descricao;
  private double valor;

  public static ProdutoBuilder umProduto() {
    return new ProdutoBuilder();
  }

  public ProdutoBuilder comNome(String nome) {
    this.nome = nome;

    return this;
  }

  public ProdutoBuilder comDescricao(String descricao) {
    this.descricao = descricao;
    return this;
  }

  public ProdutoBuilder comValor(double valor) {
    this.valor = valor;
    return this;
  }

  public Produto build() {
    Produto produto = new Produto();
    produto.setNome(nome);
    produto.setDescricao(descricao);
    produto.setValor(valor);

    return produto;
  }

}
