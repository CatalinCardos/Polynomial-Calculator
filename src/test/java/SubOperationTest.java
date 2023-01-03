import Model.GuiModel;
import Model.Polynomials;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubOperationTest {

    @Test
    public void test(){
        GuiModel addOperationTest = new GuiModel();
        Polynomials pol1= new Polynomials("4X+2");
        Polynomials pol2 = new Polynomials("5X^2+2");
        Polynomials pol3 = new Polynomials("-5X^2+4X");
        Polynomials pol4 = addOperationTest.subPol(pol1, pol2);
        assertEquals(pol4,pol3,"Testul pentru scaderea a doua  polinoame!");
    }
}
