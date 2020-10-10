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
package util;


import model.Paciente;
import model.Agendamento;
import model.Procedimento;


public class FilaEspera extends MyLinkedList{
    /**
    * Adiciona o agendamento em uma dada posiçao a depender da sua prioridade sendo ordenado de 5 até 1
     * @param agend Agendamento que sera adicionado a Fila de Espera Prioritaria.
    */
    public void add(Agendamento agend){
        if(this.fist == null){
            this.addFist(agend);
        }else{
            Node no = this.fist;
            Agendamento temp = (Agendamento) no.getObject();
            if( temp.getPrioridade() < agend.getPrioridade() )
                this.addFist(agend);
            else{
                while( no.getNext() != null ){
                    temp = (Agendamento) no.getNext().getObject();
                    if( temp.getPrioridade() < agend.getPrioridade() ){
                        break;
                    }
                    no = no.getNext();
                }
                Node no2 = new Node(agend);
                no2.setNext(no.getNext());
                no.setNext(no2);
                if( no2.getNext() == null)
                    this.last = no2;
                this.size++;
            }
        }
        
    }
    /**
    * Função que indica qual o procimo paciente que devera ser atendido de um 
    * dado procedimento passado, removendo ele da lista.
     * @param proc Procedimento ao qual se deseja o procimo Paciente
     * @return Paciente correspondente ao procimo agendamento do Procedimento passado.
    */
    public Paciente proximoPaciente( Procedimento proc){
        int cont = 0;
        Iterator it = this.iterator();
        Paciente returned = null;
        while( it.hasNext() ){
            Agendamento ag = (Agendamento) it.next();
            if( ag.getProcedimento().getEspecialidade().contains(proc.getEspecialidade())  ){
                this.remove(cont);
                returned = ag.getPaciente();
                break;
            }
        cont++;
        }
        return returned;
    }
    
}
