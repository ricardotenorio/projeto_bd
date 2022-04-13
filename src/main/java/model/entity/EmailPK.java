package model.entity;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class EmailPK {

    @Column(name = "id_cliente", nullable = false)
    private long idCliente;

    @Column(name = "email", nullable = false)
    private String endereco;

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailPK emailPK = (EmailPK) o;
        return idCliente == emailPK.idCliente && endereco.equals(emailPK.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, endereco);
    }
}
