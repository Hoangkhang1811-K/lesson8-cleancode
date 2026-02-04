package  triangletype;


public enum TriangleType {
    EQUILATERAL("tam giác đều"),
    ISOSCELES("tam giác cân"),
    SCALENE("tam giác thường"),
    NOT_A_TRIANGLE("không phải là tam giác");

    private final String label;

    TriangleType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
