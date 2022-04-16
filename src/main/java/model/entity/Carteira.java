package model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Carteira implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_carteira")
  private Long id;

  @Column(nullable = false, columnDefinition = "DOUBLE PRECISION DEFAULT 0.O")
  private double saldo;

  @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
  private int pontos;

  @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
  @OneToOne(cascade = {
              CascadeType.PERSIST,
              CascadeType.MERGE
  })
  private Cliente cliente;

  public Carteira() {

  }

  public Carteira(Long id, double saldo, int pontos, Cliente cliente) {
    this.id = id;
    this.saldo = saldo;
    this.pontos = pontos;
    this.cliente = cliente;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  public int getPontos() {
    return pontos;
  }

  public void setPontos(int pontos) {
    this.pontos = pontos;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Carteira)) return false;
    Carteira carteira = (Carteira) o;
    return Double.compare(carteira.saldo, saldo) == 0 && pontos == carteira.pontos && id.equals(carteira.id) && Objects.equals(cliente, carteira.cliente);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, saldo, pontos, cliente);
  }
}
