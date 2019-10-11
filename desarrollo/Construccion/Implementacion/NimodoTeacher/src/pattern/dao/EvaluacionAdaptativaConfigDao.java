package pattern.dao;

import dataSource.Conexion;
import java.util.ArrayList;
import java.util.List;
import pattern.model.Pregunta;

public class EvaluacionAdaptativaConfigDao extends Conexion{
    
    public List<Pregunta> getPreguntas(String periodo,int iddocenteAula,String competencia){
        List<Pregunta> listaPregunta= null;
        Pregunta pregunta = null;
        try {
            conectar();
            listaPregunta = new ArrayList<>();
            myStmt = conexion.prepareCall("{call evaluacionAdaptativaPreguntaRead(?,?,?)}");
            myStmt.setString(1, periodo);
            myStmt.setInt(2, iddocenteAula);
            myStmt.setString(3, competencia);
            rs=myStmt.executeQuery();
            while (rs.next()) {
                pregunta=new Pregunta();
                pregunta.setIdPregunta(rs.getInt(1));
                pregunta.setDescripcion(rs.getString(2));
                pregunta.setDescuido(rs.getFloat(3));
                pregunta.setAdivinanza(rs.getFloat(4));
                pregunta.setIdNivel(rs.getInt(5));
                pregunta.setIdEstilo(rs.getInt(6));
                pregunta.setIdMatriz(rs.getInt(7));
                pregunta.setIdPeriodo(rs.getInt(8));
                pregunta.setIdDocenteAula(rs.getInt(9));
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
