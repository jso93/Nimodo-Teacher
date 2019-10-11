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
import pattern.dao.DocenteDao;
import pattern.model.Persona;
import pattern.view.FrmDocente;

public class FrmDocenteController extends KeyAdapter implements IView,ICrudView,ListSelectionListener{
    //model
    private Persona docenteActual,docenteNuevo;
    //view
    private final FrmDocente frmDocente;
    //dao
    private final DocenteDao docenteDao;
    //variables
    private String dni,nombres,apellidos,user,password;
    private List<Persona> listaDocente;
    private DefaultTableModel model;
    private final String[] rowTable = new String[5];
    private int row;
    private final List<String> persona;

    public FrmDocenteController(FrmDocente frmDocente,List<String> persona) {
        this.frmDocente = frmDocente;
        this.docenteDao = new DocenteDao();
        this.persona = persona;
    }

    @Override
    public void initController() {
        frmDocente.btnCreate.addActionListener(e -> Create());
        frmDocente.btnUpdate.addActionListener(e -> Update());
        frmDocente.btnDelete.addActionListener(e -> Delete());
        frmDocente.btnNew.addActionListener(e -> Clear());
        frmDocente.table.getSelectionModel().addListSelectionListener(this);
        frmDocente.txtBuscar.addKeyListener(this);
    }

    @Override
    public void refreshView(){Clear();}

    @Override
    public void Create() {
        dni = frmDocente.txtDni.getText();
        nombres = frmDocente.txtNombres.getText();
        apellidos = frmDocente.txtApellidos.getText();
        user = frmDocente.txtUser.getText();
        password = frmDocente.txtPassword.getText();
        if(!dni.isEmpty() && !nombres.isEmpty() && !apellidos.isEmpty() && !user.isEmpty() && !password.isEmpty()){
            if(dni.length()==8){
                docenteNuevo = new Persona(dni, nombres, apellidos, user, password);
                if(docenteDao.Create(docenteNuevo)){
                    JOptionPane.showMessageDialog(null,"Registro exitoso!");
                    refreshView();
                }else{
                    JOptionPane.showMessageDialog(null,"Ya existe usuario, ingrese otro!","Mensaje",JOptionPane.ERROR_MESSAGE);
                }    
            }else{
                JOptionPane.showMessageDialog(null,"El dni debe tener 8 caracteres!","Mensaje",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Existen campos vacíos","Mensaje",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void Read() {
        listaDocente = docenteDao.Read();
        if(listaDocente.size()>0){
            //add column to table
            model.addColumn("DNI");
            model.addColumn("NOMBRES");
            model.addColumn("APELLIDOS");
            model.addColumn("USER");
            model.addColumn("PASSWORD");
            //add rowTable to table
            for (int i = 0; i <listaDocente.size(); i++) {
                rowTable[0] = listaDocente.get(i).getDni();
                rowTable[1] = listaDocente.get(i).getNombres();
                rowTable[2] = listaDocente.get(i).getApellidos();
                rowTable[3] = listaDocente.get(i).getUser();
                rowTable[4] = listaDocente.get(i).getPassword();
                model.addRow(rowTable);
            }
        }
        frmDocente.table.setModel(model);
    }

    @Override
    public void Update() {
        dni = frmDocente.txtDni.getText();
        nombres = frmDocente.txtNombres.getText();
        apellidos = frmDocente.txtApellidos.getText();
        user = frmDocente.txtUser.getText();
        password = frmDocente.txtPassword.getText();
        if(!frmDocente.table.getSelectionModel().isSelectionEmpty()){
            if(!dni.isEmpty() && !nombres.isEmpty() && !apellidos.isEmpty() && !user.isEmpty() && !password.isEmpty()){
                if(dni.length()==8){
                    //actual
                    docenteActual = new Persona();
                    docenteActual.setDni(frmDocente.table.getValueAt(row,0).toString());//primary key
                    //nuevo
                    docenteNuevo = new Persona(dni, nombres, apellidos, user, password);
                    if(docenteDao.Update(docenteActual,docenteNuevo)){
                        if(docenteActual.getDni().equals(persona.get(0))){
                            persona.set(0, dni);System.out.println("dni:"+persona.get(0));
                        }
                        JOptionPane.showMessageDialog(null,"Actualización exitosa!");
                        refreshView();
                    }else{
                        JOptionPane.showMessageDialog(null,"Ya existe usuario, ingrese otro!","Mensaje",JOptionPane.ERROR_MESSAGE);
                    }    
                }else{
                    JOptionPane.showMessageDialog(null,"El dni debe tener 8 caracteres!","Mensaje",JOptionPane.ERROR_MESSAGE);
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
        if(!frmDocente.table.getSelectionModel().isSelectionEmpty()){
            int confirmado = JOptionPane.showConfirmDialog(null,"¿Seguro que desea eliminar al docente?");
            if (JOptionPane.OK_OPTION == confirmado){
                //actual
                docenteActual = new Persona();
                docenteActual.setDni(frmDocente.table.getValueAt(row,0).toString());//primary key
                if(docenteDao.Delete(docenteActual)){
                    JOptionPane.showMessageDialog(null,"Docente eliminado!");  
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
        frmDocente.txtDni.setText("");
        frmDocente.txtNombres.setText("");
        frmDocente.txtApellidos.setText("");
        frmDocente.txtUser.setText("");
        frmDocente.txtPassword.setText("");
        frmDocente.txtBuscar.setText("");
        frmDocente.btnCreate.setEnabled(true);
        frmDocente.table.setRowSorter(null);//clear filter
        model=new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
        Read();
    }
    
    @Override 
    public void keyReleased(KeyEvent e) {
        DefaultTableModel dm=(DefaultTableModel) frmDocente.table.getModel();
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<>(dm);
        frmDocente.table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(frmDocente.txtBuscar.getText()));
        frmDocente.btnCreate.setEnabled(true);
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()){
            if (frmDocente.table.getSelectedRow() != -1) {
                row = frmDocente.table.getSelectedRow();
                frmDocente.txtDni.setText(frmDocente.table.getValueAt(row,0).toString());
                frmDocente.txtNombres.setText(frmDocente.table.getValueAt(row,1).toString());
                frmDocente.txtApellidos.setText(frmDocente.table.getValueAt(row,2).toString());
                frmDocente.txtUser.setText(frmDocente.table.getValueAt(row,3).toString());
                frmDocente.txtPassword.setText(frmDocente.table.getValueAt(row,4).toString());
                frmDocente.btnCreate.setEnabled(false);
            }    
        }
    }
}
