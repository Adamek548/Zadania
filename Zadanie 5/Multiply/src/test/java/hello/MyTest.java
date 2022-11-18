package hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import hello.CalculatorMultiply;
import org.junit.jupiter.api.Test;

class MultiplicationCalculatorTest {

    @Test
    public void test() {
        CalculatorMultiply calc = new CalculatorMultiply();
        assertEquals(8, calc.multiply(4, 2));
    }
}

//moze sie zdzownimy przez jakis komunikator zeby moc rozmawiac?