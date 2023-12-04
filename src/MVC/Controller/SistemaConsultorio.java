/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/MDIApplication.java to edit this template
 */
package MVC.Controller;

import BD.PlatillaBD;
import Dao.MCietaDAO;
import Dao.MExpedienteDAO;
import Dao.MMedicoDAO;
import Dao.MPacienteDAO;
import Dao.MUsuarioDAO;
import MVC.View.*;
import java.awt.Dimension;
import java.awt.Point;

/**
 *
 * @author josep
 */
public class SistemaConsultorio extends javax.swing.JFrame {

    private ConsultarMedicos consultarMedicos;
    private RegistrarMedicos registrarMedicos;
    private RegistrarPacientes registrarPacientes;
    private RegistrarCitas registrarCitas;

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

    /**
     * Creates new form SistemaConsultorio
     */
    public SistemaConsultorio() {

        initComponents();
        PlatillaBD bd = new PlatillaBD("127.0.0.1", "consultorio", "root", "emanuel12");

        setTitle("Sistema Consultorio");
        this.setLocationRelativeTo(null);
        consultarMedicos = new ConsultarMedicos(DaoMedico, ControllerMedico, bd);
        registrarMedicos = new RegistrarMedicos(DaoMedico, ControllerMedico, bd,consultarMedicos);
        registrarPacientes = new RegistrarPacientes();
        registrarCitas = new RegistrarCitas();

        desktopPane.add(this.consultarMedicos);
        desktopPane.add(this.registrarMedicos);
        desktopPane.add(this.registrarPacientes);
        desktopPane.add(this.registrarCitas);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        miRegistrarM = new javax.swing.JMenuItem();
        miConsultarM = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        miRegistrarP = new javax.swing.JMenuItem();
        miConsultarP = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        miRegistrarC = new javax.swing.JMenuItem();
        miConsultarC = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Contents");
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        jMenu1.setText("Médicos");

        miRegistrarM.setText("Gestionar médicos");
        miRegistrarM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRegistrarMActionPerformed(evt);
            }
        });
        jMenu1.add(miRegistrarM);

        miConsultarM.setText("Consultar médicos");
        miConsultarM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultarMActionPerformed(evt);
            }
        });
        jMenu1.add(miConsultarM);

        menuBar.add(jMenu1);

        jMenu2.setText("Pacientes");

        miRegistrarP.setText("Gestionar Pacientes");
        miRegistrarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRegistrarPActionPerformed(evt);
            }
        });
        jMenu2.add(miRegistrarP);

        miConsultarP.setText("Consultar Pacientes");
        jMenu2.add(miConsultarP);

        menuBar.add(jMenu2);

        jMenu3.setText("Citas");

        miRegistrarC.setText("Gestionar Citas");
        miRegistrarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRegistrarCActionPerformed(evt);
            }
        });
        jMenu3.add(miRegistrarC);

        miConsultarC.setText("Consultar Citas");
        jMenu3.add(miConsultarC);

        menuBar.add(jMenu3);

        jMenu4.setText("Expedientes");
        menuBar.add(jMenu4);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void miRegistrarMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegistrarMActionPerformed
        registrarMedicos.setVisible(true);
    }//GEN-LAST:event_miRegistrarMActionPerformed

    private void miConsultarMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultarMActionPerformed
        consultarMedicos.setVisible(true);
    }//GEN-LAST:event_miConsultarMActionPerformed

    private void miRegistrarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegistrarPActionPerformed
        registrarPacientes.setVisible(true);
    }//GEN-LAST:event_miRegistrarPActionPerformed

    private void miRegistrarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegistrarCActionPerformed
        registrarCitas.setVisible(true);
    }//GEN-LAST:event_miRegistrarCActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SistemaConsultorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SistemaConsultorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SistemaConsultorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SistemaConsultorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SistemaConsultorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem miConsultarC;
    private javax.swing.JMenuItem miConsultarM;
    private javax.swing.JMenuItem miConsultarP;
    private javax.swing.JMenuItem miRegistrarC;
    private javax.swing.JMenuItem miRegistrarM;
    private javax.swing.JMenuItem miRegistrarP;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

}
