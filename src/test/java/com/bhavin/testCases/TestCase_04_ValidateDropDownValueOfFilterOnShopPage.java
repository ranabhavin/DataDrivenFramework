package com.bhavin.testCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.bhavin.base.TestBase;
import com.bhavin.utilities.Utility;
import com.bhavin.utilities.Xls_Reader;

public class TestCase_04_ValidateDropDownValueOfFilterOnShopPage extends TestBase {

	/**
	 * Validate drop down value of filter on shop page.
	 */
	@Test(description = "Validate drop down value of filter on shop page")
	public void validateDropDownValueOfFilterOnShopPage() {

		openURL("testSiteURL");
		type("username_field_CSS", "bhavin3@qa.com");
		type("username_password_CSS", "Bhavin$%!!");
		click("login_btn_XPATH");
		click("order_Section_LINKTEXT");
		click("go_Shop_LINKTEXT");

		Xls_Reader reader = new Xls_Reader("./src/test/resources/excel/testData.xlsx");

		// created expected sorting list
		List<String> expected_sortingList = new ArrayList<String>();

		int sorting_rowCount = reader.getRowCount("sortingTestData");

		System.out.println(sorting_rowCount);

		for (int sortingDataRowNum = 2; sortingDataRowNum <= sorting_rowCount; sortingDataRowNum++) {

			expected_sortingList.add(reader.getCellData("sortingTestData", "filterData", sortingDataRowNum));

		}

		// Now created a actual List
		List<String> actual_sortingList = new ArrayList<String>();

		Select select = new Select(driver.findElement(By.xpath(OR.getProperty("sorting_filter_data_XPATH"))));
		List<WebElement> filter_dropDown_data = select.getOptions();
		for (WebElement eachFilterData : filter_dropDown_data) {

			actual_sortingList.add(eachFilterData.getText());
			

		}

		Assert.assertEquals(actual_sortingList, expected_sortingList,
				Utility.listCompareAndFetchData(expected_sortingList, actual_sortingList));

	}

	@AfterMethod
	public void completeTestCase() {

		driver.close();

	}

}
