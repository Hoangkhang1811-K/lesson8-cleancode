package nextdaycalculator;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextDayCalculatorTest {

    private final NextDayCalculator calculator = new NextDayCalculator();

    @Test
    void shouldReturnNextDay_whenNormalDay() {
        assertEquals(new MyDate(2, 1, 2018), calculator.nextDay(1, 1, 2018));
    }

    @Test
    void shouldGoToNextMonth_whenEndOf31DayMonth() {
        assertEquals(new MyDate(1, 2, 2018), calculator.nextDay(31, 1, 2018));
    }

    @Test
    void shouldGoToNextMonth_whenEndOf30DayMonth() {
        assertEquals(new MyDate(1, 5, 2018), calculator.nextDay(30, 4, 2018));
    }

    @Test
    void shouldGoToMarch_whenFeb28_nonLeapYear() {
        assertEquals(new MyDate(1, 3, 2018), calculator.nextDay(28, 2, 2018));
    }

    @Test
    void shouldGoToMarch_whenFeb29_leapYear() {
        assertEquals(new MyDate(1, 3, 2020), calculator.nextDay(29, 2, 2020));
    }

    @Test
    void shouldGoToNextYear_whenDec31() {
        assertEquals(new MyDate(1, 1, 2019), calculator.nextDay(31, 12, 2018));
    }

    // (khuyến nghị) test input sai để code không “lệch”
    @Test
    void shouldThrow_whenInvalidDate() {
        assertThrows(IllegalArgumentException.class, () -> calculator.nextDay(31, 4, 2018)); // April chỉ 30
        assertThrows(IllegalArgumentException.class, () -> calculator.nextDay(29, 2, 2018)); // 2018 không nhuận
        assertThrows(IllegalArgumentException.class, () -> calculator.nextDay(0, 1, 2018));
        assertThrows(IllegalArgumentException.class, () -> calculator.nextDay(10, 13, 2018));
    }
}
