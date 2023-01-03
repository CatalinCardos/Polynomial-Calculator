import Model.GuiModel;
import Model.Polynomials;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DerivOperationTest {

    @Test
    public void test(){
        GuiModel addOperationTest = new GuiModel();
        Polynomials pol1= new Polynomials("4X^2+5X+2");
        Polynomials pol3 = new Polynomials("8X+5");
        Polynomials pol4 = addOperationTest.derivPol(pol1);
        assertEquals(pol4,pol3,"Testul pentru derivare a doua  polinoame!");
    }
}
