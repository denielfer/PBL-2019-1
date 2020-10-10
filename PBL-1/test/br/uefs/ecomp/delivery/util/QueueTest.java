/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.delivery.util;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author angelo
 */
public class QueueTest {
    IQueue queue;
    Object data1, data2, data3;

    /**
     * Este método é executado antes de cada teste de unidade (testes a seguir), 
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp(){
        queue = new MyQueue();
        data1 = 1;
        data2 = 2;
        data3 = 3;
    }    

    /**
     * Teste de unidade que verifica se a inserção de objetos na fila está
     * ocorrendo de forma correta, e verifica o tamanho da fila.
     */
    @Test
    public void testEnqueue(){
        queue.enqueue(data1);
        assertEquals(data1, queue.peek());
        assertEquals(data1, queue.last());
        assertEquals(1, queue.size());
        
        queue.enqueue(data2);
        assertEquals(data1, queue.peek());
        assertEquals(data2, queue.last());
        assertEquals(2, queue.size());
        
        queue.enqueue(data3);
        assertEquals(data1, queue.peek());
        assertEquals(data3, queue.last());
        assertEquals(3, queue.size());
    }
    
    /**
     * Teste de unidade que verifica se a remoção está correta.
     */
    @Test    
    public void testDequeue() {
        queue.enqueue(data1);
        queue.enqueue(data2);
        queue.enqueue(data3);
        assertEquals(3, queue.size());
        
        assertEquals(data1, queue.dequeue());
        assertEquals(2, queue.size());
        
        assertEquals(data2, queue.dequeue());
        assertEquals(1, queue.size());
        
        assertEquals(data3, queue.dequeue());
        assertEquals(0, queue.size());
    }                
    
    /**
     * Teste de unidade que verifica se a fila está vazia ou não.
     */
    @Test
    public void testisEmpty() {
        assertTrue(queue.isEmpty());

        queue.enqueue(data1);
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }        
}
