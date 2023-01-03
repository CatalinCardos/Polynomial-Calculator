package Controller;
import Model.GuiModel;
import Model.Polynomials;
import View.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class GuiController {
    private Gui c_view;
    private GuiModel c_model;
    private boolean check;

    public GuiController(Gui c_view, GuiModel c_model) {
        this.c_view = c_view;
        this.c_model = c_model;
        c_view.addbutton1Listener(new Button1Listener());
        c_view.addbutton2Listener(new Button2Listener());
        c_view.addbutton3Listener(new Button3Listener());
        c_view.addbutton4Listener(new Button4Listener());
        c_view.addbutton5Listener(new Button5Listener());
        c_view.addbutton6Listener(new Button6Listener());
        c_view.addbutton7Listener(new Button7Listener());
        c_view.addbutton8Listener(new Button8Listener());
        c_view.addbutton9Listener(new Button9Listener());
        c_view.addbuttonClearListener(new ButtonClearListener());
        c_view.addbuttonMinusListener(new ButtonMinusListener());
        c_view.addbuttonPlusListener(new ButtonPlusListener());
        c_view.addbuttonPutereListener(new ButtonPutereListener());
        c_view.addbuttonXListener(new ButtonXListener());
        c_view.addcheckPol1Listener(new CheckPol1Listener());
        c_view.addcheckPol2Listener(new CheckPol2Listener());
        c_view.addAdunareListener(new AdunareListener());
        c_view.addScadereListener(new ScadereListener());
        c_view.addInmultireListener(new InmultireListener());
        c_view.addDerivareListener(new DerivareListener());
        c_view.addIntegrareListener(new IntegrareListener());
        c_view.addImpartireListener(new ImpartireListener());
        c_view.addbuttonZeroListener(new ButtonZeroListener());
    }

    class IntegrareListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            Polynomials pol1Final = new Polynomials(c_view.getTextPol1().getText());
            if (pol1Final.getVerifPol()) {
                Polynomials add = c_model.integPol(pol1Final);
                c_view.getTextPol1().setText("");
                add.transfMon();
                String result = add.stringPol();
                c_view.getTextRezultat().setText(result);
            } else {
                JOptionPane.showMessageDialog(c_view.getPanelPrincipal(), "Polinomul nu se afla in forma corecta!");
            }

        }
    }

    class DerivareListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            Polynomials pol1Final = new Polynomials(c_view.getTextPol1().getText());
            if (pol1Final.getVerifPol()) {
                Polynomials add = c_model.derivPol(pol1Final);
                c_view.getTextPol1().setText("");
                add.transfMon();
                String result = add.stringPol();
                c_view.getTextRezultat().setText(result);
            } else {
                JOptionPane.showMessageDialog(c_view.getPanelPrincipal(), "Polinomul nu se afla in forma corecta!");
            }

        }
    }

    class ImpartireListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            Polynomials pol1Final = new Polynomials(c_view.getTextPol1().getText());
            Polynomials pol2Final = new Polynomials(c_view.getTextPol2().getText());
            if (pol1Final.getVerifPol() && pol2Final.getVerifPol()) {
                String add = c_model.divPol(pol1Final, pol2Final);
                c_view.getTextPol2().setText("");
                c_view.getTextPol1().setText("");
                c_view.getTextRezultat().setText(add);
            } else {
                JOptionPane.showMessageDialog(c_view.getPanelPrincipal(), "Unul dintre polinoame nu se afla in forma corecta!");
            }

        }
    }

    class InmultireListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if(Objects.equals(c_view.getTextPol1().getText(), "0") || Objects.equals(c_view.getTextPol2().getText(), "0"))
            {
                c_view.getTextRezultat().setText("0");
            }
            else
            {
                Polynomials pol1Final = new Polynomials(c_view.getTextPol1().getText());
                Polynomials pol2Final = new Polynomials(c_view.getTextPol2().getText());
                if (pol1Final.getVerifPol() && pol2Final.getVerifPol()) {
                    Polynomials add = c_model.multPol(pol1Final, pol2Final);
                    c_view.getTextPol2().setText("");
                    c_view.getTextPol1().setText("");
                    add.transfMon();
                    String result = add.stringPol();
                    c_view.getTextRezultat().setText(result);
                } else {
                    JOptionPane.showMessageDialog(c_view.getPanelPrincipal(), "Unul dintre polinoame nu se afla in forma corecta!");
                }
            }


        }
    }

    class ScadereListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Polynomials pol1Final = new Polynomials(c_view.getTextPol1().getText());
            Polynomials pol2Final = new Polynomials(c_view.getTextPol2().getText());
            if (pol1Final.getVerifPol() && pol2Final.getVerifPol()) {
                Polynomials add = c_model.subPol(pol1Final, pol2Final);
                c_view.getTextPol2().setText("");
                c_view.getTextPol1().setText("");
                add.transfMon();
                String result = add.stringPol();
                c_view.getTextRezultat().setText(result);
            } else {
                JOptionPane.showMessageDialog(c_view.getPanelPrincipal(), "Unul dintre polinoame nu se afla in forma corecta!");
            }

        }
    }

    class AdunareListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            Polynomials pol1Final = new Polynomials(c_view.getTextPol1().getText());
            Polynomials pol2Final = new Polynomials(c_view.getTextPol2().getText());
            if (pol1Final.getVerifPol() && pol2Final.getVerifPol()) {
                Polynomials add = c_model.addPol(pol1Final, pol2Final);
                c_view.getTextPol2().setText("");
                c_view.getTextPol1().setText("");
                add.transfMon();
                String result = add.stringPol();
                c_view.getTextRezultat().setText(result);
            } else {
                JOptionPane.showMessageDialog(c_view.getPanelPrincipal(), "Unul dintre polinoame nu se afla in forma corecta!");
            }

        }
    }

    class Button1Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (c_view.getCheckPol2().isSelected()) {
                c_view.getTextPol2().setText(c_view.getTextPol2().getText() + "1");
            } else {
                c_view.getTextPol1().setText(c_view.getTextPol1().getText() + "1");
            }

        }
    }

    class Button2Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (c_view.getCheckPol2().isSelected()) {
                c_view.getTextPol2().setText(c_view.getTextPol2().getText() + "2");
            } else {
                c_view.getTextPol1().setText(c_view.getTextPol1().getText() + "2");
            }
        }
    }

    class Button3Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (c_view.getCheckPol2().isSelected()) {
                c_view.getTextPol2().setText(c_view.getTextPol2().getText() + "3");
            } else {
                c_view.getTextPol1().setText(c_view.getTextPol1().getText() + "3");
            }
        }
    }

    class Button4Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (c_view.getCheckPol2().isSelected()) {
                c_view.getTextPol2().setText(c_view.getTextPol2().getText() + "4");
            } else {
                c_view.getTextPol1().setText(c_view.getTextPol1().getText() + "4");
            }
        }
    }

    class Button5Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (c_view.getCheckPol2().isSelected()) {
                c_view.getTextPol2().setText(c_view.getTextPol2().getText() + "5");
            } else {
                c_view.getTextPol1().setText(c_view.getTextPol1().getText() + "5");
            }
        }
    }

    class Button6Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (c_view.getCheckPol2().isSelected()) {
                c_view.getTextPol2().setText(c_view.getTextPol2().getText() + "6");
            } else {
                c_view.getTextPol1().setText(c_view.getTextPol1().getText() + "6");
            }
        }
    }

    class Button7Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (c_view.getCheckPol2().isSelected()) {
                c_view.getTextPol2().setText(c_view.getTextPol2().getText() + "7");
            } else {
                c_view.getTextPol1().setText(c_view.getTextPol1().getText() + "7");
            }
        }
    }

    class Button8Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (c_view.getCheckPol2().isSelected()) {
                c_view.getTextPol2().setText(c_view.getTextPol2().getText() + "8");
            } else {
                c_view.getTextPol1().setText(c_view.getTextPol1().getText() + "8");
            }
        }
    }

    class Button9Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (c_view.getCheckPol2().isSelected()) {
                c_view.getTextPol2().setText(c_view.getTextPol2().getText() + "9");
            } else {
                c_view.getTextPol1().setText(c_view.getTextPol1().getText() + "9");
            }
        }
    }

    class ButtonOriListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (c_view.getCheckPol2().isSelected()) {
                c_view.getTextPol2().setText(c_view.getTextPol2().getText() + "*");
            } else {
                c_view.getTextPol1().setText(c_view.getTextPol1().getText() + "*");
            }
        }
    }

    class ButtonPlusListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (c_view.getCheckPol2().isSelected()) {
                c_view.getTextPol2().setText(c_view.getTextPol2().getText() + "+");
            } else {
                c_view.getTextPol1().setText(c_view.getTextPol1().getText() + "+");
            }
        }
    }

    class ButtonMinusListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (c_view.getCheckPol2().isSelected()) {
                c_view.getTextPol2().setText(c_view.getTextPol2().getText() + "-");
            } else {
                c_view.getTextPol1().setText(c_view.getTextPol1().getText() + "-");
            }
        }
    }

    class ButtonXListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (c_view.getCheckPol2().isSelected()) {
                c_view.getTextPol2().setText(c_view.getTextPol2().getText() + "X");
            } else {
                c_view.getTextPol1().setText(c_view.getTextPol1().getText() + "X");
            }
        }
    }

    class ButtonPutereListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (c_view.getCheckPol2().isSelected()) {
                c_view.getTextPol2().setText(c_view.getTextPol2().getText() + "^");
            } else {
                c_view.getTextPol1().setText(c_view.getTextPol1().getText() + "^");
            }
        }
    }

    class ButtonClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (c_view.getCheckPol2().isSelected()) {
                if (!c_view.getTextPol2().getText().equals("")) {
                    c_view.getTextPol2().setText(c_view.getTextPol2().getText().substring(0, c_view.getTextPol2().getText().length() - 1));
                }
            } else {
                if (!c_view.getTextPol1().getText().equals("")) {
                    c_view.getTextPol1().setText(c_view.getTextPol1().getText().substring(0, c_view.getTextPol1().getText().length() - 1));
                }
            }
        }
    }

    class CheckPol1Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (c_view.getCheckPol2().isSelected()) {
                c_view.getCheckPol2().setSelected(false);
            }
        }
    }

    class CheckPol2Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (c_view.getCheckPol1().isSelected()) {
                c_view.getCheckPol1().setSelected(false);
            }
        }
    }

    class ButtonZeroListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (c_view.getCheckPol2().isSelected()) {
                c_view.getTextPol2().setText(c_view.getTextPol2().getText() + "0");
            } else {
                c_view.getTextPol1().setText(c_view.getTextPol1().getText() + "0");
            }
        }
    }
}
