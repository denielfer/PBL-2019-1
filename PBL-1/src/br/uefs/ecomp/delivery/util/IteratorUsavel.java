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

public class IteratorUsavel implements java.util.Iterator {
    NodeUsavel ponteiro;
    
    /**
     * Construtor do iterator
     * @param head node que sera a "cabeça" do iterator
     */
    public IteratorUsavel(NodeUsavel head){   
        this.ponteiro = new NodeUsavel();
        this.ponteiro.setNext(head);
    }
    
    /**
     * Função que dira se existe proximo elemento 
     * @return true se existir um procimo elemento na lista e false caso contrario
     */
    @Override
    public boolean hasNext() {
        if(this.ponteiro == null)
            return false;
        return this.ponteiro.getNext() != null;
    }

    /**
     * Funçao que move o iterator pro procimo elemento e remove o elemento 
     * anterior da lsita do iterator
     * @return Object que estava no node removido
     */
    @Override
    public Object next() {
        if(ponteiro.getNext() == null)
            return null;
        NodeUsavel aux = this.ponteiro.getNext();
        this.ponteiro.setNext(this.ponteiro.getNext().getNext());
        aux.setNext(null);
        return aux.getObject();

    }
}
