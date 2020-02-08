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
import pattern.dao.DocenteAulaDao;
import pattern.dao.EstiloDao;
import pattern.dao.ImagenDao;
import pattern.dao.DesempeñoDao;
import pattern.dao.MatrizDao;
import pattern.dao.NivelDao;
import pattern.dao.PeriodoDao;
import pattern.dao.PreguntaDao;
import pattern.model.Alternativa;
import pattern.model.Estilo;
import pattern.model.Imagen;
import pattern.model.Desempeño;
import pattern.model.Matriz;
import pattern.model.Nivel;
import pattern.model.Periodo;
import pattern.model.Pregunta;
import pattern.view.FrmDesempeñoBusqueda;
import pattern.view.FrmDesempeñoInfo;
import pattern.view.FrmPreguntaVisual;

public class FrmPreguntaVisualController extends KeyAdapter implements IView,ICrudView,ItemListener,ListSelectionListener{
    //model
    private Pregunta preguntaNuevo,preguntaActual;
    private Alternativa primeraAlternativaNuevo,primeraAlternativaActual,segundaAlternativaNuevo,segundaAlternativaActual,terceraAlternativaNuevo,terceraAlternativaActual;
    private Imagen imagenNuevo,imagenActual;
    //view
    private final FrmPreguntaVisual frmPreguntaVisual;
    private final FrmDesempeñoBusqueda frmDesempeñoBusqueda;
    private final FrmDesempeñoInfo frmDesempeñoInfo;
    //controller
    private final FrmPrincipalController frmPrincipalController;
    private final FrmDesempeñoBusquedaController frmDesempeñoBusquedaController;
    private final FrmDesempeñoInfoController frmDesempeñoInfoController;
    //dao
    private final PreguntaDao preguntaDao;
    private final AlternativaDao alternativaDao;
    private final ImagenDao imagenDao;
    private final EstiloDao estiloDao;
    private final NivelDao nivelDao;
    private final DesempeñoDao desempeñoDao;
    private final MatrizDao matrizDao;
    private final PeriodoDao periodoDao;
    private final DocenteAulaDao docenteAulaDao;
    //variables
    private int row;
    private List<Pregunta> listaPregunta;
    private List<Imagen> listaImagen;
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
    private final FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG", "png");
    private File namepathNuevo,namepathActual;
    private double descuido,descuido_redondeado,adivinanza,adivinanza_redondeado;
    private String txtDescripcion;
    private double txtDescuido,txtAdivinanza;
    private String txtPeriodo,txtNivel,txtEstilo;
    private int idNivel,idEstilo,idMatriz,idPeriodo, idDocenteAula;
    private boolean successA = false, successB = false, successC = false;
    private final String urlImagenDestino = "C:\\wamp64\\www\\Nimodo\\NimodoStudent\\pdo\\images\\";
    private String nombrePNG;
    private final Object [] rowTable = new Object[7];
    private int aux;
    private boolean estadoChooser = false;
    private final List<String> persona;
    private String dniDocente;
    
    public FrmPreguntaVisualController(FrmPreguntaVisual frmPreguntaVisual,FrmPrincipalController frmPrincipalController,List<String> persona) {
        this.frmPreguntaVisual = frmPreguntaVisual;
        this.preguntaDao = new PreguntaDao();
        this.alternativaDao = new AlternativaDao();
        this.imagenDao = new ImagenDao();
        this.estiloDao = new EstiloDao();
        this.nivelDao = new NivelDao();
        this.desempeñoDao = new DesempeñoDao();
        this.matrizDao = new MatrizDao();
        this.periodoDao = new PeriodoDao();
        this.docenteAulaDao = new DocenteAulaDao();
        this.frmPrincipalController = frmPrincipalController;
        this.persona = persona;
        this.frmDesempeñoBusqueda = new FrmDesempeñoBusqueda(this.frmPrincipalController.frmPrincipal, true);
        this.frmDesempeñoBusquedaController = new FrmDesempeñoBusquedaController(frmDesempeñoBusqueda,this.frmPreguntaVisual,this.persona);
        this.frmDesempeñoInfo = new FrmDesempeñoInfo(this.frmPrincipalController.frmPrincipal, true);
        this.frmDesempeñoInfoController = new FrmDesempeñoInfoController(frmDesempeñoInfo);
        this.listaAlternativaNuevo = new ArrayList<>();
        this.listaAternativaActual = new ArrayList<>();
    }
    
    @Override
    public void initController() {
        frmDesempeñoBusquedaController.initController();
        frmPreguntaVisual.btnCreate.addActionListener(e -> Create());
        frmPreguntaVisual.btnUpdate.addActionListener(e -> Update());
        frmPreguntaVisual.btnDelete.addActionListener(e -> Delete());
        frmPreguntaVisual.btnNew.addActionListener(e -> Clear());
        frmPreguntaVisual.btnBuscarDesempenio.addActionListener(e-> buscarDesempeño());
        frmPreguntaVisual.btnDesempenioInfo.addActionListener(e-> verDetalleDesempeño());
        frmPreguntaVisual.btnBuscarImagen.addActionListener(e-> buscarImagen());
        frmPreguntaVisual.table.getSelectionModel().addListSelectionListener(this);
        frmPreguntaVisual.txtBuscar.addKeyListener(this);
        frmPreguntaVisual.txtNivel.addItemListener(this);
        frmPreguntaVisual.successA.addItemListener(this);
        frmPreguntaVisual.successB.addItemListener(this);
        frmPreguntaVisual.successC.addItemListener(this);
        //hide idMatriz
        frmPreguntaVisual.idMatriz.setVisible(false);
        frmPreguntaVisual.txtDesempeñoDescripcion.setVisible(false);
    }

    @Override  public void refreshView(){Clear();}
    
    @Override
    public void Create() {
        if(frmPreguntaVisual.txtPeriodo.getItemCount() > 0 && !frmPreguntaVisual.txtDescripcion.getText().isEmpty() &&
           !frmPreguntaVisual.txtDescuido.getText().isEmpty() && !frmPreguntaVisual.txtAdivinanza.getText().isEmpty() &&
            frmPreguntaVisual.txtNivel.getItemCount() > 0 && !frmPreguntaVisual.txtEstilo.getText().isEmpty() &&
           !frmPreguntaVisual.txtDesempenio.getText().isEmpty() /*&& !frmPreguntaVisual.txtImagen.getText().isEmpty()*/ && !frmPreguntaVisual.txtPrimeraAlternativa.getText().isEmpty() &&
           !frmPreguntaVisual.txtSegundaAlternativa.getText().isEmpty() && !frmPreguntaVisual.txtTerceraAlternativa.getText().isEmpty()){
            //recuperamos datos
            txtDescripcion = frmPreguntaVisual.txtDescripcion.getText();
            txtDescuido = Double.parseDouble(frmPreguntaVisual.txtDescuido.getText());
            txtAdivinanza = Double.parseDouble(frmPreguntaVisual.txtAdivinanza.getText());
            txtNivel = frmPreguntaVisual.txtNivel.getSelectedItem().toString();
            txtEstilo = frmPreguntaVisual.txtEstilo.getText();
            txtPeriodo = frmPreguntaVisual.txtPeriodo.getSelectedItem().toString();
            //idNivel
            for (int i = 0; i < listaNivel.size(); i++) {
                if(listaNivel.get(i).getNivel().equals(txtNivel))idNivel = listaNivel.get(i).getIdNivel();
            }
            //idEstilo
            for (int i = 0; i < listaEstilo.size(); i++) {
                if(listaEstilo.get(i).getEstilo().equals(txtEstilo))idEstilo = listaEstilo.get(i).getIdEstilo();
            }
            
            //idMatriz
            idMatriz = Integer.parseInt(frmPreguntaVisual.idMatriz.getText());
            
            //idperiodo
            for (int i = 0; i < listaPeriodo.size(); i++) {
                if(listaPeriodo.get(i).getPeriodo().equals(txtPeriodo))idPeriodo = listaPeriodo.get(i).getIdPeriodo();
            }
            
            if(frmPreguntaVisual.successA.isSelected() || frmPreguntaVisual.successB.isSelected() || frmPreguntaVisual.successC.isSelected()){
                //creamos objeto pregunta
                preguntaNuevo = new Pregunta(0, txtDescripcion, txtDescuido, txtAdivinanza, idNivel, idEstilo, idMatriz, idPeriodo, idDocenteAula);
                if(preguntaDao.Create(preguntaNuevo)){
                    if(frmPreguntaVisual.successA.isSelected())successA = true;
                    if(frmPreguntaVisual.successB.isSelected())successB = true;
                    if(frmPreguntaVisual.successC.isSelected())successC = true;
                    //creamos alternativa
                    primeraAlternativaNuevo = new Alternativa(0, frmPreguntaVisual.txtPrimeraAlternativa.getText(), successA, preguntaDao.getIdPregunta());
                    segundaAlternativaNuevo = new Alternativa(0, frmPreguntaVisual.txtSegundaAlternativa.getText(), successB, preguntaDao.getIdPregunta());
                    terceraAlternativaNuevo = new Alternativa(0, frmPreguntaVisual.txtTerceraAlternativa.getText(), successC, preguntaDao.getIdPregunta());
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
                    //imagen
                    if(!frmPreguntaVisual.txtImagen.getText().isEmpty()){
                        //nombre del png
                        nombrePNG = preguntaDao.getIdPregunta()+".png";
                        //creamos imagen
                        imagenNuevo = new Imagen(0,urlImagenDestino+nombrePNG, preguntaDao.getIdPregunta());
                        guardarImagen();//guardamos png en el directorio
                        if(imagenDao.Create(imagenNuevo)){JOptionPane.showMessageDialog(null,"Registro exitoso!"); refreshView();}
                    }else{
                        JOptionPane.showMessageDialog(null,"Registro exitoso!"); refreshView();
                    }
                    /*//nombre del png
                    nombrePNG = preguntaDao.getIdPregunta()+".png";
                    //creamos imagen
                    imagenNuevo = new Imagen(0,urlImagenDestino+nombrePNG, preguntaDao.getIdPregunta());
                    guardarImagen();//guardamos png en el directorio
                    if(imagenDao.Create(imagenNuevo)){JOptionPane.showMessageDialog(null,"Registro exitoso!"); refreshView();}*/
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
        cargarImagenes();
        cargarAlternativas();
        cargarPreguntas();
    }

    @Override
    public void Update() {
        if(!frmPreguntaVisual.table.getSelectionModel().isSelectionEmpty()){
            if(frmPreguntaVisual.txtPeriodo.getItemCount() > 0 && !frmPreguntaVisual.txtDescripcion.getText().isEmpty() && /*!frmPreguntaVisual.txtApriori.getText().isEmpty() && */
               !frmPreguntaVisual.txtDescuido.getText().isEmpty() && !frmPreguntaVisual.txtAdivinanza.getText().isEmpty() &&
                frmPreguntaVisual.txtNivel.getItemCount() > 0 && !frmPreguntaVisual.txtEstilo.getText().isEmpty() &&
               !frmPreguntaVisual.txtDesempenio.getText().isEmpty() /*&& !frmPreguntaVisual.txtImagen.getText().isEmpty()*/ && !frmPreguntaVisual.txtPrimeraAlternativa.getText().isEmpty() &&
               !frmPreguntaVisual.txtSegundaAlternativa.getText().isEmpty() && !frmPreguntaVisual.txtTerceraAlternativa.getText().isEmpty()){
                //PREGUNTA ACTUAL
                preguntaActual = new Pregunta();
                for (int i = 0; i < listaPregunta.size(); i++) {
                    if(listaPregunta.get(i).getDescripcion().equals(frmPreguntaVisual.table.getValueAt(row, 0).toString())){
                        preguntaActual.setIdPregunta(listaPregunta.get(i).getIdPregunta());//primary key
                    }
                }
                //PREGUNTA NUEVO
                txtDescripcion = frmPreguntaVisual.txtDescripcion.getText();
                txtDescuido = Double.parseDouble(frmPreguntaVisual.txtDescuido.getText());
                txtAdivinanza = Double.parseDouble(frmPreguntaVisual.txtAdivinanza.getText());
                txtNivel = frmPreguntaVisual.txtNivel.getSelectedItem().toString();
                txtEstilo = frmPreguntaVisual.txtEstilo.getText();
                txtPeriodo = frmPreguntaVisual.txtPeriodo.getSelectedItem().toString();
                //idNivel
                for (int i = 0; i < listaNivel.size(); i++) {
                    if(listaNivel.get(i).getNivel().equals(txtNivel))idNivel = listaNivel.get(i).getIdNivel();
                }
                //idEstilo
                for (int i = 0; i < listaEstilo.size(); i++) {
                    if(listaEstilo.get(i).getEstilo().equals(txtEstilo))idEstilo = listaEstilo.get(i).getIdEstilo();
                }
                //idMatriz
                idMatriz = Integer.parseInt(frmPreguntaVisual.idMatriz.getText());

                //idperiodo
                for (int i = 0; i < listaPeriodo.size(); i++) {
                    if(listaPeriodo.get(i).getPeriodo().equals(txtPeriodo))idPeriodo = listaPeriodo.get(i).getIdPeriodo();
                }

                if(frmPreguntaVisual.successA.isSelected() || frmPreguntaVisual.successB.isSelected() || frmPreguntaVisual.successC.isSelected()){
                    //creamos objeto pregunta
                    preguntaNuevo = new Pregunta(0, txtDescripcion, txtDescuido, txtAdivinanza, idNivel, idEstilo, idMatriz, idPeriodo, idDocenteAula);
                    if(preguntaDao.Update(preguntaActual,preguntaNuevo)){
                        if(frmPreguntaVisual.successA.isSelected())successA = true;
                        if(frmPreguntaVisual.successB.isSelected())successB = true;
                        if(frmPreguntaVisual.successC.isSelected())successC = true;
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
                        primeraAlternativaNuevo = new Alternativa(0, frmPreguntaVisual.txtPrimeraAlternativa.getText(), successA, preguntaActual.getIdPregunta());
                        segundaAlternativaNuevo = new Alternativa(0, frmPreguntaVisual.txtSegundaAlternativa.getText(), successB, preguntaActual.getIdPregunta());
                        terceraAlternativaNuevo = new Alternativa(0, frmPreguntaVisual.txtTerceraAlternativa.getText(), successC, preguntaActual.getIdPregunta());
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
                        //IMAGEN ACTUAL
                        imagenActual = new Imagen();
                        for (int i = 0; i < listaImagen.size() ; i++) {//path imagen
                            if(preguntaActual.getIdPregunta() == listaImagen.get(i).getIdPregunta()){
                                imagenActual.setImagen(listaImagen.get(i).getImagen());
                            }
                        }
                        //imagen
                        if(imagenActual.getImagen()!=null){
                            //nombre del png
                            nombrePNG = preguntaActual.getIdPregunta()+".png";
                            namepathActual = new File(imagenActual.getImagen());
                            //IMAGEN NUEVO
                            namepathNuevo = fileChooser.getSelectedFile();
                            if(estadoChooser){
                            namepathNuevo = fileChooser.getSelectedFile();//si selecciona el chooser 
                            }else{
                            namepathNuevo = namepathActual; // si no selecciona el chooser   
                            }
                            estadoChooser = false;
                            guardarImagen();
                            ////reseteamos valores
                            JOptionPane.showMessageDialog(null,"Actualización exitosa!");
                            refreshView();    
                        }else{
                            if(!frmPreguntaVisual.txtImagen.getText().isEmpty()){
                                //nombre del png
                                nombrePNG = preguntaActual.getIdPregunta()+".png";
                                //creamos imagen
                                imagenNuevo = new Imagen(0,urlImagenDestino+nombrePNG, preguntaActual.getIdPregunta());
                                guardarImagen();//guardamos png en el directorio
                                if(imagenDao.Create(imagenNuevo)){JOptionPane.showMessageDialog(null,"Actualización exitosa!"); refreshView();}    
                            }else{
                                estadoChooser = false;
                                System.out.println("la pregunta sigue sin tener imagen");
                                JOptionPane.showMessageDialog(null,"Actualización exitosa!");
                                refreshView();
                            }
                        }
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
        if(!frmPreguntaVisual.table.getSelectionModel().isSelectionEmpty()){
            int confirmado = JOptionPane.showConfirmDialog(null,"¿Seguro que desea eliminar la pregunta?");
            if (JOptionPane.OK_OPTION == confirmado){
                //actual
                preguntaActual = new Pregunta();
                for (int i = 0; i < listaPregunta.size(); i++) {
                    if(listaPregunta.get(i).getDescripcion().equals(frmPreguntaVisual.table.getValueAt(row,0).toString()))
                        preguntaActual.setIdPregunta(listaPregunta.get(i).getIdPregunta());//primary key
                }
                if(preguntaDao.Delete(preguntaActual)){
                    //IMAGEN ACTUAL
                    imagenActual = new Imagen();
                    for (int i = 0; i < listaImagen.size() ; i++) {//path imagen
                        if(preguntaActual.getIdPregunta() == listaImagen.get(i).getIdPregunta()){
                            imagenActual.setImagen(listaImagen.get(i).getImagen());
                        }
                    }
                    if(imagenActual.getImagen()!=null){
                        namepathActual = new File(imagenActual.getImagen());
                        namepathActual.delete();
                    }
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
        frmPreguntaVisual.txtDescripcion.setText("");
        frmPreguntaVisual.txtEstilo.setText("");
        frmPreguntaVisual.txtDesempenio.setText("");
        frmPreguntaVisual.txtDesempeñoDescripcion.setText("");
        frmPreguntaVisual.txtImagen.setText("");
        frmPreguntaVisual.txtDescuido.setText("");
        frmPreguntaVisual.txtAdivinanza.setText("");
        frmPreguntaVisual.txtPrimeraAlternativa.setText("");
        frmPreguntaVisual.txtSegundaAlternativa.setText("");
        frmPreguntaVisual.txtTerceraAlternativa.setText("");
        frmPreguntaVisual.txtBuscar.setText("");
        frmPreguntaVisual.successA.setSelected(false);
        frmPreguntaVisual.successB.setSelected(false);
        frmPreguntaVisual.successC.setSelected(false);
        frmPreguntaVisual.btnCreate.setEnabled(true);
        frmPreguntaVisual.table.setRowSorter(null);//clear filter
        model=new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
        Read();
    }
    
    @Override 
    public void keyReleased(KeyEvent e) {
        DefaultTableModel dm=(DefaultTableModel) frmPreguntaVisual.table.getModel();
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<>(dm);
        frmPreguntaVisual.table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(frmPreguntaVisual.txtBuscar.getText()));
        frmPreguntaVisual.btnCreate.setEnabled(true);
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource().equals(frmPreguntaVisual.txtNivel) ){
            if (e.getStateChange() == ItemEvent.SELECTED){
                if(frmPreguntaVisual.txtNivel.getSelectedItem().toString().equals("En Inicio")){
                    descuido = 0.1;
                }
                if(frmPreguntaVisual.txtNivel.getSelectedItem().toString().equals("En Proceso")){
                    descuido = 0.15;
                }
                if(frmPreguntaVisual.txtNivel.getSelectedItem().toString().equals("Satisfactorio")){
                    descuido = 0.2;
                }
                //redondeamos aleatorios
                descuido_redondeado = (double)Math.round(descuido * 10000d) / 10000d;
                
                //adivinanza
                adivinanza = 1.0/3.0;//1 de 3 porque se va a tener 3 alternativas por pregunta y solo 1 es correcta.
                //adivinanza_redondeada
                adivinanza_redondeado = (double)Math.round(adivinanza * 10000d) / 10000d;
                //seteamos valores
                frmPreguntaVisual.txtDescuido.setText(""+descuido_redondeado);
                frmPreguntaVisual.txtAdivinanza.setText(""+adivinanza_redondeado);
            }
        }
        
        if(e.getSource().equals(frmPreguntaVisual.successA) ){
            if (e.getStateChange() == ItemEvent.SELECTED){
                frmPreguntaVisual.successB.setSelected(false);
                frmPreguntaVisual.successC.setSelected(false);
            }
        }
        if(e.getSource().equals(frmPreguntaVisual.successB) ){
            if (e.getStateChange() == ItemEvent.SELECTED){
                frmPreguntaVisual.successA.setSelected(false);
                frmPreguntaVisual.successC.setSelected(false);
            }
        }
        if(e.getSource().equals(frmPreguntaVisual.successC) ){
            if (e.getStateChange() == ItemEvent.SELECTED){
                frmPreguntaVisual.successA.setSelected(false);
                frmPreguntaVisual.successB.setSelected(false);
            }
        }
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()){
            if (frmPreguntaVisual.table.getSelectedRow() != -1) {
                frmPreguntaVisual.txtImagen.setText("");
                row = frmPreguntaVisual.table.getSelectedRow();
                frmPreguntaVisual.txtPeriodo.setSelectedItem(frmPreguntaVisual.table.getValueAt(row,6).toString());
                frmPreguntaVisual.txtDescripcion.setText(frmPreguntaVisual.table.getValueAt(row,0).toString());
                frmPreguntaVisual.txtEstilo.setText(frmPreguntaVisual.table.getValueAt(row,4).toString());
                frmPreguntaVisual.txtNivel.setSelectedItem(frmPreguntaVisual.table.getValueAt(row,3).toString());
                frmPreguntaVisual.txtDesempenio.setText(frmPreguntaVisual.table.getValueAt(row,5).toString());
                frmPreguntaVisual.txtDescuido.setText(frmPreguntaVisual.table.getValueAt(row, 1).toString());
                frmPreguntaVisual.txtAdivinanza.setText(frmPreguntaVisual.table.getValueAt(row, 2).toString());
                frmPreguntaVisual.btnCreate.setEnabled(false);
                for (int i = 0; i < listaDesempeño.size(); i++) {//desempeño descripcion
                    if(listaDesempeño.get(i).getDesempeño().equals(frmPreguntaVisual.txtDesempenio.getText())){
                        frmPreguntaVisual.txtDesempeñoDescripcion.setText(listaDesempeño.get(i).getDescripcion());break;
                    }
                }
                for (int i = 0; i < listaPregunta.size(); i++) {//recorremos todas las preguntas visuales
                    if(frmPreguntaVisual.txtDescripcion.getText().equals(listaPregunta.get(i).getDescripcion())){
                        for (int j = 0; j < listaImagen.size() ; j++) {//path audio
                            if(listaPregunta.get(i).getIdPregunta() == listaImagen.get(j).getIdPregunta()){
                                frmPreguntaVisual.txtImagen.setText(listaImagen.get(j).getImagen());
                            }
                        }
                        aux =0;//reseteamos auxiliar
                        for (int j = 0; j < listaAlternativa.size(); j++) {//alternativas
                            if(listaPregunta.get(i).getIdPregunta() == listaAlternativa.get(j).getIdPregunta()){
                                if(aux == 0){
                                    frmPreguntaVisual.txtPrimeraAlternativa.setText(listaAlternativa.get(j).getDescripcion());
                                    frmPreguntaVisual.successA.setSelected(listaAlternativa.get(j).isSuccess());
                                }
                                if(aux == 1){
                                    frmPreguntaVisual.txtSegundaAlternativa.setText(listaAlternativa.get(j).getDescripcion());
                                    frmPreguntaVisual.successB.setSelected(listaAlternativa.get(j).isSuccess());
                                }
                                if(aux == 2){
                                    frmPreguntaVisual.txtTerceraAlternativa.setText(listaAlternativa.get(j).getDescripcion());
                                    frmPreguntaVisual.successC.setSelected(listaAlternativa.get(j).isSuccess());
                                }
                                aux+=1;
                            }
                        }
                        //idMatriz
                        for (int j = 0; j < listaMatriz.size(); j++) {
                            if(listaPregunta.get(i).getIdMatriz() == listaMatriz.get(j).getIdMatriz()){
                                frmPreguntaVisual.idMatriz.setText(""+listaMatriz.get(j).getIdMatriz());
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
        frmDesempeñoInfoController.sendInfo(frmPreguntaVisual.txtDesempeñoDescripcion.getText());
        frmDesempeñoInfo.setVisible(true);
        frmDesempeñoInfo.setLocationRelativeTo(null);
    }
    
    public void buscarImagen(){
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.showOpenDialog(null);
        namepathNuevo = fileChooser.getSelectedFile();
        if(namepathNuevo!=null){
        frmPreguntaVisual.txtImagen.setText(namepathNuevo.getAbsolutePath());}
        estadoChooser = true;
    }
    
    public void cargarPeriodos(){
        if(listaPeriodo!=null)listaPeriodo.clear(); 
        frmPreguntaVisual.txtPeriodo.removeAllItems();/*limpiamos combo*/
        listaPeriodo = periodoDao.Read();
        for(int i=0;i<listaPeriodo.size();i++){/*cargamos periodos en el combo*/
            frmPreguntaVisual.txtPeriodo.addItem(listaPeriodo.get(i).getPeriodo());
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
        frmPreguntaVisual.txtNivel.removeAllItems();/*limpiamos combo*/
        listaNivel=nivelDao.Read();
        for(int i=0;i<listaNivel.size();i++){/*cargamos niveles en el combo*/
            frmPreguntaVisual.txtNivel.addItem(listaNivel.get(i).getNivel());
        }
    }
    
    public void cargarEstilos(){
        if(listaEstilo!=null)listaEstilo.clear(); 
        frmPreguntaVisual.txtEstilo.setText("");/*limpiamos textfield*/
        listaEstilo=estiloDao.Read();
        for(int i=0;i<listaEstilo.size();i++){
            if(listaEstilo.get(i).getEstilo().equals("Visual")){
                frmPreguntaVisual.txtEstilo.setText(listaEstilo.get(i).getEstilo());
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
    
    public void cargarImagenes(){
        if(listaImagen!=null)listaImagen.clear(); 
        listaImagen = imagenDao.Read();
    }
    
    public void cargarAlternativas(){
        if(listaAlternativa!=null)listaAlternativa.clear();
        listaAlternativa = alternativaDao.Read();
    }
    
    public void cargarPreguntas(){//preguntas registradas segun el docente en el año actual
        int cantidadPreguntas = 0;
        listaPregunta = preguntaDao.preguntaEstiloRead(frmPreguntaVisual.txtEstilo.getText(),idDocenteAula);
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
        frmPreguntaVisual.table.setModel(model);
        frmPreguntaVisual.txtTotalPreguntas.setText("CANTIDAD:  "+cantidadPreguntas);
    }
    
    public static double getRandom(Double valorMinimo, Double valorMaximo) {
        Random rand = new Random();
        return  valorMinimo + ( valorMaximo - valorMinimo ) * rand.nextDouble();
    }
    
    public void guardarImagen(){
        try {
            if(!(urlImagenDestino+nombrePNG).equals(namepathNuevo.getAbsolutePath())){
                InputStream inStream = null;
                OutputStream outStream = null;
                File afile = new File(namepathNuevo.getAbsolutePath());
                File bfile = new File(urlImagenDestino+nombrePNG);
                inStream = new FileInputStream(afile);
                outStream = new FileOutputStream(bfile);
                bfile.delete();//eliminamos la imagen que existe
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