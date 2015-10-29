package modelo;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class MascCEP extends PlainDocument {
    private int tamanho = 9;

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {

        String CEP = getText(0, getLength());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                return;
            }
        }

        if (CEP.length() < tamanho) {
            super.remove(0, getLength());
            StringBuilder s = new StringBuilder(CEP + str);

            if (s.length() == 5) {
                s.insert(5, "-");
            }

            super.insertString(0, s.toString(), a);
        }
    }
}