package throttlr.twitter.wrapper;

import throttlr.twitter.common.ResourceFamily;
import throttlr.twitter.internal.Either;
import throttlr.twitter.strategy.ThrottleStrategy;
import twitter4j.*;
import twitter4j.api.UsersResources;

import java.io.File;
import java.io.InputStream;

public class UsersResourcesWrapper extends WrapperBase<UsersResources> implements UsersResources {

    public UsersResourcesWrapper(UsersResources usersResources, ThrottleStrategy throttleStrategy) {
        super(usersResources, throttleStrategy);
    }

    @Override
    public AccountSettings getAccountSettings() throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.accountSettings, () -> {
            try {
                return Either.right(resources.getAccountSettings());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User verifyCredentials() throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.accountVerifyCredentials, () -> {
            try {
                return Either.right(resources.verifyCredentials());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public AccountSettings updateAccountSettings(Integer trendLocationWoeid, Boolean sleepTimeEnabled, String startSleepTime, String endSleepTime, String timeZone, String lang) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.accountSettings, () -> {
            try {
                return Either.right(resources.updateAccountSettings(trendLocationWoeid, sleepTimeEnabled, startSleepTime, endSleepTime, timeZone, lang));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User updateProfile(String name, String url, String location, String description) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.accountUpdateProfile, () -> {
            try {
                return Either.right(resources.updateProfile(name, url, location, description));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User updateProfileBackgroundImage(File image, boolean tile) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.accountUpdateProfile, () -> {
            try {
                return Either.right(resources.updateProfileBackgroundImage(image, tile));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User updateProfileBackgroundImage(InputStream image, boolean tile) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.accountUpdateProfile, () -> {
            try {
                return Either.right(resources.updateProfileBackgroundImage(image, tile));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    @Deprecated
    @SuppressWarnings("deprecation")
    public User updateProfileColors(String profileBackgroundColor, String profileTextColor, String profileLinkColor, String profileSidebarFillColor, String profileSidebarBorderColor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.accountUpdateProfile, () -> {
            try {
                return Either.right(resources.updateProfileColors(profileBackgroundColor, profileTextColor, profileLinkColor, profileSidebarFillColor, profileSidebarBorderColor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User updateProfileImage(File image) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.accountUpdateProfile, () -> {
            try {
                return Either.right(resources.updateProfileImage(image));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User updateProfileImage(InputStream image) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.accountUpdateProfile, () -> {
            try {
                return Either.right(resources.updateProfileImage(image));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getBlocksList() throws TwitterException {
        return resources.getBlocksList();
    }

    @Override
    public PagableResponseList<User> getBlocksList(long cursor) throws TwitterException {
        return resources.getBlocksList(cursor);
    }

    @Override
    public IDs getBlocksIDs() throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.blocksIds, () -> {
            try {
                return Either.right(resources.getBlocksIDs());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getBlocksIDs(long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.blocksIds, () -> {
            try {
                return Either.right(resources.getBlocksIDs(cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User createBlock(long userId) throws TwitterException {
        return resources.createBlock(userId);
    }

    @Override
    public User createBlock(String screenName) throws TwitterException {
        return resources.createBlock(screenName);
    }

    @Override
    public User destroyBlock(long userId) throws TwitterException {
        return resources.destroyBlock(userId);
    }

    @Override
    public User destroyBlock(String screen_name) throws TwitterException {
        return resources.destroyBlock(screen_name);
    }

    @Override
    public PagableResponseList<User> getMutesList(long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.mutesUsersList, () -> {
            try {
                return Either.right(resources.getMutesList(cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getMutesIDs(long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.mutesUsersIds, () -> {
            try {
                return Either.right(resources.getMutesIDs(cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User createMute(long userId) throws TwitterException {
        return resources.createMute(userId);
    }

    @Override
    public User createMute(String screenName) throws TwitterException {
        return resources.createMute(screenName);
    }

    @Override
    public User destroyMute(long userId) throws TwitterException {
        return resources.destroyMute(userId);
    }

    @Override
    public User destroyMute(String screenName) throws TwitterException {
        return resources.destroyMute(screenName);
    }

    @Override
    public ResponseList<User> lookupUsers(long... ids) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.usersLookup, () -> {
            try {
                return Either.right(resources.lookupUsers(ids));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<User> lookupUsers(String... screenNames) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.usersLookup, () -> {
            try {
                return Either.right(resources.lookupUsers(screenNames));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User showUser(long userId) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.usersShowId, () -> {
            try {
                return Either.right(resources.showUser(userId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User showUser(String screenName) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.usersShowId, () -> {
            try {
                return Either.right(resources.showUser(screenName));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<User> searchUsers(String query, int page) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.usersSearch, () -> {
            try {
                return Either.right(resources.searchUsers(query, page));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<User> getContributees(long userId) throws TwitterException {
        return resources.getContributees(userId);
    }

    @Override
    public ResponseList<User> getContributees(String screenName) throws TwitterException {
        return resources.getContributees(screenName);
    }

    @Override
    public ResponseList<User> getContributors(long userId) throws TwitterException {
        return resources.getContributors(userId);
    }

    @Override
    public ResponseList<User> getContributors(String screenName) throws TwitterException {
        return resources.getContributors(screenName);
    }

    @Override
    public void removeProfileBanner() throws TwitterException {
        resources.removeProfileBanner();
    }

    @Override
    public void updateProfileBanner(File image) throws TwitterException {
        resources.updateProfileBanner(image);
    }

    @Override
    public void updateProfileBanner(InputStream image) throws TwitterException {
        resources.updateProfileBanner(image);
    }
}
