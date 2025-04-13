package Jframes;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import sistemarestaurante.ConexionBD;

public class AgregarMenu extends javax.swing.JFrame {
    
    public AgregarMenu() {
        initComponents();
        ConsultarPlatillos();  
    }
    
    public void ConsultarPlatillos() {
        ConexionBD conexion = new ConexionBD();
        ResultSet resultado = null;
        DefaultTableModel md = new DefaultTableModel();
        md.setColumnIdentifiers(new Object[]{"Nombre", "Tipo", "Precio"});
        try {
            //Abrir conexion
            conexion.setConexion();
            //definimos la consulta
            conexion.setConsulta("SELECT * FROM menu");
            //Obtenemos todos los resultados de la consulta
            resultado = conexion.getResultado();
            while (resultado.next()) {
                String tipo = resultado.getString("tipo");
                String precio = resultado.getString("precio");
                String nombre = resultado.getString("nombre");

                md.addRow(new Object[]{
                    resultado.getString("nombre"),
                    resultado.getString("tipo"),
                    resultado.getString("precio")});
                platillos1.setModel(md);
            }
            conexion.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarDatos() {
        ConexionBD conexion = new ConexionBD();
        try {
            //Abrir conexion
            conexion.setConexion();
            // Seleccionamos la tabla meseros y eliminamos el id
            conexion.setConsulta("DELETE FROM menu");
            // actualiza
            if (conexion.getConsulta().executeUpdate() > 0) {
            } else {
                JOptionPane.showMessageDialog(null, "datos no eliminados",
                        "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
            // cerrar conexion
            conexion.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean agregarDatos() {
        ConexionBD conexion = new ConexionBD();
        DefaultTableModel modelo = (DefaultTableModel) platillos1.getModel();
        int filas = modelo.getRowCount();

        try {
            conexion.setConexion();
            conexion.setConsulta("INSERT INTO menu(nombre, tipo, precio) VALUES (?, ?, ?)");

            for (int i = 0; i < filas; i++) {
                String nombre = String.valueOf(modelo.getValueAt(i, 0)).trim();
                String tipo = String.valueOf(modelo.getValueAt(i, 1)).trim();
                String precioStr = String.valueOf(modelo.getValueAt(i, 2)).trim();

                if (nombre.isEmpty() || tipo.isEmpty() || precioStr.isEmpty()) {
                    JOptionPane.showMessageDialog(this,
                            "Faltan datos en la fila " + (i + 1),
                            "Error de validación",
                            JOptionPane.ERROR_MESSAGE);
                    conexion.cerrarConexion();
                    return false;
                }

                try {
                    double precio = Double.parseDouble(precioStr);
                    if (precio <= 0) throw new NumberFormatException();
                    conexion.getConsulta().setString(1, nombre);
                    conexion.getConsulta().setString(2, tipo);
                    conexion.getConsulta().setDouble(3, precio);
                    conexion.getConsulta().executeUpdate();
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this,
                            "El precio en la fila " + (i + 1) + " no es válido.",
                            "Error de validación",
                            JOptionPane.ERROR_MESSAGE);
                    conexion.cerrarConexion();
                    return false;
                }
            }

            conexion.cerrarConexion();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error SQL: " + e.getMessage());
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        mesas = new javax.swing.JTable();
        Titulo = new javax.swing.JLabel();
        btnAgregarFila = new javax.swing.JButton();
        btnGuardarDatos = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        platillos1 = new javax.swing.JTable();
        btnEliminarPlatillo = new javax.swing.JButton();

        mesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Tipo", "Vasos", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(mesas);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Titulo.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        Titulo.setText("Menu Platillos");

        btnAgregarFila.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnAgregarFila.setText("Agregar Platillo");
        btnAgregarFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFilaActionPerformed(evt);
            }
        });

        btnGuardarDatos.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnGuardarDatos.setText("Guardar Platillo");
        btnGuardarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDatosActionPerformed(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        platillos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Nombre", "Tipo", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(platillos1);

        btnEliminarPlatillo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnEliminarPlatillo.setText("Eliminar Platillo");
        btnEliminarPlatillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPlatilloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Titulo)
                .addGap(348, 348, 348))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarPlatillo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(Titulo)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(42, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnEliminarPlatillo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnGuardarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFilaActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel) platillos1.getModel();

        // Crear una fila vacía con la cantidad de columnas actuales
        Object[] filaVacia = new Object[modelo.getColumnCount()];

        // Agregar la fila al modelo
        modelo.addRow(filaVacia);
    }//GEN-LAST:event_btnAgregarFilaActionPerformed

    public String generarResumenFactura() {
        DefaultTableModel modelo = (DefaultTableModel) platillos1.getModel();
        int filas = modelo.getRowCount();
        StringBuilder resultado = new StringBuilder("Menu:\n\n");

        resultado.append("Platillos agregados: ").append(filas).append("\n\n");

        for (int i = 0; i < filas; i++) {
            String nombre = String.valueOf(modelo.getValueAt(i, 0));
            String tipo = String.valueOf(modelo.getValueAt(i, 1));
            String precio = String.valueOf(modelo.getValueAt(i, 2));

            resultado.append((i + 1)).append(") ");
            resultado.append("Nombre: ").append(nombre).append(" | ");
            resultado.append("Tipo: ").append(tipo).append(" | ");
            resultado.append("Precio: ").append(precio).append("₡\n");
        }

        return resultado.toString();
    }
    
    private void btnGuardarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDatosActionPerformed
        eliminarDatos();
        boolean exito = agregarDatos();
        
        if(exito){
            JOptionPane.showMessageDialog(this, generarResumenFactura(), "Factura", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarDatosActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Menu abrir = new Menu();
        abrir.setVisible(true);
        abrir.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnEliminarPlatilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPlatilloActionPerformed
        int filaSeleccionada = platillos1.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un platillo para eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nombrePlatillo = String.valueOf(platillos1.getValueAt(filaSeleccionada, 0));

        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el platillo \"" + nombrePlatillo + "\"?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            ConexionBD conexion = new ConexionBD();
            try {
                conexion.setConexion();
                conexion.setConsulta("DELETE FROM menu WHERE nombre = ?");
                conexion.getConsulta().setString(1, nombrePlatillo);
                int filasAfectadas = conexion.getConsulta().executeUpdate();
                conexion.cerrarConexion();

                if (filasAfectadas > 0) {
                    DefaultTableModel modelo = (DefaultTableModel) platillos1.getModel();
                    modelo.removeRow(filaSeleccionada);
                    JOptionPane.showMessageDialog(this, "Platillo eliminado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar el platillo de la base de datos.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al eliminar el platillo: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEliminarPlatilloActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton btnAgregarFila;
    private javax.swing.JButton btnEliminarPlatillo;
    private javax.swing.JButton btnGuardarDatos;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable mesas;
    private javax.swing.JTable platillos1;
    // End of variables declaration//GEN-END:variables
}
