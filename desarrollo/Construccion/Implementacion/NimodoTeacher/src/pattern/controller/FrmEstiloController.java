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
import pattern.dao.EstiloDao;
import pattern.model.Estilo;
import pattern.view.FrmEstilo;

public class FrmEstiloController extends KeyAdapter implements IView,ICrudView,ListSelectionListener{
    //model
    private Estilo estiloActual,estiloNuevo;
    //view
    private final FrmEstilo frmEstilo;
    //dao
    private final EstiloDao estiloDao;
    //variables
    private String estilo,descripcion;
    private List<Estilo> listaEstilo;
    private DefaultTableModel model;
    private final String [] rowTable = new String[2];
    private int row;

    public FrmEstiloController(FrmEstilo frmEstilo) {
        this.frmEstilo = frmEstilo;
        this.estiloDao = new EstiloDao();
    }

    @Override
    public void initController() {
        frmEstilo.btnCreate.addActionListener(e -> Create());
        frmEstilo.btnUpdate.addActionListener(e -> Update());
        frmEstilo.btnDelete.addActionListener(e -> Delete());
        frmEstilo.btnNew.addActionListener(e -> Clear());
        frmEstilo.table.getSelectionModel().addListSelectionListener(this);
        frmEstilo.txtBuscar.addKeyListener(this);
    }

    @Override public void refreshView(){Clear();}

    @Override
    public void Create() {
        estilo = frmEstilo.txtEstilo.getText();
        descripcion = frmEstilo.txtDescripcion.getText();
        if(!estilo.isEmpty() && !descripcion.isEmpty()){
            estiloNuevo = new Estilo(0, estilo, descripcion);
            if(estiloDao.Create(estiloNuevo)){
                JOptionPane.showMessageDialog(null,"Registro exitoso!");
                refreshView();
            }else{
                JOptionPane.showMessageDialog(null,"Ya existe estilo de aprendizaje, ingrese otro!","Mensaje",JOptionPane.ERROR_MESSAGE);
            }    
        }else{
            JOptionPane.showMessageDialog(null,"Existen campos vacíos","Mensaje",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void Read() {
        listaEstilo = estiloDao.Read();
        if(listaEstilo.size()>0){
            //add column to table
            model.addColumn("ESTILO");
            model.addColumn("DESCRIPCION");
            //add rowTable to table
            for (int i = 0; i <listaEstilo.size(); i++) {
                rowTable[0] = listaEstilo.get(i).getEstilo();
                rowTable[1] = listaEstilo.get(i).getDescripcion();
                model.addRow(rowTable);
            }
        }
        frmEstilo.table.setModel(model);//seteamos model
    }

    @Override
    public void Update() {
        estilo = frmEstilo.txtEstilo.getText();
        descripcion = frmEstilo.txtDescripcion.getText();
        if(!frmEstilo.table.getSelectionModel().isSelectionEmpty()){
            if(!estilo.isEmpty() && !descripcion.isEmpty()){
                    //actual
                    estiloActual = new Estilo();
                    for (int i = 0; i < listaEstilo.size(); i++) {
                        if(listaEstilo.get(i).getEstilo().equals(frmEstilo.table.getValueAt(row,0).toString()))
                            estiloActual.setIdEstilo(listaEstilo.get(i).getIdEstilo());//primary key
                    }
                    //nuevo
                    estiloNuevo = new Estilo(0, estilo, descripcion);
                    if(estiloDao.Update(estiloActual,estiloNuevo)){
                        JOptionPane.showMessageDialog(null,"Actualización exitosa!");
                        refreshView();
                    }else{
                        JOptionPane.showMessageDialog(null,"Ya existe estilo de aprendizaje, ingrese otro!","Mensaje",JOptionPane.ERROR_MESSAGE);
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
        if(!frmEstilo.table.getSelectionModel().isSelectionEmpty()){
            int confirmado = JOptionPane.showConfirmDialog(null,"¿Seguro que desea eliminar el estilo de aprendizaje?");
            if (JOptionPane.OK_OPTION == confirmado){
                //actual
                estiloActual = new Estilo();
                for (int i = 0; i < listaEstilo.size(); i++) {
                    if(listaEstilo.get(i).getEstilo().equals(frmEstilo.table.getValueAt(row,0).toString()))
                        estiloActual.setIdEstilo(listaEstilo.get(i).getIdEstilo());//primary key
                }
                if(estiloDao.Delete(estiloActual)){
                    JOptionPane.showMessageDialog(null,"Estilo de aprendizaje eliminado!");  
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
        frmEstilo.txtEstilo.setText("");
        frmEstilo.txtDescripcion.setText("");
        frmEstilo.txtBuscar.setText("");
        frmEstilo.btnCreate.setEnabled(true);
        frmEstilo.table.setRowSorter(null);//clear filter
        model=new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
        Read();
    }
    
    @Override 
    public void keyReleased(KeyEvent e) {
        DefaultTableModel dm=(DefaultTableModel) frmEstilo.table.getModel();
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<>(dm);
        frmEstilo.table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(frmEstilo.txtBuscar.getText()));
        frmEstilo.btnCreate.setEnabled(true);
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()){
            if (frmEstilo.table.getSelectedRow() != -1) {
                row = frmEstilo.table.getSelectedRow();
                frmEstilo.txtEstilo.setText(frmEstilo.table.getValueAt(row,0).toString());
                frmEstilo.txtDescripcion.setText(frmEstilo.table.getValueAt(row,1).toString());
                frmEstilo.btnCreate.setEnabled(false);
            }    
        }
    }
}
