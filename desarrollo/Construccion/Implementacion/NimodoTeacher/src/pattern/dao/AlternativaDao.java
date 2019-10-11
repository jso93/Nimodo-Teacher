package pattern.dao;

import dataSource.Conexion;
import interfaces.ICrudDao;
import java.util.ArrayList;
import java.util.List;
import pattern.model.Alternativa;

public class AlternativaDao extends Conexion implements ICrudDao<Alternativa>{

    @Override
    public boolean Create(Alternativa alternativa) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call alternativaCreate(?,?,?)}");
            myStmt.setString(1, alternativa.getDescripcion());
            myStmt.setBoolean(2, alternativa.isSuccess());
            myStmt.setInt(3, alternativa.getIdPregunta());
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
    public List<Alternativa> Read() {
        List<Alternativa> listaAlternativa= null;
        Alternativa alternativa;        
        try {
            conectar();
            listaAlternativa=new ArrayList<>();
            myStmt = conexion.prepareCall("{call alternativaRead()}");
            rs=myStmt.executeQuery();
            while (rs.next()) {
                alternativa=new Alternativa();
                alternativa.setIdAlternativa(rs.getInt(1));
                alternativa.setDescripcion(rs.getString(2));
                alternativa.setSuccess(rs.getBoolean(3));
                alternativa.setIdPregunta(rs.getInt(4));
                listaAlternativa.add(alternativa);
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaAlternativa;
    }

    @Override
    public boolean Update(Alternativa alternativa_actual, Alternativa alternativa_nuevo) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call alternativaUpdate(?,?,?)}");
            myStmt.setString(1, alternativa_nuevo.getDescripcion());
            myStmt.setBoolean(2, alternativa_nuevo.isSuccess());
            myStmt.setInt(3, alternativa_actual.getIdAlternativa());/*primary key*/
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

    @Override  public boolean Delete(Alternativa alternativa) { return estado; }
    
}
