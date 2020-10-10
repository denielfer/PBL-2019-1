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

public class Cardapio extends QualquerCoisa {
    private String descricao;
    private double price;

    /**
     * Construtor vazio
     */
    public Cardapio() {
    } 
    
    /**
     *  Contrutor com iniciação das variaveis
     * @param descricao Nome da opçao
     * @param price Preço da opçao
     */
    public Cardapio(String descricao, double price) {
        this.descricao = descricao;
        this.price = price;
    }

    /**
     *  Pega nome da opçao
     * @return  String cotendo o nome da opçao
     */
    @Override
    public String getDescricao() {
        return this.descricao;
    }

    /**
     *  Modifica o nome da opçao
     * @param descriçao String que sera colocada no nome da opçao
     */
    @Override
    public void setDescricao(String descriçao) {
        this.descricao = descriçao;
    }

    /**
     *  Retorna o valor da opçao
     * @return Double correspondente ao valor do prato
     */
    @Override
    public double getValor() {
        return this.price;
    }

    /**
     * Modifica valor da opçao
     * @param price Double que subistituira o valor da opçao
     */
    @Override
    public void setValor(double price) {
        this.price = price;
    }

    /**
     *  Testa se o Cardapio é igual a outro Cardapio verificando se descrição e preço sao iguals
     * @param obj Cardapio para comparaçao
     * @return  true se os 2 tiverem todos os atributos de mesmo valor ou false caso contrario
     */
    @Override
    public boolean equals(Cardapio obj){
        boolean test1 = this.descricao == obj.getDescricao();
        boolean test2 = this.price == obj.getValor();
        return test1 == true && test2 == test1;
    }
    
}
