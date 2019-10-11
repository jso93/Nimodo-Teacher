package pattern.controller;

import interfaces.ICrudView;
import interfaces.IView;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import pattern.dao.AreaDao;
import pattern.dao.CapacidadDao;
import pattern.dao.CompetenciaDao;
import pattern.dao.DocenteAulaDao;
import pattern.dao.DesempeñoDao;
import pattern.dao.MatrizDao;
import pattern.model.Area;
import pattern.model.Capacidad;
import pattern.model.Competencia;
import pattern.model.Desempeño;
import pattern.model.Matriz;
import pattern.view.FrmMatriz;

public class FrmMatrizController extends KeyAdapter implements IView,ICrudView,ListSelectionListener,ItemListener{
    //model
    private Matriz matrizNuevo,matrizActual;
    //view
    private final FrmMatriz frmMatriz;
    //dao
    private final MatrizDao matrizDao;
    private final AreaDao areaDao;
    private final CompetenciaDao competenciaDao;
    private final CapacidadDao capacidadDao;
    private final DesempeñoDao desempeñoDao;
    private final DocenteAulaDao docenteAulaDao;
    //variables
    private List<Matriz> listaMatriz;
    private List<Area> listaArea;
    private List<Competencia> listaCompetencia;
    private List<Capacidad> listaCapacidad;
    private List<Desempeño> listaDesempeño;
    private List<List<String>> listaDocente;
    private final List<String> persona;
    private DefaultTableModel model;
    private String area,competencia,capacidad,desempeño,dniDocente;
    private int idArea,idCompetencia,idCapacidad,idDesempeño,idDocenteAula;
    private final String [] rowTable = new String[4];
    private int row;
    
    public FrmMatrizController(FrmMatriz frmMatriz,List<String> persona) {
        this.frmMatriz = frmMatriz;
        this.matrizDao = new MatrizDao();
        this.areaDao = new AreaDao();
        this.competenciaDao = new CompetenciaDao();
        this.capacidadDao = new CapacidadDao();
        this.desempeñoDao = new DesempeñoDao();
        this.docenteAulaDao = new DocenteAulaDao();
        this.persona = persona;
    }
    
    @Override
    public void initController() {
        frmMatriz.btnCreate.addActionListener(e -> Create());
        frmMatriz.btnUpdate.addActionListener(e -> Update());
        frmMatriz.btnDelete.addActionListener(e -> Delete());
        frmMatriz.btnNew.addActionListener(e -> Clear());
        frmMatriz.table.getSelectionModel().addListSelectionListener(this);
        frmMatriz.txtBuscar.addKeyListener(this);
        frmMatriz.txtDesempenio.addItemListener(this);
    }

    @Override
    public void refreshView(){Clear();}

    @Override
    public void Create() {
        if(frmMatriz.txtDesempenio.getItemCount()>0){
            area = frmMatriz.txtArea.getSelectedItem().toString();
            competencia = frmMatriz.txtCompetencia.getSelectedItem().toString();
            capacidad = frmMatriz.txtCapacidad.getSelectedItem().toString();
            desempeño = frmMatriz.txtDesempenio.getSelectedItem().toString();
            //idArea
            for (int i = 0; i < listaArea.size(); i++) {
                if(listaArea.get(i).getArea().equals(area)){idArea = listaArea.get(i).getIdArea();break;}
            }
            //idCompetencia
            for (int i = 0; i < listaCompetencia.size(); i++) {
                if(listaCompetencia.get(i).getCompetencia().equals(competencia)){idCompetencia = listaCompetencia.get(i).getIdCompetencia();break;}
            }
            //idCapacidad
            for (int i = 0; i < listaCapacidad.size(); i++) {
                if(listaCapacidad.get(i).getCapacidad().equals(capacidad)){idCapacidad = listaCapacidad.get(i).getIdCapacidad();break;}
            }
            //idDesempeño
            for (int i = 0; i < listaDesempeño.size(); i++) {
                if(listaDesempeño.get(i).getDesempeño().equals(desempeño)){
                    if(idDocenteAula == listaDesempeño.get(i).getIdDocenteAula()){
                    idDesempeño = listaDesempeño.get(i).getIdDesempeño();break;}
                }
            }
            //nuevo
            matrizNuevo = new Matriz(0, idArea, idCompetencia, idCapacidad, idDesempeño,idDocenteAula);
            if(matrizDao.Create(matrizNuevo)){
                JOptionPane.showMessageDialog(null,"Registro exitoso!");
                refreshView();
            }else{
                JOptionPane.showMessageDialog(null,"Ya existe referencia del Desempeño, ingrese otro!","Mensaje",JOptionPane.ERROR_MESSAGE);
            }  
        }else{
            JOptionPane.showMessageDialog(null,"Debe registrar por lo menos un Desempeño!","Mensaje",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void Read() {
        getDocenteAula();
        getAreas();
        getCompetencias();
        getCapacidades();
        getDesempeños();
        getMatriz();
    }

    @Override
    public void Update() {
        if(!frmMatriz.table.getSelectionModel().isSelectionEmpty()){
            //ACTUAL
            matrizActual = new Matriz();
            //idArea
            for (int i = 0; i < listaArea.size(); i++) {
                if(listaArea.get(i).getArea().equals(frmMatriz.table.getValueAt(row, 0).toString())){matrizActual.setIdArea(listaArea.get(i).getIdArea());break;}
            }
            //idCompetencia
            for (int i = 0; i < listaCompetencia.size(); i++) {
                if(listaCompetencia.get(i).getCompetencia().equals(frmMatriz.table.getValueAt(row, 1).toString())){matrizActual.setIdCompetencia(listaCompetencia.get(i).getIdCompetencia());break;}
            }
            //idCapacidad
            for (int i = 0; i < listaCapacidad.size(); i++) {
                if(listaCapacidad.get(i).getCapacidad().equals(frmMatriz.table.getValueAt(row, 2).toString())){matrizActual.setIdCapacidad(listaCapacidad.get(i).getIdCapacidad());break;}
            }
            //idDesempeño
            for (int i = 0; i < listaDesempeño.size(); i++) {
                if(idDocenteAula == listaDesempeño.get(i).getIdDocenteAula()){
                    if(listaDesempeño.get(i).getDesempeño().equals(frmMatriz.table.getValueAt(row, 3).toString())){
                        matrizActual.setIdDesempeño(listaDesempeño.get(i).getIdDesempeño());
                        break;
                    }    
                }
                
            }
            //buscamos matriz
            for (int i = 0; i < listaMatriz.size(); i++) {
                if(matrizActual.getIdArea() == listaMatriz.get(i).getIdArea() && matrizActual.getIdCompetencia() == listaMatriz.get(i).getIdCompetencia() && 
                   matrizActual.getIdCapacidad() == listaMatriz.get(i).getIdCapacidad() && matrizActual.getIdDesempeño() == listaMatriz.get(i).getIdDesempeño()){
                    matrizActual.setIdMatriz(listaMatriz.get(i).getIdMatriz());//elemento a actualizar
                    matrizActual.setIdDocenteAula(idDocenteAula);
                    break;
                }
            }
            //datos nuevos para actualizar
            area = frmMatriz.txtArea.getSelectedItem().toString();
            competencia = frmMatriz.txtCompetencia.getSelectedItem().toString();
            capacidad = frmMatriz.txtCapacidad.getSelectedItem().toString();
            desempeño = frmMatriz.txtDesempenio.getSelectedItem().toString();
            //NUEVO
            //idArea
            for (int i = 0; i < listaArea.size(); i++) {
                if(listaArea.get(i).getArea().equals(area)){idArea = listaArea.get(i).getIdArea();break;}
            }
            //idCompetencia
            for (int i = 0; i < listaCompetencia.size(); i++) {
                if(listaCompetencia.get(i).getCompetencia().equals(competencia)){idCompetencia = listaCompetencia.get(i).getIdCompetencia();break;}
            }
            //idCapacidad
            for (int i = 0; i < listaCapacidad.size(); i++) {
                if(listaCapacidad.get(i).getCapacidad().equals(capacidad)){idCapacidad = listaCapacidad.get(i).getIdCapacidad();break;}
            }
            //idDesempeño
            for (int i = 0; i < listaDesempeño.size(); i++) {
                if(idDocenteAula == listaDesempeño.get(i).getIdDocenteAula()){
                    if(listaDesempeño.get(i).getDesempeño().equals(desempeño)){idDesempeño = listaDesempeño.get(i).getIdDesempeño();break;}    
                }
            }
            //nuevo
            matrizNuevo = new Matriz(0, idArea, idCompetencia, idCapacidad, idDesempeño,idDocenteAula);
            if(matrizDao.Update(matrizActual,matrizNuevo)){
                JOptionPane.showMessageDialog(null,"Actualización exitosa!");
                refreshView();
            }else{
                JOptionPane.showMessageDialog(null,"Ya existe referencia del Desempeño","Mensaje",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Seleccione una fila de la tabla para actualizar","Mensaje",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void Delete() {
        if(!frmMatriz.table.getSelectionModel().isSelectionEmpty()){
            int confirmado = JOptionPane.showConfirmDialog(null,"¿Seguro que desea eliminar el Desempeño de la matriz?");
            if (JOptionPane.OK_OPTION == confirmado){
                //ACTUAL
                matrizActual = new Matriz();
                //idArea
                for (int i = 0; i < listaArea.size(); i++) {
                    if(listaArea.get(i).getArea().equals(frmMatriz.table.getValueAt(row, 0).toString())){matrizActual.setIdArea(listaArea.get(i).getIdArea());break;}
                }
                //idCompetencia
                for (int i = 0; i < listaCompetencia.size(); i++) {
                    if(listaCompetencia.get(i).getCompetencia().equals(frmMatriz.table.getValueAt(row, 1).toString())){matrizActual.setIdCompetencia(listaCompetencia.get(i).getIdCompetencia());break;}
                }
                //idCapacidad
                for (int i = 0; i < listaCapacidad.size(); i++) {
                    if(listaCapacidad.get(i).getCapacidad().equals(frmMatriz.table.getValueAt(row, 2).toString())){matrizActual.setIdCapacidad(listaCapacidad.get(i).getIdCapacidad());break;}
                }
                //idDesempeño
                for (int i = 0; i < listaDesempeño.size(); i++) {
                    if(idDocenteAula == listaDesempeño.get(i).getIdDocenteAula()){
                        if(listaDesempeño.get(i).getDesempeño().equals(frmMatriz.table.getValueAt(row, 3).toString())){matrizActual.setIdDesempeño(listaDesempeño.get(i).getIdDesempeño());break;}
                    }               
                }
                //buscamos matriz
                for (int i = 0; i < listaMatriz.size(); i++) {
                    if(matrizActual.getIdArea() == listaMatriz.get(i).getIdArea() && matrizActual.getIdCompetencia() == listaMatriz.get(i).getIdCompetencia() && 
                       matrizActual.getIdCapacidad() == listaMatriz.get(i).getIdCapacidad() && matrizActual.getIdDesempeño() == listaMatriz.get(i).getIdDesempeño()){
                        matrizActual.setIdMatriz(listaMatriz.get(i).getIdMatriz());//elemento a actualizar
                        matrizActual.setIdDocenteAula(idDocenteAula);
                        break;
                    }
                }
                if(matrizDao.Delete(matrizActual)){
                    JOptionPane.showMessageDialog(null,"Desempeño eliminado de la Matriz!"); 
                }else{
                    JOptionPane.showMessageDialog(null,"Error al eliminar!","Mensaje",JOptionPane.ERROR_MESSAGE);
                }
            }
            refreshView();
        }else{
            JOptionPane.showMessageDialog(null,"Seleccione una fila de la tabla para actualizar","Mensaje",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void Clear() {
        frmMatriz.txtBuscar.setText("");
        frmMatriz.btnCreate.setEnabled(true);
        frmMatriz.table.setRowSorter(null);//clear filter
        model=new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
        Read();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()){
            if (frmMatriz.table.getSelectedRow() != -1) {
                row = frmMatriz.table.getSelectedRow();
                frmMatriz.txtArea.setSelectedItem(frmMatriz.table.getValueAt(row,0).toString());
                frmMatriz.txtCompetencia.setSelectedItem(frmMatriz.table.getValueAt(row,1).toString());
                frmMatriz.txtCapacidad.setSelectedItem(frmMatriz.table.getValueAt(row,2).toString());
                frmMatriz.txtDesempenio.setSelectedItem(frmMatriz.table.getValueAt(row,3).toString());
                getDescripcion();
                frmMatriz.btnCreate.setEnabled(false);
            }
        }
    }
    
    @Override 
    public void keyReleased(KeyEvent e) {
        DefaultTableModel dm=(DefaultTableModel) frmMatriz.table.getModel();
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<>(dm);
        frmMatriz.table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(frmMatriz.txtBuscar.getText()));
    }
    
    public void getDocenteAula(){
        dniDocente = persona.get(0);
        if(listaDocente!=null)listaDocente.clear(); 
        listaDocente = docenteAulaDao.docentesConAula();
        for (int i = 0; i < listaDocente.size(); i++) {
            if(listaDocente.get(i).get(0).equals(dniDocente)){
                idDocenteAula = Integer.parseInt(listaDocente.get(i).get(5));
            }
        }
    }
    
    public void getAreas(){
        if(listaArea!=null)listaArea.clear(); 
        frmMatriz.txtArea.removeAllItems();/*limpiamos combo*/
        listaArea=areaDao.Read();
        for(int i=0;i<listaArea.size();i++){/*cargamos areas en el combo*/
            frmMatriz.txtArea.addItem(listaArea.get(i).getArea());
        }
    }
    
    public void getCompetencias(){
        if(listaCompetencia!=null)listaCompetencia.clear(); 
        frmMatriz.txtCompetencia.removeAllItems();/*limpiamos combo*/
        listaCompetencia=competenciaDao.Read();
        for(int i=0;i<listaCompetencia.size();i++){/*cargamos competencias en el combo*/
            frmMatriz.txtCompetencia.addItem(listaCompetencia.get(i).getCompetencia());
        }
    }
    
    public void getCapacidades(){
        if(listaCapacidad!=null)listaCapacidad.clear(); 
        frmMatriz.txtCapacidad.removeAllItems();/*limpiamos combo*/
        listaCapacidad=capacidadDao.Read();
        for(int i=0;i<listaCapacidad.size();i++){/*cargamos capacidades en el combo*/
            frmMatriz.txtCapacidad.addItem(listaCapacidad.get(i).getCapacidad());
        }
    }
    
    public void getDesempeños(){
        if(listaDesempeño!=null)listaDesempeño.clear(); 
        frmMatriz.txtDesempenio.removeAllItems();/*limpiamos combo*/
        listaDesempeño=desempeñoDao.Read();
        for(int i=0;i<listaDesempeño.size();i++){/*cargamos desempeños en el combo*/
            if(idDocenteAula == listaDesempeño.get(i).getIdDocenteAula()){
            frmMatriz.txtDesempenio.addItem(listaDesempeño.get(i).getDesempeño());
            }
        }
    }
    
    public void getDescripcion(){
        for (int i = 0; i < listaDesempeño.size(); i++) {
            if(idDocenteAula == listaDesempeño.get(i).getIdDocenteAula()){
                if(listaDesempeño.get(i).getDesempeño().equals(frmMatriz.txtDesempenio.getSelectedItem().toString())){
                    frmMatriz.txtDescripcion.setText(listaDesempeño.get(i).getDescripcion());
                }    
            }
            
        }
    }
    
    public void getMatriz(){
        listaMatriz = matrizDao.Read();
        if(listaMatriz.size()>0){
            //add column to table
            model.addColumn("AREA");
            model.addColumn("COMPETENCIA");
            model.addColumn("CAPACIDAD");
            model.addColumn("DESEMPEÑO");
            //add rowTable to table
            for (int i = 0; i <listaMatriz.size(); i++) {
                //area
                for (int j = 0; j < listaArea.size(); j++) {
                    if(listaArea.get(j).getIdArea() == listaMatriz.get(i).getIdArea()){rowTable[0] = listaArea.get(j).getArea();}
                }
                //competencia
                for (int j = 0; j < listaCompetencia.size(); j++) {
                    if(listaCompetencia.get(j).getIdCompetencia()== listaMatriz.get(i).getIdCompetencia()){rowTable[1] = listaCompetencia.get(j).getCompetencia();}
                }
                //capacidad
                for (int j = 0; j < listaCapacidad.size(); j++) {
                    if(listaCapacidad.get(j).getIdCapacidad()== listaMatriz.get(i).getIdCapacidad()){rowTable[2] = listaCapacidad.get(j).getCapacidad();}
                }
                //desempeño de cada aulaDocente
                for (int j = 0; j < listaDesempeño.size(); j++) {
                    if(listaDesempeño.get(j).getIdDesempeño()== listaMatriz.get(i).getIdDesempeño()){
                        if(idDocenteAula == listaDesempeño.get(j).getIdDocenteAula()){
                        rowTable[3] = listaDesempeño.get(j).getDesempeño();
                        model.addRow(rowTable);
                        }
                    }
                }
                
            }
        }
        frmMatriz.table.setModel(model);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource().equals(frmMatriz.txtDesempenio) ){
            getDescripcion();
        }
    }
}
