package com.bhavin.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.bhavin.base.TestBase;

public class Utility extends TestBase {

	public static String listCompareAndFetchData(List<String> expected, List<String> actual) {

		return ("Expected Data missing : "
				+ expected.stream().filter(aObject -> !actual.contains(aObject)).collect(Collectors.toList()).toString()
				+ "Actual Data found :" + actual.stream().filter(aObject -> !expected.contains(aObject))
						.collect(Collectors.toList()).toString());

	}

	public static String screenshotPath;

	public static String screenshotName;

	public static void captureScreenshot() throws IOException {

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileUtils.copyDirectory(srcFile,
				new File(System.getProperty("user.dir") + "\\target\\reports\\screenshots\\" + screenshotName));

	}

}
