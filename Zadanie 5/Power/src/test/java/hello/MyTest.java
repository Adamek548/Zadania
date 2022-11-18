package hello;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import hello.Calculator;
class MyTest{
@Test
public void testPower() {
Calculator calculator = new Calculator();
assertEquals(4, calculator.power(2,2));
}
}
