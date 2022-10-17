/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces_graficas.abm_producto;

import logica.managers.ManagerProducto;
import objects.Producto;
import objects.RenglonVenta;
import objects.Venta;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;

/**
 *
 * @author tovib
 */
public class abm_producto extends javax.swing.JFrame {

    /**
     * Creates new form abm_producto
     */
    private static HashMap<String, Producto> listaProductos = new HashMap<>();
    private DefaultTableModel model;
    public abm_producto() {
        initComponents();
        listaProductos = ManagerProducto.getHashMapProductos();
        updateTabla(listaProductos);
        addList();
    }
    public void addList(){
        texto_buscador.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateTabla(coincidencia());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateTabla(coincidencia());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateTabla(coincidencia());
            }
        });
    }
    public HashMap<String, Producto> coincidencia () {
        HashMap<String, Producto> map = new HashMap<>();
        for (Producto p : listaProductos.values()) {
            if (String.valueOf(p.getNombreP()).contains(texto_buscador.getText())) {
                map.put(p.getNombreP(),p);
            }
        }
        return map;
    }

    public void updateTabla(HashMap<String, Producto> localMap) {
        model = (DefaultTableModel) this.tabla_productos.getModel();
        /** LIMPIAR TABLA*/
        while (model.getRowCount()>0){
            model.removeRow(0);
        }
        /** CARGAR  TABLA*/
        for (Producto p: localMap.values()){
            model.addRow(new Object[]{p.getCodigoP(),p.getNombreP(),p.getCategoriaP(),p.getPrecioP(),p.getStockP(),p.getStockMinimoP()});
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

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_productos = new javax.swing.JTable();
        modificar_producto = new javax.swing.JButton();
        eliminar_producto = new javax.swing.JButton();
        texto_buscador = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        agregar_producto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Salir");

        tabla_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Categoria", "Precio", "Stock", "Stock Minimo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_productos);

        modificar_producto.setText("Modificar");
        modificar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar_productoActionPerformed(evt);
            }
        });

        eliminar_producto.setText("Eliminar");
        eliminar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_productoActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscador");

        agregar_producto.setText("Agregar");
        agregar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_productoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addGap(50, 50, 50)
                        .addComponent(texto_buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(agregar_producto))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eliminar_producto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(modificar_producto)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(agregar_producto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(modificar_producto)
                    .addComponent(eliminar_producto))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modificar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_productoActionPerformed
        // TODO add your handling code here:

        if (tabla_productos.getSelectedRow() != -1) {
            Producto p = listaProductos.get(model.getValueAt(tabla_productos.getSelectedRow(),1).toString());
            ModificarProducto mp = new ModificarProducto(p);
            mp.setVisible(true);
        } else {
            //No hay producto seleccionado
        }


        //ManagerProducto.actualizarProducto
    }//GEN-LAST:event_modificar_productoActionPerformed

    private void eliminar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_productoActionPerformed
        // TODO add your handling code here:
        //ManagerProducto.eliminarProducto
    }//GEN-LAST:event_eliminar_productoActionPerformed

    private void agregar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_productoActionPerformed
        AgregarProducto ap = new AgregarProducto();
        this.setVisible(false);
        this.dispose();
        ap.setVisible(true);
        //ManagerProducto.agregarProducto
    }//GEN-LAST:event_agregar_productoActionPerformed

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
            java.util.logging.Logger.getLogger(abm_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(abm_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(abm_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(abm_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new abm_producto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar_producto;
    private javax.swing.JButton eliminar_producto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificar_producto;
    private javax.swing.JTable tabla_productos;
    private javax.swing.JTextField texto_buscador;
    // End of variables declaration//GEN-END:variables
}
