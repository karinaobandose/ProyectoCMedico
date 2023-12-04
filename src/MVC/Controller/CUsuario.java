/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.Controller;

import BD.PlatillaBD;
import DTO.DTOUsuario;
import Dao.Dao;
import MVC.Model.MUsuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emalo
 */
public class CUsuario implements Controlador<MUsuario> {

//    private View view;
    private Dao dao;

    public CUsuario(Dao dao) {
//        this.view = view;
        this.dao = dao;
    }

    @Override
    public boolean Agregar(MUsuario obj, PlatillaBD BaseDatos) {
        if (dao.Leer(obj.getNumeroCedula(), BaseDatos) != null) {
//            view.displayMessage("Usuario ya existente, no se agregó");
            System.out.println("Ya existe");
            return false;
        } else {
            DTOUsuario DTO = new DTOUsuario(obj.getNumeroCedula(), obj.getNombre(), obj.getFechaNacimiento(), obj.getTelefono(),
                    obj.getCorreo(), obj.getCodigo(), obj.getEspecialidad(), obj.getSalario(),obj.getUsuario(),obj.getContrasena());
            if (dao.Agregar(DTO, BaseDatos)) {
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
    public MUsuario Leer(String Cedula, PlatillaBD BaseDatos) {
        DTOUsuario obj = (DTOUsuario) dao.Leer(Cedula, BaseDatos);
        System.out.println("Si esta el usuario "+obj.getUsuario());
        if (obj == null) {
//            view.displayMessage("Usuario no encontrado");
            System.out.println("Error");
            return null;
        } else {
            MUsuario MUsuario = new MUsuario(obj.getUsuario(),obj.getContrasena(),obj.getNumeroCedula(), obj.getNombre(), obj.getFechaNacimiento(), obj.getTelefono(),
                    obj.getCorreo(), obj.getCodigo(), obj.getEspecialidad(), obj.getSalario());
            System.out.println("Se mostrara");

//            view.display(user);
            return MUsuario;
        }
    }

    @Override
    public ArrayList<MUsuario> LeerTodo(PlatillaBD BaseDatos) {
        ArrayList<MUsuario> DTOMedico = dao.LeerTodo(BaseDatos);
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

    public ArrayList<DTOUsuario> LeerTodoS(PlatillaBD BaseDatos) {
        ArrayList<DTOUsuario> DTOMedico = dao.LeerTodo(BaseDatos);
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

//    private ArrayList<DTOUsuario> PasarADTOMedico(List<MUsuario> MUsuario) {
//        ArrayList<DTOUsuario> lista = new ArrayList<DTOUsuario>();
//        for (MUsuario mUsuario : MUsuario) {
//            DTOUsuario x = new DTOUsuario();
//            lista.add(x);
//        }
//        return lista;
//    }

    @Override
    public boolean Actualizar(MUsuario obj, PlatillaBD BaseDatos) {
        if (dao.Leer(obj.getNumeroCedula(), BaseDatos) != null) {
//            view.displayMessage("Usuario ya existente, no se agregó");
            DTOUsuario DTOUsuario = new DTOUsuario(obj.getNumeroCedula(),obj.getUsuario(),obj.getContrasena());

            if (dao.Actualizar(DTOUsuario, BaseDatos)) {
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
    public boolean Eliminar(MUsuario obj, PlatillaBD BaseDatos) {
        System.out.println("Cedula del eliminar" + obj.getNumeroCedula());
        if (dao.Leer(obj.getNumeroCedula(), BaseDatos) != null) {
            DTOUsuario DTOUsuario = new DTOUsuario(obj.getNumeroCedula(), obj.getNombre(), obj.getFechaNacimiento(), obj.getTelefono(),
                    obj.getCorreo(), obj.getCodigo(), obj.getEspecialidad(), obj.getSalario(),obj.getUsuario(),obj.getContrasena());
            
//            DTOMedico DTOMedico = new DTOMedico(obj.getNumeroCedula(), obj.getNombre(), obj.getFechaNacimiento(), obj.getTelefono(),
//                    obj.getCorreo(), obj.getCodigo(), obj.getEspecialidad(), obj.getSalario());

            if (dao.Eliminar(DTOUsuario, BaseDatos)) {
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
