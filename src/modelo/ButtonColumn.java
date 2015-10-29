package modelo;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import aparencia.Principal;

@SuppressWarnings("serial")
public class ButtonColumn extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener  
{
JTable table;  
JButton renderButton;  
JButton editButton;  
String text; 


public ButtonColumn(JTable table, int column)  
{  
    super();  
    this.table = table;  
    renderButton = new JButton();  

    editButton = new JButton();  
    editButton.setFocusPainted( false );  
    editButton.addActionListener( this );  

    TableColumnModel columnModel = table.getColumnModel();  
    columnModel.getColumn(column).setCellRenderer( this );  
    columnModel.getColumn(column).setCellEditor( this );  
}   

public Component getTableCellRendererComponent(  
    JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)  
{  
//    if (hasFocus)  
//    {  
//        renderButton.setForeground(table.getForeground());  
//        renderButton.setBackground(UIManager.getColor("images\\close.png"));  
//    }  
//    else if (isSelected)  
//    {  
//        renderButton.setForeground(table.getSelectionForeground());  
//         renderButton.setBackground(table.getSelectionBackground());  
//    }  
//    else  
//    {  
//        renderButton.setForeground(table.getForeground());  
//        renderButton.setBackground(UIManager.getColor("images\\close.png"));  
//    }  

//    renderButton.setText(""); 
    renderButton.setIcon(new ImageIcon("images\\close_press2.png"));
    renderButton.setBounds(4, 4, 25, 25);
    
    return renderButton;  
}  

public Component getTableCellEditorComponent(  
    JTable table, Object value, boolean isSelected, int row, int column)  
{  
    text = (value == null) ? "" : value.toString();  
    editButton.setText( text );  
    return editButton;  
}  

public Object getCellEditorValue()  
{  
    return text;  
}  

public void mouseClicked(MouseEvent e) {
    fireEditingStopped();  
    System.out.println("Oii");  
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
public boolean isCellEditable(int rowIndex, int columnIndex) {
    if (columnIndex == 14) {
            return true;
    } else {
        return false;
    }
}
}  