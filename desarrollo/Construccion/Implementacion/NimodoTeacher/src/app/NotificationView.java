package app;

import java.awt.BorderLayout; 
import java.awt.Color;  
import java.awt.Toolkit; 
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.JDialog; 
import javax.swing.JLabel;
import javax.swing.JTextPane; 
import javax.swing.SwingConstants;

public class NotificationView extends Thread { 

    private final Ventana ventana; 
    private float opacidad = 0.3f;              // opacidad inicial 
    private final int TIEMPO = 3000;         // tiempo en milisegundos que estara activa la ventana 
    private static String txtEstudianteName;
    public NotificationView() { 
        ventana = new Ventana(); 
        ventana.setOpacity(0.0f);
        //ventana.getContentPane().setBackground(Color.magenta);
        ventana.setVisible(true); 
    } 

    @Override 
    public void run() { 
        try { 
            hacerVisible(); 
            Thread.sleep(TIEMPO); 
            desvanecer(); 
            ventana.dispose(); 
        } catch (InterruptedException e) { 
            System.err.println(e); 
        } catch (URISyntaxException ex) {
            Logger.getLogger(NotificationView.class.getName()).log(Level.SEVERE, null, ex);
        } 
    } 

    private void hacerVisible() throws InterruptedException, URISyntaxException { 
        opacidad = 0.3f; 
        while (opacidad < 1) { 
            ventana.setOpacity(opacidad);
            opacidad += 0.03f; 
            Thread.sleep(20); 
        } 
        com.sun.javafx.application.PlatformImpl.startup(()->{});
        Media media = new Media(ventana.getClass().getResource("/sound/notificacion.mp3").toURI().toString());  
        MediaPlayer mediaPlayer = new MediaPlayer(media);  
        mediaPlayer.play();
    } 

    private void desvanecer() throws InterruptedException  { 
        opacidad = 1.0f; 
        while (opacidad > 0) { 
            ventana.setOpacity(opacidad);
            opacidad -= 0.03f; 
            Thread.sleep(20); 
        }
    } 

    public static void main(String estudiante) { //String[] args
        txtEstudianteName = estudiante;
        NotificationView hilo = new NotificationView(); 
        hilo.start(); 
    } 

    class Ventana extends JDialog { 
        private JTextPane textoPane; 
        private JLabel txtTitle,txtEstudiante;
        public Ventana() { 
            iniciarComponentes(); 
            ubicacionVentana(); 
        } 

        private void ubicacionVentana() { 
            int tamanioX = getWidth(); 
            int tamanioY = getHeight(); 
            int maxX = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(); 
            int maxY = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
            int random = (int) (Math.random()*maxY/2 +tamanioY);
            // ubicacion de la ventana 
            setLocation(maxX - tamanioX, maxY - (tamanioY + random)); 
        } 

        private void iniciarComponentes() { 
            setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);             
            textoPane = new JTextPane(); 
            txtTitle = new JLabel("FINALIZO EVALUACION", SwingConstants.CENTER);
            txtEstudiante = new JLabel(txtEstudianteName, SwingConstants.CENTER);
            setAlwaysOnTop(true);                          // siempre arriba 
            setPreferredSize(new java.awt.Dimension(280, 50));           // tamaño de la ventana 
            setResizable(false);                             // no se puede modificar el tamaño 
            setUndecorated(true);                           // no tiene los controles de estado 
            textoPane.setEditable(false);
            textoPane.setBackground(Color.GRAY);
            add (txtTitle, BorderLayout.PAGE_START);
            add (txtEstudiante, BorderLayout.CENTER);
            pack(); 
        } 
    } 
} 