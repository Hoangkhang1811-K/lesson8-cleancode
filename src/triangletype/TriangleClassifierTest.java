package triangletype;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleClassifierTest {

    private final TriangleClassifier classifier = new TriangleClassifier();

    @Test
    void shouldReturnEquilateral_whenAllSidesEqual() {
        assertEquals(TriangleType.EQUILATERAL, classifier.classify(2, 2, 2));
    }

    @Test
    void shouldReturnIsosceles_whenTwoSidesEqual() {
        assertEquals(TriangleType.ISOSCELES, classifier.classify(2, 2, 3));
    }

    @Test
    void shouldReturnScalene_whenAllSidesDifferentAndValid() {
        assertEquals(TriangleType.SCALENE, classifier.classify(3, 4, 5));
    }

    @Test
    void shouldReturnNotATriangle_whenViolatesTriangleInequality() {
        assertEquals(TriangleType.NOT_A_TRIANGLE, classifier.classify(8, 2, 3));
    }

    @Test
    void shouldReturnNotATriangle_whenHasNegativeSide() {
        assertEquals(TriangleType.NOT_A_TRIANGLE, classifier.classify(-1, 2, 1));
    }

    @Test
    void shouldReturnNotATriangle_whenHasZeroSide() {
        assertEquals(TriangleType.NOT_A_TRIANGLE, classifier.classify(0, 1, 1));
    }
}

