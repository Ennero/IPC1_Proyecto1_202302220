/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author Enner
 */
public class Persona {

    private String nombres, apellidos, contrase�a, codigo,edad, sexo,horarios;

    public Persona(String nombres, String apellidos, String contrase�a, String edad, String sexo, String codigo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.contrase�a = contrase�a;
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
     * @return the contrase�a
     */
    public String getContrase�a() {
        return contrase�a;
    }

    /**
     * @param contrase�a the contrase�a to set
     */
    public void setContrase�a(String contrase�a) {
        this.contrase�a = contrase�a;
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

    


}
