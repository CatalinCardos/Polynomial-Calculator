import Model.GuiModel;
import Model.Polynomials;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class IntegrOperationTest {
    @Test
    public void test(){
        GuiModel addOperationTest = new GuiModel();
        Polynomials pol1= new Polynomials("4X^3+6X+2");
        Polynomials pol3 = new Polynomials("X^4+3X^2+2X");
        Polynomials pol4 = addOperationTest.integPol(pol1);
        assertEquals(pol4,pol3,"Testul pentru integrare a doua  polinoame!");
    }
}
