/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeway;




public class Nodo{
    
    Nodos N[] = new Nodos[4];
    int claves;
    Nodo padre;
    Nodo sig1;
    Nodo sig2;
    Nodo sig3;
    Nodo sig4;
    Nodo sig5;
    
    public Nodo(Nodos N[], int claves, int numero, Nodo padre){
       this.claves = claves;
       this.N = N;
       this.padre = padre;
    }
}