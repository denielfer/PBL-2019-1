/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Util.EstruturaDeDados.GrafoMatriz;
import Model.PathFinder;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author dfc15
 */
public class pathFinderTeste {
    GrafoMatriz grafo;
    @Before
    public void setUp(){
        this.grafo = new GrafoMatriz(0);
        grafo.addVertice();
        grafo.addVertice();
        grafo.addVertice();
        grafo.addVertice();
        grafo.addVertice();
        grafo.addVertice();
        grafo.adicionarLigaçao(0, 1, 2);
        grafo.adicionarLigaçao(1, 2, 1);
        grafo.adicionarLigaçao(1,4 , 6);
        grafo.adicionarLigaçao(2,3 , 5);
        grafo.adicionarLigaçao(4,3 , 9);
        grafo.adicionarLigaçao(4,5 , 7);
    }
    @Test
    public void dijkstra(){
        int vetor_caminho[] = PathFinder.dijkistra(grafo.getMatriz(), 1, 4);
        int tamanho = 0;
        for(int j=0; j <vetor_caminho.length-1; j++){
            tamanho += (Integer) grafo.getLigaçao(vetor_caminho[j], vetor_caminho[j+1]);
        }
        Assert.assertEquals(6, tamanho);
        vetor_caminho = PathFinder.dijkistra(grafo.getMatriz(), 0, 3);
        tamanho = 0;
        for(int j=0; j <vetor_caminho.length-1; j++){
            tamanho += (Integer) grafo.getLigaçao(vetor_caminho[j], vetor_caminho[j+1]);
        }
        Assert.assertEquals(8, tamanho);
        vetor_caminho = PathFinder.dijkistra(grafo.getMatriz(), 0, 5);
        tamanho = 0;
        for(int j=0; j <vetor_caminho.length-1; j++){
            tamanho += (Integer) grafo.getLigaçao(vetor_caminho[j], vetor_caminho[j+1]);
        }
        Assert.assertEquals(15, tamanho);
        vetor_caminho = PathFinder.dijkistra(grafo.getMatriz(), 2, 5);
        tamanho = 0;
        for(int j=0; j <vetor_caminho.length-1; j++){
            tamanho += (Integer) grafo.getLigaçao(vetor_caminho[j], vetor_caminho[j+1]);
        }
        Assert.assertEquals(14, tamanho);
        vetor_caminho = PathFinder.dijkistra(grafo.getMatriz(), 1, 3);
        tamanho = 0;
        for(int j=0; j <vetor_caminho.length-1; j++){
            tamanho += (Integer) grafo.getLigaçao(vetor_caminho[j], vetor_caminho[j+1]);
        }
        Assert.assertEquals(6, tamanho);
    }
    @Test
    public void test2(){
        System.out.println("");
        int num = grafo.getNumVertices();
        for( int i =num-1; i>= 0; i--)
            grafo.removerVertice(i);
        grafo.addVertice();
        grafo.addVertice();
        grafo.addVertice();
        grafo.addVertice();
        grafo.adicionarLigaçao(0, 1, 10);
        grafo.adicionarLigaçao(0, 2, 20);
        grafo.adicionarLigaçao(3, 2, 1);
        grafo.adicionarLigaçao(3, 1, 20);
        int vetor_caminho[] = PathFinder.dijkistra(grafo.getMatriz(), 0, 3);
        int tamanho = 0;
        for(int j=0; j <vetor_caminho.length-1; j++){
            tamanho += (Integer) grafo.getLigaçao(vetor_caminho[j], vetor_caminho[j+1]);
        }
        Assert.assertEquals(21, tamanho);
    }
}
