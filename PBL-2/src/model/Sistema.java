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

import util.*;

public class Sistema {

    private final ListaPacientes pacientes = new ListaPacientes();
    private final FilaEspera espera = new FilaEspera();
    private final listaHistorico historico = new listaHistorico();
    private final ListaAgendamentos agendamentos = new ListaAgendamentos(this.historico, this.espera);
    private final ListaLotes ofertaSemanal = new ListaLotes();

    public Sistema() {
    }

    public ListaPacientes getPacientes() {
        return pacientes;
    }

    public FilaEspera getFilaDeEspera() {
        return espera;
    }

    public ListaAgendamentos getAgendamentos() {
        return agendamentos;
    }

    public Iterator getAusentes(String data) {
        return this.agendamentos.getPacientesAusentes(data);
    }

    public ListaLotes getOfertaSemanal() {
        return ofertaSemanal;
    }

    public listaHistorico getHistorico() {
        return historico;
    }

}
