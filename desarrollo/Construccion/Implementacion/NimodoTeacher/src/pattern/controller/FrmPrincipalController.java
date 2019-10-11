package pattern.controller;

import app.BackGround;
import interfaces.IView;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import pattern.dao.AparienciaDao;
import pattern.view.FrmArea;
import pattern.view.FrmAula;
import pattern.view.FrmCapacidad;
import pattern.view.FrmCompetencia;
import pattern.view.FrmDocente;
import pattern.view.FrmDocenteAula;
import pattern.view.FrmEstilo;
import pattern.view.FrmEstudiante;
import pattern.view.FrmEstudianteMatricula;
import pattern.view.FrmEvaluacionAdaptativa;
import pattern.view.FrmEvaluacionAdaptativaConfig;
import pattern.view.FrmEvaluacionTradicional;
import pattern.view.FrmGrado;
import pattern.view.FrmDesempeño;
import pattern.view.FrmInfo;
import pattern.view.FrmMatriz;
import pattern.view.FrmNetworkBayesian;
import pattern.view.FrmNivel;
import pattern.view.FrmPeriodo;
import pattern.view.FrmPreguntaAuditiva;
import pattern.view.FrmPreguntaVisual;
import pattern.view.FrmPrincipal;
import pattern.view.FrmSeccion;

public class FrmPrincipalController implements IView,ActionListener{
    //view
    public FrmPrincipal frmPrincipal;
    private FrmDocente frmDocente;
    private FrmEstudiante frmEstudiante;
    private FrmGrado frmGrado;
    private FrmSeccion frmSeccion;
    private FrmArea frmArea;
    private FrmCompetencia frmCompetencia;
    private FrmCapacidad frmCapacidad;
    private FrmDesempeño frmDesempeño;
    private FrmMatriz frmMatriz;
    private FrmEstilo frmEstilo;
    private FrmNivel frmNivel;
    private FrmPeriodo frmPeriodo;
    private FrmAula frmAula;
    private FrmEstudianteMatricula frmEstudianteMatricula;
    private FrmDocenteAula frmDocenteAula;
    private FrmEvaluacionTradicional frmEvaluacionTradicional;
    private FrmPreguntaAuditiva frmPreguntaAuditiva;
    private FrmPreguntaVisual frmPreguntaVisual;
    private FrmEvaluacionAdaptativa frmEvaluacionAdaptativa;
    private FrmEvaluacionAdaptativaConfig frmEvaluacionAdaptativaConfig;
    private FrmNetworkBayesian frmNetworkBayesian;
    private FrmInfo frmInfo;
    //controller
    private FrmDocenteController frmDocenteController;
    private FrmEstudianteController frmEstudianteController;
    private FrmGradoController frmGradoController;
    private FrmSeccionController frmSeccionController;
    private FrmAreaController frmAreaController;
    private FrmCompetenciaController frmCompetenciaController;
    private FrmCapacidadController frmCapacidadController;
    private FrmDesempeñoController frmDesempeñoController;
    private FrmMatrizController frmMatrizController;
    private FrmEstiloController frmEstiloController;
    private FrmNivelController frmNivelController;
    private FrmPeriodoController frmPeriodoController;
    private FrmAulaController frmAulaController;
    private FrmEstudianteMatriculaController frmEstudianteMatriculaController;
    private FrmDocenteAulaController frmDocenteAulaController;
    private FrmEvaluacionTradicionalController frmEvaluacionTradicionalController;
    private FrmPreguntaAuditivaController frmPreguntaAuditivaController;
    private FrmPreguntaVisualController frmPreguntaVisualController;
    private FrmEvaluacionAdaptativaController frmEvaluacionAdaptativaController;
    private FrmEvaluacionAdaptativaConfigController frmEvaluacionAdaptativaConfigController;
    private FrmNetworkBayesianController frmNetworkBayesianController;
    //dao
    private final AparienciaDao aparienciaDao;
    //variables
    private final List<String> persona;
    private final List<JInternalFrame> listaInternalFrame;
    private final GridBagConstraints contenedor;
    private List<String> apariencia;
    private List<List<String>> ListaLookAndFeel;
    public FrmPrincipalController(FrmPrincipal frmPrincipal, List<String> persona) {
        this.frmPrincipal = frmPrincipal;
        this.persona = persona;
        this.aparienciaDao = new AparienciaDao();
        this.listaInternalFrame = new ArrayList<>();
        this.contenedor = new GridBagConstraints();
    }
    
    public void initView(){
        frmPrincipal = new FrmPrincipal();
        frmPrincipal.setTitle(persona.get(1)+" "+persona.get(2)+" - "+persona.get(6));
        frmPrincipal.setExtendedState(MAXIMIZED_BOTH);        
        frmPrincipal.setVisible(true);
        //view
        frmDocente = new FrmDocente();
        frmEstudiante = new FrmEstudiante();
        frmGrado = new FrmGrado();
        frmSeccion = new FrmSeccion();
        frmArea = new FrmArea();
        frmCompetencia = new FrmCompetencia();
        frmCapacidad = new FrmCapacidad();
        frmDesempeño = new FrmDesempeño();
        frmMatriz = new FrmMatriz();
        frmEstilo =  new FrmEstilo();
        frmNivel = new FrmNivel();
        frmPeriodo =  new FrmPeriodo();
        frmAula = new FrmAula();
        frmEstudianteMatricula = new FrmEstudianteMatricula();
        frmDocenteAula = new FrmDocenteAula();
        frmEvaluacionTradicional = new FrmEvaluacionTradicional();
        frmPreguntaAuditiva = new FrmPreguntaAuditiva();
        frmPreguntaVisual  = new FrmPreguntaVisual();
        frmEvaluacionAdaptativa = new FrmEvaluacionAdaptativa();
        frmEvaluacionAdaptativaConfig = new FrmEvaluacionAdaptativaConfig(frmPrincipal, true);//jdialog
        frmNetworkBayesian = new FrmNetworkBayesian();
        frmInfo = new FrmInfo(frmPrincipal, true);
        //controller
        frmDocenteController = new FrmDocenteController(frmDocente,persona);
        frmDocenteController.initController();
        frmEstudianteController = new FrmEstudianteController(frmEstudiante);
        frmEstudianteController.initController();
        frmGradoController = new FrmGradoController(frmGrado);
        frmGradoController.initController();
        frmSeccionController = new FrmSeccionController(frmSeccion);
        frmSeccionController.initController();
        frmAreaController = new FrmAreaController(frmArea);
        frmAreaController.initController();
        frmCompetenciaController = new FrmCompetenciaController(frmCompetencia);
        frmCompetenciaController.initController();
        frmCapacidadController = new FrmCapacidadController(frmCapacidad);
        frmCapacidadController.initController();
        frmDesempeñoController = new FrmDesempeñoController(frmDesempeño,persona);
        frmDesempeñoController.initController();
        frmMatrizController = new FrmMatrizController(frmMatriz,persona);
        frmMatrizController.initController();
        frmEstiloController =  new FrmEstiloController(frmEstilo);
        frmEstiloController.initController();
        frmNivelController =  new FrmNivelController(frmNivel);
        frmNivelController.initController();
        frmPeriodoController = new FrmPeriodoController(frmPeriodo);
        frmPeriodoController.initController();
        frmAulaController = new FrmAulaController(frmAula);
        frmAulaController.initController();
        frmEstudianteMatriculaController = new FrmEstudianteMatriculaController(frmEstudianteMatricula);
        frmEstudianteMatriculaController.initController();
        frmDocenteAulaController = new FrmDocenteAulaController(frmDocenteAula);
        frmDocenteAulaController.initController();
        frmEvaluacionTradicionalController = new FrmEvaluacionTradicionalController(frmEvaluacionTradicional,persona);
        frmEvaluacionTradicionalController.initController();
        frmPreguntaAuditivaController = new FrmPreguntaAuditivaController(frmPreguntaAuditiva,this,persona);
        frmPreguntaAuditivaController.initController();
        frmPreguntaVisualController = new FrmPreguntaVisualController(frmPreguntaVisual, this,persona);
        frmPreguntaVisualController.initController();
        frmEvaluacionAdaptativaController = new FrmEvaluacionAdaptativaController(frmEvaluacionAdaptativa,persona);
        frmEvaluacionAdaptativaController.initController();
        frmEvaluacionAdaptativaConfigController = new FrmEvaluacionAdaptativaConfigController(frmEvaluacionAdaptativaConfig,this.persona);
        frmEvaluacionAdaptativaConfigController.initController();
        frmNetworkBayesianController = new FrmNetworkBayesianController(frmNetworkBayesian,this, persona);
        frmNetworkBayesianController.initController();
        //add jinternalframe to panel
        frmPrincipal.panelPrincipal.add(frmDocente,contenedor);
        frmPrincipal.panelPrincipal.add(frmEstudiante,contenedor);
        frmPrincipal.panelPrincipal.add(frmGrado,contenedor);
        frmPrincipal.panelPrincipal.add(frmSeccion,contenedor);
        frmPrincipal.panelPrincipal.add(frmArea,contenedor);
        frmPrincipal.panelPrincipal.add(frmCompetencia,contenedor);
        frmPrincipal.panelPrincipal.add(frmCapacidad,contenedor);
        frmPrincipal.panelPrincipal.add(frmDesempeño,contenedor);
        frmPrincipal.panelPrincipal.add(frmMatriz,contenedor);
        frmPrincipal.panelPrincipal.add(frmEstilo,contenedor);
        frmPrincipal.panelPrincipal.add(frmNivel,contenedor);
        frmPrincipal.panelPrincipal.add(frmPeriodo,contenedor);
        frmPrincipal.panelPrincipal.add(frmAula,contenedor);
        frmPrincipal.panelPrincipal.add(frmEstudianteMatricula,contenedor);
        frmPrincipal.panelPrincipal.add(frmDocenteAula,contenedor);
        frmPrincipal.panelPrincipal.add(frmEvaluacionTradicional,contenedor);
        frmPrincipal.panelPrincipal.add(frmPreguntaAuditiva,contenedor);
        frmPrincipal.panelPrincipal.add(frmPreguntaVisual,contenedor);
        frmPrincipal.panelPrincipal.add(frmEvaluacionAdaptativa,contenedor);
        frmPrincipal.panelPrincipal.add(frmNetworkBayesian,contenedor);
        //add jinternalframe to list
        listaInternalFrame.add(frmDocente);
        listaInternalFrame.add(frmEstudiante);
        listaInternalFrame.add(frmGrado);
        listaInternalFrame.add(frmSeccion);
        listaInternalFrame.add(frmArea);
        listaInternalFrame.add(frmCompetencia);
        listaInternalFrame.add(frmCapacidad);
        listaInternalFrame.add(frmDesempeño);
        listaInternalFrame.add(frmMatriz);
        listaInternalFrame.add(frmEstilo);
        listaInternalFrame.add(frmNivel);
        listaInternalFrame.add(frmPeriodo);
        listaInternalFrame.add(frmAula);
        listaInternalFrame.add(frmEstudianteMatricula);
        listaInternalFrame.add(frmDocenteAula);
        listaInternalFrame.add(frmEvaluacionTradicional);
        listaInternalFrame.add(frmPreguntaAuditiva);
        listaInternalFrame.add(frmPreguntaVisual);
        listaInternalFrame.add(frmEvaluacionAdaptativa);
        listaInternalFrame.add(frmNetworkBayesian);    
        //ACCESOS
        if(persona.get(6).equals("Director")){
            frmPrincipal.menuEstilo.setEnabled(false);
            frmPrincipal.menuNivel.setEnabled(false);
        }
        if(persona.get(6).equals("Docente")){
            frmPrincipal.menuDocente.setEnabled(false);
            frmPrincipal.menuEstudiante.setEnabled(false);
            frmPrincipal.menuEstudianteMatricula.setEnabled(false);
            frmPrincipal.menuDocenteAula.setEnabled(false);
            frmPrincipal.menuGrado.setEnabled(false);
            frmPrincipal.menuSeccion.setEnabled(false);
            frmPrincipal.menuAula.setEnabled(false);
            frmPrincipal.menuEstilo.setEnabled(false);
            frmPrincipal.menuArea.setEnabled(false);
            frmPrincipal.menuCompetencia.setEnabled(false);
            frmPrincipal.menuCapacidad.setEnabled(false);
            frmPrincipal.menuNivel.setEnabled(false);
            frmPrincipal.menuPeriodo.setEnabled(false);
        }
        //
        //APARIENCIA
        apariencia = aparienciaDao.Read(persona.get(0));//look andfeel actual del usuario
        ListaLookAndFeel = aparienciaDao.ReadLookAndFeel();//lista de lookandfeel
        BackGround.updateLookAndFeel(apariencia.get(1),apariencia.get(2),listaInternalFrame);//cambiamos apariencia
    }
    
    @Override
    public void initController(){
        initView();
        //AGREGAR EVENTOS A LOS ITEMS DEL MENU
        frmPrincipal.menuDocente.addActionListener(this);
        frmPrincipal.menuEstudiante.addActionListener(this);
        frmPrincipal.menuGrado.addActionListener(this);
        frmPrincipal.menuSeccion.addActionListener(this);
        frmPrincipal.menuArea.addActionListener(this);
        frmPrincipal.menuCompetencia.addActionListener(this);
        frmPrincipal.menuCapacidad.addActionListener(this);
        frmPrincipal.menuDesempeño.addActionListener(this);
        frmPrincipal.menuMatriz.addActionListener(this);
        frmPrincipal.menuEstilo.addActionListener(this);
        frmPrincipal.menuNivel.addActionListener(this);
        frmPrincipal.menuPeriodo.addActionListener(this);
        frmPrincipal.menuAula.addActionListener(this);
        frmPrincipal.menuEstudianteMatricula.addActionListener(this);
        frmPrincipal.menuDocenteAula.addActionListener(this);
        frmPrincipal.menuEvaluacionTradicional.addActionListener(this);
        frmPrincipal.menuPreguntaAuditiva.addActionListener(this);
        frmPrincipal.menuPreguntaVisual.addActionListener(this);
        frmPrincipal.menuEvaluacionAdaptativa.addActionListener(this);
        frmPrincipal.menuEvaluacionAdaptativaConfig.addActionListener(this);
        frmPrincipal.menuNetworkBayesian.addActionListener(this);
        frmPrincipal.menuInfo.addActionListener(this);
        frmPrincipal.menuMetal.addActionListener(this);
        frmPrincipal.menuWindows.addActionListener(this);
        frmPrincipal.menuWindowsClassic.addActionListener(this);   
    }
    
    @Override public void refreshView(){}

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < listaInternalFrame.size(); i++)listaInternalFrame.get(i).setVisible(false);
        if (e.getActionCommand().equals("Docentes")){showView(0);frmDocenteController.refreshView();}
        if (e.getActionCommand().equals("Estudiantes")){showView(1);frmEstudianteController.refreshView();}
        if (e.getActionCommand().equals("Grados")){showView(2);frmGradoController.refreshView();}
        if (e.getActionCommand().equals("Secciones")){showView(3);frmSeccionController.refreshView();}
        if (e.getActionCommand().equals("Areas")){showView(4);frmAreaController.refreshView();}
        if (e.getActionCommand().equals("Competencias")){showView(5);frmCompetenciaController.refreshView();}
        if (e.getActionCommand().equals("Capacidades")){showView(6);frmCapacidadController.refreshView();}
        if (e.getActionCommand().equals("Desempeños")){showView(7);frmDesempeñoController.refreshView();}
        if (e.getActionCommand().equals("Matriz")){showView(8);frmMatrizController.refreshView();}
        if (e.getActionCommand().equals("Estilos")){showView(9);frmEstiloController.refreshView();}
        if (e.getActionCommand().equals("Niveles")){showView(10);frmNivelController.refreshView();}
        if (e.getActionCommand().equals("Periodo Académico")){showView(11);frmPeriodoController.refreshView();}
        if (e.getActionCommand().equals("Aulas")){showView(12);frmAulaController.refreshView();}
        if (e.getActionCommand().equals("Matricular estudiantes")){showView(13);frmEstudianteMatriculaController.refreshView();}
        if (e.getActionCommand().equals("Asignar Aula a Docentes")){showView(14);frmDocenteAulaController.refreshView();}
        if (e.getActionCommand().equals("Evaluación Tradicional")){showView(15);frmEvaluacionTradicionalController.refreshView();}
        if (e.getActionCommand().equals("Auditiva")){showView(16);frmPreguntaAuditivaController.refreshView();}
        if (e.getActionCommand().equals("Visual")){showView(17);frmPreguntaVisualController.refreshView();}        
        if (e.getActionCommand().equals("Evaluaciones Adaptativas")){showView(18);frmEvaluacionAdaptativaController.refreshView();}
        if (e.getActionCommand().equals("Redes Bayesianas")){showView(19);frmNetworkBayesianController.refreshView();}
        //jdialog
        if (e.getActionCommand().equals("Configuración")){
            frmEvaluacionAdaptativaConfigController.refreshView();
            frmEvaluacionAdaptativaConfig.setVisible(true);
            frmEvaluacionAdaptativaConfig.setLocationRelativeTo(null);
        }
        if (e.getActionCommand().equals("Información")){
            frmInfo.setTitle("Nimodo Teacher");
            frmInfo.setVisible(true);
        }
        //APARIENCIA
        for (int i = 0; i < ListaLookAndFeel.size(); i++) {
            if (e.getActionCommand().equals(ListaLookAndFeel.get(i).get(1))){
                aparienciaDao.Update(persona.get(0),ListaLookAndFeel.get(i).get(1));
                BackGround.updateLookAndFeel(ListaLookAndFeel.get(i).get(2),ListaLookAndFeel.get(i).get(3),listaInternalFrame);    
            }
        }
    }
    
    public void showView(int i){
        try {
            listaInternalFrame.get(i).setVisible(true);
            listaInternalFrame.get(i).setSelected(true);   
            listaInternalFrame.get(i).setMaximum(true); 
        } catch (PropertyVetoException ex) {}
    }
}
