package org.subhro.util;

import org.subhro.constant.Constants;
import org.subhro.service.UserServiceImpl;

import java.util.Scanner;

public class CommandMapperAndReader {

    private static CommandMapperAndReader instance;

    private static UserServiceImpl userServiceImpl = UserServiceImpl.getInstance();

    private CommandMapperAndReader(){

    }

    public static CommandMapperAndReader getInstance(){
        if(instance == null){
            instance = new CommandMapperAndReader();
        }
        return instance;
    }

    public static void executeCommands(Scanner commandScanner){
        while (commandScanner.hasNextLine()) {
            String command = commandScanner.nextLine();
            String[] parsedCommand = command.split(" ");
            callingMethod(parsedCommand);
        }
    }

    private static void callingMethod(String[] parsedCommand){
        String command = parsedCommand[0];

        if(command.equals(Constants.START_SUBSCRIPTION_COMMAND)){

            String date = parsedCommand[1];
            userServiceImpl.startSubscription(date);
        }else if(command.equals(Constants.ADD_SUBSCRIPTION_COMMAND)){

            String subscriptionCategory = parsedCommand[1];
            String subscriptionPlan = parsedCommand[2];
            userServiceImpl.addSubscription(subscriptionCategory, subscriptionPlan);
        }else if(command.equals(Constants.ADD_TOPUP_COMMAND)){

            String topupName = parsedCommand[1];
            String topupPlan = parsedCommand[2];
            userServiceImpl.addTopup(topupName, topupPlan);
        }else if(command.equals(Constants.PRINT_RENEWAL_DETAILS)){

            userServiceImpl.printRenewalDetails();
        }
    }

}
