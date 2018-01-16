package throttlr.twitter.cluster.wrapper;

import throttlr.twitter.cluster.strategy.LoadBalanceStrategy;
import throttlr.twitter.common.ResourceFamily;
import throttlr.twitter.internal.Either;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.TwitterException;
import twitter4j.api.SearchResource;

public class SearchResourceWrapper extends WrapperBase implements SearchResource {

    public SearchResourceWrapper(LoadBalanceStrategy loadBalanceStrategy) {
        super(loadBalanceStrategy);
    }

    @Override
    public QueryResult search(Query query) throws TwitterException {
        return loadBalanceStrategy.balance(ResourceFamily.uncategorized, (resources) -> {
            try {
                return Either.right(resources.search(query));
            } catch (TwitterException e) {
                return Either.left(e);
            }
        });
    }
}
