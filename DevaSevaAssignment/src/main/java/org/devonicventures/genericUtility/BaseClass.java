package org.devonicventures.genericUtility;

import java.net.MalformedURLException;
import java.net.URL;

import org.devonicventures.pomrepo.homePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseClass {
	AppiumDriverLocalService service;
	public AndroidDriver<WebElement> driver;
	public MobileUtility mobileUtility;
	public FileUtility fileUtility;
	JavaUtility javaUtility;
	public homePage homepage;
	
	
	


	@BeforeSuite
	public void suiteSetUp()
	{
		//		System.out.println("Open database connection");
	}

	//	@BeforeClass
	//	public void classSetUp() {
	//		
	//		//here also we will select on which platform like ios or android
	//		service=AppiumDriverLocalService.buildDefaultService();
	//		service.start();
	//	}
	@BeforeMethod
	public void methodSetUp() throws MalformedURLException {
		mobileUtility=new MobileUtility();
		fileUtility=new FileUtility();
		javaUtility=new JavaUtility();

		ThreadSafeClass.setFileUtility(fileUtility);
		ThreadSafeClass.getFileUtility().initializePropertyFile(IConstants.PROPERTYFILEPATH);


		//fetch the data from property file
		String platformVersion=ThreadSafeClass.getFileUtility().getDataFromProperties("platformVersion");
		String appPackage=ThreadSafeClass.getFileUtility().getDataFromProperties("appPackage");
		String appActivity=ThreadSafeClass.getFileUtility().getDataFromProperties("appActivity");
		String deviceId=ThreadSafeClass.getFileUtility().getDataFromProperties("deviceId");

		DesiredCapabilities cap = mobileUtility.initializeDesiredCapabilities(IConstants.PLATFORMNAME, platformVersion, deviceId,appPackage,appActivity);
		URL url = mobileUtility.initializeUrl(fileUtility.getDataFromProperties("urlAddress"));
		driver = mobileUtility.initializeAndroidDriver(url, cap);

		//Thread safe class
		ThreadSafeClass.setDriver(driver);
		ThreadSafeClass.setJavaUtility(javaUtility);
		ThreadSafeClass.setMobileUtility(mobileUtility);

		ListenerImplimentationclass.testLog.info("Application Opened");

		
		ThreadSafeClass.getMobileUtility().initializeExplicitWait(10);
		
		
//		 homepage=new homePage(driver);

	
	}

	@AfterMethod
	public void methodTearDown() {
		driver.closeApp();
		ListenerImplimentationclass.testLog.info("Application closed");
	}
	@AfterClass
	//	public void classTearDown() {
	//		service.stop();
	//	}

	@AfterSuite
	public void suiteTearDown() {
		//		System.out.println("close data base connection");
	}

}
