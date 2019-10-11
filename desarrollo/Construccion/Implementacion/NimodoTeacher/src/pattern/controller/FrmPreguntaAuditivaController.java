package pattern.controller;

import interfaces.ICrudView;
import interfaces.IView;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import pattern.dao.AlternativaDao;
import pattern.dao.AudioDao;
import pattern.dao.DocenteAulaDao;
import pattern.dao.EstiloDao;
import pattern.dao.DesempeñoDao;
import pattern.dao.MatrizDao;
import pattern.dao.NivelDao;
import pattern.dao.PeriodoDao;
import pattern.dao.PreguntaDao;
import pattern.model.Alternativa;
import pattern.model.Audio;
import pattern.model.Estilo;
import pattern.model.Desempeño;
import pattern.model.Matriz;
import pattern.model.Nivel;
import pattern.model.Periodo;
import pattern.model.Pregunta;
import pattern.view.FrmDesempeñoBusqueda;
import pattern.view.FrmDesempeñoInfo;
import pattern.view.FrmPreguntaAuditiva;

public class FrmPreguntaAuditivaController extends KeyAdapter implements IView,ICrudView,ItemListener,ListSelectionListener{
    //model
    private Pregunta preguntaNuevo,preguntaActual;
    private Alternativa primeraAlternativaNuevo,primeraAlternativaActual,segundaAlternativaNuevo,segundaAlternativaActual,terceraAlternativaNuevo,terceraAlternativaActual;
    private Audio audioNuevo,audioActual;
    //view
    private final FrmPreguntaAuditiva frmPreguntaAuditiva;
    private final FrmDesempeñoBusqueda frmDesempeñoBusqueda;
    private final FrmDesempeñoInfo frmDesempeñoInfo;
    //controller
    private final FrmPrincipalController frmPrincipalController;
    private final FrmDesempeñoBusquedaController frmDesempeñoBusquedaController;
    private final FrmDesempeñoInfoController frmDesempeñoInfoController;
    //dao
    private final PreguntaDao preguntaDao;
    private final AlternativaDao alternativaDao;
    private final AudioDao audioDao;
    private final EstiloDao estiloDao;
    private final NivelDao nivelDao;
    private final DesempeñoDao desempeñoDao;
    private final MatrizDao matrizDao;
    private final PeriodoDao periodoDao;
    private final DocenteAulaDao docenteAulaDao;
    //variables
    private int row;
    private List<Pregunta> listaPregunta;
    private List<Audio> listaAudio;
    private final List<Alternativa> listaAlternativaNuevo;
    private final List<Alternativa> listaAternativaActual;
    private List<Alternativa> listaAlternativa;
    private List<Estilo> listaEstilo;
    private List<Nivel> listaNivel;
    private List<Desempeño> listaDesempeño;
    private List<Matriz> listaMatriz;
    private List<Periodo> listaPeriodo;
    private List<List<String>> listaDocente;
    private DefaultTableModel model;
    private final JFileChooser fileChooser = new JFileChooser();
    private final FileNameExtensionFilter filter = new FileNameExtensionFilter("OGG", "ogg");
    private File namepathNuevo,namepathActual;
    private double descuido,descuido_redondeado,adivinanza,adivinanza_redondeado;
    private String txtDescripcion;
    private double txtDescuido,txtAdivinanza;
    private String txtPeriodo,txtNivel,txtEstilo;
    private int idNivel,idEstilo,idMatriz,idPeriodo, idDocenteAula;
    private boolean successA = false, successB = false, successC = false;
    private final String urlImagenDestino = "C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\audio\\";
    private String nombreOGG;
    private final Object [] rowTable = new Object[7];
    private int aux;
    private boolean estadoChooser = false;
    private final List<String> persona;
    private String dniDocente;
    
    public FrmPreguntaAuditivaController(FrmPreguntaAuditiva frmPreguntaAuditiva,FrmPrincipalController frmPrincipalController,List<String> persona) {
        this.frmPreguntaAuditiva = frmPreguntaAuditiva;
        this.preguntaDao = new PreguntaDao();
        this.alternativaDao = new AlternativaDao();
        this.audioDao = new AudioDao();
        this.estiloDao = new EstiloDao();
        this.nivelDao = new NivelDao();
        this.desempeñoDao = new DesempeñoDao();
        this.matrizDao = new MatrizDao();
        this.periodoDao = new PeriodoDao();
        this.docenteAulaDao = new DocenteAulaDao();
        this.frmPrincipalController = frmPrincipalController;
        this.persona = persona;
        this.frmDesempeñoBusqueda = new FrmDesempeñoBusqueda(this.frmPrincipalController.frmPrincipal, true);
        this.frmDesempeñoBusquedaController = new FrmDesempeñoBusquedaController(frmDesempeñoBusqueda,this.frmPreguntaAuditiva,this.persona);
        this.frmDesempeñoInfo = new FrmDesempeñoInfo(this.frmPrincipalController.frmPrincipal, true);
        this.frmDesempeñoInfoController = new FrmDesempeñoInfoController(frmDesempeñoInfo);
        this.listaAlternativaNuevo = new ArrayList<>();
        this.listaAternativaActual = new ArrayList<>();
    }
    
    @Override
    public void initController() {
        frmDesempeñoBusquedaController.initController();
        frmPreguntaAuditiva.btnCreate.addActionListener(e -> Create());
        frmPreguntaAuditiva.btnUpdate.addActionListener(e -> Update());
        frmPreguntaAuditiva.btnDelete.addActionListener(e -> Delete());
        frmPreguntaAuditiva.btnNew.addActionListener(e -> Clear());
        frmPreguntaAuditiva.btnBuscarDesempenio.addActionListener(e-> buscarDesempeño());
        frmPreguntaAuditiva.btnDesempenioInfo.addActionListener(e-> verDetalleDesempeño());
        frmPreguntaAuditiva.btnBuscarAudio.addActionListener(e-> buscarAudio());
        frmPreguntaAuditiva.table.getSelectionModel().addListSelectionListener(this);
        frmPreguntaAuditiva.txtBuscar.addKeyListener(this);
        frmPreguntaAuditiva.txtNivel.addItemListener(this);
        frmPreguntaAuditiva.successA.addItemListener(this);
        frmPreguntaAuditiva.successB.addItemListener(this);
        frmPreguntaAuditiva.successC.addItemListener(this);
        //hide idMatriz
        frmPreguntaAuditiva.idMatriz.setVisible(false);
        frmPreguntaAuditiva.txtDesempeñoDescripcion.setVisible(false);
    }

    @Override public void refreshView(){Clear();}

    @Override
    public void Create() {
        if(frmPreguntaAuditiva.txtPeriodo.getItemCount() > 0 && !frmPreguntaAuditiva.txtDescripcion.getText().isEmpty() && /*!frmPreguntaAuditiva.txtApriori.getText().isEmpty() && */
           !frmPreguntaAuditiva.txtDescuido.getText().isEmpty() && !frmPreguntaAuditiva.txtAdivinanza.getText().isEmpty() &&
            frmPreguntaAuditiva.txtNivel.getItemCount() > 0 && !frmPreguntaAuditiva.txtEstilo.getText().isEmpty() &&
           !frmPreguntaAuditiva.txtDesempenio.getText().isEmpty() && !frmPreguntaAuditiva.txtAudio.getText().isEmpty() && !frmPreguntaAuditiva.txtPrimeraAlternativa.getText().isEmpty() &&
           !frmPreguntaAuditiva.txtSegundaAlternativa.getText().isEmpty() && !frmPreguntaAuditiva.txtTerceraAlternativa.getText().isEmpty()){
            //recuperamos datos
            txtDescripcion = frmPreguntaAuditiva.txtDescripcion.getText();
            txtDescuido = Double.parseDouble(frmPreguntaAuditiva.txtDescuido.getText());
            txtAdivinanza = Double.parseDouble(frmPreguntaAuditiva.txtAdivinanza.getText());
            txtNivel = frmPreguntaAuditiva.txtNivel.getSelectedItem().toString();
            txtEstilo = frmPreguntaAuditiva.txtEstilo.getText();
            txtPeriodo = frmPreguntaAuditiva.txtPeriodo.getSelectedItem().toString();
            //idNivel
            for (int i = 0; i < listaNivel.size(); i++) {
                if(listaNivel.get(i).getNivel().equals(txtNivel))idNivel = listaNivel.get(i).getIdNivel();
            }
            //idEstilo
            for (int i = 0; i < listaEstilo.size(); i++) {
                if(listaEstilo.get(i).getEstilo().equals(txtEstilo))idEstilo = listaEstilo.get(i).getIdEstilo();
            }
            
            //idMatriz
            idMatriz = Integer.parseInt(frmPreguntaAuditiva.idMatriz.getText());
            
            //idperiodo
            for (int i = 0; i < listaPeriodo.size(); i++) {
                if(listaPeriodo.get(i).getPeriodo().equals(txtPeriodo))idPeriodo = listaPeriodo.get(i).getIdPeriodo();
            }
            
            if(frmPreguntaAuditiva.successA.isSelected() || frmPreguntaAuditiva.successB.isSelected() || frmPreguntaAuditiva.successC.isSelected()){
                //creamos objeto pregunta
                preguntaNuevo = new Pregunta(0, txtDescripcion, txtDescuido, txtAdivinanza, idNivel, idEstilo, idMatriz, idPeriodo, idDocenteAula);
                if(preguntaDao.Create(preguntaNuevo)){
                    if(frmPreguntaAuditiva.successA.isSelected())successA = true;
                    if(frmPreguntaAuditiva.successB.isSelected())successB = true;
                    if(frmPreguntaAuditiva.successC.isSelected())successC = true;
                    //creamos alternativa
                    primeraAlternativaNuevo = new Alternativa(0, frmPreguntaAuditiva.txtPrimeraAlternativa.getText(), successA, preguntaDao.getIdPregunta());
                    segundaAlternativaNuevo = new Alternativa(0, frmPreguntaAuditiva.txtSegundaAlternativa.getText(), successB, preguntaDao.getIdPregunta());
                    terceraAlternativaNuevo = new Alternativa(0, frmPreguntaAuditiva.txtTerceraAlternativa.getText(), successC, preguntaDao.getIdPregunta());
                    //limpiar lista de alternativas
                    if(listaAlternativaNuevo!=null)listaAlternativaNuevo.clear(); 
                    //añadimos a la lista las alternativas
                    listaAlternativaNuevo.add(primeraAlternativaNuevo);
                    listaAlternativaNuevo.add(segundaAlternativaNuevo);
                    listaAlternativaNuevo.add(terceraAlternativaNuevo);
                    //recorremos lista
                    for (int i = 0; i < listaAlternativaNuevo.size(); i++) {
                        alternativaDao.Create(listaAlternativaNuevo.get(i));//registramos alternativas
                    }
                    //nombre del OGG
                    nombreOGG = preguntaDao.getIdPregunta()+".ogg";
                    //creamos audio
                    audioNuevo = new Audio(0,urlImagenDestino+nombreOGG, preguntaDao.getIdPregunta());
                    guardarAudio();//guardamos OGG en el directorio
                    if(audioDao.Create(audioNuevo)){JOptionPane.showMessageDialog(null,"Registro exitoso!"); refreshView();}
                    ////reseteamos valores
                    successA = false;
                    successB = false;
                    successC = false;
                }else{
                    JOptionPane.showMessageDialog(null,"Ya existe pregunta, ingrese otro!","Mensaje",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null,"Seleccione una alternativa como respuesta correcta!","Mensaje",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Existen campos vacíos","Mensaje",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void Read() {
        cargarPeriodos();
        getDocenteAula();
        cargarEstilos();
        cargarNiveles();
        cargarDesempeños();
        cargarMatriz();
        cargarAudios();
        cargarAlternativas();
        cargarPreguntas();
    }

    @Override
    public void Update() {
        if(!frmPreguntaAuditiva.table.getSelectionModel().isSelectionEmpty()){
            if(frmPreguntaAuditiva.txtPeriodo.getItemCount() > 0 && !frmPreguntaAuditiva.txtDescripcion.getText().isEmpty() && /*!frmPreguntaAuditiva.txtApriori.getText().isEmpty() && */
               !frmPreguntaAuditiva.txtDescuido.getText().isEmpty() && !frmPreguntaAuditiva.txtAdivinanza.getText().isEmpty() &&
                frmPreguntaAuditiva.txtNivel.getItemCount() > 0 && !frmPreguntaAuditiva.txtEstilo.getText().isEmpty() &&
               !frmPreguntaAuditiva.txtDesempenio.getText().isEmpty() && !frmPreguntaAuditiva.txtAudio.getText().isEmpty() && !frmPreguntaAuditiva.txtPrimeraAlternativa.getText().isEmpty() &&
               !frmPreguntaAuditiva.txtSegundaAlternativa.getText().isEmpty() && !frmPreguntaAuditiva.txtTerceraAlternativa.getText().isEmpty()){
                //PREGUNTA ACTUAL
                preguntaActual = new Pregunta();
                for (int i = 0; i < listaPregunta.size(); i++) {
                    if(listaPregunta.get(i).getDescripcion().equals(frmPreguntaAuditiva.table.getValueAt(row, 0).toString())){
                        preguntaActual.setIdPregunta(listaPregunta.get(i).getIdPregunta());//primary key
                    }
                }
                //PREGUNTA NUEVO
                txtDescripcion = frmPreguntaAuditiva.txtDescripcion.getText();
                txtDescuido = Double.parseDouble(frmPreguntaAuditiva.txtDescuido.getText());
                txtAdivinanza = Double.parseDouble(frmPreguntaAuditiva.txtAdivinanza.getText());
                txtNivel = frmPreguntaAuditiva.txtNivel.getSelectedItem().toString();
                txtEstilo = frmPreguntaAuditiva.txtEstilo.getText();
                txtPeriodo = frmPreguntaAuditiva.txtPeriodo.getSelectedItem().toString();
                //idNivel
                for (int i = 0; i < listaNivel.size(); i++) {
                    if(listaNivel.get(i).getNivel().equals(txtNivel))idNivel = listaNivel.get(i).getIdNivel();
                }
                //idEstilo
                for (int i = 0; i < listaEstilo.size(); i++) {
                    if(listaEstilo.get(i).getEstilo().equals(txtEstilo))idEstilo = listaEstilo.get(i).getIdEstilo();
                }
                //idMatriz
                idMatriz = Integer.parseInt(frmPreguntaAuditiva.idMatriz.getText());

                //idperiodo
                for (int i = 0; i < listaPeriodo.size(); i++) {
                    if(listaPeriodo.get(i).getPeriodo().equals(txtPeriodo))idPeriodo = listaPeriodo.get(i).getIdPeriodo();
                }

                if(frmPreguntaAuditiva.successA.isSelected() || frmPreguntaAuditiva.successB.isSelected() || frmPreguntaAuditiva.successC.isSelected()){
                    //creamos objeto pregunta
                    preguntaNuevo = new Pregunta(0, txtDescripcion, txtDescuido, txtAdivinanza, idNivel, idEstilo, idMatriz, idPeriodo, idDocenteAula);
                    if(preguntaDao.Update(preguntaActual,preguntaNuevo)){
                        if(frmPreguntaAuditiva.successA.isSelected())successA = true;
                        if(frmPreguntaAuditiva.successB.isSelected())successB = true;
                        if(frmPreguntaAuditiva.successC.isSelected())successC = true;
                        //ALTERNATIVA ACTUAL
                        primeraAlternativaActual = new Alternativa();
                        segundaAlternativaActual = new Alternativa();
                        terceraAlternativaActual = new Alternativa();
                        aux =0;//reseteamos auxiliar
                        for (int j = 0; j < listaAlternativa.size(); j++) {//alternativas
                            if(preguntaActual.getIdPregunta() == listaAlternativa.get(j).getIdPregunta()){
                                if(aux == 0){primeraAlternativaActual.setIdAlternativa(listaAlternativa.get(j).getIdAlternativa());}
                                if(aux == 1){segundaAlternativaActual.setIdAlternativa(listaAlternativa.get(j).getIdAlternativa());}
                                if(aux == 2){terceraAlternativaActual.setIdAlternativa(listaAlternativa.get(j).getIdAlternativa());}
                                aux+=1;
                            }
                        }
                        //limpiar lista de alternativas actuales
                        if(listaAternativaActual!=null)listaAternativaActual.clear(); 
                        //añadimos a la lista las alternativas actuales
                        listaAternativaActual.add(primeraAlternativaActual);
                        listaAternativaActual.add(segundaAlternativaActual);
                        listaAternativaActual.add(terceraAlternativaActual);
                        //ALTERNATIVA NUEVO
                        //creamos alternativa nuevo
                        primeraAlternativaNuevo = new Alternativa(0, frmPreguntaAuditiva.txtPrimeraAlternativa.getText(), successA, preguntaActual.getIdPregunta());
                        segundaAlternativaNuevo = new Alternativa(0, frmPreguntaAuditiva.txtSegundaAlternativa.getText(), successB, preguntaActual.getIdPregunta());
                        terceraAlternativaNuevo = new Alternativa(0, frmPreguntaAuditiva.txtTerceraAlternativa.getText(), successC, preguntaActual.getIdPregunta());
                        //limpiar lista de alternativas nuevas
                        if(listaAlternativaNuevo!=null)listaAlternativaNuevo.clear(); 
                        //añadimos a la lista las alternativas nuevas
                        listaAlternativaNuevo.add(primeraAlternativaNuevo);
                        listaAlternativaNuevo.add(segundaAlternativaNuevo);
                        listaAlternativaNuevo.add(terceraAlternativaNuevo);
                        //recorremos lista
                        for (int i = 0; i < listaAlternativaNuevo.size(); i++) {
                            alternativaDao.Update(listaAternativaActual.get(i),listaAlternativaNuevo.get(i));//actualizamos alternativas
                        }
                        //AUDIO ACTUAL
                        audioActual = new Audio();
                        for (int i = 0; i < listaAudio.size() ; i++) {//path audio
                            if(preguntaActual.getIdPregunta() == listaAudio.get(i).getIdPregunta()){
                                audioActual.setAudio(listaAudio.get(i).getAudio());
                            }
                        }
                        //nombre del OGG
                        nombreOGG = preguntaActual.getIdPregunta()+".ogg";
                        namepathActual = new File(audioActual.getAudio());
                        //AUDIO NUEVO
                        namepathNuevo = fileChooser.getSelectedFile();
                        if(estadoChooser){
                        namepathNuevo = fileChooser.getSelectedFile();//si selecciona el chooser 
                        }else{
                        namepathNuevo = namepathActual; // si no selecciona el chooser   
                        }
                        estadoChooser = false;
                        guardarAudio();
                        ////reseteamos valores
                        JOptionPane.showMessageDialog(null,"Actualización exitosa!");
                        refreshView();
                        successA = false;
                        successB = false;
                        successC = false;
                    }else{
                        JOptionPane.showMessageDialog(null,"Ya existe pregunta, ingrese otro!","Mensaje",JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Seleccione una alternativa como respuesta correcta!","Mensaje",JOptionPane.ERROR_MESSAGE);
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
        if(!frmPreguntaAuditiva.table.getSelectionModel().isSelectionEmpty()){
            int confirmado = JOptionPane.showConfirmDialog(null,"¿Seguro que desea eliminar la pregunta?");
            if (JOptionPane.OK_OPTION == confirmado){
                //actual
                preguntaActual = new Pregunta();
                for (int i = 0; i < listaPregunta.size(); i++) {
                    if(listaPregunta.get(i).getDescripcion().equals(frmPreguntaAuditiva.table.getValueAt(row,0).toString()))
                        preguntaActual.setIdPregunta(listaPregunta.get(i).getIdPregunta());//primary key
                }
                if(preguntaDao.Delete(preguntaActual)){
                    //AUDIO ACTUAL
                    audioActual = new Audio();
                    for (int i = 0; i < listaAudio.size() ; i++) {//path audio
                        if(preguntaActual.getIdPregunta() == listaAudio.get(i).getIdPregunta()){
                            audioActual.setAudio(listaAudio.get(i).getAudio());
                        }
                    }
                    namepathActual = new File(audioActual.getAudio());
                    namepathActual.delete();//eliminamos el OGG que existe
                    JOptionPane.showMessageDialog(null,"Pregunta eliminada!");  
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
        frmPreguntaAuditiva.txtDescripcion.setText("");
        frmPreguntaAuditiva.txtEstilo.setText("");
        frmPreguntaAuditiva.txtDesempenio.setText("");
        frmPreguntaAuditiva.txtDesempeñoDescripcion.setText("");
        frmPreguntaAuditiva.txtAudio.setText("");
        frmPreguntaAuditiva.txtDescuido.setText("");
        frmPreguntaAuditiva.txtAdivinanza.setText("");
        frmPreguntaAuditiva.txtPrimeraAlternativa.setText("");
        frmPreguntaAuditiva.txtSegundaAlternativa.setText("");
        frmPreguntaAuditiva.txtTerceraAlternativa.setText("");
        frmPreguntaAuditiva.txtBuscar.setText("");
        frmPreguntaAuditiva.successA.setSelected(false);
        frmPreguntaAuditiva.successB.setSelected(false);
        frmPreguntaAuditiva.successC.setSelected(false);
        frmPreguntaAuditiva.btnCreate.setEnabled(true);
        frmPreguntaAuditiva.table.setRowSorter(null);//clear filter
        model=new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
        Read();
    }
    
    @Override 
    public void keyReleased(KeyEvent e) {
        DefaultTableModel dm=(DefaultTableModel) frmPreguntaAuditiva.table.getModel();
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<>(dm);
        frmPreguntaAuditiva.table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(frmPreguntaAuditiva.txtBuscar.getText()));
        frmPreguntaAuditiva.btnCreate.setEnabled(true);
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource().equals(frmPreguntaAuditiva.txtNivel) ){
            if (e.getStateChange() == ItemEvent.SELECTED){
                if(frmPreguntaAuditiva.txtNivel.getSelectedItem().toString().equals("En Inicio")){
                    descuido = 0.1;
                }
                if(frmPreguntaAuditiva.txtNivel.getSelectedItem().toString().equals("En Proceso")){
                    descuido = 0.15;
                }
                if(frmPreguntaAuditiva.txtNivel.getSelectedItem().toString().equals("Satisfactorio")){
                    descuido = 0.2;
                }
                //redondeamos aleatorios
                descuido_redondeado = (double)Math.round(descuido * 10000d) / 10000d;
                
                //adivinanza
                adivinanza = 1.0/3.0;//1 de 3 porque se va a tener 3 alternativas por pregunta y solo 1 es correcta.
                //adivinanza_redondeada
                adivinanza_redondeado = (double)Math.round(adivinanza * 10000d) / 10000d;
                //seteamos valores
                frmPreguntaAuditiva.txtDescuido.setText(""+descuido_redondeado);
                frmPreguntaAuditiva.txtAdivinanza.setText(""+adivinanza_redondeado);
            }
        }
        
        if(e.getSource().equals(frmPreguntaAuditiva.successA) ){
            if (e.getStateChange() == ItemEvent.SELECTED){
                frmPreguntaAuditiva.successB.setSelected(false);
                frmPreguntaAuditiva.successC.setSelected(false);
            }
        }
        if(e.getSource().equals(frmPreguntaAuditiva.successB) ){
            if (e.getStateChange() == ItemEvent.SELECTED){
                frmPreguntaAuditiva.successA.setSelected(false);
                frmPreguntaAuditiva.successC.setSelected(false);
            }
        }
        if(e.getSource().equals(frmPreguntaAuditiva.successC) ){
            if (e.getStateChange() == ItemEvent.SELECTED){
                frmPreguntaAuditiva.successA.setSelected(false);
                frmPreguntaAuditiva.successB.setSelected(false);
            }
        }
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()){
            if (frmPreguntaAuditiva.table.getSelectedRow() != -1) {
                row = frmPreguntaAuditiva.table.getSelectedRow();
                frmPreguntaAuditiva.txtPeriodo.setSelectedItem(frmPreguntaAuditiva.table.getValueAt(row,6).toString());
                frmPreguntaAuditiva.txtDescripcion.setText(frmPreguntaAuditiva.table.getValueAt(row,0).toString());
                frmPreguntaAuditiva.txtEstilo.setText(frmPreguntaAuditiva.table.getValueAt(row,4).toString());
                frmPreguntaAuditiva.txtNivel.setSelectedItem(frmPreguntaAuditiva.table.getValueAt(row,3).toString());
                frmPreguntaAuditiva.txtDesempenio.setText(frmPreguntaAuditiva.table.getValueAt(row,5).toString());
                frmPreguntaAuditiva.txtDescuido.setText(frmPreguntaAuditiva.table.getValueAt(row, 1).toString());
                frmPreguntaAuditiva.txtAdivinanza.setText(frmPreguntaAuditiva.table.getValueAt(row, 2).toString());
                frmPreguntaAuditiva.btnCreate.setEnabled(false);
                for (int i = 0; i < listaDesempeño.size(); i++) {//desempeño descripcion
                    if(listaDesempeño.get(i).getDesempeño().equals(frmPreguntaAuditiva.txtDesempenio.getText())){
                        frmPreguntaAuditiva.txtDesempeñoDescripcion.setText(listaDesempeño.get(i).getDescripcion());break;
                    }
                }
                for (int i = 0; i < listaPregunta.size(); i++) {//recorremos todas las preguntas auditivas
                    if(frmPreguntaAuditiva.txtDescripcion.getText().equals(listaPregunta.get(i).getDescripcion())){
                        for (int j = 0; j < listaAudio.size() ; j++) {//path audio
                            if(listaPregunta.get(i).getIdPregunta() == listaAudio.get(j).getIdPregunta()){
                                frmPreguntaAuditiva.txtAudio.setText(listaAudio.get(j).getAudio());
                            }
                        }
                        aux =0;//reseteamos auxiliar
                        for (int j = 0; j < listaAlternativa.size(); j++) {//alternativas
                            if(listaPregunta.get(i).getIdPregunta() == listaAlternativa.get(j).getIdPregunta()){
                                if(aux == 0){
                                    frmPreguntaAuditiva.txtPrimeraAlternativa.setText(listaAlternativa.get(j).getDescripcion());
                                    frmPreguntaAuditiva.successA.setSelected(listaAlternativa.get(j).isSuccess());
                                }
                                if(aux == 1){
                                    frmPreguntaAuditiva.txtSegundaAlternativa.setText(listaAlternativa.get(j).getDescripcion());
                                    frmPreguntaAuditiva.successB.setSelected(listaAlternativa.get(j).isSuccess());
                                }
                                if(aux == 2){
                                    frmPreguntaAuditiva.txtTerceraAlternativa.setText(listaAlternativa.get(j).getDescripcion());
                                    frmPreguntaAuditiva.successC.setSelected(listaAlternativa.get(j).isSuccess());
                                }
                                aux+=1;
                            }
                        }
                        //idMatriz
                        for (int j = 0; j < listaMatriz.size(); j++) {
                            if(listaPregunta.get(i).getIdMatriz() == listaMatriz.get(j).getIdMatriz()){
                                frmPreguntaAuditiva.idMatriz.setText(""+listaMatriz.get(j).getIdMatriz());
                            }
                        }
                        break;    
                    }
                }
            }
        }
    }
    
    public void buscarDesempeño(){
        frmDesempeñoBusquedaController.refreshView();
        frmDesempeñoBusqueda.setVisible(true);
        frmDesempeñoBusqueda.setLocationRelativeTo(null);
    }
    
    public void verDetalleDesempeño(){
        frmDesempeñoInfoController.sendInfo(frmPreguntaAuditiva.txtDesempeñoDescripcion.getText());
        frmDesempeñoInfo.setVisible(true);
        frmDesempeñoInfo.setLocationRelativeTo(null);
    }
    
    public void buscarAudio(){
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.showOpenDialog(null);
        namepathNuevo = fileChooser.getSelectedFile();
        if(namepathNuevo!=null){
        frmPreguntaAuditiva.txtAudio.setText(namepathNuevo.getAbsolutePath());}
        estadoChooser = true;
    }
    
    public void cargarPeriodos(){
        if(listaPeriodo!=null)listaPeriodo.clear(); 
        frmPreguntaAuditiva.txtPeriodo.removeAllItems();/*limpiamos combo*/
        listaPeriodo = periodoDao.Read();
        for(int i=0;i<listaPeriodo.size();i++){/*cargamos periodos en el combo*/
            frmPreguntaAuditiva.txtPeriodo.addItem(listaPeriodo.get(i).getPeriodo());
        }
    }
    
    public void getDocenteAula(){
        dniDocente = persona.get(0);
        if(listaDocente!=null)listaDocente.clear(); 
        listaDocente = docenteAulaDao.docentesConAula();
        for (int i = 0; i < listaDocente.size(); i++) {
            if(listaDocente.get(i).get(0).equals(dniDocente)){
                idDocenteAula = Integer.parseInt(listaDocente.get(i).get(5));break;
            }
        }
    }
    
    public void cargarNiveles(){
        if(listaNivel!=null)listaNivel.clear(); 
        frmPreguntaAuditiva.txtNivel.removeAllItems();/*limpiamos combo*/
        listaNivel=nivelDao.Read();
        for(int i=0;i<listaNivel.size();i++){/*cargamos niveles en el combo*/
            frmPreguntaAuditiva.txtNivel.addItem(listaNivel.get(i).getNivel());
        }
    }
    
    public void cargarEstilos(){
        if(listaEstilo!=null)listaEstilo.clear(); 
        frmPreguntaAuditiva.txtEstilo.setText("");/*limpiamos textfield*/
        listaEstilo=estiloDao.Read();
        for(int i=0;i<listaEstilo.size();i++){
            if(listaEstilo.get(i).getEstilo().equals("Auditiva")){
                frmPreguntaAuditiva.txtEstilo.setText(listaEstilo.get(i).getEstilo());
                break;
            }
        }
    }
    
    public void cargarDesempeños(){
        if(listaDesempeño!=null)listaDesempeño.clear(); 
        listaDesempeño = desempeñoDao.Read();
    }
    
    public void cargarMatriz(){
        if(listaMatriz!=null)listaMatriz.clear(); 
        listaMatriz = matrizDao.Read();
    }
    
    public void cargarAudios(){
        if(listaAudio!=null)listaAudio.clear(); 
        listaAudio = audioDao.Read();
    }
    
    public void cargarAlternativas(){
        if(listaAlternativa!=null)listaAlternativa.clear();
        listaAlternativa = alternativaDao.Read();
    }
    
    public void cargarPreguntas(){//preguntas registradas segun el docente en el año actual
        int cantidadPreguntas = 0;
        listaPregunta = preguntaDao.preguntaEstiloRead(frmPreguntaAuditiva.txtEstilo.getText(),idDocenteAula);
        if(listaPregunta.size() > 0){
            //add column to table
            model.addColumn("DESCRIPCION");
            model.addColumn("DESCUIDO");
            model.addColumn("ADIVINANZA");
            model.addColumn("NIVEL");
            model.addColumn("ESTILO");
            model.addColumn("DESEMPEÑO");
            model.addColumn("PERIODO");
            //add rowTable to table
            for (int i = 0; i < listaPregunta.size(); i++) {
                rowTable[0] = listaPregunta.get(i).getDescripcion();
                rowTable[1] = (double)Math.round(listaPregunta.get(i).getDescuido() * 10000d) / 10000d;
                rowTable[2] = (double)Math.round(listaPregunta.get(i).getAdivinanza() * 10000d) / 10000d;
                //nivel
                for (int j = 0; j < listaNivel.size(); j++) {
                    if(listaPregunta.get(i).getIdNivel() == listaNivel.get(j).getIdNivel()){
                        rowTable[3] = listaNivel.get(j).getNivel();
                    }
                }
                //estilo
                for (int j = 0; j < listaEstilo.size(); j++) {
                    if(listaPregunta.get(i).getIdEstilo() == listaEstilo.get(j).getIdEstilo()){
                        rowTable[4] = listaEstilo.get(j).getEstilo();
                    }
                }
                //desempeño
                for (int j = 0; j < listaMatriz.size(); j++) {
                    if(listaPregunta.get(i).getIdMatriz() == listaMatriz.get(j).getIdMatriz()){
                        for (int k = 0; k < listaDesempeño.size(); k++) {
                            if(listaMatriz.get(j).getIdDesempeño() == listaDesempeño.get(k).getIdDesempeño()){
                                rowTable[5] = listaDesempeño.get(k).getDesempeño();break;   
                            }
                        }
                    }
                }
                //periodo
                for (int j = 0; j < listaPeriodo.size(); j++) {
                    if(listaPregunta.get(i).getIdPeriodo() == listaPeriodo.get(j).getIdPeriodo()){
                        rowTable[6] = listaPeriodo.get(j).getPeriodo();break;  
                    }
                }
                model.addRow(rowTable);
                cantidadPreguntas+=1;
            }
        }
        frmPreguntaAuditiva.table.setModel(model);
        frmPreguntaAuditiva.txtTotalPreguntas.setText("CANTIDAD:  "+cantidadPreguntas);
    }
    
    public static double getRandom(Double valorMinimo, Double valorMaximo) {
        Random rand = new Random();
        return  valorMinimo + ( valorMaximo - valorMinimo ) * rand.nextDouble();
    }
    
    public void guardarAudio(){
        try {
            if(!(urlImagenDestino+nombreOGG).equals(namepathNuevo.getAbsolutePath())){
                InputStream inStream = null;
                OutputStream outStream = null;
                File afile = new File(namepathNuevo.getAbsolutePath());
                File bfile = new File(urlImagenDestino+nombreOGG);
                inStream = new FileInputStream(afile);
                outStream = new FileOutputStream(bfile);
                bfile.delete();//eliminamos el audio que existe
                byte[] buffer = new byte[1024];
                int length;
                //copy the file content in bytes 
                while ((length = inStream.read(buffer)) > 0) {
                    outStream.write(buffer, 0, length);
                }
                inStream.close();
                outStream.close();
            }
        } catch(IOException e) {}
    }
}