package pattern.dao;

import java.util.List;
import dataSource.Conexion;
import java.sql.Types;
import interfaces.ICrudDao;
import java.util.ArrayList;
import pattern.model.EvaluacionTradicional;

public class EvaluacionTradicionalDao extends Conexion implements ICrudDao<EvaluacionTradicional>{
    private int idEvaluacionTradicional;
    
    @Override
    public boolean Create(EvaluacionTradicional evaluacionTradicional) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call evaluacionTradicionalCreate(?,?,?,?,?,?)}");
            myStmt.setString(1, evaluacionTradicional.getFecha());
            myStmt.setInt(2, evaluacionTradicional.getIdPeriodo());
            myStmt.setInt(3, evaluacionTradicional.getIdArea());
            myStmt.setInt(4, evaluacionTradicional.getIdEstudianteMatricula());
            myStmt.setInt(5, evaluacionTradicional.getIdDocenteAula());
            myStmt.registerOutParameter(6, Types.INTEGER);
            myStmt.executeUpdate();
            estado=true;
            idEvaluacionTradicional = myStmt.getInt(6);//id last autogenerado
            cerrar();   
        } catch (Exception e) {
            System.out.println("--->"+e);
            estado=false;
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return estado;
    }

    @Override public boolean Update(EvaluacionTradicional evaluacionTradicional_actual, EvaluacionTradicional evaluacionTradicional_nuevo) {return estado;}

    @Override
    public boolean Delete(EvaluacionTradicional evaluacionTradicional) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call evaluacionTradicionalDelete(?)}");
            myStmt.setInt(1, evaluacionTradicional.getIdEvaluacionTradicional());
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

    @Override public List<EvaluacionTradicional> Read() {List<EvaluacionTradicional>listaEvaluacionesTradicionales=null; return listaEvaluacionesTradicionales;}
    
    public int getIdEvaluacionTradicional(){ return idEvaluacionTradicional; }
    
    public List<String> getFechas(String dni,String periodo,String area){
        List<String> listaFecha= null;
        try {
            conectar();
            listaFecha=new ArrayList<>();
            myStmt = conexion.prepareCall("{call evaluacionTradicionalFechaRead(?,?,?)}");
            myStmt.setString(1, dni);
            myStmt.setString(2, periodo);
            myStmt.setString(3, area);
            rs=myStmt.executeQuery();
            while (rs.next()) {
                listaFecha.add(rs.getString(1));
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaFecha;
    }
    
    public List<List<String>> getEvaluacionTradicionalEstudiante(String dni,String periodo,String area,String fecha){
        List<List<String>> listaEstudiante= null;
        List<String> estudiante =null;
        try {
            conectar();
            listaEstudiante=new ArrayList<>();
            myStmt = conexion.prepareCall("{call evaluacionTradicionalEstudianteRead(?,?,?,?)}");
            myStmt.setString(1, dni);
            myStmt.setString(2, periodo);
            myStmt.setString(3, area);
            myStmt.setString(4, fecha);
            rs=myStmt.executeQuery();
            while (rs.next()) {
                estudiante = new ArrayList<>();
                estudiante.add(rs.getString(1));
                estudiante.add(rs.getString(2));
                estudiante.add(rs.getString(3));
                estudiante.add(rs.getString(4));
                listaEstudiante.add(estudiante);
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaEstudiante;
    }
    
    public List<List<Integer>> evaluacionTradicionalCalificacionEstudiante(String dni,String periodo,String area,String fecha){
        List<List<Integer>> listaCalificacion= null;
        List<Integer> calificacion= null;
        try {
            conectar();
            listaCalificacion=new ArrayList<>();
            myStmt = conexion.prepareCall("{call evaluacionTradicionalCalificacionEstudianteRead(?,?,?,?)}");
            myStmt.setString(1, dni);
            myStmt.setString(2, periodo);
            myStmt.setString(3, area);
            myStmt.setString(4, fecha);
            rs=myStmt.executeQuery();
            while (rs.next()) {
                calificacion=new ArrayList<>();
                calificacion.add(rs.getInt(1));
                calificacion.add(rs.getInt(2));
                listaCalificacion.add(calificacion);
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaCalificacion;
    }
}
