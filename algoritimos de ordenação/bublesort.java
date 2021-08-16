/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coisasPraDavi;

/**
 *
 * @author dfc15
 */
public class bublesort extends Lista{

    public bublesort(int max) {
        super(max);
    }

    @Override
    public void ordena() {
        boolean finesh = false;
        int cont = 0;
        while(!(finesh)){
            finesh = true;
            while(cont != this.max-1){ 
                 if(this.lista[cont] > this.lista[cont+1] ){
                    finesh = false;
                    int temp = this.lista[cont];
                    this.lista[cont] = this.lista[cont+1];
                    this.lista[cont+1] = temp; 
                }
                cont++;
            }
            if(finesh)
                break;
            cont = 0;
        }
    }
    
}
