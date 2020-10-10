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
package Model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Esta class nao tem teste pois nao faz parte do produto é apenas para gerar
 * arquivos aleatorios para o teste
 * @author dfc152
 */
public class filesGenerator {
    public static void grafos(int num_elementos, String path) throws IOException{
        if( num_elementos < 1  )
            return;
        int i;
        int bancos = (num_elementos - 1 )/50 * 10 , empresas = (num_elementos - 1 )/50 * 10 ;
        FileWriter arq = new FileWriter(path);
        PrintWriter gravarArq = new PrintWriter(arq);
        int v[] = new int[num_elementos];
       // loop que gera os vertices
        for(i = 0; i<51; i++){
            int r = new Random().nextInt(100);
            if( i==0 )
                v[i] = -1;
            else if( r > 60 && bancos > 0 ){
                v[i] = -2;
                bancos--;
            }
            else if( r <= 40 && empresas > 0 ){
                v[i] = -3;
                empresas--;
            }
            else
                v[i] = 0;
                
        }
        int matris_adijacencias[][] = new int[num_elementos][num_elementos];
        //gera as ligaçoes
        for( i=0; i<num_elementos; i++ ){
            for( int j=0; j<num_elementos; j++ ){
                if( i < j){ // se estiver acima da diagonal principal gera um valor
                    Integer num = new Random().nextInt(50); // gera um numerdo de 0 a 49
                    if(num > 3)// se o numero for maior de 15 nao tem ligaçao
                        matris_adijacencias[i][j] = 0;
                    else // se nao é o numero
                        matris_adijacencias[i][j] = num+15;
                    
                }else if( i == j ) // na diagonal principal é o tipo
                    matris_adijacencias[i][j] = v[i];
                else// abaixo da diagonal principal, o seu simetrico
                    matris_adijacencias[i][j] = matris_adijacencias[j][i];
            }  
        }
        for (i=0; i<num_elementos; i++) {
            for( int j=0; j<num_elementos; j++)
                gravarArq.printf("%02d ", matris_adijacencias[i][j] );
            if(i != num_elementos -1 )
                gravarArq.printf("\n");
        }
         
        arq.close();
    }

}
