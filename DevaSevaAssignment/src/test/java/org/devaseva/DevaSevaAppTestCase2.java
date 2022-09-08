package org.devaseva;

import org.devonicventures.genericUtility.BaseClass;
import org.devonicventures.genericUtility.ThreadSafeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.devonicventures.genericUtility.ListenerImplimentationclass.class)
public class DevaSevaAppTestCase2 extends BaseClass {

		@Test
		public void TestCase1() throws InterruptedException
		{
			ThreadSafeClass.getMobileUtility().waittillElement(5000);
			driver.swipe(515, 1567, 558, 480, 500);
			driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"View all Campaigns\"]")).click();
			ThreadSafeClass.getMobileUtility().waittillElement(5000);
			WebElement bookSeva = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Book A Seva\"]"));
			boolean flag = bookSeva.isEnabled();
			
			//validation
			Assert.assertTrue(flag);
		
	}

}
