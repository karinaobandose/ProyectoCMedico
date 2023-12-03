/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

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
    private MPaciente Paciente;
    private MMedico Medico;

    public DTOCita(Integer Id, Date Fecha, LocalTime Hora, MPaciente Paciente, MMedico Medico) {
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
        this.Paciente = (MPaciente) x[3];
        this.Medico = (MMedico) x[4];
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

    public MPaciente getPaciente() {
        return Paciente;
    }

    public void setPaciente(MPaciente Paciente) {
        this.Paciente = Paciente;
    }

    public MMedico getMedico() {
        return Medico;
    }

    public void setMedico(MMedico Medico) {
        this.Medico = Medico;
    }
}
