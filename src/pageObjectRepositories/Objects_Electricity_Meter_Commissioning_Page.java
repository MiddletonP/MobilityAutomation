package pageObjectRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;

/* *******************************************************************
* Author: Iain Storrie
* Date: 06/06/2017
* Function: Objects_Electiricty_Meter_Commissioning_Page
* Purpose: This class contains all of the elements on the Electricity Meter Commissioning page
* Arguments: 
* 			
* Returns: 
**********************************************************************
* Change Log:
* 
* Date:
* Author: 
* Details:
*
*********************************************************************/

public class Objects_Electricity_Meter_Commissioning_Page {
   
    private static WebElement element = null;
    private static String sRepositoryName = "Objects_Electricity_Meter_Commissioning_Page";

    public static WebElement lbl_Commissioning(WebDriver driver){
    	 
		try{
			element = driver.findElement(By.xpath(".//*[@id='app']/div/div/div[2]/div[2]/ng-switch/div/electask/div/div/commission/div/div[1]/div[1]/h4"));
 		}catch(Exception e){
			Log.error(sRepositoryName + " | lbl_Commissioning not found | Exception desc : "+e.getMessage());		
 		} 
	    return element;
	}
    
    public static WebElement cbx_Non_Serialised_Assets(WebDriver driver){
   	 
		try{
			element = driver.findElement(By.id("select4"));
 		}catch(Exception e){
			Log.error(sRepositoryName + " | cbx_Non_Serialised_Assets not found | Exception desc : "+e.getMessage());		
 		} 
	    return element;
	}
    
    public static WebElement txt_Non_Serialised_Assets_Number(WebDriver driver){
      	 
		try{
			element = driver.findElement(By.id("bar3"));
 		}catch(Exception e){
			Log.error(sRepositoryName + " | txt_Non_Serialised_Assets_Number not found | Exception desc : "+e.getMessage());		
 		} 
	    return element;
	}
    
    public static WebElement img_Trash(WebDriver driver){
     	 
		try{
			element = driver.findElement(By.xpath(".//*[@id='app']/div/div/div[2]/div[2]/ng-switch/div/electask/div/div/commission/div/div[2]/div[1]/div[2]/div/div[3]"));
 		}catch(Exception e){
			Log.error(sRepositoryName + " | img_Trash not found | Exception desc : "+e.getMessage());		
 		} 
	    return element;
	}
    
    public static WebElement btn_Add_Another_Asset(WebDriver driver){
    	 
		try{
			element = driver.findElement(By.id("btn1"));
 		}catch(Exception e){
			Log.error(sRepositoryName + " | btn_Add_Another_Asset not found | Exception desc : "+e.getMessage());		
 		} 
	    return element;
	}
    
    public static WebElement btn_Next_Section(WebDriver driver){
   	 
		try{
			element = driver.findElement(By.id("btnNextComm"));
 		}catch(Exception e){
			Log.error(sRepositoryName + " | btn_Next_Section not found | Exception desc : "+e.getMessage());		
 		} 
	    return element;
	}
      
	public static WebElement lbl_Commissioning_Complete(WebDriver driver){
	   	 
		try{
			element = driver.findElement(By.xpath(".//*[@id='app']/div/div/div[2]/div[2]/ng-switch/div/electask/div/div/commission/div/div[1]/div[2]"));
 		}catch(Exception e){
			Log.error(sRepositoryName + " | lbl_Commissioning_Complete not found | Exception desc : "+e.getMessage());		
 		} 
	    return element;
	}
	
			
//END OF METHODS	    
}
