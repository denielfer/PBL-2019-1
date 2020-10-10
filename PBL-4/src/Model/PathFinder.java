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
package Model;

import Util.EstruturaDeDados.MyLinkedList;
import Util.EstruturaDeDados.MyPriorityQueue;

public abstract class PathFinder {

    /**
     * Algoritmo de dijkstra para achar menhor caminho entre 2 pontos
     * 
     * @param M Interger[][] sendo a matriz de adjacencia do grafo 
     * @param indexStart index do ponto de inicio
     * @param indexFinesh index do ponto final
     * @return Integer[] sendo o vetor de index (vertices) que levam ao caminho 
     * mais curto para de {indexStart} para {indexFinesh}
    */
    public static int[] dijkistra( int[][] M, int indexStart, int indexFinesh ){
        if(indexStart == indexFinesh){
            int[] returned = new int[1];
            returned[0] = indexStart;
            return returned;
        }else if(PathFinder.whoCanComeOver(M, indexFinesh) == null // se nao da pra chega no vertice final
                || PathFinder.getConectados(M, indexStart) == null){ // se nao da pra sair do vertice inicial
            return null;
        }
        int custo_dislocamento[] = new int[M.length];
        MyLinkedList<Integer> nao_visitados = new MyLinkedList<>();
        int antecessor[] = new int[M.length];
        for(int i = 0; i < M.length;i++){
            if(i == indexStart)
                antecessor[i] = indexStart;
            else
                antecessor[i] = M.length+1;
            custo_dislocamento[i] = Integer.MAX_VALUE/2;
            if(i != indexStart)
                nao_visitados.add(i);
        }
        custo_dislocamento[indexStart] = 0;
        for(int conectado : getConectados(M, indexStart)){
            custo_dislocamento[conectado] = M[indexStart][conectado];
            antecessor[conectado] = indexStart;
        }
        while( !( nao_visitados.isEmpty() ) ){
            int vertice_verificado = PathFinder.proximoVertice( custo_dislocamento , nao_visitados );
            nao_visitados.removeByContent(vertice_verificado);
            int[] conectados = getConectados(M, vertice_verificado);
            if( conectados != null ){
                for( int conectado : conectados ){
                    int custoNovo = custo_dislocamento[vertice_verificado] + M[vertice_verificado][conectado];
                    if( custoNovo < custo_dislocamento[conectado] ){
                        custo_dislocamento[conectado] = custoNovo;
                        antecessor[conectado] = vertice_verificado;
                    }
                }
        }
            if( nao_visitados.isEmpty() ){
               return PathFinder.pathMaker(indexStart, indexFinesh, antecessor, M.length);
            }
        }
        return null;
    }
    /**
     * Funçao que gera o caminho entre {indexStart} e {indexFinesh}
     * @param indexStart int sendo o index do vertice inicial na 
     * matriz de adjacentia 
     * @param indexFinesh int sendo o index do vertice final na 
     * matriz de adjacentia 
     * @param antecessor Integer[] sendo a lista de antecessores do vertice
     * @param num_vertices int sendo o numero de vertices presentes no grafo
     * @return Integer[] sendo o vetor com a ordem de index da matroz 
     * correspondente ao caminho de {indexStarte} para {indesFinesh}
     */
    private static int[] pathMaker( int indexStart, int indexFinesh, int[] antecessor, int num_vertices ){
        int[] path = new int[num_vertices];
        boolean isNotFineshed = true;
        int possAtual = indexFinesh;
        int cont =0;
        while( isNotFineshed ){
            if(possAtual == num_vertices+1)
                return null;
            path[cont] = possAtual;
            possAtual = antecessor[possAtual];
            cont++;
            if( possAtual == indexStart )
                isNotFineshed = false;
        }
        path[cont] = indexStart;
        int truePath[] = new int[cont+1];
        for(int i=0; i < cont+1; i++){
            truePath[i] = path[ cont-i ];
        }
        return truePath;
    }
   /**
    * Gera una lista de index dos nos adijacentes ao nó {index} usando a matriz
    * de adjacendia {matriz}
    * @param matriz Integer[][] sendo a matriz de adjacencia do grafo
    * @param index int sendo o index do que deseja saber os adjacentes
    * @return int[] sendo o vetor contedo os index dos nos adjacentes
   */
    private static int[] getConectados(int[][] matriz, int index){
        int returned[] = null;
        int returnedLength = 0;
         for(int i=0; i<matriz[index].length; i++){
            if( matriz[index][i] > 0 ){
                int temp[] = new int[returnedLength+1];
                int j;
                for(j=0; j<returnedLength; j++ )
                    temp[j] = returned[j];
                temp[j] = i;
              returnedLength++;
              returned = temp;            
            }
        }
        return returned;
    }
    /**
     * Acha o proximo vertice da da lista de nao visitados
     * @param custos Integer[] contendo a tabela de custos de para chegar 
     * do vertice inicial aos outros vertices
     * @param nao_visitados MyLinkedList<Integer> sendo a lista dos index 
     * dos nós nao visitados
     * @return int sendo o no pertecente a {nao_visitados} com menor custo
    */
    private static int proximoVertice( int[] custos, MyLinkedList<Integer> nao_visitados ){
        MyPriorityQueue<Integer> ordem_procimos = new MyPriorityQueue<>();
        for( int i=0; i<custos.length; i++){
            int num = custos[i];
            ordem_procimos.queue(i, num);
        }
        boolean notFounded = true;
        while( notFounded ){
            if( nao_visitados.contains(ordem_procimos.getLast() ) )
                notFounded = false;
            else
                ordem_procimos.removeLast();
        }
        return ordem_procimos.getLast();
    }

    /**
    * Gera una lista de index dos nos adijacentes ao nó {index} usando a matriz
    * de adjacendia {matriz}
    * @param matriz Integer[][] sendo a matriz de adjacencia do grafo
    * @param index int sendo o index do que deseja saber os adjacentes
    * @return int[] sendo o vetor contedo os index dos nos adjacentes
   */
    private static int[] whoCanComeOver(int[][] matriz, int index){
        int returned[] = null;
        int returnedLength=0;
         for(int i=0; i<matriz[index].length; i++){
            if( matriz[i][index] > 0 ){
                int temp[] = new int[returnedLength+1];
                int j;
                for(j=0; j<returnedLength; j++ )
                    temp[j] = returned[j];
                temp[j] = i;
              returned = temp;            
            }
        }
        return returned;
    }
    /**
     * Funçao que retorna o caminho do dijstra e o custo total do caminho
     * @param M int[][] sendo a matriz de adjacencia do grafo
     * @param indexStart int sendo o index de inicio da matriz de adjacencia
     * @param indexFinesh int sendo o index final da matriz de adjacencia
     * @return returnOfPathFinderFunction sendo um objeto que tem de atributo 
     * 'path' contendo o caminho do dijkstra e um atributo 'cost' sendo o custo
     * total do caminho
     */
    public static returnOfPathFinderFunction pathFinder( int[][] M, int indexStart, int indexFinesh ){
        returnOfPathFinderFunction returned = new returnOfPathFinderFunction();
        returned.setPath( PathFinder.dijkistra(M, indexStart, indexFinesh) );
        returned.setCost(costPath( returned.getPath(), M ));
        return returned;
    }
    /**
     * Funçao que calcula o custo de um dado caminho ( {path} ) em uma matriz 
     * de adjacencia( {matriz} )
     * @param path int[] sendo o vetor contendo a sequencia de index dos 
     * vertices na matriz do caminho
     * @param matriz int[][] sendo a matriz de adjacencia
     * @return int sendo o custo total do caminho
     */
    private static int costPath( int[] path, int[][] matriz ){
        int returned = 0;
        for( int i=0; i<path.length-1; i++ ){
           // System.out.println(returned+" + "+matriz[i][i+1]+" = "+returned + matriz[i][i+1]);
            returned+= matriz[path[i]][path[i+1]];
        }
        return returned;
    }
    
    /**
     * Funçao que retorna o Dijkstra do {indexStart} para todos os outros pontos
      * @param M Interger[][] sendo a matriz de adjacencia do grafo 
     * @param indexStart index do ponto de inicio
     * @return returnOfPathFinderFunction[] sendo o vetor com um vetor de index
     * ( sendo o caminho ) e o custo do caminho
    */
    public static returnOfPathFinderFunction[] dijkistraForAll( int[][] M, int indexStart){
        int custo_dislocamento[] = new int[M.length];
        MyLinkedList<Integer> nao_visitados = new MyLinkedList<>();
        int antecessor[] = new int[M.length];
        for(int i = 0; i < M.length;i++){
            if(i == indexStart)
                antecessor[i] = indexStart;
            else
                antecessor[i] = M.length+1;
            custo_dislocamento[i] = Integer.MAX_VALUE/2;
            if(i != indexStart)
                nao_visitados.add(i);
        }
        custo_dislocamento[indexStart] = 0;
        for(int conectado : getConectados(M, indexStart)){
            custo_dislocamento[conectado] = M[indexStart][conectado];
            antecessor[conectado] = indexStart;
        }
        while( !( nao_visitados.isEmpty() ) ){
            int vertice_verificado = PathFinder.proximoVertice( custo_dislocamento , nao_visitados );
            nao_visitados.removeByContent(vertice_verificado);
            int[] conectados = getConectados(M, vertice_verificado);
            if( conectados != null ){
                for( int conectado : conectados ){
                    int custoNovo = custo_dislocamento[vertice_verificado] + M[vertice_verificado][conectado];
                    if( custoNovo < custo_dislocamento[conectado] ){
                        custo_dislocamento[conectado] = custoNovo;
                        antecessor[conectado] = vertice_verificado;
                    }
                }
            }
            if( nao_visitados.isEmpty() ){
               returnOfPathFinderFunction[] returned = new returnOfPathFinderFunction[M.length];
                for(int i =0; i< M.length; i++){
                    returned[i] = new returnOfPathFinderFunction();
                    if( i != indexStart ){
                        returned[i].setPath(PathFinder.pathMaker(indexStart, i, antecessor, M.length));
                        returned[i].setCost(PathFinder.costPath(returned[i].getPath(), M));
                    }else{
                        int[] temp = new int[1];
                        temp[0] = indexStart;
                        returned[i].setPath( temp );
                        returned[i].setCost(0);
                    }
                }
               return returned;
            }
        }
        return null;
    }
}
