package pattern.model;

import javax.swing.ImageIcon;

public class CheckBoxNode {
    private String nameNode;
    private ImageIcon iconNode;
    private boolean checkNode;

    public CheckBoxNode() {
    }

    public CheckBoxNode(String nameNode, ImageIcon iconNode, boolean checkNode) {
        this.nameNode = nameNode;
        this.iconNode = iconNode;
        this.checkNode = checkNode;
    }

    public String getNameNode() {
        return nameNode;
    }

    public void setNameNode(String nameNode) {
        this.nameNode = nameNode;
    }

    public ImageIcon getIconNode() {
        return iconNode;
    }

    public void setIconNode(ImageIcon iconNode) {
        this.iconNode = iconNode;
    }

    public boolean isCheckNode() {
        return checkNode;
    }

    public void setCheckNode(boolean checkNode) {
        this.checkNode = checkNode;
    }
}
