/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemTest;

import Controler.MainCotroler;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author dfc15
 */
public class MainControlerTest {
    private MainCotroler sys;
    // Nao é testado o sys.dijkstraDuplo pis é basicamente um dijkstra ( que é testado em outro lugar )
    // e retorna uma string contendo informaçoes desse dijkstra
    @Before
    public void setUp() throws IOException{
        sys = new MainCotroler();
    }
    @Test
    public void vertice_Adiciona_Remover_Test(){
        // verifica se o grafo comessou com o estacionamento
        Assert.assertTrue(sys.getGrafo().getNumVertices() == 1);
        // adiciona banco e coleta e ve se foram adicionados as respectivas listas
        Assert.assertTrue(sys.add_vertice(1, -2));
        Assert.assertTrue(sys.getBancos().get(0) == 1 );
        Assert.assertTrue(sys.add_vertice(1, -3));
        Assert.assertTrue(sys.getColetas().get(0) == 2 );
        Assert.assertTrue(sys.getGrafo().getNumVertices() == 3);
        // troca o index do banco e coleta e verifica se as listas foram modificadas
        Assert.assertTrue(sys.swapVertices(1, 2));
        Assert.assertTrue(sys.getBancos().get(0) == 2 );
        Assert.assertTrue(sys.getColetas().get(0) == 1 );
        // verifica se o numero de vertices do grafo esta certo e remove o banco 
        // e a coleta e ve se a lista foi atualizada assim como o numero de 
        // vertices do grafo
        Assert.assertTrue(sys.getGrafo().getNumVertices() == 3);
        Assert.assertTrue(sys.remover_vertice(2));
        Assert.assertTrue(sys.remover_vertice(1));
        Assert.assertTrue(sys.getGrafo().getNumVertices() == 1);
        Assert.assertTrue(sys.getBancos().get(0) == null );
        Assert.assertTrue(sys.getColetas().get(0) == null );
        // adiciona banco e coleta e ve se foram adicionados as respectivas listas
        Assert.assertTrue(sys.add_vertice(1, -3));
        Assert.assertTrue(sys.getColetas().get(0) == 1 );
        Assert.assertTrue(sys.add_vertice(1, -2));
        Assert.assertTrue(sys.getBancos().get(0) == 2 );
        Assert.assertTrue(sys.getGrafo().getNumVertices() == 3);
        // troca o index do estacionamento e coleta e verifica se as variaveis 
        // que guardam "track" deles foi atualizado
        Assert.assertTrue( sys.swapVertices(0, 1) );
        Assert.assertTrue(sys.getColetas().get(0) == 0 );
        Assert.assertTrue(sys.getEstacionamento_index() == 1 );
        Assert.assertTrue(sys.getBancos().get(0) == 2 );
        // troca o index do banco e coleta e verifica se as listas foram modificadas
        Assert.assertTrue( sys.swapVertices(0, 2) );
        Assert.assertTrue(sys.getColetas().get(0) == 2 );
        Assert.assertTrue(sys.getEstacionamento_index() == 1 );
        Assert.assertTrue(sys.getBancos().get(0) == 0 );
        // troca o index do estacionamento e banco e verifica se as variaveis 
        // que guardam "track" deles foi atualizado
        Assert.assertTrue( sys.swapVertices(0, 1) );
        Assert.assertTrue(sys.getColetas().get(0) == 2 );
        Assert.assertTrue(sys.getEstacionamento_index() == 0 );
        Assert.assertTrue(sys.getBancos().get(0) == 1 );
        // tenta remover estacionamento e verifica se a operaçao nao foi efetuada
        Assert.assertNull( sys.remover_vertice(0) );
    }
    @Test
    public void ArestaTest(){
        sys.add_vertice(1, -2);
        sys.add_vertice(1, -3);
        sys.editarAresta(0, 1, 4);
        sys.editarAresta(0, 2, 3);
        sys.editarAresta(1, 2, 2);
        //se as ligaçoes foram adicionadas coretamente
        Assert.assertTrue( sys.getMatriz()[0][0] ==  -1);
        Assert.assertTrue( sys.getMatriz()[0][1] ==  4);
        Assert.assertTrue( sys.getMatriz()[0][2] ==  3);
        
        Assert.assertTrue( sys.getMatriz()[1][0] ==  4);
        Assert.assertTrue( sys.getMatriz()[1][1] ==  -2);
        Assert.assertTrue( sys.getMatriz()[1][2] ==  2);
        
        Assert.assertTrue( sys.getMatriz()[2][0] ==  3);
        Assert.assertTrue( sys.getMatriz()[2][1] ==  2);
        Assert.assertTrue( sys.getMatriz()[2][2] ==  -3);
        
        sys.remover_vertice(1);
        // se quando removeu o vertice as ligaçoes dos outros vertices se mantem
        Assert.assertTrue( sys.getMatriz()[0][0] ==  -1);
        Assert.assertTrue( sys.getMatriz()[0][1] ==  3);
        
        Assert.assertTrue( sys.getMatriz()[1][0] ==  3);
        Assert.assertTrue( sys.getMatriz()[1][1] ==  -3);
    }
    @Test
    public void importFileTest(){// verifica se o arquivo foi importado se o numero de vertices importado
                                // é igual ao esperado
        try {
            sys.loadMatrizFromFile("Files\\Pontos.txt");
        } catch (IOException ex) {// nao deve entra nesse catch, entao se entra é erro
            Assert.assertTrue(false);
        }
        Assert.assertTrue( sys.getGrafo().getNumVertices() == 51);
        
    }
}
