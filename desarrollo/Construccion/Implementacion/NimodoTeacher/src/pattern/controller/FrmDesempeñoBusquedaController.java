package pattern.controller;

import interfaces.IView;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import pattern.dao.DocenteAulaDao;
import pattern.dao.MatrizDao;
import pattern.model.Area;
import pattern.model.Capacidad;
import pattern.model.Competencia;
import pattern.model.Desempeño;
import pattern.model.Matriz;
import pattern.view.FrmDesempeñoBusqueda;
import pattern.view.FrmPreguntaAuditiva;
import pattern.view.FrmPreguntaVisual;

public class FrmDesempeñoBusquedaController implements IView,ItemListener{
    //view
    private final FrmDesempeñoBusqueda frmDesempeñoBusqueda;
    private FrmPreguntaAuditiva frmPreguntaAuditiva;
    private FrmPreguntaVisual frmPreguntaVisual;
    //dao
    private final MatrizDao matrizDao;
    private final DocenteAulaDao docenteAulaDao;
    //variables
    private List<Matriz> listaMatriz;
    private List<Area> listaArea;
    private List<Competencia> listaCompetencias;
    private List<Capacidad> listaCapacidades;
    private List<Desempeño> listaDesempeños;
    private List<List<String>> listaDocente;
    private String dniDocente;
    private final Object frmPregunta;
    private final List<String> persona;
    private int idArea,idCompetencia,idCapacidad,idDesempeño,idMatriz;
    private String area,competencia,capacidad,desempeño;
    private int idDocenteAula;
    
    public FrmDesempeñoBusquedaController(FrmDesempeñoBusqueda frmDesempeñoBusqueda,Object frmPregunta,List<String> persona) {
        this.frmDesempeñoBusqueda = frmDesempeñoBusqueda;
        this.frmPregunta = frmPregunta;
        if(this.frmPregunta.getClass().getName().equals("pattern.view.FrmPreguntaAuditiva")){this.frmPreguntaAuditiva = (FrmPreguntaAuditiva)this.frmPregunta;}
        if(this.frmPregunta.getClass().getName().equals("pattern.view.FrmPreguntaVisual")){this.frmPreguntaVisual = (FrmPreguntaVisual)this.frmPregunta;}
        this.matrizDao = new MatrizDao();
        this.docenteAulaDao = new DocenteAulaDao();
        this.persona = persona;
    }
    
    @Override
    public void initController() {
        frmDesempeñoBusqueda.txtArea.addItemListener(this);
        frmDesempeñoBusqueda.txtCompetencia.addItemListener(this);
        frmDesempeñoBusqueda.txtCapacidad.addItemListener(this);
        frmDesempeñoBusqueda.btnAceptar.addActionListener(e->cargarDesempeño());
    }

    @Override
    public void refreshView() {
        getDocenteAula();
        getMatriz();
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource().equals(frmDesempeñoBusqueda.txtArea) ){
            if (e.getStateChange() == ItemEvent.SELECTED){
                frmDesempeñoBusqueda.txtCapacidad.removeAllItems();/*limpiamos combo*/
                frmDesempeñoBusqueda.txtDesempenio.removeAllItems();/*limpiamos combo*/
                getCompetencias(frmDesempeñoBusqueda.txtArea.getSelectedItem().toString());
            }
        }
        if(e.getSource().equals(frmDesempeñoBusqueda.txtCompetencia) ){
            if (e.getStateChange() == ItemEvent.SELECTED){
                frmDesempeñoBusqueda.txtDesempenio.removeAllItems();//limpiamos combo
                getCapacidades(frmDesempeñoBusqueda.txtArea.getSelectedItem().toString(),frmDesempeñoBusqueda.txtCompetencia.getSelectedItem().toString());
            }
        }
        if(e.getSource().equals(frmDesempeñoBusqueda.txtCapacidad) ){
            if (e.getStateChange() == ItemEvent.SELECTED){
                getDesempeños(frmDesempeñoBusqueda.txtArea.getSelectedItem().toString(),frmDesempeñoBusqueda.txtCompetencia.getSelectedItem().toString(),frmDesempeñoBusqueda.txtCapacidad.getSelectedItem().toString());
            }
        }
    }
    public void getMatriz(){
        if(listaMatriz!=null)listaMatriz.clear(); 
        listaMatriz = matrizDao.Read();
        getAreas();
    }
    public void getAreas(){
        if(listaArea!=null)listaArea.clear(); 
        frmDesempeñoBusqueda.txtArea.removeAllItems();//limpiamos combo
        listaArea = matrizDao.getMatrizAreaRead(idDocenteAula);
        for(int i=0;i<listaArea.size();i++){
            frmDesempeñoBusqueda.txtArea.addItem(listaArea.get(i).getArea());
        }
    }
    
    public void getCompetencias(String area){
        if(listaCompetencias!=null)listaCompetencias.clear(); 
        frmDesempeñoBusqueda.txtCompetencia.removeAllItems();//limpiamos combo
        listaCompetencias = matrizDao.getMatrizCompetenciaAreaRead(area,idDocenteAula);
        for (int i = 0; i < listaCompetencias.size(); i++) {
            frmDesempeñoBusqueda.txtCompetencia.addItem(listaCompetencias.get(i).getCompetencia());
        }
    }
    
    public void getCapacidades(String area,String competencia){
        if(listaCapacidades!=null)listaCapacidades.clear(); 
        frmDesempeñoBusqueda.txtCapacidad.removeAllItems();//limpiamos combo
        listaCapacidades = matrizDao.getMatrizCapacidadCompetenciaRead(area,competencia,idDocenteAula);
        for (int i = 0; i < listaCapacidades.size(); i++) {
            frmDesempeñoBusqueda.txtCapacidad.addItem(listaCapacidades.get(i).getCapacidad());
        }
    }
    
    public void getDesempeños(String area, String competencia, String capacidad){
        if(listaDesempeños!=null)listaDesempeños.clear(); 
        frmDesempeñoBusqueda.txtDesempenio.removeAllItems();//limpiamos combo
        listaDesempeños = matrizDao.getMatrizDesempeñoCapacidadRead(area,competencia,capacidad,idDocenteAula);
        for (int i = 0; i < listaDesempeños.size(); i++) {
            frmDesempeñoBusqueda.txtDesempenio.addItem(listaDesempeños.get(i).getDesempeño());
        }
    }
    
    public void cargarDesempeño(){
        if(listaDesempeños.size()>0){
            area = frmDesempeñoBusqueda.txtArea.getSelectedItem().toString();
            competencia = frmDesempeñoBusqueda.txtCompetencia.getSelectedItem().toString();
            capacidad = frmDesempeñoBusqueda.txtCapacidad.getSelectedItem().toString();
            desempeño = frmDesempeñoBusqueda.txtDesempenio.getSelectedItem().toString();
            //idArea
            for (int i = 0; i < listaArea.size(); i++) {
                if(listaArea.get(i).getArea().equals(area)){idArea = listaArea.get(i).getIdArea();break;}
            }
            //idCompetencia
            for (int i = 0; i < listaCompetencias.size(); i++) {
                if(listaCompetencias.get(i).getCompetencia().equals(competencia)){idCompetencia = listaCompetencias.get(i).getIdCompetencia();break;}
            }
            //idCapacidad
            for (int i = 0; i < listaCapacidades.size(); i++) {
                if(listaCapacidades.get(i).getCapacidad().equals(capacidad)){idCapacidad = listaCapacidades.get(i).getIdCapacidad();break;}
            }
            //idDesempeño
            for (int i = 0; i < listaDesempeños.size(); i++) {
                if(listaDesempeños.get(i).getDesempeño().equals(desempeño)){idDesempeño = listaDesempeños.get(i).getIdDesempeño();break;}
            }
            
            //idMatriz
            for (int i = 0; i < listaMatriz.size(); i++) {
                if(idArea == listaMatriz.get(i).getIdArea() && idCompetencia == listaMatriz.get(i).getIdCompetencia() && 
                   idCapacidad == listaMatriz.get(i).getIdCapacidad() && idDesempeño == listaMatriz.get(i).getIdDesempeño()){
                    idMatriz = listaMatriz.get(i).getIdMatriz();//recuperamos idMatriz
                    break;
                }
            }
            //seteamos datos en el formulario pregunta
            for (int i = 0; i < listaDesempeños.size(); i++) {
                if(listaDesempeños.get(i).getDesempeño().equals(frmDesempeñoBusqueda.txtDesempenio.getSelectedItem().toString())){
                    if(frmPregunta.getClass().getName().equals("pattern.view.FrmPreguntaAuditiva")){
                    frmPreguntaAuditiva.txtDesempenio.setText(listaDesempeños.get(i).getDesempeño());
                    frmPreguntaAuditiva.txtDesempeñoDescripcion.setText(listaDesempeños.get(i).getDescripcion()); 
                    frmPreguntaAuditiva.idMatriz.setText(""+idMatriz);
                    }
                    if(frmPregunta.getClass().getName().equals("pattern.view.FrmPreguntaVisual")){
                    frmPreguntaVisual.txtDesempenio.setText(listaDesempeños.get(i).getDesempeño());
                    frmPreguntaVisual.txtDesempeñoDescripcion.setText(listaDesempeños.get(i).getDescripcion());   
                    frmPreguntaVisual.idMatriz.setText(""+idMatriz);
                    }
                    break;
                }
            }
            frmDesempeñoBusqueda.dispose();//cerramos jdialog
        }
    }
    
    public void getDocenteAula(){
        dniDocente = persona.get(0);
        if(listaDocente!=null)listaDocente.clear(); 
        listaDocente = docenteAulaDao.docentesConAula();
        for (int i = 0; i < listaDocente.size(); i++) {
            if(listaDocente.get(i).get(0).equals(dniDocente)){
                idDocenteAula = Integer.parseInt(listaDocente.get(i).get(5));break;
            }
        }
    }
}
