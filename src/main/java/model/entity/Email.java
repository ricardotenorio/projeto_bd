package model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "email_cliente")
public class Email implements Serializable {

    @EmbeddedId
    private EmailPK id;

    @MapsId("idCliente")
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(cascade = CascadeType.ALL)
    private Cliente cliente;

    public Email(EmailPK id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
    }

    public Email(){}

    public EmailPK getId() {
        return id;
    }

    public void setId(EmailPK id) {
        this.id = id;
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
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return id.equals(email.id) && cliente.equals(email.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cliente);
    }
}
