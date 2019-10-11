package pattern.dao;

import dataSource.Conexion;
import interfaces.ICrudDao;
import java.util.ArrayList;
import java.util.List;
import pattern.model.Estilo;

public class EstiloDao extends Conexion implements ICrudDao<Estilo>{

    @Override
    public boolean Create(Estilo estilo) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call estiloCreate(?,?)}");
            myStmt.setString(1, estilo.getEstilo());
            myStmt.setString(2, estilo.getDescripcion());
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
    public List<Estilo> Read() {
        List<Estilo> listaEstilo= null;
        Estilo estilo;
        try {
            conectar();
            listaEstilo=new ArrayList<>();
            myStmt = conexion.prepareCall("{call estiloRead()}");
            rs=myStmt.executeQuery();
            while (rs.next()) {
                estilo=new Estilo();
                estilo.setIdEstilo(rs.getInt(1));
                estilo.setEstilo(rs.getString(2));
                estilo.setDescripcion(rs.getString(3));
                listaEstilo.add(estilo);
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaEstilo;
    }

    @Override
    public boolean Update(Estilo estilo_actual, Estilo estilo_nuevo) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call estiloUpdate(?,?,?)}");
            myStmt.setString(1, estilo_nuevo.getEstilo());
            myStmt.setString(2, estilo_nuevo.getDescripcion());
            myStmt.setInt(3, estilo_actual.getIdEstilo());/*primary key*/
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
    public boolean Delete(Estilo estilo) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call estiloDelete(?)}");
            myStmt.setInt(1, estilo.getIdEstilo());
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
