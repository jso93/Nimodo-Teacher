package pattern.dao;

import dataSource.Conexion;
import interfaces.ICrudDao;
import java.util.ArrayList;
import java.util.List;
import pattern.model.Persona;

public class DocenteDao extends Conexion implements ICrudDao<Persona>{

    @Override
    public boolean Create(Persona docente) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call personaCreate(?,?,?,?,?,?)}");
            myStmt.setString(1, docente.getDni());
            myStmt.setString(2, docente.getNombres());
            myStmt.setString(3, docente.getApellidos());
            myStmt.setString(4, docente.getUser());
            myStmt.setString(5, docente.getPassword());
            myStmt.setString(6, "Docente");
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
        List<Persona> listaDocente= null;
        Persona docente;
        try {
            conectar();
            listaDocente=new ArrayList<>();
            myStmt = conexion.prepareCall("{call docenteRead()}");
            rs=myStmt.executeQuery();
            while (rs.next()) {
                docente=new Persona();
                docente.setDni(rs.getString(1));
                docente.setNombres(rs.getString(2));
                docente.setApellidos(rs.getString(3));
                docente.setUser(rs.getString(4));
                docente.setPassword(rs.getString(5));
                listaDocente.add(docente);
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaDocente;
    }

    @Override
    public boolean Update(Persona docente_actual, Persona docente_nuevo) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call personaUpdate(?,?,?,?,?,?)}");
            myStmt.setString(1, docente_nuevo.getDni());
            myStmt.setString(2, docente_nuevo.getNombres());
            myStmt.setString(3, docente_nuevo.getApellidos());
            myStmt.setString(4, docente_nuevo.getUser());
            myStmt.setString(5, docente_nuevo.getPassword());
            myStmt.setString(6, docente_actual.getDni());/*primary key*/
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
    public boolean Delete(Persona docente) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call personaDelete(?)}");
            myStmt.setString(1, docente.getDni());
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
