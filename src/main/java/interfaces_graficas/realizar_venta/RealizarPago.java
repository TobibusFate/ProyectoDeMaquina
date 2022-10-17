/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces_graficas.realizar_venta;

import objects.Pago;
import objects.TipoDePago;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;

/**
 *
 * @author tovib
 */
public class RealizarPago extends javax.swing.JFrame {
    
    private static RegistrarVenta registrarVenta = null;
    /**
     * Creates new form RealizarPago
     */
    public RealizarPago(String monto, RegistrarVenta cv) {
        initComponents();
        addList();
        cerrar();
        registrarVenta = cv;
        tipo_pago.setSelectedItem(TipoDePago.EFECTIVO.getTipo());
        text_cuotas.setText("1");
        texto_dni.setEditable(false);
        monto_faltante.setText(monto);
        boton_cargar_cliente.setEnabled(false);
        titulo.setText("Realizar Pago: "+(cv.getListaPagos().size()+1));
        boton_ver_pagos.setEnabled(cv.getListaPagos().size() > 0);

    }

    public void addList() {

        for (TipoDePago tipoDePago: TipoDePago.values()){
            tipo_pago.addItem(tipoDePago.getTipo());
        }
        tipo_pago.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getItem().toString().equals(TipoDePago.FIADO.getTipo())) {
                    texto_dni.setEditable(true);
                    text_cuotas.setText("1");
                text_cuotas.setEditable(false);
                } else {
                    texto_dni.setEditable(false);
                    if (e.getItem().toString().equals(TipoDePago.EFECTIVO.getTipo())) {
                        text_cuotas.setText("1");
                        text_cuotas.setEditable(false);
                    } else {
                        text_cuotas.setText("1");
                        text_cuotas.setEditable(true);
                    
                    }
                }
            }
        });
        text_cuotas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (Character.isLetter(e.getKeyChar())) {
                    e.consume();
                } else {
                    try {
                        Integer.parseInt(text_cuotas.getText() + e.getKeyChar());
                    } catch (NumberFormatException exception) {
                        e.consume();
                    }
                }
            }
        });
        texto_monto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (Character.isLetter(e.getKeyChar())) {
                    e.consume();
                } else {
                    try {
                        Float.parseFloat(texto_monto.getText() + e.getKeyChar());
                    } catch (NumberFormatException exception) {
                        e.consume();
                    }
                }
            }
        });
        /*texto_dni.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (Character.isLetter(e.getKeyChar())) {
                    e.consume();
                } else {
                    try {
                        Integer.parseInt(texto_dni.getText() + e.getKeyChar());
                    } catch (NumberFormatException exception) {
                        e.consume();
                    }
                }
            }
        });*/
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipo_pago = new javax.swing.JComboBox<>();
        texto_monto = new javax.swing.JTextField();
        texto_dni = new javax.swing.JTextField();
        boton_cargar = new javax.swing.JButton();
        boton_cancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        monto_faltante = new javax.swing.JLabel();
        boton_pagar_restante = new javax.swing.JButton();
        text_cuotas = new javax.swing.JTextField();
        boton_cargar_cliente = new javax.swing.JButton();
        boton_ver_pagos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tipo_pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipo_pagoActionPerformed(evt);
            }
        });

        texto_monto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        texto_monto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texto_montoActionPerformed(evt);
            }
        });

        texto_dni.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        boton_cargar.setText("Cargar");
        boton_cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_cargarActionPerformed(evt);
            }
        });

        boton_cancelar.setText("Cancelar");
        boton_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_cancelarActionPerformed(evt);
            }
        });

        jLabel3.setText("Tipo de Pago");

        jLabel4.setText("D.N.I.");

        jLabel5.setText("Cuotas");

        jLabel6.setText("Monto");

        jLabel7.setText("Monto Restante    $");

        titulo.setText("Realizar Pago");

        monto_faltante.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        monto_faltante.setText("1000");

        boton_pagar_restante.setText("Pagar Todo");
        boton_pagar_restante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_pagar_restanteActionPerformed(evt);
            }
        });

        text_cuotas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        text_cuotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_cuotasActionPerformed(evt);
            }
        });

        boton_cargar_cliente.setText("Cargar Cliente");

        boton_ver_pagos.setText("Ver Pagos");
        boton_ver_pagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_ver_pagosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(text_cuotas)
                                    .addComponent(tipo_pago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(texto_dni)
                                    .addComponent(texto_monto, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(monto_faltante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(titulo))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(boton_cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boton_ver_pagos)
                        .addGap(23, 23, 23)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(boton_cargar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(boton_cargar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(boton_pagar_restante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(boton_cargar_cliente))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(titulo)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tipo_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(texto_dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(text_cuotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(monto_faltante))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(texto_monto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(boton_pagar_restante))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_cancelar)
                    .addComponent(boton_cargar)
                    .addComponent(boton_ver_pagos))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void texto_montoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto_montoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texto_montoActionPerformed

    private void tipo_pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipo_pagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipo_pagoActionPerformed

    private void boton_cargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_cargarActionPerformed
        // TODO add your handling code here:
        boolean terminar = true;
        if (texto_monto.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El Monto es obligatorio");
        }
        if (tipo_pago.getSelectedItem().toString().equals(TipoDePago.FIADO.getTipo()) && texto_dni.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El DNI es obligatorio");
            terminar = false;
        }
        if (tipo_pago.getSelectedItem().toString().equals(TipoDePago.FIADO.getTipo()) &&
                !registrarVenta.getListaClientes().containsKey(Integer.parseInt(texto_dni.getText()))) {
            JOptionPane.showMessageDialog(null, "El DNI no pertenece a un Cliente registrado");
            terminar = false;
        }
        try {
            if (Float.parseFloat(texto_monto.getText()) < 0 || Integer.parseInt(text_cuotas.getText()) < 0) {
                JOptionPane.showMessageDialog(null, "No se permiten Cuotas o Montos negativos");
                terminar = false;
            }
        } catch (NumberFormatException e) {
            terminar = false;   /** CUIDADO CON ESTE FALSE, CAPAS DE ERROR, PERO POR AHORA NO LO HIZO*/
        }
        if (terminar) {
            terminarPago();
        }
    }//GEN-LAST:event_boton_cargarActionPerformed

    public void terminarPago() {
        LocalDate now = LocalDate.now();
        String tipoPago;
        if (tipo_pago.getSelectedItem().toString().equals(TipoDePago.TARJETA_CREDITO.getTipo())) {
            tipoPago = "TarjetaCredito";
        } else if (tipo_pago.getSelectedItem().toString().equals(TipoDePago.TARJETA_DEBITO.getTipo())) {
            tipoPago = "TarjetaDebito";
        } else {
            tipoPago = tipo_pago.getSelectedItem().toString();
        }

        Pago pago = new Pago(Float.parseFloat(texto_monto.getText()), Integer.parseInt(text_cuotas.getText()), tipoPago);

        if (pago.getMetodoPago().equals(TipoDePago.FIADO.getTipo())) {
            pago.setCliente(registrarVenta.getListaClientes().get(Integer.parseInt(texto_dni.getText())));
            pago.setFechaP(now);
            pago.setFechaLimiteP(now.plusMonths(1));
        } else if (pago.getMetodoPago().equals(TipoDePago.EFECTIVO.getTipo())) {
            pago.setFechaP(now);
            pago.setFechaLimiteP(now);
        } else if (pago.getCuotas() > 1 ) { //tarjeta
            pago.setFechaP(now);
            pago.setFechaLimiteP(now.plusMonths(pago.getCuotas()));
        } else {
            pago.setFechaP(now);
            pago.setFechaLimiteP(now);
        }
        registrarVenta.addPago(pago);
        this.dispose();

    }

    private void boton_pagar_restanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_pagar_restanteActionPerformed
        // TODO add your handling code here:
        texto_monto.setText(monto_faltante.getText());
    }//GEN-LAST:event_boton_pagar_restanteActionPerformed

    private void boton_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_cancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_boton_cancelarActionPerformed

    private void text_cuotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_cuotasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_cuotasActionPerformed

    private void boton_ver_pagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_ver_pagosActionPerformed
        // TODO add your handling code here:
        MostrarPagos mp = new MostrarPagos(registrarVenta.getListaPagos());
        mp.setVisible(true);
    }//GEN-LAST:event_boton_ver_pagosActionPerformed

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
            java.util.logging.Logger.getLogger(RealizarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RealizarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RealizarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RealizarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RealizarPago("",null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_cancelar;
    private javax.swing.JButton boton_cargar;
    private javax.swing.JButton boton_cargar_cliente;
    private javax.swing.JButton boton_pagar_restante;
    private javax.swing.JButton boton_ver_pagos;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel monto_faltante;
    private javax.swing.JTextField text_cuotas;
    private javax.swing.JTextField texto_dni;
    private javax.swing.JTextField texto_monto;
    private javax.swing.JComboBox<String> tipo_pago;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
