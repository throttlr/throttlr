package throttlr.twitter.wrapper;

import throttlr.twitter.internal.Either;
import throttlr.twitter.strategy.ThrottleStrategy;
import twitter4j.*;
import twitter4j.api.UsersResources;

import java.io.File;
import java.io.InputStream;

public class UsersResourcesWrapper implements UsersResources {

    private ThrottleStrategy throttleStrategy;
    private UsersResources usersResources;

    public UsersResourcesWrapper(UsersResources usersResources, ThrottleStrategy throttleStrategy) {
        this.throttleStrategy = throttleStrategy;
        this.usersResources = usersResources;
    }

    @Override
    public AccountSettings getAccountSettings() throws TwitterException {
        return throttleStrategy.throttle("/account/settings", () -> {
            try {
                return Either.right(usersResources.getAccountSettings());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User verifyCredentials() throws TwitterException {
        return throttleStrategy.throttle("/account/verify_credentials", () -> {
            try {
                return Either.right(usersResources.verifyCredentials());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public AccountSettings updateAccountSettings(Integer trendLocationWoeid, Boolean sleepTimeEnabled, String startSleepTime, String endSleepTime, String timeZone, String lang) throws TwitterException {
        return throttleStrategy.throttle("/account/settings", () -> {
            try {
                return Either.right(usersResources.updateAccountSettings(trendLocationWoeid, sleepTimeEnabled, startSleepTime, endSleepTime, timeZone, lang));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User updateProfile(String name, String url, String location, String description) throws TwitterException {
        return throttleStrategy.throttle("/account/update_profile", () -> {
            try {
                return Either.right(usersResources.updateProfile(name, url, location, description));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User updateProfileBackgroundImage(File image, boolean tile) throws TwitterException {
        return throttleStrategy.throttle("/account/update_profile", () -> {
            try {
                return Either.right(usersResources.updateProfileBackgroundImage(image, tile));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User updateProfileBackgroundImage(InputStream image, boolean tile) throws TwitterException {
        return throttleStrategy.throttle("/account/update_profile", () -> {
            try {
                return Either.right(usersResources.updateProfileBackgroundImage(image, tile));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    @Deprecated
    @SuppressWarnings("deprecation")
    public User updateProfileColors(String profileBackgroundColor, String profileTextColor, String profileLinkColor, String profileSidebarFillColor, String profileSidebarBorderColor) throws TwitterException {
        return throttleStrategy.throttle("/account/update_profile", () -> {
            try {
                return Either.right(usersResources.updateProfileColors(profileBackgroundColor, profileTextColor, profileLinkColor, profileSidebarFillColor, profileSidebarBorderColor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User updateProfileImage(File image) throws TwitterException {
        return throttleStrategy.throttle("/account/update_profile", () -> {
            try {
                return Either.right(usersResources.updateProfileImage(image));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User updateProfileImage(InputStream image) throws TwitterException {
        return throttleStrategy.throttle("/account/update_profile", () -> {
            try {
                return Either.right(usersResources.updateProfileImage(image));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getBlocksList() throws TwitterException {
        return usersResources.getBlocksList();
    }

    @Override
    public PagableResponseList<User> getBlocksList(long cursor) throws TwitterException {
        return usersResources.getBlocksList(cursor);
    }

    @Override
    public IDs getBlocksIDs() throws TwitterException {
        return throttleStrategy.throttle("/blocks/ids", () -> {
            try {
                return Either.right(usersResources.getBlocksIDs());
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getBlocksIDs(long cursor) throws TwitterException {
        return throttleStrategy.throttle("/blocks/ids", () -> {
            try {
                return Either.right(usersResources.getBlocksIDs(cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User createBlock(long userId) throws TwitterException {
        return usersResources.createBlock(userId);
    }

    @Override
    public User createBlock(String screenName) throws TwitterException {
        return usersResources.createBlock(screenName);
    }

    @Override
    public User destroyBlock(long userId) throws TwitterException {
        return usersResources.destroyBlock(userId);
    }

    @Override
    public User destroyBlock(String screen_name) throws TwitterException {
        return usersResources.destroyBlock(screen_name);
    }

    @Override
    public PagableResponseList<User> getMutesList(long cursor) throws TwitterException {
        return throttleStrategy.throttle("/mutes/users/list", () -> {
            try {
                return Either.right(usersResources.getMutesList(cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public IDs getMutesIDs(long cursor) throws TwitterException {
        return throttleStrategy.throttle("/mutes/users/ids", () -> {
            try {
                return Either.right(usersResources.getMutesIDs(cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User createMute(long userId) throws TwitterException {
        return usersResources.createMute(userId);
    }

    @Override
    public User createMute(String screenName) throws TwitterException {
        return usersResources.createMute(screenName);
    }

    @Override
    public User destroyMute(long userId) throws TwitterException {
        return usersResources.destroyMute(userId);
    }

    @Override
    public User destroyMute(String screenName) throws TwitterException {
        return usersResources.destroyMute(screenName);
    }

    @Override
    public ResponseList<User> lookupUsers(long... ids) throws TwitterException {
        return throttleStrategy.throttle("/users/lookup", () -> {
            try {
                return Either.right(usersResources.lookupUsers(ids));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<User> lookupUsers(String... screenNames) throws TwitterException {
        return throttleStrategy.throttle("/users/lookup", () -> {
            try {
                return Either.right(usersResources.lookupUsers(screenNames));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User showUser(long userId) throws TwitterException {
        return throttleStrategy.throttle("/users/show/:id", () -> {
            try {
                return Either.right(usersResources.showUser(userId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User showUser(String screenName) throws TwitterException {
        return throttleStrategy.throttle("/users/show/:id", () -> {
            try {
                return Either.right(usersResources.showUser(screenName));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<User> searchUsers(String query, int page) throws TwitterException {
        return throttleStrategy.throttle("/users/search", () -> {
            try {
                return Either.right(usersResources.searchUsers(query, page));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<User> getContributees(long userId) throws TwitterException {
        return usersResources.getContributees(userId);
    }

    @Override
    public ResponseList<User> getContributees(String screenName) throws TwitterException {
        return usersResources.getContributees(screenName);
    }

    @Override
    public ResponseList<User> getContributors(long userId) throws TwitterException {
        return usersResources.getContributors(userId);
    }

    @Override
    public ResponseList<User> getContributors(String screenName) throws TwitterException {
        return usersResources.getContributors(screenName);
    }

    @Override
    public void removeProfileBanner() throws TwitterException {
        usersResources.removeProfileBanner();
    }

    @Override
    public void updateProfileBanner(File image) throws TwitterException {
        usersResources.updateProfileBanner(image);
    }

    @Override
    public void updateProfileBanner(InputStream image) throws TwitterException {
        usersResources.updateProfileBanner(image);
    }
}
