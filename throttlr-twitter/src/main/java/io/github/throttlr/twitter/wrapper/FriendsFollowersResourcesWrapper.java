package io.github.throttlr.twitter.wrapper;

import io.github.throttlr.twitter.common.ResourceFamily;
import io.github.throttlr.twitter.internal.Either;
import io.github.throttlr.twitter.strategy.ThrottleStrategy;
import twitter4j.*;
import twitter4j.api.FriendsFollowersResources;

public class FriendsFollowersResourcesWrapper extends WrapperBase<FriendsFollowersResources> implements FriendsFollowersResources {

    public FriendsFollowersResourcesWrapper(FriendsFollowersResources friendsFollowersResources, ThrottleStrategy throttleStrategy) {
        super(friendsFollowersResources, throttleStrategy);
    }

    @Override
    public IDs getNoRetweetsFriendships() throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.friendshipsNoRetweetsIds, () -> {
            try {
                return Either.right(resources.getNoRetweetsFriendships());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getFriendsIDs(long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.friendsIds, () -> {
            try {
                return Either.right(resources.getFriendsIDs(cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getFriendsIDs(long userId, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.friendsIds, () -> {
            try {
                return Either.right(resources.getFriendsIDs(userId, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getFriendsIDs(long userId, long cursor, int count) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.friendsIds, () -> {
            try {
                return Either.right(resources.getFriendsIDs(userId, cursor, count));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getFriendsIDs(String screenName, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.friendsIds, () -> {
            try {
                return Either.right(resources.getFriendsIDs(screenName, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getFriendsIDs(String screenName, long cursor, int count) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.friendsIds, () -> {
            try {
                return Either.right(resources.getFriendsIDs(screenName, cursor, count));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getFollowersIDs(long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.followersIds, () -> {
            try {
                return Either.right(resources.getFollowersIDs(cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getFollowersIDs(long userId, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.followersIds, () -> {
            try {
                return Either.right(resources.getFollowersIDs(userId, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getFollowersIDs(long userId, long cursor, int count) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.followersIds, () -> {
            try {
                return Either.right(resources.getFollowersIDs(userId, cursor, count));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getFollowersIDs(String screenName, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.followersIds, () -> {
            try {
                return Either.right(resources.getFollowersIDs(screenName, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getFollowersIDs(String screenName, long cursor, int count) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.followersIds, () -> {
            try {
                return Either.right(resources.getFollowersIDs(screenName, cursor, count));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Friendship> lookupFriendships(long... ids) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.friendshipsLookup, () -> {
            try {
                return Either.right(resources.lookupFriendships(ids));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Friendship> lookupFriendships(String... screenNames) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.friendshipsLookup, () -> {
            try {
                return Either.right(resources.lookupFriendships(screenNames));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getIncomingFriendships(long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.friendshipsIncoming, () -> {
            try {
                return Either.right(resources.getIncomingFriendships(cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getOutgoingFriendships(long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.friendshipsOutgoing, () -> {
            try {
                return Either.right(resources.getOutgoingFriendships(cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User createFriendship(long userId) throws TwitterException {
        return resources.createFriendship(userId);
    }

    @Override
    public User createFriendship(String screenName) throws TwitterException {
        return resources.createFriendship(screenName);
    }

    @Override
    public User createFriendship(long userId, boolean follow) throws TwitterException {
        return resources.createFriendship(userId, follow);
    }

    @Override
    public User createFriendship(String screenName, boolean follow) throws TwitterException {
        return resources.createFriendship(screenName, follow);
    }

    @Override
    public User destroyFriendship(long userId) throws TwitterException {
        return resources.destroyFriendship(userId);
    }

    @Override
    public User destroyFriendship(String screenName) throws TwitterException {
        return resources.destroyFriendship(screenName);
    }

    @Override
    public Relationship updateFriendship(long userId, boolean enableDeviceNotification, boolean retweets) throws TwitterException {
        return resources.updateFriendship(userId, enableDeviceNotification, retweets);
    }

    @Override
    public Relationship updateFriendship(String screenName, boolean enableDeviceNotification, boolean retweets) throws TwitterException {
        return resources.updateFriendship(screenName, enableDeviceNotification, retweets);
    }

    @Override
    public Relationship showFriendship(long sourceId, long targetId) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.friendshipsShow, () -> {
            try {
                return Either.right(resources.showFriendship(sourceId, targetId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public Relationship showFriendship(String sourceScreenName, String targetScreenName) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.friendshipsShow, () -> {
            try {
                return Either.right(resources.showFriendship(sourceScreenName, targetScreenName));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFriendsList(long userId, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.friendsList, () -> {
            try {
                return Either.right(resources.getFriendsList(userId, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFriendsList(long userId, long cursor, int count) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.friendsList, () -> {
            try {
                return Either.right(resources.getFriendsList(userId, cursor, count));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFriendsList(String screenName, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.friendsList, () -> {
            try {
                return Either.right(resources.getFriendsList(screenName, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFriendsList(String screenName, long cursor, int count) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.friendsList, () -> {
            try {
                return Either.right(resources.getFriendsList(screenName, cursor, count));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFriendsList(long userId, long cursor, int count, boolean skipStatus, boolean includeUserEntities) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.friendsList, () -> {
            try {
                return Either.right(resources.getFriendsList(userId, cursor, count, skipStatus, includeUserEntities));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFriendsList(String screenName, long cursor, int count, boolean skipStatus, boolean includeUserEntities) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.friendsList, () -> {
            try {
                return Either.right(resources.getFriendsList(screenName, cursor, count, skipStatus, includeUserEntities));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFollowersList(long userId, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.followersList, () -> {
            try {
                return Either.right(resources.getFollowersList(userId, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFollowersList(String screenName, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.followersList, () -> {
            try {
                return Either.right(resources.getFollowersList(screenName, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFollowersList(long userId, long cursor, int count) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.followersList, () -> {
            try {
                return Either.right(resources.getFollowersList(userId, cursor, count));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFollowersList(String screenName, long cursor, int count) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.followersList, () -> {
            try {
                return Either.right(resources.getFollowersList(screenName, cursor, count));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFollowersList(long userId, long cursor, int count, boolean skipStatus, boolean includeUserEntities) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.followersList, () -> {
            try {
                return Either.right(resources.getFollowersList(userId, cursor, count, skipStatus, includeUserEntities));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getFollowersList(String screenName, long cursor, int count, boolean skipStatus, boolean includeUserEntities) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.followersList, () -> {
            try {
                return Either.right(resources.getFollowersList(screenName, cursor, count, skipStatus, includeUserEntities));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }
}
