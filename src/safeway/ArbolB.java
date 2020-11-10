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
   int numero = 0;
    public ArbolB(){

        this.raiz = null;
    }
    
    public void Insertar(int id_Usuario, String nombre, String usuario, String correo, String contraseña, int telefono, String latitud, String longitud){
        Nodos dato= new Nodos(id_Usuario, nombre, usuario, correo, contraseña,telefono, latitud, longitud);
        if(raiz==null){
           Nodos aux[] = new Nodos[4];
           aux[0] = dato;
           numero = numero +1;
           Nodo auxiliar = new Nodo(aux,1, numero, raiz);
           raiz = auxiliar;
           raiz.sig1=null;
           raiz.sig2=null;
           raiz.sig3=null;
           raiz.sig4=null;
           raiz.sig5=null;
        }else{
           int posicion = 0;
           agregardatos(dato, raiz.N, raiz, posicion, raiz);
        }
    }
    
    public void agregardatos(Nodos dato, Nodos aux[], Nodo auxiliar, int posicion, Nodo padre){
       if(posicion<4){ 
            if(aux[posicion].getId_Usuario()< dato.getId_Usuario()){
                if(posicion==0 && auxiliar.sig1!=null){
                    padre = auxiliar;
                    auxiliar = auxiliar.sig1;
                }else if(posicion==1 && auxiliar.sig2!=null){
                    padre = auxiliar;
                    auxiliar = auxiliar.sig2;
                }else if(posicion==2 && auxiliar.sig3!=null){
                    padre = auxiliar;
                    auxiliar = auxiliar.sig3;
                }else if(posicion==3 && auxiliar.sig4!=null){
                    padre = auxiliar;
                    auxiliar = auxiliar.sig4;
                }else if((((posicion==0 && auxiliar.sig1==null)||(posicion==1 && auxiliar.sig2==null))||(posicion==2 && auxiliar.sig3==null))||(posicion==3 && auxiliar.sig4==null)){
                    if(auxiliar.claves<4){
                        corriendoNodo(aux, posicion, dato, auxiliar);
                        auxiliar.claves = auxiliar.claves + 1;
                    }else if(auxiliar.claves==4){        
                        separandoNodos(aux, posicion, dato, auxiliar);
                    }
                    
                }
            }
        }else if(posicion==4){
            if(auxiliar.sig5!=null){
                padre = auxiliar;
                auxiliar = auxiliar.sig1;
            }else{
                separandoNodos(aux, posicion, dato, auxiliar);            
            }
        }
        
    }
    
    public void corriendoNodo(Nodos aux[], int posicion, Nodos dato, Nodo auxiliar){
        int pos = 0;
        int pos2 = 0;
        Nodos extra[] = new Nodos[5];
        while(aux[pos]!=null){
            if(posicion == pos){
                extra[pos2]=dato;
                pos2 = pos2 + 1;
            }
            extra[pos]=aux[pos2];
            pos = pos + 1;
            pos2= pos2 + 1;
        }
        posicion = 0;
        while(extra[posicion]!=null){
            aux[posicion]=extra[posicion];
            posicion = posicion + 1;
        }
         if(posicion==0){
           if(auxiliar.sig4!=null){
               auxiliar.sig5 = auxiliar.sig4;
           }
           if(auxiliar.sig3!=null){
               auxiliar.sig4 = auxiliar.sig3;
           }
           if(auxiliar.sig2!=null){
               auxiliar.sig3 = auxiliar.sig2;
           }
           if(auxiliar.sig1!=null){
               auxiliar.sig2 = auxiliar.sig1;
           }
           auxiliar.sig1 = null;
        }
        if(posicion==1){
            if(auxiliar.sig4!=null){
               auxiliar.sig5 = auxiliar.sig4;
            }
            if(auxiliar.sig3!=null){
               auxiliar.sig4 = auxiliar.sig3;
            }
            if(auxiliar.sig2!=null){
               auxiliar.sig3 = auxiliar.sig2;
            }
            auxiliar.sig2 = null;
        }
        if(posicion==2){
            if(auxiliar.sig4!=null){
               auxiliar.sig5 = auxiliar.sig4;
            }
            if(auxiliar.sig3!=null){
               auxiliar.sig4 = auxiliar.sig3;
            } 
            auxiliar.sig3 = null;
        }
        if(posicion==3){
           if(auxiliar.sig4!=null){
               auxiliar.sig5 = auxiliar.sig4;
            }
           auxiliar.sig4 = null;
        }
        
    }
    
    public void separandoNodos(Nodos aux[], int posicion, Nodos dato, Nodo auxiliar){
        int pos = 0;
        int pos2 = 0;
        Nodo auxExtra = null;
        Nodos extra[] = new Nodos[5];
        while(aux[pos]!=null){
            if(posicion == pos){
                extra[pos2]=dato;
                pos2 = pos2 + 1;
            }
            extra[pos]=aux[pos2];
            pos = pos + 1;
            pos2= pos2 + 1;
        }
       if(posicion==0){
           if(auxiliar.sig5!=null){
                auxExtra.sig5 = auxiliar.sig5;
           }
           if(auxiliar.sig4!=null){
               auxiliar.sig5 = auxiliar.sig4;
           }
           if(auxiliar.sig3!=null){
               auxiliar.sig4 = auxiliar.sig3;
           }
           if(auxiliar.sig2!=null){
               auxiliar.sig3 = auxiliar.sig2;
           }
           if(auxiliar.sig1!=null){
               auxiliar.sig2 = auxiliar.sig1;
           }
           auxiliar.sig1 = null;
        }
        if(posicion==1){
            if(auxiliar.sig5!=null){
                auxExtra.sig5 = auxiliar.sig5;
           }
            if(auxiliar.sig4!=null){
               auxiliar.sig5 = auxiliar.sig4;
            }
            if(auxiliar.sig3!=null){
               auxiliar.sig4 = auxiliar.sig3;
            }
            if(auxiliar.sig2!=null){
               auxiliar.sig3 = auxiliar.sig2;
            }
            auxiliar.sig2 = null;
        }
        if(posicion==2){
            if(auxiliar.sig5!=null){
                auxExtra.sig5 = auxiliar.sig5;
           }
            if(auxiliar.sig4!=null){
               auxiliar.sig5 = auxiliar.sig4;
            }
            if(auxiliar.sig3!=null){
               auxiliar.sig4 = auxiliar.sig3;
            } 
            auxiliar.sig3 = null;
        }
        if(posicion==3){
            if(auxiliar.sig5!=null){
                auxExtra.sig5 = auxiliar.sig5;
            }
            if(auxiliar.sig4!=null){
               auxiliar.sig5 = auxiliar.sig4;
            }
            auxiliar.sig4 = null;
        }
        posicion = 0;
        if(auxiliar.padre == raiz){
            Nodos extra2[] = new Nodos[4];
            Nodos extra3[] = new Nodos[4];
            numero = numero + 1;
            aux[0] = extra[0];
            aux[1] = extra[1];
            extra2[0] = extra[2];
            extra3[0] = extra[3];
            extra3[1] = extra[4];
            Nodo auxiliar2 = new Nodo(extra2,1, numero, auxiliar);
            raiz = auxiliar2;
            auxiliar2.padre = raiz;
            Nodo auxiliar3 = new Nodo(extra3, 2, numero, auxiliar2);
            auxiliar3.sig1 = auxiliar.sig4;
            auxiliar3.sig2 = auxiliar.sig5;
            auxiliar2.sig1=auxiliar;
            auxiliar2.sig2=auxiliar3;
            auxiliar3.sig1 = auxiliar.sig3;
            auxiliar3.sig2 = auxiliar.sig4;
            auxiliar3.sig3 = auxiliar.sig5;
            auxiliar.sig3 = null;
            auxiliar.sig4 = null;
            auxiliar.sig5 = null;
        }else{
            Nodos extra3[] = new Nodos[4];
            numero = numero + 1;
            aux[0] = extra[0];
            aux[1] = extra[1];
            extra3[0] = extra[3];
            extra3[1] = extra[4];
            Nodo auxiliar3 = new Nodo(extra3, 2, numero, auxiliar.padre);
            auxiliar3.sig1 = auxiliar.sig4;
            auxiliar3.sig2 = auxiliar.sig5;
            auxiliar3.sig1 = auxiliar.sig3;
            auxiliar3.sig2 = auxiliar.sig4;
            auxiliar3.sig3 = auxiliar.sig5;
            auxiliar.sig3 = null;
            auxiliar.sig4 = null;
            auxiliar.sig5 = null;
            dato = extra[2];
            posicion = buscarPosicion(aux, 0, dato);
            if(auxiliar.padre.claves<4){
                corriendoNodo(auxiliar.padre.N, posicion, dato, auxiliar.padre);
                auxiliar.padre.claves = auxiliar.claves + 1;
            }else if(auxiliar.padre.claves==4){        
                separandoNodos(auxiliar.padre.N, posicion, dato, auxiliar.padre);
            }
        }
    }
    
    public int buscarPosicion(Nodos aux[], int posicion, Nodos dato ){
        if(posicion<4){ 
            if(aux[posicion].getId_Usuario()< dato.getId_Usuario()){
               posicion = posicion + 1;
               buscarPosicion(aux, posicion,dato);
            }else{
                return posicion;
            }
            
        }
        return 0;
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