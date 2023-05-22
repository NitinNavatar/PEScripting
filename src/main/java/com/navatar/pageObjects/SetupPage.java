package com.navatar.pageObjects;

import static com.navatar.generic.CommonLib.FindElement;
import static com.navatar.generic.CommonLib.FindElements;
import static com.navatar.generic.CommonLib.ThreadSleep;
import static com.navatar.generic.CommonLib.isDisplayed;
import static com.navatar.generic.CommonLib.log;
import static com.navatar.generic.CommonLib.scrollDownThroughWebelement;

import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.navatar.generic.EnumConstants.AddProspectsTab;
import com.navatar.generic.EnumConstants.EditViewMode;
import com.navatar.generic.EnumConstants.NavatarSetupSideMenuTab;
import com.navatar.generic.EnumConstants.ObjectFeatureName;
import com.navatar.generic.EnumConstants.TopOrBottom;
import com.navatar.generic.EnumConstants.YesNo;
import com.navatar.generic.EnumConstants.action;
import com.navatar.generic.EnumConstants.object;
import com.relevantcodes.extentreports.LogStatus;

public class SetupPage extends BasePageBusinessLayer {

	public SetupPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[contains(@placeholder,'Quick Find') or @class='filter-box input']")
	private WebElement quickSearch;

	public WebElement getQucikSearchInSetupPage(int timeOut) {

		return isDisplayed(driver, quickSearch, "visibility", 30, "quick search text box in ");
	}

	@FindBy(xpath = "//ul[contains(@class,'tabBarItems slds-grid')]//span[contains(@class,'title slds-truncate')][contains(text(),'Object Manager')]")
	private WebElement objectManager_Lighting;

	/**
	 * @return the objectManage_Lighting
	 */
	public WebElement getObjectManager_Lighting(int timeOut) {
		return isDisplayed(driver, objectManager_Lighting, "Visibility", timeOut, "object manage");
	}

	@FindBy(xpath = "//input[@id='globalQuickfind']")
	private WebElement quickSearchInObjectManager_Lighting;

	/**
	 * @return the quickSearchInObjectManager_Lighting
	 */
	public WebElement getQuickSearchInObjectManager_Lighting(int timeOut) {
		return isDisplayed(driver, quickSearchInObjectManager_Lighting, "Visibility", timeOut,
				"quick search in object manager in lighting");
	}

	public List<WebElement> getFieldsInPageLayoutList() {

		return FindElements(driver, "//div[@id='fieldTrough']//div[contains(@class,'item')]", "page layout field item");
	}

	public List<WebElement> getFieldsListInCompactLayout() {

		return FindElements(driver, "//*[@class='compactLayoutFields']/li", "Compact layout field item");
	}

	@FindBy(xpath = "//*[text()='Organization Name']/following-sibling::*[1]")
	private WebElement orgCompanyName;

	public WebElement getOrgCompanyName(int timeOut) {
		return isDisplayed(driver, orgCompanyName, "Visibility", timeOut, "org Company Name");
	}

	@FindBy(xpath = "//input[@id='quickfind']")
	private WebElement quickFindInPageLayout_Lighting;

	/**
	 * @return the quickSearchInObjectManager_Lighting
	 */
	public WebElement getQuickFindInPageLayout_Lighting(int timeOut) {
		return isDisplayed(driver, quickFindInPageLayout_Lighting, "Visibility", timeOut,
				"quick find in page layout in lighting");
	}

	@FindBy(xpath = "//iframe[contains(@title,'Salesforce - Enterprise Edition')]")
	private WebElement editPageLayoutFrame_Lighting;

	/**
	 * @return the editPageLayoutFrame_Lighting
	 */
	public WebElement getEditPageLayoutFrame_Lighting(int timeOut) {
		return isDisplayed(driver, editPageLayoutFrame_Lighting, "Visibility", timeOut,
				"edit page layout frame in lighting");
	}
	
	@FindBy(xpath = "//input[@name='sectionName']")
	private WebElement sectionNameInput;

	public WebElement getSectionNameInput(int timeOut) {
		return isDisplayed(driver, sectionNameInput, "Visibility", timeOut,
				"Section Name Input");
	}

	@FindBy(xpath = "//input[@name='section_show_detail']")
	private WebElement detailPageCheckbox;

	public WebElement getDetailPageCheckbox(int timeOut) {
		return isDisplayed(driver, detailPageCheckbox, "Visibility", timeOut,
				"Detail Page Checkbox");
	}
	
	@FindBy(xpath = "//input[@name='section_show_edit']")
	private WebElement editPageCheckbox;

	public WebElement getEditPageCheckbox(int timeOut) {
		return isDisplayed(driver, editPageCheckbox, "Visibility", timeOut,
				"Edit Page Checkbox");
	}
	
	@FindBy(xpath = "//Label[text()='2-Column']/../..//input")
	private WebElement twoColumnRadioBtn;

	public WebElement getTwoColumnRadioBtn(int timeOut) {
		return isDisplayed(driver, twoColumnRadioBtn, "Visibility", timeOut,
				"Two Column Radio Button");
	}
	
	@FindBy(xpath = "//label[text()='Left-Right']/../..//input")
	private WebElement leftRightRadioBtn;

	public WebElement getLeftRightRadioBtn(int timeOut) {
		return isDisplayed(driver, leftRightRadioBtn, "Visibility", timeOut,
				"Left Right Radio Button");
	}
	
	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtn;

	public WebElement getOkBtn(int timeOut) {
		return isDisplayed(driver, okBtn, "Visibility", timeOut,
				"OK Button");
	}
	
	@FindBy(xpath = "//iframe[contains(@title,'Edit Page Layout: Institution ~ Salesforce - Enterprise Edition')]")
	private WebElement editPageLayoutFrame;

	/**
	 * @return the editPageLayoutFrame_Lighting
	 */
	public WebElement getEditPageLayoutFrame(int timeOut) {
		return isDisplayed(driver, editPageLayoutFrame, "Visibility", timeOut,
				"edit page layout frame in lighting");
	}
	
	@FindBy(xpath = "//table[@id='saveBtn']")
	private WebElement SaveBtn;

	/**
	 * @return the editPageLayoutFrame_Lighting
	 */
	public WebElement getSaveBtn(int timeOut) {
		return isDisplayed(driver, SaveBtn, "Visibility", timeOut,
				"Save Btn");
	}
	
	
	@FindBy(xpath = "//em[@class='x-btn-split']//button[@type='button'][contains(text(),'Save')]")
	private WebElement pageLayoutSaveBtn;

	/**
	 * @return the pageLayoutSaveBtn
	 */
	public WebElement getPageLayoutSaveBtn(object obj, int timeOut) {
		String xpath = "";
		WebElement ele = null;
		if (obj == object.Global_Actions) {
			xpath = "//table[@id='saveBtn']";
			ele = FindElement(driver, xpath, "save", action.BOOLEAN, 10);
			return isDisplayed(driver, ele, "Visibility", timeOut, "pagelayout save button");
		} else
			return isDisplayed(driver, pageLayoutSaveBtn, "Visibility", timeOut, "pagelayout save button");
	}

	@FindBy(xpath = "//iframe[contains(@title,'Salesforce - Enterprise Edition')]")
	private WebElement setupPageIframe;

	/**
	 * @return the userIframe
	 */
	public WebElement getSetUpPageIframe(int timeOut) {
		ThreadSleep(5000);
		return isDisplayed(driver, setupPageIframe, "Visibility", timeOut, "active users iframe");
	}

	@FindBy(xpath = "//td[contains(@id,'ButtonRow')]//input[@name='save']")
	private WebElement createUserSaveBtn_Lighting;

	/**
	 * @return the createUserSaveBtn
	 */
	public WebElement getCreateUserSaveBtn_Lighting(int timeOut) {
		return isDisplayed(driver, createUserSaveBtn_Lighting, "Visibility", timeOut, " save button in lighting");
	}
	
	@FindBy(xpath = "//h3[text()='Custom Attributes']/ancestor::tr//input[@name='new']")
	private WebElement customAttributeNewButton;

	/**
	 * @return the createUserSaveBtn
	 */
	public WebElement getcustomAttributeNewButton(int timeOut) {
		return isDisplayed(driver, customAttributeNewButton, "Visibility", timeOut, "customAttributeNewButton");
	}
	
	@FindBy(xpath = "//input[@id='key']")
	private WebElement attributeKeyInput;

	/**
	 * @return the createUserSaveBtn
	 */
	public WebElement getAttributeKeyInput(int timeOut) {
		return isDisplayed(driver, attributeKeyInput, "Visibility", timeOut, "attributeKeyInput");
	}

	@FindBy(xpath = "//textarea[@id='value']")
	private WebElement attributeValueInput;

	/**
	 * @return the createUserSaveBtn
	 */
	public WebElement getAttributeValueInput(int timeOut) {
		return isDisplayed(driver, attributeValueInput, "Visibility", timeOut, "attributeValueInput");
	}

	@FindBy(xpath = "//h3[text()='Installed Packages']/../../../../../..//*[contains(text(),'Navatar PE ')]/../..//td[4]")
	private WebElement installedPackageVersionNo;

	public WebElement getInstalledPackageVersion() {

		return isDisplayed(driver, installedPackageVersionNo, "Visibility", 20, "install paa=ckage verison");

	}

	@FindBy(id = "ImportedPackage_font")
	private WebElement installedPackageLink_Classic;

	/**
	 * @return the installedpackageLink
	 */
	@FindBy(xpath = "//a[contains(@href,'/setup/ImportedPackage/home')]")
	private WebElement installedPackageLink_Lighting;

	public WebElement getInstalledPackageLink(int timeOut) {
		return isDisplayed(driver, installedPackageLink_Lighting, "Visibility", timeOut, "Installed package in ");
	}

	@FindBy(xpath = "//iframe[@id='available']")
	private WebElement installedPackageFrame;

	@FindBy(xpath = "//iframe[contains(@title,'Add Users:')]")
	private WebElement installedPackageParentFrame_Lighting;

	/**
	 * @return the installedPackageFrame_Lighting
	 */
	public WebElement getInstalledPackageParentFrame_Lighting(int timeOut) {
		return isDisplayed(driver, installedPackageParentFrame_Lighting, "Visibility", timeOut,
				" Installed Package Parent Frame in Lightning");
	}

	/**
	 * @return the installedPackageFrame
	 */
	public WebElement getInstalledPackageFrame(int timeOut) {
		return isDisplayed(driver, installedPackageFrame, "Visibility", timeOut,
				"Add Users frame in installed package.");
	}

	@FindBy(xpath = "//label[text()='Quick Find']/following-sibling::input")
	private WebElement quickFindSearch;

	public WebElement getquickFindSearch(int timeOut) {
		return isDisplayed(driver, quickFindSearch, "Visibility", timeOut, "quickFindSearch");
	}
	
	@FindBy(xpath = "//h3[text()='Salesforce Mobile and Lightning Experience Actions']/..//..//..//div[@id='__PLATFORM_ACTION']//div[@class='btn customButton'][1]")
	private WebElement quickFindSearch1;

	public WebElement getquickFindSearch1(int timeOut) {
		return isDisplayed(driver, quickFindSearch1, "Visibility", timeOut, "quickFindSearch1");
	}
	
	@FindBy(xpath = "//div[text()='Mobile & Lightning Actions']")
	private WebElement MobileLightning;

	public WebElement getMobileLightning(int timeOut) {
		return isDisplayed(driver, MobileLightning, "Visibility", timeOut, "MobileLightning");
	}

	@FindBy(xpath = "//button[@title='Custom Field']")
	private WebElement customFieldNewButton;

	public WebElement getCustomFieldNewButton(int timeOut) {
		return isDisplayed(driver, customFieldNewButton, "Visibility", timeOut, "custom field new button");
	}

	public WebElement getNewCustomFieldFrame(String objectName, int timeOut) {
		if (objectName.toString().equalsIgnoreCase(object.Deal.toString())) {
			objectName = "Pipeline";
		}
		String xpath = "//iframe[contains(@title,'" + objectName.replace("_", " ") + "')]";
		WebElement ele = FindElement(driver, xpath, objectName + " new object frame xpath", action.SCROLLANDBOOLEAN,
				timeOut);
		return isDisplayed(driver, ele, "visibility", timeOut, objectName + " new object frame xpath");
	}

	public WebElement getNewCustomFieldDataTypeOrFormulaReturnType(String dataType, int timeOut) {
		String xpath = "//label[text()='" + dataType + "']/preceding-sibling::input";
		WebElement ele = FindElement(driver, xpath, dataType + " data type xpath", action.SCROLLANDBOOLEAN, timeOut);
		return isDisplayed(driver, ele, "visibility", timeOut, dataType + " data type xpath");
	}
	
	public WebElement getObjectFieldLink(String fieldName, int timeOut) {
		String xpath = "//table[@data-aura-class='uiVirtualDataGrid--default uiVirtualDataGrid']//span[text()='"+fieldName+"']/ancestor::a";
		WebElement ele = FindElement(driver, xpath, fieldName + " field name xpath", action.SCROLLANDBOOLEAN, timeOut);
		return isDisplayed(driver, ele, "visibility", timeOut,  " field name xpath");
	}

	@FindBy(xpath = "//div[@class='pbTopButtons']//input[@name='goNext']")
	private WebElement customFieldNextBtn;

	public WebElement getCustomFieldNextBtn(int timeOut) {
		return isDisplayed(driver, customFieldNextBtn, "Visibility", timeOut, "custom field next button");
	}

	@FindBy(xpath = "//input[@id='pageNumField']")
	private WebElement currentPageNo;

	public WebElement getCurrentPageInput(int timeOut) {
		return isDisplayed(driver, currentPageNo, "Visibility", timeOut, "current selected page input box");
	}

	@FindBy(xpath = "//div[@id='totalPages']")
	private WebElement totalPageNo;

	public WebElement getTotalPagesCount(int timeOut) {
		return isDisplayed(driver, totalPageNo, "Visibility", timeOut, "total no of page");
	}

	/* @FindBy(xpath = "//table[@id='nextBtn']") */
	@FindBy(xpath = "//button[text()='Next']")
	private WebElement overrideSetupFieldNextBtn;

	public WebElement getOverrideSetupFieldNextBtn(int timeOut) {
		return isDisplayed(driver, overrideSetupFieldNextBtn, "Visibility", timeOut, "override field next button");
	}

	@FindBy(xpath = "//input[@id='quickfind']")
	private WebElement quickFindSearchBox;

	public WebElement getQuickFindSearchBox(String environment, String mode, int timeOut) {
		return isDisplayed(driver, quickFindSearchBox, "Visibility", timeOut, "quick Find Search Box " + mode);
	}

	@FindBy(xpath = "//input[@id='MasterLabel']")
	private WebElement fieldLabelTextBox;
	@FindBy(xpath = "//*[text()='Label']/../following-sibling::td//input")
	private WebElement fieldLabelTextBox1;

	public WebElement getFieldLabelTextBox1(int timeOut) {
		return isDisplayed(driver, fieldLabelTextBox1, "Visibility", timeOut, "field label text box");
	}

	@FindBy(xpath = "//*[text()='Record Type Label']/../following-sibling::td//input")
	private WebElement recordTypeLabelTextBox1;

	@FindBy(xpath = "//*[text()='Record Type Name']/../following-sibling::td//input")
	private WebElement recordTypeNameTextBox1;

	public WebElement getrecordTypeNameTextBox1(int timeOut) {
		return isDisplayed(driver, recordTypeNameTextBox1, "Visibility", timeOut, "field label text box");
	}

	@FindBy(xpath = "//*[text()='API Name']/following-sibling::td//input")
	private WebElement apiLabelTextBox;

	public WebElement getapiLabelTextBox(int timeOut) {
		return isDisplayed(driver, apiLabelTextBox, "Visibility", timeOut, "field label text box");
	}

	public WebElement getFieldLabelTextBox(int timeOut) {
		return isDisplayed(driver, fieldLabelTextBox, "Visibility", timeOut, "field label text box");
	}

	@FindBy(id = "DomainEnumOrId")
	private WebElement relatedToDropDownList;

	public WebElement getRelatedToDropDownList(int timeOut) {
		return isDisplayed(driver, relatedToDropDownList, "Visibility", timeOut, "relatedToDropDownList");
	}

	@FindBy(xpath = "//div[@class='pbTopButtons']//input[@name='save']")
	private WebElement customFieldSaveBtn;

	public WebElement getCustomFieldSaveBtn(int timeOut) {
		return isDisplayed(driver, customFieldSaveBtn, "Visibility", timeOut, "custom field save button");
	}
	
	@FindBy(xpath = "//button[@title='Save']")
	private WebElement inputSaveBtn;

	public WebElement getinputSaveBtn(int timeOut) {
		return isDisplayed(driver, inputSaveBtn, "Visibility", timeOut, "input Save Btn");
	}
	
	@FindBy(xpath = "//h2[text()='Customize the Help Menu']//ancestor::li//span[@class='slds-checkbox_faux']")
	private WebElement helpmenutogglebutton;

	public WebElement gethelpmenutogglebutton(int timeOut) {
		return isDisplayed(driver, helpmenutogglebutton, "Visibility", timeOut, "help menu toggle button");
	}

	public WebElement getObjectFeatureNewButton(ObjectFeatureName objectFeatureName, int timeOut) {
		String xpath = "//button[@title='" + objectFeatureName + "']";
		WebElement ele = FindElement(driver, xpath, objectFeatureName + " new button xpath", action.SCROLLANDBOOLEAN,
				timeOut);
		return isDisplayed(driver, ele, "visibility", timeOut, objectFeatureName + " new button xpath");
	}

	@FindBy(xpath = "//input[@id='MasterLabel']")
	private WebElement fieldSetLabelTextBox;

	public WebElement getFieldSetLabelTextBox(int timeOut) {
		return isDisplayed(driver, fieldSetLabelTextBox, "visibility", timeOut, "field set label name");
	}

	@FindBy(xpath = "//textarea[@id='Description']")
	private WebElement fieldSetWhereIsThisUsedTextArea;

	public WebElement getFieldSetWhereIsThisUsedTextArea(int timeOut) {
		return isDisplayed(driver, fieldSetWhereIsThisUsedTextArea, "Visibility", timeOut,
				"field Set Where Is This Used TextArea");
	}

	@FindBy(xpath = "//td[@id='topButtonRow']//input[@title='Save']")
	private WebElement saveButton;

	public WebElement getSaveButton(int timeOut) {
		return isDisplayed(driver, saveButton, "visibility", timeOut, "save button");
	}

	@FindBy(xpath = "//div[@id='defaultView']/div")
	private WebElement FieldSetdefaultViewDragAndDropTextLabel;

	public WebElement getFieldSetdefaultViewDragAndDropTextLabel(int timeOut) {
		return isDisplayed(driver, FieldSetdefaultViewDragAndDropTextLabel, "Visibility", timeOut,
				"default view drag and drop text label");
	}

	public WebElement getCreatedFieldSetLabelNameText(String fieldSetName, int timeOut) {
		String xpath = "//span[contains(text(),'" + fieldSetName + "')]/..";
		WebElement ele = FindElement(driver, xpath, fieldSetName + " label name text", action.SCROLLANDBOOLEAN,
				timeOut);
		return isDisplayed(driver, ele, "visibility", timeOut, fieldSetName + " label name text");
	}

	public List<WebElement> getDefaultFieldSetLabelsList() {
		return FindElements(driver, "//div[@id='defaultView']/div//table//td[2]/div", "default field set label text");
	}

	@FindBy(xpath = "//iframe[contains(@title,'Field Set: New Field Set')]")
	private WebElement fieldSetComponentFrame;

	public WebElement getFieldSetComponentFrame(int timeOut) {
		return isDisplayed(driver, fieldSetComponentFrame, "Visibility", timeOut, "field set component frame");
	}

	@FindBy(xpath = "//iframe[contains(@title,'Salesforce - Enterprise Edition')]")
	private WebElement fieldAndRelationShipFrame;

	public WebElement getFieldAndRelationShipFrame(int timeOut) {
		return isDisplayed(driver, fieldAndRelationShipFrame, "Visibility", timeOut, "View Field Accessibility Frame");
	}

	public WebElement getObjectEditOrSetFieldSecurityOrViewFieldAccessbilityBtn(String objectButtonLabelName,
			int timeOut) {
		String xpath = "//input[@title='" + objectButtonLabelName + "']";
		WebElement ele = FindElement(driver, xpath, objectButtonLabelName + " button xpath", action.SCROLLANDBOOLEAN,
				timeOut);
		return isDisplayed(driver, ele, "visibility", timeOut, objectButtonLabelName + " button xpath");
	}

	@FindBy(xpath = "//select[@id='zSelect']")
	private WebElement fieldAccessbilityDropDown;

	public WebElement getFieldAccessbilityDropDown(int timeOut) {
		return isDisplayed(driver, fieldAccessbilityDropDown, "Visibility", timeOut, "field accessbility drop down");
	}

	public WebElement getfieldAccessOptionLink(String profileName, int timeOut) {
		String xpath = "//div[contains(@style,'block')]//th[text()='" + profileName + "']/following-sibling::td[1]//a";
		WebElement ele = FindElement(driver, xpath, profileName + " link xpath", action.SCROLLANDBOOLEAN, timeOut);
		return isDisplayed(driver, ele, "visibility", timeOut, profileName + " link xpath");
	}

	@FindBy(xpath = "//input[@id='p11']")
	private WebElement fieldLevelSecurityVisibleCheckBox;

	public WebElement getFieldLevelSecurityVisibleCheckBox(int timeOut) {
		return isDisplayed(driver, fieldLevelSecurityVisibleCheckBox, "Visibility", timeOut,
				"field Level Security Visible CheckBox");
	}

	@FindBy(xpath = "//td[@class='pbButtonb']//input[@title='Save']")
	private WebElement viewAccessbilityDropDownSaveButton;

	public WebElement getViewAccessbilityDropDownSaveButton(int timeOut) {
		return isDisplayed(driver, viewAccessbilityDropDownSaveButton, "Visibility", timeOut,
				"view Accessbility DropDown Save Button");
	}

	public List<WebElement> getDraggedObjectListInCreateFieldSet() {
		return FindElements(driver, "//div[@id='defaultView']/div", "dragged object list in created field set");
	}

	@FindBy(xpath = "//div[@class='pbBody canvasDrop']")
	private WebElement pageLayoutDropLocation;

	public WebElement getPageLayoutDropLocation(int timeOut) {
		return isDisplayed(driver, pageLayoutDropLocation, "Visibility", timeOut, "page layout drop location");
	}

	public WebElement getDraggedFieldsLabelAndValueXpath(String label, int timeOut) {
		String xpath = "//div[@class='itemLabel']/span[text()='" + label
				+ "']/../following-sibling::div[text()='www.salesforce.com']";
		WebElement ele = FindElement(driver, xpath, label + " xpath", action.SCROLLANDBOOLEAN, timeOut);
		return isDisplayed(driver, ele, "visibility", timeOut, label + " xpath");
	}

	@FindBy(xpath = "//div[@data-aura-class='uiScroller']")
	private WebElement appMangerScroll;

	public WebElement getAppMangerScroll(int timeOut) {
		return isDisplayed(driver, appMangerScroll, "Visibility", timeOut, "ap pManger Scroll");
	}

	@FindBy(xpath = "//*[@title='Record Type']")
	private WebElement recordTypeNewButton;

	public WebElement getRecordTypeNewButton(int timeOut) {
		return isDisplayed(driver, recordTypeNewButton, "Visibility", timeOut, "Record Type New Button");
	}

	@FindBy(xpath = "//input[@id='selectAllProfiles']")
	private WebElement makeAvailableCheckBox;

	public WebElement getMakeAvailableCheckBox(int timeOut) {
		return isDisplayed(driver, makeAvailableCheckBox, "Visibility", timeOut, "make Available CheckBox");
	}

	@FindBy(xpath = "//div[@class='pbBottomButtons']//input[@name='goNext']")
	private WebElement customFieldNextBtn2;

	public WebElement getCustomFieldNextBtn2(int timeOut) {
		return isDisplayed(driver, customFieldNextBtn2, "Visibility", timeOut, " next button");
	}

	@FindBy(xpath = "//input[@id='selectAllMakeDefaults']")
	private WebElement makeDefaultCheckBox;

	public WebElement getMakeDefaultCheckBoxCheckBox(int timeOut) {
		return isDisplayed(driver, makeDefaultCheckBox, "Visibility", timeOut, "make Default CheckBox");
	}

	@FindBy(xpath = "//input[@title='New Custom Object Tabs']")
	private WebElement customObjectTabNewBtn;

	public WebElement getCustomObjectTabNewBtn(int timeOut) {
		return isDisplayed(driver, customObjectTabNewBtn, "Visibility", timeOut, "custom Object Tab NewBtn");
	}

	@FindBy(xpath = "//select[@id='p1']")
	private WebElement objectDropDown;

	public WebElement getObjectDropDown(int timeOut) {
		return isDisplayed(driver, objectDropDown, "Visibility", timeOut, "Object drop down");
	}

	@FindBy(xpath = "//img[@title='Lookup (New Window)']")
	private WebElement tabObjectLookUpIcon;

	/**
	 * @return the tabObjectLookUpIcon
	 */
	public WebElement getTabObjectLookUpIcon(int timeOut) {
		return isDisplayed(driver, tabObjectLookUpIcon, "Visibility", timeOut, "tab Object Look Up Icon");
	}

	@FindBy(xpath = "//div[@aria-labelledby='appImageLabel']//span")
	private WebElement imgName;

	/**
	 * @return the tabObjectLookUpIcon
	 */
	public WebElement getImgName(int timeOut) {
		return isDisplayed(driver, imgName, "Visibility", timeOut, "Image Name");
	}

	@FindBy(xpath = "//input[@type='file']")
	private WebElement uploadPhotoButton;

	public WebElement getuploadPhotoButton(String projectName, int timeOut) {
		return isDisplayed(driver, uploadPhotoButton, "Visibility", timeOut, "upload photo button");

	}

	@FindBy(xpath = "//button[text()='Clear']")
	private WebElement imgClearButton;

	public WebElement getImgClearButton(String projectName, int timeOut) {
		return isDisplayed(driver, imgClearButton, "Visibility", timeOut, "Img Clear button");

	}

	@FindBy(xpath = "//*[text()='New Flow']")
	private WebElement newFlowButton;

	public WebElement getNewFlowButton(String projectName, int timeOut) {
		return isDisplayed(driver, newFlowButton, "Visibility", timeOut, "New Flow button");

	}

	@FindBy(xpath = "//*[text()='Screen Flow']")
	private WebElement screenFlow;

	public WebElement getScreenFlow(String projectName, int timeOut) {
		return isDisplayed(driver, screenFlow, "Visibility", timeOut, "Screen Flow button");

	}

	@FindBy(xpath = "//*[text()='Screen Flow']")
	private WebElement freeForm;

	public WebElement getfreeForm(String projectName, int timeOut) {
		return isDisplayed(driver, freeForm, "Visibility", timeOut, "Free Form");

	}

	@FindBy(xpath = "//*[text()='Industry']/../following-sibling::*//select")
	private WebElement industryDropdownList;

	public WebElement getIndustryDropdownList(int timeOut) {
		scrollDownThroughWebelement(driver, industryDropdownList, "Industry DropDown List");
		return isDisplayed(driver, industryDropdownList, "Visibility", timeOut, "Industry DropDown List");

	}

	public WebElement getIndustryDropdownList(String dropDownLabel, String dropDownValue, int timeOut) {
		ThreadSleep(1000);
		try {
			if (dropDownValue.contains("None") || dropDownValue.contains("none")) {

				String xpath = "//*[text()='" + dropDownLabel + "']/following-sibling::*";
				WebElement ele = FindElement(driver, xpath, dropDownLabel + " " + dropDownValue,
						action.SCROLLANDBOOLEAN, timeOut);
				System.err.println("getIndustryDropdownList " + ele.getText().trim());
				if (ele.getText().trim().isEmpty() || ele.getText().trim().equals("")) {
					System.err.println("verified getIndustryDropdownList " + ele.getText().trim());
					return ele;
				} else {
					log(LogStatus.ERROR, "Value not verified " + dropDownValue, YesNo.Yes);
					sa.assertTrue(false, "Value not verified " + dropDownValue);
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String xpath = "//*[text()='" + dropDownLabel + "']/following-sibling::*[text()='" + dropDownValue + "']";
		WebElement ele = FindElement(driver, xpath, dropDownLabel + " " + dropDownValue, action.SCROLLANDBOOLEAN,
				timeOut);
		return isDisplayed(driver, ele, "Visibility", timeOut, dropDownLabel + " " + dropDownValue);

	}

	public WebElement getProfileMakeAvailableCheckbox(String profile, int timeOut) {
		String xpath = "//th[text()='" + profile + "']/..//input[@title='Make Available']";
		WebElement ele = FindElement(driver, xpath, profile + ":checkbox", action.SCROLLANDBOOLEAN, timeOut);
		return isDisplayed(driver, ele, "Visibility", timeOut, "");

	}

	public WebElement getRegionDropdownList(String dropDownLabel, String dropDownValue, int timeOut) {
		ThreadSleep(1000);
		try {
			if (dropDownValue.contains("None") || dropDownValue.contains("none")) {

				String xpath = "//*[text()='" + dropDownLabel + "']/following-sibling::*";
				WebElement ele = FindElement(driver, xpath, dropDownLabel + " " + dropDownValue,
						action.SCROLLANDBOOLEAN, timeOut);
				System.err.println("getRegionDropdownList " + ele.getText().trim());
				if (ele.getText().trim().isEmpty() || ele.getText().trim().equals("")) {
					System.err.println("verified getRegionDropdownList " + ele.getText().trim());
					return ele;
				} else {
					log(LogStatus.ERROR, "Value not verified " + dropDownValue, YesNo.Yes);
					sa.assertTrue(false, "Value not verified " + dropDownValue);
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String xpath = "//*[text()='" + dropDownLabel + "']/following-sibling::*[text()='" + dropDownValue + "']";
		WebElement ele = FindElement(driver, xpath, dropDownLabel + " " + dropDownValue, action.SCROLLANDBOOLEAN,
				timeOut);
		return isDisplayed(driver, ele, "Visibility", timeOut, dropDownLabel + " " + dropDownValue);

	}

	@FindBy(xpath = "//*[text()='Region']/../following-sibling::*//select")
	private WebElement regionDropdownList;

	public WebElement getRegionDropdownList(int timeOut) {
		scrollDownThroughWebelement(driver, regionDropdownList, "Region DropDown List");
		return isDisplayed(driver, regionDropdownList, "Visibility", timeOut, "Region DropDown List");

	}

	@FindBy(xpath = "//*[text()='Time Zone']/../following-sibling::*//select")
	private WebElement timezoneDropdownList;

	public WebElement gettimezoneDropdownList(int timeOut) {
		scrollDownThroughWebelement(driver, timezoneDropdownList, "time zone Dropdown List");
		return isDisplayed(driver, timezoneDropdownList, "Visibility", timeOut, "time zone Dropdown List");

	}

	@FindBy(xpath = "//*[text()='Locale']/../following-sibling::*//select")
	private WebElement localeDropdownList;

	public WebElement getLocaleDropdownList(int timeOut) {
		scrollDownThroughWebelement(driver, localeDropdownList, "time zone Dropdown List");
		return isDisplayed(driver, localeDropdownList, "Visibility", timeOut, "time zone Dropdown List");

	}

	@FindBy(xpath = "//input[@title='New Action']")
	private WebElement newActionBtn;

	public WebElement getNewActionBtnNewBtn(int timeOut) {
		return isDisplayed(driver, newActionBtn, "Visibility", timeOut, "New ACtion Button");
	}

	@FindBy(xpath = "//h3[text()='Predefined Field Values']/../following-sibling::td//input")
	private WebElement predefinedFieldValuesNewButton;

	public WebElement getpredefinedFieldValuesNewButtonn(int timeOut) {
		return isDisplayed(driver, predefinedFieldValuesNewButton, "Visibility", timeOut,
				"Predefined Field Values New Button");
	}

	@FindBy(xpath = "//select[@id='ColumnEnumOrId']")
	private WebElement selectFieldName;

	public WebElement getSelectFieldName(int timeOut) {
		return isDisplayed(driver, selectFieldName, "Visibility", timeOut, "Select Field Name");
	}

	@FindBy(xpath = "//textarea[@id='DefaultValueFormula']")
	private WebElement formulaValueTextArea;

	public WebElement getFormulaValueTextArea(int timeOut) {
		return isDisplayed(driver, formulaValueTextArea, "Visibility", timeOut, "formula Value TextArea");
	}

	@FindBy(xpath = "//*[@title='Page Layout']")
	private WebElement pageLayoutNewButton;

	public WebElement getPageLayoutNewButton(int timeOut) {
		return isDisplayed(driver, pageLayoutNewButton, "Visibility", timeOut, "Page Layout New Button");
	}

	@FindBy(xpath = "//select[@id='p2']")
	private WebElement selectExistingPageLayout;

	public WebElement getSelectExistingPageLayout(int timeOut) {
		return isDisplayed(driver, selectExistingPageLayout, "Visibility", timeOut, "Select Existing Page Layout");
	}

	@FindBy(xpath = "//select[@id='p13']")
	private WebElement applyOneLayoutToAllProfiles;

	public WebElement getApplyOneLayoutToAllProfiles(int timeOut) {
		return isDisplayed(driver, applyOneLayoutToAllProfiles, "Visibility", timeOut, "Select Page Layout");
	}

	@FindBy(xpath = "//div[@title='Visualforce Pages']//a")
	private WebElement visualForcePagesLink;

	public WebElement getvisualForcePagesLink(int timeOut) {
		return isDisplayed(driver, visualForcePagesLink, "Visibility", timeOut, "Select Page Layout");
	}

	@FindBy(xpath = "//h3[text()='Values']/../following-sibling::td//input[@name='new']")
	private WebElement valuesNewButton;

	public WebElement getValuesNewButton(int timeOut) {
		return isDisplayed(driver, valuesNewButton, "Visibility", timeOut, "Values New Button");
	}

	@FindBy(xpath = "//*[text()='Add Utility Item']")
	private WebElement addUtilityItem;

	public WebElement getAddUtilityItem(int timeOut) {
		return isDisplayed(driver, addUtilityItem, "Visibility", timeOut, "Add Utility Item");
	}

	@FindBy(xpath = "//*[@Title='Research']")
	private WebElement researchItem;

	public WebElement getResearchItem(int timeOut) {
		return isDisplayed(driver, researchItem, "Visibility", timeOut, "Research Item");
	}

	@FindBy(xpath = "//div[@class='paletteSearch']//input")
	private WebElement searchIconOnUtilityItem;

	public WebElement getSearchIconOnUtilityItem(int timeOut) {
		return isDisplayed(driver, searchIconOnUtilityItem, "Visibility", timeOut, "Search Icon on Add Utility Item");
	}

	@FindBy(xpath = "//div[@class='buttonsDiv']/button//span[text()='Move this utility down the list.']/..")
	private WebElement moveThisUtilityDownTheList;

	public WebElement getMoveThisUtilityDownTheList(int timeOut) {
		String xpath = "//div[@class='buttonsDiv']/button//span[text()='Move this utility down the list.']/..";
		List<WebElement> eleList = FindElements(driver, xpath, "Move this utility down the list.");
		WebElement ele = null;
		for (WebElement webElement : eleList) {
			webElement = isDisplayed(driver, webElement, "Visibility", 2, "Move this utility down the list.");
			if (webElement != null) {
				return webElement;
			} else {

			}
		}
		return ele;

	}

	public WebElement getRemoveUtilityTheList(int timeOut) {
		String xpath = "//div[@class='buttonsDiv']/button[3]";
		List<WebElement> eleList = FindElements(driver, xpath, "Remove");
		WebElement ele = null;
		for (WebElement webElement : eleList) {
			webElement = isDisplayed(driver, webElement, "Visibility", 2, "Remove");
			if (webElement != null) {
				return webElement;
			} else {

			}
		}
		return ele;

	}

	@FindBy(xpath = "//label[text()='Selected Record Types']/..//following-sibling::select")
	private WebElement SelectedRecordType;

	public WebElement getSelectedRecordType(int timeOut) {
		return isDisplayed(driver, SelectedRecordType, "Visibility", timeOut, "SelectedRecordType");
	}

	@FindBy(xpath = "//label[text()='Available Record Types']/..//following-sibling::select")
	private WebElement availableRecordType;

	public WebElement getavailableRecordType(int timeOut) {
		return isDisplayed(driver, availableRecordType, "Visibility", timeOut, "availableRecordType");
	}

	@FindBy(xpath = "//select[@id='pageLayoutSelector']")
	private WebElement pageLayoutSelector;

	public WebElement getpageLayoutSelector(int timeOut) {
		return isDisplayed(driver, pageLayoutSelector, "Visibility", timeOut, "pageLayoutSelector");
	}

	@FindBy(xpath = "//td//input[contains(@title,'Edit')]")
	private WebElement editButtonOfCreatedFieldAndRelationShip;

	public WebElement getEditButtonOfCreatedFieldAndRelationShip(int timeOut) {
		return isDisplayed(driver, editButtonOfCreatedFieldAndRelationShip, "Visibility", timeOut,
				"editButtonOfCreatedFieldAndRelationShip");
	}

	@FindBy(xpath = "//input[@value=' Clone ' or  title='Clone']")
	private WebElement cloneButton;

	public WebElement getCloneButton(int timeOut) {
		return isDisplayed(driver, cloneButton, "Visibility", timeOut, "cloneButton");
	}

	@FindBy(xpath = "//input[@id='newProfileName']")
	private WebElement profileNameTextBox;

	public WebElement getProfileNameTextBox(int timeOut) {
		return isDisplayed(driver, profileNameTextBox, "Visibility", timeOut, "profileNameTextBox");
	}

	@FindBy(xpath = "//select[contains(@id,'setupEntSelect')]")
	private WebElement setupComponentDropdown;

	public WebElement getOverrideSetupComponentDropdown(int timeOut) {

		scrollDownThroughWebelement(driver, setupComponentDropdown, "setup component dropdown ");
		return isDisplayed(driver, setupComponentDropdown, "Visibility", timeOut, "setup component dropdown ");

	}

	@FindBy(xpath = "//select[contains(@id,'assocEntSelect')]")
	private WebElement objectDropdown;

	public WebElement getOverrideObjectDropdown(int timeOut) {

		scrollDownThroughWebelement(driver, objectDropdown, "override object dropdown");
		return isDisplayed(driver, objectDropdown, "Visibility", timeOut, "override object dropdown");

	}

	@FindBy(xpath = "//div[@class='pbHeader']//input[@title='Save']")
	private WebElement saveButtonHeader;

	public WebElement getsaveButtonHeader(int timeOut) {
		return isDisplayed(driver, saveButtonHeader, "Visibility", timeOut, "Save Button");
	}

	@FindBy(xpath = "//iframe[contains(@title,'User Edit:')]")
	private WebElement userEditPageIframe;

	public WebElement getuserEditPageIframe(int timeOut) {
		return isDisplayed(driver, userEditPageIframe, "Visibility", timeOut, "user edit page iframe");
	}

	@FindBy(xpath = "//ul[contains(@class,'tabBarItems slds-grid')]//span[contains(@class,'title slds-truncate')][contains(text(),'Home')]")
	private WebElement homeTab;

	public WebElement getHomeTab(int timeOut) {
		return isDisplayed(driver, homeTab, "Visibility", timeOut, "Home tab button");
	}

	@FindBy(xpath = "//div[@class='pbHeader']//input[@title='Save']")
	private WebElement editPageSaveButton;

	public WebElement geteditPageSaveButton(int timeOut) {
		return isDisplayed(driver, editPageSaveButton, "Visibility", timeOut, "Save Button on Edit page");
	}

	@FindBy(xpath = "//h1[text()='All Users']")
	private WebElement allUserHeading;

	public WebElement getallUserHeading(int timeOut) {
		return isDisplayed(driver, allUserHeading, "Visibility", timeOut, "All user heading");
	}

	public WebElement getfieldAccessOptionLinkcell(String profileName, int recordType, int timeOut) {
		String xpath = "//div[contains(@style,'block')]//th[text()='" + profileName + "']/following-sibling::td["
				+ recordType + "]//a";
		WebElement ele = FindElement(driver, xpath, profileName + " link xpath", action.SCROLLANDBOOLEAN, timeOut);
		return isDisplayed(driver, ele, "visibility", timeOut, profileName + " link xpath");
	}

	@FindBy(xpath = "//input[@id='p12']")
	private WebElement pageLayourSecurityVisibleCheckBox;

	public WebElement getpageLayourSecurityVisibleCheckBox(int timeOut) {
		return isDisplayed(driver, pageLayourSecurityVisibleCheckBox, "Visibility", timeOut,
				"Page layout Security Visible CheckBox");
	}

	@FindBy(xpath = "//input[@title='New Field Dependencies']")
	private WebElement fieldDependenciesNewBtn;

	public WebElement getfieldDependenciesNewBtn(int timeOut) {
		return isDisplayed(driver, fieldDependenciesNewBtn, "Visibility", timeOut, "Field dependency new button");
	}

	@FindBy(xpath = "//select[@id='controller']")
	private WebElement controllerDropDown;

	public WebElement getcontrollerDropDown(int timeOut) {
		return isDisplayed(driver, controllerDropDown, "Visibility", timeOut, "controller Drop Down field");
	}

	@FindBy(xpath = "//select[@id='dependent']")
	private WebElement dependentDropDown;

	public WebElement getdependentDropDown(int timeOut) {
		return isDisplayed(driver, dependentDropDown, "Visibility", timeOut, "dependent Drop Down field");
	}

	@FindBy(xpath = "//div[@class='pbBottomButtons']//input[@title='Continue']")
	private WebElement dependencyContinueBtn;

	public WebElement getdependencyContinueBtn(int timeOut) {
		return isDisplayed(driver, dependencyContinueBtn, "Visibility", timeOut, "Dependency continue button");
	}

	@FindBy(xpath = "//tr[@class='last detailRow']//input[@value='Include Values']")
	private WebElement includeValueBtn;

	public WebElement getincludeValueBtn(int timeOut) {
		return isDisplayed(driver, includeValueBtn, "Visibility", timeOut, "Include value button");
	}

	@FindBy(xpath = "//div[@class='pbBottomButtons']//input[@title='Save']")
	private WebElement footerSaveBtn;

	public WebElement getfooterSaveBtn(int timeOut) {
		return isDisplayed(driver, footerSaveBtn, "Visibility", timeOut, "footer save button");
	}

	@FindBy(xpath = "//span[text()='Fields & Relationships']")
	private WebElement fieldandRelationshipHeading;

	public WebElement getfieldandRelationshipHeading(int timeOut) {
		return isDisplayed(driver, fieldandRelationshipHeading, "Visibility", timeOut,
				"Field and relationship heading");
	}

	@FindBy(xpath = "//span[text()='Fields & Relationships']/ancestor::div[@class='slds-page-header']//input[@placeholder='Quick Find']")
	private WebElement fieldandRelationshipQuickSearch;

	public WebElement getfieldandRelationshipQuickSearch(int timeOut) {
		return isDisplayed(driver, fieldandRelationshipQuickSearch, "Visibility", timeOut,
				"Field and relationship Quick Search");
	}

	@FindBy(xpath = "//section[@class='related-list-card']//tbody//td[3]//span[@class='slds-assistive-text' or contains(@class,'assistiveText')]")
	private List<WebElement> companyRecordTypeActivityStatus;

	public List<WebElement> getcompanyRecordTypeActivityStatus() {
		return companyRecordTypeActivityStatus;
	}

	@FindBy(xpath = "//section[@class='related-list-card']//tbody//td[1]//span")
	private WebElement companyRecordTypeName;

	public WebElement getcompanyRecordTypeName(int timeOut) {
		return isDisplayed(driver, companyRecordTypeName, "Visibility", timeOut, "Company record type name");
	}

	@FindBy(xpath = "//section[@class='related-list-card']//tbody//td[1]//span")
	private List<WebElement> companyRecordTypeNamelist;

	public List<WebElement> getcompanyRecordTypeNamelist() {
		return companyRecordTypeNamelist;
	}

	@FindBy(xpath = "//iframe[@title='User Profiles ~ Salesforce - Enterprise Edition']")
	private WebElement userProfileIframe;

	public WebElement getuserProfileIframe(int timeOut) {
		return isDisplayed(driver, userProfileIframe, "Visibility", timeOut, "User Profile Iframe");
	}

	@FindBy(xpath = "//iframe[contains(@title,'Salesforce - Enterprise Edition')]")
	private WebElement profileIframe;

	public WebElement getProfileIframe(int timeOut) {
		return isDisplayed(driver, profileIframe, "Visibility", timeOut, "Profile Iframe");
	}

	@FindBy(xpath = "//table[@class='detailList']//tr[td[text()='Accounts']]//a[text()='Edit']")
	private WebElement recordTypeEditButton;

	public WebElement getRecordTypeEditButton(int timeOut) {
		return isDisplayed(driver, recordTypeEditButton, "Visibility", timeOut, "Record type edit button");
	}

	@FindBy(xpath = "//iframe[contains(@title,'Edit Record Type Settings')]")
	private WebElement editRecordTypeIframe;

	public WebElement geteditRecordTypeIframe(int timeOut) {
		return isDisplayed(driver, editRecordTypeIframe, "Visibility", timeOut, "Record type edit iframe");
	}

	@FindBy(xpath = "//select[@id='p5']//option[@selected='selected']")
	private WebElement defaultRecordType;

	public WebElement getdefaultRecordType(int timeOut) {
		return defaultRecordType;
	}

	@FindBy(xpath = "//iframe[contains(@title,'Salesforce - Enterprise Edition')]")
	private WebElement recordTypeIframe;

	public WebElement getrecordTypeIframe(int timeOut) {
		return isDisplayed(driver, recordTypeIframe, "Visibility", timeOut, "Record type iframes");
	}

	@FindBy(xpath = "//a[@data-list='Record Types']")
	private WebElement recordTypeObjectManager;

	public WebElement getrecordTypeObjectManager(int timeOut) {
		return isDisplayed(driver, recordTypeObjectManager, "Visibility", timeOut, "Record type Object Manager");
	}

	@FindBy(xpath = "//button[text()='Page Layout Assignment']")
	private WebElement pageLayoutAssignment;

	public WebElement getpageLayoutAssignment(int timeOut) {
		return isDisplayed(driver, pageLayoutAssignment, "Visibility", timeOut, "Page Layout Assignment button");
	}

	@FindBy(xpath = "//iframe[contains(@title,'Salesforce - Enterprise Edition')]")
	private WebElement pageLayoutIframe;

	public WebElement getpageLayoutIframe(int timeOut) {
		return isDisplayed(driver, pageLayoutIframe, "Visibility", timeOut, "Page layout Iframe");
	}

	@FindBy(xpath = "//a[text()='Next>']")
	private WebElement nextBtn;

	public WebElement getnextBtn(int timeOut) {
		return isDisplayed(driver, nextBtn, "Visibility", timeOut, "Next button");
	}

	@FindBy(xpath = "//a[text()='<Prev']")
	private WebElement PrevBtn;

	public WebElement getPrevBtn(int timeOut) {
		return isDisplayed(driver, PrevBtn, "Visibility", timeOut, "Prev button");
	}

	@FindBy(xpath = "//button[text()='View Page Assignments']")
	private WebElement viewPageAssignments;

	public WebElement getviewPageAssignments(int timeOut) {
		return isDisplayed(driver, viewPageAssignments, "Visibility", timeOut, "View Page Assignments button");
	}

	public WebElement sectionInPageLayoutButton(String sectionInPageLayout, int timeOut) {
		String xpath = "//div[@id='troughSelector']/ul/li/div[text()='" + sectionInPageLayout + "']";

		try {
			return FindElement(driver, xpath, "sectionInPageLayout", action.SCROLLANDBOOLEAN, timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "sectionInPageLayout", action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	@FindBy(xpath = "//label[text()='Selected Record Types']/../following-sibling::select//option")
	private WebElement selectedRecordTypeOption;

	public WebElement getSelectedRecordTypeOption(int timeOut) {
		return isDisplayed(driver, selectedRecordTypeOption, "Visibility", timeOut, "Selected Record Type Option");
	}

	@FindBy(xpath = "//img[@class='leftArrowIcon']")
	private WebElement leftArrowIcon;

	public WebElement getLeftArrowIcon(int timeOut) {
		return isDisplayed(driver, leftArrowIcon, "Visibility", timeOut, "left arrow icon");
	}

	@FindBy(xpath = "//img[@class='rightArrowIcon']")
	private WebElement rightArrowIcon;

	public WebElement getRightArrowIcon(int timeOut) {
		return isDisplayed(driver, rightArrowIcon, "Visibility", timeOut, "right arrow icon");
	}

	@FindBy(xpath = "//label[text()='Available Record Types']/../following-sibling::select//option[text()='--Master--']")
	private WebElement masterOptionValueFromAvailabelRecord;

	public WebElement getMasterOptionValueFromAvailabelRecord(int timeOut) {
		return isDisplayed(driver, masterOptionValueFromAvailabelRecord, "Visibility", timeOut,
				"Master option value from availabel record");
	}

	@FindBy(xpath = "//label[text()='Selected Record Types']/../following-sibling::select//option[text()='--Master--']")
	private WebElement masterOptionValueFromSelectedRecord;

	public WebElement getMasterOptionValueFromSelectedRecord(int timeOut) {
		return isDisplayed(driver, masterOptionValueFromSelectedRecord, "Visibility", timeOut,
				"Master option value from selected record");
	}

	@FindBy(xpath = "//iframe[contains(@title,'Edit Record Type')]")
	private WebElement IframeEditRecordType;

	public WebElement getIframeEditRecordType(int timeOut) {
		return isDisplayed(driver, IframeEditRecordType, "Visibility", timeOut, "Edit record type page iframe");
	}

	@FindBy(xpath = "//iframe[contains(@title,'Record Type')]")
	private WebElement IframeRecordType;

	public WebElement getIframeRecordType(int timeOut) {
		return isDisplayed(driver, IframeRecordType, "Visibility", timeOut, "record type page iframe");
	}

	@FindBy(xpath = "//button[@title='delete']")
	private WebElement deleteButton;

	public WebElement getdeleteButton(int timeOut) {
		return isDisplayed(driver, deleteButton, "Visibility", timeOut, "Delete buton");
	}

	@FindBy(xpath = "//iframe[contains(@title,'Deletion problems')]")
	private WebElement deleteProblemIframe;

	public WebElement getdeleteProblemIframe(int timeOut) {
		return isDisplayed(driver, deleteProblemIframe, "Visibility", timeOut, "Delete problem iframe");
	}

	@FindBy(xpath = "//iframe[contains(@title,'Delete Record Type')]")
	private WebElement deleteRecordTypeIframe;

	public WebElement getDeleteRecordTypeIframe(int timeOut) {
		return isDisplayed(driver, deleteRecordTypeIframe, "Visibility", timeOut, "Delete record type iframe");
	}

	@FindBy(xpath = "//input[@title='Done']")
	private WebElement doneDeleteRecordTypeBtn;

	public WebElement getDoneDeleteRecordTypeBtn(int timeOut) {
		return isDisplayed(driver, doneDeleteRecordTypeBtn, "Visibility", timeOut, "Done delete record type button");
	}

	@FindBy(xpath = "//a[@class='forceActionLink']/div[text()='New']")
	private WebElement newButton;

	public WebElement getNewButton(int timeOut) {
		return isDisplayed(driver, newButton, "Visibility", timeOut, "New Button");
	}

	@FindBy(xpath = "//div[@class='errorMsg']")
	private WebElement errorMsgRecordType;

	public WebElement errorMsgRecordType(int timeOut) {
		return isDisplayed(driver, errorMsgRecordType, "Visibility", timeOut, "errorMsgRecordType");
	}

	@FindBy(xpath = "//select[@id='p5']")
	private WebElement defaultRecord;

	public WebElement editButtonInRenameTabAndLabels(String tabName, int timeOut) {
		String xpath = "//th[text()='" + tabName + "']//preceding-sibling::td[@class='actionColumn']//a[text()='Edit']";

		try {
			return FindElement(driver, xpath, tabName, action.SCROLLANDBOOLEAN, timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, tabName, action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	public WebElement editButtonInPublisherLayout(int timeOut) {
		String xpath = "//a[text()='Edit']";

		try {
			return FindElement(driver, xpath, "edit", action.SCROLLANDBOOLEAN, timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "edit", action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	@FindBy(xpath = "//input[@name='goNext']")
	private WebElement nextButton;

	public WebElement nextButton(int timeOut) {
		return isDisplayed(driver, nextButton, "Visibility", timeOut, "nextButton");
	}

	public WebElement renameLabelNameSingularTextBox(String labelName, int timeOut) {
		String xpath = "//th[text()='" + labelName
				+ "']/following-sibling::td/input[@type=\"text\" and contains(@title,\"Singular\")]";

		try {
			return FindElement(driver, xpath, "renameLabelNameSingularTextBox", action.SCROLLANDBOOLEAN, timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "renameLabelNameSingularTextBox", action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	public WebElement renameLabelNamePluralTextBox(String labelName, int timeOut) {
		String xpath = "//th[text()='" + labelName
				+ "']/following-sibling::td/input[@type=\"text\" and contains(@title,\"Plural\")]";

		try {
			return FindElement(driver, xpath, "renameLabelNamePluralTextBox", action.SCROLLANDBOOLEAN, timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "renameLabelNamePluralTextBox", action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	/*
	 * @FindBy(xpath = "//div[@class='pbBottomButtons']//input[@title='Save']")
	 * private WebElement footerSaveBtn;
	 * 
	 * public WebElement getfooterSaveBtn(int timeOut) { return isDisplayed(driver,
	 * footerSaveBtn, "Visibility", timeOut, "footer save button"); }
	 */

	public WebElement EditButtonOfAcuitySettings(String SettingName, int timeOut) {
		String xpath = "//a[text()='" + SettingName + "']/ancestor::tr//a[text()='Edit']";

		try {
			return FindElement(driver, xpath, "EditButtonOfAcuitySettings", action.SCROLLANDBOOLEAN, timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "EditButtonOfAcuitySettings", action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	public WebElement settingTypeManageRecordsButton(String SettingType, int timeOut) {
		String xpath = "//th//a[text()='" + SettingType + "']/../..//a[text()='Manage Records']";

		try {
			return isDisplayed(driver,
					FindElement(driver, xpath, "SettingTypeInCustomMetaData", action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "SettingTypeInCustomMetaData");

		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver,
					FindElement(driver, xpath, "SettingTypeInCustomMetaData", action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "SettingTypeInCustomMetaData");
		}
	}
	
	public WebElement NewRecordsButton( int timeOut) {
		String xpath = "//input[@name='new'][contains(@title,'Custom Metadata')]";

		try {
			return isDisplayed(driver,
					FindElement(driver, xpath, "NewRecordsButton", action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "NewRecordsButton");

		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver,
					FindElement(driver, xpath, "NewRecordsButton", action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "NewRecordsButton");
		}
	}

	public String GetDataFromValueFieldInCustomMetaData(int timeOut) {
		String xpath = "//td[contains(@class,'dataCol last')]//*";

		try {
			return FindElement(driver, xpath, "Value Field", action.SCROLLANDBOOLEAN, 10).getAttribute("value");

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Value Field", action.SCROLLANDBOOLEAN, 10).getAttribute("value");
		}
	}

	@FindBy(xpath = "//input[@id='Title']")
	private WebElement userTitle;

	public WebElement getUserTitle(int timeOut) {
		return isDisplayed(driver, userTitle, "Visibility", timeOut, "user title");
	}

	
	
	
	
	@FindBy(xpath = "//input[@title='Export Now'][@name='edit']")
	private WebElement exportNow;

	public WebElement getexportNowButton(int timeOut) {
		return isDisplayed(driver, exportNow, "Visibility", timeOut, "exportNow");
	}
	
	@FindBy(xpath = "//td[text()='Schedule Date']/following-sibling::td")
	private WebElement scheduleDate;

	public WebElement getscheduleDate(int timeOut) {
		return isDisplayed(driver, scheduleDate, "Visibility", timeOut, "scheduleDate");
	}
	@FindBy(xpath = "//a[@class='actionLink'][contains(@title,'download')]")
	private WebElement downloadButton;

	public WebElement getdownloadButton(int timeOut) {
		return isDisplayed(driver, downloadButton, "Visibility", timeOut, "downloadButton");
	}

	public WebElement getdefaultRecord(int timeOut) {
		return defaultRecord;
	}

	@FindBy(xpath = "//td[contains(@class,'dataCol last')]//*")
	private WebElement valueTextBoxInAcuitySetting;

	public WebElement getValueTextBoxInAcuitySetting(int timeOut) {
		return isDisplayed(driver, valueTextBoxInAcuitySetting, "Visibility", timeOut, "ValueTextBoxInAcuitySetting");
	}

	@FindBy(xpath = "//select[@id=\"fcf\"]")
	private WebElement viewUsers;

	public WebElement viewUsers(int timeOut) {
		return isDisplayed(driver, viewUsers, "Visibility", timeOut, "viewUsers");
	}

	public WebElement LabelNameInCustomMetaData(String labelName, int timeOut) {
		String xpath = "//a[text()='" + labelName + "']";

		return isDisplayed(driver,
				FindElement(driver, xpath, "Label Name In Custom Meta Data", action.SCROLLANDBOOLEAN, timeOut),
				"label Name", 10, "Label Name In Custom Meta Data");

	}

	public WebElement LabelNameInputCustomMetaData(int timeOut) {
		String xpath = "//input[@name='MasterLabel']";

		return isDisplayed(driver,
				FindElement(driver, xpath, "Label Name Input Custom Meta Data", action.BOOLEAN, timeOut),
				"label Name", 10, "Label Name Input Custom Meta Data");

	}
	
	public WebElement pluralLabelNameInputCustomMetaData( int timeOut) {
		String xpath = "//input[@name='PluralLabel']";

		return isDisplayed(driver,
				FindElement(driver, xpath, "plural Label Name Input Custom Meta Data", action.BOOLEAN, timeOut),
				"label Name", 10, "plural Label Name Input Custom Meta Data");

	}
	
	public WebElement descriptionInputCustomMetaData(int timeOut) {
		String xpath = "//textarea[@name='Description']";

		return isDisplayed(driver,
				FindElement(driver, xpath, "description Input Custom Meta Data", action.BOOLEAN, timeOut),
				"label Name", 10, "description Input Custom Meta Data");

	}

	@FindBy(xpath = "//button[@title=\"Validation Rule\"]")
	private WebElement vaidationRuleNewButton;

	public WebElement vaidationRuleNewButton(int timeOut) {
		return isDisplayed(driver, vaidationRuleNewButton, "Visibility", timeOut, "vaidationRuleNewButton");
	}

	@FindBy(id = "ValidationName")
	private WebElement validationRuleName;

	public WebElement validationRuleName(int timeOut) {
		return isDisplayed(driver, validationRuleName, "Visibility", timeOut, "vaidationRuleName");
	}

	@FindBy(id = "ValidationFormula")
	private WebElement validationRuleFormula;

	public WebElement validationRuleFormula(int timeOut) {
		return isDisplayed(driver, validationRuleFormula, "Visibility", timeOut, "validationRuleFormula");
	}

	@FindBy(id = "ValidationMessage")
	private WebElement validationRuleMessage;

	public WebElement validationRuleMessage(int timeOut) {
		return isDisplayed(driver, validationRuleMessage, "Visibility", timeOut, "validationRuleMessage");
	}

	public WebElement validationRuleErrorMsgLocation(String errorLocation, int timeOut) {
		String xpath = "//td[text()=\"Error Location\"]/following-sibling::td//label[text()=\"" + errorLocation
				+ "\"]/preceding-sibling::input";

		return isDisplayed(driver,
				FindElement(driver, xpath, "validationRuleErrorMsgLocation", action.SCROLLANDBOOLEAN, timeOut),
				"label Name", 10, "validationRuleErrorMsgLocation");

	}

	public WebElement validationRuleAlreadyExist(String validationRuleName, int timeOut) {
		String xpath = "//span[text()=\"" + validationRuleName + "\" and @class=\"uiOutputText\"]";

		return isDisplayed(driver,
				FindElement(driver, xpath, "validationRuleAlreadyExist", action.SCROLLANDBOOLEAN, timeOut),
				"Validation Rule Name: " + validationRuleName, 10, "validationRuleAlreadyExist");

	}

	@FindBy(xpath = "//iframe[contains(@title,\"Validation Rule\")]")
	private WebElement validationRuleIframe;

	public WebElement validationRuleIframe(int timeOut) {
		return isDisplayed(driver, validationRuleIframe, "Visibility", timeOut,
				"vaidativalidationRuleIframeonRuleIframe");
	}

	@FindBy(name = "save")
	private WebElement validationRuleSaveButton;

	public WebElement validationRuleSaveButton(int timeOut) {
		return isDisplayed(driver, validationRuleSaveButton, "Visibility", timeOut, "validationRuleSaveButton");
	}

	@FindBy(id = "FieldEnumOrId")
	private WebElement validationRuleFieldSelect;

	public WebElement validationRuleFieldSelect(int timeOut) {
		return isDisplayed(driver, validationRuleFieldSelect, "Visibility", timeOut, "validationRuleFieldSelect");
	}

	public WebElement validationRuleCreatedDetailName(String validationRuleName, int timeOut) {
		String xpath = "//table[@class=\"detailList\"]//td[text()=\"" + validationRuleName + "\"]";

		return isDisplayed(driver,
				FindElement(driver, xpath, "validationRuleCreatedDetailName", action.SCROLLANDBOOLEAN, timeOut),
				"Validation Rule Name: " + validationRuleName, 10, "validationRuleCreatedDetailName");

	}

	public WebElement recordTypeMakeAvailableGlobal(int timeOut) {
		String xpath = "//tr[@class=\"headerRow\"]/th/following::label[text()=\"Make Available\"]/preceding-sibling::input";

		return isDisplayed(driver,
				FindElement(driver, xpath, "recordTypeMakeAvailableGlobal", action.SCROLLANDBOOLEAN, timeOut),
				"recordTypeMakeAvailableGlobal", 10, "recordTypeMakeAvailableGlobal");

	}

	
	@FindBy(id = "p5")
	private WebElement defaultRecordTypeOption;

	public WebElement defaultRecordTypeOption(int timeOut) {
		return isDisplayed(driver, defaultRecordTypeOption, "Visibility", timeOut, "defaultRecordTypeOption");
	}
	
	@FindBy(xpath = "//input[@title='Edit']")
	private WebElement editButton;

	public WebElement editButton(int timeOut) {
		return isDisplayed(driver, editButton, "Visibility", timeOut,
				"edit button");
	}
	
	@FindBy(xpath = "//div[@class=' pbTitle relatedList']/following-sibling::div[@id='item_RL__RelatedActivityList']")
	private WebElement OpenActivitiesRelatedListOptionLink;

	public WebElement OpenActivitiesRelatedListOptionLink(int timeOut) {
		return isDisplayed(driver, OpenActivitiesRelatedListOptionLink, "Visibility", timeOut,
				"OpenActivitiesRelatedListOptionLink");
	}
	
	@FindBy(xpath = "//div[@class=' pbTitle relatedList']/following-sibling::div[@id='item_RL__RelatedHistoryList']")
	private WebElement ActivityHistoryRelatedListOptionLink;

	public WebElement ActivityHistoryRelatedListOptionLink(int timeOut) {
		return isDisplayed(driver, ActivityHistoryRelatedListOptionLink, "Visibility", timeOut,
				"ActivityHistoryRelatedListOptionLink");
	}
	
	
	@FindBy(xpath = "//div[@class=' pbTitle relatedList']/following-sibling::div[@id='item_RL__RelatedActivityList']//div[@class='remove']")
	private WebElement OpenActivitiesRelatedListRemoveLink;

	public WebElement OpenActivitiesRelatedListOptionRemoveLink(int timeOut) {
		return isDisplayed(driver, OpenActivitiesRelatedListRemoveLink, "Visibility", timeOut,
				"OpenActivitiesRelatedListOptionLink");
	}
	
	@FindBy(xpath = "//div[@class=' pbTitle relatedList']/following-sibling::div[@id='item_RL__RelatedHistoryList']//div[@class='remove']")
	private WebElement ActivityHistoryRelatedListRemoveLink;

	public WebElement ActivityHistoryRelatedListOptionRemoveLink(int timeOut) {
		return isDisplayed(driver, ActivityHistoryRelatedListRemoveLink, "Visibility", timeOut,
				"ActivityHistoryRelatedListOptionLink");
	}
	
	@FindBy(xpath = "//div[@class=' pbTitle relatedList']/following-sibling::div[@id='item_RL__RelatedFileList']")
	private WebElement filesRelatedListOptionLink;

	public WebElement filesRelatedListOptionLink(int timeOut) {
		return isDisplayed(driver, filesRelatedListOptionLink, "Visibility", timeOut,
				"filesRelatedListOptionLink");
	}
	
	@FindBy(xpath="//label[text()='Section Title Label']/following-sibling::div//input")
	private WebElement SectionTitleLabel;

	/**
	 * @return the SectionTitleLabel
	 */
	public WebElement getSectionTitleLabel(String projectName,int timeOut) {

		return isDisplayed(driver, SectionTitleLabel, "Visibility", timeOut, "Section Title Label");


	}
	
	@FindBy(xpath="//label[text()='End']/../..//input")
	private WebElement EndDate;

	/**
	 * @return the SectionTitleLabel
	 */
	public WebElement getEndDate(String projectName,int timeOut) {

		return isDisplayed(driver, EndDate, "Visibility", timeOut, "End Date");


	}
	
	@FindBy(xpath="//span[text()='New Task']/ancestor::tr//a[@class='rowActionsPlaceHolder slds-button slds-button--icon-border-filled']")
	private WebElement NewTaskdropdown;

	/**
	 * @return the NewTaskdropdown
	 */
	public WebElement getNewTaskdropdown(int timeOut) {

		return isDisplayed(driver, NewTaskdropdown, "Visibility", timeOut, "New Task drop down");


	}
	
	@FindBy(xpath="//span[text()='New Event']/ancestor::tr//a[@class='rowActionsPlaceHolder slds-button slds-button--icon-border-filled']")
	private WebElement NewEventdropdown;

	/**
	 * @return the NewTaskdropdown
	 */
	public WebElement getNewEventdropdown(int timeOut) {

		return isDisplayed(driver, NewEventdropdown, "Visibility", timeOut, "New Event drop down");


	}
	@FindBy(xpath="//span[text()='View']/ancestor::tr//a[@class='rowActionsPlaceHolder slds-button slds-button--icon-border-filled']")
	private WebElement Viewdropdown;

	/**
	 * @return the Viewdropdown
	 */
	public WebElement getViewdropdown(int timeOut) {

		return isDisplayed(driver, Viewdropdown, "Visibility", timeOut, "View drop down");


	}
	
	@FindBy(xpath="//span[text()='New']/ancestor::tr//a[@class='rowActionsPlaceHolder slds-button slds-button--icon-border-filled']")
	private WebElement NewViewdropdown;

	/**
	 * @return the Viewdropdown
	 */
	public WebElement getNewdropdown(int timeOut) {

		return isDisplayed(driver, NewViewdropdown, "Visibility", timeOut, "New View drop down");


	}
	
	@FindBy(xpath="//div[contains(@class,'actionMenu')]//a[@title='Edit']")
	private WebElement NewTaskEditbutton;

	/**
	 * @return the SectionTitleLabel
	 */
	public WebElement getNewTaskEditbutton(int timeOut) {

		return isDisplayed(driver, NewTaskEditbutton, "Visibility", timeOut, "New Task Edit button");


	}
	@FindBy(xpath="//*[@data-label='Label']")
	private WebElement Labeltextbox;

	/**
	 * @return the Labeltextbox
	 */
	public WebElement getLabeltextbox(String projectName,int timeOut) {

		return isDisplayed(driver, Labeltextbox, "Visibility", timeOut, "Label text box");


	}
	
	@FindBy(xpath="(//*[text()='Lightning Experience Override']/../..//input[@name='LexOverrides'])[1]")
	private WebElement Lightningcomponent;

	/**
	 * @return the Labeltextbox
	 */
	public WebElement getLightningcomponent(String projectName,int timeOut) {

		return isDisplayed(driver, Lightningcomponent, "Visibility", timeOut, "Lightning component");


	}
	
	@FindBy(xpath="(//*[text()='Mobile Override']/../..//input[@name='S1Overrides'])[1]")
	private WebElement MobileOverride;

	/**
	 * @return the Labeltextbox
	 */
	public WebElement getMobileOverride(String projectName,int timeOut) {

		return isDisplayed(driver, MobileOverride, "Visibility", timeOut, "Mobile Override");


	}
	@FindBy(xpath="//*[@data-label='URL']")
	private WebElement Urltextbox;

	/**
	 * @return the Urltextbox
	 */
	public WebElement getUrltextbox(String projectName,int timeOut) {

		return isDisplayed(driver, Urltextbox, "Visibility", timeOut, "Url text box");


	}
	@FindBy(xpath="//*[@data-label='Label']//button")
	private WebElement Labelpencilicon;

	/**
	 * @return the Labelpencilicon
	 */
	public WebElement getLabelpencilicon(String projectName,int timeOut) {

		return isDisplayed(driver, Labelpencilicon, "Visibility", timeOut, "Label pencil icon");


	}
	
	@FindBy(xpath = "(//*[text()='Lightning component']/../..//select)[1]")
	private WebElement Lightningcomponent1;

	public WebElement getLightningcomponent1(String projectName, int timeOut) {
		return isDisplayed(driver, Lightningcomponent1, "Visibility", timeOut, "Lightning component1");
	}
	
	@FindBy(xpath = "//*[text()='Mobile Override']/../..//*[text()='Lightning component']/../..//select")
	private WebElement Lightningcomponent2;

	public WebElement getLightningcomponent2(String projectName, int timeOut) {
		return isDisplayed(driver, Lightningcomponent2, "Visibility", timeOut, "Lightning component2");
	}
	
	@FindBy(xpath="//*[@data-label='URL']//button")
	private WebElement Urlpencilicon;

	/**
	 * @return the Urlpencilicon
	 */
	public WebElement getUrlpencilicon(String projectName,int timeOut) {

		return isDisplayed(driver, Urlpencilicon, "Visibility", timeOut, "Url pencil icon");


	}
	
	@FindBy(xpath="//input[@name='dt-inline-edit-text']")
	private WebElement inputtextbox;

	/**
	 * @return the inputtextbox
	 */
	public WebElement getinputtextbox(String projectName,int timeOut) {

		return isDisplayed(driver, inputtextbox, "Visibility", timeOut, "input text box");


	}
	
	@FindBy(xpath="//input[@name='dt-inline-edit-url']")
	private WebElement urlinputtextbox;

	/**
	 * @return the urlinputtextbox
	 */
	public WebElement geturlinputtextbox(String projectName,int timeOut) {

		return isDisplayed(driver, urlinputtextbox, "Visibility", timeOut, "url input text box");


	}
	
	@FindBy(xpath = "//input[@id='globalQuickfind']")
	private WebElement searchTextboxFieldsAndRelationships;

	public WebElement getsearchTextboxFieldsAndRelationships(int timeOut) {
		return isDisplayed(driver, searchTextboxFieldsAndRelationships, "Visibility", timeOut,
				"search Textbox on Fields And Relationships");
	}
	
	@FindBy(xpath = "//h3[text()='Salesforce Mobile and Lightning Experience Actions']")
	private WebElement SalesforceMobileandLightningExperienceActions;

	public WebElement getSalesforceMobileandLightningExperienceActions(int timeOut) {
		return isDisplayed(driver, SalesforceMobileandLightningExperienceActions, "Visibility", timeOut,
				"Sales force Mobile and Lightning Experience Actions");
	}
	
	@FindBy(xpath = "//div[@id='troughCategory__RelatedList']")
	private WebElement relatedListOptionLink;

	public WebElement relatedListOptionLink(int timeOut) {
		return isDisplayed(driver, relatedListOptionLink, "Visibility", timeOut,
				"relatedListOptionLink");
	}
	@FindBy(xpath = "//input[@value='Schedule Apex']")
	private WebElement ScheduleApex;

	public WebElement getScheduleApex(int timeOut) {
		return isDisplayed(driver, ScheduleApex, "Visibility", timeOut,
				"Schedule Apex");
	}
	@FindBy(xpath = "//input[@id='job_name']")
	private WebElement JobName;

	public WebElement getJobName(int timeOut) {
		return isDisplayed(driver, JobName, "Visibility", timeOut,
				"Job Name");
	}
	@FindBy(xpath = "//input[@id='ac']")
	private WebElement ApexClass;

	public WebElement getApexClass(int timeOut) {
		return isDisplayed(driver, ApexClass, "Visibility", timeOut,
				"Apex Class");
	}
	@FindBy(xpath="//div[contains(@class,'scroll-bidirectional native')]")
	private WebElement selectProspectsGridScrollBox;
	
	/**
	 * @return the selectProspectsGridScrollBox
	 */
	public WebElement getSelectProspectsGridScrollBox(int timeOut) {
		

			return isDisplayed(driver, selectProspectsGridScrollBox, "Visibility", timeOut, "select prospects scroll box grid");
			
	}

	@FindBy(xpath="//div/div/div[@class='oneAlohaPage']//iframe")
	private WebElement setUpFrame_Lighting;

	/**
	 * @return the dealCreationFrame_Lighting
	 */
	public WebElement getnavatarSetUpTabFrame_Lighting(String projectName,int timeOut) {
		return isDisplayed(driver, setUpFrame_Lighting, "Visibility", timeOut, " Frame Lighting");
	}
	
	@FindBy(xpath="//div[contains(@id,'RightMenuContentSection')]//div[@class='slds-button-group float_r']")
	private WebElement editButtonforNavatarSetUpSideMenuTab;

	/**
	 * @return the getEditButtonforNavatarSetUpSideMenuTab
	 */
	public WebElement getEditButtonforNavatarSetUpSideMenuTab(String projectName,NavatarSetupSideMenuTab sideMenuTab,int timeOut) {
		return isDisplayed(driver, editButtonforNavatarSetUpSideMenuTab, "Visibility", timeOut, "Edit Button for Navatar SetUp Side Menu Tab");
	}
	public WebElement getEnableCheckBoxforClickNavatarSetUpSideMenuTab(String project,
			NavatarSetupSideMenuTab sideMenuTab, EditViewMode editviewMode, int timeOut) {
		WebElement ele =null;
		List<WebElement> enableCheckBoxList = FindElements(driver,
				"//span[contains(@class,'primaryPaletteBorder')]/..//input/following-sibling::span",
				"Enable CheckBox for Click Navatar SetUp Side Menu Tab");

//		if (NavatarSetupSideMenuTab.CommitmentCreation.equals(sideMenuTab) || NavatarSetupSideMenuTab.DealCreation.equals(sideMenuTab) || NavatarSetupSideMenuTab.IndividualInvestorCreation.equals(sideMenuTab)) {
//			return isDisplayed(driver, enableCheckBoxList.get(1), "Visibility", timeOut,
//					"Enable CheckBox for Navatar SetUp Side Menu Tab");
//		}else if (EditViewMode.View.toString().equalsIgnoreCase(editviewMode.toString()) || NavatarSetupSideMenuTab.OfficeLocations.equals(sideMenuTab)) {
//			return isDisplayed(driver, enableCheckBoxList.get(0), "Visibility", timeOut,
//					"Enable CheckBox for Navatar SetUp Side Menu Tab");
//		} else {
//			return isDisplayed(driver, enableCheckBoxList.get(0), "Visibility", timeOut,
//					"Enable CheckBox for Navatar SetUp Side Menu Tab");
//		}
		
		
		for(WebElement element:enableCheckBoxList) {
			
			element =isDisplayed(driver, element, "Visibility", timeOut,"Enable CheckBox for Navatar SetUp Side Menu Tab");
			
			if(element!=null) {
				ele= element;
				break;
			}
		}
		
		return ele;
		
	}
	public WebElement getSaveButtonforNavatarSetUpSideMenuTab(String projectName,NavatarSetupSideMenuTab sideMenuTab,int timeOut, TopOrBottom topOrBottom) {
		String xpath ;
		WebElement ele;
		if (TopOrBottom.TOP.toString().equalsIgnoreCase(topOrBottom.toString())) {
			xpath = "(//div[contains(@id,'RightMenuContentSection')]//input[@title='Save'])[1]";
		} else {
			xpath = "(//div[contains(@id,'RightMenuContentSection')]//input[@title='Save'])[2]";
		}
		ele = FindElement(driver, xpath, "Save Button : "+topOrBottom, action.SCROLLANDBOOLEAN, timeOut);
				
		return isDisplayed(driver, ele, "Visibility", timeOut, "Save Button for Navatar SetUp Side Menu Tab : "+topOrBottom);
	}
}
