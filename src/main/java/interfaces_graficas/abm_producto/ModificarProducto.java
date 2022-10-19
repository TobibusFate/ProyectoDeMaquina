/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces_graficas.abm_producto;

import logica.managers.ManagerProducto;
import logica.managers.ManagerRenglon;
import objects.Producto;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author tovib
 */
public class ModificarProducto extends javax.swing.JFrame {

    /**
     * Creates new form ModificarProducto
     */
    private List<JTextField> campos = new ArrayList<>();
    private ABM_Producto abm_padre = null;
    private Producto producto;
    public ModificarProducto(Producto p, ABM_Producto abm_producto) {
        initComponents();
        this.producto = p;
        abm_padre = abm_producto;
        initTextsFiles();
        addListener();
        this.boton_modificar.setEnabled(false);
    }

    private void initTextsFiles() {
        codigo_producto.setText(String.valueOf(producto.getCodigoP()));
        codigo_producto.setEditable(false);
        nombre_producto.setText(producto.getNombreP());
        categoria_producto.setText(producto.getCategoriaP());
        precio_producto.setText(String.valueOf(producto.getPrecioP()));
        stock_producto.setText(String.valueOf(producto.getStockP()));
        stock_minimo_producto.setText(String.valueOf(producto.getStockMinimoP()));
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
        abm_padre.enabledButtons();
        this.dispose();
    }


    private void addListener() {
        campos.add(codigo_producto);
        campos.add(nombre_producto);
        campos.add(categoria_producto);
        campos.add(precio_producto);
        campos.add(stock_producto);
        campos.add(stock_minimo_producto);
        DocumentListener listener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                boolean canEnable = true;
                for (JTextField campo: campos) {
                    if (campo.getText().isEmpty()) canEnable = false;
                }
                boton_modificar.setEnabled(canEnable);
            }
        };
        for (JTextField campo:campos) {
            campo.getDocument().addDocumentListener(listener);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        codigo_producto = new javax.swing.JTextField();
        nombre_producto = new javax.swing.JTextField();
        categoria_producto = new javax.swing.JTextField();
        precio_producto = new javax.swing.JTextField();
        stock_minimo_producto = new javax.swing.JTextField();
        stock_producto = new javax.swing.JTextField();
        boton_modificar = new javax.swing.JButton();
        boton_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Codigo");

        jLabel2.setText("Nombre");

        jLabel3.setText("Categoria");

        jLabel4.setText("Stock");

        jLabel5.setText("Stock Minimo");

        jLabel6.setText("Precio");

        boton_modificar.setText("Modificar");
        boton_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_modificarActionPerformed(evt);
            }
        });

        boton_cancelar.setText("Cancelar");
        boton_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(boton_cancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(stock_minimo_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(boton_modificar)
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(stock_producto, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(categoria_producto)
                            .addComponent(nombre_producto, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codigo_producto, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(precio_producto))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codigo_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(nombre_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoria_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precio_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stock_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stock_minimo_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_cancelar)
                    .addComponent(boton_modificar))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_cancelarActionPerformed
        // TODO add your handling code here:
        abm_padre.enabledButtons();
        this.dispose();
    }//GEN-LAST:event_boton_cancelarActionPerformed

    private void boton_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_modificarActionPerformed
        // TODO add your handling code here:

        //logica para cambiar codigo de producto

        /*if (this.producto.getCodigoP() != Integer.parseInt(codigo_producto.getText())) {
            Producto p = new Producto(Integer.parseInt(codigo_producto.getText()),nombre_producto.getText().toUpperCase(),categoria_producto.getText().toUpperCase(),Float.parseFloat(precio_producto.getText()),Integer.parseInt(stock_producto.getText()),Integer.parseInt(stock_minimo_producto.getText()));
            ManagerProducto.deleteProducto(this.producto);
            ManagerRenglon.updateProductos(this.producto, p);
            ManagerProducto.cargarProducto(codigo_producto.getText(),nombre_producto.getText(),categoria_producto.getText(),precio_producto.getText(),stock_producto.getText(),stock_minimo_producto.getText());
        } else {
            ManagerProducto.updateProducto(new Producto(this.producto.getCodigoP(),nombre_producto.getText().toUpperCase(),categoria_producto.getText().toUpperCase(),Float.parseFloat(precio_producto.getText()),Integer.parseInt(stock_producto.getText()),Integer.parseInt(stock_minimo_producto.getText())));
            abm_padre.updateProductos();
        }*/
        if (ManagerProducto.updateProducto(new Producto(this.producto.getCodigoP(),nombre_producto.getText().toUpperCase(),categoria_producto.getText().toUpperCase(),Float.parseFloat(precio_producto.getText()),Integer.parseInt(stock_producto.getText()),Integer.parseInt(stock_minimo_producto.getText())))) {
            abm_padre.updateProductos();
            abm_padre.enabledButtons();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error en la carga,\nya existe un producto con ese nombre", "Falla en Alta de Producto",JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_boton_modificarActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarProducto(new Producto(0), new ABM_Producto("")).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_cancelar;
    private javax.swing.JButton boton_modificar;
    private javax.swing.JTextField categoria_producto;
    private javax.swing.JTextField codigo_producto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField nombre_producto;
    private javax.swing.JTextField precio_producto;
    private javax.swing.JTextField stock_minimo_producto;
    private javax.swing.JTextField stock_producto;
    // End of variables declaration//GEN-END:variables
}
