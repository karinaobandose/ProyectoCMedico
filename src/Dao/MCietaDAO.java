/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import BD.PlatillaBD;
import DTO.DTOCita;
import MVC.Model.MMedico;
import MVC.Model.MPaciente;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author emalo
 */
public class MCietaDAO implements Dao<DTOCita> {

    private HashMap<String, DTOCita> ListaCitas;
    private static String Tabla = "citas";
    private String columnasInsercion = "";
    private String valoresInsercion = "";

    public MCietaDAO() {
        ListaCitas = new HashMap();
        AgregarDeBaseDatos();
    }

    private void AgregarDeBaseDatos() {
        PlatillaBD bd = new PlatillaBD("127.0.0.1", "consultorio", "root", "emanuel12");
        Object[][] Lista = bd.mostrarTodosRegistros(Tabla);
        if (Lista != null) {
            for (Object[] fila : Lista) {
                DTOCita DTOCita = new DTOCita(fila);
                ListaCitas.put(String.valueOf(DTOCita.getId()), DTOCita);
            }
        }

    }

    @Override
    public boolean Agregar(DTOCita obj, PlatillaBD BaseDatos) {
        columnasInsercion = "Fecha, Hora, CedulaPaciente, CedulaMedico";
        valoresInsercion = "?,?,?,?";
        if (obj == null) {
            return false;
        }

        System.out.println(obj.getFecha());
        System.out.println(obj.getHora());
        System.out.println(obj.getPaciente().getNumeroCedula());
        System.out.println(obj.getMedico().getNumeroCedula());

        Object[] Parametros = {obj.getFecha(), obj.getHora()+":00", obj.getPaciente().getNumeroCedula(), obj.getMedico().getNumeroCedula()};
        boolean resultado;
        System.out.println("EL RESULTADO DEL LEER ES" + Leer(String.valueOf(obj.getId()), BaseDatos));

        if (Leer(String.valueOf(obj.getId()), BaseDatos) == null) {
            resultado = BaseDatos.insertarRegistro(Tabla, columnasInsercion, valoresInsercion, Parametros);
            String x = String.valueOf(obj.getId());
            ListaCitas.put(x, obj);
            System.out.println("Registro Agregado correctamente, dentro de la base de datos");
            return resultado;
        } else if (Leer(String.valueOf(obj.getId()), BaseDatos) instanceof DTOCita) {
            String x = String.valueOf(obj.getId());
            ListaCitas.put(x, obj);
            System.out.println("Registro Agregado correctamente");
            return true;
        } else {
            System.out.println("Error al actualizar el registro: " + BaseDatos.getError());
            return false;
        }

    }

    @Override
    public DTOCita Leer(String Id, PlatillaBD BaseDatos) {
        String Condional = "id = ?";
        Object[] Parametros = {Id};
        Object[] comprobar = BaseDatos.seleccionarUnRegistro(Tabla, Condional, Parametros);
        if (comprobar != null) {
            return this.ListaCitas.get(Id);

        }
        return null;
    }

    @Override
    public ArrayList<DTOCita> LeerTodo(PlatillaBD BaseDatos) {
        return new ArrayList<>(ListaCitas.values());
    }

    @Override
    public boolean Actualizar(DTOCita obj, PlatillaBD BaseDatos) {
        String setValuesActualizar = "Fecha = ?, Hora= ?, CedulaPaciente= ?, CedulaMedico= ?";
        String condicionActualizar = "id = ?";
        Object[] Parametros = {obj.getFecha(), obj.getHora(), obj.getPaciente().getNumeroCedula(),
            obj.getMedico().getNumeroCedula(), obj.getId()};
        boolean resultado = BaseDatos.actualizarRegistro(Tabla, setValuesActualizar, condicionActualizar, Parametros);
//        return this.Agregar(obj);
        return resultado;
    }

    @Override
    public boolean Eliminar(DTOCita obj, PlatillaBD BaseDatos) {
        String condicionEliminar = "id = ?";
        Object[] Parametro = {obj.getId()};
        String x = String.valueOf(obj.getId());
        System.out.println(ListaCitas.size());

//        if (ListaMedicos.size()<1) {
//            
//        }
        boolean resultado = BaseDatos.eliminarRegistro(Tabla, condicionEliminar, Parametro);
        if (resultado) {
            ListaCitas.remove(x);
            return true;
        } else {
            return false;
        }

    }
}
