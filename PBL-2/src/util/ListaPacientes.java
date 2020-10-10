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


public class ListaPacientes extends MyLinkedList {

    /**
     * Funçao que retorna Iterator para uma lista de pacientes que contem o nome
     * passado no seu nome.
     *
     * @param name String que sera usado para comparação na busca.
     * @return Iterator para lista com Pacientes com cujo nome contem a String
     * passada
     */
    public Iterator buscarPacientePorNome(String name) {
        MyLinkedList temp = new MyLinkedList();
        Iterator it = this.iterator();
        while (it.hasNext()) {
            Paciente p = (Paciente) it.next();
            if (p.getNome().contains(name)) {
                temp.add(p);
            }
        }

        return temp.iterator();
    }

    /**
     * Funçao que retorna Iterator para uma lista de pacientes que contem o cpf
     * passado no seu cpf.
     *
     * @param cpf String que sera usado para comparação na busca.
     * @return Iterator para lista com Pacientes com cujo nome contem a String
     * passada
     */
    public Object buscarPacientePorCPF(String cpf) {
        Iterator it = this.iterator();
        Paciente returned = null;
        while (it.hasNext()) {
            Paciente p = (Paciente) it.next();
            if (p.getCpf().contains(cpf)) {
                returned = p;
                break;
            }
        }

        return returned;
    }

}
