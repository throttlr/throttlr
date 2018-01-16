package io.github.throttlr.twitter.internal;

public class Right<L, R> implements Either<L, R> {

    private final R value;

    Right(R value) {
        this.value = value;
    }

    @Override
    public boolean isLeft() {
        return false;
    }

    @Override
    public L getLeft() {
        throw new NullPointerException();
    }

    @Override
    public boolean isRight() {
        return true;
    }

    @Override
    public R getRight() {
        return value;
    }
}
