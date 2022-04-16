
package builder;

import model.entity.Cliente;
import model.entity.ClienteFisico;

import java.util.Objects;

public class ClienteFisicoBuilder {
	
	private String nome;

	private String rg;

	private String cpf;

	public ClienteFisicoBuilder(String nome, String rg, String cpf) {
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
	}

	public ClienteFisicoBuilder() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ClienteFisicoBuilder that = (ClienteFisicoBuilder) o;
		return nome.equals(that.nome) && rg.equals(that.rg) && cpf.equals(that.cpf);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, rg, cpf);
	}
}
