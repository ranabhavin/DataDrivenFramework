package com.bhavin.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.bhavin.base.TestBase;

public class TestCase_03_ValidateRegisterButtonShouldBeDisabledIfPasswordCriteriaNotFulFiiled extends TestBase {

	@Test(description = "Test Case 3")
	public void validateRegisterButtonShouldBeDisabledIfPasswordCriteriaNotFulFiiled() throws InterruptedException {

		openURL("testSiteURL");
		type("register_email_field_CSS", "qaqw@asd.uk");
		type("register_password_field_CSS", "fdffd");
		Thread.sleep(3000);

		Assert.assertFalse(isElementEnabled("register_button_XPATH"));

	}

	
	  @AfterMethod public void completeTestCase() {
	  
	  driver.close();
	  
	  }
	 

}
