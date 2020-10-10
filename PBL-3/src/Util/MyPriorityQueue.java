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
package Util;

import Model.Computador;

/**
 * Fila de Prioridade Generica* com generics de conteudo
 * 
 * *: updateElemente é acoplada e especifica parra esse resoluçao deste problema
 * @param <T> Classe que sera guardada no conteudo da estrutura
 */
public class MyPriorityQueue<T> {
    private NodePriorityQueue<T> fist;
    private int size;
    
    /**
     * Construtor vazio
    */
    public MyPriorityQueue() {
    }
    
    /**
     * retorna o tamanho da lista
     * @return int contendo o tamanh oda lista
     */
    public int size() {
        return this.size;
    }
    /**
     * Função para adiciona elemento como primeiro elemento da lista
     * @param content Object contendo o elemento que deseja ser adicionado
     * @param key float sendo a prioridade de {content}
    */
    private void addFist( T content, float key ){
        NodePriorityQueue<T> node = new NodePriorityQueue<>( content, key );
        node.setNext(this.fist);
        this.fist = node;
        this.size++;
    }
    /**
     * Funçao que adiciona elementos ao final da lista
     *
     * @param content Object contendo o elemento que deseja ser adicionado
     * @param priority float correspondente a prioridade do conteudo
     */
    public void queue( T content, float priority ){
        NodePriorityQueue<T> aux = this.fist;
        if( this.fist == null || this.fist.getPriority() < priority ){
            this.addFist(content, priority);
        }else {
            while( aux.getNext() != null && aux.getNext().getPriority() >= priority ){
                aux = aux.getNext();
            }
            NodePriorityQueue<T> node = new NodePriorityQueue<>(content, priority);
            node.setNext(aux.getNext());
            aux.setNext(node);
            size++;
        }
    }
    /**
     * remove elemento por posição da lista
     *
     * @return Object que foi removido da lista
     */
    public T deQueue() {
        if (this.size == 0) {
            return null;
        }
        NodePriorityQueue<T> node = this.fist;
        this.fist = this.fist.getNext();
        node.setNext(null);
        this.size--;
        return node.getContent();
        
    }
    /**
     * Função que remove um computador e adiciona ele novamente na lista de computadores
     * 
     * @param elemento T que sera removido e readicionado
     * @param priority float contendo a prioridade de {elemento}
     * @return true se foi realizado com sucesso e false caso nao seja encontrado o elemento
    */
    public boolean updateElemente(T elemento, float priority){
        if(elemento == null){ 
            // se recebeu null retorne que nao foi feita a operaçao
            return false;
        }else if(this.fist == null){ 
// se a fila esta vazia adicioneo elemento e retorne que foi feita a operaçao
            this.queue(elemento, priority);
            return true;
        }// se nenhum for null
        NodePriorityQueue<T> aux = this.fist;
        // se nao for o primeiro
        if( ( (Computador) aux.getContent()).getName() != ((Computador) elemento).getName() ) {
            // mova até que o procimo do {aux} seja o que contem {elemento} ou ate o procimo ser null
            while( aux.getNext() != null && ((Computador) aux.getNext().getContent()).getName() != ((Computador) elemento).getName() ){
                aux = aux.getNext();
            }
            if( aux.getNext() == null )// se {elemento nao esta na lista}
                // retorne que a operaçao nao foi feita
                return false;
// fassa que o proximo de {aux} seja o procimo do no que comtem {elemento}
            aux.setNext(aux.getNext().getNext());
            // o tamanho diminuio em 1
            size--;
        }else{// ses for o primeiro, remova-o
            this.deQueue();
        }
        // adicione novamento o removido
        this.queue(elemento, priority);
        return true;
        
    }
    
     /**
     * Função que diz se a lista está vazia ou não
     *
     * @return boolean sendo true para está vazia e false para nao está vazia
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Funçao que retorna um iterador da lista
     *
     * @return Iterator contendo todos os elementos da lista
     */
    public IteratorMyPriorityQueue<T> iterator() {
        return new IteratorMyPriorityQueue<>(this.fist);
    }
    /**
     * Retorna o primeiro elemento da fila;
     * @return T sendo o comteudo do no do primeiro elemento da fila
    */
    public T getFist(){
        return this.fist.getContent();
    }
}