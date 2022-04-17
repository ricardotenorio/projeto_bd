package builder;

import model.entity.Pedido;
import model.entity.PedidoProduto;
import model.entity.PedidoProdutoPK;
import model.entity.Produto;

public class PedidoProdutoBuilder {

  private PedidoProdutoPK id;
  private double valorUnitario;
  private int quantidade;
  private Pedido pedido;
  private Produto produto;

  public static PedidoProdutoBuilder umPedidoProduto() {
    return new PedidoProdutoBuilder();
  }

  public PedidoProdutoBuilder comValor(double valorUnitario) {
    this.valorUnitario = valorUnitario;

    return this;
  }

  public PedidoProdutoBuilder comQuantidade(int quantidade) {
    this.quantidade = quantidade;

    return this;
  }

  public PedidoProdutoBuilder comPedido(Pedido pedido) {
    this.pedido = pedido;

    return this;
  }

  public PedidoProdutoBuilder comProduto(Produto produto) {
    this.produto = produto;

    return this;
  }

  public PedidoProduto build() {
    PedidoProduto pedidoProduto = new PedidoProduto();
    pedidoProduto.setPedido(pedido);
    pedidoProduto.setProduto(produto);
    pedidoProduto.setValorUnitario(valorUnitario);
    pedidoProduto.setQuantidade(quantidade);
    pedidoProduto.setId(new PedidoProdutoPK(pedido.getId(), produto.getId()));

    return pedidoProduto;
  }

}
