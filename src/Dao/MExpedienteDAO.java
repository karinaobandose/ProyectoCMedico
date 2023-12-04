/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import BD.PlatillaBD;
import DTO.DTOExpediente;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author emalo
 */
public class MExpedienteDAO implements Dao<DTOExpediente> {

    private HashMap<String, DTOExpediente> ListaExpediente;
    private static String Tabla = "expedientes";
    private String columnasInsercion = "";
    private String valoresInsercion = "";
    private int Ultimo;

    public MExpedienteDAO() {
        ListaExpediente = new HashMap();
        AgregarDeBaseDatos();
    }

    private void AgregarDeBaseDatos() {
        PlatillaBD bd = new PlatillaBD("127.0.0.1", "consultorio", "root", "Joseph");
        Object[][] Lista = bd.mostrarTodosRegistros(Tabla);
        if (Lista != null) {
            for (Object[] fila : Lista) {
                DTOExpediente Expediente = new DTOExpediente(fila);
                ListaExpediente.put(String.valueOf(Expediente.getNumeroExpediente()), Expediente);
            }
        }

    }

    @Override
    public boolean Agregar(DTOExpediente obj, PlatillaBD BaseDatos) {

        System.out.println("AGREGAR DEL DAO");

        columnasInsercion = "numeroexpediente,Fecha,Hora,CedulaMedio,Descripcion";
        valoresInsercion = "?,?,?,?,?";
        if (obj == null) {
            return false;
        }

        Object[] Parametros = {obj.getNumeroExpediente(), obj.getFecha(), obj.getHora() + ":00", obj.getMedico(), obj.getDescripcion()};
        boolean resultado;
        System.out.println("EL RESULTADO DEL LEER ES" + Leer(String.valueOf(obj.getNumeroExpediente()), BaseDatos));

        if (Leer(String.valueOf(obj.getNumeroExpediente()), BaseDatos) == null) {
            resultado = BaseDatos.insertarRegistro(Tabla, columnasInsercion, valoresInsercion, Parametros);
            ListaExpediente.put(obj.getNumeroExpediente(), obj);
            System.out.println("Registro Agregado correctamente, dentro de la base de datos");
            return resultado;
        } else if (Leer(obj.getNumeroExpediente(), BaseDatos) instanceof DTOExpediente) {
            ListaExpediente.put(obj.getNumeroExpediente(), obj);
            System.out.println("Registro Agregado correctamente");
            return true;
        } else {
            System.out.println("Error al actualizar el registro: " + BaseDatos.getError());
            return false;
        }

    }

    @Override
    public DTOExpediente Leer(String numeroexpediente, PlatillaBD BaseDatos) {
        String Condional = "numeroexpediente = ?";
        Object[] Parametros = {numeroexpediente};
        Object[] comprobar = BaseDatos.seleccionarUnRegistro(Tabla, Condional, Parametros);
        if (comprobar != null) {
            return this.ListaExpediente.get(numeroexpediente);

        }
        return null;
    }

    @Override
    public ArrayList<DTOExpediente> LeerTodo(PlatillaBD BaseDatos) {
        return new ArrayList<>(ListaExpediente.values());
    }

    @Override
    public boolean Actualizar(DTOExpediente obj, PlatillaBD BaseDatos) {
        String setValuesActualizar = "Fecha = ?, Hora= ?, CedulaMedio= ?, Descripcion= ?";
        String condicionActualizar = "numeroexpediente = ?";
        Object[] Parametros = {obj.getFecha(), obj.getHora() + ":00", obj.getMedico(),
            obj.getDescripcion(), obj.getNumeroExpediente()};
        boolean resultado = BaseDatos.actualizarRegistro(Tabla, setValuesActualizar, condicionActualizar, Parametros);
//        return this.Agregar(obj);
        AgregarDeBaseDatos();
        return resultado;
    }

    @Override
    public boolean Eliminar(DTOExpediente obj, PlatillaBD BaseDatos) {
        String condicionEliminar = "numeroexpediente = ?";
        Object[] Parametro = {obj.getNumeroExpediente()};
        String x = String.valueOf(obj.getNumeroExpediente());

//        if (ListaMedicos.size()<1) {
//            
//        }
        boolean resultado = BaseDatos.eliminarRegistro(Tabla, condicionEliminar, Parametro);
        if (resultado) {
            ListaExpediente.remove(x);
            return true;
        } else {
            return false;
        }

    }
}
