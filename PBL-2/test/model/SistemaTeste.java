package model;

import java.util.Date;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;


public class SistemaTeste {

    private Sistema sys;
    private Paciente p1, p2, p3, p4, p5, p6;
    private Exame exame1, exame2;
    private Consulta consulta1, consulta2;
    private Lote lote1, lote2, lote3, lote4, lote5;
    private Agendamento ag1, ag2, ag3, ag4, ag5, ag6;


    @Before
    public void setUp() throws Exception {

        sys = new Sistema();

        p1 = new Paciente("Carla", "345.908.000-12", "8890-6578", "07-01-1990");
        p2 = new Paciente("Roberto", "461.671.097-16", "3669-9023", "28-02-19360");
        p3 = new Paciente("Antonieta", "401.351.807-86", "2256-9800", "16-10-1970");
        p4 = new Paciente("Jamile", "321.654.212-05", "9879-2134", "01-01-2005");
        p5 = new Paciente("Paulo", "099.000.344-11", "8888-5555", "10-03-1956");
        p6 = new Paciente ("Jesuino", "005.556.677-78", "9956-6878", "30-05-1920");

        exame1 = new Exame("Francisco", "E20", "Tomografia", "Sem recomendacoes", "Gravidez");
        exame2 = new Exame("João", "E13", "Eletrocardiograma", "Sem recomendacoes", "Sem restrições");

        consulta1 = new Consulta("João", "C09", "Cardiologia");
        consulta2 = new Consulta("Jailma", "C12", "Oftamologia");

        lote1 = new Lote(exame1, 10, "22/07/2019");
        lote2 = new Lote(consulta1, 5, "22/07/2019");
        lote3 = new Lote(consulta2, 10, "26/07/2019");
        lote4 = new Lote(exame2, 1, "27/07/2019");
        lote5 = new Lote(consulta2, 5, "26/07/2019");

        ag1 = new Agendamento("Roseane", p1, consulta1, new Date(1553303046), "22/07/2019", 2);
        ag2 = new Agendamento("Marcos", p2, exame1, new Date(1553303046), "22/07/2019", 5);
        ag3 = new Agendamento("Roseane", p3, exame2, new Date(1553303046), "27/07/2019", 4);
        ag4 = new Agendamento("Marcos", p4, consulta2, new Date(1553303046), "23/07/2019", 1);
        ag5 = new Agendamento("Marcos", p5, exame2, new Date(1553303046), "27/07/2019", 3);
        ag6 = new Agendamento("Judas", p6, consulta2, new Date(1553303046),"26/07/2019", 4);
    }

    
    @Test
    public void testeAddPaciente() {
        
        // Adiciona os pacientes à lista.
        sys.getPacientes().add(p1);
        sys.getPacientes().add(p2);
        sys.getPacientes().add(p3);
        sys.getPacientes().add(p4);

        //Retorna os respectivos pacientes da lista.
        assertEquals(p1, sys.getPacientes().get(0));
        assertEquals(p2, sys.getPacientes().get(1));
        assertEquals(p3, sys.getPacientes().get(2));
        assertEquals(p4, sys.getPacientes().get(3));

        assertEquals(4, sys.getPacientes().size());

    }

    @Test
    public void testeIteratorPaciente() {
        sys.getPacientes().add(p1);
        sys.getPacientes().add(p2);
        sys.getPacientes().add(p3);
        sys.getPacientes().add(p4);

        Iterator iterador = sys.getPacientes().iterator();

        assertTrue(iterador.hasNext());
        assertEquals(p1, iterador.next());

        assertTrue(iterador.hasNext());
        assertEquals(p2, iterador.next());

        assertTrue(iterador.hasNext());
        assertEquals(p3, iterador.next());

        assertTrue(iterador.hasNext());
        assertEquals(p4, iterador.next());

        assertFalse(iterador.hasNext());
    }
  
    @Test
    public void testeBuscarPaciente() {
        sys.getPacientes().add(p1);
        sys.getPacientes().add(p2);
        sys.getPacientes().add(p3);
        sys.getPacientes().add(p4);

        Iterator iterador = sys.getPacientes().buscarPacientePorNome("Roberto");
        assertTrue(iterador.hasNext());
        assertEquals(p2, iterador.next());
        assertFalse(iterador.hasNext());

        iterador = sys.getPacientes().buscarPacientePorNome("a");
        assertTrue(iterador.hasNext());
        assertEquals(p1, iterador.next());
        assertTrue(iterador.hasNext());
        assertEquals(p3, iterador.next());
        assertTrue(iterador.hasNext());
        assertEquals(p4, iterador.next());
        assertFalse(iterador.hasNext());

        assertEquals(p4, sys.getPacientes().buscarPacientePorCPF("321.654.212-05"));

    }

    @Test
    public void testeAddOfertaSemanal() {
        sys.getOfertaSemanal().add(lote1);
        sys.getOfertaSemanal().add(lote2);
        sys.getOfertaSemanal().add(lote3);
        
        // verifica a quantidade de nós na lista e a quantidade do lote3
        assertEquals(3, sys.getOfertaSemanal().size());
        assertEquals(10, sys.getOfertaSemanal().get(2).getQuantidade());
        
        //adiciona o lote5 que difere apenas na quantidade do lote3
        sys.getOfertaSemanal().add(lote5);
        
        //verifica se o lote5 não foi adicionado e se a quantidade do lote5 foi somada ao lote3
        assertEquals(3, sys.getOfertaSemanal().size());
        assertEquals(15, sys.getOfertaSemanal().get(2).getQuantidade());

        //Retorna os respectivos lotes semanais ou OfertaSemanal.
        assertEquals(lote1, sys.getOfertaSemanal().get(0));
        assertEquals(lote2, sys.getOfertaSemanal().get(1));
        assertEquals(lote3, sys.getOfertaSemanal().get(2));
        
    }
    
    @Test
    public void testeprocurarOfertaSemanal() {
        sys.getOfertaSemanal().add(lote1);
        sys.getOfertaSemanal().add(lote2);
        sys.getOfertaSemanal().add(lote3);
        sys.getOfertaSemanal().add(lote4);

        assertNull(sys.getOfertaSemanal().procurarOferta(consulta2, "25/07/2019"));
        assertEquals(lote3, sys.getOfertaSemanal().procurarOferta(consulta2, "26/07/2019"));
        assertEquals(lote1, sys.getOfertaSemanal().procurarOferta(exame1, "22/07/2019"));

    }
      @Test
    public void testeIteradorAgendamento(){
        sys.getOfertaSemanal().add(lote1);
        sys.getOfertaSemanal().add(lote2);
        sys.getOfertaSemanal().add(lote3);
        sys.getOfertaSemanal().add(lote4);

        sys.getAgendamentos().addAgendamento(ag1, sys.getOfertaSemanal());
        sys.getAgendamentos().addAgendamento(ag2, sys.getOfertaSemanal());
        sys.getAgendamentos().addAgendamento(ag3, sys.getOfertaSemanal());
        
        Iterator iterador = sys.getAgendamentos().iterator();

        assertTrue(iterador.hasNext());
        assertEquals(ag1, iterador.next());

        assertTrue(iterador.hasNext());
        assertEquals(ag2, iterador.next());

        assertTrue(iterador.hasNext());
        assertEquals(ag3, iterador.next());

        assertFalse(iterador.hasNext());
    }

    @Test
    public void testeAddAgendamento() {
        sys.getOfertaSemanal().add(lote1);
        sys.getOfertaSemanal().add(lote2);
        sys.getOfertaSemanal().add(lote3);
        sys.getOfertaSemanal().add(lote4);

        assertEquals("Agendamento confirmado", sys.getAgendamentos().addAgendamento(ag1, sys.getOfertaSemanal()));

        assertEquals("Agendamento confirmado", sys.getAgendamentos().addAgendamento(ag2, sys.getOfertaSemanal()));

        assertEquals("Agendamento confirmado", sys.getAgendamentos().addAgendamento(ag3, sys.getOfertaSemanal()));

        assertEquals("Procedimento indisponível para a data escolhida", sys.getAgendamentos().addAgendamento(ag4, sys.getOfertaSemanal()));

        assertEquals("Procedimento esgotado", sys.getAgendamentos().addAgendamento(ag5, sys.getOfertaSemanal()));

        assertEquals(3, sys.getAgendamentos().size());
        assertEquals(ag1, sys.getAgendamentos().get(0));
        assertEquals(ag2, sys.getAgendamentos().get(1));
        assertEquals(ag3, sys.getAgendamentos().get(2));
    }

    @Test
    public void testeConfirmarPresenca() {

        sys.getOfertaSemanal().add(lote1);
        sys.getOfertaSemanal().add(lote2);
        sys.getOfertaSemanal().add(lote3);
        sys.getOfertaSemanal().add(lote4);

        //Adiciona na lista de agendamentos com base na oferta semanal.
        sys.getAgendamentos().addAgendamento(ag1, sys.getOfertaSemanal());
        sys.getAgendamentos().addAgendamento(ag2, sys.getOfertaSemanal());
        sys.getAgendamentos().addAgendamento(ag3, sys.getOfertaSemanal());

        assertEquals(3, sys.getAgendamentos().size());

        assertEquals(0, sys.getFilaDeEspera().size());

        sys.getAgendamentos().confirmarPresenca(ag1);
        assertEquals(ag1, sys.getFilaDeEspera().get(0));

        sys.getAgendamentos().confirmarPresenca(ag2);
        assertEquals(ag2, sys.getFilaDeEspera().get(0));

        sys.getAgendamentos().confirmarPresenca(ag3);
        assertEquals(ag3, sys.getFilaDeEspera().get(1));

        assertEquals(ag2, sys.getFilaDeEspera().get(0));
        assertEquals(ag3, sys.getFilaDeEspera().get(1));
        assertEquals(ag1, sys.getFilaDeEspera().get(2));

        assertEquals(3, sys.getFilaDeEspera().size());
        assertEquals(0, sys.getAgendamentos().size());
    
        assertEquals(ag1, sys.getHistorico().get(0));
        assertEquals(ag2, sys.getHistorico().get(1));
        assertEquals(ag3, sys.getHistorico().get(2));
        
        assertEquals(3,sys.getHistorico().size());
    }
    
    @Test
    public void testeListaDeEspera(){
        
        // Adiciona os lotes e adiciona os agendamentos na lista de agendamentos.
        sys.getOfertaSemanal().add(lote1);
        sys.getOfertaSemanal().add(lote2);
        sys.getOfertaSemanal().add(lote3);
        sys.getOfertaSemanal().add(lote4);

        sys.getAgendamentos().addAgendamento(ag1, sys.getOfertaSemanal());
        sys.getAgendamentos().addAgendamento(ag2, sys.getOfertaSemanal());
        sys.getAgendamentos().addAgendamento(ag3, sys.getOfertaSemanal());
        sys.getAgendamentos().addAgendamento(ag6, sys.getOfertaSemanal());
        
        assertEquals(4,sys.getAgendamentos().size());
        
       //Adiciona na Fila de Espera
       sys.getAgendamentos().confirmarPresenca(ag1);
       sys.getAgendamentos().confirmarPresenca(ag2);
       sys.getAgendamentos().confirmarPresenca(ag3);
       sys.getAgendamentos().confirmarPresenca(ag6);
       
       assertEquals(ag2, sys.getFilaDeEspera().get(0));
       assertEquals(ag3, sys.getFilaDeEspera().get(1));
       assertEquals(ag6, sys.getFilaDeEspera().get(2));
       assertEquals(ag1, sys.getFilaDeEspera().get(3));

       assertEquals(4, sys.getFilaDeEspera().size());
    
       //Retira da Fila de Espera para ser atendido
       assertEquals(p2, sys.getFilaDeEspera().proximoPaciente(exame1));
       assertNull(sys.getFilaDeEspera().proximoPaciente(exame1));
       assertEquals(3, sys.getFilaDeEspera().size());
       
       assertEquals(p6,sys.getFilaDeEspera().proximoPaciente(consulta2));
       assertNull(sys.getFilaDeEspera().proximoPaciente(consulta2));
       assertEquals(2, sys.getFilaDeEspera().size());
       
       assertEquals(p3, sys.getFilaDeEspera().proximoPaciente(exame2));
       assertNull(sys.getFilaDeEspera().proximoPaciente(exame2));
       assertEquals(1, sys.getFilaDeEspera().size());
       
       assertEquals(p1, sys.getFilaDeEspera().proximoPaciente(consulta1));
       assertNull(sys.getFilaDeEspera().proximoPaciente(consulta1));
       assertEquals(0, sys.getFilaDeEspera().size());
          
    }
    
    @Test
    public void testeIteradorHistorico() {
        sys.getOfertaSemanal().add(lote1);
        sys.getOfertaSemanal().add(lote2);
        sys.getOfertaSemanal().add(lote3);
        sys.getOfertaSemanal().add(lote4);

        sys.getAgendamentos().addAgendamento(ag1, sys.getOfertaSemanal());
        sys.getAgendamentos().addAgendamento(ag2, sys.getOfertaSemanal());
        sys.getAgendamentos().addAgendamento(ag3, sys.getOfertaSemanal());
        
        sys.getAgendamentos().confirmarPresenca(ag1);
        sys.getAgendamentos().confirmarPresenca(ag2);
        sys.getAgendamentos().confirmarPresenca(ag3);

        Iterator iterador = sys.getHistorico().iterator();

        assertTrue(iterador.hasNext());
        assertEquals(ag1, iterador.next());

        assertTrue(iterador.hasNext());
        assertEquals(ag2, iterador.next());

        assertTrue(iterador.hasNext());
        assertEquals(ag3, iterador.next());

        assertFalse(iterador.hasNext());

    }

    @Test
    public void testePesquisarHistorico(){
       // Adiciona na lista de agendamento
       
       sys.getOfertaSemanal().add(lote1);
        sys.getOfertaSemanal().add(lote2);
        sys.getOfertaSemanal().add(lote3);
        sys.getOfertaSemanal().add(lote4);

        sys.getAgendamentos().addAgendamento(ag1, sys.getOfertaSemanal());
        sys.getAgendamentos().addAgendamento(ag2, sys.getOfertaSemanal());
        sys.getAgendamentos().addAgendamento(ag3, sys.getOfertaSemanal());
        
       // Adiciona na lista do Historico
       sys.getAgendamentos().confirmarPresenca(ag1);
       sys.getAgendamentos().confirmarPresenca(ag2);
       sys.getAgendamentos().confirmarPresenca(ag3);

       // Teste de busca por paciente
        Iterator iterador = sys.getHistorico().procurarHistoricoPorPaciente(p1);
        assertTrue( iterador.hasNext() );
        assertEquals(ag1, iterador.next() );
        assertFalse( iterador.hasNext() );
        assertNull( iterador.next() );
        
        iterador = sys.getHistorico().procurarHistoricoPorPaciente(p2);
        assertTrue( iterador.hasNext() );
        assertEquals(ag2, iterador.next() );
        assertFalse( iterador.hasNext() );
        assertNull( iterador.next() );
        
        iterador = sys.getHistorico().procurarHistoricoPorPaciente(p3);
        assertTrue( iterador.hasNext() );
        assertEquals(ag3, iterador.next() );
        assertFalse( iterador.hasNext() );
        assertNull( iterador.next() );
      
        //Teste de busca por procedimento
        iterador = sys.getHistorico().procurarHistoricoPorProcedimento(  exame2 );
        assertTrue( iterador.hasNext() );
        assertEquals( ag3, iterador.next() );
        assertFalse( iterador.hasNext() );
        assertNull( iterador.next() );
       
        iterador = sys.getHistorico().procurarHistoricoPorProcedimento(  exame1 );
        assertTrue( iterador.hasNext() );
        assertEquals( ag2, iterador.next() );
        assertFalse( iterador.hasNext() );
        assertNull( iterador.next() );
       
       iterador = sys.getHistorico().procurarHistoricoPorProcedimento(consulta1);
       assertTrue( iterador.hasNext() );
      assertEquals( ag1, iterador.next() );
        assertFalse( iterador.hasNext() );
        assertNull( iterador.next() );

        
       //Teste de busca por Atendente
        // Atendente: Roseane
       iterador = sys.getHistorico().procurarHistoricoPorAtendente("Roseane");
       assertTrue( iterador.hasNext() );
      assertEquals( ag1, iterador.next() );
       
       assertTrue( iterador.hasNext() );
       assertEquals( ag3, iterador.next() );
       
        assertFalse( iterador.hasNext() );
        assertNull( iterador.next() );
        
        
       // Atendente : Marcos
       iterador = sys.getHistorico().procurarHistoricoPorAtendente("Marcos");
       assertTrue( iterador.hasNext() );
       assertEquals( ag2, iterador.next() );
       
        assertFalse( iterador.hasNext() );
        assertNull( iterador.next() );
 
       
       //Teste de busca por Medico
        // Medico: Francisco
       iterador = sys.getHistorico().procurarHistoricoPorMedico("Francisco");
       assertTrue( iterador.hasNext() );
       assertEquals( ag2, iterador.next() );
       
        assertFalse( iterador.hasNext() );
        assertNull( iterador.next() );
 
        // Medico: João
       iterador = sys.getHistorico().procurarHistoricoPorMedico("João");
       assertTrue( iterador.hasNext() );
       assertEquals( ag1, iterador.next() );
       
       assertTrue( iterador.hasNext() );
       assertEquals( ag3, iterador.next() ); 
       
       assertFalse( iterador.hasNext() );
       assertNull( iterador.next() );
 
       
      //Teste de busca por Data
        //Data : 22/07/2019
        iterador = sys.getHistorico().procurarHistoricoPorData("22/07/2019");
        assertTrue( iterador.hasNext() );
        assertEquals( ag1, iterador.next() );
        
        assertTrue( iterador.hasNext() );
        assertEquals( ag2, iterador.next() );
        
        assertFalse( iterador.hasNext() );
        assertNull( iterador.next() );
        
        //Data : 27/07/2019
        iterador = sys.getHistorico().procurarHistoricoPorData("27/07/2019");
        assertTrue( iterador.hasNext() );
        assertEquals( ag3, iterador.next() );
       
        assertFalse( iterador.hasNext() );
        assertNull( iterador.next() ); 

    }
    
    
    
    /**
     * Teste de unidade para pacientes ausentes.
     */
   @Test
    public void testePacientesAusentes() {

        sys.getOfertaSemanal().add(lote1);
        sys.getOfertaSemanal().add(lote2);
        sys.getOfertaSemanal().add(lote3);
        sys.getOfertaSemanal().add(lote4);

        sys.getAgendamentos().addAgendamento(ag1, sys.getOfertaSemanal());
        sys.getAgendamentos().addAgendamento(ag2, sys.getOfertaSemanal());
        sys.getAgendamentos().addAgendamento(ag3, sys.getOfertaSemanal());

        assertEquals(3, sys.getAgendamentos().size());

        Iterator iterador = sys.getAgendamentos().getPacientesAusentes("22/07/2019");

        assertTrue(iterador.hasNext());
        assertEquals(p1, iterador.next());
        assertTrue(iterador.hasNext());
        assertEquals(p2, iterador.next());
        assertFalse(iterador.hasNext());

        sys.getAgendamentos().confirmarPresenca(ag2);

        iterador = sys.getAgendamentos().getPacientesAusentes("22/07/2019");
        assertTrue(iterador.hasNext());
        assertEquals(p1, iterador.next());
        assertFalse(iterador.hasNext());

    }

}
