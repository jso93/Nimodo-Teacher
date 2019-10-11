package pattern.model.networkBayesian;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import pattern.controller.FrmPrincipalController;
import pattern.controller.FrmReporteNetworkBayesianController;
import pattern.model.Alternativa;
import pattern.model.Capacidad;
import pattern.model.Competencia;
import pattern.model.Imagen;
import pattern.model.Desempeño;
import pattern.view.FrmReporteNetworkBayesian;

public class NetworkBayesianController extends JPanel implements MouseListener, MouseMotionListener{
    //model
    //view
    private final FrmReporteNetworkBayesian frmReporteNetworkBayesian;
    //controller
    private final FrmReporteNetworkBayesianController frmReporteNetworkBayesianController;
    //dao
    //variables
    private String dniEstudiante,dniDocente;
    private int idDocenteAula;
    private String area,periodo;
    private String grado,seccion;
    private String estudiante;
    private DrawNode drawUtils;
    private final Graph graph;
    private Node selectedNode = null;
    private Node hoveredNode = null;
    private Point cursor;
    private Graphics2D graphics2d;
    private Node areaNode;
    private List<Competencia> listaCompetencias;
    private List<List<Object>> listaCapacidadCompetencia;
    private List<List<Object>> listaDesempeñoCapacidad;
    private List<List<Object>> listaPreguntaDesempeño;
    private List<List<Object>> listaEvaluacionAdaptativa;
    private final List<Node> listaNodeDesempeño;
    private final List<Node> listaNodeCompetencia;
    private final List<Node> listaNodeCapacidad;
    private List<Alternativa> listaAlternativa;
    private List<Imagen> listaImagen;
    int cantCapacidad,cantCompetencia,cantDesempeño;
    int distanciaCapacidad = 200;
    int distanciaCompetencia = 800;
    int distanciaDesempeño = 75;
    
    public NetworkBayesianController(FrmPrincipalController frmPrincipalController){
        this.frmReporteNetworkBayesian = new FrmReporteNetworkBayesian(frmPrincipalController.frmPrincipal, true);
        this.frmReporteNetworkBayesianController = new FrmReporteNetworkBayesianController(this.frmReporteNetworkBayesian);
        this.frmReporteNetworkBayesianController.initController();
        this.graph = new Graph();
        this.listaNodeCompetencia = new ArrayList<>();
        this.listaNodeCapacidad = new ArrayList<>();
        this.listaNodeDesempeño = new ArrayList<>();
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        graphics2d = (Graphics2D) g;
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        drawUtils = new DrawNode(graphics2d);
        Color colorDefault = Color.DARK_GRAY;
        Color colorNivelInicio = Color.RED;
        Color colorNivelProceso = Color.ORANGE;
        Color colorNivelSatisfactorio = Color.GREEN;
        Color color = null;
        if(graph.getNodes().size()>0){
            //PINTAMOS CONECTORES
            graphics2d.setColor(Color.gray);
            for (int i = 0; i < listaCompetencias.size(); i++) {
                Point fromComp = listaNodeCompetencia.get(i).getCoord();
                Point toComp = graph.getNodes().get(0).getCoord();
                graphics2d.setStroke(new BasicStroke(3));
                graphics2d.drawLine(fromComp.x, fromComp.y, toComp.x, toComp.y);
                for (int j = 0; j < listaCapacidadCompetencia.size(); j++) {
                    if(listaCompetencias.get(i).getIdCompetencia() == Integer.parseInt(listaCapacidadCompetencia.get(j).get(0).toString())){
                        Point fromCap = listaNodeCapacidad.get(j).getCoord();
                        Point toCap = listaNodeCompetencia.get(i).getCoord();
                        graphics2d.setStroke(new BasicStroke(3));
                        graphics2d.drawLine(fromCap.x, fromCap.y, toCap.x, toCap.y);
                        Capacidad capacidad = (Capacidad)listaCapacidadCompetencia.get(j).get(1);
                        for (int k = 0; k < listaDesempeñoCapacidad.size(); k++) {
                            if(listaCompetencias.get(i).getIdCompetencia() == Integer.parseInt(listaDesempeñoCapacidad.get(k).get(0).toString()) && capacidad.getIdCapacidad()==Integer.parseInt(listaDesempeñoCapacidad.get(k).get(1).toString())){
                                Point fromDesemp = listaNodeDesempeño.get(k).getCoord();
                                Point toDesemp = listaNodeCapacidad.get(j).getCoord();
                                graphics2d.setStroke(new BasicStroke(3));
                                graphics2d.drawLine(fromDesemp.x, fromDesemp.y, toDesemp.x, toDesemp.y);
                            }
                        }
                    }
                }
                
            }          
            //PINTAMOS AREA
            double nivelArea = (double)areaNode.getConocimientoAPosteriori();
            if(nivelArea>=0.00 && nivelArea<=0.55){color = colorNivelInicio;}
            if(nivelArea>0.55 && nivelArea<=0.80){color = colorNivelProceso;}
            if(nivelArea>0.80 && nivelArea<=1.0){color = colorNivelSatisfactorio;}
            drawUtils.drawNode(areaNode,color);
            //PINTAMOS COMPETENCIAS
            for (int i = 0; i < listaCompetencias.size(); i++) {
                drawUtils.drawNode(listaNodeCompetencia.get(i),colorDefault);
            }
            //PINTAMOS CAPACIDADES
            for (int i = 0; i < listaCapacidadCompetencia.size(); i++) {
                drawUtils.drawNode(listaNodeCapacidad.get(i),colorDefault);
            }
            //PINTAMOS DESEMPEÑOS
            for (int i = 0; i < listaDesempeñoCapacidad.size(); i++) {
                double nivelDesempeño = (double)Double.parseDouble(listaDesempeñoCapacidad.get(i).get(3).toString());
                if(nivelDesempeño>=0.00 && nivelDesempeño<=0.55){color = colorNivelInicio;}
                if(nivelDesempeño>0.55 && nivelDesempeño<=0.80){color = colorNivelProceso;}
                if(nivelDesempeño>0.80 && nivelDesempeño<=1.0){color = colorNivelSatisfactorio;}
                drawUtils.drawNode(listaNodeDesempeño.get(i),color);
            }
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        for(Node node : graph.getNodes()) {
            if(DrawNode.isOverlapping(e, node.getCoord())){
                if(node.getTipo().equals("Area")){
                    frmReporteNetworkBayesianController.recibirDatos(area,periodo,dniEstudiante,idDocenteAula,dniDocente,areaNode, listaNodeCompetencia,listaPreguntaDesempeño);
                }else{
                    if(node.getTipo().equals("Competencia")){                    
                        try {
                            descargarPDF(node);
                        } catch (FileNotFoundException | DocumentException ex) {}
                    }else{
                        JOptionPane.showMessageDialog(null,node.getTipo()+": "+node.getName()+"\nConocimiento aposteriori: "+node.getConocimientoAPosteriori());
                    }    
                }
                return;
            }
        }
    }

    @Override public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {
        selectedNode = null;
        hoveredNode = null;
        repaint();
    }

    @Override public void mouseEntered(MouseEvent e) {}

    @Override public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
        hoveredNode = null;
        for (Node node : graph.getNodes()) {
            if(selectedNode ==null && DrawNode.isWithinBounds(e, node.getCoord())){
                selectedNode = node;
            } else if(DrawNode.isWithinBounds(e, node.getCoord())) {
                hoveredNode = node;
            }
        }
        if(selectedNode !=null){
                selectedNode.setCoord(e.getX(), e.getY());
                cursor = null;
                repaint();
        }
    }

    @Override public void mouseMoved(MouseEvent e) {}
    
    public void reset(){ 
         graph.clear(); 
         repaint();
    }
    public void drawNetworkBayesian(List<List<Object>> _listaDesempeñoCapacidad,List<List<Object>> _listaCapacidadCompetencia,List<Competencia> _listaCompetencias,String _area,String _periodo,String _dniEstudiante,int _idDocenteAula,String _dniDocente,List<List<Object>> _listaPreguntaDesempeño,List<List<Object>> _listaEvaluacionAdaptativa,String _grado,String _seccion,String _estudiante,List<Imagen> _listaImagen,List<Alternativa> _listaAlternativa){
        reset();
        //alternativa
        listaAlternativa = _listaAlternativa;
        //imagen
        listaImagen = _listaImagen;
        //grado y seccion
        grado = _grado;
        seccion = _seccion;
        //estudiante
        estudiante = _estudiante;
        //list evaluacion adaptativa
        listaEvaluacionAdaptativa = _listaEvaluacionAdaptativa;
        //lista preguntas
        listaPreguntaDesempeño = _listaPreguntaDesempeño;
        //area periodo
        area = _area;
        periodo = _periodo;
        //docente
        idDocenteAula = _idDocenteAula;
        dniDocente = _dniDocente;
        //estudiante
        dniEstudiante = _dniEstudiante;
        //CREAR NODO AREA
        Point pointArea = new Point();
        pointArea.setLocation(this.getWidth()/2, 20);
        //area
        areaNode = new Node(pointArea, 1,area,0.0,"Area");
        graph.addNode(areaNode);
        //RECIBIMOS DATOS
        listaCompetencias = _listaCompetencias;
        cantCompetencia = listaCompetencias.size();
        listaCapacidadCompetencia = _listaCapacidadCompetencia;
        listaDesempeñoCapacidad = _listaDesempeñoCapacidad;
        if(listaNodeCompetencia!=null)listaNodeCompetencia.clear();
        if(listaNodeCapacidad!=null)listaNodeCapacidad.clear();
        if(listaNodeDesempeño!=null)listaNodeDesempeño.clear();
        //CREAR NODO COMPETENCIA
        double conocimientoAreaAPosteriori = 0.0;
        double tempArea = 0.0;
        for (int i = 0; i < listaCompetencias.size(); i++) {
            int xCompetencia;
            int yCompetencia = 150;
            if(cantCompetencia%2==0){
                 xCompetencia= this.getWidth()/2+i*distanciaCompetencia-(cantCompetencia/2*distanciaCompetencia)+distanciaCompetencia/2;
             }else{
                 xCompetencia = this.getWidth()/2+i*distanciaCompetencia-(cantCompetencia/2*distanciaCompetencia);
             }
            Point pointCompetencia = new Point(xCompetencia,yCompetencia);
            Node nodeCompetencia = new Node(pointCompetencia,listaCompetencias.get(i).getIdCompetencia(),listaCompetencias.get(i).getCompetencia(),0.00,"Competencia");
            listaNodeCompetencia.add(nodeCompetencia);
            graph.addNode(listaNodeCompetencia.get(i));
            //CREAR NODO CAPACIDAD
            cantCapacidad = 0;
            for (int j = 0; j < listaCapacidadCompetencia.size(); j++) {
                if(listaCompetencias.get(i).getIdCompetencia()==Integer.parseInt(listaCapacidadCompetencia.get(j).get(0).toString())){
                    cantCapacidad+=1;
                }
            }
            System.out.println("competencia:"+listaCompetencias.get(i).getCompetencia()+" cantcapacidad:"+cantCapacidad);
            double conocimientoCompetenciaAPosteriori = 0.0;
            double tempCompetencia = 0.0;
            if(cantCapacidad!=0){
                conocimientoCompetenciaAPosteriori = (double)1/cantCompetencia;
                int aux = 0;
                for (int j = 0; j < listaCapacidadCompetencia.size(); j++) {
                    if(listaCompetencias.get(i).getIdCompetencia()==Integer.parseInt(listaCapacidadCompetencia.get(j).get(0).toString())){
                        int xCapacidad;
                        int yCapacidad = 300;
                        if(cantCapacidad%2==0){
                             xCapacidad= listaNodeCompetencia.get(i).getX()+aux*distanciaCapacidad-(cantCapacidad/2*distanciaCapacidad)+distanciaCapacidad/2;
                         }else{
                             xCapacidad = listaNodeCompetencia.get(i).getX()+aux*distanciaCapacidad-(cantCapacidad/2*distanciaCapacidad);
                         }
                        aux+=1;
                        Point pointCapacidad = new Point(xCapacidad,yCapacidad);
                        Capacidad capacidad = (Capacidad)listaCapacidadCompetencia.get(j).get(1);
                        Node nodeCapacidad = new Node(pointCapacidad,capacidad.getIdCapacidad(),capacidad.getCapacidad(),0.0,"Capacidad");
                        listaNodeCapacidad.add(nodeCapacidad);
                        graph.addNode(listaNodeCapacidad.get(j)); 
                        //CREAR NODO DESEMPEÑO 
                        cantDesempeño = 0;
                        for (int k = 0; k < listaDesempeñoCapacidad.size(); k++) {
                            if(listaCompetencias.get(i).getIdCompetencia() == Integer.parseInt(listaDesempeñoCapacidad.get(k).get(0).toString()) && capacidad.getIdCapacidad()==Integer.parseInt(listaDesempeñoCapacidad.get(k).get(1).toString())){
                                 cantDesempeño+=1;
                            }
                        }
                        System.out.println("desempeño:"+listaDesempeñoCapacidad.size());
                        System.out.println("\t"+capacidad.getCapacidad());
                        System.out.println("\t\t"+cantDesempeño);
                        double conocimientoCapacidadAPosteriori = 0.0;
                        double tempCapacidad = 0.0;
                        if(cantDesempeño!=0){
                            conocimientoCapacidadAPosteriori = (double)1/cantCapacidad;
                            int aux1 = 0;
                            for (int k = 0; k < listaDesempeñoCapacidad.size(); k++) {
                                if(listaCompetencias.get(i).getIdCompetencia() == Integer.parseInt(listaDesempeñoCapacidad.get(k).get(0).toString()) && capacidad.getIdCapacidad()==Integer.parseInt(listaDesempeñoCapacidad.get(k).get(1).toString())){
                                    int xDesempeño;
                                    int yDesempeño = 450;
                                    if(cantDesempeño%2==0){
                                         xDesempeño= listaNodeCapacidad.get(j).getX()+aux1*distanciaDesempeño-(cantDesempeño/2*distanciaDesempeño)+distanciaDesempeño/2;
                                     }else{
                                         xDesempeño = listaNodeCapacidad.get(j).getX()+aux1*distanciaDesempeño-(cantDesempeño/2*distanciaDesempeño);
                                     }
                                    aux1+=1;
                                    Point pointDesempeño = new Point(xDesempeño,yDesempeño);
                                    Desempeño desempeño = (Desempeño)listaDesempeñoCapacidad.get(k).get(2); 
                                    //listaDesempeñoCapacidad.get(k).set(3, ""+getRandom(0.7,0.9));
                                    double conocimientoDesempeñoAPosteriori = Double.parseDouble(listaDesempeñoCapacidad.get(k).get(3).toString());
                                    //conocimientoDesempeñoAPosteriori = (double)Math.round(conocimientoDesempeñoAPosteriori * 10000d) / 10000d;
                                    Node nodeDesempeño = new Node(pointDesempeño,desempeño.getIdDesempeño(),desempeño.getDesempeño(),conocimientoDesempeñoAPosteriori,"Desempeño");
                                    listaNodeDesempeño.add(nodeDesempeño);
                                    graph.addNode(listaNodeDesempeño.get(k)); 
                                    tempCapacidad = (double)(tempCapacidad + conocimientoDesempeñoAPosteriori);
                                }
                            }
                            System.out.println("suma:"+tempCapacidad);
                            tempCapacidad = (double)(tempCapacidad*conocimientoCapacidadAPosteriori);
                            conocimientoCapacidadAPosteriori = (double)(tempCapacidad/cantDesempeño);
                            conocimientoCapacidadAPosteriori = (double)Math.round(conocimientoCapacidadAPosteriori * 10000d) / 10000d;
                            System.out.println("conocimiento a posteriori capacidad:"+conocimientoCapacidadAPosteriori);
                            listaNodeCapacidad.get(j).setConocimientoAPosteriori(conocimientoCapacidadAPosteriori);
                        }
                       tempCompetencia = (double)(tempCompetencia + conocimientoCapacidadAPosteriori); 
                    }
                }
                System.out.println("suma capacidades:"+tempCompetencia);
                tempCompetencia = (double)(tempCompetencia*conocimientoCompetenciaAPosteriori);
                conocimientoCompetenciaAPosteriori = (double)Math.round(tempCompetencia * 10000d) / 10000d;
                System.out.println("conocimiento competencia:"+conocimientoCompetenciaAPosteriori);
                listaNodeCompetencia.get(i).setConocimientoAPosteriori(conocimientoCompetenciaAPosteriori);
            }
            tempArea = (double) (tempArea + conocimientoCompetenciaAPosteriori);
        }
        conocimientoAreaAPosteriori = (double)Math.round(tempArea * 10000d) / 10000d;
        areaNode.setConocimientoAPosteriori(conocimientoAreaAPosteriori);
        
    }
    
    public void descargarPDF(Node node)throws FileNotFoundException, DocumentException{
        boolean estado = false;
        for (int i = 0; i < listaEvaluacionAdaptativa.size(); i++) {
            if(node.getName().equals(listaEvaluacionAdaptativa.get(i).get(2))){
                estado = true;
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Donde desea guardar");   
                FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF", "pdf");
                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(filter);
                int userSelection = fileChooser.showSaveDialog(frmReporteNetworkBayesian);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    System.out.println("Save as file: " + fileToSave.getAbsolutePath()+".pdf");
                    // Se crea el documento
                    Document documento = new Document();
                    // Se crea el OutputStream para el fichero donde queremos dejar el pdf.
                    FileOutputStream ficheroPdf = new FileOutputStream(fileToSave.getAbsolutePath()+".pdf");
                    // Se asocia el documento al OutputStream y se indica que el espaciado entre
                    // lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
                    PdfWriter writer = PdfWriter.getInstance(documento,ficheroPdf);
                    writer.setInitialLeading(25);
                    //PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
                    //variables
                    Font evaluacionAdaptativaFont = FontFactory.getFont("arial",35,Font.BOLD,BaseColor.BLACK);
                    Font areaFont = FontFactory.getFont("arial",30,Font.BOLD,BaseColor.BLACK);
                    Font competenciaFont = FontFactory.getFont("arial",16,Font.NORMAL,BaseColor.BLACK);
                    Font periodoFont = FontFactory.getFont("arial",16,Font.NORMAL,BaseColor.BLACK);
                    Font AulaFont = FontFactory.getFont("arial",20,Font.BOLD,BaseColor.BLACK);
                    Font estudiantetTitleFont = FontFactory.getFont("arial",16,Font.BOLD,BaseColor.BLACK);
                    Font estudianteNameFont = FontFactory.getFont("arial",13,Font.NORMAL,BaseColor.BLACK);
                    Paragraph evaluacionAdaptativaText = new Paragraph("EVALUACIÓN ADAPTATIVA",evaluacionAdaptativaFont);
                    evaluacionAdaptativaText.setAlignment(Element.ALIGN_CENTER);
                    Paragraph areaText = new Paragraph(""+area.toUpperCase(),areaFont);
                    areaText.setAlignment(Element.ALIGN_CENTER);
                    Paragraph competenciaText = new Paragraph(node.getName().toUpperCase(),competenciaFont);
                    competenciaText.setAlignment(Element.ALIGN_CENTER);
                    Paragraph periodoText = new Paragraph(""+periodo.toUpperCase(),periodoFont);
                    periodoText.setAlignment(Element.ALIGN_CENTER);
                    Paragraph aulaText = new Paragraph(""+grado.toUpperCase()+"   ''"+seccion.toUpperCase()+"''",AulaFont);
                    aulaText.setAlignment(Element.ALIGN_CENTER);
                    Paragraph estudiantetTitleText = new Paragraph("ESTUDIANTE",estudiantetTitleFont);
                    estudiantetTitleText.setAlignment(Element.ALIGN_CENTER);
                    Paragraph estudiantetNameText = new Paragraph(""+estudiante.toUpperCase(),estudianteNameFont);
                    estudiantetNameText.setAlignment(Element.ALIGN_CENTER);
                    Paragraph estudiantetTitleNota = new Paragraph("NIVEL DE CONOCIMIENTO",estudiantetTitleFont);
                    estudiantetTitleNota.setAlignment(Element.ALIGN_CENTER);
                    //nota vigesimal
                    double calificacion = 0.0;
                    double porcentaje = 0.0;
                    calificacion = (double)1/cantCompetencia;
                    System.out.println("---------"+calificacion);
                    porcentaje = (double)(node.getConocimientoAPosteriori()*100)/calificacion;
                    porcentaje = (double)Math.round(porcentaje * 10000d) / 10000d;
                    calificacion = (double)(node.getConocimientoAPosteriori()*20)/calificacion;
                    calificacion = (double)Math.round(calificacion * 10000d) / 10000d;                    
                    Paragraph estudiantetNotaText = new Paragraph(""+calificacion+" ( "+porcentaje+"% ) ",estudianteNameFont);
                    estudiantetNotaText.setAlignment(Element.ALIGN_CENTER);                    
                    String a="a.";
                    String b="b.";
                    String c="c.";
                    String alter ="";
                    int contAlternativa = 0;
                    int contPregunta = 0;
                    // Se abre el documento.
                    documento.open();
                    //cabecera
                    documento.add(new Paragraph("\n"));
                    documento.add(new Paragraph("\n"));
                    documento.add(new Paragraph("\n"));
                    documento.add(new Paragraph("\n"));
                    documento.add(new Paragraph("\n"));
                    documento.add(new Paragraph("\n"));
                    documento.add(new Paragraph("\n"));
                    documento.add(new Paragraph("\n"));
                    documento.add(new Paragraph("\n"));
                    documento.add(new Paragraph("\n"));
                    documento.add(new Paragraph("\n"));
                    documento.add(evaluacionAdaptativaText);
                    documento.add(new Paragraph("\n"));
                    documento.add(areaText);
                    documento.add(competenciaText);
                    documento.add(periodoText);
                    documento.add(new Paragraph("\n"));
                    documento.add(new Paragraph("\n"));
                    documento.add(aulaText);
                    documento.add(new Paragraph("\n"));
                    documento.add(new Paragraph("\n"));
                    documento.add(estudiantetTitleText);
                    documento.add(estudiantetNameText);
                    documento.add(new Paragraph("\n"));
                    documento.add(new Paragraph("\n"));
                    documento.add(estudiantetTitleNota);
                    documento.add(estudiantetNotaText);
                    documento.add(new Paragraph("\n"));
                    documento.add(new Paragraph("\n"));
                    documento.add(new Paragraph("\n"));
                    documento.add(new Paragraph("\n"));
                    documento.add(new Paragraph("\n"));
                    documento.add(new Paragraph("\n"));
                    documento.add(new Paragraph("\n"));
                    documento.add(new Paragraph("\n"));                    
                    System.out.println("id:"+listaEvaluacionAdaptativa.get(i).get(0)+"area:"+listaEvaluacionAdaptativa.get(i).get(1)+" competencia:"+listaEvaluacionAdaptativa.get(i).get(2)+" periodo:"+listaEvaluacionAdaptativa.get(i).get(3)+" fecha:"+listaEvaluacionAdaptativa.get(i).get(4));
                    for (int j = 0; j < listaPreguntaDesempeño.size(); j++) {
                        if (listaEvaluacionAdaptativa.get(i).get(0) == listaPreguntaDesempeño.get(j).get(8)) {
                            System.out.println("\tpregunta:"+listaPreguntaDesempeño.get(j).get(1)+" idevalucion:"+listaPreguntaDesempeño.get(j).get(8));
                            contPregunta+=1;
                            documento.add(new Paragraph(""+contPregunta+". "+listaPreguntaDesempeño.get(j).get(1),FontFactory.getFont("arial",16,Font.BOLD,BaseColor.BLACK)));//PREGUNTA
                            contAlternativa = 0;//restablecer contador
                            for (int k = 0; k < listaImagen.size(); k++) {
                                if(listaImagen.get(k).getIdPregunta() == Integer.parseInt(listaPreguntaDesempeño.get(j).get(0).toString()) ){
                                    try {
                                        System.out.println("imagen:"+listaImagen.get(k).getImagen());
                                        Image foto = Image.getInstance(listaImagen.get(k).getImagen());
                                        foto.scaleAbsolute(300, 120);
                                        foto.setAlignment(Chunk.ALIGN_MIDDLE);
                                        documento.add(foto);  
                                        documento.add(new Paragraph("\n"));  
                                    } catch (DocumentException | IOException e) {
                                    }
                                }
                            }
                            Alternativa alternativa = (Alternativa)listaPreguntaDesempeño.get(j).get(4);
                            System.out.println("idpregunta:"+listaPreguntaDesempeño.get(j).get(0)+" descripcion:"+listaPreguntaDesempeño.get(j).get(1)+" estado: "+alternativa.isSuccess()+" idalternativa:"+alternativa.getIdAlternativa()+" IDEVALUACIONADAPTATIVA:"+listaPreguntaDesempeño.get(j).get(8));
                            Font alterFont = null;
                            for (int k = 0; k < listaAlternativa.size(); k++) {
                                if(Integer.parseInt(listaPreguntaDesempeño.get(j).get(0).toString())==listaAlternativa.get(k).getIdPregunta()){
                                    System.out.println("\tidalternativa: "+listaAlternativa.get(k).getIdAlternativa()+" descripcion:"+listaAlternativa.get(k).getDescripcion()+" estado: "+listaAlternativa.get(k).isSuccess()+" idpregunta:"+listaAlternativa.get(k).getIdPregunta());
                                    if(alternativa.getIdAlternativa() == listaAlternativa.get(k).getIdAlternativa()){
                                        System.out.println("\tidalternativa: "+listaAlternativa.get(k).getIdAlternativa()+" descripcion:"+listaAlternativa.get(k).getDescripcion()+" estado: "+listaAlternativa.get(k).isSuccess()+" idpregunta:"+listaAlternativa.get(k).getIdPregunta()+" ----eligio este xd");
                                        if(listaAlternativa.get(k).isSuccess()){
                                            alterFont = FontFactory.getFont("arial",16,Font.NORMAL,BaseColor.GREEN);    
                                        }else{
                                            alterFont = FontFactory.getFont("arial",16,Font.NORMAL,BaseColor.RED);  
                                        }
                                    }else{
                                        if(listaAlternativa.get(k).isSuccess()){
                                            alterFont = FontFactory.getFont("arial",16,Font.BOLD,BaseColor.GREEN);    
                                        }else{
                                            alterFont = FontFactory.getFont("arial",16,Font.NORMAL,BaseColor.BLACK);
                                        }
                                    }
                                    contAlternativa+=1;
                                    if(contAlternativa==1){alter =a;}
                                    if(contAlternativa==2){alter =b;}
                                    if(contAlternativa==3){alter =c;}
                                    Font itemFont = FontFactory.getFont("arial",16,Font.BOLD,BaseColor.BLACK);
                                    Paragraph comb=new Paragraph(); 
                                    comb.add(new Chunk(alter,itemFont)); 
                                    comb.add(new Chunk("  "+listaAlternativa.get(k).getDescripcion(),alterFont)); 
                                    documento.add(comb);
                                    if(contAlternativa==3){
                                        documento.add(new Paragraph("\n"));  
                                    }
                                }
                            }
                        }
                    }
                    documento.close();  
                    if(!documento.isOpen()){
                        JOptionPane.showMessageDialog(null,"PDF generado con exito!");
                    }
                }
            }
        }
        if(!estado){
            JOptionPane.showMessageDialog(null, "Aún no se ha realizado la evaluacion adaptativa"+"\n"+node.getTipo()+": "+node.getName()+"\nConocimiento aposteriori: "+node.getConocimientoAPosteriori());
        }
    }
    
    public static double getRandom(Double valorMinimo, Double valorMaximo) {
        Random rand = new Random();
        return  valorMinimo + ( valorMaximo - valorMinimo ) * rand.nextDouble();
    }
}
