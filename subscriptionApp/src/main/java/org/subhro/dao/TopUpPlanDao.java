package org.subhro.dao;

import org.subhro.models.TopUpPlan;

public interface TopUpPlanDao {

    TopUpPlan getTopupPlan(String topupName);
}
