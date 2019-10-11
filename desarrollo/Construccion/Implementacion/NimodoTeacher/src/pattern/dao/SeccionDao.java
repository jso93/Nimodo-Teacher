package pattern.dao;

import dataSource.Conexion;
import interfaces.ICrudDao;
import java.util.ArrayList;
import java.util.List;
import pattern.model.Seccion;

public class SeccionDao extends Conexion implements ICrudDao<Seccion>{

    @Override
    public boolean Create(Seccion seccion) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call seccionCreate(?,?)}");
            myStmt.setString(1, seccion.getSeccion());
            myStmt.setString(2, seccion.getDescripcion());
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
    public List<Seccion> Read() {
        List<Seccion> listaSeccion= null;
        Seccion seccion;
        try {
            conectar();
            listaSeccion=new ArrayList<>();
            myStmt = conexion.prepareCall("{call seccionRead()}");
            rs=myStmt.executeQuery();
            while (rs.next()) {
                seccion=new Seccion();
                seccion.setIdSeccion(rs.getInt(1));
                seccion.setSeccion(rs.getString(2));
                seccion.setDescripcion(rs.getString(3));
                listaSeccion.add(seccion);
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaSeccion;
    }

    @Override
    public boolean Update(Seccion seccion_actual, Seccion seccion_nuevo) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call seccionUpdate(?,?,?)}");
            myStmt.setString(1, seccion_nuevo.getSeccion());
            myStmt.setString(2, seccion_nuevo.getDescripcion());
            myStmt.setInt(3, seccion_actual.getIdSeccion());/*primary key*/
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
    public boolean Delete(Seccion seccion) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call seccionDelete(?)}");
            myStmt.setInt(1, seccion.getIdSeccion());
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
