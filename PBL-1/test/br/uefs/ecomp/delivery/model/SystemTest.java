package br.uefs.ecomp.delivery.model;

import java.util.Iterator;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;



/**
 *
 * @author angelo
 */
public class SystemTest {
    private System sys;
    private Cliente c1, c2, c3;
    private Cardapio m1, m2, m3;
    private Pedido p1, p2, p3;

    /**
     * Este método é executado antes de cada teste de unidade (testes a seguir),
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp() throws Exception {
        sys = new System();

        c1 = new Cliente("Fulano", "000-9090-0000","fulano@email.com");
        c2 = new Cliente("Beltrano", "000-9080-0000","beltrano@email.com");
        c3 = new Cliente("Cicrano", "000-9080-0000","cicrano@email.com");

        m1 = new Cardapio("Prato1", 10.00);
        m2 = new Cardapio("Prato2", 8.50);
        m3 = new Cardapio("Bebida1", 3.49);

        p1 = new Pedido(c1, new Date(),"Rua X", true);
        p2 = new Pedido(c2, new Date(),"Rua Y", true);
        p3 = new Pedido(c2, new Date(),"Rua Z", true);

    }
    
    /**
     * Teste de unidade que verifica a inserção de clientes no sistema.
     */
    @Test
    public void testAddCliente() {
        sys.getClientes().add(c1);
        sys.getClientes().add(c2);
        sys.getClientes().add(c3);
        assertEquals(sys.getClientes().size(),3);
        
        assertEquals(c1, sys.getClientes().get(0));
        assertEquals(c2, sys.getClientes().get(1));
        assertEquals(c3, sys.getClientes().get(2));

    }

    /**
     * Teste de unidade que verifica a inserção de opção ao cardápio no sistema.
     */
    @Test
    public void testAddCardapio() {
        sys.getCardapio().add(m1);
        sys.getCardapio().add(m2);
        sys.getCardapio().add(m3);
        assertEquals(sys.getCardapio().size(),3);

        assertEquals(m1, sys.getCardapio().get(0));
        assertEquals(m2, sys.getCardapio().get(1));
        assertEquals(m3, sys.getCardapio().get(2));

    }

    /**
     * Teste de unidade que verifica a inserção de pedidos no sistema.
     */
    @Test
    public void testAddPedido() {

        sys.getPedidosAbertos().enqueue(p1);
        sys.getPedidosAbertos().enqueue(p2);
        sys.getPedidosAbertos().enqueue(p3);
        assertEquals(sys.getPedidosAbertos().size(),3);

        assertEquals(p1, sys.getPedidosAbertos().dequeue());
        assertEquals(p2, sys.getPedidosAbertos().dequeue());
        assertEquals(p3, sys.getPedidosAbertos().dequeue());

   }
    
    /**
     * Teste de unidade que verifica a remoção de clientes no sistema.
     */
    @Test
    public void testRemoveCliente() {
        sys.getClientes().add(c1);
        sys.getClientes().add(c2);
        sys.getClientes().add(c3);
        
        sys.getClientes().removeByPhone("000-9999-0000");
        assertEquals(sys.getClientes().size(),3);
        assertEquals(c1, sys.getClientes().get(0));
        assertEquals(c2, sys.getClientes().get(1));
        assertEquals(c3, sys.getClientes().get(2));
        
        sys.getClientes().removeByPhone("000-9080-0000");
        assertEquals(sys.getClientes().size(),1);
        assertEquals(c1, sys.getClientes().get(0));

        assertFalse(sys.getClientes().isEmpty());
    }
    
    /**
     * Teste de unidade que verifica o iterador de clientes.
     */
    @Test
    public void testIterator() {
        sys.getClientes().add(c1);
        sys.getClientes().add(c2);
        sys.getClientes().add(c3);
        
        Iterator it = sys.getClientes().iterator();
        
        assertTrue(it.hasNext());
        assertEquals(c1, it.next());
        
        assertTrue(it.hasNext());
        assertEquals(c2, it.next());
        
        assertTrue(it.hasNext());
        assertEquals(c3, it.next());
        
        assertFalse(it.hasNext());        
    }

    /**
     * Teste que verifica verifica se é possível recuperar clientes pelo telefone ou nome
     */
    @Test
    public void testSearchClientes(){
        sys.getClientes().add(c1);
        sys.getClientes().add(c2);
        sys.getClientes().add(c3);

        Iterator it = sys.getClientes().searchClientebyName("Fulano");
        assertTrue(it.hasNext());
        assertEquals(c1, it.next());
        assertFalse(it.hasNext());

        it = sys.getClientes().searchClientebyPhone("000-9090-0000");
        assertTrue(it.hasNext());
        assertEquals(c1, it.next());
        assertFalse(it.hasNext());

        it = sys.getClientes().searchClientebyName("l");
        assertTrue(it.hasNext());
        assertEquals(c1, it.next());

        assertTrue(it.hasNext());
        assertEquals(c2, it.next());

        assertFalse(it.hasNext());
        assertNull(it.next());

        it = sys.getClientes().searchClientebyPhone("000-9080-0000");
        assertTrue(it.hasNext());
        assertEquals(c2, it.next());
        assertTrue(it.hasNext());
        assertEquals(c3, it.next());

        assertFalse(it.hasNext());
        assertNull(it.next());

    }


    /**
     * Teste de unidade que verifica atualização do pedido e pedidos em aberto.
     */
    @Test
    public void testAtualizaPedidos() {

        sys.getPedidosAbertos().enqueue(p1);
        assertEquals(p1, sys.getPedidosAbertos().peek());
        assertEquals(1,sys.getPedidosAbertos().size());
        assertEquals(p1,sys.getPedidosAbertos().last());
        assertEquals(0,sys.getPedidosFechados().size());

        sys.getPedidosAbertos().setNexttoPedidoFechado();
        assertEquals(0, sys.getPedidosAbertos().size());
        assertEquals(1,sys.getPedidosFechados().size());
        assertEquals(p1,sys.getPedidosFechados().get(0));

        sys.getPedidosAbertos().enqueue(p2);
        assertEquals(p2, sys.getPedidosAbertos().peek());
        assertEquals(1,sys.getPedidosAbertos().size());
        assertEquals(p2,sys.getPedidosAbertos().last());

        sys.getPedidosAbertos().enqueue(p3);
        assertEquals(p2, sys.getPedidosAbertos().peek());
        assertEquals(p3, sys.getPedidosAbertos().last());
        assertEquals(2,sys.getPedidosAbertos().size());


        sys.getPedidosAbertos().setNexttoPedidoFechado();
        assertEquals(p1, sys.getPedidosFechados().get(0));
        assertEquals(p2, sys.getPedidosFechados().get(1));
        assertEquals(2,sys.getPedidosFechados().size());
        assertEquals(p3, sys.getPedidosAbertos().peek());
        assertEquals(p3, sys.getPedidosAbertos().last());
        assertEquals(1,sys.getPedidosAbertos().size());

        sys.getPedidosAbertos().setNexttoPedidoFechado();
        assertEquals(p1, sys.getPedidosFechados().get(0));
        assertEquals(p2, sys.getPedidosFechados().get(1));
        assertEquals(p3, sys.getPedidosFechados().get(2));
        assertEquals(3,sys.getPedidosFechados().size());
        assertEquals(0,sys.getPedidosAbertos().size());

    }


    /**
     * Teste de unidade que verifica apresentação do cardápio.
     */
    @Test
    public void testListaCardapio() {
        sys.getCardapio().add(m1);
        assertEquals(sys.getCardapio().showCardapio(),"Prato1");

        sys.getCardapio().add(m2);
        assertEquals(sys.getCardapio().size(),2);
        assertEquals(sys.getCardapio().showCardapio(),"Prato1\nPrato2");

        sys.getCardapio().add(m3);
        assertEquals(sys.getCardapio().size(),3);
        assertEquals(sys.getCardapio().showCardapio(),"Prato1\nPrato2\nBebida1");

     }



}
