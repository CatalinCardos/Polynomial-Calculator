package Controller;

import Model.GuiModel;
import Model.Polynomials;
import View.Gui;

import javax.swing.*;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        GuiModel model = new GuiModel();
        Gui view = new Gui();
        GuiController controller = new GuiController(view,model);
        JFrame mainPage;
        mainPage = new JFrame("POLYcalculator");
        mainPage.setContentPane(view.getPanelPrincipal());
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPage.pack();
        mainPage.setVisible(true);
//        Polynomials c = new Polynomials("13X+10X^3-10X");


    }
}
