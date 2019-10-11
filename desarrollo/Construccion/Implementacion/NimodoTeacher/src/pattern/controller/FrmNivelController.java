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
import pattern.dao.NivelDao;
import pattern.model.Nivel;
import pattern.view.FrmNivel;

public class FrmNivelController extends KeyAdapter implements IView,ICrudView,ListSelectionListener{
    //model
    private Nivel nivelActual,nivelNuevo;
    //view
    private final FrmNivel frmNivel;
    //dao
    private final NivelDao nivelDao;
    //variables
    private String nivel,descripcion;
    private List<Nivel> listaNivel;
    private DefaultTableModel model;
    private final String [] rowTable = new String[2];
    private int row;

    public FrmNivelController(FrmNivel frmNivel) {
        this.frmNivel = frmNivel;
        this.nivelDao = new NivelDao();
    }

    @Override
    public void initController() {
        frmNivel.btnCreate.addActionListener(e -> Create());
        frmNivel.btnUpdate.addActionListener(e -> Update());
        frmNivel.btnDelete.addActionListener(e -> Delete());
        frmNivel.btnNew.addActionListener(e -> Clear());
        frmNivel.table.getSelectionModel().addListSelectionListener(this);
        frmNivel.txtBuscar.addKeyListener(this);
    }

    @Override public void refreshView(){Clear();}

    @Override
    public void Create() {
        nivel = frmNivel.txtNivel.getText();
        descripcion = frmNivel.txtDescripcion.getText();
        if(!nivel.isEmpty() && !descripcion.isEmpty()){
            nivelNuevo = new Nivel(0, nivel, descripcion);
            if(nivelDao.Create(nivelNuevo)){
                JOptionPane.showMessageDialog(null,"Registro exitoso!");
                refreshView();
            }else{
                JOptionPane.showMessageDialog(null,"Ya existe Nivel, ingrese otro!","Mensaje",JOptionPane.ERROR_MESSAGE);
            }    
        }else{
            JOptionPane.showMessageDialog(null,"Existen campos vacíos","Mensaje",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void Read() {
        listaNivel = nivelDao.Read();
        if(listaNivel.size()>0){
            //add column to table
            model.addColumn("NIVEL");
            model.addColumn("DESCRIPCION");
            //add rowTable to table
            for (int i = 0; i <listaNivel.size(); i++) {
                rowTable[0] = listaNivel.get(i).getNivel();
                rowTable[1] = listaNivel.get(i).getDescripcion();
                model.addRow(rowTable);
            }
        }
        frmNivel.table.setModel(model);//seteamos model
    }

    @Override
    public void Update() {
        nivel = frmNivel.txtNivel.getText();
        descripcion = frmNivel.txtDescripcion.getText();
        if(!frmNivel.table.getSelectionModel().isSelectionEmpty()){
            if(!nivel.isEmpty() && !descripcion.isEmpty()){
                    //actual
                    nivelActual = new Nivel();
                    for (int i = 0; i < listaNivel.size(); i++) {
                        if(listaNivel.get(i).getNivel().equals(frmNivel.table.getValueAt(row,0).toString()))
                            nivelActual.setIdNivel(listaNivel.get(i).getIdNivel());//primary key
                    }
                    //nuevo
                    nivelNuevo = new Nivel(0, nivel, descripcion);
                    if(nivelDao.Update(nivelActual,nivelNuevo)){
                        JOptionPane.showMessageDialog(null,"Actualización exitosa!");
                        refreshView();
                    }else{
                        JOptionPane.showMessageDialog(null,"Ya existe Nivel, ingrese otro!","Mensaje",JOptionPane.ERROR_MESSAGE);
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
        if(!frmNivel.table.getSelectionModel().isSelectionEmpty()){
            int confirmado = JOptionPane.showConfirmDialog(null,"¿Seguro que desea eliminar el Nivel?");
            if (JOptionPane.OK_OPTION == confirmado){
                //actual
                nivelActual = new Nivel();
                for (int i = 0; i < listaNivel.size(); i++) {
                    if(listaNivel.get(i).getNivel().equals(frmNivel.table.getValueAt(row,0).toString()))
                        nivelActual.setIdNivel(listaNivel.get(i).getIdNivel());//primary key
                }
                if(nivelDao.Delete(nivelActual)){
                    JOptionPane.showMessageDialog(null,"Nivel eliminado!");  
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
        frmNivel.txtNivel.setText("");
        frmNivel.txtDescripcion.setText("");
        frmNivel.txtBuscar.setText("");
        frmNivel.btnCreate.setEnabled(true);
        frmNivel.table.setRowSorter(null);//clear filter
        model=new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
        Read();
    }
    
    @Override 
    public void keyReleased(KeyEvent e) {
        DefaultTableModel dm=(DefaultTableModel) frmNivel.table.getModel();
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<>(dm);
        frmNivel.table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(frmNivel.txtBuscar.getText()));
        frmNivel.btnCreate.setEnabled(true);
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()){
            if (frmNivel.table.getSelectedRow() != -1) {
                row = frmNivel.table.getSelectedRow();
                frmNivel.txtNivel.setText(frmNivel.table.getValueAt(row,0).toString());
                frmNivel.txtDescripcion.setText(frmNivel.table.getValueAt(row,1).toString());
                frmNivel.btnCreate.setEnabled(false);
            }    
        }
    }
    
}
