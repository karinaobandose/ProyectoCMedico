/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import BD.PlatillaBD;
import DTO.DTOUsuario;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author emalo
 */
public class MUsuarioDAO implements Dao<DTOUsuario> {

    private HashMap<String, DTOUsuario> ListaUsuario;
    private static String Tabla = "usuarios";
    private String columnasInsercion = "";
    private String valoresInsercion = "";

    public MUsuarioDAO() {
        ListaUsuario = new HashMap();
        AgregarDeBaseDatos();
    }

    private void AgregarDeBaseDatos() {
        PlatillaBD bd = new PlatillaBD("127.0.0.1", "consultorio", "root", "emanuel12");
        Object[][] Lista = bd.mostrarTodosRegistros(Tabla);
        if (Lista != null) {
            for (Object[] fila : Lista) {
                DTOUsuario DTOUsuario = new DTOUsuario(fila);
                ListaUsuario.put(DTOUsuario.getNumeroCedula(), DTOUsuario);
            }
        }

    }

    @Override
    public boolean Agregar(DTOUsuario obj, PlatillaBD BaseDatos) {
        columnasInsercion = "Cedula, Nombre, FechaN, Telefono, Correo, Codigo, Especialidad, Salario, Usuario, Contrasena";
        valoresInsercion = "?,?,?,?,?,?,?,?,?,?";
        if (obj == null) {
            return false;
        }

        Object[] Parametros = {obj.getNumeroCedula(), obj.getNombre(), obj.getFechaNacimiento(), obj.getTelefono(),
            obj.getCorreo(), obj.getCodigo(), obj.getEspecialidad(), obj.getSalario(), obj.getUsuario(), obj.getContrasena()};
        boolean resultado;

        if (Leer(obj.getNumeroCedula(), BaseDatos) == null) {
            resultado = BaseDatos.insertarRegistro(Tabla, columnasInsercion, valoresInsercion, Parametros);
            String x = String.valueOf(obj.getNumeroCedula());
            ListaUsuario.put(x, obj);
            System.out.println("Registro Agregado correctamente");
            return resultado;
        } else if (Leer(obj.getNumeroCedula(), BaseDatos) instanceof DTOUsuario) {
            String x = String.valueOf(obj.getNumeroCedula());
            ListaUsuario.put(x, obj);
            System.out.println("Registro Agregado correctamente");
            return true;
        } else {
            System.out.println("Error al actualizar el registro: " + BaseDatos.getError());
            return false;
        }

    }

    @Override
    public DTOUsuario Leer(String Cedula, PlatillaBD BaseDatos) {
        String Condional = "Cedula = ?";
        Object[] Parametros = {Cedula};
        Object[] comprobar = BaseDatos.seleccionarUnRegistro(Tabla, Condional, Parametros);
        if (comprobar != null) {
            return this.ListaUsuario.get(Cedula);

        }
        return null;
    }

    @Override
    public ArrayList<DTOUsuario> LeerTodo(PlatillaBD BaseDatos) {
        return new ArrayList<>(ListaUsuario.values());
    }

    @Override
    public boolean Actualizar(DTOUsuario obj, PlatillaBD BaseDatos) {
        String setValuesActualizar = "Usuario = ?, Contrasena = ?";
        String condicionActualizar = "Cedula = ?";
        Object[] Parametros = {obj.getUsuario(), obj.getContrasena(), obj.getNumeroCedula()};
        boolean resultado = BaseDatos.actualizarRegistro(Tabla, setValuesActualizar, condicionActualizar, Parametros);
//        return this.Agregar(obj);
        AgregarDeBaseDatos();
        return resultado;
    }

    @Override
    public boolean Eliminar(DTOUsuario obj, PlatillaBD BaseDatos) {
        String condicionEliminar = "Cedula = ?";
        Object[] Parametro = {obj.getNumeroCedula()};
        String x = String.valueOf(obj.getNumeroCedula());
        System.out.println(ListaUsuario.size());

//        if (ListaUsuario.size()<1) {
//            
//        }
        boolean resultado = BaseDatos.eliminarRegistro(Tabla, condicionEliminar, Parametro);
        if (resultado) {
            ListaUsuario.remove(x);
            return true;
        } else {
            return false;
        }

    }
}
