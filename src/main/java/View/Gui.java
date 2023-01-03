package View;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Gui {
    private JTextField textPol1;
    private JPanel panelPrincipal;
    private JTextField textPol2;
    private JPanel panelOperatii;
    private JTextField textRezultat;
    private JButton button1;
    private JButton button4;
    private JButton button2;
    private JButton button5;
    private JButton button3;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton adunareButton;
    private JButton scadereButton;
    private JButton inmultireButton;
    private JButton impartireButton;
    private JButton derivareButton;
    private JButton integrareButton;
    private JButton buttonOri;
    private JButton buttonPutere;
    private JButton buttonMinus;
    private JButton buttonPlus;
    private JButton buttonClear;
    private JButton buttonX;
    private JCheckBox checkPol1;
    private JCheckBox checkPol2;
    private JButton buttonZero;
    private String polinom1;
    private String polinom2;

    public void addbutton1Listener(ActionListener mal) {button1.addActionListener(mal);
    }
    public void addbutton2Listener(ActionListener mal) {
        button2.addActionListener(mal);
    }
    public void addbutton3Listener(ActionListener mal) {
        button3.addActionListener(mal);
    }
    public void addbutton4Listener(ActionListener mal) {
        button4.addActionListener(mal);
    }
    public void addbutton5Listener(ActionListener mal) {
        button5.addActionListener(mal);
    }
    public void addbutton6Listener(ActionListener mal) {
        button6.addActionListener(mal);
    }
    public void addbutton7Listener(ActionListener mal) {
        button7.addActionListener(mal);
    }
    public void addbutton8Listener(ActionListener mal) {
        button8.addActionListener(mal);
    }
    public void addbutton9Listener(ActionListener mal) {
        button9.addActionListener(mal);
    }
    public void addbuttonPlusListener(ActionListener mal) {
        buttonPlus.addActionListener(mal);
    }
    public void addbuttonMinusListener(ActionListener mal) {
        buttonMinus.addActionListener(mal);
    }
    public void addbuttonXListener(ActionListener mal) {
        buttonX.addActionListener(mal);
    }
    public void addbuttonClearListener(ActionListener mal) {
        buttonClear.addActionListener(mal);
    }
    public void addbuttonPutereListener(ActionListener mal) {
        buttonPutere.addActionListener(mal);
    }
    public void addcheckPol1Listener(ActionListener mal) {checkPol1.addActionListener(mal);}
    public void addcheckPol2Listener(ActionListener mal) {checkPol2.addActionListener(mal);}
    public void addAdunareListener(ActionListener mal) {adunareButton.addActionListener(mal);}
    public void addScadereListener(ActionListener mal) {scadereButton.addActionListener(mal);}
    public void addInmultireListener(ActionListener mal) {inmultireButton.addActionListener(mal);}
    public void addImpartireListener(ActionListener mal) {impartireButton.addActionListener(mal);}
    public void addDerivareListener(ActionListener mal){derivareButton.addActionListener(mal);}
    public void addIntegrareListener(ActionListener mal){integrareButton.addActionListener(mal);}
    public void addbuttonZeroListener(ActionListener mal){buttonZero.addActionListener(mal);}
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public JTextField getTextPol1() {
        return textPol1;
    }

    public JTextField getTextPol2() {
        return textPol2;
    }

    public JCheckBox getCheckPol1() {
        return checkPol1;
    }

    public JCheckBox getCheckPol2() {
        return checkPol2;
    }

    public JTextField getTextRezultat() {
        return textRezultat;
    }
}
