/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BD;

/**
 *
 * @author emalo
 */
public class PlatillaBD extends BD{

    public PlatillaBD(String servidor, String baseD, String usuario, String contrasena) {
        super("com.mysql.cj.jdbc.Driver", "jdbc", "mysql", servidor, baseD, usuario, contrasena);

    }

}
