/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Daniel Fernandes Campos e Esdras Evangelista de sena santos
 * Data: 18/08/2019
 *
 * Testes de Angelo Lola do PBL 1 modificados para Prioriry Queue com generics, de chave numerica
 */
package util;

import Util.EstruturaDeDados.IteratorMyPriorityQueue;
import Util.EstruturaDeDados.MyPriorityQueue;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class MyPriorityQueueTest {
    MyPriorityQueue<Object> list;
    Object data1, data2, data3;

    /**
     * Este método é�executado antes de cada teste de unidade (testes a seguir), 
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp(){
        list = new MyPriorityQueue<>();
        data1 = 1;
        data2 = 2;
        data3 = 3;
    }
    
    /**
     * Teste de unidade que verifica se a inserção de objetos na lista está
     * ocorrendo de forma correta.
     */
    @Test
    public void testInsert(){
        Assert.assertEquals(0, list.size());

        list.queue(data1, 1);
        Assert.assertEquals(1, list.size());

        list.queue(data2, 2);
        Assert.assertEquals(2, list.size());

        list.queue(data3, 3);
        Assert.assertEquals(3, list.size());
        
       IteratorMyPriorityQueue<Object> it = list.iterator();
        Assert.assertEquals(data3, it.next());
        Assert.assertEquals(data2, it.next());
        Assert.assertEquals(data1, it.next());
         
        Assert.assertEquals(3, list.size());
    }
    
    /**
     * Teste de unidade que verifica se a remoção de objetos na lista está sendo
     * feita corretamente.
     */
    @Test
    public void testDelete(){
        Assert.assertNull(list.deQueue());
        Assert.assertNull(list.deQueue());
        
        list.queue(data1, 1);
        list.queue(data2, 3);
        list.queue(data3, 2);
        
        Assert.assertEquals(data2, list.deQueue());
        Assert.assertEquals(2, list.size());

        Assert.assertEquals(data3, list.deQueue());
        Assert.assertEquals(1, list.size());
        
        Assert.assertEquals(data1, list.deQueue());
        Assert.assertEquals(0, list.size());
        
        Assert.assertTrue(list.isEmpty());
    }
    
    /**
     * Teste de unidade que verifica se os métodos de inserção e remoção de objetos 
     * na lista estão funcionando corretamente.
     */
    @Test
    public void testInsertDelete() {
        list.queue(data1, 2);
        list.queue(data2, 1);
        list.queue(data3 ,3);
        Assert.assertFalse(list.isEmpty());

        Assert.assertEquals(data3, list.deQueue());
        Assert.assertFalse(list.isEmpty());

        Assert.assertEquals(data1, list.deQueue());
        Assert.assertFalse(list.isEmpty());
        
        Assert.assertEquals(data2, list.deQueue());
        Assert.assertTrue(list.isEmpty());
    }
    
    /**
     * Teste de unidade que verifica se a lista está vazia ou não.
     */
    @Test
    public void testisEmpty() {
        Assert.assertTrue(list.isEmpty());
        list.queue(data1, 1);
        Assert.assertFalse(list.isEmpty());
        list.deQueue();
        Assert.assertTrue(list.isEmpty());
    }
    
    /**
     * Teste de unidade que verifica o tamanho da lista antes e após inserções 
     * e remoções.
     */
    @Test
    public void testSize() {
        Assert.assertEquals(0, list.size());

        list.queue(data1, 3);
        Assert.assertEquals(1, list.size());

        list.queue(data2, 2);
        list.queue(data3, 1);
        Assert.assertEquals(3, list.size());

        list.deQueue();
        Assert.assertEquals(2, list.size());

        list.deQueue();
        list.deQueue();
        Assert.assertEquals(0, list.size());
    }

    /**
     * Teste de unidade que verifica se o método iterator está listando os
     * objetos corretamente.
     */
    @Test
    public void testIterator() {
        IteratorMyPriorityQueue<Object> it = list.iterator();
         Assert.assertFalse(it.hasNext());

        list.queue(data1, 3);
        list.queue(data2, 2);
        list.queue(data3, 1);
        it = list.iterator();
        Assert.assertTrue(it.hasNext());
        Assert.assertEquals(data1, it.next());
        Assert.assertTrue(it.hasNext());
        Assert.assertEquals(data2, it.next());
        Assert.assertTrue(it.hasNext());
        Assert.assertEquals(data3, it.next());
        Assert.assertFalse(it.hasNext());
    }
}
