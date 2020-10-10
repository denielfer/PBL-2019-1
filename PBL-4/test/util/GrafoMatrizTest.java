/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.junit.Before;
import Util.EstruturaDeDados.GrafoMatriz;
import java.util.Random;
import org.junit.Test;
import org.testng.Assert;
/**
 *
 * @author dfc15
 */
public class GrafoMatrizTest {
    private GrafoMatriz GM;
    private int num_elementos;
    @Before 
    public void setUp(){
        // variavel que guarda o numero de colulas / linhas da matris variando de 4 a 8
        num_elementos = /*4;*/new Random().nextInt(4)+4; 
        this.GM = new GrafoMatriz( num_elementos );
    }
    
    @Test
    public void testAdd_Get_remove__Vertice_ligaçao(){
        for( int i = 0; i < num_elementos; i++ ){ // loop que verifica se o grafo esta zerado
             for( int j = 0; j <num_elementos ; j++ )
                Assert.assertEquals(GM.getLigaçao(i, j) , 0);
        }
        Object M[][] = new Object[ num_elementos + 1 ][ num_elementos + 1 ];
        for( int i=0; i<num_elementos +1; i++ ){ // loop que gera a matris de teste
            for( int j=0; j<num_elementos +1 ; j++ ){
                if( i < j) // se estiver acima da diagonal principal gera um valor
                    M[i][j] = new Random().nextInt(15);
                else if( i == j ) // na diagonal principal é o tipo
                    M[i][j] = new Random().nextInt(2)-2;
                else// abaixo da diagonal principal, o seu simetrico
                    M[i][j] = M[j][i];
            }  
        }
        Assert.assertEquals(num_elementos, GM.getNumVertices());
        GM.addVertice();
        num_elementos++;
        Assert.assertEquals(num_elementos, GM.getNumVertices());
        for( int i=0; i<num_elementos; i++ ){ // loop que passa a matris de teste para o grafo
            for( int j=0; j<num_elementos; j++ ){
                GM.adicionarLigaçao(i, j, (int) M[i][j]);
            }  
        }
        // loop que verifica se os valores foram salvos corretamente
        for( int i=0; i<num_elementos; i++ ){ 
            for( int j=0; j<num_elementos; j++ ){
                Assert.assertEquals( M[i][j], GM.getLigaçao(i, j) );
            }  
        }
        // remove um vertice
        int indexDoRemovido = new Random().nextInt( num_elementos );
        Assert.assertEquals(num_elementos, GM.getNumVertices());
        GM.removerVertice(indexDoRemovido);
        num_elementos--;
        Assert.assertEquals(num_elementos, GM.getNumVertices());
// loop que corige matriz teste, remove 1 linha ou culuna sendo a linha que deveria ser removido acima
        int newI = 0;
        Object temp[][] = new Object[ num_elementos ][ num_elementos ];
        for(int i = 0; i<num_elementos+1; i++){
            if( indexDoRemovido == i )
                continue;
            int newJ = 0;
            for(int j = 0; j<num_elementos+1; j++){
                if(indexDoRemovido == j){
                    continue;
                }
                temp[newI][newJ] = M[i][j];
                newJ++;
            }
            newI++;
        }
        M = temp;
        // loop que verifica se os valores apos a remoção estao certos
        for( int i=0; i<num_elementos; i++ ){ 
            for( int j=0; j<num_elementos; j++ ){
                Assert.assertEquals( GM.getLigaçao(i, j) , M[i][j]);
            }  
        }
        
        for( int i=0; i<num_elementos; i++ ){ // Limpa o grafo
            for( int j=0; j<num_elementos; j++ ){
                if(j!=i)
                    GM.removerLigaçao(i, j);
            }  
        }
        
        for( int i = 0; i < num_elementos; i++ ){ // loop que verifica se o grafo foi zerado
            for( int j = 0; j <num_elementos ; j++ ){
                if( j!=i )
                    Assert.assertEquals(GM.getLigaçao(i, j), 0);
            }
        }
    }
}
