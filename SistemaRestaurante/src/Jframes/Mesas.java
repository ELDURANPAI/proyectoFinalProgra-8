package Jframes;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import sistemarestaurante.ConexionBD;

public class Mesas extends javax.swing.JFrame {

    public void ConsultarMeseros() {
        ConexionBD conexion = new ConexionBD();
        ResultSet resultado = null;
        DefaultTableModel md = new DefaultTableModel();
        md.setColumnIdentifiers(new Object[]{"Mesa", "Capacidad", "Estado", "Nombre"});

        try {
            //Abrir conexion
            conexion.setConexion();
            //definimos la consulta
            conexion.setConsulta("SELECT * FROM mesas");
            //Obtenemos todos los resultados de la consulta
            resultado = conexion.getResultado();
            while (resultado.next()) {
                String mesa = resultado.getString("mesa");
                String capacidad = resultado.getString("capacidad");
                String estado = resultado.getString("estado");
                String nombre = resultado.getString("nombre");

                md.addRow(new Object[]{
                    resultado.getString("mesa"),
                    resultado.getString("capacidad"),
                    resultado.getString("estado"),
                    resultado.getString("nombre")});
                mesas.setModel(md);
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
            conexion.setConsulta("DELETE FROM mesas");
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

    public void agregarDatos() { // metodo para guardar y agregar los datos de la tabla
        ConexionBD conexion = new ConexionBD();
        ResultSet resultado = null;

        DefaultTableModel modelo = (DefaultTableModel) mesas.getModel();
        int filas = modelo.getRowCount();

        try {
            //Abrir conexion
            conexion.setConexion();
            // definimos la consulta
            conexion.setConsulta("INSERT INTO mesas (mesa, capacidad, estado, nombre) VALUES (?, ?, ?, ?)");

            for (int i = 0; i < filas; i++) {
                conexion.getConsulta().setString(1, String.valueOf(modelo.getValueAt(i, 0)));
                conexion.getConsulta().setString(2, String.valueOf(modelo.getValueAt(i, 1)));
                conexion.getConsulta().setString(3, String.valueOf(modelo.getValueAt(i, 2)));
                conexion.getConsulta().setString(4, String.valueOf(modelo.getValueAt(i, 3)));

                conexion.getConsulta().executeUpdate();
            }
            JOptionPane.showMessageDialog(this, "Datos guardados en la base de datos correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar en base de datos: " + e.getMessage());
        }
    }

    public Mesas() {
        initComponents();
        ConsultarMeseros();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVerSalon = new javax.swing.JButton();
        Titulo = new javax.swing.JLabel();
        btnGuardarDatos = new javax.swing.JButton();
        btnAgregarFila = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        mesas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnVerSalon.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnVerSalon.setText("Ver salon");
        btnVerSalon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerSalonActionPerformed(evt);
            }
        });

        Titulo.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        Titulo.setLabelFor(this);
        Titulo.setText("Personal Mesas");

        btnGuardarDatos.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnGuardarDatos.setText("Guardar Datos");
        btnGuardarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDatosActionPerformed(evt);
            }
        });

        btnAgregarFila.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnAgregarFila.setText("Agregar Mesa");
        btnAgregarFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFilaActionPerformed(evt);
            }
        });

        btnRegresar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        mesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Mesa", "Capacidad", "Estado", "Nombre"
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAgregarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerSalon, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Titulo)
                .addGap(348, 348, 348))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(btnVerSalon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnAgregarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnGuardarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDatosActionPerformed
        eliminarDatos();
        agregarDatos();
    }//GEN-LAST:event_btnGuardarDatosActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Menu abrir = new Menu();
        abrir.setVisible(true);
        abrir.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAgregarFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFilaActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel) mesas.getModel();

        // Crear una fila vacía con la cantidad de columnas actuales
        Object[] filaVacia = new Object[modelo.getColumnCount()];

        // Agregar la fila al modelo
        modelo.addRow(filaVacia);
    }//GEN-LAST:event_btnAgregarFilaActionPerformed

    private void btnVerSalonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerSalonActionPerformed
        Salon abrirSalon = new Salon();
        abrirSalon.setVisible(true);
        abrirSalon.setLocationRelativeTo(null);
        this.dispose(); 
    }//GEN-LAST:event_btnVerSalonActionPerformed

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
            java.util.logging.Logger.getLogger(Mesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mesas().setVisible(true);
            }
        });
    }

    //noooo

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton btnAgregarFila;
    private javax.swing.JButton btnGuardarDatos;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVerSalon;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable mesas;
    // End of variables declaration//GEN-END:variables
}
