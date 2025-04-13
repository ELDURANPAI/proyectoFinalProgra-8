/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframes;

import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import sistemarestaurante.ConexionBD;
import java.sql.SQLException;
import javax.swing.JButton;


/**
 *
 * @author plast Prueba
 */
public class Salon extends javax.swing.JFrame {

    public Salon() {
        initComponents();
        inicializarMesas();       // Pone todas en rojo
        marcarMesasOcupadas();    // Corrige a verde si están ocupadas en BD
    }
    
    private void inicializarMesas() {
        JButton[] botones = {
            btnMesa1, btnMesa2, btnMesa3, btnMesa4,
            btnMesa5, btnMesa6, btnMesa7, btnMesa8,
            btnMesa9, btnMesa10, btnMesa11, btnMesa12
        };

        for (JButton btn : botones) {
            btn.setBackground(Color.RED); // Estado inicial: mesa vacía
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanelPrincipal = new javax.swing.JPanel();
        JPanelBotones = new javax.swing.JPanel();
        btnMesa1 = new javax.swing.JButton();
        btnMesa2 = new javax.swing.JButton();
        btnMesa3 = new javax.swing.JButton();
        btnMesa4 = new javax.swing.JButton();
        btnMesa5 = new javax.swing.JButton();
        btnMesa6 = new javax.swing.JButton();
        btnMesa7 = new javax.swing.JButton();
        btnMesa8 = new javax.swing.JButton();
        btnMesa9 = new javax.swing.JButton();
        btnMesa10 = new javax.swing.JButton();
        btnMesa11 = new javax.swing.JButton();
        btnMesa12 = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        imagenDeFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JPanelPrincipal.setMaximumSize(new java.awt.Dimension(960, 580));
        JPanelPrincipal.setMinimumSize(new java.awt.Dimension(960, 580));
        JPanelPrincipal.setPreferredSize(new java.awt.Dimension(960, 580));
        JPanelPrincipal.setLayout(null);

        JPanelBotones.setOpaque(false);
        JPanelBotones.setLayout(new java.awt.GridLayout(3, 3, 10, 10));

        btnMesa1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnMesa1.setText("Mesa 1");
        btnMesa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa1ActionPerformed(evt);
            }
        });
        JPanelBotones.add(btnMesa1);

        btnMesa2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnMesa2.setText("Mesa 2");
        btnMesa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa2ActionPerformed(evt);
            }
        });
        JPanelBotones.add(btnMesa2);

        btnMesa3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnMesa3.setText("Mesa 3");
        btnMesa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa3ActionPerformed(evt);
            }
        });
        JPanelBotones.add(btnMesa3);

        btnMesa4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnMesa4.setText("Mesa 4");
        btnMesa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa4ActionPerformed(evt);
            }
        });
        JPanelBotones.add(btnMesa4);

        btnMesa5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnMesa5.setText("Mesa 5");
        btnMesa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa5ActionPerformed(evt);
            }
        });
        JPanelBotones.add(btnMesa5);

        btnMesa6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnMesa6.setText("Mesa 6");
        btnMesa6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa6ActionPerformed(evt);
            }
        });
        JPanelBotones.add(btnMesa6);

        btnMesa7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnMesa7.setText("Mesa 7");
        btnMesa7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa7ActionPerformed(evt);
            }
        });
        JPanelBotones.add(btnMesa7);

        btnMesa8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnMesa8.setText("Mesa 8");
        btnMesa8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa8ActionPerformed(evt);
            }
        });
        JPanelBotones.add(btnMesa8);

        btnMesa9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnMesa9.setText("Mesa 9");
        btnMesa9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa9ActionPerformed(evt);
            }
        });
        JPanelBotones.add(btnMesa9);

        btnMesa10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnMesa10.setText("Mesa 10");
        btnMesa10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa10ActionPerformed(evt);
            }
        });
        JPanelBotones.add(btnMesa10);

        btnMesa11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnMesa11.setText("Mesa 11");
        btnMesa11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa11ActionPerformed(evt);
            }
        });
        JPanelBotones.add(btnMesa11);

        btnMesa12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnMesa12.setText("Mesa 12");
        btnMesa12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa12ActionPerformed(evt);
            }
        });
        JPanelBotones.add(btnMesa12);

        JPanelPrincipal.add(JPanelBotones);
        JPanelBotones.setBounds(70, 90, 790, 350);

        titulo.setBackground(new java.awt.Color(255, 255, 255));
        titulo.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("Salon (Mesas del Restaurante)");
        JPanelPrincipal.add(titulo);
        titulo.setBounds(20, 20, 520, 47);

        btnVolver.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        JPanelPrincipal.add(btnVolver);
        btnVolver.setBounds(340, 460, 250, 60);

        imagenDeFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/icono3.jpg"))); // NOI18N
        imagenDeFondo.setMaximumSize(new java.awt.Dimension(960, 580));
        imagenDeFondo.setMinimumSize(new java.awt.Dimension(960, 580));
        imagenDeFondo.setPreferredSize(new java.awt.Dimension(960, 580));
        JPanelPrincipal.add(imagenDeFondo);
        imagenDeFondo.setBounds(0, 0, 960, 580);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 944, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 541, Short.MAX_VALUE)
        );

        setBounds(0, 0, 960, 580);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMesa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa1ActionPerformed
        gestionarMesa(btnMesa1, "1");
    }//GEN-LAST:event_btnMesa1ActionPerformed

    private void btnMesa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa2ActionPerformed
        gestionarMesa(btnMesa2, "2");
    }//GEN-LAST:event_btnMesa2ActionPerformed

    private void btnMesa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa3ActionPerformed
         gestionarMesa(btnMesa3, "3");
    }//GEN-LAST:event_btnMesa3ActionPerformed

    private void btnMesa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa4ActionPerformed
         gestionarMesa(btnMesa4, "4");
    }//GEN-LAST:event_btnMesa4ActionPerformed

    private void btnMesa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa5ActionPerformed
         gestionarMesa(btnMesa5, "5");
    }//GEN-LAST:event_btnMesa5ActionPerformed

    private void btnMesa6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa6ActionPerformed
         gestionarMesa(btnMesa6, "6");
    }//GEN-LAST:event_btnMesa6ActionPerformed

    private void btnMesa7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa7ActionPerformed
         gestionarMesa(btnMesa7, "7");
    }//GEN-LAST:event_btnMesa7ActionPerformed

    private void btnMesa8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa8ActionPerformed
         gestionarMesa(btnMesa8, "8");
    }//GEN-LAST:event_btnMesa8ActionPerformed

    private void btnMesa9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa9ActionPerformed
         gestionarMesa(btnMesa9, "9");
    }//GEN-LAST:event_btnMesa9ActionPerformed

    private void btnMesa10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa10ActionPerformed
         gestionarMesa(btnMesa10, "10");
    }//GEN-LAST:event_btnMesa10ActionPerformed

    private void btnMesa11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa11ActionPerformed
         gestionarMesa(btnMesa11, "11");
    }//GEN-LAST:event_btnMesa11ActionPerformed

    private void btnMesa12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa12ActionPerformed
         gestionarMesa(btnMesa12, "12");
    }//GEN-LAST:event_btnMesa12ActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Menu volverMenu = new Menu();
        volverMenu.setVisible(true);
        volverMenu.setLocationRelativeTo(null);
        this.dispose();              
    }//GEN-LAST:event_btnVolverActionPerformed

    private void gestionarMesa(JButton boton, String numeroMesa) {
        if (mesaYaOcupada(numeroMesa)) {
            JOptionPane.showMessageDialog(this, "La mesa " + numeroMesa + " ya está ocupada.");
            return;
        }

        String nombreMesero = JOptionPane.showInputDialog(this, "Ingrese el nombre del mesero encargado:");
        if (nombreMesero == null || nombreMesero.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el nombre del mesero.");
            return;
        }

        if (!meseroExiste(nombreMesero.trim())) {
            JOptionPane.showMessageDialog(this, "El mesero no existe en el sistema.");
            return;
        }

        String cantidadStr = JOptionPane.showInputDialog(this, "Ingrese la cantidad de personas:");
        if (cantidadStr == null || cantidadStr.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar la cantidad de personas.");
            return;
        }

        try {
            int cantidad = Integer.parseInt(cantidadStr.trim());
            if (cantidad <= 0) throw new NumberFormatException();

            guardarMesaEnBD(numeroMesa, nombreMesero, cantidad);
            boton.setBackground(Color.GREEN);

            JOptionPane.showMessageDialog(this, "Mesa asignada correctamente.");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Cantidad inválida.");
        }
    }
    
    private boolean meseroExiste(String nombre) {
        ConexionBD conexion = new ConexionBD();
        ResultSet rs = null;

        try {
            conexion.setConexion();
            conexion.setConsulta("SELECT * FROM meseros WHERE nombre = ?");
            conexion.getConsulta().setString(1, nombre);
            rs = conexion.getResultado();

            if (rs.next()) {
                return true;
            }

            conexion.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    private boolean mesaYaOcupada(String numeroMesa) {
        ConexionBD conexion = new ConexionBD();
        ResultSet rs;

        try {
            conexion.setConexion();
            conexion.setConsulta("SELECT * FROM mesas_ocupadas WHERE numero_mesa = ?");
            conexion.getConsulta().setString(1, numeroMesa);
            rs = conexion.getResultado();

            if (rs.next()) return true;
            conexion.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private void guardarMesaEnBD(String numeroMesa, String mesero, int personas) {
        ConexionBD conexion = new ConexionBD();

        try {
            conexion.setConexion();
            conexion.setConsulta("INSERT INTO mesas_ocupadas (numero_mesa, nombre_mesero, cantidad_personas) VALUES (?, ?, ?)");
            conexion.getConsulta().setString(1, numeroMesa);
            conexion.getConsulta().setString(2, mesero);
            conexion.getConsulta().setInt(3, personas);
            conexion.getConsulta().executeUpdate();

            conexion.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private JButton obtenerBotonMesa(int num) {
        switch (num) {
            case 1: return btnMesa1;
            case 2: return btnMesa2;
            case 3: return btnMesa3;
            case 4: return btnMesa4;
            case 5: return btnMesa5;
            case 6: return btnMesa6;
            case 7: return btnMesa7;
            case 8: return btnMesa8;
            case 9: return btnMesa9;
            case 10: return btnMesa10;
            case 11: return btnMesa11;
            case 12: return btnMesa12;
            default: return null;
        }
    }

    private void marcarMesasOcupadas() {
    ConexionBD conexion = new ConexionBD();
    ResultSet rs = null;

    try {
        conexion.setConexion();
        conexion.setConsulta("SELECT numero_mesa FROM mesas_ocupadas"); // tabla donde guardás las mesas ocupadas
        rs = conexion.getResultado();

        while (rs.next()) {
            int num = rs.getInt("numero_mesa");
            JButton boton = obtenerBotonMesa(num);
            if (boton != null) {
                boton.setBackground(Color.GREEN); // mesa ocupada
            }
        }

        conexion.cerrarConexion();
    } catch (SQLException e) {
        e.printStackTrace();
    }
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
            java.util.logging.Logger.getLogger(Salon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Salon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Salon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Salon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Salon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelBotones;
    private javax.swing.JPanel JPanelPrincipal;
    private javax.swing.JButton btnMesa1;
    private javax.swing.JButton btnMesa10;
    private javax.swing.JButton btnMesa11;
    private javax.swing.JButton btnMesa12;
    private javax.swing.JButton btnMesa2;
    private javax.swing.JButton btnMesa3;
    private javax.swing.JButton btnMesa4;
    private javax.swing.JButton btnMesa5;
    private javax.swing.JButton btnMesa6;
    private javax.swing.JButton btnMesa7;
    private javax.swing.JButton btnMesa8;
    private javax.swing.JButton btnMesa9;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel imagenDeFondo;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
