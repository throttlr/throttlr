package throttlr.twitter.internal;

public class Left<L, R> implements Either<L, R> {

    private final L value;

    Left(L value) {
        this.value = value;
    }

    @Override
    public boolean isLeft() {
        return true;
    }

    @Override
    public L getLeft() {
        return value;
    }

    @Override
    public boolean isRight() {
        return false;
    }

    @Override
    public R getRight() {
        throw new NullPointerException();
    }
}
