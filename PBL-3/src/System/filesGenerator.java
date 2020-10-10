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
package System;

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
    public void generateIMGX(int quantidade_imagens) throws IOException{
        int i;
        FileWriter arq = new FileWriter("Files\\imagens.ascii");
        PrintWriter gravarArq = new PrintWriter(arq);
        for (i=1; i<=quantidade_imagens; i++) {
        // sera salvo no arquivo img{cont} (tamanho){ numero aleatorio de 1 a 50 }
          gravarArq.printf("img%d %d%n", i,new Random().nextInt(50)+1 );
        }
        arq.close();
    }
    
    public void generateComputadorX( int quantidade_computadores ) throws IOException{
        int i;
        FileWriter arq = new FileWriter("Files\\computadores.ascii");
        PrintWriter gravarArq = new PrintWriter(arq);
        for (i=1; i<=quantidade_computadores; i++) {
        // sera salvo no arquivo computador{cont} (tamanho){ numero aleatorio de (1 a 10) *100 }
          gravarArq.printf("computador%d %d%n", i,(new Random().nextInt(90)+20 )*100);
        }
        arq.close();
    }
}
