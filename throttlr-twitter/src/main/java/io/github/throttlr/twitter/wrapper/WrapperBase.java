package io.github.throttlr.twitter.wrapper;

import io.github.throttlr.twitter.strategy.ThrottleStrategy;

class WrapperBase<T> {
    ThrottleStrategy throttleStrategy;
    T resources;

    WrapperBase(T resources, ThrottleStrategy throttleStrategy) {
        this.throttleStrategy = throttleStrategy;
        this.resources = resources;
    }
}
