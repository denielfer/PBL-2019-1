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
package Util.EstruturaDeDados;

/**
 * Node para lista generica com generics de conteudo
 * @param <T> Classe que sera guardada no conteudo da estrutura
 */
public class NodeList<T> {
    private T content;
    private NodeList<T> next;

    public NodeList() {
    }
    /**
     * Construtor com conteudo
     * @param content T sendo o conteudo do no
     */
    public NodeList(T content) {
        this.content = content;
    }
    /**
     * Construtor com conteudo
     * @return T sendo o conteudo do no
     */
    public T getContent() {
        return content;
    }
    /**
     * funçao que modifica o conteudo do no
     * @param content T sendo o novo conteudo do no
    */
    public void setContent(T content) {
        this.content = content;
    }
    /**
     * funçao que retorna o proximo no deste
     * @return NodeList sendo o proximo no deste
     */
    public NodeList<T> getNext() {
        return next;
    }
    /**
     * funçao que modifica o proximo no deste no
     * @param next NodeList sendo o proximo no deste no
    */
    public void setNext(NodeList<T> next) {
        this.next = next;
    }
    
}
