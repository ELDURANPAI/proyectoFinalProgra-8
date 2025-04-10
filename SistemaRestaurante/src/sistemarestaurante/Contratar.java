package sistemarestaurante;

import java.sql.*;
import javax.swing.*;

public class Contratar {

    ConexionBD conexion = new ConexionBD();
    ResultSet resultado = null;
    public int ID;
    public String Nombre, Cedula;

    public void AgregarMesero(String nombre, String cedula) {
        try {
            //Abrir conexion
            conexion.setConexion();
            //definimos la consulta
            conexion.setConsulta("INSERT INTO meseros(nombre, cedula) VALUES (?,?)"); // entra en la tabla BD
            conexion.getConsulta().setString(1, nombre);// ingresamos el nombre
            conexion.getConsulta().setString(2, cedula);// ingresamos la cedula

            if (conexion.getConsulta().executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "DATOS AGREGADOS CORRECTAMENTE!",
                        "AVISO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "A OCURRIDO UN ERROR AL INGRESAR LOS DATOS!",
                        "ERROR",
                        JOptionPane.ERROR_MESSAGE
                );
            }

            conexion.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void EliminarMesero(int id) {
        try {
            //Abrir conexion
            conexion.setConexion();
            // Seleccionamos la tabla meseros y eliminamos el id
            conexion.setConsulta("DELETE FROM meseros where id= " + id);

            if (conexion.getConsulta().executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "DATOS ELIMINADOS CORRECTAMENTE!",
                        "AVISO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "ID NO ENCONTRADO!",
                        "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }

            conexion.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
