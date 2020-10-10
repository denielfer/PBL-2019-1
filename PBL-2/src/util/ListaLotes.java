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

import model.Lote;
import model.Procedimento;

public class ListaLotes extends MyLinkedList {

    /**
     * Funçao que procurará por um Procedimento que ocorrera em uma determinada
     * data na lista.
     *
     * @param proc Procedimento procurado
     * @param data String contendo a data na qual o proc acontecera, deve ser
     * passada na forma : DD/MM/AAAA
     * @return Lote caso o proc seja achado na lista para a data especificada e
     * null caso contrario.
     */
    public Lote procurarOferta(Procedimento proc, String data) {
        Iterator it = this.iterator();
        Lote returned = null;
        while (it.hasNext()) {
            Lote temp = (Lote) it.next();
            if (temp.getProcedimento() == proc && temp.getData().contains(data)) {
                if (temp.getVagasRestantes() > 0) {
                    returned = temp;
                }
                break;
            }
        }
        return returned;
    }

    /**
     * Funçao que retorna uma String informando sobre um procedimento em uma
     * data. Retornando:
     * - "Pode ADD" : quando o porcedimento pode sera
     * adicionado 
     * - "Sem vagas" : quando o porcedimento nao pode sera adicionado
     * por falta de vagas 
     * - "Sem Lote" : quando o porcedimento nao pode sera
     * adicionado por inexistencia do Lote.
     *
     * @param proc Procedimento que sera procurado
     * @param data String contendo a data na qual o proc acontecera, deve ser
     * passada na forma : DD/MM/AAAA
     * @return String contendo a informação retornada.
     */
    public String informaçãoDoLote(Procedimento proc, String data) {
        Iterator it = this.iterator();
        String returned = null;
        while (it.hasNext()) {
            Lote temp = (Lote) it.next();
            if (temp.getProcedimento().getEspecialidade() == proc.getEspecialidade() && temp.getData().contains(data)) {
                if (temp.getVagasRestantes() > 0) {
                    returned = "Pode ADD";
                } else {
                    returned = "Sem vagas";
                }
                break;
            }
        }
        if (returned == null) {
            returned = "Sem Lote";
        }
        return returned;
    }

    /**
     * Função que chamara a Função Ocupar Vaga de um Lote.
     *
     * @param proc Procedimento que sera procurado pra ocupar a vaga.
     * @param data String contendo a data na qual o proc acontecera, deve ser
     * passada na forma : DD/MM/AAAA
     */
    public void ocuparVaga(Procedimento proc, String data) {
        Iterator it = this.iterator();
        while (it.hasNext()) {
            Lote temp = (Lote) it.next();
            if (temp.getProcedimento().getEspecialidade() == proc.getEspecialidade() && temp.getData().contains(data)) {
                if (temp.getVagasRestantes() > 0) {
                    temp.ocuparVaga();
                }
                break;
            }
        }
    }

    /**
     * Funçao que retorna o Lote que está na posição requerida da lista
     *
     * @param index int correspondente a posiçao desejata.
     * @return Lote presente na posição passada.
     */
    @Override
    public Lote get(int index) {
        if (index < 0) {
            return null;
        } else if (this.fist == null) {
            return null;
        } else if (index == 0) {
            return (Lote) fist.getObject();
        }
        Node temp1 = fist.getNext();
        int cont = 0;
        while (cont < index - 1) {
            temp1 = temp1.getNext();
            cont++;
        }
        return (Lote) temp1.getObject();
    }

    /**
     * Função que adicionara um Lote a lista
     *
     * @param lote Lote que sera adicionado
     */
    public void add(Lote lote) {
        boolean jaExiste = false;
        Iterator it = this.iterator();
        Lote tempLote = null;
        while (it.hasNext()) {
            tempLote = (Lote) it.next();
            if (tempLote.equals(lote)) {
                jaExiste = true;
            }
        }
        if (jaExiste) {
            tempLote.setQuantidade(tempLote.getQuantidade() + lote.getQuantidade());
        } else {
            super.add(lote);
        }
    }

}
