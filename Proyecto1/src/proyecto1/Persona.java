
package proyecto1;

import java.util.ArrayList;

/**
 *
 * @author Enner
 */
public class Persona {

    private String nombres, apellidos, contraseña, codigo,edad, sexo;
    private ArrayList<String> horario=new ArrayList<>();
    private ArrayList<String> fecha=new ArrayList<>();
    private ArrayList<String> estado=new ArrayList<>();
    private ArrayList<String> motivo=new ArrayList<>();

    public Persona(String nombres, String apellidos, String contraseña, String edad, String sexo, String codigo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.contraseña = contraseña;
        this.edad = edad;
        this.sexo = sexo;
        this.codigo = codigo;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the edad
     */
    public String getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(String edad) {
        this.edad = edad;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
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
     * @return the fecha
     */
    public ArrayList<String> getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(ArrayList<String> fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the estado
     */
    public ArrayList<String> getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(ArrayList<String> estado) {
        this.estado = estado;
    }

    /**
     * @return the motivo
     */
    public ArrayList<String> getMotivo() {
        return motivo;
    }

    /**
     * @param motivo the motivo to set
     */
    public void setMotivo(ArrayList<String> motivo) {
        this.motivo = motivo;
    }

    

    


}
