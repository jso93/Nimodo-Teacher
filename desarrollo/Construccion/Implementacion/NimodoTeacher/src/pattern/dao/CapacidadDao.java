package pattern.dao;

import dataSource.Conexion;
import interfaces.ICrudDao;
import java.util.ArrayList;
import java.util.List;
import pattern.model.Capacidad;

public class CapacidadDao extends Conexion implements ICrudDao<Capacidad>{

    @Override
    public boolean Create(Capacidad capacidad) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call capacidadCreate(?,?)}");
            myStmt.setString(1, capacidad.getCapacidad());
            myStmt.setString(2, capacidad.getDescripcion());
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
    public List<Capacidad> Read() {
        List<Capacidad> listaCapacidad =null;
        Capacidad capacidad;
        try {
            conectar();
            listaCapacidad=new ArrayList<>();
            myStmt = conexion.prepareCall("{call capacidadRead()}");
            rs=myStmt.executeQuery();
            while (rs.next()) {
                capacidad=new Capacidad();
                capacidad.setIdCapacidad(rs.getInt(1));
                capacidad.setCapacidad(rs.getString(2));
                capacidad.setDescripcion(rs.getString(3));
                listaCapacidad.add(capacidad);
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaCapacidad;
    }

    @Override
    public boolean Update(Capacidad capacidad_actual, Capacidad capacidad_nuevo) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call capacidadUpdate(?,?,?)}");
            myStmt.setString(1, capacidad_nuevo.getCapacidad());
            myStmt.setString(2, capacidad_nuevo.getDescripcion());
            myStmt.setInt(3, capacidad_actual.getIdCapacidad());/*primary key*/
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
    public boolean Delete(Capacidad capacidad) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call capacidadDelete(?)}");
            myStmt.setInt(1, capacidad.getIdCapacidad());
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
