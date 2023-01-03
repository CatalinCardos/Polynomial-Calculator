import Model.Polynomials;
import org.testng.annotations.Test;
import Model.GuiModel;

import java.util.Objects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddOperationTest {

    @Test
public void addTest()
{
    GuiModel addOperationTest = new GuiModel();
    Polynomials pol1= new Polynomials("4X+2");
    Polynomials pol2 = new Polynomials("5X^2+2");
    Polynomials pol3 = new Polynomials("5X^2+4X+4");
    Polynomials pol4 = addOperationTest.addPol(pol1, pol2);
    assertEquals(pol3, pol4, "Testul pentru adunarea polinoamelor!");
}
}
