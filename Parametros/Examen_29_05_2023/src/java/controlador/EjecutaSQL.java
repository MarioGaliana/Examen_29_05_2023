package controlador;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class EjecutaSQL {

    public static ResultSet devuelveRS(String consulta, String usu,
            String pas, String cad) {

        Connection con = Conecta.getConexion(usu, pas, cad);

        ResultSet rs = null;

        try {

            Statement st = con.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            rs = st.executeQuery(consulta);

            return rs;
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }

    }

    public static int ejecutaDms(String orden, String usu, String pas, String cad) {
        Connection con = Conecta.getConexion(usu, pas, cad);

        try {

            Statement st = con.createStatement();

            return st.executeUpdate(orden);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return 0;
        }

    }

}
