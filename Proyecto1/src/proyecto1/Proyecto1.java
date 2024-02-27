
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
    static boolean registrop=false;

    
    
    public static void main(String[] args) {
        ActualizarDatos a=new ActualizarDatos();
        
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       // Inicio inicio=new Inicio();
        //Admin registro=new Admin();
        

        for(int i=0;i<pacientes.size();i++){
            System.out.println(pacientes.get(i).getApellidos());
            
        }
        
        
        
    }
    
    public static Object[][] tablear() {
        int filas = pacientes.size();
        Object[][] tableado = new Object[filas][5];
        for (int i = 0; i < filas; i++) {
            tableado[i][0] = pacientes.get(i).getNombres();
            tableado[i][1] = pacientes.get(i).getApellidos();
            tableado[i][2] = pacientes.get(i).getEdad();
            tableado[i][3] = pacientes.get(i).getSexo();
            tableado[i][4] = pacientes.get(i).getCodigo();
        }
        return tableado;
    }
    public static Object[][] tablearD() {
        int filas = pacientes.size();
        Object[][] tableado = new Object[filas][5];
        for (int i = 0; i < filas; i++) {
            tableado[i][0] = pacientes.get(i).getNombres();
            tableado[i][1] = pacientes.get(i).getApellidos();
            tableado[i][2] = pacientes.get(i).getEdad();
            tableado[i][3] = pacientes.get(i).getSexo();
            tableado[i][4] = pacientes.get(i).getCodigo();
        }
        return tableado;
    }
    static int posicion=0;
    static boolean found;
    public static void buscarp(String codigo){
        int encontrado=0;
        for(int i=0;i<pacientes.size();i++){
            if(codigo.equals(pacientes.get(i).getCodigo())){            
            encontrado=i;
            found=true;
            break;
            }else{
                found=false;
            }
        }
        posicion=encontrado;
    }
    
    static void nuevaCuenta(String nombres,String apellidos,String contraseña,String edad,String genero,String codigo){
        pacientes.add(new Persona(nombres,apellidos,contraseña,edad,genero,codigo));
    }
    
}
