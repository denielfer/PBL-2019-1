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

public class Node {
    private Object object;
    private Node next;
    /**
    * construtor vazio
    */
    public Node(){
    }
    
    /**
     * Contrutor inicializa objeto
     * @param content Object correspondente ao objeto que ficara neste nó
     */
    public Node(Object content){
        this.object = content;
    }

    /**
     *  Função para definir qual o proximo nó deste nó
     * @param nextObj Node correspondente ao proximo nó
     */
    protected void setNext(Node nextObj){
        this.next = nextObj;
    }
    
    /**
     *  Função que retorna o objeto presente no nó
     * @return Object correspondente ao objeto presente no nó
     */
    protected Object getObject(){
    return this.object;
    }
    
    /**
     *  Função que retorna o proximo nó 
     * @return Node correspondente ao proximo nó
     */
    protected Node getNext(){
        return this.next;
    }    
}
