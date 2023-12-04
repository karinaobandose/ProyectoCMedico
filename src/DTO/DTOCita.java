/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import MVC.Controller.CCita;
import MVC.Model.MMedico;
import MVC.Model.MPaciente;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author emalo
 */
public class DTOCita {

    private Integer Id;
    private Date Fecha;
    private LocalTime Hora;
    private String Paciente;
    private String Medico;
    
    private CCita ct = new CCita();

    public DTOCita(Integer Id, Date Fecha, LocalTime Hora, String Paciente, String Medico) {
        this.Id = Id;
        this.Fecha = Fecha;
        this.Hora = Hora;
        this.Paciente = Paciente;
        this.Medico = Medico;
    }
    
    public DTOCita(Date Fecha, LocalTime Hora, String Paciente, String Medico) {
        this.Id = Id;
        this.Fecha = Fecha;
        this.Hora = Hora;
        this.Paciente = Paciente;
        this.Medico = Medico;
    }

    public DTOCita(Object[] x) {
        this.Id = Integer.parseInt(String.valueOf(x[0]));
        this.Fecha = java.sql.Date.valueOf(String.valueOf(x[1]));
        this.Hora = LocalTime.parse(String.valueOf(x[2]));
        this.Paciente = (String) x[3];
        this.Medico = (String) x[4];
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
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

    public String getPaciente() {
        return Paciente;
    }

    public void setPaciente(String Paciente) {
        this.Paciente = Paciente;
    }

    public String getMedico() {
        return Medico;
    }

    public void setMedico(String Medico) {
        this.Medico = Medico;
    }
}
