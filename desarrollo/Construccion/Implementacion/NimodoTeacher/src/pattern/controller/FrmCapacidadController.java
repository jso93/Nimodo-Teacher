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
import pattern.dao.CapacidadDao;
import pattern.model.Capacidad;
import pattern.view.FrmCapacidad;

public class FrmCapacidadController extends KeyAdapter implements IView,ICrudView,ListSelectionListener{
    //model
    private Capacidad capacidadActual,capacidadNuevo;
    //view
    private final FrmCapacidad frmCapacidad;
    //dao
    private final CapacidadDao capacidadDao;
    //variables
    private String capacidad,descripcion;
    private List<Capacidad> listaCapacidad;
    private DefaultTableModel model;
    private final String[] rowTable = new String[2];
    private int row;

    public FrmCapacidadController(FrmCapacidad frmCapacidad) {
        this.frmCapacidad = frmCapacidad;
        this.capacidadDao = new CapacidadDao();
    }
    
    @Override
    public void initController() {
        frmCapacidad.btnCreate.addActionListener(e -> Create());
        frmCapacidad.btnUpdate.addActionListener(e -> Update());
        frmCapacidad.btnDelete.addActionListener(e -> Delete());
        frmCapacidad.btnNew.addActionListener(e -> Clear());
        frmCapacidad.table.getSelectionModel().addListSelectionListener(this);
        frmCapacidad.txtBuscar.addKeyListener(this);
    }

    @Override
    public void refreshView(){Clear();}

    @Override
    public void Create() {
        capacidad = frmCapacidad.txtCapacidad.getText();
        descripcion = frmCapacidad.txtDescripcion.getText();
        if(!capacidad.isEmpty() && !descripcion.isEmpty()){
            capacidadNuevo = new Capacidad(0, capacidad, descripcion);
            if(capacidadDao.Create(capacidadNuevo)){
                JOptionPane.showMessageDialog(null,"Registro exitoso!");
                refreshView();
            }else{
                JOptionPane.showMessageDialog(null,"Ya existe capacidad, ingrese otro!","Mensaje",JOptionPane.ERROR_MESSAGE);
            }    
        }else{
            JOptionPane.showMessageDialog(null,"Existen campos vacíos","Mensaje",JOptionPane.ERROR_MESSAGE);
        }    
    }

    @Override
    public void Read() {
        //cargamos capacidades
        listaCapacidad = capacidadDao.Read();
        if(listaCapacidad.size()>0){
            //add column to table
            model.addColumn("CAPACIDAD");
            model.addColumn("DESCRIPCION");
            //add rowTable to table
            for (int i = 0; i <listaCapacidad.size(); i++) {
                rowTable[0] = listaCapacidad.get(i).getCapacidad();
                rowTable[1] = listaCapacidad.get(i).getDescripcion();
                model.addRow(rowTable);
            }
        }
        frmCapacidad.table.setModel(model);//seteamos model
    }

    @Override
    public void Update() {
        if(!frmCapacidad.table.getSelectionModel().isSelectionEmpty()){
            capacidad = frmCapacidad.txtCapacidad.getText();
            descripcion = frmCapacidad.txtDescripcion.getText();
            if(!capacidad.isEmpty() && !descripcion.isEmpty()){
                //actual
                capacidadActual = new Capacidad();
                for (int i = 0; i < listaCapacidad.size(); i++) {
                    if(listaCapacidad.get(i).getCapacidad().equals(frmCapacidad.table.getValueAt(row,0).toString()))
                        capacidadActual.setIdCapacidad(listaCapacidad.get(i).getIdCapacidad());//primary key
                }
                capacidadNuevo = new Capacidad(0, capacidad, descripcion);
                if(capacidadDao.Update(capacidadActual, capacidadNuevo)){
                    JOptionPane.showMessageDialog(null,"Datos actualizados!");
                    refreshView();
                }else{
                    JOptionPane.showMessageDialog(null,"Ya existe la capacidad, ingrese otro!","Mensaje",JOptionPane.ERROR_MESSAGE);
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
        if(!frmCapacidad.table.getSelectionModel().isSelectionEmpty()){
            int confirmado = JOptionPane.showConfirmDialog(null,"¿Seguro que desea eliminar la Capacidad?");
            if (JOptionPane.OK_OPTION == confirmado){
                //actual
                capacidadActual = new Capacidad();
                for (int i = 0; i < listaCapacidad.size(); i++) {
                    if(listaCapacidad.get(i).getCapacidad().equals(frmCapacidad.table.getValueAt(row,0).toString()))
                        capacidadActual.setIdCapacidad(listaCapacidad.get(i).getIdCapacidad());//primary key
                }
                if(capacidadDao.Delete(capacidadActual)){
                    JOptionPane.showMessageDialog(null,"Capacidad eliminada!");  
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
        frmCapacidad.txtCapacidad.setText("");
        frmCapacidad.txtDescripcion.setText("");
        frmCapacidad.txtBuscar.setText("");
        frmCapacidad.btnCreate.setEnabled(true);
        frmCapacidad.table.setRowSorter(null);//clear filter
        model=new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
        Read();
    }
    
    @Override 
    public void keyReleased(KeyEvent e) {
        DefaultTableModel dm=(DefaultTableModel) frmCapacidad.table.getModel();
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<>(dm);
        frmCapacidad.table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(frmCapacidad.txtBuscar.getText()));
        frmCapacidad.btnCreate.setEnabled(true);
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()){
            if (frmCapacidad.table.getSelectedRow() != -1) {
                row = frmCapacidad.table.getSelectedRow();
                frmCapacidad.txtCapacidad.setText(frmCapacidad.table.getValueAt(row,0).toString());
                frmCapacidad.txtDescripcion.setText(frmCapacidad.table.getValueAt(row,1).toString());
                frmCapacidad.btnCreate.setEnabled(false);
            }    
        }
    }
}
