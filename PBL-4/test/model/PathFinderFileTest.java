/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import Controler.MainCotroler;
import Model.PathFinder;

import java.io.IOException;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author dfc15
 */
public class PathFinderFileTest {
    MainCotroler sys;
    @Before
    public void setUp() throws IOException{
        sys = new MainCotroler();
        sys.loadMatrizFromFile("Files\\pontos.txt");
    }
    @Test
    public void dijkstraFromFileTest(){
        //verifica se o dijkstra da diagonal principal é 0
        for( int i=0; i < sys.getGrafo().getNumVertices(); i++){
            int[] c = new int[1];
            c[0] = i;
            Assert.assertTrue(compareIntArrey(c, PathFinder.dijkistra(sys.getMatriz(), i, i)));
        }
        //agora serao verificados alguns caminhos que foram calculados a mao do arquivo base
        /*
            Nota nao tem assert para o custo do caminho pois seria o somatorio de i=0 ate 
        i = dijkstra.length-2 de sys.getMatriz()[ dijkstra[i] [ dijkstra[i+1] ]
        ,sendo uma operaçao rudimentar ( loop com soma de variavel ) do java portanto nao sera testado aqui.
        */
        int dijkstra[] = PathFinder.dijkistra(sys.getMatriz(), 0, 4);
        int[] comparaçao = new int[]{0,23,44,25,04};
        Assert.assertTrue(compareIntArrey(dijkstra, comparaçao));
        
        dijkstra= PathFinder.dijkistra(sys.getMatriz(), 0, 36);
        comparaçao = new int[]{00,23,44,31,36};
        Assert.assertTrue(compareIntArrey(dijkstra, comparaçao));
        
        dijkstra= PathFinder.dijkistra(sys.getMatriz(), 1, 4);
        comparaçao = new int[]{01,34,42,12,41,04};
        Assert.assertTrue(compareIntArrey(dijkstra, comparaçao));
        
        dijkstra= PathFinder.dijkistra(sys.getMatriz(), 1, 25);
        comparaçao = new int[]{01,34,28,31,44,25};
        Assert.assertTrue(compareIntArrey(dijkstra, comparaçao));
        
        dijkstra= PathFinder.dijkistra(sys.getMatriz(), 1, 37);
        comparaçao = new int[]{01,34,16,00,37};
        Assert.assertTrue(compareIntArrey(dijkstra, comparaçao));
        
        dijkstra= PathFinder.dijkistra(sys.getMatriz(), 1, 4);
        comparaçao = new int[]{02,17,23,44,25,04};
        Assert.assertTrue(compareIntArrey(dijkstra, comparaçao));
        
        dijkstra= PathFinder.dijkistra(sys.getMatriz(), 2, 21);
        comparaçao = new int[]{02,17,23,48,39,21};
        Assert.assertTrue(compareIntArrey(dijkstra, comparaçao));
        
        dijkstra= PathFinder.dijkistra(sys.getMatriz(), 2, 45);
        comparaçao = new int[]{02,29,06,45};
        Assert.assertTrue(compareIntArrey(dijkstra, comparaçao));
        
        dijkstra= PathFinder.dijkistra(sys.getMatriz(), 2, 50);
        comparaçao = new int[]{02,24,50};
        Assert.assertTrue(compareIntArrey(dijkstra, comparaçao));
        
        dijkstra= PathFinder.dijkistra(sys.getMatriz(), 3, 12);
        comparaçao = new int[]{03,28,34,42,12};
        Assert.assertTrue(compareIntArrey(dijkstra, comparaçao));
        
        dijkstra= PathFinder.dijkistra(sys.getMatriz(), 3, 19);
        comparaçao = new int[]{03,28,31,36,19};
        Assert.assertTrue(compareIntArrey(dijkstra, comparaçao));
        
        dijkstra= PathFinder.dijkistra(sys.getMatriz(), 3, 35);
        comparaçao = new int[]{03,28,31,15,35};
        Assert.assertTrue(compareIntArrey(dijkstra, comparaçao));
        
        dijkstra= PathFinder.dijkistra(sys.getMatriz(), 3, 47);
        comparaçao = new int[]{03,28,31,13,47};
        Assert.assertTrue(compareIntArrey(dijkstra, comparaçao));
        
        dijkstra= PathFinder.dijkistra(sys.getMatriz(), 21, 1);
        comparaçao = new int[]{21,39,48,28,34,01};
        Assert.assertTrue(compareIntArrey(dijkstra, comparaçao));
        
        dijkstra= PathFinder.dijkistra(sys.getMatriz(), 21, 2);
        comparaçao = new int[]{21,39,48,28,29,02};
        Assert.assertTrue(compareIntArrey(dijkstra, comparaçao));
        
        dijkstra= PathFinder.dijkistra(sys.getMatriz(), 21, 19);
        comparaçao = new int[]{21,39,37,49,38,19};
        Assert.assertTrue(compareIntArrey(dijkstra, comparaçao));
        
        dijkstra= PathFinder.dijkistra(sys.getMatriz(), 21, 21);
        comparaçao = new int[]{21};
        Assert.assertTrue(compareIntArrey(dijkstra, comparaçao));
        
        dijkstra= PathFinder.dijkistra(sys.getMatriz(), 21, 22);
        comparaçao = new int[]{21,39,48,28,31,15,22};
        Assert.assertTrue(compareIntArrey(dijkstra, comparaçao));
        
        dijkstra= PathFinder.dijkistra(sys.getMatriz(), 21, 35);
        comparaçao = new int[]{21,39,48,28,31,15,35};
        Assert.assertTrue(compareIntArrey(dijkstra, comparaçao));
        
        dijkstra= PathFinder.dijkistra(sys.getMatriz(), 22, 39);
        comparaçao = new int[]{22,15,31,28,48,39};
        Assert.assertTrue(compareIntArrey(dijkstra, comparaçao));
        
        dijkstra= PathFinder.dijkistra(sys.getMatriz(), 22, 44);
        comparaçao = new int[]{22,14,44};
        Assert.assertTrue(compareIntArrey(dijkstra, comparaçao));
        
        dijkstra= PathFinder.dijkistra(sys.getMatriz(), 22, 50);
        comparaçao = new int[]{22,15,50};
        Assert.assertTrue(compareIntArrey(dijkstra, comparaçao));
        
        dijkstra= PathFinder.dijkistra(sys.getMatriz(), 23, 0);
        comparaçao = new int[]{23,00};
        Assert.assertTrue(compareIntArrey(dijkstra, comparaçao));
        
        dijkstra= PathFinder.dijkistra(sys.getMatriz(), 23, 23);
        comparaçao = new int[]{23};
        Assert.assertTrue(compareIntArrey(dijkstra, comparaçao));
        
        dijkstra= PathFinder.dijkistra(sys.getMatriz(), 25, 21);
        comparaçao = new int[]{25,44,23,48,39,21};
        Assert.assertTrue(compareIntArrey(dijkstra, comparaçao));
        
        dijkstra= PathFinder.dijkistra(sys.getMatriz(), 25, 32);
        comparaçao = new int[]{25,44,32};
        Assert.assertTrue(compareIntArrey(dijkstra, comparaçao));
        
        dijkstra= PathFinder.dijkistra(sys.getMatriz(), 26, 21);
        comparaçao = new int[]{26,20,28,48,39,21};
        Assert.assertTrue(compareIntArrey(dijkstra, comparaçao));
        
        dijkstra= PathFinder.dijkistra(sys.getMatriz(), 50, 4);
        comparaçao = new int[]{50,15,31,44,25,04};
        Assert.assertTrue(compareIntArrey(dijkstra, comparaçao));
    }
    /**
     * Compara 2 vetores elemento por elemento para ver se sao iguais
     * @param expected int[] vetor esperado
     * @param actual int[] vetor verificado
     * @return boolean sendo true se sao iguais e false caso contrario
     */
    private boolean compareIntArrey(int[] expected,int[] actual){
        if( actual.length != expected.length){
            return false;
        }
        for(int i = 0; i < expected.length;i++){
            if(expected[i] != expected[i])
                return false;
        }
        return true;
    }
}
