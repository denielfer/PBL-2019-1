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
package br.uefs.ecomp.delivery.model;
import br.uefs.ecomp.delivery.util.*;

public class System {
    private final ListaUsavel clientList;
    private final ListaUsavel menuList;
    private final ListaUsavel Pedidos;
    private final ListaUsavel pedidosFechados;
    private final MyQueue pedidosAbertos;

    /**
     *construtor que inicializa as listas e a fila do system
     */
    public System(){
        this.menuList = new ListaUsavel();
        this.clientList = new ListaUsavel();
        Pedidos = new ListaUsavel();
        pedidosFechados = new ListaUsavel();
        pedidosAbertos = new MyQueue(pedidosFechados);
    }
    
    /**
     *  Retoran uma fila de pedidos abertos
     * @return MyQueue de pedidos em abertos
     */
    public MyQueue getPedidosAbertos(){
        return this.pedidosAbertos;
    }
    
    /**
     *  Retorna a lista de pedidos fechados
     * @return ListaUsavel de pedidos fechados
     */
    public ListaUsavel getPedidosFechados(){
        return this.pedidosFechados;
    }

    /**
     *  Retorna uma lista de clientes cadastrados
     * @return ListaUsavel de clientes
     */
    public ListaUsavel getClientes(){
        return clientList;
    }
    
    /**
     *  Retorna uma lista do cardapio cadastrado
     * @return ListaUsavel do cardapio
     */
    public ListaUsavel getCardapio(){
        return menuList;
    }
    
    /**
     *  Adiciona um pedido a lista de pedidos abertos
     * @param data correspondente ao horario que o pedido foi feito
     */
    public void addOrder(QualquerCoisa data){
        this.Pedidos.add(data);
    }
    
    /**
     * Retorna uma lista de pedidos abertos
     * @return ListaUsavel de pedidos abertos
     */
    public ListaUsavel getPedidos(){
        return this.Pedidos;
    }
    
    /**
     *  Retorna o iterator da lista de clientes
     * @return IteratorUsavel da lista de clientes
     */
    public IteratorUsavel iterator() {
        return new IteratorUsavel(this.clientList.getHead());
    }
}   
