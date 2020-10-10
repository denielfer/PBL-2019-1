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
package Controler;

import Model.PathFinder;
import Model.returnOfPathFinderFunction;
import Util.FileReader.FileInfo;
import Util.EstruturaDeDados.GrafoMatriz;
import Util.EstruturaDeDados.Iterator;
import Util.EstruturaDeDados.MyLinkedList;
import Util.FileReader.FileReader;
import java.io.IOException;

public class MainCotroler {
    private GrafoMatriz grafo;
    private int estacionamento_index;
    private final MyLinkedList<Integer> bancos;
    private final MyLinkedList<Integer> coletas;
    
    public MainCotroler() {
        this.grafo = new GrafoMatriz(1);// cria um grafo com 1 vertice
        this.estacionamento_index = 0;
        bancos = new MyLinkedList();
        coletas = new MyLinkedList();
        grafo.adicionarLigaçao(0, 0, -1);// esse vertice é o estacionamento
        
    }

    /****************************SEÇÂO UTIL*************************************/
    /**
     * Retorna a Matriz salva no sistema
     * @return GrafoMatriz salva no sistema
     */
    public GrafoMatriz getGrafo() {
        return grafo;
    }
    public void printGrafo(){
        for (int i=0; i<this.getGrafo().getNumVertices(); i++) {
            for( int j=0; j<this.getGrafo().getNumVertices(); j++)
                System.out.printf("%02d ", this.getGrafo().getLigaçao(i, j));
            System.out.printf("\n");
        }
    }

    /**
     * Retorna a Matriz salva no sistema
     * @return GrafoMatriz salva no sistema
     */
    public int[][] getMatriz() {
        return grafo.getMatriz();
    }
    /**
     * Retorna uma MyLinkedList<Integer> contendo os index dos bancos
     * @return MyLinkedLista<interger> contendo a lista de index dos bancos
     */
    public MyLinkedList<Integer> getBancos(){
        return bancos;
    }
    /**
     * Retorna uma MyLinkedList<Integer> contendo os index das coletas
     * @return MyLinkedLista<interger> contendo a lista de index das coletas
     */
    public MyLinkedList<Integer> getColetas() {    
        return coletas;
    }
    /**
     * Retorna um int contendo o index do estacionamento
     * @return int sendo o index do estacionamento
     */
    public int getEstacionamento_index() {
        return estacionamento_index;
    }

    /**
     * Funçao que inicializa grafo com o tamanho passado
     * @param tamanho_grafo int sendo o tamanho do grafo, considerando um grafo 
     * de i = j, onde i é o  numero de linhas e j o de colunas
     */
    private void loadGrafo(int tamanho_grafo) {
        this.grafo = new GrafoMatriz( tamanho_grafo );
    }
    /**
     * verifica se o vertice de tipo {tipo} é um estacionamento, banco ou coleta
     * e sendo remove ele do seu luga ( {index1} ) e coloca no seu luga novo
     * ( [index2] )
     * @param tipo int sendo o tipo do vertice ( -1 para estacionamento, 
     * -2 para banco e -3 para coleta )
     * @param index1 int sendo o antigo index do ponto na matriz
     * @param index2 int sendo o novo index do ponto na matrizs
     */
    private void atualizar_listas(int tipo, int index1, Integer index2){
        if(tipo == -1)
            this.estacionamento_index = index2;
        else if(tipo == -2){
            bancos.removeByContent(index1);
            if( index2 != null )
                bancos.add(index2);
        }else if(tipo == -3){
            coletas.removeByContent(index1);
            if( index2 != null )
                coletas.add(index2);
        }

        if( index2 == null ){// se um vertice de numero n foi removido os vertices de inedex>n ,
                             //os index salvos nas lista serao decrementados em 1
            if( estacionamento_index > index1 )
                estacionamento_index--;
            Iterator it = coletas.iterator();
            for( int i=0; it.hasNext(); i++ ){
                Integer temp = (Integer) it.next();
                if( temp > index1 ){
                    coletas.remove(i);
                    coletas.addAt(i, temp-1);
                }
            }
            it = bancos.iterator();
            for( int i=0; it.hasNext(); i++ ){
                Integer temp = (Integer) it.next();
                if( temp > index1 ){
                    bancos.remove(i);
                    bancos.addAt(i, temp-1);
                }
            }
        }
    }
    /***********************SEÇÂO DA TELA DE ARRESTAS***************************/
    /**
     * Funçao que modifica as ligaçoes do grafo
     * @param index1 int sendo o index do primeiro vertice
     * @param index2 int sendo o index do segungo vertice
     * @param valor int sendo o novo valor da coneçao ( sendo zero para 
     * remover a coneçao )
     */
    public void editarAresta(int index1, int index2, int valor){
        this.grafo.getMatriz()[index1][index2] = valor;
        this.grafo.getMatriz()[index2][index1] = valor;
    }
    /************************SEÇÂO DA TELA DO DIJKSTRA**************************/
    /**
     *  Funçao que faz o dijkstra pra o ponto de coleta e retorna a string do 
     * estacionamento para o ponto de coleta e do ponto de coleta para o banco
     * @param indexStart int sendo o index do ponto inicio ( estacionamento ) da roda
     * @param indexColeta int sendo o index do ponto intermediario ( coleta ) 
     * que deseja passar
     * @param indexBanco int sendo destino ( banco ) para onde se deseja ir
     * @return String sendo o texto mostrado na interfacie. ( String contendo:
     * "De {indexStart } para {indexColeta} tem custo { cost1  } e o caminho é : {path1 }"+
     * "De {indexColeta} para {indexBanco } tem custo { cost2  } e o caminho é : {path2 }"+
     * "De { indexStart } para {indexBanco } tem custo { cost_T } e o caminho é : {path_T} ")
     */
    public String dijkstraDuplo( int indexStart, int indexColeta, int indexBanco){
        returnOfPathFinderFunction[] caminhos;
        try{
             caminhos = PathFinder.dijkistraForAll(this.getMatriz(), indexColeta );
        }catch(java.lang.NullPointerException e){
            return "CAMINHO IMPOCIVEL";
        }
        String path1="",path2="",path_T="";
        for( int i= caminhos[indexStart].getPath().length -1; i>=0; i-- ){
            path1+=caminhos[indexStart].getPath()[i];
            if( i-1 >=0 )
                path1+="->";
        }
        for( int i= 0; i<caminhos[indexBanco].getPath().length; i++ ){
            path2+=caminhos[indexBanco].getPath()[i];
            if( i+1 != caminhos[indexBanco].getPath().length )
                path2+="->";
        }
        path_T = path1 +"->"+ path2;
        int cost1=0,cost2=0,cost_T=0;
        cost1 += caminhos[indexStart].getCost();
        cost2 += caminhos[indexBanco].getCost();
        cost_T = cost1 + cost2;
        return "De "+indexStart +" para "+indexColeta+" tem custo "+cost1+" e o caminho é : "+path1+
               "\nDe "+indexColeta+" para "+indexBanco+" tem custo "+ cost2+" e o caminho é : "+path2+
               "\nDe "+indexStart+" para "+indexBanco+" tem custo "+ cost_T +" e o caminho é : "+path_T;
    }
    
    /*
    {path1 }  \nDe {indexColeta} para "+
               "{indexBanco } tem custo { cost2  } e o caminho é : {path2 } D "+
                "{ indexStart } para {indexBanco } tem custo { cost_T } e o "+
    
    */
    /***********************SEÇÂO DA TELA DE VERTICE****************************/
    /**
     * Funçao que adicona vertices na matriz
     * @param num_vertices_adicionados int sendo o numero de vertices adidionados do tipo{ tipo_vertice }
     * @param tipo_vertice int sendo o tipo do vertice podendo ser -2 para banco e -3 para coleta
     * @return true se a operaçao foi realizada e false caso contrario
    */
     public boolean add_vertice( int num_vertices_adicionados, int tipo_vertice ){
        if(num_vertices_adicionados > 0){
            int num_vertices_old = grafo.getNumVertices();
            for(int i =0; i<num_vertices_adicionados; i++){
                grafo.addVertice();
                grafo.adicionarLigaçao(i+num_vertices_old, i+num_vertices_old, tipo_vertice);
                if( tipo_vertice == -2 )
                    bancos.add(i+num_vertices_old);
                else if( tipo_vertice == -3)
                    coletas.add(i+num_vertices_old);
            }
            return true;
        }
        return false;
    }
    /**
     * Remove um vertice do grafo se ele nao for o estacionamento
     * @param index index do vertice na matriz
     * @return true se foi removido, false caso nao foi removido e null caso 
     * tentativa de remover estacionamento
     */
    public Boolean remover_vertice(int index){
        if(index>=0 && index<grafo.getNumVertices() 
                && grafo.getMatriz()[index][index] != -1){
            int temp= grafo.getMatriz()[index][index];
            grafo.removerVertice(index);
            this.atualizar_listas(temp, index, null);
            return true;
        }
        if(grafo.getMatriz()[index][index] == -1){
            return null;
        }
        return false;
    }
    /**
     * troca o lugar de 2 pontos
     * @param index1 index do ponto 1 na matriz
     * @param index2 index do ponto 2 na matriz
     * @return true se a operaçao foi feita e false caso contrario
     */
    public boolean swapVertices(int index1, int index2){
        if(index1 != index2 && index1>=0 && index1<grafo.getNumVertices() &&
                index2>=0 && index2<=grafo.getNumVertices()){
            int temp1 = grafo.getMatriz()[index1][index1];
            int temp2 = grafo.getMatriz()[index2][index2];
            
            grafo.getMatriz()[index1][index1] = temp2;
            grafo.getMatriz()[index2][index2] = temp1;
            
            this.atualizar_listas(temp1, index1, index2);
            this.atualizar_listas(temp2, index2, index1);
            return true;
        }
        return false;
    }
    
    /**
    * Separa a String no arquivo file.
     * @param filePath Caminho do arquivo que sera lido
     * @return int sendo o numero de elementos do grafo.
     * @throws java.io.IOException Exception para erro de arquivo
    */
    public int loadMatrizFromFile( String filePath ) throws IOException{
        FileInfo fileInfo = FileReader.readFile(filePath);
        int cont = 0, possCurso = 0, proxPonto = -1;
        MyLinkedList list = new MyLinkedList();
        this.loadGrafo( fileInfo.getNumLines() );
        Iterator it = bancos.iterator();
        while(it.hasNext()){
            bancos.remove(0);
            it.next();
        }
        it = coletas.iterator();
        while(it.hasNext()){
            coletas.remove(0);
            it.next();
        }
        while( cont != fileInfo.getNumLines() ){
            char chars[] = new char[10]; // vetor de chars que tem unidades lidas do arquivo
            // Faz a leitura do nome
            for(int i = 0; i<fileInfo.getNumLines(); i++){
                possCurso = proxPonto+1;
                proxPonto = fileInfo.getText().indexOf(" ", possCurso);
                fileInfo.getText().getChars(possCurso, proxPonto, chars, 0);
                chars[proxPonto - possCurso] = 0 ;
                // converte o que leu para String
                Float temp = Float.valueOf( String.valueOf(chars) );
                this.grafo.adicionarLigaçao(cont, i, temp.intValue()  );
                if( cont == i){
                    switch(temp.intValue()){
                        case -1:
                            this.estacionamento_index = cont;
                            break;
                        case -2:
                            this.bancos.add(cont);
                            break;
                        case -3:
                            this.coletas.add(cont);
                            break;
                    }
                }
                chars = new char[10];
            }
            // faz a separaçao da linhas
            possCurso = proxPonto+1;
            proxPonto = fileInfo.getText().indexOf("\n", possCurso);
            cont++;
            
        }
        return fileInfo.getNumLines();
    }
}
