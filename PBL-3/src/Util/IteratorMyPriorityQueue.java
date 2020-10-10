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
 * Iterator genirico para Fila de prioridade com generics de conteudo e float de prioridade
 * @param <T>
 */
public class IteratorMyPriorityQueue<T> {
        
    NodePriorityQueue<T> ponteiro;
    
    /**
     * Construtor do iterator
     *
     * @param temp node que sera a "cabeça" do iterator
     */
    public IteratorMyPriorityQueue( NodePriorityQueue<T> temp) {
        this.ponteiro = temp;
    }
    /**
     * Função que dira se existe proximo elemento
     *
     * @return true se existir um procimo elemento na lista e false caso
     * contrario
     */
    public boolean hasNext() {
        return this.ponteiro != null;
    }

    /**
     * Funçao que move o iterator pro procimo elemento e remove o elemento
     * anterior da lsita do iterator
     *
     * @return Object que estava no node removido
     */
    public T next() {
        NodePriorityQueue<T> aux = this.ponteiro;
        if (this.ponteiro == null) {
            return null;
        } else {
            this.ponteiro = this.ponteiro.getNext();
        }
        return aux.getContent();
    }
}
