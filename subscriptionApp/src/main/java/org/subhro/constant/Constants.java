package org.subhro.constant;

public final class Constants {

    private Constants(){

    }

    //Subscription and topup Name constants
    public static final String SUBSCRIPTION_MUSIC = "MUSIC";
    public static final String SUBSCRIPTION_VIDEO = "VIDEO";
    public static final String SUBSCRIPTION_PODCAST = "PODCAST";

    public static final String PLAN_FREE = "FREE";
    public static final String PLAN_PERSONAL = "PERSONAL";
    public static final String PLAN_PREMIUM = "PREMIUM";

    public static final String TOPUP_FOUR_DEVICE = "FOUR_DEVICE";
    public static final String TOPUP_TEN_DEVICE = "TEN_DEVICE";

    public static final String DELIMITER = "#";

    //Subscription Constants
    public static final int SUBSCRIPTION_FREE_MONTHS = 1;
    public static final int SUBSCRIPTION_FREE_AMOUNT = 0;

    public static final int MUSIC_PERSONAL_MONTHS = 1;
    public static final int MUSIC_PERSONAL_AMOUNT = 100;
    public static final int MUSIC_PREMIUM_MONTHS = 3;
    public static final int MUSIC_PREMIUM_AMOUNT = 250;

    public static final int VIDEO_PERSONAL_MONTHS = 1;
    public static final int VIDEO_PERSONAL_AMOUNT = 200;
    public static final int VIDEO_PREMIUM_MONTHS = 3;
    public static final int VIDEO_PREMIUM_AMOUNT = 500;

    public static final int PODCAST_PERSONAL_MONTHS = 1;
    public static final int PODCAST_PERSONAL_AMOUNT = 100;
    public static final int PODCAST_PREMIUM_MONTHS = 3;
    public static final int PODCAST_PREMIUM_AMOUNT = 300;

    //TOPUP
    public static final int FOUR_DEVICE_AMOUNT = 50;
    public static final int TEN_DEVICE_AMOUNT = 100;

    //Error Messages
    public static final String INVALID_DATE_FORMAT_MESSAGE = "INVALID_DATE";
    public static final String ADD_SUBSCRIPTION_FAILED_MESSAGE = "ADD_SUBSCRIPTION_FAILED";
    public static final String SUBSCRIPTIONS_NOT_FOUND_MESSAGE = "SUBSCRIPTIONS_NOT_FOUND";
    public static final String DUPLICATE_CATEGORY_MESSAGE = "DUPLICATE_CATEGORY";
    public static final String ADD_TOPUP_FAILED_MESSAGE = "ADD_TOPUP_FAILED";
    public static final String DUPLICATE_TOPUP_MESSAGE = "DUPLICATE_TOPUP";

    //Default Custom Exception Messages
    public static final String INPUT_VALUE_EMPTY_MESSAGE = "Value is empty!!!";
    public static final String INVALID_TOPUP_PLAN_REQUEST_MESSAGE = "Invalid topup plan request. Month can not be less than 1.";
    public static final String SUBSCRIPTION_DOES_NOT_EXIST_MESSAGE = "Incorrect subscription values passed. Subscription plan does not exist!!";
    public static final String TOPUP_DOES_NOT_EXIST_MESSAGE = "Incorrect topup value passed. Topup does not exist!!";

    //Commands
    public static final String START_SUBSCRIPTION_COMMAND = "START_SUBSCRIPTION";
    public static final String ADD_SUBSCRIPTION_COMMAND = "ADD_SUBSCRIPTION";
    public static final String ADD_TOPUP_COMMAND = "ADD_TOPUP";
    public static final String PRINT_RENEWAL_DETAILS = "PRINT_RENEWAL_DETAILS";

    //Other
    public static final int RENEWAL_REMINDER_DAY_BEFORE_EXPIRY = 10;
    public static final String DATE_FORMAT = "dd-MM-yyyy";
    public static final String RENEWAL_AMOUNT_MESSAGE = "RENEWAL_AMOUNT";
    public static final String RENEWAL_REMINDER_MESSAGE = "RENEWAL_REMINDER";

}
