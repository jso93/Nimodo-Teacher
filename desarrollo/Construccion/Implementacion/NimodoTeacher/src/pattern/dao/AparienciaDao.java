package pattern.dao;

import dataSource.Conexion;
import java.util.ArrayList;
import java.util.List;

public class AparienciaDao extends Conexion {

    public List<String> Read(String dni) {
        List<String> apariencia= null;
        try {
            conectar();
            apariencia=new ArrayList<>();
            myStmt = conexion.prepareCall("{call aparienciaRead(?)}");
            myStmt.setString(1, dni);
            rs=myStmt.executeQuery();
            while (rs.next()) {
                apariencia.add(rs.getString(1));
                apariencia.add(rs.getString(2));
                apariencia.add(rs.getString(3));
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return apariencia;
    }
    public List<List<String>> ReadLookAndFeel() {
        List<List<String>> ListaLookAndFeel= null;
        List<String> lookandfeel= null;
        try {
            conectar();
            ListaLookAndFeel=new ArrayList<>();
            myStmt = conexion.prepareCall("{call lookandfeelRead()}");
            rs=myStmt.executeQuery();
            while (rs.next()) {
                lookandfeel=new ArrayList<>();
                lookandfeel.add(rs.getString(1));
                lookandfeel.add(rs.getString(2));
                lookandfeel.add(rs.getString(3));
                lookandfeel.add(rs.getString(4));
                ListaLookAndFeel.add(lookandfeel);
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return ListaLookAndFeel;
    }
    
    public boolean Update(String dni, String look) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call aparienciaUpdate(?,?)}");
            myStmt.setString(1, dni);
            myStmt.setString(2, look);
            myStmt.executeUpdate();
            estado=true;
            cerrar();    
        } catch (Exception e) {
            System.out.println("--->"+e);
            estado=false;
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return estado;
    }
}
