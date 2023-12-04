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
public class MUsuario extends MMedico{
    
    private String Usuario;
    private Integer Contrasena;

    public MUsuario(String Usuario, int Contrasena, String NumeroCedula, String Nombre, Date FechaNacimiento, String Telefono, String Correo, Integer Codigo, String Especialidad, double Salario) {
        super(NumeroCedula, Nombre, FechaNacimiento, Telefono, Correo, Codigo, Especialidad, Salario);
        this.Usuario = Usuario;
        this.Contrasena = Contrasena;
    }

    public MUsuario(String NumeroCedula,String Usuario, int Contrasena) {
        super(NumeroCedula);
        this.Usuario = Usuario;
        this.Contrasena = Contrasena;
    }
    
    

    public MUsuario(String Usuario, String Contrasena, String NumeroCedula, String Nombre, Date FechaNacimiento, String Telefono, String Correo, Integer Codigo, String Especialidad, double Salario) {
        super(NumeroCedula, Nombre, FechaNacimiento, Telefono, Correo, Codigo, Especialidad, Salario);
        this.Usuario = Usuario;
        setContrasena(Contrasena);
    }
    
    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public int getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = this.Encriptar(Contrasena);
    }
    
    private int Encriptar(String password){
        return password.hashCode();
        
    }
    
    
}
