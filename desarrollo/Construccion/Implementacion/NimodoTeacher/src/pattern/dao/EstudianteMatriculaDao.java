package pattern.dao;

import java.util.List;
import dataSource.Conexion;
import interfaces.ICrudDao;
import java.util.ArrayList;
import pattern.model.EstudianteMatricula;

public class EstudianteMatriculaDao extends Conexion implements ICrudDao<EstudianteMatricula>{
    
    @Override
    public boolean Create(EstudianteMatricula estudianteMatricula) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call estudianteMatriculaCreate(?,?,?)}");
            myStmt.setString(1, estudianteMatricula.getFecha());
            myStmt.setInt(2, estudianteMatricula.getIdPerfil());
            myStmt.setInt(3, estudianteMatricula.getIdAula());
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
    
    @Override public boolean Update(EstudianteMatricula area_actual, EstudianteMatricula area_nuevo) {return estado;}
    
    @Override
    public boolean Delete(EstudianteMatricula estudianteMatricula) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call estudianteMatriculaDelete(?)}");
            myStmt.setInt(1, estudianteMatricula.getIdEstudianteMatricula());
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
    
    @Override public List<EstudianteMatricula> Read() {List<EstudianteMatricula>listaEstudianteMatricula=null;return listaEstudianteMatricula;}
    
    public List<List<String>> estudiantesConMatricula(){
        List<List<String>> listaEstudiante = null;
        List<String> estudiante = null;
        try {
            conectar();
            listaEstudiante=new ArrayList<>();
            myStmt = conexion.prepareCall("{call estudianteConMatriculaRead()}");
            rs=myStmt.executeQuery();
            while (rs.next()) {
                estudiante = new ArrayList<>();
                estudiante.add(rs.getString(1));
                estudiante.add(rs.getString(2));
                estudiante.add(rs.getString(3));
                estudiante.add(rs.getString(4));
                estudiante.add(rs.getString(5));
                estudiante.add(rs.getString(6));
                estudiante.add(rs.getString(7));
                listaEstudiante.add(estudiante);
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaEstudiante;
    }
    
    public List<List<String>> estudiantesSinMatricula(){
        List<List<String>> listaEstudiante = null;
        List<String> estudiante  = null;
        try {
            conectar();
            listaEstudiante=new ArrayList<>();
            myStmt = conexion.prepareCall("{call estudianteSinMatriculaRead()}");
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
}
