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
    private int Ultimo;

    public MCietaDAO() {
        ListaCitas = new HashMap();
        AgregarDeBaseDatos();
    }

    private void AgregarDeBaseDatos() {
        PlatillaBD bd = new PlatillaBD("127.0.0.1", "consultorio", "root", "Joseph");
        Object[][] Lista = bd.mostrarTodosRegistros(Tabla);
        if (Lista != null) {
            for (Object[] fila : Lista) {
                DTOCita Cita = new DTOCita(fila);
                ListaCitas.put(String.valueOf(Cita.getId()), Cita);
                Ultimo = Cita.getId();
            }
        }

    }

    @Override
    public boolean Agregar(DTOCita obj, PlatillaBD BaseDatos) {

        System.out.println("AGREGAR DEL DAO");

        columnasInsercion = "Fecha, Hora, CedulaPaciente, CedulaMedico";
        valoresInsercion = "?,?,?,?";
        if (obj == null) {
            return false;
        }

        System.out.println(obj.getFecha());
        System.out.println(obj.getHora());
        System.out.println(obj.getPaciente());
        System.out.println(obj.getMedico());

        Object[] Parametros = {obj.getFecha(), obj.getHora() + ":00", obj.getPaciente(), obj.getMedico()};
        boolean resultado;
        System.out.println("EL RESULTADO DEL LEER ES" + Leer(String.valueOf(obj.getId()), BaseDatos));

        if (Leer(String.valueOf(obj.getId()), BaseDatos) == null) {
            resultado = BaseDatos.insertarRegistro(Tabla, columnasInsercion, valoresInsercion, Parametros);
            Ultimo++;
            System.out.println(Ultimo);
            obj.setId(Ultimo);
            ListaCitas.put(String.valueOf(Ultimo), obj);
            System.out.println("Registro Agregado correctamente, dentro de la base de datos");
            return resultado;
        } else if (Leer(String.valueOf(obj.getId()), BaseDatos) instanceof DTOCita) {
            String x = String.valueOf(obj.getId());
            ListaCitas.put(String.valueOf(Ultimo), obj);
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
        Object[] Parametros = {obj.getFecha(), obj.getHora() + ":00", obj.getPaciente(),
            obj.getMedico(), obj.getId()};
        boolean resultado = BaseDatos.actualizarRegistro(Tabla, setValuesActualizar, condicionActualizar, Parametros);
//        return this.Agregar(obj);
        AgregarDeBaseDatos();
        return resultado;
    }

    @Override
    public boolean Eliminar(DTOCita obj, PlatillaBD BaseDatos) {
        String condicionEliminar = "id = ?";
        Object[] Parametro = {obj.getId()};
        String x = String.valueOf(obj.getId());

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
