package br.uefs.ecomp.delivery.model;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Testes de unidade para a classe {@link ItemPedido}
 */
public class ItemPedidoTest {

    private ItemPedido i1;
    private Cardapio m1;
    private Cliente c1;
    private Pedido p1;

    /**
     * Este método é executado antes de cada teste de unidade (testes a seguir), 
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp() throws Exception {

        c1 = new Cliente("Fulano", "000-9090-0000","fulano@email.com");

        m1 = new Cardapio("Prato1", 10.00);

        p1 = new Pedido(c1, new Date(1553303046),"Rua X", true);

        i1 = new ItemPedido(m1, 2, "sem ingrediente1");
        i1.setPedido(p1);

    }

    /**
     * Teste de unidade que verifica se os atributos de um item de pedido são atribuídos e
     * modificados corretamente.
     */
    @Test
    public void testBasic() {
        assertEquals(m1, i1.getOpcaoMenu());
        assertEquals(p1, i1.getPedido());
        assertEquals(2, i1.getQuantidade());
        assertEquals("sem ingrediente1", i1.getObservacao());

        i1.setQuantidade(5);
        i1.setObservacao("sem ingrediente2");
        assertEquals(5, i1.getQuantidade());
        assertEquals("sem ingrediente2", i1.getObservacao());
    }
    

}
