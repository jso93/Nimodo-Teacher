package pattern.dao;

import java.util.List;
import dataSource.Conexion;
import interfaces.ICrudDao;
import pattern.model.Calificacion;

public class CalificacionDao extends Conexion implements ICrudDao<Calificacion>{
    
    @Override
    public boolean Create(Calificacion calificacion) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call calificacionCreate(?,?)}");
            myStmt.setInt(1, calificacion.getCalificacion());
            myStmt.setInt(2, calificacion.getIdEvaluacionTradicional());
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
    @Override public boolean Update(Calificacion area_actual, Calificacion area_nuevo) {return estado;}
    
    @Override public boolean Delete(Calificacion area) {return estado;}
    
    @Override public List<Calificacion> Read() {List<Calificacion>listaAreas=null;return listaAreas;}

}
