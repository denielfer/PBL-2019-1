/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Daniel Fernandes Campos e Esdras Evangelista de sena santos
 * Data: 20/09/2019
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
package Util.FileReader;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author dfc15
 */
public class FileReader {
    /**
    * Separa a String no arquivo file.
     * @param filePath Caminho do arquivo que sera lido
     * @return int sendo o numero de elementos do grafo.
     * @throws java.io.IOException Exception para erro de arquivo
    */
    public static FileInfo readFile( String filePath ) throws IOException{
        FileInfo fileInfo = null;
        try{
            fileInfo = FileReader.readAll(filePath);
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch( IOException e ){
            System.out.println(e.getMessage());
        }finally{
            if( fileInfo == null )
                return null;
            else
                return fileInfo;
        }
    }
    
    
    
    /**
     * Codigo que efetua leitura de todo o arquivos TXT
     * @param filePath caminho para o arquivo;
     * @return FileInfo contendo uma String com todo o texto e o numero de linhas;
     * @throws java.io.FileNotFoundException Exeção para arquivo não encontrado
    */
    private static FileInfo readAll( String filePath ) throws IOException {
        FileInputStream stream;
        try{
            stream = new FileInputStream(filePath);
        }catch( FileNotFoundException e ){
            throw new FileNotFoundException("Arquivo não encontrado por favor "
                    + "verifique se o caminho informado foi correto ou se o "
                    + "arquivo existe");
        }
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(reader);
        String fullFile = "";
        String linha;
        try{
            linha = br.readLine();
        }catch( IOException e ){
            stream.close(); // se deu erro fecha o arquivo antes de lança o erro
            throw new IOException("Problema na leitura das linhas do arquivo");
        }
        int numLines = 0;
        while( linha != null ){
            numLines++;
            fullFile += linha + "\n";
            try{
                linha = br.readLine();
            }catch( IOException e ){
                stream.close(); // se deu erro fecha o arquivo antes de lança o erro
                throw new IOException("Problema na leitura das linhas do arquivo");
            }
        }
        stream.close();
        return new FileInfo( fullFile, numLines );
    }
}
