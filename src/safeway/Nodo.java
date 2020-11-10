/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeway;




public class Nodo{
    
    public Nodos N[] = new Nodos[4];
    public int claves;
    public Nodo padre;
    public Nodo sig1;
    public Nodo sig2;
    public Nodo sig3;
    public Nodo sig4;
    public Nodo sig5;
    public int numero;
    
    public Nodo(Nodos N[], int claves, int numero, Nodo padre){
       this.claves = claves;
       this.N = N;
       this.padre = padre;
       this.numero = numero;
    }

    /**
     * @return the sig1
     */
  
    public int getClaves() {
        return claves;
    }

    /**
     * @param claves the claves to set
     */
    public void setClaves(int claves) {
        this.claves = claves;
    }

    /**
     * @return the padre
     */
    

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

  
}