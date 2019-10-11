package pattern.controller;

import interfaces.ICrudView;
import interfaces.IView;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pattern.dao.EvaluacionTradicionalDao;
import pattern.dao.MatrizDao;
import pattern.model.Alternativa;
import pattern.model.networkBayesian.Node;
import pattern.view.FrmReporteNetworkBayesian;

public class FrmReporteNetworkBayesianController implements IView,ICrudView{
    //view
    private final FrmReporteNetworkBayesian frmReporteNetworkBayesian;
    //dao
    private final EvaluacionTradicionalDao evaluacionTradicionalDao;
    private final MatrizDao matrizDao;
    //variables
    private DefaultTableModel modelTableET,modelTableEA,modelTableNC,modelTableESA,modelTableTE;
    private int cantCompetencia;
    private final String [] rowTableET = new String[2];
    private final String [] rowTableEA = new String[2];
    private final String [] rowTableNC = new String[2];
    private final String [] rowTableESA = new String[3];
    private final String [] rowTableTE = new String[3];
    private List<List<String>> listaEstudianteCET;
    private List<String> listaFecha;
    private List<List<Integer>> listaCalificacionEstudiante;
    private final List<List<Double>> listaCalificacionEstudianteSuma;
    private List<List<Object>> listaPreguntaDesempeño;
    private final List<Object> listaPreguntaCorrecta;
    private final List<Object> listaPreguntaIncorrecta;
    private Node areaNode;
    private List<Node> listaNodeCompetencia;
    private int  idDocenteAula;
    private String area,periodo;
    private String dniDocente;
    private String dniEstudiante;
    private String fecha;
    private int aux;
    private double tiempoPreguntaCorrecta,tiempoPreguntaIncorrecta;
    private double tiempoPreguntaCorrectaPromedio,tiempoPreguntaIncorrectaPromedio;
    private double cantPreguntaVisualCorrecta,cantPreguntaAuditivaCorrecta;
    private double porcentajeVisualCorrecta,porcentajeAuditivaCorrecta;
    private int cantPreguntaVisualInCorrecta,cantPreguntaAuditivaInCorrecta;
    private String tiempoCorrecto,tiempoIncorrecto ;
    public FrmReporteNetworkBayesianController(FrmReporteNetworkBayesian frmReporteNetworkBayesian) {
        this.frmReporteNetworkBayesian = frmReporteNetworkBayesian;
        this.evaluacionTradicionalDao = new EvaluacionTradicionalDao();
        this.matrizDao = new MatrizDao();
        this.listaEstudianteCET = new ArrayList<>();
        this.listaCalificacionEstudianteSuma = new ArrayList<>();
        this.listaPreguntaCorrecta = new ArrayList<>();
        this.listaPreguntaIncorrecta = new ArrayList<>();
    }

    @Override  public void initController() {}

    @Override
    public void refreshView() {
        Clear();
        frmReporteNetworkBayesian.setLocationRelativeTo(null);
        frmReporteNetworkBayesian.setVisible(true);
    }
    
    public void recibirDatos(String _area,String _periodo, String _dniEstudiante,int _idDocenteAula,String _dniDocente,Node _areaNode,List<Node> _listaNodeCompetencia,List<List<Object>> _listaPreguntaDesempeño){
        area = _area;
        periodo = _periodo;
        idDocenteAula = _idDocenteAula;
        dniDocente = _dniDocente;
        dniEstudiante = _dniEstudiante;
        areaNode = _areaNode;
        listaNodeCompetencia = _listaNodeCompetencia;
        listaPreguntaDesempeño = _listaPreguntaDesempeño;
        refreshView();
    }

    @Override public void Create() {}

    @Override public void Read() { getFechas(); }

    @Override public void Update() {}

    @Override public void Delete() {}

    @Override
    public void Clear() {
        modelTableET = new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
        modelTableEA = new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
        modelTableNC = new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
        modelTableESA = new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
        modelTableTE = new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
        Read();
    }
    
    public void getCompetenciaCET(String area){
        cantCompetencia = matrizDao.getMatrizCompetenciaAreaRead(area,idDocenteAula).size();
    }
    
    public void getFechas(){
        if(listaFecha!=null)listaFecha.clear(); 
        listaFecha = evaluacionTradicionalDao.getFechas(dniDocente,periodo,area);
        getEvaluacionesTradicionales();
    }
    
    public void getEvaluacionesTradicionales(){
        getCompetenciaCET(area);//contamos competencias por area
        //PROMEDIO DE EVALUACIONES TRADICIONALES POR COMPETENCIA
        if(listaFecha.size()>0){
            modelTableET = new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
            modelTableET.addColumn("NOMBRES");
            modelTableET.addColumn("APELLIDOS");
            for (int i = 0; i < cantCompetencia; i++) {
                modelTableET.addColumn("COMP."+(i+1));
            }
            modelTableET.addColumn("PROMEDIO");
            fecha = listaFecha.get(0);                
            //limpiamos lista
            if(listaEstudianteCET!=null)listaEstudianteCET.clear();
            if(listaCalificacionEstudiante!=null)listaCalificacionEstudiante.clear();
            //recuperamos datos
            listaEstudianteCET = evaluacionTradicionalDao.getEvaluacionTradicionalEstudiante(dniDocente,periodo,area,fecha);
            for (int j = 0; j < listaEstudianteCET.size(); j++) {
                System.out.println("ESTUDIANTE "+(j+1));
                System.out.println("DNI:"+listaEstudianteCET.get(j).get(0));
                System.out.println("NOMBRES:"+listaEstudianteCET.get(j).get(1));
                System.out.println("APELLIDOS:"+listaEstudianteCET.get(j).get(2));
                List<Double> calificacionEstudianteSuma = new ArrayList<>();
                for (int i = 0; i < cantCompetencia; i++) {
                    calificacionEstudianteSuma.add(0.00);
                }
                for (int i = 0; i <listaFecha.size(); i++) {
                    fecha = listaFecha.get(i);
                    //limpiamos lista
                    if(listaEstudianteCET!=null)listaEstudianteCET.clear();
                    if(listaCalificacionEstudiante!=null)listaCalificacionEstudiante.clear();
                    //recuperamos datos
                    listaEstudianteCET = evaluacionTradicionalDao.getEvaluacionTradicionalEstudiante(dniDocente,periodo,area,fecha);
                    listaCalificacionEstudiante = evaluacionTradicionalDao.evaluacionTradicionalCalificacionEstudiante(dniDocente, periodo, area, fecha);
                    int m;
                    m=2;
                    List<Double> calificacionEstudianteSumaAux = new ArrayList<>();
                    for (int k = 0; k < listaCalificacionEstudiante.size(); k++) {
                        int idEvaluacion_Tradicional = listaCalificacionEstudiante.get(k).get(0); 
                        if(idEvaluacion_Tradicional == Integer.parseInt(listaEstudianteCET.get(j).get(3))){
                            calificacionEstudianteSumaAux.add(Double.parseDouble(listaCalificacionEstudiante.get(k).get(1).toString()));
                            double suma = calificacionEstudianteSuma.get(m-2)+calificacionEstudianteSumaAux.get(m-2);
                            calificacionEstudianteSuma.set(m-2, suma);
                            m+=1;  
                        }else{
                            m=2;
                        }
                    }
                }
                listaCalificacionEstudianteSuma.add(calificacionEstudianteSuma);
            }
            for (int i = 0; i < listaCalificacionEstudianteSuma.size(); i++) {
                if(dniEstudiante.equals(listaEstudianteCET.get(i).get(0))){
                    aux =i;
                    rowTableET[0] = listaEstudianteCET.get(i).get(1);
                    rowTableET[1] = listaEstudianteCET.get(i).get(2);
                    modelTableET.addRow(rowTableET);
                    double promedioFinal=0.00;
                    for (int j = 0; j <listaCalificacionEstudianteSuma.get(i).size(); j++) {
                        double promedio = listaCalificacionEstudianteSuma.get(i).get(j)/listaFecha.size();
                        promedio = (double)Math.round(promedio * 10000d) / 10000d;//redondeando a 4 decimales
                        modelTableET.setValueAt(promedio,0,(j+2));
                        System.out.println("\tnota promedio:"+promedio);
                        promedioFinal = promedioFinal + promedio;
                    }
                    promedioFinal = (double)(promedioFinal/listaCalificacionEstudianteSuma.get(i).size());
                    promedioFinal = (double)Math.round(promedioFinal * 10000d) / 10000d;//redondeando a 4 decimales
                    modelTableET.setValueAt(promedioFinal,0,(2+listaCalificacionEstudianteSuma.get(i).size()));
                }
            }
            getEvaluacionesAdaptativas();
        }else{
            JOptionPane.showMessageDialog(null,"El estudiante, no tiene evaluaciones tradicionales registradas!","Mensaje",JOptionPane.ERROR_MESSAGE);
            frmReporteNetworkBayesian.tableEvaluacionAdaptativa.setModel(modelTableEA);//seteamos model
            frmReporteNetworkBayesian.tableNivelConocimiento.setModel(modelTableNC);//seteamos model
            frmReporteNetworkBayesian.tableEstiloAprendizaje.setModel(modelTableESA);//seteamos model
            frmReporteNetworkBayesian.tableTiempoEvaluacion.setModel(modelTableTE);//seteamos model
        }
        frmReporteNetworkBayesian.tableEvaluacionTradicional.setModel(modelTableET);//seteamos model
        if(listaCalificacionEstudianteSuma!=null)listaCalificacionEstudianteSuma.clear();//limpiamos lista de sumas
    }
    
    public void getEvaluacionesAdaptativas(){
        modelTableEA = new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
        //add column to table
        modelTableEA.addColumn("NOMBRES");
        modelTableEA.addColumn("APELLIDOS");
        for (int i = 0; i < cantCompetencia; i++) {
            modelTableEA.addColumn("COMP."+(i+1));
        }
        modelTableEA.addColumn("PROMEDIO");
        rowTableEA[0] = listaEstudianteCET.get(aux).get(1);
        rowTableEA[1] = listaEstudianteCET.get(aux).get(2);
        modelTableEA.addRow(rowTableEA);
        double promedioIdeal = (double)1/listaNodeCompetencia.size();
        double promedioObtenidoCompetencia;
        double promedioFinal;
        for (int i = 0; i < listaNodeCompetencia.size(); i++) {
            promedioObtenidoCompetencia = (double)(listaNodeCompetencia.get(i).getConocimientoAPosteriori()*20)/promedioIdeal;
            promedioObtenidoCompetencia = (double)Math.round(promedioObtenidoCompetencia * 10000d) / 10000d;//redondeando a 4 decimales
            modelTableEA.setValueAt(promedioObtenidoCompetencia,0,(i+2));
        }
        promedioFinal = (double)(areaNode.getConocimientoAPosteriori()*20);
        promedioFinal = (double)Math.round(promedioFinal * 10000d) / 10000d;//redondeando a 4 decimales
        modelTableEA.setValueAt(promedioFinal,0,(2+listaNodeCompetencia.size()));
        frmReporteNetworkBayesian.tableEvaluacionAdaptativa.setModel(modelTableEA);//seteamos model
        getNivelConocimiento();
        getEstiloAprendizaje();
        getTiempoEvaluacion();
    }
    
    public void getNivelConocimiento(){
        double probabilidadApriori,probabilidadAposteriori;
        //nivel de conocimiento apriori
        probabilidadApriori = (double)((Double.parseDouble(modelTableET.getValueAt(0, (2+listaNodeCompetencia.size())).toString()))/20)*100;
        probabilidadApriori = (double)Math.round(probabilidadApriori * 10000d) / 10000d;//redondeando a 4 decimales
        //nivel de conocimiento a posteriori
        probabilidadAposteriori = (double)((Double.parseDouble(modelTableEA.getValueAt(0, (2+listaNodeCompetencia.size())).toString()))/20)*100;
        probabilidadAposteriori = (double)Math.round(probabilidadAposteriori * 10000d) / 10000d;//redondeando a 4 decimales
        //columnas tabla
        modelTableNC = new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
        modelTableNC.addColumn("A PRIORI");
        modelTableNC.addColumn("A POSTERIORI");
        //filas tabla
        rowTableNC[0] = ""+modelTableET.getValueAt(0, (2+listaNodeCompetencia.size()))+"   ("+probabilidadApriori+"%)";
        rowTableNC[1] = ""+modelTableEA.getValueAt(0, (2+listaNodeCompetencia.size()))+"   ("+probabilidadAposteriori+"%)";
        modelTableNC.addRow(rowTableNC);
        //seteamos modelo
        frmReporteNetworkBayesian.tableNivelConocimiento.setModel(modelTableNC);
    }
    
    public void getEstiloAprendizaje(){
        //restablecemos variables
        cantPreguntaVisualCorrecta = 0;
        cantPreguntaAuditivaCorrecta = 0;
        cantPreguntaVisualInCorrecta = 0;
        cantPreguntaAuditivaInCorrecta = 0;
        porcentajeVisualCorrecta = 0.00;
        porcentajeAuditivaCorrecta = 0.00;
        listaPreguntaCorrecta.clear();
        listaPreguntaIncorrecta.clear();
        for (int i = 0; i < listaPreguntaDesempeño.size(); i++) {
            Alternativa alternativa = (Alternativa)listaPreguntaDesempeño.get(i).get(4);
            boolean estado= alternativa.isSuccess();
            if(estado){
                listaPreguntaCorrecta.add(listaPreguntaDesempeño.get(i));
            }else{
                listaPreguntaIncorrecta.add(listaPreguntaDesempeño.get(i));
            }
        }
        //PREGUNTAS CORRECTAS
        if(listaPreguntaCorrecta.size()>0){
            for (int i = 0; i < listaPreguntaCorrecta.size(); i++) {
                @SuppressWarnings("unchecked")
                List<Object> pregunta = (List<Object>)listaPreguntaCorrecta.get(i);
                if(pregunta.get(3).equals("Visual")){cantPreguntaVisualCorrecta+=1;}
                if(pregunta.get(3).equals("Auditiva")){cantPreguntaAuditivaCorrecta+=1;}
            }
            porcentajeVisualCorrecta = (double)(1*cantPreguntaVisualCorrecta/listaPreguntaCorrecta.size())*100;
            porcentajeVisualCorrecta = (double)Math.round(porcentajeVisualCorrecta * 10000d) / 10000d;
            porcentajeAuditivaCorrecta = (double)(1*cantPreguntaAuditivaCorrecta/listaPreguntaCorrecta.size())*100;
            porcentajeAuditivaCorrecta = (double)Math.round(porcentajeAuditivaCorrecta * 10000d) / 10000d;
        }else{
            System.out.println("NO TIENE NINGUNA PREGUNTA CORRECTA");
        }
        //PREGUNTAS INCORRECTAS
        if(listaPreguntaIncorrecta.size()>0){
            for (int i = 0; i < listaPreguntaIncorrecta.size(); i++) {
                @SuppressWarnings("unchecked")
                List<Object> pregunta = (List<Object>)listaPreguntaIncorrecta.get(i);
                if(pregunta.get(3).equals("Visual")){cantPreguntaVisualInCorrecta+=1;}
                if(pregunta.get(3).equals("Auditiva")){cantPreguntaAuditivaInCorrecta+=1;}
            }
        }
        //columnas tabla
        modelTableESA = new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
        modelTableESA.addColumn("ESTADO");
        modelTableESA.addColumn("VISUALES");
        modelTableESA.addColumn("AUDITIVAS");
        //filas tabla
        rowTableESA[0] = "CORRECTAS";
        rowTableESA[1] = ""+cantPreguntaVisualCorrecta+"  ("+porcentajeVisualCorrecta+"%)";
        rowTableESA[2] = ""+cantPreguntaAuditivaCorrecta+"  ("+porcentajeAuditivaCorrecta+"%)";;
        modelTableESA.addRow(rowTableESA);
        //filas tabla
        rowTableESA[0] = "INCORRECTAS";
        rowTableESA[1] = ""+cantPreguntaVisualInCorrecta;
        rowTableESA[2] = ""+cantPreguntaAuditivaInCorrecta;
        modelTableESA.addRow(rowTableESA);
        //seteamos modelo
        frmReporteNetworkBayesian.tableEstiloAprendizaje.setModel(modelTableESA);
    }
    
    public void getTiempoEvaluacion(){
        tiempoPreguntaCorrecta = 0.00;
        tiempoPreguntaIncorrecta = 0.00;
        tiempoPreguntaCorrectaPromedio = 0.00;
        tiempoPreguntaIncorrectaPromedio = 0.00;
        for (int i = 0; i < listaPreguntaDesempeño.size(); i++) {
            Alternativa alternativa = (Alternativa)listaPreguntaDesempeño.get(i).get(4);
            boolean estado= alternativa.isSuccess();
            if(estado){
                tiempoPreguntaCorrecta = tiempoPreguntaCorrecta + Integer.parseInt(listaPreguntaDesempeño.get(i).get(6).toString());
            }else{
                tiempoPreguntaIncorrecta = tiempoPreguntaIncorrecta + Integer.parseInt(listaPreguntaDesempeño.get(i).get(6).toString());
            }
        }
        if(listaPreguntaCorrecta.size()>0){
            tiempoPreguntaCorrectaPromedio = (double)tiempoPreguntaCorrecta/listaPreguntaCorrecta.size();
            tiempoPreguntaCorrectaPromedio = (double)Math.round(tiempoPreguntaCorrectaPromedio * 1d) / 1d;
        }
        if(listaPreguntaIncorrecta.size()>0){
            tiempoPreguntaIncorrectaPromedio = (double)tiempoPreguntaIncorrecta/listaPreguntaIncorrecta.size();
            tiempoPreguntaIncorrectaPromedio = (double)Math.round(tiempoPreguntaIncorrectaPromedio * 1d) / 1d;
        }
        //tiempo formateado
        tiempoCorrecto = getTiempo(tiempoPreguntaCorrectaPromedio);
        tiempoIncorrecto = getTiempo(tiempoPreguntaIncorrectaPromedio);
        //columnas tabla
        modelTableTE = new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
        modelTableTE.addColumn("ESTADO");
        modelTableTE.addColumn("PREGUNTAS");
        modelTableTE.addColumn("PROM.TIEMPO");
        //filas tabla
        rowTableTE[0] = "CORRECTAS";
        rowTableTE[1] = ""+listaPreguntaCorrecta.size();
        rowTableTE[2] = ""+tiempoCorrecto;
        modelTableTE.addRow(rowTableTE);
        //filas tabla
        rowTableTE[0] = "INCORRECTAS";
        rowTableTE[1] = ""+listaPreguntaIncorrecta.size();
        rowTableTE[2] = ""+tiempoIncorrecto;
        modelTableTE.addRow(rowTableTE);
        //seteamos modelo
        frmReporteNetworkBayesian.tableTiempoEvaluacion.setModel(modelTableTE);
    }
    public String  getTiempo(double tiempo){
        int horas,minutos,segundos;
        horas = (int)tiempo/3600;
        minutos = (int)(tiempo%3600)/60;
        segundos =(int)(tiempo%3600)%60;
        String time = "00:00:00";
        try {
            String myDateString = horas+":"+minutos+":"+segundos;
            DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Date date = sdf.parse(myDateString);            
            SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
            time = localDateFormat.format(date);
            System.out.println(time);    
        } catch (ParseException e) {}
        return time;
    }
}
