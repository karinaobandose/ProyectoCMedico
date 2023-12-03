/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import BD.PlatillaBD;
import DTO.DTOPaciente;
import MVC.Model.MPaciente;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author emalo
 */
public class MPacienteDAO implements Dao<DTOPaciente> {

    private HashMap<String, DTOPaciente> ListaPacientes;
    private static String Tabla = "pacientes";
    private String columnasInsercion = "";
    private String valoresInsercion = "";

    public MPacienteDAO() {
        ListaPacientes = new HashMap();
        AgregarDeBaseDatos();
    }

    private void AgregarDeBaseDatos() {
        PlatillaBD bd = new PlatillaBD("127.0.0.1", "consultorio", "root", "emanuel12");
        Object[][] Lista = bd.mostrarTodosRegistros(Tabla);
        if (Lista != null) {
            for (Object[] fila : Lista) {
                DTOPaciente DTOPaciente = new DTOPaciente(fila);
                ListaPacientes.put(DTOPaciente.getNumeroCedula(), DTOPaciente);
            }
        }

    }

    @Override
    public boolean Agregar(DTOPaciente obj, PlatillaBD BaseDatos) {
        columnasInsercion = "Cedula, Nombre, FechaN, Telefono, Correo";
        valoresInsercion = "?,?,?,?,?";
        if (obj == null) {
            return false;
        }

        Object[] Parametros = {obj.getNumeroCedula(), obj.getNombre(), obj.getFechaN(), obj.getTelefono(),
            obj.getCorreo()};
        boolean resultado;

        if (Leer(obj.getNumeroCedula(), BaseDatos) == null) {
            resultado = BaseDatos.insertarRegistro(Tabla, columnasInsercion, valoresInsercion, Parametros);
            String x = String.valueOf(obj.getNumeroCedula());
            ListaPacientes.put(x, obj);
            System.out.println("Registro Agregado correctamente");
            return resultado;
        } else if (Leer(obj.getNumeroCedula(), BaseDatos) instanceof DTOPaciente) {
            String x = String.valueOf(obj.getNumeroCedula());
            ListaPacientes.put(x, obj);
            System.out.println("Registro Agregado correctamente");
            return true;
        } else {
            System.out.println("Error al actualizar el registro: " + BaseDatos.getError());
            return false;
        }

    }

    @Override
    public DTOPaciente Leer(String Cedula, PlatillaBD BaseDatos) {
        String Condional = "Cedula = ?";
        Object[] Parametros = {Cedula};
        Object[] comprobar = BaseDatos.seleccionarUnRegistro(Tabla, Condional, Parametros);
        if (comprobar != null) {
            return this.ListaPacientes.get(Cedula);

        }
        return null;
    }

    @Override
    public ArrayList<DTOPaciente> LeerTodo(PlatillaBD BaseDatos) {
        return new ArrayList<>(ListaPacientes.values());
    }

    @Override
    public boolean Actualizar(DTOPaciente obj, PlatillaBD BaseDatos) {
        String setValuesActualizar = "Nombre = ?, FechaN = ?, Telefono = ?, Correo = ?";
        String condicionActualizar = "Cedula = ?";
        Object[] Parametros = {obj.getNombre(), obj.getFechaN(), obj.getTelefono(),
            obj.getCorreo(), obj.getNumeroCedula()};
        boolean resultado = BaseDatos.actualizarRegistro(Tabla, setValuesActualizar, condicionActualizar, Parametros);
//        return this.Agregar(obj);
        return resultado;
    }

    @Override
    public boolean Eliminar(DTOPaciente obj, PlatillaBD BaseDatos) {
        String condicionEliminar = "Cedula = ?";
        Object[] Parametro = {obj.getNumeroCedula()};
        String x = String.valueOf(obj.getNumeroCedula());
        System.out.println(ListaPacientes.size());

//        if (ListaMedicos.size()<1) {
//            
//        }
        boolean resultado = BaseDatos.eliminarRegistro(Tabla, condicionEliminar, Parametro);
        if (resultado) {
            ListaPacientes.remove(x);
            return true;
        } else {
            return false;
        }

    }

}
