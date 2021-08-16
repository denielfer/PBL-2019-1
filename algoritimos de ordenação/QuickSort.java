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
public class QuickSort extends Lista{

    public QuickSort(int max) {
        super(max);
    }

    @Override
    @SuppressWarnings("null")
    public void ordena() {
        boolean finesh = false; // ja acabou jesica?
        int low = 0; // index do ordenado ( variaveis dos proximos captulos )
        while( !(finesh) ){
            finesh = true; // supor q terminou
            int cont = low + 1; // variavel q vai andar pela lista procurando por outros numeros
            int ordenado = this.lista[low]; // qual numero ta sendo ordenado
            while( cont != this.max ){ // se nao vi a lista toda
                if(  ordenado > this.lista[cont]){ // se o q eu to vendo na lista é menor o ordenado
                    finesh = false;  // se for eu nao acabei
                    this.lista[low] = this.lista[cont]; // o  valor do index q eu to ordenando é o menor
                    this.lista[cont] = ordenado; // coloca o maior numero de volta a fila
                    ordenado = this.lista[low]; // salva o novo valor q to ordenando
                }
                cont++;
            }
            if(low != this.max-2)
                low++;
            if( finesh == true )
                break;
        }
    }
}