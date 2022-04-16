package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.persistence.EntityManager;

import builder.ClienteFisicoBuilder;
import model.entity.ClienteFisico;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import model.entity.Cliente;

public class ClienteFisicoDAOTest {
	
	EntityManager manager;
	ClienteDAO dao;
	
	@BeforeEach
	public void before() {
		manager = TestEMFactory.getInstance().getEntityManager();
		dao = new ClienteDAO(manager);
		manager.getTransaction().begin();
	}
	
	@AfterEach
	public void after() {
		manager.getTransaction().rollback();
		manager.close();
	}
	
	@Test
	public void deveSalvarCliente() {
		Cliente novoCliente = ClienteFisicoBuilder.umClienteFisico().comNome("João da Silva").build();
        dao.adiciona(novoCliente);
        assertNotNull(novoCliente.getId());
	}
	
	@Test
	public void deveEncontrarPeloId() {
		Cliente novoCliente = ClienteFisicoBuilder.umClienteFisico().comNome("João da Silva").build();
	    dao.adiciona(novoCliente);
		
	    Cliente cleinteDoBanco = dao.buscaPorId(novoCliente.getId());
	    assertNotNull(cleinteDoBanco);
	    assertEquals(novoCliente.getNome(), cleinteDoBanco.getNome());
	}
	
	@Test
	public void naoDeveEncontrarPeloId() {
		Cliente clienteDoBanco = dao.buscaPorId(-1l);
	    assertNull(clienteDoBanco);
	}
	
	@Test
	public void deveDeletarUmCliente() {
		Cliente novoCliente = ClienteFisicoBuilder.umClienteFisico().comNome("João da Silva").build();
	    
		dao.adiciona(novoCliente);
		
		Long idCliente = novoCliente.getId();
		
	    dao.remove(novoCliente);
	    
	    manager.flush();
	    
	    Cliente clienteDoBanco = dao.buscaPorId(idCliente);
	    assertNull(clienteDoBanco);
	}
	
	@Test
	public void deveAtualizarUmCliente() {
		Cliente novoCliente = ClienteFisicoBuilder.umClienteFisico().comNome("João da Silva").build();
		dao.adiciona(novoCliente);
		
		Long idCliente = novoCliente.getId();
		
		novoCliente.setNome("João Ferreira da Silva");
	    dao.atualiza(novoCliente);
	    
	    manager.flush();
	    
	    Cliente clienteDoBanco = dao.buscaPorId(idCliente);
	    assertNotNull(clienteDoBanco);
	    assertEquals("João Ferreira da Silva", clienteDoBanco.getNome());
	}

}
