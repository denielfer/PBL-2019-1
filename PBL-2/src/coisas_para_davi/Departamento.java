/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coisas_para_davi;

import java.util.ArrayList;

/**
 *
 * @author dfc15
 */
public class Departamento implements Elemento{
    private ArrayList<Elemento> integrantes;
    public Departamento(){
        this.integrantes = new ArrayList();
    }
    public void addElemento( Elemento e){
        this.integrantes.add(e);
    }
    public void removeElemento( Elemento e ){
        this.integrantes.remove(e);
    }
    @Override
    public void printInformation() {
        for( Elemento e : this.integrantes )
            e.printInformation();
    }
}