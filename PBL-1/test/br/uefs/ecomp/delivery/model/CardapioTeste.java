package br.uefs.ecomp.delivery.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testes de unidade para a classe {@link Cardapio}
 */
public class CardapioTeste {

    private Cardapio m1;

    /**
     * Este método é executado antes de cada teste de unidade (testes a seguir), 
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp() throws Exception {
        m1 = new Cardapio("Prato1", 10.00);
    }

    /**
     * Teste de unidade que verifica se os atributos de uma opção de cardápio são atribuídos e
     * modificados corretamente.
     */
    @Test
    public void testBasic() {
        assertEquals("Prato1", m1.getDescricao());
        assertEquals(10.00, m1.getValor(),.0001);

        m1.setDescricao("Lanche1");
        m1.setValor(5.55);
        assertEquals("Lanche1", m1.getDescricao());
        assertEquals(5.55, m1.getValor(),.0001);
    }
    
    /**
     * Testa se o método equals foi implementado corretamente.
     */
    @Test
    public void testEquals() {
        Cardapio temp = new Cardapio("Prato1", 9.00);
        assertFalse(temp.equals(m1));

        temp.setValor(10.0);
        assertTrue(temp.equals(m1));

        temp = new Cardapio("Lanche1", 10.00);
        assertFalse(temp.equals(m1));
    }
}
