/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BD;

import Dao.MMedicoDAO;
import MVC.Controller.CMedico;
import MVC.Model.MMedico;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author emalo
 */
public class prueba2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PlatillaBD bd = new PlatillaBD("127.0.0.1", "consultorio", "root", "emanuel12");
//        Date fechaManual = new Date(1900, 11, 1);
//        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
//        String fechaFormateada = formato.format(fechaManual);
//        LocalDate fecha = LocalDate.of(2023, 12, 1);

        LocalDate fechaLocalDate = LocalDate.of(2023, 12, 1);
        Date fechaDate = java.sql.Date.valueOf(fechaLocalDate);
        System.out.println(fechaDate);

        MMedico medico = new MMedico("123", "Emmanuel", fechaDate, "61689514", "Emmanuel@asd.com", 5650, "Doctor", 500.79);
        MMedico medico1 = new MMedico("234", "Perez", fechaDate, "61689514", "Emmanuel@asd.com", 5650, "Doctor", 500.79);
        MMedico medico2 = new MMedico("456", "Maria", fechaDate, "61689514", "Emmanuel@asd.com", 5650, "Doctor", 500.79);

        System.out.println(medico.EstaCompleto());

        MMedicoDAO Dao = new MMedicoDAO();

        CMedico Controller = new CMedico(Dao);

        ArrayList<MMedico> x = Controller.LeerTodo(bd);
        
        System.out.println(x.get(0).getNumeroCedula());



//        Controller.Agregar(medico,bd);
//        Controller.Agregar(medico1,bd);
//        Controller.Agregar(medico2,bd);
//
//        System.out.println(Controller.Leer("234",bd).getNombre());;
//        Controller.Leer("404370845",bd);
//        Controller.Leer("404370845",bd);
    }

}
