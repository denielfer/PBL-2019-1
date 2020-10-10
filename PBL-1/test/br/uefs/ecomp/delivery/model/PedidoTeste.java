package br.uefs.ecomp.delivery.model;

import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Testes de unidade para a classe {@link Pedido}
 */
public class PedidoTeste {
    private Cliente c1;
    private Pedido p1 ;
    private ItemPedido i1, i2, i3;
    private Cardapio m1, m2, m3;


    /**
     * Este método é executado antes de cada teste de unidade (testes a seguir), 
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp() throws Exception {
        c1 = new Cliente("Fulano", "000-9090-0000","fulano@email.com");

        m1 = new Cardapio("Prato1", 10.00);
        m2 = new Cardapio("Prato2", 8.50);
        m3 = new Cardapio("Bebida1", 3.49);

        p1 = new Pedido(c1, new Date(1553303046),"Rua X", true);

    }
   
    /**
     * Teste de unidade que verifica se os atributos de um pedido são
     * atribuídos e modificados corretamente.
     */
    @Test
    public void testBasic(){
        assertEquals(new Date(1553303046), p1.getDataHora());
        assertEquals(c1, p1.getCliente());
        assertEquals("Rua X", p1.getEndereco());
        assertEquals(true, p1.getSituacao());

        i1 = new ItemPedido(m1, 2, "sem ingrediente1");
        i1.setPedido(p1);
        assertEquals(1, p1.getItens().size());
        assertEquals(i1, p1.getItens().get(0));

        i2 = new ItemPedido(m2, 1, "preparação2");
        i2.setPedido(p1);
        assertEquals(2, p1.getItens().size());
        assertEquals(i1, p1.getItens().get(0));
        assertEquals(i2, p1.getItens().get(1));
        assertEquals(28.50, p1.getValorTotal(),.0001);

        i3 = new ItemPedido(m3, 3, "saborX");
        i3.setPedido(p1);
        assertEquals(3, p1.getItens().size());
        assertEquals(i3, p1.getItens().get(2));
        assertEquals(38.97, p1.getValorTotal(),.0001);

        p1.getItens().get(2).setQuantidade(1);
        assertEquals(3, p1.getItens().size());
        assertEquals(i3, p1.getItens().get(2));
        assertEquals(31.99, p1.getValorTotal(),.0001);

        p1.setEndereco("Rua 7");
        assertEquals("Rua 7", p1.getEndereco());

        p1.setFechado();
        assertEquals(false, p1.getSituacao());

        Pedido temp = new Pedido(c1, new Date(1554494099),"Rua BBB", true);
        i1 = new ItemPedido(m3, 10, "saborA");
        i1.setPedido(temp);
        assertEquals(1, temp.getItens().size());
        assertEquals(3, p1.getItens().size());

    }
    

}
