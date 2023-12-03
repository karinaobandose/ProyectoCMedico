/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.Controller;

import BD.PlatillaBD;
import DTO.DTOExpediente;
import Dao.Dao;
import MVC.Model.MExpediente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emalo
 */
public class CExpediente implements Controlador<MExpediente> {

//    private View view;
    private Dao dao;

    public CExpediente(Dao dao) {
//        this.view = view;
        this.dao = dao;
    }

    @Override
    public boolean Agregar(MExpediente obj, PlatillaBD BaseDatos) {
        if (dao.Leer(obj.getNumeroCedula(), BaseDatos) != null) {
//            view.displayMessage("Usuario ya existente, no se agregó");
            System.out.println("Ya existe");
            return false;
        } else {
            DTOExpediente DTOMedico = new DTOExpediente();
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
    public MExpediente Leer(String Cedula, PlatillaBD BaseDatos) {
        DTOExpediente DTOMedico = (DTOExpediente) dao.Leer(Cedula, BaseDatos);
        if (DTOMedico == null) {
//            view.displayMessage("Usuario no encontrado");
            System.out.println("Error");
            return null;
        } else {
            MExpediente MExpediente = new MExpediente(DTOMedico.getNumeroCedula());
            System.out.println("Se mostrara");

//            view.display(user);
            return MExpediente;
        }
    }

    @Override
    public ArrayList<MExpediente> LeerTodo(PlatillaBD BaseDatos) {
        ArrayList<MExpediente> DTOMedico = dao.LeerTodo(BaseDatos);
        if (DTOMedico == null) {
//            view.displayMessage("Usuario no encontrado");
            System.out.println("Error");
            return null;
        } else {
            System.out.println("Se mostrara");

//            view.display(user);
            return DTOMedico;
        }
    }

    public ArrayList<DTOExpediente> LeerTodoS(PlatillaBD BaseDatos) {
        ArrayList<DTOExpediente> DTOMedico = dao.LeerTodo(BaseDatos);
        if (DTOMedico == null) {
//            view.displayMessage("Usuario no encontrado");
            System.out.println("Error");
            return null;
        } else {
            System.out.println("Se mostrara");

//            view.display(user);
            return DTOMedico;
        }
    }

    private ArrayList<DTOExpediente> PasarADTOMedico(List<MExpediente> MExpediente) {
        ArrayList<DTOExpediente> lista = new ArrayList<DTOExpediente>();
        for (MExpediente mExpediente : MExpediente) {
            DTOExpediente x = new DTOExpediente();
            lista.add(x);
        }
        return lista;
    }

    @Override
    public boolean Actualizar(MExpediente obj, PlatillaBD BaseDatos) {
        if (dao.Leer(obj.getNumeroCedula(), BaseDatos) != null) {
//            view.displayMessage("Usuario ya existente, no se agregó");
            DTOExpediente DTOExpediente = new DTOExpediente();

            if (dao.Actualizar(DTOExpediente, BaseDatos)) {
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
    public boolean Eliminar(MExpediente obj, PlatillaBD BaseDatos) {
        if (dao.Leer(obj.getNumeroCedula(), BaseDatos) != null) {
            DTOExpediente DTOExpediente = new DTOExpediente();
            
//            DTOMedico DTOMedico = new DTOMedico(obj.getNumeroCedula(), obj.getNombre(), obj.getFechaNacimiento(), obj.getTelefono(),
//                    obj.getCorreo(), obj.getCodigo(), obj.getEspecialidad(), obj.getSalario());

            if (dao.Eliminar(DTOExpediente, BaseDatos)) {
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
