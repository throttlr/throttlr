package io.github.throttlr.twitter.strategy;

import io.github.throttlr.twitter.internal.Either;
import twitter4j.TwitterException;
import twitter4j.TwitterResponse;

import java.util.function.Supplier;

public interface ThrottleStrategy {
    <T extends TwitterResponse> T throttle(String resourceFamily, Supplier<Either<TwitterException, T>> supplier) throws TwitterException;
}
