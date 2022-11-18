import org.junit.jupiter.api.Test;
import pl.babol.adam.Calculator;
import pl.babol.adam.exception.NegativesNotAllowedException;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    private final Calculator calculator = new Calculator();

    //step1
    @Test
    void shouldReturnZeroForEmptyString() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    void shouldReturnProperValueForSingleCharacter() {
        assertEquals(5, calculator.add("5"));
        assertEquals(123, calculator.add("123"));
        assertEquals(5098, calculator.add("5098"));
    }

    @Test
    void shouldReturnSumOfTwoNumbers() {
        assertEquals(12, calculator.add("5, 7"));
        assertEquals(130, calculator.add("123, 7"));
        assertEquals(709, calculator.add("509, 200"));
    }

    //step2
    @Test
    void shouldReturnSumOfSeveralNumbers() {
        assertEquals(22, calculator.add("5, 7, 10"));
        assertEquals(139, calculator.add("123, 7, 3, 6"));
        assertEquals(1209, calculator.add("509, 200, 100, 400"));
    }

    //step3
    @Test
    void shouldReturnProperSumForNumbersSeparatedWithNewLinesAndCommas() {
        assertEquals(22, calculator.add("5\n7, 10"));
        assertEquals(139, calculator.add("123\n7\n3\n6"));
        assertEquals(1209, calculator.add("509, 200, 100\n400"));
    }

    //step4
    @Test
    void shouldSupportSettingDelimiters() {
        assertEquals(3, calculator.add("//;\n1;2"));
        assertEquals(5, calculator.add("//x\n1x4"));
        assertEquals(8, calculator.add("//--\n1--7"));
    }

    @Test
    void shouldThrowProperExceptionForNegativeNumbers() {
        assertThrows(NegativesNotAllowedException.class, () -> calculator.add("5, -7, 10"));
        assertThrows(NegativesNotAllowedException.class, () -> calculator.add("-123, -7, -3, -6"));
        assertThrows(NegativesNotAllowedException.class, () -> calculator.add("1, 2, -3"));
        assertThrows(NegativesNotAllowedException.class, () -> calculator.add("//;\n-1;2"));
        assertThrows(NegativesNotAllowedException.class, () -> calculator.add("//;\n-1;-2"));
        assertThrows(NegativesNotAllowedException.class, () -> calculator.add("//;\n0;-2"));
    }
    @Test
    void shouldThrowCountNegative(){
        NegativesNotAllowedException exceptedException = assertThrows(NegativesNotAllowedException.class, () -> calculator.add("-1, 3, -2"));
        assertEquals("Negatives not allowed: 2", exceptedException.getMessage());
    }
}
