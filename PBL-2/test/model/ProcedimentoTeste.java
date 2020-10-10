package model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ProcedimentoTeste {

    Procedimento procedimento;

    @Before
    public void setUp() throws Exception {
        procedimento = new Procedimento("Sidney", "sala 09");

    }

    @Test
    public void testeInsercao() {
        assertEquals("Sidney", procedimento.getMedico());
        assertEquals("sala 09", procedimento.getSala());

        procedimento.setMedico("Josineide");
        procedimento.setSala("sala especial 03");

        assertEquals("Josineide", procedimento.getMedico());
        assertEquals("sala especial 03", procedimento.getSala());

    }
}
