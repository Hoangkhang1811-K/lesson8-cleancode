package nextdaycalculator;


public class NextDayCalculator {

    public MyDate nextDay(int day, int month, int year) {
        validate(day, month, year);

        int maxDay = daysInMonth(month, year);
        if (day < maxDay) {
            return new MyDate(day + 1, month, year);
        }

        // day == maxDay => sang tháng mới
        if (month < 12) {
            return new MyDate(1, month + 1, year);
        }

        // 31/12 => sang năm mới
        return new MyDate(1, 1, year + 1);
    }

    private void validate(int day, int month, int year) {
        if (year <= 0) throw new IllegalArgumentException("Year must be > 0");
        if (month < 1 || month > 12) throw new IllegalArgumentException("Month must be 1..12");
        int maxDay = daysInMonth(month, year);
        if (day < 1 || day > maxDay) throw new IllegalArgumentException("Invalid day for given month/year");
    }

    private int daysInMonth(int month, int year) {
        switch (month) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return 31;
        }
    }

    private boolean isLeapYear(int year) {
        // Năm nhuận: chia hết cho 400 hoặc (chia hết cho 4 và không chia hết cho 100)
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }
}

