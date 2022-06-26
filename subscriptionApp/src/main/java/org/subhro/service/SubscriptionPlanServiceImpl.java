package org.subhro.service;

import org.subhro.dao.SubscriptionPlanDaoImpl;
import org.subhro.models.SubscriptionPlan;

public class SubscriptionPlanServiceImpl implements SubscriptionPlanService{

    private static SubscriptionPlanServiceImpl instance;

    private SubscriptionPlanServiceImpl(){

    }

    public static SubscriptionPlanServiceImpl getInstance(){
        if(instance==null){
            instance = new SubscriptionPlanServiceImpl();
        }
        return instance;
    }

    private SubscriptionPlanDaoImpl subscriptionPlanDao = SubscriptionPlanDaoImpl.getInstance();

    @Override
    public SubscriptionPlan getSubscriptionPlan(String subscriptionCategory, String plan) {
        return subscriptionPlanDao.getSubscriptionPlan(subscriptionCategory, plan);
    }
}
