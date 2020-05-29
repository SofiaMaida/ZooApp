package ar.com.ada.maven.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    //SINGLETON
    private static Connection connection;

    private static String user = "root";                                //usuario
    private static String host = "jdbc:mysql://localhost:3306/";        //host - puerto
    private static String password = "LGlg123+-*/";                     //contraseña
    private static String db = "Zoologicodb";                           //base de datos para conectar
    private static String drive = "com.mysql.cj.jdbc.Driver";

    private DBConnection() {
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //verificar conexion
        if (connection == null || connection.isClosed()) {
            Class.forName(drive).newInstance();
            String url = host + db + "?serverTimezone=UTC";
            //crear conexion
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }
}
