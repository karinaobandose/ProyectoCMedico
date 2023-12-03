/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.Controller;

import BD.PlatillaBD;
import DTO.DTOMedico;
import Dao.Dao;
import MVC.Model.MMedico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emalo
 */
public class CMedico implements Controlador<MMedico> {

//    private View view;
    private Dao dao;

    public CMedico(Dao dao) {
//        this.view = view;
        this.dao = dao;
    }

    @Override
    public boolean Agregar(MMedico obj, PlatillaBD BaseDatos) {
        if (dao.Leer(obj.getNumeroCedula(), BaseDatos) != null) {
//            view.displayMessage("Usuario ya existente, no se agregó");
            System.out.println("Ya existe");
            return false;
        } else {
            //Validar información
            DTOMedico DTOMedico = new DTOMedico(obj.getNumeroCedula(), obj.getNombre(), obj.getFechaNacimiento(), obj.getTelefono(),
                    obj.getCorreo(), obj.getCodigo(), obj.getEspecialidad(), obj.getSalario());
            if (dao.Agregar(DTOMedico, BaseDatos)) {
//                view.displayMessage("Usuario gregado correctamente");
                System.out.println("Agregado");
                return true;
            } else {
//                view.displayMessage("Error al agregar el usuario");
                System.out.println("Error");
                return false;
            }

        }
    }

    @Override
    public MMedico Leer(String Cedula, PlatillaBD BaseDatos) {
        DTOMedico DTOMedico = (DTOMedico) dao.Leer(Cedula, BaseDatos);
        if (DTOMedico == null) {
//            view.displayMessage("Usuario no encontrado");
            System.out.println("Error");
            return null;
        } else {
            MMedico MMedico = new MMedico(DTOMedico.getNumeroCedula(), DTOMedico.getNombre(), DTOMedico.getFechaNacimiento(), DTOMedico.getTelefono(),
                    DTOMedico.getCorreo(), DTOMedico.getCodigo(), DTOMedico.getEspecialidad(), DTOMedico.getSalario());
            System.out.println("Se mostrara");

//            view.display(user);
            return MMedico;
        }
    }

    @Override
    public ArrayList<MMedico> LeerTodo(PlatillaBD BaseDatos) {
        ArrayList<MMedico> DTOMedico = dao.LeerTodo(BaseDatos);
        if (DTOMedico == null) {
//            view.displayMessage("Usuario no encontrado");
            System.out.println("Error");
            return null;
        } else {
//            MMedico MMedico = new MMedico(DTOMedico.getNumeroCedula(), DTOMedico.getNombre(), DTOMedico.getFechaNacimiento(), DTOMedico.getTelefono(),
//                    DTOMedico.getCorreo(), DTOMedico.getCodigo(), DTOMedico.getEspecialidad(), DTOMedico.getSalario());
            System.out.println("Se mostrara");

//            view.display(user);
            return DTOMedico;
        }
    }

    @Override
    public boolean Actualizar(MMedico obj, PlatillaBD BaseDatos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Eliminar(MMedico obj, PlatillaBD BaseDatos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
