package io.github.throttlr.twitter.wrapper;

import io.github.throttlr.twitter.common.ResourceFamily;
import io.github.throttlr.twitter.internal.Either;
import io.github.throttlr.twitter.strategy.ThrottleStrategy;
import twitter4j.DirectMessage;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.api.DirectMessagesResources;

import java.io.InputStream;

public class DirectMessagesResourcesWrapper extends WrapperBase<DirectMessagesResources> implements DirectMessagesResources {

    public DirectMessagesResourcesWrapper(DirectMessagesResources directMessagesResources, ThrottleStrategy throttleStrategy) {
        super(directMessagesResources, throttleStrategy);
    }

    @Override
    public ResponseList<DirectMessage> getDirectMessages() throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.directMessages, () -> {
            try {
                return Either.right(resources.getDirectMessages());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<DirectMessage> getDirectMessages(Paging paging) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.directMessages, () -> {
            try {
                return Either.right(resources.getDirectMessages(paging));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<DirectMessage> getSentDirectMessages() throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.directMessagesSent, () -> {
            try {
                return Either.right(resources.getSentDirectMessages());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<DirectMessage> getSentDirectMessages(Paging paging) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.directMessagesSent, () -> {
            try {
                return Either.right(resources.getSentDirectMessages(paging));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public DirectMessage showDirectMessage(long id) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.directMessagesShow, () -> {
            try {
                return Either.right(resources.showDirectMessage(id));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public DirectMessage destroyDirectMessage(long id) throws TwitterException {
        return resources.destroyDirectMessage(id);
    }

    @Override
    public DirectMessage sendDirectMessage(long userId, String text) throws TwitterException {
        return resources.sendDirectMessage(userId, text);
    }

    @Override
    public DirectMessage sendDirectMessage(String screenName, String text) throws TwitterException {
        return resources.sendDirectMessage(screenName, text);
    }

    @Override
    public InputStream getDMImageAsStream(String url) throws TwitterException {
        return resources.getDMImageAsStream(url);
    }
}
