package br.uefs.ecomp.delivery.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * Testes de unidade para a classe {@link Cliente}
 */
public class ClienteTeste {

    private Cliente c1;


    /**
     * Este método é executado antes de cada teste de unidade (testes a seguir),
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp() throws Exception {
        c1 = new Cliente("Fulano", "000-9090-0000","fulano@email.com");

    }

    /**
     * Teste de unidade que verifica se os atributos de um cliente são
     * atribuídos corretamente.
     */
    @Test
    public void testBasic() {
        assertEquals("Fulano", c1.getName());
        assertEquals("000-9090-0000", c1.getPhone());
        assertFalse(c1.getPhone().equals("000-9080-0000"));
        assertEquals("fulano@email.com", c1.getEmail());
    }
    
    /**
     * Teste de unidade que verifica se o método
     * que compara dois clientes foi implementado corretamente.
     */
    @Test
    public void testEquals() {
        Cliente temp = new Cliente("Fulano", "000-9090-0000","fulano@email.com");
        assertTrue(temp.equals(c1));
        
        temp = new Cliente("Beltrano", "099-9090-0000","beltrano@email.com");
        assertFalse(temp.equals(c1));

        temp = new Cliente("Fulano", "099-9090-0000","fulano2@email.com");
        assertFalse(temp.equals(c1));
        
    }




}
