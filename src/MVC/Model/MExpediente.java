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
    
    private String NumeroExpediente;
    private Date Fecha;
    private LocalTime Hora;
    private String Medico;
    private String Descripcion;

    public MExpediente(String NumeroExpediente,Date Fecha, LocalTime Hora, String Medico, String Descripcion) {
        this.NumeroExpediente = NumeroExpediente;
        this.Fecha = Fecha;
        this.Hora = Hora;
        this.Medico = Medico;
        this.Descripcion = Descripcion;
    }

    public String getNumeroExpediente() {
        return NumeroExpediente;
    }

    public void setNumeroExpediente(String NumeroExpediente) {
        this.NumeroExpediente = NumeroExpediente;
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

    public String getMedico() {
        return Medico;
    }

    public void setMedico(String Medico) {
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

