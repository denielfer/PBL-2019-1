
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

public class listaHistorico extends MyLinkedList{
    /**
    * Função que retorna Iterator para lista que contem todos os Agendamentos guardados nesta lista do Paciente passado
     * @param paciente Paciente que sera usado como parametro de busca.
     * @return Iterator para lista que conten todos os Agendamentos guardados nesta lista do Paciente passado
    */
    public Iterator procurarHistoricoPorPaciente( Paciente paciente ){
        Iterator it = this.iterator();
        MyLinkedList temp = new MyLinkedList();
        while( it.hasNext() ){
            Agendamento ag = (Agendamento) it.next();
            if( ag.getPaciente().getCpf() == null ? paciente.getCpf() == null : ag.getPaciente().getCpf().equals(paciente.getCpf()) ){
                temp.add(ag);
            }
        }
       return temp.iterator();
    }
    /**
    * Função que retorna Iterator para lista que contem todos os Agendamentos guardados nesta lista do Medico passado
     * @param medic String que sera usado como parametro de busca.
     * @return Iterator para lista que conten todos os Agendamentos guardados nesta lista do Medico passado
    */
    public Iterator procurarHistoricoPorMedico( String medic ){
        Iterator it = this.iterator();
        MyLinkedList temp = new MyLinkedList();
        while( it.hasNext() ){
            Agendamento ag = (Agendamento) it.next();
            if( ag.getMedico().contains(medic)  ){
                temp.add(ag);
            }
        }
        return temp.iterator();
    }
    /**
    * Função que retorna Iterator para lista que contem todos os Agendamentos guardados nesta lista do atendente passado
     * @param atend String que sera usado como parametro de busca.
     * @return Iterator para lista que conten todos os Agendamentos guardados nesta lista do atendente passado
    */
    public Iterator procurarHistoricoPorAtendente( String atend ){
        Iterator it = this.iterator();
        MyLinkedList temp = new MyLinkedList();
        while( it.hasNext() ){
            Agendamento ag = (Agendamento) it.next();
            if( ag.getAtendente().contains(atend)  ){
                temp.add(ag);
            }
        }
        return temp.iterator();
    }
    /**
    * Função que retorna Iterator para lista que contem todos os Agendamentos guardados nesta lista do Procedimento passado
     * @param procedimento Procedimento que sera usado como parametro de busca.
     * @return Iterator para lista que conten todos os Agendamentos guardados nesta lista do Procedimento passado
    */
    public Iterator procurarHistoricoPorProcedimento(Procedimento procedimento) {
        Iterator it = this.iterator();
        MyLinkedList temp = new MyLinkedList();
            while( it.hasNext() ){
                Agendamento ag = (Agendamento) it.next();
                if( procedimento.getEspecialidade() == ag.getProcedimento().getEspecialidade() 
                && procedimento.getSala() == ag.getProcedimento().getSala()){
                    temp.add(ag);
                    }
                                        
        }
        return temp.iterator();
    }
    /**
    * Função que retorna Iterator para lista que contem todos os Agendamentos guardados nesta lista da data passada passado, data deve esta no formato : DD/MM/AAAA.
     * @param data String que sera usado como parametro de busca.
     * @return Iterator para lista que conten todos os Agendamentos guardados nesta lista da data passada passado, data deve esta no formato : DD/MM/AAAA
    */
    public Iterator procurarHistoricoPorData(String data) {
        Iterator it = this.iterator();
        MyLinkedList temp = new MyLinkedList();
        while( it.hasNext() ){
            Agendamento ag = (Agendamento) it.next();
            if( ag.getDtProcedimento().contains(data)  ){
                temp.add(ag);
            }
        }
        return temp.iterator();
    }

}
