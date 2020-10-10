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
import br.uefs.ecomp.delivery.util.ListaUsavel;
import br.uefs.ecomp.delivery.util.QualquerCoisa;
import java.util.Date;

public class Pedido extends QualquerCoisa{
    private Cliente client;
    private String endereço;
    private ListaUsavel itens;
    private boolean situaçao;
    private Date dataHora;
    
    /**
     *  Construtor que apenas inicializa lista de itens pedidos
     */
    public Pedido(){
        this.itens = new ListaUsavel();
    }

    /**
     *  Construtor que inicializa objeto inteiro
     * @param client Cliente ao qual o pedido é associado
     * @param data Data correspondente a hora e data do pedido
     * @param endereço String contendo o endereço que deve ser entrege o pedido
     * @param status Boolean que guarda true se o pedido nao foi encerado ainda e false caso contario
     */
    public Pedido(Cliente client, Date data, String endereço, boolean status) {
        this.itens = new ListaUsavel();
        this.client = client;
        this.endereço = endereço;    
        this.dataHora = data;
        this.situaçao = status;
        
        
    }

    /**
     *  Retorna o cliente ao qual o pedido é associado
     * @return Cliente ao qual o pedido é associado
     */
    @Override
    public Cliente getCliente() {
        return client;
    }
    
    /**
     *  Adiciona um item a lista de itens do pedido
     * @param item  ItemPedido que sera adicionado a Lista de Itens Pedidos
     */
    @Override
    protected void addItem(ItemPedido item){
        this.itens.add(item);
    }

    /**
     *  Retorna a Data e hora do pedido
     * @return Data correspondente a quando o pedido foi feito
     */
    @Override
    public Date getDataHora() {
        return dataHora;
    }
    
    /**
     *  Retoran se o pedido esta abeto ou fechado
     * @return true se o pedido estiver aberto ainda e false caso fechado
     */
    @Override
    public boolean getSituacao() {
        return situaçao;
    }
    
    /**
     *  Função que adiciona um item a lista de itens pedidos
     * @param item ItemPedido que sera adicionado a lista de itens pedidos
     */
    @Override
    public void update(ItemPedido item){
        this.itens.add(item);
    }
    
    /**
     *  Modifica o endereço da entrega
     * @param endereço String correspondente ao novo endereço da entrega
     */
    @Override
    public void setEndereco(String endereço) {
        this.endereço = endereço;
    }
    
    /**
     *  Retorana o enderço da entrega
     * @return String com o endereço de entrega
     */
    @Override
    public String getEndereco() {
        return endereço;
    }

    /**
     *  Retorna a lista de itens do pedido
     * @return ListaUsavel lista que conten os itens pedidos do pedido
     */
    @Override
    public ListaUsavel getItens() {
        return this.itens;
    }
    /**
    * Calcula o vator total do pedido
    * @return double contendo o valor do pedido
    */    
    
    private double calcularValorTotal(){
        double total = 0;
        QualquerCoisa temp1;
        Cardapio temp2;
        for(int i = 0; i < this.itens.size(); i++){
            temp1 = (ItemPedido )this.itens.get(i);
            temp2 = temp1.getOpcaoMenu();
            total += temp1.getQuantidade() * temp2.getValor();
        }
        return total;
    }
    
    /**
     *Modifica o status do pedido para fechado
     */
    @Override
    public void setFechado(){
        this.situaçao = false;
    } 

    /**
     *  Retorna a situação do pedido
     * @return  true se o pedido estiver aberta ou false caso fecahdo
     */
    @Override
    public boolean getSituaçao() {
        return situaçao;
    }
    
    /**
     * Retorna o valor total do pedido
     * @return  Double correspondete ao valor total do pedido
     */
    @Override
    public double getValorTotal(){
        return calcularValorTotal();
    }
    
    
}
