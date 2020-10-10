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
package SystemTest;

import Excptions.DuplicateKeyUsedException;
import Excptions.InsufficientMemoryExceptrion;
import Excptions.NoComputerRegisteredException;
import Excptions.SystemOFFException;
import Model.*;
import Util.*;

import System.MainControler;
import System.filesGenerator;
import java.io.IOException;
import java.util.Random;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainControlerTest {
    MainControler system = new MainControler();
    int numeroComputadores ; 
    int numeroImagens ;
    
    @Before
    public void setUp(){
        filesGenerator gen = new filesGenerator();
        // é gerado antes de cada teste um numero aleatorio de 10 a 20 computadores
        // e um numero aleatorio de 1000 a 1100 imagens. o numero de computadores é
        // relativamente grande pra na aleatoriedade nao acontecer de usar todo o
        // espaço disponivel nos computadores e dar erro por haver mais imagens do
        // que o suportado, fato que é testado especificamente no teste de computador
        numeroComputadores = new Random().nextInt(10)+10;
        numeroImagens = new Random().nextInt(1000)+1000;
        try{
            gen.generateComputadorX(numeroComputadores);
        }catch( IOException e ){
            System.out.println(e.getMessage());
            Assert.assertTrue(false);// caso haja problemas na confecçao dos arquivo
        }
        try{
            gen.generateIMGX(numeroImagens);
        }catch( IOException e ){
            System.out.println(e.getMessage());
            Assert.assertTrue(false);// caso haja problemas na confecçao dos arquivo
        }
    }
    @Test
    // teste de inicializar e finalizar sistema
    public void inicializarTest(){
        Assert.assertFalse(this.system.isIsOn());
        this.system.Inicializar();
        Assert.assertTrue(this.system.isIsOn());
        IteratorMyPriorityQueue<Computador> itC = this.system.getPcQueue().iterator();
        int cont = 0;
        while( itC.hasNext() ){
            itC.next();
            cont++;
        }
        Assert.assertEquals(this.numeroComputadores, cont);
        Assert.assertEquals(this.numeroImagens, this.system.getRegistrosTree().getNumElementos());
        this.system.finesh();
    }
    @Test
    // as exceptions nao serao jogada pois os sitema foi inicializado e existe memoria suficioente para adiciona a procima imagem e sua chave é unica
    // Teste de adicionar remover e buscar para imagens e computadores
    public void adiciona_Remover__Imagem_ComputadorTest() throws SystemOFFException, InsufficientMemoryExceptrion, DuplicateKeyUsedException{ 
    // Nota : Durantes testes feitos ocoreram falhas inconsistentes em passar por esse teste
    //        a falha acontecia na linha 118 mas quando colocando pra rodar novamente 
    //        passava sem apresentar erros
        this.system.Inicializar();
      
    // verifica se o numeros de computadores na estrutura é o esperado
        Assert.assertEquals(this.numeroComputadores, this.system.getPcQueue().size() );
     
        try {
            // adiciona 1 computador e ve se o numero subio em 1
            this.system.addComputer(("Computador"+this.numeroComputadores+1),( new Random().nextInt(139)+1 )*100);
        } catch (IOException ex) {
            // erro nao esperado, logo esse assert so acontecera se algo errado acontecer
            Assert.assertTrue(false);
        }
        this.numeroComputadores++;
        Assert.assertEquals(this.numeroComputadores, this.system.getPcQueue().size() );
        
    //Verifica se qundo desliga e liga o sistema o computador adicionado fica salvo
        this.system.finesh();
        this.system.Inicializar();
        Assert.assertEquals(this.numeroComputadores, this.system.getPcQueue().size() );
        
    // verifica se o numero de imagens na estrutura é o esperado
        Assert.assertEquals(this.numeroImagens, this.system.getRegistrosTree().getNumElementos() );
       
    //adiciona 1 imagem e ve se o numero modifico em 1 e se é pocivel entrontra-la
        Computador pc = this.system.getPcQueue().getFist(); // salva o computador que recebera a procima imagem
        float pcEspaçoLivreAntesDeAdicionar = pc.getFreeEspace();
        this.system.addImagem(("img"+(this.numeroImagens+1)), new Random().nextInt(50)+1);// adiciona imagem
        Assert.assertEquals(this.numeroImagens+1, this.system.getRegistrosTree().getNumElementos() ); // verifica se o numero de Registros somo 1
        Imagem img = pc.getImagens().find(("img"+(this.numeroImagens+1))); // pede ao computador salvo acima para procura a imagem salva  
        Assert.assertNotNull(img);// verifica se o resultado da presquisa nao é null. ou seja, acho uma imagem
        Assert.assertEquals(("img"+(this.numeroImagens+1)), img.getName()); // e se o nome da imagem achada é o nome da que foi adicionada
  
    //Remoçao e busca de imagem
        Assert.assertEquals(pc, this.system.buscarImagem(("img"+(this.numeroImagens+1))) ); // verifica se a imagem adicionada esta na arvore de registros e se o computador associado é o computador esperado
        this.system.excluirImagem(("img"+(this.numeroImagens+1)));// remove a imagem que foi adicionada acima
        Assert.assertEquals(this.numeroImagens, this.system.getRegistrosTree().getNumElementos() );// verifica se o numero de registro salvos foi alterado
        Assert.assertEquals(pcEspaçoLivreAntesDeAdicionar, pc.getFreeEspace()); // verifica se retirou o espaço que a imagem ocupava do computador
        Assert.assertEquals(pc,this.system.getPcQueue().getFist() ); // verifica se o computador salvo volto a ser o primeiro a recever imagem
    
         // remove a arvore inteira
        for( int i = this.numeroImagens; i>0; i-- ){
            this.system.excluirImagem( ("img"+i) );
            Assert.assertFalse(this.system.getRegistrosTree().find(("img"+i)) != null);
            if( i > 1 )
                Assert.assertNotNull(this.system.getRegistrosTree().find( ( "img"+(i-1) ) ) );
        }
        // Verifica se o tamanho livre de cada computador é igual a sua capacidade total de armazenamento
        for(int i=0; i < this.numeroComputadores; i++){   
            pc = this.system.getPcQueue().deQueue();
            Assert.assertEquals(pc.getTamanho(), pc.getFreeEspace());
        }
        this.system.finesh(); 
    }
    //Testes de listagem
    @Test
    public void listagemTest() throws SystemOFFException{ // it will not throw that couse we inicialize this system
        this.system.Inicializar();
        this.system.listaComputadores();
        /* Listagem de imagens e computadores
         Para esse teste foi comparado se o numero retornado pelas funçoes de
         de listagem de computadores e imagens sao respectivamente igual ao 
         numero de computadores e imagens total do sistema. O numero retornado
         pelas funçoes corresponde ao numero de elementos printados, 
         sendo computador ou imagens.
        */
        Assert.assertEquals(numeroComputadores,this.system.listaComputadores() );
        Assert.assertEquals(numeroImagens,this.system.listaImagens());
        
        // INICIO DO BLOCO
        
        /* Listagem de espaço disponivel nos computadores
         Para esse teste foi removido todas as imagens do sistema, assim é esperado
         que o numero do espaço livre seja igual ao numero do armazenamento total
         do computador. ( isso foi feito pois como os arquvos sao gerados 
         aleatoriamente a cada teste nao temos como saber como as imagens serao
         distribuidas entre os computadores ou qual sera o tamanho total e livre
         dos computadores e é considerado que ja foi feito e passado pelo teste
         "ComputadorTeste" que faz a verificaçao se quando imagens sao adicionadas
         ou removidas o valor de espaço livre é modificado)
        */
        
        // remove a arvore inteira
        for( int i = this.numeroImagens; i>0; i-- ){
            this.system.excluirImagem( ("img"+i) );
            Assert.assertFalse(this.system.getRegistrosTree().find(("img"+i)) != null);
            if( i > 1 )
                Assert.assertNotNull(this.system.getRegistrosTree().find( ( "img"+(i-1) ) ) );
        }
        //Faz o somatorio de todos os espaços livres e espaços totais de todos
        // os computadores do sistema
        float  espaçoMaximoTotal =0; 
        
        Computador PCs[] = new Computador[this.numeroComputadores];
        // salva todos os computadores em um vetor e soma o espaço maximo deles
        for(int i=0; i < this.numeroComputadores; i++){   
            PCs[i] = this.system.getPcQueue().deQueue();
            espaçoMaximoTotal += PCs[i].getTamanho();
        }
        // adiciona os Computadores de volta a fila de computadores,
        // para usos posterioroes
        for(int i=0; i < this.numeroComputadores; i++){   
            this.system.getPcQueue().queue(PCs[i], PCs[i].getFreeEspace());
        }
        
        Assert.assertEquals(espaçoMaximoTotal, this.system.listaComputadoresEspaçoVazio() );// rever esta linha
        try {// Recarega todas as imagens no sistema
            this.system.loadFilesImgaens();
            // caso uma Exception seja pega o teste dara erro pois nao é esperado
            // a ocorencias de exceptions
        } catch (IOException | InsufficientMemoryExceptrion | 
                 NoComputerRegisteredException | DuplicateKeyUsedException ex) {
            Assert.assertFalse(true);
        }
        
        // FIM DO BLOCO
        
        /* Listagem de imagens em computadores
         Para esse teste foi somado todos os valores retornados pela funçao
         'listaImagensEmComputador', sendo que o valor retornado é um inteiro
         correspondendo numero de imagens printadas, e foi verificado se esta
         soma é igual ao numero de imagens total.
        */
        IteratorMyPriorityQueue it = this.system.getPcQueue().iterator();
        while( it.hasNext() ){
            Computador pc = (Computador) it.next();
            Assert.assertEquals(pc.getImagens().getNumElementos(), this.system.listaImagensEmComputador( pc ));
        }
    this.system.finesh();
    }
}
 

