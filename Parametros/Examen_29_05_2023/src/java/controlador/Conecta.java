package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conecta {

    public static Connection getConexion(String usu, String pas, String url) {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// Driver depende de la BD

            con = (Connection) DriverManager.getConnection(url, usu, pas);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
        return con;
    }
}
