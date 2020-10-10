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
package model;

import Model.Computador;
import Model.Imagem;
import Excptions.DuplicateKeyUsedException;
import Excptions.InsufficientMemoryExceptrion;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;

public class ComputadorTest {
    Computador pc;
    Imagem img1;
    Imagem img2;
    Imagem img3;
    Imagem img1fake;
    Imagem img4;
    
    @Before
    public void setUp(){
        pc = new Computador("computador",100);
        img1 = new Imagem("imagem1", 50);
        img2 = new Imagem("imagem2", 25);
        img3 = new Imagem("imagem3", 10);
        img1fake = new Imagem("imagem1", 10);
        img4 = new Imagem("imagem4", 30);
        
    }
    
    @Test
    public void add(){
      // como nao tem imagens adicionadas espera-se que o tamanho livre seja igual o tamanho total
        Assert.assertEquals(pc.getTamanho(), pc.getFreeEspace(), 0.001);
        // verifica se o tamanho da arvore no {pc} é 0
        Assert.assertEquals(0, this.pc.getImagens().getNumElementos());
        try{// adiciona 3 imagens somando 85 de tamanho
            pc.storageImagem(img1);
            pc.storageImagem(img2);
            pc.storageImagem(img3);
        }catch(InsufficientMemoryExceptrion | DuplicateKeyUsedException e){// nao deve entra aqui entao se entra é erro
            Assert.assertTrue(false);
        }  
        // verifica se o tamanho da arvore no {pc} foi almentado em 3, 
        //usado para considera que as imagens foram adicionadas, considerando 
        //que o teste de arvore foi feito previamente e passado
        Assert.assertEquals(3, this.pc.getImagens().getNumElementos());
        // nao deve entra aqui entao se entra é erro
        Assert.assertEquals(15, pc.getFreeEspace(), 0.001);
       
       // os procimos 2 trys sao tentantivas de adiciona imagens que devem falhar 
       // e lança exceptions, por isso tem que ser feitos separados, pois quando a
       // exception é lançada o resto do try nao é executada
        try{// INICIO DO BLOCO
           pc.storageImagem(img1fake);
       // entra no catch aqui em baixo pois o nome da {img1fake} é igual ao da {img1}
       }catch(DuplicateKeyUsedException e){ 
           Assert.assertTrue(true);
       }catch(InsufficientMemoryExceptrion e){// nao deve entra aqui entao se entra é erro
            Assert.assertTrue(false);
       }
       try{
           pc.storageImagem(img4);
       }catch(DuplicateKeyUsedException e){// nao deve entra aqui entao se entra é erro
           Assert.assertTrue(false);
  // entra nesse catch aqui abaixo pois a imagem exige mais espaço do que o {pc} tem de espaço livre
       }catch(InsufficientMemoryExceptrion e){
            Assert.assertTrue(true);
       }//Fim do bloco
       
         // verifica se o tamanho da arvore no {pc} nao foi modificado nas tentativas
        //falha de adicionar uma imagem
        Assert.assertEquals(3, this.pc.getImagens().getNumElementos());
        // verifica se o tamanho livre nao mudo nas tentativas falhas de adicionar
       Assert.assertEquals(15, pc.getFreeEspace(), 0.001);
    }
    @Test
    public void remove(){
        // como nao tem imagens adicionadas espera-se que o tamanho livre seja igual o tamanho total
        Assert.assertEquals(pc.getTamanho(), pc.getFreeEspace(), 0.001);
        try{ 
            pc.storageImagem(img1);
            pc.storageImagem(img2);
            pc.storageImagem(img3);
        }catch(InsufficientMemoryExceptrion | DuplicateKeyUsedException e){// nao deve entra aqui entao se entra é erro
            Assert.assertTrue(false);
        }
        // nao deve entra aqui entao se entra é erro
        Assert.assertFalse(pc.removeImagem("imagem4"));// tentando remover imagem que nao existe
        // verifica se o tamanho livre nao almento pois nao houve imagens removidas
        Assert.assertEquals(15, pc.getFreeEspace(), 0.001);        
        // temta remover{img3}
        Assert.assertTrue(pc.removeImagem("imagem3"));
        // verifica se o tamanho livre almento no esperado
        Assert.assertEquals(25, pc.getFreeEspace(), 0.001);
        // temta remover{img1}
        Assert.assertTrue(pc.removeImagem("imagem1"));
        // verifica se o tamanho livre almento no esperado
        Assert.assertEquals(75, pc.getFreeEspace(), 0.001);
        // temta remover{img2}
        Assert.assertTrue(pc.removeImagem("imagem2"));
        // verifica se o tamanho livre almento no esperado
        Assert.assertEquals(100, pc.getFreeEspace(), 0.001);
    }
    @Test
    public void add_remove(){
    try{ 
            pc.storageImagem(img1);
        }catch(InsufficientMemoryExceptrion | DuplicateKeyUsedException e){// nao deve entra aqui entao se entra é erro
            Assert.assertTrue(false);
        }
        // nao deve entra aqui entao se entra é erro
    Assert.assertEquals(50, pc.getFreeEspace(), 0.001);
    
    Assert.assertTrue(pc.removeImagem("imagem1"));
    
    Assert.assertEquals(100, pc.getFreeEspace(), 0.001);
    
    try{ 
            pc.storageImagem(img2);
        }catch(InsufficientMemoryExceptrion | DuplicateKeyUsedException e){// nao deve entra aqui entao se entra é erro
            Assert.assertTrue(false);
        }
        // nao deve entra aqui entao se entra é erro
    Assert.assertEquals(75, pc.getFreeEspace(), 0.001);
            
    Assert.assertTrue(pc.removeImagem("imagem2"));
            
    Assert.assertEquals(100, pc.getFreeEspace(), 0.001);
    }
}