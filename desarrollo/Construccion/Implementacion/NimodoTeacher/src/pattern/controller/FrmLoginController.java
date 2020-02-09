package pattern.controller;

import interfaces.IView;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import pattern.dao.LoginDao;
import pattern.view.FrmLogin;
import pattern.view.FrmPrincipal;

public class FrmLoginController implements IView{
    //view
    private FrmLogin frmLogin;
    private FrmPrincipal frmPrincipal;
    //controller
    private FrmPrincipalController frmPrincipalController;
    //dao
    private LoginDao loginDao;
    //variables
    private String user,password;
    private List<String> persona;
    
    public FrmLoginController(FrmLogin frmLogin) {
        this.frmLogin = frmLogin;
    }
    
    public void initView(){
        frmLogin = new FrmLogin();
        frmLogin.setVisible(true);
    }
    
    @Override
    public void initController(){
        initView();
        frmLogin.txtUser.addKeyListener(getKeyAdapter());
        frmLogin.txtPassword.addKeyListener(getKeyAdapter());
    }
    
    @Override
    public void refreshView(){}
    
    public KeyAdapter getKeyAdapter(){
        return new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    user = frmLogin.txtUser.getText();
                    password = String.valueOf(frmLogin.txtPassword.getPassword());
                    if(!user.equals("") && !password.equals("")){
                        loginDao=new LoginDao();
                        persona = loginDao.validarLogin(user, password);
                        if(persona!=null){
                            if(!persona.get(6).equals("Estudiante")){
                                frmLogin.dispose();
                                frmPrincipalController = new FrmPrincipalController(frmPrincipal, persona);
                                frmPrincipalController.initController();   
                                
                            }else{
                                JOptionPane.showMessageDialog(null,"Usted es estudiante, porfavor ingresar desde la aplicacion móvil!","Mensaje",JOptionPane.ERROR_MESSAGE);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null,"Usuario no existe o la contraseña es incorrecta!","Mensaje",JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Existen campos vacios!","Mensaje",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        };
    }
    
}
/*UPDATE TIEMPO RESULTADO POR ID
List<Integer> listaID;
listaID = loginDao.Read();
for (int i = 0; i < listaID.size(); i++) {
    //System.out.println("index:"+(i+1)+" id:"+listaID.get(i));
    if(loginDao.updateResultado(listaID.get(i))){
        System.out.println("index:"+(i+1)+" id:"+listaID.get(i)+"success update!");
    }else{
        System.out.println("index:"+(i+1)+" id:"+listaID.get(i)+"fallo update!");
    }
}
*/