package throttlr.twitter.cluster.wrapper;

import throttlr.twitter.cluster.strategy.LoadBalanceStrategy;
import twitter4j.DirectMessage;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.api.DirectMessagesResources;

import java.io.InputStream;

public class DirectMessagesResourcesWrapper extends WrapperBase implements DirectMessagesResources {

    public DirectMessagesResourcesWrapper(LoadBalanceStrategy loadBalanceStrategy) {
        super(loadBalanceStrategy);
    }

    @Override
    public ResponseList<DirectMessage> getDirectMessages() throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public ResponseList<DirectMessage> getDirectMessages(Paging paging) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public ResponseList<DirectMessage> getSentDirectMessages() throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public ResponseList<DirectMessage> getSentDirectMessages(Paging paging) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public DirectMessage showDirectMessage(long id) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public DirectMessage destroyDirectMessage(long id) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public DirectMessage sendDirectMessage(long userId, String text) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public DirectMessage sendDirectMessage(String screenName, String text) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public InputStream getDMImageAsStream(String url) throws TwitterException {
        throw new UnsupportedOperationException();
    }
}
