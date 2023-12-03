/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.Controller;

import BD.PlatillaBD;
import DTO.DTOPaciente;
import Dao.Dao;
import MVC.Model.MPaciente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emalo
 */
public class CPaciente implements Controlador<MPaciente> {

//    private View view;
    private Dao dao;

    public CPaciente(Dao dao) {
//        this.view = view;
        this.dao = dao;
    }

    @Override
    public boolean Agregar(MPaciente obj, PlatillaBD BaseDatos) {
        if (dao.Leer(obj.getNumeroCedula(), BaseDatos) != null) {
//            view.displayMessage("Usuario ya existente, no se agregó");
            System.out.println("Ya existe");
            return false;
        } else {
            DTOPaciente DTOMedico = new DTOPaciente(
                    obj.getNumeroCedula(),obj.getNombre(),
                    obj.getFechaN(),obj.getTelefono(),obj.getCorreo());
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
    public MPaciente Leer(String Cedula, PlatillaBD BaseDatos) {
        DTOPaciente obj = (DTOPaciente) dao.Leer(Cedula, BaseDatos);
        if (obj == null) {
//            view.displayMessage("Usuario no encontrado");
            System.out.println("Error");
            return null;
        } else {
            MPaciente MPaciente = new MPaciente(obj.getNumeroCedula(),obj.getNombre(),
                    obj.getFechaN(),obj.getTelefono(),obj.getCorreo());
            if (dao.Agregar(obj, BaseDatos));
            System.out.println("Se mostrara");

//            view.display(user);
            return MPaciente;
        }
    }

    @Override
    public ArrayList<MPaciente> LeerTodo(PlatillaBD BaseDatos) {
        ArrayList<MPaciente> obj = dao.LeerTodo(BaseDatos);
        if (obj == null) {
//            view.displayMessage("Usuario no encontrado");
            System.out.println("Error");
            return null;
        } else {
            System.out.println("Se mostrara");

//            view.display(user);
            return obj;
        }
    }

    public ArrayList<DTOPaciente> LeerTodoS(PlatillaBD BaseDatos) {
        ArrayList<DTOPaciente> obj = dao.LeerTodo(BaseDatos);
        if (obj == null) {
//            view.displayMessage("Usuario no encontrado");
            System.out.println("Error");
            return null;
        } else {
            System.out.println("Se mostrara");

//            view.display(user);
            return obj;
        }
    }

    private ArrayList<DTOPaciente> PasarADTOMedico(List<MPaciente> MPaciente) {
        ArrayList<DTOPaciente> lista = new ArrayList<DTOPaciente>();
        for (MPaciente obj : MPaciente) {
            DTOPaciente x = new DTOPaciente(obj.getNumeroCedula(),obj.getNombre(),
                    obj.getFechaN(),obj.getTelefono(),obj.getCorreo());
            lista.add(x);
        }
        return lista;
    }

    @Override
    public boolean Actualizar(MPaciente obj, PlatillaBD BaseDatos) {
        if (dao.Leer(obj.getNumeroCedula(), BaseDatos) != null) {
//            view.displayMessage("Usuario ya existente, no se agregó");
            DTOPaciente DTOPaciente = new DTOPaciente(obj.getNumeroCedula(),obj.getNombre(),
                    obj.getFechaN(),obj.getTelefono(),obj.getCorreo());

            if (dao.Actualizar(DTOPaciente, BaseDatos)) {
//                view.displayMessage("Usuario gregado correctamente");
                System.out.println("actualizado");
                return true;
            } else {
//                view.displayMessage("Error al agregar el usuario");
                System.out.println("Error");
                return false;
            }
        } else {

            System.out.println("No existe");
            return false;

        }
    }

    @Override
    public boolean Eliminar(MPaciente obj, PlatillaBD BaseDatos) {
        if (dao.Leer(obj.getNumeroCedula(), BaseDatos) != null) {
            DTOPaciente DTOPaciente = new DTOPaciente(obj.getNumeroCedula(),obj.getNombre(),
                    obj.getFechaN(),obj.getTelefono(),obj.getCorreo());
            
//            DTOMedico DTOMedico = new DTOMedico(obj.getNumeroCedula(), obj.getNombre(), obj.getFechaNacimiento(), obj.getTelefono(),
//                    obj.getCorreo(), obj.getCodigo(), obj.getEspecialidad(), obj.getSalario());

            if (dao.Eliminar(DTOPaciente, BaseDatos)) {
//                view.displayMessage("Usuario gregado correctamente");
                System.out.println("eliminar");
                return true;
            } else {
//                view.displayMessage("Error al agregar el usuario");
                System.out.println("Error");
                return false;
            }
        } else {

            System.out.println("No existe");
            return false;

        }
    }
}
