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
    private Dao daoMedico;

    public CExpediente(Dao dao,Dao daoMedico) {
//        this.view = view;
        this.dao = dao;
        this.daoMedico = daoMedico;
    }

    @Override
    public boolean Agregar(MExpediente obj, PlatillaBD BaseDatos) {
        if (dao.Leer(obj.getNumeroExpediente(), BaseDatos) != null) {
//            view.displayMessage("Usuario ya existente, no se agregó");
            System.out.println("Ya existe");
            return false;
        } else {
            DTOExpediente DTOMedico = new DTOExpediente(obj.getNumeroExpediente(),
                    obj.getFecha(),obj.getHora(),obj.getMedico(),obj.getDescripcion());
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
    public MExpediente Leer(String NumeroExpediente, PlatillaBD BaseDatos) {
        DTOExpediente DTO = (DTOExpediente) dao.Leer(NumeroExpediente, BaseDatos);
        if (DTO == null) {
//            view.displayMessage("Usuario no encontrado");
            System.out.println("Error");
            return null;
        } else {
            MExpediente MExpediente = new MExpediente(DTO.getNumeroExpediente(),
                    DTO.getFecha(),DTO.getHora(),
                    DTO.getMedico(),DTO.getDescripcion());
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

//    private ArrayList<DTOExpediente> PasarADTOMedico(List<MExpediente> MExpediente) {
//        ArrayList<DTOExpediente> lista = new ArrayList<DTOExpediente>();
//        for (MExpediente mExpediente : MExpediente) {
//            DTOExpediente x = new DTOExpediente();
//            lista.add(x);
//        }
//        return lista;
//    }

    @Override
    public boolean Actualizar(MExpediente obj, PlatillaBD BaseDatos) {
        if (dao.Leer(obj.getNumeroExpediente(), BaseDatos) != null) {
//            view.displayMessage("Usuario ya existente, no se agregó");
            DTOExpediente DTOExpediente = new DTOExpediente(obj.getNumeroExpediente(),
                    obj.getFecha(),obj.getHora(),obj.getMedico(),obj.getDescripcion());

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
        if (dao.Leer(obj.getNumeroExpediente(), BaseDatos) != null) {
            DTOExpediente DTOExpediente = new DTOExpediente(obj.getNumeroExpediente(),
                    obj.getFecha(),obj.getHora(),obj.getMedico(),obj.getDescripcion());
            
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
