/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miahorcadov2;

import Entidades.Diccionario;

/**
 *
 * @author Eli
 */
public class Comienzo {
    
     public static void main(String[] args)
    {
        generarLIstas();
    }
    
    
      public static void generarLIstas()
    {
        Diccionario lista = new Diccionario();
        lista.Cargar();
        Diccionario.guardarDiccionario(lista, "diccionario.xml");
        System.out.println("lista creada");
        
       // ListaUsuarios listaUser = new ListaUsuarios();
       // listaUser.generar();
        //ListaUsuarios.guardarUsuarios(listaUser, USUARIO_ARCH);
    }
}
    
    

