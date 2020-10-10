/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import model.*;
import java.util.Date;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thiago Cardozo e Daniel Fernandes
 */
public class FilaPrioridadeTeste {
    
    FilaEspera fila;
    Paciente p1;
    Paciente p2;
    Paciente p3;
    Paciente p4;
    Procedimento exame2;
    Agendamento a1; //maior prioridade
    Agendamento a2; // prioridade igual ao a3
    Agendamento a3; // prioridade igual ao a2
    Agendamento a4; //menor prioridade

    /**
     * Este método é executado antes de cada teste de unidade (testes a seguir), 
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp(){
        fila = new FilaEspera();
        p1 = new Paciente("nome1","cpf1", "telefone1","s");
        p2 = new Paciente("nome2","cpf2", "telefone2","s");
        p3 = new Paciente("nome3","cpf3", "telefone3","s");
        p4 = new Paciente("nome4","cpf4", "telefone4","S");
        exame2 = new Exame("Paula","SC10", "Hemograma", "Sem recomendações", "Sem restrições");
        a1 = new Agendamento("João",p1,exame2,new Date(),"27/07/2019",5); //maior prioridade
        a2 = new Agendamento("João",p2,exame2,new Date(),"27/07/2019",3); // prioridade igual ao a3
        a3 = new Agendamento("João",p3,exame2,new Date(),"27/07/2019",3); // prioridade igual ao a2
        a4 = new Agendamento("João",p4,exame2,new Date(),"27/07/2019",1); //menor prioridade
    }    

    /**
     * Teste de unidade que verifica se a inserção de objetos na lista está
     * ocorrendo de forma correta.
     */
    @Test
    public void testInsert(){
        assertEquals(0, fila.size());

        fila.add(a4);
        assertEquals(1, fila.size());

        fila.add(a3);
        assertEquals(2, fila.size());

        fila.add(a2);
        assertEquals(3, fila.size());
        
        fila.add(a1);
        assertEquals(4, fila.size());
       
        assertEquals(a1, fila.get(0));
        assertEquals(a3, fila.get(1));
        assertEquals(a2, fila.get(2));
        assertEquals(a4, fila.get(3));
         
        assertEquals(4, fila.size());
    }
    
    /**
     * Teste de unidade que verifica se os dados presentes na lista estão sendo
     * recuperados corretamente.
     */
    @Test    
    public void testGet() {
        fila.add(a1);
        fila.add(a2);
        fila.add(a3);
        fila.add(a4);
        
        assertEquals(a1, fila.get(0));
        assertEquals(a2, fila.get(1));
        assertEquals(a3, fila.get(2));       
        assertEquals(a4, fila.get(3));       
    }
    
    /**
     * Teste de unidade que verifica se a remoção de objetos na lista está sendo
     * feita corretamente.
     */
    @Test
    public void testDelete(){
        assertNull(fila.remove(0));
        assertNull(fila.remove(1));
        
        fila.add(a4);
        fila.add(a3);
        fila.add(a2);
        fila.add(a1);
        
        assertEquals(4, fila.size());
        
        assertEquals(a3, fila.remove(1));
        assertEquals(3, fila.size());

        assertEquals(a2, fila.remove(1));
        assertEquals(2, fila.size());

        assertNull(fila.remove(2));
        assertEquals(2, fila.size());
        
        assertEquals(a1, fila.remove(0));
        assertEquals(1, fila.size());
        
        assertEquals(a4, fila.remove(0));
        assertEquals(0, fila.size());
        
        assertTrue(fila.isEmpty());
    }
    
    /**
     * Teste de unidade que verifica se os métodos de inserção e remoção de objetos 
     * na lista estão funcionando corretamente.
     */
    @Test
    public void testInsertDelete() {
        
        assertTrue(fila.isEmpty());
        
        fila.add(a2);
        assertFalse(fila.isEmpty());
        assertEquals(a2, fila.remove(0));
        assertTrue(fila.isEmpty());
        
        fila.add(a3);
        assertFalse(fila.isEmpty());
        assertEquals(a3, fila.remove(0));
        assertTrue(fila.isEmpty());

        fila.add(a1);
        assertFalse(fila.isEmpty());
        assertEquals(a1, fila.remove(0));
        assertTrue(fila.isEmpty());

        fila.add(a4);
        assertFalse(fila.isEmpty());
        assertEquals(a4, fila.remove(0));
        assertTrue(fila.isEmpty());
    }
    
    /**
     * Teste de unidade que verifica se a lista está vazia ou não.
     */
    @Test
    public void testisEmpty() {
        assertTrue(fila.isEmpty());
        fila.add(a1);
        assertFalse(fila.isEmpty());
        fila.remove(0);
        assertTrue(fila.isEmpty());
    }
    
    /**
     * Teste de unidade que verifica o tamanho da lista antes e após inserções 
     * e remoções.
     */
    @Test
    public void testSize() {
        assertEquals(0, fila.size());

        fila.add(a1);
        assertEquals(1, fila.size());

        fila.add(a2);
        assertEquals(2, fila.size());
        fila.add(a3);
        assertEquals(3, fila.size());
        fila.add(a4);
        assertEquals(4, fila.size());

        fila.remove(0);
        assertEquals(3, fila.size());

        fila.remove(0);
        assertEquals(2, fila.size());
        fila.remove(0);
        assertEquals(1, fila.size());
        fila.remove(0);
        assertEquals(0, fila.size());
    }

    /**
     * Teste de unidade que verifica se o método iterator está listando os
     * objetos corretamente.
     */
    @Test
    public void testIterator() {
        Iterator it = fila.iterator();
        assertFalse(it.hasNext());

        fila.add(a1);
        fila.add(a2);
        fila.add(a3);
        fila.add(a4);

        it = fila.iterator();
        assertTrue(it.hasNext());
        assertEquals(a1, it.next());
        assertTrue(it.hasNext());
        assertEquals(a2, it.next());
        assertTrue(it.hasNext());
        assertEquals(a3, it.next());
        assertTrue(it.hasNext());
        assertEquals(a4, it.next());
        assertFalse(it.hasNext());
        assertNull(it.next());
    }
    // Neste teste sera testado se o remove funciona coretamente dos index 3 para 0
    
    @Test
    public void removeFourIndex(){
        fila.add(a1);
        fila.add(a2);
        fila.add(a3);
        fila.add(a4);
        
        assertEquals(a4, fila.remove(3));
        assertEquals(a3, fila.remove(2));
        assertEquals(a2, fila.remove(1));
        assertEquals(a1, fila.remove(0));
        
        
    }
    /* Neste teste sera adicio ado agendamentos em ordem de prioridade invertida
       e em seguida sera pego um iterator para percorer a fila e verificar se 
       ela esta na ordem certa
    */
    @Test
    public void prioryteTest(){
        Iterator it ;
        
        fila.add(a4);
        it = fila.iterator();
        assertTrue(it.hasNext());
        assertEquals(a4, it.next());
        assertFalse(it.hasNext());
        assertNull(it.next());
        
        fila.add(a2);
        it = fila.iterator();
        assertTrue(it.hasNext());
        assertEquals(a2, it.next());
        assertTrue(it.hasNext());
        assertEquals(a4, it.next());
        assertFalse(it.hasNext());
        assertNull(it.next());
        
        fila.add(a1);
        it = fila.iterator();
        assertTrue(it.hasNext());
        assertEquals(a1, it.next());
        assertTrue(it.hasNext());
        assertEquals(a2, it.next());
        assertTrue(it.hasNext());
        assertEquals(a4, it.next());
        assertFalse(it.hasNext());
        assertNull(it.next());
        
        fila.add(a3);
        it = fila.iterator();
        assertTrue(it.hasNext());
        assertEquals(a1, it.next());
        assertTrue(it.hasNext());
        assertEquals(a2, it.next());
        assertTrue(it.hasNext());
        assertEquals(a3, it.next());
        assertTrue(it.hasNext());
        assertEquals(a4, it.next());
        assertFalse(it.hasNext());
        assertNull(it.next());
        
        
        // Daqui para baixo é chamado proximo paciente e chama iterator
        
        assertEquals(p1, fila.proximoPaciente(exame2));
        it = fila.iterator();
        assertTrue(it.hasNext());
        assertEquals(a2, it.next());
        assertTrue(it.hasNext());
        assertEquals(a3, it.next());
        assertTrue(it.hasNext());
        assertEquals(a4, it.next());
        assertFalse(it.hasNext());
        assertNull(it.next());
      
        assertEquals(p2, fila.proximoPaciente(exame2));
        it = fila.iterator();
        assertTrue(it.hasNext());
        assertEquals(a3, it.next());
        assertTrue(it.hasNext());
        assertEquals(a4, it.next());
        assertFalse(it.hasNext());
        assertNull(it.next());
        
        assertEquals(p3, fila.proximoPaciente(exame2));
        it = fila.iterator();
        assertTrue(it.hasNext());
        assertEquals(a4, it.next());
        assertFalse(it.hasNext());
        assertNull(it.next());
        
        assertEquals(p4, fila.proximoPaciente(exame2));
        it = fila.iterator();
        assertFalse(it.hasNext());
        assertNull(it.next());
        
        assertNull(fila.proximoPaciente(exame2));
    }
    
}
