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
package br.uefs.ecomp.delivery.util;
import br.uefs.ecomp.delivery.model.*;

public class ListaUsavel {
    
    protected int size = 0;
    protected NodeUsavel fist;
    protected NodeUsavel last;

    /**
     * retorna um inteiro correspondente ao tamanho da lista
     * @return int correspondente ao tamanho da lista
     */
    public int size() {
        return this.size;
    }

    /**
     * funçao que adiciona um objeto como cabeça movendo os antigos como 
     * proximos
     * @param obj objeto que sera adicionado a cabeça
     */
    public void addFist(QualquerCoisa obj) {
        NodeUsavel temp = new NodeUsavel(obj);
        temp.setNext(this.fist);
        if (this.fist == null) {
            this.last = temp;
        }
        this.fist = temp;
        this.size++;
    }

    /**
     * Funçao que adiciona elementos ao final da lista
     * @param obj objeto que sera adicionado na ultima posição da lista
     */
    public void add(QualquerCoisa obj) {
        NodeUsavel temp = new NodeUsavel(obj);
        if (fist == null) {
            this.fist = temp;
            this.last = temp;
            size++;
            return;
        }

        this.last.setNext(temp);
        this.last = temp;
        size++;

    }

    /**
     * Funçao que adiciona elementos em uma dada posiçao tal que 0 é a 1ª possiçao
     * e size()-1 é a ultima
     * @param pos posição que deseja adicionar o objeto
     * @param obj objeto que sera adicionado
     * @return boolrsn sendo true se foi adicionado e false caso a posiçao 
     * passada seja maior que tamanho da lista ou menor que zero
     */
    public boolean add(int pos, QualquerCoisa obj) {
        if (pos > size() || pos < 0) {
            return false;
        }
        if (pos == 0 || this.fist == null) {
            addFist(obj);
            return true;
        }

        int cont = 0;
        NodeUsavel temp1 = fist;// variavel que aponta para o no anterior a onde sera inserido

        while (cont < pos - 1) {
            temp1 = temp1.getNext();
            cont++;
        }
        NodeUsavel temp2 = new NodeUsavel(obj);
        temp2.setNext(temp1.getNext());
        temp1.setNext(temp2);
        size++;
        return true;
    }

    /**
     *  Funçao que removera um objeto de um uma dada posição da lista
     * @param pos posiçao do elemento que sera removido
     * @return QualquerCoisa correspondente  ao objeto removido
     */
    public QualquerCoisa remove(int pos) {
        if (pos >= size() || pos < 0 || this.size == 0) {
            return null;
        }
        NodeUsavel temp1 = fist;// variavel que aponta para o no anterior ao que sera removido, caso nao primeiro.
        if (pos == 0) {
            fist = fist.getNext();
            this.size--;
            temp1.setNext(null);
            return temp1.getObject();
        }
        int cont = 0;
        NodeUsavel temp2 = fist.getNext(); // variavel que aponta para o objeto que eliminado
        while (cont < pos - 1) {
            temp1 = temp1.getNext();
            temp2 = temp2.getNext();
            cont++;
        }
        temp1.setNext(temp2.getNext());
        this.size--;
        temp2.setNext(null);
        return temp2.getObject();

    }

    /**
     * retorna o objeto da posiçao index, sendo 0 a 1ª posiçao e size()-1 a
     * ultima posiçao
     *
     * @param index int correspondente ao index do objeto desejado
     * @return QualquerCoisa correspondente ao objeto do index
     */
    public QualquerCoisa get(int index) {
        if (index < 0) {
            return null;
        } else if (index == 0) {
            return fist.getObject();
        }
        NodeUsavel temp1 = fist.getNext();
        int cont = 0;
        while (cont < index - 1) {
            temp1 = temp1.getNext();
            cont++;
        }
        return temp1.getObject();
    }

    /**
     *  função para saber se a lista esta vazia
     * @return bollean sendo true para vazia e false para não vazia
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     *  cria um iterator para a lista
     * @return IteratorUsavel da lista
     */
    public IteratorUsavel iterator() {
        return new IteratorUsavel(this.fist);
    }

    /**
     * Cria um iterator comessando em uma posição determinada
     * @param inicio NodeUsavel correspondente ao primeiro elemento do iterator
     * @return IteratorUsavel correspondente ao iteretor da lista
     */
    public IteratorUsavel iterator(NodeUsavel inicio) {
        return new IteratorUsavel(inicio);
    }

    /**
     * procura um cliente usando o telefone como parametro
     * @param phone String contendo o numero de telefone procurado
     * @return  IteratorUsavel com todos os clientes com o numero passado
     */
    public IteratorUsavel searchClientebyPhone(String phone) {
        Cliente tempClient = (Cliente) this.fist.getObject();
        ListaUsavel returnList = new ListaUsavel();
        NodeUsavel tempNode = this.fist;
//        tempClient = (Cliente) tempNode.getNext().getObject();
        if (tempClient.getPhone().contains(phone)) {
            returnList.add(tempClient);
        }
        while (tempNode != null) {
            tempNode = tempNode.getNext();
            if (tempNode != null) {
                tempClient = (Cliente) tempNode.getObject();
                if (tempClient.getPhone().contains(phone)) 
                    returnList.add(tempClient);
            }
        }
        return new IteratorUsavel(returnList.fist);
    }

    /**
     *  remove apenas o primeiro cliente com numero passado da lista de clientes
     * @param number String contendo o numero a ser removido
     */
    public void removeOnlyFistByPhone(String number) {
        NodeUsavel trash;
        if (this.fist.getObject().getPhone().contains(number)) {
            trash = this.fist;
            this.fist = this.fist.getNext();
            trash.setNext(null);
        } else {
            NodeUsavel aux1 = this.fist;
            while (!aux1.getNext().getObject().getPhone().contains(number)) {
                aux1 = aux1.getNext();
            }
            trash = aux1.getNext();
            aux1.setNext(aux1.getNext().getNext());
        }
        trash.setNext(null);
        size--;
    }

    /**
     *  remove todos os cliente com numero passado da lista de clientes
     * @param number String contendo o numero a ser removido
     */
    public void removeByPhone(String number) {
        NodeUsavel curso1 = this.fist.getNext();
        NodeUsavel curso2 = this.fist;
        NodeUsavel trash;
        String tempString = curso2.getObject().getPhone();
        if (tempString.contains(number)) {
            this.fist = this.fist.getNext();
            size--;
            curso2.setNext(null);
        }
        while (curso1 != null) {
            tempString = curso1.getObject().getPhone();
            if (tempString.contains(number)) {
                curso2.setNext(curso1.getNext());
                trash = curso1;
                size--;
                trash.setNext(null);

            }else{
                curso2 = curso2.getNext();
            }
            curso1 = curso2.getNext();
        }
    }

    /**
     *  Procura por clientes, na lista de clientes, utilizando nome como parametro
     * @param name String contendo o nome de cliente procurado
     * @return  IteratorUsavel contendo todos os clientes com o nome procurado
     */
        public IteratorUsavel searchClientebyName(String name) {
        NodeUsavel temp1 = this.fist;
        NodeUsavel tempList = null;
        Cliente temp2 = (Cliente) this.fist.getObject();
        while (temp1 != null) {
            if (temp2.getName().contains(name)) {
                NodeUsavel temp = new NodeUsavel(temp1.getObject());
                if (tempList == null) {
                    tempList = temp;
                } else {
                    NodeUsavel temp3 = tempList;
                    while (temp3.getNext() != null) {
                        temp3 = temp3.getNext();
                    }
                    temp3.setNext(temp);
                }
            }
            temp1 = temp1.getNext();
            if (temp1 != null) {
                temp2 = (Cliente) temp1.getObject();
            }
        }
        return new IteratorUsavel(tempList);
    }

    /**
     * Funçao que retorna a cabeça da lista
     * @return NodeUsavel correspondente a cabeça da lista
     */
    public NodeUsavel getHead() {
        return this.fist;
    }

    /**
     * Função para que gera string com os elementos do cardapio
     * @return String contendo os elementos do cardapio
     */
    public String showCardapio() {
        if (this.fist==null)
            return "";
        NodeUsavel temp = this.fist;
        String returnedString = "";
        returnedString += temp.getObject().getDescricao();
        temp = temp.getNext();
        while (temp != null) {
            returnedString += "\n";
            returnedString += temp.getObject().getDescricao();
            temp = temp.getNext();
        }
        return returnedString;
    }

}
