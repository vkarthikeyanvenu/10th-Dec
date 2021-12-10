package org.testing;

import java.io.IOException;
import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.utilities.BaseClass;
import org.utilities.FBLoginPojo;

public class TestNgOrder extends BaseClass {
	
	@BeforeClass
		private void launchingChrome() {
			launchChrome();
			loadUrl("https://www.facebook.com/");
			winMax();
			printTitle();
			printCurrentUrl();
			
		}
	
	@AfterClass
		private void closingChrome() {
			closeChrome();
		}
	
	@BeforeMethod
		private void startTime() {
		loadUrl("https://www.facebook.com/");	
		System.out.println(new Date());
			
		}
	@AfterMethod
		private void endTime() {
			System.out.println(new Date());

		}
	
	@Test(invocationCount = 3)
		private void tc3() throws IOException, InterruptedException {
			FBLoginPojo f = new FBLoginPojo();
			fill(f.getTxtUser(), getData(3,0));
			fill(f.getTxtPass(), getData(3, 1));
			btnClick(f.getBtnLogin());
			
			Thread.sleep(2000);
		}
	
	@Test(priority = -20, enabled = false)
		private void tc1() throws IOException, InterruptedException {
			FBLoginPojo f = new FBLoginPojo();
			fill(f.getTxtUser(), getData(1,0));
			fill(f.getTxtPass(), getData(1, 1));
			btnClick(f.getBtnLogin());
			
			Thread.sleep(2000);
		}
		
	@Test(priority = -10, enabled = false)
		private void tc2() throws IOException, InterruptedException {
			FBLoginPojo f = new FBLoginPojo();
			fill(f.getTxtUser(), getData(2,0));
			fill(f.getTxtPass(), getData(2, 1));
			btnClick(f.getBtnLogin());
			
			Thread.sleep(2000);
			

		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
