/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeway;

/**
 *
 * @author MADELYN
 */
class Page {
    
    private int max;
    private Page paginaPadre;
    private Nodo[] llaves;

    
    /**
     * @return the max
     */
    public Page(int max){
        this.max = max;
        this.llaves = new Nodo[max];
        paginaPadre = null;
    }
    
    
    
    public void put(int i, Nodo llave){
        this.getLlaves()[i]= llave;
    }
    
    public Nodo get(int i){
        return this.getLlaves()[i];
    }

    /**
     * @return the max
     */
    public int getMax() {
        return max;
    }

    /**
     * @param max the max to set
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * @return the paginaPadre
     */
    public Page getPaginaPadre() {
        return paginaPadre;
    }

    /**
     * @param paginaPadre the paginaPadre to set
     */
    public void setPaginaPadre(Page paginaPadre) {
        this.paginaPadre = paginaPadre;
    }

    /**
     * @return the llaves
     */
    public Nodo[] getLlaves() {
        return llaves;
    }

    /**
     * @param llaves the llaves to set
     */
    public void setLlaves(Nodo[] llaves) {
        this.llaves = llaves;
    }
}
   