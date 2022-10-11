/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces_graficas.realizar_venta;

import logica.managers.ManagerCliente;
import logica.managers.ManagerProducto;
import logica.managers.ManagerVenta;
import objects.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author tovib
 */
public class RegistrarVenta extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarVenta
     */
    private String usuario;
    private static HashMap <String, Producto> listaProductos = new HashMap<>();
    private static HashMap <Integer, Cliente> listaClientes = new HashMap<>();
    private static HashMap <String, RenglonVenta> listaRenglon = new HashMap<>();
    private static ArrayList<Pago> listaPagos = new ArrayList<>();
    private DefaultTableModel model;

    public RegistrarVenta(String usuario) {
        initComponents();
        this.usuario = usuario;
        addList();
        listaRenglon.clear();
        unidades.setText("1");
        boton_realizar_pago.setEnabled(false);
        boton_vaciar_pagos.setEnabled(false);
        listaClientes = ManagerCliente.getHashMapClientes();
        listaProductos = ManagerProducto.getHashMapProductos();
        updateCombobox();
    }
    public void addPago (Pago p) {
        listaPagos.add(p);
        if (!listaPagos.isEmpty()) {
            boton_vaciar_pagos.setEnabled(true);
        }
        updateMontoRestante();
    }
    public HashMap<Integer, Cliente> getListaClientes() {
        return listaClientes;
    }
    private void addList() {
        buscador_productos.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateCombobox();
                combobox_listado_productos.hidePopup();
                combobox_listado_productos.showPopup();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateCombobox();
                combobox_listado_productos.hidePopup();
                combobox_listado_productos.showPopup();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateCombobox();
                combobox_listado_productos.hidePopup();
                combobox_listado_productos.showPopup();
            }
        });

        tabla_renglones.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                //super.focusGained(e);
                int fila = tabla_renglones.getSelectedRow();
                int columna = tabla_renglones.getSelectedColumn();
                String nuevoValor = tabla_renglones.getValueAt(fila,columna).toString();
                String nombreFila = tabla_renglones.getValueAt(fila,1).toString();
                updateRenglonVenta(nombreFila,nuevoValor,columna);
                updateTable();
            }

        });

        unidades.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (Character.isLetter(e.getKeyChar())) {
                    e.consume();
                } else {
                    try {
                        Integer.parseInt(unidades.getText() + e.getKeyChar());
                    } catch (NumberFormatException exception) {
                        e.consume();
                    }
                }
            }
        });
    }
    private void updateRenglonVenta (String nombreFila, String nuevoValor, int columna){
        RenglonVenta renglonVenta = listaRenglon.get(nombreFila);
        switch (columna){
            case 2: //unidades
                if (Integer.parseInt(nuevoValor) > listaProductos.get(nombreFila).getStockP()) {
                    JOptionPane.showMessageDialog(null, "La cantidad supera las unidades en stock");
                } else {
                    renglonVenta.setUnidades(Integer.parseInt(nuevoValor));
                }
                break;
            case 5: //descuento
                if (Float.parseFloat(nuevoValor) > 100 || Float.parseFloat(nuevoValor) < 0) {
                    JOptionPane.showMessageDialog(null, "El descuento toma valores entre 0 y 100");
                } else {
                    renglonVenta.setDescuento(Float.parseFloat(nuevoValor));
                }

        }
        listaRenglon.replace(nombreFila,renglonVenta);
    }
    private void updateCombobox(){
        List<String> lista = new ArrayList<>();
        for (int i = 0;i<combobox_listado_productos.getItemCount();i++) {
            lista.add(combobox_listado_productos.getItemAt(i).toLowerCase());
        }
        for (Producto p: listaProductos.values()){
            if (p.getNombreP().toLowerCase().contains(buscador_productos.getText().toLowerCase())) {
                if (!lista.contains(p.getNombreP().toLowerCase())) {
                    combobox_listado_productos.addItem(p.getNombreP().toLowerCase());
                }
            }
            if (lista.contains(p.getNombreP().toLowerCase())) {
                if (!p.getNombreP().toLowerCase().contains(buscador_productos.getText().toLowerCase())) {
                    combobox_listado_productos.removeItem(p.getNombreP().toLowerCase());
                }
            }
        }
    }
    public void prepararNuevaCompra() {
        listaPagos.clear();
        boton_vaciar_pagos.setEnabled(false);
        boton_realizar_pago.setText("Realizar Pago");
        boton_realizar_pago.setEnabled(false);
        listaRenglon.clear();
        listaProductos = ManagerProducto.getHashMapProductos();
        listaClientes = ManagerCliente.getHashMapClientes();
        updateTable();
    }

    public void updateTable (){
        model = (DefaultTableModel) this.tabla_renglones.getModel();
        /** LIMPIAR TABLA*/
        while (model.getRowCount()>0){
            model.removeRow(0);
        }
        /** CARGAR  TABLA*/
        for (RenglonVenta rv: listaRenglon.values()){
            model.addRow(new Object[]{rv.getProducto().getCodigoP(),rv.getProducto().getNombreP(),rv.getUnidades(),rv.getProducto().getPrecioP(),rv.getMontoTotal(),rv.getDescuento()});
        }
        float value = 0;
        for (RenglonVenta rv : listaRenglon.values()) {
            value += rv.getMontoTotal();
        }
        valor_total_value.setText(String.valueOf(value));
        updateMontoRestante();
    }

    public void updateMontoRestante() {
        float monto_pagado = 0;
        for (Pago p: listaPagos) {
            monto_pagado+= p.getMontoP();
        }
        float restanteActual = Float.parseFloat(valor_total_value.getText()) - monto_pagado;
        if (restanteActual <= 0) {
            //actualizar restante actual
            //informar vuelto
            text_monto_restante.setText("Vuelto");
            monto_restante_value.setText(String.valueOf(restanteActual));
            if (!listaRenglon.isEmpty()) {
                boton_realizar_pago.setText("Finalizar Compra");
            }
        } else {
            text_monto_restante.setText("Monto Restante");
            monto_restante_value.setText(String.valueOf(restanteActual));
            boton_realizar_pago.setText("Realizar Pago");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_renglones = new javax.swing.JTable();
        boton_realizar_pago = new javax.swing.JButton();
        boton_salir = new javax.swing.JButton();
        buscador_productos = new javax.swing.JTextField();
        combobox_listado_productos = new javax.swing.JComboBox<>();
        boton_agregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        unidades = new javax.swing.JTextField();
        boton_quitar = new javax.swing.JButton();
        boton_vaciar_pagos = new javax.swing.JButton();
        text_monto_restante = new javax.swing.JLabel();
        text_valor_total = new javax.swing.JLabel();
        monto_restante_value = new javax.swing.JLabel();
        valor_total_value = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabla_renglones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Unidades", "Monto", "Monto Total", "Descuento %"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Long.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_renglones);
        if (tabla_renglones.getColumnModel().getColumnCount() > 0) {
            tabla_renglones.getColumnModel().getColumn(0).setResizable(false);
            tabla_renglones.getColumnModel().getColumn(1).setResizable(false);
            tabla_renglones.getColumnModel().getColumn(2).setResizable(false);
            tabla_renglones.getColumnModel().getColumn(3).setResizable(false);
            tabla_renglones.getColumnModel().getColumn(4).setResizable(false);
            tabla_renglones.getColumnModel().getColumn(5).setResizable(false);
        }

        boton_realizar_pago.setText("Realizar Pago");
        boton_realizar_pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_realizar_pagoActionPerformed(evt);
            }
        });

        boton_salir.setText("Salir");
        boton_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_salirActionPerformed(evt);
            }
        });

        buscador_productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscador_productosActionPerformed(evt);
            }
        });

        combobox_listado_productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_listado_productosActionPerformed(evt);
            }
        });

        boton_agregar.setText("Agregar");
        boton_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_agregarActionPerformed(evt);
            }
        });

        jLabel2.setText("Buscador");

        jLabel3.setText("Unidades");

        unidades.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        unidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unidadesActionPerformed(evt);
            }
        });

        boton_quitar.setText("Quitar");
        boton_quitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_quitarActionPerformed(evt);
            }
        });

        boton_vaciar_pagos.setText("Vaciar Pagos");
        boton_vaciar_pagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_vaciar_pagosActionPerformed(evt);
            }
        });

        text_monto_restante.setText("Monto Restante");

        text_valor_total.setText("Valor Total");

        monto_restante_value.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        monto_restante_value.setText("0");

        valor_total_value.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        valor_total_value.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boton_salir)
                        .addGap(398, 398, 398)
                        .addComponent(boton_vaciar_pagos, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(boton_realizar_pago, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buscador_productos, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(combobox_listado_productos, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(113, 113, 113)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(unidades, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(text_monto_restante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(monto_restante_value, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(text_valor_total, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(valor_total_value, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boton_agregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boton_quitar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscador_productos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combobox_listado_productos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_agregar)
                    .addComponent(jLabel3)
                    .addComponent(unidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boton_quitar)
                        .addGap(46, 46, 46)
                        .addComponent(text_valor_total)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(valor_total_value)
                        .addGap(73, 73, 73)
                        .addComponent(text_monto_restante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(monto_restante_value, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_salir)
                    .addComponent(boton_realizar_pago)
                    .addComponent(boton_vaciar_pagos))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscador_productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscador_productosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscador_productosActionPerformed

    private void boton_realizar_pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_realizar_pagoActionPerformed
        // TODO add your handling code here:
        if (boton_realizar_pago.getText().equals("Realizar Pago")) {
            RealizarPago rp = new RealizarPago(monto_restante_value.getText(),this);
            rp.setVisible(true);
        } else {
            boolean cerrada = true;
            for (Pago p :listaPagos) {
                if (p.getCuotas() > 1 || p.getMetodoPago().equals(TipoDePago.FIADO.getTipo())) {
                    cerrada = false;
                    break;
                }
            }
            Venta v = new Venta(Float.parseFloat(valor_total_value.getText()), cerrada, this.usuario);
            ManagerVenta.cargarVenta(v,listaRenglon.values(),listaPagos);
            JOptionPane.showMessageDialog(null, "Venta Exitosa");
            prepararNuevaCompra();

        }
        
        /** ejecutar seleccion pago la cantidad de veces que indique value*/
    }//GEN-LAST:event_boton_realizar_pagoActionPerformed


    private void combobox_listado_productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_listado_productosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combobox_listado_productosActionPerformed

    private void boton_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_agregarActionPerformed
        // TODO add your handling code here:
        String text = combobox_listado_productos.getSelectedItem().toString();
        int unidades_value = Integer.parseInt(unidades.getText());

        if (listaRenglon.containsKey(text)) {
            /** MODIFICAR CANTIDAD*/
            RenglonVenta renglonVenta = listaRenglon.get(text);
            if ((unidades_value + renglonVenta.getUnidades()) >
                    listaProductos.get(combobox_listado_productos.getSelectedItem().toString()).getStockP()) {
                JOptionPane.showMessageDialog(null, "La cantidad supera las unidades en stock");
            } else {
                renglonVenta.setUnidades(renglonVenta.getUnidades()+unidades_value);
                listaRenglon.replace(text,renglonVenta);
            }

        } else {
            /** NUEVA ENTRADA*/
            if (unidades_value > listaProductos.get(combobox_listado_productos.getSelectedItem().toString()).getStockP()) {
                JOptionPane.showMessageDialog(null, "La cantidad supera las unidades en stock");
            } else {
                listaRenglon.put(text,new RenglonVenta(unidades_value,listaProductos.get(combobox_listado_productos.getSelectedItem().toString())));
            }
        }
        if (!listaRenglon.isEmpty()){
            boton_realizar_pago.setEnabled(true);
        }
        unidades.setText("1");
        updateTable();
                
    }//GEN-LAST:event_boton_agregarActionPerformed


    

    private void unidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unidadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unidadesActionPerformed

    private void boton_vaciar_pagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_vaciar_pagosActionPerformed
        // TODO add your handling code here:
        listaPagos.clear();
        updateMontoRestante();
        boton_vaciar_pagos.setEnabled(false);
    }//GEN-LAST:event_boton_vaciar_pagosActionPerformed

    private void boton_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_salirActionPerformed
        // TODO add your handling code here:
        MenuVendedor mv = new MenuVendedor(this.usuario);
        mv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_boton_salirActionPerformed

    private void boton_quitarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        if (tabla_renglones.getSelectedRow() != -1) {
            /** REMOVER VALOR DE LISTA Y TABLA*/
            listaRenglon.remove(model.getValueAt(tabla_renglones.getSelectedRow(),1).toString());
            model.removeRow(tabla_renglones.getSelectedRow());
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado producto");
        }
        if (listaRenglon.isEmpty()) {
            boton_realizar_pago.setEnabled(false);
        }
        updateTable();
    }

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
            java.util.logging.Logger.getLogger(RegistrarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarVenta("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_agregar;
    private javax.swing.JButton boton_quitar;
    private javax.swing.JButton boton_realizar_pago;
    private javax.swing.JButton boton_salir;
    private javax.swing.JButton boton_vaciar_pagos;
    private javax.swing.JTextField buscador_productos;
    private javax.swing.JComboBox<String> combobox_listado_productos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel monto_restante_value;
    private javax.swing.JTable tabla_renglones;
    private javax.swing.JLabel text_monto_restante;
    private javax.swing.JLabel text_valor_total;
    private javax.swing.JTextField unidades;
    private javax.swing.JLabel valor_total_value;
    // End of variables declaration//GEN-END:variables
}
