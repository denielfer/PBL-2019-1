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
 * Node de fila prioritaria com generics de conteudo e float de chave
 * @param <T> Classe que sera guardada no conteudo da estrutura
 */
public class NodePriorityQueue<T> {
    private T content;
    private NodePriorityQueue<T> next;
    private float priority;

    public NodePriorityQueue(T content, float priority) {
        this.content = content;
        this.priority = priority;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public NodePriorityQueue<T> getNext() {
        return next;
    }

    public void setNext(NodePriorityQueue<T> next) {
        this.next = next;
    }

    public float getPriority() {
        return priority;
    }

    public void setPriority(float priority) {
        this.priority = priority;
    }
    
    
}
