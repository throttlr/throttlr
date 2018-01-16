package io.github.throttlr.twitter.cluster;

import twitter4j.Twitter;

import java.util.Set;

public interface ThrottlrTwitterBalancer extends Twitter {
    void addTwitter(Long id, Twitter twitter);
    Set<Long> getTwitterIdSet();
}
