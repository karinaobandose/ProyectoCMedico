/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BD;

import DTO.DTOMedico;
import Dao.MMedicoDAO;
import MVC.Controller.CMedico;
import MVC.Model.MMedico;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in);

        MMedicoDAO Dao = new MMedicoDAO();

        CMedico Controller = new CMedico(Dao);

        int numeroIngresado;

        do {
            System.out.print("Ingresa un número (1 para continuar, 99 para detener): ");
            numeroIngresado = scanner.nextInt();

            if (numeroIngresado == 1) {
                System.out.println("Continuando...");
                LocalDate fechaLocalDate = LocalDate.of(2023, 12, 1);
                Date fechaDate = java.sql.Date.valueOf(fechaLocalDate);
                System.out.println(fechaDate);

                MMedico medico = new MMedico("4141", "Emmanuel", fechaDate, "61689514", "Emmanuel@asd.com", 5650, "Doctor", 500.79);
                MMedico medico1 = new MMedico("234", "Perez", fechaDate, "61689514", "Emmanuel@asd.com", 5650, "Doctor", 500.79);
                MMedico medico2 = new MMedico("456", "Maria", fechaDate, "61689514", "Emmanuel@asd.com", 5650, "Doctor", 500.79);

                System.out.println(medico.EstaCompleto());

                Controller.Agregar(medico, bd);
                Controller.Agregar(medico1, bd);
                Controller.Agregar(medico2, bd);

                ArrayList<DTOMedico> x = Controller.LeerTodoS(bd);
                for (DTOMedico mMedico : x) {
                    System.out.println("Cedula: " + mMedico.getNumeroCedula());
                    System.out.println("Nombre: " + mMedico.getNombre());
                    System.out.println("Fecha Nacimiento: " + mMedico.getFechaNacimiento());
                    System.out.println("Telefono: " + mMedico.getTelefono());
                    System.out.println("Correo: " + mMedico.getCorreo());
                    System.out.println("Codigo: " + mMedico.getCodigo());
                    System.out.println("Especialidad: " + mMedico.getEspecialidad());
                    System.out.println("Salario: " + mMedico.getSalario());
                    System.out.println("-----------------------");
                }
            } else if (numeroIngresado == 99) {
                System.out.println("Deteniendo...");
                
            } else if (numeroIngresado == 3) {
                System.out.print("cedula");
                String x1 = scanner.next();
                MMedico temp = Controller.Leer(x1, bd);
                Controller.Eliminar(temp, bd);
            } else if (numeroIngresado == 2) {
                System.out.print("cedula");
                String x1 = scanner.next();
                System.out.print("nombre");
                String x2 = scanner.next();
                System.out.print("fecha");
                String x3 = scanner.next();
                System.out.print("tele");
                String x4 = scanner.next();
                System.out.print("correo");
                String x5 = scanner.next();
                System.out.print("codigo");
                Integer x6 = scanner.nextInt();
                System.out.print("especialidad");
                String x7 = scanner.next();
                System.out.print("salario");
                double x8 = scanner.nextDouble();

                MMedico temp = Controller.Leer(x1, bd);
                Controller.Eliminar(temp, bd);

                if (x1.isEmpty()) {
                    x1 = temp.getNumeroCedula();
                }
                if (x2.isEmpty()) {
                    x2 = temp.getNombre();
                }
                if (x3.isEmpty()) {
                    x3 = String.valueOf(temp.getFechaNacimiento());
                }
                if (x4.isEmpty()) {
                    x4 = temp.getTelefono();
                }
                if (x5.isEmpty()) {
                    x5 = temp.getCorreo();
                }
                if (x6.equals(null)) {
                    x6 = temp.getCodigo();
                }
                if (!x7.isEmpty()) {
                    x7 = temp.getEspecialidad();
                }

                Date fechaDate = java.sql.Date.valueOf(x3);

                MMedico tempobjecto = new MMedico(x1, x2, fechaDate, x4, x5, x6, x7, x8);

                Controller.Actualizar(tempobjecto, bd);

                
                System.out.println("Deteniendo...");
            } else {
                System.out.println("Número no reconocido. Inténtalo de nuevo.");
            }

        } while (numeroIngresado != 99);

//
//        System.out.println(Controller.Leer("234",bd).getNombre());;
//        Controller.Leer("404370845",bd);
//        Controller.Leer("404370845",bd);
    }

}
