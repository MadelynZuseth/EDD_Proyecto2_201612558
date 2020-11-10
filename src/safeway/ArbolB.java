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
   public Nodo raiz;
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
           auxiliar.padre = raiz;
           raiz.sig1 = null;
           raiz.sig2 = null;
           raiz.sig3 = null;
           raiz.sig4 = null;
           raiz.sig5 = null;
        }else{
           int posicion = 0;
           agregardatos(dato, raiz.N, raiz, posicion, raiz);
        }
    }
    
    public void agregardatos(Nodos dato, Nodos aux[], Nodo auxiliar, int posicion, Nodo padre){
        
       if(posicion<4){ 
          if(aux[posicion]!= null){
            if(aux[posicion].getId_Usuario() < dato.getId_Usuario()){
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
                    posicion = posicion  + 1;
                   // auxiliar.setClaves(auxiliar.getClaves() + 1);
                    agregardatos(dato,aux,auxiliar,posicion,padre);
                }
            }else if(aux[posicion].getId_Usuario()> dato.getId_Usuario()){
                if(auxiliar.claves < 4){
                    corriendoNodo(aux, posicion, dato, auxiliar);
                    auxiliar.setClaves(auxiliar.getClaves() + 1);
                }else if(auxiliar.claves >= 4){        
                    separandoNodos(posicion, dato, auxiliar);
                }
            }
          }else{
               if(auxiliar.claves < 4){
                    corriendoNodo(aux, posicion, dato, auxiliar);
                    auxiliar.setClaves(auxiliar.getClaves() + 1);
               }else if(auxiliar.claves == 4){        
                    separandoNodos(posicion, dato, auxiliar);
                }  
            }
        }else if(posicion==4){
            if(auxiliar.sig5!=null){
                padre = auxiliar;
                auxiliar = auxiliar.sig1;
            }else{
                separandoNodos(posicion, dato, auxiliar);            
            }
        }
    
    }
    
    public void corriendoNodo(Nodos aux[], int posicion, Nodos dato, Nodo auxiliar){
        int pos = 0;
        int pos2 = 0;
        Nodos extra[] = new Nodos[5];
        while(auxiliar.N[pos2]!=null || posicion==pos2){
            if(posicion == pos){
                extra[pos]=dato;
                pos = pos + 1;
            }
            extra[pos]=auxiliar.N[pos2];
            pos = pos + 1;
            pos2= pos2 + 1;
        }
        
        
         if(posicion==0){
           if(auxiliar.sig4!=null){
               auxiliar.sig5 = auxiliar.sig4;
           }
           if(auxiliar.sig3!=null){
               auxiliar.sig4 = auxiliar.sig3;
           }
           if(auxiliar.sig2 !=null){
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
        posicion = 0;
        while(extra[posicion]!=null){
            aux[posicion]=extra[posicion];
            posicion = posicion + 1;
        }
        
    }
    
    public void separandoNodos(int posicion, Nodos dato,Nodo auxiliar){
        int pos = 0;
        int pos2 = 0;
        Nodo auxExtra = null;
        Nodos extra[] = new Nodos[5];
        
        while(pos2 < 4){
            if(auxiliar.N[pos2]!=null){
                if(posicion == pos2){
                    extra[pos]=dato;
                    pos = pos + 1;
                }
                extra[pos]=auxiliar.N[pos2];
                pos = pos + 1;
                pos2= pos2 + 1;
            }
        }
        
       if(posicion==0){
           if(auxiliar.sig5!=null){
                auxExtra.sig5=auxiliar.sig5;
           }
           if(auxiliar.sig4!=null){
               auxiliar.sig5 = auxiliar.sig4;
           }
           if(auxiliar.sig3!=null){
               auxiliar.sig4=auxiliar.sig3;
           }
           if(auxiliar.sig2!=null){
               auxiliar.sig3=auxiliar.sig2;
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
            auxiliar.N[0] = extra[0];
            auxiliar.N[1] = extra[1];
            auxiliar.N[2] =  null;
            auxiliar.N[3] = null;
            extra2[0] = extra[2];
            extra3[0] = extra[3];
            extra3[1] = extra[4];
            numero = numero + 1;
            Nodo auxiliar2 = new Nodo(extra2,1, numero, auxiliar);
            raiz = auxiliar2;
            auxiliar2.padre=raiz;
            numero = numero + 1;
            Nodo auxiliar3 = new Nodo(extra3, 2, numero, auxiliar2);
            auxiliar3.sig1 = auxiliar.sig3;
            auxiliar3.sig2 = auxiliar.sig4;
            auxiliar3.sig3 = auxiliar.sig5;
            auxiliar3.sig4 = null;
            auxiliar3.sig5 = null;
            auxiliar2.sig1 = auxiliar;
            auxiliar2.sig2 = auxiliar3;
            auxiliar2.sig3 = null;
            auxiliar2.sig4 = null;
            auxiliar2.sig5 = null;
            auxiliar.sig3 = null;
            auxiliar.sig4 = null;
            auxiliar.sig5 = null;
        }else{
            Nodos extra3[] = new Nodos[4];
            numero = numero + 1;
            auxiliar.N[0] = extra[0];
            auxiliar.N[1] = extra[1];
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
            posicion = buscarPosicion(auxiliar.N, 0, dato);
            if(auxiliar.padre.getClaves() < 4){
                corriendoNodo(auxiliar.padre.N, posicion, dato, auxiliar.padre);
                auxiliar.padre.setClaves(auxiliar.getClaves() + 1);
            }else if(auxiliar.padre.claves==4){        
                separandoNodos(posicion, dato, auxiliar.padre);
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
            recorrerGraficar(s,raiz);
            unirNodos(s,raiz);
        }else{
            s.append("nodo[label=\"no se han ingresado datos\"];");
        }
    }
    
    public void recorrerGraficar(StringBuilder s, Nodo auxiliar){
        if(auxiliar!=null){
            //String nombre = String.valueOf(auxiliar.numero);
            s.append(auxiliar.numero).append("[label=\"<f0>");
            int n = 0;
            int f = 1;
            while(n<4){
                if(auxiliar.N[n]!=null){
                    s.append("|<f").append(f).append(">").append(auxiliar.N[n].getId_Usuario());
                    f = f+1;
                }else{
                    s.append("|<f").append(f).append(">").append("NULL");
                    f = f+1; 
                }
                s.append("|<f").append(f).append(">");
                f = f+1;
                n = n+1;
            }   
            s.append("\"];\n");
            if(auxiliar.sig1!=null){
                recorrerGraficar(s, auxiliar.sig1);
            }
            if(auxiliar.sig2!=null){
                recorrerGraficar(s, auxiliar.sig2);
            }
            if(auxiliar.sig3!=null){
                recorrerGraficar(s, auxiliar.sig3);
            }
            if(auxiliar.sig4!=null){
                recorrerGraficar(s, auxiliar.sig4);
            }
            if(auxiliar.sig5!=null){
                recorrerGraficar(s, auxiliar.sig5);
            }
        }
    }
    
    public void unirNodos(StringBuilder s,Nodo auxiliar){
            if(auxiliar!=null){
                 if(auxiliar.sig1!=null){
                     s.append(auxiliar.numero).append(":f0").append("->").append(auxiliar.sig1.getNumero()).append(";");
                 }if(auxiliar.sig2!=null){
                     s.append(auxiliar.numero).append(":f2").append("->").append(auxiliar.sig2.getNumero()).append(";");
                 }if(auxiliar.sig3!=null){
                     s.append(auxiliar.numero).append(":f4").append("->").append(auxiliar.sig3.getNumero()).append(";");
                 }if(auxiliar.sig4!=null){
                     s.append(auxiliar.numero).append(":f6").append("->").append(auxiliar.sig4.getNumero()).append(";");
                 }if(auxiliar.sig5!=null){
                     s.append(auxiliar.numero).append(":f8").append("->").append(auxiliar.sig5.getNumero()).append(";");
                 }
                }
            if(auxiliar.sig1!=null){
                unirNodos(s, auxiliar.sig1);
            }
            if(auxiliar.sig2!=null){
                unirNodos(s, auxiliar.sig2);
            }
            if(auxiliar.sig3!=null){
                unirNodos(s, auxiliar.sig3);
            }
            if(auxiliar.sig4!=null){
                unirNodos(s, auxiliar.sig4);
            }
            if(auxiliar.sig5!=null){
                unirNodos(s, auxiliar.sig5);
            }
    } 
}

