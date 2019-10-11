package app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Window;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class BackGround{ 
   public static Color color;
   public static void loopForPanel(Container c, Color col) {
        synchronized (c.getTreeLock()) {
            for (Component com : c.getComponents()) {
                if (com instanceof JPanel) {
                    com.setBackground(col);
                }
                if (com instanceof Container) {
                    loopForPanel((Container) com,col);
                }
            }
        }
    }
    public static void updateLookAndFeel(String look,String color,List<JInternalFrame> listaInternalFrame) {
       try {
       UIManager.setLookAndFeel(look);
        for (Window w : Window.getWindows()) {
            SwingUtilities.updateComponentTreeUI(w);
        } 
        BackGround.color=Color.decode(color);//recuperamos color
        for (int i = 0; i < listaInternalFrame.size(); i++) {
            //hide bar
            ((javax.swing.plaf.basic.BasicInternalFrameUI)listaInternalFrame.get(i).getUI()).setNorthPane(null);
            //undecorated
            listaInternalFrame.get(i).putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
            listaInternalFrame.get(i).getRootPane().setWindowDecorationStyle(JRootPane.NONE);    
            UIManager.put("OptionPane.background", BackGround.color);
            UIManager.getLookAndFeelDefaults().put("Panel.background", BackGround.color);
            loopForPanel(listaInternalFrame.get(i),BackGround.color);
        }
       } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {}
   }
   
} 
     