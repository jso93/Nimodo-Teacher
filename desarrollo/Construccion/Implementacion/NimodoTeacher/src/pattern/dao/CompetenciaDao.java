package pattern.dao;

import dataSource.Conexion;
import interfaces.ICrudDao;
import java.util.ArrayList;
import java.util.List;
import pattern.model.Competencia;

public class CompetenciaDao extends Conexion implements ICrudDao<Competencia>{

    @Override
    public boolean Create(Competencia competencia) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call competenciaCreate(?,?)}");
            myStmt.setString(1, competencia.getCompetencia());
            myStmt.setString(2, competencia.getDescripcion());
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
    public List<Competencia> Read() {
        List<Competencia> listaCompetencia =null;
        Competencia competencia;
        try {
            conectar();
            listaCompetencia=new ArrayList<>();
            myStmt = conexion.prepareCall("{call competenciaRead()}");
            rs=myStmt.executeQuery();
            while (rs.next()) {
                competencia=new Competencia();
                competencia.setIdCompetencia(rs.getInt(1));
                competencia.setCompetencia(rs.getString(2));
                competencia.setDescripcion(rs.getString(3));                
                listaCompetencia.add(competencia);
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaCompetencia;
    }

    @Override
    public boolean Update(Competencia competencia_actual, Competencia competencia_nuevo) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call competenciaUpdate(?,?,?)}");
            myStmt.setString(1, competencia_nuevo.getCompetencia());
            myStmt.setString(2, competencia_nuevo.getDescripcion());
            myStmt.setInt(3, competencia_actual.getIdCompetencia());/*primary key*/
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
    public boolean Delete(Competencia competencia) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call competenciaDelete(?)}");
            myStmt.setInt(1, competencia.getIdCompetencia());
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
