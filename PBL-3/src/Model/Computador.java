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

import Excptions.InsufficientMemoryExceptrion;
import Excptions.DuplicateKeyUsedException;
import Util.MyAVLTree;

/**
 * essa classe extends Imagem 
 * ( pois existe nome ( String ) e tamanho ( float ) em comum )
 */
public class Computador extends Imagem {

    private final MyAVLTree<Imagem> imagens;
    private float freeEspace;
    /**
     * construtor com nome e tamanho
     * @param name String com nome do computador
     * @param capacidadeDeArmazenamento float correspondente a capacidade de armazenamento do computador
    */
    public Computador(String name, float capacidadeDeArmazenamento) {
        super(name, capacidadeDeArmazenamento);
        this.imagens = new MyAVLTree();
        freeEspace = capacidadeDeArmazenamento;
    }

    /**
     * Retorna a arvore de imagens deste computador
     * @return MyAVLTree de imagens sendo a arvore de imagens deste computador
     */
    public MyAVLTree<Imagem> getImagens() {
        return imagens;
    }
    /**
     *  Remove uma imagem com a {key} passada deste computador
     * @param key String sendo o nome da imagem que deseja remover deste computador
     * @return boolean sendo true se removel e false caso nao acho a imagem no computador
    */
    public boolean removeImagem( String key ){
        Imagem img = this.imagens.find(key);
        if(img == null)
            return false;
        else{
            this.imagens.remove(key);
            this.freeEspace += img.getTamanho();
            return true;
        }
    }
    
    /**
     *  Adiciona imagens neste computador
     * @param img Imagem que sera adicionado no computador
     * @throws InsufficientMemoryExceptrion Exception de quando a memoria é insuficiente para adiciona a imagem
     * @throws DuplicateKeyUsedException Exception de quando a chave( nome da {img} ) é duplicada
     */
    public void storageImagem( Imagem img ) throws InsufficientMemoryExceptrion, DuplicateKeyUsedException{
        if( this.freeEspace < img.getTamanho() ){
            throw new InsufficientMemoryExceptrion(" Este computador não pode receber essa imagem.");
        }
        this.imagens.add(img, img.getName());
        this.freeEspace = this.freeEspace - img.getTamanho();
    }
    
    /**
     * Retorna o espaço vazio neste computador
     * @return float sendo o espaço vazio deste computador
     */
    public float getFreeEspace() {
        return freeEspace;
    }
}
