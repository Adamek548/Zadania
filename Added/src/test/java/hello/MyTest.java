package hello;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import hello.Calculator;
class MyTest{
@Test
public void testAdd() {
Calculator calculator = new Calculator();
assertEquals(3, calculator.add(1,2));
}
}
