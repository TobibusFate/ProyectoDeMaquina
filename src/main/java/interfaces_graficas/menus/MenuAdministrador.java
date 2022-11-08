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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author tovib
 */
public class MenuAdministrador extends javax.swing.JFrame {

    private static final Logger INFOLOGGER = LogManager.getLogger("info-log");
    private String username;
    
    public MenuAdministrador(String username) {
        initComponents();
        this.username = username;
        boton_agregar_cliente.setEnabled(false);
        boton_buscar_cliente.setEnabled(false);
        boton_cierre_diario.setEnabled(false);
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
        boton_cerrar_sesion = new javax.swing.JButton();
        boton_alta_pedido = new javax.swing.JButton();
        boton_buscar_pedido = new javax.swing.JButton();
        boton_buscar_cliente = new javax.swing.JButton();
        boton_buscar_venta = new javax.swing.JButton();
        realizar_venta = new javax.swing.JButton();
        boton_agregar_cliente = new javax.swing.JButton();
        boton_productos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        boton_cierre_diario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(420, 480));

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setPreferredSize(new java.awt.Dimension(420, 450));

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
        boton_agregar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_agregar_clienteActionPerformed(evt);
            }
        });

        boton_productos.setText("ABM Producto");
        boton_productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_productosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        jLabel1.setText("Bienvenido al gestor de ventas");

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel2.setText("Administrador:");

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel3.setText("Vendedor:");

        boton_cierre_diario.setText("Cierre Diario");

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentLayout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(boton_agregar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton_buscar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(contentLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSeparator3)
                                        .addComponent(jSeparator1)
                                        .addGroup(contentLayout.createSequentialGroup()
                                            .addGap(1, 1, 1)
                                            .addComponent(boton_cerrar_sesion)
                                            .addGap(192, 192, 192)))
                                    .addComponent(jLabel2)))
                            .addGroup(contentLayout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(realizar_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton_buscar_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(boton_alta_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton_productos, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boton_buscar_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton_cierre_diario, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(29, 29, 29)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_buscar_venta)
                    .addComponent(realizar_venta))
                .addGap(18, 18, 18)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_agregar_cliente)
                    .addComponent(boton_buscar_cliente))
                .addGap(29, 29, 29)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_alta_pedido)
                    .addComponent(boton_buscar_pedido))
                .addGap(18, 18, 18)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_productos)
                    .addComponent(boton_cierre_diario))
                .addGap(34, 34, 34)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(boton_cerrar_sesion)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_alta_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_alta_pedidoActionPerformed
        // TODO add your handling code here:
        AltaPedido_Generador apg = new AltaPedido_Generador(username);
        this.setVisible(false);
        apg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_boton_alta_pedidoActionPerformed

    private void boton_cerrar_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_cerrar_sesionActionPerformed
        // TODO add your handling code here:
        LogIn li = new LogIn();
        li.setVisible(true);
        INFOLOGGER.info("El usuario \'"+username+"\' ha cerrado sesion");
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_boton_cerrar_sesionActionPerformed

    private void boton_buscar_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_buscar_pedidoActionPerformed
        BuscarPedido bp = new BuscarPedido(username);
        bp.setVisible(true);
        this.setVisible(false);
        this.dispose();
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

    private void boton_agregar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_agregar_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_agregar_clienteActionPerformed

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
    private javax.swing.JButton boton_buscar_venta;
    private javax.swing.JButton boton_cerrar_sesion;
    private javax.swing.JButton boton_cierre_diario;
    private javax.swing.JButton boton_productos;
    private javax.swing.JPanel content;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton realizar_venta;
    // End of variables declaration//GEN-END:variables
}
