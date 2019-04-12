/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Eli
 */
public class Palabras {

    private String palabra;
    private int nivel;
    private String descripcion;
    
    /**
     *
     * @param palabra
     */
    public Palabras(String palabra, int nivel,String descripcion) {
        this.palabra = palabra;
        this.nivel = nivel;
       this.descripcion = descripcion;
    }

    public Palabras() {
        
    }
    
    public String getPalabra() {
        return this.palabra;
    }

    public int getNivel() {
        return this.nivel;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setPalabra(String palabra) {
        
        if(palabra != null)
        {
        this.palabra = palabra;
        }
        
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    }
    
