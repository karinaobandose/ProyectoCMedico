/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.Controller;

import BD.PlatillaBD;
import DTO.DTOCita;
import Dao.Dao;
import MVC.Model.MCita;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emalo
 */
public class CCita implements Controlador<MCita> {

//    private View view;
    private Dao dao;

    public CCita(Dao dao) {
//        this.view = view;
        this.dao = dao;
    }

    @Override
    public boolean Agregar(MCita obj, PlatillaBD BaseDatos) {
        if (dao.Leer(obj.getNumeroCedula(), BaseDatos) != null) {
//            view.displayMessage("Usuario ya existente, no se agregó");
            System.out.println("Ya existe");
            return false;
        } else {
            DTOCita DTOMedico = new DTOCita();
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
    public MCita Leer(String Cedula, PlatillaBD BaseDatos) {
        DTOCita DTOMedico = (DTOCita) dao.Leer(Cedula, BaseDatos);
        if (DTOMedico == null) {
//            view.displayMessage("Usuario no encontrado");
            System.out.println("Error");
            return null;
        } else {
            MCita MCita = new MCita(DTOMedico.getNumeroCedula());
            System.out.println("Se mostrara");

//            view.display(user);
            return MCita;
        }
    }

    @Override
    public ArrayList<MCita> LeerTodo(PlatillaBD BaseDatos) {
        ArrayList<MCita> DTOMedico = dao.LeerTodo(BaseDatos);
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

    public ArrayList<DTOCita> LeerTodoS(PlatillaBD BaseDatos) {
        ArrayList<DTOCita> DTOMedico = dao.LeerTodo(BaseDatos);
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

    private ArrayList<DTOCita> PasarADTOMedico(List<MCita> MCita) {
        ArrayList<DTOCita> lista = new ArrayList<DTOCita>();
        for (MCita mCita : MCita) {
            DTOCita x = new DTOCita();
            lista.add(x);
        }
        return lista;
    }

    @Override
    public boolean Actualizar(MCita obj, PlatillaBD BaseDatos) {
        if (dao.Leer(obj.getNumeroCedula(), BaseDatos) != null) {
//            view.displayMessage("Usuario ya existente, no se agregó");
            DTOCita DTOCita = new DTOCita();

            if (dao.Actualizar(DTOCita, BaseDatos)) {
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
    public boolean Eliminar(MCita obj, PlatillaBD BaseDatos) {
        if (dao.Leer(obj.getNumeroCedula(), BaseDatos) != null) {
            DTOCita DTOCita = new DTOCita();
            
//            DTOMedico DTOMedico = new DTOMedico(obj.getNumeroCedula(), obj.getNombre(), obj.getFechaNacimiento(), obj.getTelefono(),
//                    obj.getCorreo(), obj.getCodigo(), obj.getEspecialidad(), obj.getSalario());

            if (dao.Eliminar(DTOCita, BaseDatos)) {
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
