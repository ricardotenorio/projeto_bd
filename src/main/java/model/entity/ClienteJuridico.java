package model.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@DiscriminatorValue("juridico")
public class ClienteJuridico extends Cliente {

    @Column(name = "insc_estadual", length = 50)
    private String inscricaoEstadual;

    @Column(name = "cnpj", length = 50)
    private String cnpj;

    public ClienteJuridico(String inscricaoEstadual, String cnpj) {
        this.inscricaoEstadual = inscricaoEstadual;
        this.cnpj = cnpj;
    }

    public ClienteJuridico() {}

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteJuridico that = (ClienteJuridico) o;
        return inscricaoEstadual.equals(that.inscricaoEstadual) && cnpj.equals(that.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inscricaoEstadual, cnpj);
    }
}
