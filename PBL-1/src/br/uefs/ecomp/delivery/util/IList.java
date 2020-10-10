package br.uefs.ecomp.delivery.util;

/**
 *
 * @author dfc15
 */
public interface IList extends Iterable{

    /**
     * Retorna o tamanho da lista.
     * @return tamanho da lista.
     */
    public int size();

    /**
     * Insere objeto ao final da lista.
     * @param obj a ser inserido ao final da lista.
     */
    public void add(Object obj);
        
    /**
     * Insere um objeto em uma determinada posição da lista, empurrando demais elementos para direita.
     * Posição 0 refere-se a primeira posição da lista e a última posição depende do tamanho da lista.
     * @param pos a posição do objeto na lista, após a inserção. Deve ser um 
     * valor entre 0 e o tamanho da lista.
     * @param obj a ser inserido na lista
     * @return true, caso o objeto tenha sido inserido e false caso contrário.
     */
    public boolean add(int pos, Object obj);


    /**
     * Remove um objeto de uma determinada posição, deslocando demais elementos seguintes para esquerda.
     * @param pos a posição do objeto a ser removido.
     * @return o objeto removido ou null caso a lista esteja vazia ou pos seja
     * menor que 0 (zero) e maior que o tamanho da lista.
     */
    public Object remove(int pos);

    /**
     * Retorna o objeto em uma determinada posição da lista, sem remove-lo.
     * @param index do objeto a ser recuperado.
     * @return o objeto recuperado ou null caso a lista esteja vazia ou pos seja
     * menor que 0 (zero) ou maior que o tamanho da lista.
     */
    public Object get(int index);   
    
    /**
     * Indica se a lista est� vazia.
     * @return true caso a lista esteja vazia, false caso contrário
     */
    public boolean isEmpty();
}
