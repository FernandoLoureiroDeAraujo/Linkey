package modelo;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class MascDia extends PlainDocument{
    @Override  
    public void insertString(int offset, String str, AttributeSet attr) throws  
            BadLocationException {  
    	
    		super.insertString(offset, str.replaceAll("[^1-31]", ""), attr);
    
    }
//
//	public void replace(int offset, String str, AttributeSet attr) throws  
//	BadLocationException {  
//	
//	super.insertString(offset, str.replaceAll("[^01-31]", ""), attr);
//	
//	}
}
