package org.subhro.models;

import java.util.Date;

public class User {

    private Subscription subscriptions;
    private TopUp topUp;
    private Date subscriptionStartDate;

    public User(){
        subscriptions = new Subscription();
        topUp = new TopUp();
        subscriptionStartDate = null;
    }

    public User(Date subscriptionStartDate){
        this.subscriptionStartDate = subscriptionStartDate;
    }

    public User(Subscription subscriptions, TopUp topUp, Date subscriptionStartDate){
        this.subscriptions = subscriptions;
        this.topUp = topUp;
        this.subscriptionStartDate = subscriptionStartDate;
    }

    public Subscription getSubscriptions() {
        return subscriptions;
    }

    public TopUp getTopUp() {
        return topUp;
    }

    public Date getSubscriptionStartDate() {
        return subscriptionStartDate;
    }

    public void setSubscriptionStartDate(Date subscriptionStartDate) {
        this.subscriptionStartDate = subscriptionStartDate;
    }
}
