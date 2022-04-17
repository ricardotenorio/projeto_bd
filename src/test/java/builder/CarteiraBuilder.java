package builder;

import model.entity.Carteira;
import model.entity.Cliente;
import model.entity.ClienteFisico;
import org.checkerframework.checker.units.qual.C;

public class CarteiraBuilder {

  private double saldo;
  private int pontos;
  private Cliente cliente;

  public static CarteiraBuilder umaCarteira() {
    return new CarteiraBuilder();
  }

  public CarteiraBuilder comCliente(Cliente cliente) {
    this.cliente = cliente;
    return this;
  }

  public CarteiraBuilder comSaldo(double saldo) {
    this.saldo = saldo;
    return this;
  }

  public CarteiraBuilder comPontos(int pontos) {
    this.pontos = pontos;
    return this;
  }

  public Carteira build() {
    Carteira carteira = new Carteira();
    carteira.setSaldo(saldo);
    carteira.setPontos(pontos);
    carteira.setCliente(cliente);

    return carteira;
  }

}
