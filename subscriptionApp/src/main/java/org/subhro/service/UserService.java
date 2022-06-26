package org.subhro.service;

public interface UserService {

    void startSubscription(String subscriptionStartDate);
    void addSubscription(String subscriptionCategory, String subscriptionPlan);
    void addTopup(String topupName, String topupPlan);
    void printRenewalDetails();
}
