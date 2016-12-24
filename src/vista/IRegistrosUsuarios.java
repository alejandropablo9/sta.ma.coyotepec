package vista;

import controlador.AdminIFrame;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import modelo.Cuenta;
import modelo.CuentaDAO;
import modelo.Zona;
import modelo.ZonaDAO;
import modelo.ModelViewCuenta;
/**
 *
 * @author Alejandro
 */
public class IRegistrosUsuarios extends javax.swing.JInternalFrame {

    /**
     * Creates new form IRegistroClientes
     */
    public static IRegistrarUsuario vtnRUsuario = null;
    public static IEditarUsuario vtnEUsuario = null;
    private JDesktopPane dp;
    public static ModelViewCuenta mdlCuentas;
    
    public IRegistrosUsuarios(JDesktopPane mainApp) {
        initComponents();
        mdlCuentas = new ModelViewCuenta();
        dp = mainApp;        
        this.jTablaCuentas.setModel(mdlCuentas);
    }  
    
    public static final void actualizaTabla(){
        jTablaCuentas.setModel(new ModelViewCuenta());
    }
    
    public static final void actualizaTabla(ModelViewCuenta mvc){
        jTablaCuentas.setModel(mvc);
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
        jLabel1 = new javax.swing.JLabel();
        jcbZonas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jtfApellidos = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaCuentas = new javax.swing.JTable();
        bNuevoUsuario = new javax.swing.JButton();
        nEditarUsuario = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();

        setClosable(true);
        setForeground(java.awt.Color.darkGray);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lista de Usuarios");

        jPanel1.setBackground(new java.awt.Color(213, 228, 244));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("LISTA DE USUARIOS");

        Zona t = new Zona(0, "TODAS");
        this.jcbZonas.addItem(t);
        ArrayList<Zona> alZonas= ZonaDAO.todasLasZonas();
        for(Zona z : alZonas)
        this.jcbZonas.addItem(z);

        jLabel2.setText("ZONA");

        jtNombre.setText("NOMBRE(S)");
        jtNombre.setToolTipText("NOMBRE(S)");
        jtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtNombreFocusLost(evt);
            }
        });

        jtfApellidos.setText("APELLIDOS");
        jtfApellidos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfApellidosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfApellidosFocusLost(evt);
            }
        });

        jbBuscar.setText("BUSCAR");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jTablaCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTablaCuentas);

        bNuevoUsuario.setBackground(new java.awt.Color(213, 228, 244));
        bNuevoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/agregarCliente.png"))); // NOI18N
        bNuevoUsuario.setToolTipText("Nuevo Usuario");
        bNuevoUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bNuevoUsuario.setBorderPainted(false);
        bNuevoUsuario.setContentAreaFilled(false);
        bNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNuevoUsuarioActionPerformed(evt);
            }
        });

        nEditarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/editarCliente48.png"))); // NOI18N
        nEditarUsuario.setToolTipText("Editar Usuario");
        nEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nEditarUsuarioActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jcbZonas, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jtfApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbBuscar))
                                    .addComponent(jLabel2))
                                .addGap(0, 326, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bNuevoUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nEditarUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbSalir)
                        .addGap(25, 25, 25))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bNuevoUsuario)
                            .addComponent(nEditarUsuario)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jbSalir))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jbActualizar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbZonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void bNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuevoUsuarioActionPerformed
        if(this.vtnRUsuario== null){
           this.vtnRUsuario = new IRegistrarUsuario(); 
        }
        AdminIFrame.mostrarVentanaFactura(dp, this.vtnRUsuario); 
    }//GEN-LAST:event_bNuevoUsuarioActionPerformed

    private void jtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtNombreFocusGained
        if(jtNombre.getText().equals("NOMBRE(S)")){
            jtNombre.setText("");
        }
    }//GEN-LAST:event_jtNombreFocusGained

    private void jtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtNombreFocusLost
        if(jtNombre.getText().trim().isEmpty()){
            jtNombre.setText("NOMBRE(S)");
        }else{
            this.jtNombre.setText(jtNombre.getText().toUpperCase());
        }
    }//GEN-LAST:event_jtNombreFocusLost

    private void jtfApellidosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfApellidosFocusGained
        if(jtfApellidos.getText().equals("APELLIDOS")){
            jtfApellidos.setText("");
        }
    }//GEN-LAST:event_jtfApellidosFocusGained

    private void jtfApellidosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfApellidosFocusLost
        if(jtfApellidos.getText().trim().isEmpty()){
            jtfApellidos.setText("APELLIDOS");
        }else{
            this.jtfApellidos.setText(jtfApellidos.getText().toUpperCase());
        }
    }//GEN-LAST:event_jtfApellidosFocusLost

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        Zona z = (Zona) this.jcbZonas.getSelectedItem();
        Cuenta c = new Cuenta();
        c.setNombreUsuario(jtNombre.getText());
        c.setApellidosUsuario(jtfApellidos.getText());
        c.setNombreZona(z.getNombre());
        
        if(c.getNombreUsuario().equals("NOMBRE(S)")){
            c.setNombreUsuario("");
        }
        if(c.getApellidosUsuario().equals("APELLIDOS")){
            c.setApellidosUsuario("");
        }
        if(z.getCodigo() == 0){
            c.setNombreZona("");
        }
        jTablaCuentas.setModel(new ModelViewCuenta(CuentaDAO.cuentasComo(c)));
        //Logica.validarBusquedaCuentas(c);
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void nEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nEditarUsuarioActionPerformed
        int index = jTablaCuentas.getSelectedRow();        
        ModelViewCuenta mvcuentas = (ModelViewCuenta) jTablaCuentas.getModel();
        if(index != -1){
            Cuenta c = mvcuentas.getCuenta(index);
            //System.out.println(index+", "+c.getNombreUsuario());
            if(vtnEUsuario == null){
                vtnEUsuario = new IEditarUsuario(c); 
            }
            AdminIFrame.mostrarVentanaFactura(dp, vtnEUsuario);             
        }        
    }//GEN-LAST:event_nEditarUsuarioActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
       jTablaCuentas.setModel(new ModelViewCuenta(CuentaDAO.todasLasCuentas()));
    }//GEN-LAST:event_jbActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bNuevoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTablaCuentas;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Zona> jcbZonas;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtfApellidos;
    private javax.swing.JButton nEditarUsuario;
    // End of variables declaration//GEN-END:variables
}