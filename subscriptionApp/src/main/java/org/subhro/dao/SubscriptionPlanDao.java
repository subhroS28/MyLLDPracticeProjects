package org.subhro.dao;

import org.subhro.models.SubscriptionPlan;

public interface SubscriptionPlanDao {

    SubscriptionPlan getSubscriptionPlan(String subscriptionCategory, String plan);
}
