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
import pattern.dao.DocenteAulaDao;
import pattern.dao.DesempeñoDao;
import pattern.model.Desempeño;
import pattern.view.FrmDesempeño;

public class FrmDesempeñoController extends KeyAdapter implements IView,ICrudView,ListSelectionListener{
    //model
    private Desempeño desempeñoActual,desempeñoNuevo;
    //view
    private final FrmDesempeño frmDesempeño;
    //dao
    private final DesempeñoDao desempeñoDao;
    private final DocenteAulaDao docenteAulaDao;
    //variables
    private String desempeño,descripcion,dniDocente;
    private List<Desempeño> listaDesempeño;
    private List<List<String>> listaDocente;
    private final List<String> persona;
    private DefaultTableModel model;
    private final String[] rowTable = new String[2];
    private int row;
    private int idDocenteAula;

    public FrmDesempeñoController(FrmDesempeño frmDesempeño,List<String> persona) {
        this.frmDesempeño = frmDesempeño;
        this.desempeñoDao = new DesempeñoDao();
        this.docenteAulaDao = new DocenteAulaDao();
        this.persona = persona;
    }
    
    @Override
    public void initController() {
        frmDesempeño.btnCreate.addActionListener(e -> Create());
        frmDesempeño.btnUpdate.addActionListener(e -> Update());
        frmDesempeño.btnDelete.addActionListener(e -> Delete());
        frmDesempeño.btnNew.addActionListener(e -> Clear());
        frmDesempeño.table.getSelectionModel().addListSelectionListener(this);
        frmDesempeño.txtBuscar.addKeyListener(this);
    }

    @Override public void refreshView(){Clear();}

    @Override
    public void Create() {
        desempeño = frmDesempeño.txtDesempenio.getText();
        descripcion = frmDesempeño.txtDescripcion.getText();
        if(!desempeño.isEmpty() && !descripcion.isEmpty()){
            desempeñoNuevo = new Desempeño(0, desempeño, descripcion,idDocenteAula);
            if(desempeñoDao.Create(desempeñoNuevo)){
                JOptionPane.showMessageDialog(null,"Registro exitoso!");
                refreshView();
            }else{
                JOptionPane.showMessageDialog(null,"Ya existe desempeño, ingrese otro!","Mensaje",JOptionPane.ERROR_MESSAGE);
            }    
        }else{
            JOptionPane.showMessageDialog(null,"Existen campos vacíos","Mensaje",JOptionPane.ERROR_MESSAGE);
        }    
    }

    @Override
    public void Read() {
        getDocenteAula();
        //cargamos desempeños
        listaDesempeño = desempeñoDao.Read();
        if(listaDesempeño.size()>0){
            //add column to table
            model.addColumn("DESEMPEÑO");
            model.addColumn("DESCRIPCION");
            //add rowTable to table
            for (int i = 0; i <listaDesempeño.size(); i++) {
                if(idDocenteAula == listaDesempeño.get(i).getIdDocenteAula()){
                rowTable[0] = listaDesempeño.get(i).getDesempeño();
                rowTable[1] = listaDesempeño.get(i).getDescripcion();
                model.addRow(rowTable);    
                }
            }
        }
        frmDesempeño.table.setModel(model);//seteamos model
    }

    @Override
    public void Update() {
        if(!frmDesempeño.table.getSelectionModel().isSelectionEmpty()){
            desempeño = frmDesempeño.txtDesempenio.getText();
            descripcion = frmDesempeño.txtDescripcion.getText();
            if(!desempeño.isEmpty() && !descripcion.isEmpty()){
                //actual
                desempeñoActual = new Desempeño();
                for (int i = 0; i < listaDesempeño.size(); i++) {
                    if(listaDesempeño.get(i).getDesempeño().equals(frmDesempeño.table.getValueAt(row,0).toString()))
                        desempeñoActual.setIdDesempeño(listaDesempeño.get(i).getIdDesempeño());//primary key
                }
                //nuevo
                desempeñoNuevo = new Desempeño(0, desempeño, descripcion,idDocenteAula);
                if(desempeñoDao.Update(desempeñoActual, desempeñoNuevo)){
                    JOptionPane.showMessageDialog(null,"Datos actualizados!");
                    refreshView();
                }else{
                    JOptionPane.showMessageDialog(null,"Ya existe el desempeño, ingrese otro!","Mensaje",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null,"Existen campos vacios","Mensaje",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Seleccione una fila de la tabla para actualizar","Mensaje",JOptionPane.ERROR_MESSAGE);
        }    
    }
    
    @Override
    public void Delete() {
        if(!frmDesempeño.table.getSelectionModel().isSelectionEmpty()){
            int confirmado = JOptionPane.showConfirmDialog(null,"¿Seguro que desea eliminar el Desempeño?");
            if (JOptionPane.OK_OPTION == confirmado){
                //actual
                desempeñoActual = new Desempeño();
                for (int i = 0; i < listaDesempeño.size(); i++) {
                    if(listaDesempeño.get(i).getDesempeño().equals(frmDesempeño.table.getValueAt(row,0).toString()))
                        desempeñoActual.setIdDesempeño(listaDesempeño.get(i).getIdDesempeño());//primary key
                }
                if(desempeñoDao.Delete(desempeñoActual)){
                    JOptionPane.showMessageDialog(null,"Desempeño eliminado!");  
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
        frmDesempeño.txtDesempenio.setText("");
        frmDesempeño.txtDescripcion.setText("");
        frmDesempeño.txtBuscar.setText("");
        frmDesempeño.btnCreate.setEnabled(true);
        frmDesempeño.table.setRowSorter(null);//clear filter
        model=new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
        Read();
    }
    
    @Override 
    public void keyReleased(KeyEvent e) {
        DefaultTableModel dm=(DefaultTableModel) frmDesempeño.table.getModel();
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<>(dm);
        frmDesempeño.table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(frmDesempeño.txtBuscar.getText()));
        frmDesempeño.btnCreate.setEnabled(true);
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()){
            if (frmDesempeño.table.getSelectedRow() != -1) {
                row = frmDesempeño.table.getSelectedRow();
                frmDesempeño.txtDesempenio.setText(frmDesempeño.table.getValueAt(row,0).toString());
                frmDesempeño.txtDescripcion.setText(frmDesempeño.table.getValueAt(row,1).toString());
                frmDesempeño.btnCreate.setEnabled(false);
            }    
        }
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
}
