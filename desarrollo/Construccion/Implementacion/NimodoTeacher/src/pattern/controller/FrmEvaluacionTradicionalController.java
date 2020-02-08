package pattern.controller;

import com.toedter.calendar.JTextFieldDateEditor;
import interfaces.ICrudView;
import interfaces.IView;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import pattern.dao.CalificacionDao;
import pattern.dao.DocenteAulaDao;
import pattern.dao.EstudianteMatriculaDao;
import pattern.dao.EvaluacionTradicionalDao;
import pattern.dao.MatrizDao;
import pattern.dao.PeriodoDao;
import pattern.model.Area;
import pattern.model.Calificacion;
import pattern.model.EvaluacionTradicional;
import pattern.model.Periodo;
import pattern.view.FrmEvaluacionTradicional;

public class FrmEvaluacionTradicionalController extends KeyAdapter implements IView,ICrudView,ItemListener{
    //model
    private EvaluacionTradicional evaluacionTradicionalNuevo,evaluacionTradicionalActual;
    private Calificacion calificacionNuevo;
    //view
    private final FrmEvaluacionTradicional frmEvaluacionTradicional;
    //dao
    private final EvaluacionTradicionalDao evaluacionTradicionalDao;
    private final CalificacionDao calificacionDao; 
    private final PeriodoDao periodoDao;
    private final MatrizDao matrizDao;
    private final DocenteAulaDao docenteAulaDao;
    private final EstudianteMatriculaDao estudianteMatriculaDao;
    //variables
    private final List<EvaluacionTradicional> listaEvaluacionTradicional;
    private List<Periodo> listaPeriodo;
    private List<Area> listaArea;
    private List<List<String>> listaDocente;
    private List<List<String>> listaEstudianteSET;
    private List<List<String>> listaEstudianteCET;
    private List<String> listaFecha;
    private List<List<Integer>> listaCalificacionEstudiante;
    private DefaultTableModel modelSET,modelCET;
    private String docente,grado,seccion,fecha,dniDocente,periodo,area;
    private final List<String> persona;
    private final Object [] rowTableSET = new Object[3];
    private final Object [] rowTableCET = new Object[3];
    private int cantidadCompetenciaSET,cantidadCompetenciaCET;
    private int idPeriodo,idArea,idEstudianteMatricula,idDocenteAula,idEvaluacionTradicional;
    private int cantidadFilaSET,cantidadColumnaSET,cantidadFilaCET,cantNotaIn,cantNotaOut,nota;
    private JTextFieldDateEditor editorFecha;
    private boolean evaluacionTradicionalCreate;

    public FrmEvaluacionTradicionalController(FrmEvaluacionTradicional frmEvaluacionTradicional,List<String> persona) {
        this.frmEvaluacionTradicional = frmEvaluacionTradicional;
        this.persona = persona;
        this.evaluacionTradicionalDao = new EvaluacionTradicionalDao();
        this.calificacionDao = new CalificacionDao();
        this.periodoDao = new PeriodoDao();
        this.matrizDao = new MatrizDao();
        this.docenteAulaDao = new DocenteAulaDao();
        this.estudianteMatriculaDao = new EstudianteMatriculaDao();
        this.listaEstudianteCET = new ArrayList<>();
        this.listaEvaluacionTradicional = new ArrayList<>();
    }
    
    @Override
    public void initController() {
        frmEvaluacionTradicional.btnCreate.addActionListener(e -> Create());
        frmEvaluacionTradicional.btnDelete.addActionListener(e -> Delete());
        frmEvaluacionTradicional.txtAreaSET.addItemListener(this);
        frmEvaluacionTradicional.txtBuscarSET.addKeyListener(this);
        frmEvaluacionTradicional.txtPeriodoCET.addItemListener(this);
        frmEvaluacionTradicional.txtAreaCET.addItemListener(this);
        frmEvaluacionTradicional.txtFechaCET.addItemListener(this);
        frmEvaluacionTradicional.txtBuscarCET.addKeyListener(this);
        editorFecha = (JTextFieldDateEditor) frmEvaluacionTradicional.txtFechaSET.getDateEditor();
        editorFecha.setEditable(false);
    }

    @Override
    public void refreshView(){Clear();}

    @Override
    public void Create() {
        //fecha
        fecha = ((JTextField) frmEvaluacionTradicional.txtFechaSET.getDateEditor().getUiComponent()).getText();//fecha
        //idperiodo
        for (int i = 0; i < listaPeriodo.size(); i++) {
            if(listaPeriodo.get(i).getPeriodo().equals(frmEvaluacionTradicional.txtPeriodoSET.getSelectedItem().toString()))
                idPeriodo = listaPeriodo.get(i).getIdPeriodo();
        }
        //idarea
        for (int i = 0; i < listaArea.size(); i++) {
            if(listaArea.get(i).getArea().equals(frmEvaluacionTradicional.txtAreaSET.getSelectedItem().toString()))
                idArea = listaArea.get(i).getIdArea();
        }
        //contamos filas y columnas
        cantidadFilaSET = frmEvaluacionTradicional.tableSET.getRowCount();
        cantidadColumnaSET = frmEvaluacionTradicional.tableSET.getColumnCount();
        if (cantidadFilaSET>0){
            cantNotaIn = 0;
            cantNotaOut = cantidadFilaSET * (cantidadColumnaSET-3);
            for (int i = 0; i < cantidadFilaSET; i++) {
                for (int j = 3; j < cantidadColumnaSET; j++) {
                    if(frmEvaluacionTradicional.tableSET.getValueAt(i, j)!=null ){
                        String notaLocal = String.valueOf(frmEvaluacionTradicional.tableSET.getValueAt(i, j).toString());
                        if(notaLocal.length()>0)if(isNumeric(notaLocal))cantNotaIn+=1;
                    }
                }
            }
            if(cantNotaIn == cantNotaOut){//verificamos que se haya ingresado todas las notas
                if(!fecha.isEmpty()){
                    evaluacionTradicionalCreate = false;
                    for (int i = 0; i < cantidadFilaSET; i++) {
                        //idestudiante_matricula
                        for (int j = 0; j < listaEstudianteSET.size(); j++) {
                            if(listaEstudianteSET.get(j).get(0).equals(frmEvaluacionTradicional.tableSET.getValueAt(i,0).toString())){
                                idEstudianteMatricula = Integer.parseInt(listaEstudianteSET.get(j).get(5));break;    
                            }
                        }
                        evaluacionTradicionalNuevo = new EvaluacionTradicional(0, fecha, idPeriodo, idArea, idEstudianteMatricula, idDocenteAula);
                        if(evaluacionTradicionalDao.Create(evaluacionTradicionalNuevo)){//registramos evaluacion tradicional
                            idEvaluacionTradicional = evaluacionTradicionalDao.getIdEvaluacionTradicional();
                            for (int j = 3; j < cantidadColumnaSET; j++) {
                                nota = Integer.parseInt(frmEvaluacionTradicional.tableSET.getValueAt(i, j).toString());
                                calificacionNuevo = new Calificacion(0, nota, idEvaluacionTradicional);
                                calificacionDao.Create(calificacionNuevo);//registramos calificaciones
                            }
                            evaluacionTradicionalCreate = true;
                        }
                    }
                    if(evaluacionTradicionalCreate){
                        JOptionPane.showMessageDialog(null,"Registro exitoso!");
                        refreshView();    
                    }else{
                        JOptionPane.showMessageDialog(null,"Ya existe la evaluacion tradicional!","Mensaje",JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Seleccione una fecha!","Mensaje",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null,"Existen calificaciones sin ingresar y deben ser numericos,porfavor ingrese todas las calificaciones!","Mensaje",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null,"No existen alumnos matriculados, debe de matricular algun estudiante!","Mensaje",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void Read() {
        getPeriodo();//recuperamos periodos
        getDocenteAula();
        getArea();//recuperamos areas;
        getFechas();//recuperamos fechas de las evaluaciones tradicionales registradas
    }

    @Override public void Update(){}

    @Override
    public void Delete() {
        cantidadFilaCET = frmEvaluacionTradicional.tableCET.getRowCount();
        if(cantidadFilaCET>0){
            int confirmado = JOptionPane.showConfirmDialog(null,"¿Seguro que desea eliminar la lista de evaluaciones tradicionales?");
            if (JOptionPane.OK_OPTION == confirmado){
                for (int i = 0; i < listaEvaluacionTradicional.size(); i++) {
                    evaluacionTradicionalDao.Delete(listaEvaluacionTradicional.get(i));
                }
                JOptionPane.showMessageDialog(null,"Evaluaciones tradicionales eliminadas!");
                refreshView();
            }
        }else{
            JOptionPane.showMessageDialog(null,"No existen evaluaciones tradicionales registradas!","Mensaje",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void Clear() {
        frmEvaluacionTradicional.txtDocenteSET.setText("");
        frmEvaluacionTradicional.txtGradoSET.setText("");
        frmEvaluacionTradicional.txtSeccionSET.setText("");
        frmEvaluacionTradicional.txtDocenteCET.setText("");
        frmEvaluacionTradicional.txtGradoCET.setText("");
        frmEvaluacionTradicional.txtSeccionCET.setText("");
        frmEvaluacionTradicional.tableCET.setRowSorter(null);//clear filter
        modelCET = new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
        Read();
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource().equals(frmEvaluacionTradicional.txtAreaSET) ){
            if(frmEvaluacionTradicional.txtAreaSET.getItemCount()>0)
                getCompetenciaSET(frmEvaluacionTradicional.txtAreaSET.getSelectedItem().toString());
        }
        if(e.getSource().equals(frmEvaluacionTradicional.txtPeriodoCET) || e.getSource().equals(frmEvaluacionTradicional.txtAreaCET )){
            if(frmEvaluacionTradicional.txtPeriodoCET.getItemCount()>0 && frmEvaluacionTradicional.txtAreaCET.getItemCount()>0 )
                getFechas();
            
        }
        if(e.getSource().equals(frmEvaluacionTradicional.txtFechaCET)){
            if(frmEvaluacionTradicional.txtPeriodoCET.getItemCount()>0 && frmEvaluacionTradicional.txtAreaCET.getItemCount()>0 && frmEvaluacionTradicional.txtFechaCET.getItemCount()>0)
                getEvaluacionesTradicionales();
        }
    }
    
    @Override 
    public void keyReleased(KeyEvent e) {
        DefaultTableModel dm=(DefaultTableModel) frmEvaluacionTradicional.tableSET.getModel();
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<>(dm);
        frmEvaluacionTradicional.tableSET.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(frmEvaluacionTradicional.txtBuscarSET.getText()));
        frmEvaluacionTradicional.btnCreate.setEnabled(true);
        
        DefaultTableModel dm1=(DefaultTableModel) frmEvaluacionTradicional.tableCET.getModel();
        TableRowSorter<DefaultTableModel> tr1=new TableRowSorter<>(dm1);
        frmEvaluacionTradicional.tableCET.setRowSorter(tr1);
        tr1.setRowFilter(RowFilter.regexFilter(frmEvaluacionTradicional.txtBuscarCET.getText()));
        frmEvaluacionTradicional.btnCreate.setEnabled(true);
    }
    
    public void getPeriodo(){
        if(listaPeriodo!=null)listaPeriodo.clear(); 
        frmEvaluacionTradicional.txtPeriodoSET.removeAllItems();/*limpiamos combo*/
        frmEvaluacionTradicional.txtPeriodoCET.removeAllItems();/*limpiamos combo*/
        listaPeriodo = periodoDao.Read();
        for(int i=0;i<listaPeriodo.size();i++){/*cargamos periodos en el combo*/
            frmEvaluacionTradicional.txtPeriodoSET.addItem(listaPeriodo.get(i).getPeriodo());
            frmEvaluacionTradicional.txtPeriodoCET.addItem(listaPeriodo.get(i).getPeriodo());
        }
    }
    
    public void getArea(){
        if(listaArea!=null)listaArea.clear(); 
        frmEvaluacionTradicional.txtAreaSET.removeAllItems();/*limpiamos combo*/
        frmEvaluacionTradicional.txtAreaCET.removeAllItems();/*limpiamos combo*/
        listaArea = matrizDao.getMatrizAreaRead(idDocenteAula);
        for(int i=0;i<listaArea.size();i++){/*cargamos periodos en el combo*/
            frmEvaluacionTradicional.txtAreaSET.addItem(listaArea.get(i).getArea());
            frmEvaluacionTradicional.txtAreaCET.addItem(listaArea.get(i).getArea());
        }
    }
    
    public void getDocenteAula(){
        dniDocente = persona.get(0);
        if(listaDocente!=null)listaDocente.clear(); 
        listaDocente = docenteAulaDao.docentesConAula();
        for (int i = 0; i < listaDocente.size(); i++) {
            if(listaDocente.get(i).get(0).equals(dniDocente)){
                idDocenteAula = Integer.parseInt(listaDocente.get(i).get(5));
                docente = listaDocente.get(i).get(1)+" "+listaDocente.get(i).get(2);
                grado = listaDocente.get(i).get(3);
                seccion = listaDocente.get(i).get(4);
                //SETEAMOS DATOS DEL DOCENTE AULA
                frmEvaluacionTradicional.txtDocenteSET.setText(docente);
                frmEvaluacionTradicional.txtGradoSET.setText(grado);
                frmEvaluacionTradicional.txtSeccionSET.setText(seccion);
                frmEvaluacionTradicional.txtDocenteCET.setText(docente);
                frmEvaluacionTradicional.txtGradoCET.setText(grado);
                frmEvaluacionTradicional.txtSeccionCET.setText(seccion);
            }
        }
    }
    
    public void getCompetenciaSET(String area){
        cantidadCompetenciaSET = matrizDao.getMatrizCompetenciaAreaRead(area,idDocenteAula).size();
        frmEvaluacionTradicional.tableSET.setRowSorter(null);//clear filter
        modelSET = new DefaultTableModel(){
        @Override public boolean isCellEditable(int row, int column) {for (int i = 3; i < (cantidadCompetenciaSET+3); i++)if(column>=i)return true;return false;}};
        getEstudianteMatricula();
    }
    
    public void getCompetenciaCET(String area){
        cantidadCompetenciaCET = matrizDao.getMatrizCompetenciaAreaRead(area,idDocenteAula).size();
    }
    
    public void getEstudianteMatricula(){
        if(listaEstudianteSET!=null)listaEstudianteSET.clear(); 
        listaEstudianteSET = estudianteMatriculaDao.estudiantesConMatricula();
        if(listaEstudianteSET.size()>0){
            //add column to table
            modelSET.addColumn("DNI");
            modelSET.addColumn("NOMBRES");
            modelSET.addColumn("APELLIDOS");
            for (int i = 0; i < cantidadCompetenciaSET; i++) {
                modelSET.addColumn("COMP."+(i+1));
            }
            //add rowTable to table
            for (int i = 0; i <listaEstudianteSET.size(); i++) {
                if(listaEstudianteSET.get(i).get(3).equals(grado) && listaEstudianteSET.get(i).get(4).equals(seccion)){
                rowTableSET[0] = listaEstudianteSET.get(i).get(0);
                rowTableSET[1] = listaEstudianteSET.get(i).get(1);
                rowTableSET[2] = listaEstudianteSET.get(i).get(2);
                modelSET.addRow(rowTableSET);  
                }
            }
        }
        frmEvaluacionTradicional.tableSET.setModel(modelSET);
    }
    
    public void getFechas(){
        periodo = frmEvaluacionTradicional.txtPeriodoCET.getSelectedItem().toString();
        area = frmEvaluacionTradicional.txtAreaCET.getSelectedItem().toString();
        if(listaFecha!=null)listaFecha.clear(); 
        listaFecha = evaluacionTradicionalDao.getFechas(dniDocente,periodo,area);
        frmEvaluacionTradicional.txtFechaCET.removeAllItems();/*limpiamos combo*/
        for (int i = 0; i < listaFecha.size(); i++) {
            frmEvaluacionTradicional.txtFechaCET.addItem(listaFecha.get(i));
        }
        getEvaluacionesTradicionales();    
    }
    
    public void getEvaluacionesTradicionales(){
        area = frmEvaluacionTradicional.txtAreaCET.getSelectedItem().toString();
        getCompetenciaCET(area);//contamos competencias por area
        frmEvaluacionTradicional.tableCET.setRowSorter(null);//clear filter
        modelCET = new DefaultTableModel(){
        @Override public boolean isCellEditable(int row, int column) {for (int i = 3; i < (cantidadCompetenciaCET+3); i++)if(column>=i)return true;return false;}};
        if(frmEvaluacionTradicional.txtFechaCET.getItemCount()>0){
            //add column to table
            modelCET.addColumn("DNI");
            modelCET.addColumn("NOMBRES");
            modelCET.addColumn("APELLIDOS");
            for (int i = 0; i < cantidadCompetenciaCET; i++) {
            modelCET.addColumn("COMP."+(i+1));
            }
            fecha = frmEvaluacionTradicional.txtFechaCET.getSelectedItem().toString();
            if(listaEstudianteCET!=null)listaEstudianteCET.clear(); 
                listaEstudianteCET = evaluacionTradicionalDao.getEvaluacionTradicionalEstudiante(dniDocente,periodo,area,fecha);
                listaCalificacionEstudiante = evaluacionTradicionalDao.evaluacionTradicionalCalificacionEstudiante(dniDocente, periodo, area, fecha);
                listaEvaluacionTradicional.clear();//reseteamos evaluaciones tradicionales de estudiantes
                int k;
                for (int i = 0; i < listaEstudianteCET.size(); i++) {
                    rowTableCET[0] = listaEstudianteCET.get(i).get(0);
                    rowTableCET[1] = listaEstudianteCET.get(i).get(1);
                    rowTableCET[2] = listaEstudianteCET.get(i).get(2);
                    modelCET.addRow(rowTableCET);  
                    k=3;
                    for (int j = 0; j < listaCalificacionEstudiante.size(); j++) {
                        int idEvaluacion_Tradicional = listaCalificacionEstudiante.get(j).get(0); 
                        if(idEvaluacion_Tradicional == Integer.parseInt(listaEstudianteCET.get(i).get(3))){
                            modelCET.setValueAt(listaCalificacionEstudiante.get(j).get(1),i,k);
                            k+=1;  
                        }else{
                            k=3;
                        }
                    }
                    //recuperamos id de las evaluaciones tradicionales
                    evaluacionTradicionalActual = new EvaluacionTradicional();
                    evaluacionTradicionalActual.setIdEvaluacionTradicional(Integer.parseInt(listaEstudianteCET.get(i).get(3)));
                    listaEvaluacionTradicional.add(evaluacionTradicionalActual);
                }
        }
        frmEvaluacionTradicional.tableCET.setModel(modelCET);
    }
    public static boolean isNumeric(String strNum) {
        boolean ret = true;
        try {
            Integer.parseInt(strNum);
        }catch (NumberFormatException e) {
            ret = false;
        }
        return ret;
    }
}
