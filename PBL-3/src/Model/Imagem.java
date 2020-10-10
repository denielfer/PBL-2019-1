/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Daniel Fernandes Campos e Esdras Evangelista de sena santos
 * Data: 18/08/2019
 *
 * Declaro que este código foi elaborado pela dupla de forma individual e
 * não contém nenhum trecho de código de outro colega ou de outro autor,
 * tais como provindos de livros e apostilas, e páginas ou documentos
 * eletrônicos da Internet. Qualquer trecho de código de outra autoria que
 * uma citação para o  não a minha está destacado com  autor e a fonte do
 * código, e estou ciente que estes trechos não serão considerados para fins
 * de avaliação. Alguns trechos do código podem coincidir com de outros
 * colegas pois estes foram discutidos em sessões tutorias.
 */
package Model;

public class Imagem {
    protected String name;
    protected float tamanho;
    /**
     * Construtor com nome de tamanho
    */
    public Imagem() {
    }
    
    /**
     * Construtor com nome de tamanho
     * @param name String sendo o nome da imagem
     * @param peso float sendo o tamanho da imagem
     */
    public Imagem(String name, float peso) {
        this.name = name;
        this.tamanho = peso;
    }

    /**
     * Retorna o nome da Imagem
     * @return String sendo o nome da imagem
     */
    public String getName() {
        return name;
    }

    /**
     * Retorna o tamanho da imagem
     * @return float sendo o tamanho da imagem
     */
    public float getTamanho() {
        return tamanho;
    }
    /**
     * Modifica o nome da imagem
     * @param name String sendo o novo nome da imagem
    */
    public void setName(String name){
        this.name = name;
    }
    /**
     * Modifica o tamanho da imagem
     * @param tamanho int sendo o novo tamanho da imagem
    */
    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }
    
}
