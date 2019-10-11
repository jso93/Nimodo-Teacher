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
import pattern.dao.DocenteAulaDao;
import pattern.dao.GradoDao;
import pattern.dao.SeccionDao;
import pattern.model.Aula;
import pattern.model.DocenteAula;
import pattern.model.Grado;
import pattern.model.Seccion;
import pattern.view.FrmDocenteAula;

public class FrmDocenteAulaController extends KeyAdapter implements IView,ICrudView,ItemListener{
    //model
    private DocenteAula docenteAulaActual,docenteAulaNuevo;
    //view
    private final FrmDocenteAula frmDocenteAula;
    //dao
    private final DocenteAulaDao docenteAulaDao;
    private final AulaDao aulaDao;
    private final GradoDao gradoDao;
    private final SeccionDao seccionDao;
    //variables
    private String fecha;
    private int idPerfil,idAula,idGrado,idSeccion,idDocenteAula;
    private final List<DocenteAula> listaDocenteAAula;
    private final List<DocenteAula> listaDocenteDAula;
    private List<Aula> listaAula;
    private List<Grado> listaGrado;
    private List<Seccion> listaSeccion;
    private List<String> listaAulaGrado,listaAulaSeccion;
    private List<List<String>> listaDocenteSinAula;
    private List<List<String>> listaDocenteConAula;
    private DefaultTableModel modelSinAula,modelConAula;
    private final Object [] rowTableSinAula = new Object[4];
    private final Object [] rowTableConAula = new Object[6];
    private int cantidadFilasSinAula,cantidadFilasConAula;
    private String estadoSinAula,estadoConAula;
    private JTextFieldDateEditor editorFecha;
    
    public FrmDocenteAulaController(FrmDocenteAula frmDocenteAula) {
        this.frmDocenteAula = frmDocenteAula;
        this.docenteAulaDao = new DocenteAulaDao();
        this.aulaDao = new AulaDao();
        this.gradoDao = new GradoDao();
        this.seccionDao = new SeccionDao();
        this.listaDocenteAAula = new ArrayList<>();
        this.listaDocenteDAula = new ArrayList<>();
    }
    
    @Override
    public void initController() {
        frmDocenteAula.btnCreate.addActionListener(e -> Create());
        frmDocenteAula.btnDelete.addActionListener(e -> Delete());
        frmDocenteAula.txtBuscarSinMatricula.addKeyListener(this);
        frmDocenteAula.txtBuscarConMatricula.addKeyListener(this);
        frmDocenteAula.txtGrado.addItemListener(this);
        editorFecha = (JTextFieldDateEditor) frmDocenteAula.txtFecha.getDateEditor();
        editorFecha.setEditable(false);
    }

    @Override
    public void refreshView(){Clear();}

    @Override
    public void Create() {
        getAula();//recuperamos aula en la cual se van a asignar los docentes
        cantidadFilasSinAula = frmDocenteAula.tableSinMatricula.getRowCount();
        if(cantidadFilasSinAula>0){
            listaDocenteAAula.clear();
            for (int i = 0; i < cantidadFilasSinAula; i++) {
                estadoSinAula = frmDocenteAula.tableSinMatricula.getValueAt(i, 0).toString();
                if(estadoSinAula.equals("true")){
                    for (int j = 0; j <listaDocenteSinAula.size(); j++) {
                        if(listaDocenteSinAula.get(j).get(0).equals(frmDocenteAula.tableSinMatricula.getValueAt(i, 1).toString()))
                            idPerfil = Integer.parseInt(listaDocenteSinAula.get(j).get(3));//idPerfil
                    }
                    //nuevo
                    docenteAulaNuevo = new DocenteAula();
                    docenteAulaNuevo.setIdPerfil(idPerfil);
                    docenteAulaNuevo.setIdAula(idAula);
                    listaDocenteAAula.add(docenteAulaNuevo);    
                }
            }
            if(listaDocenteAAula.size()>0){
                fecha = ((JTextField) frmDocenteAula.txtFecha.getDateEditor().getUiComponent()).getText();
                if(!fecha.isEmpty()){
                    for (int i = 0; i < listaDocenteAAula.size(); i++) {
                        listaDocenteAAula.get(i).setFecha(fecha);
                        docenteAulaDao.Create(listaDocenteAAula.get(i));
                    }
                    JOptionPane.showMessageDialog(null,"Asignación exitosa!");
                    refreshView();      
                }else{
                    JOptionPane.showMessageDialog(null,"Seleccione fecha de la asignación!","Mensaje",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null,"Porfavor seleccione por lo menos a un docente que desea asignar aula!","Mensaje",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Todos los docentes ya fueron asignados a sus respectivas aulas!","Mensaje",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void Read() {
        getGrado();//cargar grado
        getDocenteSinAula();//docenteSinAula
        getDocenteConAula();//docenteAsignado
    }

    @Override public void Update(){}

    @Override
    public void Delete() {
        cantidadFilasConAula = frmDocenteAula.tableConMatricula.getRowCount();
        if(cantidadFilasConAula>0){
            listaDocenteDAula.clear();
            for (int i = 0; i < cantidadFilasConAula; i++) {
                estadoConAula = frmDocenteAula.tableConMatricula.getValueAt(i, 0).toString();
                if(estadoConAula.equals("true")){
                    for (int j = 0; j <listaDocenteConAula.size(); j++) {
                        if(listaDocenteConAula.get(j).get(0).equals(frmDocenteAula.tableConMatricula.getValueAt(i, 1).toString()))
                            idDocenteAula = Integer.parseInt(listaDocenteConAula.get(j).get(5));
                    }
                    //nuevo
                    docenteAulaActual = new DocenteAula();
                    docenteAulaActual.setIdDocenteAula(idDocenteAula);
                    listaDocenteDAula.add(docenteAulaActual);
                }
            }
            if(listaDocenteDAula.size()>0){
                int confirmado = JOptionPane.showConfirmDialog(null,"¿Seguro que desea eliminar las asignaciones de aulas a docentes seleccionadas?");     
                if (JOptionPane.OK_OPTION == confirmado){
                    for (int i = 0; i < listaDocenteDAula.size(); i++) {
                        docenteAulaDao.Delete(listaDocenteDAula.get(i));
                    }
                    JOptionPane.showMessageDialog(null,"Asignaciones eliminadas!");
                    refreshView();
                }
            }else{
                JOptionPane.showMessageDialog(null,"Porfavor seleccione por lo menos a un docente que desea eliminar aula!","Mensaje",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null,"No hay ningun docente asignado!","Mensaje",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void Clear() {
        frmDocenteAula.txtBuscarSinMatricula.setText("");
        frmDocenteAula.txtBuscarConMatricula.setText("");
        frmDocenteAula.txtFecha.setDate(null);
        frmDocenteAula.tableSinMatricula.setRowSorter(null);//clear filter
        frmDocenteAula.tableConMatricula.setRowSorter(null);//clear filter
        modelSinAula = new DefaultTableModel(){
        @Override public Class getColumnClass(int column) {switch (column) {case 0:return Boolean.class;default:;return String.class;}}
        @Override public boolean isCellEditable(int row, int column) {for (int i = 0; i < 4; i++)if(column==0)return true;return false;}};
        modelConAula = new DefaultTableModel(){
        @Override public Class getColumnClass(int column) {switch (column) {case 0:return Boolean.class;default:;return String.class;}}
        @Override public boolean isCellEditable(int row, int column) {for (int i = 0; i < 6; i++)if(column==0)return true;return false;}};
        Read();
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) 
            getSecciones(frmDocenteAula.txtGrado.getSelectedItem().toString());
    }
    
    public void getAula(){
        listaAula = aulaDao.Read();
        listaGrado = gradoDao.Read();
        listaSeccion = seccionDao.Read();
        //buscar id del grado seleccionado
        for (int i = 0; i < listaGrado.size(); i++) {
            if(listaGrado.get(i).getGrado().equals(frmDocenteAula.txtGrado.getSelectedItem().toString()))
                idGrado = listaGrado.get(i).getIdGrado();//buscar id del grado seleccionado
        }
        //buscar id de la seccion seleccionada
        for (int i = 0; i < listaSeccion.size(); i++) {
            if(listaSeccion.get(i).getSeccion().equals(frmDocenteAula.txtSeccion.getSelectedItem().toString()))
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
        frmDocenteAula.txtGrado.removeAllItems();/*limpiamos combo*/
        listaAulaGrado = aulaDao.aulaGrado();
        for(int i=0;i<listaAulaGrado.size();i++){/*cargamos grados en el combo*/
            frmDocenteAula.txtGrado.addItem(listaAulaGrado.get(i));
        }
    }
    
    public void getSecciones(String grado){
        if(listaAulaSeccion!=null)listaAulaSeccion.clear(); 
        frmDocenteAula.txtSeccion.removeAllItems();/*limpiamos combo*/
        listaAulaSeccion =  aulaDao.aulaSeccion(grado);
        for(int i=0;i<listaAulaSeccion.size();i++){/*cargamos secciones en el combo*/
            frmDocenteAula.txtSeccion.addItem(listaAulaSeccion.get(i));
        }
    }
    
    public void getDocenteSinAula(){
        listaDocenteSinAula = docenteAulaDao.docentesSinAula();
        if(listaDocenteSinAula.size()>0){
            //add column to table
            modelSinAula.addColumn("SELECCIONAR");
            modelSinAula.addColumn("DNI");
            modelSinAula.addColumn("NOMBRES");
            modelSinAula.addColumn("APELLIDOS");
            //add rowTable to table
            for (int i = 0; i <listaDocenteSinAula.size(); i++) {
                rowTableSinAula[0] = false;
                rowTableSinAula[1] = listaDocenteSinAula.get(i).get(0);
                rowTableSinAula[2] = listaDocenteSinAula.get(i).get(1);
                rowTableSinAula[3] = listaDocenteSinAula.get(i).get(2);
                modelSinAula.addRow(rowTableSinAula);
            }
        }
        frmDocenteAula.tableSinMatricula.setModel(modelSinAula);//seteamos model*/
    }
    
    public void getDocenteConAula(){
        listaDocenteConAula = docenteAulaDao.docentesConAula();
        if(listaDocenteConAula.size()>0){
            //add column to table
            modelConAula.addColumn("SELECCIONAR");
            modelConAula.addColumn("DNI");
            modelConAula.addColumn("NOMBRES");
            modelConAula.addColumn("APELLIDOS");
            modelConAula.addColumn("GRADO");
            modelConAula.addColumn("SECCION");
            //add rowTable to table
            for (int i = 0; i <listaDocenteConAula.size(); i++) {
                rowTableConAula[0] = false;
                rowTableConAula[1] = listaDocenteConAula.get(i).get(0);
                rowTableConAula[2] = listaDocenteConAula.get(i).get(1);
                rowTableConAula[3] = listaDocenteConAula.get(i).get(2);
                rowTableConAula[4] = listaDocenteConAula.get(i).get(3);
                rowTableConAula[5] = listaDocenteConAula.get(i).get(4);
                modelConAula.addRow(rowTableConAula);
            }
        }
        frmDocenteAula.tableConMatricula.setModel(modelConAula);//seteamos model*/
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        DefaultTableModel dm=(DefaultTableModel) frmDocenteAula.tableSinMatricula.getModel();
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<>(dm);
        frmDocenteAula.tableSinMatricula.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(frmDocenteAula.txtBuscarSinMatricula.getText()));
        cantidadFilasSinAula = frmDocenteAula.tableSinMatricula.getRowCount();
        
        DefaultTableModel dm1=(DefaultTableModel) frmDocenteAula.tableConMatricula.getModel();
        TableRowSorter<DefaultTableModel> tr1=new TableRowSorter<>(dm1);
        frmDocenteAula.tableConMatricula.setRowSorter(tr1);
        tr1.setRowFilter(RowFilter.regexFilter(frmDocenteAula.txtBuscarConMatricula.getText()));
        cantidadFilasConAula = frmDocenteAula.tableConMatricula.getRowCount();
    }
}