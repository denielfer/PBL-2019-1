package model;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoteTeste {

    Exame exame1;
    Consulta consulta1;
    Lote lote;

    @Before
    public void setUp() throws Exception {
        exame1 = new Exame("Francisco Amaral", "E20", "Tomografia", "Sem recomendacoes", "Gravidez");
        consulta1 = new Consulta("João Ferreira", "C09", "Cardiologia");
        lote = new Lote(exame1, 7, "30/07/2019");
    }

    @Test
    public void testeInsercao() {
        assertEquals(exame1, lote.getProcedimento());
        assertEquals(7, lote.getQuantidade());
        assertEquals("30/07/2019", lote.getData());

        lote.setProcedimento(consulta1);
        lote.setQuantidade(10);
        lote.setData("31/07/2019");

        assertEquals(consulta1, lote.getProcedimento());
        assertEquals(10, lote.getQuantidade());
        assertEquals("31/07/2019", lote.getData());
    }
    @Test
    public void testEquals() {
        Lote l;
        l = new Lote(exame1, 7, "30/07/2019");
        assertTrue(l.equals(lote));     
        
        l = new Lote(consulta1, 5, "12/09/2019");
        assertFalse(l.equals(lote));
    }
}
