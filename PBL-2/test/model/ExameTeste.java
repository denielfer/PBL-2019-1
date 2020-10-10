package model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ExameTeste {

    Exame exame;

    @Before
    public void setUp() throws Exception {

        exame = new Exame("Maria Silva", "E20", "Eletrocardiograma", "Sem recomendacoes", "Sem restrições");
    }

    @Test
    public void testeInsercao() {
        assertEquals("Maria Silva", exame.getMedico());
        assertEquals("E20", exame.getSala());
        assertEquals("Eletrocardiograma", exame.getTipo());
        assertEquals("Sem recomendacoes", exame.getRecomendacoes());
        assertEquals("Sem restrições", exame.getRestricoes());

        exame.setMedico("Ana Paz");
        exame.setSala("E13");
        exame.setTipo("Ultrassom morfológica");

        assertEquals("Ana Paz", exame.getMedico());
        assertEquals("E13", exame.getSala());
        assertEquals("Ultrassom morfológica", exame.getTipo());

    }
    @Test
    public void testEquals() {
        Exame exame1 = new Exame("Maria Silva", "E20", "Eletrocardiograma", "Sem recomendacoes", "Sem restrições");
        assertTrue(exame1.equals(exame));
        
        exame1 = new Exame("Salvador", "E04", "Eletrocardiograma", "Sem objetos metalicos", "Sem restrições");
        assertFalse(exame1.equals(exame));
        
    }

}
