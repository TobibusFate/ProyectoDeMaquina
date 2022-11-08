/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces_graficas.alta_pedido;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import objects.Producto;
import objects.RenglonPedido;
import objects.TipoCantidad;

/**
 *
 * @author Cell9870
 */
public class AltaPedido_Sugerencias extends javax.swing.JFrame {

    private Map<String, Producto> mapProductos = new HashMap<>();
    private Map<String, RenglonPedido> mapRenglones = new HashMap<>();
    private AltaPedido_Generador apg;
     
    public AltaPedido_Sugerencias(AltaPedido_Generador apg) {
        initComponents();
        cerrar();
        this.apg = apg;
        this.mapProductos = apg.getMapProductos();
        this.mapRenglones = apg.getMapRenglones();
        updateTable();
    }

    private void cerrar () {
        try {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    destruir();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void destruir () {
        this.dispose();
    }

    private void updateTable() {
        DefaultTableModel model = (DefaultTableModel) TblProd.getModel();
        while(model.getRowCount() > 0) {
            model.removeRow(0);
        }
        for(Producto prod: mapProductos.values()) {
            if (prod.getStockMinimoP() > prod.getStockP()) 
                model.addRow(new Object[] {
                    prod.getCodigoP(),
                    prod.getNombreP(),
                    prod.getStockP(),
                    prod.getStockMinimoP()
                });
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TblProd = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        BtnAdd = new javax.swing.JButton();
        BtnSelectAll = new javax.swing.JButton();
        BtnGoBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setPreferredSize(new java.awt.Dimension(600, 500));

        TblProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Stock Actual", "Stock Minimo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblProd.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TblProd);

        jLabel1.setText("Sugerencias de productos con stock por debajo del mínimo para el pedido:");

        BtnAdd.setText("Agregar");
        BtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddActionPerformed(evt);
            }
        });

        BtnSelectAll.setText("Seleccionar Todo");
        BtnSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSelectAllActionPerformed(evt);
            }
        });

        BtnGoBack.setText("Volver Atrás");
        BtnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGoBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 226, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentLayout.createSequentialGroup()
                        .addComponent(BtnGoBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnSelectAll)
                        .addGap(18, 18, 18)
                        .addComponent(BtnAdd)))
                .addContainerGap())
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAdd)
                    .addComponent(BtnSelectAll)
                    .addComponent(BtnGoBack))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGoBackActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_BtnGoBackActionPerformed

    private void BtnSelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSelectAllActionPerformed
        TblProd.selectAll();
    }//GEN-LAST:event_BtnSelectAllActionPerformed

    private void BtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddActionPerformed
        int[] rows = TblProd.getSelectedRows();
        if (rows.length == 0) JOptionPane.showMessageDialog(this, "Seleccione al menos un producto", "No se ha seleccionado un producto", JOptionPane.ERROR_MESSAGE);
        else {
            for (int prodRow: TblProd.getSelectedRows()) {
                Producto prod = mapProductos.get((String)TblProd.getModel().getValueAt(prodRow, 1));
                int cant = prod.getStockMinimoP() - prod.getStockP();
                if (!mapRenglones.containsKey(prod.getNombreP())) {
                    mapRenglones.put(
                            prod.getNombreP(),
                            new RenglonPedido(prod,
                                    cant > 0 ? cant : 1,
                                    TipoCantidad.Bolsones,
                                    0F));
                }
                else if (mapRenglones.get(prod.getNombreP()).getCantidad() < cant) {
                    RenglonPedido rp =  mapRenglones.get(prod.getNombreP());
                    rp.setCantidad(cant);
                    mapRenglones.replace(prod.getNombreP(), rp);
                }
            }
        apg.updateTable();
        }
    }//GEN-LAST:event_BtnAddActionPerformed

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
            java.util.logging.Logger.getLogger(AltaPedido_Sugerencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaPedido_Sugerencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaPedido_Sugerencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaPedido_Sugerencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltaPedido_Sugerencias(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAdd;
    private javax.swing.JButton BtnGoBack;
    private javax.swing.JButton BtnSelectAll;
    private javax.swing.JTable TblProd;
    private javax.swing.JPanel content;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    
}
