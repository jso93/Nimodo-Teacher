package pattern.dao;

import dataSource.Conexion;
import interfaces.ICrudDao;
import java.util.ArrayList;
import java.util.List;
import pattern.model.Nivel;

public class NivelDao extends Conexion implements ICrudDao<Nivel>{

    @Override
    public boolean Create(Nivel nivel) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call nivelCreate(?,?)}");
            myStmt.setString(1, nivel.getNivel());
            myStmt.setString(2, nivel.getDescripcion());
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
    public List<Nivel> Read() {
        List<Nivel> listaNivel= null;
        Nivel nivel;
        try {
            conectar();
            listaNivel=new ArrayList<>();
            myStmt = conexion.prepareCall("{call nivelRead()}");
            rs=myStmt.executeQuery();
            while (rs.next()) {
                nivel=new Nivel();
                nivel.setIdNivel(rs.getInt(1));
                nivel.setNivel(rs.getString(2));
                nivel.setDescripcion(rs.getString(3));
                listaNivel.add(nivel);
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaNivel;
    }

    @Override
    public boolean Update(Nivel nivel_actual, Nivel nivel_nuevo) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call nivelUpdate(?,?,?)}");
            myStmt.setString(1, nivel_nuevo.getNivel());
            myStmt.setString(2, nivel_nuevo.getDescripcion());
            myStmt.setInt(3, nivel_actual.getIdNivel());/*primary key*/
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
    public boolean Delete(Nivel nivel) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call nivelDelete(?)}");
            myStmt.setInt(1, nivel.getIdNivel());
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
