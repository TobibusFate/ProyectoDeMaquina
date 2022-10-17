/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces_graficas.buscar_pedido;
import interfaces_graficas.AltaPedido.MenuAdministrador;
import interfaces_graficas.BajaPedido.BajaPedido_Preview;
import interfaces_graficas.ModificarPedido.ModificarPedido;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import interfaces_graficas.menus.MenuAdministrador;
import interfaces_graficas.baja_pedido.BajaPedido_Preview;
import logica.managers.ManagerPedido;
import objects.Pedido;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Cell9870
 */
public class BuscarPedido extends javax.swing.JFrame {

    private Map<Integer,Pedido> mapPedidos = new HashMap<>();
    private DefaultTableModel model;
    private String username;
    
    public BuscarPedido(String username) {
        initComponents();
        DateDesde.setDateFormatString("yyyy-MM-dd");
        DateHasta.setDateFormatString("yyyy-MM-dd");
        this.username = username;
        mapPedidos = ManagerPedido.getMapPedidos();
        updateTable();
    }

    
    private void updateTable() {
        model = (DefaultTableModel) TblPedidos.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        for (Pedido p: mapPedidos.values()) {
            if (p.getFechaEntrega() == null) {
                model.addRow(new Object[] {
                    p.getCodigo(),
                    p.getAdmin().getApellido()+" "+p.getAdmin().getNombre(),
                    p.getProv().getNombre(),
                    p.getFechaPedido().toString(),
                    "No recibido"
                });
            }
        else {
                model.addRow(new Object[] {
                    p.getCodigo(),
                    p.getAdmin().getApellido()+" "+p.getAdmin().getNombre(),
                    p.getProv().getNombre(),
                    p.getFechaPedido().toString(),
                    p.getFechaEntrega().toString()
                });
            }
        }
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        content = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        FldCUIT = new javax.swing.JTextField();
        Cbx_ListaProveedores = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        FldCodigoPedido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        DateDesde = new com.toedter.calendar.JDateChooser();
        DateHasta = new com.toedter.calendar.JDateChooser();
        BtnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblPedidos = new javax.swing.JTable();
        BtnEliminarPedido = new javax.swing.JButton();
        BtnModificarPedido = new javax.swing.JButton();
        BtnGoBack = new javax.swing.JButton();
        BtnVerPedido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        content.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Buscar por Proveedor: ");

        FldCUIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FldCUITActionPerformed(evt);
            }
        });

        Cbx_ListaProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cbx_ListaProveedoresActionPerformed(evt);
            }
        });

        jLabel2.setText("Buscar por Codigo: ");

        FldCodigoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FldCodigoPedidoActionPerformed(evt);
            }
        });

        jLabel3.setText("Buscar por Fechas: ");

        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        TblPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Creado por", "Proveedor", "Creado en", "Entregado en"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblPedidos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TblPedidos);

        BtnEliminarPedido.setText("Eliminar Pedido");
        BtnEliminarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarPedidoActionPerformed(evt);
            }
        });

        BtnModificarPedido.setText("Modificar Pedido");
        BtnModificarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarPedidoActionPerformed(evt);
            }
        });

        BtnGoBack.setText("Volver Atrás");
        BtnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGoBackActionPerformed(evt);
            }
        });

        BtnVerPedido.setText("Ver Pedido");
        BtnVerPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVerPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(contentLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(35, 35, 35)
                                .addComponent(FldCodigoPedido))
                            .addGroup(contentLayout.createSequentialGroup()
                                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(DateDesde, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(FldCUIT))))
                        .addGap(18, 18, 18)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DateHasta, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(Cbx_ListaProveedores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(303, Short.MAX_VALUE))
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(BtnBuscar)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(contentLayout.createSequentialGroup()
                                .addComponent(BtnGoBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnEliminarPedido)
                                .addGap(18, 18, 18)
                                .addComponent(BtnModificarPedido)
                                .addGap(18, 18, 18)
                                .addComponent(BtnVerPedido)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(FldCodigoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Cbx_ListaProveedores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FldCUIT, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(DateDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DateHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BtnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnEliminarPedido)
                    .addComponent(BtnModificarPedido)
                    .addComponent(BtnGoBack)
                    .addComponent(BtnVerPedido))
                .addContainerGap())
        );

        getContentPane().add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FldCodigoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FldCodigoPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FldCodigoPedidoActionPerformed

    private void Cbx_ListaProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cbx_ListaProveedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cbx_ListaProveedoresActionPerformed

    private void FldCUITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FldCUITActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FldCUITActionPerformed

    private void BtnVerPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVerPedidoActionPerformed
        JOptionPane.showMessageDialog(content, "Funcionalidad no implementada","Not implemented error",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_BtnVerPedidoActionPerformed

    private void BtnModificarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarPedidoActionPerformed
        int row = TblPedidos.getSelectedRow();
        if (row != -1) {
            Pedido p = mapPedidos.get((Integer) TblPedidos.getValueAt(row, 0));
            this.setVisible(false);
            ModificarPedido mp = new ModificarPedido(username, p);
            mp.setVisible(true);
        }
        else JOptionPane.showMessageDialog(content, "Seleccione un pedido","Pedido no seleccionado",JOptionPane.ERROR_MESSAGE);
        
    }//GEN-LAST:event_BtnModificarPedidoActionPerformed

    private void BtnEliminarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarPedidoActionPerformed
        int row = TblPedidos.getSelectedRow();
        if (row != -1) {
            Pedido p = mapPedidos.get((Integer) TblPedidos.getValueAt(row, 0));
            this.setVisible(false);
            BajaPedido_Preview bp = new BajaPedido_Preview(p, username);
            bp.setVisible(true);
        }
        else JOptionPane.showMessageDialog(content, "Seleccione un pedido","Pedido no seleccionado",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_BtnEliminarPedidoActionPerformed

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        JOptionPane.showMessageDialog(content, "Funcionalidad no implementada","Not implemented error",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void BtnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGoBackActionPerformed
        MenuAdministrador mv = new MenuAdministrador(username);
        mv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnGoBackActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarPedido("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnEliminarPedido;
    private javax.swing.JButton BtnGoBack;
    private javax.swing.JButton BtnModificarPedido;
    private javax.swing.JButton BtnVerPedido;
    private javax.swing.JComboBox<String> Cbx_ListaProveedores;
    private com.toedter.calendar.JDateChooser DateDesde;
    private com.toedter.calendar.JDateChooser DateHasta;
    private javax.swing.JTextField FldCUIT;
    private javax.swing.JTextField FldCodigoPedido;
    private javax.swing.JTable TblPedidos;
    private javax.swing.JPanel content;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
