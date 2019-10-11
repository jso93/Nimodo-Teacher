package pattern.dao;

import dataSource.Conexion;
import interfaces.ICrudDao;
import java.util.ArrayList;
import java.util.List;
import pattern.model.Imagen;

public class ImagenDao extends Conexion implements ICrudDao<Imagen>{

    @Override
    public boolean Create(Imagen imagen) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call imagenCreate(?,?)}");
            myStmt.setString(1, imagen.getImagen());
            myStmt.setInt(2, imagen.getIdPregunta());
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
    public List<Imagen> Read() {
        List<Imagen> listaImagen= null;
        Imagen imagen;        
        try {
            conectar();
            listaImagen=new ArrayList<>();
            myStmt = conexion.prepareCall("{call imagenRead()}");
            rs=myStmt.executeQuery();
            while (rs.next()) {
                imagen=new Imagen();
                imagen.setIdImagen(rs.getInt(1));
                imagen.setImagen(rs.getString(2));
                imagen.setIdPregunta(rs.getInt(3));
                listaImagen.add(imagen);
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaImagen;
    }

    @Override public boolean Update(Imagen imagen_actual, Imagen imagen_nuevo) { return estado;}

    @Override public boolean Delete(Imagen imagen) {return estado;}   
}
