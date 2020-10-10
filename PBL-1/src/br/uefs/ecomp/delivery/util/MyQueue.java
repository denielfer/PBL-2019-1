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
package br.uefs.ecomp.delivery.util;

public class MyQueue implements IQueue{
    private Node fist;
    private Node last;
    private int size;
    private ListaUsavel pedidosFechados;

    /**
     * construtor vazio
     */
    public MyQueue(){
    }
    
    /**
     *  Contrutor com inicialização
     * @param pedidosFechados ListaUsavel conrespondente a lista de pedidos fechados
     */
    public MyQueue(ListaUsavel pedidosFechados){
        this.pedidosFechados = pedidosFechados;
    }
    
    /**
     *  Função para adicionar um objeto na ultima posição da fila
     * @param data Object que sera adicionado na lista
     */
    @Override
    public void enqueue(Object data) {
        Node temp1 = new Node(data);
        if(this.fist == null)
            this.fist = temp1;
        if(this.last != null)
            this.last.setNext(temp1);
        this.last = temp1;
        size++;
    }

    /**
     * Função que remove o primeiro objeto da fila
     * @return Object correspondente ao objeto removido da fila
     */
    @Override
    public Object dequeue() {
        Node temp1 = this.fist;
        this.fist = this.fist.getNext();
        size--;
        temp1.setNext(null);
        return temp1.getObject();
    }

    /**
     *  Função que retorna o primeiro objeto da fila
     * @return Object correspondente ao primeiro objeto da lista
     */
    @Override
    public Object peek() {
        return this.fist.getObject();
    }

    /**
     *  Funçao que removera o primeiro elemento da fila de pedidos abertos e 
     * dicionara ele na lista de pedidos fechados
     */
    public void setNexttoPedidoFechado(){   
        this.pedidosFechados.add((QualquerCoisa) this.dequeue());
    }
    
    /**
     *  Função retorna o ultimo objeto da fila
     * @return Object correspondente ao ultimo objeto da fila
     */
    @Override
    public Object last() {
        return this.last.getObject();
    }

    /**
     *  Função que diz qual o tamanho da fila
     * @return int correspondente ao tamanho da fila
     */
    @Override
    public int size() {
        return size;
    }

    /**
     *  Função que diz se a fila esta vazia ou não
     * @return boolean sendo true para está vazia e false para não está vazia
     */
    @Override
    public boolean isEmpty() {
        return this.fist == null;
    }
}
