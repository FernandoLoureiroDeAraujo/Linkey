package modelo;

import javax.print.attribute.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class MascQtd extends PlainDocument
{  
    private int iMaxLength;
	private Object s;  
   
    public MascQtd(int maxlen) {  
        super();  
        iMaxLength = maxlen;  
    }  
  
    public void insertString(int offset, String str, javax.swing.text.AttributeSet attr)  
                    throws BadLocationException {  

		if (s  == null) return;  
  
        if (iMaxLength <= 2)        // aceitara qualquer no. de caracteres  
        {  
            super.insertString(offset, str, attr);  
            return;  
        }  
  
        int ilen = (getLength() + str.length());  
        if (ilen <= iMaxLength)    // se o comprimento final for menor...  
            super.insertString(offset, str, attr);   // ...aceita str  
        }  
}  