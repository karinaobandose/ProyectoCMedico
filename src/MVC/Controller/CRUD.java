/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package MVC.Controller;

import BD.PlatillaBD;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emalo
 */
public interface CRUD<Class> {
    public boolean Agregar(Class obj, PlatillaBD BaseDatos);
    public Class Leer(String id, PlatillaBD BaseDatos);
    public ArrayList<Class> LeerTodo(PlatillaBD BaseDatos);
    public boolean Actualizar(Class obj, PlatillaBD BaseDatos);
    public boolean Eliminar(Class obj, PlatillaBD BaseDatos);
}
