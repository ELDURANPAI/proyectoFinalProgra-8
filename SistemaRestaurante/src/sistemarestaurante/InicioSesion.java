package sistemarestaurante;

import java.sql.*;
import javax.swing.JOptionPane;

public class InicioSesion {

    public boolean encontrado = false;

    public boolean IniciarSesion(String usuario, String clave) {
        ConexionBD conexion = new ConexionBD(); //Conexion con la BD
        ResultSet resultado = null; // guardar Resultados

        try {
            //Abrir conexion
            conexion.setConexion();
            //definimos la consulta
            conexion.setConsulta("SELECT * FROM usuarios");
            //Obtenemos todos los resultados de la consulta
            resultado = conexion.getResultado();
            while (resultado.next()) {
                var Nombre = resultado.getString("Usuario");
                var pass = resultado.getString("Clave");
                if (usuario.equals(Nombre) && clave.equals(pass)) {
                    JOptionPane.showMessageDialog(null, "BIENVENIDO " + usuario);
                    return encontrado = true;
                } else {
                    
                }

            }
            conexion.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return encontrado;
    }
}
