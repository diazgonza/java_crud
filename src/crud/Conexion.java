package crud;

import java.sql.*;

public class Conexion {
    Connection cx;
    String db = "gsd-1";
    String url = "jdbc:mysql://mispruebas.cfogwulgnczu.us-east-1.rds.amazonaws.com:3306/"+db;
    String user = "admin";
    String pass = "W5TRT98sMHBm5EJqk8cL";
    
    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cx = (Connection) DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException | SQLException ex) {
        }
        return cx;
    }
    
    public void desconectar() {
        try {
            cx.close();
        } catch (SQLException ex) {
        }
    }
}
