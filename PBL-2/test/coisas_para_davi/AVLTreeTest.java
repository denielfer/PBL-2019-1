
package coisas_para_davi;

import org.junit.*;

/**
 *
 * @author dfc15
 */
public class AVLTreeTest {
    AVLTree tree; 
    @Before
    public void setUp(){
        tree = new MyAVLTree();
        tree.raiz = tree.inserir(tree.raiz, 5); 
        tree.raiz = tree.inserir(tree.raiz, 9); 
        tree.raiz = tree.inserir(tree.raiz, 1); 
        tree.raiz = tree.inserir(tree.raiz, 7); 
        tree.raiz = tree.inserir(tree.raiz, 10); 
        tree.raiz = tree.inserir(tree.raiz, -5); 
        tree.raiz = tree.inserir(tree.raiz, 2); 
        tree.raiz = tree.inserir(tree.raiz, 4); 
        tree.raiz = tree.inserir(tree.raiz, 6); 
    }
    
    public void testPack(){
        Assert.assertEquals(5, tree.raiz.chave);
        Assert.assertEquals(9, tree.raiz.direita.chave);
        Assert.assertEquals(10, tree.raiz.direita.direita.chave);
        Assert.assertEquals(7, tree.raiz.direita.esquerda.chave);
        Assert.assertEquals(6, tree.raiz.direita.esquerda.esquerda.chave);
        Assert.assertEquals(1, tree.raiz.esquerda.chave);
        Assert.assertEquals(-5, tree.raiz.esquerda.esquerda.chave);
        Assert.assertEquals(2, tree.raiz.esquerda.direita.chave);
        Assert.assertEquals(4, tree.raiz.esquerda.direita.direita.chave);
    }
}
