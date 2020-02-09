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
    /*public List<Integer> Read() {
        List<Integer> listaDocente= null;
        //Persona docente;
        try {
            conectar();
            listaDocente=new ArrayList<>();
            myStmt = conexion.prepareCall("{call resultadoRead()}");
            rs=myStmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                listaDocente.add(id);
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaDocente;
    }
    public boolean updateResultado(int id){
        try {
            conectar();
            myStmt = conexion.prepareCall("{call resultadoUpdate(?)}");
            myStmt.setInt(1, id);
            myStmt.executeUpdate();
            estado=true;
            cerrar();    
        } catch (Exception e) {
            System.out.println("--->"+e);
            estado=false;
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return estado; 
    }*/
}
