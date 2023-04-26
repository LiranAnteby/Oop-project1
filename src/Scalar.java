public interface Scalar {
    Scalar add(Scalar s);
    Scalar add(RationalScalar s);
    Scalar add(IntegerScalar s);
    Scalar mul(Scalar s);
    Scalar mul(IntegerScalar s);

    Scalar mul(RationalScalar s);


    Scalar neg();

    Scalar power(int exponent);

    int sign();

    boolean equals(Object o);

}
