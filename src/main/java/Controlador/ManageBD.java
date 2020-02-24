package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ManageBD {

  String bd = "lliga_futbol";
    String usuari = "root";
    String password = "123456";
    
    Connection conn = null;

    public Connection getConnection() {
        return conn;
    }
    
    public ManageBD() throws AplicacioException {
        
        
        this.conn = ConnectarBD();
    }
    
        
    /**
    * Connecta a una BD mysql i gestiona la connexi�
    *
    * @return objecte Connection
    * @throws SQLException 
    */
    private Connection ConnectarBD() throws AplicacioException
    {
        Connection ret = null;
        
        
        try {
            ret =  DriverManager.getConnection("jdbc:mysql://localhost:3306/"+bd+"?useUnicode=true&"
                    + "useJDBCCompliantTimezoneShift=true&"   
                    + "useLegacyDatetimeCode=false&serverTimezone=UTC", usuari, password);
        } catch (SQLException ex) {
            throw new AplicacioException("Error ConnectarBD: " + ex.toString());
        }
       
        
        return ret;
    }
    
    public void closeConnection() throws AplicacioException
    {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            throw new AplicacioException("Error inicialitzant connexi�: " + ex.toString());
        }
    }



}
