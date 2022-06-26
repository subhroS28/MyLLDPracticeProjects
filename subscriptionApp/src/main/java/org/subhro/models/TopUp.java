package org.subhro.models;

public class TopUp {

    private TopUpPlan topUpPlan;
    private int topUpMonth;

    public TopUp(){
        topUpPlan = null;
        topUpMonth = 0;
    }

    public TopUp(TopUpPlan topUpPlan, int topUpMonth){
        this.topUpPlan = topUpPlan;
        this.topUpMonth = topUpMonth;
    }

    public TopUpPlan getTopUpPlan() {
        return topUpPlan;
    }

    public void setTopUpPlan(TopUpPlan topUpPlan) {
        this.topUpPlan = topUpPlan;
    }

    public int getTopUpMonth() {
        return topUpMonth;
    }

    public void setTopUpMonth(int topUpMonth) {
        this.topUpMonth = topUpMonth;
    }
}
