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
import pattern.dao.AreaDao;
import pattern.model.Area;
import pattern.view.FrmArea;

public class FrmAreaController extends KeyAdapter implements IView,ICrudView,ListSelectionListener{
    //model
    private Area areaActual,areaNuevo;
    //view
    private final FrmArea frmArea;
    //dao
    private final AreaDao areaDao;
    //variables
    private String area,descripcion;
    private List<Area> listaArea;
    private DefaultTableModel model;
    private final String [] rowTable = new String[2];
    private int row;

    public FrmAreaController(FrmArea frmArea) {
        this.frmArea = frmArea;
        this.areaDao = new AreaDao();
    }

    @Override
    public void initController() {
        frmArea.btnCreate.addActionListener(e -> Create());
        frmArea.btnUpdate.addActionListener(e -> Update());
        frmArea.btnDelete.addActionListener(e -> Delete());
        frmArea.btnNew.addActionListener(e -> Clear());
        frmArea.table.getSelectionModel().addListSelectionListener(this);
        frmArea.txtBuscar.addKeyListener(this);
        //frmArea.btnUpdateTiempo.addActionListener(e -> updateTiempo());
    }

    @Override
    public void refreshView(){Clear();}

    @Override
    public void Create() {        
        area = frmArea.txtArea.getText();
        descripcion = frmArea.txtDescripcion.getText();
        if(!area.isEmpty() && !descripcion.isEmpty()){
            areaNuevo = new Area(0, area, descripcion);
            if(areaDao.Create(areaNuevo)){
                JOptionPane.showMessageDialog(null,"Registro exitoso!");
                refreshView();
            }else{
                JOptionPane.showMessageDialog(null,"Ya existe area, ingrese otro!","Mensaje",JOptionPane.ERROR_MESSAGE);
            }    
        }else{
            JOptionPane.showMessageDialog(null,"Existen campos vacíos","Mensaje",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void Read() {
        listaArea = areaDao.Read();
        if(listaArea.size()>0){
            //add column to table
            model.addColumn("AREA");
            model.addColumn("DESCRIPCION");
            //add rowTable to table
            for (int i = 0; i <listaArea.size(); i++) {
                rowTable[0] = listaArea.get(i).getArea();
                rowTable[1] = listaArea.get(i).getDescripcion();
                model.addRow(rowTable);
            }
        }
        frmArea.table.setModel(model);//seteamos model
    }

    @Override
    public void Update() {
        if(!frmArea.table.getSelectionModel().isSelectionEmpty()){
            area = frmArea.txtArea.getText();
            descripcion = frmArea.txtDescripcion.getText();
            if(!area.isEmpty() && !descripcion.isEmpty()){
                    //actual
                    areaActual = new Area();
                    for (int i = 0; i < listaArea.size(); i++) {
                        if(listaArea.get(i).getArea().equals(frmArea.table.getValueAt(row,0).toString()))
                            areaActual.setIdArea(listaArea.get(i).getIdArea());//primary key
                    }
                    //nuevo
                    areaNuevo = new Area(0, area, descripcion);
                    if(areaDao.Update(areaActual,areaNuevo)){
                        JOptionPane.showMessageDialog(null,"Actualización exitosa!");
                        refreshView();
                    }else{
                        JOptionPane.showMessageDialog(null,"Ya existe area, ingrese otro!","Mensaje",JOptionPane.ERROR_MESSAGE);
                    }    
            }else{
                JOptionPane.showMessageDialog(null,"Existen campos vacíos","Mensaje",JOptionPane.ERROR_MESSAGE);
            }    
        }else{
            JOptionPane.showMessageDialog(null,"Seleccione una fila de la tabla para actualizar","Mensaje",JOptionPane.ERROR_MESSAGE);
        }
    }

    /*public void updateTiempo() {
        for (int i = 1; i <= 1743; i++) {
            if(areaDao.UpdateTiempo(i)){
                System.out.println(i+" -- OK!!");
            }else{
                System.out.println(i+" -- FALLO!!");
            }
        }
    }*/
    
    @Override
    public void Delete() {
        if(!frmArea.table.getSelectionModel().isSelectionEmpty()){
            int confirmado = JOptionPane.showConfirmDialog(null,"¿Seguro que desea eliminar el area?");
            if (JOptionPane.OK_OPTION == confirmado){
                //actual
                areaActual = new Area();
                for (int i = 0; i < listaArea.size(); i++) {
                    if(listaArea.get(i).getArea().equals(frmArea.table.getValueAt(row,0).toString()))
                        areaActual.setIdArea(listaArea.get(i).getIdArea());//primary key
                }
                if(areaDao.Delete(areaActual)){
                    JOptionPane.showMessageDialog(null,"Area eliminada!");  
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
        frmArea.txtArea.setText("");
        frmArea.txtDescripcion.setText("");
        frmArea.txtBuscar.setText("");
        frmArea.btnCreate.setEnabled(true);
        frmArea.table.setRowSorter(null);//clear filter
        model=new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
        Read();
    }
    
    @Override 
    public void keyReleased(KeyEvent e) {
        DefaultTableModel dm=(DefaultTableModel) frmArea.table.getModel();
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<>(dm);
        frmArea.table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(frmArea.txtBuscar.getText()));
        frmArea.btnCreate.setEnabled(true);
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()){
            if (frmArea.table.getSelectedRow() != -1) {
                row = frmArea.table.getSelectedRow();
                frmArea.txtArea.setText(frmArea.table.getValueAt(row,0).toString());
                frmArea.txtDescripcion.setText(frmArea.table.getValueAt(row,1).toString());
                frmArea.btnCreate.setEnabled(false);
            }
        }
    }
   
}
