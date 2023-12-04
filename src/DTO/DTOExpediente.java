/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import MVC.Model.MMedico;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author emalo
 */
public class DTOExpediente {

    private String NumeroExpediente;
    private Date Fecha;
    private LocalTime Hora;
    private String Medico;
    private String Descripcion;

    public DTOExpediente(String NumeroExpediente,Date Fecha, LocalTime Hora, String Medico, String Descripcion) {
        this.NumeroExpediente = NumeroExpediente;
        this.Fecha = Fecha;
        this.Hora = Hora;
        this.Medico = Medico;
        this.Descripcion = Descripcion;
    }
    
    public DTOExpediente(Object[] x) {
        this.NumeroExpediente = String.valueOf(x[1]);
        this.Fecha = java.sql.Date.valueOf(String.valueOf(x[2]));
        this.Hora = LocalTime.parse(String.valueOf(x[3]));
        this.Medico = String.valueOf(x[4]);
        this.Descripcion = String.valueOf(x[5]);
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
}
