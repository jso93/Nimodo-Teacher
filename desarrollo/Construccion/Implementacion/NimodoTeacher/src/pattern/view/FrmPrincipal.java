
package pattern.view;

import app.NotificationView;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class FrmPrincipal extends javax.swing.JFrame implements Runnable{
    
    public FrmPrincipal() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/logo.png")));
        Thread hilo = new Thread(this);
        hilo.start();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panelPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuDocente = new javax.swing.JMenuItem();
        menuEstudiante = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        menuEstudianteMatricula = new javax.swing.JMenuItem();
        menuDocenteAula = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuGrado = new javax.swing.JMenuItem();
        menuSeccion = new javax.swing.JMenuItem();
        menuAula = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuEstilo = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuArea = new javax.swing.JMenuItem();
        menuCompetencia = new javax.swing.JMenuItem();
        menuCapacidad = new javax.swing.JMenuItem();
        menuDesempeño = new javax.swing.JMenuItem();
        menuMatriz = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        menuPregunta = new javax.swing.JMenu();
        menuPreguntaVisual = new javax.swing.JMenuItem();
        menuPreguntaAuditiva = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        menuNivel = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        menuPeriodo = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        menuEvaluacionTradicional = new javax.swing.JMenuItem();
        menuEA = new javax.swing.JMenu();
        menuEvaluacionAdaptativaConfig = new javax.swing.JMenuItem();
        menuReporte = new javax.swing.JMenu();
        menuEvaluacionAdaptativa = new javax.swing.JMenuItem();
        menuNetworkBayesian = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        menuMetal = new javax.swing.JMenuItem();
        menuWindows = new javax.swing.JMenuItem();
        menuWindowsClassic = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        menuInfo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 871, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panelPrincipal);

        jMenu1.setText("Usuarios");

        menuDocente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/docente.png"))); // NOI18N
        menuDocente.setText("Docentes");
        jMenu1.add(menuDocente);

        menuEstudiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/estudiante.png"))); // NOI18N
        menuEstudiante.setText("Estudiantes");
        jMenu1.add(menuEstudiante);

        jMenuBar1.add(jMenu1);

        jMenu6.setText("Matricula");

        menuEstudianteMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/matricula.png"))); // NOI18N
        menuEstudianteMatricula.setText("Matricular estudiantes");
        jMenu6.add(menuEstudianteMatricula);

        menuDocenteAula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/matricula.png"))); // NOI18N
        menuDocenteAula.setText("Asignar Aula a Docentes");
        jMenu6.add(menuDocenteAula);

        jMenuBar1.add(jMenu6);

        jMenu2.setText("Escuela");

        menuGrado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/grado.png"))); // NOI18N
        menuGrado.setText("Grados");
        jMenu2.add(menuGrado);

        menuSeccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/seccion.png"))); // NOI18N
        menuSeccion.setText("Secciones");
        jMenu2.add(menuSeccion);

        menuAula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/aula.png"))); // NOI18N
        menuAula.setText("Aulas");
        jMenu2.add(menuAula);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Estilos de aprendizaje");

        menuEstilo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/estilo.png"))); // NOI18N
        menuEstilo.setText("Estilos");
        jMenu3.add(menuEstilo);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Areas Curriculares");

        menuArea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/area.png"))); // NOI18N
        menuArea.setText("Areas");
        jMenu4.add(menuArea);

        menuCompetencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/competencia.png"))); // NOI18N
        menuCompetencia.setText("Competencias");
        jMenu4.add(menuCompetencia);

        menuCapacidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/capacidad.png"))); // NOI18N
        menuCapacidad.setText("Capacidades");
        jMenu4.add(menuCapacidad);

        menuDesempeño.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/indicador.png"))); // NOI18N
        menuDesempeño.setText("Desempeños");
        jMenu4.add(menuDesempeño);

        menuMatriz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/matriz.png"))); // NOI18N
        menuMatriz.setText("Matriz");
        jMenu4.add(menuMatriz);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Banco de preguntas");

        menuPregunta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pregunta.png"))); // NOI18N
        menuPregunta.setText("Preguntas");
        menuPregunta.setOpaque(true);

        menuPreguntaVisual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/visual.png"))); // NOI18N
        menuPreguntaVisual.setText("Visual");
        menuPregunta.add(menuPreguntaVisual);

        menuPreguntaAuditiva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/auditiva.png"))); // NOI18N
        menuPreguntaAuditiva.setText("Auditiva");
        menuPregunta.add(menuPreguntaAuditiva);

        jMenu5.add(menuPregunta);

        jMenuBar1.add(jMenu5);

        jMenu8.setText("Nivel de logro");

        menuNivel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nivel.png"))); // NOI18N
        menuNivel.setText("Niveles");
        jMenu8.add(menuNivel);

        jMenuBar1.add(jMenu8);

        jMenu9.setText("Periodos");

        menuPeriodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/periodo.png"))); // NOI18N
        menuPeriodo.setText("Periodo Académico");
        jMenu9.add(menuPeriodo);

        jMenuBar1.add(jMenu9);

        jMenu7.setText("Evaluaciones");

        menuEvaluacionTradicional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/evaluacion.png"))); // NOI18N
        menuEvaluacionTradicional.setText("Evaluación Tradicional");
        jMenu7.add(menuEvaluacionTradicional);

        menuEA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/evaluacion.png"))); // NOI18N
        menuEA.setText("Evaluación Adaptativa");
        menuEA.setOpaque(true);

        menuEvaluacionAdaptativaConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/config.png"))); // NOI18N
        menuEvaluacionAdaptativaConfig.setText("Configuración");
        menuEA.add(menuEvaluacionAdaptativaConfig);

        menuReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Reporte.png"))); // NOI18N
        menuReporte.setText("Reportes");
        menuReporte.setOpaque(true);

        menuEvaluacionAdaptativa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/evaluacion.png"))); // NOI18N
        menuEvaluacionAdaptativa.setText("Evaluaciones Adaptativas");
        menuReporte.add(menuEvaluacionAdaptativa);

        menuNetworkBayesian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bayesian.png"))); // NOI18N
        menuNetworkBayesian.setText("Redes Bayesianas");
        menuReporte.add(menuNetworkBayesian);

        menuEA.add(menuReporte);

        jMenu7.add(menuEA);

        jMenuBar1.add(jMenu7);

        jMenu10.setText("Apariencia");

        menuMetal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/metal.png"))); // NOI18N
        menuMetal.setText("Metal");
        jMenu10.add(menuMetal);

        menuWindows.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/windows.png"))); // NOI18N
        menuWindows.setText("Windows");
        jMenu10.add(menuWindows);

        menuWindowsClassic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/windowsclassic.png"))); // NOI18N
        menuWindowsClassic.setText("Windows Classic");
        jMenu10.add(menuWindowsClassic);

        jMenuBar1.add(jMenu10);

        jMenu11.setText("Ayuda");

        menuInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/informacion.png"))); // NOI18N
        menuInfo.setText("Información");
        jMenu11.add(menuInfo);

        jMenuBar1.add(jMenu11);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*   Metal
Nimbus
CDE/Motif
Windows
Windows Classic*/
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JMenuItem menuArea;
    public javax.swing.JMenuItem menuAula;
    public javax.swing.JMenuItem menuCapacidad;
    public javax.swing.JMenuItem menuCompetencia;
    public javax.swing.JMenuItem menuDesempeño;
    public javax.swing.JMenuItem menuDocente;
    public javax.swing.JMenuItem menuDocenteAula;
    private javax.swing.JMenu menuEA;
    public javax.swing.JMenuItem menuEstilo;
    public javax.swing.JMenuItem menuEstudiante;
    public javax.swing.JMenuItem menuEstudianteMatricula;
    public javax.swing.JMenuItem menuEvaluacionAdaptativa;
    public javax.swing.JMenuItem menuEvaluacionAdaptativaConfig;
    public javax.swing.JMenuItem menuEvaluacionTradicional;
    public javax.swing.JMenuItem menuGrado;
    public javax.swing.JMenuItem menuInfo;
    public javax.swing.JMenuItem menuMatriz;
    public javax.swing.JMenuItem menuMetal;
    public javax.swing.JMenuItem menuNetworkBayesian;
    public javax.swing.JMenuItem menuNivel;
    public javax.swing.JMenuItem menuPeriodo;
    private javax.swing.JMenu menuPregunta;
    public javax.swing.JMenuItem menuPreguntaAuditiva;
    public javax.swing.JMenuItem menuPreguntaVisual;
    private javax.swing.JMenu menuReporte;
    public javax.swing.JMenuItem menuSeccion;
    public javax.swing.JMenuItem menuWindows;
    public javax.swing.JMenuItem menuWindowsClassic;
    public javax.swing.JDesktopPane panelPrincipal;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        try {
            System.out.println("open socket!");
            DatagramSocket socketUDP = new DatagramSocket(6789);
            byte[] bufer = new byte[1000];
            String estudiante;
            while (true) {
              // Construimos el DatagramPacket para recibir peticiones
              DatagramPacket packet = new DatagramPacket(bufer, bufer.length);
              // Leemos una petición del DatagramSocket
              socketUDP.receive(packet);
              estudiante = new String(packet.getData(), 0, packet.getLength());
              System.out.println(""+packet.getAddress().getHostAddress()+"----" + estudiante);
              NotificationView.main(estudiante);
              if (estudiante.equals("off"))break;
            }
            socketUDP.close();
        } catch (IOException e) {}
    }
}
