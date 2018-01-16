package throttlr.twitter.cluster;

import throttlr.twitter.cluster.strategy.LoadBalanceStrategy;
import throttlr.twitter.cluster.wrapper.*;
import twitter4j.*;
import twitter4j.api.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.Authorization;
import twitter4j.auth.OAuth2Token;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.util.function.Consumer;

import java.io.File;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;

public class ThrottlrTwitterBalancerImpl implements ThrottlrTwitterBalancer {

    private final LoadBalanceStrategy loadBalanceStrategy;
    private final Twitter twitter;
    private final TimelinesResources timelinesResources;
    private final TweetsResources tweetsResources;
    private final SearchResource searchResource;
    private final DirectMessagesResources directMessagesResources;
    private final FriendsFollowersResources friendsFollowersResources;
    private final UsersResources usersResources;
    private final SuggestedUsersResources suggestedUsersResources;
    private final FavoritesResources favoritesResources;
    private final ListsResources listsResources;
    private final SavedSearchesResources savedSearchesResources;
    private final PlacesGeoResources placesGeoResources;
    private final TrendsResources trendsResources;
    private final SpamReportingResource spamReportingResource;
    private final HelpResources helpResources;

    public ThrottlrTwitterBalancerImpl(Map<Long, Twitter> twitters, LoadBalanceStrategy loadBalanceStrategy) throws TwitterException {
        this.loadBalanceStrategy = loadBalanceStrategy;
        this.twitter = this;
        this.timelinesResources = new TimelinesResourcesWrapper(loadBalanceStrategy);
        this.tweetsResources = new TweetsResourcesWrapper(loadBalanceStrategy);
        this.searchResource = new SearchResourceWrapper(loadBalanceStrategy);
        this.directMessagesResources = new DirectMessagesResourcesWrapper(loadBalanceStrategy);
        this.friendsFollowersResources = new FriendsFollowersResourcesWrapper(loadBalanceStrategy);
        this.usersResources = new UsersResourcesWrapper(loadBalanceStrategy);
        this.suggestedUsersResources = new SuggestedUsersResourcesWrapper(loadBalanceStrategy);
        this.favoritesResources = new FavoritesResourcesWrapper(loadBalanceStrategy);
        this.listsResources = new ListsResourcesWrapper(loadBalanceStrategy);
        this.savedSearchesResources = new SavedSearchesResourcesWrapper(loadBalanceStrategy);
        this.placesGeoResources = new PlacesGeoResourcesWrapper(loadBalanceStrategy);
        this.trendsResources = new TrendsResourcesWrapper(loadBalanceStrategy);
        this.spamReportingResource = new SpamReportingResourceWrapper(loadBalanceStrategy);
        this.helpResources = new HelpResourcesWrapper(loadBalanceStrategy);
        loadBalanceStrategy.init(twitters);
    }

    @Override
    public void addTwitter(Long id, Twitter twitter) {
        loadBalanceStrategy.add(id, twitter);
    }

    @Override
    public Set<Long> getTwitterIdSet() {
        return loadBalanceStrategy.getTwitterIdSet();
    }

    /*
        TimelinesResources
     */
    @Override
    public TimelinesResources timelines() {
        return timelinesResources;
    }

    @Override
    public ResponseList<Status> getMentionsTimeline() throws TwitterException {
        return timelinesResources.getMentionsTimeline();
    }

    @Override
    public ResponseList<Status> getMentionsTimeline(Paging paging) throws TwitterException {
        return timelinesResources.getMentionsTimeline(paging);
    }

    @Override
    public ResponseList<Status> getUserTimeline(String screenName, Paging paging) throws TwitterException {
        return timelinesResources.getUserTimeline(screenName, paging);
    }

    @Override
    public ResponseList<Status> getUserTimeline(long userId, Paging paging) throws TwitterException {
        return timelinesResources.getUserTimeline(userId, paging);
    }

    @Override
    public ResponseList<Status> getUserTimeline(String screenName) throws TwitterException {
        return timelinesResources.getUserTimeline(screenName);
    }

    @Override
    public ResponseList<Status> getUserTimeline(long userId) throws TwitterException {
        return timelinesResources.getUserTimeline(userId);
    }

    @Override
    public ResponseList<Status> getUserTimeline() throws TwitterException {
        return timelinesResources.getUserTimeline();
    }

    @Override
    public ResponseList<Status> getUserTimeline(Paging paging) throws TwitterException {
        return timelinesResources.getUserTimeline(paging);
    }

    @Override
    public ResponseList<Status> getHomeTimeline() throws TwitterException {
        return timelinesResources.getHomeTimeline();
    }

    @Override
    public ResponseList<Status> getHomeTimeline(Paging paging) throws TwitterException {
        return timelinesResources.getHomeTimeline(paging);
    }

    @Override
    public ResponseList<Status> getRetweetsOfMe() throws TwitterException {
        return timelinesResources.getRetweetsOfMe();
    }

    @Override
    public ResponseList<Status> getRetweetsOfMe(Paging paging) throws TwitterException {
        return timelinesResources.getRetweetsOfMe(paging);
    }

    /*
        TweetsResources
     */
    @Override
    public TweetsResources tweets() {
        return tweetsResources;
    }

    @Override
    public ResponseList<Status> getRetweets(long statusId) throws TwitterException {
        return tweetsResources.getRetweets(statusId);
    }

    @Override
    public IDs getRetweeterIds(long statusId, long cursor) throws TwitterException {
        return tweetsResources.getRetweeterIds(statusId, cursor);
    }

    @Override
    public IDs getRetweeterIds(long statusId, int count, long cursor) throws TwitterException {
        return tweetsResources.getRetweeterIds(statusId, count, cursor);
    }

    @Override
    public Status showStatus(long id) throws TwitterException {
        return tweetsResources.showStatus(id);
    }

    @Override
    public Status destroyStatus(long statusId) throws TwitterException {
        return tweetsResources.destroyStatus(statusId);
    }

    @Override
    public Status updateStatus(String status) throws TwitterException {
        return tweetsResources.updateStatus(status);
    }

    @Override
    public Status updateStatus(StatusUpdate latestStatus) throws TwitterException {
        return tweetsResources.updateStatus(latestStatus);
    }

    @Override
    public Status retweetStatus(long statusId) throws TwitterException {
        return tweetsResources.retweetStatus(statusId);
    }

    @Override
    public OEmbed getOEmbed(OEmbedRequest req) throws TwitterException {
        return tweetsResources.getOEmbed(req);
    }

    @Override
    public ResponseList<Status> lookup(long... ids) throws TwitterException {
        return tweetsResources.lookup(ids);
    }

    @Override
    public UploadedMedia uploadMedia(File mediaFile) throws TwitterException {
        return tweetsResources.uploadMedia(mediaFile);
    }

    @Override
    public UploadedMedia uploadMedia(String fileName, InputStream media) throws TwitterException {
        return tweetsResources.uploadMedia(fileName, media);
    }

    /*
        SearchResource
     */
    @Override
    public SearchResource search() {
        return searchResource;
    }

    @Override
    public QueryResult search(Query query) throws TwitterException {
        return searchResource.search(query);
    }

    /*
        DirectMessagesResources
     */
    @Override
    public DirectMessagesResources directMessages() {
        return directMessagesResources;
    }

    @Override
    public ResponseList<DirectMessage> getDirectMessages() throws TwitterException {
        return directMessagesResources.getDirectMessages();
    }

    @Override
    public ResponseList<DirectMessage> getDirectMessages(Paging paging) throws TwitterException {
        return directMessagesResources.getDirectMessages(paging);
    }

    @Override
    public ResponseList<DirectMessage> getSentDirectMessages() throws TwitterException {
        return directMessagesResources.getSentDirectMessages();
    }

    @Override
    public ResponseList<DirectMessage> getSentDirectMessages(Paging paging) throws TwitterException {
        return directMessagesResources.getSentDirectMessages(paging);
    }

    @Override
    public DirectMessage showDirectMessage(long id) throws TwitterException {
        return directMessagesResources.showDirectMessage(id);
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

    /*
        FriendsFollowersResources
     */
    @Override
    public FriendsFollowersResources friendsFollowers() {
        return friendsFollowersResources;
    }

    @Override
    public IDs getNoRetweetsFriendships() throws TwitterException {
        return friendsFollowersResources.getNoRetweetsFriendships();
    }

    @Override
    public IDs getFriendsIDs(long cursor) throws TwitterException {
        return friendsFollowersResources.getFriendsIDs(cursor);
    }

    @Override
    public IDs getFriendsIDs(long userId, long cursor) throws TwitterException {
        return friendsFollowersResources.getFriendsIDs(userId, cursor);
    }

    @Override
    public IDs getFriendsIDs(long userId, long cursor, int count) throws TwitterException {
        return friendsFollowersResources.getFriendsIDs(userId, cursor, count);
    }

    @Override
    public IDs getFriendsIDs(String screenName, long cursor) throws TwitterException {
        return friendsFollowersResources.getFriendsIDs(screenName, cursor);
    }

    @Override
    public IDs getFriendsIDs(String screenName, long cursor, int count) throws TwitterException {
        return friendsFollowersResources.getFriendsIDs(screenName, cursor, count);
    }

    @Override
    public IDs getFollowersIDs(long cursor) throws TwitterException {
        return friendsFollowersResources.getFollowersIDs(cursor);
    }

    @Override
    public IDs getFollowersIDs(long userId, long cursor) throws TwitterException {
        return friendsFollowersResources.getFollowersIDs(userId, cursor);
    }

    @Override
    public IDs getFollowersIDs(long userId, long cursor, int count) throws TwitterException {
        return friendsFollowersResources.getFollowersIDs(userId, cursor, count);
    }

    @Override
    public IDs getFollowersIDs(String screenName, long cursor) throws TwitterException {
        return friendsFollowersResources.getFollowersIDs(screenName, cursor);
    }

    @Override
    public IDs getFollowersIDs(String screenName, long cursor, int count) throws TwitterException {
        return friendsFollowersResources.getFollowersIDs(screenName, cursor, count);
    }

    @Override
    public ResponseList<Friendship> lookupFriendships(long... ids) throws TwitterException {
        return friendsFollowersResources.lookupFriendships(ids);
    }

    @Override
    public ResponseList<Friendship> lookupFriendships(String... screenNames) throws TwitterException {
        return friendsFollowersResources.lookupFriendships(screenNames);
    }

    @Override
    public IDs getIncomingFriendships(long cursor) throws TwitterException {
        return friendsFollowersResources.getIncomingFriendships(cursor);
    }

    @Override
    public IDs getOutgoingFriendships(long cursor) throws TwitterException {
        return friendsFollowersResources.getOutgoingFriendships(cursor);
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
        return friendsFollowersResources.showFriendship(sourceId, targetId);
    }

    @Override
    public Relationship showFriendship(String sourceScreenName, String targetScreenName) throws TwitterException {
        return friendsFollowersResources.showFriendship(sourceScreenName, targetScreenName);
    }

    @Override
    public PagableResponseList<User> getFriendsList(long userId, long cursor) throws TwitterException {
        return friendsFollowersResources.getFriendsList(userId, cursor);
    }

    @Override
    public PagableResponseList<User> getFriendsList(long userId, long cursor, int count) throws TwitterException {
        return friendsFollowersResources.getFriendsList(userId, cursor, count);
    }

    @Override
    public PagableResponseList<User> getFriendsList(String screenName, long cursor) throws TwitterException {
        return friendsFollowersResources.getFriendsList(screenName, cursor);
    }

    @Override
    public PagableResponseList<User> getFriendsList(String screenName, long cursor, int count) throws TwitterException {
        return friendsFollowersResources.getFriendsList(screenName, cursor, count);
    }

    @Override
    public PagableResponseList<User> getFriendsList(long userId, long cursor, int count, boolean skipStatus, boolean includeUserEntities) throws TwitterException {
        return friendsFollowersResources.getFriendsList(userId, cursor, count, skipStatus, includeUserEntities);
    }

    @Override
    public PagableResponseList<User> getFriendsList(String screenName, long cursor, int count, boolean skipStatus, boolean includeUserEntities) throws TwitterException {
        return friendsFollowersResources.getFriendsList(screenName, cursor, count, skipStatus, includeUserEntities);
    }

    @Override
    public PagableResponseList<User> getFollowersList(long userId, long cursor) throws TwitterException {
        return friendsFollowersResources.getFollowersList(userId, cursor);
    }

    @Override
    public PagableResponseList<User> getFollowersList(String screenName, long cursor) throws TwitterException {
        return friendsFollowersResources.getFollowersList(screenName, cursor);
    }

    @Override
    public PagableResponseList<User> getFollowersList(long userId, long cursor, int count) throws TwitterException {
        return friendsFollowersResources.getFollowersList(userId, cursor, count);
    }

    @Override
    public PagableResponseList<User> getFollowersList(String screenName, long cursor, int count) throws TwitterException {
        return friendsFollowersResources.getFollowersList(screenName, cursor, count);
    }

    @Override
    public PagableResponseList<User> getFollowersList(long userId, long cursor, int count, boolean skipStatus, boolean includeUserEntities) throws TwitterException {
        return friendsFollowersResources.getFollowersList(userId, cursor, count, skipStatus, includeUserEntities);
    }

    @Override
    public PagableResponseList<User> getFollowersList(String screenName, long cursor, int count, boolean skipStatus, boolean includeUserEntities) throws TwitterException {
        return friendsFollowersResources.getFollowersList(screenName, cursor, count, skipStatus, includeUserEntities);
    }

    /*
        UsersResources
     */
    @Override
    public UsersResources users() {
        return usersResources;
    }

    @Override
    public AccountSettings getAccountSettings() throws TwitterException {
        return usersResources.getAccountSettings();
    }

    @Override
    public User verifyCredentials() throws TwitterException {
        return usersResources.verifyCredentials();
    }

    @Override
    public AccountSettings updateAccountSettings(Integer trendLocationWoeid, Boolean sleepTimeEnabled, String startSleepTime, String endSleepTime, String timeZone, String lang) throws TwitterException {
        return usersResources.updateAccountSettings(trendLocationWoeid, sleepTimeEnabled, startSleepTime, endSleepTime, timeZone, lang);
    }

    @Override
    public User updateProfile(String name, String url, String location, String description) throws TwitterException {
        return usersResources.updateProfile(name, url, location, description);
    }

    @Override
    public User updateProfileBackgroundImage(File image, boolean tile) throws TwitterException {
        return usersResources.updateProfileBackgroundImage(image, tile);
    }

    @Override
    public User updateProfileBackgroundImage(InputStream image, boolean tile) throws TwitterException {
        return usersResources.updateProfileBackgroundImage(image, tile);
    }

    @Override
    @Deprecated
    @SuppressWarnings("deprecation")
    public User updateProfileColors(String profileBackgroundColor, String profileTextColor, String profileLinkColor, String profileSidebarFillColor, String profileSidebarBorderColor) throws TwitterException {
        return usersResources.updateProfileColors(profileBackgroundColor, profileTextColor, profileLinkColor, profileSidebarFillColor, profileSidebarBorderColor);
    }

    @Override
    public User updateProfileImage(File image) throws TwitterException {
        return usersResources.updateProfileImage(image);
    }

    @Override
    public User updateProfileImage(InputStream image) throws TwitterException {
        return usersResources.updateProfileImage(image);
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
        return usersResources.getBlocksIDs();
    }

    @Override
    public IDs getBlocksIDs(long cursor) throws TwitterException {
        return usersResources.getBlocksIDs(cursor);
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
        return usersResources.getMutesList(cursor);
    }

    @Override
    public IDs getMutesIDs(long cursor) throws TwitterException {
        return usersResources.getMutesIDs(cursor);
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
        return usersResources.lookupUsers(ids);
    }

    @Override
    public ResponseList<User> lookupUsers(String... screenNames) throws TwitterException {
        return usersResources.lookupUsers(screenNames);
    }

    @Override
    public User showUser(long userId) throws TwitterException {
        return usersResources.showUser(userId);
    }

    @Override
    public User showUser(String screenName) throws TwitterException {
        return usersResources.showUser(screenName);
    }

    @Override
    public ResponseList<User> searchUsers(String query, int page) throws TwitterException {
        return usersResources.searchUsers(query, page);
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

    /*
        SuggestedUsersResources
     */
    @Override
    public SuggestedUsersResources suggestedUsers() {
        return suggestedUsersResources;
    }

    @Override
    public ResponseList<User> getUserSuggestions(String categorySlug) throws TwitterException {
        return suggestedUsersResources.getUserSuggestions(categorySlug);
    }

    @Override
    public ResponseList<Category> getSuggestedUserCategories() throws TwitterException {
        return suggestedUsersResources.getSuggestedUserCategories();
    }

    @Override
    public ResponseList<User> getMemberSuggestions(String categorySlug) throws TwitterException {
        return suggestedUsersResources.getMemberSuggestions(categorySlug);
    }

    /*
        FavoritesResources
     */
    @Override
    public FavoritesResources favorites() {
        return favoritesResources;
    }

    @Override
    public ResponseList<Status> getFavorites() throws TwitterException {
        return favoritesResources.getFavorites();
    }

    @Override
    public ResponseList<Status> getFavorites(long userId) throws TwitterException {
        return favoritesResources.getFavorites(userId);
    }

    @Override
    public ResponseList<Status> getFavorites(String screenName) throws TwitterException {
        return favoritesResources.getFavorites(screenName);
    }

    @Override
    public ResponseList<Status> getFavorites(Paging paging) throws TwitterException {
        return favoritesResources.getFavorites(paging);
    }

    @Override
    public ResponseList<Status> getFavorites(long userId, Paging paging) throws TwitterException {
        return favoritesResources.getFavorites(userId, paging);
    }

    @Override
    public ResponseList<Status> getFavorites(String screenName, Paging paging) throws TwitterException {
        return favoritesResources.getFavorites(screenName, paging);
    }

    @Override
    public Status createFavorite(long id) throws TwitterException {
        return favoritesResources.createFavorite(id);
    }

    @Override
    public Status destroyFavorite(long id) throws TwitterException {
        return favoritesResources.destroyFavorite(id);
    }

    /*
        ListsResources
     */
    @Override
    public ListsResources list() {
        return listsResources;
    }

    @Override
    public ResponseList<UserList> getUserLists(String listOwnerScreenName) throws TwitterException {
        return listsResources.getUserLists(listOwnerScreenName);
    }

    @Override
    public ResponseList<UserList> getUserLists(String listOwnerScreenName, boolean reverse) throws TwitterException {
        return listsResources.getUserLists(listOwnerScreenName, reverse);
    }

    @Override
    public ResponseList<UserList> getUserLists(long listOwnerUserId) throws TwitterException {
        return listsResources.getUserLists(listOwnerUserId);
    }

    @Override
    public ResponseList<UserList> getUserLists(long listOwnerUserId, boolean reverse) throws TwitterException {
        return listsResources.getUserLists(listOwnerUserId, reverse);
    }

    @Override
    public ResponseList<Status> getUserListStatuses(long listId, Paging paging) throws TwitterException {
        return listsResources.getUserListStatuses(listId, paging);
    }

    @Override
    public ResponseList<Status> getUserListStatuses(long ownerId, String slug, Paging paging) throws TwitterException {
        return listsResources.getUserListStatuses(ownerId, slug, paging);
    }

    @Override
    public ResponseList<Status> getUserListStatuses(String ownerScreenName, String slug, Paging paging) throws TwitterException {
        return listsResources.getUserListStatuses(ownerScreenName, slug, paging);
    }

    @Override
    public UserList destroyUserListMember(long listId, long userId) throws TwitterException {
        return listsResources.destroyUserListMember(listId, userId);
    }

    @Override
    public UserList destroyUserListMember(long listId, String screenName) throws TwitterException {
        return listsResources.destroyUserListMember(listId, screenName);
    }

    @Override
    public UserList destroyUserListMembers(long listId, String[] screenNames) throws TwitterException {
        return listsResources.destroyUserListMembers(listId, screenNames);
    }

    @Override
    public UserList destroyUserListMembers(long listId, long[] userIds) throws TwitterException {
        return listsResources.destroyUserListMembers(listId, userIds);
    }

    @Override
    public UserList destroyUserListMembers(String ownerScreenName, String slug, String[] screenNames) throws TwitterException {
        return listsResources.destroyUserListMembers(ownerScreenName, slug, screenNames);
    }

    @Override
    public UserList destroyUserListMember(long ownerId, String slug, long userId) throws TwitterException {
        return listsResources.destroyUserListMember(ownerId, slug, userId);
    }

    @Override
    public UserList destroyUserListMember(String ownerScreenName, String slug, long userId) throws TwitterException {
        return listsResources.destroyUserListMember(ownerScreenName, slug, userId);
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(long cursor) throws TwitterException {
        return listsResources.getUserListMemberships(cursor);
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(int count, long cursor) throws TwitterException {
        return listsResources.getUserListMemberships(count, cursor);
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(long listMemberId, long cursor) throws TwitterException {
        return listsResources.getUserListMemberships(listMemberId, cursor);
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(long listMemberId, int count, long cursor) throws TwitterException {
        return listsResources.getUserListMemberships(listMemberId, count, cursor);
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(String listMemberScreenName, long cursor) throws TwitterException {
        return listsResources.getUserListMemberships(listMemberScreenName, cursor);
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(String listMemberScreenName, int count, long cursor) throws TwitterException {
        return listsResources.getUserListMemberships(listMemberScreenName, count, cursor);
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(String listMemberScreenName, long cursor, boolean filterToOwnedLists) throws TwitterException {
        return listsResources.getUserListMemberships(listMemberScreenName, cursor, filterToOwnedLists);
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(String listMemberScreenName, int count, long cursor, boolean filterToOwnedLists) throws TwitterException {
        return listsResources.getUserListMemberships(listMemberScreenName, count, cursor, filterToOwnedLists);
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(long listMemberId, long cursor, boolean filterToOwnedLists) throws TwitterException {
        return listsResources.getUserListMemberships(listMemberId, cursor, filterToOwnedLists);
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(long listMemberId, int count, long cursor, boolean filterToOwnedLists) throws TwitterException {
        return listsResources.getUserListMemberships(listMemberId, count, cursor, filterToOwnedLists);
    }

    @Override
    public PagableResponseList<User> getUserListSubscribers(long listId, long cursor) throws TwitterException {
        return listsResources.getUserListSubscribers(listId, cursor);
    }

    @Override
    public PagableResponseList<User> getUserListSubscribers(long listId, int count, long cursor) throws TwitterException {
        return listsResources.getUserListSubscribers(listId, count, cursor);
    }

    @Override
    public PagableResponseList<User> getUserListSubscribers(long listId, int count, long cursor, boolean skipStatus) throws TwitterException {
        return listsResources.getUserListSubscribers(listId, count, cursor, skipStatus);
    }

    @Override
    public PagableResponseList<User> getUserListSubscribers(long ownerId, String slug, long cursor) throws TwitterException {
        return listsResources.getUserListSubscribers(ownerId, slug, cursor);
    }

    @Override
    public PagableResponseList<User> getUserListSubscribers(long ownerId, String slug, int count, long cursor) throws TwitterException {
        return listsResources.getUserListSubscribers(ownerId, slug, count, cursor);
    }

    @Override
    public PagableResponseList<User> getUserListSubscribers(long ownerId, String slug, int count, long cursor, boolean skipStatus) throws TwitterException {
        return listsResources.getUserListSubscribers(ownerId, slug, count, cursor, skipStatus);
    }

    @Override
    public PagableResponseList<User> getUserListSubscribers(String ownerScreenName, String slug, long cursor) throws TwitterException {
        return listsResources.getUserListSubscribers(ownerScreenName, slug, cursor);
    }

    @Override
    public PagableResponseList<User> getUserListSubscribers(String ownerScreenName, String slug, int count, long cursor) throws TwitterException {
        return listsResources.getUserListSubscribers(ownerScreenName, slug, count, cursor);
    }

    @Override
    public PagableResponseList<User> getUserListSubscribers(String ownerScreenName, String slug, int count, long cursor, boolean skipStatus) throws TwitterException {
        return listsResources.getUserListSubscribers(ownerScreenName, slug, count, cursor, skipStatus);
    }

    @Override
    public UserList createUserListSubscription(long listId) throws TwitterException {
        return listsResources.createUserListSubscription(listId);
    }

    @Override
    public UserList createUserListSubscription(long ownerId, String slug) throws TwitterException {
        return listsResources.createUserListSubscription(ownerId, slug);
    }

    @Override
    public UserList createUserListSubscription(String ownerScreenName, String slug) throws TwitterException {
        return listsResources.createUserListSubscription(ownerScreenName, slug);
    }

    @Override
    public User showUserListSubscription(long listId, long userId) throws TwitterException {
        return listsResources.showUserListSubscription(listId, userId);
    }

    @Override
    public User showUserListSubscription(long ownerId, String slug, long userId) throws TwitterException {
        return listsResources.showUserListSubscription(ownerId, slug, userId);
    }

    @Override
    public User showUserListSubscription(String ownerScreenName, String slug, long userId) throws TwitterException {
        return listsResources.showUserListSubscription(ownerScreenName, slug, userId);
    }

    @Override
    public UserList destroyUserListSubscription(long listId) throws TwitterException {
        return listsResources.destroyUserListSubscription(listId);
    }

    @Override
    public UserList destroyUserListSubscription(long ownerId, String slug) throws TwitterException {
        return listsResources.destroyUserListSubscription(ownerId, slug);
    }

    @Override
    public UserList destroyUserListSubscription(String ownerScreenName, String slug) throws TwitterException {
        return listsResources.destroyUserListSubscription(ownerScreenName, slug);
    }

    @Override
    public UserList createUserListMembers(long listId, long... userIds) throws TwitterException {
        return listsResources.createUserListMembers(listId, userIds);
    }

    @Override
    public UserList createUserListMembers(long ownerId, String slug, long... userIds) throws TwitterException {
        return listsResources.createUserListMembers(ownerId, slug, userIds);
    }

    @Override
    public UserList createUserListMembers(String ownerScreenName, String slug, long... userIds) throws TwitterException {
        return listsResources.createUserListMembers(ownerScreenName, slug, userIds);
    }

    @Override
    public UserList createUserListMembers(long listId, String... screenNames) throws TwitterException {
        return listsResources.createUserListMembers(listId, screenNames);
    }

    @Override
    public UserList createUserListMembers(long ownerId, String slug, String... screenNames) throws TwitterException {
        return listsResources.createUserListMembers(ownerId, slug, screenNames);
    }

    @Override
    public UserList createUserListMembers(String ownerScreenName, String slug, String... screenNames) throws TwitterException {
        return listsResources.createUserListMembers(ownerScreenName, slug, screenNames);
    }

    @Override
    public User showUserListMembership(long listId, long userId) throws TwitterException {
        return listsResources.showUserListMembership(listId, userId);
    }

    @Override
    public User showUserListMembership(long ownerId, String slug, long userId) throws TwitterException {
        return listsResources.showUserListMembership(ownerId, slug, userId);
    }

    @Override
    public User showUserListMembership(String ownerScreenName, String slug, long userId) throws TwitterException {
        return listsResources.showUserListMembership(ownerScreenName, slug, userId);
    }

    @Override
    public PagableResponseList<User> getUserListMembers(long listId, long cursor) throws TwitterException {
        return listsResources.getUserListMembers(listId, cursor);
    }

    @Override
    public PagableResponseList<User> getUserListMembers(long listId, int count, long cursor) throws TwitterException {
        return listsResources.getUserListMembers(listId, count, cursor);
    }

    @Override
    public PagableResponseList<User> getUserListMembers(long listId, int count, long cursor, boolean skipStatus) throws TwitterException {
        return listsResources.getUserListMembers(listId, count, cursor, skipStatus);
    }

    @Override
    public PagableResponseList<User> getUserListMembers(long ownerId, String slug, long cursor) throws TwitterException {
        return listsResources.getUserListMembers(ownerId, slug, cursor);
    }

    @Override
    public PagableResponseList<User> getUserListMembers(long ownerId, String slug, int count, long cursor) throws TwitterException {
        return listsResources.getUserListMembers(ownerId, slug, count, cursor);
    }

    @Override
    public PagableResponseList<User> getUserListMembers(long ownerId, String slug, int count, long cursor, boolean skipStatus) throws TwitterException {
        return listsResources.getUserListMembers(ownerId, slug, count, cursor, skipStatus);
    }

    @Override
    public PagableResponseList<User> getUserListMembers(String ownerScreenName, String slug, long cursor) throws TwitterException {
        return listsResources.getUserListMembers(ownerScreenName, slug, cursor);
    }

    @Override
    public PagableResponseList<User> getUserListMembers(String ownerScreenName, String slug, int count, long cursor) throws TwitterException {
        return listsResources.getUserListMembers(ownerScreenName, slug, count, cursor);
    }

    @Override
    public PagableResponseList<User> getUserListMembers(String ownerScreenName, String slug, int count, long cursor, boolean skipStatus) throws TwitterException {
        return listsResources.getUserListMembers(ownerScreenName, slug, count, cursor, skipStatus);
    }

    @Override
    public UserList createUserListMember(long listId, long userId) throws TwitterException {
        return listsResources.createUserListMember(listId, userId);
    }

    @Override
    public UserList createUserListMember(long ownerId, String slug, long userId) throws TwitterException {
        return listsResources.createUserListMember(ownerId, slug, userId);
    }

    @Override
    public UserList createUserListMember(String ownerScreenName, String slug, long userId) throws TwitterException {
        return listsResources.createUserListMember(ownerScreenName, slug, userId);
    }

    @Override
    public UserList destroyUserList(long listId) throws TwitterException {
        return listsResources.destroyUserList(listId);
    }

    @Override
    public UserList destroyUserList(long ownerId, String slug) throws TwitterException {
        return listsResources.destroyUserList(ownerId, slug);
    }

    @Override
    public UserList destroyUserList(String ownerScreenName, String slug) throws TwitterException {
        return listsResources.destroyUserList(ownerScreenName, slug);
    }

    @Override
    public UserList updateUserList(long listId, String newListName, boolean isPublicList, String newDescription) throws TwitterException {
        return listsResources.updateUserList(listId, newListName, isPublicList, newDescription);
    }

    @Override
    public UserList updateUserList(long ownerId, String slug, String newListName, boolean isPublicList, String newDescription) throws TwitterException {
        return listsResources.updateUserList(ownerId, slug, newListName, isPublicList, newDescription);
    }

    @Override
    public UserList updateUserList(String ownerScreenName, String slug, String newListName, boolean isPublicList, String newDescription) throws TwitterException {
        return listsResources.updateUserList(ownerScreenName, slug, newListName, isPublicList, newDescription);
    }

    @Override
    public UserList createUserList(String listName, boolean isPublicList, String description) throws TwitterException {
        return listsResources.createUserList(listName, isPublicList, description);
    }

    @Override
    public UserList showUserList(long listId) throws TwitterException {
        return listsResources.showUserList(listId);
    }

    @Override
    public UserList showUserList(long ownerId, String slug) throws TwitterException {
        return listsResources.showUserList(ownerId, slug);
    }

    @Override
    public UserList showUserList(String ownerScreenName, String slug) throws TwitterException {
        return listsResources.showUserList(ownerScreenName, slug);
    }

    @Override
    public PagableResponseList<UserList> getUserListSubscriptions(String listSubscriberScreenName, long cursor) throws TwitterException {
        return listsResources.getUserListSubscriptions(listSubscriberScreenName, cursor);
    }

    @Override
    public PagableResponseList<UserList> getUserListSubscriptions(String listSubscriberScreenName, int count, long cursor) throws TwitterException {
        return listsResources.getUserListSubscriptions(listSubscriberScreenName, count, cursor);
    }

    @Override
    public PagableResponseList<UserList> getUserListSubscriptions(long listSubscriberId, long cursor) throws TwitterException {
        return listsResources.getUserListSubscriptions(listSubscriberId, cursor);
    }

    @Override
    public PagableResponseList<UserList> getUserListSubscriptions(long listSubscriberId, int count, long cursor) throws TwitterException {
        return listsResources.getUserListSubscriptions(listSubscriberId, count, cursor);
    }

    @Override
    public PagableResponseList<UserList> getUserListsOwnerships(String listOwnerScreenName, long cursor) throws TwitterException {
        return listsResources.getUserListsOwnerships(listOwnerScreenName, cursor);
    }

    @Override
    public PagableResponseList<UserList> getUserListsOwnerships(String listOwnerScreenName, int count, long cursor) throws TwitterException {
        return listsResources.getUserListsOwnerships(listOwnerScreenName, count, cursor);
    }

    @Override
    public PagableResponseList<UserList> getUserListsOwnerships(long listOwnerId, long cursor) throws TwitterException {
        return listsResources.getUserListsOwnerships(listOwnerId, cursor);
    }

    @Override
    public PagableResponseList<UserList> getUserListsOwnerships(long listOwnerId, int count, long cursor) throws TwitterException {
        return listsResources.getUserListsOwnerships(listOwnerId, count, cursor);
    }

    /*
        SavedSearchesResources
     */
    @Override
    public SavedSearchesResources savedSearches() {
        return savedSearchesResources;
    }

    @Override
    public ResponseList<SavedSearch> getSavedSearches() throws TwitterException {
        return savedSearchesResources.getSavedSearches();
    }

    @Override
    public SavedSearch showSavedSearch(long id) throws TwitterException {
        return savedSearchesResources.showSavedSearch(id);
    }

    @Override
    public SavedSearch createSavedSearch(String query) throws TwitterException {
        return savedSearchesResources.createSavedSearch(query);
    }

    @Override
    public SavedSearch destroySavedSearch(long id) throws TwitterException {
        return savedSearchesResources.destroySavedSearch(id);
    }

    /*
        PlacesGeoResources
     */
    @Override
    public PlacesGeoResources placesGeo() {
        return placesGeoResources;
    }

    @Override
    public Place getGeoDetails(String placeId) throws TwitterException {
        return placesGeoResources.getGeoDetails(placeId);
    }

    @Override
    public ResponseList<Place> reverseGeoCode(GeoQuery query) throws TwitterException {
        return placesGeoResources.reverseGeoCode(query);
    }

    @Override
    public ResponseList<Place> searchPlaces(GeoQuery query) throws TwitterException {
        return placesGeoResources.searchPlaces(query);
    }

    @Override
    public ResponseList<Place> getSimilarPlaces(GeoLocation location, String name, String containedWithin, String streetAddress) throws TwitterException {
        return placesGeoResources.getSimilarPlaces(location, name, containedWithin, streetAddress);
    }

    /*
        TrendsResources
     */
    @Override
    public TrendsResources trends() {
        return trendsResources;
    }

    @Override
    public Trends getPlaceTrends(int woeid) throws TwitterException {
        return trendsResources.getPlaceTrends(woeid);
    }

    @Override
    public ResponseList<Location> getAvailableTrends() throws TwitterException {
        return trendsResources.getAvailableTrends();
    }

    @Override
    public ResponseList<Location> getClosestTrends(GeoLocation location) throws TwitterException {
        return trendsResources.getClosestTrends(location);
    }

    /*
        SpamReportingResource
     */
    @Override
    public SpamReportingResource spamReporting() {
        return spamReportingResource;
    }

    @Override
    public User reportSpam(long userId) throws TwitterException {
        return spamReportingResource.reportSpam(userId);
    }

    @Override
    public User reportSpam(String screenName) throws TwitterException {
        return spamReportingResource.reportSpam(screenName);
    }

    /*
        HelpResources
     */
    @Override
    public HelpResources help() {
        return helpResources;
    }

    @Override
    public TwitterAPIConfiguration getAPIConfiguration() throws TwitterException {
        return helpResources.getAPIConfiguration();
    }

    @Override
    public ResponseList<Language> getLanguages() throws TwitterException {
        return helpResources.getLanguages();
    }

    @Override
    public String getPrivacyPolicy() throws TwitterException {
        return helpResources.getPrivacyPolicy();
    }

    @Override
    public String getTermsOfService() throws TwitterException {
        return helpResources.getTermsOfService();
    }

    @Override
    public Map<String, RateLimitStatus> getRateLimitStatus() throws TwitterException {
        return helpResources.getRateLimitStatus();
    }

    @Override
    public Map<String, RateLimitStatus> getRateLimitStatus(String... resources) throws TwitterException {
        return helpResources.getRateLimitStatus(resources);
    }

    /*
        TwitterBase
        TODO: This implementation is not wrapped by delegated wrappers.
     */

    @Override
    public String getScreenName() throws TwitterException, IllegalStateException {
        return twitter.getScreenName();
    }

    @Override
    public long getId() throws TwitterException, IllegalStateException {
        return twitter.getId();
    }

    @Override
    public void addRateLimitStatusListener(RateLimitStatusListener listener) {
        twitter.addRateLimitStatusListener(listener);
    }

    @Override
    public void onRateLimitStatus(Consumer<RateLimitStatusEvent> action) {
        twitter.onRateLimitStatus(action);
    }

    @Override
    public void onRateLimitReached(Consumer<RateLimitStatusEvent> action) {
        twitter.onRateLimitReached(action);
    }

    @Override
    public Authorization getAuthorization() {
        return twitter.getAuthorization();
    }

    @Override
    public Configuration getConfiguration() {
        return twitter.getConfiguration();
    }

    /*
        OAuth2Support
        TODO: This implementation is not wrapped by delegated wrappers.
     */

    @Override
    public OAuth2Token getOAuth2Token() throws TwitterException {
        return twitter.getOAuth2Token();
    }

    @Override
    public void setOAuth2Token(OAuth2Token oauth2Token) {
        twitter.setOAuth2Token(oauth2Token);
    }

    @Override
    public void invalidateOAuth2Token() throws TwitterException {
        twitter.invalidateOAuth2Token();
    }

    /*
        OAuthSupport
        TODO: This implementation is not wrapped by delegated wrappers.
     */

    @Override
    public void setOAuthConsumer(String consumerKey, String consumerSecret) {
        twitter.setOAuthConsumer(consumerKey, consumerSecret);
    }

    @Override
    public RequestToken getOAuthRequestToken() throws TwitterException {
        return twitter.getOAuthRequestToken();
    }

    @Override
    public RequestToken getOAuthRequestToken(String callbackURL) throws TwitterException {
        return twitter.getOAuthRequestToken(callbackURL);
    }

    @Override
    public RequestToken getOAuthRequestToken(String callbackURL, String xAuthAccessType) throws TwitterException {
        return twitter.getOAuthRequestToken(callbackURL, xAuthAccessType);
    }

    @Override
    public RequestToken getOAuthRequestToken(String callbackURL, String xAuthAccessType, String xAuthMode) throws TwitterException {
        return twitter.getOAuthRequestToken(callbackURL, xAuthAccessType, xAuthMode);
    }

    @Override
    public AccessToken getOAuthAccessToken() throws TwitterException {
        return twitter.getOAuthAccessToken();
    }

    @Override
    public AccessToken getOAuthAccessToken(String oauthVerifier) throws TwitterException {
        return twitter.getOAuthAccessToken(oauthVerifier);
    }

    @Override
    public AccessToken getOAuthAccessToken(RequestToken requestToken) throws TwitterException {
        return twitter.getOAuthAccessToken(requestToken);
    }

    @Override
    public AccessToken getOAuthAccessToken(RequestToken requestToken, String oauthVerifier) throws TwitterException {
        return twitter.getOAuthAccessToken(requestToken, oauthVerifier);
    }

    @Override
    public AccessToken getOAuthAccessToken(String screenName, String password) throws TwitterException {
        return twitter.getOAuthAccessToken(screenName, password);
    }

    @Override
    public void setOAuthAccessToken(AccessToken accessToken) {
        twitter.setOAuthAccessToken(accessToken);
    }
}
