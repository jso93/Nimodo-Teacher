package pattern.dao;

import java.util.ArrayList;
import java.util.List;
import dataSource.Conexion;
import interfaces.ICrudDao;
import pattern.model.Periodo;

public class PeriodoDao extends Conexion implements ICrudDao<Periodo>{

    @Override
    public boolean Create(Periodo periodo) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call periodoCreate(?,?,?)}");
            myStmt.setString(1, periodo.getPeriodo());
            myStmt.setString(2, periodo.getFechaInicio());
            myStmt.setString(3,periodo.getFechaFin());
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
    public boolean Update(Periodo periodo_actual, Periodo periodo_nuevo) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call periodoUpdate(?,?,?,?)}");
            myStmt.setString(1, periodo_nuevo.getPeriodo());
            myStmt.setString(2, periodo_nuevo.getFechaInicio());
            myStmt.setString(3, periodo_nuevo.getFechaFin());
            myStmt.setInt(4, periodo_actual.getIdPeriodo());/*primary key*/
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
    public boolean Delete(Periodo periodo) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call periodoDelete(?)}");
            myStmt.setInt(1, periodo.getIdPeriodo());
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
    public List<Periodo> Read() {
        List<Periodo>listaPeriodo=null;
        Periodo periodo;
        try {
            conectar();
            listaPeriodo=new ArrayList<>();
            myStmt = conexion.prepareCall("{call periodoRead()}");
            rs=myStmt.executeQuery();
            while (rs.next()) {
                periodo=new Periodo();
                periodo.setIdPeriodo(rs.getInt(1));
                periodo.setPeriodo(rs.getString(2));
                periodo.setFechaInicio(rs.getString(3));
                periodo.setFechaFin(rs.getString(4));
                listaPeriodo.add(periodo);
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaPeriodo;
    }
}
