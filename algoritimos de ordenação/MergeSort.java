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
public class MergeSort  extends Lista{

    public MergeSort(int max) {
        super(max);
    }

    public void ordena( int[] vetor, int lowVet, int maxVet ) {
        int mid;
        if( lowVet < maxVet ){
            mid = (int) ( maxVet - lowVet )/2 + lowVet ;
            this.ordena(vetor, lowVet, mid);
            this.ordena(vetor, mid+1, maxVet);
            this.combina(vetor, lowVet, mid, maxVet);
        }
    }
    
    private void combina(int[] vetor, int lowVet, int mid, int maxVet){
        int[] vetorTemp = new int[maxVet+1];
        int cont = 0;
        int low = lowVet, low2 = mid+1;
        boolean lowCabo = false;
        boolean low2Cabo = false;
        while( cont != maxVet+1){
            if( !(lowCabo) && !(low2Cabo) ){ // se o vetor 1 e o 2 nao acabaram
                if( vetor[low] > vetor[low2] ){ 
                    vetorTemp[cont] = vetor[low2];
                    low2++;
                    if(low2> maxVet)
                        low2Cabo = true;
                }else{
                    vetorTemp[cont] = vetor[low];
                    low++;
                    if(low> mid)
                        lowCabo = true;
                }
            }else{ // se um dos vetores acabo
                if( lowCabo ){ // se o vetor 1 acabo vaibotando o do segundo
                    vetorTemp[cont] = vetor[low2];
                    if(low2 < this.max-1)
                        low2++;
                }
                else{   // se nao vai botando o do 1
                    vetorTemp[cont] = vetor[low];
                    if(low < this.max-1)
                        low++;
                }
            }
            cont++;
        }
        for( int i = lowVet; i != maxVet+1; i++ ){
            vetor[i] = vetorTemp[i - lowVet];
        }
    }
    

    @Override
    public void ordena() {
        this.ordena(this.lista, 0, max-1);
    }
}
