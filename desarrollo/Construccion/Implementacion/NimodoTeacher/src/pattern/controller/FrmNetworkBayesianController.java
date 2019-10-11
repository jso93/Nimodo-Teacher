package pattern.controller;

import interfaces.IView;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import pattern.dao.AlternativaDao;
import pattern.dao.DocenteAulaDao;
import pattern.dao.EstiloDao;
import pattern.dao.EstudianteMatriculaDao;
import pattern.dao.EvaluacionAdaptativaDao;
import pattern.dao.ImagenDao;
import pattern.dao.MatrizDao;
import pattern.dao.NivelDao;
import pattern.dao.PeriodoDao;
import pattern.dao.PreguntaDao;
import pattern.model.Alternativa;
import pattern.model.Area;
import pattern.model.Capacidad;
import pattern.model.Competencia;
import pattern.model.Estilo;
import pattern.model.Imagen;
import pattern.model.Desempeño;
import pattern.model.Matriz;
import pattern.model.Nivel;
import pattern.model.Periodo;
import pattern.model.Pregunta;
import pattern.model.networkBayesian.NetworkBayesianController;
import pattern.view.FrmNetworkBayesian;

public class FrmNetworkBayesianController implements IView,ItemListener{
    //model
    private final NetworkBayesianController panel;
    //view
    private final FrmNetworkBayesian frmNetworkBayesian;
    //dao
    private final EstudianteMatriculaDao estudianteMatriculaDao;
    private final DocenteAulaDao docenteAulaDao;
    private final PeriodoDao periodoDao;
    private final MatrizDao matrizDao;
    private final PreguntaDao preguntaDao;
    private final AlternativaDao alternativaDao;
    private final NivelDao nivelDao;
    private final EstiloDao estiloDao;
    private final EvaluacionAdaptativaDao evaluacionAdaptativaDao;
    //variables
    private final List<String> persona;
    private List<List<String>> listaEstudiante;
    private List<List<String>> listaDocente;
    private List<List<String>> listaEstudianteMatriculado;
    private List<Periodo> listaPeriodo;
    private List<Matriz> listaMatriz;
    private final ImagenDao imagenDao;
    private List<List<Object>> listaEvaluacionAdaptativa;
    private List<Area> listaArea;
    private List<Competencia> listaCompetencias;
    private List<Capacidad> listaCapacidades;
    private List<Desempeño> listaDesempeñoAux;
    private final List<List<Object>> listaCapacidadCompetencia;
    private final List<List<Object>> listaDesempeñoCapacidad;
    private List<Pregunta> listaPregunta;
    private List<List<Object>> listaPreguntaDesempeño;
    private List<Object> preguntaDesempeño;
    private List<Alternativa> listaAlternativa;
    private List<Nivel> listaNivel;
    private List<Estilo> listaEstilo;
    private List<Imagen> listaImagen;
    private List<List<Object>> listaPreguntaEA;//lista preguntas de todas las evaluaciones adaptativas
    private List<List<Object>> preguntaInicio ;
    private List<List<Object>> preguntaProceso;
    private List<List<Object>> preguntaSatisfactorio;
    private String dniEstudiante;
    private String grado,seccion;
    private String estudiante;
    private int idDocenteAula;
    private String dniDocente;
    private String area;
    private String periodo;   

    public FrmNetworkBayesianController(FrmNetworkBayesian frmNetworkBayesian,FrmPrincipalController frmPrincipalController,List<String> persona) {
        this.frmNetworkBayesian = frmNetworkBayesian;
        this.persona = persona;
        this.panel = new NetworkBayesianController(frmPrincipalController);
        this.matrizDao = new MatrizDao();
        this.preguntaDao = new PreguntaDao();
        this.alternativaDao = new AlternativaDao();
        this.nivelDao = new NivelDao();
        this.estiloDao = new EstiloDao();
        this.evaluacionAdaptativaDao = new EvaluacionAdaptativaDao();
        this.estudianteMatriculaDao = new EstudianteMatriculaDao();
        this.docenteAulaDao = new DocenteAulaDao();
        this.periodoDao = new PeriodoDao();
        this.imagenDao = new ImagenDao();
        this.listaCapacidadCompetencia = new ArrayList<>();
        this.listaDesempeñoCapacidad = new ArrayList<>();
    }
    
    @Override
    public void initController() {
        //events
        frmNetworkBayesian.btnConsultar.addActionListener(e -> NetworkBayesian());
        frmNetworkBayesian.txtEstudiante.addItemListener(this);
        frmNetworkBayesian.txtArea.addItemListener(this);
        frmNetworkBayesian.txtPeriodo.addItemListener(this);
        //properties
        panel.setPreferredSize(new Dimension(9000, 4096));
        frmNetworkBayesian.scroll.setViewportView(panel);
        frmNetworkBayesian.scroll.setPreferredSize(new Dimension(750, 500));
        frmNetworkBayesian.scroll.getViewport().setViewPosition(new Point(4100, 0));
    }

    @Override   public void refreshView() {Clear();}

    public void Read() {
        getDocenteAula();
        getPeriodo();
        getEstudianteMatriculado();
        getImagen();
        /*matriz*/
        getMatriz();
        getPregunta();
        getAlternativa();
        getNivel();
        getEstilo();        
        panel.reset();
    }

    public void Clear() {
        Read();
    }
    
    public void NetworkBayesian(){        
        int idEstudianteMatricula = frmNetworkBayesian.txtEstudiante.getSelectedIndex();
        for(int i=0;i<listaEstudianteMatriculado.size();i++){
            if(idEstudianteMatricula == i){
                idEstudianteMatricula=Integer.parseInt(listaEstudianteMatriculado.get(i).get(5));
                System.out.println("DNI:"+listaEstudianteMatriculado.get(i).get(0));
                System.out.println("NOMBRES:"+listaEstudianteMatriculado.get(i).get(1));
                System.out.println("APELLIDOS:"+listaEstudianteMatriculado.get(i).get(2));
                dniEstudiante = listaEstudianteMatriculado.get(i).get(0);
            }
        }
        area = frmNetworkBayesian.txtArea.getSelectedItem().toString();
        periodo = frmNetworkBayesian.txtPeriodo.getSelectedItem().toString();        
        listaPreguntaDesempeño = new ArrayList<>();
        listaPreguntaEA = evaluacionAdaptativaDao.getPreguntaAreaRead(idEstudianteMatricula,idDocenteAula, area,periodo);
        if(listaPreguntaEA.size()>0){
            for (int i = 0; i < listaPreguntaEA.size(); i++) {
                for (int j = 0; j < listaAlternativa.size(); j++) {
                    for (int k = 0; k < listaPregunta.size(); k++) {
                        int idPregunta = listaAlternativa.get(j).getIdPregunta();
                        int idAlternativa = Integer.parseInt(listaPreguntaEA.get(i).get(2).toString());
                        if (idAlternativa == listaAlternativa.get(j).getIdAlternativa() && idPregunta == listaPregunta.get(k).getIdPregunta()){
                            int idNivel = listaPregunta.get(k).getIdNivel();
                            int idEstilo = listaPregunta.get(k).getIdEstilo();
                            String nivel =null,estilo=null;
                            for (int l = 0; l < listaNivel.size(); l++) {
                                if(idNivel == listaNivel.get(l).getIdNivel())nivel = listaNivel.get(l).getNivel();
                            }
                            for (int l = 0; l < listaEstilo.size(); l++) {
                                if(idEstilo == listaEstilo.get(l).getIdEstilo())estilo = listaEstilo.get(l).getEstilo();
                            }
                            System.out.println("idmatriz:"+listaPregunta.get(k).getIdMatriz()+"pregunta:"+listaPregunta.get(k).getDescripcion()+" idpregunta:"+listaPregunta.get(k).getIdPregunta()+" nivel: "+nivel+" estilo:"+estilo+" success:"+listaAlternativa.get(j).isSuccess()+" conocimientoaposteriori:"+listaPreguntaEA.get(i).get(3)+" tiempo:"+listaPreguntaEA.get(i).get(4)+" idevaluacionadaptativa:"+listaPreguntaEA.get(i).get(0));
                            preguntaDesempeño = new ArrayList<>();
                            preguntaDesempeño.add(listaPregunta.get(k).getIdPregunta());
                            preguntaDesempeño.add(listaPregunta.get(k).getDescripcion());
                            preguntaDesempeño.add(nivel);
                            preguntaDesempeño.add(estilo);
                            preguntaDesempeño.add(listaAlternativa.get(j));
                            preguntaDesempeño.add(listaPreguntaEA.get(i).get(3));
                            preguntaDesempeño.add(listaPreguntaEA.get(i).get(4));
                            preguntaDesempeño.add(listaPregunta.get(k).getIdMatriz());
                            preguntaDesempeño.add(listaPreguntaEA.get(i).get(0));//idevaluacionAdptativa
                            listaPreguntaDesempeño.add(preguntaDesempeño);//agregamos pregunta
                        }
                    }
                }
            }
        }
        getCompetencias(area);//consultamos competencias por area
        getEvaluacionAdaptativa();//consultamos evaluaciones adapttivs
        //PREGUNTAS POR DESEMPEÑO
        System.out.println("********************************");
        for (int i = 0; i < listaDesempeñoCapacidad.size(); i++) {
            for (int j = 0; j < listaMatriz.size(); j++) {
                Desempeño desempeño =(Desempeño)listaDesempeñoCapacidad.get(i).get(2);
                if(desempeño.getIdDesempeño() == listaMatriz.get(j).getIdDesempeño()){
                    System.out.println("Desempeño: "+desempeño.getDesempeño());
                    preguntaInicio = new ArrayList<>(); 
                    preguntaProceso = new ArrayList<>(); 
                    preguntaSatisfactorio = new ArrayList<>(); 
                    for (int k = 0; k < listaPreguntaDesempeño.size(); k++) {
                        int idMatriz = Integer.parseInt(listaPreguntaDesempeño.get(k).get(7).toString());
                        if(listaMatriz.get(j).getIdMatriz() == idMatriz){
                            System.out.println("\tpregunta:"+listaPreguntaDesempeño.get(k).get(1));
                            if(listaPreguntaDesempeño.get(k).get(2).equals("En Inicio")){preguntaInicio.add(listaPreguntaDesempeño.get(k));}
                            if(listaPreguntaDesempeño.get(k).get(2).equals("En Proceso")){preguntaProceso.add(listaPreguntaDesempeño.get(k));}
                            if(listaPreguntaDesempeño.get(k).get(2).equals("Satisfactorio")){preguntaSatisfactorio.add(listaPreguntaDesempeño.get(k));}
                        }
                    }
                    getConocimientoAPosterioriDesempeño(i,preguntaInicio,preguntaProceso,preguntaSatisfactorio);
                    break;
                }
            }
        }
        /////DRAW NETWORK BAYESIAN
        panel.drawNetworkBayesian(listaDesempeñoCapacidad,listaCapacidadCompetencia,listaCompetencias,area,periodo,dniEstudiante,idDocenteAula,dniDocente,listaPreguntaDesempeño,listaEvaluacionAdaptativa,grado,seccion,estudiante,listaImagen,listaAlternativa);
    }
    
    public void getConocimientoAPosterioriDesempeño(int indice,List<List<Object>> preguntaInicio,List<List<Object>> preguntaProceso,List<List<Object>> preguntaSatisfactorio){
        boolean estadoNivelInicio = false;
        boolean estadoNivelProceso = false;
        boolean estadoSatisfactorio = false;
        double nivelInicio = 0.55;
        double nivelProceso = 0.25;
        double nivelSatisfactorio = 0.20;
        double nivelConocimientoDesempeño = 0.0;
        double sumaInicio = 0.0;
        double sumaProceso = 0.0;
        double sumaSatisfactorio = 0.0;
        //nivel inicio
        if(preguntaInicio.size()>0){
            estadoNivelInicio = true;
            for (int i = 0; i < preguntaInicio.size(); i++) {
                double conocimientoPregunta =Double.parseDouble(preguntaInicio.get(i).get(5).toString());
                sumaInicio+=conocimientoPregunta;
            }
            nivelConocimientoDesempeño = nivelConocimientoDesempeño + (sumaInicio/preguntaInicio.size())*nivelInicio;
            nivelConocimientoDesempeño = (double)Math.round(nivelConocimientoDesempeño * 10000d) / 10000d;//redondeando a 4 decimales
        }
        //nivel proceso
        if(preguntaProceso.size()>0){
            estadoNivelProceso = true;
            for (int i = 0; i < preguntaProceso.size(); i++) {
                double conocimientoPregunta =Double.parseDouble(preguntaProceso.get(i).get(5).toString());
                sumaProceso+=conocimientoPregunta;
            }
            nivelConocimientoDesempeño = nivelConocimientoDesempeño + (sumaProceso/preguntaProceso.size())*nivelProceso;
            nivelConocimientoDesempeño = (double)Math.round(nivelConocimientoDesempeño * 10000d) / 10000d;//redondeando a 4 decimales
        }
        //nivel satisfactorio
        if(preguntaSatisfactorio.size()>0){
            estadoSatisfactorio = true;
            for (int i = 0; i < preguntaSatisfactorio.size(); i++) {
                double conocimientoPregunta =Double.parseDouble(preguntaSatisfactorio.get(i).get(5).toString());
                sumaSatisfactorio+=conocimientoPregunta;
            }
            nivelConocimientoDesempeño = nivelConocimientoDesempeño + (sumaSatisfactorio/preguntaSatisfactorio.size())*nivelSatisfactorio;
            nivelConocimientoDesempeño = (double)Math.round(nivelConocimientoDesempeño * 10000d) / 10000d;//redondeando a 4 decimales
        }
        //VERIFICAR ESTADOS
        if(!estadoNivelInicio && estadoNivelProceso){
            nivelConocimientoDesempeño = nivelInicio + nivelConocimientoDesempeño;
            nivelConocimientoDesempeño = (double)Math.round(nivelConocimientoDesempeño * 10000d) / 10000d;
        }
        if(!estadoNivelInicio && !estadoNivelProceso && estadoSatisfactorio){
            nivelConocimientoDesempeño = nivelInicio + nivelProceso + nivelConocimientoDesempeño;
            nivelConocimientoDesempeño = (double)Math.round(nivelConocimientoDesempeño * 10000d) / 10000d;
        }
        System.out.println("\tCONOCIMIENTO A POSTERIORI DEL DESEMPEÑO:"+nivelConocimientoDesempeño);
        listaDesempeñoCapacidad.get(indice).set(3, nivelConocimientoDesempeño);
    }
    
    public void getDocenteAula(){
        dniDocente = persona.get(0);
        if(listaDocente!=null)listaDocente.clear(); 
        listaDocente = docenteAulaDao.docentesConAula();
        for (int i = 0; i < listaDocente.size(); i++) {
            if(listaDocente.get(i).get(0).equals(dniDocente)){
                idDocenteAula = Integer.parseInt(listaDocente.get(i).get(5));
                grado = listaDocente.get(i).get(3);
                seccion = listaDocente.get(i).get(4);
                break;
            }
        }
    }
    
    public void getEstudianteMatriculado(){
        if(listaEstudiante!=null)listaEstudiante.clear(); 
        listaEstudiante = estudianteMatriculaDao.estudiantesConMatricula();
        frmNetworkBayesian.txtEstudiante.removeAllItems();//limpiamos combo
        listaEstudianteMatriculado = new ArrayList<>();
        for(int i=0;i<listaEstudiante.size();i++){
            if(grado.equals(listaEstudiante.get(i).get(3)) && seccion.equals(listaEstudiante.get(i).get(4))){
                frmNetworkBayesian.txtEstudiante.addItem(listaEstudiante.get(i).get(1));//new Item(1, "Test")
                listaEstudianteMatriculado.add(listaEstudiante.get(i));
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
        listaArea = matrizDao.getMatrizAreaRead(idDocenteAula);
        frmNetworkBayesian.txtArea.removeAllItems();//limpiamos combo
        for(int i=0;i<listaArea.size();i++){
            frmNetworkBayesian.txtArea.addItem(listaArea.get(i).getArea());
            System.out.println("Area:"+listaArea.get(i).getArea());
        }
    }
    
    public void getPeriodo(){
        if(listaPeriodo!=null)listaPeriodo.clear(); 
        frmNetworkBayesian.txtPeriodo.removeAllItems();//limpiamos combo
        listaPeriodo = periodoDao.Read();
        for (int i = 0; i < listaPeriodo.size(); i++) {
            frmNetworkBayesian.txtPeriodo.addItem(listaPeriodo.get(i).getPeriodo());
        }
    }
    public void getCompetencias(String area){
        if(listaCompetencias!=null)listaCompetencias.clear(); 
        if(listaCapacidadCompetencia!=null)listaCapacidadCompetencia.clear(); 
        if(listaDesempeñoCapacidad!=null)listaDesempeñoCapacidad.clear();
        listaCompetencias = matrizDao.getMatrizCompetenciaAreaRead(area,idDocenteAula);
        for (int i = 0; i < listaCompetencias.size(); i++) {
            System.out.println("COMPETENCIA:"+listaCompetencias.get(i).getCompetencia());
            getCapacidades(area, listaCompetencias.get(i));
        }
    }
    public void getCapacidades(String area,Competencia competencia){
        if(listaCapacidades!=null)listaCapacidades.clear(); 
        listaCapacidades = matrizDao.getMatrizCapacidadCompetenciaRead(area,competencia.getCompetencia(),idDocenteAula);
        for (int i = 0; i < listaCapacidades.size(); i++) {
            System.out.println("\tCAPACIDAD:"+listaCapacidades.get(i).getCapacidad());
            List<Object> capacidadCompetencia = new ArrayList<>();
            capacidadCompetencia.add(competencia.getIdCompetencia());
            capacidadCompetencia.add(listaCapacidades.get(i));
            listaCapacidadCompetencia.add(capacidadCompetencia);
            getDesempeños(area, competencia, listaCapacidades.get(i));
        }
    }
    public void getDesempeños(String area,Competencia competencia, Capacidad capacidad){
        if(listaDesempeñoAux!=null)listaDesempeñoAux.clear(); 
        listaDesempeñoAux = matrizDao.getMatrizDesempeñoCapacidadRead(area,competencia.getCompetencia(),capacidad.getCapacidad(),idDocenteAula);
        for (int i = 0; i < listaDesempeñoAux.size(); i++) {
            System.out.println("\t\tDESEMPEÑO:"+listaDesempeñoAux.get(i).getDesempeño());
            List<Object> desempeñoCapacidad = new ArrayList<>();
            desempeñoCapacidad.add(competencia.getIdCompetencia());
            desempeñoCapacidad.add(capacidad.getIdCapacidad());
            desempeñoCapacidad.add(listaDesempeñoAux.get(i));
            desempeñoCapacidad.add(0.00);//CONOCIMIENTO POR DEFAULT
            listaDesempeñoCapacidad.add(desempeñoCapacidad);
        }
    }
    
    public void getPregunta(){listaPregunta = preguntaDao.Read();}
    
    public void getAlternativa(){listaAlternativa = alternativaDao.Read();}
    
    public void getNivel(){listaNivel = nivelDao.Read();}
    
    public void getEstilo(){listaEstilo = estiloDao.Read();}
    
    public void getImagen(){listaImagen = imagenDao.Read();}
    
    public void getEvaluacionAdaptativa(){
        int idEstudianteMatricula = frmNetworkBayesian.txtEstudiante.getSelectedIndex();
        for(int i=0;i<listaEstudianteMatriculado.size();i++){
            if(idEstudianteMatricula == i){
                idEstudianteMatricula=Integer.parseInt(listaEstudianteMatriculado.get(i).get(5));
                estudiante = listaEstudianteMatriculado.get(i).get(1)+"  "+listaEstudianteMatriculado.get(i).get(2);
            }
        }
        if(listaEvaluacionAdaptativa!=null)listaEvaluacionAdaptativa.clear(); 
        listaEvaluacionAdaptativa = evaluacionAdaptativaDao.Read(idEstudianteMatricula,idDocenteAula,area,periodo);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource().equals(frmNetworkBayesian.txtEstudiante) || e.getSource().equals(frmNetworkBayesian.txtArea) || e.getSource().equals(frmNetworkBayesian.txtPeriodo)){
            if (e.getStateChange() == ItemEvent.SELECTED){
               panel.reset();
            }
        }
    }
}
