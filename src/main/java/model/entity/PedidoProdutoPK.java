package model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class PedidoProdutoPK {

  @Column(name = "id_pedido", nullable = false)
  private Long idPedido;

  @Column(name = "id_produto", nullable = false)
  private Long idProduto;

  public PedidoProdutoPK() {}

  public PedidoProdutoPK(Long idPedido, Long idProduto) {
    this.idPedido = idPedido;
    this.idProduto = idProduto;
  }

  public Long getIdPedido() {
    return idPedido;
  }

  public void setIdPedido(Long idPedido) {
    this.idPedido = idPedido;
  }

  public Long getIdProduto() {
    return idProduto;
  }

  public void setIdProduto(Long idProduto) {
    this.idProduto = idProduto;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof PedidoProdutoPK)) return false;
    PedidoProdutoPK that = (PedidoProdutoPK) o;
    return idPedido.equals(that.idPedido) && idProduto.equals(that.idProduto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idPedido, idProduto);
  }
}
