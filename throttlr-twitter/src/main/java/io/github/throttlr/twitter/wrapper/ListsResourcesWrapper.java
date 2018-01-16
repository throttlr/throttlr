package io.github.throttlr.twitter.wrapper;

import io.github.throttlr.twitter.common.ResourceFamily;
import io.github.throttlr.twitter.internal.Either;
import io.github.throttlr.twitter.strategy.ThrottleStrategy;
import twitter4j.*;
import twitter4j.api.ListsResources;

public class ListsResourcesWrapper extends WrapperBase<ListsResources> implements ListsResources {

    public ListsResourcesWrapper(ListsResources listsResources, ThrottleStrategy throttleStrategy) {
        super(listsResources, throttleStrategy);
    }

    @Override
    public ResponseList<UserList> getUserLists(String listOwnerScreenName) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsList, () -> {
            try {
                return Either.right(resources.getUserLists(listOwnerScreenName));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<UserList> getUserLists(String listOwnerScreenName, boolean reverse) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsList, () -> {
            try {
                return Either.right(resources.getUserLists(listOwnerScreenName, reverse));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<UserList> getUserLists(long listOwnerUserId) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsList, () -> {
            try {
                return Either.right(resources.getUserLists(listOwnerUserId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<UserList> getUserLists(long listOwnerUserId, boolean reverse) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsList, () -> {
            try {
                return Either.right(resources.getUserLists(listOwnerUserId, reverse));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getUserListStatuses(long listId, Paging paging) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsStatuses, () -> {
            try {
                return Either.right(resources.getUserListStatuses(listId, paging));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getUserListStatuses(long ownerId, String slug, Paging paging) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsStatuses, () -> {
            try {
                return Either.right(resources.getUserListStatuses(ownerId, slug, paging));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getUserListStatuses(String ownerScreenName, String slug, Paging paging) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsStatuses, () -> {
            try {
                return Either.right(resources.getUserListStatuses(ownerScreenName, slug, paging));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public UserList destroyUserListMember(long listId, long userId) throws TwitterException {
        return resources.destroyUserListMember(listId, userId);
    }

    @Override
    public UserList destroyUserListMember(long listId, String screenName) throws TwitterException {
        return resources.destroyUserListMember(listId, screenName);
    }

    @Override
    public UserList destroyUserListMembers(long listId, String[] screenNames) throws TwitterException {
        return resources.destroyUserListMembers(listId, screenNames);
    }

    @Override
    public UserList destroyUserListMembers(long listId, long[] userIds) throws TwitterException {
        return resources.destroyUserListMembers(listId, userIds);
    }

    @Override
    public UserList destroyUserListMembers(String ownerScreenName, String slug, String[] screenNames) throws TwitterException {
        return resources.destroyUserListMembers(ownerScreenName, slug, screenNames);
    }

    @Override
    public UserList destroyUserListMember(long ownerId, String slug, long userId) throws TwitterException {
        return resources.destroyUserListMember(ownerId, slug, userId);
    }

    @Override
    public UserList destroyUserListMember(String ownerScreenName, String slug, long userId) throws TwitterException {
        return resources.destroyUserListMember(ownerScreenName, slug, userId);
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsMemberships, () -> {
            try {
                return Either.right(resources.getUserListMemberships(cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(int count, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsMemberships, () -> {
            try {
                return Either.right(resources.getUserListMemberships(count, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(long listMemberId, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsMemberships, () -> {
            try {
                return Either.right(resources.getUserListMemberships(listMemberId, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(long listMemberId, int count, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsMemberships, () -> {
            try {
                return Either.right(resources.getUserListMemberships(listMemberId, count, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(String listMemberScreenName, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsMemberships, () -> {
            try {
                return Either.right(resources.getUserListMemberships(listMemberScreenName, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(String listMemberScreenName, int count, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsMemberships, () -> {
            try {
                return Either.right(resources.getUserListMemberships(listMemberScreenName, count, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(String listMemberScreenName, long cursor, boolean filterToOwnedLists) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsMemberships, () -> {
            try {
                return Either.right(resources.getUserListMemberships(listMemberScreenName, cursor, filterToOwnedLists));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(String listMemberScreenName, int count, long cursor, boolean filterToOwnedLists) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsMemberships, () -> {
            try {
                return Either.right(resources.getUserListMemberships(listMemberScreenName, count, cursor, filterToOwnedLists));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(long listMemberId, long cursor, boolean filterToOwnedLists) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsMemberships, () -> {
            try {
                return Either.right(resources.getUserListMemberships(listMemberId, cursor, filterToOwnedLists));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(long listMemberId, int count, long cursor, boolean filterToOwnedLists) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsMemberships, () -> {
            try {
                return Either.right(resources.getUserListMemberships(listMemberId, count, cursor, filterToOwnedLists));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListSubscribers(long listId, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsSubscribers, () -> {
            try {
                return Either.right(resources.getUserListSubscribers(listId, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListSubscribers(long listId, int count, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsSubscribers, () -> {
            try {
                return Either.right(resources.getUserListSubscribers(listId, count, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListSubscribers(long listId, int count, long cursor, boolean skipStatus) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsSubscribers, () -> {
            try {
                return Either.right(resources.getUserListSubscribers(listId, count, cursor, skipStatus));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListSubscribers(long ownerId, String slug, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsSubscribers, () -> {
            try {
                return Either.right(resources.getUserListSubscribers(ownerId, slug, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListSubscribers(long ownerId, String slug, int count, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsSubscribers, () -> {
            try {
                return Either.right(resources.getUserListSubscribers(ownerId, slug, count, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListSubscribers(long ownerId, String slug, int count, long cursor, boolean skipStatus) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsSubscribers, () -> {
            try {
                return Either.right(resources.getUserListSubscribers(ownerId, slug, count, cursor, skipStatus));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListSubscribers(String ownerScreenName, String slug, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsSubscribers, () -> {
            try {
                return Either.right(resources.getUserListSubscribers(ownerScreenName, slug, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListSubscribers(String ownerScreenName, String slug, int count, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsSubscribers, () -> {
            try {
                return Either.right(resources.getUserListSubscribers(ownerScreenName, slug, count, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListSubscribers(String ownerScreenName, String slug, int count, long cursor, boolean skipStatus) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsSubscribers, () -> {
            try {
                return Either.right(resources.getUserListSubscribers(ownerScreenName, slug, count, cursor, skipStatus));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public UserList createUserListSubscription(long listId) throws TwitterException {
        return resources.createUserListSubscription(listId);
    }

    @Override
    public UserList createUserListSubscription(long ownerId, String slug) throws TwitterException {
        return resources.createUserListSubscription(ownerId, slug);
    }

    @Override
    public UserList createUserListSubscription(String ownerScreenName, String slug) throws TwitterException {
        return resources.createUserListSubscription(ownerScreenName, slug);
    }

    @Override
    public User showUserListSubscription(long listId, long userId) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsSubscribersShow, () -> {
            try {
                return Either.right(resources.showUserListSubscription(listId, userId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User showUserListSubscription(long ownerId, String slug, long userId) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsSubscribersShow, () -> {
            try {
                return Either.right(resources.showUserListSubscription(ownerId, slug, userId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User showUserListSubscription(String ownerScreenName, String slug, long userId) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsSubscribersShow, () -> {
            try {
                return Either.right(resources.showUserListSubscription(ownerScreenName, slug, userId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public UserList destroyUserListSubscription(long listId) throws TwitterException {
        return resources.destroyUserListSubscription(listId);
    }

    @Override
    public UserList destroyUserListSubscription(long ownerId, String slug) throws TwitterException {
        return resources.destroyUserListSubscription(ownerId, slug);
    }

    @Override
    public UserList destroyUserListSubscription(String ownerScreenName, String slug) throws TwitterException {
        return resources.destroyUserListSubscription(ownerScreenName, slug);
    }

    @Override
    public UserList createUserListMembers(long listId, long... userIds) throws TwitterException {
        return resources.createUserListMembers(listId, userIds);
    }

    @Override
    public UserList createUserListMembers(long ownerId, String slug, long... userIds) throws TwitterException {
        return resources.createUserListMembers(ownerId, slug, userIds);
    }

    @Override
    public UserList createUserListMembers(String ownerScreenName, String slug, long... userIds) throws TwitterException {
        return resources.createUserListMembers(ownerScreenName, slug, userIds);
    }

    @Override
    public UserList createUserListMembers(long listId, String... screenNames) throws TwitterException {
        return resources.createUserListMembers(listId, screenNames);
    }

    @Override
    public UserList createUserListMembers(long ownerId, String slug, String... screenNames) throws TwitterException {
        return resources.createUserListMembers(ownerId, slug, screenNames);
    }

    @Override
    public UserList createUserListMembers(String ownerScreenName, String slug, String... screenNames) throws TwitterException {
        return resources.createUserListMembers(ownerScreenName, slug, screenNames);
    }

    @Override
    public User showUserListMembership(long listId, long userId) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsMembersShow, () -> {
            try {
                return Either.right(resources.showUserListMembership(listId, userId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User showUserListMembership(long ownerId, String slug, long userId) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsMembersShow, () -> {
            try {
                return Either.right(resources.showUserListMembership(ownerId, slug, userId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User showUserListMembership(String ownerScreenName, String slug, long userId) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsMembersShow, () -> {
            try {
                return Either.right(resources.showUserListMembership(ownerScreenName, slug, userId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListMembers(long listId, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsMembers, () -> {
            try {
                return Either.right(resources.getUserListMembers(listId, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListMembers(long listId, int count, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsMembers, () -> {
            try {
                return Either.right(resources.getUserListMembers(listId, count, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListMembers(long listId, int count, long cursor, boolean skipStatus) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsMembers, () -> {
            try {
                return Either.right(resources.getUserListMembers(listId, count, cursor, skipStatus));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListMembers(long ownerId, String slug, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsMembers, () -> {
            try {
                return Either.right(resources.getUserListMembers(ownerId, slug, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListMembers(long ownerId, String slug, int count, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsMembers, () -> {
            try {
                return Either.right(resources.getUserListMembers(ownerId, slug, count, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListMembers(long ownerId, String slug, int count, long cursor, boolean skipStatus) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsMembers, () -> {
            try {
                return Either.right(resources.getUserListMembers(ownerId, slug, count, cursor, skipStatus));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListMembers(String ownerScreenName, String slug, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsMembers, () -> {
            try {
                return Either.right(resources.getUserListMembers(ownerScreenName, slug, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListMembers(String ownerScreenName, String slug, int count, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsMembers, () -> {
            try {
                return Either.right(resources.getUserListMembers(ownerScreenName, slug, count, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListMembers(String ownerScreenName, String slug, int count, long cursor, boolean skipStatus) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsMembers, () -> {
            try {
                return Either.right(resources.getUserListMembers(ownerScreenName, slug, count, cursor, skipStatus));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public UserList createUserListMember(long listId, long userId) throws TwitterException {
        return resources.createUserListMember(listId, userId);
    }

    @Override
    public UserList createUserListMember(long ownerId, String slug, long userId) throws TwitterException {
        return resources.createUserListMember(ownerId, slug, userId);
    }

    @Override
    public UserList createUserListMember(String ownerScreenName, String slug, long userId) throws TwitterException {
        return resources.createUserListMember(ownerScreenName, slug, userId);
    }

    @Override
    public UserList destroyUserList(long listId) throws TwitterException {
        return resources.destroyUserList(listId);
    }

    @Override
    public UserList destroyUserList(long ownerId, String slug) throws TwitterException {
        return resources.destroyUserList(ownerId, slug);
    }

    @Override
    public UserList destroyUserList(String ownerScreenName, String slug) throws TwitterException {
        return resources.destroyUserList(ownerScreenName, slug);
    }

    @Override
    public UserList updateUserList(long listId, String newListName, boolean isPublicList, String newDescription) throws TwitterException {
        return resources.updateUserList(listId, newListName, isPublicList, newDescription);
    }

    @Override
    public UserList updateUserList(long ownerId, String slug, String newListName, boolean isPublicList, String newDescription) throws TwitterException {
        return resources.updateUserList(ownerId, slug, newListName, isPublicList, newDescription);
    }

    @Override
    public UserList updateUserList(String ownerScreenName, String slug, String newListName, boolean isPublicList, String newDescription) throws TwitterException {
        return resources.updateUserList(ownerScreenName, slug, newListName, isPublicList, newDescription);
    }

    @Override
    public UserList createUserList(String listName, boolean isPublicList, String description) throws TwitterException {
        return resources.createUserList(listName, isPublicList, description);
    }

    @Override
    public UserList showUserList(long listId) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsShow, () -> {
            try {
                return Either.right(resources.showUserList(listId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public UserList showUserList(long ownerId, String slug) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsShow, () -> {
            try {
                return Either.right(resources.showUserList(ownerId, slug));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public UserList showUserList(String ownerScreenName, String slug) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsShow, () -> {
            try {
                return Either.right(resources.showUserList(ownerScreenName, slug));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListSubscriptions(String listSubscriberScreenName, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsSubscriptions, () -> {
            try {
                return Either.right(resources.getUserListSubscriptions(listSubscriberScreenName, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListSubscriptions(String listSubscriberScreenName, int count, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsSubscriptions, () -> {
            try {
                return Either.right(resources.getUserListSubscriptions(listSubscriberScreenName, count, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListSubscriptions(long listSubscriberId, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsSubscriptions, () -> {
            try {
                return Either.right(resources.getUserListSubscriptions(listSubscriberId, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListSubscriptions(long listSubscriberId, int count, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsSubscriptions, () -> {
            try {
                return Either.right(resources.getUserListSubscriptions(listSubscriberId, count, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListsOwnerships(String listOwnerScreenName, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsOwnerships, () -> {
            try {
                return Either.right(resources.getUserListsOwnerships(listOwnerScreenName, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListsOwnerships(String listOwnerScreenName, int count, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsOwnerships, () -> {
            try {
                return Either.right(resources.getUserListsOwnerships(listOwnerScreenName, count, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListsOwnerships(long listOwnerId, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsOwnerships, () -> {
            try {
                return Either.right(resources.getUserListsOwnerships(listOwnerId, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListsOwnerships(long listOwnerId, int count, long cursor) throws TwitterException {
        return throttleStrategy.throttle(ResourceFamily.listsOwnerships, () -> {
            try {
                return Either.right(resources.getUserListsOwnerships(listOwnerId, count, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }
}
