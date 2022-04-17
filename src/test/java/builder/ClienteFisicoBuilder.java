package builder;

import model.entity.Cliente;
import model.entity.ClienteFisico;

public class ClienteFisicoBuilder {
	
	private String nome;
	private String cpf;
	private String rg;

	private ClienteFisicoBuilder() {}
	
	public static ClienteFisicoBuilder umCliente() {
		return new ClienteFisicoBuilder();
	}
	
	public ClienteFisicoBuilder comNome(String nome) {
		this.nome = nome;
		return this;
	}

	public ClienteFisicoBuilder comRg(String rg) {
		this.rg = rg;
		return this;
	}

	public ClienteFisicoBuilder comCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}
	
	public Cliente build() {
		ClienteFisico cliente = new ClienteFisico();
		cliente.setNome(nome);
		cliente.setRg(rg);
		cliente.setCpf(cpf);
		return cliente;
	}

}
