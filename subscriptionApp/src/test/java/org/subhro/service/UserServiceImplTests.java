package org.subhro.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.subhro.exceptions.InputValueEmptyException;
import org.subhro.exceptions.SubscriptionDoesNotExistException;
import org.subhro.exceptions.TopupDoesNotExistException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTests {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @InjectMocks
    private UserServiceImpl userService;

    private String emptyString = "";

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test(expected = InputValueEmptyException.class)
    public void startSubscriptionWithIncorrectValueTest(){
        userService.startSubscription(emptyString);
    }

    @Test(expected = InputValueEmptyException.class)
    public void addSubscriptionWithIncorrectValueTest(){
        userService.addSubscription(emptyString, emptyString);
    }

    @Test(expected = InputValueEmptyException.class)
    public void addTopupWithIncorrectTopupNameValueTest(){
        userService.addTopup(emptyString, emptyString);
    }

    @Test(expected = InputValueEmptyException.class)
    public void addTopupWithIncorrectTopupMonthValueTest(){
        userService.addTopup("Dummy", "-1");
    }

    @Test
    public void startSubscriptionWithCorrectValueTest(){
        userService.startSubscription("20-02-2022");
    }

    //As the values passed are correct so there will we no exception
    @Test
    public void addSubscriptionWithCorrectValueTest(){
        userService.addSubscription("MUSIC", "PERSONAL");
    }

    @Test(expected = SubscriptionDoesNotExistException.class)
    public void addSubscriptionWithInCorrectValueTest(){
        userService.addSubscription("MUSICss", "PERSONAL");
    }

    //As the values passed are correct so there will we no exception
    @Test
    public void addTopupWithCorrectTopupValueTest(){
        userService.addTopup("FOUR_DEVICE", "1");
    }

    @Test(expected = TopupDoesNotExistException.class)
    public void addTopupWithInCorrectTopupValueTest(){
        userService.addTopup("FOUR_DEVICE22", "1");
    }
}
