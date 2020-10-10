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

import model.Agendamento;

public class ListaAgendamentos extends MyLinkedList {

    private final listaHistorico historico;
    private final FilaEspera espera;

    /**
     * Construtor que recebera a ListaHistorico, lista de historico, e a
     * FilaEspera, Fila de espera.
     *
     * @param historico listaHistorico, onde serao aodionados o Agendamentos ao
     * serem marcados como presente.
     * @param espera FilaEspera onde sera repassado os Agendamentos ao serem
     * marcados como presente.
     */
    public ListaAgendamentos(listaHistorico historico, FilaEspera espera) {
        this.historico = historico;
        this.espera = espera;
    }

    /**
     * Essa funçao ira repassar o agendamento que for passado como parametro
     * para alista de historico e a fila de espera
     *
     * @param agendamento Agendamento que sera repassado para as listas
     */
    public void confirmarPresenca(Agendamento agendamento) {
        Iterator it = this.iterator();
        int index = 0;
        while (it.hasNext()) {
            Agendamento ag = (Agendamento) it.next();
            if (ag.equals(agendamento)) {
                ag.setPresenca();
                this.remove(index);
                this.getHistorico().add(ag);
                this.getEspera().add(ag);
                break;
            }
            index++;
        }
    }

    /**
     * Metodo que adiciona o Agendamento passado a esta lista.
     *
     * @param agend Agendamento que sera adiconado
     */
    private void add(Agendamento agend) {
        Node temp = new Node(agend);
        if (fist == null) {
            this.fist = temp;
        } else {
            this.last.setNext(temp);
        }
        this.last = temp;
        size++;

    }

    /**
     * Funçao que retornara uma String contendo se foi agendado ou se os
     * procedimentos ja estao esgotados ou se esta indisponivel pra data
     * escolhida opçoes de retorno : 
     * - "Agendamento confirmado" : Agendamento
     * foi adicionado 
     * - "Procedimento esgotado" : Nçao existe mais vaga para o
     * procedimento no dia requerido. 
     * - "Procedimento indisponível para a data
     * escolhida" : O procedimento do agendamento não esta dispónivel para a
     * data passada
     *
     * @param agend Agendamento que tentara ser adicionado
     * @param oferta String contendo informaçao sobre o agendamento.
     */
    public String addAgendamento(Agendamento agend, ListaLotes oferta) {
        String informaçao = oferta.informaçãoDoLote(agend.getProcedimento(), agend.getDtProcedimento());
        switch (informaçao) {
            case "Pode ADD":
                this.add(agend);
                oferta.ocuparVaga(agend.getProcedimento(), agend.getDtProcedimento());
                return "Agendamento confirmado";
            case "Sem vagas":
                return "Procedimento esgotado";
            case "Sem Lote":
                return "Procedimento indisponível para a data escolhida";
            default:
                return null;
        }

    }

    public listaHistorico getHistorico() {
        return historico;
    }

    public FilaEspera getEspera() {
        return espera;
    }

    /**
     * Funçao quer retorna um Iterador para todos os Agendamentos que ainda
     * estao na lista para data passada.
     *
     * @param data String contendo a data que deseja saber os ausentes, deve ser
     * passada em : DD/MM/AAAA
     * @return Iterator para lista com os agendamentos encontrados para a data
     * dada.
     */
    public Iterator getPacientesAusentes(String data) {
        Iterator it = this.iterator();
        MyLinkedList temp = new MyLinkedList();
        Agendamento ag;
        while (it.hasNext()) {
            ag = (Agendamento) it.next();
            if (ag.getDtProcedimento() == data) {
                temp.add(ag.getPaciente());
            }
        }
        return temp.iterator();
    }

}
