/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BD;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emalo
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PlatillaBD bd = new PlatillaBD("127.0.0.1", "consultorio", "root", "emanuel12");
        Object[] x = new Object[1];
        x[0] = "emmanuel";

        buscar(x, bd);

//        // Eliminar un registro
//        String condicionEliminar = "id = ?";
//        Object[] parametrosEliminar = {1};
//        eliminarRegistro("prueba", condicionEliminar, parametrosEliminar, bd);


//        // Actualizar un registro
//        String setValuesActualizar = "nombre = ?";
//        String condicionActualizar = "id = ?";
//        Object[] parametrosActualizar = {"Poppe", 2}; //Aqui van los parametros los cuales queremos cambiar
//        actualizarRegistro("prueba", setValuesActualizar, condicionActualizar, parametrosActualizar, bd);


        // Mostrar todos los registros
//        Object[][] todosLosRegistros = mostrarTodosRegistros("prueba", bd);
//        imprimirRegistros(todosLosRegistros);
//
//        
//        System.out.println("");
//        System.out.println("");
//        System.out.println("SALTO");
//        System.out.println("");
//        System.out.println("");
//        
//        // Seleccionar un registro específico
//        String condicionSeleccionar = "id = ?";
//        Object[] parametrosSeleccionar = {4};
//        Object[] registroSeleccionado = seleccionarUnRegistro("prueba", condicionSeleccionar, parametrosSeleccionar, bd);
//        imprimirRegistro(registroSeleccionado);
//
//                
//        System.out.println("");
//        System.out.println("");
//        System.out.println("SALTO");
//        System.out.println("");
//        System.out.println("");
//        
        // Insertar un nuevo registro
        String columnasInsercion = "Cedula, Nombre, FechaN, Correo, Codigo, Especialidad, Salario";
        String valoresInsercion = "?,?,?,?,?,?,?";
        Object[] parametrosInsercion = {504370845,"Emmanuel Rodriguez","2023/02/02","Emmanuel@asd.com",258,"Enfermero",234.4};
        insertarRegistro("medicos", columnasInsercion, valoresInsercion, parametrosInsercion, bd);


    }

    public static void buscar(Object[] x, PlatillaBD bd) {
        bd.prepararSentencia("select * from prueba ");
        Object[][] resultado = bd.seleccionar(x);
        try {
            for (Object[] fila : resultado) {
                for (Object dato : fila) {
                    System.out.print(dato + "\t");
                }
                System.out.println();  // Nueva línea después de cada fila
            }
        } catch (Exception e) {
        }

    }

    public static void eliminarRegistro(String tabla, String condicion, Object[] parametros, PlatillaBD bd) {
        boolean resultado = bd.eliminarRegistro(tabla, condicion, parametros);
        if (resultado) {
            System.out.println("Registro eliminado correctamente");
        } else {
            System.out.println("Error al eliminar el registro: " + bd.getError());
        }
    }

    public static void actualizarRegistro(String tabla, String setValues, String condicion, Object[] parametros, PlatillaBD bd) {
        boolean resultado = bd.actualizarRegistro(tabla, setValues, condicion, parametros);
        if (resultado) {
            System.out.println("Registro actualizado correctamente");
        } else {
            System.out.println("Error al actualizar el registro: " + bd.getError());
        }
    }

    public static void imprimirRegistros(Object[][] registros) {
        if (registros != null) {
            for (Object[] fila : registros) {
                imprimirRegistro(fila);
            }
        }
    }

    public static void imprimirRegistro(Object[] registro) {
        if (registro != null) {
            for (Object dato : registro) {
                System.out.print(dato + "\t");
            }
            System.out.println();  // Nueva línea después de cada fila
        }
    }

    public static Object[][] mostrarTodosRegistros(String tabla, BD bd) {
        return bd.mostrarTodosRegistros(tabla);
    }

    public static Object[] seleccionarUnRegistro(String tabla, String condicion, Object[] parametros, BD bd) {
        return bd.seleccionarUnRegistro(tabla, condicion, parametros);
    }

    public static void insertarRegistro(String tabla, String columnas, String valores, Object[] parametros, BD bd) {
        boolean resultado = bd.insertarRegistro(tabla, columnas, valores, parametros);
        if (resultado) {
            System.out.println("Registro Agregado correctamente");
        } else {
            System.out.println("Error al actualizar el registro: " + bd.getError());
        }
    }

}
