package org.subhro.models;

import java.util.HashMap;
import java.util.Map;

public class Subscription {

    private Map<String, SubscriptionPlan> subscriptions;

    public Subscription(){
        subscriptions = new HashMap<>();
    }

    public Subscription(Map<String, SubscriptionPlan> subscriptions){
        this.subscriptions = subscriptions;
    }

    public Map<String, SubscriptionPlan> getSubscriptions() {
        return subscriptions;
    }

}
