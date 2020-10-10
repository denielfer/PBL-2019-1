/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Daniel Fernandes Campos e Esdras Evangelista de sena santos
 * Data: 20/09/2019
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
package View;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author dfc15
 */
public abstract class ERRO {
    /**
     * Cria e mostra uma {mensagem} na tela com o titulo {titulo}
     * @param titulo String com o titulo da aba
     * @param mensagem String com a mensagem da aba
     */
    public static void dialogErro(String titulo, String mensagem){
        new Thread(){
                @Override
                public void run(){
                DateFormat df = new SimpleDateFormat("HH:mm:ss");
                String hora = df.format(System.currentTimeMillis());
                System.out.println("*******************************\n"+hora+"\n"+"estacionamento: "+Tela.controler.getEstacionamento_index()+"\n bancos: "+Tela.controler.getBancos().size()+"\n Coletas: "+Tela.controler.getColetas().size());
                Tela.controler.printGrafo();
                System.out.println("*******************************\n");
                JLabel tempLabel = new JLabel();
                tempLabel.setText(mensagem);
                JPanel tempPanel = new JPanel();
                tempPanel.add( tempLabel );
                JFrame tempFrame = new JFrame();
                tempFrame.add(tempPanel);
                tempFrame.pack();
                tempFrame.setTitle(titulo);
                tempFrame.setLocationRelativeTo(null);
                tempFrame.show();
                    try {
                        Thread.sleep(8000);
                        tempFrame.hide();
                        this.finalize();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ERRO.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Throwable ex) {
                        Logger.getLogger(ERRO.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        }.start();
    }
}
