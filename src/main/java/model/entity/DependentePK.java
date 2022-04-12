package model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class DependentePK {

  @Column(name = "id_cliente", nullable = false)
  private int idCliente;

  @Column(name = "rg", nullable = false, columnDefinition = "VARCHAR(50)")
  private String rg;

  public DependentePK() {}

  public DependentePK(int idCliente, String rg) {
    this.idCliente = idCliente;
    this.rg = rg;
  }

  public int getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(int idCliente) {
    this.idCliente = idCliente;
  }

  public String getRg() {
    return rg;
  }

  public void setRg(String rg) {
    this.rg = rg;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof DependentePK)) return false;
    DependentePK that = (DependentePK) o;
    return idCliente == that.idCliente && rg.equals(that.rg);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idCliente, rg);
  }
}
