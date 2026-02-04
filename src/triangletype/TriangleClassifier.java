package triangletype;



public class TriangleClassifier {

    public TriangleType classify(int a, int b, int c) {
        if (!isValidTriangle(a, b, c)) {
            return TriangleType.NOT_A_TRIANGLE;
        }

        if (a == b && b == c) {
            return TriangleType.EQUILATERAL;
        }

        if (a == b || a == c || b == c) {
            return TriangleType.ISOSCELES;
        }

        return TriangleType.SCALENE;
    }

    private boolean isValidTriangle(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return false;

        // Dùng long để tránh overflow nếu số rất lớn
        long x = a, y = b, z = c;
        return x + y > z && x + z > y && y + z > x;
    }
}
