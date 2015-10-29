package modelo;  
  
import javax.swing.text.AttributeSet;  
import javax.swing.text.BadLocationException;  
import javax.swing.text.PlainDocument;  
  
public class MascTel extends PlainDocument{  
  
    private int caracters = 0;
  
    @Override  
    public void insertString(int offset, String str, AttributeSet attr) throws  
            BadLocationException {  
    	
    	
    	
        String Telefone = getText(0, getLength());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                return;
            }
        }
                 
        if(13 >= caracters ){          	       
	        	str = str.replaceAll("\b", "");
	        	if(caracters == 0){  
	                str = "("+str;  
	            }
	            if(caracters == 3){  
	                str = ") "+str;  
	            }
		       	 		
				if (caracters == 9){
					str = "-"+str;  
				}
//	    else if(15 >= caracters){
//	    		str = str.replaceAll("\b", "");
//	    		if (caracters == 10){
//					str = "-"+str;
//	     }

				super.insertString(offset, str, attr);  
		        caracters = getLength();
		     }}     
	       	

    @Override  
    public void remove(int offset, int length) throws BadLocationException {  
          
        super.remove(offset, length);  
          
        caracters = getLength();  
          
        if(caracters == 9 || caracters == 4 || caracters == 1){  
            super.remove(getLength()-1, 1);  
            caracters = getLength();  
        }  
    }  
}  