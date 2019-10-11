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
import pattern.dao.CompetenciaDao;
import pattern.model.Competencia;
import pattern.view.FrmCompetencia;

public class FrmCompetenciaController extends KeyAdapter implements IView,ICrudView,ListSelectionListener{
    //model
    private Competencia competenciaActual,competenciaNuevo;
    //view
    private final FrmCompetencia frmCompetencia;
    //dao
    private final CompetenciaDao competenciaDao;
    //variables
    private String competencia,descripcion;
    private List<Competencia> listaCompetencia;
    private DefaultTableModel model;
    private final String[] rowTable = new String[2];
    private int row;

    public FrmCompetenciaController(FrmCompetencia frmCompetencia) {
        this.frmCompetencia = frmCompetencia;
        this.competenciaDao = new CompetenciaDao();
    }
    
    @Override
    public void initController() {
        frmCompetencia.btnCreate.addActionListener(e -> Create());
        frmCompetencia.btnUpdate.addActionListener(e -> Update());
        frmCompetencia.btnDelete.addActionListener(e -> Delete());
        frmCompetencia.btnNew.addActionListener(e -> Clear());
        frmCompetencia.table.getSelectionModel().addListSelectionListener(this);
        frmCompetencia.txtBuscar.addKeyListener(this);
    }

    @Override public void refreshView(){Clear();}

    @Override
    public void Create() {
        competencia = frmCompetencia.txtCompetencia.getText();
        descripcion = frmCompetencia.txtDescripcion.getText();
        if(!competencia.isEmpty() && !descripcion.isEmpty()){
            competenciaNuevo = new Competencia();
            competenciaNuevo.setIdCompetencia(0);
            competenciaNuevo.setCompetencia(competencia);
            competenciaNuevo.setDescripcion(descripcion);
            if(competenciaDao.Create(competenciaNuevo)){
                JOptionPane.showMessageDialog(null,"Registro exitoso!");
                refreshView();
            }else{
                JOptionPane.showMessageDialog(null,"Ya existe competencia, ingrese otro!","Mensaje",JOptionPane.ERROR_MESSAGE);
            }    
        }else{
            JOptionPane.showMessageDialog(null,"Existen campos vacíos","Mensaje",JOptionPane.ERROR_MESSAGE);
        }    
    }

    @Override
    public void Read() {
        //cargamos competencias
        listaCompetencia = competenciaDao.Read();
        if(listaCompetencia.size()>0){
            //add column to table
            model.addColumn("COMPETENCIA");
            model.addColumn("DESCRIPCION");
            //add rowTable to table
            for (int i = 0; i <listaCompetencia.size(); i++) {
                rowTable[0] = listaCompetencia.get(i).getCompetencia();
                rowTable[1] = listaCompetencia.get(i).getDescripcion();
                model.addRow(rowTable);
            }
        }
        frmCompetencia.table.setModel(model);//seteamos model
    }

    @Override
    public void Update() {
        if(!frmCompetencia.table.getSelectionModel().isSelectionEmpty()){
            competencia = frmCompetencia.txtCompetencia.getText();
            descripcion = frmCompetencia.txtDescripcion.getText();
            if(!competencia.isEmpty() && !descripcion.isEmpty()){
                //actual
                competenciaActual = new Competencia();
                for (int i = 0; i < listaCompetencia.size(); i++) {
                    if(listaCompetencia.get(i).getCompetencia().equals(frmCompetencia.table.getValueAt(row,0).toString()))
                       competenciaActual.setIdCompetencia(listaCompetencia.get(i).getIdCompetencia());//primary key
                }
                //nuevo
                competenciaNuevo = new Competencia();
                competenciaNuevo.setIdCompetencia(0);
                competenciaNuevo.setCompetencia(competencia);
                competenciaNuevo.setDescripcion(descripcion);
                if(competenciaDao.Update(competenciaActual, competenciaNuevo)){
                    JOptionPane.showMessageDialog(null,"Datos actualizados!");
                    refreshView();
                }else{
                    JOptionPane.showMessageDialog(null,"Ya existe la competencia, ingrese otro!","Mensaje",JOptionPane.ERROR_MESSAGE);
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
        if(!frmCompetencia.table.getSelectionModel().isSelectionEmpty()){
            int confirmado = JOptionPane.showConfirmDialog(null,"¿Seguro que desea eliminar la Competencia?");
            if (JOptionPane.OK_OPTION == confirmado){
                //actual
                competenciaActual = new Competencia();
                for (int i = 0; i < listaCompetencia.size(); i++) {
                    if(listaCompetencia.get(i).getCompetencia().equals(frmCompetencia.table.getValueAt(row,0).toString()))
                        competenciaActual.setIdCompetencia(listaCompetencia.get(i).getIdCompetencia());//primary key
                }
                if(competenciaDao.Delete(competenciaActual)){
                    JOptionPane.showMessageDialog(null,"Competencia eliminada!");  
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
        frmCompetencia.txtCompetencia.setText("");
        frmCompetencia.txtDescripcion.setText("");
        frmCompetencia.txtBuscar.setText("");
        frmCompetencia.btnCreate.setEnabled(true);
        frmCompetencia.table.setRowSorter(null);//clear filter
        model=new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
        Read();
    }
    
    @Override 
    public void keyReleased(KeyEvent e) {
        DefaultTableModel dm=(DefaultTableModel) frmCompetencia.table.getModel();
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<>(dm);
        frmCompetencia.table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(frmCompetencia.txtBuscar.getText()));
        frmCompetencia.btnCreate.setEnabled(true);
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()){
            if (frmCompetencia.table.getSelectedRow() != -1) {
                row = frmCompetencia.table.getSelectedRow();
                frmCompetencia.txtCompetencia.setText(frmCompetencia.table.getValueAt(row,0).toString());
                frmCompetencia.txtDescripcion.setText(frmCompetencia.table.getValueAt(row,1).toString());
                frmCompetencia.btnCreate.setEnabled(false);
            }    
        }
    }
}
