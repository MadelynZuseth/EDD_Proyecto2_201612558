/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safeway;

import java.util.ArrayList;

/**
 *
 * @author MADELYN
 */
public class Nodos {
    private int id_Usuario;
    private String nombre;
    private String usuario;
    private String correo;
    private String contraseña;
    private int telefono;
    private String latitud;
    private String longitud;
    private Nodos Arrays[];
    Nodos derecha;
    Nodos izquierda;
     
    public Nodos(int id_Usuario_, String nombre_, String usuario_, String correo_, String contraseña_, int telefono_, String latitud_, String longitud_){
        id_Usuario = id_Usuario_;
        usuario = usuario_;
        nombre = nombre_;
        correo = correo_;
        contraseña = contraseña_;
        telefono = telefono_;
        latitud = latitud_;
        longitud = longitud_;
        Arrays= new Nodos[5];
        derecha = null;
        izquierda = null;
    }

    /**
     * @return the id_Usuario
     */
    public int getId_Usuario() {
        return id_Usuario;
    }

    /**
     * @param id_Usuario the id_Usuario to set
     */
    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the latitud
     */
    public String getLatitud() {
        return latitud;
    }

    /**
     * @param latitud the latitud to set
     */
    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    /**
     * @return the longitud
     */
    public String getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    /**
     * @return the Arrays
     */
    public Nodos[] getArrays() {
        return Arrays;
    }

    /**
     * @param Arrays the Arrays to set
     */
    public void setArrays(Nodos[] Arrays) {
        this.Arrays = Arrays;
    }

    
}
