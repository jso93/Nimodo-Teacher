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
import pattern.dao.AulaDao;
import pattern.dao.EstudianteMatriculaDao;
import pattern.dao.GradoDao;
import pattern.dao.SeccionDao;
import pattern.model.Aula;
import pattern.model.EstudianteMatricula;
import pattern.model.Grado;
import pattern.model.Seccion;
import pattern.view.FrmEstudianteMatricula;

public class FrmEstudianteMatriculaController extends KeyAdapter implements IView,ICrudView,ItemListener{
    //model
    private EstudianteMatricula estudianteMatriculaActual,estudianteMatriculaNuevo;
    //view
    private final FrmEstudianteMatricula frmEstudianteMatricula;
    //dao
    private final EstudianteMatriculaDao estudianteMatriculaDao;
    private final AulaDao aulaDao;
    private final GradoDao gradoDao;
    private final SeccionDao seccionDao;
    //variables
    private String fecha;
    private int idPerfil,idAula,idGrado,idSeccion,idEstudianteMatricula;
    private final List<EstudianteMatricula> listaEstudianteAMatricular;
    private final List<EstudianteMatricula> listaEstudianteDMatricular;
    private List<Aula> listaAula;
    private List<Grado> listaGrado;
    private List<Seccion> listaSeccion;
    private List<String> listaAulaGrado,listaAulaSeccion;
    private List<List<String>> listaEstudianteSinMatricula;
    private List<List<String>> listaEstudianteConMatricula;
    private DefaultTableModel modelSinMatricula,modelConMatricula;
    private final Object [] rowTableSinMatricula = new Object[4];
    private final Object [] rowTableConMatricula = new Object[6];
    private int cantidadFilasSinMatricula,cantidadFilasConMatricula;
    private String estadoSinMatricula,estadoConMatricula;
    private JTextFieldDateEditor editorFecha;
    
    public FrmEstudianteMatriculaController(FrmEstudianteMatricula frmEstudianteMatricula) {
        this.frmEstudianteMatricula = frmEstudianteMatricula;
        this.estudianteMatriculaDao = new EstudianteMatriculaDao();
        this.aulaDao = new AulaDao();
        this.gradoDao = new GradoDao();
        this.seccionDao = new SeccionDao();
        this.listaEstudianteAMatricular = new ArrayList<>();
        this.listaEstudianteDMatricular = new ArrayList<>();
    }
    
    @Override
    public void initController() {
        frmEstudianteMatricula.btnCreate.addActionListener(e -> Create());
        frmEstudianteMatricula.btnDelete.addActionListener(e -> Delete());
        frmEstudianteMatricula.txtBuscarSinMatricula.addKeyListener(this);
        frmEstudianteMatricula.txtBuscarConMatricula.addKeyListener(this);
        frmEstudianteMatricula.txtGrado.addItemListener(this);
        editorFecha = (JTextFieldDateEditor) frmEstudianteMatricula.txtFecha.getDateEditor();
        editorFecha.setEditable(false);
    }

    @Override public void refreshView(){Clear();}

    @Override
    public void Create() {
        getAula();//recuperamos aula en lacual se van a matricular los estudiantes
        cantidadFilasSinMatricula = frmEstudianteMatricula.tableSinMatricula.getRowCount();
        if(cantidadFilasSinMatricula>0){
            listaEstudianteAMatricular.clear();
            for (int i = 0; i < cantidadFilasSinMatricula; i++) {
                estadoSinMatricula = frmEstudianteMatricula.tableSinMatricula.getValueAt(i, 0).toString();
                if(estadoSinMatricula.equals("true")){
                    for (int j = 0; j <listaEstudianteSinMatricula.size(); j++) {
                        if(listaEstudianteSinMatricula.get(j).get(0).equals(frmEstudianteMatricula.tableSinMatricula.getValueAt(i, 1).toString()))
                            idPerfil = Integer.parseInt(listaEstudianteSinMatricula.get(j).get(3));//idPerfil
                    }
                    //nuevo
                    estudianteMatriculaNuevo = new EstudianteMatricula();
                    estudianteMatriculaNuevo.setIdPerfil(idPerfil);
                    estudianteMatriculaNuevo.setIdAula(idAula);
                    listaEstudianteAMatricular.add(estudianteMatriculaNuevo);    
                }
            }
            if(listaEstudianteAMatricular.size()>0){
                fecha = ((JTextField) frmEstudianteMatricula.txtFecha.getDateEditor().getUiComponent()).getText();
                if(!fecha.isEmpty()){
                    for (int i = 0; i < listaEstudianteAMatricular.size(); i++) {
                        listaEstudianteAMatricular.get(i).setFecha(fecha);
                        estudianteMatriculaDao.Create(listaEstudianteAMatricular.get(i));
                    }
                    JOptionPane.showMessageDialog(null,"Matricula exitosa!");
                    refreshView();      
                }else{
                    JOptionPane.showMessageDialog(null,"Seleccione fecha de matricula!","Mensaje",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null,"Porfavor seleccione por lo menos a un estudiante que desea matricular!","Mensaje",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Todos los estudiantes ya estan matriculados!","Mensaje",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void Read() {
        getGrado();//cargar grado
        getEstudianteSinMatricula();//estudiantesSinMatricula
        getEstudianteConMatricula();//estudiantesMatriculados
    }

    @Override public void Update(){}

    @Override
    public void Delete() {
        cantidadFilasConMatricula = frmEstudianteMatricula.tableConMatricula.getRowCount();
        if(cantidadFilasConMatricula>0){
            listaEstudianteDMatricular.clear();
            for (int i = 0; i < cantidadFilasConMatricula; i++) {
                estadoConMatricula = frmEstudianteMatricula.tableConMatricula.getValueAt(i, 0).toString();
                if(estadoConMatricula.equals("true")){
                    for (int j = 0; j <listaEstudianteConMatricula.size(); j++) {
                        if(listaEstudianteConMatricula.get(j).get(0).equals(frmEstudianteMatricula.tableConMatricula.getValueAt(i, 1).toString()))
                            idEstudianteMatricula = Integer.parseInt(listaEstudianteConMatricula.get(j).get(5));
                    }
                    //nuevo
                    estudianteMatriculaActual = new EstudianteMatricula();
                    estudianteMatriculaActual.setIdEstudianteMatricula(idEstudianteMatricula);
                    listaEstudianteDMatricular.add(estudianteMatriculaActual);
                }
            }
            if(listaEstudianteDMatricular.size()>0){
                int confirmado = JOptionPane.showConfirmDialog(null,"¿Seguro que desea eliminar las matriculas seleccionadas?");     
                if (JOptionPane.OK_OPTION == confirmado){
                    for (int i = 0; i < listaEstudianteDMatricular.size(); i++) {
                        estudianteMatriculaDao.Delete(listaEstudianteDMatricular.get(i));
                    }
                    JOptionPane.showMessageDialog(null,"Matricula eliminada!");
                    refreshView();
                }      
            }else{
                JOptionPane.showMessageDialog(null,"Porfavor seleccione por lo menos a un estudiante que desea eliminar matricula!","Mensaje",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null,"No hay ningun estudiante matriculado!","Mensaje",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void Clear() {
        frmEstudianteMatricula.txtBuscarSinMatricula.setText("");
        frmEstudianteMatricula.txtBuscarConMatricula.setText("");
        frmEstudianteMatricula.txtFecha.setDate(null);
        frmEstudianteMatricula.tableSinMatricula.setRowSorter(null);//clear filter
        frmEstudianteMatricula.tableConMatricula.setRowSorter(null);//clear filter
        modelSinMatricula = new DefaultTableModel(){
        @Override public Class getColumnClass(int column) {switch (column) {case 0:return Boolean.class;default:;return String.class;}}
        @Override public boolean isCellEditable(int row, int column) {for (int i = 0; i < 4; i++)if(column==0)return true;return false;}};
        modelConMatricula = new DefaultTableModel(){
        @Override public Class getColumnClass(int column) {switch (column) {case 0:return Boolean.class;default:;return String.class;}}
        @Override public boolean isCellEditable(int row, int column) {for (int i = 0; i < 6; i++)if(column==0)return true;return false;}};
        Read();
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) 
            getSecciones(frmEstudianteMatricula.txtGrado.getSelectedItem().toString());
    }
    
    public void getAula(){
        listaAula = aulaDao.Read();
        listaGrado = gradoDao.Read();
        listaSeccion = seccionDao.Read();
        //buscar id del grado seleccionado
        for (int i = 0; i < listaGrado.size(); i++) {
            if(listaGrado.get(i).getGrado().equals(frmEstudianteMatricula.txtGrado.getSelectedItem().toString()))
                idGrado = listaGrado.get(i).getIdGrado();//buscar id del grado seleccionado
        }
        //buscar id de la seccion seleccionada
        for (int i = 0; i < listaSeccion.size(); i++) {
            if(listaSeccion.get(i).getSeccion().equals(frmEstudianteMatricula.txtSeccion.getSelectedItem().toString()))
                idSeccion = listaSeccion.get(i).getIdSeccion();
        }
        //buscar id del aula segun grado y seccion seleccionado
        for (int i = 0; i < listaAula.size(); i++) {
            if(listaAula.get(i).getIdGrado() == idGrado && listaAula.get(i).getIdSeccion() == idSeccion)
                idAula = listaAula.get(i).getIdAula();//idAula
        }
    }
    public void getGrado(){
        if(listaAulaGrado!=null)listaAulaGrado.clear(); 
        frmEstudianteMatricula.txtGrado.removeAllItems();/*limpiamos combo*/
        listaAulaGrado = aulaDao.aulaGrado();
        for(int i=0;i<listaAulaGrado.size();i++){/*cargamos grados en el combo*/
            frmEstudianteMatricula.txtGrado.addItem(listaAulaGrado.get(i));
        }
    }
    
    public void getSecciones(String grado){
        if(listaAulaSeccion!=null)listaAulaSeccion.clear(); 
        frmEstudianteMatricula.txtSeccion.removeAllItems();/*limpiamos combo*/
        listaAulaSeccion =  aulaDao.aulaSeccion(grado);
        for(int i=0;i<listaAulaSeccion.size();i++){/*cargamos secciones en el combo*/
            frmEstudianteMatricula.txtSeccion.addItem(listaAulaSeccion.get(i));
        }
    }
    
    public void getEstudianteSinMatricula(){
        listaEstudianteSinMatricula = estudianteMatriculaDao.estudiantesSinMatricula();
        if(listaEstudianteSinMatricula.size()>0){
            //add column to table
            modelSinMatricula.addColumn("SELECCIONAR");
            modelSinMatricula.addColumn("DNI");
            modelSinMatricula.addColumn("NOMBRES");
            modelSinMatricula.addColumn("APELLIDOS");
            //add rowTable to table
            for (int i = 0; i <listaEstudianteSinMatricula.size(); i++) {
                rowTableSinMatricula[0] = false;
                rowTableSinMatricula[1] = listaEstudianteSinMatricula.get(i).get(0);
                rowTableSinMatricula[2] = listaEstudianteSinMatricula.get(i).get(1);
                rowTableSinMatricula[3] = listaEstudianteSinMatricula.get(i).get(2);
                modelSinMatricula.addRow(rowTableSinMatricula);
            }
        }
        frmEstudianteMatricula.tableSinMatricula.setModel(modelSinMatricula);//seteamos model*/
    }
    
    public void getEstudianteConMatricula(){
        listaEstudianteConMatricula = estudianteMatriculaDao.estudiantesConMatricula();
        if(listaEstudianteConMatricula.size()>0){
            //add column to table
            modelConMatricula.addColumn("SELECCIONAR");
            modelConMatricula.addColumn("DNI");
            modelConMatricula.addColumn("NOMBRES");
            modelConMatricula.addColumn("APELLIDOS");
            modelConMatricula.addColumn("GRADO");
            modelConMatricula.addColumn("SECCION");
            //add rowTable to table
            for (int i = 0; i <listaEstudianteConMatricula.size(); i++) {
                rowTableConMatricula[0] = false;
                rowTableConMatricula[1] = listaEstudianteConMatricula.get(i).get(0);
                rowTableConMatricula[2] = listaEstudianteConMatricula.get(i).get(1);
                rowTableConMatricula[3] = listaEstudianteConMatricula.get(i).get(2);
                rowTableConMatricula[4] = listaEstudianteConMatricula.get(i).get(3);
                rowTableConMatricula[5] = listaEstudianteConMatricula.get(i).get(4);
                modelConMatricula.addRow(rowTableConMatricula);
            }
        }
        frmEstudianteMatricula.tableConMatricula.setModel(modelConMatricula);//seteamos model*/
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        DefaultTableModel dm=(DefaultTableModel) frmEstudianteMatricula.tableSinMatricula.getModel();
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<>(dm);
        frmEstudianteMatricula.tableSinMatricula.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(frmEstudianteMatricula.txtBuscarSinMatricula.getText()));
        cantidadFilasSinMatricula = frmEstudianteMatricula.tableSinMatricula.getRowCount();
        
        DefaultTableModel dm1=(DefaultTableModel) frmEstudianteMatricula.tableConMatricula.getModel();
        TableRowSorter<DefaultTableModel> tr1=new TableRowSorter<>(dm1);
        frmEstudianteMatricula.tableConMatricula.setRowSorter(tr1);
        tr1.setRowFilter(RowFilter.regexFilter(frmEstudianteMatricula.txtBuscarConMatricula.getText()));
        cantidadFilasConMatricula = frmEstudianteMatricula.tableConMatricula.getRowCount();
    }
}