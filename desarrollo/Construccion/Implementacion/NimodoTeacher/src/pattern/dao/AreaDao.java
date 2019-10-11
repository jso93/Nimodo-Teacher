package pattern.dao;

import dataSource.Conexion;
import interfaces.ICrudDao;
import java.util.ArrayList;
import java.util.List;
import pattern.model.Area;

public class AreaDao extends Conexion implements ICrudDao<Area>{

    @Override
    public boolean Create(Area area) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call areaCreate(?,?)}");
            myStmt.setString(1, area.getArea());
            myStmt.setString(2, area.getDescripcion());
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
    public List<Area> Read() {
        List<Area> listaArea= null;
        Area area;
        try {
            conectar();
            listaArea=new ArrayList<>();
            myStmt = conexion.prepareCall("{call areaRead()}");
            rs=myStmt.executeQuery();
            while (rs.next()) {
                area=new Area();
                area.setIdArea(rs.getInt(1));
                area.setArea(rs.getString(2));
                area.setDescripcion(rs.getString(3));
                listaArea.add(area);
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaArea;
    }

    @Override
    public boolean Update(Area area_actual, Area area_nuevo) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call areaUpdate(?,?,?)}");
            myStmt.setString(1, area_nuevo.getArea());
            myStmt.setString(2, area_nuevo.getDescripcion());
            myStmt.setInt(3, area_actual.getIdArea());/*primary key*/
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
    public boolean Delete(Area area) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call areaDelete(?)}");
            myStmt.setInt(1, area.getIdArea());
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
