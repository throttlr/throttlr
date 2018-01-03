package throttlr.twitter.wrapper;

import throttlr.twitter.internal.Either;
import throttlr.twitter.strategy.ThrottleStrategy;
import twitter4j.DirectMessage;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.api.DirectMessagesResources;

import java.io.InputStream;

public class DirectMessagesResourcesWrapper implements DirectMessagesResources {

    private ThrottleStrategy throttleStrategy;
    private DirectMessagesResources directMessagesResources;

    public DirectMessagesResourcesWrapper(DirectMessagesResources directMessagesResources, ThrottleStrategy throttleStrategy) {
        this.throttleStrategy = throttleStrategy;
        this.directMessagesResources = directMessagesResources;
    }

    @Override
    public ResponseList<DirectMessage> getDirectMessages() throws TwitterException {
        return throttleStrategy.throttle("/direct_messages", () -> {
            try {
                return Either.right(directMessagesResources.getDirectMessages());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<DirectMessage> getDirectMessages(Paging paging) throws TwitterException {
        return throttleStrategy.throttle("/direct_messages", () -> {
            try {
                return Either.right(directMessagesResources.getDirectMessages(paging));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<DirectMessage> getSentDirectMessages() throws TwitterException {
        return throttleStrategy.throttle("/direct_messages/sent", () -> {
            try {
                return Either.right(directMessagesResources.getSentDirectMessages());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<DirectMessage> getSentDirectMessages(Paging paging) throws TwitterException {
        return throttleStrategy.throttle("/direct_messages/sent", () -> {
            try {
                return Either.right(directMessagesResources.getSentDirectMessages(paging));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public DirectMessage showDirectMessage(long id) throws TwitterException {
        return throttleStrategy.throttle("/direct_messages/show", () -> {
            try {
                return Either.right(directMessagesResources.showDirectMessage(id));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public DirectMessage destroyDirectMessage(long id) throws TwitterException {
        return directMessagesResources.destroyDirectMessage(id);
    }

    @Override
    public DirectMessage sendDirectMessage(long userId, String text) throws TwitterException {
        return directMessagesResources.sendDirectMessage(userId, text);
    }

    @Override
    public DirectMessage sendDirectMessage(String screenName, String text) throws TwitterException {
        return directMessagesResources.sendDirectMessage(screenName, text);
    }

    @Override
    public InputStream getDMImageAsStream(String url) throws TwitterException {
        return directMessagesResources.getDMImageAsStream(url);
    }
}
