/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.Model;

import java.util.Date;

/**
 *
 * @author emalo
 */
public class MPaciente implements Model {

    private String NumeroCedula;
    private String Nombre;
    private Date FechaN;
    private String Telefono;
    private String Correo;

    public MPaciente(String NumeroCedula, String Nombre, Date FechaN, String Telefono, String Correo) {
        this.NumeroCedula = NumeroCedula;
        this.Nombre = Nombre;
        this.FechaN = FechaN;
        this.Telefono = Telefono;
        this.Correo = Correo;
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

    public Date getFechaN() {
        return FechaN;
    }

    public void setFechaN(Date FechaN) {
        this.FechaN = FechaN;
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

    @Override
    public boolean EstaCompleto() {
        return this.NumeroCedula != null && this.Nombre != null
                && this.FechaN != null && this.Telefono != null
                && this.Correo != null;
    }

}
