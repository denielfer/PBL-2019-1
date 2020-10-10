package model;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AgendamentoTeste {

    
    Paciente paciente1, paciente2;
    String medico1, medico2;
    Exame exame1;
    Consulta consulta1;

    Agendamento agendamento1;

    @Before
    public void setUp() throws Exception {

        paciente1 = new Paciente("Diego", "980.123.465-00", "2345-0987", "06/12/2000");
        paciente2 = new Paciente("Clara", "091.123.269-00", "9109-1276", "04/10/1990");

        exame1 = new Exame("Alana Morais", "E02", "Hemograma", "Em jejum", "Sem restrições");

        consulta1 = new Consulta("Tagner", "C07", "Cardiologia");

        agendamento1 = new Agendamento("Henrique", paciente1, consulta1, new Date(1553303046), "29/07/2019", 4);
    }

    @Test
    public void testeInsercao() {
        assertEquals("Henrique", agendamento1.getAtendente());
        assertEquals(paciente1, agendamento1.getPaciente());
        assertEquals(consulta1, agendamento1.getProcedimento());
        assertEquals(new Date(1553303046), agendamento1.getDataInsercao());
        assertEquals("29/07/2019", agendamento1.getDtProcedimento());
        assertEquals(4, agendamento1.getPrioridade());
        assertEquals(false, agendamento1.isPresente());

        agendamento1.setAtendente("Kailla");
        agendamento1.setPaciente(paciente2);
        agendamento1.setProcedimento(exame1);
        agendamento1.setDataInsercao(new Date(1653303646));
        agendamento1.setDtProcedimento("30/07/2019");
        agendamento1.setPrioridade(1);
        agendamento1.setPresenca();

        assertEquals("Kailla", agendamento1.getAtendente());
        assertEquals(paciente2, agendamento1.getPaciente());
        assertEquals(exame1, agendamento1.getProcedimento());
        assertEquals(new Date(1653303646), agendamento1.getDataInsercao());
        assertEquals("30/07/2019", agendamento1.getDtProcedimento());
        assertEquals(1, agendamento1.getPrioridade());
        assertEquals(true, agendamento1.isPresente());
    }
}
