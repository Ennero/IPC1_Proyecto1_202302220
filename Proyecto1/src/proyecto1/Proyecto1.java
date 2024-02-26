
package proyecto1;

/**
 *
 * @author Enner
 */
import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.ColorUIResource;

public class Proyecto1 {
    

    /**
     * @param args the command line arguments
     */
    static ArrayList<Persona> pacientes= new ArrayList<>();
    static ArrayList<Doctor> doctores=new ArrayList<>();
    
        static int codigo=1000;

    
    
    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       // Inicio inicio=new Inicio();
        Admin registro=new Admin();
        

        for(int i=0;i<pacientes.size();i++){
            System.out.println(pacientes.get(i).getApellidos());
            
        }
        
        
        
    }
    
    
    
    
    
    
    static void nuevaCuenta(String nombres,String apellidos,String contraseña,String edad,String genero,String codigo){
        pacientes.add(new Persona(nombres,apellidos,contraseña,edad,genero,codigo));
    }
    
}
