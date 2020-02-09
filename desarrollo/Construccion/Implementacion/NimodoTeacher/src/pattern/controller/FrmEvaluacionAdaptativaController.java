package pattern.controller;

import interfaces.ICrudView;
import interfaces.IView;
import java.awt.MenuItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import pattern.dao.DocenteAulaDao;
import pattern.dao.EstudianteMatriculaDao;
import pattern.dao.EvaluacionAdaptativaDao;
import pattern.dao.MatrizDao;
import pattern.dao.PeriodoDao;
import pattern.model.Area;
import pattern.model.EvaluacionAdaptativa;
import pattern.model.Matriz;
import pattern.model.Periodo;
import pattern.model.Persona;
import pattern.view.FrmEvaluacionAdaptativa;

public class FrmEvaluacionAdaptativaController implements IView,ICrudView,ListSelectionListener{
    //model
    private EvaluacionAdaptativa evaluacionAdaptativaActual;
    //view
    private final FrmEvaluacionAdaptativa frmEvaluacionAdaptativa;
    //dao
    private final EstudianteMatriculaDao estudianteMatriculaDao;
    private final DocenteAulaDao docenteAulaDao;
    private final PeriodoDao periodoDao;
    private final MatrizDao matrizDao;
    private final EvaluacionAdaptativaDao evaluacionAdaptativaDao;
    //variables
    private List<List<String>> listaEstudiante;
    private List<List<String>> listaEstudianteMatriculado;
    private List<Matriz> listaMatriz;
    private List<List<Object>> listaEvaluacionAdaptativa;
    private List<Area> listaArea;
    private List<Periodo> listaPeriodo;
    private final List<String> persona;
    private List<List<String>> listaDocente;
    private int idDocenteAula;
    private String dniDocente;
    private String grado,seccion;
    private DefaultTableModel model;
    private final String [] rowTable = new String[5];
    private int row;
    private String area;
    private String periodo;
    private Map<Integer, String> mapa ;

    public FrmEvaluacionAdaptativaController(FrmEvaluacionAdaptativa frmEvaluacionAdaptativa,List<String> persona) {
        this.frmEvaluacionAdaptativa = frmEvaluacionAdaptativa;
        this.matrizDao = new MatrizDao();
        this.evaluacionAdaptativaDao = new EvaluacionAdaptativaDao();
        this.persona = persona;
        this.docenteAulaDao = new DocenteAulaDao();
        this.periodoDao = new PeriodoDao();
        this.estudianteMatriculaDao = new EstudianteMatriculaDao();
    }
    
    @Override
    public void initController() {
        frmEvaluacionAdaptativa.btnConsultar.addActionListener(e -> getEvaluacionAdaptativa());
        frmEvaluacionAdaptativa.btnDelete.addActionListener(e -> Delete());
        frmEvaluacionAdaptativa.table.getSelectionModel().addListSelectionListener(this);
    }
    
    @Override  public void refreshView() {Clear();}
    
    @Override
    public void Read(){
        getDocenteAula();
        getPeriodo();
        getEstudianteMatriculado();
        /*matriz*/
        getMatriz();
        getAreas();
        /*evaluacion adaptativa*/
        getEvaluacionAdaptativa();
    }
    
    public void getEvaluacionAdaptativa(){
        frmEvaluacionAdaptativa.table.setRowSorter(null);//clear filter
        model=new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
        int idEstudianteMatricula = frmEvaluacionAdaptativa.txtEstudiante.getSelectedIndex();
        System.out.println("index combo:"+idEstudianteMatricula);
        int aux = 0;
        for(int i=0;i<listaEstudianteMatriculado.size();i++){
            //if(idEstudianteMatricula == i){idEstudianteMatricula=Integer.parseInt(listaEstudianteMatriculado.get(i).get(5));break;}
            /*int aux = 0;
            boolean isactived = false;
            for (Map.Entry<Integer, String> entry : mapa.entrySet()) {
                int key = entry.getKey();
                String value = entry.getValue();
                if(idEstudianteMatricula == aux){
                    System.out.println("index:"+aux+" key:"+key+" value:"+value);
                    idEstudianteMatricula = key;
                    isactived = true;
                    break;
                }
                aux++;
            }
            if(isactived){break;}*/
            if(aux ==idEstudianteMatricula){
                idEstudianteMatricula = Integer.parseInt(listaEstudianteMatriculado.get(i).get(5));
                System.out.println("idmatricula:"+idEstudianteMatricula);
                System.out.println("DNI:"+listaEstudianteMatriculado.get(i).get(0));
                System.out.println("NOMBRES:"+listaEstudianteMatriculado.get(i).get(1));
                System.out.println("APELLIDOS:"+listaEstudianteMatriculado.get(i).get(2));
                break;
            }
            aux++;
        }
        area = frmEvaluacionAdaptativa.txtArea.getSelectedItem().toString();
        periodo = frmEvaluacionAdaptativa.txtPeriodo.getSelectedItem().toString();
        listaEvaluacionAdaptativa = evaluacionAdaptativaDao.Read(idEstudianteMatricula,idDocenteAula,area,periodo);
        if(listaEvaluacionAdaptativa.size()>0){
            //add column to table
            model.addColumn("ID");
            model.addColumn("AREA");
            model.addColumn("COMPETENCIA");
            model.addColumn("PERIODO");
            model.addColumn("FECHA");
            for (int i = 0; i < listaEvaluacionAdaptativa.size(); i++) {
                rowTable[0] = ""+listaEvaluacionAdaptativa.get(i).get(0);
                rowTable[1] = ""+listaEvaluacionAdaptativa.get(i).get(1);
                rowTable[2] = ""+listaEvaluacionAdaptativa.get(i).get(2);
                rowTable[3] = ""+listaEvaluacionAdaptativa.get(i).get(3);
                rowTable[4] = ""+listaEvaluacionAdaptativa.get(i).get(4);
                model.addRow(rowTable);
            }
        }else{
            System.out.println("no hay nada");
        }
        frmEvaluacionAdaptativa.table.setModel(model);//seteamos model
        if(frmEvaluacionAdaptativa.table.getColumnCount()!=0){
            frmEvaluacionAdaptativa.table.getColumnModel().getColumn(0).setWidth(0);
            frmEvaluacionAdaptativa.table.getColumnModel().getColumn(0).setMinWidth(0);
            frmEvaluacionAdaptativa.table.getColumnModel().getColumn(0).setMaxWidth(0);    
        }
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
        frmEvaluacionAdaptativa.txtEstudiante.removeAllItems();//limpiamos combo
        listaEstudianteMatriculado = new ArrayList<>();
        //mapa = new HashMap<>();
        for(int i=0;i<listaEstudiante.size();i++){
            if(grado.equals(listaEstudiante.get(i).get(3)) && seccion.equals(listaEstudiante.get(i).get(4))){
                frmEvaluacionAdaptativa.txtEstudiante.addItem(listaEstudiante.get(i).get(1));//new Item(1, "Test")                
                //mapa.put(Integer.parseInt(listaEstudiante.get(i).get(5)),listaEstudiante.get(i).get(1));
                listaEstudianteMatriculado.add(listaEstudiante.get(i));
                //System.out.println(listaEstudianteMatriculado.get(i));
            }
        }
    /*mapa.forEach((k,v)->{
             System.out.println("LLave = " + k + ", Valor = " + v);
        //Aqui llenas tu JComboBox
        frmEvaluacionAdaptativa.txtEstudiante.addItem(v);
       // frmEvaluacionAdaptativa.txtEstudiante.getSelectedItem().;
    });*/
    }
   
    public void getMatriz(){
        if(listaMatriz!=null)listaMatriz.clear(); 
        listaMatriz = matrizDao.Read();
        getAreas();
    }
    
    public void getAreas(){
        if(listaArea!=null)listaArea.clear(); 
        listaArea = matrizDao.getMatrizAreaRead(idDocenteAula);
        frmEvaluacionAdaptativa.txtArea.removeAllItems();//limpiamos combo
        for(int i=0;i<listaArea.size();i++){
            frmEvaluacionAdaptativa.txtArea.addItem(listaArea.get(i).getArea());
        }
    }
    
    public void getPeriodo(){
        if(listaPeriodo!=null)listaPeriodo.clear(); 
        frmEvaluacionAdaptativa.txtPeriodo.removeAllItems();//limpiamos combo
        listaPeriodo = periodoDao.Read();
        for (int i = 0; i < listaPeriodo.size(); i++) {
            frmEvaluacionAdaptativa.txtPeriodo.addItem(listaPeriodo.get(i).getPeriodo());
        }
    }
    
    @Override
    public void Delete() {
        if(!frmEvaluacionAdaptativa.table.getSelectionModel().isSelectionEmpty()){
            int confirmado = JOptionPane.showConfirmDialog(null,"¿Seguro que desea eliminar la evaluacion adaptativa?");
            if (JOptionPane.OK_OPTION == confirmado){
                //actual
                evaluacionAdaptativaActual = new EvaluacionAdaptativa();
                for (int i = 0; i < listaEvaluacionAdaptativa.size(); i++) {
                    int idEvaluacion = Integer.parseInt(listaEvaluacionAdaptativa.get(i).get(0).toString());
                    if(idEvaluacion==Integer.parseInt(frmEvaluacionAdaptativa.table.getValueAt(row,0).toString())){
                        int id = Integer.parseInt(frmEvaluacionAdaptativa.table.getValueAt(row,0).toString());
                        evaluacionAdaptativaActual.setIdEvaluacionAdaptativa(id);//primary key
                    }
                }
                if(evaluacionAdaptativaDao.Delete(evaluacionAdaptativaActual)){
                    JOptionPane.showMessageDialog(null,"Evaluacion Adaptativa eliminada!");  
                }else{
                    JOptionPane.showMessageDialog(null,"Error al eliminar!","Mensaje",JOptionPane.ERROR_MESSAGE);
                }
            }
            refreshView();
        }else{
            JOptionPane.showMessageDialog(null,"Seleccione una fila de la tabla para eliminar","Mensaje",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override    public void Create() {}

    @Override    public void Update() {}

    @Override
    public void Clear() {
        frmEvaluacionAdaptativa.table.setRowSorter(null);//clear filter
        model=new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
        Read();
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()){
            if (frmEvaluacionAdaptativa.table.getSelectedRow() != -1) {
                row = frmEvaluacionAdaptativa.table.getSelectedRow();
                frmEvaluacionAdaptativa.txtArea.setSelectedItem(frmEvaluacionAdaptativa.table.getValueAt(row,1).toString());
                frmEvaluacionAdaptativa.txtPeriodo.setSelectedItem(frmEvaluacionAdaptativa.table.getValueAt(row,3).toString());
            }
        }
    }
}
