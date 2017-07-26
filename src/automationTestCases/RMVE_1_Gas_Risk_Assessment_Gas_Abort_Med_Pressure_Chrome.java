/* *******************************************************************
* Test Case Name: RMVE_1_Gas_Risk_Assessment_Gas_Abort_Med_Pressure_Chrome
* Author: Iain Storrie
* Date: 10/07/2017
* Purpose: This test ensure that a user can abort an appointment from the 
* Gas Risk Assessment - Gas page where the risk assessment fails due to Medium 
* pressure on the Chrome browser for a Remove 1 job
*
**********************************************************************
* Change Log:
* 
* Date:
* Author: 
* Details:
*
*********************************************************************/

package automationTestCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import utility.*;
import webModule.*;
import pageObjectRepositories.Objects_Abort_Page;
import pageObjectRepositories.Objects_Appointment_Details_Page;
import pageObjectRepositories.Objects_Doorstep_Protocol_Page;
import pageObjectRepositories.Objects_Gas_Meter_Initial_Risk_Assessment_Page;
import pageObjectRepositories.Objects_Gas_Meter_Risk_Assessment_Gas_Page;
import pageObjectRepositories.Objects_Login_Page;


public class RMVE_1_Gas_Risk_Assessment_Gas_Abort_Med_Pressure_Chrome {

	//Declare our test variables
	public WebDriver driver;	
	private String sTestCaseName;
	private int iTestCaseRow;
	
	//Get data and open the browser
	@BeforeMethod
	public void beforeMethod() throws Exception {
	
		DOMConfigurator.configure("log4j.xml");
	
	    sTestCaseName = this.toString();
	
	    sTestCaseName = Utils.getTestCaseName(this.toString());
	
	    Log.startTestCase(sTestCaseName);
	
	    ExcelUtils.setExcelFile(Constant.Path_TestData + "Mobility_Automation_Test_Data" + ".xlsm","Data");
		
	    iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_Test_Case_Name);
	
	    driver = Utils.openBrowser(iTestCaseRow);
	    
	    //Verify that we are on the correct page
	    Thread.sleep(10000);
	    Objects_Login_Page.btn_Login(driver).isDisplayed();
	    Log.info("Login button displayed");
		
	}
	
	//Run the test
	@Test
	public void main() throws Exception {
			
		Methods_Login.viewPage(driver, sTestCaseName);
		
		Methods_Login.addSuccessValues(driver, sTestCaseName);
		
		Methods_Appointments_List.viewPage(driver, sTestCaseName);
		
		//Select the correct appointment
		driver.findElement(By.xpath(".//*[@id='app']/div/div/workorderlistitem[193]/div/div[1]/div/div[1]/span[1]/span")).click();
		
		//Verify that we are on the Appointment Details page
		Objects_Appointment_Details_Page.btn_Call_Forward(driver).isDisplayed();
		Log.info("Appointment Details page displayed as expected");	
		
		Methods_Appointment_Details.viewPage(driver, sTestCaseName);
		
		//Verify correct Customer Details displayed
		Objects_Appointment_Details_Page.lnk_Customer_Details(driver).click();
		Methods_Appointment_Details.viewCustomerDetails(driver, sTestCaseName, 29);
				
		//Verify correct Job Details displayed
		Objects_Appointment_Details_Page.lnk_Job_Details(driver).click();
		Methods_Appointment_Details.viewJobDetails(driver, sTestCaseName, 29);
				
		//Verify correct Meter Details displayed
		Objects_Appointment_Details_Page.lnk_Meter_Details(driver).click();
		Methods_Appointment_Details.viewMeterDetails(driver, sTestCaseName, 29);
				
		//Click Call Forward to bring up Contact options
		Objects_Appointment_Details_Page.btn_Call_Forward(driver).click();
		
		//Complete Remaining Customer Contact questions
		Objects_Appointment_Details_Page.btn_Contact_Made_Yes(driver).click();
		Objects_Appointment_Details_Page.btn_Appointment_Confirm_Yes(driver).click();
		
		//Click Depart Button to progress to Doorstep Protocol Page
		Objects_Appointment_Details_Page.btn_Depart(driver).click();
		Objects_Appointment_Details_Page.btn_Depart_For_Appointment_OK(driver).click();
		
		//Verify that we are on the Doorstep Protocol page
		Objects_Doorstep_Protocol_Page.btn_Arrive(driver).isDisplayed();
		Log.info("Doorstep Protocol page displayed as expected");	
				
		//Verify that Doorstep Sidebar displayed
		Methods_Doorstep_Protocol.viewSidebar(driver, sTestCaseName);
			
		//Verify Arrive button displayed
		Methods_Doorstep_Protocol.viewPage(driver, sTestCaseName);
		Objects_Doorstep_Protocol_Page.btn_Arrive(driver).click();
			
		//Verify Arrive elements displayed
		Methods_Doorstep_Protocol.viewArrivePage(driver, sTestCaseName);
		Log.info("Doorstep Protocol page arrive elements displayed as expected");
			
		//Invoke Method to complete doorstep protocol questions for a success outcome 
		Methods_Doorstep_Protocol.addSuccessValues(driver, sTestCaseName);
		
		//Verify that we are on the Gas Meter Initial Risk Assessment page
		Objects_Gas_Meter_Initial_Risk_Assessment_Page.lbl_Initial_Risk_Assessment(driver).isDisplayed();
		Log.info("Gas Meter Initial Risk Assessment page displayed as expected");	
								
		//Invoke Method to complete a successful initial risk assessment 
		Methods_Gas_Meter_Initial_Risk_Assessment.addSuccessValues(driver, sTestCaseName);
								
		//Verify that we are on the Gas Meter Risk Assessment - Gas page
		Objects_Gas_Meter_Risk_Assessment_Gas_Page.lbl_Risk_Assessment_Gas(driver).isDisplayed();
		Log.info("Risk Assessment - Gas page displayed as expected");
		
		//Verify Initial page elements displayed
		Methods_Gas_Meter_Risk_Assessment_Gas.viewPage(driver, sTestCaseName);
		Log.info("Gas Meter Risk Assessment Gas initial elements displayed as expected");
																												
		//Invoke Method to complete an aborted risk assessment - gas due to medium pressure 
		Methods_Gas_Meter_Risk_Assessment_Gas.addAbortValuesMedGas(driver, sTestCaseName);

		//Click Abort button to bring up Abort page 
		Objects_Gas_Meter_Risk_Assessment_Gas_Page.btn_Abort(driver).click();
		Log.info("Abort button clicked");
				
		//Verify Abort page displayed
		Objects_Abort_Page.First_Utility_Additional_Questions.btn_Gas_Meter_Accessible_Yes(driver).isDisplayed();
		Log.info("Abort page displayed as expected");
		
	
	}
	
	//Log out
	@AfterMethod
	public void afterMethod() {
	
	    driver.quit();
	    
	    Log.endTestCase(sTestCaseName);        
	
	}
}

