/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces_graficas.buscar_venta;

import interfaces_graficas.menus.MenuAdministrador;
import interfaces_graficas.menus.MenuVendedor;
import logica.managers.ManagerVenta;
import objects.Venta;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;

/**
 *
 * @author tovib
 */
public class BuscarVenta extends javax.swing.JFrame {
    private static HashMap<String, Venta> listaVentas = new HashMap<>();
    private int tipo;

    private String usuario;
    private DefaultTableModel model;
    
    /**
     * Creates new form BuscarVenta
     */
    public BuscarVenta(String usuario, int tipo) {
        initComponents();
        this.tipo = tipo;
        this.usuario = usuario;
        listaVentas = ManagerVenta.getAllVentas();
        addList();
        updateTabla(listaVentas);
    }

    public void updateTabla(HashMap<String, Venta> localList ) {
        model = (DefaultTableModel) this.tabla_ventas.getModel();
        /** LIMPIAR TABLA*/
        while (model.getRowCount()>0){
            model.removeRow(0);
        }
        /** CARGAR  TABLA*/
        for (Venta venta: localList.values()) {
            String cerrada = "";
            if (venta.getCerradaV()){
                cerrada = "Cerrada";
            } else {
                cerrada = "Abierta";
            }
            model.addRow(new Object[]{venta.getCodigoV(), venta.getCuentaVendedor(), cerrada, venta.getMontoV(),venta.getHoraV(),venta.getFechaV()});
        }
    }
    public HashMap<String, Venta> coincidencia () {
        HashMap<String, Venta> map = new HashMap<>();
        for (Venta v : listaVentas.values()) {
            if (String.valueOf(v.getCodigoV()).contains(buscador_venta.getText())) {
                map.put(String.valueOf(v.getCodigoV()),v);
            }
        }
        return map;
    }

    public void addList(){
        buscador_venta.getDocument().addDocumentListener(new DocumentListener() {
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


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buscador_venta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_ventas = new javax.swing.JTable();
        boton_mostar = new javax.swing.JButton();
        boton_salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Buscardor");

        tabla_ventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Vendedor", "Estado ", "Monto", "Hora", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(tabla_ventas);

        boton_mostar.setText("Mostrar");
        boton_mostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_mostarActionPerformed(evt);
            }
        });

        boton_salir.setText("Salir");
        boton_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buscador_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(332, 332, 332))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(boton_salir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boton_mostar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscador_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_mostar)
                    .addComponent(boton_salir))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_mostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_mostarActionPerformed
        // TODO add your handling code here:
        if (tabla_ventas.getSelectedRow() != -1) {
            MostrarVenta mv = new MostrarVenta(listaVentas.get(model.getValueAt(tabla_ventas.getSelectedRow(),0).toString()));
            mv.setVisible(true);

        } else {
            // seleccione algo
        }
    }//GEN-LAST:event_boton_mostarActionPerformed

    private void boton_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_salirActionPerformed
        // TODO add your handling code here:
        if (this.tipo == 0) { //Vendedor
            MenuVendedor mv = new MenuVendedor(this.usuario);
            mv.setVisible(true);

        } else { //Administrador
            MenuAdministrador ma = new MenuAdministrador(this.usuario);
            ma.setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_boton_salirActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarVenta("",-1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_mostar;
    private javax.swing.JButton boton_salir;
    private javax.swing.JTextField buscador_venta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_ventas;
    // End of variables declaration//GEN-END:variables
}