package model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Endereco implements Serializable {

  @Column(name = "end_cep")
  private String cep;

  @Column(name = "end_rua")
  private String rua;

  @Column(name = "end_cidade")
  private String cidade;

  public Endereco() {}

  public Endereco(String cep, String rua, String cidade) {
    this.cep = cep;
    this.rua = rua;
    this.cidade = cidade;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getRua() {
    return rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Endereco)) return false;
    Endereco endereco = (Endereco) o;
    return Objects.equals(cep, endereco.cep) && Objects.equals(rua, endereco.rua) && Objects.equals(cidade, endereco.cidade);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cep, rua, cidade);
  }
}
