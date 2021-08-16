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
public class insertionSort extends Lista{

    public insertionSort(int max) {
        super(max);
    }

    @Override
    public void ordena() {
        boolean finesh = false;
        while( !(finesh) ){
            finesh=true;
            int pos=1;
            while(pos != this.max){
                int temp = 0;
                if( this.lista[pos -1] > this.lista[pos] ){
                    finesh = false;
                    temp = this.lista[pos-1];
                    this.lista[pos-1] = this.lista[pos];
                    this.lista[pos] = temp;
                }
                pos++;
            }
            if(finesh)
                break;
        }
    }
    
}
