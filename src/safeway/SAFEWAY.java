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
        ArbolB arbol = new ArbolB();
        arbol.Insertar(5,"Madelyn", "Mady", "madelyn.com","55158d8e",50121616,"(50,50)","58");
        arbol.graficar();
    }
}
