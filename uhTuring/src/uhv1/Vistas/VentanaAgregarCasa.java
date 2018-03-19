package uhv1.Vistas;


import static java.awt.SystemColor.control;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import uhv1.Negocio.ControlAgregarCasa;

/**
 *
 * @author Vianey
 */
public class VentanaAgregarCasa extends javax.swing.JFrame {

    
    private ControlAgregarCasa controlcasa;
    
    public VentanaAgregarCasa(ControlAgregarCasa controlc) {
        this.controlcasa=controlc;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTnumero = new javax.swing.JTextField();
        jTseccion = new javax.swing.JTextField();
        botonguardar = new javax.swing.JButton();
        botoncancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        jLabel1.setText("Agregar una Casa");

        jLabel2.setText("Seccion:");

        jLabel3.setText("Número:");

        botonguardar.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        botonguardar.setText("Guardar");
        botonguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonguardarActionPerformed(evt);
            }
        });

        botoncancelar.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        botoncancelar.setText("Cancelar");
        botoncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoncancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTseccion, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTnumero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(77, 77, 77))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(botonguardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(botoncancelar)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTseccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonguardar)
                    .addComponent(botoncancelar))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonguardarActionPerformed
         if (jTseccion.getText().isEmpty() || jTnumero.getText().isEmpty()) {
              JOptionPane.showMessageDialog(null, "Es necesario llenar los campos");
         }
         else {
              
              String seccion = jTseccion.getText();
              int numero = Integer.parseInt(jTnumero.getText());

              try {
                  controlcasa.agregarCasa(seccion, numero);
              } catch (SQLException ex) {
                  Logger.getLogger(VentanaAltaHabitante.class.getName()).log(Level.SEVERE, null, ex);
              }
              JOptionPane.showMessageDialog(null, "Se ha agregado la casa");
              dispose();
            controlcasa.regresaVentanaHabitante();// cierra la ventana

          }

    }//GEN-LAST:event_botonguardarActionPerformed

    private void botoncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoncancelarActionPerformed
        dispose();
       controlcasa.botonCancelar();
    }//GEN-LAST:event_botoncancelarActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botoncancelar;
    private javax.swing.JButton botonguardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTnumero;
    private javax.swing.JTextField jTseccion;
    // End of variables declaration//GEN-END:variables
}
