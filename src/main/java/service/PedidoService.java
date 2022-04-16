package service;

import dao.EMFactory;
import dao.PedidoDAO;
import model.entity.Cliente;
import model.entity.Pedido;

import java.util.List;

public class PedidoService {

  private PedidoDAO dao = new PedidoDAO(EMFactory.getInstance().getEntityManager());

  public Pedido atualizaPedido(Pedido pedido){
    return dao.atualiza(pedido);
  }

  public void removePedido(Pedido pedido){
    dao.remove(pedido);
  }

  public List<Pedido> listaPedido(Pedido pedido){
    return dao.listaTodos();
  }

  public Pedido buscaID(long pedidoID){
    return dao.buscaPorId(pedidoID);
  }

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
