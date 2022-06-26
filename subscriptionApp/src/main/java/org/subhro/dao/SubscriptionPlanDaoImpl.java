package org.subhro.dao;

import org.subhro.constant.Constants;
import org.subhro.exceptions.SubscriptionDoesNotExistException;
import org.subhro.models.SubscriptionPlan;

import java.util.HashMap;

public class SubscriptionPlanDaoImpl implements SubscriptionPlanDao{

    private static SubscriptionPlanDaoImpl instance;

    private SubscriptionPlanDaoImpl(){

    }

    public static SubscriptionPlanDaoImpl getInstance(){
        if(instance==null){
            instance = new SubscriptionPlanDaoImpl();
        }
        return instance;
    }

    private static final HashMap<String, SubscriptionPlan> subscriptionPlanMap;

    static {
        subscriptionPlanMap = new HashMap<>();

        for(SubscriptionPlan plan : SubscriptionPlan.values()){
            String subscriptionCategory = plan.getSubscriptionCategory();
            String subscriptionPlan = plan.getSubscriptionPlanService();

            if(plan.getSubscriptionPlanService().equals(Constants.PLAN_FREE)){
                subscriptionPlanMap.put(subscriptionPlan, plan);
                continue;
            }
            subscriptionPlanMap.put(subscriptionCategory + Constants.DELIMITER + subscriptionPlan, plan);
        }
    }

    @Override
    public SubscriptionPlan getSubscriptionPlan(String subscriptionCategory, String plan) {
        if(plan.equals(Constants.PLAN_FREE)){
            return subscriptionPlanMap.get(Constants.PLAN_FREE);
        }

        String subscriptionPlanKey = subscriptionCategory +  Constants.DELIMITER + plan;
        SubscriptionPlan subscriptionPlan = subscriptionPlanMap.getOrDefault(subscriptionPlanKey, null);

        if(subscriptionPlan==null){
            throw new SubscriptionDoesNotExistException(Constants.SUBSCRIPTION_DOES_NOT_EXIST_MESSAGE);
        }
        return subscriptionPlan;
    }
}
