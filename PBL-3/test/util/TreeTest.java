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

import Excptions.DuplicateKeyUsedException;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import Util.MyAVLTree;

public class TreeTest {
    Object o1;
    Object o2;
    Object o3;
    Object o4;
    Object o5;
    Object o1N;
    Object o0;
    Object o2N;
    Object o;
    Object o123;
    Object o321;
    Object o213;
    MyAVLTree<Object> arvore;
   @Before
    public void setUp(){
        this.arvore = new MyAVLTree<>();
        this.
        o1 =1;
        o2 =2;
        o3 =3;
        o4 =4;
        o5 =5;
        o1N = -1;
        o0 = 0;
        o2N = -2;
    }
    @Test
    public void addAndFindTest() throws Exception{
        try {// Add teste
            arvore.add(o1, "aaa");
            arvore.add(o2, "aab");
            arvore.add(o3, "aac");// rodação
            arvore.add(o4, "aad");//    a
            arvore.add(o5, "aae");// direita
            arvore.add(o0, "aaf"); // rotaçao 
            arvore.add(o1N, "aag");// a esquerda
        } catch (DuplicateKeyUsedException ex) {
            // Essa condiçao so vai entra se der erro de chave duplicado porém
            //como nao ha chaves duplicadas essa falha so acontecera em caso de
            // erro de implementaçao do throw
            Assert.assertTrue(false);
            // considera-se que passou caso o assert acima nao seja ativado
        }
        //Teste de Find
        System.out.println("Print arvore em addTeste:");
        arvore.printTree();
        Object o1f = arvore.find("aaa");
        Object o2f = arvore.find("aab");
        Object o3f = arvore.find("aac");
        Object o4f = arvore.find("aad");
        Object o5f = arvore.find("aae");
        Assert.assertEquals(o1, o1f);
        Assert.assertEquals(o2, o2f);
        Assert.assertEquals(o3, o3f);
        Assert.assertEquals(o4, o4f);
        Assert.assertEquals(o5, o5f);
        //Teste de chaves repitidas
        try {
            arvore.add(o3, "aaa");
        } catch (DuplicateKeyUsedException ex) {
            // Essa condiçao so vai entra se der erro de chave duplicado então
            //como ha chaves duplicadas essa falha assim testamos o throw excpetion
            Assert.assertTrue(true);
        }
        
    }
    @Test
    public void removeTest(){
        try {
            arvore.add(o1, "aaa");
            arvore.add(o2, "aab");
            arvore.add(o3, "aac");
            arvore.add(o4, "aad");
            arvore.add(o5, "aae");
            arvore.add(o0, "aaf"); 
            arvore.add(o1N, "aag");
        } catch (DuplicateKeyUsedException ex) {
            // Essa condiçao so vai entra se der erro de chave duplicado porém
            //como nao ha chaves duplicadas essa falha so acontecera em caso de
            // erro de implementaçao do throw
            Assert.assertTrue(false);
        }
        System.out.println("Print arvore em removeTeste Inicial:");
        arvore.printTree();

        Assert.assertTrue( arvore.remove("aaa") ); // remove folha
        Assert.assertNull(arvore.find("aaa"));

        try {
            arvore.add(o1, "aaa");
        } catch (DuplicateKeyUsedException ex) {
            // Essa condiçao so vai entra se der erro de chave duplicado porém
            //como nao ha chaves duplicadas essa falha so acontecera em caso de
            // erro de implementaçao do throw
            Assert.assertTrue(false);
        }

        Assert.assertTrue( arvore.remove("aaf") ); // no com 2 filhos
        Assert.assertNull(arvore.find("aaf"));

        Assert.assertTrue( arvore.remove("aae") ); // remove no com 1 filho
        Assert.assertNull(arvore.find("aae"));

        Assert.assertTrue( arvore.remove("aab") ); // remove no com 2 filhos
        Assert.assertNull(arvore.find("aab"));

        Assert.assertTrue( arvore.remove("aac") );
        Assert.assertNull(arvore.find("aac"));

        Assert.assertTrue( arvore.remove("aaa") );
        Assert.assertNull(arvore.find("aaa"));
        System.out.println("Print arvore em addTeste FINAL:");
        arvore.printTree();
    } 
}
