/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Daniel Fernandes Campos e Esdras Evangelista de sena santos
 * Data: 18/08/2019
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
package allTest;

import SystemTest.MainControlerTest;
import model.ComputadorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import util.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    LinkedListTest.class,
    MyPriorityQueueTest.class, 
    NodeTreeTest.class,
    TreeTest.class,
    ComputadorTest.class,
    MainControlerTest.class,

})
public class AllTests {
}
