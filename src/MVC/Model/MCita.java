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
public class MCita implements Model {
    
    private Integer Id;
    private Date Fecha;
    private LocalTime Hora;
    private MPaciente Paciente;
    private MMedico Medico;

    public MCita(Integer Id, Date Fecha, LocalTime Hora, MPaciente Paciente, MMedico Medico) {
        this.Id = Id;
        this.Fecha = Fecha;
        this.Hora = Hora;
        this.Paciente = Paciente;
        this.Medico = Medico;
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

    @Override
    public boolean EstaCompleto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
