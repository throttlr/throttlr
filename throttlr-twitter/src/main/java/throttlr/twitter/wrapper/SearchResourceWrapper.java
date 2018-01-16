package throttlr.twitter.wrapper;

import throttlr.twitter.strategy.ThrottleStrategy;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.TwitterException;
import twitter4j.api.SearchResource;

public class SearchResourceWrapper extends WrapperBase<SearchResource> implements SearchResource {

    public SearchResourceWrapper(SearchResource searchResource, ThrottleStrategy throttleStrategy) {
        super(searchResource, throttleStrategy);
    }

    @Override
    public QueryResult search(Query query) throws TwitterException {
        return resources.search(query);
    }
}
