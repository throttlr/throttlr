package throttlr.twitter.cluster.wrapper;

import throttlr.twitter.cluster.strategy.LoadBalanceStrategy;
import throttlr.twitter.common.ResourceFamily;
import throttlr.twitter.internal.Either;
import twitter4j.*;
import twitter4j.api.ListsResources;

public class ListsResourcesWrapper extends WrapperBase implements ListsResources {

    public ListsResourcesWrapper(LoadBalanceStrategy loadBalanceStrategy) {
        super(loadBalanceStrategy);
    }

    @Override
    public ResponseList<UserList> getUserLists(String listOwnerScreenName) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsList, (resources) -> {
            try {
                return Either.right(resources.getUserLists(listOwnerScreenName));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<UserList> getUserLists(String listOwnerScreenName, boolean reverse) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsList, (resources) -> {
            try {
                return Either.right(resources.getUserLists(listOwnerScreenName, reverse));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<UserList> getUserLists(long listOwnerUserId) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsList, (resources) -> {
            try {
                return Either.right(resources.getUserLists(listOwnerUserId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<UserList> getUserLists(long listOwnerUserId, boolean reverse) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsList, (resources) -> {
            try {
                return Either.right(resources.getUserLists(listOwnerUserId, reverse));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getUserListStatuses(long listId, Paging paging) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsStatuses, (resources) -> {
            try {
                return Either.right(resources.getUserListStatuses(listId, paging));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getUserListStatuses(long ownerId, String slug, Paging paging) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsStatuses, (resources) -> {
            try {
                return Either.right(resources.getUserListStatuses(ownerId, slug, paging));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public ResponseList<Status> getUserListStatuses(String ownerScreenName, String slug, Paging paging) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsStatuses, (resources) -> {
            try {
                return Either.right(resources.getUserListStatuses(ownerScreenName, slug, paging));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public UserList destroyUserListMember(long listId, long userId) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserList destroyUserListMember(long listId, String screenName) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserList destroyUserListMembers(long listId, String[] screenNames) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserList destroyUserListMembers(long listId, long[] userIds) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserList destroyUserListMembers(String ownerScreenName, String slug, String[] screenNames) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserList destroyUserListMember(long ownerId, String slug, long userId) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserList destroyUserListMember(String ownerScreenName, String slug, long userId) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsMemberships, (resources) -> {
            try {
                return Either.right(resources.getUserListMemberships(cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(int count, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsMemberships, (resources) -> {
            try {
                return Either.right(resources.getUserListMemberships(count, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(long listMemberId, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsMemberships, (resources) -> {
            try {
                return Either.right(resources.getUserListMemberships(listMemberId, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(long listMemberId, int count, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsMemberships, (resources) -> {
            try {
                return Either.right(resources.getUserListMemberships(listMemberId, count, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(String listMemberScreenName, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsMemberships, (resources) -> {
            try {
                return Either.right(resources.getUserListMemberships(listMemberScreenName, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(String listMemberScreenName, int count, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsMemberships, (resources) -> {
            try {
                return Either.right(resources.getUserListMemberships(listMemberScreenName, count, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(String listMemberScreenName, long cursor, boolean filterToOwnedLists) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsMemberships, (resources) -> {
            try {
                return Either.right(resources.getUserListMemberships(listMemberScreenName, cursor, filterToOwnedLists));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(String listMemberScreenName, int count, long cursor, boolean filterToOwnedLists) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsMemberships, (resources) -> {
            try {
                return Either.right(resources.getUserListMemberships(listMemberScreenName, count, cursor, filterToOwnedLists));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(long listMemberId, long cursor, boolean filterToOwnedLists) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsMemberships, (resources) -> {
            try {
                return Either.right(resources.getUserListMemberships(listMemberId, cursor, filterToOwnedLists));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListMemberships(long listMemberId, int count, long cursor, boolean filterToOwnedLists) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsMemberships, (resources) -> {
            try {
                return Either.right(resources.getUserListMemberships(listMemberId, count, cursor, filterToOwnedLists));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListSubscribers(long listId, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsSubscribers, (resources) -> {
            try {
                return Either.right(resources.getUserListSubscribers(listId, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListSubscribers(long listId, int count, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsSubscribers, (resources) -> {
            try {
                return Either.right(resources.getUserListSubscribers(listId, count, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListSubscribers(long listId, int count, long cursor, boolean skipStatus) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsSubscribers, (resources) -> {
            try {
                return Either.right(resources.getUserListSubscribers(listId, count, cursor, skipStatus));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListSubscribers(long ownerId, String slug, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsSubscribers, (resources) -> {
            try {
                return Either.right(resources.getUserListSubscribers(ownerId, slug, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListSubscribers(long ownerId, String slug, int count, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsSubscribers, (resources) -> {
            try {
                return Either.right(resources.getUserListSubscribers(ownerId, slug, count, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListSubscribers(long ownerId, String slug, int count, long cursor, boolean skipStatus) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsSubscribers, (resources) -> {
            try {
                return Either.right(resources.getUserListSubscribers(ownerId, slug, count, cursor, skipStatus));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListSubscribers(String ownerScreenName, String slug, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsSubscribers, (resources) -> {
            try {
                return Either.right(resources.getUserListSubscribers(ownerScreenName, slug, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListSubscribers(String ownerScreenName, String slug, int count, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsSubscribers, (resources) -> {
            try {
                return Either.right(resources.getUserListSubscribers(ownerScreenName, slug, count, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListSubscribers(String ownerScreenName, String slug, int count, long cursor, boolean skipStatus) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsSubscribers, (resources) -> {
            try {
                return Either.right(resources.getUserListSubscribers(ownerScreenName, slug, count, cursor, skipStatus));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public UserList createUserListSubscription(long listId) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserList createUserListSubscription(long ownerId, String slug) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserList createUserListSubscription(String ownerScreenName, String slug) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public User showUserListSubscription(long listId, long userId) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsSubscribersShow, (resources) -> {
            try {
                return Either.right(resources.showUserListSubscription(listId, userId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User showUserListSubscription(long ownerId, String slug, long userId) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsSubscribersShow, (resources) -> {
            try {
                return Either.right(resources.showUserListSubscription(ownerId, slug, userId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User showUserListSubscription(String ownerScreenName, String slug, long userId) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsSubscribersShow, (resources) -> {
            try {
                return Either.right(resources.showUserListSubscription(ownerScreenName, slug, userId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public UserList destroyUserListSubscription(long listId) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserList destroyUserListSubscription(long ownerId, String slug) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserList destroyUserListSubscription(String ownerScreenName, String slug) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserList createUserListMembers(long listId, long... userIds) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserList createUserListMembers(long ownerId, String slug, long... userIds) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserList createUserListMembers(String ownerScreenName, String slug, long... userIds) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserList createUserListMembers(long listId, String... screenNames) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserList createUserListMembers(long ownerId, String slug, String... screenNames) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserList createUserListMembers(String ownerScreenName, String slug, String... screenNames) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public User showUserListMembership(long listId, long userId) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsMembersShow, (resources) -> {
            try {
                return Either.right(resources.showUserListMembership(listId, userId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User showUserListMembership(long ownerId, String slug, long userId) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsMembersShow, (resources) -> {
            try {
                return Either.right(resources.showUserListMembership(ownerId, slug, userId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public User showUserListMembership(String ownerScreenName, String slug, long userId) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsMembersShow, (resources) -> {
            try {
                return Either.right(resources.showUserListMembership(ownerScreenName, slug, userId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListMembers(long listId, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsMembers, (resources) -> {
            try {
                return Either.right(resources.getUserListMembers(listId, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListMembers(long listId, int count, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsMembers, (resources) -> {
            try {
                return Either.right(resources.getUserListMembers(listId, count, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListMembers(long listId, int count, long cursor, boolean skipStatus) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsMembers, (resources) -> {
            try {
                return Either.right(resources.getUserListMembers(listId, count, cursor, skipStatus));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListMembers(long ownerId, String slug, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsMembers, (resources) -> {
            try {
                return Either.right(resources.getUserListMembers(ownerId, slug, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListMembers(long ownerId, String slug, int count, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsMembers, (resources) -> {
            try {
                return Either.right(resources.getUserListMembers(ownerId, slug, count, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListMembers(long ownerId, String slug, int count, long cursor, boolean skipStatus) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsMembers, (resources) -> {
            try {
                return Either.right(resources.getUserListMembers(ownerId, slug, count, cursor, skipStatus));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListMembers(String ownerScreenName, String slug, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsMembers, (resources) -> {
            try {
                return Either.right(resources.getUserListMembers(ownerScreenName, slug, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListMembers(String ownerScreenName, String slug, int count, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsMembers, (resources) -> {
            try {
                return Either.right(resources.getUserListMembers(ownerScreenName, slug, count, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<User> getUserListMembers(String ownerScreenName, String slug, int count, long cursor, boolean skipStatus) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsMembers, (resources) -> {
            try {
                return Either.right(resources.getUserListMembers(ownerScreenName, slug, count, cursor, skipStatus));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public UserList createUserListMember(long listId, long userId) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserList createUserListMember(long ownerId, String slug, long userId) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserList createUserListMember(String ownerScreenName, String slug, long userId) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserList destroyUserList(long listId) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserList destroyUserList(long ownerId, String slug) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserList destroyUserList(String ownerScreenName, String slug) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserList updateUserList(long listId, String newListName, boolean isPublicList, String newDescription) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserList updateUserList(long ownerId, String slug, String newListName, boolean isPublicList, String newDescription) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserList updateUserList(String ownerScreenName, String slug, String newListName, boolean isPublicList, String newDescription) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserList createUserList(String listName, boolean isPublicList, String description) throws TwitterException {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserList showUserList(long listId) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsShow, (resources) -> {
            try {
                return Either.right(resources.showUserList(listId));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public UserList showUserList(long ownerId, String slug) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsShow, (resources) -> {
            try {
                return Either.right(resources.showUserList(ownerId, slug));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public UserList showUserList(String ownerScreenName, String slug) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsShow, (resources) -> {
            try {
                return Either.right(resources.showUserList(ownerScreenName, slug));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListSubscriptions(String listSubscriberScreenName, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsSubscriptions, (resources) -> {
            try {
                return Either.right(resources.getUserListSubscriptions(listSubscriberScreenName, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListSubscriptions(String listSubscriberScreenName, int count, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsSubscriptions, (resources) -> {
            try {
                return Either.right(resources.getUserListSubscriptions(listSubscriberScreenName, count, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListSubscriptions(long listSubscriberId, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsSubscriptions, (resources) -> {
            try {
                return Either.right(resources.getUserListSubscriptions(listSubscriberId, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListSubscriptions(long listSubscriberId, int count, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsSubscriptions, (resources) -> {
            try {
                return Either.right(resources.getUserListSubscriptions(listSubscriberId, count, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListsOwnerships(String listOwnerScreenName, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsOwnerships, (resources) -> {
            try {
                return Either.right(resources.getUserListsOwnerships(listOwnerScreenName, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListsOwnerships(String listOwnerScreenName, int count, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsOwnerships, (resources) -> {
            try {
                return Either.right(resources.getUserListsOwnerships(listOwnerScreenName, count, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListsOwnerships(long listOwnerId, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsOwnerships, (resources) -> {
            try {
                return Either.right(resources.getUserListsOwnerships(listOwnerId, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }

    @Override
    public PagableResponseList<UserList> getUserListsOwnerships(long listOwnerId, int count, long cursor) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.listsOwnerships, (resources) -> {
            try {
                return Either.right(resources.getUserListsOwnerships(listOwnerId, count, cursor));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }
}
