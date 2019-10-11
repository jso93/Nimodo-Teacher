package pattern.dao;

import dataSource.Conexion;
import interfaces.ICrudDao;
import java.util.ArrayList;
import java.util.List;
import pattern.model.Desempeño;

public class DesempeñoDao extends Conexion implements ICrudDao<Desempeño>{

    @Override
    public boolean Create(Desempeño desempeño) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call desempeñoCreate(?,?,?)}");
            myStmt.setString(1, desempeño.getDesempeño());
            myStmt.setString(2, desempeño.getDescripcion());
            myStmt.setInt(3, desempeño.getIdDocenteAula());
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
    public List<Desempeño> Read() {
        List<Desempeño> listaDesempeño =null;
        Desempeño desempeño;
        try {
            conectar();
            listaDesempeño=new ArrayList<>();
            myStmt = conexion.prepareCall("{call desempeñoRead()}");
            rs=myStmt.executeQuery();
            while (rs.next()) {
                desempeño=new Desempeño();
                desempeño.setIdDesempeño(rs.getInt(1));
                desempeño.setDesempeño(rs.getString(2));
                desempeño.setDescripcion(rs.getString(3));
                desempeño.setIdDocenteAula(rs.getInt(4));
                listaDesempeño.add(desempeño);
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaDesempeño;
    }

    @Override
    public boolean Update(Desempeño desempeño_actual, Desempeño desempeño_nuevo) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call desempeñoUpdate(?,?,?)}");
            myStmt.setString(1, desempeño_nuevo.getDesempeño());
            myStmt.setString(2, desempeño_nuevo.getDescripcion());
            myStmt.setInt(3, desempeño_actual.getIdDesempeño());/*primary key*/
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
    public boolean Delete(Desempeño desempeño) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call desempeñoDelete(?)}");
            myStmt.setInt(1, desempeño.getIdDesempeño());
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
