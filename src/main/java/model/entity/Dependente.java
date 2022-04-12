package model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Dependente implements Serializable {

  @EmbeddedId
  private DependentePK id;

  @Column(nullable = false)
  private String nome;

  @MapsId("idCliente")
  @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
  @ManyToOne
  private Cliente cliente;

  public Dependente() {}

  public Dependente(DependentePK id, String nome, Cliente cliente) {
    this.id = id;
    this.nome = nome;
    this.cliente = cliente;
  }

  public DependentePK getId() {
    return id;
  }

  public void setId(DependentePK id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
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
    if (!(o instanceof Dependente)) return false;
    Dependente that = (Dependente) o;
    return id.equals(that.id) && nome.equals(that.nome) && cliente.equals(that.cliente);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, cliente);
  }

}
