package vista;

import controlador.ControladorRecibo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import modelo.Recibo;
import utilerias.Conversion;

/**
 *
 * @author Alejandro
 */
public class IGenerarRecibos extends javax.swing.JInternalFrame {

    /**
     * Creates new form IGenerarRecibos
     */
    private Matcher matchCuota;
    private final Pattern erCuota;
    public IGenerarRecibos() {
        initComponents();
        erCuota = Pattern.compile("\\d+.\\d{2}");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpContenedor = new javax.swing.JPanel();
        jpBar = new javax.swing.JPanel();
        jlTitulo = new javax.swing.JLabel();
        jcMes = new javax.swing.JComboBox<>();
        jcbAnio = new javax.swing.JComboBox<>();
        jlAnio = new javax.swing.JLabel();
        jlMes = new javax.swing.JLabel();
        jbGenerar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jtMonto = new componente.DTexto();
        jlMonto = new javax.swing.JLabel();
        msjError = new javax.swing.JLabel();

        jpContenedor.setBackground(new java.awt.Color(255, 255, 255));

        jpBar.setBackground(new java.awt.Color(0, 153, 255));

        jlTitulo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jlTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jlTitulo.setText("GENERAR RECIBOS SIN MEDIDOR");

        javax.swing.GroupLayout jpBarLayout = new javax.swing.GroupLayout(jpBar);
        jpBar.setLayout(jpBarLayout);
        jpBarLayout.setHorizontalGroup(
            jpBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBarLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jlTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpBarLayout.setVerticalGroup(
            jpBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBarLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jlTitulo)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jcMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));

        for(int i = 2016; i <= 2030; i++){
            jcbAnio.addItem(i);
        }

        jlAnio.setText("Año");

        jlMes.setText("Mes");

        jbGenerar.setText("Generar");
        jbGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGenerarActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jtMonto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtMonto.setText("0.00");
        jtMonto.setRango(new char[] {'0', '.'});
        jtMonto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtMontoFocusLost(evt);
            }
        });
        jtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtMontoActionPerformed(evt);
            }
        });

        jlMonto.setText("Concepto");

        msjError.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jpContenedorLayout = new javax.swing.GroupLayout(jpContenedor);
        jpContenedor.setLayout(jpContenedorLayout);
        jpContenedorLayout.setHorizontalGroup(
            jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpContenedorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbGenerar)
                .addGap(26, 26, 26))
            .addGroup(jpContenedorLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(msjError)
                    .addGroup(jpContenedorLayout.createSequentialGroup()
                        .addGroup(jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlAnio))
                        .addGap(18, 18, 18)
                        .addGroup(jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlMes))
                        .addGap(18, 18, 18)
                        .addGroup(jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlMonto)
                            .addComponent(jtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jpContenedorLayout.setVerticalGroup(
            jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContenedorLayout.createSequentialGroup()
                .addComponent(jpBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlAnio)
                    .addComponent(jlMes)
                    .addComponent(jlMonto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(msjError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGenerar)
                    .addComponent(jbSalir))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGenerarActionPerformed
        Recibo rsm = new Recibo();
        matchCuota = erCuota.matcher(jtMonto.getText());
        if(matchCuota.matches()){        
            rsm.normalizarMonto(Conversion.deStringAdouble(jtMonto.getText()));
            rsm.setMes(jcMes.getSelectedIndex() + 1);
            rsm.setLectura(0);
            rsm.setEstado("ADEUDO");
            rsm.setAnio((int) jcbAnio.getSelectedItem());        
        }else{
            msjError.setText("La cuota no es valida");
        }
        ControladorRecibo.generarServicios(rsm);
    }//GEN-LAST:event_jbGenerarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        jtMonto.setText("0.00");
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtMontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtMontoActionPerformed

    private void jtMontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtMontoFocusLost
        
    }//GEN-LAST:event_jtMontoFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbGenerar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<String> jcMes;
    private javax.swing.JComboBox<Integer> jcbAnio;
    private javax.swing.JLabel jlAnio;
    private javax.swing.JLabel jlMes;
    private javax.swing.JLabel jlMonto;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JPanel jpBar;
    private javax.swing.JPanel jpContenedor;
    private componente.DTexto jtMonto;
    private javax.swing.JLabel msjError;
    // End of variables declaration//GEN-END:variables
}
