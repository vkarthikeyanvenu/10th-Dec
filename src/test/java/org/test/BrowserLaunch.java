package org.test;

import java.io.IOException;

import org.utilities.BaseClass;
import org.utilities.FBLoginPojo;

public class BrowserLaunch extends BaseClass {
	
	public static void main(String[] args) throws IOException {
		
		launchChrome();
		
		loadUrl("https://www.facebook.com/");
		
		winMax();
		
		printTitle();
		
		printCurrentUrl();
		
		
		FBLoginPojo f = new FBLoginPojo();
		
		fill(f.getTxtUser(), getData(1,0));
		
		
		fill(f.getTxtPass(), getData(1,1));
		
		//rightClick(txtPass);
		
		
		//btnClick(f.getBtnLogin());
		
		//takeSnap(filename);
		
		
		driver.navigate().refresh();
		
		FBLoginPojo f1 = new FBLoginPojo();
		fill(f1.getTxtUser(), getData(3,1));
		
		
		
		
	}

}
