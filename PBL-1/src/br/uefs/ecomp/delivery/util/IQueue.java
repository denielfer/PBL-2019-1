package br.uefs.ecomp.delivery.util;

public interface IQueue {

    /**
     * Adicina um objeto no final da fila
     * @param data objecto que sera adicionado 
     * no ultimo no da fila
     */
    public void enqueue(Object data);

    /**
     * Remove o primeiro elemento da fila
     * @return um Object correspondente ao objeto do nó removido
     */
    public Object dequeue();

    /**
     * retorna o objeto do primeiro nó da fila
     * @return Object correspondente ao objeto do primeiro nó da fila
     */
    public Object peek();

    /**
     * retorna o objeto do ultimo nó da fila
     * @return Object correspondente ao ultimo objeto da fila
     */
    public Object last();
    
    /**s
     *  returna o tamanho da fila
     * @return int correspondente ao tamanho da fila
     */
    public int size();

    /**
     *  retorna uma boolean dizendo se a fila esta vazia
     * @return true se estiver vazia ou false se não estiver
     */
    public boolean isEmpty();
}
