package pattern.dao;

import dataSource.Conexion;
import interfaces.ICrudDao;
import java.util.ArrayList;
import java.util.List;
import pattern.model.Persona;

public class EstudianteDao extends Conexion implements ICrudDao<Persona>{

    @Override
    public boolean Create(Persona estudiante) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call personaCreate(?,?,?,?,?,?)}");
            myStmt.setString(1, estudiante.getDni());
            myStmt.setString(2, estudiante.getNombres());
            myStmt.setString(3, estudiante.getApellidos());
            myStmt.setString(4, estudiante.getUser());
            myStmt.setString(5, estudiante.getPassword());
            myStmt.setString(6, "Estudiante");
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
    public List<Persona> Read() {
        List<Persona> listaEstudiante= null;
        Persona estudiante;
        try {
            conectar();
            listaEstudiante=new ArrayList<>();
            myStmt = conexion.prepareCall("{call estudianteRead()}");
            rs=myStmt.executeQuery();
            while (rs.next()) {
                estudiante=new Persona();
                estudiante.setDni(rs.getString(1));
                estudiante.setNombres(rs.getString(2));
                estudiante.setApellidos(rs.getString(3));
                estudiante.setUser(rs.getString(4));
                estudiante.setPassword(rs.getString(5));
                listaEstudiante.add(estudiante);
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaEstudiante;
    }

    @Override
    public boolean Update(Persona estudiante_actual, Persona estudiante_nuevo) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call personaUpdate(?,?,?,?,?,?)}");
            myStmt.setString(1, estudiante_nuevo.getDni());
            myStmt.setString(2, estudiante_nuevo.getNombres());
            myStmt.setString(3, estudiante_nuevo.getApellidos());
            myStmt.setString(4, estudiante_nuevo.getUser());
            myStmt.setString(5, estudiante_nuevo.getPassword());
            myStmt.setString(6, estudiante_actual.getDni());/*primary key*/
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
    public boolean Delete(Persona estudiante) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call personaDelete(?)}");
            myStmt.setString(1, estudiante.getDni());
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