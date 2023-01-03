import Model.GuiModel;
import Model.Polynomials;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivOperationTest {
    @Test
    public void test(){
        GuiModel addOperationTest = new GuiModel();
        Polynomials pol1= new Polynomials("4X+2");
        Polynomials pol2 = new Polynomials("2X");
        String result = "2.00" + "          REST:" + "2.00";
        String result2 = addOperationTest.divPol(pol1, pol2);
        assertEquals(result,result2,"Testul pentru impartire a doua  polinoame!");
    }

    @Test
    public void test1(){
        GuiModel addOperationTest = new GuiModel();
        Polynomials pol1= new Polynomials("4X+2");
        Polynomials pol2 = new Polynomials("0");
        String result = "Invalid!";
        String result2 = addOperationTest.divPol(pol1, pol2);
        assertEquals(result,result2,"Testul pentru impartire a doua  polinoame!");
    }
}
