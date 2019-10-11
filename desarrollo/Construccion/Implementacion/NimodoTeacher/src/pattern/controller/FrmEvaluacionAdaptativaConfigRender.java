package pattern.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import pattern.model.CheckBoxNode;

public class FrmEvaluacionAdaptativaConfigRender implements TreeCellRenderer {
    private final Color selectionForeground;
    private final Color selectionBackground;
    private final Color textForeground;
    private final Color textBackground;
    private final JCheckBox check;
    private final JLabel label;
    private final JPanel panel;

    protected JCheckBox getCheck() {
        return check;
    }
    
    public FrmEvaluacionAdaptativaConfigRender() {
        check = new JCheckBox();
        label = new JLabel();
        panel = new JPanel();
        panel.add(check);
        panel.setOpaque(false);
        panel.add(label);
        Font fontValue;
        fontValue = UIManager.getFont("Tree.font");
        if (fontValue != null) {
            check.setFont(fontValue);
        }
        selectionForeground = UIManager.getColor("Tree.selectionForeground");
        selectionBackground = UIManager.getColor("Tree.selectionBackground");
        textForeground = UIManager.getColor("Tree.textForeground");
        textBackground = UIManager.getColor("Tree.textBackground");
    }
    
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        tree.setRowHeight(30); tree.setEnabled(true);
        if (selected) {
            check.setForeground(selectionForeground);
            check.setBackground(selectionBackground);
        } else {
            check.setForeground(textForeground);
            check.setBackground(textBackground);
        }

        if ((value != null) && (value instanceof DefaultMutableTreeNode)) {
            Object userObject = ((DefaultMutableTreeNode) value).getUserObject();
            if (userObject instanceof CheckBoxNode) {
                CheckBoxNode node = (CheckBoxNode) userObject;
                check.setSelected(node.isCheckNode());
                label.setText(node.getNameNode());
                label.setIcon(node.getIconNode());
            }
        }
        return panel;
    }
}