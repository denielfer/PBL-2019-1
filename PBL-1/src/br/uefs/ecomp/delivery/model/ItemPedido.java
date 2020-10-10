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

import br.uefs.ecomp.delivery.util.QualquerCoisa;

public class ItemPedido extends QualquerCoisa{
    private Pedido pedido; /// AVALIAR REMOÇAO DESTA VARIAVEL **********************************
    private Cardapio opcaoMenu;
    private int quantidade;
    private String modificacao;

    /**
     *  Construtor vazio
     */
    public ItemPedido(){
    }

    /**
     *  Contrutor com inicialização
     * @param pedido Pedido que sera guardado no objeto e que terra esse objeto adicionado a sua lsita de itensPedidos
     * @param prato Cardapio correspondente a opção do menu escolhida
     * @param quantidade Int correspondente a quantidade de vezes que a opçao do menu ( prato ) foi escolhida
     * @param descriçao String contendo possiveis observaçoes
     */
    public ItemPedido(Pedido pedido,  Cardapio prato, int quantidade, String descriçao) {
        this.pedido = pedido;
        this.opcaoMenu = prato;
        this.quantidade = quantidade;
        this.modificacao = descriçao;
        this.update();
        
    }
        /**
     *  Contrutor com inicialização
     * @param prato Cardapio correspondente a opção do menu escolhida
     * @param quantidade Int correspondente a quantidade de vezes que a opçao do menu ( prato ) foi escolhida
     * @param descriçao String contendo possiveis observaçoes
     */
    public ItemPedido( Cardapio prato, int quantidade, String descriçao) {
        this.opcaoMenu = prato;
        this.quantidade = quantidade;
        this.modificacao = descriçao;
        
    }
    /**
    * Funçao responçavel por adicionar esse objeto no pedido
    */
    private void update(){
        this.pedido.addItem(this);
    }
    
    /**
     *  Retorna o pedido ao qual esse item pertence
     * @return Pedido ao qual esse item pertence
     */
    public Pedido getPedido() {
        return this.pedido;
    }
    
    /**
     *  Retorna a opção do menu escolhida
     * @return Cardapio correspondente a opção do menu escolhida
     */
    public Cardapio getOpcaoMenu() {
        return this.opcaoMenu;
    }
    
    /**
     *  Retorna a quantidade de vezes que a opção do menu foi escolhida
     * @return  int correspondente a quantidade de vezes que a opção do menu foi escolhida
     */
    public int getQuantidade() {
        return this.quantidade;
    }

    /**
     *  Modifica a qual pedido esse item pertence
     * @param pedido Pedido a qual esse item pertence
     */
    public void setPedido(Pedido pedido) {
        pedido.update(this);
        this.pedido = pedido;
    }
    
    /**
     *  Modifica a quantidade de vezes que a opção do menu foi escolhida
     * @param quantidade int correspondente a nova quantidade de vezes que a opção do menu foi escolhida
     */
    @Override
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     *  Retorna a observação sobre a opção do menu escolhida
     * @return String contendo a observação sobre a opção do menu escolhida
     */
    public String getObservacao() {
        return this.modificacao;
    }

    /**
     *  Modifica a observação sobre a opção do menu escolhida
     * @param descriçao String contendo a observação sobre a opção do menu escolhida
     */
    public void setObservacao(String descriçao) {
        this.modificacao = descriçao;
    }


    
    
    
}
