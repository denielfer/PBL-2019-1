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

public class Cliente extends QualquerCoisa{
        private String name;
        private String foneNumber;
        private String email;
        
    /**
     * Construtor vazio
     */
    public Cliente(){
        }
     /**
     *construçao e inicialização cliente
     * 
     * @param name String com o nome do cliente
     * @param foneNumber String com o nome do cliente
     * @param email String com o email do cliente
    */
    public Cliente (String name, String foneNumber, String email){
        this.name=name;
        this.foneNumber = foneNumber;
        this.email = email;
    }

    /**
     *  Retorna o nome do cliente
     * @return  String cotendo o nome do cliente
     */
    public String getName() {
        return name;
    }

    /**
     *  Modifica o nome do cliente
     * @param name String cotendo novo nome do cliente
     */
        @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     *  Retorna uma String com o numero do cliente
     * @return String cotendo o numero do cliente
     */
        @Override
    public String getPhone() {
        return foneNumber;
    }

    /**
     *  Modifica o numero de um cliente
     * @param foneNumber String cotendo no novo numero do cliente
     */
        @Override
    public void setPhone(String foneNumber) {
        this.foneNumber = foneNumber;
    }

    /**
     *  Retorna uma String contendo o email do cliente
     * @return String cotendo o email do cliente
     */
        @Override
    public String getEmail() {
        return email;
    }

    /**
     *  Modifica o email do cliente 
     * @param email String contendo o email do cliente
     */
        @Override
    public void setEmail(String email) {
        this.email = email;
    }
        
    /**
     *  Compara se um cliente é igual a este cliente
     * @param obj Cliente para comparação
     * @return true se todos os atributos forem igual ou false caso contrario
     */
        @Override
    public boolean equals(Cliente obj){
     boolean temp1 = this.email == obj.getEmail();
     boolean temp2 = this.foneNumber == obj.getPhone();
     boolean temp3 = this.name == obj.getName();
     return temp1 == true && temp1 == temp3 == temp2;
    }

}
