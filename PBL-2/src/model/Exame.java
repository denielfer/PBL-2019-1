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

public class Exame extends Procedimento {

    private String Recomendacoes, restriçoes;

    public Exame(String medico, String sala, String especialidade, String recomendaçoes, String restriçoes) {
        super(sala, especialidade, medico);
        this.Recomendacoes = recomendaçoes;
        this.restriçoes = restriçoes;
    }

    public String getRecomendacoes() {
        return Recomendacoes;
    }

    public void setRecomendacoes(String recomendaçoes) {
        this.Recomendacoes = recomendaçoes;
    }

    public String getRestricoes() {
        return restriçoes;
    }

    public void setRestricoes(String restriçoes) {
        this.restriçoes = restriçoes;
    }

    public String getTipo() {
        return especialidade;
    }

    public void setTipo(String Tipo) {
        this.especialidade = Tipo;
    }

}
