package org.subhro.dao;

import org.subhro.models.*;
import org.subhro.util.MessageDisplayer;
import org.subhro.util.SubscriptionDetailsDateUtil;

import java.util.Date;
import java.util.Map;

public class UserDaoImpl extends MessageDisplayer implements UserDao{

    private static UserDaoImpl instance;

    private User user;

    private UserDaoImpl(){
        user = new User();
    }

    public static UserDaoImpl getInstance(){
        if(instance==null){
            instance = new UserDaoImpl();
        }
        return instance;
    }

    @Override
    public void startSubscription(String subscriptionStartDate) {
        Date startDate = SubscriptionDetailsDateUtil.getSimpleDateFormat(subscriptionStartDate);
        user.setSubscriptionStartDate(startDate);
    }

    @Override
    public void addSubscription(String subscriptionCategory, SubscriptionPlan subscriptionPlan) {
        if(user.getSubscriptionStartDate() == null){
            addSubscriptionForInvalidDateError();
            return;
        }

        Subscription userSubscription = user.getSubscriptions();
        Map<String, SubscriptionPlan> userSubscriptionPlans = userSubscription.getSubscriptions();
        if(userSubscriptionPlans.containsKey(subscriptionCategory)){
            addSubscriptionForDuplicateSubscriptionError();
            return;
        }

        userSubscriptionPlans.put(subscriptionCategory, subscriptionPlan);
    }

    @Override
    public void addTopup(TopUpPlan topUpPlan, int topupPlanMonth) {
        if(user.getSubscriptionStartDate() == null){
            addTopupForInvalidDateError();
            return;
        }

        Subscription userSubscription = user.getSubscriptions();
        Map<String, SubscriptionPlan> userSubscriptionPlans = userSubscription.getSubscriptions();
        if(userSubscriptionPlans.isEmpty()){
            addTopupForNoSubscriptionError();
            return;
        }

        TopUp userTopUp = user.getTopUp();
        if(userTopUp.getTopUpPlan() != null){
            addTopupForDuplicateTopup();
            return;
        }

        userTopUp.setTopUpPlan(topUpPlan);
        userTopUp.setTopUpMonth(topupPlanMonth);
    }

    @Override
    public void printRenewalDetails() {
        Subscription userSubscription = user.getSubscriptions();
        Map<String, SubscriptionPlan> userSubscriptionPlans = userSubscription.getSubscriptions();
        if(userSubscriptionPlans.isEmpty()){
            subscriptionNotFoundError();
            return;
        }

        int renewalAmount = 0;
        renewalAmount += calculatedTopupAmount();

        for(Map.Entry<String, SubscriptionPlan> entry : userSubscriptionPlans.entrySet()){
            String subscriptionName = entry.getKey();
            SubscriptionPlan subscriptionPlan = entry.getValue();
            renewalAmount += subscriptionPlan.getSubscriptionAmount();

            String subscriptionRenewalDate = SubscriptionDetailsDateUtil.getRenewalDate(user.getSubscriptionStartDate(), subscriptionPlan.getSubscriptionMonths());
            subscriptionRenewalMessage(subscriptionName, subscriptionRenewalDate);
        }

        renewalAmountMessage(renewalAmount);
    }

    private int calculatedTopupAmount(){
        int topupAmount = 0;
        TopUp userTopUp = user.getTopUp();
        if(userTopUp.getTopUpPlan() != null){
            TopUpPlan userTopUpPlan = userTopUp.getTopUpPlan();
            topupAmount += ( userTopUpPlan.getAmount() * userTopUp.getTopUpMonth() );
        }
        return topupAmount;
    }
}
