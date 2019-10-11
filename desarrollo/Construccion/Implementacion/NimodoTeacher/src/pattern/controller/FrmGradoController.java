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
import pattern.dao.GradoDao;
import pattern.model.Grado;
import pattern.view.FrmGrado;

public class FrmGradoController extends KeyAdapter implements IView,ICrudView,ListSelectionListener{
    //model
    private Grado gradoActual,gradoNuevo;
    //view
    private final FrmGrado frmGrado;
    //dao
    private final GradoDao gradoDao;
    //variables
    private String grado,descripcion;
    private List<Grado> listaGrado;
    private DefaultTableModel model;
    private final String [] rowTable = new String[2];
    private int row;

    public FrmGradoController(FrmGrado frmGrado) {
        this.frmGrado = frmGrado;
        this.gradoDao = new GradoDao();
    }

    @Override
    public void initController() {
        frmGrado.btnCreate.addActionListener(e -> Create());
        frmGrado.btnUpdate.addActionListener(e -> Update());
        frmGrado.btnDelete.addActionListener(e -> Delete());
        frmGrado.btnNew.addActionListener(e -> Clear());
        frmGrado.table.getSelectionModel().addListSelectionListener(this);
        frmGrado.txtBuscar.addKeyListener(this);
    }

    @Override public void refreshView(){Clear();}

    @Override
    public void Create() {
        grado = frmGrado.txtGrado.getText();
        descripcion = frmGrado.txtDescripcion.getText();
        if(!grado.isEmpty() && !descripcion.isEmpty()){
            gradoNuevo = new Grado(0, grado, descripcion);
            if(gradoDao.Create(gradoNuevo)){
                JOptionPane.showMessageDialog(null,"Registro exitoso!");
                refreshView();
            }else{
                JOptionPane.showMessageDialog(null,"Ya existe grado, ingrese otro!","Mensaje",JOptionPane.ERROR_MESSAGE);
            }    
        }else{
            JOptionPane.showMessageDialog(null,"Existen campos vacíos","Mensaje",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void Read() {
        listaGrado = gradoDao.Read();
        if(listaGrado.size()>0){
            //add column to table
            model.addColumn("GRADO");
            model.addColumn("DESCRIPCION");
            //add rowTable to table
            for (int i = 0; i <listaGrado.size(); i++) {
                rowTable[0] = listaGrado.get(i).getGrado();
                rowTable[1] = listaGrado.get(i).getDescripcion();
                model.addRow(rowTable);
            }
        }
        frmGrado.table.setModel(model);
    }

    @Override
    public void Update() {
        grado = frmGrado.txtGrado.getText();
        descripcion = frmGrado.txtDescripcion.getText();
        if(!frmGrado.table.getSelectionModel().isSelectionEmpty()){
            if(!grado.isEmpty() && !descripcion.isEmpty()){
                    //actual
                    gradoActual = new Grado();
                    for(int i = 0; i < listaGrado.size(); i++) {
                        if(listaGrado.get(i).getGrado().equals(frmGrado.table.getValueAt(row,0).toString()))
                            gradoActual.setIdGrado(listaGrado.get(i).getIdGrado());//primary key
                    }
                    //nuevo
                    gradoNuevo = new Grado(0, grado, descripcion);
                    if(gradoDao.Update(gradoActual,gradoNuevo)){
                        JOptionPane.showMessageDialog(null,"Actualización exitosa!");
                        refreshView();
                    }else{
                        JOptionPane.showMessageDialog(null,"Ya existe grado, ingrese otro!","Mensaje",JOptionPane.ERROR_MESSAGE);
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
        if(!frmGrado.table.getSelectionModel().isSelectionEmpty()){
            int confirmado = JOptionPane.showConfirmDialog(null,"¿Seguro que desea eliminar el grado?");
            if (JOptionPane.OK_OPTION == confirmado){
                //actual
                gradoActual = new Grado();
                for(int i = 0; i < listaGrado.size(); i++) {
                    if(listaGrado.get(i).getGrado().equals(frmGrado.table.getValueAt(row,0).toString()))
                        gradoActual.setIdGrado(listaGrado.get(i).getIdGrado());//primary key
                }
                if(gradoDao.Delete(gradoActual)){
                    JOptionPane.showMessageDialog(null,"Grado eliminado!");  
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
        frmGrado.txtGrado.setText("");
        frmGrado.txtDescripcion.setText("");
        frmGrado.txtBuscar.setText("");
        frmGrado.btnCreate.setEnabled(true);
        frmGrado.table.setRowSorter(null);//clear filter
        model=new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
        Read();
    }
    
    @Override 
    public void keyReleased(KeyEvent e) {
        DefaultTableModel dm=(DefaultTableModel) frmGrado.table.getModel();
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<>(dm);
        frmGrado.table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(frmGrado.txtBuscar.getText()));
        frmGrado.btnCreate.setEnabled(true);
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()){
            if (frmGrado.table.getSelectedRow() != -1) {
                row = frmGrado.table.getSelectedRow();
                frmGrado.txtGrado.setText(frmGrado.table.getValueAt(row,0).toString());
                frmGrado.txtDescripcion.setText(frmGrado.table.getValueAt(row,1).toString());
                frmGrado.btnCreate.setEnabled(false);
            }    
        }
    }
}
