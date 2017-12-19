package webModule;

import org.openqa.selenium.WebDriver;
import pageObjectRepositories.Objects_Login_Page;
import utility.Log;
import utility.Utils;

public class Methods_LoginWaypoint{
	
		
	/* **************************************************************************************************
	* Function: viewPage
	* Author: Iain Storrie
	* Date: 29/06/2017
	* Purpose: This method checks the main page elements on the Login page
	* Arguments: 
	* 			
	* Returns: 
	*****************************************************************************************************
	* Change Log:
	* 
	* Date:
	* Author: 
	* Details:
	*
	****************************************************************************************************/	
	public static void viewPage(WebDriver driver, String sTestCaseName) throws Exception{
	
		//Check that all of the elements of that are expected are displayed
		Objects_Login_Page.UsernameWaypoint(driver).isDisplayed();{
		Log.info(sTestCaseName + " | Username displayed as expected");
		}
		
		Objects_Login_Page.PasswordWaypoint(driver).isDisplayed();{
		Log.info(sTestCaseName + " | Password displayed as expected");
		}
		
		Objects_Login_Page.btn_LoginWaypoint(driver).isDisplayed();{
		Log.info(sTestCaseName + " | Login button displayed as expected");
		}
		
		//Take a screenshot to show what we've done
		Utils.takeScreenshot(driver, sTestCaseName + "-viewMainPage");
		
	//END OF VIEW PAGE METHOD
	}
	
	
	/* **************************************************************************************************
	* Function: addSuccessValues
	* Author: Iain Storrie
	* Date: 29/06/2017
	* Purpose: This method adds the required responses in the Login page in order to log in to Mobility
	* successfully
	* Arguments: 
	* 			
	* Returns: 
	*****************************************************************************************************
	* Change Log:
	* 
	* Date:
	* Author: 
	* Details:
	*
	****************************************************************************************************/	
	public static void addSuccessValuesWaypoint(WebDriver driver, String sTestCaseName) throws Exception{
	
		//Add correct responses for a successful login Procedure
		
		Objects_Login_Page.UsernameWaypoint(driver).click();
		Objects_Login_Page.UsernameWaypoint(driver).sendKeys("Paul Middleton");{
		//Objects_Login_Page.Username(driver).sendKeys("Automation");{
		Log.info(sTestCaseName + " | Username entered");
		}
		Objects_Login_Page.PasswordWaypoint(driver).click();
		Objects_Login_Page.PasswordWaypoint(driver).sendKeys("K4er1n4k4tt4!");{
		//Objects_Login_Page.Password(driver).sendKeys("Aut0m4t1on");{
		Log.info(sTestCaseName + " | Password entered");
		}
		Objects_Login_Page.btn_LoginWaypoint(driver).click();{
		Log.info(sTestCaseName + " | Login button clicked");
		}
		Thread.sleep(5000);
						
		//Take a screenshot to show what we've done
		Utils.takeScreenshot(driver, sTestCaseName + "-addSuccessValues");
		
	//END OF ADD SUCCESS VALUES METHOD
	}
	
//END OF METHODS
}