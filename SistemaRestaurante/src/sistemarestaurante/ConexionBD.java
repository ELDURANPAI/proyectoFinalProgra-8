package sistemarestaurante;

// Importe de la libreria SQL
import java.sql.*;

public class ConexionBD {
    // Datos de gestion BD
    Connection conexion = null;
    PreparedStatement consulta = null;
    ResultSet resultado = null;
    
    // Parametros de la conexion
    String url= "jdbc:mysql://localhost:3306/restaurantebd";  // URl de la BD
    String user= "root"; // Usuario con el que nos conectaremos
    String pass=""; // contraseña del usuario

    //Construimos los metodos para la conexion
    public void setConsulta(String sql) {
        try {
            this.consulta = conexion.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public PreparedStatement getConsulta() {
        return consulta;
    }

    public ResultSet getResultado() {
        try {
            return consulta.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setConexion() {
        try {
            this.conexion = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cerrarConexion() {
        if (resultado != null) {
            try {
                resultado.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (consulta != null) {
            try {
                consulta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}