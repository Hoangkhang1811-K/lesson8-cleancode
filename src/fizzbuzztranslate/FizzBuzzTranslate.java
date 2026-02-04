package fizzbuzztranslate;



public class FizzBuzzTranslate {

    private static final int LIMIT = 100;

    public String translate(int number) {
        validate(number);

        if (isFizzBuzz(number)) return "FizzBuzz";
        if (isFizz(number)) return "Fizz";
        if (isBuzz(number)) return "Buzz";

        return toVietnamese(number);
    }

    private void validate(int number) {
        if (number <= 0) throw new IllegalArgumentException("number must be > 0");
        if (number >= LIMIT) throw new IllegalArgumentException("number must be < 100");
    }

    private boolean isFizzBuzz(int number) {
        // Ưu tiên FizzBuzz nếu vừa Fizz vừa Buzz (chia hết hoặc chứa chữ số)
        return isFizz(number) && isBuzz(number);
    }

    private boolean isFizz(int number) {
        return number % 3 == 0 || containsDigit(number, 3);
    }

    private boolean isBuzz(int number) {
        return number % 5 == 0 || containsDigit(number, 5);
    }

    private boolean containsDigit(int number, int digit) {
        int n = number;
        while (n > 0) {
            if (n % 10 == digit) return true;
            n /= 10;
        }
        return false;
    }

    private String toVietnamese(int number) {
        // bài yêu cầu đọc kiểu: 26 -> "hai sáu" (đọc từng chữ số)
        if (number < 10) return digitToWord(number);

        int tens = number / 10;
        int ones = number % 10;
        return digitToWord(tens) + " " + digitToWord(ones);
    }

    private String digitToWord(int digit) {
        switch (digit) {
            case 0: return "không";
            case 1: return "một";
            case 2: return "hai";
            case 3: return "ba";
            case 4: return "bốn";
            case 5: return "năm";
            case 6: return "sáu";
            case 7: return "bảy";
            case 8: return "tám";
            case 9: return "chín";
            default: throw new IllegalArgumentException("digit must be 0..9");
        }
    }
}
