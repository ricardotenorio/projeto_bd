package service;

import builder.*;
import model.entity.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoServiceTest {

    static PedidoService service = new PedidoService();
    static Produto produto;
    static Cliente cliente;
    static Carteira carteira;
    static Set<PedidoProduto> itens;
    static Pedido pedido;



    @BeforeAll
    public static void before() {
        itens = new HashSet<>();
        produto = ProdutoBuilder.umProduto().comNome("leite").comValor(10).comDescricao("litro de leite").build();
        cliente = ClienteFisicoBuilder.umCliente().comNome("lucas").comCpf("03581467219").comRg("123456789").build();
        carteira = CarteiraBuilder.umaCarteira().comCliente(cliente).comSaldo(100.0).comPontos(0).build();
        pedido = PedidoBuilder.umPedido().comItens(itens).comCliente(cliente).comData(LocalDate.now()).
                comEndereco(new Endereco("a", "b", "c")).build();
        itens.add(PedidoProdutoBuilder.umPedidoProduto().comProduto(produto).comValor(produto.getValor()).comQuantidade(2).comPedido(pedido).build());
        cliente.setCarteira(carteira);
    }

    @BeforeEach
    public void beforeEach(){
        carteira.setSaldo(100.0);
    }

    @Test
    public void deveFinalizarPedidoSeSaldoSuficiente() throws Exception {
        service.finalizarPedido(pedido);
        assertNotNull(pedido.getId());
    }

    @Test
    public void deveDebitarSaldoCarteiraAoFinalizarPedido() throws Exception {
        double saldoCarteira = carteira.getSaldo();

        service.finalizarPedido(pedido);
        assertNotEquals(saldoCarteira, carteira.getSaldo());
    }

    @Test
    public void deveLancarExecaoSeSaldoForInsuficiente() throws Exception {
        carteira.setSaldo(0.0);
        CarteiraService cs = new CarteiraService();
        cs.atualizaCarteira(carteira);
        assertThrows(Exception.class,() -> service.finalizarPedido(pedido));
    }

    @Test
    public void deveIncrementarPontosDaCarteiraEmComprasAcimaDeDez() throws Exception{
        service.finalizarPedido(pedido);
        assertEquals(2, carteira.getPontos());
    }
}
