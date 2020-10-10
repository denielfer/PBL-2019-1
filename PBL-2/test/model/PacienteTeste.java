package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PacienteTeste {

    Paciente paciente1;

    @Before
    public void setUp() throws Exception {
        paciente1 = new Paciente("Ana", "089.345.555-00", "3445-8901", "24-07-1998");
    }

    @Test
    public void testeInsercao() {
        assertEquals("Ana", paciente1.getNome());
        assertEquals("089.345.555-00", paciente1.getCpf());
        assertEquals("3445-8901", paciente1.getTelefone());
        assertEquals("24-07-1998", paciente1.getDataNascimento());

        paciente1.setNome("Ana Maria");
        paciente1.setCpf("000.567.124-98");
        paciente1.setDataNascimento("24-07-2000");

        assertEquals("Ana Maria", paciente1.getNome());
        assertEquals("000.567.124-98", paciente1.getCpf());
        assertEquals("24-07-2000", paciente1.getDataNascimento());

    }

     @Test
    public void testEquals() {
        Paciente paciente2= new Paciente("Ana", "089.345.555-00", "3445-8901", "24-07-1998");
        assertTrue(paciente2.equals(paciente1));
        
        paciente2= new Paciente("Joao Carlos", "111.225.555-00", "2345-0198", "05-12-2000");
        assertFalse(paciente2.equals(paciente1));
        
    }

}
