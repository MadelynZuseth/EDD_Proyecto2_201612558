/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeway;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class ArbolB{
   Nodo raiz;
   int clave = 0;
   int numero = 0;
    public ArbolB(){

        this.raiz = null;
    }
    
    public void Insertar(int id_Usuario, String nombre, String usuario, String correo, String contraseña, int telefono, String latitud, String longitud){
        if(raiz==null){
           Nodos dato= new Nodos(id_Usuario, nombre, usuario, correo, contraseña,telefono, latitud, longitud);
           Nodos aux[] = new Nodos[4];
           aux[0] = dato;
           clave = clave + 1;
           numero = numero +1;
           Nodo auxiliar = new Nodo(aux,clave, numero);
           raiz = auxiliar;
           raiz.siguiente1 = null;
           raiz.siguiente2 = null;
           raiz.siguiente3 = null;
           raiz.siguiente4 = null;
           raiz.siguiente5 = null;
        }else{
            if((((raiz.siguiente1==null && raiz.siguiente2==null) && raiz.siguiente3==null)&& raiz.siguiente4==null) && raiz.siguiente5==null){
                int posicion = 0;
                
            }
        }
                    
    }
     
    public void graficar(){
        StringBuilder s = new StringBuilder();
        s.append("digraph G{\n").append("node[shape=record]\n");
        FileWriter fichero = null;
        PrintWriter pw = null;
        grafica(s);
        try{
            fichero = new FileWriter("./arbolb.dot");
            s.append("}");
            pw = new PrintWriter(fichero);
            pw.append(s.toString());
            fichero.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            String cmd = "dot -Tpdf ./arbolb.dot -o arbolb.pdf";
            Runtime.getRuntime().exec(cmd);
        }catch (IOException ioe){
            System.out.print(ioe);
        }
            
    }
    public void grafica(StringBuilder s){
        if(raiz!=null){
            String nombre = String.valueOf(numero);
            s.append(nombre).append("[label=\"<fo>");
            int n = 0;
            int f = 1;
                while(n<4){
                  if(raiz.N[n]!=null){
                    s.append("|<f").append(f).append(">").append(raiz.N[n].getId_Usuario());
                    f = f+1;
                  }else{
                    s.append("|<f").append(f).append(">").append("NULL");
                    f = f+1; 
                  }
                    s.append("|<f").append(f).append(">");
                    n = n+1;
                    f = f+1;
                  }
                
            s.append("\"];\n");
        }else{
            s.append("nodo[label=\"no se han ingresado datos\"];");
        }
    }
}