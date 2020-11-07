/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeway;




public class Nodo{
    
    Nodos N[] = new Nodos[4];
    int claves;
    Nodos siguiente1;
    Nodos siguiente2;
    Nodos siguiente3;
    Nodos siguiente4;
    Nodos siguiente5;
    
    public Nodo(Nodos N[], int claves, int numero){
       this.claves = claves;
       this.N = N;
    }
}