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
import pattern.dao.SeccionDao;
import pattern.model.Seccion;
import pattern.view.FrmSeccion;

public class FrmSeccionController extends KeyAdapter implements IView,ICrudView,ListSelectionListener{
    //model
    private Seccion seccionActual,seccionNuevo;
    //view
    private final FrmSeccion frmSeccion;
    //dao
    private final SeccionDao seccionDao;
    //variables
    private String seccion,descripcion;
    private List<Seccion> listaSeccion;
    private DefaultTableModel model;
    private final String[] rowTable = new String[2];
    private int row;
    
    public FrmSeccionController(FrmSeccion frmSeccion) {
        this.frmSeccion = frmSeccion;
        this.seccionDao = new SeccionDao();
    }
    
    @Override
    public void initController() {
        frmSeccion.btnCreate.addActionListener(e -> Create());
        frmSeccion.btnUpdate.addActionListener(e -> Update());
        frmSeccion.btnDelete.addActionListener(e -> Delete());
        frmSeccion.btnNew.addActionListener(e -> Clear());
        frmSeccion.table.getSelectionModel().addListSelectionListener(this);
        frmSeccion.txtBuscar.addKeyListener(this);
    }

    @Override public void refreshView(){Clear();}

    @Override
    public void Create() {
        seccion = frmSeccion.txtSeccion.getText();
        descripcion = frmSeccion.txtDescripcion.getText();
        if(!seccion.isEmpty() && !descripcion.isEmpty()){
            seccionNuevo = new Seccion(0, seccion, descripcion);
            if(seccionDao.Create(seccionNuevo)){
                JOptionPane.showMessageDialog(null,"Registro exitoso!");
                refreshView();
            }else{
                JOptionPane.showMessageDialog(null,"Ya existe seccion, ingrese otro!","Mensaje",JOptionPane.ERROR_MESSAGE);
            }    
        }else{
            JOptionPane.showMessageDialog(null,"Existen campos vacíos","Mensaje",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void Read() {
        listaSeccion = seccionDao.Read();
        if(listaSeccion.size()>0){
            //add column to table
            model.addColumn("SECCION");
            model.addColumn("DESCRIPCION");
            //add rowTable to table
            for (int i = 0; i <listaSeccion.size(); i++) {
                rowTable[0] = listaSeccion.get(i).getSeccion();
                rowTable[1] = listaSeccion.get(i).getDescripcion();
                model.addRow(rowTable);
            }
        }
        frmSeccion.table.setModel(model);
    }

    @Override
    public void Update() {
        seccion = frmSeccion.txtSeccion.getText();
        descripcion = frmSeccion.txtDescripcion.getText();
        if(!frmSeccion.table.getSelectionModel().isSelectionEmpty()){
            if(!seccion.isEmpty() && !descripcion.isEmpty()){
                    //actual
                    seccionActual = new Seccion();
                    for (int i = 0; i < listaSeccion.size(); i++) {
                        if(listaSeccion.get(i).getSeccion().equals(frmSeccion.table.getValueAt(row,0).toString()))
                            seccionActual.setIdSeccion(listaSeccion.get(i).getIdSeccion());//primary key
                    }
                    //nuevo
                    seccionNuevo = new Seccion(0, seccion, descripcion);
                    if(seccionDao.Update(seccionActual,seccionNuevo)){
                        JOptionPane.showMessageDialog(null,"Actualización exitosa!");
                        refreshView();
                    }else{
                        JOptionPane.showMessageDialog(null,"Ya existe seccion, ingrese otro!","Mensaje",JOptionPane.ERROR_MESSAGE);
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
        if(!frmSeccion.table.getSelectionModel().isSelectionEmpty()){
            int confirmado = JOptionPane.showConfirmDialog(null,"¿Seguro que desea eliminar la seccion?");
            if (JOptionPane.OK_OPTION == confirmado){
                //actual
                seccionActual = new Seccion();
                for (int i = 0; i < listaSeccion.size(); i++) {
                    if(listaSeccion.get(i).getSeccion().equals(frmSeccion.table.getValueAt(row,0).toString()))
                        seccionActual.setIdSeccion(listaSeccion.get(i).getIdSeccion());//primary key
                }
                if(seccionDao.Delete(seccionActual)){
                    JOptionPane.showMessageDialog(null,"Seccion eliminada!");  
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
        frmSeccion.txtSeccion.setText("");
        frmSeccion.txtDescripcion.setText("");
        frmSeccion.txtBuscar.setText("");
        frmSeccion.btnCreate.setEnabled(true);
        frmSeccion.table.setRowSorter(null);//clear filter
        model = new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
        Read();
    }
    
    @Override 
    public void keyReleased(KeyEvent e) {
        DefaultTableModel dm=(DefaultTableModel) frmSeccion.table.getModel();
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<>(dm);
        frmSeccion.table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(frmSeccion.txtBuscar.getText()));
        frmSeccion.btnCreate.setEnabled(true);
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()){
            if (frmSeccion.table.getSelectedRow() != -1) {
                row = frmSeccion.table.getSelectedRow();
                frmSeccion.txtSeccion.setText(frmSeccion.table.getValueAt(row,0).toString());
                frmSeccion.txtDescripcion.setText(frmSeccion.table.getValueAt(row,1).toString());
                frmSeccion.btnCreate.setEnabled(false);
            }    
        }
    }
}
