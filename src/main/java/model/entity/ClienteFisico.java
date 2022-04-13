package model.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@DiscriminatorValue("fisico")
public class ClienteFisico extends Cliente {

    @Column(name = "cpf", columnDefinition = "CHAR(11)")
    private String cpf;

    @Column(name = "rg", length = 50)
    private String rg;

    public ClienteFisico(String cpf, String rg) {
        this.cpf = cpf;
        this.rg = rg;
    }

    public ClienteFisico() {}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
        if (o == null || getClass() != o.getClass()) return false;
        ClienteFisico that = (ClienteFisico) o;
        return cpf.equals(that.cpf) && rg.equals(that.rg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, rg);
    }
}
