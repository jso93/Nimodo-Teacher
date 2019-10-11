package pattern.dao;

import dataSource.Conexion;
import interfaces.ICrudDao;
import java.util.ArrayList;
import java.util.List;
import pattern.model.Audio;

public class AudioDao extends Conexion implements ICrudDao<Audio>{

    @Override
    public boolean Create(Audio audio) {
        try {
            conectar();
            myStmt = conexion.prepareCall("{call audioCreate(?,?)}");
            myStmt.setString(1, audio.getAudio());
            myStmt.setInt(2, audio.getIdPregunta());
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
    public List<Audio> Read() {
        List<Audio> listaAudio= null;
        Audio audio;        
        try {
            conectar();
            listaAudio=new ArrayList<>();
            myStmt = conexion.prepareCall("{call audioRead()}");
            rs=myStmt.executeQuery();
            while (rs.next()) {
                audio=new Audio();
                audio.setIdAudio(rs.getInt(1));
                audio.setAudio(rs.getString(2));
                audio.setIdPregunta(rs.getInt(3));
                listaAudio.add(audio);
            }
            cerrar();
        } catch (Exception e) {
            System.out.println("--->"+e);
            try {cerrar();} catch (Exception ex) { System.out.println(ex); }
        }
        return listaAudio;
    }

    @Override public boolean Update(Audio object_actual, Audio object_nuevo) { return estado; }

    @Override public boolean Delete(Audio object) { return estado; }
    
}
