package model.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_cliente")
public abstract class Cliente implements Serializable {
	
	private static final long serialVersionUID = 3387642521978418140L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "ID_CLIENTE")
	private Long id;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	public Cliente() {}

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
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + "]";
	}

}
