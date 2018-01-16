package throttlr.twitter.cluster.wrapper;

import throttlr.twitter.cluster.strategy.LoadBalanceStrategy;

class WrapperBase {
    LoadBalanceStrategy loadBalanceStrategy;

    WrapperBase(LoadBalanceStrategy loadBalanceStrategy) {
        this.loadBalanceStrategy = loadBalanceStrategy;
    }
}
