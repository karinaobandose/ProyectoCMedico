/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author emalo
 */
public class DTOUsuario extends DTOMedico {

    private String Usuario;
    private Integer Contrasena;

    public DTOUsuario(String Usuario, int Contrasena, String NumeroCedula, String Nombre, Date FechaNacimiento, String Telefono, String Correo, Integer Codigo, String Especialidad, double Salario) {
        super(NumeroCedula, Nombre, FechaNacimiento, Telefono, Correo, Codigo, Especialidad, Salario);
        this.Usuario = Usuario;
        this.Contrasena = Contrasena;
    }

    public DTOUsuario(Object[] x) {
        super(x);
        this.setUsuario(String.valueOf(x[5]));
        this.setContrasena(Integer.parseInt(String.valueOf(x[6])));
    }

//    public DTOUsuario(String Usuario, String Contrasena, String NumeroCedula, String Nombre, Date FechaNacimiento, String Telefono, String Correo, Integer Codigo, String Especialidad, double Salario) {
//        super(NumeroCedula, Nombre, FechaNacimiento, Telefono, Correo, Codigo, Especialidad, Salario);
//        this.Usuario = Usuario;
//        setContrasena(Contrasena);
//    }
    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public int getContrasena() {
        return Contrasena;
    }

    public void setContrasena(Integer Contrasena) {
        this.Contrasena = Contrasena;
    }

}
