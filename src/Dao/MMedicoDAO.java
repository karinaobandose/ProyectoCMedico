/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import BD.PlatillaBD;
import DTO.DTOMedico;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author emalo
 */
public class MMedicoDAO implements Dao<DTOMedico> {

    private HashMap<String, DTOMedico> ListaMedicos;
    private static String Tabla = "medicos";
    private String columnasInsercion = "";
    private String valoresInsercion = "";

    public MMedicoDAO() {
        ListaMedicos = new HashMap();
        AgregarDeBaseDatos();
    }
    
    private void AgregarDeBaseDatos(){
        PlatillaBD bd = new PlatillaBD("127.0.0.1", "consultorio", "root", "emanuel12");
        Object[][] Lista = bd.mostrarTodosRegistros(Tabla);
        if (Lista != null) {
            for (Object[] fila : Lista) {
                DTOMedico DTOMedico = new DTOMedico(fila);
                ListaMedicos.put(DTOMedico.getNumeroCedula(), DTOMedico);
            }
        }
        
    }

    @Override
    public boolean Agregar(DTOMedico obj, PlatillaBD BaseDatos) {
        columnasInsercion = "Cedula, Nombre, FechaN, Telefono, Correo, Codigo, Especialidad, Salario";
        valoresInsercion = "?,?,?,?,?,?,?,?";
        if (obj == null) {
            return false;
        }

        Object[] Parametros = {obj.getNumeroCedula(), obj.getNombre(), obj.getFechaNacimiento(), obj.getTelefono(),
            obj.getCorreo(), obj.getCodigo(), obj.getEspecialidad(), obj.getSalario()};
        boolean resultado = BaseDatos.insertarRegistro(Tabla, columnasInsercion, valoresInsercion, Parametros);

        if (resultado) {
            String x = String.valueOf(obj.getNumeroCedula());
            ListaMedicos.put(x, obj);
            System.out.println("Registro Agregado correctamente");
            return true;
        } else {
            System.out.println("Error al actualizar el registro: " + BaseDatos.getError());
            return false;
        }

    }

    @Override
    public DTOMedico Leer(String Cedula, PlatillaBD BaseDatos) {
        String Condional = "Cedula = ?";
        Object[] Parametros = {Cedula};
        Object[] comprobar = BaseDatos.seleccionarUnRegistro(Tabla, Condional, Parametros);
        if (comprobar != null) {
            return this.ListaMedicos.get(Cedula);

        }
        return null;
    }

    @Override
    public ArrayList<DTOMedico> LeerTodo(PlatillaBD BaseDatos) {
        return new ArrayList<>(ListaMedicos.values());
    }

    @Override
    public boolean Actualizar(DTOMedico obj, PlatillaBD BaseDatos) {
//        return this.Agregar(obj);
        return false;
    }

    @Override
    public boolean Eliminar(DTOMedico obj, PlatillaBD BaseDatos) {
        String x = String.valueOf(obj.getNumeroCedula());
        return ListaMedicos.remove(x) != null;
    }

}
