package throttlr.twitter.internal;

public class SystemTimeSource implements TimeSource {
    @Override
    public int getNowTimeInSeconds() {
        return (int) (System.currentTimeMillis() / 1000);
    }
}
