package model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Produto implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_produto")
  private Long id;

  @Column
  private String nome;

  @Column
  private String descricao;

  @Column(nullable = false)
  private double valor;

  public Produto() {}

  public Produto(Long id, String nome, String descricao, double valor) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.valor = valor;
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

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Produto)) return false;
    Produto produto = (Produto) o;
    return id == produto.id && Double.compare(produto.valor, valor) == 0 && Objects.equals(nome, produto.nome) && Objects.equals(descricao, produto.descricao);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, descricao, valor);
  }

}
