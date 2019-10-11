package pattern.controller;

import com.toedter.calendar.JTextFieldDateEditor;
import interfaces.ICrudView;
import interfaces.IView;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import pattern.dao.PeriodoDao;
import pattern.model.Periodo;
import pattern.view.FrmPeriodo;

public class FrmPeriodoController extends KeyAdapter implements IView,ICrudView,ListSelectionListener{
    //model
    private Periodo periodoActual,periodoNuevo;
    //view
    private final FrmPeriodo frmPeriodo;
    //dao
    private final PeriodoDao periodoDao;
    //variables
    private String periodo,fechaInicio,fechaFin;
    private List<Periodo> listaPeriodo;
    private DefaultTableModel model;
    private final String [] rowTable = new String[3];
    private int row;
    private Date fecha_inicio,fecha_fin;
    private JTextFieldDateEditor editorFechaInicio,editorFechaFin;

    public FrmPeriodoController(FrmPeriodo frmPeriodo) {
        this.frmPeriodo = frmPeriodo;
        this.periodoDao = new PeriodoDao();
    }

    @Override
    public void initController() {
        frmPeriodo.btnCreate.addActionListener(e -> Create());
        frmPeriodo.btnUpdate.addActionListener(e -> Update());
        frmPeriodo.btnDelete.addActionListener(e -> Delete());
        frmPeriodo.btnNew.addActionListener(e -> Clear());
        frmPeriodo.table.getSelectionModel().addListSelectionListener(this);
        frmPeriodo.txtBuscar.addKeyListener(this);
        //disabled editor jcalendar
        editorFechaInicio = (JTextFieldDateEditor) frmPeriodo.txtFechaInicio.getDateEditor();
        editorFechaInicio.setEditable(false);
        editorFechaFin = (JTextFieldDateEditor) frmPeriodo.txtFechaFin.getDateEditor();
        editorFechaFin.setEditable(false);
    }

    @Override public void refreshView(){Clear();}

    @Override
    public void Create() {
        periodo = frmPeriodo.txtPeriodo.getSelectedItem().toString();
        fechaInicio = ((JTextField) frmPeriodo.txtFechaInicio.getDateEditor().getUiComponent()).getText();
        fechaFin = ((JTextField) frmPeriodo.txtFechaFin.getDateEditor().getUiComponent()).getText();
        if(!periodo.isEmpty() && !fechaInicio.isEmpty() && !fechaFin.isEmpty()){
            periodoNuevo = new Periodo(0, periodo, fechaInicio,fechaFin);
            if(periodoDao.Create(periodoNuevo)){
                JOptionPane.showMessageDialog(null,"Registro exitoso!");
                refreshView();
            }else{
                JOptionPane.showMessageDialog(null,"Ya existe Periodo, ingrese otro!","Mensaje",JOptionPane.ERROR_MESSAGE);
            }    
        }else{
            JOptionPane.showMessageDialog(null,"Existen campos vacíos","Mensaje",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void Read() {
        listaPeriodo = periodoDao.Read();
        if(listaPeriodo.size()>0){
            //add column to table
            model.addColumn("PERIODO");
            model.addColumn("FECHA INICIO");
            model.addColumn("FECHA FIN");
            //add rowTable to table
            for (int i = 0; i <listaPeriodo.size(); i++) {
                rowTable[0] = listaPeriodo.get(i).getPeriodo();
                rowTable[1] = listaPeriodo.get(i).getFechaInicio();
                rowTable[2] = listaPeriodo.get(i).getFechaFin();
                model.addRow(rowTable);
            }
        }
        frmPeriodo.table.setModel(model);//seteamos model
    }

    @Override
    public void Update() {
        if(!frmPeriodo.table.getSelectionModel().isSelectionEmpty()){
            periodo = frmPeriodo.txtPeriodo.getSelectedItem().toString();
            fechaInicio = ((JTextField) frmPeriodo.txtFechaInicio.getDateEditor().getUiComponent()).getText();
            fechaFin = ((JTextField) frmPeriodo.txtFechaFin.getDateEditor().getUiComponent()).getText();
            if(!periodo.isEmpty() && !fechaInicio.isEmpty() && !fechaFin.isEmpty()){
                    //actual
                    periodoActual = new Periodo();
                    for (int i = 0; i < listaPeriodo.size(); i++) {
                        if(listaPeriodo.get(i).getPeriodo().equals(frmPeriodo.table.getValueAt(row,0).toString()))
                            periodoActual.setIdPeriodo(listaPeriodo.get(i).getIdPeriodo());//primary key
                    }
                    //nuevo
                    periodoNuevo = new Periodo(0, periodo, fechaInicio,fechaFin);
                    if(periodoDao.Update(periodoActual,periodoNuevo)){
                        JOptionPane.showMessageDialog(null,"Actualización exitosa!");
                        refreshView();
                    }else{
                        JOptionPane.showMessageDialog(null,"Ya existe periodo, ingrese otro!","Mensaje",JOptionPane.ERROR_MESSAGE);
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
        if(!frmPeriodo.table.getSelectionModel().isSelectionEmpty()){
            int confirmado = JOptionPane.showConfirmDialog(null,"¿Seguro que desea eliminar el periodo?");
            if (JOptionPane.OK_OPTION == confirmado){
                //actual
                periodoActual = new Periodo();
                for (int i = 0; i < listaPeriodo.size(); i++) {
                    if(listaPeriodo.get(i).getPeriodo().equals(frmPeriodo.table.getValueAt(row,0).toString()))
                        periodoActual.setIdPeriodo(listaPeriodo.get(i).getIdPeriodo());//primary key
                }
                if(periodoDao.Delete(periodoActual)){
                    JOptionPane.showMessageDialog(null,"Periodo eliminado!");  
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
        frmPeriodo.txtPeriodo.setSelectedIndex(0);
        frmPeriodo.txtFechaInicio.setDate(null);
        frmPeriodo.txtFechaFin.setDate(null);
        frmPeriodo.txtBuscar.setText("");
        frmPeriodo.btnCreate.setEnabled(true);
        frmPeriodo.table.setRowSorter(null);//clear filter
        model=new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
        Read();
    }
    
    @Override 
    public void keyReleased(KeyEvent e) {
        DefaultTableModel dm=(DefaultTableModel) frmPeriodo.table.getModel();
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<>(dm);
        frmPeriodo.table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(frmPeriodo.txtBuscar.getText()));
        frmPeriodo.btnCreate.setEnabled(true);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()){
            if (frmPeriodo.table.getSelectedRow() != -1) {
                 row = frmPeriodo.table.getSelectedRow();
                 frmPeriodo.txtPeriodo.setSelectedItem(frmPeriodo.table.getValueAt(row,0).toString());
                 try {
                         fecha_inicio = new SimpleDateFormat("dd/MM/yyyy").parse(frmPeriodo.table.getValueAt(row, 1).toString());
                         frmPeriodo.txtFechaInicio.setDate(fecha_inicio);
                         fecha_fin = new SimpleDateFormat("dd/MM/yyyy").parse(frmPeriodo.table.getValueAt(row, 2).toString());
                         frmPeriodo.txtFechaFin.setDate(fecha_fin);
                     } catch (ParseException ex) {
                         Logger.getLogger(FrmPeriodoController.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 frmPeriodo.btnCreate.setEnabled(false);
             }     
        }
    }
    
}
