
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
    static ArrayList<Producto> productos=new ArrayList<>();

    
    static int codigoP=100;
    static int codigo=1000;
    static boolean registro=false;

    
     //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
       //ActualizarDatos a=new ActualizarDatos();
      //Inicio inicio=new Inicio();
       //Admin registro=new Admin();
        RegistroDoctores a=new RegistroDoctores();
       //Añadir a=new Añadir();

        
        
        
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
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
        int filas = doctores.size();
        Object[][] tableado = new Object[filas][7];
        for (int i = 0; i < filas; i++) {
            tableado[i][0] = doctores.get(i).getNombres();
            tableado[i][1] = doctores.get(i).getApellidos();
            tableado[i][2] = doctores.get(i).getEdad();
            tableado[i][3] = doctores.get(i).getSexo();
            tableado[i][4] = doctores.get(i).getCodigo();
            tableado[i][5] = doctores.get(i).getEspecialidad();
            tableado[i][6] = doctores.get(i).getTelefono();
        }
        return tableado;
    }
    public static Object[][] tablearM() {
        int filas = productos.size();
        Object[][] tableado = new Object[filas][5];
        for (int i = 0; i < filas; i++) {
            tableado[i][0] = productos.get(i).getCodigo();
            tableado[i][1] = productos.get(i).getNombre();
            tableado[i][2] = productos.get(i).getCantidad();
            tableado[i][3] = productos.get(i).getDescripcion();
            tableado[i][4] = productos.get(i).getPrecio();
        }
        return tableado;
    }
    static int posicion=0;
    static boolean found;
    //**********************************************************************************************************************************

    public static void buscard(String codigo){
        int encontrado=0;
        for(int j=0;j<doctores.size();j++){
            if(codigo.equals(doctores.get(j).getCodigo())){
                encontrado=j;
                found=true;
                break;
            }else{
                found=false;
            }
        }
        posicion=encontrado;
    }
    
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
    public static void buscarm(String codigo){
        int encontrado=0;
        for(int i=0;i<productos.size();i++){
            if(codigo.equals(productos.get(i).getCodigo())){            
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
    
    static void nuevaCuentaDoctor(String nombres,String apellidos,String contraseña,String edad,String genero,String codigo,String especialidad, String telefono){
        doctores.add(new Doctor(nombres,apellidos,contraseña,edad,genero,codigo,especialidad,telefono));
    }
    
    static void nuevoProducto(String codigo, String nombre,int cantidad, String descripcion, String precio ){
        productos.add(new Producto(codigo,nombre,cantidad,descripcion,precio));
    }
    
}
