package org.devonicventures.pomrepo;

import org.devonicventures.genericUtility.BaseClass;
import org.devonicventures.genericUtility.ThreadSafeClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class homePage  {
	
	public homePage(AndroidDriver<WebElement> driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//android.widget.Button[@content-desc='Book A Seva'])[1]")
	private WebElement bookSevaBtn ;
	
	@FindBy(xpath="//android.widget.Button[@content-desc=\\\"Book A Seva - Rs.2116.00\\\"]")
	private WebElement bookCurrentSeva ;
	
	@FindBy(xpath="/android.view.View[@content-desc='ENTER YOUR DETAILS']/android.widget.EditText[1]")
	private WebElement nameTf ;
	
	@FindBy(xpath="//android.view.View[@content-desc='ENTER YOUR DETAILS']/android.widget.EditText[2]")
	private WebElement emailTf ;
	
	@FindBy(xpath="//android.widget.Button[@content-desc=\\\"Proceed to pay (₹ 2327.60)\\")
	private WebElement proccedToPayBtn ;
	
	
	//businessLibraries
	public void BookSevaTest() throws InterruptedException
	{
		ThreadSafeClass.getMobileUtility().waittillElement(5000);
		ThreadSafeClass.getMobileUtility().swipeAction(515, 1567, 558, 480, 500);
		bookSevaBtn.click();
		ThreadSafeClass.getMobileUtility().waittillElement(7000);
		ThreadSafeClass.getMobileUtility().swipeAction(515, 1567, 558, 480, 500);
		bookCurrentSeva.click();
		ThreadSafeClass.getMobileUtility().waittillElement(7000);
		nameTf.sendKeys("Santhruptha");
		emailTf.sendKeys("sks@gmail.com");
		proccedToPayBtn.click();
			
	}


}
