package org.subhro.util;

import org.subhro.constant.Constants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SubscriptionDetailsDateUtil {

    private static SubscriptionDetailsDateUtil instance;

    private SubscriptionDetailsDateUtil(){

    }

    public static SubscriptionDetailsDateUtil getInstance(){
        if(instance==null){
            instance = new SubscriptionDetailsDateUtil();
        }
        return instance;
    }

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);

    static {
        //So that simpleDateFormat gives exception when wrong format date is passed
        simpleDateFormat.setLenient(false);
    }

    public static Date getSimpleDateFormat(String subscriptionStartDate){
        try {
            return simpleDateFormat.parse(subscriptionStartDate);
        } catch (ParseException e) {
            System.out.println(Constants.INVALID_DATE_FORMAT_MESSAGE);
            return null;
        }
    }

    public static String getRenewalDate(Date subscriptionStartDate, int subscriptionsMonths){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(subscriptionStartDate);

        calendar.add(Calendar.MONTH, subscriptionsMonths);
        calendar.add(Calendar.DATE, (-1)* Constants.RENEWAL_REMINDER_DAY_BEFORE_EXPIRY);

        Date renewalDate = calendar.getTime();
        return simpleDateFormat.format(renewalDate);
    }
}
