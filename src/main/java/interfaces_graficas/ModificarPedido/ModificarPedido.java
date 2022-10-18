/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces_graficas.ModificarPedido;


import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import interfaces_graficas.menus.MenuAdministrador;
import logica.managers.ManagerAdministrador;
import logica.managers.ManagerProducto;
import objects.Pedido;
import objects.Producto;
import objects.RenglonPedido;
import logica.managers.ManagerRenglonPedido;
import objects.Administrador;
import objects.TipoCantidad;

public class ModificarPedido extends javax.swing.JFrame {
    
    private Map<String,Producto> mapProductos = new HashMap<>();
    private Map<String, RenglonPedido> mapRenglones = new HashMap<>();
    private DefaultTableModel model;
    private Pedido pedido;
    private Administrador admin;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    
    public ModificarPedido(String username, Pedido pedido) {
        initComponents();
        labelCodigoPedido.setText(String.valueOf(pedido.getCodigo()));
        labelFechaCreacion.setText(pedido.getFechaPedido().format(formatter));
        AddListeners();
        //Btn_Continuar.setEnabled(false);
        BtnAsignarFecha.setEnabled(false);
        BtnLimpiarFecha.setEnabled(false);
        this.pedido = pedido;
        mapProductos = ManagerProducto.getHashMapProductos();
        List<RenglonPedido> listaRenglones = ManagerRenglonPedido.getRenglonesPorPedido(pedido);
        for (RenglonPedido rp: listaRenglones){
            mapRenglones.put(rp.getProducto().getNombreP(), rp);
        }
        admin = ManagerAdministrador.getAdministrador(-1, username);
        updateTable();
        updateComboboxProductos();
    }
    
    private void AddListeners() {
        FldProd.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateComboboxProductos();
                Cbx_ListaProductos.hidePopup();
                Cbx_ListaProductos.showPopup();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateComboboxProductos();
                Cbx_ListaProductos.hidePopup();
                Cbx_ListaProductos.showPopup();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateComboboxProductos();
                Cbx_ListaProductos.hidePopup();
                Cbx_ListaProductos.showPopup();
            }
        }        
        );
        
        TblRenglones.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                int row = TblRenglones.getSelectedRow();
                int column = TblRenglones.getSelectedColumn();
                String newValue = TblRenglones.getValueAt(row, column).toString();
                String rowName = TblRenglones.getValueAt(row, 1).toString();
                updateRenglonPedido(rowName,newValue,column);
                updateTable();
            }
        }
        );
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        content = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        FldProd = new javax.swing.JTextField();
        Cbx_ListaProductos = new javax.swing.JComboBox<>();
        Cbx_ListaTipos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblRenglones = new javax.swing.JTable();
        Btn_addProd = new javax.swing.JButton();
        Btn_removeProd = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        FldMontoFinal = new javax.swing.JTextField();
        BtnCancelar = new javax.swing.JButton();
        Btn_Continuar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labelCodigoPedido = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelFechaCreacion = new javax.swing.JLabel();
        BtnAsignarFecha = new javax.swing.JButton();
        calendarFechaEntrega = new com.toedter.calendar.JDateChooser();
        BtnLimpiarFecha = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Productos: ");

        FldProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FldProdActionPerformed(evt);
            }
        });

        Cbx_ListaProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cbx_ListaProductosActionPerformed(evt);
            }
        });

        Cbx_ListaTipos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bolsones", "Bultos Cerrados", "Pallets" }));
        Cbx_ListaTipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cbx_ListaTiposActionPerformed(evt);
            }
        });

        TblRenglones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Producto", "Cantidad", "U. Medida", "Precio Unitario", "% Bonif", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblRenglones.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TblRenglones);

        Btn_addProd.setText("+");
        Btn_addProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_addProdActionPerformed(evt);
            }
        });

        Btn_removeProd.setText("-");
        Btn_removeProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_removeProdActionPerformed(evt);
            }
        });

        jLabel3.setText("Monto Final:");

        FldMontoFinal.setEditable(false);

        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        Btn_Continuar.setText("Continuar");
        Btn_Continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ContinuarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Código de Pedido:");

        labelCodigoPedido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelCodigoPedido.setText("####");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Fecha Creación:");

        labelFechaCreacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelFechaCreacion.setText("DD-MM-AAAA");

        BtnAsignarFecha.setText("Asignar Fecha de entrega");
        BtnAsignarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAsignarFechaActionPerformed(evt);
            }
        });

        calendarFechaEntrega.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calendarFechaEntregaPropertyChange(evt);
            }
        });

        BtnLimpiarFecha.setText("Limpiar fecha");
        BtnLimpiarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarFechaActionPerformed(evt);
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
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(contentLayout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(FldMontoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(contentLayout.createSequentialGroup()
                                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addGroup(contentLayout.createSequentialGroup()
                                                .addGap(87, 87, 87)
                                                .addComponent(FldProd, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Cbx_ListaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Cbx_ListaTipos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Btn_removeProd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Btn_addProd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentLayout.createSequentialGroup()
                                .addComponent(BtnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Btn_Continuar)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelCodigoPedido)
                        .addGap(114, 114, 114)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelFechaCreacion)
                        .addGap(151, 151, 151))))
            .addGroup(contentLayout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(calendarFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnLimpiarFecha)
                    .addComponent(BtnAsignarFecha))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(labelFechaCreacion)
                    .addComponent(jLabel1)
                    .addComponent(labelCodigoPedido))
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Cbx_ListaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(FldProd, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Cbx_ListaTipos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(Btn_addProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btn_removeProd)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FldMontoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_Continuar)
                            .addComponent(BtnCancelar)))
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calendarFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnAsignarFecha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnLimpiarFecha)))
                .addContainerGap())
        );

        getContentPane().add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FldProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FldProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FldProdActionPerformed

    private void Cbx_ListaProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cbx_ListaProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cbx_ListaProductosActionPerformed

    private void Cbx_ListaTiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cbx_ListaTiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cbx_ListaTiposActionPerformed

    private void Btn_addProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_addProdActionPerformed
        // TODO add your handling code here:
        String cbxText = Cbx_ListaProductos.getSelectedItem().toString();
        String cbxTipo = Cbx_ListaTipos.getSelectedItem().toString();
        if (!mapRenglones.containsKey(cbxText)) {
            switch (cbxTipo) {
                case "Bolsones": mapRenglones.put(cbxText, new RenglonPedido(mapProductos.get(cbxText),1,TipoCantidad.Bolsones,0F)); break;
                case "Bultos Cerrados": mapRenglones.put(cbxText, new RenglonPedido(mapProductos.get(cbxText),1,TipoCantidad.BultosCerrados,0F)); break;
                case "Pallets": mapRenglones.put(cbxText, new RenglonPedido(mapProductos.get(cbxText),1,TipoCantidad.Pallets,0F)); break;
                default: mapRenglones.put(cbxText, new RenglonPedido(mapProductos.get(cbxText),1,TipoCantidad.Bolsones,0F)); break;
            }
        }
        else {
            RenglonPedido rp = mapRenglones.get(cbxText);
            switch (cbxTipo) {
                case "Bolsones": rp.setTipoCantidad(TipoCantidad.Bolsones);; break;
                case "Bultos Cerrados": rp.setTipoCantidad(TipoCantidad.BultosCerrados);; break;
                case "Pallets": rp.setTipoCantidad(TipoCantidad.Pallets);; break;
            }
            mapRenglones.replace(cbxText, rp);
        }
        if (!mapRenglones.isEmpty()) {
            Btn_Continuar.setEnabled(true);
        }
        updateTable();
    }//GEN-LAST:event_Btn_addProdActionPerformed

    private void Btn_removeProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_removeProdActionPerformed
        if (TblRenglones.getSelectedRow() != -1) {
            mapRenglones.remove(model.getValueAt(TblRenglones.getSelectedRow(), 1).toString());
            model.removeRow(TblRenglones.getSelectedRow());
        }
        else {
            // TODO: MessageDialog
        }
        if (mapRenglones.isEmpty()) {
            Btn_Continuar.setEnabled(false);
        }
        updateTable();
    }//GEN-LAST:event_Btn_removeProdActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        MenuAdministrador mv = new MenuAdministrador(this.admin.getCuenta().getCuenta());
        mv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void Btn_ContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ContinuarActionPerformed
        // TODO add your handling code here:

        ModificarPedido_Preview previewWindow = new ModificarPedido_Preview(this);
        this.setVisible(false);
        previewWindow.setVisible(true);
    }//GEN-LAST:event_Btn_ContinuarActionPerformed

    private void BtnAsignarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAsignarFechaActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        pedido.setFechaEntrega(LocalDate.parse(sdf.format(calendarFechaEntrega.getCalendar().getTime())));
        if(pedido.getFechaEntrega().isBefore(pedido.getFechaPedido())) {
            JOptionPane.showMessageDialog(content, "La fecha de entrega no puede ser anterior al pedido, seleccione nuevamente","Error fecha de entrega",JOptionPane.ERROR_MESSAGE);
            pedido.setFechaEntrega(null);
        }
    }//GEN-LAST:event_BtnAsignarFechaActionPerformed

    private void BtnLimpiarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarFechaActionPerformed
            pedido.setFechaEntrega(null);
    }//GEN-LAST:event_BtnLimpiarFechaActionPerformed

    private void calendarFechaEntregaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calendarFechaEntregaPropertyChange
        BtnAsignarFecha.setEnabled(true);
        BtnLimpiarFecha.setEnabled(true);
    }//GEN-LAST:event_calendarFechaEntregaPropertyChange
    
    private void updateRenglonPedido(String rowName, String newValue, int column) {
        RenglonPedido rp = mapRenglones.get(rowName);
        switch (column) {
            case 2: {
                if ("".matches(newValue) || Integer.parseInt(newValue) <= 0) {
                    JOptionPane.showMessageDialog(content, "Valor inválido, solo valores enteros positivos. \nIntente nuevamente.");
                    rp.setCantidad(1);
                }
                else rp.setCantidad(Integer.parseInt(newValue));
            } break;
            case 5: {
                if ("".matches(newValue) || !newValue.matches("\\d*(\\.\\d{0,2})?") || Float.parseFloat(newValue) < 0F || Float.parseFloat(newValue) > 100F) {
                    JOptionPane.showMessageDialog(content, "Valor inválido, solo valores positivos (max 100%), con dos decimales como máximo. \nIntente nuevamente.");
                    rp.setDescuento(0.0F);
                }
                else rp.setDescuento(Float.parseFloat(newValue));
            } break;
        }
        mapRenglones.replace(rowName, rp);
    }
    
    private void updateComboboxProductos(){
        List<String> listaProd = new ArrayList<>();
        for (int i = 0;i<Cbx_ListaProductos.getItemCount();i++) {
            listaProd.add(Cbx_ListaProductos.getItemAt(i).toLowerCase());
        }
        for (Producto p: mapProductos.values()){
            if (p.getNombreP().toLowerCase().contains(FldProd.getText().toLowerCase())) {
                if (!listaProd.contains(p.getNombreP().toLowerCase())) {
                    Cbx_ListaProductos.addItem(p.getNombreP().toLowerCase());
                }
            }
            if (listaProd.contains(p.getNombreP().toLowerCase())) {
                if (!p.getNombreP().toLowerCase().contains(FldProd.getText().toLowerCase())) {
                    Cbx_ListaProductos.removeItem(p.getNombreP().toLowerCase());
                }
            }
        }
    }
    
    private void updateTable() {
        model = (DefaultTableModel) TblRenglones.getModel();
        while(model.getRowCount() > 0) {
            model.removeRow(0);
        }
        for (RenglonPedido rp: mapRenglones.values()) {
            model.addRow(new Object[]{rp.getProducto().getCodigoP(),rp.getProducto().getNombreP(), rp.getCantidad(), rp.getTipoCantidad(), rp.getProducto().getPrecioP(), rp.getDescuento(), rp.getMontoTotal()});
        }
        float value = 0;
        for (RenglonPedido rp: mapRenglones.values()) {
            value += rp.getMontoTotal();
        }
        FldMontoFinal.setText(Float.toString(value));
    }
    
    public Administrador getAdministrador() {
        return admin;
    }
    public Map<String, RenglonPedido> getRenglones() {
        return mapRenglones;
    }
    
    public Pedido getPedido() {
        return pedido;
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
            java.util.logging.Logger.getLogger(ModificarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarPedido("", null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAsignarFecha;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnLimpiarFecha;
    private javax.swing.JButton Btn_Continuar;
    private javax.swing.JButton Btn_addProd;
    private javax.swing.JButton Btn_removeProd;
    private javax.swing.JComboBox<String> Cbx_ListaProductos;
    private javax.swing.JComboBox<String> Cbx_ListaTipos;
    private javax.swing.JTextField FldMontoFinal;
    private javax.swing.JTextField FldProd;
    private javax.swing.JTable TblRenglones;
    private com.toedter.calendar.JDateChooser calendarFechaEntrega;
    private javax.swing.JPanel content;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCodigoPedido;
    private javax.swing.JLabel labelFechaCreacion;
    // End of variables declaration//GEN-END:variables
}
