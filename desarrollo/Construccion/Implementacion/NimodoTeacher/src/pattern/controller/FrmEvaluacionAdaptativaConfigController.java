package pattern.controller;

import interfaces.ICrudView;
import interfaces.IView;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import pattern.dao.CompetenciaDao;
import pattern.dao.DocenteAulaDao;
import pattern.dao.EstiloDao;
import pattern.dao.EvaluacionAdaptativaConfigDao;
import pattern.dao.MatrizDao;
import pattern.dao.NivelDao;
import pattern.dao.PeriodoDao;
import pattern.model.Area;
import pattern.model.CheckBoxNode;
import pattern.model.Competencia;
import pattern.model.Estilo;
import pattern.model.Nivel;
import pattern.model.Periodo;
import pattern.model.Pregunta;
import pattern.view.FrmEvaluacionAdaptativaConfig;

public class FrmEvaluacionAdaptativaConfigController  implements IView,ICrudView,ItemListener{
    //view
    private final FrmEvaluacionAdaptativaConfig frmEvaluacionAdaptativaConfig;
    //dao
    private final MatrizDao matrizDao;
    private final CompetenciaDao competenciaDao;
    private final PeriodoDao periodoDao;
    private final NivelDao nivelDao;
    private final EstiloDao estiloDao;
    private final EvaluacionAdaptativaConfigDao evaluacionAdaptativaConfigDao;
    private final DocenteAulaDao docenteAulaDao;
    //variables
    private List<Area> listaArea;
    private List<Competencia> listaCompetencias;
    private List<Periodo> listaPeriodo;
    private List<Pregunta> listaPregunta;
    private List<Estilo> listaEstilo;
    private List<Nivel> listaNivel;
    private final List<String> persona;
    private List<List<String>> listaDocente;
    private String periodo,competencia,dniDocente;
    private int idDocenteAula;
    private final DefaultMutableTreeNode root;
    private DefaultMutableTreeNode nodeArea,nodeCompetencia,nodePeriodo;
    private final FrmEvaluacionAdaptativaConfigRender renderer;
    private DefaultTableModel model;
    private final Object [] rowTable = new Object[5];
    private List<Boolean> estadoBimestre;
    private int tiempo;
    private final ImageIcon areaIcon =new ImageIcon(FrmEvaluacionAdaptativaConfigController.class.getResource("/images/area.png"));
    private final ImageIcon competenciaIcon =new ImageIcon(FrmEvaluacionAdaptativaConfigController.class.getResource("/images/competencia.png"));
    private final ImageIcon periodoIcon =new ImageIcon(FrmEvaluacionAdaptativaConfigController.class.getResource("/images/periodo.png"));
    
    public FrmEvaluacionAdaptativaConfigController(FrmEvaluacionAdaptativaConfig frmEvaluacionAdaptativaConfig,List<String> persona) {
        this.frmEvaluacionAdaptativaConfig = frmEvaluacionAdaptativaConfig;
        this.matrizDao = new MatrizDao();
        this.competenciaDao = new CompetenciaDao();
        this.periodoDao = new PeriodoDao();
        this.nivelDao = new NivelDao();
        this.estiloDao = new EstiloDao();
        this.evaluacionAdaptativaConfigDao = new EvaluacionAdaptativaConfigDao();
        this.docenteAulaDao = new DocenteAulaDao();
        this.persona = persona;
        this.renderer = new FrmEvaluacionAdaptativaConfigRender();
        this.root = new DefaultMutableTreeNode("Areas");
    }
    
    @Override
    public void initController() {
        frmEvaluacionAdaptativaConfig.txtArea.addItemListener(this);
        frmEvaluacionAdaptativaConfig.txtCompetencia.addItemListener(this);
        frmEvaluacionAdaptativaConfig.btnMostrar.addActionListener(e->getPreguntas());
        frmEvaluacionAdaptativaConfig.btnCreate.addActionListener(e -> Update());
        frmEvaluacionAdaptativaConfig.btnCreateTiempo.addActionListener(e -> configTiempo());
    }

    @Override
    public void refreshView(){Clear();}
    
    @Override
    public void Read(){
        getDocenteAula();
        getAreas();
        getNiveles();
        getEstilos();
    }
    @Override
    public void Update() {
        getAllCompetencias();//consultamos todas las competencias
        for (int i = 0; i < root.getChildCount(); i++) {
            Object node = frmEvaluacionAdaptativaConfig.jtreeArea.getModel().getChild(root, i);
            DefaultMutableTreeNode areaNode = (DefaultMutableTreeNode) node;
            CheckBoxNode area =(CheckBoxNode) areaNode.getUserObject();
            for (int j = 0; j < areaNode.getChildCount(); j++) {
                Object node1 = frmEvaluacionAdaptativaConfig.jtreeArea.getModel().getChild(areaNode, j);
                DefaultMutableTreeNode competenciaNode = (DefaultMutableTreeNode) node1;
                CheckBoxNode _competencia =(CheckBoxNode) competenciaNode.getUserObject();
                estadoBimestre.clear();//reseteamos
                for (int k = 0; k < competenciaNode.getChildCount(); k++) {
                    Object node2 = frmEvaluacionAdaptativaConfig.jtreeArea.getModel().getChild(competenciaNode, k);
                    DefaultMutableTreeNode periodoNode = (DefaultMutableTreeNode) node2;
                    CheckBoxNode _periodo =(CheckBoxNode) periodoNode.getUserObject();
                    estadoBimestre.add(_periodo.isCheckNode());
                }
                for (int k = 0; k < listaCompetencias.size(); k++) {
                    if(_competencia.getNameNode().equals(listaCompetencias.get(k).getCompetencia())){
                        matrizDao.getMatrizCompetenciaBimestreUpdate(listaCompetencias.get(k).getIdCompetencia(), idDocenteAula, estadoBimestre.get(0), estadoBimestre.get(1), estadoBimestre.get(2), estadoBimestre.get(3));
                        break;
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null,"Datos actualizados!");
        frmEvaluacionAdaptativaConfig.dispose();
    }

    @Override public void Create() {}

    @Override public void Delete() {}

    @Override
    public void Clear() {
        frmEvaluacionAdaptativaConfig.txtTotalPreguntas.setText("");
        frmEvaluacionAdaptativaConfig.table.setRowSorter(null);//clear filter
        model=new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
        frmEvaluacionAdaptativaConfig.table.setModel(model);//seteamos model*/
        Read();
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource().equals(frmEvaluacionAdaptativaConfig.txtArea) ){
            if (e.getStateChange() == ItemEvent.SELECTED){
                frmEvaluacionAdaptativaConfig.txtPeriodo.removeAllItems();/*limpiamos combo*/
                getCompetencias(frmEvaluacionAdaptativaConfig.txtArea.getSelectedItem().toString());
            }
        }
        if(e.getSource().equals(frmEvaluacionAdaptativaConfig.txtCompetencia) ){
            if (e.getStateChange() == ItemEvent.SELECTED){
                frmEvaluacionAdaptativaConfig.txtPeriodo.removeAllItems();/*limpiamos combo*/
                getPeriodos();
            }
        }
    }
    
    public void configTiempo(){
        getTiempo();//consultamos tiempo
        int horas,minutos,segundos;
        horas = tiempo/3600;
        minutos = (tiempo%3600)/60;
        segundos =(tiempo%3600)%60;
        
        JTextField jtHoras = new JTextField();
        jtHoras.setText(""+horas);
        JTextField jtMinutos = new JTextField();
        jtMinutos.setText(""+minutos);
        JTextField jtSegundos = new JTextField();
        jtSegundos.setText(""+segundos);
        Object[] message = {"Horas:", jtHoras,"Minutos:", jtMinutos,"Segundos:", jtSegundos};

        int option = JOptionPane.showConfirmDialog(null, message, "Configurar tiempo", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String txtHoras,txtMinutos,txtSegundos;
            txtHoras = jtHoras.getText();
            txtMinutos = jtMinutos.getText();
            txtSegundos = jtSegundos.getText();
            if(txtHoras.length()>0 && txtMinutos.length()>0 && txtSegundos.length()>0){
                if(isNumeric(txtHoras) && isNumeric(txtMinutos) && isNumeric(txtSegundos)){
                    horas = Integer.parseInt(txtHoras);
                    minutos = Integer.parseInt(txtMinutos);
                    segundos = Integer.parseInt(txtSegundos);
                    tiempo = Math.abs(horas*3600)+Math.abs(minutos*60)+Math.abs(segundos);//convertimos a segundos
                    if(matrizDao.getMatrizCompetenciaTiempoUpdate(idDocenteAula, tiempo)){
                       JOptionPane.showMessageDialog(null,"Tiempo de evaluación adaptativa actualizada!");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Los valores ingresados deben ser numericos","Mensaje",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null,"Existen campos vacios!","Mensaje",JOptionPane.ERROR_MESSAGE);
            }
        } 
    }
    
    public void getAreas(){
        if(listaArea!=null)listaArea.clear(); 
        listaArea = matrizDao.getMatrizAreaRead(idDocenteAula);
        frmEvaluacionAdaptativaConfig.txtArea.removeAllItems();//limpiamos combo
        root.removeAllChildren(); //this removes all nodes
        frmEvaluacionAdaptativaConfig.jtreeArea.setModel(null);
        for(int i=0;i<listaArea.size();i++){
            frmEvaluacionAdaptativaConfig.txtArea.addItem(listaArea.get(i).getArea());
            nodeArea = new DefaultMutableTreeNode(new CheckBoxNode(listaArea.get(i).getArea(),areaIcon,false));
            root.add(nodeArea);
            getCompetencias(listaArea.get(i).getArea(), nodeArea);
        }
        frmEvaluacionAdaptativaConfig.jtreeArea.setRootVisible(false);
        frmEvaluacionAdaptativaConfig.jtreeArea.setCellRenderer(renderer);
        frmEvaluacionAdaptativaConfig.jtreeArea.setCellEditor(new FrmEvaluacionAdaptativaConfigEditor(frmEvaluacionAdaptativaConfig.jtreeArea));
        frmEvaluacionAdaptativaConfig.jtreeArea.setEditable(true);  
        frmEvaluacionAdaptativaConfig.jtreeArea.setModel(new DefaultTreeModel(root) {
            @Override
            public void valueForPathChanged(TreePath path, Object newValue) {
                Object currNode = path.getLastPathComponent();
                super.valueForPathChanged(path, newValue);
                DefaultMutableTreeNode padreNode = (DefaultMutableTreeNode) currNode;
                CheckBoxNode padre =(CheckBoxNode) padreNode.getUserObject();
                for (int i = 0; i < padreNode.getChildCount(); i++) {
                    DefaultMutableTreeNode hijoNode = (DefaultMutableTreeNode) padreNode.getChildAt(i);
                    CheckBoxNode hijo = (CheckBoxNode) hijoNode.getUserObject();
                    hijo.setCheckNode(padre.isCheckNode());
                    for (int j = 0; j < hijoNode.getChildCount(); j++) {
                        DefaultMutableTreeNode nietoNode = (DefaultMutableTreeNode) hijoNode.getChildAt(j);
                        CheckBoxNode nieto = (CheckBoxNode) nietoNode.getUserObject();
                        nieto.setCheckNode(hijo.isCheckNode());
                    }
                }
                if ((currNode != null) && (currNode instanceof DefaultMutableTreeNode)) {
                    DefaultMutableTreeNode editedNode = (DefaultMutableTreeNode) currNode;
                    CheckBoxNode newCBN = (CheckBoxNode) newValue;
                    if (!editedNode.isLeaf()) {
                        for (int i = 0; i < editedNode.getChildCount(); i++) {
                            DefaultMutableTreeNode node = (DefaultMutableTreeNode) editedNode.getChildAt(i);
                            CheckBoxNode cbn = (CheckBoxNode) node.getUserObject();
                            cbn.setCheckNode(newCBN.isCheckNode());
                        }
                    }
                    else{
                        boolean isAllChiledSelected = true;
                        for (int i = 0; i < editedNode.getParent().getChildCount(); i++) {
                            DefaultMutableTreeNode node = (DefaultMutableTreeNode) editedNode.getParent().getChildAt(i);
                            CheckBoxNode cbn = (CheckBoxNode) node.getUserObject();
                            if(!cbn.isCheckNode()){
                                isAllChiledSelected = false;
                            }
                        }
                        if(isAllChiledSelected){
                            DefaultMutableTreeNode node = (DefaultMutableTreeNode)editedNode.getParent();
                              CheckBoxNode cbn = (CheckBoxNode) node.getUserObject();
                            cbn.setCheckNode(isAllChiledSelected);
                        }
                    }
                    if (!newCBN.isCheckNode()) {
                        DefaultMutableTreeNode node = (DefaultMutableTreeNode) editedNode.getParent();
                        if (node.getUserObject() instanceof CheckBoxNode)
                            ((CheckBoxNode) node.getUserObject()).setCheckNode(false);                            
                    }                                        
                }
            }
        });
    }
    
    public void getAllCompetencias(){
        if(listaCompetencias!=null)listaCompetencias.clear(); 
        listaCompetencias = competenciaDao.Read();
    }
    
    public void getCompetencias(String area,DefaultMutableTreeNode nodeArea){
        if(listaCompetencias!=null)listaCompetencias.clear(); 
        listaCompetencias = matrizDao.getMatrizCompetenciaAreaRead(area,idDocenteAula);
        for (int i = 0; i < listaCompetencias.size(); i++) {
            nodeCompetencia = new DefaultMutableTreeNode(new CheckBoxNode(listaCompetencias.get(i).getCompetencia(),competenciaIcon,false));
            nodeArea.add(nodeCompetencia);
            getPeriodos(listaCompetencias.get(i), nodeCompetencia);
        }
    }
    
    public void getCompetencias(String area){
        if(listaCompetencias!=null)listaCompetencias.clear(); 
        frmEvaluacionAdaptativaConfig.txtCompetencia.removeAllItems();//limpiamos combo
        listaCompetencias = matrizDao.getMatrizCompetenciaAreaRead(area,idDocenteAula);
        for (int i = 0; i < listaCompetencias.size(); i++) {
            frmEvaluacionAdaptativaConfig.txtCompetencia.addItem(listaCompetencias.get(i).getCompetencia());
        }
    }
    
    public void getPeriodos(){
        if(listaPeriodo!=null)listaPeriodo.clear(); 
        frmEvaluacionAdaptativaConfig.txtPeriodo.removeAllItems();
        listaPeriodo = periodoDao.Read();
        for(int i=0;i<listaPeriodo.size();i++){
            frmEvaluacionAdaptativaConfig.txtPeriodo.addItem(listaPeriodo.get(i).getPeriodo());
        }
    }
    
    public void getPeriodos(Competencia competencia,DefaultMutableTreeNode nodeCompetencia){
        int count =0;
        //ESTADO BIMESTRES
        if(estadoBimestre!=null)estadoBimestre.clear(); 
        estadoBimestre = matrizDao.getMatrizCompetenciaBimestreRead(competencia.getIdCompetencia(), idDocenteAula);
        if(listaPeriodo!=null)listaPeriodo.clear(); 
        listaPeriodo = periodoDao.Read();
        for(int i=0;i<listaPeriodo.size();i++){
            nodePeriodo = new DefaultMutableTreeNode(new CheckBoxNode(listaPeriodo.get(i).getPeriodo(), periodoIcon,estadoBimestre.get(i)));
            nodeCompetencia.add(nodePeriodo);
            if(estadoBimestre.get(i)){count+=1;}
        }
        //si todos los periodos estas activados, ponemos check a la competencia
        if(count==4){((CheckBoxNode) nodeCompetencia.getUserObject()).setCheckNode(true);}
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
    
    public void getNiveles(){
        if(listaNivel!=null)listaNivel.clear(); 
        listaNivel=nivelDao.Read();
    }
    
    public void getEstilos(){
        if(listaEstilo!=null)listaEstilo.clear(); 
        listaEstilo=estiloDao.Read();
    }
    
    public void getTiempo(){
        if(listaCompetencias.size()>0){
            tiempo = matrizDao.getMatrizCompetenciaTiempoRead(listaCompetencias.get(0).getIdCompetencia(), idDocenteAula);
        }
    }
    
    public void getPreguntas(){
        int cantidadPreguntas = 0;
        frmEvaluacionAdaptativaConfig.table.setRowSorter(null);//clear filter
        model=new DefaultTableModel(){@Override public boolean isCellEditable(int row, int column) {return false;}};
        periodo = frmEvaluacionAdaptativaConfig.txtPeriodo.getSelectedItem().toString();
        competencia = frmEvaluacionAdaptativaConfig.txtCompetencia.getSelectedItem().toString();
        listaPregunta = evaluacionAdaptativaConfigDao.getPreguntas(periodo, idDocenteAula, competencia);
        if(listaPregunta.size()>0){
            //add column to table
            model.addColumn("PREGUNTA");
            //model.addColumn("APRIORI");
            model.addColumn("DESCUIDO");
            model.addColumn("ADIVINANZA");
            model.addColumn("NIVEL");
            model.addColumn("ESTILO");
            //add rowTable to table
            for (int i = 0; i <listaPregunta.size(); i++) {
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
                model.addRow(rowTable);
                cantidadPreguntas+=1;
            }
        }
        frmEvaluacionAdaptativaConfig.table.setModel(model);//seteamos model*/
        frmEvaluacionAdaptativaConfig.txtTotalPreguntas.setText("CANTIDAD:  "+cantidadPreguntas);
    }
    
    public static boolean isNumeric(String strNum) {
        boolean ret = true;
        try {
            Integer.parseInt(strNum);
        }catch (NumberFormatException e) {
            ret = false;
        }
        return ret;
    }
 }
