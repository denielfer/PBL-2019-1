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


public class Paciente {

    private String name;
    private String cpf;
    private String telefone;
    private String nacimento;

    public String getNome() {
        return this.name;
    }

    public void setNome(String name) {
        this.name = name;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Construtor vazio;
     */
    public Paciente() {
    }

    ;
    /**
    * Construtor com todos os atributos
     * @param name String contendo o nome;
     * @param cpf String contendo o CPF;
     * @param telefone String contendo o telefone;
     * @param nacimento String contendo a data de nacimento que deve ser passada em DD/MM/AAAA.
    */
    public Paciente(String name, String cpf, String telefone, String nacimento) {
        this.name = name;
        this.cpf = cpf;
        this.telefone = telefone;
        this.nacimento = nacimento;
    }

    public String getDataNascimento() {
        return this.nacimento;
    }

    public void setDataNascimento(String dataDeNacimento) {
        this.nacimento = dataDeNacimento;
    }

    /**
     * Esta funçao faz a comparaçao entre este Paciente e um que sera passado,
     * se tem o mesmo cpf e se o nome é igual.
     *
     * @param p Paciente ao qual esse sera comparado, por cpf e nome.
     * @return True se tiverem o mesmo cpf e false caso contrario
     */
    public boolean equals(Paciente p) {
        return this.cpf == p.getCpf() && this.name.contentEquals(p.getNome());
    }

}
