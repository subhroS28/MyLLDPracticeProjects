package org.subhro.util;

import org.subhro.constant.Constants;

public class MessageDisplayer {

    protected void addSubscriptionForInvalidDateError(){
        System.out.println(Constants.ADD_SUBSCRIPTION_FAILED_MESSAGE + " " +
                Constants.INVALID_DATE_FORMAT_MESSAGE);
    }

    protected void addSubscriptionForDuplicateSubscriptionError(){
        System.out.println(Constants.ADD_SUBSCRIPTION_FAILED_MESSAGE + " " +
                Constants.DUPLICATE_CATEGORY_MESSAGE);
    }

    protected void addTopupForInvalidDateError(){
        System.out.println(Constants.ADD_TOPUP_FAILED_MESSAGE + " " +
                Constants.INVALID_DATE_FORMAT_MESSAGE);

    }

    protected void addTopupForNoSubscriptionError(){
        System.out.println(Constants.ADD_TOPUP_FAILED_MESSAGE + " " +
                Constants.SUBSCRIPTIONS_NOT_FOUND_MESSAGE);
    }

    protected void addTopupForDuplicateTopup(){
        System.out.println(Constants.ADD_TOPUP_FAILED_MESSAGE + " " +
                Constants.DUPLICATE_TOPUP_MESSAGE);
    }

    protected void subscriptionNotFoundError(){
        System.out.println(Constants.SUBSCRIPTIONS_NOT_FOUND_MESSAGE);
    }

    protected void subscriptionRenewalMessage(String subscriptionName, String subscriptionRenewalDate){
        System.out.println(Constants.RENEWAL_REMINDER_MESSAGE + " " + subscriptionName + " " + subscriptionRenewalDate);
    }

    protected void renewalAmountMessage(int renewalAmount){
        System.out.println(Constants.RENEWAL_AMOUNT_MESSAGE + " " + renewalAmount);
    }
}
