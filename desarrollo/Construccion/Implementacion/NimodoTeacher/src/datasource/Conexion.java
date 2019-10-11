package dataSource;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    /*PARAMETROS DE CONEXION*/
    protected Connection conexion;
    private final String driver="com.mysql.jdbc.Driver";
    private final String dbUrl="jdbc:mysql://localhost/nimodo";
    private final String user = "root";
    private final String password = "";
    /*private final String dbUrl="jdbc:mysql://107.180.51.38:3306/nimodo?noAccessToProcedureBodies=true";
    private final String user = "jsilva";
    private final String password = "1003920102";*/
    /*GET RESULT CRUD*/
    public ResultSet rs=null;
    public ResultSetMetaData md=null;
    public CallableStatement myStmt = null;
    public boolean estado=false;
    /*CONECTAR A BASE DE DATOS*/
    public Connection conectar()throws Exception{
        try {
            Class.forName(driver);
            conexion=DriverManager.getConnection(dbUrl,user,password);
            
        } catch (ClassNotFoundException | SQLException e) {
           // throw e;
           JOptionPane.showMessageDialog(null,"Error conectando a base de Datos\nverifique su conexion a la red!"+e,"Mensaje",JOptionPane.ERROR_MESSAGE);   
        }
        return conexion;
    }
    /*CERRAR CONEXION DE LA BASE DE DATOS*/
    public void cerrar()throws Exception{
        if (conexion!=null) {
            if(!conexion.isClosed()){
                conexion.close();
            }
        }
    }
}
