/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Daniel Fernandes Campos e Esdras Evangelista de sena santos
 * Data: 18/08/2019
 *
 * Declaro que este código foi elaborado pela dupla de forma individual e
 * não contém nenhum trecho de código de outro colega ou de outro autor,
 * tais como provindos de livros e apostilas, e páginas ou documentos
 * eletrônicos da Internet. Qualquer trecho de código de outra autoria que
 * uma citação para o  não a minha está destacado com  autor e a fonte do
 * código, e estou ciente que estes trechos não serão considerados para fins
 * de avaliação. Alguns trechos do código podem coincidir com de outros
 * colegas pois estes foram discutidos em sessões tutorias.
 */
package util;

import Util.NodeTree;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class NodeTreeTest {
    NodeTree<Object> no;
    Object data;
    @Before
    public void setUp(){
        data  = 1;
        no = new NodeTree<>( data, "Key" );
    }
    @Test
    public void getTest(){
        Assert.assertSame(data , no.getContent());
        Assert.assertNull( no.getLeft() );
        Assert.assertNull( no.getRight() );
        Assert.assertEquals( 1, no.getAltura() );
        Assert.assertEquals("Key", no.getChave());
    }
    @Test
    public void setTest(){
        no.setAltura(0);
        Assert.assertEquals(0, no.getAltura());
        Object data2 = 10;
        no.setContent(data2);
        Assert.assertSame(data2 , no.getContent());
        Assert.assertNull( no.getLeft() );
        no.setLeft(no);
        Assert.assertSame( no ,no.getLeft() );
        Assert.assertNull( no.getRight() );
        no.setRight(no);
        Assert.assertSame( no ,no.getLeft() );
        no.setChave("ola");
        Assert.assertEquals("ola", no.getChave());
        
        
        
    }
    
}
