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
package Util.EstruturaDeDados;

public class GrafoMatriz {
    private int matriz[][];
    private int tamanho;

    public GrafoMatriz() {
    }
    
    
    
    public GrafoMatriz( int tamanho ) {
        this.matriz = new int[tamanho][tamanho];
        this.tamanho = tamanho;
        this.matriz = this.inicializarMatriz( this.matriz, this.tamanho );
    }
    
    /**
     * edita o valor de uma ligaçao
     * @param index1 index da linha da matriz
     * @param index2 index da coluna da matriz
     * @param novo_valor novo valor que sera colocado na posiçao 
     * [ {index1} ][ {index2} ] da matriz
     * @return int sendo o tipo antigo do vertice ou -Integer.MAX_VALUE caso 
     * tenha sido passado [index1] != [index2]
     */
    public int EditarTipoVertice(int index1, int index2, int novo_valor){
        if(index1 == index2){
            int returned = this.matriz[index1][index2];
            this.matriz[index1][index2] = novo_valor;
            return returned;
        }
        return -Integer.MAX_VALUE;
    }
    /**
     * Adiciona 1 vertice a matriz de adijacencias
    */
    public void addVertice(){
        tamanho++;
        int temp[][] = new int[this.tamanho][this.tamanho];
        temp = this.inicializarMatriz( temp,this.tamanho);
        for(int i = 0; i<this.tamanho - 1; i++){
            for(int j = 0; j<this.tamanho -1 ; j++){
                temp[i][j] = this.matriz[i][j];
            }
        }
        this.matriz = temp;
    }
    /**
     * remover o vertice no index {indexDoVertice}da matriz de adijacencias
     * @param indexDoVertice index do vertice que sera removido
    */
    public void removerVertice(int indexDoVertice){
        int temp[][] = new int[this.tamanho -1][this.tamanho -1 ];
        temp = this.inicializarMatriz( temp, this.tamanho-1 );
        int newI = 0;
        for(int i = 0; i<this.tamanho; i++){
            if( indexDoVertice == i )
                continue;
            int newJ = 0;
            for(int j = 0; j<this.tamanho; j++){
                if(indexDoVertice == j){
                    continue;
                }
                temp[newI][newJ] = this.matriz[i][j];
                newJ++;
            }
            newI++;
        }
        this.matriz = temp;
        this.tamanho--;
    }
    
    /**
     * Funçao que reescreve os valores da matriz em : [ {indexP1} ][ {indexP2} ] 
     * e [ {indexP2} ][ {indexP1} ] colocando {peso no lugar}
     * @param indexP1 index do ponto 1
     * @param indexP2 index do ponto 2
     * @param peso valor da coneção entre eles
    */
    public void adicionarLigaçao( int indexP1, int indexP2, int peso){
        this.matriz[indexP1][indexP2] = peso;
        this.matriz[indexP2][indexP1] = peso;
    }
    /**
     *
     * @param indexP1 index do ponto 1
     * @param indexP2 index do ponto 2
     * @return boolean sendo true se removeu e false caso passou index erado
    */
    public boolean removerLigaçao( int indexP1, int indexP2){
        if( indexP1 != indexP2 ){
            this.matriz[indexP1][indexP2] = 0;
            this.matriz[indexP2][indexP1] = 0;
            return true;
        }
        return false;
    }

    /**
     * Retorna o numero de elementos ( vertices ) no grafo
     * @return int sendo o numero de elementos ( vertices ) no grafo
    */
    public int getNumVertices() {
        return tamanho;
    }
    /**
     *Retorna o valor da interceçao entre {indexP1} e {indexP2}
     * @param indexP1 index do ponto 1
     * @param indexP2 index do ponto 2
     * @return Object na ligaçao entre {indexP1} e {indexP2}
    */
    public Object getLigaçao( int indexP1, int indexP2){
        return this.matriz[indexP1][indexP2];
    }
    /**
     * Troca todos os valores da matris para 0, quando cria uma matris seja pra
     * adicionar vertice ou quando cria do zero existe um numm la
     * @param matriz Object[][] sendo uma matriz de que todos os valores se tornarao 0
     * @param tamanho da matriz, sendo o numero de colunas = numero de linhas
     * @return Object[][] sendo a matriz zerada
     *  
    */
    private int[][] inicializarMatriz( int matriz[][], int tamanho){
        for(int i =0; i<tamanho; i++){
            for(int j =0; j< tamanho; j++)
                matriz[i][j] = 0;
        }
        return matriz;
    }
   /**
    * Retorna a matriz de adjacencia do grafo
    * @return Object[][] sendo uma matriz de integer e a matriz de adjacencia
   */
    public int[][] getMatriz(){
        return this.matriz;
    }
    
}
