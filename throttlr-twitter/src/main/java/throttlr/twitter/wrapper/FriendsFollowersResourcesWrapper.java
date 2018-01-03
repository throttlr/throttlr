package throttlr.twitter.wrapper;

import throttlr.twitter.internal.Either;
import throttlr.twitter.strategy.ThrottleStrategy;
import twitter4j.*;
import twitter4j.api.FriendsFollowersResources;

public class FriendsFollowersResourcesWrapper implements FriendsFollowersResources {

    private ThrottleStrategy throttleStrategy;
    private FriendsFollowersResources friendsFollowersResources;

    public FriendsFollowersResourcesWrapper(FriendsFollowersResources friendsFollowersResources, ThrottleStrategy throttleStrategy) {
        this.throttleStrategy = throttleStrategy;
        this.friendsFollowersResources = friendsFollowersResources;
    }

    @Override
    public IDs getNoRetweetsFriendships() throws TwitterException {
        return throttleStrategy.throttle("/friendships/no_retweets/ids", () -> {
            try {
                return Either.right(friendsFollowersResources.getNoRetweetsFriendships());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getFriendsIDs(long cursor) throws TwitterException {
        return throttleStrategy.throttle("/friends/ids", () -> {
            try {
                return Either.right(friendsFollowersResources.getFriendsIDs(cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getFriendsIDs(long userId, long cursor) throws TwitterException {
        return throttleStrategy.throttle("/friends/ids", () -> {
            try {
                return Either.right(friendsFollowersResources.getFriendsIDs(userId, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getFriendsIDs(long userId, long cursor, int count) throws TwitterException {
        return throttleStrategy.throttle("/friends/ids", () -> {
            try {
                return Either.right(friendsFollowersResources.getFriendsIDs(userId, cursor, count));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getFriendsIDs(String screenName, long cursor) throws TwitterException {
        return throttleStrategy.throttle("/friends/ids", () -> {
            try {
                return Either.right(friendsFollowersResources.getFriendsIDs(screenName, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getFriendsIDs(String screenName, long cursor, int count) throws TwitterException {
        return throttleStrategy.throttle("/friends/ids", () -> {
            try {
                return Either.right(friendsFollowersResources.getFriendsIDs(screenName, cursor, count));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getFollowersIDs(long cursor) throws TwitterException {
        return throttleStrategy.throttle("/followers/ids", () -> {
            try {
                return Either.right(friendsFollowersResources.getFollowersIDs(cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getFollowersIDs(long userId, long cursor) throws TwitterException {
        return throttleStrategy.throttle("/followers/ids", () -> {
            try {
                return Either.right(friendsFollowersResources.getFollowersIDs(userId, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getFollowersIDs(long userId, long cursor, int count) throws TwitterException {
        return throttleStrategy.throttle("/followers/ids", () -> {
            try {
                return Either.right(friendsFollowersResources.getFollowersIDs(userId, cursor, count));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getFollowersIDs(String screenName, long cursor) throws TwitterException {
        return throttleStrategy.throttle("/followers/ids", () -> {
            try {
                return Either.right(friendsFollowersResources.getFollowersIDs(screenName, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getFollowersIDs(String screenName, long cursor, int count) throws TwitterException {
        return throttleStrategy.throttle("/followers/ids", () -> {
            try {
                return Either.right(friendsFollowersResources.getFollowersIDs(screenName, cursor, count));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Friendship> lookupFriendships(long... ids) throws TwitterException {
        return throttleStrategy.throttle("/friendships/lookup", () -> {
            try {
                return Either.right(friendsFollowersResources.lookupFriendships(ids));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Friendship> lookupFriendships(String... screenNames) throws TwitterException {
        return throttleStrategy.throttle("/friendships/lookup", () -> {
            try {
                return Either.right(friendsFollowersResources.lookupFriendships(screenNames));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getIncomingFriendships(long cursor) throws TwitterException {
        return throttleStrategy.throttle("/friendships/incoming", () -> {
            try {
                return Either.right(friendsFollowersResources.getIncomingFriendships(cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getOutgoingFriendships(long cursor) throws TwitterException {
        return throttleStrategy.throttle("/friendships/outgoing", () -> {
            try {
                return Either.right(friendsFollowersResources.getOutgoingFriendships(cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User createFriendship(long userId) throws TwitterException {
        return friendsFollowersResources.createFriendship(userId);
    }

    @Override
    public User createFriendship(String screenName) throws TwitterException {
        return friendsFollowersResources.createFriendship(screenName);
    }

    @Override
    public User createFriendship(long userId, boolean follow) throws TwitterException {
        return friendsFollowersResources.createFriendship(userId, follow);
    }

    @Override
    public User createFriendship(String screenName, boolean follow) throws TwitterException {
        return friendsFollowersResources.createFriendship(screenName, follow);
    }

    @Override
    public User destroyFriendship(long userId) throws TwitterException {
        return friendsFollowersResources.destroyFriendship(userId);
    }

    @Override
    public User destroyFriendship(String screenName) throws TwitterException {
        return friendsFollowersResources.destroyFriendship(screenName);
    }

    @Override
    public Relationship updateFriendship(long userId, boolean enableDeviceNotification, boolean retweets) throws TwitterException {
        return friendsFollowersResources.updateFriendship(userId, enableDeviceNotification, retweets);
    }

    @Override
    public Relationship updateFriendship(String screenName, boolean enableDeviceNotification, boolean retweets) throws TwitterException {
        return friendsFollowersResources.updateFriendship(screenName, enableDeviceNotification, retweets);
    }

    @Override
    public Relationship showFriendship(long sourceId, long targetId) throws TwitterException {
        return throttleStrategy.throttle("/friendships/show", () -> {
            try {
                return Either.right(friendsFollowersResources.showFriendship(sourceId, targetId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public Relationship showFriendship(String sourceScreenName, String targetScreenName) throws TwitterException {
        return throttleStrategy.throttle("/friendships/show", () -> {
            try {
                return Either.right(friendsFollowersResources.showFriendship(sourceScreenName, targetScreenName));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFriendsList(long userId, long cursor) throws TwitterException {
        return throttleStrategy.throttle("/friends/list", () -> {
            try {
                return Either.right(friendsFollowersResources.getFriendsList(userId, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFriendsList(long userId, long cursor, int count) throws TwitterException {
        return throttleStrategy.throttle("/friends/list", () -> {
            try {
                return Either.right(friendsFollowersResources.getFriendsList(userId, cursor, count));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFriendsList(String screenName, long cursor) throws TwitterException {
        return throttleStrategy.throttle("/friends/list", () -> {
            try {
                return Either.right(friendsFollowersResources.getFriendsList(screenName, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFriendsList(String screenName, long cursor, int count) throws TwitterException {
        return throttleStrategy.throttle("/friends/list", () -> {
            try {
                return Either.right(friendsFollowersResources.getFriendsList(screenName, cursor, count));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFriendsList(long userId, long cursor, int count, boolean skipStatus, boolean includeUserEntities) throws TwitterException {
        return throttleStrategy.throttle("/friends/list", () -> {
            try {
                return Either.right(friendsFollowersResources.getFriendsList(userId, cursor, count, skipStatus, includeUserEntities));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFriendsList(String screenName, long cursor, int count, boolean skipStatus, boolean includeUserEntities) throws TwitterException {
        return throttleStrategy.throttle("/friends/list", () -> {
            try {
                return Either.right(friendsFollowersResources.getFriendsList(screenName, cursor, count, skipStatus, includeUserEntities));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFollowersList(long userId, long cursor) throws TwitterException {
        return throttleStrategy.throttle("/followers/list", () -> {
            try {
                return Either.right(friendsFollowersResources.getFollowersList(userId, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFollowersList(String screenName, long cursor) throws TwitterException {
        return throttleStrategy.throttle("/followers/list", () -> {
            try {
                return Either.right(friendsFollowersResources.getFollowersList(screenName, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFollowersList(long userId, long cursor, int count) throws TwitterException {
        return throttleStrategy.throttle("/followers/list", () -> {
            try {
                return Either.right(friendsFollowersResources.getFollowersList(userId, cursor, count));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFollowersList(String screenName, long cursor, int count) throws TwitterException {
        return throttleStrategy.throttle("/followers/list", () -> {
            try {
                return Either.right(friendsFollowersResources.getFollowersList(screenName, cursor, count));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFollowersList(long userId, long cursor, int count, boolean skipStatus, boolean includeUserEntities) throws TwitterException {
        return throttleStrategy.throttle("/followers/list", () -> {
            try {
                return Either.right(friendsFollowersResources.getFollowersList(userId, cursor, count, skipStatus, includeUserEntities));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFollowersList(String screenName, long cursor, int count, boolean skipStatus, boolean includeUserEntities) throws TwitterException {
        return throttleStrategy.throttle("/followers/list", () -> {
            try {
                return Either.right(friendsFollowersResources.getFollowersList(screenName, cursor, count, skipStatus, includeUserEntities));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }
}
