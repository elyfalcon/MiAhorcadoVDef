/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.util.Random;

/**
 *
 * @author Eli
 */
public class Aleatorio {
    
    public static int Entero(int min, int max) //MODIFICAR ENUM
    {
        Random aleatorio = new Random();
        int numero = aleatorio.nextInt(max + 1 - min) + min;
        return numero;
    }
    
    
}
