package throttlr.twitter.wrapper;

import throttlr.twitter.strategy.ThrottleStrategy;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.TwitterException;
import twitter4j.api.SearchResource;

public class SearchResourceWrapper implements SearchResource {

    private ThrottleStrategy throttleStrategy;
    private SearchResource searchResource;

    public SearchResourceWrapper(SearchResource searchResource, ThrottleStrategy throttleStrategy) {
        this.throttleStrategy = throttleStrategy;
        this.searchResource = searchResource;
    }

    @Override
    public QueryResult search(Query query) throws TwitterException {
        return searchResource.search(query);
    }
}
