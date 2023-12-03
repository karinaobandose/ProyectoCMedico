/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.Model;

import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author emalo
 */
public class MExpediente implements Model {
    
    private Date Fecha;
    private LocalTime Hora;
    private MMedico Medico;
    private String Descripcion;

    public MExpediente(Date Fecha, LocalTime Hora, MMedico Medico, String Descripcion) {
        this.Fecha = Fecha;
        this.Hora = Hora;
        this.Medico = Medico;
        this.Descripcion = Descripcion;
    }
    
    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public LocalTime getHora() {
        return Hora;
    }

    public void setHora(LocalTime Hora) {
        this.Hora = Hora;
    }

    public MMedico getMedico() {
        return Medico;
    }

    public void setMedico(MMedico Medico) {
        this.Medico = Medico;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    @Override
    public boolean EstaCompleto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
}

