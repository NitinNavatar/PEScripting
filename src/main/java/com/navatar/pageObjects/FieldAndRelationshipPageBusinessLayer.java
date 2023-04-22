package com.navatar.pageObjects;

import static com.navatar.generic.CommonLib.FindElement;
import static com.navatar.generic.CommonLib.click;
import static com.navatar.generic.CommonLib.log;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.navatar.generic.CommonLib;
import com.navatar.generic.CommonVariables;
import com.navatar.generic.EnumConstants.Condition;
import com.navatar.generic.EnumConstants.YesNo;
import com.navatar.generic.EnumConstants.action;
import com.relevantcodes.extentreports.LogStatus;

public class FieldAndRelationshipPageBusinessLayer extends FieldAndRelationshipPage {

	public FieldAndRelationshipPageBusinessLayer(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}


	
	public boolean activateOrAddPicklistValueOfField(String projectName, String fieldName,String value, Condition condition)
	{
		SetupPageBusinessLayer setup =new SetupPageBusinessLayer(driver);
		WebElement ele;
		
		boolean flag=false;
		CommonLib.ThreadSleep(5000);
				CommonLib.switchToFrame(driver, 20, setup.getSetUpPageIframe(60));
				CommonLib.ThreadSleep(5000);
				String xpath="//th[@scope='row' and text()='"+value+"']/preceding-sibling::td";
				ele =FindElement(driver, xpath, "", action.SCROLLANDBOOLEAN, 10);
				if(ele!=null) {
					 xpath="//th[@scope='row' and text()='"+value+"']/preceding-sibling::td//a[contains(@title,'ctivate')]";
					ele =FindElement(driver, xpath, "", action.BOOLEAN, 10);
					String actionStatus=CommonLib.getText(driver, ele, value+" Field", action.SCROLLANDBOOLEAN);
					if(condition.toString().equals("activate"))
					{
						if(!actionStatus.equalsIgnoreCase("Deactivate"))
						{
							if (CommonLib.click(driver, ele,value+" activate button" , action.SCROLLANDBOOLEAN)) {
								log(LogStatus.INFO, "clicked on the activate button of " +value, YesNo.No);
								CommonLib.ThreadSleep(10000);
								CommonLib.switchToDefaultContent(driver);
								CommonLib.ThreadSleep(3000);
								flag =true;
								if(fieldName.equalsIgnoreCase("Industry")) {
									CommonVariables.industryAactivatedFields.add(value);
								}else if(fieldName.equalsIgnoreCase("type")) {
									CommonVariables.typeAactivatedFields.add(value);

								}else {
									CommonVariables.accountSourceAactivatedFields.add(value);

								}
								
							}					
						}
						else
						{
							CommonLib.switchToDefaultContent(driver);
							CommonLib.ThreadSleep(3000);
							log(LogStatus.INFO, value+" is already Activated", YesNo.No);

							flag=true;
						}
					}
				}else {
					
					if(CommonLib.click(driver, getpicklistNewButton(60), "New Button for Picklist", action.SCROLLANDBOOLEAN))
					{
						CommonLib.ThreadSleep(3000);
						log(LogStatus.INFO, "clicked on the New button", YesNo.No);
						CommonLib.switchToDefaultContent(driver);
						CommonLib.ThreadSleep(3000);
						CommonLib.switchToFrame(driver, 30, getaddPicklistIFrame(30));
						CommonLib.ThreadSleep(5000);
						if(CommonLib.sendKeys(driver, getaddPicklistTextArea(50), value, "Textarea", action.SCROLLANDBOOLEAN))
						{
							
							log(LogStatus.INFO, "Value has been passed into the Picklist textarea", YesNo.No);

							if(CommonLib.click(driver, getallRecordTypeCheckbox(20), "New Button for Picklist", action.SCROLLANDBOOLEAN)) {
								
								log(LogStatus.INFO, "able to click on all record type checkbox", YesNo.No);

							if(CommonLib.click(driver, getsaveButton(20),"Save Button", action.SCROLLANDBOOLEAN))
							{
								CommonLib.ThreadSleep(7000);
								log(LogStatus.INFO, "Save button has been clicked", YesNo.No);
								CommonLib.switchToDefaultContent(driver);
								CommonLib.switchToFrame(driver, 40, getfieldsAndRelationshipsIframe(30));
								try
								{
									ele=new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[text()='"+value+"']")));
								}
								catch(Exception ex)
								{
									ex.printStackTrace();
									log(LogStatus.ERROR,"Option is not created in the Piclist",YesNo.Yes);
									return false;
								}
								if(ele!=null)
								{
									log(LogStatus.PASS, "Option has been created in the Piclist", YesNo.No);
									flag=true;
									if(fieldName.equalsIgnoreCase("Industry")) {
										CommonVariables.industryAddedFields.add(value);
									}else if(fieldName.equalsIgnoreCase("type")) {
										CommonVariables.typeAddedFields.add(value);

									}else {
										CommonVariables.accountSourceAddedFields.add(value);

									}
									CommonLib.switchToDefaultContent(driver);
									CommonLib.ThreadSleep(3000);
								}
								else
								{
									log(LogStatus.ERROR,"Option is not created in the Piclist",YesNo.Yes);
									flag=false;
								}							
							}
							else
							{
								log(LogStatus.ERROR,"Could not click on the save button",YesNo.Yes);
								flag=false;
							}
							
							}else {
								log(LogStatus.ERROR,"Could not click on the all record type checkbox button",YesNo.Yes);
								flag=false;
							}	
						}
						else
						{
							log(LogStatus.ERROR,"Could not pass the option value in the Picklist textarea",YesNo.Yes);
							flag=false;
						}
					}
					else
					{
						log(LogStatus.ERROR,"Could not click on the New Button",YesNo.Yes);
						flag=false;
					}
					
				}			
		


		return flag;

	}
	
	public boolean deactivatePicklistValueOfField(String projectName, String fieldName,String value, Condition condition)
	{
		SetupPageBusinessLayer setup =new SetupPageBusinessLayer(driver);
		WebElement ele;
		
		boolean flag=false;
		CommonLib.ThreadSleep(5000);
				CommonLib.switchToFrame(driver, 20, setup.getSetUpPageIframe(60));
				CommonLib.ThreadSleep(5000);
				String xpath="//th[@scope='row' and text()='"+value+"']/preceding-sibling::td";
				ele =FindElement(driver, xpath, "", action.SCROLLANDBOOLEAN, 10);
				if(ele!=null) {
					 xpath="//th[@scope='row' and text()='"+value+"']/preceding-sibling::td//a[contains(@title,'ctivate')]";
					ele =FindElement(driver, xpath, "", action.BOOLEAN, 10);
					String actionStatus=CommonLib.getText(driver, ele, value+" Field", action.SCROLLANDBOOLEAN);
					if(condition.toString().equalsIgnoreCase("deactivate"))
					{
						if(!actionStatus.equalsIgnoreCase("Activate"))
						{
							if (CommonLib.click(driver, ele,value+" Activate button" , action.SCROLLANDBOOLEAN)) {

								if(!CommonLib.isAlertPresent(driver))
								{		
									CommonLib.clickUsingJavaScript(driver, ele,value+" field" , action.SCROLLANDBOOLEAN);

								}

								CommonLib.switchToAlertAndAcceptOrDecline(driver, 20, action.ACCEPT);
								CommonLib.ThreadSleep(20000);
								CommonLib.switchToDefaultContent(driver);
								CommonLib.ThreadSleep(3000);
								log(LogStatus.INFO, "clicked on the Activate button of " +value, YesNo.No);	

								flag=true;
							}					
						}
						else
						{
							log(LogStatus.INFO, value+" is already Deactivated", YesNo.No);
							CommonLib.switchToDefaultContent(driver);
							CommonLib.ThreadSleep(3000);
							flag=true;
						}
					}
				}


		return flag;

	}


	public boolean editPicklistFieldLabel(String projectName, String fieldName,String labelName,String apiName)
	{
		String xPath="";
		WebElement ele;
		boolean flag=false;
		if(CommonLib.sendKeysAndPressEnter(driver, getQucikSearchInFieldAndRelationshipPage(50),fieldName , "Field", action.SCROLLANDBOOLEAN))
		{
			log(LogStatus.INFO,"Field value has been passed in "+fieldName,YesNo.No);
			CommonLib.ThreadSleep(6000);
			xPath="//span[text()='"+fieldName+"']";
			ele = FindElement(driver, xPath, fieldName + " xpath", action.SCROLLANDBOOLEAN, 30);
			if (CommonLib.click(driver, ele,fieldName+" field" , action.SCROLLANDBOOLEAN)) {
				log(LogStatus.INFO, "clicked on Field" + fieldName, YesNo.No);
				CommonLib.ThreadSleep(7000);
				CommonLib.switchToFrame(driver, 40, getfieldsAndRelationshipsIframe(30));
				try
				{
					ele=new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[text()='"+apiName+"']/preceding-sibling::td//a[contains(@title,'Edit')]")));
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
					log(LogStatus.ERROR,"Could not found the "+fieldName+" Element",YesNo.Yes);
					return false;
				}
				if(CommonLib.click(driver, ele, fieldName+" Field", action.SCROLLANDBOOLEAN))
				{
					CommonLib.switchToDefaultContent(driver);
					CommonLib.switchToFrame(driver, 50, getpiclistEditiframe(30));
					if(CommonLib.sendKeys(driver, getEditPicklistLabelName(50), labelName, apiName+ " Picklist Value", action.SCROLLANDBOOLEAN))
					{
						log(LogStatus.INFO, labelName+" has been passed in the Picklist Label Name" , YesNo.No);
						if(CommonLib.click(driver, geteditPicklistSaveButton(30), "Save Button" , action.SCROLLANDBOOLEAN))
						{
							log(LogStatus.INFO, "Clicked on the Save button" , YesNo.No);
							CommonLib.switchToDefaultContent(driver);
							CommonLib.switchToFrame(driver, 40, getfieldsAndRelationshipsIframe(30));			
							CommonLib.ThreadSleep(15000);
							try
							{
								ele=new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[text()='"+apiName+"']/preceding-sibling::th")));
							}
							catch(Exception ex)
							{
								ex.printStackTrace();
								log(LogStatus.ERROR,"Could not found the "+labelName+" Element",YesNo.Yes);
								return false;
							}


							String Buttonstatus=CommonLib.getText(driver, ele, apiName+" value status", action.SCROLLANDBOOLEAN);
							if(Buttonstatus.equals(labelName))
							{
								log(LogStatus.PASS, apiName+" value has been changed"  , YesNo.No);
								flag=true;
							}
							else
							{
								log(LogStatus.ERROR,apiName+" value is not changed",YesNo.Yes);
								flag=false;
							}											
						}
						else
						{
							log(LogStatus.ERROR,"Could not click on the save button",YesNo.Yes);
							flag=false;
						}
					}
					else
					{
						log(LogStatus.ERROR,"Could not pass the label name of "+apiName,YesNo.Yes);
						flag=false;
					}
				}
				else
				{
					log(LogStatus.ERROR,"Could not click on the Edit Button of "+apiName,YesNo.Yes);
					flag=false;
				}

			}

			else
			{
				log(LogStatus.ERROR,"Could not click on the "+fieldName,YesNo.Yes);
				flag=false;
			}
		}
		else
		{
			log(LogStatus.ERROR,"Could not pass the Field value "+fieldName,YesNo.Yes);
			flag=false;
		}
		return flag;

	}



	public boolean deletePicklistOptionAndReplaceValue(String projectName, String fieldName,String ReplaceValue,String apiName,Condition condition)
	{
		String xPath="";
		WebElement ele;
		boolean flag=false;
		if(CommonLib.sendKeysAndPressEnter(driver, getQucikSearchInFieldAndRelationshipPage(50),fieldName , "Field", action.SCROLLANDBOOLEAN))
		{
			log(LogStatus.INFO,"Field value has been passed in "+fieldName,YesNo.No);
			CommonLib.ThreadSleep(6000);
			xPath="//span[text()='"+fieldName+"']";
			ele = FindElement(driver, xPath, fieldName + " xpath", action.SCROLLANDBOOLEAN, 30);
			if (CommonLib.click(driver, ele,fieldName+" field" , action.SCROLLANDBOOLEAN)) {
				log(LogStatus.INFO, "clicked on Field" + fieldName, YesNo.No);
				CommonLib.ThreadSleep(7000);
				CommonLib.switchToFrame(driver, 40, getfieldsAndRelationshipsIframe(30));
				try
				{
					ele=new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[text()='"+apiName+"']/preceding-sibling::td//a[contains(@title,'Del')]")));
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
					log(LogStatus.ERROR,"Could not found the "+fieldName+" Element",YesNo.Yes);
					return false;
				}
				if(CommonLib.click(driver, ele, fieldName+" Field", action.SCROLLANDBOOLEAN))
				{				
					log(LogStatus.INFO, "clicked on the Del button of " +apiName, YesNo.No);
					if(!CommonLib.isAlertPresent(driver))
					{		
						CommonLib.clickUsingJavaScript(driver, ele,apiName+" field" , action.SCROLLANDBOOLEAN);
					}
					CommonLib.switchToAlertAndAcceptOrDecline(driver, 20, action.ACCEPT);
					CommonLib.switchToDefaultContent(driver);
					log(LogStatus.INFO, "Clicked on OK button on the Alert Popup", YesNo.No);
					CommonLib.switchToFrame(driver, 50, getfindAndReplaceIframe(50));

					if(condition.toString().equals("replaceWithValue"))
					{
						if(CommonLib.selectVisibleTextFromDropDown(driver, getreplaceValueDropDown(50), "Replace Value Drop Down", ReplaceValue))
						{
							if(CommonLib.click(driver, geteditPicklistSaveButton(30), "Save Button" , action.SCROLLANDBOOLEAN))
							{
								log(LogStatus.INFO, "Clicked on the Save button" , YesNo.No);
							}
							else
							{
								log(LogStatus.ERROR,"Could not click on the save button",YesNo.Yes);
								flag=false;
							}
						}
						else
						{
							log(LogStatus.ERROR,"Could not select the "+ReplaceValue+ "from the Replace option ",YesNo.Yes);
							flag=false;
						}
					}
					else if(condition.toString().equals("replaceWithBlank"))
					{

						if(CommonLib.click(driver, getreplaceValueWithNull(30), "Save Button" , action.SCROLLANDBOOLEAN))
						{
							log(LogStatus.INFO, "Clicked on the Replace value on records with blank value" , YesNo.No);
							if(CommonLib.click(driver, geteditPicklistSaveButton(30), "Save Button" , action.SCROLLANDBOOLEAN))
							{
								log(LogStatus.INFO, "Clicked on the Save button" , YesNo.No);
							}
							else
							{
								log(LogStatus.ERROR,"Could not click on the save button",YesNo.Yes);
								flag=false;
							}
						}
						else
						{
							log(LogStatus.ERROR,"Could not Click on the Replace value on records with blank value",YesNo.Yes);
							flag=false;
						}

					}

					CommonLib.switchToDefaultContent(driver);
					CommonLib.switchToFrame(driver, 40, getfindAndReplaceIframe(30));			
					CommonLib.ThreadSleep(15000);

					if(!CommonLib.isElementPresent(ele))
					{
						log(LogStatus.INFO, apiName+" has been deleted" , YesNo.No);
						flag=true;
					}
					else
					{
						log(LogStatus.ERROR,apiName+" is not deleted",YesNo.Yes);
						flag=false;
					}

				}
				else
				{
					log(LogStatus.ERROR,"Could not click on the Del Button of "+apiName,YesNo.Yes);
					flag=false;
				}

			}
			else
			{
				log(LogStatus.ERROR,"Could not click on the "+fieldName,YesNo.Yes);
				flag=false;
			}
		}
		else
		{
			log(LogStatus.ERROR,"Could not pass the Field value "+fieldName,YesNo.Yes);
			flag=false;
		}
		return flag;

	}

	public boolean createPicklistValue(String projectName, String fieldName,String optionValueName)
	{
		String xPath="";
		WebElement ele;
		boolean flag=false;
		if(CommonLib.sendKeysAndPressEnter(driver, getQucikSearchInFieldAndRelationshipPage(50),fieldName , "Field", action.SCROLLANDBOOLEAN))
		{
			log(LogStatus.INFO,"Field value has been passed in "+fieldName,YesNo.No);
			CommonLib.ThreadSleep(6000);
			xPath="//span[text()='"+fieldName+"']";
			ele = FindElement(driver, xPath, fieldName + " xpath", action.SCROLLANDBOOLEAN, 30);
			if (CommonLib.click(driver, ele,fieldName+" field" , action.SCROLLANDBOOLEAN)) {
				log(LogStatus.INFO, "clicked on Field" + fieldName, YesNo.No);
				CommonLib.ThreadSleep(7000);
				CommonLib.switchToFrame(driver, 40, getfieldsAndRelationshipsIframe(30));
				if(CommonLib.click(driver, getpicklistNewButton(60), "New Button for Picklist", action.SCROLLANDBOOLEAN))
				{
					log(LogStatus.INFO, "clicked on the New button", YesNo.No);
					CommonLib.switchToDefaultContent(driver);
					CommonLib.switchToFrame(driver, 50, getaddPicklistIFrame(50));
					if(CommonLib.sendKeys(driver, getaddPicklistTextArea(50), optionValueName, "Textarea", action.SCROLLANDBOOLEAN))
					{
						log(LogStatus.INFO, "Value has been passed into the Picklist textarea", YesNo.No);
						if(CommonLib.click(driver, getsaveButton(50),"Save Button", action.SCROLLANDBOOLEAN))
						{
							log(LogStatus.INFO, "Save button has been clicked", YesNo.No);
							CommonLib.switchToDefaultContent(driver);
							CommonLib.switchToFrame(driver, 40, getfieldsAndRelationshipsIframe(30));
							try
							{
								ele=new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[text()='"+optionValueName+"']")));
							}
							catch(Exception ex)
							{
								ex.printStackTrace();
								log(LogStatus.ERROR,"Option is not created in the Piclist",YesNo.Yes);
								return false;
							}
							if(ele!=null)
							{
								log(LogStatus.PASS, "Option has been created in the Piclist", YesNo.No);
								flag=true;
							}
							else
							{
								log(LogStatus.ERROR,"Option is not created in the Piclist",YesNo.Yes);
								flag=false;
							}							
						}
						else
						{
							log(LogStatus.ERROR,"Could not click on the save button",YesNo.Yes);
							flag=false;
						}
					}
					else
					{
						log(LogStatus.ERROR,"Could not pass the option value in the Picklist textarea",YesNo.Yes);
						flag=false;
					}
				}
				else
				{
					log(LogStatus.ERROR,"Could not click on the New Button",YesNo.Yes);
					flag=false;
				}
			}
			else
			{
				log(LogStatus.ERROR,"Could not click on the "+fieldName,YesNo.Yes);
				flag=false;
			}
		}
		else
		{
			log(LogStatus.ERROR,"Could not pass the Field value "+fieldName,YesNo.Yes);
			flag=false;
		}
		return flag;
	}

	public boolean replacePiclistOptionValue(String projectName,String changingToValue,String changingFromValue)
	{
		boolean flag=false;
		if(CommonLib.click(driver, getreplaceButton(50), "Replace Button Name", action.SCROLLANDBOOLEAN))
		{
			CommonLib.switchToDefaultContent(driver);
			CommonLib.switchToFrame(driver, 50, getReplaceOptionIframe(50));
			log(LogStatus.INFO, "Clickd on the Replace button", YesNo.No);
			if(CommonLib.sendKeys(driver, getvalueChangingFrom(50), changingFromValue, "Changing From Value", action.SCROLLANDBOOLEAN))
			{
				log(LogStatus.INFO, changingFromValue+" has been passed in Exact Value Changing From textbox", YesNo.No);
				if(CommonLib.selectVisibleTextFromDropDown(driver, getvalueChangingTo(50),  "Value Changing From Dropdown" ,changingToValue))
				{
					log(LogStatus.INFO, changingToValue+" has been selected from the Value changing to dropdown field", YesNo.No);
					if(CommonLib.click(driver,	getreplaceButton(60), "Replace Button", action.SCROLLANDBOOLEAN))
					{
						log(LogStatus.INFO, "Replace button has been clicked", YesNo.No);
						CommonLib.switchToDefaultContent(driver);
						CommonLib.switchToFrame(driver, 50, getReplacePicklistConfirmationiframe(50));
						String Message=CommonLib.getText(driver, getReplaceConfirmationMessage(50), "Confirmation Message", action.SCROLLANDBOOLEAN);
						if(Message.equals("Replace Picklist Confirmation"))
						{
							log(LogStatus.INFO, changingToValue+ " has been replaced with the "+changingToValue, YesNo.No);
							CommonLib.switchToDefaultContent(driver);
							flag=true;
						}
						else
						{
							log(LogStatus.ERROR, "Could not repalce the "+changingFromValue+ " value with the "+changingToValue, YesNo.No);
							flag=false;
						}
					}
					else
					{
						log(LogStatus.ERROR, "Could not click on the Replace Buttob", YesNo.No);
						flag=false;
					}
				}
				else
				{
					log(LogStatus.ERROR, "Could not select the value from the Dropdown", YesNo.No);
					flag=false;
				}
			}
			else
			{
				log(LogStatus.ERROR,"Could not pass the value in the Exact Value Changing From textbox ",YesNo.Yes);
				flag=false;
			}
		}
		else
		{
			log(LogStatus.ERROR,"Could not click on the Replace button",YesNo.Yes);
			flag=false;
		}

		return flag;

	}

	public boolean verifyField(String fieldName)
	{
		String xPath="";
		WebElement ele;
		boolean flag=false;
		if(CommonLib.sendKeysAndPressEnter(driver, getQucikSearchInFieldAndRelationshipPage(50),fieldName ,fieldName+" field", action.SCROLLANDBOOLEAN))
		{
			log(LogStatus.INFO,"Field value has been passed in "+fieldName,YesNo.No);
			CommonLib.ThreadSleep(6000);
			xPath="//span[text()='"+fieldName+"']";
			ele = FindElement(driver, xPath, fieldName + " xpath", action.SCROLLANDBOOLEAN, 30);
			if (ele!=null) {
				log(LogStatus.INFO, fieldName+" field is appearing", YesNo.No);	
				flag=true;
			}
			else
			{
				log(LogStatus.ERROR, fieldName+" field is not appearing", YesNo.Yes);	
			}
		}
		else
		{
			log(LogStatus.ERROR,"Not able to pass the "+fieldName+" in the searchbox", YesNo.Yes);
		}
		return flag;
	}

	public ArrayList<String> verifyPicklistValue(String fieldName, String[] picklistValue,Condition condition)
	{
		String xPath="";
		WebElement ele;
		List<WebElement> elements;
		ArrayList<String> picklistExpectedValue=new ArrayList<String>();
		ArrayList<String> picklistActualValue=new ArrayList<String>();
		ArrayList<String> result=new ArrayList<String>();

		for(int i=0; i<picklistValue.length; i++)
		{
			picklistExpectedValue.add(picklistValue[i]);
		}

		if(CommonLib.sendKeysAndPressEnter(driver, getQucikSearchInFieldAndRelationshipPage(50),fieldName ,fieldName+" field", action.SCROLLANDBOOLEAN))
		{
			log(LogStatus.INFO,"Field value has been passed in "+fieldName,YesNo.No);
			CommonLib.ThreadSleep(6000);
			xPath="//span[text()='"+fieldName+"']";
			ele = FindElement(driver, xPath, fieldName + " xpath", action.SCROLLANDBOOLEAN, 30);
			if (CommonLib.click(driver, ele,fieldName+" field" , action.SCROLLANDBOOLEAN)) {
				log(LogStatus.INFO, "clicked on Field" + fieldName, YesNo.No);
				CommonLib.ThreadSleep(10000);
				if(CommonLib.switchToFrame(driver, 40, getfieldsAndRelationshipsIframe(30)))
				{
					log(LogStatus.INFO,"Successfully switch to Field and Relationship Iframe", YesNo.No);
					if(condition.toString().equals("activate"))
					{
						xPath="//a[text()='Deactivate']/ancestor::tr//th";
						elements=CommonLib.FindElements(driver, xPath, "Active picklist");
						for(int i=0; i<elements.size(); i++)
						{
							String text=CommonLib.getText(driver, elements.get(i), "Active Picklist "+i+ "", action.SCROLLANDBOOLEAN);
							picklistActualValue.add(text);
						}

						for(int i=0; i<picklistExpectedValue.size(); i++)
						{
							if(picklistExpectedValue.get(i).equals(picklistActualValue.get(i)))
							{
								log(LogStatus.INFO,picklistExpectedValue.get(i)+" has been matched with the "+picklistActualValue.get(i), YesNo.No);					
							}
							else
							{
								log(LogStatus.ERROR,picklistExpectedValue.get(i)+" is not matched with the "+picklistActualValue.get(i), YesNo.Yes);
								result.add(picklistExpectedValue.get(i)+" is not matched with the "+picklistActualValue.get(i));
							}
						}

					}


					else if(condition.toString().equals("deactivate"))
					{
						xPath="//a[text()='Activate']/ancestor::tr//th";
						elements=CommonLib.FindElements(driver, xPath, "inactive picklist");
						for(int i=0; i<elements.size(); i++)
						{
							String text=CommonLib.getText(driver, elements.get(i), "inactive Picklist "+i+ "", action.SCROLLANDBOOLEAN);
							picklistActualValue.add(text);
						}

						for(int i=0; i<picklistExpectedValue.size(); i++)
						{
							if(picklistExpectedValue.get(i).equals(picklistActualValue.get(i)))
							{
								log(LogStatus.INFO,picklistExpectedValue.get(i)+" has been matched with the "+picklistActualValue.get(i), YesNo.No);					
							}
							else
							{
								log(LogStatus.ERROR,picklistExpectedValue.get(i)+" is not matched with the "+picklistActualValue.get(i), YesNo.Yes);
								result.add(picklistExpectedValue.get(i)+" is not matched with the "+picklistActualValue.get(i));
							}
						}

					}
				}
				else
				{
					log(LogStatus.ERROR,"Not able to switch to Field and Relationship Iframe", YesNo.Yes);
					result.add("Not able to switch to Field and Relationship Iframe");
				}
			}
			else
			{
				log(LogStatus.ERROR,"Not able to click on the "+fieldName+" ", YesNo.Yes);
				result.add("Not able to click on the "+fieldName+" ");
			}

		}
		else
		{
			log(LogStatus.ERROR,"Not able to pass the "+fieldName+" in the searchbox", YesNo.Yes);
			result.add("Not able to pass the "+fieldName+" in the searchbox");
		}

		return result;

	}


}
