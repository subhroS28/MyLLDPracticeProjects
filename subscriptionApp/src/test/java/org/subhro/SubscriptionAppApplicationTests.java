package org.subhro;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.subhro.service.UserServiceImpl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class SubscriptionAppApplicationTests {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	private UserServiceImpl userServiceImpl;

	@Before
	public void setUp() {
		userServiceImpl = UserServiceImpl.getInstance();
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@After
	public void tearDown() {
		System.setOut(standardOut);
	}

	@Test
	public void callingCommandsUsingClassesFirstTest(){
		userServiceImpl.startSubscription("20-02-2022");
		userServiceImpl.addSubscription("MUSIC", "PERSONAL");
		userServiceImpl.addSubscription("VIDEO", "PREMIUM");
		userServiceImpl.addSubscription("PODCAST", "FREE");
		userServiceImpl.addTopup("FOUR_DEVICE", "3");
		userServiceImpl.printRenewalDetails();

		assertEquals(Boolean.FALSE, outputStreamCaptor.toString().trim().contains("INVALID_DATE"));
		assertEquals(Boolean.TRUE, outputStreamCaptor.toString().trim().contains("RENEWAL_REMINDER"));
	}

	@Test
	public void callingCommandsUsingClassesSecondTest(){
		userServiceImpl.startSubscription("20-02-2022");
		userServiceImpl.addTopup("FOUR_DEVICE", "3");
		userServiceImpl.printRenewalDetails();

		assertEquals(Boolean.TRUE, outputStreamCaptor.toString().trim().contains("ADD_TOPUP_FAILED DUPLICATE_TOPUP"));
	}

	@Test
	public void callingCommandsUsingClassesFourthTest(){
		userServiceImpl.startSubscription("20-02-2022");
		userServiceImpl.addSubscription("MUSIC", "PERSONAL");
		userServiceImpl.addSubscription("MUSIC", "PREMIUM");
		userServiceImpl.addTopup("FOUR_DEVICE", "3");
		userServiceImpl.printRenewalDetails();

		assertEquals(Boolean.TRUE, outputStreamCaptor.toString().trim().contains("ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY"));
	}

	@Test
	public void callingCommandsUsingClassesFifthTest(){
		userServiceImpl.startSubscription("20-02-2022");
		userServiceImpl.addSubscription("MUSIC", "PERSONAL");
		userServiceImpl.addTopup("FOUR_DEVICE", "3");
		userServiceImpl.addTopup("FOUR_DEVICE", "2");
		userServiceImpl.printRenewalDetails();

		assertEquals(Boolean.TRUE, outputStreamCaptor.toString().trim().contains("ADD_TOPUP_FAILED DUPLICATE_TOPUP"));
	}

	@Test(expected = IOException.class)
	public void callingMainMethodWithIncorrectPathTest() throws Exception {
		String[] args = new String[1];
		args[0] = "sample_input\\dummyNonExistingFileFile.txt";
		SubscriptionAppApplication.main(args);
	}

}
