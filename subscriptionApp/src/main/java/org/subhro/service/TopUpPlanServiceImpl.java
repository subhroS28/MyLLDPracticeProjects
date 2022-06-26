package org.subhro.service;

import org.subhro.dao.TopUpPlanDaoImpl;
import org.subhro.models.TopUpPlan;

public class TopUpPlanServiceImpl implements TopUpPlanService{

    private static TopUpPlanServiceImpl instance;

    private TopUpPlanDaoImpl topUpPlanDao = TopUpPlanDaoImpl.getInstance();

    private TopUpPlanServiceImpl(){

    }

    public static TopUpPlanServiceImpl getInstance(){
        if(instance==null){
            instance = new TopUpPlanServiceImpl();
        }
        return instance;
    }

    @Override
    public TopUpPlan getTopupPlan(String topupName) {
        return topUpPlanDao.getTopupPlan(topupName);
    }
}
