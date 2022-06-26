package org.subhro.service;

import org.subhro.models.SubscriptionPlan;

public interface SubscriptionPlanService {

    SubscriptionPlan getSubscriptionPlan(String subscriptionCategory, String plan);
}
