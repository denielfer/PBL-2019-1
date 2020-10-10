/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatFiles;


import Model.PathFinder;
import System.MainCotroler;

import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import model.PathFinderFileTest;
import org.junit.Before;
import org.junit.Test;

/**
 * Arquivo que roda o dijkstra de todos os pontos para todos os pontos e salva em um arquivo
 */
public class GenerateFileToTest {
    MainCotroler sys;
    @Before
    public void setUp() throws IOException{
        sys = new MainCotroler();
        sys.loadMatrizFromFile("Files\\pontos.txt");
    }
    @Test
    public void dijkstraFromFileToFile(){
        VariosDijkstras("Files\\dijkstra_busca_pontos.txt");
        VariosDijkstras("Files\\dijkstra_busca_pontos1.txt");
        VariosDijkstras("Files\\dijkstra_busca_pontos2.txt");
        VariosDijkstras("Files\\dijkstra_busca_pontos3.txt");
        
    }


private void VariosDijkstras(String path){
    FileWriter arq = null;
        int contador=0;
        try {
            arq = new FileWriter(path);
            PrintWriter gravarArq = new PrintWriter(arq);
            int vetor_caminho[] = null;
            int tamanho = 0;
            for(int c = 0; c < sys.getGrafo().getNumVertices(); c++){
                for(int i =0; i < sys.getGrafo().getNumVertices(); i++){
                    tamanho = 0;
                    vetor_caminho = PathFinder.dijkistra(sys.getMatriz(), c, i);
                    if(vetor_caminho == null){
                        gravarArq.printf("O caminho de %02d para %02d é: Inalcançavel",c,i);
                        gravarArq.printf("\n");
                        gravarArq.printf("\n___________________________\n");
                        contador++;
                        System.out.println(contador);
                        continue;
                    }
                    gravarArq.printf("O caminho de %02d para %02d é: ",c,i);
                    for(int j=0; j <vetor_caminho.length-1; j++){
                        gravarArq.printf("%02d,",vetor_caminho[j]);
                    }
                    gravarArq.printf("%02d",vetor_caminho[vetor_caminho.length-1]);
                    gravarArq.printf("\nCom tamanho: ");
                    for(int j=0; j <vetor_caminho.length-1; j++){
                        tamanho += (Integer) sys.getGrafo().getLigaçao(vetor_caminho[j], vetor_caminho[j+1]);
                        gravarArq.printf("%d+",sys.getGrafo().getLigaçao(vetor_caminho[j], vetor_caminho[j+1]));
                    }
                    gravarArq.printf("0=%d",tamanho);
                    gravarArq.printf("\n___________________________\n");
                }
            }
            Assert.assertTrue(true);
        } catch (IOException ex) {
            Logger.getLogger(PathFinderFileTest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                arq.close();
            } catch (IOException ex) {
                Logger.getLogger(PathFinderFileTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}