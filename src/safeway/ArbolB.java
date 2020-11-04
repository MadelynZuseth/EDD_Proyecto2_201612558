/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeway;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ArbolB<T extends Comparable <T>, V>{
    private int k;
    private Page raiz;
    
    public ArbolB(int k){
        this.k = k;
        this.raiz = new Page(k);
    }
    
    public void Insertar(T llave, V valor){
        Nodo newNodo = new Nodo(llave, valor);
        Nodo llavecentral = null;
        if(this.raiz.get(0) == null){
            this.raiz.put(0, newNodo);
        }else if(this.raiz.get(0).getIzquierda() == null){
            int lugarInsertado = -1;
            Page nodo = this.raiz;
            for(int i = 0; i < k; i++){
                if(nodo.get(i)==null){
                    nodo.put(i, newNodo);
                    lugarInsertado = i;
                }
                if(lugarInsertado != -1){
                    if(lugarInsertado == k-1){
                        int midle = nodo.getMax()/2;
                        llavecentral = nodo.get(midle);
                        Page derecho = new Page(k);
                        Page izquierdo = new Page(k);
                        int indiceizquierdo = 0, indicederecho = 0;
                        for (int j=0; j < nodo.getMax(); j++){
                            if(nodo.get(j).compareTo(llavecentral.getKey())<0){
                                izquierdo.put(indiceizquierdo, nodo.get(j));
                                indiceizquierdo++;
                                nodo.put(j, null);
                            }else if(nodo.get(j).compareTo(llavecentral.getKey())>0){
                                derecho.put(indicederecho, nodo.get(j));
                                indicederecho++;
                                nodo.put(j,null);
                            }
                        }
                        nodo.put(midle,null);
                        this.raiz = nodo;
                        this.raiz.put(0, llavecentral);
                        izquierdo.setPaginaPadre(this.raiz);
                        derecho.setPaginaPadre(this.raiz);
                        llavecentral.setIzquierda(izquierdo);
                        llavecentral.setDerecha(derecho);
                        break;
                    }else{
                        break;
                    }
                }
            }
        }else if(this.raiz.get(0).getIzquierda()!=null){
            Page nodo = this.raiz;
            while(nodo.get(0).getIzquierda()!=null){
                int loop = 0;
                for(int i=0; i < nodo.getMax(); i++){
                    if(nodo.get(i)!=null){
                        if(nodo.get(i).compareTo(newNodo.getKey())>0){
                            nodo = nodo.get(i).getIzquierda();
                            break;
                        }
                    }else {
                        nodo = nodo.get(i -1).getDerecha();
                        break;
                    }
                }
                if(loop==nodo.getMax()){
                    nodo = nodo.get(loop -1).getDerecha();
                }
            }
            int indicecolocado = colocarNodo(nodo, newNodo);
            if(indicecolocado == k-1){
                while(nodo.getPaginaPadre()!= null){
                    int indicemedio = nodo.getMax() /2;
                    llavecentral = nodo.get(indicemedio);
                    Page izquierdo = new Page(k);
                    Page derecho = new Page(k);
                    int indiceizquierdo = 0, indicederecho = 0;
                    for(int i=0; i<k; i++){
                        if(nodo.get(i).compareTo(llavecentral.getKey())<0){
                            izquierdo.put(indiceizquierdo,nodo.get(i));
                            indiceizquierdo++;
                            nodo.put(i, null);
                        }else if(nodo.get(i).compareTo(llavecentral.getKey())>0){
                            derecho.put(indicederecho, nodo.get(i));
                            indicederecho++;
                            nodo.put(i, null);
                        }
                    }
                    nodo.put(indicemedio,null);
                    llavecentral.setIzquierda(izquierdo);
                    llavecentral.setDerecha(derecho);
                    nodo = nodo.getPaginaPadre();
                    izquierdo.setPaginaPadre(nodo);
                    derecho.setPaginaPadre(nodo);
                    for(int i=0; i< k; i++){
                        if(izquierdo.get(i)!=null){
                            if(izquierdo.get(i).getIzquierda()!=null){
                                izquierdo.get(i).getIzquierda().setPaginaPadre(izquierdo);
                            }
                            if(izquierdo.get(i).getDerecha()!=null){
                                izquierdo.get(i).getDerecha().setPaginaPadre(izquierdo);
                            }
                        }
                    }
                    for(int i = 0; i < k; i++){
                        if(derecho.get(i)!=null){
                            if(derecho.get(i).getIzquierda()!=null){
                                derecho.get(i).getIzquierda().setPaginaPadre(derecho);
                            }
                            if(derecho.get(i).getDerecha()!=null){
                                derecho.get(i).getDerecha().setPaginaPadre(derecho);
                            }
                        }
                    }
                int lugarcolocado = colocarNodo(nodo, llavecentral);
                if(lugarcolocado==k-1){
                    if(nodo.getPaginaPadre()==null){
                        int indicecentralraiz = k /2 ;
                        Nodo llavecentralraiz = nodo.get(indicecentralraiz);
                        Page izquierdaraiz = new Page(k);
                        Page derecharazi = new Page(k);
                        int indicederechoraiz = 0, indiceizquierdoraiz = 0;
                        for(int i=0; i <k; i++){
                            if(nodo.get(i).compareTo(llavecentralraiz.getKey())<0){
                                izquierdaraiz.put(indiceizquierdoraiz, nodo.get(i));
                                indiceizquierdoraiz++;
                                nodo.put(i,null);
                            }else if(nodo.get(i).compareTo(llavecentralraiz.getKey())>0){
                              derecharazi.put(indicederechoraiz, nodo.get(i));
                                indicederechoraiz++;
                                nodo.put(i,null);
                            }
                        }
                        nodo.put(indicecentralraiz,null);
                        nodo.put(0, llavecentralraiz);
                        for(int i=0; i<k; i++){
                            if(izquierdaraiz.get(i)!=null){
                                izquierdaraiz.get(i).getIzquierda().setPaginaPadre(izquierdaraiz);
                                izquierdaraiz.get(i).getDerecha().setPaginaPadre(izquierdaraiz);
                            }
                        }
                        for(int i=0;i<k; i++){
                            if(derecharazi.get(i)!=null){
                                derecharazi.get(i).getIzquierda().setPaginaPadre(derecharazi);
                                derecharazi.get(i).getDerecha().setPaginaPadre(derecharazi);     
                            }
                        }
                        llavecentralraiz.setIzquierda(izquierdaraiz);
                        llavecentralraiz.setDerecha(derecharazi);
                        izquierdaraiz.setPaginaPadre(nodo);
                        derecharazi.setPaginaPadre(nodo);
                        this.raiz = nodo;
                    }
                    continue;
                }else{
                    break;
                }
            }
        }
    }
    }

    private int colocarNodo(Page nodo, Nodo newNodo){
        int index = -1;
        for(int i=0; i< k; i++){
            if(nodo.get(i) == null){
                boolean placed = false;
                for(int j=i-1; j>=0; j--){
                    if(nodo.get(j).compareTo(newNodo.getKey())>0){
                        nodo.put(j+1, nodo.get(j));
                    }else{
                        nodo.put(j+1, newNodo);
                        nodo.get(j).setDerecha(newNodo.getIzquierda());
                        if(j+2<k && nodo.get(j+2)!=null){
                            nodo.get(j+2).setIzquierda(newNodo.getDerecha());
                        }
                        placed = true;
                        break;
                    }
                }
                if(placed == false){
                    nodo.put(0, newNodo);
                    nodo.get(1).setIzquierda(newNodo.getDerecha());
                }
                index = i;
                break;
            }
        }
        return index;
    }
    
    public void Graficar(){
        StringBuilder s = new StringBuilder();
        s.append("digraph G{\n").append("node[shape=record]\n");
        Graficar(this.raiz,s,new ArrayList<>(), null, 0);
        s.append("|");
        FileWriter fichero = null;
        PrintWriter pw = null;
        try{
            fichero = new FileWriter("./salida.dot");
            pw = new PrintWriter(fichero);
            pw.append(s.toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(null != fichero){
                    fichero.close();
                }
            }catch(Exception e2){
                e2.printStackTrace();
            }
            try{
                String cmd = "dot -Tpf ./salida.dot -o imagen.pdf";
                Runtime.getRuntime().exec(cmd);
            }catch (IOException ioe){
                System.out.print(ioe);
            }
        }
    }
       
    private void Graficar(Page actual, StringBuilder cad, ArrayList <Page> arr, Page padre, int pos ){
        if(actual == null){
            return;
        }
        int j = 0;
        if(arr.contains(actual)){
            arr.remove(actual);
            return;
        }else{
            arr.add(actual);
        }
        cad.append("node").append(actual.hashCode()).append("[label=\"");
        boolean enlace = true;
        for(int i=0; i<actual.getMax();i++){
            if(actual.get(i)==null){
                return;
            }else{
                if(enlace){
                    if(i !=actual.getMax() - 1){
                        cad.append("<f").append(j).append(">|");
                    }else{
                        cad.append("<f").append(j).append(">|");
                        break;
                    }
                    enlace = false;
                    i--;
                    j++;
                }else{
                    cad.append("<f").append(j++).append(">").append(actual.get(i).getValor()).append("|");
                    enlace = true;
                    if(i<actual.getMax()-1){
                        if(actual.get(i+1)== null){
                            cad.append("<f").append(j).append(">");
                            break;
                        }
                    }
                }
            }
         }
         cad.append("\"]\n");
         int ji = 0;
         for(int i=0;i<actual.getMax();i++){
             if(actual.get(i)==null){
                 break;
             }
             Graficar(actual.get(i).getIzquierda(),cad, arr, actual, ji++);
             ji++;
             Graficar(actual.get(i).getDerecha(),cad,arr,actual,ji++);
             ji--;
         }
         if (padre!=null){
             cad.append("node").append(padre.hashCode()).append(":f").append(pos).append("->node").append(actual.hashCode());
         }
       }
    }

 

    
