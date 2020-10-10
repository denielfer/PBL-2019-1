/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Daniel Fernandes Campos
 * Data: 25/07/2019
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
package model;


public class Procedimento {

    protected String sala;
    protected String especialidade;
    protected String medico;

    public Procedimento() {
    }

    /**
     * Construtor com sala e medico apenas.
     *
     * @param sala String contendo a sala onde o Procedimento ocorera;
     * @param medico String contendo o nome do medico que realizara o
     * Procedimento.
     */
    public Procedimento(String medico, String sala) {
        this.sala = sala;
        this.medico = medico;
    }

    /**
     * Construtor com todos os atributos
     *
     * @param sala String contendo a sala onde o Procedimento ocorera;
     * @param especialidade String cotendo a especiolidade do Procedimento;
     * @param medico String contendo o nome do medico que realizara o
     * Procedimento.
     */
    public Procedimento(String sala, String especialidade, String medico) {
        this.sala = sala;
        this.especialidade = especialidade;
        this.medico = medico;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    /**
     * Faz a comparaçao de 2 Procedimentos e retorna se forem iguais
     *
     * @param proc Procedimento ao qual sera comparado
     * @return Boolean sendo true para iguais e false para diferentes
     */
    public boolean equals(Procedimento proc) {
        return this.especialidade == proc.getEspecialidade() && this.sala == proc.getSala();

    }
}
