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

public class NodeUsavel {
    private QualquerCoisa object;
    private NodeUsavel next;
    /**
    * construtor vazio
    */
    public NodeUsavel(){
    }
    
    /**
     *Contrutor inicializa objeto
     * @param content QualquerCoisa correspondente ao objeto a ser guardado neste nó
     */
    public NodeUsavel(QualquerCoisa content){
        this.object = content;
    }

    /**
     *  Função que define qual sera o proximo nó deste nó
     * @param nextObj NodeUsavel correspondente ao proximo nó deste nó
     */
    protected void setNext(NodeUsavel nextObj){
        this.next = nextObj;
    }
    
    /**
     *  Função que retorna o objeto desse nó
     * @return QuanquerCoisa correspondente ao objeto desse nó
     */
    protected QualquerCoisa getObject(){
    return this.object;
    }
    
    /**
     *  Função que retorna o proximo nó 
     * @return NodeUsavel correspondente ao proximo nó 
     */
    protected NodeUsavel getNext(){
        return this.next;
    }
}
