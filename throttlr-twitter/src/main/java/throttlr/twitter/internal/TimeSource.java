package throttlr.twitter.internal;

public interface TimeSource {
    int getNowTimeInSeconds();
}
