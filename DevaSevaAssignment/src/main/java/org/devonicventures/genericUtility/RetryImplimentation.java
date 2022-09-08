package org.devonicventures.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplimentation implements IRetryAnalyzer{

	int count =0;
	int retrylimit=2;
	public boolean retry(ITestResult result) {
		while(count<retrylimit)
		{
			count++;
			return true;
		}
		return false;

	}



}
