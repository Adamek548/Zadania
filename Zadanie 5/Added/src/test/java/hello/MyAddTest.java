package hello;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import hello.CalculatorAdd;
class MyAddTest{
@Test
public void testAdd () {
CalculatorAdd calculator = new CalculatorAdd();
assertEquals(3, calculator.add(1,2));
}
}
