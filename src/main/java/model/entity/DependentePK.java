package model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DependentePK implements Serializable {

  @Column(name = "id_cliente", nullable = false)
  private Long idCliente;

  @Column(name = "rg", nullable = false, columnDefinition = "VARCHAR(50)")
  private String rg;

  public DependentePK() {}

  public DependentePK(Long idCliente, String rg) {
    this.idCliente = idCliente;
    this.rg = rg;
  }

  public Long getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Long idCliente) {
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
