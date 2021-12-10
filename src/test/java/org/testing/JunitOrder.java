package org.testing;

import java.io.IOException;
import java.sql.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.utilities.BaseClass;
import org.utilities.FBLoginPojo;

import junit.framework.Assert;

public class JunitOrder extends BaseClass {
	
	@BeforeClass
	public static void launchingBrowser() {
		launchChrome();
		
		winMax();
	}
	
	@AfterClass
		public static void closingBrowser() {
		closeChrome();

	}
	
	@Before
		public void startTime() {
		//Date d = new Date();
		//System.out.println(d);
		
		loadUrl("https://www.facebook.com/");	
	}
	
	@After
		public void endTime() {
		System.out.println(new Date(0));
	
	}
	
	@Test
		public void tc1() throws IOException, InterruptedException {
			String title = driver.getTitle();
			
			Assert.assertTrue("Verify the title", !title.contains("Facebook"));
		
		
			FBLoginPojo f = new FBLoginPojo();
			fill(f.getTxtUser(), getData(1,0));
			fill(f.getTxtPass(), getData(1,1));
			
			String currentUrl = driver.getCurrentUrl();
			String expect = "https://www.facebook.com/";
			
			Assert.assertEquals("Verify the URL",expect, currentUrl);
			btnClick(f.getBtnLogin());
			
			Thread.sleep(2000);

		}
	
	@Test
		public void tc3() throws IOException, InterruptedException {
		FBLoginPojo f = new FBLoginPojo();
		fill(f.getTxtUser(), getData(2,0));
		fill(f.getTxtPass(), getData(2,1));
		btnClick(f.getBtnLogin());
		
		Thread.sleep(2000);

		}
	
	@Test
		public void tc2() throws IOException, InterruptedException {
		
		FBLoginPojo f = new FBLoginPojo();
		fill(f.getTxtUser(), getData(3,0));
		fill(f.getTxtPass(), getData(3,1));
		btnClick(f.getBtnLogin());
		
		Thread.sleep(2000);
			

		}
	
	
	
	

}
