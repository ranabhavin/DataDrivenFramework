package com.bhavin.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.bhavin.base.TestBase;

// TODO: Auto-generated Javadoc
/**
 * The Class TestCase_01_ValidateRegistrationDoneSuccessfully.
 */
public class TestCase_01_ValidateRegistrationDoneSuccessfully extends TestBase {

	/**
	 * Validate registration done successfully.
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test(description = "Test Case 1")
	public void validateRegistrationDoneSuccessfully() throws InterruptedException {

		openURL("testSiteURL");
		type("register_email_field_CSS", "bhavin3@qa.com");
		type("register_password_field_CSS", "Bhavin$%!!");
		Thread.sleep(3000);
		click("register_button_XPATH");

	}

	/**
	 * Complete test case.
	 */
	@AfterMethod
	public void completeTestCase() {

		driver.close();

	}

}
