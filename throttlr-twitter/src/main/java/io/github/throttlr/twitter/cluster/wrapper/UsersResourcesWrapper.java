package io.github.throttlr.twitter.cluster.wrapper;

import io.github.throttlr.twitter.cluster.strategy.LoadBalanceStrategy;
import io.github.throttlr.twitter.common.ResourceFamily;
import io.github.throttlr.twitter.internal.Either;
import twitter4j.*;
import twitter4j.api.UsersResources;

import java.io.File;
import java.io.InputStream;

public class UsersResourcesWrapper extends WrapperBase implements UsersResources {

    public UsersResourcesWrapper(LoadBalanceStrategy loadBalanceStrategy) {
        super(loadBalanceStrategy);
    }

    @Override
    public AccountSettings getAccountSettings() throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public User verifyCredentials() throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public AccountSettings updateAccountSettings(Integer trendLocationWoeid, Boolean sleepTimeEnabled, String startSleepTime, String endSleepTime, String timeZone, String lang) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public User updateProfile(String name, String url, String location, String description) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public User updateProfileBackgroundImage(File image, boolean tile) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public User updateProfileBackgroundImage(InputStream image, boolean tile) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    @SuppressWarnings("deprecation")
    public User updateProfileColors(String profileBackgroundColor, String profileTextColor, String profileLinkColor, String profileSidebarFillColor, String profileSidebarBorderColor) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public User updateProfileImage(File image) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public User updateProfileImage(InputStream image) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public PagableResponseList<User> getBlocksList() throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public PagableResponseList<User> getBlocksList(long cursor) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public IDs getBlocksIDs() throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public IDs getBlocksIDs(long cursor) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public User createBlock(long userId) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public User createBlock(String screenName) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public User destroyBlock(long userId) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public User destroyBlock(String screen_name) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public PagableResponseList<User> getMutesList(long cursor) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public IDs getMutesIDs(long cursor) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public User createMute(long userId) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public User createMute(String screenName) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public User destroyMute(long userId) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public User destroyMute(String screenName) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public ResponseList<User> lookupUsers(long... ids) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.usersLookup, (resources) -> {
            try {
                return Either.right(resources.lookupUsers(ids));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<User> lookupUsers(String... screenNames) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.usersLookup, (resources) -> {
            try {
                return Either.right(resources.lookupUsers(screenNames));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User showUser(long userId) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.usersShowId, (resources) -> {
            try {
                return Either.right(resources.showUser(userId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User showUser(String screenName) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.usersShowId, (resources) -> {
            try {
                return Either.right(resources.showUser(screenName));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<User> searchUsers(String query, int page) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.usersSearch, (resources) -> {
            try {
                return Either.right(resources.searchUsers(query, page));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<User> getContributees(long userId) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public ResponseList<User> getContributees(String screenName) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public ResponseList<User> getContributors(long userId) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public ResponseList<User> getContributors(String screenName) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeProfileBanner() throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateProfileBanner(File image) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateProfileBanner(InputStream image) throws TwitterException {
        throw new UnsupportedOperationException();
    }
}
