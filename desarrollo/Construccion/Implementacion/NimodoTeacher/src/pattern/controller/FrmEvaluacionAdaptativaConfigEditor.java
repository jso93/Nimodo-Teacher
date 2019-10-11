package pattern.controller;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreePath;
import pattern.model.CheckBoxNode;

public class FrmEvaluacionAdaptativaConfigEditor extends AbstractCellEditor implements TreeCellEditor {
    private final JTree tree1;
    private DefaultMutableTreeNode editedNode;
    private final JCheckBox check;  
    private final JLabel label;  
    private final JTextField textField;  
    private final JPanel panel;
    private CheckBoxNode checkBoxNode;
    private ImageIcon icon;
    
    public FrmEvaluacionAdaptativaConfigEditor(JTree tree) {
        this.tree1 = tree;
        check = new JCheckBox();  
        check.setBackground(UIManager.getColor("Tree.background"));  
        label = new JLabel();  
        textField = new JTextField();  
        textField.setEditable(false);
        textField.setBackground(UIManager.getColor("Tree.background"));  
        textField.setBorder(null);
        panel = new JPanel();  
        panel.setOpaque(true);  
        panel.add(check);  
        panel.add(label);  
        panel.add(textField);  
    }
    
    @Override
    public Object getCellEditorValue() {
        icon = (ImageIcon) label.getIcon();
        checkBoxNode = new CheckBoxNode(textField.getText(),icon,check.isSelected());
        return checkBoxNode;
    }
    
    @Override
    public boolean isCellEditable(EventObject event) {
        boolean returnValue = false;
        if (event instanceof MouseEvent) {
            MouseEvent mouseEvent = (MouseEvent) event;
            TreePath path = tree1.getPathForLocation(mouseEvent.getX(),mouseEvent.getY());
            if (path != null) {
                Object node = path.getLastPathComponent();
                if ((node != null) && (node instanceof DefaultMutableTreeNode)) {
                    editedNode = (DefaultMutableTreeNode) node;
                    Object userObject = editedNode.getUserObject();
                    Rectangle r = tree1.getPathBounds(path);
                    int x = mouseEvent.getX() - r.x;
                    check.setText("");
                    returnValue = userObject instanceof CheckBoxNode && x > 0 && x < check.getPreferredSize().width;
                }
            }
        }
        return returnValue;
    }
    
    @Override
    public Component getTreeCellEditorComponent(final JTree tree, Object value,boolean selected, boolean expanded, boolean leaf, int row) {
        ItemListener itemListener = (ItemEvent itemEvent) -> {
            tree.repaint();
            fireEditingStopped();
        };
        if (check instanceof JCheckBox) {
            ((JCheckBox) check).addItemListener(itemListener);
        }
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;  
        checkBoxNode = (CheckBoxNode)node.getUserObject();
        check.setSelected(checkBoxNode.isCheckNode());
        label.setIcon(checkBoxNode.getIconNode());
        textField.setText(checkBoxNode.getNameNode());  
        return panel;
    }
}