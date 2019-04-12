
package Entidades;

/**
 *
 * @author Eli
 */
public class Usuarios {
    
    private String nombre;
    private String password;
    private String nom_usuario;
    
    public Usuarios(){
    }

    public Usuarios(String nombre, String password,String nom_usuario) {
        this.nombre = nombre;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom_usuario() {
        return nom_usuario;
    }

    public void setNom_usuario(String nom_usuario) {
        this.nom_usuario = nom_usuario;
    }
    
    
    
}
