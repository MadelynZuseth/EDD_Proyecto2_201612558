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
public class SAFEWAY {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolB <Integer, Integer> arbol = new ArbolB<>(5);
        for(int i=0; i<=10;i++){
            arbol.Insertar(i, i);
        }
        arbol.Graficar();
    }
}
