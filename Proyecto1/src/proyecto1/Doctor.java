
package proyecto1;

/**
 *
 * @author Enner
 */

import java.util.ArrayList;
public class Doctor extends Persona {
    
    private String especialidad;
    private String telefono;
    private ArrayList<String> horario=new ArrayList<>();

    public Doctor(String nombres, String apellidos, String contraseņa, String edad, String sexo, String codigo,String especialidad,String telefono) {
        super(nombres, apellidos, contraseņa, edad, sexo, codigo);
        this.especialidad=especialidad;
        this.telefono=telefono;
    }
    

    /**
     * @return the especialidad
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * @param especialidad the especialidad to set
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the horario
     */
    public ArrayList<String> getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(ArrayList<String> horario) {
        this.horario = horario;
    }


    /**
     * @return the horario
     */
    

   
    
    
}
