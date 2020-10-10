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

/**
 * Fila de lista Generica com generics de conteudo
 * 
 * @param <T> Classe que sera guardada no conteudo da estrutura
 */
public class MyLinkedList<T> {
    private NodeList<T> fist;
    private NodeList<T> last;
    private int size;
    
     /**
     * retorna o tamanho da lista
     *
     * @return int contendo o tamanh oda lista
     */
    public int size() {
        return this.size;
    }
    /**
     * Função para adiciona elemento como primeiro elemento da lista
     *
     * @param content Object contendo o elemento que deseja ser adicionado
     */
    public void addFist( T content ){
        NodeList<T> node = new NodeList<>( content );
        node.setNext(this.fist);
        if( this.fist == null ){
            this.last = node;
        }
        this.fist = node;
        this.size++;
    }
    /**
     * Funçao que adiciona elementos ao final da lista
     *
     * @param content Object contendo o elemento que deseja ser adicionado
     */
    public void add( T content ){
        if( this.fist == null ){
            this.addFist(content);
        }else {
            NodeList<T> node = new NodeList<>( content );
            this.last.setNext(node);
            this.last = node;
            size++;
        }
    }
    /**
     * Funçao que adiciona elementos em uma dada posiçao tal que 0 é a 1ª
     * possiçao e size()-1 é a ultima
     *
     * @param poss possição que se deseja adicionar o objeto na lista
     * @param content Object contendo o elemento que deseja ser adicionado
     * @return true se foir adicionado ou false cao contrario.
     */
    public boolean addAt(int poss, T content){
        if( poss < 0 || poss > this.size  ){
            return false;
        }else if(poss == 0 || this.fist == null){
            this.addFist(content);
        }else{
        int cont = 0;
            NodeList<T> temp1 = fist;// variavel que aponta para o no anterior a onde sera inserido

            while (cont < poss - 1) {
                temp1 = temp1.getNext();
                cont++;
            }
            NodeList<T> temp2 = new NodeList<>(content);
            temp2.setNext(temp1.getNext());
            temp1.setNext(temp2);
            size++;
        }
        return true;
    }
    
        /**
     * remove elemento por posição da lista
     *
     * @param pos int correspondente a posição que deseja remover o objeto
     * @return Object que foi removido da lista
     */
    public T remove(int pos) {
        if (pos >= this.size || pos < 0 || this.size == 0) {
            return null;
        }
        NodeList<T> temp1 = fist;// variavel que aponta para o no anterior ao que sera removido, caso nao primeiro.
        if (pos == 0) {
            fist = fist.getNext();
            this.size--;
            return temp1.getContent();
        }
        int cont = 0;
        NodeList<T> temp2 = fist.getNext(); // variavel que aponta para o objeto que eliminado
        while (cont < pos - 1) {
            temp1 = temp1.getNext();
            temp2 = temp2.getNext();
            cont++;
        }
        temp1.setNext(temp2.getNext());
        this.size--;
        temp2.setNext(null);
        return temp2.getContent();

    }

    /**
     * retorna o objeto da posiçao index-1 sendo 0 a 1ª posiçao e size()-1 a
     * ultima posiçao
     *
     * @param index index do elemento desejado
     * @return Recomendado fazer casting
     */
    public T get(int index) {
        if (index < 0 || index > this.size) {
            return null;
        } else if (this.fist == null) {
            return null;
        } else if (index == 0) {
            return fist.getContent();
        }
        NodeList<T> temp1 = fist.getNext();
        int cont = 0;
        while (cont < index - 1) {
            temp1 = temp1.getNext();
            cont++;
        }
        return temp1.getContent();
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
    public Iterator<T> iterator() {
        return new Iterator<>(this.fist);
    }
}
