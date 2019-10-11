package pattern.controller;

import pattern.view.FrmDesempeñoInfo;

public class FrmDesempeñoInfoController{
    //view
    private final FrmDesempeñoInfo frmDesempeñoInfo;

    public FrmDesempeñoInfoController(FrmDesempeñoInfo frmDesempeñoInfo) {
        this.frmDesempeñoInfo = frmDesempeñoInfo;
    }
    
    public void sendInfo(String descripcion){
        frmDesempeñoInfo.txtDescripcion.setText(descripcion);
    }
    
}
