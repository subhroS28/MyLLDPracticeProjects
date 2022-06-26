package org.subhro.dao;

import org.subhro.models.SubscriptionPlan;
import org.subhro.models.TopUpPlan;

public interface UserDao {

    void startSubscription(String subscriptionStartDate);
    void addSubscription(String subscriptionCategory, SubscriptionPlan subscriptionPlan);
    void addTopup(TopUpPlan topUpPlan, int topupPlanMonth);
    void printRenewalDetails();
}
