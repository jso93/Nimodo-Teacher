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
import pattern.dao.EstudianteDao;
import pattern.model.Persona;
import pattern.view.FrmEstudiante;

public class FrmEstudianteController extends KeyAdapter implements IView,ICrudView,ListSelectionListener{
    //model
    private Persona estudianteActual,estudianteNuevo;
    //view
    private final FrmEstudiante frmEstudiante;
    //dao
    private final EstudianteDao estudianteDao;
    //variables
    private String dni,nombres,apellidos,user,password;
    private List<Persona> listaEstudiante;
    private DefaultTableModel model;
    private final String[] rowTable = new String[5];
    private int row;

    public FrmEstudianteController(FrmEstudiante frmEstudiante) {
        this.frmEstudiante = frmEstudiante;
        this.estudianteDao = new EstudianteDao();
    }
    
    @Override
    public void initController() {
        frmEstudiante.btnCreate.addActionListener(e -> Create());
        frmEstudiante.btnUpdate.addActionListener(e -> Update());
        frmEstudiante.btnDelete.addActionListener(e -> Delete());
        frmEstudiante.btnNew.addActionListener(e -> Clear());
        frmEstudiante.table.getSelectionModel().addListSelectionListener(this);
        frmEstudiante.txtBuscar.addKeyListener(this);
    }

    @Override public void refreshView(){Clear();}

    @Override
    public void Create() {
        dni = frmEstudiante.txtDni.getText();
        nombres = frmEstudiante.txtNombres.getText();
        apellidos = frmEstudiante.txtApellidos.getText();
        user = frmEstudiante.txtUser.getText();
        password = frmEstudiante.txtPassword.getText();
        if(!dni.isEmpty() && !nombres.isEmpty() && !apellidos.isEmpty() && !user.isEmpty() && !password.isEmpty()){
            if(dni.length()==8){
                estudianteNuevo = new Persona(dni, nombres, apellidos, user, password);
                if(estudianteDao.Create(estudianteNuevo)){
                    JOptionPane.showMessageDialog(null,"Registro exitoso!");
                    refreshView();
                }else{
                    JOptionPane.showMessageDialog(null,"Ya existe usuario con el dni ingresado o nombre de user","Mensaje",JOptionPane.ERROR_MESSAGE);
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
        listaEstudiante = estudianteDao.Read();
        if(listaEstudiante.size()>0){
            //add column to table
            model.addColumn("DNI");
            model.addColumn("NOMBRES");
            model.addColumn("APELLIDOS");
            model.addColumn("USER");
            model.addColumn("PASSWORD");
            //add rowTable to table
            for (int i = 0; i <listaEstudiante.size(); i++) {
                rowTable[0] = listaEstudiante.get(i).getDni();
                rowTable[1] = listaEstudiante.get(i).getNombres();
                rowTable[2] = listaEstudiante.get(i).getApellidos();
                rowTable[3] = listaEstudiante.get(i).getUser();
                rowTable[4] = listaEstudiante.get(i).getPassword();
                model.addRow(rowTable);
            }
        }
        frmEstudiante.table.setModel(model);
    }

    @Override
    public void Update() {
        dni = frmEstudiante.txtDni.getText();
        nombres = frmEstudiante.txtNombres.getText();
        apellidos = frmEstudiante.txtApellidos.getText();
        user = frmEstudiante.txtUser.getText();
        password = frmEstudiante.txtPassword.getText();
        if(!frmEstudiante.table.getSelectionModel().isSelectionEmpty()){
            if(!dni.isEmpty() && !nombres.isEmpty() && !apellidos.isEmpty() && !user.isEmpty() && !password.isEmpty()){
                if(dni.length()==8){
                    //actual
                    estudianteActual = new Persona();
                    estudianteActual.setDni(frmEstudiante.table.getValueAt(row,0).toString());//primary key
                    //nuevo
                    estudianteNuevo = new Persona(dni, nombres, apellidos, user, password);
                    if(estudianteDao.Update(estudianteActual,estudianteNuevo)){
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
        if(!frmEstudiante.table.getSelectionModel().isSelectionEmpty()){
            int confirmado = JOptionPane.showConfirmDialog(null,"¿Seguro que desea eliminar al estudiante?");
            if (JOptionPane.OK_OPTION == confirmado){
                //actual
                estudianteActual = new Persona();
                estudianteActual.setDni(frmEstudiante.table.getValueAt(row,0).toString());//primary key
                if(estudianteDao.Delete(estudianteActual)){
                    JOptionPane.showMessageDialog(null,"Estudiante eliminado!");  
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
        frmEstudiante.txtDni.setText("");
        frmEstudiante.txtNombres.setText("");
        frmEstudiante.txtApellidos.setText("");
        frmEstudiante.txtUser.setText("");
        frmEstudiante.txtPassword.setText("");
        frmEstudiante.txtBuscar.setText("");
        frmEstudiante.btnCreate.setEnabled(true);
        frmEstudiante.table.setRowSorter(null);//clear filter
        model = new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
        Read();
    }
    
    @Override 
    public void keyReleased(KeyEvent e) {
        DefaultTableModel dm=(DefaultTableModel) frmEstudiante.table.getModel();
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<>(dm);
        frmEstudiante.table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(frmEstudiante.txtBuscar.getText()));
        frmEstudiante.btnCreate.setEnabled(true);
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()){
            if (frmEstudiante.table.getSelectedRow() != -1) {
                row = frmEstudiante.table.getSelectedRow();
                frmEstudiante.txtDni.setText(frmEstudiante.table.getValueAt(row,0).toString());
                frmEstudiante.txtNombres.setText(frmEstudiante.table.getValueAt(row,1).toString());
                frmEstudiante.txtApellidos.setText(frmEstudiante.table.getValueAt(row,2).toString());
                frmEstudiante.txtUser.setText(frmEstudiante.table.getValueAt(row,3).toString());
                frmEstudiante.txtPassword.setText(frmEstudiante.table.getValueAt(row,4).toString());
                frmEstudiante.btnCreate.setEnabled(false);
            }    
        }
    }
}
