/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.Model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author karin
 */
public class MMedico implements Model {

    private String NumeroCedula;
    private String Nombre;
    private Date FechaNacimiento;
    private String Telefono;
    private String Correo;
    private Integer Codigo;
    private String Especialidad;
    private double Salario;

    public MMedico(String NumeroCedula) {
        this.NumeroCedula = NumeroCedula;
    }
    
    

    public MMedico(String NumeroCedula, String Nombre,
            Date FechaNacimiento, String Telefono,
            String Correo, Integer Codigo, String Especialidad, double Salario) {
        this.NumeroCedula = NumeroCedula;
        this.Nombre = Nombre;
        this.FechaNacimiento = FechaNacimiento;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Codigo = Codigo;
        this.Especialidad = Especialidad;
        this.Salario = Salario;
    }

    public String getNumeroCedula() {
        return NumeroCedula;
    }

    public void setNumeroCedula(String NumeroCedula) {
        this.NumeroCedula = NumeroCedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public Integer getCodigo() {
        return Codigo;
    }

    public void setCodigo(Integer Codigo) {
        this.Codigo = Codigo;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double Salario) {
        this.Salario = Salario;
    }

    @Override
    public boolean EstaCompleto() {
        return this.NumeroCedula != null && this.Nombre != null
                && this.FechaNacimiento != null && this.Telefono != null
                && this.Correo != null
                && this.Codigo != null
                && this.Especialidad != null
                && (Double) this.Salario != null;
    }

}
