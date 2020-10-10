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
 * Node de arvore com generics de conteudo
 * @param <T> Class do conteudo guardado dentro
 */
public class NodeTree<T> {
    private T content;
    private String chave;
    private int altura;
    private NodeTree<T> right;
    private NodeTree<T> left;

    public NodeTree(T content, String chave) {
        this.content = content;
        this.altura = 1;
        this.chave = chave;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    public int getAltura() {
        return altura;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public NodeTree() {
        this.altura = 1;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public NodeTree<T> getRight() {
        return this.right;
    }

    public void setRight(NodeTree<T> next) {
        this.right = next;
    }

    public NodeTree<T> getLeft() {
        return this.left;
    }

    public void setLeft(NodeTree<T> next) {
        this.left = next;
    }
    
}
