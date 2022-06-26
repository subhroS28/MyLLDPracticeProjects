package org.subhro.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.subhro.constant.Constants;
import org.subhro.models.SubscriptionPlan;
import org.subhro.models.TopUpPlan;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoImplTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @InjectMocks
    private UserDaoImpl userDaoImpl;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void startSubscriptionWithInCorrectDateTest(){
        userDaoImpl.startSubscription("07-19-2022");

        assertEquals("INVALID_DATE", outputStreamCaptor.toString().trim());
    }

    @Test
    public void startSubscriptionWithCorrectDateTest(){
        userDaoImpl.startSubscription("20-02-2022");

        assertNotEquals("INVALID_DATE", outputStreamCaptor.toString().trim());
        assertEquals("", outputStreamCaptor.toString().trim());
    }

    @Test
    public void addSubscriptionWithInCorrectDateTest(){
        userDaoImpl.startSubscription("07-19-2022");
        userDaoImpl.addSubscription("MUSIC", SubscriptionPlan.MUSIC_PERSONAL_PLAN);

        assertEquals(Boolean.TRUE, outputStreamCaptor.toString().trim()
                .contains("ADD_SUBSCRIPTION_FAILED INVALID_DATE"));
    }

    @Test
    public void addSubscriptionWithCorrectDateTest(){
        userDaoImpl.startSubscription("20-02-2022");
        userDaoImpl.addSubscription("MUSIC", SubscriptionPlan.MUSIC_PERSONAL_PLAN);

        assertEquals("", outputStreamCaptor.toString().trim());
    }

    @Test
    public void addSubscriptionWithDuplicateSubscriptionTest(){
        userDaoImpl.startSubscription("20-02-2022");
        userDaoImpl.addSubscription("MUSIC", SubscriptionPlan.MUSIC_PERSONAL_PLAN);
        userDaoImpl.addSubscription("MUSIC", SubscriptionPlan.MUSIC_PREMIUM_PLAN);

        assertEquals(Constants.ADD_SUBSCRIPTION_FAILED_MESSAGE + " " + Constants.DUPLICATE_CATEGORY_MESSAGE,
                outputStreamCaptor.toString().trim());
    }

    @Test
    public void addTopupWithInCorrectDateTest(){
        userDaoImpl.startSubscription("07-19-2022");
        userDaoImpl.addTopup(TopUpPlan.FOUR_DEVICE, 3);

        assertEquals(Boolean.TRUE, outputStreamCaptor.toString().trim()
                .contains("ADD_TOPUP_FAILED INVALID_DATE"));
    }

    @Test
    public void addTopupWithNoSubscriptionPlanTest(){
        userDaoImpl.startSubscription("20-02-2022");
        userDaoImpl.addTopup(TopUpPlan.FOUR_DEVICE, 3);

        assertEquals(Boolean.TRUE, outputStreamCaptor.toString().trim()
                .contains("ADD_TOPUP_FAILED SUBSCRIPTIONS_NOT_FOUND"));
    }

    @Test
    public void addTopupWithDuplicateTopUpTest(){
        userDaoImpl.startSubscription("20-02-2022");
        userDaoImpl.addSubscription("MUSIC", SubscriptionPlan.MUSIC_PERSONAL_PLAN);
        userDaoImpl.addTopup(TopUpPlan.FOUR_DEVICE, 3);
        userDaoImpl.addTopup(TopUpPlan.FOUR_DEVICE, 5);

        assertEquals(Constants.ADD_TOPUP_FAILED_MESSAGE + " " + Constants.DUPLICATE_TOPUP_MESSAGE,
                outputStreamCaptor.toString().trim());
    }

    @Test
    public void addTopupWithSubscriptionPlanTest(){
        userDaoImpl.startSubscription("20-02-2022");
        userDaoImpl.addSubscription("MUSIC", SubscriptionPlan.MUSIC_PERSONAL_PLAN);
        userDaoImpl.addTopup(TopUpPlan.FOUR_DEVICE, 3);

        assertEquals("", outputStreamCaptor.toString().trim());
    }

    @Test
    public void printRenewalDetailsWithNoSubscriptionPlanTest(){
        userDaoImpl.printRenewalDetails();

        assertEquals("SUBSCRIPTIONS_NOT_FOUND", outputStreamCaptor.toString().trim());
    }

    @Test
    public void printRenewalDetailsWithSubscriptionPlanTest(){
        userDaoImpl.startSubscription("20-02-2022");
        userDaoImpl.addSubscription("MUSIC", SubscriptionPlan.MUSIC_PERSONAL_PLAN);
        userDaoImpl.addTopup(TopUpPlan.FOUR_DEVICE, 3);
        userDaoImpl.printRenewalDetails();

        assertEquals(Boolean.FALSE, outputStreamCaptor.toString().trim().contains("SUBSCRIPTIONS_NOT_FOUND"));
        assertEquals(Boolean.TRUE, outputStreamCaptor.toString().trim().contains("RENEWAL_REMINDER"));
    }
}
