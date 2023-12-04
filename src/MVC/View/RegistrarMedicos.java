/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package MVC.View;

/**
 *
 * @author josep
 */
public class RegistrarMedicos extends javax.swing.JInternalFrame {

    /**
     * Creates new form RegistrarClientes
     */
    public RegistrarMedicos() {
        initComponents();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblCedulaM = new javax.swing.JLabel();
        txtCedulaM = new javax.swing.JTextField();
        lblNombreM = new javax.swing.JLabel();
        txtNombreM = new javax.swing.JTextField();
        lblFechaM = new javax.swing.JLabel();
        txtFechaM = new javax.swing.JTextField();
        lblTelefonoM = new javax.swing.JLabel();
        txtTelefonoM = new javax.swing.JTextField();
        lblCodigoColegioM = new javax.swing.JLabel();
        txtCodigoColegioM = new javax.swing.JTextField();
        lblCorreoM = new javax.swing.JLabel();
        txtCorreoM = new javax.swing.JTextField();
        lblEspecialidadM = new javax.swing.JLabel();
        txtEspecialidadM = new javax.swing.JTextField();
        lblSalarioM = new javax.swing.JLabel();
        txtSalarioM = new javax.swing.JTextField();
        lblLogoM = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 204, 204));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestionar médicos");

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        lblCedulaM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCedulaM.setForeground(new java.awt.Color(255, 255, 255));
        lblCedulaM.setText("Cédula");

        lblNombreM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombreM.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreM.setText("Nombre completo");

        lblFechaM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFechaM.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaM.setText("Fecha de Nacimiento");

        lblTelefonoM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTelefonoM.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefonoM.setText("Teléfono");

        lblCodigoColegioM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCodigoColegioM.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigoColegioM.setText("Código de colegio");

        lblCorreoM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCorreoM.setForeground(new java.awt.Color(255, 255, 255));
        lblCorreoM.setText("Correo electrónico");

        lblEspecialidadM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEspecialidadM.setForeground(new java.awt.Color(255, 255, 255));
        lblEspecialidadM.setText("Especialidad");

        lblSalarioM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSalarioM.setForeground(new java.awt.Color(255, 255, 255));
        lblSalarioM.setText("Salario");

        lblLogoM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rsc/logo.jpg"))); // NOI18N

        btnCrear.setText("Crear");

        btnEditar.setText("Editar");

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 0, 0));
        btnEliminar.setText("Eliminar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCedulaM, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblCorreoM)
                        .addComponent(lblTelefonoM)
                        .addComponent(lblFechaM)
                        .addComponent(lblNombreM)
                        .addComponent(txtNombreM)
                        .addComponent(txtFechaM)
                        .addComponent(txtTelefonoM)
                        .addComponent(txtCorreoM, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                        .addComponent(lblCodigoColegioM)
                        .addComponent(txtCodigoColegioM)
                        .addComponent(txtCedulaM)))
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblEspecialidadM)
                            .addComponent(lblSalarioM)
                            .addComponent(txtSalarioM)
                            .addComponent(lblLogoM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEspecialidadM))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedulaM)
                    .addComponent(lblEspecialidadM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCedulaM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEspecialidadM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreM)
                    .addComponent(lblSalarioM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSalarioM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblFechaM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTelefonoM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefonoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblCorreoM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCorreoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblCodigoColegioM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoColegioM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblLogoM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCrear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditar)
                            .addComponent(btnEliminar))))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCedulaM;
    private javax.swing.JLabel lblCodigoColegioM;
    private javax.swing.JLabel lblCorreoM;
    private javax.swing.JLabel lblEspecialidadM;
    private javax.swing.JLabel lblFechaM;
    private javax.swing.JLabel lblLogoM;
    private javax.swing.JLabel lblNombreM;
    private javax.swing.JLabel lblSalarioM;
    private javax.swing.JLabel lblTelefonoM;
    private javax.swing.JTextField txtCedulaM;
    private javax.swing.JTextField txtCodigoColegioM;
    private javax.swing.JTextField txtCorreoM;
    private javax.swing.JTextField txtEspecialidadM;
    private javax.swing.JTextField txtFechaM;
    private javax.swing.JTextField txtNombreM;
    private javax.swing.JTextField txtSalarioM;
    private javax.swing.JTextField txtTelefonoM;
    // End of variables declaration//GEN-END:variables
}
