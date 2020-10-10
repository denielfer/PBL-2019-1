    /**
* Componente Curricular: Módulo Integrado de Programação
* Autor: Daniel Fernandes Campos e Esdras Evangelista de sena santos
* Data: 18/08/2019
*
* Declaro que este código foi elaborado pela dupla de forma individual e
* não contém nenhum trecho de código de outro colega ou de outro autor*,
* tais como provindos de livros e apostilas, e páginas ou documentos
* eletrônicos da Internet. Qualquer trecho de código de outra autoria que
* uma citação para o  não a minha está destacado com  autor e a fonte do
* código, e estou ciente que estes trechos não serão considerados para fins
* de avaliação. Alguns trechos do código podem coincidir com de outros
* colegas pois estes foram discutidos em sessões tutorias.
* 
* * : Funçao readAll foi baseada/editada do codigo de leitura de arquivos
* pego no link :
*    https://blog.caelum.com.br/lendo-arquivos-texto-em-java/
*
*/
package System;

import Excptions.DuplicateKeyUsedException;
import Excptions.InsufficientMemoryExceptrion;
import Excptions.NoComputerRegisteredException;
import Excptions.SystemOFFException;
import Model.*;
import Util.Iterator;
import Util.IteratorMyPriorityQueue;
import Util.MyAVLTree;
import Util.MyLinkedList;
import Util.MyPriorityQueue;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
/**
 *
 * @author dfc15
 */
public class MainControler {
    private MyAVLTree<Registro> registrosTree;
    private MyPriorityQueue<Computador> pcQueue;
    private boolean isOn = false;
    public MainControler() {
    }

    /**
    * Funçao que inicializa o sistema, iniciando a fila de computadores e a 
    * arvore de imagens e chamando as funçoes que carregam os arquivos nescessarios
    */
    public void Inicializar(){
        this.isOn = true;
        this.registrosTree = new MyAVLTree<>();
        this.pcQueue = new MyPriorityQueue();
        try{
            this.loadFilesComputador();
            this.loadFilesImgaens();
        }catch(DuplicateKeyUsedException | IOException | InsufficientMemoryExceptrion | NoComputerRegisteredException e){
            System.out.println("Sistema nao pode ser inicializado por problema \n"
                    + "Leia sugestoes dadas acima para mais informaçoes\n");
            this.isOn = false;
        }
    }
    /**
    * Funçao que inicializa o sistema encera sistema, em conjunto com a funçao 
    * inicializar servem para fazer o testes em que o sistema precise ser reiniciado
    */
    public void finesh(){
       this.registrosTree = null;
       this.pcQueue = null;
       this.isOn = false;
    }
/*********************************SEÇÂO LISTAGENS*********************************************/
    /**
     *  Printa todos os computadores junto com seus tamanhos maximos de armazenamento
     * @return int contendo o numero de computadores cadastrados no sistema
     * @throws Excptions.SystemOFFException Exeção para sistema nao inicializado
    */ 
    public int listaComputadores() throws SystemOFFException{// user storie : 5
        if(!(this.isOn))
            throw new SystemOFFException("Inicie o systema para realizar essa operação");
        IteratorMyPriorityQueue it = this.pcQueue.iterator();
        int returned = 0;
        System.out.println("Computadores cadastrados e seus tamanhos de armazenamento maximo : ");
        while( it.hasNext()){
            returned++;
            Computador pc = (Computador) it.next();
            System.out.println(pc.getName()+" : "+pc.getTamanho());
        }
        System.out.println("__________________________________________________________________");
        return returned;
    }
    /**
     *  Printa todos os computadores junto com seus tamanhos de armazenamento vazio
     * @return float sendo o espaço total livre no sistema
     * @throws Excptions.SystemOFFException Exeção para sistema nao inicializado
    */
    public float listaComputadoresEspaçoVazio() throws SystemOFFException{// user storie : 7
        if(!(this.isOn))
            throw new SystemOFFException("Inicie o systema para realizar essa operação");
        IteratorMyPriorityQueue it = this.pcQueue.iterator();
        float returned = 0;
        System.out.println("Computadores cadastrados e seus tamanhos de armazenamento vazio : ");
        while( it.hasNext()){
            Computador pc = (Computador) it.next();
            returned += pc.getFreeEspace();
            System.out.println(pc.getName()+" : "+pc.getFreeEspace());
        }
        System.out.println("__________________________________________________________________");
        return returned;
    }
    /**
     * Printa todas as imagens com seus tamanhos do sistema assim como em 
     * qual computador ela esta
     * @return int correspondente ao numero de imagens printadas
     * @throws Excptions.SystemOFFException Exeção para sistema nao inicializado
    */
    public int listaImagens() throws SystemOFFException{// user storie : 6
        if(!(this.isOn))
            throw new SystemOFFException("Inicie o systema para realizar essa operação");
        IteratorMyPriorityQueue it = this.pcQueue.iterator();
        int returned = 0;
        System.out.println("{computador}:\n{Imagen} : {tamanho_imagem} ");
        while( it.hasNext()){
            Computador pc = (Computador) it.next();
            returned += this.listaImagensEmComputador(pc);
        }
        System.out.println("__________________________________________________________________");
        return returned;   
    }
    /**
     * Printa todas as imagens com seus tamanhos de um computador
     * @param pc Computador do qual as imagens serao printadas
     * @return int correspondente ao numero de imagens printadas
     * @throws Excptions.SystemOFFException Exeção para sistema nao inicializado
    */
    public int listaImagensEmComputador(Computador pc) throws SystemOFFException{// user storie : 8
        // esse metodo éo lista conteudo de um computador
        if(!(this.isOn))
            throw new SystemOFFException("Inicie o systema para realizar essa operação");
        System.out.println(pc.getName()+" :");
        pc.getImagens().printIMGTree();
        return pc.getImagens().getNumElementos();
    }
/***************************SEÇÂO REMOVER/PROCURAR IMAGEM*************************************/
    /**
     *Funçao que busca Imagem no sistema retornando o computador a qual ela 
     * pertence ou null caso nao exista no sistema
     * @param nome String sendo o nome da imagem procurada
     * @return Computador a qual a imagem esta salva caso exista e null caso não exista
     * @throws Excptions.SystemOFFException Exeção para sistema nao inicializado
    */
    public Computador buscarImagem(String nome) throws SystemOFFException{// user storie : 9
        if(!(this.isOn)){
            throw new SystemOFFException("Inicie o systema para adicionar computadores ao sistema\n");
        }
        return this.registrosTree.find(nome).getPc();
    }
    /**
     * Funçao que remove Imagem do sistema
     * @param key String sendo o nome da imagem procurada
     * @throws Excptions.SystemOFFException Exeção para sistema nao inicializado
    */
    public void excluirImagem(String key) throws SystemOFFException{// user storie : 10
        if(!(this.isOn)){
            throw new SystemOFFException("Inicie o systema para adicionar computadores ao sistema\n");
        }
        Registro registro= this.registrosTree.find(key);
        if( registro != null ){
            this.registrosTree.remove(key);
            registro.getPc().removeImagem(key);
            this.pcQueue.updateElemente(registro.getPc(), registro.getPc().getFreeEspace());
        }
    }
/***************************SEÇÂO ADICIONAR IMAGEM/COMPUTADOR*********************************/
    /**
     * Adiciona um Computador ao sistema Salvando ele no arquivo de computadores 
     * caso o systema esteja online.
     * Nota: essa funçao contelpla a user storie : 1 e parte da 3 sendo a 
     * escrita do arquivo sendo feita aqui e a leitura em outra funçao
     * @param nome String contendo o nome do computador adicionado
     * @param capacidade float sendo a capacidade do novo computador
     * @throws Excptions.SystemOFFException Exeção para sistema bnao inicializado
     * @throws java.io.IOException Erro de arquivo
    */
    public void addComputer( String nome, float capacidade) throws SystemOFFException, IOException{// user storie : 1
        if(!(this.isOn)){
            throw new SystemOFFException("Inicie o systema para adicionar computadores ao sistema\n");
        }
        this.pcQueue.queue(new Computador(nome, capacidade), capacidade);

        int i;
        FileWriter arq = null;
        try {
            arq = new FileWriter("Files\\computadores.ascii", true);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.printf(nome+" %d\n", (int) capacidade);  
        
        }finally{
            if( arq != null)
                arq.close();
        }
    }
    /**
     * Adiciona uma imagem no sistema 
     * caso o systema esteja online
     * @param nome String contendo o nome do computador adicionado
     * @param tamanho float sendo o tamanho do computador
     * @throws Excptions.SystemOFFException Exeção para sistema bnao inicializado
     * @throws Excptions.InsufficientMemoryExceptrion Exeção jogada quando a memoria do ocmputador é insuficiente para armazena a imagem
     * @throws Excptions.DuplicateKeyUsedException Exeçao jogada quando a chave passada ja foi adicionada
    */
    public void addImagem( String nome, float tamanho ) throws SystemOFFException, InsufficientMemoryExceptrion, DuplicateKeyUsedException{// user storie : 2
        if(!(this.isOn))
            throw new SystemOFFException("Inicie o systema para adicionar imagens ao sistema\n");
        Imagem img = new Imagem( nome, tamanho);
        Computador pc = null;   
        try{
            pc = this.addImagemToComputador( img );
        }catch( InsufficientMemoryExceptrion | NoComputerRegisteredException e){
            System.out.println(" Nao é pocivel adicionar mais imagens ao sistema devido a falta de espaço\n"
                    + "Cadastre computadores e reinicie o sistema para carega as imagens\n");
            throw new InsufficientMemoryExceptrion("");
        }catch( DuplicateKeyUsedException e ){
            System.out.println("Não foi poscivel adicionar" + img.getName()+" pois ja existe imagem com esse nome\n" );
            throw e;
        }
        try{
            this.registrosTree.add( new Registro( img, pc )  , img.getName());
        }catch(DuplicateKeyUsedException e){
            System.out.println("Não foi poscivel adicionar" + img.getName()+" pois ja existe imagem com esse nome\n" );
        }
    }
    /**
    * Adiciona uma imagem ao computador com maior capacidade;
     * @param img imagem a ser adicionada no computador
     * @return Compútador ao qual a imagem foi adicionada
     * @throws InsufficientMemoryExceptrion Exeção jogada quando a memoria do ocmputador é insuficiente para armazena a imagem
     * @throws DuplicateKeyUsedException Exeção jogada quando a chave passada ja foi adicionada
     * @throws NoComputerRegisteredException Exeção lançada quando nao ha computadores cadastrados no sistema
    */
    private Computador addImagemToComputador( Imagem img ) throws InsufficientMemoryExceptrion, DuplicateKeyUsedException, NoComputerRegisteredException{
        Computador pc = this.pcQueue.deQueue();
        if( pc == null ){
             System.out.println(" É nescessario cadastra mas computadores para adicionar imagens ");
             throw new NoComputerRegisteredException("Nao existe computadores no sistema");
        }
        else{
            try{
                pc.storageImagem(img);
            } catch( InsufficientMemoryExceptrion e ){
                throw new InsufficientMemoryExceptrion(" Espaço de armazenamento exedido");
            }finally{
                this.pcQueue.queue(pc, pc.getFreeEspace());
            }
        }
        return pc;
    }
/*******************SEÇÂO DE CAREGAR ARQUIVOS IMAGEM E COMPUTADOR*****************************/
    /**
    * Funçao que realizara a leitura dos arquivos de computador
     * @throws java.io.IOException Exeção de erro de arquivo
    */
    public void loadFilesComputador() throws IOException{// user storie : 3
        MyLinkedList list = null;
        try{
            list = this.stringSeparatorFile( "Files\\computadores.ascii" );
        }catch(IOException e){
            System.out.println(e.getMessage());
            System.out.println("Problema na leitura do arquivo de computad"
                        + "ores por favor incira src\\Files\\computadores.ascii "
                        + "e reinicie o sistema");
            throw new IOException();
        }
        Iterator<Computador> it = list.iterator();
        while( it.hasNext()){
            Imagem name_tamanho_info =it.next();
            Computador pc = new Computador( name_tamanho_info.getName(), name_tamanho_info.getTamanho() );
            this.pcQueue.queue(pc, pc.getFreeEspace());
        }
        
    }
    
    /**
     * Funçao que realizara a leitura dos arquivos de imagens
     * @throws java.io.IOException Exeção de erro de arquivo
     * @throws Excptions.InsufficientMemoryExceptrion Exception para memoria em computadores incapaz de guarda imagens
     * @throws Excptions.NoComputerRegisteredException Exception para nenhum computador registrado no sistema
     * @throws Excptions.DuplicateKeyUsedException Exception para imagem com nome duplicado
    */
    public void loadFilesImgaens() throws IOException, InsufficientMemoryExceptrion, NoComputerRegisteredException, DuplicateKeyUsedException{// user storie : 4
        MyLinkedList list = null;
        try {
            list = this.stringSeparatorFile( "Files\\imagens.ascii" );
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Problema na leitura do arquivo de imagens "
                        + "por favor incira src\\Files\\imgaens.ascii "
                        + "e reinicie o sistema\n");
            throw new IOException();
        }
        Iterator<Imagem> it = list.iterator();
        while( it.hasNext()){
            Imagem img = it.next();
            try {
                this.addImagem(img.getName(), img.getTamanho());
            } catch (SystemOFFException e) {
                System.out.println(e.getMessage());
                return;
            } catch(InsufficientMemoryExceptrion e){
                throw new InsufficientMemoryExceptrion("");
            } catch(DuplicateKeyUsedException e){
                System.out.println("Imagem :\"" + img.getName() +"\" ja existe "
                        + "no sistema portanto nao foi adicionada");
            }
        }
    }
    /***************************SUB-SEÇÂO LEITURA DE ARQUIVOS****************************/
    /**
    * Separa a String no arquivo file.
     * @param filePath Caminho do arquivo que sera lido
     * @return MyLinkedList de Imagens como nome de tamanho.
     * @throws java.io.IOException Exception para erro de arquivo
    */
    public MyLinkedList stringSeparatorFile( String filePath ) throws IOException{
        FileInfo pcFileInfo = null;
        try{
            pcFileInfo = this.readAll(filePath);
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch( IOException e ){
            System.out.println(e.getMessage());
        }finally{
            if( pcFileInfo == null )
                return null;
        }
        int cont = 0, possCurso = 0, proxPonto = -1;
        MyLinkedList list = new MyLinkedList();
        while( cont != pcFileInfo.getNumLines() ){
            Imagem item = new Imagem();
            char chars[] = new char[1000];
            // Faz a leitura do nome
            possCurso = proxPonto+1;
            proxPonto = pcFileInfo.getText().indexOf(" ", possCurso);
            pcFileInfo.getText().getChars(possCurso, proxPonto, chars, 0);
            chars[proxPonto - possCurso] = 0 ;
            item.setName( String.valueOf(chars) ); // converte o que leu para String
            chars = new char[1000];
            // Faz a leitura do tamanho
            possCurso = proxPonto+1;
            proxPonto = pcFileInfo.getText().indexOf("\n", possCurso);
            pcFileInfo.getText().getChars(possCurso, proxPonto,chars, 0);
            chars[proxPonto - possCurso] = 0 ;
            item.setTamanho( Float.valueOf( String.copyValueOf(chars) ) ); // converte o que leu para float
            
            // Salva na lista
            list.add(item);
            /*System.out.print(cont + ": ");
            System.out.println(item.getName()+' '+item.getTamanho()+'\n');*/
            cont++;
            
        }
        return list;
    }
    
    
    
    /**
    * Codigo que efetua leitura de todo o arquivos TXT
     * @param filePath caminho para o arquivo;
     * @return FileInfo contendo uma String com todo o texto e o numero de linhas;
     * @throws java.io.FileNotFoundException Exeção para arquivo não encontrado
    */
    private FileInfo readAll( String filePath ) throws IOException {
        FileInputStream stream;
        try{
            stream = new FileInputStream(filePath);
        }catch( FileNotFoundException e ){
            throw new FileNotFoundException("Arquivo de Imagens/Computadores não "
                    + "encontrado por favor coloque os na pasta Files para continuar,"
                    + "caso arquivos estejam la verifique se a estençao é \".ascii\"");
        }
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(reader);
        String fullFile = "";
        String linha;
        try{
            linha = br.readLine();
        }catch( IOException e ){
            stream.close(); // se deu erro fecha o arquivo antes de lança o erro
            throw new IOException("Problema na leitura das linhas do arquivo");
        }
        int numLines = 0;
        while( linha != null ){
            numLines++;
            fullFile += linha + "\n";
            try{
                linha = br.readLine();
            }catch( IOException e ){
                stream.close(); // se deu erro fecha o arquivo antes de lança o erro
                throw new IOException("Problema na leitura das linhas do arquivo");
            }
        }
        stream.close();
        return new FileInfo( fullFile, numLines );
    }

/************************************GETTER ATRIBUTOS*****************************************/
    /**
     * Retorna a arvore de Registros do sistema
     * @return MyAVLTree de registros
    */
    public MyAVLTree<Registro> getRegistrosTree() {
        return registrosTree;
    }
    /**
     * Retorna a fila de prioridade de computadores do sistema
     * @return MyPriorityQueue de computadores
    */
    public MyPriorityQueue<Computador> getPcQueue() {
        return pcQueue;
    }
    /**
     * Retorna uma boolean indicando se o sistema esta online, podendo ser usado
     * @return boolean sendo true para system on e false para off
    */
    public boolean isIsOn() {
        return isOn;
    }
}

    