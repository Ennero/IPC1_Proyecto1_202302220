package proyecto1;

/**
 *
 * @author Enner
 */
import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.ColorUIResource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class Proyecto1 {

    /**
     * @param args the command line arguments
     */
    static ArrayList<Persona> pacientes = new ArrayList<>();
    static ArrayList<Doctor> doctores = new ArrayList<>();
    static ArrayList<Producto> productos = new ArrayList<>();
    static ArrayList<Citas> citas = new ArrayList<>();

    public static void refresD() {
        DoctoresM sdf = new DoctoresM();
    }

    static int codigoP = 100;
    static int codigo = 1000;
    static boolean registro = false;
    static boolean irAdmin = true;
    static int indice=0;

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ActualizarDatos a=new ActualizarDatos();
        Inicio inicio=new Inicio();
        //Admin registro = new Admin();
        //RegistroDoctores a=new RegistroDoctores();
        //Añadir a=new Añadir();
        //DoctoresM sdkfjh=new DoctoresM();
    }
    public static boolean PP, DD;

    public static void ingresoP(String contraseña, String codigo) {
        PP = false;
        for (int i = 0; i < pacientes.size(); i++) {
            if (codigo.equals(pacientes.get(i).getCodigo()) && contraseña.equals(pacientes.get(i).getContraseña())) {
                PP = true;
                indice = i;
            }
        }
    }

    public static void ingresoD(String contraseña, String codigo) {
        DD = false;
        for (int i = 0; i < doctores.size(); i++) {
            if (codigo.equals(doctores.get(i).getCodigo()) && contraseña.equals(doctores.get(i).getContraseña())) {
                DD = true;
                indice = i;
            }
        }
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
    static int posicion;
    static boolean found;

    public static Object[][] tablearHorario() {
        int fila = doctores.get(indice).getHorario().size();
        Object[][] tableado = new Object[fila][3];
        for (int i = 0; i < fila; i++) {
            tableado[i][0] = i + 1;
            tableado[i][1] = doctores.get(indice).getHorario().get(i);
            tableado[i][2] = doctores.get(indice).getFecha().get(i);
        }
        return tableado;
    }

    public static Object[][] tablearCitasP() {
        int fila = pacientes.get(indice).getHorario().size();
        Object[][] tableado = new Object[fila][4];
        for (int i = 0; i < fila; i++) {
            tableado[i][0] = i + 1;
            tableado[i][1] = pacientes.get(indice).getEstado().get(i);
            tableado[i][2] = pacientes.get(indice).getFecha().get(i);
            tableado[i][3] = pacientes.get(indice).getHorario().get(i);
        }
        return tableado;
    }

    public static Object[][] teblearCitasDoc() {
        int fila = doctores.get(indice).getHorario().size();
        Object[][] tableado = new Object[fila][4];
        for (int i = 0; i < fila; i++) {
            tableado[i][0] = i + 1;
            tableado[i][1] = pacientes.get(indice).getEstado().get(i);
            tableado[i][2] = pacientes.get(indice).getFecha().get(i);
            tableado[i][3] = pacientes.get(indice).getHorario().get(i);
        }
        return tableado;

    }

    //**********************************************************************************************************************************
    //Aquí meteré lo que usaré para generar las gráficas
    public static String[][] contarespecialidad() {
        String[][] contado = new String[doctores.size()][2];
        int fila = doctores.size();
        String[] tableado = new String[fila];
        for (int i = 0; i < fila; i++) {
            tableado[i] = doctores.get(i).getEspecialidad();
        }
        Map<String, Integer> especialidades = new HashMap<>();
        for (String tableado1 : tableado) {
            especialidades.put(tableado1, especialidades.getOrDefault(tableado1, 0) + 1);
        }
        int indico = 0;
        for (Map.Entry<String, Integer> j : especialidades.entrySet()) {
            contado[indico][0] = j.getKey();
            contado[indico][1] = j.getValue().toString();
            indico++;
        }
        return contado;
    }

    public static int[] contarproductos() {
        int[] tableado = new int[productos.size()];
        int fila = productos.size();
        for (int i = 0; i < fila; i++) {
            tableado[i] = (productos.get(i).getCantidad());
        }
        Arrays.sort(tableado);
        int[] tableadito = new int[tableado.length];
        for (int j = 0; j < fila; j++) {
            tableadito[j] = tableado[fila - j - 1];
        }
        tableado = tableadito;
        return tableado;
    }

    //*************************************************************************************************************************************************
    public static void buscaraldoc(String espe) {
        for (int j = 0; j < doctores.size(); j++) {
            if (espe.equals(doctores.get(j).getEspecialidad())) {
                PacienteM.doctor.addElement(doctores.get(j).getNombres());
            }
        }
    }
//******************************************************************************************************************************************
    public static void buscardNombre(String nombre) {
        int encontrado = 0;
        for (int j = 0; j < doctores.size(); j++) {
            if (nombre.equals(doctores.get(j).getNombres())) {
                encontrado = j;
                found = true;
                break;
            } else {
                found = false;
            }
        }
        posicion = encontrado;
    }

    public static void buscard(String codigo) {
        int encontrado = 0;
        for (int j = 0; j < doctores.size(); j++) {
            if (codigo.equals(doctores.get(j).getCodigo())) {
                encontrado = j;
                found = true;
                break;
            } else {
                found = false;
            }
        }
        posicion = encontrado;
    }

    public static void buscarp(String codigo) {
        int encontrado = 0;
        for (int i = 0; i < pacientes.size(); i++) {
            if (codigo.equals(pacientes.get(i).getCodigo())) {
                encontrado = i;
                found = true;
                break;
            } else {
                found = false;
            }
        }
        posicion = encontrado;
    }

    public static void buscarm(String codigo) {
        int encontrado = 0;
        for (int i = 0; i < productos.size(); i++) {
            if (codigo.equals(productos.get(i).getCodigo())) {
                encontrado = i;
                found = true;
                break;
            } else {
                found = false;
            }
        }
        posicion = encontrado;
    }

    public static void buscarMNCantidad(int cantidad) {
        int encontrado = 0;
        for (int i = 0; i < productos.size(); i++) {
            if (cantidad == (productos.get(i).getCantidad())) {
                encontrado = i;
                found = true;
                break;
            } else {
                found = false;
            }
        }
        posicion = encontrado;
    }
    
    public static void buscarCitas(int lugar) {
        int encontrado = 0;
        for (int i = 0; i < citas.size(); i++) {
            if (lugar == (citas.get(i).getPlace())) {
                encontrado = i;
                found = true;
                break;
            } else {
                found = false;
            }
        }
        posicion = encontrado;
    }

    static void nuevaCuenta(String nombres, String apellidos, String contraseña, String edad, String genero, String codigo) {
        pacientes.add(new Persona(nombres, apellidos, contraseña, edad, genero, codigo));
    }

    static void nuevaCuentaDoctor(String nombres, String apellidos, String contraseña, String edad, String genero, String codigo, String especialidad, String telefono) {
        doctores.add(new Doctor(nombres, apellidos, contraseña, edad, genero, codigo, especialidad, telefono));
    }

    static void nuevoProducto(String codigo, String nombre, int cantidad, String descripcion, String precio) {
        productos.add(new Producto(codigo, nombre, cantidad, descripcion, precio));
    }
    static void nuevaCita(String nombre, String hora, String fecha,int doctor, int paciente,String motivos, int id) {
        citas.add(new Citas(nombre,hora,fecha,doctor,paciente,motivos,id));
    }

}
