package pattern.dao;

import java.util.ArrayList;
import java.util.List;
import dataSource.Conexion;
import interfaces.ICrudDao;
import pattern.model.Aula;

public class AulaDao extends Conexion implements ICrudDao<Aula>{

    @Override
    public boolean Create(Aula aula) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call aulaCreate(?,?)}");
            myStmt.setInt(1, aula.getIdGrado());
            myStmt.setInt(2, aula.getIdSeccion());
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
    public boolean Update(Aula aula_actual, Aula aula_nuevo) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call aulaUpdate(?,?,?)}");
            myStmt.setInt(1, aula_nuevo.getIdGrado());
            myStmt.setInt(2, aula_nuevo.getIdSeccion());
            myStmt.setInt(3, aula_actual.getIdAula());/*primary key*/
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
    public boolean Delete(Aula aula) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call aulaDelete(?)}");
            myStmt.setInt(1, aula.getIdAula());
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
    public List<Aula> Read() {
        List<Aula>listaAula=null;
        Aula aula;
        try {
            conectar();
            listaAula=new ArrayList<>();
            myStmt = conexion.prepareCall("{call aulaRead()}");
            rs=myStmt.executeQuery();
            while (rs.next()) {
                aula=new Aula();
                aula.setIdAula(rs.getInt(1));
                aula.setIdGrado(rs.getInt(2));
                aula.setIdSeccion(rs.getInt(3));
                listaAula.add(aula);
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaAula;
    }
    
    public List<String> aulaGrado(){
        List<String> listaGrado = null;
        try {
            conectar();
            listaGrado=new ArrayList<>();
            myStmt = conexion.prepareCall("{call aulaGradoRead()}");
            rs=myStmt.executeQuery();
            while (rs.next()) {
                listaGrado.add(rs.getString(1));
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaGrado;
    }
    
    public List<String> aulaSeccion(String grado){
        List<String> listaSeccion = null;
        try {
            conectar();
            listaSeccion=new ArrayList<>();
            myStmt = conexion.prepareCall("{call aulaSeccionRead(?)}");
            myStmt.setString(1, grado);
            rs=myStmt.executeQuery();
            while (rs.next()) {
                listaSeccion.add(rs.getString(1));
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaSeccion;
    }
}
