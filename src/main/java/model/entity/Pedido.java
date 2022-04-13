package model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Pedido implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_pedido")
  private Long id;

  @Column(name = "valor_total")
  private double valorTotal;

  @Column(nullable = false, columnDefinition = "DATE")
  private LocalDate data;

  @Embedded
  @AttributeOverrides(
      {
          @AttributeOverride(
              name = "cep",
              column = @Column(
                  name = "end_cep",
                  columnDefinition = "CHAR(8)",
                  nullable = false
              )
          ),
          @AttributeOverride(
              name = "rua",
              column = @Column(name = "end_rua", nullable = false)
          ),
          @AttributeOverride(
              name = "cidade",
              column = @Column(name = "end_cidade", nullable = false)
          )
      }
  )
  private Endereco endereco;

  @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
  @ManyToOne(optional = false)
  private Cliente cliente;

  public Pedido() {}

  public Pedido(Long id, double valorTotal, LocalDate data, Endereco endereco, Cliente cliente) {
    this.id = id;
    this.valorTotal = valorTotal;
    this.data = data;
    this.endereco = endereco;
    this.cliente = cliente;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public double getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(double valorTotal) {
    this.valorTotal = valorTotal;
  }

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
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
    if (!(o instanceof Pedido)) return false;
    Pedido pedido = (Pedido) o;
    return id == pedido.id && Double.compare(pedido.valorTotal, valorTotal) == 0 && data.equals(pedido.data) && endereco.equals(pedido.endereco) && cliente.equals(pedido.cliente);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, valorTotal, data, endereco, cliente);
  }
}
