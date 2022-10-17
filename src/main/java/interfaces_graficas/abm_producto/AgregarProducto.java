/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces_graficas.abm_producto;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import logica.managers.ManagerProducto;

public class AgregarProducto extends javax.swing.JFrame {

    private List<JTextField> campos = new ArrayList<>();
    
    public AgregarProducto() {
        initComponents();
        AddListener();
        BtnAgregar.setEnabled(false);
    }
    
    private void AddListener() {
        campos.add(FldCodigo);
        campos.add(FldNombre);
        campos.add(FldCategoria);
        campos.add(FldPrecio);
        campos.add(FldStock);
        campos.add(FldStockMinimo);
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
                BtnAgregar.setEnabled(canEnable);
            }
        };
        for (JTextField campo:campos) {
            campo.getDocument().addDocumentListener(listener);
        }
    }
    
    private void limpiarCampos() {
        for (JTextField campo : campos) {
            campo.setText("");
        }
        BtnAgregar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FldNombre = new javax.swing.JTextField();
        FldCategoria = new javax.swing.JTextField();
        FldPrecio = new javax.swing.JTextField();
        FldStockMinimo = new javax.swing.JTextField();
        FldStock = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        FldCodigo = new javax.swing.JTextField();
        BtnAgregar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        FldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FldNombreKeyTyped(evt);
            }
        });

        FldCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FldCategoriaKeyTyped(evt);
            }
        });

        FldPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FldPrecioKeyTyped(evt);
            }
        });

        FldStockMinimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FldStockMinimoKeyTyped(evt);
            }
        });

        FldStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FldStockKeyTyped(evt);
            }
        });

        jLabel1.setText("Codigo");

        jLabel2.setText("Nombre");

        jLabel4.setText("Stock");

        jLabel3.setText("Categoria");

        jLabel5.setText("Stock Minimo");

        jLabel6.setText("Precio");

        FldCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FldCodigoKeyTyped(evt);
            }
        });

        BtnAgregar.setText("Agregar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(FldStockMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel6))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(FldStock)
                                .addComponent(FldCategoria)
                                .addComponent(FldNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(FldCodigo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(FldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                        .addComponent(BtnAgregar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(FldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FldCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FldStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FldStockMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCancelar)
                    .addComponent(BtnAgregar))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        if (ManagerProducto.cargarProducto(FldCodigo.getText(),FldNombre.getText(),FldCategoria.getText(),FldPrecio.getText(),FldStock.getText(),FldStockMinimo.getText())) {
            JOptionPane.showMessageDialog(this, "Se ha cargado el producto en el sistema", "Exito en Alta de Producto", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
        }
        else {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error en la carga,\nya existe un producto con ese codigo o nombre", "Falla en Alta de Producto",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void FldCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FldCodigoKeyTyped
        char c = evt.getKeyChar();
        if (FldCodigo.getText().length() > 8 || !Character.isDigit(c)) evt.consume();
    }//GEN-LAST:event_FldCodigoKeyTyped

    private void FldNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FldNombreKeyTyped
        char c = evt.getKeyChar();
        if (FldNombre.getText().length() > 512 || (!Character.isLetterOrDigit(c) && c != ' ')) evt.consume();
        if (FldNombre.getText().isEmpty() && c == ' ') evt.consume();
    }//GEN-LAST:event_FldNombreKeyTyped

    private void FldCategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FldCategoriaKeyTyped
        char c = evt.getKeyChar();
        if (FldCategoria.getText().length() > 512 || (!Character.isLetterOrDigit(c) && c != ' ')) evt.consume();
        if (FldCategoria.getText().isEmpty() && c == ' ') evt.consume();
    }//GEN-LAST:event_FldCategoriaKeyTyped

    private void FldStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FldStockKeyTyped
        char c = evt.getKeyChar();
        if (FldStock.getText().length() > 8 || !Character.isDigit(c)) evt.consume();
    }//GEN-LAST:event_FldStockKeyTyped

    private void FldStockMinimoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FldStockMinimoKeyTyped
        char c = evt.getKeyChar();
        if (FldStockMinimo.getText().length() > 8 || !Character.isDigit(c)) evt.consume();
    }//GEN-LAST:event_FldStockMinimoKeyTyped

    private void FldPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FldPrecioKeyTyped
        char text[] = FldPrecio.getText().toCharArray();
        char c = evt.getKeyChar();
        int count = 0;
        for (int i = 0; i < text.length; i++) {
            if (text[i] == '.') {
                count++;
            }
        }
        if (!Character.isDigit(c) && c == '.' && count >= 1) evt.consume();
        if (!Character.isDigit(c) && c != '.') evt.consume();
        
        String[] partes = FldPrecio.getText().split("[.]",2);
        if (partes.length > 1) {
            if (partes[1].length() > 1) evt.consume();
            if (partes[0].length() > 10) evt.consume();
        }
        else if (FldPrecio.getText().length() > 15) evt.consume();
    }//GEN-LAST:event_FldPrecioKeyTyped

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        abm_producto abm = new abm_producto();
        this.setVisible(false);
        abm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JTextField FldCategoria;
    private javax.swing.JTextField FldCodigo;
    private javax.swing.JTextField FldNombre;
    private javax.swing.JTextField FldPrecio;
    private javax.swing.JTextField FldStock;
    private javax.swing.JTextField FldStockMinimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
