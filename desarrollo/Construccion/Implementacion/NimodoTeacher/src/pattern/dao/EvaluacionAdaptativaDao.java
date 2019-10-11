package pattern.dao;

import dataSource.Conexion;
import java.util.ArrayList;
import java.util.List;
import pattern.model.EvaluacionAdaptativa;

public class EvaluacionAdaptativaDao extends Conexion {

    public List<List<Object>> Read(int idestudiante_matricula ,int iddocente_aula , String area , String periodo ) {
        List<List<Object>> listaEvaluacionAdaptativa= null;
        List<Object> evaluacionAdaptativa;
        try {
            conectar();
            listaEvaluacionAdaptativa=new ArrayList<>();
            myStmt = conexion.prepareCall("{call evaluacionAdaptativaRead(?,?,?,?)}");
            myStmt.setInt(1, idestudiante_matricula);
            myStmt.setInt(2, iddocente_aula);
            myStmt.setString(3, area);
            myStmt.setString(4, periodo);
            rs=myStmt.executeQuery();
            while (rs.next()) {
                evaluacionAdaptativa = new ArrayList<>();
                evaluacionAdaptativa.add(+rs.getInt(1));
                evaluacionAdaptativa.add(rs.getString(2));
                evaluacionAdaptativa.add(rs.getString(3));
                evaluacionAdaptativa.add(rs.getString(4));
                evaluacionAdaptativa.add(rs.getString(5));
                listaEvaluacionAdaptativa.add(evaluacionAdaptativa);
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaEvaluacionAdaptativa;
    }

    public boolean Delete(EvaluacionAdaptativa evaluacionAdaptativa) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call evaluacionAdaptativaDelete(?)}");
            myStmt.setInt(1, evaluacionAdaptativa.getIdEvaluacionAdaptativa());
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
    
    public List<List<Object>> getPreguntaAreaRead(int idestudiante_matricula,int iddocente_aula ,String area,String periodo ) {
        List<List<Object>> listaPregunta= null;
        List<Object> pregunta =null;
        try {
            conectar();
            listaPregunta = new ArrayList<>();
            myStmt = conexion.prepareCall("{call evaluacionAdaptativaPreguntaAreaRead(?,?,?,?)}");
            myStmt.setInt(1, idestudiante_matricula);
            myStmt.setInt(2, iddocente_aula);
            myStmt.setString(3, area);
            myStmt.setString(4, periodo);
            rs=myStmt.executeQuery();
            while (rs.next()) {
                pregunta = new ArrayList<>();
                pregunta.add(rs.getInt(1));
                pregunta.add(rs.getString(2));
                pregunta.add(rs.getInt(3));
                pregunta.add(rs.getDouble(4));
                pregunta.add(rs.getInt(5));
                listaPregunta.add(pregunta);
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaPregunta;
    }
}
