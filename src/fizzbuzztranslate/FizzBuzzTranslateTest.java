package fizzbuzztranslate;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTranslateTest {

    private final FizzBuzzTranslate fb = new FizzBuzzTranslate();

    // Cơ bản
    @Test
    void shouldReturnFizz_whenDivisibleBy3() {
        assertEquals("Fizz", fb.translate(9));
    }

    @Test
    void shouldReturnBuzz_whenDivisibleBy5() {
        assertEquals("Buzz", fb.translate(10));
    }

    @Test
    void shouldReturnFizzBuzz_whenDivisibleBy3And5() {
        assertEquals("FizzBuzz", fb.translate(15));
    }

    // Nâng cấp: chứa chữ số
    @Test
    void shouldReturnFizz_whenContainsDigit3() {
        assertEquals("Fizz", fb.translate(13));
    }

    @Test
    void shouldReturnBuzz_whenContainsDigit5() {
        assertEquals("Buzz", fb.translate(52));
    }

    @Test
    void shouldReturnFizzBuzz_whenFizzAndBuzzByContainsOrDivisible() {
        assertEquals("FizzBuzz", fb.translate(35)); // chứa 3 và chia hết 5
    }

    // Đọc số bằng chữ
    @Test
    void shouldReadSingleDigitNumber() {
        assertEquals("hai", fb.translate(2));
    }

    @Test
    void shouldReadTwoDigitNumber() {
        assertEquals("hai sáu", fb.translate(26));
    }

    // Validate
    @Test
    void shouldThrow_whenOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> fb.translate(0));
        assertThrows(IllegalArgumentException.class, () -> fb.translate(100));
    }
}
