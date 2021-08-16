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
public class selectionSort extends Lista{

    public selectionSort(int max) {
        super(max);
    }

    @Override
    public void ordena() {
        boolean finesh = false;
        while( !finesh ){
            for( int i = 0; i<this.max; i++ ){ // lopp que vai roda o vetor checando se o index x é menor que x elementos
                finesh = true;
                int temp = this.lista[i];
                for( int j = i+1; j<this.max; j++ ){
                    if( temp > this.lista[j] ){
                        this.lista[i] = this.lista[j];
                        this.lista[j] = temp;
                        temp = this.lista[i];
                        finesh = false;
                    }
                }
            }
        }
    }
    
}
