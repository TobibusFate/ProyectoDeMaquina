/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces_graficas.menus;

import interfaces_graficas.alta_pedido.AltaPedido_Generador;
import interfaces_graficas.buscar_pedido.BuscarPedido;
import interfaces_graficas.abm_producto.ABM_Producto;
import interfaces_graficas.buscar_venta.BuscarVenta;
import interfaces_graficas.realizar_venta.RegistrarVenta;

/**
 *
 * @author tovib
 */
public class MenuAdministrador extends javax.swing.JFrame {

    private String username;
    
    public MenuAdministrador(String username) {
        initComponents();
        this.username = username;
        boton_agregar_cliente.setEnabled(false);
        boton_buscar_cliente.setEnabled(false);
        boton_buscar_producto.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boton_cerrar_sesion = new javax.swing.JButton();
        boton_alta_pedido = new javax.swing.JButton();
        boton_buscar_pedido = new javax.swing.JButton();
        boton_buscar_producto = new javax.swing.JButton();
        boton_buscar_cliente = new javax.swing.JButton();
        boton_buscar_venta = new javax.swing.JButton();
        realizar_venta = new javax.swing.JButton();
        boton_agregar_cliente = new javax.swing.JButton();
        boton_productos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        boton_cerrar_sesion.setText("Cerrar Sesion");
        boton_cerrar_sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_cerrar_sesionActionPerformed(evt);
            }
        });

        boton_alta_pedido.setText("Alta Pedido");
        boton_alta_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_alta_pedidoActionPerformed(evt);
            }
        });

        boton_buscar_pedido.setText("Buscar Pedido");
        boton_buscar_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_buscar_pedidoActionPerformed(evt);
            }
        });

        boton_buscar_producto.setText("Buscar Producto");

        boton_buscar_cliente.setText("Buscar Ciente");
        boton_buscar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_buscar_clienteActionPerformed(evt);
            }
        });

        boton_buscar_venta.setText("Buscar Venta");
        boton_buscar_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_buscar_ventaActionPerformed(evt);
            }
        });

        realizar_venta.setText("Realizar Venta");
        realizar_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realizar_ventaActionPerformed(evt);
            }
        });

        boton_agregar_cliente.setText("Agregar Cliente");

        boton_productos.setText("ABM Producto");
        boton_productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_productosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(boton_cerrar_sesion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(boton_buscar_producto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(boton_buscar_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(boton_buscar_venta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(boton_agregar_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(realizar_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(boton_buscar_pedido)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(boton_alta_pedido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(boton_productos)
                                .addGap(23, 23, 23)))))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_buscar_venta)
                    .addComponent(realizar_venta))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_agregar_cliente)
                    .addComponent(boton_buscar_cliente))
                .addGap(36, 36, 36)
                .addComponent(boton_buscar_producto)
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_alta_pedido)
                    .addComponent(boton_productos))
                .addGap(18, 18, 18)
                .addComponent(boton_buscar_pedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(boton_cerrar_sesion)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_alta_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_alta_pedidoActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        AltaPedido_Generador apg = new AltaPedido_Generador(username);
        apg.setVisible(true);
    }//GEN-LAST:event_boton_alta_pedidoActionPerformed

    private void boton_cerrar_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_cerrar_sesionActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        LogIn li = new LogIn();
        li.setVisible(true);
    }//GEN-LAST:event_boton_cerrar_sesionActionPerformed

    private void boton_buscar_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_buscar_pedidoActionPerformed
        this.setVisible(false);
        BuscarPedido bp = new BuscarPedido(username);
        bp.setVisible(true);
    }//GEN-LAST:event_boton_buscar_pedidoActionPerformed

    private void boton_buscar_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_buscar_ventaActionPerformed
        // TODO add your handling code here:
        BuscarVenta bv = new BuscarVenta(this.username,1);
        bv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_boton_buscar_ventaActionPerformed

    private void realizar_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realizar_ventaActionPerformed
        // TODO add your handling code here:
        RegistrarVenta cv = new RegistrarVenta(this.username,1);
        cv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_realizar_ventaActionPerformed

    private void boton_buscar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_buscar_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_buscar_clienteActionPerformed

    private void boton_productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_productosActionPerformed
        // TODO add your handling code here:
        ABM_Producto abmp = new ABM_Producto(this.username);
        abmp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_boton_productosActionPerformed

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
            java.util.logging.Logger.getLogger(MenuAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdministrador("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_agregar_cliente;
    private javax.swing.JButton boton_alta_pedido;
    private javax.swing.JButton boton_buscar_cliente;
    private javax.swing.JButton boton_buscar_pedido;
    private javax.swing.JButton boton_buscar_producto;
    private javax.swing.JButton boton_buscar_venta;
    private javax.swing.JButton boton_cerrar_sesion;
    private javax.swing.JButton boton_productos;
    private javax.swing.JButton realizar_venta;
    // End of variables declaration//GEN-END:variables
}