
package conexãoSql;

import com.mysql.cj.jdbc.ConnectionImpl;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class conexaoSQL {
    ConnectionImpl conectar=null;
    
    public ConnectionImpl conectar (){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = (ConnectionImpl) DriverManager.getConnection("jdbc:mysql://localhost:3306/aplicativo", "root", "");
           // JOptionPane.showMessageDialog(null,"Conexion Exitosa,  \n \tRECEBA!!");
        }catch (Exception e ) {
                        JOptionPane.showMessageDialog(null,"Conexion falhouuu" + e.getMessage());

        }
        return conectar;
    }
   
}

