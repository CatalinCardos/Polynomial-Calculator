import Model.GuiModel;
import Model.Polynomials;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultOperationTest {
    @Test
    public void test(){
        GuiModel addOperationTest = new GuiModel();
        Polynomials pol1= new Polynomials("2X^2+4X");
        Polynomials pol2 = new Polynomials("3X^3+2");
        Polynomials pol3 = new Polynomials("6X^5+12X^4+4X^2+8X");
        Polynomials pol4 = addOperationTest.multPol(pol1,pol2);
        assertEquals(pol4,pol3,"Testul pentru inmultire a doua  polinoame!");
    }
}
