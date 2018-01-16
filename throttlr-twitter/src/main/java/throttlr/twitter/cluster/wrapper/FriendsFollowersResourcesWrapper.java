package throttlr.twitter.cluster.wrapper;

import throttlr.twitter.cluster.strategy.LoadBalanceStrategy;
import throttlr.twitter.common.ResourceFamily;
import throttlr.twitter.internal.Either;
import twitter4j.*;
import twitter4j.api.FriendsFollowersResources;

public class FriendsFollowersResourcesWrapper extends WrapperBase implements FriendsFollowersResources {

    public FriendsFollowersResourcesWrapper(LoadBalanceStrategy loadBalanceStrategy) {
        super(loadBalanceStrategy);
    }

    @Override
    public IDs getNoRetweetsFriendships() throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public IDs getFriendsIDs(long cursor) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public IDs getFriendsIDs(long userId, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.friendsIds, (resources) -> {
            try {
                return Either.right(resources.getFriendsIDs(userId, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getFriendsIDs(long userId, long cursor, int count) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.friendsIds, (resources) -> {
            try {
                return Either.right(resources.getFriendsIDs(userId, cursor, count));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getFriendsIDs(String screenName, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.friendsIds, (resources) -> {
            try {
                return Either.right(resources.getFriendsIDs(screenName, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getFriendsIDs(String screenName, long cursor, int count) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.friendsIds, (resources) -> {
            try {
                return Either.right(resources.getFriendsIDs(screenName, cursor, count));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getFollowersIDs(long cursor) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public IDs getFollowersIDs(long userId, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.followersIds, (resources) -> {
            try {
                return Either.right(resources.getFollowersIDs(userId, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getFollowersIDs(long userId, long cursor, int count) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.followersIds, (resources) -> {
            try {
                return Either.right(resources.getFollowersIDs(userId, cursor, count));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getFollowersIDs(String screenName, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.followersIds, (resources) -> {
            try {
                return Either.right(resources.getFollowersIDs(screenName, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getFollowersIDs(String screenName, long cursor, int count) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.followersIds, (resources) -> {
            try {
                return Either.right(resources.getFollowersIDs(screenName, cursor, count));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Friendship> lookupFriendships(long... ids) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.friendshipsLookup, (resources) -> {
            try {
                return Either.right(resources.lookupFriendships(ids));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Friendship> lookupFriendships(String... screenNames) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.friendshipsLookup, (resources) -> {
            try {
                return Either.right(resources.lookupFriendships(screenNames));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getIncomingFriendships(long cursor) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public IDs getOutgoingFriendships(long cursor) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public User createFriendship(long userId) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public User createFriendship(String screenName) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public User createFriendship(long userId, boolean follow) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public User createFriendship(String screenName, boolean follow) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public User destroyFriendship(long userId) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public User destroyFriendship(String screenName) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Relationship updateFriendship(long userId, boolean enableDeviceNotification, boolean retweets) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Relationship updateFriendship(String screenName, boolean enableDeviceNotification, boolean retweets) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Relationship showFriendship(long sourceId, long targetId) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.friendshipsShow, (resources) -> {
            try {
                return Either.right(resources.showFriendship(sourceId, targetId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public Relationship showFriendship(String sourceScreenName, String targetScreenName) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.friendshipsShow, (resources) -> {
            try {
                return Either.right(resources.showFriendship(sourceScreenName, targetScreenName));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFriendsList(long userId, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.friendsList, (resources) -> {
            try {
                return Either.right(resources.getFriendsList(userId, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFriendsList(long userId, long cursor, int count) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.friendsList, (resources) -> {
            try {
                return Either.right(resources.getFriendsList(userId, cursor, count));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFriendsList(String screenName, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.friendsList, (resources) -> {
            try {
                return Either.right(resources.getFriendsList(screenName, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFriendsList(String screenName, long cursor, int count) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.friendsList, (resources) -> {
            try {
                return Either.right(resources.getFriendsList(screenName, cursor, count));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFriendsList(long userId, long cursor, int count, boolean skipStatus, boolean includeUserEntities) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.friendsList, (resources) -> {
            try {
                return Either.right(resources.getFriendsList(userId, cursor, count, skipStatus, includeUserEntities));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFriendsList(String screenName, long cursor, int count, boolean skipStatus, boolean includeUserEntities) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.friendsList, (resources) -> {
            try {
                return Either.right(resources.getFriendsList(screenName, cursor, count, skipStatus, includeUserEntities));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFollowersList(long userId, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.followersList, (resources) -> {
            try {
                return Either.right(resources.getFollowersList(userId, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFollowersList(String screenName, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.followersList, (resources) -> {
            try {
                return Either.right(resources.getFollowersList(screenName, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFollowersList(long userId, long cursor, int count) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.followersList, (resources) -> {
            try {
                return Either.right(resources.getFollowersList(userId, cursor, count));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFollowersList(String screenName, long cursor, int count) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.followersList, (resources) -> {
            try {
                return Either.right(resources.getFollowersList(screenName, cursor, count));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFollowersList(long userId, long cursor, int count, boolean skipStatus, boolean includeUserEntities) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.followersList, (resources) -> {
            try {
                return Either.right(resources.getFollowersList(userId, cursor, count, skipStatus, includeUserEntities));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFollowersList(String screenName, long cursor, int count, boolean skipStatus, boolean includeUserEntities) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.followersList, (resources) -> {
            try {
                return Either.right(resources.getFollowersList(screenName, cursor, count, skipStatus, includeUserEntities));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }
}
