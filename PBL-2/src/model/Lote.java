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


public class Lote {

    private String data;
    private int vagasOcupadas;
    private int vagasTotais;
    private Procedimento procedimento;

    /**
     * Construtor sem o id em hex code
     */
    public Lote(Procedimento procedimento, int vagasTotais, String data) {
        this.data = data;
        this.vagasTotais = vagasTotais;
        this.procedimento = procedimento;
        this.vagasOcupadas = 0;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setQuantidade(int vagasTotais) {
        this.vagasTotais = vagasTotais;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    /**
     * Esta funçao soma 1 no numero de vagas ocupadas
     *
     * @return true se der pra adicionar e false caso nao seja pocivel;
     */
    public boolean ocuparVaga() {
        if (this.vagasOcupadas == this.vagasTotais) {
            return false;
        }
        vagasOcupadas++;
        return true;
    }

    public int getVagasOcupadas() {
        return vagasOcupadas;
    }

    public int getQuantidade() {
        return vagasTotais;
    }

    public Procedimento getProcedimento() {
        return this.procedimento;
    }

    public String getData() {
        return this.data;
    }

    public int getVagasRestantes() {
        return this.getQuantidade() - this.getVagasOcupadas();
    }

    /**
     * Esta funçao faz a comparaçao entre este lote e um que sera passado, se
     * eles guardam a mesma data e o mesmo Procedimento
     *
     * @param lot Lote ao qual esse sera comparado
     * @return True se tiverem mesma data e mesmo Procedimento e false caso
     * contrario
     */
    public boolean equals(Lote lot) {
        return this.data == lot.getData() && this.procedimento.equals(lot.getProcedimento());
    }

}
