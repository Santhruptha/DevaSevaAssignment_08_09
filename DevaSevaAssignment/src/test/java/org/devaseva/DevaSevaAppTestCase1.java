package org.devaseva;

import org.devonicventures.genericUtility.BaseClass;
import org.devonicventures.genericUtility.ThreadSafeClass;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.devonicventures.genericUtility.ListenerImplimentationclass.class)
public class DevaSevaAppTestCase1 extends BaseClass {
	
	@Test
	public void TestCase1() throws InterruptedException
	{
		ThreadSafeClass.getMobileUtility().waittillElement(7000);
		driver.swipe(515, 1779, 558, 480, 500);
		ThreadSafeClass.getMobileUtility().waittillElement(2000);
		driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\"Book A Seva\"])[1]")).click();
		ThreadSafeClass.getMobileUtility().waittillElement(7000);
		driver.swipe(515, 1567, 558, 480, 500);
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Book A Seva - Rs.2116.00\"]")).click();
		ThreadSafeClass.getMobileUtility().waittillElement(4000);
		driver.findElement(By.xpath("//android.view.View[@content-desc='ENTER YOUR DETAILS']/android.widget.EditText[1]")).sendKeys("Santhruptha");
		driver.findElement(By.xpath("//android.view.View[@content-desc='ENTER YOUR DETAILS']/android.widget.EditText[2]")).sendKeys("sks123@gmail.com");
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Proceed to pay (₹ 2327.60)\"]")).click();	
	}

}
