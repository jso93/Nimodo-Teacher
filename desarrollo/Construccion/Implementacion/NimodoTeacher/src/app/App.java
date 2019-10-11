package app;

import javax.swing.UnsupportedLookAndFeelException;
import pattern.controller.FrmLoginController;
import pattern.view.FrmLogin;

public class App {
    //view
    private static FrmLogin frmLogin;
    //controller
    private static FrmLoginController frmLoginController;
    
    public static void main() {
        try {
            javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {}
        frmLoginController = new FrmLoginController(frmLogin);
        frmLoginController.initController();
    }
}