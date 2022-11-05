package hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import hello.Calculator;
import org.junit.jupiter.api.Test;

class CalculatorTest {
   
   @Test
   public void testAdd() {
	  Calculator calculator = new Calculator();
      assertEquals(3, calculator.add(1,2));
   }
}
