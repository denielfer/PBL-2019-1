/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Daniel Fernandes Campos
 * Data: 21/06/2019
 *
 * Declaro que este código foi elaborado por mim de forma individual e
 * não contém nenhum trecho de código de outro colega ou de outro autor,
 * tais como provindos de livros e apostilas, e páginas ou documentos
 * eletrônicos da Internet. Qualquer trecho de código de outra autoria que
 * uma citação para o  não a minha está destacado com  autor e a fonte do
 * código, e estou ciente que estes trechos não serão considerados para fins
 * de avaliação. Alguns trechos do código podem coincidir com de outros
 * colegas pois estes foram discutidos em sessões tutorias.
 */
package util;

public class MyLinkedList implements IList {

    protected int size = 0;
    protected Node fist;
    protected Node last;

    /**
     * retorna o tamanho da lista
     *
     * @return int contendo o tamanh oda lista
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Função para adiciona elemento como primeiro elemento da lista
     *
     * @param obj Object contendo o elemento que deseja ser adicionado
     */
    public void addFist(Object obj) {
        Node temp = new Node(obj);
        temp.setNext(this.fist);
        if (this.fist == null) {
            this.last = temp;
        }
        this.fist = temp;
        this.size++;
    }

    /**
     * Funçao que adiciona elementos ao final da lista
     *
     * @param obj Object contendo o elemento que deseja ser adicionado
     */
    @Override
    public void add(Object obj) {
        Node temp = new Node(obj);
        if (fist == null) {
            this.fist = temp;
        } else {
            this.last.setNext(temp);
        }
        this.last = temp;
        size++;
    }

    /**
     * Funçao que adiciona elementos em uma dada posiçao tal que 0 é a 1ª
     * possiçao e size()-1 é a ultima
     *
     * * @param pos possição que se deseja adicionar o objeto na lista
     * * @param obj Object contendo o elemento que deseja ser adicionado
     */
    @Override
    public boolean add(int pos, Object obj) {
        if (pos > size() || pos < 0) {
            return false;
        }
        if (pos == 0 || this.fist == null) {
            this.addFist(obj);
            return true;
        }

        int cont = 0;
        Node temp1 = fist;// variavel que aponta para o no anterior a onde sera inserido

        while (cont < pos - 1) {
            temp1 = temp1.getNext();
            cont++;
        }
        Node temp2 = new Node(obj);
        temp2.setNext(temp1.getNext());
        temp1.setNext(temp2);
        size++;
        return true;
    }

    /**
     * remove elemento por posição da lista
     *
     * @param pos int correspondente a posição que deseja remover o objeto
     * @return Object que foi removido da lista
     */
    @Override
    public Object remove(int pos) {
        if (pos >= size() || pos < 0 || this.size == 0) {
            return null;
        }
        Node temp1 = fist;// variavel que aponta para o no anterior ao que sera removido, caso nao primeiro.
        if (pos == 0) {
            fist = fist.getNext();
            this.size--;
            return temp1.getObject();
        }
        int cont = 0;
        Node temp2 = fist.getNext(); // variavel que aponta para o objeto que eliminado
        while (cont < pos - 1) {
            temp1 = temp1.getNext();
            temp2 = temp2.getNext();
            cont++;
        }
        temp1.setNext(temp2.getNext());
        this.size--;
        temp2.setNext(null);
        return temp2.getObject();

    }

    /**
     * retorna o objeto da posiçao index-1 sendo 0 a 1ª posiçao e size()-1 a
     * ultima posiçao
     *
     * @return Recomendado fazer casting
     */
    @Override
    public Object get(int index) {
        if (index < 0) {
            return null;
        } else if (this.fist == null) {
            return null;
        } else if (index == 0) {
            return fist.getObject();
        }
        Node temp1 = fist.getNext();
        int cont = 0;
        while (cont < index - 1) {
            temp1 = temp1.getNext();
            cont++;
        }
        return temp1.getObject();
    }

    /**
     * Função que diz se a lista está vazia ou não
     *
     * @return boolean sendo true para está vazia e false para nao está vazia
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Funçao que retorna um iterador da lista
     *
     * @return Iterator contendo todos os elementos da lista
     */
    @Override
    public Iterator iterator() {
        return new Iterator(this.fist);
    }

}
