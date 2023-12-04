/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC.Controller;

import BD.PlatillaBD;
import DTO.DTOCita;
import DTO.DTOMedico;
import DTO.DTOPaciente;
import Dao.Dao;
import MVC.Model.MCita;
import MVC.Model.MPaciente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emalo
 */
public class CCita implements Controlador<MCita> {

//    private View view;
    private Dao dao;
    private Dao daoMedico;
    private Dao daoPaciente;

    public CCita(Dao dao, Dao daoMedico, Dao daoPaciente) {
//        this.view = view;
        this.dao = dao;
        this.daoMedico = daoMedico;
        this.daoPaciente = daoPaciente;
    }

    @Override
    public boolean Agregar(MCita obj, PlatillaBD BaseDatos) {
        if (dao.Leer(String.valueOf(obj.getId()), BaseDatos) != null) {
//            view.displayMessage("Usuario ya existente, no se agregó");
            System.out.println("Ya existe");
            return false;
        } else {
            DTOCita DTO = new DTOCita(obj.getId(), obj.getFecha(), obj.getHora(), obj.getPaciente(), obj.getMedico());
            if (dao.Agregar(DTO, BaseDatos)) {
//                view.displayMessage("Usuario gregado correctamente");
                System.out.println("Agregado");
                return true;
            } else {
//                view.displayMessage("Error al agregar el usuario");
                System.out.println("Error asdasdsa");
                return false;
            }

        }
    }

    @Override
    public MCita Leer(String id, PlatillaBD BaseDatos) {
        DTOCita DTO = (DTOCita) dao.Leer(id, BaseDatos);
        if (DTO == null) {
//            view.displayMessage("Usuario no encontrado");
            System.out.println("Error");
            return null;
        } else {
            DTOPaciente TempDTOPaciente = (DTOPaciente) this.daoPaciente.Leer(DTO.getPaciente().getNumeroCedula(), BaseDatos);
//            MPaciente PacienteTemp = new MPaciente(TempDTOPaciente.getNumeroCedula(),
//                    TempDTOPaciente.getNombre(),TempDTOPaciente.getFechaN(),
//                    TempDTOPaciente.getTelefono(),TempDTOPaciente.getCorreo());
            DTOMedico MedicoTemp = (DTOMedico) this.daoPaciente.Leer(DTO.getPaciente().getNumeroCedula(), BaseDatos);

            MCita MCita = new MCita(DTO.getId(),DTO.getFecha(),DTO.getHora(),DTO.getPaciente(),DTO.getMedico());
            System.out.println("Se mostrara");

//            view.display(user);
            return MCita;
        }
    }

    @Override
    public ArrayList<MCita> LeerTodo(PlatillaBD BaseDatos) {
        ArrayList<MCita> DTO = dao.LeerTodo(BaseDatos);
        if (DTO == null) {
//            view.displayMessage("Usuario no encontrado");
            System.out.println("Error");
            return null;
        } else {
            System.out.println("Se mostrara");

//            view.display(user);
            return DTO;
        }
    }

    public ArrayList<DTOCita> LeerTodoS(PlatillaBD BaseDatos) {
        ArrayList<DTOCita> DTO = dao.LeerTodo(BaseDatos);
        if (DTO == null) {
//            view.displayMessage("Usuario no encontrado");
            System.out.println("Error");
            return null;
        } else {
            System.out.println("Se mostrara");

//            view.display(user);
            return DTO;
        }
    }

    private ArrayList<DTOCita> PasarADTO(List<MCita> MCita) {
        ArrayList<DTOCita> lista = new ArrayList<DTOCita>();
        for (MCita mCita : MCita) {
            DTOCita x = new DTOCita(mCita.getId(),mCita.getFecha(),mCita.getHora(),mCita.getPaciente(),mCita.getMedico());
            lista.add(x);
        }
        return lista;
    }

    @Override
    public boolean Actualizar(MCita obj, PlatillaBD BaseDatos) {
        if (dao.Leer(String.valueOf(obj.getId()), BaseDatos) != null) {
//            view.displayMessage("Usuario ya existente, no se agregó");
            DTOCita DTOCita = new DTOCita(obj.getId(),obj.getFecha(),obj.getHora(),obj.getPaciente(),obj.getMedico());

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
        if (dao.Leer(String.valueOf(obj.getId()), BaseDatos) != null) {
            DTOCita DTOCita = new DTOCita(obj.getId(),obj.getFecha(),
                    obj.getHora(),obj.getPaciente(),obj.getMedico());

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
