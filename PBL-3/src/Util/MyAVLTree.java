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
package Util;

import Excptions.DuplicateKeyUsedException;
import Model.Imagem;

/**
 * Esta é uma Arvore AVL generica*
 * 
 * *: printIMGTree e printIMGNode sao depemdentes de Imagens e feitas espesificamente para este problema
 * @param <T> Objeto do qual a arvore sera;
 */
public class MyAVLTree<T> {
    private int numElementos;
    private NodeTree<T> root;
    /**
    * Construtor vazio
    */
    public MyAVLTree() {
        this.numElementos = 0;
    }
    
/*******************************BLOCO DO ADD*************************************************/    
    /**
    * Adiciona content para na arvore com a chave chave;
     * @param content T sendo o conteudo do no
     * @param chave String que sera usada para identificaçao do no
     * @return boolean sendo true para adicionado e false para nao foi pocivel adicionar
     * @throws Excptions.DuplicateKeyUsedException Exeçao para chaves duplicadas
    */public boolean add( T content, String chave ) throws DuplicateKeyUsedException{
        if(root == null){
            root = new NodeTree<>( content, chave );
            this.numElementos++;
            return true;
        }
        NodeTree check = this.find(root, chave);
        if( check == null ){
            root = this.addNode(root, new NodeTree<>( content, chave ));
            this.numElementos++;
            return true;
        }
        throw new DuplicateKeyUsedException("Chave ja existente, temte outra.");
    }
    /**
     * Função que adiciona um no a arvore de forma recurciva 
     * @param place NodeTree que esta sendo verificado a adição
     * @param adding NodeTree que sera adicionado
     * @return NodeTree com a arvore/sub-arvore apos a inserção
     */
    private NodeTree<T> addNode( NodeTree<T> place ,NodeTree<T> adding ){
        if( place == null ){
            return adding;
        }
        int chavesComparadas = this.compareString(place.getChave(), adding.getChave());
        if(chavesComparadas < 0 )
            place.setRight( this.addNode(place.getRight(), adding) );
        else if ( chavesComparadas > 0  )
            place.setLeft( this.addNode(place.getLeft(), adding) );
        place.setAltura( this.maxHightChild(place) +1 );
        place = this.rotations(place);
        return place;
    }
/*******************************BLOCO DO FIND*************************************************/    
    /**
    * Procura se uma determinada chave esta na arvore, retornando null caso não esteja,
    * ou o node caso esteja.
     * @param chave String sendo a chave ( codigo pesquisado ) do elemento na arvore
     * @return T sendo o conteudo do no que tem a {chave} passada
    */
    public T find(String chave ){
        NodeTree<T> find = this.find(root, chave);
        if(find != null)
            return find.getContent();
        return null;
    }
    
    /**
    * Procura se uma determinada chave esta na arvore, retornando null caso não esteja,
    * ou o node caso esteja.
    * @param node NodeTree para busca recurciva
    * @param chave String sendo a chave ( codigo pesquisado ) do elemento na arvore
    * @return  NodeTree<T> contendo o no com a chave achada
    */
    private NodeTree<T> find( NodeTree<T> node, String chave ){
        if(node == null)
            return null;
        int chavesComparadas = this.compareString(node.getChave(), chave);
        if(chavesComparadas<0)
            return this.find(node.getRight(), chave);
        else if(chavesComparadas>0)
            return  this.find(node.getLeft(), chave);
        else
            return node;
    }
/*******************************BLOCO DO REMOVE**************************************************/    
    /**
    * remove no da arvore com a chave passada
     * @param chave String contendo a chave procurada
     * @return boolean sendo true se foir removido e false caso {chave} nao esteja no sistema
    */
    public boolean remove( String chave ){
        if(this.find(chave) != null){
            this.root = this.remove(root, chave);
            this.numElementos--;
            return true;
        }else
            return false;
    }
    /**
     * remove no da arvore com a chave passada
     * @param chave String contendo a chave procurada
     * @param node NodeTree em que sera comparado para acha a chave
     * @return NodeTree contendo a nova sub-arvore sem o no removido caso exista;
    */
    private NodeTree<T> remove( NodeTree<T> node, String chave ){
        if(node == null)
            return node;
        int chavesComparadas = this.compareString(node.getChave(), chave);
        if(chavesComparadas <= -1 ) {
            node.setRight( this.remove(node.getRight(), chave) ) ;
        }
        if(chavesComparadas >= 1 ) {
            node.setLeft( this.remove(node.getLeft(), chave) );
        }
        if(chavesComparadas == 0 ) {
            if( node.getRight() == null || node.getLeft() == null ){// se algum filho for null
                if( node.getRight() == null ){// se nao tem filho na direita
                    node = node.getLeft();// vira o filho da esquerda

                }else{// se tiver filho na direita
                    node = node.getRight(); // vira o filho da direita
                }
            }else {// se tiver os 2 filhos
                NodeTree<T> temp = this.getSucessor(node);
                if( temp != null ){
                    if( temp != node.getRight())
                        temp.setRight(node.getRight());
                    temp.setLeft(node.getLeft());
                }
                node = temp;
//                NodeTree<T> temp = node;
//                node = node.getRight();// vira o da direita
//                // adiciona a sub-arvore do filho da esquerda na estrutura aparti do no modificado
//                node = this.addBranch( node , temp.getLeft() );
            }
        }
        if( node != null ){
            node.setAltura( 1 + this.maxHightChild( node ) );
            node = this.rotations(node);
        }
        return node;
    }
    /**
     * funçao que acha o sucessor de um no
     * @param node NodeTree<T> no qual sera procurado o sucessor
     * @return NodeTree<T> que sera o sucessor do {node}
    */
    private NodeTree<T> getSucessor(NodeTree<T> node){
        if(node == null)
            return null;
        
        if(node.getRight() == null || node.getLeft() == null){ // se so tiver 1 filho
            if(node.getRight() == null) // se o direito for null
                return node.getLeft();
            else // se o esquerda for null
                return node.getRight();
        }else{ // se tiver 2 filhos
            NodeTree<T> sucessor = node.getRight();
            NodeTree<T> aux = node.getRight();
            if( aux.getLeft() != null){ // se o da direita nao for o sucessor
                while(aux.getLeft().getLeft() != null){// anda pra esquerda ate acha o sucessor
                    aux = aux.getLeft();
                }
               sucessor = aux.getLeft();
               aux.setLeft( this.getSucessor( aux.getLeft() ) );
            }else{ // se o da direita for o sucessor
                aux = this.getSucessor(aux);
            }
            return sucessor;
        }
    }
    /**
    * Adiciona branch ( uma arvore ) a um no passado a um no e balancea a 
    * arvore com raiz em node
    * @param node para add recurcivo, é onde vai ser adicionado o {branch}
    * @param branch é o no que sera adiciona no {node}
    * @return nova sub-arvore com {branch} adicionado
    */
    private NodeTree<T> addBranch( NodeTree<T> node, NodeTree<T> branch  ){
        if( node == null){
            return branch;
        }
        int chavesComparadas = this.compareString(node.getChave(), branch.getChave());
        if( chavesComparadas >= 1) {
            node.setLeft( this.addBranch(node.getLeft(), branch) );
        }else if( chavesComparadas <= -1){
            node.setRight( this.addBranch(node.getRight(), branch));
        }
        node.setAltura( 1 + this.maxHightChild( node ) );
        node = this.rotations(node);
        return node;
    }
/*******************************BLOCO DE ROTAÇÔES*********************************************/    
    /**
    * Recebe um no da arvore e verifica se é nescessario fazer rotaçoes para 
    * balancear-lo e caso nescessario fazelas
    * @param node NodeTree que sera verificado a nescessidade de rotações
    * @return NodeTree balanceado com rotaçoes feitas se nescessario
    */
    private  NodeTree<T> rotations( NodeTree<T> node ){
        int balance = getBelance(node);
        NodeTree<T> returned = node;
        if (balance > 1 && getBelance(node.getLeft()) < 0) { 
            node.setLeft( leftRotation(node.getLeft()) ); 
            returned = rightRotation(node); 
        }else if (balance < -1 && getBelance(node.getRight()) > 0) { 
            node.setRight( rightRotation( node.getRight() ) ); 
            returned = leftRotation(node); 
        }else if (balance > 1 && getBelance(node.getLeft() ) >= 0){ 
            returned = rightRotation(node);
        }else if(balance < -1 && getBelance(node.getRight()) <= 0) {
            returned = leftRotation(node); 
        }
        return returned;
    }
    
    /**
    * Compara {compare} com {toCompare} e se {compare} vier primeiro alfabeticamente
    * retorna negativo, se forem iguais, retorna 0 
    * se {toCompare} vier primeiro alfabeticamente retorna positivo
    * 
    * ***iguinora diferença de maiusculo e minusculos***
    * 
    * @param compare String que sera comparada com {toCompare}
    * @param toCompare String que sera comparada com {compare}
    * @return int sendo 0 para iguais, maior que sero para {toCompare} maior 
    * e maior que zero para compare} maior
    */
    private int compareString( String compare, String toCompare  ){
        int i =0;
        compare = compare.toLowerCase();
        toCompare = toCompare.toLowerCase();
                 // se as acabo as duas Strings ao mesmo tempo
        while( i != compare.length() && i != toCompare.length() ){ 
            // se a string {compare} acabo e a {toCompare} nao
            if( i == compare.length() && i < toCompare.length() ) 
                return 1; // compare é menor
            // se a String {toCompare} acabo e {compare} não
            else if( i < compare.length() && i == toCompare.length())
                return -1;
            else{ // se as 2 nao acabaram 
                // subtrai valor numero do caracter {i} da String {toCompare} 
                // do valor do caracter {i} da String {Compare}
                // assim conseguimos ver qual a caracter é maior pois os valores
                // sao tabelados em ordem alfabetica comesando no 97 para 'a' 122 para 'z'
                int valor = compare.charAt(i) - toCompare.charAt(i);
                if( valor != 0 )
                    return valor;
            }    
            i++;
        }
        return 0; // se as duas sao iguais retorna 0
    }
    
    /**
    * Retorna a altura do filho mais alto
    * @param node NodeTree que sera verificado qual a altura do maior filho
    * @return int correspondente a altura do maior filho
    */
    private int maxHightChild( NodeTree<T> node ){
        if(node == null)
            return -1;
        else if( node.getLeft() == null & node.getRight() == null )
            return 0;
        else if ( node.getLeft() == null )
            return node.getRight().getAltura();
        else if( node.getRight() == null )
            return node.getLeft().getAltura();
        return node.getLeft().getAltura() > node.getRight().getAltura()?
               node.getLeft().getAltura() : node.getRight().getAltura();
    }
    /**
    *   Calcula o balanço de um no
    * @param node NodeTree qual sera calculado o valor do balanço
    * @param int sendo o balanço de {node}
    */
    private int getBelance( NodeTree<T> node ){
        if ( node == null )
            return 0;
        if( node.getLeft() == null & node.getRight() == null )
            return 0;
        else if ( node.getLeft() == null )
            return node.getRight().getAltura() * -1;
        else if( node.getRight() == null )
            return node.getLeft().getAltura();
        return node.getLeft().getAltura() - node.getRight().getAltura();
    }
    /**
    * Faz rotaçao de no desbalanceado para direita
    * @param node NodeTree onde sera realizado a rotaçao para direita
    * @return NodeTree com a rotação realizada
    */private NodeTree<T> rightRotation( NodeTree<T> node ){
        NodeTree<T> nodeLC = node.getLeft();
        NodeTree<T> nodeLRC = nodeLC.getRight();
        nodeLC.setRight(node);
        node.setLeft(nodeLRC);
        node.setAltura( this.maxHightChild(node) + 1 );
        nodeLC.setAltura( this.maxHightChild(nodeLC) + 1 );
        return nodeLC;
    }
    
    /**
    * Faz rotaçao de no desbalanceado para esquerda
    * @param node NodeTree onde sera realizado a rotaçao para esquerda
    * @return NodeTree com a rotação realizada
    */
    private NodeTree<T> leftRotation( NodeTree<T> node ){
        NodeTree<T> nodeRC = node.getRight();
        NodeTree<T> nodeRLC = nodeRC.getLeft();
        nodeRC.setLeft(node);
        node.setRight(nodeRLC);
        node.setAltura( this.maxHightChild(node) + 1 );
        nodeRC.setAltura( this.maxHightChild(nodeRC) + 1 );
        return nodeRC;
    }
/*******************************BLOCO DO PRINT************************************************/    
    /**
    *Printa toda a arvore.
    */
    public void printTree(){
        this.printNode(root);
    }
    /**
    *Printa um no e faz recurçao para esquerda depois para direita.
    * @param node NodeTree para print recurcivo
    */
    private void printNode( NodeTree<T> node ){
        if(node != null) {
            this.printNode(node.getLeft());
            System.out.println(node.getContent());
            this.printNode(node.getRight());
        }
    }

    /**
    *Printa toda a arvore de imagens.
    */
    public void printIMGTree(){
        this.printIMGNode(root);
    }
    /**
    *Printa um no e faz recurçao para esquerda depois para direita.
    * @param node NodeTree para print recurcivo
    */
    private void printIMGNode( NodeTree<T> node ){
        if(node != null) {
            this.printIMGNode(node.getLeft());
            Imagem img = (Imagem) node.getContent();
            System.out.println("\t"+img.getName()+" : "+img.getTamanho());
            this.printIMGNode(node.getRight());
        }
    }
/*******************************BLOCO DO OUTROS***********************************************/    
    /**
     * @return int contendo numero de elementos presentes na arvore
     */
    public int getNumElementos() {
        return numElementos;
    }
}