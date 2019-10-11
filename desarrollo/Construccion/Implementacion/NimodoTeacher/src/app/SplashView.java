package app;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.imageio.ImageIO;
import javax.swing.*;
 
public class SplashView extends JWindow {
     
    private final int duration;
     
    public SplashView(int d) {
        duration = d;
    }
     
    public void showSplash() {
        JPanel content = new MidPic(); 
        int width = 256;
        int height =295;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        setBounds(x,y,width,height);
        JLabel txtNimodo = new JLabel("Nimodo Teacher 1.0", JLabel.CENTER);
        txtNimodo.setIcon(new ImageIcon(SplashView.class.getResource("/images/load.gif")));
        txtNimodo.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(txtNimodo, BorderLayout.SOUTH);
        add(content);
        setVisible(true);
        try { Thread.sleep(duration); } catch (InterruptedException e) {}
        setVisible(false);
    }

    public void showSplashAndExit() throws URISyntaxException {
        showSplash();
        App.main(); 
    }
     
    public static void main(String[] args) throws URISyntaxException {
        SplashView splash = new SplashView(5000);
        splash.showSplashAndExit();
    }
    
    class MidPic extends JPanel{
        BufferedImage img; 
        public MidPic(){ 
            try { 
                img = ImageIO.read(SplashView.class.getResource("/images/logo.png")); // Aquí la ruta del fichero 
            } catch (IOException e) {} 
        } 
        @Override
        public void paint(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(img, 0, 0, this);
        }
    }
}