package org.subhro.models;

import org.subhro.constant.Constants;

public enum TopUpPlan {

    FOUR_DEVICE(Constants.FOUR_DEVICE_AMOUNT),
    TEN_DEVICE(Constants.TEN_DEVICE_AMOUNT);

    private final int amount;

    TopUpPlan(int amount){
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
