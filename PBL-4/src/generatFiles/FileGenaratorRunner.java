/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatFiles;

import System.filesGenerator;
import java.io.IOException;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;

/**
 * Apenas para gerar um arquivo aleatorio para ser usado como grafo do sistema
 */
public class FileGenaratorRunner {
    @Before
    public void setUp() throws IOException{
        filesGenerator.grafos(51, "Files\\pontos1.txt");
        filesGenerator.grafos(51, "Files\\pontos2.txt");
        filesGenerator.grafos(51, "Files\\pontos3.txt");
    }
    @Test
    public void t1(){
        Assert.assertTrue(true);
    }
}
