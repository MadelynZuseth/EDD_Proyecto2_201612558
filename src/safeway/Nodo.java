/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeway;

/**
 *
 * @author MADELYN
 * @param <T>
 * @param <V>
 */
public class Nodo<T extends Comparable<T>, V> implements Comparable {
    
    private T key;
    private V valor;
    private Page derecha;
    private Page izquierda;
    
    public Nodo(T key, V valor){
        this.key = key;
        this.valor = valor;
        this.derecha = null;
        this.izquierda = null;
    }
    
    @Override
    public int compareTo(Object o) {
        T aux = (T) o;
        if(this.key.compareTo(aux)<0){
            return -1;
        }else if (this.key.compareTo(aux)>0){
            return 1;
        }
        return 0;
    }

    /**
     * @return the key
     */
    public T getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(T key) {
        this.key = key;
    }

    /**
     * @return the valor
     */
    public V getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(V valor) {
        this.valor = valor;
    }

    /**
     * @return the derecha
     */
    public Page getDerecha() {
        return derecha;
    }

    /**
     * @param derecha the derecha to set
     */
    public void setDerecha(Page derecha) {
        this.derecha = derecha;
    }

    /**
     * @return the izquierda
     */
    public Page getIzquierda() {
        return izquierda;
    }

    /**
     * @param izquierda the izquierda to set
     */
    public void setIzquierda(Page izquierda) {
        this.izquierda = izquierda;
    }
   
}