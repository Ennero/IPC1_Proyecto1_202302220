
package proyecto1;

/**
 *
 * @author Enner
 */

import java.util.ArrayList;
public class Doctor extends Persona {
    
    private String especialidad;
    private String telefono;
    private ArrayList<String> paciente=new ArrayList<>();
    private ArrayList<Integer> indicePacientes=new ArrayList<>();

    public Doctor(String nombres, String apellidos, String contraseña, String edad, String sexo, String codigo,String especialidad,String telefono) {
        super(nombres, apellidos, contraseña, edad, sexo, codigo);
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
     * @return the paciente
     */
    public ArrayList<String> getPaciente() {
        return paciente;
    }

    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(ArrayList<String> paciente) {
        this.paciente = paciente;
    }

    /**
     * @return the indicePacientes
     */
    public ArrayList<Integer> getIndicePacientes() {
        return indicePacientes;
    }

    /**
     * @param indicePacientes the indicePacientes to set
     */
    public void setIndicePacientes(ArrayList<Integer> indicePacientes) {
        this.indicePacientes = indicePacientes;
    }


    

   
    
    
}
