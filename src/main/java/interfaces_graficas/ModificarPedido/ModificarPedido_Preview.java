/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces_graficas.ModificarPedido;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.managers.ManagerPedido;
import objects.Administrador;
import objects.Pedido;
import objects.RenglonPedido;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Cell9870
 */
public class ModificarPedido_Preview extends javax.swing.JFrame {

    private static final Logger INFOLOGGER = LogManager.getLogger("info-log");
    
    private Map<String, RenglonPedido> mapRenglones = new HashMap<>();
    private Administrador admin;
    private DefaultTableModel model;
    private ModificarPedido modificarPedido;
    private Pedido pedido;
    
    public ModificarPedido_Preview(ModificarPedido modificarPedido) {
        initComponents();
        this.modificarPedido = modificarPedido;
        this.mapRenglones = modificarPedido.getRenglones();
        this.admin = modificarPedido.getAdministrador();
        this.pedido = modificarPedido.getPedido();
        updateText();
        updateTable();
    }

    
    private void updateText() {
        LblPedidoCodigo.setText("Preview Pedido #" + pedido.getCodigo());
        LblNombreAdmin.setText(admin.getApellido()+" "+admin.getNombre());
        LblDNIAdmin.setText("DNI: "+admin.getDni());
        LblTelAdmin.setText("Telefono: "+admin.getTelefono());
        if(pedido.getFechaEntrega() != null)
            labelFechaEntrega.setText(pedido.getFechaEntrega().toString());
        else
            labelFechaEntrega.setText("Sin fecha establecida");
    }
    
    private void updateTable() {
        model = (DefaultTableModel) TblRenglones.getModel();
        while(model.getRowCount() > 0) {
            model.removeRow(0);
        }
        float value = 0;
        
        if (!mapRenglones.isEmpty()) {
            for (RenglonPedido rp: mapRenglones.values()) {
                model.addRow(new Object[]{rp.getProducto().getCodigoP(),rp.getProducto().getNombreP(), rp.getCantidad(), rp.getTipoCantidad(), rp.getProducto().getPrecioP(), rp.getDescuento(), rp.getMontoTotal()});
            }

            for (RenglonPedido rp: mapRenglones.values()) {
                value += rp.getMontoTotal();
            }
        }
        else JOptionPane.showMessageDialog(content, "Los productos de este pedido, han sido dados de baja.\nEs recomendable que los modifique, o que habilite sus productos.", "Pedido sin renglones", JOptionPane.INFORMATION_MESSAGE);
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
        jSeparator1 = new javax.swing.JSeparator();
        LblDNIAdmin = new javax.swing.JLabel();
        LblTelAdmin = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblRenglones = new javax.swing.JTable();
        Modificar = new javax.swing.JButton();
        BtnVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        FldMontoFinal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        labelFechaEntrega = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        content.setBackground(new java.awt.Color(255, 255, 255));

        LblPedidoCodigo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LblPedidoCodigo.setText("Preview Pedido #xxxx");

        LblNombreAdmin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LblNombreAdmin.setText("<nameAdmin>");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setToolTipText("");

        LblDNIAdmin.setText("DNI");

        LblTelAdmin.setText("Tel??fono");

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

        Modificar.setText("Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });

        BtnVolver.setText("Volver Atr??s");
        BtnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVolverActionPerformed(evt);
            }
        });

        jLabel1.setText("Monto Final:");

        FldMontoFinal.setEditable(false);

        jLabel2.setText("Fecha de entrega: ");

        labelFechaEntrega.setText("dd-MM-yyyy");

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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelFechaEntrega))
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
                                .addComponent(BtnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(FldMontoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentLayout.createSequentialGroup()
                                .addComponent(LblNombreAdmin)
                                .addGap(6, 6, 6)
                                .addComponent(LblDNIAdmin)
                                .addGap(6, 6, 6)
                                .addComponent(LblTelAdmin))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentLayout.createSequentialGroup()
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(labelFechaEntrega))
                        .addGap(47, 47, 47)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Modificar)
                    .addComponent(BtnVolver)
                    .addComponent(jLabel1)
                    .addComponent(FldMontoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        if (JOptionPane.showOptionDialog(content, "??Est?? seguro que desea modificar este pedido?",
                    "Confirmaci??n de Modificaci??n de Pedido", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, 
                    null, null, null) == 0) {

            ManagerPedido.modificarPedido(pedido, new ArrayList(mapRenglones.values()));
            JOptionPane.showMessageDialog(content, "El pedido fue modificado en el sistema","Modificaci??n de Pedido exitosa",JOptionPane.INFORMATION_MESSAGE);
            INFOLOGGER.info("El pedido #"+pedido.getCodigo()+" fue modificado por el usuario \'"+admin.getCuenta().getCuenta()+"\'");
            this.setVisible(false);
            modificarPedido.setVisible(true);
            this.dispose();
        }        
    }//GEN-LAST:event_ModificarActionPerformed

    private void BtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVolverActionPerformed
        this.setVisible(false);
        modificarPedido.setVisible(true);
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
            java.util.logging.Logger.getLogger(ModificarPedido_Preview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarPedido_Preview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarPedido_Preview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarPedido_Preview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarPedido_Preview(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnVolver;
    private javax.swing.JTextField FldMontoFinal;
    private javax.swing.JLabel LblDNIAdmin;
    private javax.swing.JLabel LblNombreAdmin;
    private javax.swing.JLabel LblPedidoCodigo;
    private javax.swing.JLabel LblTelAdmin;
    private javax.swing.JButton Modificar;
    private javax.swing.JTable TblRenglones;
    private javax.swing.JPanel content;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelFechaEntrega;
    // End of variables declaration//GEN-END:variables
}
