package org.subhro.dao;

import org.subhro.constant.Constants;
import org.subhro.exceptions.TopupDoesNotExistException;
import org.subhro.models.TopUpPlan;

import java.util.HashMap;

public class TopUpPlanDaoImpl implements TopUpPlanDao{

    private static TopUpPlanDaoImpl instance;

    private TopUpPlanDaoImpl(){

    }

    public static TopUpPlanDaoImpl getInstance(){
        if (instance==null){
            instance = new TopUpPlanDaoImpl();
        }
        return instance;
    }

    private static HashMap<String, TopUpPlan> topupMap;

    static {
        topupMap = new HashMap<>();

        topupMap.put(Constants.TOPUP_FOUR_DEVICE, TopUpPlan.FOUR_DEVICE);
        topupMap.put(Constants.TOPUP_TEN_DEVICE, TopUpPlan.TEN_DEVICE);
    }

    @Override
    public TopUpPlan getTopupPlan(String topupName) {
        TopUpPlan topUpPlan = topupMap.getOrDefault(topupName, null);

        if(topUpPlan==null){
            throw new TopupDoesNotExistException(Constants.TOPUP_DOES_NOT_EXIST_MESSAGE);
        }
        return topUpPlan;
    }
}
