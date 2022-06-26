package org.subhro.models;

import org.subhro.constant.Constants;

public enum SubscriptionPlan {

    FREE_PLAN(Constants.PLAN_FREE, Constants.PLAN_FREE,
            Constants.SUBSCRIPTION_FREE_MONTHS, Constants.SUBSCRIPTION_FREE_AMOUNT),

    MUSIC_PERSONAL_PLAN(Constants.SUBSCRIPTION_MUSIC, Constants.PLAN_PERSONAL,
            Constants.MUSIC_PERSONAL_MONTHS, Constants.MUSIC_PERSONAL_AMOUNT),

    MUSIC_PREMIUM_PLAN(Constants.SUBSCRIPTION_MUSIC, Constants.PLAN_PREMIUM,
            Constants.MUSIC_PREMIUM_MONTHS, Constants.MUSIC_PREMIUM_AMOUNT),

    VIDEO_PERSONAL_PLAN(Constants.SUBSCRIPTION_VIDEO, Constants.PLAN_PERSONAL,
            Constants.VIDEO_PERSONAL_MONTHS, Constants.VIDEO_PERSONAL_AMOUNT),

    VIDEO_PREMIUM_PLAN(Constants.SUBSCRIPTION_VIDEO, Constants.PLAN_PREMIUM,
            Constants.VIDEO_PREMIUM_MONTHS, Constants.VIDEO_PREMIUM_AMOUNT),

    PODCAST_PERSONAL_PLAN(Constants.SUBSCRIPTION_PODCAST, Constants.PLAN_PERSONAL,
            Constants.PODCAST_PERSONAL_MONTHS, Constants.PODCAST_PERSONAL_AMOUNT),

    PODCAST_PREMIUM_PLAN(Constants.SUBSCRIPTION_PODCAST, Constants.PLAN_PREMIUM,
            Constants.PODCAST_PREMIUM_MONTHS, Constants.PODCAST_PREMIUM_AMOUNT);

    private final String subscriptionCategory;
    private final String subscriptionPlanService;
    private final int subscriptionMonths;
    private final int subscriptionAmount;

    SubscriptionPlan(String subscriptionCategory, String subscriptionPlan, int months, int amount){
        this.subscriptionCategory = subscriptionCategory;
        this.subscriptionPlanService = subscriptionPlan;
        this.subscriptionMonths = months;
        this.subscriptionAmount = amount;
    }

    public String getSubscriptionCategory() {
        return subscriptionCategory;
    }

    public String getSubscriptionPlanService() {
        return subscriptionPlanService;
    }

    public int getSubscriptionMonths() {
        return subscriptionMonths;
    }

    public int getSubscriptionAmount() {
        return subscriptionAmount;
    }
}
