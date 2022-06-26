package org.subhro.service;

import org.subhro.dao.UserDaoImpl;
import org.subhro.exceptions.InputValueEmptyException;
import org.subhro.models.SubscriptionPlan;
import org.subhro.models.TopUpPlan;

import static org.subhro.constant.Constants.INPUT_VALUE_EMPTY_MESSAGE;
import static org.subhro.constant.Constants.INVALID_TOPUP_PLAN_REQUEST_MESSAGE;

public class UserServiceImpl implements UserService{

    private static UserServiceImpl instance;

    private UserDaoImpl userDao = UserDaoImpl.getInstance();
    private SubscriptionPlanServiceImpl subscriptionPlanService = SubscriptionPlanServiceImpl.getInstance();
    private TopUpPlanServiceImpl topUpPlanService = TopUpPlanServiceImpl.getInstance();

    private UserServiceImpl(){

    }

    public static UserServiceImpl getInstance(){
        if(instance==null){
            instance = new UserServiceImpl();
        }
        return instance;
    }

    @Override
    public void startSubscription(String subscriptionStartDate){
        validateStringInput(subscriptionStartDate);

        userDao.startSubscription(subscriptionStartDate);
    }

    @Override
    public void addSubscription(String subscriptionCategory, String plan){
        validateStringInput(subscriptionCategory);
        validateStringInput(plan);

        SubscriptionPlan subscriptionPlan = subscriptionPlanService.getSubscriptionPlan(subscriptionCategory, plan);
        userDao.addSubscription(subscriptionCategory, subscriptionPlan);
    }

    @Override
    public void addTopup(String topupName, String planMonth){
        validateStringInput(topupName);
        validateStringInput(planMonth);

        int topupPlanMonths = Integer.parseInt(planMonth);
        if(topupPlanMonths<=0){
            throw new InputValueEmptyException(INVALID_TOPUP_PLAN_REQUEST_MESSAGE);
        }
        TopUpPlan topupPlan = topUpPlanService.getTopupPlan(topupName);
        userDao.addTopup(topupPlan, topupPlanMonths);
    }

    @Override
    public void printRenewalDetails(){
        userDao.printRenewalDetails();
    }

    private void validateStringInput(String stringValue){
        if(stringValue==null || stringValue.isEmpty()){
            throw new InputValueEmptyException(INPUT_VALUE_EMPTY_MESSAGE);
        }
    }
}
