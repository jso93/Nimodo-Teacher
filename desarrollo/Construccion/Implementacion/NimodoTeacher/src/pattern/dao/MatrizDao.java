package pattern.dao;

import dataSource.Conexion;
import interfaces.ICrudDao;
import java.util.ArrayList;
import java.util.List;
import pattern.model.Area;
import pattern.model.Capacidad;
import pattern.model.Competencia;
import pattern.model.Desempeño;
import pattern.model.Matriz;

public class MatrizDao extends Conexion implements ICrudDao<Matriz>{

    @Override
    public boolean Create(Matriz matriz) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call matrizCreate(?,?,?,?,?)}");
            myStmt.setInt(1, matriz.getIdArea());
            myStmt.setInt(2, matriz.getIdCompetencia());
            myStmt.setInt(3, matriz.getIdCapacidad());
            myStmt.setInt(4, matriz.getIdDesempeño());
            myStmt.setInt(5, matriz.getIdDocenteAula());
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
    public List<Matriz> Read() {
        List<Matriz> listaMatriz =null;
        Matriz matriz;
        try {
            conectar();
            listaMatriz=new ArrayList<>();
            myStmt = conexion.prepareCall("{call matrizRead()}");
            rs=myStmt.executeQuery();
            while (rs.next()) {
                matriz=new Matriz();
                matriz.setIdMatriz(rs.getInt(1));
                matriz.setIdArea(rs.getInt(2));
                matriz.setIdCompetencia(rs.getInt(3));
                matriz.setIdCapacidad(rs.getInt(4));
                matriz.setIdDesempeño(rs.getInt(5));
                matriz.setIdDocenteAula(rs.getInt(6));
                listaMatriz.add(matriz);
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaMatriz;
    }

    @Override
    public boolean Update(Matriz matriz_actual, Matriz matriz_nuevo) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call matrizUpdate(?,?,?,?,?,?)}");
            myStmt.setInt(1, matriz_nuevo.getIdArea());
            myStmt.setInt(2, matriz_nuevo.getIdCompetencia());
            myStmt.setInt(3, matriz_nuevo.getIdCapacidad());
            myStmt.setInt(4, matriz_nuevo.getIdDesempeño());
            myStmt.setInt(5, matriz_nuevo.getIdDocenteAula());
            myStmt.setInt(6, matriz_actual.getIdMatriz());/*primary key*/
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
    public boolean Delete(Matriz matriz) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call matrizDelete(?)}");
            myStmt.setInt(1, matriz.getIdMatriz());
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
    public List<Area> getMatrizAreaRead(int idDocenteAula){
        List<Area> listaArea =null;
        Area area = null;
        try {
            conectar();
            listaArea = new ArrayList<>();
            myStmt = conexion.prepareCall("{call matrizAreaRead(?)}");
            myStmt.setInt(1, idDocenteAula);
            rs=myStmt.executeQuery();
            while (rs.next()) {
                area = new Area();
                area.setIdArea(rs.getInt(1));
                area.setArea(rs.getString(2));
                area.setDescripcion(rs.getString(3));
                listaArea.add(area);
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaArea;
    }
    
    public List<Competencia> getMatrizCompetenciaAreaRead(String area,int idDocenteAula){
        List<Competencia> listaCompetencia =null;
        Competencia competencia = null;
        try {
            conectar();
            listaCompetencia = new ArrayList<>();
            myStmt = conexion.prepareCall("{call matrizCompetenciaAreaDocenteRead(?,?)}");
            myStmt.setString(1, area);
            myStmt.setInt(2, idDocenteAula);
            rs=myStmt.executeQuery();
            while (rs.next()) {
                competencia = new Competencia();
                competencia.setCompetencia(rs.getString(1));
                competencia.setIdCompetencia(rs.getInt(2));
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
    
    public List<Capacidad> getMatrizCapacidadCompetenciaRead(String area,String competencia,int idDocenteAula){
        List<Capacidad> listaCapacidad =null;
        Capacidad capacidad = null;
        try {
            conectar();
            listaCapacidad = new ArrayList<>();
            myStmt = conexion.prepareCall("{call matrizCapacidadCompetenciaRead(?,?,?)}");
            myStmt.setString(1, area);
            myStmt.setString(2, competencia);
            myStmt.setInt(3, idDocenteAula);
            rs=myStmt.executeQuery();
            while (rs.next()) {
                capacidad = new Capacidad();
                capacidad.setCapacidad(rs.getString(1));
                capacidad.setIdCapacidad(rs.getInt(2));
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
    
    public List<Desempeño> getMatrizDesempeñoCapacidadRead(String area,String competencia,String capacidad,int idDocenteAula){
        List<Desempeño> listaDesempeño =null;
        Desempeño desempeño = null;
        try {
            conectar();
            listaDesempeño = new ArrayList<>();
            myStmt = conexion.prepareCall("{call matrizDesempeñoCapacidadRead(?,?,?,?)}");
            myStmt.setString(1, area);
            myStmt.setString(2, competencia);
            myStmt.setString(3, capacidad);
            myStmt.setInt(4, idDocenteAula);
            rs=myStmt.executeQuery();
            while (rs.next()) {
                desempeño = new Desempeño();
                desempeño.setDesempeño(rs.getString(1));
                desempeño.setIdDesempeño(rs.getInt(2));
                desempeño.setDescripcion(rs.getString(3));
                listaDesempeño.add(desempeño);
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaDesempeño;
    }
    
    public List<Boolean> getMatrizCompetenciaBimestreRead(int idCompetencia,int idDocenteAula){
        List<Boolean> estadoBimestre =null;
        try {
            conectar();
            estadoBimestre = new ArrayList<>();
            myStmt = conexion.prepareCall("{call matrizCompetenciaBimestreRead(?,?)}");
            myStmt.setInt(1, idCompetencia);
            myStmt.setInt(2, idDocenteAula);
            rs=myStmt.executeQuery();
            while (rs.next()) {
                estadoBimestre.add(rs.getBoolean(2));
                estadoBimestre.add(rs.getBoolean(3));
                estadoBimestre.add(rs.getBoolean(4));
                estadoBimestre.add(rs.getBoolean(5));
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return estadoBimestre;
    }
    
    public boolean getMatrizCompetenciaBimestreUpdate(int idcompetencia, int idDocenteAula, boolean primer_bimestre, boolean segundo_bimestre, boolean tercer_bimestre, boolean cuarto_bimestre) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call matrizCompetenciaBimestreUpdate(?,?,?,?,?,?)}");
            myStmt.setInt(1, idcompetencia);
            myStmt.setInt(2, idDocenteAula);
            myStmt.setBoolean(3, primer_bimestre);
            myStmt.setBoolean(4, segundo_bimestre);
            myStmt.setBoolean(5, tercer_bimestre);
            myStmt.setBoolean(6, cuarto_bimestre);
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
    
    public int getMatrizCompetenciaTiempoRead(int idCompetencia,int idDocenteAula){
        int tiempo = 0;
        try {
            conectar();
            myStmt = conexion.prepareCall("{call matrizCompetenciaTiempoRead(?,?)}");
            myStmt.setInt(1, idCompetencia);
            myStmt.setInt(2, idDocenteAula);
            rs=myStmt.executeQuery();
            while (rs.next()) {
                tiempo = rs.getInt(2);
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return tiempo;
    }
    
    public boolean getMatrizCompetenciaTiempoUpdate(int idDocenteAula,int tiempo) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call matrizCompetenciaTiempoUpdate(?,?)}");
            myStmt.setInt(1, idDocenteAula);
            myStmt.setInt(2, tiempo);
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
