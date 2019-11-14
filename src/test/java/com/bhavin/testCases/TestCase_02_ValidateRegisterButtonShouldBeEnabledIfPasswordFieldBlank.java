package com.bhavin.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.bhavin.base.TestBase;

public class TestCase_02_ValidateRegisterButtonShouldBeEnabledIfPasswordFieldBlank extends TestBase {

	@Test(description = "Test Case 2")
	public void validateRegisterButtonShouldBeEnabledIfPasswordFieldBlank() throws InterruptedException {

		openURL("testSiteURL");
		type("register_email_field_CSS", "qa@orioncs.com");
		// Assert.assertTrue(driver.findElement(By.xpath(OR.getProperty("register_button_XPATH"))).isEnabled(),
		// "Register Button is disabled");
		// Assert.assertTrue(isElementPresent(by, locator));

		Thread.sleep(3000);
		Assert.assertTrue(isElementEnabled("register_button_XPATH"));
	}

	@AfterMethod
	public void completeTestCase() {

		driver.close();

	}

}
