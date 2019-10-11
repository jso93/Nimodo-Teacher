package pattern.dao;

import dataSource.Conexion;
import interfaces.ICrudDao;
import java.util.ArrayList;
import java.util.List;
import pattern.model.Grado;

public class GradoDao extends Conexion implements ICrudDao<Grado>{

    @Override
    public boolean Create(Grado grado) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call gradoCreate(?,?)}");
            myStmt.setString(1, grado.getGrado());
            myStmt.setString(2, grado.getDescripcion());
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

    @Override
    public List<Grado> Read() {
        List<Grado> listaGrado= null;
        Grado grado;
        try {
            conectar();
            listaGrado=new ArrayList<>();
            myStmt = conexion.prepareCall("{call gradoRead()}");
            rs=myStmt.executeQuery();
            while (rs.next()) {
                grado=new Grado();
                grado.setIdGrado(rs.getInt(1));
                grado.setGrado(rs.getString(2));
                grado.setDescripcion(rs.getString(3));
                listaGrado.add(grado);
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaGrado;
    }

    @Override
    public boolean Update(Grado grado_actual, Grado grado_nuevo) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call gradoUpdate(?,?,?)}");
            myStmt.setString(1, grado_nuevo.getGrado());
            myStmt.setString(2, grado_nuevo.getDescripcion());
            myStmt.setInt(3, grado_actual.getIdGrado());/*primary key*/
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

    @Override
    public boolean Delete(Grado grado) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call gradoDelete(?)}");
            myStmt.setInt(1, grado.getIdGrado());
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
