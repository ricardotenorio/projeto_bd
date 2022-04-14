package model.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity(name = "pedido_produto")
public class PedidoProduto {

  @EmbeddedId
  private PedidoProdutoPK id;

  @Column(name = "valor_unidade", nullable = false)
  private Double valorUnitario;

  @Column(name = "qtd", columnDefinition = "INTEGER NOT NULL DEFAULT 1")
  private Integer quantidade;

  @ManyToOne(cascade = CascadeType.ALL)
  @MapsId("idPedido")
  @JoinColumn(name = "id_pedido")
  private Pedido pedido;

  @ManyToOne(cascade = CascadeType.ALL)
  @MapsId("idProduto")
  @JoinColumn(name = "id_produto")
  private Produto produto;

  public PedidoProduto() {}

  public PedidoProduto(PedidoProdutoPK id, Double valorUnitario, Integer quantidade, Pedido pedido, Produto produto) {
    this.id = id;
    this.valorUnitario = valorUnitario;
    this.quantidade = quantidade;
    this.pedido = pedido;
    this.produto = produto;
  }

  public PedidoProdutoPK getId() {
    return id;
  }

  public void setId(PedidoProdutoPK id) {
    this.id = id;
  }

  public Double getValorUnitario() {
    return valorUnitario;
  }

  public void setValorUnitario(Double valorUnitario) {
    this.valorUnitario = valorUnitario;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public Pedido getPedido() {
    return pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof PedidoProduto)) return false;
    PedidoProduto that = (PedidoProduto) o;
    return id.equals(that.id) && valorUnitario.equals(that.valorUnitario) && quantidade.equals(that.quantidade) && pedido.equals(that.pedido) && produto.equals(that.produto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, valorUnitario, quantidade, pedido, produto);
  }
}
