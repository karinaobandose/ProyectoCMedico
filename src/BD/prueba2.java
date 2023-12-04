/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BD;

import DTO.DTOCita;
import DTO.DTOExpediente;
import DTO.DTOMedico;
import DTO.DTOPaciente;
import DTO.DTOUsuario;
import Dao.MCietaDAO;
import Dao.MExpedienteDAO;
import Dao.MMedicoDAO;
import Dao.MPacienteDAO;
import Dao.MUsuarioDAO;
import MVC.Controller.CCita;
import MVC.Controller.CExpediente;
import MVC.Controller.CMedico;
import MVC.Controller.CPaciente;
import MVC.Controller.CUsuario;
import MVC.Model.MCita;
import MVC.Model.MExpediente;
import MVC.Model.MMedico;
import MVC.Model.MPaciente;
import MVC.Model.MUsuario;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
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
        PlatillaBD bd = new PlatillaBD("127.0.0.1", "consultorio", "root", "Joseph");
//        Date fechaManual = new Date(1900, 11, 1);
//        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
//        String fechaFormateada = formato.format(fechaManual);
//        LocalDate fecha = LocalDate.of(2023, 12, 1);

        Scanner scanner = new Scanner(System.in);

        MPacienteDAO DaoPaciente = new MPacienteDAO();
        MMedicoDAO DaoMedico = new MMedicoDAO();
        MCietaDAO DaoCitas = new MCietaDAO();
        MExpedienteDAO DaoExpediente = new MExpedienteDAO();
        MUsuarioDAO DaoUsuario = new MUsuarioDAO();

        CPaciente ControllerPaciente = new CPaciente(DaoPaciente);
        CMedico ControllerMedico = new CMedico(DaoMedico);
        CUsuario ControllerUsuario = new CUsuario(DaoUsuario);
        CCita ControllerCita = new CCita(DaoCitas, DaoMedico, DaoPaciente);
        CExpediente ControllerExpediente = new CExpediente(DaoExpediente, DaoMedico);
        

        ArrayList<DTOUsuario> x = ControllerUsuario.LeerTodoS(bd);

        System.out.println("--------------------------");
        System.out.println("--------------------------");
        System.out.println("--------------------------");

        for (DTOUsuario mMedico : x) {
            System.out.print("Cedula: " + mMedico.getNumeroCedula()+ " / ");
            System.out.print("Usuario: " + mMedico.getUsuario()+ " / ");
            System.out.print("Contrasena: " + mMedico.getContrasena()+ " / ");
            System.out.println("");
            System.out.println("-----------------------");
        }

        int numeroIngresado;

        do {
            System.out.print("Ingresa un número (1 para continuar, 99 para detener): ");
            numeroIngresado = scanner.nextInt();

            if (numeroIngresado == 1) {
                System.out.println("Continuando...");
                LocalDate fechaLocalDate = LocalDate.of(2000, 12, 1);
                Date fechaDate = java.sql.Date.valueOf(fechaLocalDate);
                System.out.println(fechaDate);

                LocalTime horaEspecifica = LocalTime.of(10, 30, 00);

                MPaciente Paciente = new MPaciente("4141", "Emmanuel", fechaDate, "61689514", "Emmanuel@asd.com");
                MMedico medico = new MMedico("985", "Emmanuel", fechaDate, "61689514", "Emmanuel@asd.com", 5056, "Medico", 1555);
                MUsuario Usuario = new MUsuario("JK", 12345, "951", "Emmanuel", fechaDate, "61689514", "Emmanuel@asd.com", 5056, "Medico", 1555);
//                MPaciente medico1 = new MPaciente("234", "Perez", fechaDate, "61689514", "Emmanuel@asd.com");
//                MPaciente medico2 = new MPaciente("456", "Maria", fechaDate, "61689514", "Emmanuel@asd.com");


                MCita Cita = new MCita(fechaDate, horaEspecifica, Paciente, medico);
                MExpediente Expediente = new MExpediente("5650",fechaDate,horaEspecifica,medico.getNumeroCedula(),"Informaicion Delicada");

//                System.out.println(medico.EstaCompleto());
                ControllerUsuario.Agregar(Usuario, bd);
//                Controller.Agregar(medico1, bd);

            } else if (numeroIngresado == 99) {
                System.out.println("Deteniendo...");

            } else if (numeroIngresado == 3) {
                System.out.print("numero");
                String x1 = scanner.next();
                MUsuario temp = ControllerUsuario.Leer(x1, bd);
                ControllerUsuario.Eliminar(temp, bd);
            } else if (numeroIngresado == 2) {
<<<<<<< HEAD
                System.out.print("Cedula");
                String id = scanner.next();
                System.out.print("Usuario");
                String x1 = scanner.next();
                System.out.print("Contrasena");
                String x2 = scanner.next();
//                System.out.print("fecha");
//                String x3 = scanner.next();
//                System.out.print("tele");
//                String x4 = scanner.next();
=======
                System.out.print("ID: ");
                String id = scanner.next();
                System.out.print("Fecha: ");
                String x1 = scanner.next();
                System.out.print("Hora: ");
                String x2 = scanner.next();
                System.out.print("Medico");
                String x3 = scanner.next();
                System.out.print("Descripcion: ");
                String x4 = scanner.next();
>>>>>>> SegundaRamaS
//                System.out.print("correo");
//                String x5 = scanner.next();
//                System.out.print("codigo");

<<<<<<< HEAD
                MUsuario temp = ControllerUsuario.Leer(id, bd);
=======
                MExpediente temp = ControllerExpediente.Leer(id, bd);
>>>>>>> SegundaRamaS
//                Controller.Eliminar(temp, bd);

                if (x1.isEmpty()) {
                    x1 = String.valueOf(temp.getUsuario());
                }
                if (x2.isEmpty()) {
                    x2 = String.valueOf(temp.getContrasena());
                }
//                if (x3.isEmpty()) {
//                    x3 = temp.getMedico();
//                }
//                if (x4.isEmpty()) {
//                    x4 = temp.getDescripcion();
//                }
//                if (x5.isEmpty()) {
//                    x5 = temp.getCorreo();
//                }
//                if (x6.equals(null)) {
//                    x6 = temp.getCodigo();
//                }
//                if (!x7.isEmpty()) {
//                x7 = temp.getEspecialidad();
<<<<<<< HEAD

//                Date fechaDate = java.sql.Date.valueOf(x1);
//                LocalTime hora = LocalTime.parse(x2);
=======
                Date fechaDate = java.sql.Date.valueOf(x1);
                LocalTime hora = LocalTime.parse(x2);
>>>>>>> SegundaRamaS
//                MPaciente temppa = ControllerPaciente.Leer(x3, bd);
//                MMedico tempme = ControllerMedico.Leer(x3, bd);
                System.out.println("-------------");
                System.out.println(id);
                System.out.println(x1);
                System.out.println(x2);
//                System.out.println(temppa.getNumeroCedula());
//                System.out.println(tempme.getNumeroCedula());                
                System.out.println("-------------");
                MUsuario tempobjecto = new MUsuario(id,x1,Integer.valueOf(x2));

                ControllerUsuario.Actualizar(tempobjecto, bd);

                System.out.println("Deteniendo...");

            } else {
                System.out.println("Número no reconocido. Inténtalo de nuevo.");
            }

            ArrayList<DTOUsuario> mMedico = ControllerUsuario.LeerTodoS(bd);
            for (int i = 0; i < mMedico.size(); i++) {  // Corrected the loop condition
                System.out.print("Cedula: " + mMedico.get(i).getNumeroCedula()+ " / ");  // Use get(i) to access elements in ArrayList
                System.out.print("Usuario: " + mMedico.get(i).getUsuario()+ " / ");
                System.out.print("Contrasena: " + mMedico.get(i).getContrasena()+ " / ");
                System.out.println("");
                System.out.println("-----------------------");
            }
//            for (DTOCita mMedico : x) {
//                System.out.print("ID: " + mMedico.getId() + " / ");
//                System.out.print("Fecha: " + mMedico.getFecha() + " / ");
//                System.out.print("Hora: " + mMedico.getHora() + " / ");
//                System.out.print("Paciente: " + mMedico.getPaciente() + " / ");
//                System.out.print("Medico: " + mMedico.getMedico() + " / ");
//                System.out.println("");
//                System.out.println("-----------------------");
//            }

        } while (numeroIngresado != 99);

//
//        System.out.println(Controller.Leer("234",bd).getNombre());;
//        Controller.Leer("404370845",bd);
//        Controller.Leer("404370845",bd);
    }

}
