package Jframes;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import sistemarestaurante.ConexionBD;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Harry Orozco
 */
public class AgregarMenu extends javax.swing.JFrame {

    /**
     * Creates new form AgregarMenu
     */
    
        public void ConsultarPlatillos() {
        ConexionBD conexion = new ConexionBD();
        ResultSet resultado = null;
        DefaultTableModel md = new DefaultTableModel();
        md.setColumnIdentifiers(new Object[]{"Nombre", "Tipo", "Vasos", "Precio"});
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
                String vasos = resultado.getString("vasos");
                String nombre = resultado.getString("nombre");

                md.addRow(new Object[]{
                    resultado.getString("nombre"),
                    resultado.getString("tipo"),
                    resultado.getString("precio"),
                    resultado.getString("vasos")});
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

    public void agregarDatos() {
    ConexionBD conexion = new ConexionBD();
    ResultSet resultado = null;
    DefaultTableModel modelo = (DefaultTableModel) platillos1.getModel(); 
    int filas = modelo.getRowCount();
    try {
        conexion.setConexion();
        conexion.setConsulta("INSERT INTO menu(nombre, tipo, precio, vasos) VALUES (?, ?, ?, ?)");
        for (int i = 0; i < filas; i++) {
            conexion.getConsulta().setString(1, String.valueOf(modelo.getValueAt(i, 0))); 
            conexion.getConsulta().setString(2, String.valueOf(modelo.getValueAt(i, 1))); 
            conexion.getConsulta().setString(3, String.valueOf(modelo.getValueAt(i, 3)));
            conexion.getConsulta().setString(4, String.valueOf(modelo.getValueAt(i, 2))); 
            conexion.getConsulta().executeUpdate();
        }
        JOptionPane.showMessageDialog(this, "Datos guardados en la base de datos correctamente.");
        conexion.cerrarConexion();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al guardar en base de datos: " + e.getMessage());
    }
}
    public String toString() {
        DefaultTableModel modelo = (DefaultTableModel) platillos1.getModel();
        int filas = modelo.getRowCount();
        String resultado = "Factura:\n";
        int contadorVasos = 0;
        resultado += "Numero de vasos agregados: ";
        for (int i = 0; i < filas; i++) {
            try {
                int vasos = Integer.parseInt(String.valueOf(modelo.getValueAt(i, 2)));
                contadorVasos += vasos;
            } catch (NumberFormatException e) {
            }
        }
        resultado += contadorVasos + "\n";
        resultado += "Lista de vasos: ";
        for (int i = 0; i < filas; i++) {
            String vasosS = String.valueOf(modelo.getValueAt(i, 2));
            resultado += vasosS;
            if (i < filas - 1) {
                resultado += ", ";
            }
        }
        resultado += "\n\nNumero de platillos agregados: " + filas + "\n";
        resultado += "Lista de platillos:\n";
        for (int i = 0; i < filas; i++) {
            String nombre = String.valueOf(modelo.getValueAt(i, 0));
            String tipo = String.valueOf(modelo.getValueAt(i, 1));
            String precio = String.valueOf(modelo.getValueAt(i, 3));
            resultado += (i + 1) + ") ";
            resultado += "Nombre: " + nombre + "";
            resultado += "Tipo: " + tipo + "";
            resultado += "Precio: " + precio + "\n";
        }

        return resultado;
    }
    
    public AgregarMenu() {
        initComponents();
        ConsultarPlatillos();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        mesas = new javax.swing.JTable();
        Titulo = new javax.swing.JLabel();
        btnAgregarFila = new javax.swing.JButton();
        btnGuardarDatos = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        platillos1 = new javax.swing.JTable();

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
        btnGuardarDatos.setText("Guardar Datos");
        btnGuardarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDatosActionPerformed(evt);
            }
        });

        btnRegresar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        platillos1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(platillos1);

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
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(31, 31, 31)
                        .addComponent(btnAgregarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnGuardarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
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

    private void btnGuardarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDatosActionPerformed
        eliminarDatos();
        agregarDatos();
        JOptionPane.showMessageDialog(null, toString(), "Factura", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnGuardarDatosActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Menu abrir = new Menu();
        abrir.setVisible(true);
        abrir.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

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
    private javax.swing.JButton btnGuardarDatos;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable mesas;
    private javax.swing.JTable platillos1;
    // End of variables declaration//GEN-END:variables
}
