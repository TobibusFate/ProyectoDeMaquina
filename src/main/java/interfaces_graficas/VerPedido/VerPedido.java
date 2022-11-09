/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces_graficas.VerPedido;

import interfaces_graficas.buscar_pedido.BuscarPedido;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.managers.ManagerRenglonPedido;
import objects.Pedido;
import objects.RenglonPedido;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Cell9870
 */
public class VerPedido extends javax.swing.JFrame {

    private static final Logger ERRLOGGER = LogManager.getLogger("error-log");
    private String username;
    private Pedido pedido;
    private List<RenglonPedido> renglones = new ArrayList<>();
    
    public VerPedido(Pedido pedido, String username) {
        initComponents();
        this.username = username;
        this.pedido = pedido;
        renglones = ManagerRenglonPedido.getRenglonesPorPedidoVisibles(pedido);
        updateText();
        updateTable();
    }
    
    private void updateText() {
        LblPedidoCodigo.setText("Preview Pedido #"+pedido.getCodigo());
        LblNameProv.setText(pedido.getProv().getNombre());
        LblCUITProv.setText("CUIT: "+pedido.getProv().getCuit());
        LblEmailProv.setText("Email: "+pedido.getProv().getEmail());
        LblDirProv.setText("Domicilio: "+pedido.getProv().getDireccion());
        LblNombreAdmin.setText(pedido.getAdmin().getApellido()+" "+pedido.getAdmin().getNombre());
        LblDNIAdmin.setText("DNI: "+pedido.getAdmin().getDni());
        LblTelAdmin.setText("Telefono: "+pedido.getAdmin().getTelefono());
    }
    
    private void updateTable() {
        DefaultTableModel model = (DefaultTableModel) TblRenglones.getModel();
        while(model.getRowCount() > 0) {
            model.removeRow(0);
        }
        float value = 0;
        
        if (!renglones.isEmpty()) {
            for (RenglonPedido rp: renglones) {
                model.addRow(new Object[]{rp.getProducto().getCodigoP(),rp.getProducto().getNombreP(), rp.getCantidad(), rp.getTipoCantidad(), rp.getProducto().getPrecioP(), rp.getDescuento(), rp.getMontoTotal()});
            }
            for (RenglonPedido rp: renglones) {
                value += rp.getMontoTotal();
            }
        }
        else {
            JOptionPane.showMessageDialog(content, "Los productos de este pedido, han sido dados de baja.\nEs recomendable que lo elimine, o que habilite sus productos.", "Pedido sin renglones", JOptionPane.INFORMATION_MESSAGE);
        }
        FldMontoFinal.setText(Float.toString(value));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        content = new javax.swing.JPanel();
        LblPedidoCodigo = new javax.swing.JLabel();
        LblNombreAdmin = new javax.swing.JLabel();
        LblNameProv = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        LblDNIAdmin = new javax.swing.JLabel();
        LblTelAdmin = new javax.swing.JLabel();
        LblCUITProv = new javax.swing.JLabel();
        LblEmailProv = new javax.swing.JLabel();
        LblDirProv = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblRenglones = new javax.swing.JTable();
        BtnVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        FldMontoFinal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(860, 510));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        content.setBackground(new java.awt.Color(255, 255, 255));

        LblPedidoCodigo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LblPedidoCodigo.setText("Preview Pedido #xxxx");

        LblNombreAdmin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LblNombreAdmin.setText("<nameAdmin>");

        LblNameProv.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LblNameProv.setText("<nameProveedor>");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setToolTipText("");

        LblDNIAdmin.setText("DNI");

        LblTelAdmin.setText("Teléfono");

        LblCUITProv.setText("CUIT");

        LblEmailProv.setText("Email");

        LblDirProv.setText("Direccion");

        TblRenglones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Producto", "Cantidad", "U. Medida", "Precio Unitario", "% Bonif", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblRenglones.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TblRenglones);

        BtnVolver.setText("Volver Atrás");
        BtnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVolverActionPerformed(evt);
            }
        });

        jLabel1.setText("Monto Final:");

        FldMontoFinal.setEditable(false);

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LblNombreAdmin)
                                    .addComponent(LblDNIAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LblTelAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(133, 133, 133)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(contentLayout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(LblNameProv))
                                    .addComponent(LblCUITProv, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LblEmailProv, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LblDirProv, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(contentLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(contentLayout.createSequentialGroup()
                                .addGap(283, 283, 283)
                                .addComponent(LblPedidoCodigo)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(contentLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentLayout.createSequentialGroup()
                                .addComponent(BtnVolver)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(FldMontoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(194, 194, 194)))))
                .addContainerGap())
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(LblPedidoCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addComponent(LblNombreAdmin)
                        .addGap(6, 6, 6)
                        .addComponent(LblDNIAdmin)
                        .addGap(6, 6, 6)
                        .addComponent(LblTelAdmin))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addComponent(LblNameProv)
                        .addGap(6, 6, 6)
                        .addComponent(LblCUITProv)
                        .addGap(6, 6, 6)
                        .addComponent(LblEmailProv)
                        .addGap(6, 6, 6)
                        .addComponent(LblDirProv)))
                .addGap(6, 6, 6)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnVolver)
                    .addComponent(jLabel1)
                    .addComponent(FldMontoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVolverActionPerformed
        BuscarPedido bp = new BuscarPedido(username);
        this.setVisible(false);
        bp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(VerPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerPedido(null,"").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnVolver;
    private javax.swing.JTextField FldMontoFinal;
    private javax.swing.JLabel LblCUITProv;
    private javax.swing.JLabel LblDNIAdmin;
    private javax.swing.JLabel LblDirProv;
    private javax.swing.JLabel LblEmailProv;
    private javax.swing.JLabel LblNameProv;
    private javax.swing.JLabel LblNombreAdmin;
    private javax.swing.JLabel LblPedidoCodigo;
    private javax.swing.JLabel LblTelAdmin;
    private javax.swing.JTable TblRenglones;
    private javax.swing.JPanel content;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
