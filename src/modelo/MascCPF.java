package modelo;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class MascCPF extends PlainDocument {

    private int tamanho = 14;

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {

        String CPF = getText(0, getLength());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                return;
            }
        }

        if (CPF.length() < tamanho) {
            super.remove(0, getLength());
            StringBuilder s = new StringBuilder(CPF + str);

            if (s.length() == 3) {
                s.insert(3, ".");
            } else if (s.length() == 7) {
                s.insert(7, ".");
            }else if(s.length() == 11){
                s.insert(11, "-");
            }

            super.insertString(0, s.toString(), a);
        }
    }
}