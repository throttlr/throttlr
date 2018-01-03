package throttlr.twitter.internal;

public interface Either<L, R> {

    boolean isLeft();

    L getLeft();

    boolean isRight();

    R getRight();

    static <L, R> Left<L, R> left(L value) {
        return new Left<>(value);
    }

    static <L, R> Right<L, R> right(R value) {
        return new Right<>(value);
    }
}
