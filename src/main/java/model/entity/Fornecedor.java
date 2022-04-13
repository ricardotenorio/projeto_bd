package model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Fornecedor implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_fornecedor")
  private Long id;

  @Column(nullable = false)
  private String nome;

  public Fornecedor() {}

  public Fornecedor(Long id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Fornecedor)) return false;
    Fornecedor that = (Fornecedor) o;
    return id == that.id && nome.equals(that.nome);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome);
  }
}
