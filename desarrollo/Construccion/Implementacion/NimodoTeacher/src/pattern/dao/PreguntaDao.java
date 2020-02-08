package pattern.dao;

import dataSource.Conexion;
import interfaces.ICrudDao;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import pattern.model.Pregunta;

public class PreguntaDao extends Conexion implements ICrudDao<Pregunta>{
    private int idPregunta;
    @Override
    public boolean Create(Pregunta pregunta) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call preguntaCreate(?,?,?,?,?,?,?,?,?)}");
            myStmt.setString(1, pregunta.getDescripcion());
            myStmt.setDouble(2, pregunta.getDescuido());
            myStmt.setDouble(3, pregunta.getAdivinanza());
            myStmt.setInt(4, pregunta.getIdNivel());
            myStmt.setInt(5, pregunta.getIdEstilo());
            myStmt.setInt(6, pregunta.getIdMatriz());
            myStmt.setInt(7, pregunta.getIdPeriodo());
            myStmt.setInt(8, pregunta.getIdDocenteAula());
            myStmt.registerOutParameter(9, Types.INTEGER);
            myStmt.executeUpdate();
            estado=true;
            idPregunta = myStmt.getInt(9);//id last autogenerado
            cerrar();   
        } catch (Exception e) {
            System.out.println("--->"+e);
            estado=false;
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return estado;
    }

    @Override
    public List<Pregunta> Read() {
        List<Pregunta> listaPregunta= null;
        Pregunta pregunta;
        try {
            conectar();
            listaPregunta=new ArrayList<>();
            myStmt = conexion.prepareCall("{call preguntaRead()}");
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
    
    public List<List<Object>> ReadForCompetencia() {
        List<List<Object>> listaPregunta = null;
        List<Object> pregunta = null;
        try {
            conectar();
            listaPregunta=new ArrayList<>();
            myStmt = conexion.prepareCall("{call preguntaReadForCompetencia()}");
            rs=myStmt.executeQuery();
            while (rs.next()) {
                pregunta = new ArrayList<>();
                pregunta.add(rs.getInt(1));
                pregunta.add(rs.getString(2));
                pregunta.add(rs.getString(3));
                pregunta.add(rs.getString(4));
                pregunta.add(rs.getString(5));
                pregunta.add(rs.getString(6));
                pregunta.add(rs.getString(7));
                listaPregunta.add(pregunta);
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaPregunta;
    }

    @Override
    public boolean Update(Pregunta pregunta_actual, Pregunta pregunta_nuevo) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call preguntaUpdate(?,?,?,?,?,?,?,?)}");
            myStmt.setString(1, pregunta_nuevo.getDescripcion());
            myStmt.setDouble(2, pregunta_nuevo.getDescuido());
            myStmt.setDouble(3, pregunta_nuevo.getAdivinanza());
            myStmt.setInt(4, pregunta_nuevo.getIdNivel());
            myStmt.setInt(5, pregunta_nuevo.getIdEstilo());
            myStmt.setInt(6, pregunta_nuevo.getIdMatriz());
            myStmt.setInt(7, pregunta_nuevo.getIdPeriodo());
            myStmt.setInt(8, pregunta_actual.getIdPregunta());/*primary key*/
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
    public boolean Delete(Pregunta pregunta) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call preguntaDelete(?)}");
            myStmt.setInt(1, pregunta.getIdPregunta());
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

    public int getIdPregunta() { return idPregunta; }

    public List<Pregunta> preguntaEstiloRead(String estilo, int idDocenteAula) {
        List<Pregunta> listaPregunta= null;
        Pregunta pregunta;
        try {
            conectar();
            listaPregunta=new ArrayList<>();
            myStmt = conexion.prepareCall("{call preguntaEstiloRead(?,?)}");
            myStmt.setString(1, estilo);
            myStmt.setInt(2, idDocenteAula);
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