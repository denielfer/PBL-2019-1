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

public class FileInfo {
    private String text;
    private int numLines;
    /**
     * Construtor vazio
    */
    public FileInfo() {
    }

    /**
     * Construtor com texto e numero de linhas
     * @param text String sendo o texto que sera salvo
     * @param numLines int sendo o numero de linhas salvo
     */
    public FileInfo(String text, int numLines) {
        this.text = text;
        this.numLines = numLines;
    }
    
    /**
     * Retorna o texto salvo neste objeto
     * @return String sendo o texto que ta salvo neste objeto
     */
    public String getText() {
        return text;
    }

    /**
     * Modifica o texto salvo neste objeto
     * @param text String sendo o novo testo salvo neste objeto
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Retorna o {numLines} deste objeto
     * @return int sendo o numeoro de linhas salva neste objeto
     */
    public int getNumLines() {
        return numLines;
    }

    /**
     * Modifica o {numLines} deste objeto
     * @param numLines int sendo o novo numero do {numLines} deste objeto
     */
    public void setNumLines(int numLines) {
        this.numLines = numLines;
    }
    
    
}
