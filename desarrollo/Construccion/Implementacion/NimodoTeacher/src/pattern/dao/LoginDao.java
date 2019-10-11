package pattern.dao;

import dataSource.Conexion;
import java.util.ArrayList;
import java.util.List;

public class LoginDao extends Conexion{
    public List<String> validarLogin(String user, String password){
        List<String> persona = null;
        try {
            conectar();
            myStmt = conexion.prepareCall("{call validarLogin(?,?)}");
            myStmt.setString(1,user);
            myStmt.setString(2,password);
            rs=myStmt.executeQuery();
            while (rs.next()){
                persona = new ArrayList<>();
                persona.add(rs.getString(1));
                persona.add(rs.getString(2));
                persona.add(rs.getString(3));
                persona.add(rs.getString(4));
                persona.add(rs.getString(5));
                persona.add(rs.getString(6));
                persona.add(rs.getString(7));
                if(rs.getString(7).equals("Director"))break;
            }
            cerrar();
        } catch (Exception e) {
            System.err.println("-->"+e);
        }
        return persona;   
    }
}
