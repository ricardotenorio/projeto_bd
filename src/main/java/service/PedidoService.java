package service;

import dao.EMFactory;
import dao.PedidoDAO;
import model.entity.Pedido;

public class PedidoService {

  private PedidoDAO dao = new PedidoDAO(EMFactory.getInstance().getEntityManager());

  public void finalizarPedido(Pedido pedido) throws Exception {
    double valorTotal = calcularValorTotal(pedido);

    pedido.setValorTotal(valorTotal);

    if (pedido.getCliente().verificarSaldoCarteira() < pedido.getValorTotal()) {
      throw new Exception("saldo insuficiente");
    }

    try {
      dao.adiciona(pedido);
    } catch (Exception ex) {
      throw new Exception("Erro ao salvar");
    }

  }

  private double calcularValorTotal(Pedido pedido) {
    double valorTotal = pedido.getItens()
                              .stream()
                              .mapToDouble(item -> item.getQuantidade() * item.getValorUnitario())
                              .sum();

    return valorTotal;
  }

}
