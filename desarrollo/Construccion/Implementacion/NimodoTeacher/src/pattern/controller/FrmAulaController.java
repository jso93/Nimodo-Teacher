package pattern.controller;

import interfaces.ICrudView;
import interfaces.IView;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import pattern.dao.AulaDao;
import pattern.dao.GradoDao;
import pattern.dao.SeccionDao;
import pattern.model.Aula;
import pattern.model.Grado;
import pattern.model.Seccion;
import pattern.view.FrmAula;

public class FrmAulaController extends KeyAdapter implements IView,ICrudView,ListSelectionListener{
    //model
    private Aula aulaActual,aulaNuevo;
    //view
    private final FrmAula frmAula;
    //dao
    private final AulaDao aulaDao;
    private final GradoDao gradoDao;
    private final SeccionDao seccionDao;
    //variables
    private String grado,seccion,gradoNuevo,seccionNuevo;
    private int idAula,idGrado,idSeccion,idGradoNuevo,idSeccionNuevo;
    private List<Aula> listaAula;
    private List<Grado> listaGrado;
    private List<Seccion> listaSeccion;
    private DefaultTableModel model;
    private final String [] rowTable = new String[2];
    private int row;

    public FrmAulaController(FrmAula frmAula) {
        this.frmAula = frmAula;
        this.aulaDao = new AulaDao();
        this.gradoDao = new GradoDao();
        this.seccionDao = new SeccionDao();
    }

    @Override
    public void initController() {
        frmAula.btnCreate.addActionListener(e -> Create());
        frmAula.btnUpdate.addActionListener(e -> Update());
        frmAula.btnDelete.addActionListener(e -> Delete());
        frmAula.btnNew.addActionListener(e -> Clear());
        frmAula.table.getSelectionModel().addListSelectionListener(this);
        frmAula.txtBuscar.addKeyListener(this);
    }

    @Override
    public void refreshView(){Clear();}

    @Override
    public void Create() {
        if(frmAula.txtGrado.getItemCount()>0 && frmAula.txtSeccion.getItemCount()>0){
            grado = frmAula.txtGrado.getSelectedItem().toString();
            seccion = frmAula.txtSeccion.getSelectedItem().toString();
            //nuevo
            aulaNuevo = new Aula();
            for (int i = 0; i < listaGrado.size(); i++) {
                if(listaGrado.get(i).getGrado().equals(grado))
                    aulaNuevo.setIdGrado(listaGrado.get(i).getIdGrado());
            }
            for (int i = 0; i < listaSeccion.size(); i++) {
                if(listaSeccion.get(i).getSeccion().equals(seccion))
                    aulaNuevo.setIdSeccion(listaSeccion.get(i).getIdSeccion());
            }
            if(aulaDao.Create(aulaNuevo)){
                JOptionPane.showMessageDialog(null,"Registro exitoso!");
                refreshView();
            }else{
                JOptionPane.showMessageDialog(null,"Ya existe aula, ingrese otro!","Mensaje",JOptionPane.ERROR_MESSAGE);
            }    
        }else{
            JOptionPane.showMessageDialog(null,"No existe grados o secciones registradas,\npor favor registre algun grado y seccion!","Mensaje",JOptionPane.ERROR_MESSAGE);
            refreshView();
        }
    }

    @Override
    public void Read() {
        //lista grado
        getGrados();
        //lista secciones
        getSecciones();
        //lista aulas
        listaAula = aulaDao.Read();
        if(listaAula.size()>0){
            //add column to table
            model.addColumn("GRADO");
            model.addColumn("SECCION");
            //add rowTable to table
            for (int i = 0; i <listaAula.size(); i++) {
                for (int j = 0; j < listaGrado.size(); j++) {
                    if(listaAula.get(i).getIdGrado() == listaGrado.get(j).getIdGrado())
                        grado = listaGrado.get(j).getGrado();//recuperamos grado
                }
                for (int j = 0; j < listaSeccion.size(); j++) {
                    if(listaAula.get(i).getIdSeccion() == listaSeccion.get(j).getIdSeccion())
                        seccion = listaSeccion.get(j).getSeccion();//recuperamos seccion
                }
                rowTable[0] = grado;
                rowTable[1] = seccion;
                model.addRow(rowTable);
            }
        }
        frmAula.table.setModel(model);//seteamos model
    }

    @Override
    public void Update() {
        if(!frmAula.table.getSelectionModel().isSelectionEmpty()){
            grado = frmAula.table.getValueAt(row, 0).toString();
            seccion = frmAula.table.getValueAt(row, 1).toString();
            gradoNuevo = frmAula.txtGrado.getSelectedItem().toString();
            seccionNuevo = frmAula.txtSeccion.getSelectedItem().toString();
            if(!grado.isEmpty() && !seccion.isEmpty()){
                    //actual
                    aulaActual = new Aula();
                    for (int i = 0; i < listaGrado.size(); i++) {
                        if(listaGrado.get(i).getGrado().equals(grado))
                            idGrado = listaGrado.get(i).getIdGrado();
                    }
                    for (int i = 0; i < listaSeccion.size(); i++) {
                        if(listaSeccion.get(i).getSeccion().equals(seccion))
                            idSeccion = listaSeccion.get(i).getIdSeccion();
                    }
                    for (int i = 0; i < listaAula.size(); i++) {
                        if(listaAula.get(i).getIdGrado() == idGrado && listaAula.get(i).getIdSeccion() == idSeccion)
                            idAula = listaAula.get(i).getIdAula();
                    }
                    aulaActual.setIdAula(idAula);
                    //nuevo
                    for (int i = 0; i < listaGrado.size(); i++) {
                        if(listaGrado.get(i).getGrado().equals(gradoNuevo))
                            idGradoNuevo = listaGrado.get(i).getIdGrado();
                    }
                    for (int i = 0; i < listaSeccion.size(); i++) {
                        if(listaSeccion.get(i).getSeccion().equals(seccionNuevo))
                            idSeccionNuevo = listaSeccion.get(i).getIdSeccion();
                    }
                    aulaNuevo = new Aula(0, idGradoNuevo, idSeccionNuevo);
                    if(aulaDao.Update(aulaActual,aulaNuevo)){
                        JOptionPane.showMessageDialog(null,"Actualización exitosa!");
                        refreshView();
                    }else{
                        JOptionPane.showMessageDialog(null,"Ya existe Aula, ingrese otro!","Mensaje",JOptionPane.ERROR_MESSAGE);
                    }    
            }else{
                JOptionPane.showMessageDialog(null,"Existen campos vacíos","Mensaje",JOptionPane.ERROR_MESSAGE);
            }    
        }else{
            JOptionPane.showMessageDialog(null,"Seleccione una fila de la tabla para actualizar","Mensaje",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void Delete() {
        if(!frmAula.table.getSelectionModel().isSelectionEmpty()){
            int confirmado = JOptionPane.showConfirmDialog(null,"¿Seguro que desea eliminar el Aula?");
            if (JOptionPane.OK_OPTION == confirmado){
                grado = frmAula.table.getValueAt(row, 0).toString();
                seccion = frmAula.table.getValueAt(row, 1).toString();
                //actual
                aulaActual = new Aula();
                for (int i = 0; i < listaGrado.size(); i++) {
                    if(listaGrado.get(i).getGrado().equals(grado))
                        idGrado = listaGrado.get(i).getIdGrado();
                }
                for (int i = 0; i < listaSeccion.size(); i++) {
                    if(listaSeccion.get(i).getSeccion().equals(seccion))
                        idSeccion = listaSeccion.get(i).getIdSeccion();
                }
                for (int i = 0; i < listaAula.size(); i++) {
                    if(listaAula.get(i).getIdGrado() == idGrado && listaAula.get(i).getIdSeccion() == idSeccion)
                        idAula = listaAula.get(i).getIdAula();
                }
                aulaActual.setIdAula(idAula);
                if(aulaDao.Delete(aulaActual)){
                    JOptionPane.showMessageDialog(null,"Aula eliminada!");  
                }else{
                    JOptionPane.showMessageDialog(null,"Error al eliminar!","Mensaje",JOptionPane.ERROR_MESSAGE);
                }
            }
            refreshView();
        }else{
            JOptionPane.showMessageDialog(null,"Seleccione una fila de la tabla para eliminar","Mensaje",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void Clear() {
        frmAula.txtBuscar.setText("");
        frmAula.btnCreate.setEnabled(true);
        frmAula.table.setRowSorter(null);//clear filter
        model=new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
        Read();
    }
    
    @Override 
    public void keyReleased(KeyEvent e) {
        DefaultTableModel dm=(DefaultTableModel) frmAula.table.getModel();
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<>(dm);
        frmAula.table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(frmAula.txtBuscar.getText()));
        frmAula.btnCreate.setEnabled(true);
    }
    
    public void getGrados(){
        if(listaGrado!=null)listaGrado.clear(); 
        frmAula.txtGrado.removeAllItems();/*limpiamos combo*/
        listaGrado=gradoDao.Read();
        for(int i=0;i<listaGrado.size();i++){/*cargamos grados en el combo*/
            frmAula.txtGrado.addItem(listaGrado.get(i).getGrado());
        }
    }
    
    public void getSecciones(){
        if(listaSeccion!=null)listaSeccion.clear(); 
        frmAula.txtSeccion.removeAllItems();/*limpiamos combo*/
        listaSeccion=seccionDao.Read();
        for(int i=0;i<listaSeccion.size();i++){/*cargamos secciones en el combo*/
            frmAula.txtSeccion.addItem(listaSeccion.get(i).getSeccion());
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()){
            if (frmAula.table.getSelectedRow() != -1) {
                row = frmAula.table.getSelectedRow();
                frmAula.txtGrado.setSelectedItem(frmAula.table.getValueAt(row,0).toString());
                frmAula.txtSeccion.setSelectedItem(frmAula.table.getValueAt(row,1).toString());
                frmAula.btnCreate.setEnabled(false);
            }
        }
    }
}
