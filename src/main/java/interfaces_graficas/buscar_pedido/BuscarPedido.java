/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces_graficas.buscar_pedido;
import interfaces_graficas.ModificarPedido.ModificarPedido;
import interfaces_graficas.VerPedido.VerPedido;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import interfaces_graficas.menus.MenuAdministrador;
import interfaces_graficas.baja_pedido.BajaPedido_Preview;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import logica.managers.ManagerPedido;
import objects.Pedido;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import logica.managers.ManagerProveedor;
import objects.Proveedor;

/**
 *
 * @author Cell9870
 */
public class BuscarPedido extends javax.swing.JFrame {

    private Map<Long,Proveedor> mapProveedores = new HashMap<>();
    private Map<Integer,Pedido> mapPedidos = new HashMap<>();
    private DefaultTableModel model;
    private String username;
    
    public BuscarPedido(String username) {
        initComponents();
        addListeners();
        DateDesde.setDateFormatString("yyyy-MM-dd");
        DateHasta.setDateFormatString("yyyy-MM-dd");
        this.username = username;
        mapPedidos = ManagerPedido.getMapPedidos();
        mapProveedores = ManagerProveedor.getProveedoresMap();
        updateComboboxProveedores();
        updateTable(false);
        
    }

    private void addListeners() {
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
    }
    
    private void updateComboboxProveedores() {
        List<String> listaProv = new ArrayList<>();
        for (int i = 0;i<Cbx_ListaProveedores.getItemCount();i++) {
            listaProv.add(Cbx_ListaProveedores.getItemAt(i));
        }
        for (Proveedor p: mapProveedores.values()){
            if (p.getNombre().toUpperCase().contains(FldCUIT.getText().toUpperCase()) || String.valueOf(p.getCuit()).contains(FldCUIT.getText()) ) {
                if (!listaProv.contains(p.getNombre())) {
                    Cbx_ListaProveedores.addItem(p.getNombre());
                }
            }
            if (listaProv.contains(p.getNombre())) {
                if (!p.getNombre().toUpperCase().contains(FldCUIT.getText().toUpperCase())) {
                    Cbx_ListaProveedores.removeItem(p.getNombre());
                }
            }
        }
        if (!Cbx_ListaProveedores.getItemAt(0).equals("Ninguno")) Cbx_ListaProveedores.insertItemAt("Ninguno", 0);
        Cbx_ListaProveedores.setSelectedIndex(0);
    }
    
    private void updateTable(Boolean filtrado) {
        model = (DefaultTableModel) TblPedidos.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        boolean meetFilters;
        
        for (Pedido p: mapPedidos.values()) {
            meetFilters = true;
            if (filtrado) {
                if (!FldCodigoPedido.getText().isBlank() && !String.valueOf(p.getCodigo()).equals(FldCodigoPedido.getText())) meetFilters = false;
                if (Cbx_ListaProveedores.getSelectedItem() != null) {
                    String str = Cbx_ListaProveedores.getSelectedItem().toString();
                    if (!str.equals("Ninguno") && !p.getProv().getNombre().equals(str)) meetFilters = false;
                }
                try {
                    LocalDate fechaDesde = DateDesde.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    LocalDate fechaHasta = DateHasta.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    LocalDate fechaPedido = p.getFechaPedido();
                    if (fechaPedido.compareTo(fechaDesde)<0 || fechaPedido.compareTo(fechaHasta)>0) meetFilters = false;
                } catch (NullPointerException ex) {
                }
            }

            if (meetFilters) {
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setPreferredSize(new java.awt.Dimension(800, 520));

        jLabel1.setText("Buscar por Proveedor: ");

        FldCUIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FldCUITActionPerformed(evt);
            }
        });

        Cbx_ListaProveedores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno" }));
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

        jLabel4.setText("Desde:");

        jLabel5.setText("Hasta:");

        jLabel6.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel6.setText("Buscar Pedido");

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(40, 40, 40)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentLayout.createSequentialGroup()
                                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(contentLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(DateDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(FldCUIT, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(contentLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(DateHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Cbx_ListaProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(contentLayout.createSequentialGroup()
                                .addComponent(FldCodigoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentLayout.createSequentialGroup()
                        .addComponent(BtnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnEliminarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnModificarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnVerPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(contentLayout.createSequentialGroup()
                .addGap(349, 349, 349)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(FldCodigoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FldCUIT, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cbx_ListaProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3))
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DateDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(BtnBuscar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(DateHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnEliminarPedido)
                    .addComponent(BtnModificarPedido)
                    .addComponent(BtnGoBack)
                    .addComponent(BtnVerPedido))
                .addContainerGap())
        );

        getContentPane().add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FldCodigoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FldCodigoPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FldCodigoPedidoActionPerformed

    private void Cbx_ListaProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cbx_ListaProveedoresActionPerformed
        
    }//GEN-LAST:event_Cbx_ListaProveedoresActionPerformed

    private void FldCUITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FldCUITActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FldCUITActionPerformed

    private void BtnVerPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVerPedidoActionPerformed
        int row = TblPedidos.getSelectedRow();
        if (row != -1) {
            Pedido p = mapPedidos.get((Integer) TblPedidos.getValueAt(row, 0));
            VerPedido vp = new VerPedido(p, username);
            vp.setVisible(true);
            this.setVisible(false);
            this.dispose();
        }
        else JOptionPane.showMessageDialog(content, "Seleccione un pedido","Pedido no seleccionado",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_BtnVerPedidoActionPerformed

    private void BtnModificarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarPedidoActionPerformed
        int row = TblPedidos.getSelectedRow();
        if (row != -1) {
            Pedido p = mapPedidos.get((Integer) TblPedidos.getValueAt(row, 0));
            ModificarPedido mp = new ModificarPedido(username, p);
            this.dispose();
            this.setVisible(false);
            mp.setVisible(true);
        }
        else JOptionPane.showMessageDialog(content, "Seleccione un pedido","Pedido no seleccionado",JOptionPane.ERROR_MESSAGE);
        
    }//GEN-LAST:event_BtnModificarPedidoActionPerformed

    private void BtnEliminarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarPedidoActionPerformed
        int row = TblPedidos.getSelectedRow();
        if (row != -1) {
            Pedido p = mapPedidos.get((Integer) TblPedidos.getValueAt(row, 0));
            BajaPedido_Preview bp = new BajaPedido_Preview(p, username);
            bp.setVisible(true);
            this.setVisible(false);
            this.dispose();
        }
        else JOptionPane.showMessageDialog(content, "Seleccione un pedido","Pedido no seleccionado",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_BtnEliminarPedidoActionPerformed

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        try {
            LocalDate fechaDesde = DateDesde.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate fechaHasta = DateHasta.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (fechaHasta.compareTo(fechaDesde) < 0) {
                JOptionPane.showMessageDialog(content, "La fecha-hasta es anterior a la fecha-desde,\nintente nuevamente","Fechas incorrectas",JOptionPane.ERROR_MESSAGE);
                updateTable(false);
            }
            else updateTable(true);
        } catch (NullPointerException ex) {
            if ((DateDesde.getDate()!=null && DateHasta.getDate()==null)||(DateDesde.getDate()==null && DateHasta.getDate()!=null)) {
                JOptionPane.showMessageDialog(content, "Seleccione ambas fechas","Una de las fechas es nula",JOptionPane.ERROR_MESSAGE);
                updateTable(false);
            }
            else if (DateDesde.getDate() == null && DateHasta.getDate()==null) updateTable(true);
        }
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
