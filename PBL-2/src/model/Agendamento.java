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
import java.util.Date;

public class Agendamento {

    private Paciente paciente;
    private String medico;
    private String atendente;
    private Procedimento procedimento;
    private Date data;
    private String dataMarcada;
    private boolean compareceu = false;
    private int prioridade = 1;

    public Agendamento(String atendente, Paciente paciente, Procedimento procedimento,
            Date data, String dataMarcada, int prioridade) {
        this.paciente = paciente;
        this.medico = procedimento.getMedico();
        this.atendente = atendente;
        this.procedimento = procedimento;
        this.data = data;
        this.prioridade = prioridade;
        this.dataMarcada = dataMarcada;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public void setAtendente(String atendente) {
        this.atendente = atendente;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public void setDataInsercao(Date data) {
        this.data = data;
    }

    public void setDtProcedimento(String dataMarcada) {
        this.dataMarcada = dataMarcada;
    }

    public void setCompareceu(boolean compareceu) {
        this.compareceu = compareceu;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public boolean isPresente() {
        return compareceu;
    }

    public void setPresenca() {
        this.compareceu = true;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getMedico() {
        return medico;
    }

    public String getAtendente() {
        return atendente;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public Date getDataInsercao() {
        return data;
    }

    public String getDtProcedimento() {
        return dataMarcada;
    }

}
