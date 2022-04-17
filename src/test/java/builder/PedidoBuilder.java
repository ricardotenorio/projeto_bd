package builder;

import model.entity.*;

import java.time.LocalDate;
import java.util.Set;

public class PedidoBuilder {

  private double valorTotal;
  private LocalDate data;
  private Endereco endereco;
  private Cliente cliente;
  private Set<PedidoProduto> itens;

  public static PedidoBuilder umPedido() {
    return new PedidoBuilder();
  }

  public PedidoBuilder comValorTotal(double valorTotal) {
    this.valorTotal = valorTotal;
    return this;
  }

  public PedidoBuilder comData(LocalDate data) {
    this.data = data;
    return this;
  }

  public PedidoBuilder comEndereco(Endereco endereco) {
    this.endereco = endereco;
    return this;
  }

  public PedidoBuilder comCliente(Cliente cliente) {
    this.cliente = cliente;
    return this;
  }

  public PedidoBuilder comItens(Set<PedidoProduto> itens) {
    this.itens = itens;
    return this;
  }

  public Pedido build() {
    Pedido pedido = new Pedido();
    pedido.setValorTotal(valorTotal);
    pedido.setData(data);
    pedido.setEndereco(endereco);
    pedido.setCliente(cliente);
    pedido.setItens(itens);

    return pedido;
  }

}
