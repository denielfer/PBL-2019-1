package model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ConsultaTeste {

    Consulta consulta;

    @Before
    public void setUp() throws Exception {

        consulta = new Consulta("Alberto", "C09", "Dermatologia");
    }

    @Test
    public void testeInsercao() {
        assertEquals("Alberto", consulta.getMedico());
        assertEquals("C09", consulta.getSala());
        assertEquals("Dermatologia", consulta.getEspecialidade());

        consulta.setMedico("Marta");
        consulta.setSala("C05");
        consulta.setEspecialidade("Radiologia");

        assertEquals("Marta", consulta.getMedico());
        assertEquals("C05", consulta.getSala());
        assertEquals("Radiologia", consulta.getEspecialidade());
    }
    @Test
    public void testEquals() {
        Consulta consulta1= new Consulta("Alberto", "C09", "Dermatologia");
        assertTrue(consulta1.equals(consulta));
        
        consulta1 = new Consulta("John", "S01", "Radiologia");
        assertFalse(consulta1.equals(consulta));
        
    }
}
