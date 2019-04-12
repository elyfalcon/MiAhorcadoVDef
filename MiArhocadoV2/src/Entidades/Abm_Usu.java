
package Entidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eli
 */
public class Abm_Usu {
    
    
    ArrayList usu=new ArrayList<Usuarios>();
    
    //guardar datos en el array
    public void GuardarUsuarios(Usuarios unusuario){
    
    usu.add(unusuario);
    
    }
    
    //Guardar en un archivo
    
    public void GuardarenArchivo(Usuarios usuario)
    {
        try {
            FileWriter fw=new FileWriter("Usuarios.txt",true);
            BufferedWriter bf=new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bf);
            pw.print(usuario.getNombre());
            pw.printf("| "+usuario.getNom_usuario());
            pw.println("| "+usuario.getPassword());
            pw.close();
            
        }catch (Exception e){ 
        
            JOptionPane.showMessageDialog(null, e);
        }
        
    
    }
    
    // Muestro los datos en un jtable
    
    public DefaultTableModel ListaUsuarios(){
    
   // Lista cabecera=new Lista();
  //  cabecera.add("Nombre");
 //   cabecera.add("Password");
    DefaultTableModel mdlTabla = new DefaultTableModel();
    mdlTabla.addColumn("Nombre");
    mdlTabla.addColumn("Usuario");
    mdlTabla.addColumn("Password");
    
    
    try{
    
       FileReader fr=new FileReader("Usuarios.txt");
       BufferedReader br=new BufferedReader(fr);
       String linea;
       
        while((linea= br.readLine())!=null)
               {
                 StringTokenizer dato=new StringTokenizer(linea,"|");
                 Vector x=new Vector();
                 while(dato.hasMoreTokens()){
                 x.addElement(dato.nextToken());
                    }
                 mdlTabla.addRow(x);
               }
       
    
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
    return mdlTabla;
    }
    
}

