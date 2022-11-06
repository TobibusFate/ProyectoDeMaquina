/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces_graficas.alta_pedido;

import interfaces_graficas.menus.MenuAdministrador;
import logica.managers.ManagerAdministrador;
import logica.managers.ManagerProducto;
import logica.managers.ManagerProveedor;
import objects.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Cell9870
 */
public class AltaPedido_Generador extends javax.swing.JFrame {

    private Map<Long,Proveedor> mapProveedores = new HashMap<>();
    Map<String,Producto> mapProductos = new HashMap<>();
    Map<String, RenglonPedido> mapRenglones = new HashMap<>();
    private Proveedor proveedor;
    private DefaultTableModel model;
    private Administrador admin;
    
    public AltaPedido_Generador(String username) {
        initComponents();
        AddListeners();
        mapRenglones.clear();
        Btn_Continuar.setEnabled(false);
        
        mapProveedores = ManagerProveedor.getProveedoresMap();
        mapProductos = ManagerProducto.getHashMapProductosVisibles();
        admin = ManagerAdministrador.getAdministrador(-1, username);
        updateComboboxProductos();
        updateComboboxProveedores();
    }

    private void AddListeners() {
        FldCUIT.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    updateComboboxProveedores();
                    Cbx_ListaProveedores.hidePopup();
                    Cbx_ListaProveedores.showPopup();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    updateComboboxProveedores();
                    Cbx_ListaProveedores.hidePopup();
                    Cbx_ListaProveedores.showPopup();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    updateComboboxProveedores();
                    Cbx_ListaProveedores.hidePopup();
                    Cbx_ListaProveedores.showPopup();
                }
            }        
        );
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
                    if (row>=0 && column>=0) {
                        String newValue = TblRenglones.getValueAt(row, column).toString();
                        String rowName = TblRenglones.getValueAt(row, 1).toString();
                        updateRenglonPedido(rowName,newValue,column);
                        updateTable();
                    }
                }
            }
        );
    }
    
    private void updateRenglonPedido(String rowName, String newValue, int column) {
        RenglonPedido rp = getMapRenglones().get(rowName);
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
        getMapRenglones().replace(rowName, rp);
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
        jLabel1 = new javax.swing.JLabel();
        Btn_CargarProv = new javax.swing.JButton();
        FldNombre = new javax.swing.JTextField();
        FldCUIT = new javax.swing.JTextField();
        FldEmail = new javax.swing.JTextField();
        FldDomicilio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblRenglones = new javax.swing.JTable();
        BtnCancelar = new javax.swing.JButton();
        Btn_removeProd = new javax.swing.JButton();
        Btn_Continuar = new javax.swing.JButton();
        Cbx_ListaProveedores = new javax.swing.JComboBox<>();
        FldCUIT1 = new javax.swing.JTextField();
        Btn_addProd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        FldProd = new javax.swing.JTextField();
        Cbx_ListaProductos = new javax.swing.JComboBox<>();
        FldMontoFinal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Cbx_ListaTipos = new javax.swing.JComboBox<>();
        BtnSugerencias = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        content.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Proveedor:");

        Btn_CargarProv.setText("Cargar");
        Btn_CargarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Btn_CargarProvProvActionPerformed(evt);
            }
        });

        FldNombre.setEditable(false);
        FldNombre.setText("Nombre");
        FldNombre.setPreferredSize(new java.awt.Dimension(81, 20));

        FldCUIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FldCUITActionPerformed(evt);
            }
        });

        FldEmail.setEditable(false);
        FldEmail.setText("Email");
        FldEmail.setPreferredSize(new java.awt.Dimension(144, 20));
        FldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FldEmailActionPerformed(evt);
            }
        });

        FldDomicilio.setEditable(false);
        FldDomicilio.setText("Domicilio");
        FldDomicilio.setPreferredSize(new java.awt.Dimension(421, 20));
        FldDomicilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FldDomicilioActionPerformed(evt);
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

        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        Btn_removeProd.setText("-");
        Btn_removeProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_removeProdActionPerformed(evt);
            }
        });

        Btn_Continuar.setText("Continuar");
        Btn_Continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ContinuarActionPerformed(evt);
            }
        });

        Cbx_ListaProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cbx_ListaProveedoresActionPerformed(evt);
            }
        });

        FldCUIT1.setEditable(false);
        FldCUIT1.setText("CUIT");
        FldCUIT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FldCUIT1ActionPerformed(evt);
            }
        });

        Btn_addProd.setText("+");
        Btn_addProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_addProdActionPerformed(evt);
            }
        });

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

        FldMontoFinal.setEditable(false);

        jLabel3.setText("Monto Final:");

        Cbx_ListaTipos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bolsones", "Bultos Cerrados", "Pallets" }));
        Cbx_ListaTipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cbx_ListaTiposActionPerformed(evt);
            }
        });

        BtnSugerencias.setText("Sugerencias");
        BtnSugerencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSugerenciasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(FldDomicilio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentLayout.createSequentialGroup()
                                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentLayout.createSequentialGroup()
                                        .addComponent(FldCUIT1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(contentLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(33, 33, 33)))
                                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(contentLayout.createSequentialGroup()
                                        .addComponent(FldCUIT, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(Cbx_ListaProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Btn_CargarProv))
                                    .addGroup(contentLayout.createSequentialGroup()
                                        .addComponent(FldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(FldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(contentLayout.createSequentialGroup()
                                    .addComponent(BtnCancelar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Btn_Continuar))
                                .addGroup(contentLayout.createSequentialGroup()
                                    .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(contentLayout.createSequentialGroup()
                                                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(BtnSugerencias)
                                                    .addComponent(jLabel3))
                                                .addGap(18, 18, 18)
                                                .addComponent(FldMontoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                        .addComponent(Btn_addProd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(FldCUIT, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cbx_ListaProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_CargarProv))
                .addGap(12, 12, 12)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(FldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(FldCUIT1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(FldDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(FldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(contentLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Cbx_ListaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(FldProd, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Cbx_ListaTipos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(Btn_addProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btn_removeProd)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FldMontoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Continuar)
                    .addComponent(BtnCancelar)
                    .addComponent(BtnSugerencias))
                .addContainerGap())
        );

        getContentPane().add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_Btn_CargarProvProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Btn_CargarProvProvActionPerformed
        // TODO add your handling code here:
        String textCbx = Cbx_ListaProveedores.getSelectedItem().toString();
        for (Proveedor prov : mapProveedores.values()) {
            if (Long.toString(prov.getCuit()).equals(textCbx) || prov.getNombre().equals(textCbx)) {
                FldCUIT1.setText(Long.toString(prov.getCuit()));
                FldNombre.setText(prov.getNombre());
                FldEmail.setText(prov.getEmail());
                FldDomicilio.setText(prov.getDireccion());
                proveedor = ManagerProveedor.getProveedor(prov.getCuit());
            }
        }
        if (!mapRenglones.isEmpty() && !"CUIT".matches(FldCUIT1.getText())) {
            Btn_Continuar.setEnabled(true);
        }
    }//GEN-LAST:event_Btn_Btn_CargarProvProvActionPerformed

    private void FldCUITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FldCUITActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FldCUITActionPerformed

    private void FldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FldEmailActionPerformed

    private void FldDomicilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FldDomicilioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FldDomicilioActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        MenuAdministrador mv = new MenuAdministrador(this.admin.getCuenta().getCuenta());
        mv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void Btn_removeProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_removeProdActionPerformed
        if (TblRenglones.getSelectedRow() != -1) {
            getMapRenglones().remove(model.getValueAt(TblRenglones.getSelectedRow(), 1).toString());
            model.removeRow(TblRenglones.getSelectedRow());
        }
        else {
            JOptionPane.showMessageDialog(this, "Seleccione un producto", "No se ha seleccionado un producto",JOptionPane.ERROR_MESSAGE);
        }
        if (getMapRenglones().isEmpty() || "CUIT".matches(FldCUIT1.getText())) {
            Btn_Continuar.setEnabled(false);
        }
        updateTable();
    }//GEN-LAST:event_Btn_removeProdActionPerformed

    private void Btn_ContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ContinuarActionPerformed
        // TODO add your handling code here:
        
        AltaPedido_Preview previewWindow = new AltaPedido_Preview(this);
        this.setVisible(false);
        previewWindow.setVisible(true);
    }//GEN-LAST:event_Btn_ContinuarActionPerformed

    private void Cbx_ListaProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cbx_ListaProveedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cbx_ListaProveedoresActionPerformed

    private void FldCUIT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FldCUIT1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FldCUIT1ActionPerformed

    private void Btn_addProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_addProdActionPerformed
        // TODO add your handling code here:
        String cbxText = Cbx_ListaProductos.getSelectedItem().toString();
        String cbxTipo = Cbx_ListaTipos.getSelectedItem().toString();
        if (!mapRenglones.containsKey(cbxText)) {
            switch (cbxTipo) {
                case "Bolsones": getMapRenglones().put(cbxText, new RenglonPedido(getMapProductos().get(cbxText),1,TipoCantidad.Bolsones,0F)); break;
                case "Bultos Cerrados": getMapRenglones().put(cbxText, new RenglonPedido(getMapProductos().get(cbxText),1,TipoCantidad.BultosCerrados,0F)); break;
                case "Pallets": getMapRenglones().put(cbxText, new RenglonPedido(getMapProductos().get(cbxText),1,TipoCantidad.Pallets,0F)); break;
                default: getMapRenglones().put(cbxText, new RenglonPedido(getMapProductos().get(cbxText),1,TipoCantidad.Bolsones,0F)); break;
            }
        }
        else {
            RenglonPedido rp = getMapRenglones().get(cbxText);
            switch (cbxTipo) {
                case "Bolsones": rp.setTipoCantidad(TipoCantidad.Bolsones);; break;
                case "Bultos Cerrados": rp.setTipoCantidad(TipoCantidad.BultosCerrados);; break;
                case "Pallets": rp.setTipoCantidad(TipoCantidad.Pallets);; break;
            }
            getMapRenglones().replace(cbxText, rp);
        }
        if (!mapRenglones.isEmpty() && !"CUIT".matches(FldCUIT1.getText())) {
            Btn_Continuar.setEnabled(true);
        }
        updateTable();
    }//GEN-LAST:event_Btn_addProdActionPerformed

    private void FldProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FldProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FldProdActionPerformed

    private void Cbx_ListaProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cbx_ListaProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cbx_ListaProductosActionPerformed

    private void Cbx_ListaTiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cbx_ListaTiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cbx_ListaTiposActionPerformed

    private void BtnSugerenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSugerenciasActionPerformed
        AltaPedido_Sugerencias aps = new AltaPedido_Sugerencias(this);
        aps.setVisible(true);
    }//GEN-LAST:event_BtnSugerenciasActionPerformed

    private void updateComboboxProveedores(){
        List<String> listaProv = new ArrayList<>();
        for (int i = 0;i<Cbx_ListaProveedores.getItemCount();i++) {
            listaProv.add(Cbx_ListaProveedores.getItemAt(i));
        }
        for (Proveedor p: mapProveedores.values()){
            if (p.getNombre().contains(FldCUIT.getText()) || String.valueOf(p.getCuit()).contains(FldCUIT.getText()) ) {
                if (!listaProv.contains(p.getNombre())) {
                    Cbx_ListaProveedores.addItem(p.getNombre());
                }
            }
            if (listaProv.contains(p.getNombre())) {
                if (!p.getNombre().contains(FldCUIT.getText())) {
                    Cbx_ListaProveedores.removeItem(p.getNombre());
                }
            }
        }
    }
    
    private void updateComboboxProductos(){
        List<String> listaProd = new ArrayList<>();
        for (int i = 0;i<Cbx_ListaProductos.getItemCount();i++) {
            listaProd.add(Cbx_ListaProductos.getItemAt(i));
        }
        for (Producto p: getMapProductos().values()){
            if (p.getNombreP().contains(FldProd.getText())) {
                if (!listaProd.contains(p.getNombreP())) {
                    Cbx_ListaProductos.addItem(p.getNombreP());
                }
            }
            if (listaProd.contains(p.getNombreP())) {
                if (!p.getNombreP().contains(FldProd.getText())) {
                    Cbx_ListaProductos.removeItem(p.getNombreP());
                }
            }
        }
    }
    
    public void updateTable() {
        model = (DefaultTableModel) TblRenglones.getModel();
        while(model.getRowCount() > 0) {
            model.removeRow(0);
        }
        for (RenglonPedido rp: getMapRenglones().values()) {
            model.addRow(new Object[]{rp.getProducto().getCodigoP(),rp.getProducto().getNombreP(), rp.getCantidad(), rp.getTipoCantidad(), rp.getProducto().getPrecioP(), rp.getDescuento(), rp.getMontoTotal()});
        }
        float value = 0;
        for (RenglonPedido rp: getMapRenglones().values()) {
            value += rp.getMontoTotal();
        }
        FldMontoFinal.setText(Float.toString(value));
    }
    
    public Proveedor getProveedor() {
        return proveedor;
    }
    public Administrador getAdministrador() {
        return admin;
    }
    public Map<String, RenglonPedido> getRenglones() {
        return getMapRenglones();
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
            java.util.logging.Logger.getLogger(AltaPedido_Generador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaPedido_Generador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaPedido_Generador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaPedido_Generador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltaPedido_Generador("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnSugerencias;
    private javax.swing.JButton Btn_CargarProv;
    private javax.swing.JButton Btn_Continuar;
    private javax.swing.JButton Btn_addProd;
    private javax.swing.JButton Btn_removeProd;
    private javax.swing.JComboBox<String> Cbx_ListaProductos;
    private javax.swing.JComboBox<String> Cbx_ListaProveedores;
    private javax.swing.JComboBox<String> Cbx_ListaTipos;
    private javax.swing.JTextField FldCUIT;
    private javax.swing.JTextField FldCUIT1;
    private javax.swing.JTextField FldDomicilio;
    private javax.swing.JTextField FldEmail;
    private javax.swing.JTextField FldMontoFinal;
    private javax.swing.JTextField FldNombre;
    private javax.swing.JTextField FldProd;
    private javax.swing.JTable TblRenglones;
    private javax.swing.JPanel content;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the mapProductos
     */
    public Map<String,Producto> getMapProductos() {
        return mapProductos;
    }

    /**
     * @return the mapRenglones
     */
    public Map<String, RenglonPedido> getMapRenglones() {
        return mapRenglones;
    }
}
