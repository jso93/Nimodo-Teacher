package pattern.dao;

import java.util.List;
import dataSource.Conexion;
import interfaces.ICrudDao;
import java.util.ArrayList;
import pattern.model.DocenteAula;

public class DocenteAulaDao extends Conexion implements ICrudDao<DocenteAula>{
    
    @Override
    public boolean Create(DocenteAula docenteAula) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call docenteAulaCreate(?,?,?)}");
            myStmt.setString(1, docenteAula.getFecha());
            myStmt.setInt(2, docenteAula.getIdPerfil());
            myStmt.setInt(3, docenteAula.getIdAula());
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
    
    @Override public boolean Update(DocenteAula docente_actual, DocenteAula docente_nuevo) {return estado;}
    
    @Override
    public boolean Delete(DocenteAula docenteAula) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call docenteAulaDelete(?)}");
            myStmt.setInt(1, docenteAula.getIdDocenteAula());
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
    
    @Override public List<DocenteAula> Read() {List<DocenteAula>listaDocenteAula=null;return listaDocenteAula;}
    
    public List<List<String>> docentesConAula(){
        List<List<String>> listaDocente = null;
        List<String> docente = null;
        try {
            conectar();
            listaDocente=new ArrayList<>();
            myStmt = conexion.prepareCall("{call docenteConAulaRead()}");
            rs=myStmt.executeQuery();
            while (rs.next()) {
                docente = new ArrayList<>();
                docente.add(rs.getString(1));
                docente.add(rs.getString(2));
                docente.add(rs.getString(3));
                docente.add(rs.getString(4));
                docente.add(rs.getString(5));
                docente.add(rs.getString(6));
                listaDocente.add(docente);
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaDocente;
    }
    
    public List<List<String>> docentesSinAula(){
        List<List<String>> listaDocente = null;
        List<String> docente  = null;
        try {
            conectar();
            listaDocente=new ArrayList<>();
            myStmt = conexion.prepareCall("{call docenteSinAulaRead()}");
            rs=myStmt.executeQuery();
            while (rs.next()) {
                docente = new ArrayList<>();
                docente.add(rs.getString(1));
                docente.add(rs.getString(2));
                docente.add(rs.getString(3));
                docente.add(rs.getString(4));
                listaDocente.add(docente);
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaDocente;
    }
}
