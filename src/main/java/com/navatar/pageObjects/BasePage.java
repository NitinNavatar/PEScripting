/**
 * 
 */
package com.navatar.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import com.navatar.generic.BaseLib;
import com.navatar.generic.CommonLib;
import com.navatar.generic.SoftAssert;
import com.navatar.generic.EnumConstants.*;
import com.relevantcodes.extentreports.LogStatus;

import static com.navatar.generic.AppListeners.appLog;
import static com.navatar.generic.CommonLib.*;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Parul Singh
 *
 */
public abstract class BasePage extends BaseLib {

	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//a[@title='Logout']")
	private WebElement logout;

	@FindBy(xpath = "//a[contains(@href,'logout')]")
	private WebElement logout_Lightning;

	public WebElement getLogoutButton(int timeOut) {
		return isDisplayed(driver, logout_Lightning, "Visibility", timeOut, "Logout in User menu");
	}

	@FindBy(xpath = "//*[contains(text(),'Maintenance')]")
	private WebElement scheduledMaintenancePopUp;

	/**
	 * @return the scheduledMaintenancePopUp
	 */
	public WebElement getScheduledMaintenancePopUp(int timeOut) {
		return isDisplayed(driver, scheduledMaintenancePopUp, "Visibility", timeOut, "Scheduled Maintenance Pop Up",
				action.SCROLL);
	}

	@FindBy(xpath = "//a[@class='continue']")
	private WebElement scheduledMaintenanceContinueLink;

	/**
	 * @return the scheduledMaintenanceContinueLink
	 */
	public WebElement getScheduledMaintenanceContinueLink(int timeOut) {
		return isDisplayed(driver, scheduledMaintenanceContinueLink, "Visibility", timeOut,
				"scheduled Maintenance Continue Link");
	}

	@FindBy(xpath = "//a[@title='Contacts Tab']")
	private WebElement contactsTab;

	/**
	 * @return the contactsTab
	 */
	public WebElement getContactsTab(int timeOut) {
		return isDisplayed(driver, contactsTab, "Visibility", timeOut, "Contacts Tab");
	}

	@FindBy(xpath = "//a[@title='Funds Tab']")
	private WebElement fundsTab;

	/**
	 * @return the fundsTab
	 */
	public WebElement getFundsTab(int timeOut) {
		return isDisplayed(driver, fundsTab, "Visibility", timeOut, "Funds Tab");
	}

	@FindBy(xpath = "//a[@title='Institutions Tab']")
	private WebElement institutionsTab;

	/**
	 * @return the fundsTab
	 */
	public WebElement getInstitutionsTab(int timeOut) {
		return isDisplayed(driver, institutionsTab, "Visibility", timeOut, "Institutions Tab");
	}

	@FindBy(xpath = "//a[@title='Fundraisings Tab']")
	private WebElement fundRaisingsTab;

	/**
	 * @return the fundRaisingsTab
	 */
	public WebElement getFundRaisingsTab(int timeOut) {
		return isDisplayed(driver, fundRaisingsTab, "Visibility", timeOut, "FundRaisings Tab");
	}

	@FindBy(xpath = "//select[@name='fcf']")
	private WebElement viewDropdown;

	/**
	 * @return the viewDropdown
	 */
	public WebElement getViewDropdown(int timeOut) {
		return isDisplayed(driver, viewDropdown, "Visibility", timeOut, "View Dropdown");
	}

	@FindBy(xpath = "//input[@name='go']")
	private WebElement goButton;

	/**
	 * @return the goButton
	 */
	public WebElement getGoButton(int timeOut) {
		return isDisplayed(driver, goButton, "Visibility", timeOut, "Go Button");
	}

	@FindBy(xpath = "//input[@name='new']")
	private WebElement newButtonClassic;

	/**
	 * @return the newButton
	 */
	public WebElement getNewButton(String environment, String mode, int timeOut) {
		if (mode.equalsIgnoreCase(Mode.Classic.toString())) {
			return isDisplayed(driver, newButtonClassic, "Visibility", timeOut, "New Button Classic");
		} else {
			return newButtonLighting;
		}

	}

	@FindBy(xpath = "//a[text()='Close']")
	private WebElement lightingCloseButton;

	/**
	 * @return the lightingCloseButton
	 */
	public WebElement getLightingCloseButton(int timeOut) {
		return isDisplayed(driver, lightingCloseButton, "Visibility", timeOut, "Linghting Pop-Up Close Icon");
	}

	@FindBy(xpath = "//div[@id='userNavButton']/span")
	private WebElement userMenuTab;

	public List<WebElement> getUserMenuTab_Lightning() {
		return FindElements(driver, "//span[contains(@class,'userProfileCardTriggerRoot')]//img[@alt='User']",
				"user menu tab in lightning");
	}

	/**
	 * @return the userMenuTab
	 */
	public WebElement getUserMenuTab(int timeOut) {
		return isDisplayed(driver, userMenuTab, "Visibility", timeOut, "User Menu Tab");

	}

	@FindBy(xpath = "//a[contains(@class,'menuTriggerLink slds-button')]//div[contains(@class,'tooltip-trigger uiTooltip')]")
	private WebElement settingIcon_Lighting;

	/**
	 * @return the settingTab_Lighting
	 */
	public WebElement getSettingLink_Lighting(int timeOut) {
		return isDisplayed(driver, settingIcon_Lighting, "Visibility", timeOut, "setting tab in lighting");
	}

	@FindBy(xpath = "//div[@class='slds-nav-vertical__section']//a[text()='Notifications']")
	private WebElement settingNotificationButton;

	/**
	 * @return the settingTab_Lighting
	 */
	public WebElement getNavatarSettingNotificationButton(int timeOut) {
		return isDisplayed(driver, settingNotificationButton, "Visibility", timeOut, "settingNotificationButton");
	}

	@FindBy(xpath = "//input[@name='actionNotification']")
	private WebElement ActionNotificationCheckbox;

	/**
	 * @return the settingTab_Lighting
	 */
	public WebElement getActionNotificationCheckbox(int timeOut) {
		return isDisplayed(driver, ActionNotificationCheckbox, "Visibility", timeOut, "ActionNotificationCheckbox");
	}
	
	@FindBy(xpath = "//input[@name='infoNotification']")
	private WebElement InformationalNotificationCheckbox;

	/**
	 * @return the settingTab_Lighting
	 */
	public WebElement getInformationalNotificationCheckbox(int timeOut) {
		return isDisplayed(driver, InformationalNotificationCheckbox, "Visibility", timeOut, "InformationalNotificationCheckbox");
	}
	
	@FindBy(xpath = "//div[@class='menuButton menuButtonRounded']")
	private WebElement UserNameAtUserMenuTab;

	/**
	 * @return the userNameAtUserMenuTab
	 */
	public WebElement getUserNameAtUserMenuTab(int timeOut) {
		return isDisplayed(driver, UserNameAtUserMenuTab, "Visibility", timeOut, "User Name at user menu tab");
	}

	@FindBy(xpath = "//a[text()='Settings']")
	private WebElement settingsLinkLightning;

	/**
	 * @return the settingsLinkLightning
	 */
	public WebElement getSettingsLinkLightning(int timeOut) {
		return isDisplayed(driver, settingsLinkLightning, "Visibility", timeOut,
				"settings Link on user menu Lightning");
	}

	@FindBy(xpath = "//a[text()='Display & Layout']")
	private WebElement displayAndLayout_Lightning;

	/**
	 * @return the displayAndLayout_Lightning
	 */
	public WebElement getDisplayAndLayout_Lightning(int timeOut) {
		return isDisplayed(driver, displayAndLayout_Lightning, "Visibility", timeOut, "displayAndLayout_Lightning");
	}

	@FindBy(xpath = "//a[text()='Record Page Settings']")
	private WebElement recordPageSettings;

	/**
	 * @return the recordPageSettings
	 */
	public WebElement getRecordPageSettings(int timeOut) {
		return isDisplayed(driver, recordPageSettings, "Visibility", timeOut, "recordPageSettings");
	}

	@FindBy(xpath = "//img[@alt='Select Related Lists']")
	private WebElement relatedListRecordPageSetting;

	/**
	 * @return the relatedListRecordPageSetting
	 */
	public WebElement getRelatedListRecordPageSetting(int timeOut) {
		return isDisplayed(driver, relatedListRecordPageSetting, "Visibility", timeOut, "relatedListRecordPageSetting");
	}

	@FindBy(xpath = "//h2[text()='Tabs']/..//div[@class='uiTabBar']")
	private WebElement relatedTabBar;

	/**
	 * @return the relatedListRecordPageSetting
	 */
	public WebElement getRelatedTabBar(int timeOut) {
		return isDisplayed(driver, relatedTabBar, "Visibility", timeOut, "related tab list nav bar");
	}

	@FindBy(xpath = "//img[@alt='Select Activity Timeline']")
	private WebElement activityTimelineRecordPageSetting;

	/**
	 * @return the activityTimelineRecordPageSetting
	 */
	public WebElement getActivityTimelineRecordPageSetting(int timeOut) {
		return isDisplayed(driver, activityTimelineRecordPageSetting, "Visibility", timeOut,
				"activityTimelineRecordPageSetting");
	}

//	@FindBy(xpath = "//button[text()='Save']")
//	private WebElement recordPageSettingSave;

	@FindBy(xpath = "//button[@name='SaveEdit']")
	private WebElement recordPageSettingSave;

	/**
	 * @return the recordPageSettingSave
	 */
	public WebElement getRecordPageSettingSave(int timeOut) {
		return isDisplayed(driver, recordPageSettingSave, "Visibility", timeOut, "recordPageSettingSave");
	}

	@FindBy(xpath = "//li[@data-aura-class='uiMenuItem onesetupSetupMenuItem']/a[@title='Setup']")
	private WebElement setupLink_Lighting;

	@FindBy(xpath = "//a[@title='Setup']")
	private WebElement userMenuSetupLink;

	/**
	 * @return the userMenuSetupLink
	 */
	public WebElement getUserMenuSetupLink(int timeOut) {
		WebElement ele = null;
		ele = setupLink_Lighting;
		return isDisplayed(driver, ele, "Visibility", timeOut, "Setup Link");
	}

	@FindBy(xpath = "//li[@data-aura-class='uiMenuItem onesetupSetupMenuItem']/a[@title='Edit Page']")
	private WebElement editPageLink_Lighting;

	public WebElement getEditPageLink_Lighting(int timeOut) {
		return isDisplayed(driver, editPageLink_Lighting, "Visibility", timeOut, "edit page Link");
	}

	public WebElement getUserMenuSetupLink(String mode, int timeOut) {
		WebElement ele = null;
		if (mode.equalsIgnoreCase(Mode.Classic.toString()))
			ele = userMenuSetupLink;
		else
			ele = setupLink_Lighting;
		return isDisplayed(driver, ele, "Visibility", timeOut, "Setup Link");
	}

	@FindBy(xpath = "(//a[@title='Logout'])[1]")
	private WebElement logOutButton;

	/**
	 * @return the logOutButton
	 */
	public WebElement getLogOutButton(int timeOut) {
		return isDisplayed(driver, logOutButton, "Visibility", timeOut, "Logout Button");
	}

	@FindBy(xpath = "//a[@id='ManageUsers_font']")
	private WebElement userLink_Classic;

	@FindBy(xpath = "//a[text()='Users'][contains(@href,'ManageUsers/home')]")
	private WebElement userLink_Lighting;

	/**
	 * @return the usersLink
	 */
	public WebElement getUsersLink(int timeOut) {
		return isDisplayed(driver, userLink_Lighting, "Visibility", timeOut, "Users Link in ");
	}

	@FindBy(xpath = "(//input[@title='New User'])[1]")
	private WebElement newUserLink;

	/**
	 * @return the newUserLink
	 */
	public WebElement getNewUserLink(int timeOut) {
		return isDisplayed(driver, newUserLink, "Visibility", timeOut, "New User Button");
	}

	@FindBy(id = "name_firstName")
	private WebElement userFirstName;

	/**
	 * @return the userFirstName
	 */
	public WebElement getUserFirstName(int timeOut) {
		return isDisplayed(driver, userFirstName, "Visibility", timeOut, "User First Name");
	}

	@FindBy(id = "name_lastName")
	private WebElement userLastName;

	/**
	 * @return the userLastName
	 */
	public WebElement getUserLastName(int timeOut) {
		return isDisplayed(driver, userLastName, "Visibility", timeOut, "User Last Name");
	}

	@FindBy(id = "user_license_id")
	private WebElement userUserLicenseDropDownList;

	/**
	 * @return the userUserLicenseDropDownList
	 */
	public WebElement getUserUserLicenseDropDownList(int timeOut) {
		return isDisplayed(driver, userUserLicenseDropDownList, "Visibility", timeOut, "User License Drop Down List");
	}

	@FindBy(id = "Profile")
	private WebElement userProfileDropDownList;

	/**
	 * @return the userProfileDropDownList
	 */
	public WebElement getUserProfileDropDownList(int timeOut) {
		return isDisplayed(driver, userProfileDropDownList, "Visibility", timeOut, "User Profile Drop Down List");
	}

	@FindBy(id = "Email")
	private WebElement userEmailId;

	/**
	 * @return the userEmailId
	 */
	public WebElement getUserEmailId(int timeOut) {
		return isDisplayed(driver, userEmailId, "Visibility", timeOut, "User Email Id");
	}

	@FindBy(xpath = "//td[text()='Email']/../td[2]/a")
	private WebElement userEmailIDLabeltext;

	/**
	 * @return the userEmailIDLabeltext
	 */
	public WebElement getUserEmailIDLabeltext(int timeOut) {
		return isDisplayed(driver, userEmailIDLabeltext, "Visibility", timeOut, "Email ID Label Text");
	}

	@FindBy(xpath = "//a[contains(@title,'Manage Licenses')][contains(@title,'PE')]")
	private WebElement manageLicensesLink;

	/**
	 * @return the manageLicensesLink
	 */
	public WebElement getManageLicensesLink(int timeOut) {
		return isDisplayed(driver, manageLicensesLink, "Visibility", timeOut, "Manage Licenses Link");
	}

	@FindBy(xpath = "//input[@title='Add Users']")
	private WebElement addUsersbutton;

	/**
	 * @return the addUsersbutton
	 */
	public WebElement getAddUsersbutton(int timeOut) {
		return isDisplayed(driver, addUsersbutton, "Visibility", timeOut, "Add Users Button");
	}

	@FindBy(xpath = "//div[@class='listRelatedObject userBlock']//form/div[2]/table//tr[1]//a[contains(@title,'Active')]")
	private WebElement ActiveUserTab;

	/**
	 * @return the activeUserTab
	 */
	public WebElement getActiveUserTab(int timeOut) {
		return isDisplayed(driver, ActiveUserTab, "Visibility", timeOut, "Active User Tab");
	}

	@FindBy(xpath = "//input[@title='Add']")
	private WebElement activeUserAddButton;

	/**
	 * @return the activeUserAddButton
	 */
	public WebElement getActiveUserAddButton(int timeOut) {
		return isDisplayed(driver, activeUserAddButton, "Visibility", timeOut, "Active User Add Button");
	}

	@FindBy(xpath = "//label[text()='Salesforce CRM Content User']/../..//input")
	private WebElement SalesforceCRMContentUserCheckBox;

	/**
	 * @return the salesforceCRMContentUserCheckBox
	 */
	public WebElement getSalesforceCRMContentUserCheckBox(int timeOut) {
		return isDisplayed(driver, SalesforceCRMContentUserCheckBox, "Visibility", timeOut,
				"Salesforce CRM Content User Check Box");
	}

	@FindBy(xpath = "//h2[contains(text(),'Change Your Password')]")
	private WebElement chnageYourPassword;

	/**
	 * @return the chnageYourPassword
	 */
	public WebElement getChnageYourPassword(int timeOut) {
		return isDisplayed(driver, chnageYourPassword, "Visibility", timeOut, "Change password Text label");
	}

	@FindBy(id = "newpassword")
	private WebElement newPassword;

	/**
	 * @return the newPassword
	 */
	public WebElement getNewPassword(int timeOut) {
		return isDisplayed(driver, newPassword, "Visibility", timeOut, "New password Text Box");
	}

	@FindBy(id = "confirmpassword")
	private WebElement confimpassword;

	/**
	 * @return the confimpassword
	 */
	public WebElement getConfimpassword(int timeOut) {
		return isDisplayed(driver, confimpassword, "Visibility", timeOut, "Confirm password Text Box");
	}

	@FindBy(id = "question")
	private WebElement question;

	/**
	 * @return the question
	 */
	public WebElement getQuestion(int timeOut) {
		return isDisplayed(driver, question, "Visibility", timeOut, "Question drop Doown List");
	}

	@FindBy(id = "answer")
	private WebElement answer;

	/**
	 * @return the answer
	 */
	public WebElement getAnswer(int timeOut) {
		return isDisplayed(driver, answer, "Visibility", timeOut, "Answer Text Box");
	}

	@FindBy(xpath = "//button[contains(text(),' Change Password')]")
	private WebElement changePassword;

	/**
	 * @return the changePassword
	 */
	public WebElement getChangePassword(int timeOut) {
		return isDisplayed(driver, changePassword, "Visibility", timeOut, "Change Password Button");
	}

	@FindBy(xpath = "//li[@id='AllTab_Tab']/a")
	private WebElement allTabBtn;

	/**
	 * @return the allTabBtn
	 */
	public WebElement getAllTabBtn(int timeOut) {
		return isDisplayed(driver, allTabBtn, "Visibility", timeOut, "All Tab Button");
	}

	@FindBy(xpath = "//div[@class='bDescription']/a")
	private WebElement addTabLink;

	/**
	 * @return the addTabLink
	 */
	public WebElement getAddTabLink(int timeOut) {
		return isDisplayed(driver, addTabLink, "Visibility", timeOut, "Add a Tab Link");
	}

	@FindBy(xpath = "//tr[@ class='last detailRow']//table//td[1]/select")
	private WebElement availableTabList;

	/**
	 * @return the availableTabList
	 */
	public WebElement getAvailableTabList(int timeOut) {
		return isDisplayed(driver, availableTabList, "Visibility", timeOut, "Available Tab Drop Down List");
	}

	@FindBy(xpath = "//tr[@ class='last detailRow']//td[2]/div[2]/a")
	private WebElement customTabAddBtn;

	/**
	 * @return the customTabAddBtn
	 */
	public WebElement getCustomTabAddBtn(int timeOut) {
		return isDisplayed(driver, customTabAddBtn, "Visibility", timeOut, "Custom Tab Add Button");
	}

	@FindBy(xpath = "//a//img[@title='Add']")
	private WebElement AddBtn;

	/**
	 * @return the customTabAddBtn
	 */
	public WebElement getAddBtn(int timeOut) {
		return isDisplayed(driver, AddBtn, "Visibility", timeOut, "Custom Tab Add Button");
	}

	@FindBy(xpath = "//a//img[@title='Remove']")
	private WebElement RemoveBtn;

	/**
	 * @return the customTabRemoveBtn
	 */
	public WebElement getRemoveBtn(int timeOut) {
		return isDisplayed(driver, RemoveBtn, "Visibility", timeOut, "Custom Tab Remove Button");
	}

	@FindBy(xpath = "//label[text()='Available Fields']/../following-sibling::select")
	private WebElement availableFieldsLayout;

	public WebElement getavailableFieldsLayout(int timeOut) {
		return isDisplayed(driver, availableFieldsLayout, "Visibility", timeOut, "available Fields on Layout");
	}

	@FindBy(xpath = "//img[@title='Add']")
	private WebElement addButtonForFieldsLayout;

	public WebElement getaddButtonForFieldsLayout(int timeOut) {
		return isDisplayed(driver, addButtonForFieldsLayout, "Visibility", timeOut, "add button Fields on Layout");
	}

	@FindBy(xpath = "//div[@class='pbBottomButtons']//input[@title='Save']")
	private WebElement customTabSaveBtn;

	/**
	 * @return the customTabSaveBtn
	 */
	public WebElement getCustomTabSaveBtn(int timeOut) {
		return isDisplayed(driver, customTabSaveBtn, "Visibility", timeOut, "Custom Tab Save Button");
	}

	public WebElement getCustomTabSaveBtn(String projectName, int timeOut) {

		List<WebElement> eleList = FindElements(driver, "//button[@title='Save' or text()='Save'or @name='SaveEdit']",
				"Save Button");

		for (WebElement webElement : eleList) {
			webElement = isDisplayed(driver, webElement, "Visibility", 2, "Custom Tab Save Button lightning");
			if (webElement != null) {
				return webElement;
			} else {

			}
		}
		return isDisplayed(driver, save_Lightning, "Visibility", timeOut, "Custom Tab Save Button lightning");

	}

	@FindBy(xpath = "//input[@name=\"save\"]")
	private WebElement pageLayoutSaveButton;

	public WebElement pageLayoutSaveButton(String projectName, int timeOut) {
		return isDisplayed(driver, pageLayoutSaveButton, "Visibility", timeOut, "pageLayoutSaveButton");

	}

	@FindBy(xpath = "//button[@name=\"SaveEdit\"]")
	private WebElement fundRaisingSaveButton;

	public WebElement fundRaisingSaveButton(String projectName, int timeOut) {
		return isDisplayed(driver, fundRaisingSaveButton, "Visibility", timeOut, "fundRaisingSaveButton");

	}

	@FindBy(xpath = "//div[@class='slds-modal__footer']//button[@title='Save' or @type='submit']")
	private WebElement fundRaisingpupupSaveButton;

	public WebElement fundRaisingpupupSaveButton(String projectName, int timeOut) {
		return isDisplayed(driver, fundRaisingpupupSaveButton, "Visibility", timeOut,
				"fund Raising pup up Save Button");

	}

	@FindBy(xpath = "//button[text()='Compact Layout Assignment']")
	private WebElement compactLayoutAssignmentLight;

	public WebElement getcompactLayoutAssignmentLight(String projectName, int timeOut) {
		return isDisplayed(driver, compactLayoutAssignmentLight, "Visibility", timeOut,
				"compactLayoutAssignmentLightning button");

	}

	@FindBy(xpath = "//input[@title='Edit Assignment']")
	private WebElement editAssignment;

	public WebElement geteditAssignment(String projectName, int timeOut) {
		return isDisplayed(driver, editAssignment, "Visibility", timeOut, "editAssignment");

	}

	@FindBy(xpath = "//button[text()='Page Layout Assignment']")
	private WebElement pageLayoutAssignment;

	public WebElement getpageLayoutAssignment(String projectName, int timeOut) {
		return isDisplayed(driver, pageLayoutAssignment, "Visibility", timeOut, "editAssignment");

	}

	@FindBy(xpath = "//select[@id='defaultCompactLayoutSelector']")
	private WebElement defaultCompactLayout;

	public WebElement getdefaultCompactLayoutDropdown(String projectName, int timeOut) {
		return isDisplayed(driver, defaultCompactLayout, "Visibility", timeOut, "defaultCompactLayout");

	}

	@FindBy(xpath = "//button[text()='Save' and @name='SaveEdit']")
	private WebElement save_Lightning;

	@FindBy(xpath = "//input[@placeholder='Search all items...']")
	private WebElement searchTabTextbox;

	public WebElement getsearchTabTextbox(int timeOut) {
		return isDisplayed(driver, searchTabTextbox, "Visibility", timeOut, "search Tab Textbox");

	}

	@FindBy(xpath = "//tr[@ class='last detailRow']//table//td[3]/select")
	private WebElement customTabSelectedList;

	/**
	 * @return the customTabSelectedList
	 */
	public WebElement getCustomTabSelectedList(int timeOut) {
		return isDisplayed(driver, customTabSelectedList, "Visibility", timeOut, "Custom Tab Selected List");
	}

	@FindBy(xpath = "//tr[@ class='last detailRow']//td[2]/div[3]/a")
	private WebElement customTabRemoveBtn;

	/**
	 * @return the customTabRemoveBtn
	 */
	public WebElement getCustomTabRemoveBtn(int timeOut) {
		return isDisplayed(driver, customTabRemoveBtn, "Visibility", timeOut, "Custom Tab Remove Button");
	}

	@FindBy(xpath = "//a[@title='Navatar Investor Manager Tab']")
	private WebElement navatarInvestorManagerTab;

	/**
	 * @return the navatarInvestorManagerTab
	 */
	public WebElement getNavatarInvestorManagerTab(int timeOut) {
		return isDisplayed(driver, navatarInvestorManagerTab, "Visibility", timeOut, "Navatar Investor Manager Tab");
	}

	@FindBy(xpath = "//button[contains(@class,'userProfile')]/div")
	private WebElement salesForceLightingIcon;

	/**
	 * @return the salesForceLightingIcon
	 */
	public WebElement getSalesForceLightingIcon(int timeOut) {
		return isDisplayed(driver, salesForceLightingIcon, "Visibility", timeOut, "Sales Force Lighting Icon");
	}

	@FindBy(xpath = "//div[contains(@class,'userProfilePanel')]//a[contains(@class,'switch-to-aloha')]")
	private WebElement switchToClassic;

	/**
	 * @return the switchToClassic
	 */
	public WebElement getSwitchToClassic(int timeOut) {
		return isDisplayed(driver, switchToClassic, "Visibility", timeOut, "Sales force switch to classic mode");
	}

	@FindBy(xpath = "//img[@name='Workspace']")
	private WebElement workspaceExpandIcon;

	/**
	 * @return the workspaceExpandIcon
	 */
	public WebElement getWorkspaceExpandIcon(int timeOut) {
		return isDisplayed(driver, workspaceExpandIcon, "Visibility", timeOut, "Workspace Expand Icon");
	}

	@FindBys(@FindBy(xpath = "//span[@id='setupErrorFR']"))
	private List<WebElement> getErrorMessageOnAllPages;

	/**
	 * @return the errorMessageBeforeAdminRegistrationOnAllPages
	 */

	public List<WebElement> getErrorMessageOnAllPages(int timeOut) {
		if (checkElementsVisibility(driver, getErrorMessageOnAllPages, "Error Messages", timeOut)) {
			return getErrorMessageOnAllPages;
		} else {
			return null;
		}
	}

	public WebElement getFolderTypeRadioButton(FolderType folderType, Workspace workspace, PageName pageName,
			int timeOut) {
		String workspaceSelector = "";
		if (folderType.toString().equalsIgnoreCase(FolderType.Common.toString())
				&& pageName.toString().equalsIgnoreCase(PageName.NavatarInvestorManager.toString())) {
			folderType = FolderType.Global;
		}
		String xpath = "//input[@id='chk" + folderType.toString() + "Folder']";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "BWFR";
			} else {
				workspaceSelector = "BWINV";
			}
			xpath = "//input[@id='chk" + folderType.toString() + "Folder" + workspaceSelector + "']";
		} else if (pageName.toString().equalsIgnoreCase(PageName.ManageFolderPopUp.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "fundraising";
			} else {
				workspaceSelector = "investor";
			}
			xpath = "//input[@id='checkbox" + folderType.toString().toLowerCase() + "_grid1" + workspaceSelector + "']";
		}
		return isDisplayed(driver,
				FindElement(driver, xpath, folderType.toString() + " Folder Radio button", action.BOOLEAN, timeOut),
				"Visibility", timeOut, folderType.toString() + " Folder Radio button");
	}

	public WebElement getParentFolderNameTextBox(Workspace workspace, PageName pageName, int timeOut) {
		String workspaceSelector = "";
		String xpath = "//input[@id='txtParentFolderName']";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "BWFR";
			} else {
				workspaceSelector = "BWINV";
			}
			xpath = "//input[@id='txtParentFolderName" + workspaceSelector + "']";
		} else if (pageName.toString().equalsIgnoreCase(PageName.ManageFolderPopUp.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "fundraising";
			} else {
				workspaceSelector = "investor";
			}
			xpath = "//input[@id='foldecommonaddfund" + workspaceSelector + "']";
		}
		return isDisplayed(driver, FindElement(driver, xpath, "Parent Folder Name Text Box", action.BOOLEAN, timeOut),
				"Visibility", timeOut, "Parent Folder Name Text Box");
	}

	public WebElement getParentFolderSaveButton(Workspace workspace, PageName pageName, int timeOut) {
		String workspaceSelector = "";
		String xpath = "//a[contains(@onclick,'checkAndCreateFolder')][contains(@onclick,'txtParentFolderName')]";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "BWFR";
			} else {
				workspaceSelector = "BWINV";
			}
			xpath = "//a[contains(@onclick,'checkAndCreateFolder" + workspaceSelector
					+ "')][contains(@onclick,'txtParentFolderName" + workspaceSelector + "')]";
		} else if (pageName.toString().equalsIgnoreCase(PageName.ManageFolderPopUp.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "fundraising";
			} else {
				workspaceSelector = "investor";
			}
			xpath = "//a[contains(@onclick,'CreateCommon_pop1" + workspaceSelector + "();')]";
		}
		return isDisplayed(driver, FindElement(driver, xpath, "Parent Folder Save Button", action.BOOLEAN, timeOut),
				"Visibility", timeOut, "Parent Folder Save Button");
	}

	public WebElement getChildFolderNameTextBox(Workspace workspace, PageName pageName, int timeOut) {
		String workspaceSelector = "";
		String xpath = "//input[@id='txtChildFolderName']";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "BWFR";
			} else {
				workspaceSelector = "BWINV";
			}
			xpath = "//input[@id='txtChildFolderName" + workspaceSelector + "']";
		} else if (pageName.toString().equalsIgnoreCase(PageName.ManageFolderPopUp.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "fundraising";
			} else {
				workspaceSelector = "investor";
			}
			xpath = "//input[@id='foldernameaddfundr2" + workspaceSelector + "']";
		}
		return isDisplayed(driver, FindElement(driver, xpath, "Child Folder Name Text Box", action.BOOLEAN, timeOut),
				"Visibility", timeOut, "child Folder Name Text Box");
	}

	public WebElement getParentRenameFolderNameTextBox(Workspace workspace, PageName pageName, int timeOut) {
		String workspaceSelector = "";
		String xpath = "";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())
				|| pageName.toString().equalsIgnoreCase(PageName.BuildStep2Of3.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "FR";
			} else {
				workspaceSelector = "INV";
			}
			xpath = "//input[@id='txtRenameFolderBW" + workspaceSelector + "']";
		} else if (pageName.toString().equalsIgnoreCase(PageName.ManageFolderPopUp.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "fundraising";
			} else {
				workspaceSelector = "investor";
			}
			xpath = "//input[@id='renamefol_pop1" + workspaceSelector + "']";
		}
		return isDisplayed(driver,
				FindElement(driver, xpath, "parent rename Folder Name Text Box", action.BOOLEAN, timeOut), "Visibility",
				timeOut, "parent rename Folder Name Text Box");
	}

	public WebElement getChildRenameFolderNameTextBox(Workspace workspace, PageName pageName, int timeOut) {
		String workspaceSelector = "";
		String xpath = "";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())) {
			// code needs to be write
		} else if (pageName.toString().equalsIgnoreCase(PageName.ManageFolderPopUp.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "fundraising";
			} else {
				workspaceSelector = "investor";
			}
			xpath = "//input[@id='renamefol_pop1" + workspaceSelector + "']";
		}
		return isDisplayed(driver,
				FindElement(driver, xpath, "parent rename Folder Name Text Box", action.BOOLEAN, timeOut), "Visibility",
				timeOut, "parent rename Folder Name Text Box");
	}

	public WebElement getCreatedFolderWebelement(String folderPath, PageName pageName, int timeOut) {
		WebElement ele = null;
		String folderStruct[] = folderPath.split("/");
		if (folderStruct.length == 1) {
			ele = isDisplayed(driver, FindElement(driver,
					"//span[contains(text(),'All Folders')]/span/../../../following-sibling::ul/li/div//label[contains(text(),'"
							+ folderStruct[0] + "')]",
					" created folder", action.SCROLLANDBOOLEAN, timeOut), "visibility", timeOut, "created folder");
		} else {
			ele = isDisplayed(driver, FindElement(driver,
					"//span[contains(text(),'All Folders')]/span/../../../following-sibling::ul/li/div//label[contains(text(),'"
							+ folderStruct[0] + "')]/../../../following-sibling::ul/li/div//label[contains(text(),'"
							+ folderStruct[1] + "')]",
					"created sub folder", action.SCROLLANDBOOLEAN, timeOut), "visibility", timeOut,
					"created sub folder");
		}
		return ele;
	}

	public WebElement getChildFolderSaveButton(Workspace workspace, PageName pageName, int timeOut) {
		String workspaceSelector = "";
		String xpath = "(//a[contains(@onclick,'checkAndCreateFolder')])[2]";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "BWFR";
			} else {
				workspaceSelector = "BWINV";
			}
			xpath = "//a[contains(@onclick,'checkAndCreateFolder" + workspaceSelector
					+ "')][contains(@id,'btnSubFolderSave')]";
		} else if (pageName.toString().equalsIgnoreCase(PageName.ManageFolderPopUp.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "fundraising";
			} else {
				workspaceSelector = "investor";
			}
			xpath = "//a[contains(@onclick,'CreateFolder_pop1" + workspaceSelector + "();')]";
		}
		return isDisplayed(driver, FindElement(driver, xpath, "Parent Folder Save Button", action.BOOLEAN, timeOut),
				"Visibility", timeOut, "Parent Folder Save Button");
	}

	public WebElement getParentFolderErrorMsg(Workspace workspace, PageName pageName, ErrorMessageType ErrorMessageType,
			int timeOut) {
		String workspaceSelector = "";
		String xpath = "";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())) {
			// code need to be write for fund page
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "FR";
			} else {
				workspaceSelector = "INV";
			}
			if (ErrorMessageType.toString().equalsIgnoreCase(ErrorMessageType.BlankErrorMsg.toString())) {
				xpath = "//span[@id='err1stLvlFolderBW" + workspaceSelector + "']";
			} else if (ErrorMessageType.toString().equalsIgnoreCase(ErrorMessageType.PrefixErrorMsg.toString())) {
				xpath = "//span[@id='err1stLvlFolderForCommonBW" + workspaceSelector + "']";
			} else if (ErrorMessageType.toString().equalsIgnoreCase(ErrorMessageType.SpiecalCharErrorMsg.toString())) {
				xpath = "//span[@id='errforInvalidCharFirstFundBW" + workspaceSelector + "']";
			} else if (ErrorMessageType.toString()
					.equalsIgnoreCase(ErrorMessageType.FolderCreationRestrictionErrorMsg.toString())) {
				xpath = "//div[@id='errMsgSecondCommonFolderBW" + workspaceSelector + "']";
			} else {
				xpath = "//div[@id='errMsgDupFolderBW" + workspaceSelector + "']";
			}
		} else if (pageName.toString().equalsIgnoreCase(PageName.ManageFolderPopUp.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "fundraising";
			} else {
				workspaceSelector = "investor";
			}
			if (ErrorMessageType.toString().equalsIgnoreCase(ErrorMessageType.BlankErrorMsg.toString())) {
				xpath = "//span[@id='errorfoldecommonaddfund" + workspaceSelector + "']";
			} else if (ErrorMessageType.toString().equalsIgnoreCase(ErrorMessageType.PrefixErrorMsg.toString())) {
				xpath = "//span[@id='errorfoldecommonaddfund22" + workspaceSelector + "']";
			} else if (ErrorMessageType.toString().equalsIgnoreCase(ErrorMessageType.SpiecalCharErrorMsg.toString())) {
				xpath = "//span[@id='errforInvalidCharFirst1" + workspaceSelector + "']";
			} else if (ErrorMessageType.toString()
					.equalsIgnoreCase(ErrorMessageType.FolderCreationRestrictionErrorMsg.toString())) {
				xpath = "//div[@id='CommonError1investor']//p";
			}
		}
		return isDisplayed(driver, FindElement(driver, xpath, "Folder Error Message", action.BOOLEAN, timeOut),
				"Visibility", timeOut, "Folder Error Message");
	}

	public WebElement getSubFolderErrorMsg(Workspace workspace, PageName pageName, ErrorMessageType ErrorMessageType,
			int timeOut) {
		String workspaceSelector = "";
		String xpath = "";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())) {
			// code need to be write for fund page
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "FR";
			} else {
				workspaceSelector = "INV";
			}
			if (ErrorMessageType.toString().equalsIgnoreCase(ErrorMessageType.BlankErrorMsg.toString())) {
				xpath = "//span[@id='errSubFolderNameBW" + workspaceSelector + "']";
			} else if (ErrorMessageType.toString().equalsIgnoreCase(ErrorMessageType.PrefixErrorMsg.toString())) {
				xpath = "//span[@id='errSubFolderNameforCommonBW" + workspaceSelector + "']";
			} else if (ErrorMessageType.toString().equalsIgnoreCase(ErrorMessageType.SpiecalCharErrorMsg.toString())) {
				xpath = "//span[@id='errforInvalidCharSubFundBW" + workspaceSelector + "']";
			} else {
				xpath = "//span[@id='errDupSubFolderNameBW" + workspaceSelector + "']";
			}
		} else if (pageName.toString().equalsIgnoreCase(PageName.ManageFolderPopUp.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "fundraising";
			} else {
				workspaceSelector = "investor";
			}
			if (ErrorMessageType.toString().equalsIgnoreCase(ErrorMessageType.BlankErrorMsg.toString())) {
				xpath = "//span[@id='errorfoldernameaddfundr2" + workspaceSelector + "']";
			} else if (ErrorMessageType.toString().equalsIgnoreCase(ErrorMessageType.PrefixErrorMsg.toString())) {
				xpath = "//span[@id='errorfoldernameaddfundr2" + workspaceSelector + "22']";
			} else if (ErrorMessageType.toString().equalsIgnoreCase(ErrorMessageType.SpiecalCharErrorMsg.toString())) {
				xpath = "//span[@id='addsubInvalid1" + workspaceSelector + "']";
			}
		}
		return isDisplayed(driver, FindElement(driver, xpath, "Sub Folder Error Message", action.BOOLEAN, timeOut),
				"Visibility", timeOut, "Sub Folder Error Message");
	}

	public WebElement getParentRenameFolderErrorMsg(Workspace workspace, PageName pageName,
			ErrorMessageType ErrorMessageType, int timeOut) {
		String workspaceSelector = "";
		String xpath = "";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())
				|| pageName.toString().equalsIgnoreCase(PageName.BuildStep2Of3.toString())) {
			// code need to be write for fund page
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "FR";
			} else {
				workspaceSelector = "INV";
			}
			if (ErrorMessageType.toString().equalsIgnoreCase(ErrorMessageType.BlankErrorMsg.toString())) {
				xpath = "//span[@id='errRenFolderNameBW" + workspaceSelector + "']";
			} else if (ErrorMessageType.toString().equalsIgnoreCase(ErrorMessageType.PrefixErrorMsg.toString())) {
//				xpath = "//span[@id='errRenFolderNameForCommonBW"+workspaceSelector+"11']";
				xpath = "//span[@id='errRenFolderNameForCommonBW" + workspaceSelector + "']";
			} else if (ErrorMessageType.toString().equalsIgnoreCase(ErrorMessageType.SpiecalCharErrorMsg.toString())) {
				xpath = "//span[@id='errforCharRenameBW" + workspaceSelector + "']";
			}
		} else if (pageName.toString().equalsIgnoreCase(PageName.ManageFolderPopUp.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "fundraising";
			} else {
				workspaceSelector = "investor";
			}
			if (ErrorMessageType.toString().equalsIgnoreCase(ErrorMessageType.BlankErrorMsg.toString())) {
				xpath = "//span[@id='errorrenamefol_pop1" + workspaceSelector + "']";
			} else if (ErrorMessageType.toString().equalsIgnoreCase(ErrorMessageType.PrefixErrorMsg.toString())) {
//				xpath = "//span[@id='errorrenamefol_pop1"+workspaceSelector+"11']";
				xpath = "//span[@id='errorrenamefol_pop1" + workspaceSelector + "']";
			} else if (ErrorMessageType.toString().equalsIgnoreCase(ErrorMessageType.SpiecalCharErrorMsg.toString())) {
				xpath = "//span[@id='renameInvalid1" + workspaceSelector + "']";
			}
		}
		return isDisplayed(driver, FindElement(driver, xpath, "Rename Folder Error Message", action.BOOLEAN, timeOut),
				"Visibility", timeOut, "Rename Folder Error Message");
	}

	public WebElement getParentRenameFolderSaveButton(Workspace workspace, PageName pageName, int timeOut) {
		String workspaceSelector = "";
		String xpath = "(//a[contains(@onclick,'checkAndCreateFolder')])[2]";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())
				|| pageName.toString().equalsIgnoreCase(PageName.BuildStep2Of3.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "FR";
			} else {
				workspaceSelector = "INV";
			}
			if (pageName.toString().equalsIgnoreCase(PageName.BuildStep2Of3.toString())) {
				xpath = "//a[contains(@onclick,'saveRenameFolderBW" + workspaceSelector + "()')]";
			} else {
				xpath = "//a[contains(@onclick,'saveRenameFolderBW" + workspaceSelector + "();')]";
			}
		} else if (pageName.toString().equalsIgnoreCase(PageName.ManageFolderPopUp.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "fundraising";
			} else {
				workspaceSelector = "investor";
			}
			xpath = "//a[contains(@onclick,'Save_Rename_folder_pop1" + workspaceSelector + "();')]";
		}
		return isDisplayed(driver,
				FindElement(driver, xpath, "Parent Rename Folder Save Button", action.BOOLEAN, timeOut), "Visibility",
				timeOut, "Parent Rename Folder Save Button");
	}

	public WebElement getParentRenameFolderCrossIcon(Workspace workspace, PageName pageName, int timeOut) {
		String workspaceSelector = "";
		String xpath = "";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())) {
			// needs to be write
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "FR";
			} else {
				workspaceSelector = "INV";
			}
//			xpath = "//span[contains(@onclick,'clearTextBW"+workspaceSelector+"(') and contains(@onclick,'rename')  and contains(@onclick,';')]";
			xpath = "//a[contains(@onclick,'clearTextBW" + workspaceSelector
					+ "(') and contains(@onclick,'rename')  and contains(@onclick,';')]";
		} else if (pageName.toString().equalsIgnoreCase(PageName.ManageFolderPopUp.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "fundraising";
			} else {
				workspaceSelector = "investor";
			}
			xpath = "//span[contains(@onclick,'closeRenamepop1" + workspaceSelector + "()')]";
		}
		return isDisplayed(driver,
				FindElement(driver, xpath, "Parent Rename Folder Cross Icon", action.BOOLEAN, timeOut), "Visibility",
				timeOut, "Parent Rename Folder Cross Icon");
	}

	public WebElement getParentRenameFolderCancelButton(Workspace workspace, PageName pageName, int timeOut) {
		String workspaceSelector = "";
		String xpath = "";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())) {
			// needs to be write
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "FR";
			} else {
				workspaceSelector = "INV";
			}
			xpath = "//a[contains(@onclick,'clearTextBW" + workspaceSelector
					+ "(')  and contains(@onclick,'rename')  and contains(@title,'Cancel') ]";
		} else if (pageName.toString().equalsIgnoreCase(PageName.ManageFolderPopUp.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "fundraising";
			} else {
				workspaceSelector = "investor";
			}
			xpath = "//a[contains(@onclick,'closeRenamepop1" + workspaceSelector + "();')]";
		}
		return isDisplayed(driver,
				FindElement(driver, xpath, "Parent Rename Folder cancel button", action.BOOLEAN, timeOut), "Visibility",
				timeOut, "Parent Rename Folder Cancel button");
	}

	public WebElement getFolderErrorMsg(Workspace workspace, PageName pageName, ErrorMessageType ErrorMessageType,
			FolderType Foldertype, int timeOut) {
		String workspaceSelector = "";
		String xpath = "";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())) {
			// code need to be write for fund page
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				if (Foldertype.toString().equalsIgnoreCase(FolderType.Common.toString())) {
					xpath = "//div[@id='errMsgSecondCommonFolderBWFR']";
				} else {
					xpath = "//div[@id='errMsgSecondInternalFolderBWFR']";
				}

			} else {
				if (Foldertype.toString().equalsIgnoreCase(FolderType.Common.toString())) {
					xpath = "//div[@id='errMsgSecondCommonFolderBWINV']";
				} else {
					xpath = "//div[@id='errMsgSecondInternalFolderBWINV']";
				}
			}
		} else if (pageName.toString().equalsIgnoreCase(PageName.ManageFolderPopUp.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				if (Foldertype.toString().equalsIgnoreCase(FolderType.Common.toString())) {
					workspaceSelector = "1fundraising";
				} else {
					workspaceSelector = "2fundraising";
				}

			} else {
				if (Foldertype.toString().equalsIgnoreCase(FolderType.Common.toString())) {
					workspaceSelector = "1investor";
				} else {
					workspaceSelector = "2investor";
				}
			}
			xpath = "//div[@id='CommonError" + workspaceSelector + "']//p";
		}
		return isDisplayed(driver, FindElement(driver, xpath, "Folder Error Message", action.BOOLEAN, timeOut),
				"Visibility", timeOut, "Folder Error Message");
	}

	public WebElement getFolderCreationErrorMessageCrossIcon(Workspace workspace, PageName pageName,
			FolderType Foldertype, int timeOut) {
		String workspaceSelector = "";
		String xpath = "";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				if (Foldertype.toString().equalsIgnoreCase(FolderType.Common.toString())) {
					xpath = "//div[@id='errMsgSecondCommonFolderBWFR']/../preceding-sibling::div[1]/a";
				} else {
					xpath = "//div[@id='errMsgSecondInternalFolderBWFR']/../preceding-sibling::div[1]/a";
				}
			} else {
				if (Foldertype.toString().equalsIgnoreCase(FolderType.Common.toString())) {
					xpath = "//div[@id='errMsgSecondCommonFolderBWINV']/../preceding-sibling::div[1]/a";
				} else {
					xpath = "//div[@id='errMsgSecondInternalFolderBWINV']/../preceding-sibling::div[1]/a";
				}
			}
		} else if (pageName.toString().equalsIgnoreCase(PageName.ManageFolderPopUp.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				if (Foldertype.toString().equalsIgnoreCase(FolderType.Common.toString())) {
					workspaceSelector = "1fundraising";
				} else {
					workspaceSelector = "2fundraising";
				}

			} else {
				if (Foldertype.toString().equalsIgnoreCase(FolderType.Common.toString())) {
					workspaceSelector = "1investor";
				} else {
					workspaceSelector = "2investor";
				}
			}
			xpath = "(//div[@id='CommonError" + workspaceSelector + "']//a)[1]";
		}
		return isDisplayed(
				driver, FindElement(driver, xpath, "folder creation error message cross icon on parent level",
						action.BOOLEAN, timeOut),
				"Visibility", timeOut, "folder creation error message cross icon on parent level");
	}

	public WebElement getFolderCreationErrorMessageOkBtn(Workspace workspace, PageName pageName, FolderType Foldertype,
			int timeOut) {
		String workspaceSelector = "";
		String xpath = "";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())) {
			// code need to be write for fund page
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				if (Foldertype.toString().equalsIgnoreCase(FolderType.Common.toString())) {
					xpath = "//div[@id='errMsgSecondCommonFolderBWFR']/../following-sibling::div[1]/a";
				} else {
					xpath = "//div[@id='errMsgSecondInternalFolderBWFR']/../following-sibling::div[1]/a";
				}
			} else {
				if (Foldertype.toString().equalsIgnoreCase(FolderType.Common.toString())) {
					xpath = "//div[@id='errMsgSecondCommonFolderBWINV']/../following-sibling::div[1]/a";
				} else {
					xpath = "//div[@id='errMsgSecondInternalFolderBWINV']/../following-sibling::div[1]/a";
				}
			}
		} else if (pageName.toString().equalsIgnoreCase(PageName.ManageFolderPopUp.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				if (Foldertype.toString().equalsIgnoreCase(FolderType.Common.toString())) {
					workspaceSelector = "1fundraising";
				} else {
					workspaceSelector = "2fundraising";
				}

			} else {
				if (Foldertype.toString().equalsIgnoreCase(FolderType.Common.toString())) {
					workspaceSelector = "1investor";
				} else {
					workspaceSelector = "2investor";
				}
			}
			xpath = "(//div[@id='CommonError" + workspaceSelector + "']//a)[2]";
		}
		return isDisplayed(
				driver, FindElement(driver, xpath, "folder creation error message OK button on parent level",
						action.BOOLEAN, timeOut),
				"Visibility", timeOut, "folder creation error message Ok button on parent level");
	}

	public WebElement getFolderDeleteYesBtn(Workspace workspace, PageName pageName, int timeOut) {
		String workspaceSelector = "";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "FR";
			} else {
				workspaceSelector = "INV";
			}
			return isDisplayed(driver,
					FindElement(driver, "//a[@onclick='deleteFolderBW" + workspaceSelector + "();']",
							"delete yes button", action.SCROLLANDBOOLEAN, timeOut),
					"visibility", timeOut, "delete yes button");
		} else {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "fundraising";
			} else {
				workspaceSelector = "investor";
			}
			return isDisplayed(driver,
					FindElement(driver, "//div[@id='deletefolderpopup1" + workspaceSelector + "']//a[text()='Yes']",
							"delete yes button", action.SCROLLANDBOOLEAN, timeOut),
					"visibility", timeOut, "delete yes button");
		}
	}

	public WebElement getFolderDeleteNoBtn(Workspace workspace, PageName pageName, int timeOut) {
		String workspaceSelector = "";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "FR";
			} else {
				workspaceSelector = "INV";
			}
			return isDisplayed(driver,
					FindElement(driver, "//a[contains(@onclick,'idConfirmDeletionBW" + workspaceSelector + "')]",
							"folder delete No button", action.SCROLLANDBOOLEAN, timeOut),
					"visibility", timeOut, "folder delete No button");
		} else {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "fundraising";
			} else {
				workspaceSelector = "investor";
			}
			return isDisplayed(driver,
					FindElement(driver, "//a[contains(@onclick,'closeaddpop1" + workspaceSelector + "();')]",
							"folder delete No button", action.SCROLLANDBOOLEAN, timeOut),
					"visibility", timeOut, "folder delete No button");
		}
	}

	public WebElement getFolderDeleteCrossIcon(Workspace workspace, PageName pageName, int timeOut) {
		String workspaceSelector = "";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "FR";
			} else {
				workspaceSelector = "INV";
			}
			return isDisplayed(driver,
					FindElement(driver, "//span[contains(@onclick,'idConfirmDeletionBW" + workspaceSelector + "')]",
							"folder delete Cross Icon", action.SCROLLANDBOOLEAN, timeOut),
					"visibility", timeOut, "folder delete Cross Icon");
		} else {

			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "fundraising";
			} else {
				workspaceSelector = "investor";
			}
			return isDisplayed(driver,
					FindElement(driver, "//a[contains(@onclick,'closeaddpop1" + workspaceSelector + "();')]",
							"folder delete Cross Icon", action.SCROLLANDBOOLEAN, timeOut),
					"visibility", timeOut, "folder delete Cross Icon");
		}
	}

	public WebElement getFolderDeleteErrorMsg1(Workspace workspace, PageName pageName, int timeOut) {
		String workspaceSelector = "";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "FR";
			} else {
				workspaceSelector = "INV";
			}
			return isDisplayed(driver,
					FindElement(driver,
							"//span[contains(@onclick,'idConfirmDeletionBW" + workspaceSelector
									+ "')]/../following-sibling::p",
							"folder delete Error Message1", action.SCROLLANDBOOLEAN, timeOut),
					"visibility", timeOut, "folder delete Error Message1");
		} else {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "fundraising";
			} else {
				workspaceSelector = "investor";
			}
			return isDisplayed(driver,
					FindElement(driver, "//div[@id='deletefolderpopup1" + workspaceSelector + "content']/p[1]",
							"folder delete Error Message1", action.SCROLLANDBOOLEAN, timeOut),
					"visibility", timeOut, "folder delete Error Message1");
		}
	}

	public WebElement getFolderDeleteErrorMsg2(Workspace workspace, int timeOut) {
		String workspaceSelector = "";
		if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
			workspaceSelector = "fundraising";
		} else {
			workspaceSelector = "investor";
		}
		return isDisplayed(driver,
				FindElement(driver, "//div[@id='deletefolderpopup1" + workspaceSelector + "content']/p[2]",
						"folder delete Error Message2", action.SCROLLANDBOOLEAN, timeOut),
				"visibility", timeOut, "folder delete Error Message2");
	}

	@FindBy(xpath = "//iframe[contains(@title,'PE_Fund_NothingEnabled')]")
	private WebElement fundPageFrame;
	
	@FindBy(xpath = "//iframe[contains(@title,'Activity Settings')]")
	private WebElement activitySettingFrame;
	
	@FindBy(xpath = "//iframe[contains(@title,'Salesforce - Enterprise Edition')]")
	private WebElement enterpriseeditionFrame;

	@FindBy(xpath = "//iframe[@title='Investor_Portal_Institution_Enabled']")
	private WebElement institutionPageFrame;

	@FindBy(xpath = "//iframe[@title='Investor_Portal_Contact_Enabled']")
	private WebElement contactPageFrame;

	@FindBy(xpath = "//iframe[contains(@title,'Investor_Portal_Commitment_Enabled')]")
	private WebElement commitmentPageFrame;
	@FindBy(xpath = "//iframe[contains(@title,'Task Compact Layout')]")
	private WebElement compactLayoutFrame;

//	 @FindBy(xpath="//iframe[@id='PEDisclaimersSetup']")
//	 private WebElement navatarInvestorAddOnFrame;

	@FindBy(xpath = "//iframe[@title='InvestorPortal_Alerts']")
	private WebElement homePageAlertsFrame;

	@FindBy(xpath = "//iframe[@id='theIframe']")
	private WebElement NIMTabFrame;

	@FindBy(xpath = "//iframe[@id='NavatarInvestorAddOns']")
	private WebElement navatarInvestorAddOnFrame;

	@FindBy(xpath = "//iframe[@title='TaskRay']")
	private WebElement taskRayPageFrame;

	@FindBy(xpath = "//iframe[@title='TaskRay']")
	private WebElement taskRayTabFrame;

	@FindBy(xpath = "//iframe[@id='project-details-frame']")
	private WebElement projectDetailsPopUpFrame;

	@FindBy(xpath = "//iframe[@title='accessibility title']")
	private WebElement taskPageFrame;

	@FindBy(xpath = "//iframe[contains(@title,'Activity Custom Field')]")
	private WebElement activityLayoutFrame;
	@FindBy(xpath = "//iframe[contains(@title,'Account Custom Field')]")
	private WebElement accountLayoutFrame;
	@FindBy(xpath = "//div[contains(@class,'windowViewMode-maximized')]//iframe[contains(@title,'Salesforce - Enterprise Edition')]")
	private WebElement pipelineLayoutFrame;
	@FindBy(xpath = "//iframe[contains(@title,'Convert to Portfolio')]")
	private WebElement convertToPortfolioFrame;

	@FindBy(xpath = "//iframe[contains(@title,'Picklist Edit: ')]")
	private WebElement statusPicklistFrame;
	@FindBy(xpath = "//iframe[contains(@title,'Sharing Settings ~ Salesforce - Enterprise Edition')]")
	private WebElement sharingSettingsFrame;
	@FindBy(xpath = "//iframe[contains(@title,'Navigation Custom Field: Navigation Type')]")
	private WebElement customNavigationFrame;
	@FindBy(xpath = "//iframe[contains(@title,'Add Picklist Values: Navigation Type')]")
	private WebElement NavigationPickListFrame;
	@FindBy(xpath = "//iframe[contains(@title,'Affiliation Custom Field: Role ~ Salesforce - Enterprise Edition')]")
	private WebElement affiliationFrame;
	@FindBy(xpath = "//iframe[contains(@title,'Fundraising Contact Custom Field: Role ~ Salesforce - Enterprise Edition')]")
	private WebElement fundRaisingFrame;
	@FindBy(xpath = "//iframe[contains(@title,'Financing Custom Field: Lender Status ~ Salesforce - Enterprise Edition')]")
	private WebElement financingFrame;

	public WebElement getstatusPicklistFrame(int timeOut) {
		return isDisplayed(driver, statusPicklistFrame, "Visibility", timeOut, "status Picklist Frame");
	}
	
	public WebElement getActivitySettingFrame(int timeOut) {
		return isDisplayed(driver, activitySettingFrame, "Visibility", timeOut, "activity Setting Frame");
	}
	
	public WebElement getenterpriseeditionFrame(int timeOut) {
		return isDisplayed(driver, enterpriseeditionFrame, "Visibility", timeOut, "enterprise edition Frame");
	}

	@FindBy(xpath = "//iframe[contains(@title,'Visualforce Pages')]")
	private WebElement visualforcePageFrame;

	/**
	 * @author Ankit Jaiswal
	 * @param pageName
	 * @param timeOut
	 * @return webelement/null
	 */
	public WebElement getFrame(PageName pageName, int timeOut) {
		WebElement ele = null;
		if (pageName.toString().equalsIgnoreCase(PageName.InstitutionsPage.toString())) {
			ele = isDisplayed(driver, institutionPageFrame, "Visibility", timeOut, pageName + " frame");
		} else if (pageName.toString().equalsIgnoreCase(PageName.Object2Page.toString())) {
			ele = isDisplayed(driver, contactPageFrame, "Visibility", timeOut, pageName + " frame");
		} else if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())) {
			ele = isDisplayed(driver, fundPageFrame, "Visibility", timeOut, pageName + " frame");
		} else if (pageName.toString().equalsIgnoreCase(PageName.CommitmentsPage.toString())) {
			ele = isDisplayed(driver, commitmentPageFrame, "Visibility", timeOut, pageName + " frame");
		} else if (pageName.toString().equalsIgnoreCase(PageName.HomePage.toString())) {
			ele = isDisplayed(driver, homePageAlertsFrame, "Visibility", timeOut, pageName + " frame");
		} else if (pageName.toString().equalsIgnoreCase(PageName.TaskRayPage.toString())) {
			ele = isDisplayed(driver, taskRayPageFrame, "Visibility", timeOut, pageName + " frame");
		} else if (pageName.toString().equalsIgnoreCase(PageName.NavatarInvestorAddOnsPage.toString())) {
			ele = isDisplayed(driver, navatarInvestorAddOnFrame, "Visibility", timeOut, pageName + " frame");
		} else if (pageName.toString().equalsIgnoreCase(PageName.NavatarInvestorManager.toString())) {
			ele = isDisplayed(driver, NIMTabFrame, "Visibility", timeOut, "NIM Frame");
		} else if (pageName.toString().equalsIgnoreCase(PageName.TaskRayPage.toString())) {
			ele = isDisplayed(driver, taskRayTabFrame, "Visibility", timeOut, "TaskRay Frame");
		} else if (pageName.toString().equalsIgnoreCase(PageName.ProjectDetailsPoPUp.toString())) {
			ele = isDisplayed(driver, projectDetailsPopUpFrame, "Visibility", timeOut, "Project Details PoPUp Frame");
		} else if (pageName.toString().equalsIgnoreCase(PageName.TaskPage.toString())) {
			ele = isDisplayed(driver, taskPageFrame, "Visibility", timeOut, "Project Details PoPUp Frame");
		} else if (pageName.toString().equalsIgnoreCase(PageName.ActivitiesOrMeetings.toString())) {
			ele = isDisplayed(driver, meetingOrActivitiesFrame, "Visibility", timeOut, "meeting or activties Frame");
		} else if (pageName.toString().equalsIgnoreCase(PageName.EmailUploadPage.toString())) {
			ele = isDisplayed(driver, emailUploadPageFrame, "Visibility", timeOut, "meeting or activties Frame");
		} else if (pageName.toString().equalsIgnoreCase(PageName.CompactLayout.toString())) {
			ele = isDisplayed(driver, compactLayoutFrame, "Visibility", timeOut, "meeting or activties Frame");
		} else if (pageName.toString().equalsIgnoreCase(PageName.ActivityLayoutPage.toString())) {
			ele = isDisplayed(driver, activityLayoutFrame, "Visibility", timeOut, "meeting or activties Frame");
		} else if (pageName.toString().equalsIgnoreCase(PageName.VisualForcePage.toString())) {
			ele = isDisplayed(driver, visualforcePageFrame, "Visibility", timeOut, "visual force page frame");
		} else if (pageName.toString().equalsIgnoreCase(PageName.MeetingType.toString())) {
			ele = isDisplayed(driver, meetingTypeFrame, "Visibility", timeOut, "meeting or activties Frame");
		} else if (pageName.toString().equalsIgnoreCase(PageName.AddPickListMeetingType.toString())) {
			ele = isDisplayed(driver, addPickListMeetingTypeFrame, "Visibility", timeOut,
					"Add PickList meeting or activties Frame");
		} else if (pageName.toString().equalsIgnoreCase(PageName.AccountCustomFieldStatusPage.toString())) {
			ele = isDisplayed(driver, accountLayoutFrame, "Visibility", timeOut, "account Layout Frame");
		} else if (pageName.toString().equalsIgnoreCase(PageName.PipelineCustomPage.toString())) {
			ele = isDisplayed(driver, pipelineLayoutFrame, "Visibility", timeOut, "pipeline custom page frame");
		} else if (pageName.toString().equalsIgnoreCase(PageName.SharingSettingsPage.toString())) {
			ele = isDisplayed(driver, sharingSettingsFrame, "Visibility", timeOut, "Sharing Settings Page frame");
		} else if (pageName.toString().equalsIgnoreCase(PageName.DashboardDeadDeals.toString())) {
			ele = isDisplayed(driver, dashboardFrame, "Visibility", timeOut, "Sharing Settings Page frame");
		} else if (pageName.toString().equalsIgnoreCase(PageName.AccountReferral.toString())) {
			ele = isDisplayed(driver, accountReferralFrame, "Visibility", timeOut, "Sharing Settings Page frame");

		} else if (pageName.toString().equalsIgnoreCase(PageName.CustomNavigationPage.toString())) {
			ele = isDisplayed(driver, customNavigationFrame, "Visibility", timeOut, "Custom Navigation Frame");
		} else if (pageName.toString().equalsIgnoreCase(PageName.NavigationPickListPage.toString())) {
			ele = isDisplayed(driver, NavigationPickListFrame, "Visibility", timeOut, "Navigation PickList Page");

		} else if (pageName.toString().equalsIgnoreCase(PageName.RecordTypePortfolioCompany.toString())) {
			ele = isDisplayed(driver, RTPortfolioCFrame, "Visibility", timeOut, "RecordTypePortfolioCompany");

		} else if (pageName.toString().equalsIgnoreCase(PageName.ConvertToPortfolioFrame.toString())) {
			ele = isDisplayed(driver, convertToPortfolioFrame, "Visibility", timeOut, "convert to portfolio frame");

		} else if (pageName.toString().equalsIgnoreCase(PageName.AffiliationPage.toString())) {
			ele = isDisplayed(driver, affiliationFrame, "Visibility", timeOut, "affiliation Frame");

		} else if (pageName.toString().equalsIgnoreCase(PageName.Fundraising_ContactPage.toString())) {
			ele = isDisplayed(driver, fundRaisingFrame, "Visibility", timeOut, "FR Contact Frame");

		} else if (pageName.toString().equalsIgnoreCase(PageName.Financing.toString())) {
			ele = isDisplayed(driver, financingFrame, "Visibility", timeOut, "Financing Frame");

		}
		return ele;
	}

	@FindBy(xpath = "//input[@id='globalQuickfind']")
	private WebElement searchTextboxFieldsAndRelationships;

	public WebElement getsearchTextboxFieldsAndRelationships(int timeOut) {
		return isDisplayed(driver, searchTextboxFieldsAndRelationships, "Visibility", timeOut,
				"search Textbox on Fields And Relationships");
	}

	@FindBy(xpath = "//div[@class='pbHeader']//input[@title='Edit']")
	private WebElement editButton_Classic;

	@FindBy(xpath = "//a[@title='Edit']")
	private WebElement editButton_Lighting;

	/**
	 * @return the editButton
	 */
	public WebElement getEditButton(String environment, String mode, int timeOut) {
		if (mode.equalsIgnoreCase(Mode.Classic.toString())) {
			return isDisplayed(driver, editButton_Classic, "Visibility", timeOut, "Edit Button Classic");
		} else {
			return isDisplayed(driver, editButton_Lighting, "Visibility", timeOut, "Edit Button Lighting");

		}

	}

	@FindBy(xpath = "//label[text()='Active']/../following-sibling::td//input")
	private WebElement activeCheckbox;

	public WebElement getactiveCheckbox(int timeOut) {
		return isDisplayed(driver, activeCheckbox, "Visibility", timeOut, "active Checkbox");
	}

	/**
	 * @param editButton the editButton to set
	 */
	public void setEditButton(WebElement editButton) {
		this.editButton_Classic = editButton;
	}

	/*****************************************************
	 * Investor registration
	 *************************/

	@FindBy(xpath = "//label[contains(text(),'First Name')]")
	private WebElement firstNameLabel;

	/**
	 * @return the firstNameLabel
	 */
	public WebElement getFirstNameLabel(int timeOut) {
		return isDisplayed(driver, firstNameLabel, "Visibility", timeOut,
				"first name text on investor registration page");
	}

	@FindBy(xpath = "//label[contains(text(),'Last Name')]")
	private WebElement lastNameLabel;

	/**
	 * @return the lastNameLabel
	 */
	public WebElement getLastNameLabel(int timeOut) {
		return isDisplayed(driver, lastNameLabel, "Visibility", timeOut,
				"last name text on investor registration page");
	}

	@FindBy(xpath = "//label[contains(text(),'Nick Name')]")
	private WebElement nickNameLabel;

	/**
	 * @return the nickNameLabel
	 */
	public WebElement getNickNameLabel(int timeOut) {
		return isDisplayed(driver, nickNameLabel, "Visibility", timeOut,
				"nick name label text on investor registratin page");
	}

	@FindBy(xpath = "//label[contains(text(),'E-mail (Username)')]")
	private WebElement emailLabel;

	/**
	 * @return the emailLabel
	 */
	public WebElement getEmailLabel(int timeOut) {
		return isDisplayed(driver, emailLabel, "Visibility", timeOut, "email text text on investor registration page");
	}

	@FindBy(xpath = "//label[contains(text(),'Firm Name')]")
	private WebElement firmNameLabel;

	/**
	 * @return the firmNameLabel
	 */
	public WebElement getFirmNameLabel(int timeOut) {
		return isDisplayed(driver, firmNameLabel, "Visibility", timeOut,
				"firm name text on investor registration page");
	}

	@FindBy(xpath = "(//label[contains(text(),'Password')])[1]")
	private WebElement passwordLabel;

	/**
	 * @return the passwordLabel
	 */
	public WebElement getPasswordLabel(int timeOut) {
		return isDisplayed(driver, passwordLabel, "Visibility", timeOut, "password text on investor registration page");
	}

	@FindBy(xpath = "//label[contains(text(),'Confirm Password')]")
	private WebElement confirmPasswordLabel;

	/**
	 * @return the confirmPasswordLabel
	 */
	public WebElement getConfirmPasswordLabel(int timeOut) {
		return isDisplayed(driver, confirmPasswordLabel, "Visibility", timeOut,
				"confirm password text on investor registration page");
	}

	@FindBy(xpath = "//font[contains(text(),'Use at least 8 characters')]")
	private WebElement eightCharactersInfoLabel;

	/**
	 * @return the eightCharactersInfoLabel
	 */
	public WebElement getEightCharactersInfoLabel(int timeOut) {
		return isDisplayed(driver, eightCharactersInfoLabel, "Visibility", timeOut,
				"use at least 8 characters information on investor registration page");
	}

	@FindBy(xpath = "//input[@name='User_FirstLogin:Form:FirstName']")
	private WebElement targetFirstName;

	/**
	 * @return the targetFirstName
	 */
	public WebElement getTargetFirstName(int timeOut) {
		return isDisplayed(driver, targetFirstName, "Visibility", timeOut, "target first name");
	}

	@FindBy(xpath = "//input[@name='User_FirstLogin:Form:LastName']")
	private WebElement targetlastName;

	/**
	 * @return the targetlastName
	 */
	public WebElement getTargetlastName(int timeOut) {
		return isDisplayed(driver, targetlastName, "Visibility", timeOut, "target last name");
	}

	@FindBy(xpath = "//input[@name='User_FirstLogin:Form:communityNickname']")
	private WebElement targetNickName;

	/**
	 * @return the targetNickName
	 */
	public WebElement getTargetNickName(int timeOut) {
		return isDisplayed(driver, targetNickName, "Visibility", timeOut, "target nick name");
	}

	@FindBy(xpath = "//input[@name='User_FirstLogin:Form:UserName_Email']")
	private WebElement targetEmailId;

	/**
	 * @return the targetEmailId
	 */
	public WebElement getTargetEmailId(int timeOut) {
		return isDisplayed(driver, targetEmailId, "Visibility", timeOut, "target email id");
	}

	@FindBy(xpath = "//input[@name='User_FirstLogin:Form:investorfirm']")
	private WebElement targetFirmName;

	/**
	 * @return the targetFirmName
	 */
	public WebElement getTargetFirmName(int timeOut) {
		return isDisplayed(driver, targetFirmName, "Visibility", timeOut, "target firm name");
	}

	@FindBy(xpath = "//input[@name='User_FirstLogin:Form:pwd']")
	private WebElement targetpassword;

	/**
	 * @return the targetpassword
	 */
	public WebElement getTargetpassword(int timeOut) {
		return isDisplayed(driver, targetpassword, "Visibility", timeOut, "target password");
	}

	@FindBy(xpath = "//input[@name='User_FirstLogin:Form:cpwd']")
	private WebElement targetConfirmPassword;

	/**
	 * @return the targetConfirmPassword
	 */
	public WebElement getTargetConfirmPassword(int timeOut) {
		return isDisplayed(driver, targetConfirmPassword, "Visibility", timeOut, "target confirm password");
	}

	@FindBy(xpath = "//a[@class='GlobalButton']/span")
	private WebElement targetSignUpBtn;

	/**
	 * @return the targetSignUpBtn
	 */
	public WebElement getTargetSignUpBtn(int timeOut) {
		return isDisplayed(driver, targetSignUpBtn, "Visibility", timeOut, "sign button");
	}

	@FindBy(xpath = "//a[@class='GlobalButtonCancel']/span")
	private WebElement targetcancelBtn;

	/**
	 * @return the targetcancelBtn
	 */
	public WebElement getTargetcancelBtn(int timeOut) {
		return isDisplayed(driver, targetcancelBtn, "Visibility", timeOut, "cancel button");
	}

	@FindBy(xpath = "//a[@title='Logout']")
	private WebElement investorLogout;

	/**
	 * @return the logout
	 */
	public WebElement getInvestorLogout() {
		return isDisplayed(driver, investorLogout, "Visibility", 30, "Investor logout button");
	}

	@FindBy(xpath = "//img[contains(@src,'navatar')]")
	private WebElement navatarImageInvRegistration;

	/**
	 * @return the navatarImage
	 */
	public WebElement getnavatarImageInvRegistration(int timeOut) {
		return isDisplayed(driver, navatarImageInvRegistration, "Visibility", timeOut,
				"Navatar image on investor registration page");
	}

	@FindBy(xpath = "//div[@id='nodata']//h1")
	private WebElement errorMessageBeforeGivingInternalUserAccess;

	/**
	 * @return the errorMessageBeforeGivingInternalUserAccess
	 */
	public WebElement getErrorMessageBeforeGivingInternalUserAccess(int timeOut) {
		return isDisplayed(driver, errorMessageBeforeGivingInternalUserAccess, "Visibility", timeOut,
				"Error Message Before Giving Internal User Access");
	}

	@FindBy(xpath = "//a[@title='Sign In?']")
	private WebElement signInLink;

	@FindBy(xpath = "//span[text()='Enabled Visualforce Page Access']")
	private WebElement enableVisualForcePageAccessLink;

	/**
	 * @return the enableVisualForcePageAccessLink
	 */
	public WebElement getEnableVisualForcePageAccessLink(int timeOut) {
		return isDisplayed(driver, enableVisualForcePageAccessLink, "Visibility", timeOut,
				"Enable VisiualForce Page Access Link");
	}

	@FindBy(xpath = "//h3[text()='Enabled Visualforce Page Access']/../following-sibling::td//input")
	private WebElement enableVisualForcePageAccessEditButton;

	/**
	 * @return the enableVisualForcePageAccessEditButton
	 */
	public WebElement getEnableVisualForcePageAccessEditButton(int timeOut) {
		return isDisplayed(driver, enableVisualForcePageAccessEditButton, "Visibility", timeOut, "Edit Button");
	}

	/**
	 * @return the signInButton
	 */
	public WebElement getSignInLink(int timeOut) {
		return isDisplayed(driver, signInLink, "Visibility", timeOut, "Sign in button on investor registration page");
	}

	@FindBy(xpath = "//a[contains(@title,'Last Login')]")
	private WebElement lastLogin;

	/**
	 * @return the lastLogin
	 */
	public WebElement getLastLogin(int timeOut) {
		return isDisplayed(driver, lastLogin, "Visibility", timeOut, "Last Login");
	}

	@FindBy(xpath = "//select[@id='fcf']")
	private WebElement viewAllDropdownList;

	/**
	 * @return the viewAllDropdownList
	 */
	public WebElement getViewAllDropdownList(int timeOut) {
		return isDisplayed(driver, viewAllDropdownList, "Visibility", timeOut, "View All Dropdown List");
	}

	@FindBy(xpath = "//input[@id='active']")
	private WebElement activeCheckboxInUserCreation;

	/**
	 * @return the activeCheckboxINUSerCreation
	 */
	public WebElement getActiveCheckboxInUserCreation(int timeOut) {
		return isDisplayed(driver, activeCheckboxInUserCreation, "Visibility", timeOut,
				"Active Checkbox In User Creation Page");
	}

	@FindBy(xpath = "//select[@id='duel_select_0']")
	private WebElement VFPageMultiSelect;

	/**
	 * @return the vFPageMultiSelect
	 */
	public WebElement getVFPageMultiSelect(int timeOut) {
		return isDisplayed(driver, VFPageMultiSelect, "Visibility", timeOut, "VF Page Multi Select");
	}

	@FindBy(xpath = "//img[@class='rightArrowIcon']")
	private WebElement multiSelectAddButton;

	/**
	 * @return the multiSelectAddButton
	 */
	public WebElement getMultiSelectAddButton(int timeOut) {
		return isDisplayed(driver, multiSelectAddButton, "Visibility", timeOut, "Multi Select Add Button");
	}

	@FindBy(xpath = "//div[@id='pendingPopup']/div[@class='head_popup']")
	private WebElement pendingDisclaimerPopUpHeader;

	@FindBy(xpath = "//td[@id='topButtonRow']//input[@title='Delete']")
	private WebElement deleteButton;

	/**
	 * @return the deleteButton
	 */
	public WebElement getDeleteButton(int timeOut) {
		return isDisplayed(driver, deleteButton, "Visibility", timeOut, "Delete Button");
	}

	/**
	 * @return the pendingDisclaimerPopUpHeader
	 */
	public WebElement getPendingDisclaimerPopUpHeader(int timeOut) {
		return isDisplayed(driver, pendingDisclaimerPopUpHeader, "Visibility", timeOut,
				"Pending disclaimer Pop Header");
	}

	@FindBy(xpath = "//div[@id='pendingPopup']/div[@class='formbox']")
	private WebElement pendingDisclaimerPopUpMessage;

	/**
	 * @return the pendingDisclaimerPopUpMessage
	 */
	public WebElement getPendingDisclaimerPopUpMessage(int timeOut) {
		return isDisplayed(driver, pendingDisclaimerPopUpMessage, "Visibility", timeOut,
				"Pending disclaimer pop up message");
	}

	@FindBy(xpath = "//div[@id='pendingPopup']/div[@class='paginationstyle']/a[@title='Go to Disclaimers']")
	private WebElement pendingDisclaimerPopGoToDisclaimerButton;

	/**
	 * @return the pendingDisclaimerPopGoToDisclaimerButton
	 */
	public WebElement getPendingDisclaimerPopGoToDisclaimerButton(int timeOut) {
		return isDisplayed(driver, pendingDisclaimerPopGoToDisclaimerButton, "Visibility", timeOut,
				"Goto Disclaimer Button");
	}

	@FindBy(xpath = "//div[@id='pendingPopup']/div[@class='paginationstyle']/a[@title='Cancel']")
	private WebElement pendingDisclaimerPopUpCancelBUtton;

	/**
	 * @return the pendingDisclaimerPopUpCancelBUtton
	 */
	public WebElement getPendingDisclaimerPopUpCancelBUtton(int timeOut) {
		return isDisplayed(driver, pendingDisclaimerPopUpCancelBUtton, "Visibility", timeOut,
				"Pending disclaimer Pop Up Cancel Button");
	}

	@FindBy(xpath = "//div[@id='pendingPopup']/div[@class='head_popup']/a")
	private WebElement pendingDisclaimerPopUpCrossIcon;

	/**
	 * @return the pendingDisclaimerPopUpCrossIcon
	 */
	public WebElement getPendingDisclaimerPopUpCrossIcon(int timeOut) {
		return isDisplayed(driver, pendingDisclaimerPopUpCrossIcon, "Visibility", timeOut, "");
	}

	@FindBy(xpath = "//select[contains(@id,'compHeadID:headerCompID:selectValue')]")
	private WebElement firmNameDropdown;

	/**
	 * @return the firmNameDropdown
	 */
	public WebElement getFirmNameDropdown(int timeOut) {
		return isDisplayed(driver, firmNameDropdown, "Visibility", timeOut, "");
	}

	@FindBy(xpath = "//a[@title='Profile']")
	private WebElement profileLink;

	/**
	 * @return the profileLink
	 */
	public WebElement getProfileLink(int timeOut) {
		return isDisplayed(driver, profileLink, "Visibility", timeOut, "Profile link on top right");
	}

	@FindBy(xpath = "//div[@class='head_popup head_popupDisclaimer']")
	private WebElement accessDeniedPopUpHeader;

	/**
	 * @return the accessDeniedPopUpHeader
	 */
	public WebElement getAccessDeniedPopUpHeader(int timeOut) {
		return isDisplayed(driver, accessDeniedPopUpHeader, "Visibility", timeOut, "Access Denied Pop Up Header");
	}

	@FindBy(xpath = "//div[@class='formbox formboxDisclaimer']")
	private WebElement accessDeniedPopUpMessage;

	/**
	 * @return the accessDeniedPopUpMessage
	 */
	public WebElement getAccessDeniedPopUpMessage(int timeOut) {
		return isDisplayed(driver, accessDeniedPopUpMessage, "Visibility", timeOut, "Access denied Pop Up message");
	}

	@FindBy(xpath = "//div[@class='paginationstyle']/a[@title='Go to Disclaimers']")
	private WebElement accessDeniedPopUpGoToDisclaimerButton;

	/**
	 * @return the accessDeniedGoToDisclaimerButton
	 */
	public WebElement getAccessDeniedPopUpGoToDisclaimerButton(int timeOut) {
		return isDisplayed(driver, accessDeniedPopUpGoToDisclaimerButton, "Visibility", timeOut,
				"Access denied pop up Go to Disclaimer button");
	}

	@FindBy(xpath = "//a[@id='downloadLink']")
	private WebElement downloadLink;

	/**
	 * @return the downloadLink
	 */
	public WebElement getDownloadLink(int timeOut) {
		return isDisplayed(driver, downloadLink, "Visibility", timeOut, "Download Button");
	}

	@FindBy(xpath = "//a[@title='Close']")
	private WebElement viewFileOnFileDistClose;

	/**
	 * @return the viewFileOnFileDistClose
	 */
	public WebElement getViewFileOnFileDistClose(int timeOut) {
		return isDisplayed(driver, viewFileOnFileDistClose, "Visibility", timeOut, "");
	}

	@FindBy(xpath = "//a[@title='Download']")
	private WebElement viewFileOnfileDistDownload;

	/**
	 * @return the fileDistDownload
	 */
	public WebElement getViewFileOnfileDistDownload(int timeOut) {
		return isDisplayed(driver, viewFileOnfileDistDownload, "Visibility", timeOut, "File Dist Download");
	}

	@FindBy(xpath = "//a[@class='dynatree-title'][text()='All Folders']")
	private WebElement allFoldersOnBulkDownloadWindow;

	/**
	 * @return the allFoldersOnBulkDownloadWindow
	 */
	public WebElement getAllFoldersOnBulkDownloadWindow(int timeOut) {
		return isDisplayed(driver, allFoldersOnBulkDownloadWindow, "Visibility", timeOut, "All folders");
	}

	@FindBy(xpath = "//a[@title='Close']/img")
	private WebElement documentCloseBtn;

	/**
	 * @return the doucmentCloseBtn
	 */
	public WebElement getDocumentCloseBtn(int timeOut) {
		return isDisplayed(driver, documentCloseBtn, "Visibility", timeOut, "Document Close Button");
	}

	@FindBy(xpath = "//span[@id='myGridfundr-scroll-box']")
	private WebElement scrollBoxforFundPage;

	/**
	 * @return the scrollBoxforFundPage
	 */
	public WebElement getScrollBoxforFundPage(int timeOut) {
		return isDisplayed(driver, scrollBoxforFundPage, "Visibility", timeOut, "Scroll Box");
	}

	public WebElement getWorkspaceSectionView(Workspace workspace, int timeOut) {
		String workspaceSelector = "";
		if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
			workspaceSelector = "Fundraising";
		} else {
			workspaceSelector = "Investor";
		}
		return isDisplayed(
				driver, FindElement(driver, "//h3[text()='" + workspaceSelector + " Workspace']",
						workspace + " view section", action.BOOLEAN, 30),
				"visibility", 60, workspace + " view section");
	}

	public WebElement getAddFolderParentFolderCancelButton(Workspace workspace, PageName pageName, int timeOut) {
		String workspaceSelector = "";

		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "FR";
			} else {
				workspaceSelector = "INV";
			}
			return isDisplayed(driver,
					FindElement(driver,
							"//a[contains(@onclick,'clearTextBW" + workspaceSelector
									+ "')][contains(@onclick,''none'')][contains(@onclick,';')]",
							"Parent Folder cancel Button", action.BOOLEAN, timeOut),
					"Visibility", timeOut, "Parent Folder cancel Button");
		} else {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "fundraising";
			} else {
				workspaceSelector = "investor";
			}
			return isDisplayed(driver,
					FindElement(driver,
							"//a[contains(@onclick,'CreateCommon_pop1" + workspaceSelector
									+ "();')]/following-sibling::a",
							"Parent Folder cancel Button", action.BOOLEAN, timeOut),
					"Visibility", timeOut, "Parent Folder cancel Button");
		}
	}

	@FindBy(xpath = "//div[@class='tip-inner tip-bg-image']/span")
	public WebElement addFolderInfoIconMessage;

	/**
	 * @return the addFolderInfoIconMessage
	 */
	public WebElement getAddFolderInfoIconMessage(int timeOut) {
		return isDisplayed(driver, addFolderInfoIconMessage, "Visibility", timeOut, "Add folder info icon message;");
	}

	@FindBy(xpath = "//a[@id='Customize_icon']//img")
	private WebElement customizeIcon;

	/**
	 * @return the customizeIcon
	 */
	public WebElement getCustomizeIcon(int timeOut) {
		return isDisplayed(driver, customizeIcon, "Visibility", timeOut, "Customize Icon");
	}

	@FindBy(xpath = "//a[@id='Account_icon']//img")
	private WebElement accountsIconUnderCustomizeIcon;

	/**
	 * @return the accountsTabUnderCustomizeIcon
	 */
	public WebElement getAccountsIconUnderCustomizeIcon(int timeOut) {
		return isDisplayed(driver, accountsIconUnderCustomizeIcon, "Visibility", timeOut,
				"Accounts Icon under Customize Icon");
	}

	@FindBy(xpath = "//a[@id='AccountFields_font']")
	private WebElement fieldsLabelUnderAccountIcon;

	/**
	 * @return the fieldsLabelUnderAccountIcon
	 */
	public WebElement getFieldsLabelUnderAccountIcon(int timeOut) {
		return isDisplayed(driver, fieldsLabelUnderAccountIcon, "Visibility", timeOut, "Fields Label");
	}

	@FindBy(xpath = "//input[@name='new_field']")
	private WebElement newButtonInAccountsField;

	/**
	 * @return the newButtonInAccountsField
	 */
	public WebElement getNewButtonInAccountsField(int timeOut) {
		return isDisplayed(driver, newButtonInAccountsField, "Visibility", timeOut, "New Button");
	}

	@FindBy(xpath = "//div[@class='pbBottomButtons']//input[@title='Next']")
	private WebElement nextButton;

	/**
	 * @return the nextButton
	 */
	public WebElement getNextButton(int timeOut) {
		return isDisplayed(driver, nextButton, "Visibility", timeOut, "Next Button");
	}

	@FindBy(xpath = "//input[@id='MasterLabel']")
	private WebElement fieldLabelTextBox;

	/**
	 * @return the fieldLabelTextBox
	 */
	public WebElement getFieldLabelTextBox(int timeOut) {
		return isDisplayed(driver, fieldLabelTextBox, "Visibility", timeOut, "Field Label Text Box");
	}

	@FindBy(xpath = "//input[@id='startNum']")
	private WebElement startingNumberFieldTextBox;

	/**
	 * @return the startingNumberFieldTextBox
	 */
	public WebElement getStartingNumberFieldTextBox(int timeOut) {
		return isDisplayed(driver, startingNumberFieldTextBox, "Visibility", timeOut, "Starting Number Field TextBox");
	}

	@FindBy(xpath = "//input[@id='Scale']")
	private WebElement decimalPlacesTextbox;

	/**
	 * @return the decimalPlacesTextbox
	 */
	public WebElement getDecimalPlacesTextbox(int timeOut) {
		return isDisplayed(driver, decimalPlacesTextbox, "Visibility", timeOut, "Decimal Places Text box");
	}

	@FindBy(xpath = "//div[@class='pbBottomButtons']//input[@name='save']")
	private WebElement saveButtonInCustomFields;

	/**
	 * @return the saveButtonInCustomFields
	 */
	public WebElement getSaveButtonInCustomFields(int timeOut) {
		return isDisplayed(driver, saveButtonInCustomFields, "Visibility", timeOut, "Save Button In custom Fields");
	}

	@FindBy(xpath = "//a[@id='DevTools_icon']//img")
	private WebElement createIcon;

	/**
	 * @return the createIcon
	 */
	public WebElement getCreateIcon(int timeOut) {
		return isDisplayed(driver, createIcon, "Visibility", timeOut, "Create Icon");
	}

	@FindBy(xpath = "//a[text()='Objects']")
	private WebElement objectsLabel;

	/**
	 * @return the objectsLabel
	 */
	public WebElement getObjectsLabel(int timeOut) {
		return isDisplayed(driver, objectsLabel, "Visibility", timeOut, "Objects Label");
	}

	@FindBy(xpath = "//th[@class=' dataCell  ']//a[text()='Fundraising']")
	private WebElement fundraisingLabelInObject;

	/**
	 * @return the fundraisingLabelInObject
	 */
	public WebElement getFundraisingLabelInObject(int timeOut) {
		return isDisplayed(driver, fundraisingLabelInObject, "Visibility", timeOut, "FundRaisingLabel");
	}

	@FindBy(xpath = "//textarea[@class='FormulaText']")
	private WebElement formulaTextBox;

	/**
	 * @return the folrulaTextBox
	 */
	public WebElement getFormulaTextBox(int timeOut) {
		return isDisplayed(driver, formulaTextBox, "Visibility", timeOut, "Formula TextBox");
	}

	@FindBy(xpath = "//input[@id='picklistTypeLOCAL_PICKLIST']")
	private WebElement multiPicklistValueRadioButton;

	/**
	 * @return the multiPicklistValueRadioButton
	 */
	public WebElement getMultiPicklistValueRadioButton(int timeOut) {
		return isDisplayed(driver, multiPicklistValueRadioButton, "Visibility", timeOut, "MultiPickListRadio Button");
	}

	@FindBy(xpath = "//textarea[@id='ptext']")
	private WebElement valueTextBox;

	/**
	 * @return the valueTextBox
	 */
	public WebElement getValueTextBox(int timeOut) {
		return isDisplayed(driver, valueTextBox, "Visibility", timeOut, "Value Text Box");
	}

	public List<WebElement> getAllFundraisingscustomFields() {
		return FindElements(driver, "//div[@class='noStandardTab']//th[@class=' dataCell  ']//a",
				"All FundRaisings Custom Fields");
	}

	@FindBy(xpath = "//th[@class=' dataCell  ']//a[text()='Commitment']")
	private WebElement commitmentLabelInObject;

	/**
	 * @return the commitmentLabelInObject
	 */
	public WebElement getCommitmentLabelInObject(int timeOut) {
		return isDisplayed(driver, commitmentLabelInObject, "Visibility", timeOut, "Commitment Label");
	}

	@FindBy(xpath = "//input[@id='Length']")
	private WebElement lengthTextbox;

	/**
	 * @return the lengthTextbox
	 */
	public WebElement getLengthTextbox(int timeOut) {
		return isDisplayed(driver, lengthTextbox, "Visibility", timeOut, "Length TextBox");
	}

	public List<WebElement> getAllCommitmentscustomFields() {
		return FindElements(driver, "//div[@class='noStandardTab']//th[@class=' dataCell  ']//a",
				"All Commitments Custom Fields");
	}

	/**
	 * @return the deleteFileNoButtonLinkContentGrid
	 */
	public WebElement getDeleteFileNoButtonContentGrid(Workspace workSpace, int timeOut) {
		int i = 0;
		String prefixXpath = "(//div[contains(text(),'Confirm Deletion')])[";
		String suffixXpath = "]/following-sibling::div/a[@title='No']";
		String fullXpath = "";
		WebElement ele;
		if (workSpace.toString().equalsIgnoreCase(Workspace.InvestorWorkspace.toString())) {
			i = 2;
			fullXpath = prefixXpath + i + suffixXpath;
			ele = FindElement(driver, fullXpath, "Delete File No Button", action.BOOLEAN, timeOut);
			return isDisplayed(driver, ele, "Visibility", timeOut, "Delete File No Button");
		} else {
			i = 1;
			fullXpath = prefixXpath + i + suffixXpath;
			ele = FindElement(driver, fullXpath, "Delete File No Button", action.BOOLEAN, timeOut);
			return isDisplayed(driver, ele, "Visibility", timeOut, "Delete File No Button");
		}

	}

	/**
	 * @return the deleteFileCrossIconLinkContentGrid
	 */
	public WebElement getDeleteFileCrossIconLinkContentGrid(Workspace workSpace, int timeOut) {

		int i = 0;
		String prefixXpath = "(//div[contains(text(),'Confirm Deletion')])[";
		String suffixXpath = "]/span[@title='Close']";
		String fullXpath = "";
		WebElement ele;
		if (workSpace.toString().equalsIgnoreCase(Workspace.InvestorWorkspace.toString())) {
			i = 2;
			fullXpath = prefixXpath + i + suffixXpath;
			ele = FindElement(driver, fullXpath, "Delete File Cross Icon", action.BOOLEAN, timeOut);
			return isDisplayed(driver, ele, "Visibility", timeOut, "Delete File Cross Icon");
		} else {
			i = 1;
			fullXpath = prefixXpath + i + suffixXpath;
			ele = FindElement(driver, fullXpath, "Delete File Cross Icon", action.BOOLEAN, timeOut);
			return isDisplayed(driver, ele, "Visibility", timeOut, "Delete File Cross Icon");
		}
	}

	/**
	 * @return the deleteFileYesButtonLinkContentGrid
	 */
	public WebElement getDeleteFileYesButtonContentGrid(Workspace workSpace, int timeOut) {

		int i = 0;
		String prefixXpath = "(//div[contains(text(),'Confirm Deletion')])[";
		String suffixXpath = "]/following-sibling::div/a[@title='Yes']";
		String fullXpath = "";
		WebElement ele;
		if (workSpace.toString().equalsIgnoreCase(Workspace.InvestorWorkspace.toString())) {
			i = 2;
			fullXpath = prefixXpath + i + suffixXpath;
			ele = FindElement(driver, fullXpath, "Delete File Yes Button", action.BOOLEAN, timeOut);
			return isDisplayed(driver, ele, "Visibility", timeOut, "Delete File Yes Button");
		} else {
			i = 1;
			fullXpath = prefixXpath + i + suffixXpath;
			ele = FindElement(driver, fullXpath, "Delete File Yes Button", action.BOOLEAN, timeOut);
			return isDisplayed(driver, ele, "Visibility", timeOut, "Delete File Yes Button");
		}
	}

	public WebElement getDeleteFilePopUpMsgContentGrid(Workspace workSpace, int timeOut) {

		int i = 0;
		String prefixXpath = "(//div[contains(text(),'Confirm Deletion')])[";
		String suffixXpath = "]/../p";
		String fullXpath = "";
		WebElement ele;
		if (workSpace.toString().equalsIgnoreCase(Workspace.InvestorWorkspace.toString())) {
			i = 2;
			fullXpath = prefixXpath + i + suffixXpath;
			ele = FindElement(driver, fullXpath, "Delete File Msg", action.BOOLEAN, timeOut);
			return isDisplayed(driver, ele, "Visibility", timeOut, "Delete File Msg");
		} else {
			i = 1;
			fullXpath = prefixXpath + i + suffixXpath;
			ele = FindElement(driver, fullXpath, "Delete File Msg", action.BOOLEAN, timeOut);
			return isDisplayed(driver, ele, "Visibility", timeOut, "Delete File Msg");
		}
	}

	public WebElement getDeleteFilePopUpHeaderContentGrid(Workspace workSpace, int timeOut) {

		int i = 0;
		String prefixXpath = "(//div[contains(text(),'Confirm Deletion')])[";
		String suffixXpath = "]";
		String fullXpath = "";
		WebElement ele;
		if (workSpace.toString().equalsIgnoreCase(Workspace.InvestorWorkspace.toString())) {
			i = 2;
			fullXpath = prefixXpath + i + suffixXpath;
			ele = FindElement(driver, fullXpath, "Delete File Pop Up Header", action.BOOLEAN, timeOut);
			return isDisplayed(driver, ele, "Visibility", timeOut, "Delete File Pop Up Header");
		} else {
			i = 1;
			fullXpath = prefixXpath + i + suffixXpath;
			ele = FindElement(driver, fullXpath, "Delete  File Pop Up Header", action.BOOLEAN, timeOut);
			return isDisplayed(driver, ele, "Visibility", timeOut, "Delete File Pop Up Header");
		}
	}

	/**
	 * @return the searchIcon for AllPage FundRaising or Investor Side
	 */
	public WebElement getSearchIcon(WebDriver driver, PageName pName, Workspace workspace, int timeOut) {

		String workSpaceXpath = null;
		WebElement ele = null;
		String searchIconXpath = "//a[@title='Search']";
		String fullXPath;

		if (pName.toString().equalsIgnoreCase(PageName.FundsPage.toString())) {

			if (workspace.toString().equalsIgnoreCase(Workspace.InvestorWorkspace.toString())) {
				workSpaceXpath = "//div[@id='invworkspace']";

			} else {
				workSpaceXpath = "//div[@id='frworkspace']";

			}

		} else if (pName.toString().equalsIgnoreCase(PageName.InstitutionsPage.toString())
				|| pName.toString().equalsIgnoreCase(PageName.Object2Page.toString())) {

			if (workspace.toString().equalsIgnoreCase(Workspace.InvestorWorkspace.toString())) {
				workSpaceXpath = "//div[@id='Investorgrid_div']";

			} else {
				workSpaceXpath = "//div[@id='divFrWorkspace']";
			}
		} else if (pName.toString().equalsIgnoreCase(PageName.CommitmentsPage.toString())) {

			if (workspace.toString().equalsIgnoreCase(Workspace.InvestorWorkspace.toString())) {
				workSpaceXpath = "//div[@class='content_div']";

			} else {
				workSpaceXpath = "//div[@class='content_div']";
			}
		}

		if (workSpaceXpath != null) {

			fullXPath = workSpaceXpath + searchIconXpath;

			ele = FindElement(driver, fullXPath, "Search Icon", action.SCROLLANDBOOLEAN, timeOut);

		} else {
			appLog.info(" Xpath Not Found for Seacrh Icon for " + pName.toString() + " : " + workspace.toString());
			BaseLib.sa.assertTrue(false,
					" Xpath Not Found for Seacrh Icon for " + pName.toString() + " : " + workspace.toString());
		}

		return ele;

	}

	/**
	 * @return the searchTextBox for AllPage FundRaising or Investor Side
	 */

	public WebElement getSearchTextBox(WebDriver driver, PageName pName, Workspace workspace, int timeOut) {

		String workSpaceXpath = null;
		WebElement ele = null;
		String searchTextBoxXpath = "//input[@class='input_txt_search']";
		String fullXPath;

		if (pName.toString().equalsIgnoreCase(PageName.FundsPage.toString())) {

			if (workspace.toString().equalsIgnoreCase(Workspace.InvestorWorkspace.toString())) {
				workSpaceXpath = "//div[@id='invworkspace']";

			} else {
				workSpaceXpath = "//div[@id='frworkspace']";

			}

		} else if (pName.toString().equalsIgnoreCase(PageName.InstitutionsPage.toString())
				|| pName.toString().equalsIgnoreCase(PageName.Object2Page.toString())) {

			if (workspace.toString().equalsIgnoreCase(Workspace.InvestorWorkspace.toString())) {
				workSpaceXpath = "//div[@id='Investorgrid_div']";

			} else {
				workSpaceXpath = "//div[@id='divFrWorkspace']";
			}
		} else if (pName.toString().equalsIgnoreCase(PageName.CommitmentsPage.toString())) {

			if (workspace.toString().equalsIgnoreCase(Workspace.InvestorWorkspace.toString())) {
				workSpaceXpath = "//div[@class='content_div']";

			} else {
				workSpaceXpath = "//div[@class='content_div']";
			}
		}

		if (workSpaceXpath != null) {

			fullXPath = workSpaceXpath + searchTextBoxXpath;

			ele = FindElement(driver, fullXPath, "Search Text Box", action.SCROLLANDBOOLEAN, timeOut);

		} else {
			appLog.info(" Xpath Not Found for Seacrh Text Box for " + pName.toString() + " : " + workspace.toString());
			BaseLib.sa.assertTrue(false,
					" Xpath Not Found for Seacrh Text Box for " + pName.toString() + " : " + workspace.toString());
		}

		return ele;

	}

	@FindBy(xpath = "//div[@id='SearchId']//div[@class='head_popup']")
	private WebElement searchHeader;

	/**
	 * @return the searchHeader
	 */
	public WebElement getSearchHeader(int timeOut) {
		return isDisplayed(driver, searchHeader, "Visibility", timeOut, "Search Header");
	}

	@FindBy(xpath = "//span[@id='Specify_the_recipients_to_include-headers']/span[contains(@id,'Specify_the_recipients_to_include-header-')]/span//span[3]")
	private List<WebElement> allLabelsOnSearchPopUp;

	/**
	 * @return the allLabelsOnSearchPopUp
	 */
	public List<WebElement> getAllLabelsOnSearchPopUp() {
		if (checkElementsVisibility(driver, allLabelsOnSearchPopUp, "All Label Search Pop", 60)) {
			return allLabelsOnSearchPopUp;
		} else {
			return null;
		}
	}

	/**
	 * @return the getAllRadioButton
	 */
	public WebElement getAllFolderRadioButton(int timeOut) {
		String path = "//span[text()='Search All Folders']/..//input";
		WebElement ele = FindElement(driver, path, "All Folder Radio Button", action.SCROLLANDBOOLEAN, 30);
		return isDisplayed(driver, ele, "Visibility", timeOut, "Selected Folder Radio Button");
	}

	/**
	 * @return the getFolderRadioButton
	 */
	public WebElement getFolderRadioButton(String folder, int timeOut) {
		String path = "//span[@title='" + folder + "']/../..//input[@id='selectedFolder']";
		WebElement ele = FindElement(driver, path, folder, action.SCROLLANDBOOLEAN, 30);
		return isDisplayed(driver, ele, "Visibility", timeOut, " Folder Radio Button");
	}

	@FindBy(xpath = "//a[contains(@onclick,'clear_gridDD')]")
	private WebElement clearSearchContentButtonSearchResultPopUp;

	/**
	 * @return the clearSearchContentButtonSearchResultPopUp
	 */
	public WebElement getClearSearchContentButtonSearchResultPopUp(int timeOut) {
		return isDisplayed(driver, clearSearchContentButtonSearchResultPopUp, "Visibility", timeOut,
				"clear Search Result Button On Search Result Popup.");
	}

	@FindBy(xpath = "//div[contains(text(),'Search Results')]/following-sibling::div//input[@class='input_txt_search']")
	private WebElement searchResultPopUpTextBox;

	/**
	 * @return the searchResultPopUpTextBox
	 */
	public WebElement getSearchResultPopUpTextBox(int timeOut) {
		return isDisplayed(driver, searchResultPopUpTextBox, "Visibility", timeOut, "Search Result Pop Up Text Box.");
	}

	@FindBy(xpath = "//div[contains(text(),'Search Results')]/following-sibling::div//a[@class='icon_btn_search']")
	private WebElement searchResultPopSearchIcon;

	/**
	 * @return the searchResultPopSearchIcon
	 */
	public WebElement getSearchResultPopSearchIcon(int timeOut) {
		return isDisplayed(driver, searchResultPopSearchIcon, "Visibility", timeOut,
				"search Result Search Icon Button");
	}

	@FindBy(xpath = "//a[@onclick='refreshAllData(); return false;']")
	private WebElement searchPopCrossIcon;

	/**
	 * @return the searchPopCrossIcon
	 */
	public WebElement getSearchPopCrossIcon(int timeOut) {
		return isDisplayed(driver, searchPopCrossIcon, "Visibility", timeOut, "Search Pop Up Cross Icon");
	}

	/**
	 * @return the getSearchFolderPathColumnValue
	 */
	public List<WebElement> getDateColumnValue() {
		String xpath = "//span[contains(@id,'Specify_the_recipients_to_include-cell-0-')]";
		return FindElements(driver, xpath, "Date Column Value");
	}

	/**
	 * @return the getSearchFolderPathColumnValue
	 */
	public List<WebElement> getNameColumnValue() {
		String xpath = "//span[contains(@id,'Specify_the_recipients_to_include-cell-1-')]/a";
		return FindElements(driver, xpath, " Name Column Value");
	}

	/**
	 * @return the getSearchSizeColumnValue
	 */
	public List<WebElement> getStatusColumnValue() {
		String xpath = "//span[contains(@id,'Specify_the_recipients_to_include-cell-4-')]";
		return FindElements(driver, xpath, "Status Column Value");
	}

	/**
	 * @return the getSearchLastUpdatedColumnValue
	 */
	public List<WebElement> getOwnerColumnValue() {
		String xpath = "//span[contains(@id,'Specify_the_recipients_to_include-cell-5-')]";
		return FindElements(driver, xpath, "Ownerd Column Value");
	}

	/**
	 * @return the getSearchLastUpdatedColumnValue
	 */
	public List<WebElement> getMeetingTypeColumnValue() {
		String xpath = "//span[contains(@id,'Specify_the_recipients_to_include-cell-6-')]";
		return FindElements(driver, xpath, "Ownerd Column Value");
	}

	/**
	 * @return the getSearchLastUpdatedColumnValue
	 */
	public List<WebElement> getActivityColumnValue() {
		String xpath = "//span[contains(@id,'Specify_the_recipients_to_include-cell-7-')]";
		return FindElements(driver, xpath, "Activity Column Value");
	}

	@FindBy(xpath = "//div[@id='clearsearchenbDD']/a")
	private WebElement searchPopSearchTextBoxCrossIcon;

	/**
	 * @return the searchPopSearchTextBoxCrossIcon
	 */
	public WebElement getSearchPopSearchTextBoxCrossIcon(int timeOut) {
		return isDisplayed(driver, searchPopSearchTextBoxCrossIcon, "Visibility", timeOut,
				"Search Pop Up Search Text Box Cross Icon");
	}

	@FindBy(xpath = "//span[contains(@id,'SearchResultsFor_DealDetail_FileSearch-cell-')]/span")
	private WebElement noDataToDisplaySearchPopMsg;

	/**
	 * @return the noDataToDisplaySearchPopMsg
	 */
	public WebElement getNoDataToDisplaySearchPopMsg(int timeOut) {
		return isDisplayed(driver, noDataToDisplaySearchPopMsg, "Visibility", timeOut, "No Data To display Msg");
	}

	@FindBy(xpath = "//div[@id='SearchId']//b/font")
	private WebElement noDataToDisplaySearchPopMsg1;

	/**
	 * @return the noDataToDisplaySearchPopMsg1
	 */
	public WebElement getNoDataToDisplaySearchPopMsg1(int timeOut) {
		return isDisplayed(driver, noDataToDisplaySearchPopMsg1, "Visibility", timeOut, "No Data To display Msg");
	}

	/**
	 * @deprecated Use {@link #getColumnHeads(PageName,Workspace)} instead
	 */
	public List<WebElement> getColumnHeads() {
		return getColumnHeads(PageName.FundsPage, Workspace.FundraisingWorkspace);
	}

	public List<WebElement> getColumnHeads(PageName pageName, Workspace workSpace) {
		if (workSpace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
			return FindElements(driver, "//span[contains(@id,'myGridfundr-header-')]/span[3]", "column heads");
		} else {
			return FindElements(driver, "//span[contains(@id,'myGrid-header-')]/span[3]", "column heads");
		}

	}

	/**
	 * @deprecated Use {@link #getSortingArrow(PageName,Workspace)} instead
	 */
	public List<WebElement> getSortingArrow() {
		return getSortingArrow(PageName.FundsPage, Workspace.FundraisingWorkspace);
	}

	public List<WebElement> getSortingArrow(PageName pageNAME, Workspace workSpace) {
		if (workSpace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
			return FindElements(driver, "//span[contains(@id,'myGridfundr-header-')]/span[3]/span",
					"sorting arrow for all columns");
		} else {
			return FindElements(driver, "//span[contains(@id,'myGrid-header-')]/span[3]/span",
					"sorting arrow for all columns");
		}
	}

	public List<WebElement> getColumnHeadsInvestor() {
		return FindElements(driver, "//span[contains(@id,'myGrid-header-')]/span[3]", "column heads Investor");
	}

	public List<WebElement> getSortingArrowInvestor() {
		return FindElements(driver, "//span[contains(@id,'myGrid-header-')]/span[3]/span",
				"sorting arrow for all columns Investor");
	}

	public WebElement getAlertHistoryLink(Workspace workspace, PageName pageName, int timeOut) {

		String workspaceSelector = "";
		if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
			if (pageName.toString().equalsIgnoreCase(PageName.Object2Page.toString())) {
				workspaceSelector = "pg:frm:ACTALTFR:AVTALT:theLinkPanel";
			} else {
				workspaceSelector = "page:formACTALTFR:ACTALTFR:AVTALT:theLinkPanel";
			}
		} else {
			if (pageName.toString().equalsIgnoreCase(PageName.Object2Page.toString())) {
				workspaceSelector = "pg:frm:ACTALTINV:AVTALT:theLinkPanel";
			} else {
				workspaceSelector = "page:formACTALTINV:ACTALTINV:AVTALT:theLinkPanel";
			}
		}
		return isDisplayed(driver,
				FindElement(driver, "//span[@id='" + workspaceSelector + "']//a[@title='Alert History']",
						"alert history link", action.BOOLEAN, timeOut),
				"Visibility", timeOut, "alert history link");
	}

	public WebElement getAlertHistoryCrossIcon(Workspace workspace, int timeOut) {
		String workspaceSelector = "";
		if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
			workspaceSelector = "FR";
		} else {
			workspaceSelector = "INV";
		}
		return isDisplayed(driver,
				FindElement(driver,
						"//div[contains(@class,'ActivityAlerts_fancyboxACTALT" + workspaceSelector
								+ "')]//a[@title='Close']",
						"alert history cross icon", action.BOOLEAN, timeOut),
				"Visibility", timeOut, "alert history cross icon");
	}

	public WebElement getFirmProfileUpdatedHeader(Workspace workspace, PageName pageName, int timeOut) {

		String workspaceSelector = "";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())
				|| pageName.toString().equalsIgnoreCase(PageName.Object2Page.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "ACTALTFR:AVTALT:rendrAccountHistory";
			} else {
				workspaceSelector = "ACTALTINV:AVTALT:rendrAccountHistory";
			}
		} else {
			if (pageName.toString().equalsIgnoreCase(PageName.HomePage.toString())) {
				workspaceSelector = "page:formACTALT_new:ACTALT:AVTALT:rendrAccountHistory";
			}
		}
		return isDisplayed(driver,
				FindElement(driver, "//span[contains(@id,'" + workspaceSelector + "')]//div[@class='head_popup']",
						"alert history link", action.BOOLEAN, timeOut),
				"Visibility", timeOut, "Firm profile updtaed header");
	}

	public WebElement getFirmTextLabel(Workspace workspace, PageName pageName, int timeOut) {
		String workspaceSelector = "";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())
				|| pageName.toString().equalsIgnoreCase(PageName.Object2Page.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "formboxACTALTFR";
			} else {
				workspaceSelector = "formboxACTALTINV";
			}
		} else {
			if (pageName.toString().equalsIgnoreCase(PageName.HomePage.toString())) {
				workspaceSelector = "formboxACTALT";
			}
		}
		return isDisplayed(driver,
				FindElement(driver,
						"(//div[@id='" + workspaceSelector
								+ "']//strong[text()='Firm:']/..//following-sibling::td[@class='maxcharswordwrap'])[1]",
						"alert history link", action.BOOLEAN, timeOut),
				"Visibility", timeOut, "Firm value");
	}

	@FindBy(xpath = "//span[text()='Field']")
	private WebElement fieldLabelInFirmProfilePopup;

	/**
	 * @return the fieldLabelInFirmProfilePopup
	 */
	public WebElement getFieldLabelInFirmProfilePopup(int timeOut) {
		return isDisplayed(driver, fieldLabelInFirmProfilePopup, "Visibility", timeOut,
				"Field Label in firm profile popup");
	}

	@FindBy(xpath = "//span[text()='New Value']")
	private WebElement valueLabelInFirmProfilePopup;

	/**
	 * @return the fieldLabelInFirmProfilePopup
	 */
	public WebElement getValueLabelInFirmProfilePopup(int timeOut) {
		return isDisplayed(driver, valueLabelInFirmProfilePopup, "Visibility", timeOut,
				"Value Label in firm profile popup");
	}

	public WebElement getFirmProfileUpdateScrollBox(Workspace workspace, PageName pageName, int timeOut) {
		String workspaceSelector = "";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())
				|| pageName.toString().equalsIgnoreCase(PageName.Object2Page.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "grid_AccountProfileUpdatedACTALTFR-scroll-box";
			} else {
				workspaceSelector = "grid_AccountProfileUpdatedACTALTINV-scroll-box";
			}
		} else {
			if (pageName.toString().equalsIgnoreCase(PageName.HomePage.toString())) {
				workspaceSelector = "grid_AccountProfileUpdatedACTALT-scroll-box";
			}
		}
		return isDisplayed(driver, FindElement(driver, "//span[@id='" + workspaceSelector + "']",
				"Firm Profile Updtae scrollBOx", action.BOOLEAN, timeOut), "Visibility", timeOut,
				"Firm Profile Updae scroll ox");
	}

	public WebElement getGoToFirmButton(PageName pageName, Workspace workspace, int timeOut) {
		String workspaceSelector = "";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())
				|| pageName.toString().equalsIgnoreCase(PageName.Object2Page.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "IDInvestorAccountACTALTFR";
			} else {
				workspaceSelector = "IDInvestorAccountACTALTINV";
			}
		} else {
			if (pageName.toString().equalsIgnoreCase(PageName.HomePage.toString())) {
				workspaceSelector = "IDInvestorAccountACTALT";
			}
		}
		return isDisplayed(driver, FindElement(driver, "//div[@id='" + workspaceSelector + "']//a[text()='Go to Firm']",
				"Go to firm button", action.BOOLEAN, timeOut), "Visibility", timeOut, "Go to firm button");
	}

	public WebElement getFirmProfileUpdateCloseButton(Workspace workspace, PageName pageName, int timeOut) {
		String workspaceSelector = "";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())
				|| pageName.toString().equalsIgnoreCase(PageName.Object2Page.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "ACTALTFR:AVTALT:rendrAccountHistory";
			} else {
				workspaceSelector = "ACTALTINV:AVTALT:rendrAccountHistory";
			}
		} else {
			if (pageName.toString().equalsIgnoreCase(PageName.HomePage.toString())) {
				workspaceSelector = "page:formACTALT_new:ACTALT:AVTALT:rendrAccountHistory";
			}
		}
		return isDisplayed(driver,
				FindElement(driver, "//span[contains(@id,'" + workspaceSelector + "')]//a[text()='Close']",
						"Firm Profile Updtae Close Button", action.BOOLEAN, timeOut),
				"Visibility", timeOut, "Firm Profile Update close button");
	}

	public WebElement getFirmProfileUpdateCloseIcon(Workspace workspace, PageName pageName, int timeOut) {
		String workspaceSelector = "";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())
				|| pageName.toString().equalsIgnoreCase(PageName.Object2Page.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "IDInvestorAccountACTALTFR";
			} else {
				workspaceSelector = "IDInvestorAccountACTALTINV";
			}
		} else {
			if (pageName.toString().equalsIgnoreCase(PageName.HomePage.toString())) {
				workspaceSelector = "IDInvestorAccountACTALT";
			}
		}
		return isDisplayed(driver,
				FindElement(driver,
						"//div[@id='" + workspaceSelector + "']//div[@class='head_popup']//a[@title='Close']",
						"Firm Profile Updtae Close icon", action.BOOLEAN, timeOut),
				"Visibility", timeOut, "Firm Profile Update close icon");
	}

	public WebElement getContactProfileUpdatedHeader(Workspace workspace, PageName pageName, int timeOut) {

		String workspaceSelector = "";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())
				|| pageName.toString().equalsIgnoreCase(PageName.Object2Page.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "ACTALTFR:AVTALT:rendrContactHistory";
			} else {
				workspaceSelector = "ACTALTINV:AVTALT:rendrContactHistory";
			}
		} else {
			if (pageName.toString().equalsIgnoreCase(PageName.HomePage.toString())) {
				workspaceSelector = "page:formACTALT_new:ACTALT:AVTALT:rendrContactHistory";
			}
		}
		return isDisplayed(driver,
				FindElement(driver, "//span[contains(@id,'" + workspaceSelector + "')]//div[@class='head_popup']",
						"Contact Profile header", action.BOOLEAN, timeOut),
				"Visibility", timeOut, "Contact profile updtaed header");
	}

	public WebElement getFirmTextLabelInContactProfileUpdated(Workspace workspace, PageName pageName, int timeOut) {
		String workspaceSelector = "";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())
				|| pageName.toString().equalsIgnoreCase(PageName.Object2Page.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "formboxACTALTFR";
			} else {
				workspaceSelector = "formboxACTALTINV";
			}
		} else {
			if (pageName.toString().equalsIgnoreCase(PageName.HomePage.toString())) {
				workspaceSelector = "formboxACTALT";
			}
		}
		return isDisplayed(driver,
				FindElement(driver,
						"(//div[@id='" + workspaceSelector
								+ "']//strong[text()='Firm:']/..//following-sibling::td[@class='maxcharswordwrap'])[2]",
						"Firm label in contact profile updtaed", action.BOOLEAN, timeOut),
				"Visibility", timeOut, "Firm value");
	}

	public WebElement getContactTextLabelInContactProfileUpdated(Workspace workspace, PageName pageName, int timeOut) {
		String workspaceSelector = "";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())
				|| pageName.toString().equalsIgnoreCase(PageName.Object2Page.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "formboxACTALTFR";
			} else {
				workspaceSelector = "formboxACTALTINV";
			}
		} else {
			if (pageName.toString().equalsIgnoreCase(PageName.HomePage.toString())) {
				workspaceSelector = "formboxACTALT";
			}
		}
		return isDisplayed(driver,
				FindElement(driver, "(//div[@id='" + workspaceSelector
						+ "']//strong[text()='Contact:']/..//following-sibling::td[@class='maxcharswordwrap'])[1]",
						"Contact label in contact profile updtaed", action.BOOLEAN, timeOut),
				"Visibility", timeOut, "Contact value");
	}

	public WebElement getContactProfileUpdateScrollBox(Workspace workspace, PageName pageName, int timeOut) {
		String workspaceSelector = "";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())
				|| pageName.toString().equalsIgnoreCase(PageName.Object2Page.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "grid_ContactProfileUpdatedACTALTFR-scroll-box";
			} else {
				workspaceSelector = "grid_ContactProfileUpdatedACTALTINV-scroll-box";
			}
		} else {
			if (pageName.toString().equalsIgnoreCase(PageName.HomePage.toString())) {
				workspaceSelector = "grid_ContactProfileUpdatedACTALT-scroll-box";
			}
		}
		return isDisplayed(
				driver, FindElement(driver, "//span[@id='" + workspaceSelector + "']",
						"Contact Profile Updtae scrollBOx", action.BOOLEAN, timeOut),
				"Visibility", timeOut, "Contact Profile Updae scroll ox");
	}

	public WebElement getGoToContactButton(PageName pageName, Workspace workspace, int timeOut) {
		String workspaceSelector = "";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())
				|| pageName.toString().equalsIgnoreCase(PageName.Object2Page.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "IDInvestorContactACTALTFR";
			} else {
				workspaceSelector = "IDInvestorContactACTALTINV";
			}
		} else {
			if (pageName.toString().equalsIgnoreCase(PageName.HomePage.toString())) {
				workspaceSelector = "IDInvestorContactACTALT";
			}
		}
		return isDisplayed(driver,
				FindElement(driver, "//div[@id='" + workspaceSelector + "']//a[text()='Go to Contact']",
						"Go to Contact button", action.BOOLEAN, timeOut),
				"Visibility", timeOut, "Go to Contact button");
	}

	public WebElement getContactProfileUpdateCloseButton(Workspace workspace, PageName pageName, int timeOut) {
		String workspaceSelector = "";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())
				|| pageName.toString().equalsIgnoreCase(PageName.Object2Page.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "ACTALTFR:AVTALT:rendrContactHistory";
			} else {
				workspaceSelector = "ACTALTINV:AVTALT:rendrContactHistory";
			}
		} else {
			if (pageName.toString().equalsIgnoreCase(PageName.HomePage.toString())) {
				workspaceSelector = "page:formACTALT_new:ACTALT:AVTALT:rendrContactHistory";
			}
		}
		return isDisplayed(driver,
				FindElement(driver, "//span[contains(@id,'" + workspaceSelector + "')]//a[text()='Close']",
						"Contact Profile Updtae Close Button", action.BOOLEAN, timeOut),
				"Visibility", timeOut, "Contact Profile Update close button");
	}

	public WebElement getContactProfileUpdateCloseIcon(Workspace workspace, PageName pageName, int timeOut) {
		String workspaceSelector = "";
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())
				|| pageName.toString().equalsIgnoreCase(PageName.Object2Page.toString())) {
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "ACTALTFR:AVTALT:rendrContactHistory";
			} else {
				workspaceSelector = "ACTALTINV:AVTALT:rendrContactHistory";
			}
		} else {
			if (pageName.toString().equalsIgnoreCase(PageName.HomePage.toString())) {
				workspaceSelector = "page:formACTALT_new:ACTALT:AVTALT:rendrContactHistory";
			}
		}
		return isDisplayed(driver,
				FindElement(driver,
						"//span[contains(@id,'" + workspaceSelector
								+ "')]//div[@class='head_popup']//a[@title='Close']",
						"Contact Profile Updtae Close icon", action.BOOLEAN, timeOut),
				"Visibility", timeOut, "Contact Profile Update close icon");
	}

	public WebElement getAlertHistoryScrollbox(Workspace workspace, int timeOut) {
		String workspaceSelector = "";
		if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
			workspaceSelector = "FR";
		} else {
			workspaceSelector = "INV";
		}
		return isDisplayed(driver,
				FindElement(driver, "//span[@id='myGridACTALT" + workspaceSelector + "-scroll-box']",
						"Alert history popup scrollbox", action.BOOLEAN, timeOut),
				"Visibility", timeOut, "Alert history popup Scroll box");
	}

	@FindBy(xpath = "//span[text()='Date']//span")
	private WebElement dateSortIcon;

	/**
	 * @return the dateSortIcon
	 */
	public WebElement getDateSortIcon(int timeOut) {
		return isDisplayed(driver, dateSortIcon, "Visibility", timeOut, "Date sort icon");
	}

	@FindBy(xpath = "//span[text()='Activity Type']//span")
	private WebElement activityTypeSortIcon;

	/**
	 * @return the dateSortIcon
	 */
	public WebElement getActivityTypeSortIcon(int timeOut) {
		return isDisplayed(driver, activityTypeSortIcon, "Visibility", timeOut, "activity Type sort icon");
	}

	public List<WebElement> getActivityTypeColumnValue(PageName pageName, Workspace workspace) {
		if (pageName.toString().equalsIgnoreCase(PageName.FundsPage.toString())
				|| pageName.toString().equalsIgnoreCase(PageName.Object2Page.toString())) {
			String workspaceSelector = "";
			if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
				workspaceSelector = "FR";
			} else {
				workspaceSelector = "INV";
			}
			String xpath = "//span[@id='myGridACTALT" + workspaceSelector + "-rows']//span[contains(@id,'myGridACTALT"
					+ workspaceSelector + "-cell-0-')]";
			return FindElements(driver, xpath, "Activity type Column Value");
		} else {
			String xpath = "//span[@id='myGridACTALT-rows']//span[contains(@id,'myGridACTALT-cell-0-')]";
			return FindElements(driver, xpath, "Activity type Column Value");
		}

	}

	@FindBy(xpath = "//span[text()='Workspace']/span")
	private WebElement workspaceSortIconOnHomePageAlert;

	/**
	 * @return the workspaceSortIconOnHomePageAlert
	 */
	public WebElement getWorkspaceSortIconOnHomePageAlert(int timeOut) {
		return isDisplayed(driver, workspaceSortIconOnHomePageAlert, "Visibility", timeOut,
				"workspace Sort Icon On Home Page Alert");
	}

	@FindBy(xpath = "//span[text()='Workspace']")
	private WebElement workspaceLabelOnHomePageAlert;

	/**
	 * @return the workspaceSortIconOnHomePageAlert
	 */
	public WebElement getWorkspaceLabelOnHomePageAlert(int timeOut) {
		return isDisplayed(driver, workspaceLabelOnHomePageAlert, "Visibility", timeOut,
				"workspace Label On Home Page Alert");
	}

	@FindBy(xpath = "//span[text()='Field']/span")
	private WebElement fieldLabelSortIconOnProfileUpdatedPopupAlert;

	/**
	 * @return the fieldLabelSortIconOnProfileUpdatedPopupAlert
	 */
	public WebElement getFieldLabelSortIconOnProfileUpdatedPopupAlert(int timeOut) {
		return isDisplayed(driver, fieldLabelSortIconOnProfileUpdatedPopupAlert, "Visibility", timeOut,
				"field Label Sort Icon On Profile Updated Popup Alert ");
	}

	@FindBy(xpath = "//div[@id='fileNotFound']")
	private WebElement fileNotFoundErrorMessage;

	/**
	 * @return the fileNotFoundErrorMessage
	 */
	public WebElement getFileNotFoundErrorMessage(int timeOut) {
		return isDisplayed(driver, fileNotFoundErrorMessage, "Visibility", timeOut, "File Not found error Message");
	}

	@FindBy(xpath = "//a[text()='Create New View']")
	private WebElement createViewLink;

	/**
	 * @return the createViewLink
	 */
	public WebElement getCreateViewLink(int timeOut) {
		return isDisplayed(driver, createViewLink, "Visibility", timeOut, "Create View Link");
	}

	@FindBy(xpath = "//label[text()='View Name:']/../following-sibling::td//input")
	private WebElement viewName;

	/**
	 * @return the viewName
	 */
	public WebElement getViewName(int timeOut) {
		return isDisplayed(driver, viewName, "Visibility", timeOut, "View Name");
	}

	@FindBy(xpath = "//label[text()='View Unique Name:']/../following-sibling::td//input")
	private WebElement viewUniqueName;

	/**
	 * @return the viewUniqueName
	 */
	public WebElement getViewUniqueName(int timeOut) {
		return isDisplayed(driver, viewUniqueName, "Visibility", timeOut, "View Unique Name");
	}

	@FindBy(xpath = "//select[@id='fcol1']")
	private WebElement fieldDropDown;

	/**
	 * @return the fieldDropDown
	 */
	public WebElement getFieldDropDown(int timeOut) {
		return isDisplayed(driver, fieldDropDown, "Visibility", timeOut, "Field Drop Down");
	}

	@FindBy(xpath = "//select[@id='fop1']")
	private WebElement viewOperatorDropDown;

	/**
	 * @return the viewOperatorDropDown
	 */
	public WebElement getViewOperatorDropDown(int timeOut) {
		return isDisplayed(driver, viewOperatorDropDown, "Visibility", timeOut, "View Operator Drop Down");
	}

	@FindBy(xpath = "//input[@id='fval1']")
	private WebElement viewValueBox;

	/**
	 * @return the viewValueBox
	 */
	public WebElement getViewValueBox(int timeOut) {
		return isDisplayed(driver, viewValueBox, "Visibility", timeOut, "View Text Box");
	}

	@FindBy(xpath = "//td[text()='Folder Structure']/following-sibling::td/div")
	private WebElement folderStructureInHub;

	/**
	 * @return the folderStructureInHub
	 */
	public WebElement getFolderStructureInHub(int timeOut) {
		return isDisplayed(driver, folderStructureInHub, "Visibility", timeOut, "Folder Structure in hub");
	}

	@FindBy(xpath = "(//td[text()='Related Folder IDs']/following-sibling::td/div)[1]")
	private WebElement relatedFolderIds;

	/**
	 * @return the relatedFolderIds
	 */
	public WebElement getRelatedFolderIds(int timeOut) {
		return isDisplayed(driver, relatedFolderIds, "Visibility", timeOut, "");
	}

	@FindBy(xpath = "(//td[text()='Related Folder IDs2']/following-sibling::td/div)[1]")
	private WebElement relatedFolderIds2;

	/**
	 * @return the folderStrucutreIds2
	 */
	public WebElement getRelatedFolderIds2(int timeOut) {
		return isDisplayed(driver, relatedFolderIds2, "Visibility", timeOut, "Folder Structure ids2");
	}

	@FindBy(xpath = "//input[@id='phSearchInput']")
	private WebElement globalSearch;

	/**
	 * @return the globalSearch
	 */
	public WebElement getGlobalSearch(int timeOut) {
		return isDisplayed(driver, globalSearch, "Visibility", timeOut, "Global Search");
	}

	@FindBy(xpath = "//input[@id='phSearchButton']")
	private WebElement globalSearchButton;

	/**
	 * @return the globalSearch
	 */
	public WebElement getGlobalSearchButton(int timeOut) {
		return isDisplayed(driver, globalSearchButton, "Visibility", timeOut, "Global Search Button");
	}

	@FindBy(xpath = "//a[@title='Developer Console (New Window)']")
	private WebElement devConsoleLink;

	/**
	 * @return the devConsoleLink
	 */
	public WebElement getDevConsoleLink(int timeOut) {
		return isDisplayed(driver, devConsoleLink, "Visibility", timeOut, "Dev Console");
	}

	@FindBy(xpath = "//span[text()='Execute']")
	private WebElement executeButton;

	/**
	 * @return the executeButton
	 */
	public WebElement getExecuteButton(int timeOut) {
		return isDisplayed(driver, executeButton, "Visibility", timeOut, "Execute Button");
	}

	@FindBy(xpath = "//div[@id='recordscountACTALT']")
	private WebElement recordCountOnHomePage;

	/**
	 * @return the recordCountOnHomePage
	 */
	public WebElement getRecordCountOnHomePage(int timeOut) {
		return isDisplayed(driver, recordCountOnHomePage, "Visibility", timeOut, "Record Count");
	}

	@FindBy(xpath = "(//a[@title='Show All'])[1]")
	private WebElement showAllLinkFWR;

	@FindBy(xpath = "(//a[@title='Show All'])[2]")
	private WebElement showAllLinkINV;

	@FindBy(xpath = "//a[@title='Show All']")
	private WebElement showAllLink;

	/**
	 * @return the showAllLink
	 */
	public WebElement getShowAllLink(Workspace workspace, int timeOut) {
		if (workspace != null && workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
			return isDisplayed(driver, showAllLinkFWR, "Visibility", timeOut, "Show All Link");
		} else if (workspace != null && workspace.toString().equalsIgnoreCase(Workspace.InvestorWorkspace.toString())) {
			return isDisplayed(driver, showAllLinkINV, "Visibility", timeOut, "Show All Link");
		} else {
			return isDisplayed(driver, showAllLink, "Visibility", timeOut, "Show All Link");
		}
	}

	public WebElement getRecordCountAlertHistoryPopUp(Workspace workspace, int timeOut) {
		String workspaceSelector = "";
		if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
			workspaceSelector = "FR";
		} else {
			workspaceSelector = "INV";
		}
		return isDisplayed(driver, FindElement(driver, "//div[@id='recordscountACTALT" + workspaceSelector + "']",
				"Record Count", action.BOOLEAN, 30), "Visibility", timeOut, "record Count");
	}

	@FindBy(xpath = "//img[@title='Next']/..")
	private WebElement nextImageonPage;

	/**
	 * @return the nextImageonPage
	 */
	public WebElement getNextImageonPage(int timeOut) {
		return isDisplayed(driver, nextImageonPage, "Visibility", timeOut, "Next Image");
	}

	@FindBy(xpath = "//span[@id='gridDivRecords']")
	private WebElement investorRecordCount;

	/**
	 * @return the investorRecordCount
	 */
	public WebElement getInvestorRecordCount(int timeOut) {
		return isDisplayed(driver, investorRecordCount, "Visibility", timeOut, "Investor Files Record Count");
	}

	// PE

	@FindBy(xpath = "//li[@id='MoreTabs_Tab']")
	private WebElement moreTabIConClassic;

	@FindBy(xpath = "//input[@name='save']")
	private WebElement saveButtonClassic;

//	@FindBy(xpath = "(//button[@title='Save' or text()='Save'])[2]")

	@FindBy(xpath = "//button[@title='Save' or text()='Save'][@name='SaveEdit']")

	private WebElement saveButtonLighting;

	/**
	 * @return the saveButton
	 */
	public WebElement getSaveButton(int timeOut) {
		return isDisplayed(driver, saveButtonLighting, "Visibility", timeOut, "Save Button Lighting");

	}

	@FindBy(xpath = "//div[@class='forceListViewManagerGrid']//div[contains(@class,'uiScroller')]")
	private WebElement scrollBoxforPageGrid;

	/**
	 * @return the scrollBoxforPageGrid
	 */
	public WebElement getScrollBoxforPageGrid(String environment, String mode, int timeOut) {
		return isDisplayed(driver, scrollBoxforPageGrid, "Visibility", timeOut, "Scroll Box for Page Grid");
	}

	@FindBy(xpath = "//button[@title='Refresh']")
	private WebElement refrshActivity;

	/**
	 * @return the scrollBoxforPageGrid
	 */
	public WebElement getrefrshActivity(String projectName, int timeOut) {
		return isDisplayed(driver, refrshActivity, "Visibility", timeOut, "refrshActivity");
	}

	@FindBy(xpath = "//button[@title='Select a List View']")
	private WebElement selectListIcon_Lighting;

	/**
	 * @return the selectListIcon_Lighting
	 */
	public WebElement getSelectListIcon(int timeOut) {
		return isDisplayed(driver, selectListIcon_Lighting, "Visibility", timeOut, "Select List Icon");
	}

	/**
	 * @return the select list label
	 */
	public WebElement getSelectListLabelLink(String labelName, int timeOut) {
		String xpath = "//li[contains(@class,'slds-dropdown__item has-icon--left')]//span[text()='" + labelName
				+ "']/..";
		WebElement ele = FindElement(driver, xpath, "select list label", action.SCROLLANDBOOLEAN, timeOut);
		return isDisplayed(driver, ele, "Visibility", timeOut, "Select List label");
	}

	/* return all links of select list icon option list */
	public List<WebElement> getAllLinkOfSelectListIconOption(String mode, String tabName, int timeOut) {
		String xpath;
		if (mode.equalsIgnoreCase(Mode.Classic.toString())) {

			xpath = "//select[@id='fcf'][@title='View:']/option";
		} else {

			xpath = "//ul[@aria-label='" + tabName + " | List Views']/li/a/span";
		}
		return FindElements(driver, xpath, "Select list icon link");
	}

	@FindBy(xpath = "//input[contains(@name,'search-input')]")
	private WebElement searchIcon_Lighting;

	/**
	 * @return the searchIcon_Lighting
	 */
	public WebElement getSearchIcon_Lighting(int timeOut) {
		return isDisplayed(driver, searchIcon_Lighting, "Visibility", timeOut, "Search Icon Lighting");
	}

	@FindBy(xpath = "//a[@class='switch-to-lightning']")
	private WebElement switchToLightingLink;

	/**
	 * @return the switchToLightingLink
	 */
	public WebElement getSwitchToLightingLink(int timeOut) {
		return isDisplayed(driver, switchToLightingLink, "Visibility", timeOut, "Switch To Lighting Link");
	}

	@FindBy(xpath = "//label[@for='lksrch']/following-sibling::input[@name='lksrch']")
	private WebElement lookUpSearchTextBox;

	/**
	 * @return the lookUpSearchTextBox
	 */
	public WebElement getLookUpSearchTextBox(int timeOut) {
		return isDisplayed(driver, lookUpSearchTextBox, "Visibility", timeOut, "look up search text box");
	}

	@FindBy(xpath = "//label[@for='lksrch']/following-sibling::input[@name='go']")
	private WebElement lookUpSearchGoBtn;

	/**
	 * @return the lookUpSearchGoBtn
	 */
	public WebElement getLookUpSearchGoBtn(int timeOut) {
		return isDisplayed(driver, lookUpSearchGoBtn, "Visibility", timeOut, "look up search go button");
	}

	@FindBy(xpath = "//frame[@title='Search']")
	private WebElement lookUpSearchSectionFrame;

	/**
	 * @return the lookUpSearchSectionFrame
	 */
	public WebElement getLookUpSearchFrame(int timeOut) {
		return isDisplayed(driver, lookUpSearchSectionFrame, "Visibility", timeOut, "look up search frame");
	}

	@FindBy(xpath = "//frame[@title='Results']")
	private WebElement lookUpResultFrame;

	/**
	 * @return the lookUpResultFrame
	 */
	public WebElement getLookUpResultFrame(int timeOut) {
		return isDisplayed(driver, lookUpResultFrame, "Visibility", timeOut, "look up result frame");
	}

	public WebElement getCreateFundRaisingBtn(String environment, String mode, PageName pageName, int timeOut) {
		WebElement ele = null;
		String xpath = "";
		if (mode.toString().equalsIgnoreCase(Mode.Lightning.toString())) {
			xpath = "button";
		} else {
			xpath = "input";
		}
		return isDisplayed(driver,
				FindElement(driver, "//" + xpath + "[text()='Bulk Fundraising' or @title='Bulk Fundraising']",
						"Create Fundraising button on " + pageName, action.SCROLLANDBOOLEAN, timeOut),
				"Visibility", timeOut, "Create Fundraising button on " + pageName);
	}

	@FindBy(xpath = "//div[@id='OnloadPopup']//a[@title='Close']/img")
	private WebElement selectFundPopUpCrossIcon;

	/**
	 * @return the selectFundPopUpCrossIcon
	 */
	public WebElement getSelectFundPopUpCrossIcon(int timeOut) {
		return isDisplayed(driver, selectFundPopUpCrossIcon, "Visibility", timeOut, "select fund pop up cross icon");
	}

	@FindBy(xpath = "//span[@title='Deals Sourced']/..")
	private WebElement dataSourcedLink;

	/**
	 * @return the dataSourcedLink
	 */
	public WebElement getDataSourcedLink(int timeOut) {
		return isDisplayed(driver, dataSourcedLink, "Visibility", timeOut, "data source link");
	}

	@FindBy(xpath = "//h3[text()='Activity History']/ancestor::div[@class='bRelatedList']//div[@class='pbBody']//tr//th")
	private WebElement activityHistoryNoRecordsToDisplayMsg_Classic;

	@FindBy(xpath = "//div[contains(@class,'emptyListContent')]")
	private WebElement activityHistoryNoRecordsToDisplayMsg_Lighting;

	/**
	 * @return the getActivityHistoryNoRecordsToDisplay
	 */
	public WebElement getActivityHistoryNoRecordsToDisplay(String environment, String mode, int timeOut) {
		if (mode.equalsIgnoreCase(Mode.Classic.toString())) {
			return isDisplayed(driver, activityHistoryNoRecordsToDisplayMsg_Classic, "Visibility", timeOut,
					"No Records to Display Classic");
		} else {
			return isDisplayed(driver, activityHistoryNoRecordsToDisplayMsg_Lighting, "Visibility", timeOut,
					"No Past Activity Lighting");
		}

	}

	@FindBy(xpath = "//h3[text()='Open Activities']/ancestor::div[@class='bRelatedList']//div[@class='pbBody']//tr//th")
	private WebElement openActivityNoRecordsToDisplayMsg_Classic;

	@FindBy(xpath = "//div[contains(@class,'openActivities')]//span")
	private WebElement openActivityNoRecordsToDisplayMsg_Lighting;

	/**
	 * @return the getOpenActivitiesNoRecordsToDisplay
	 */
	public WebElement getOpenActivitiesNoRecordsToDisplay(String environment, String mode, int timeOut) {
		if (mode.equalsIgnoreCase(Mode.Classic.toString())) {
			return isDisplayed(driver, openActivityNoRecordsToDisplayMsg_Classic, "Visibility", timeOut,
					"No Records to Display Classic");
		} else {
			return isDisplayed(driver, openActivityNoRecordsToDisplayMsg_Lighting, "Visibility", timeOut,
					"No Open Activity Lighting");
		}

	}

	@FindBy(xpath = "//h3[text()='Activities']/ancestor::div[@class='bRelatedList']//div[@class='pbBody']//tr//th")
	private WebElement activitiesGridNoRecordsToDisplayMsg_Classic;

	@FindBy(xpath = "//span[text()='Activities']/following-sibling::span[@title='(0)']")
	private WebElement activitiesGridNoRecordsToDisplayMsg_Lighting;

	/**
	 * @return the getOpenActivitiesNoRecordsToDisplay
	 */
	public WebElement getActivitiesGridNoRecordsToDisplay(String environment, String mode, int timeOut) {
		if (mode.equalsIgnoreCase(Mode.Classic.toString())) {
			return isDisplayed(driver, activitiesGridNoRecordsToDisplayMsg_Classic, "Visibility", timeOut,
					"No Records to Display Classic");
		} else {
			return isDisplayed(driver, activitiesGridNoRecordsToDisplayMsg_Lighting, "Visibility", timeOut,
					"No Activities Lighting");
		}

	}

	@FindBy(xpath = "//h3[text()='Activities']/ancestor::div[@class='bRelatedList']//div[@class='pbBody']//tr//th")
	private WebElement relatedListWithCount_Classic;

	@FindBy(xpath = "//span[text()='Activities']/following-sibling::span[@title='(0)']")
	private WebElement relatedListWithCount_Lighting;

	/**
	 * @return the getOpenActivitiesNoRecordsToDisplay
	 */
	public WebElement getRelatedListWithCount(String environment, String mode, int timeOut) {
		if (mode.equalsIgnoreCase(Mode.Classic.toString())) {
			return isDisplayed(driver, relatedListWithCount_Classic, "Visibility", timeOut, "Related List");
		} else {
			return isDisplayed(driver, relatedListWithCount_Lighting, "Visibility", timeOut, "No Activities Lighting");
		}

	}

	public WebElement getCreateCommitmentsBtn(String environment, String mode, PageName pageName, int timeOut) {
		WebElement ele = null;
		String xpath = "";
		if (mode.toString().equalsIgnoreCase(Mode.Lightning.toString())) {
			xpath = "a";
		} else {
			xpath = "input";
		}
		return isDisplayed(driver,
				FindElement(driver, "//" + xpath + "[@title='Create Commitments']",
						"Create Commitments button on " + pageName, action.BOOLEAN, timeOut),
				"Visibility", timeOut, "Create Commitments button on " + pageName);
	}

	@FindBy(xpath = "//h2[@class='topName']")
	private WebElement labelHeaderText;

	@FindBy(xpath = "//div[contains(@class,'outputName')]")
	private WebElement labelHeaderText_Lightning;

	/**
	 * @return the labelHeaderText
	 */
	public WebElement getLabelHeaderText(String environment, String mode, int timeOut) {
		if (mode.equalsIgnoreCase(Mode.Lightning.toString())) {
			return isDisplayed(driver, labelHeaderText_Lightning, "Visibility", timeOut, "label header text");
		} else {
			return isDisplayed(driver, labelHeaderText, "Visibility", timeOut, "label header text");

		}
	}

	@FindBy(xpath = "//div[@id='TotalComm']/span")
	private WebElement totalCommitment;

	/**
	 * @return the totalCommitment
	 */
	public WebElement getTotalCommitment(int timeOut) {
		return isDisplayed(driver, totalCommitment, "Visibility", timeOut, "Total commitment");
	}

	@FindBy(xpath = "//div[@id='TotalCapital']")
	private WebElement totalRecallableCapital;

	/**
	 * @return the totalRecallablecapital
	 */
	public WebElement getTotalRecallablecapital(int timeOut) {
		return isDisplayed(driver, totalRecallableCapital, "Visibility", timeOut, "Total recallableCapital");
	}

	@FindBy(xpath = "//div[@id='RecallCapital']")
	private WebElement totalCapitalCalled;

	/**
	 * @return the totalCapitalCalled
	 */
	public WebElement getTotalCapitalCalled(int timeOut) {
		return isDisplayed(driver, totalCapitalCalled, "Visibility", timeOut, "Total Capital Called");
	}

	@FindBy(xpath = "//span[text()='Amount']/preceding-sibling::input")
	private WebElement amountRadioButton;

	/**
	 * @return the amountRadioButton
	 */
	public WebElement getAmountRadioButton(int timeOut) {
		return isDisplayed(driver, amountRadioButton, "Visibility", timeOut, "Amount Radio button");
	}

	@FindBy(xpath = "//span[text()='Percentage']/preceding-sibling::input")
	private WebElement percentageRadioButton;

	/**
	 * @return the percentageRadioButton
	 */
	public WebElement getPercentageRadioButton(int timeOut) {
		return isDisplayed(driver, percentageRadioButton, "Visibility", timeOut, "percentage Radio Button");
	}

	@FindBy(xpath = "//td[text()='Capital Amount']/following-sibling::td/input[@id='txtCapitalAmt']")
	private WebElement capitalAmount;

	/**
	 * @return the capitalAmount
	 */
	public WebElement getCapitalAmount(int timeOut) {
		return isDisplayed(driver, capitalAmount, "Visibility", timeOut, "Capital Amount");
	}

	@FindBy(xpath = "//td[text()='Capital Amount']/following-sibling::td/input[@id='txtCapitalPercent']")
	private WebElement capitalAmountPercent;

	/**
	 * @return the capitalAmountPercent
	 */
	public WebElement getCapitalAmountPercent(int timeOut) {
		return isDisplayed(driver, capitalAmountPercent, "Visibility", timeOut, "Capital Amount Percentage");
	}

	@FindBy(xpath = "//td[text()='Management Fee']/following-sibling::td/input[@id='txtManagementFeeAmt']")
	private WebElement managemanetFeesAmt;

	/**
	 * @return the managemanetFeesAmt
	 */
	public WebElement getManagemanetFeesAmt(int timeOut) {
		return isDisplayed(driver, managemanetFeesAmt, "Visibility", timeOut, "Management Fees Amount");
	}

	@FindBy(xpath = "//td[text()='Management Fee']/following-sibling::td/input[@id='txtManagementFeePercent']")
	private WebElement managementFeesPercent;

	/**
	 * @return the managementFeesPercent
	 */
	public WebElement getManagementFeesPercent(int timeOut) {
		return isDisplayed(driver, managementFeesPercent, "Visibility", timeOut, "Management Fees Percentage");
	}

	@FindBy(xpath = "//td[text()='Other Fee']/following-sibling::td/input[@id='txtOtherFeeAmt']")
	private WebElement otherFeesAmt;

	/**
	 * @return the otherFeesAmt
	 */
	public WebElement getOtherFeesAmt(int timeOut) {
		return isDisplayed(driver, otherFeesAmt, "Visibility", timeOut, "Other Fees Amount");
	}

	@FindBy(xpath = "//td[text()='Other Fee']/following-sibling::td/input[@id='txtOtherFeePercent']")
	private WebElement otherFeesPercentage;

	/**
	 * @return the otherFeesPercentage
	 */
	public WebElement getOtherFeesPercentage(int timeOut) {
		return isDisplayed(driver, otherFeesPercentage, "Visibility", timeOut, "Other Fees Percentage");
	}

	@FindBy(xpath = "//td[text()='Capital Call']/following-sibling::td//span[contains(@id,'capitalcallId')]")
	private WebElement capitalCall;

	/**
	 * @return the capitalCall
	 */
	public WebElement getCapitalCall(int timeOut) {
		return isDisplayed(driver, capitalCall, "Visibility", timeOut, "Capital Call");
	}

	@FindBy(xpath = "//td[text()='Call Date']/following-sibling::td//input")
	private WebElement drawDownCallDate;

	/**
	 * @return the callDate
	 */
	public WebElement getDrawDownCallDate(int timeOut) {
		return isDisplayed(driver, drawDownCallDate, "Visibility", timeOut, "Call Date");
	}

	@FindBy(xpath = "//td[text()='Call Date']/following-sibling::td//input")
	private WebElement drawDownDueDate;

	/**
	 * @return the dueDate
	 */
	public WebElement getDrawDownDueDate(int timeOut) {
		return isDisplayed(driver, drawDownDueDate, "Visibility", timeOut, "Due Date");
	}

	@FindBy(xpath = "//span[text()='Setup Capital Calls']")
	private WebElement setupCapitalCallsButton;

	/**
	 * @return the setupCapitalCallsButton
	 */
	public WebElement getSetupCapitalCallsButton(int timeOut) {
		return isDisplayed(driver, setupCapitalCallsButton, "Visibility", timeOut, "Setup Capital Call button");
	}

	@FindBy(xpath = "//input[@id='txtTotalPercent']")
	private WebElement totalPercentage;

	/**
	 * @return the totalPercentage
	 */
	public WebElement getTotalPercentage(int timeOut) {
		return isDisplayed(driver, totalPercentage, "Visibility", timeOut, "Total Percentage text box");
	}

	@FindBy(xpath = "//input[contains(@id,'txtCallDate')]/following-sibling::span")
	private WebElement todaysCallDate;

	/**
	 * @return the todaysCallDate
	 */
	public WebElement getTodaysCallDate(int timeOut) {
		return isDisplayed(driver, todaysCallDate, "Visibility", timeOut, "Call Date today");
	}

	@FindBy(xpath = "//span[text()='People']")
	private WebElement peopleTabOnTagged;

	/**
	 * @return the todaysCallDate
	 */
	public WebElement getPeopleTabOnTagged(int timeOut) {
		return isDisplayed(driver, peopleTabOnTagged, "Visibility", timeOut, "People Tab On Tagged");
	}
	
	@FindBy(xpath = "//input[contains(@id,'txtDueDate')]/following-sibling::span")
	private WebElement todaysDueDate;

	/**
	 * @return the todaysDueDate
	 */
	public WebElement getTodaysDueDate(int timeOut) {
		return isDisplayed(driver, todaysDueDate, "Visibility", timeOut, "Due date today");
	}

	@FindBy(xpath = "//input[contains(@id,'txtDueDate')]")
	private WebElement dueDateTextBox;

	/**
	 * @return the dueDateTextBox
	 */
	public WebElement getDueDateTextBox(int timeOut) {
		return isDisplayed(driver, dueDateTextBox, "Visibility", timeOut, "Due Date Text Box");
	}

	@FindBy(xpath = "//div[contains(@class,'slds-template_iframe')]//iframe[@title='accessibility title']")
	private WebElement createFundraisingsFrame_Lighting;

	/**
	 * @return the createFundraisingsFrame_Lighting
	 */
	public WebElement getCreateFundraisingsFrame_Lighting(int timeOut) {
		return isDisplayed(driver, createFundraisingsFrame_Lighting, "Visibility", timeOut,
				"create fundraisings frame on lighting");
	}

	@FindBy(xpath = "//tr[contains(@class,'dataRow')]")
	private List<WebElement> totalCapitalCalls;

	/**
	 * @return the totalCapitalCalls
	 */
	public List<WebElement> getTotalCapitalCalls() {
		return totalCapitalCalls;
	}

	@FindBy(xpath = "//span[text()='Generate Capital Calls']")
	private WebElement generateCapitalCallsButton;

	/**
	 * @return the generateCapitalCallsButton
	 */
	public WebElement getGenerateCapitalCallsButton(int timeOut) {
		return isDisplayed(driver, generateCapitalCallsButton, "Visibility", timeOut, "Generate capital call");
	}

	@FindBy(xpath = "//span[text()='Target Commitments (mn)']/../following-sibling::div/span/span")
	private WebElement targetCommitmentAmount_Lightning;

	@FindBy(xpath = "//td[text()='Target Commitments (mn)']/following-sibling::td/div")
	private WebElement targetCommitmentAmount_Classic;

	/**
	 * @return the targetCommitmentAmount
	 */
	public WebElement getTargetCommitmentAmount(String mode, int timeOut) {
		if (mode.equalsIgnoreCase(Mode.Lightning.toString())) {
			return isDisplayed(driver, targetCommitmentAmount_Lightning, "Visibility", timeOut,
					"Target Commitment Amount");
		} else {
			return isDisplayed(driver, targetCommitmentAmount_Classic, "Visibility", timeOut,
					"Target Commitment Amount");
		}
	}

	@FindBy(xpath = "//span[text()='Total Commitments (mn)']/../following-sibling::div/span/span")
	private WebElement totalCommitmentsAmount_Lightning;

	@FindBy(xpath = "//td[text()='Total Commitments (mn)']/following-sibling::td/div")
	private WebElement totalCommitmentAmount_Classic;

	/**
	 * @return the totalCommitmentsAmount_Lightning
	 */
	public WebElement getTotalCommitmentsAmount(String mode, int timeOut) {
		if (mode.equalsIgnoreCase(Mode.Lightning.toString())) {
			return isDisplayed(driver, totalCommitmentsAmount_Lightning, "Visibility", timeOut,
					"Total Commitment Amount");
		} else {
			return isDisplayed(driver, totalCommitmentAmount_Classic, "Visibility", timeOut, "Total Commitment Amount");
		}
	}

	@FindBy(xpath = "//span[text()='Remaining Commitments (mn)']/../following-sibling::div/span/span")
	private WebElement remainingCommitmentAmount_Lighting;

	@FindBy(xpath = "//td[text()='Remaining Commitments (mn)']/following-sibling::td/div")
	private WebElement remainingCommitmentAmount_Classic;

	/**
	 * @return the remainingCommitmentAmount_Lighting
	 */
	public WebElement getRemainingCommitmentAmount(String mode, int timeOut) {
		if (mode.equalsIgnoreCase(Mode.Lightning.toString())) {
			return isDisplayed(driver, remainingCommitmentAmount_Lighting, "Visibility", timeOut,
					"Remaining Commitment Amount");
		} else {
			return isDisplayed(driver, remainingCommitmentAmount_Classic, "Visibility", timeOut,
					"Remaining Commitment Amount");
		}
	}

	@FindBy(xpath = "//span[text()='Total Capital Called (mn)']/../following-sibling::div/span/span")
	private WebElement totalCapitalCalled_Lightning;

	@FindBy(xpath = "//td[text()='Total Capital Called (mn)']/following-sibling::td/div")
	private WebElement totalCapitalCalled_Classic;

	/**
	 * @return the totalCapitalCalled_lightning
	 */
	public WebElement getTotalCapitalCalled(String mode, int timeOut) {
		if (mode.equalsIgnoreCase(Mode.Lightning.toString())) {
			return isDisplayed(driver, totalCapitalCalled_Lightning, "Visibility", timeOut,
					"Total Commitment Called Amount");
		} else {
			return isDisplayed(driver, totalCapitalCalled_Classic, "Visibility", timeOut,
					"Total Commitment Called Amount");
		}
	}

	@FindBy(xpath = "//span[text()='Total Recallable Capital (mn)']/../following-sibling::div/span/span")
	private WebElement totalRecallableCapitalAmount_Lightning;

	@FindBy(xpath = "//td[text()='Total Recallable Capital (mn)']/following-sibling::td/div")
	private WebElement totalRecallableCapitalAmount_Classic;

	/**
	 * @return the totalRecallableCapitalAmount
	 */
	public WebElement getTotalRecallableCapitalAmount(String mode, int timeOut) {
		if (mode.equalsIgnoreCase(Mode.Lightning.toString())) {
			return isDisplayed(driver, totalRecallableCapitalAmount_Lightning, "Visibility", timeOut,
					"Total Recallable capital Amount");
		} else {
			return isDisplayed(driver, totalRecallableCapitalAmount_Classic, "Visibility", timeOut,
					"Total Recallable capital Amount");
		}
	}

	@FindBy(xpath = "//button[@title='Personalize your nav bar']")
	private WebElement personalizePencilIcon;

	/**
	 * @return the personalizePencilIcon
	 */
	public WebElement getPersonalizePencilIcon(int timeOut) {
		return isDisplayed(driver, personalizePencilIcon, "Visibility", timeOut, "Personalize Pencil Icon");

	}

	@FindBy(xpath = "//button[contains(text(),'Add More Items')]")
	private WebElement addMoreItemsLink;

	/**
	 * @return the addMoreItemsLink
	 */
	public WebElement getAddMoreItemsLink(int timeOut) {
		return isDisplayed(driver, addMoreItemsLink, "Visibility", timeOut, "Add More Items");

	}

	@FindBy(xpath = "//div[@role='list']//a[text()='All']")
	private WebElement allAddLink;

	/**
	 * @return the allAddLink
	 */
	public WebElement getAllAddLink(int timeOut) {
		return isDisplayed(driver, allAddLink, "Visibility", timeOut, "Add More Items");

	}

	@FindBy(xpath = "//button/span[contains(text(),'Add')]")
	private WebElement addNavButton;

	/**
	 * @return the addNavButton
	 */
	public WebElement getAddNavButton(int timeOut) {
		return isDisplayed(driver, addNavButton, "Visibility", timeOut, "Add Nav Button");

	}

	@FindBy(xpath = "//div[@data-aura-class='oneEditMyNav']/../following-sibling::div//button/span[contains(text(),'Save')]")
	private WebElement tabSaveButton;

	/**
	 * @return the addNavButton
	 */
	public WebElement getTabSaveButton(int timeOut) {
		return isDisplayed(driver, tabSaveButton, "Visibility", timeOut, "tAB Save Button");

	}

	@FindBy(xpath = "//input[@value='Tag Documents']")
	private WebElement tagDocsButton;

	public WebElement gettagDocsButton(int timeOut) {
		return isDisplayed(driver, tagDocsButton, "Visibility", timeOut, "tagDocsButton");

	}

	public WebElement getMoreTabIcon(String environment, String mode, int timeOut) {
		if (mode.equalsIgnoreCase(Mode.Classic.toString())) {
			return isDisplayed(driver, moreTabIConClassic, "Visibility", timeOut, "More Tab ICon Classic");
		} else {
			return isDisplayed(driver, moreTabIConLighting, "Visibility", timeOut, "More Tab ICon Lighting");
		}
	}

	/***************************************
	 * Activity Association
	 **************************************/
	@FindBy(xpath = "//a[text()='Users']/../button")
	private WebElement expandUserIcon_Lighting;

	/**
	 * @return the expandManageUserIcon
	 */
	public WebElement getExpandUserIcon(int timeOut) {
		return isDisplayed(driver, expandUserIcon_Lighting, "Visibility", timeOut, "Expand User Icon");
	}

	/////////////////////////////////////////////////// Activity Association
	/////////////////////////////////////////////////// /////////////////////////////

	@FindBy(xpath = "//span[contains(text(),'More')]/..//lightning-primitive-icon")
	private WebElement moreTabIConLighting;

	public WebElement getMoreTabIcon(String projectName, int timeOut) {
		return isDisplayed(driver, moreTabIConLighting, "Visibility", timeOut, "More Tab ICon Lighting");
	}

	@FindBy(xpath = "//*[@title='New']/parent::a")
	private WebElement newButtonLighting;

	/**
	 * @return the newButton
	 */
	public WebElement getNewButton(String projectName, int timeOut) {
		ThreadSleep(5000);
		return newButtonLighting;

	}

	@FindBy(xpath = "//div[contains(@class,'actionsContainer') or contains(@class,'forceModalActionContainer')]//button/span[text()='Save']")
	private WebElement saveButtonLighting1;

	/**
	 * @return the saveButton
	 */
	public WebElement getSaveButton(String projectName, int timeOut) {

		return isDisplayed(driver, saveButtonLighting1, "Visibility", timeOut, "Save Button Lighting");
	}

	@FindBy(xpath = "//span[text()='Next']")
	private WebElement nextButton1;

	/**
	 * @return the continueButton
	 */
	public WebElement getContinueOrNextButton(String projectName, int timeOut) {

		return isDisplayed(driver, nextButton1, "Visibility", timeOut, "Next Button");

	}

	@FindBy(xpath = "//div[@title='New Task with Multiple Associations']/..")
	private WebElement buttonNewTaskMultiple;

	/**
	 * @return the saveButton
	 */
	public WebElement getButtonNewTaskMultipleAssociations(String projectName, int timeOut) {

		return isDisplayed(driver, buttonNewTaskMultiple, "Visibility", timeOut, "buttonNewTaskMultiple");
	}

	@FindBy(xpath = "//div[@title='Log a Call with Multiple Associations']/..")
	private WebElement buttonLogCallMultiple;

	public WebElement getButtonLogCallMultiple(String projectName, int timeOut) {

		return isDisplayed(driver, buttonLogCallMultiple, "Visibility", timeOut, "buttonLogCallMultiple");
	}

	public WebElement getstatusDropdownInCreateNewTask(String projectName, int timeOut) {
		String xpath = returnXpathOfDropdownInTaskPage(PageLabel.Status.toString());
		return isDisplayed(driver, FindElement(driver, xpath, "Status", action.SCROLLANDBOOLEAN, timeOut), "Visibility",
				timeOut, "statusDropdownInCreateNewTask");
	}

	@FindBy(xpath = "//div[@title='User']/span/span[2]/span")
	private WebElement createNewTaskAssignedTo;

	public WebElement getcreateNewTaskAssignedTo(String projectName, int timeOut) {

		return isDisplayed(driver, createNewTaskAssignedTo, "Visibility", timeOut, "createNewTaskAssignedTo");
	}

	/*
	 * @FindBy(xpath = "//label[text()='Subject']/..//input") private WebElement
	 * createNewTaskSubjectTextbox;
	 * 
	 * public WebElement getcreateNewTaskSubjectTextbox(String projectName,int
	 * timeOut) {
	 * 
	 * return isDisplayed(driver, createNewTaskSubjectTextbox, "Visibility",
	 * timeOut, "createNewTaskSubjectTextbox"); }
	 */
	@FindBy(xpath = "//span[text()='Name']/ancestor::label/following-sibling::div//input")
	private WebElement nameTextBoxInNewTask;

	public WebElement getnameTextBoxInNewTask(String projectName, int timeOut) {

		return isDisplayed(driver, nameTextBoxInNewTask, "Visibility", timeOut, "nameTextBoxInNewTask");
	}

	@FindBy(xpath = "//span[text()='Due Date']/..//following-sibling::div//input")
	private WebElement dueDateTextBoxInNewTask;

	@FindBy(xpath = "//label[text()='Due Date Only']/..//input")
	private WebElement dueDateTextBoxInNewTask1;

	public WebElement getdueDateTextBoxInNewTask(String projectName, int timeOut) {
		WebElement ele = isDisplayed(driver, dueDateTextBoxInNewTask, "Visibility", timeOut, "dueDateTextBoxInNewTask");
		;
		if (ele != null) {
			return ele;
		} else {

		}
		return isDisplayed(driver, dueDateTextBoxInNewTask1, "Visibility", timeOut, "dueDateTextBoxInNewTask");
	}

	public String returnXpathOfDropdownInTaskPage(String field) {

		return "//label[text()='" + field + "']/following-sibling::div//input";
	}

	public WebElement getmeetingTypeDropdown(String projectName, int timeOut) {
		String xpath = returnXpathOfDropdownInTaskPage(PageLabel.Meeting_Type.toString());
		return isDisplayed(driver, FindElement(driver, xpath, "Meeting Type", action.SCROLLANDBOOLEAN, timeOut),
				"Visibility", timeOut, "meetingTypeDropdown");
	}

	public WebElement getPriorityDropdown(String projectName, int timeOut) {
		String xpath = returnXpathOfDropdownInTaskPage(PageLabel.Priority.toString());
		return isDisplayed(driver, FindElement(driver, xpath, "priority", action.SCROLLANDBOOLEAN, timeOut),
				"Visibility", timeOut, "priority Dropdown");
	}

	public List<WebElement> relatedAssociations(String projectName) {
		return FindElements(driver, "//div[@id='relatedAssociation']//div[contains(@id,'objDropdown')]/div",
				"All Commitments Custom Fields");
	}

	@FindBy(xpath = "//*[text()='Comments']/../..//textarea")
	private WebElement commentsTextBox;

	public WebElement getcommentsTextBox(String projectName, int timeOut) {

		return isDisplayed(driver, commentsTextBox, "Visibility", timeOut, "commentsTextBox");
	}

	@FindBy(xpath = "//div[@id='relatedAssociation']//input")
	private WebElement relationAssociationsTextbox;

	public WebElement getrelatedAssociationsTextbox(String projectName, int timeOut) {

		return isDisplayed(driver, relationAssociationsTextbox, "Visibility", timeOut, "relationAssociationsTextbox");
	}

	@FindBy(xpath = "//div[contains(@class,'dropdownButton')]//button")
	private WebElement relatedAssociationsdropdownButton;

	public WebElement getrelatedAssociationsdropdownButton(String projectName, int timeOut) {

		return isDisplayed(driver, relatedAssociationsdropdownButton, "Visibility", timeOut,
				"relatedAssociationsdropdownButton");
	}

	@FindBy(xpath = "//button[@title='Save']/preceding-sibling::button[@title='Cancel']")
	private WebElement cancelButton1;

	public WebElement getcancelButton(String projectName, int timeOut) {

		return isDisplayed(driver, cancelButton1, "Visibility", timeOut, "cancelButton");
	}

	@FindBy(xpath = "//a[@title='Refresh']")
	private WebElement refresh;

	public WebElement getrefreshButton(String projectName, int timeOut) {

		return isDisplayed(driver, refresh, "Visibility", timeOut, "refresh");
	}

	@FindBy(xpath = "//div[@class='cActivityTab']/following-sibling::iframe")
	private WebElement meetingOrActivitiesFrame;

	/**
	 * @return the meetingFrameOnContactPage
	 */
	public WebElement getmeetingOrActivitiesFrame(String projectName, int timeOut) {
		return isDisplayed(driver, meetingOrActivitiesFrame, "Visibility", timeOut, "meetingOrActivitiesFrame");
	}

	public List<WebElement> createdRelatedAssociationsOnWindow(String projectName) {
		List<WebElement> e = FindElements(driver, "//div[@id='RelatedAsspopupID']//a", "created related associations");
		return e;
	}

	@FindBy(xpath = "//img[@id='lefttorightenableActivitySearchpage']")
	private WebElement moveToSelectedColToDisplay;

	public WebElement getmoveToSelectedColToDisplay(String projectName, int timeOut) {
		return isDisplayed(driver, moveToSelectedColToDisplay, "Visibility", timeOut, "moveToSelectedColToDisplay");
	}

	@FindBy(xpath = "//img[@id='righttoleftenableActivitySearchpage']")
	private WebElement moveToAvailableColToDisplay;

	public WebElement getmoveToAvailableColToDisplay(String projectName, int timeOut) {
		return isDisplayed(driver, moveToAvailableColToDisplay, "Visibility", timeOut, "moveToAvailableColToDisplay");
	}

	public WebElement getOkButtonRAorComment(String projectName, String relatedOrComment, int timeOut) {
		String id = "", xpath = "";
		if (relatedOrComment.equalsIgnoreCase("Comment"))
			id = "commentpopupID";
		else if (relatedOrComment.equalsIgnoreCase("CN"))
			id = "conDIVid";
		else
			id = "RelatedAsspopupID";
		xpath = "//div[@id='" + id + "']//following-sibling::div//button[text()='OK']";
		return isDisplayed(driver, FindElement(driver, xpath, "ok button", action.BOOLEAN, timeOut), "Visibility",
				timeOut, "createdRelAssocOkButton");
	}

	public WebElement getCrossIconRAorComment(String projectName, String relatedOrComment, int timeOut) {
		String id = "", xpath = "";
		if (relatedOrComment.equalsIgnoreCase("Comment"))
			id = "page:form:commentid";
		else if (relatedOrComment.equalsIgnoreCase("CN"))
			id = "page:form:contactpopupid";
		else
			id = "page:form:RleatedAssociationpopupid";
		xpath = "//span[@id='" + id + "']//a[@title='Close']";
		return isDisplayed(driver, FindElement(driver, xpath, "cross button", action.BOOLEAN, timeOut), "Visibility",
				timeOut, "createdRelAssocCrossIcon");
	}

	@FindBy(xpath = "//span[@id='page:form:field1']")
	private WebElement commentsTextOnPopup;

	public WebElement getcommentsTextOnPopup(String projectName, int timeOut) {
		return isDisplayed(driver, commentsTextOnPopup, "Visibility", timeOut, "commentsTextOnPopup");
	}

	public WebElement geDropdownOnTaskPopUp(String projectName, String label, action action, int timeOut) {
		String xpath = returnXpathOfDropdownInTaskPage(label);
		WebElement ele = FindElement(driver, xpath, label, action, timeOut);
		return isDisplayed(driver, ele, "Visibility", timeOut, "Drop Down : " + label);
	}

	public WebElement getDropdownOnTaskPopUp(String projectName, PageName pageName, String label, action action,
			int timeOut) {
		String xpath = "";
		label = label.replace("_", " ");
		if (PageName.TaskPage.toString().equals(pageName.toString())
				|| PageName.NewEventPopUp.toString().equals(pageName.toString()))
		// ||PageName.CallPopUp.toString().equals(pageName.toString()) ||
		// PageName.Meet.toString().equals(pageName.toString()))
		{
			xpath = "//span[text()='" + label + "']/../following-sibling::div//a";

		} else if (PageName.Object2Page.toString().equals(pageName.toString())) {
			xpath = "//span[text()='" + label + "']/../following-sibling::div//a";

		} else {
			xpath = "//label[text()='" + label + "']/following-sibling::div//input";
		}

		WebElement ele = FindElement(driver, xpath, label, action, timeOut);
		return isDisplayed(driver, ele, "Visibility", timeOut, "Drop Down : " + label);
	}

	@FindBy(xpath = "//a[@title='Columns to Display']")
	private WebElement wrenchIcon;

	public WebElement getwrenchIcon(String projectName, int timeOut) {
		return isDisplayed(driver, wrenchIcon, "Visibility", timeOut, "wrenchIcon");
	}

	@FindBy(xpath = "//div[@id='displayFilterText1']//img")
	private WebElement advancedFilterImg;

	public WebElement getadvancedFilterImg(String projectName, int timeOut) {
		return isDisplayed(driver, advancedFilterImg, "Visibility", timeOut, "advancedFilterImg");
	}

	@FindBy(xpath = "(//*[contains(@title,'more action')])[1]")
	private WebElement showMoreActionButton;

	public WebElement getShowMoreActionButton(String projectName, int timeOut) {

		return isDisplayed(driver, showMoreActionButton, "Visibility", timeOut, "show More Action Button");
	}

	@FindBy(xpath = "//select[@id='rangeid']")
	private WebElement rangeDropdown;

	public WebElement getrangeDropdown(String projectName, int timeOut) {

		return isDisplayed(driver, rangeDropdown, "Visibility", timeOut, "rangeDropdown");
	}

	@FindBy(xpath = "//input[@id='checkActivityid']")
	private WebElement activitiesCheckbox;

	public WebElement getactivitiesCheckbox(String projectName, int timeOut) {

		return isDisplayed(driver, activitiesCheckbox, "Visibility", timeOut, "activitiesCheckbox");
	}

	@FindBy(xpath = "//input[@id='checkAttchmentid']")
	private WebElement attachmentCheckbox;

	public WebElement getattachmentCheckbox(String projectName, int timeOut) {

		return isDisplayed(driver, attachmentCheckbox, "Visibility", timeOut, "attachmentCheckbox");
	}

	@FindBy(xpath = "//input[@id='SearchContent']//preceding-sibling::img[@title='Search']")
	private WebElement searchIconActivities;

	public WebElement getsearchIconActivities(String projectName, int timeOut) {

		return isDisplayed(driver, searchIconActivities, "Visibility", timeOut, "searchIcon");
	}

	@FindBy(xpath = "//input[@id='SearchContent']")
	private WebElement searchTextbox;

	public WebElement getsearchTextboxActivities(String projectName, int timeOut) {

		return isDisplayed(driver, searchTextbox, "Visibility", timeOut, "searchTextbox");
	}

	@FindBy(xpath = "//span[@id='ClearSearch']//img")
	private WebElement searchCrossActivities;

	public WebElement getsearchCrossActivities(String projectName, int timeOut) {

		return isDisplayed(driver, searchCrossActivities, "Visibility", timeOut, "searchCross");
	}

	@FindBy(xpath = "//span[contains(@class,'toastMessage')]")
	private WebElement createdConfirmationMsg;

	public WebElement getCreatedConfirmationMsg(String projectName, int timeOut) {

		return isDisplayed(driver, createdConfirmationMsg, "Visibility", timeOut, "Created Confirmation Msg");
	}

	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement cancelButton;

	/**
	 * @return the cancelButton
	 */
	public WebElement getCancelButton(String projectName, int timeOut) {
		List<WebElement> eleList = FindElements(driver, "//button[text()='Cancel']", "cancelButton");
		for (int i = 0; i < eleList.size(); i++) {
			WebElement ele = eleList.get(i);
			ele = isDisplayed(driver, ele, "Visibility", timeOut, "cancelButton");
			if (ele != null) {
				return ele;
			} else {
				if (i == eleList.size() - 1) {
					return ele;
				}
			}
		}

		return isDisplayed(driver, cancelButton, "Visibility", timeOut, "Cancel");
	}

	@FindBy(xpath = "//button[@title='Close this window']")
	private WebElement crossIcon;

	public WebElement getcrossIcon(String projectName, int timeOut) {
		List<WebElement> eleList = FindElements(driver, "//button[@title='Close this window']", "crossIcon");
		for (int i = 0; i < eleList.size(); i++) {
			WebElement ele = eleList.get(i);
			ele = isDisplayed(driver, ele, "Visibility", timeOut, "crossIcon");
			if (ele != null) {
				return ele;
			} else {
				if (i == eleList.size() - 1) {
					return ele;
				}
			}
		}

		return isDisplayed(driver, crossIcon, "Visibility", timeOut, "crossIcon");
	}

	@FindBy(xpath = "//button[@title='Close']")
	private WebElement crossIconAcuity;

	public WebElement getcrossIconAcuity(String projectName, int timeOut) {
		List<WebElement> eleList = FindElements(driver, "//button[@title='Close']", "crossIcon");
		for (int i = 0; i < eleList.size(); i++) {
			WebElement ele = eleList.get(i);
			ele = isDisplayed(driver, ele, "Visibility", timeOut, "crossIcon");
			if (ele != null) {
				return ele;
			} else {
				if (i == eleList.size() - 1) {
					return ele;
				}
			}
		}

		return isDisplayed(driver, crossIcon, "Visibility", timeOut, "crossIcon");
	}

	@FindBy(xpath = "//div[@class='cActivityTab']/following-sibling::iframe")
	private WebElement meetingFrameOnContactPage;

	/**
	 * @return the meetingFrameOnContactPage
	 */
	public WebElement getMeetingFrameOnContactPage(String projectName, int timeOut) {
		return isDisplayed(driver, meetingFrameOnContactPage, "Visibility", timeOut, "Meeting frame on Contact Page");
	}

	@FindBy(xpath = "//div[@title='New Meeting']")
	private WebElement newMeetingButton;

	/**
	 * @return the newMeetingButton
	 */
	public WebElement getNewMeetingButton(String projectName, int timeOut) {
		return isDisplayed(driver, newMeetingButton, "Visibility", timeOut, "New Meeting Button on Contact Page");
	}

	@FindBy(xpath = "//a[@id='_rtdeActivitySearchpage']/preceding-sibling::button")
	private WebElement cancelButtonOnColumnsToDisplay;

	public WebElement getCancelButtonOnColumnsToDisplay(String projectName, int timeOut) {

		return isDisplayed(driver, cancelButtonOnColumnsToDisplay, "Visibility", timeOut,
				"cancelButtonOnColumnsToDisplay");
	}

	public WebElement getsearchTextboxColToDisplay(String projectName, int timeOut) {
		String xpath = "//input[@id='searchcon_grid1ActivitySearchpage']";
		return isDisplayed(driver, FindElement(driver, xpath, "searchTextbox", action.SCROLLANDBOOLEAN, timeOut),
				"Visibility", timeOut, "searchTextbox");
	}

	@FindBy(xpath = "//div[@id='wrenchpopup1ActivitySearchpage']//img[@title='Search']")
	private WebElement searchIconColToDisplay;

	public WebElement getsearchIconColToDisplay(String projectName, int timeOut) {

		return isDisplayed(driver, searchIconColToDisplay, "Visibility", timeOut, "searchIcon");
	}

	@FindBy(xpath = "//span[@id='clearsearchenb1ActivitySearchpage']//div[@title='Clear']//img")
	private WebElement searchCrossColToDisplay;

	public WebElement getsearchCrossColToDisplay(String projectName, int timeOut) {

		return isDisplayed(driver, searchCrossColToDisplay, "Visibility", timeOut, "searchCross");
	}

	@FindBy(id = "msgBlankId")
	private WebElement pleaseEnterAValueMsg;

	public WebElement getpleaseEnterAValueMsg(String projectName, int timeOut) {

		return isDisplayed(driver, pleaseEnterAValueMsg, "Visibility", timeOut, "pleaseEnterAValueMsg");
	}

	@FindBy(xpath = "//a[@id='closebtn']")
	private WebElement crossIconColToDisplay;

	public WebElement getcrossIconColToDisplay(String projectName, int timeOut) {

		return isDisplayed(driver, crossIconColToDisplay, "Visibility", timeOut, "crossIconColToDisplay");
	}

	@FindBy(xpath = "//div[@id='displayFilterText1']//img")
	private WebElement advancedFilterToggle;

	public WebElement getadvancedFilterToggle(String projectName, int timeOut) {

		return isDisplayed(driver, advancedFilterToggle, "Visibility", timeOut, "advancedFilterToggle");
	}

	@FindBy(xpath = "//a[@title='Search Activities/Attachments Settings']//img")
	private WebElement searchActAttach;

	public WebElement getsearchActAttach(String projectName, int timeOut) {

		return isDisplayed(driver, searchActAttach, "Visibility", timeOut, "searchActAttach");
	}

	public List<WebElement> getfilterHeadings(String projectName, int timeOut) {

		return FindElements(driver, "//div[@id='SearchGridDiv1']//h3", "filterHeadings");
	}

	@FindBy(xpath = "//input[@name='page:form:advancefilterid:adv_cmp:j_id60']")
	private WebElement insuffOKButton;

	public WebElement getinsuffOKButton(String projectName, int timeOut) {

		return isDisplayed(driver, insuffOKButton, "Visibility", timeOut, "insuffOKButton");
	}

	@FindBy(xpath = "//div[contains(@class,'InsufficientPermissions')]//a[@title='Close']")
	private WebElement insuffCrossButton;

	public WebElement getinsuffCrossButton(String projectName, int timeOut) {

		return isDisplayed(driver, insuffCrossButton, "Visibility", timeOut, "insuffCrossButton");
	}

	public WebElement getrevertToDefaultColToDisplay(String projectName, EnableDisable ed, int timeOut) {
		String xpath = "", e = "";
		if (ed == EnableDisable.Disable)
			e = "active";
		xpath = "//a[@id='_rtde" + e + "ActivitySearchpage']";
		return isDisplayed(driver, FindElement(driver, xpath, "revertToDefault", action.SCROLLANDBOOLEAN, timeOut),
				"Visibility", timeOut, "revertToDefault");
	}

	public WebElement getApplyColToDisplay(String projectName, EnableDisable ed, int timeOut) {
		String xpath = "", e = "";
		if (ed == EnableDisable.Disable)
			e = "deactve";
		xpath = "//a[@id='_apply" + e + "ActivitySearchpage']";
		return isDisplayed(driver, FindElement(driver, xpath, "Apply", action.SCROLLANDBOOLEAN, timeOut), "Visibility",
				timeOut, "Apply");
	}

	public WebElement getMoveUpColToDisplay(String projectName, EnableDisable ed, int timeOut) {
		String xpath = "", e = "";
		if (ed == EnableDisable.Disable)
			e = "disable";
		else
			e = "enable";
		xpath = "//img[@id='moveup" + e + "ActivitySearchpage']";
		return isDisplayed(driver, FindElement(driver, xpath, "Apply", action.SCROLLANDBOOLEAN, timeOut), "Visibility",
				timeOut, "Apply");
	}

	public WebElement getMoveDownColToDisplay(String projectName, EnableDisable ed, int timeOut) {
		String xpath = "", e = "";
		if (ed == EnableDisable.Disable)
			e = "disable";
		else
			e = "enable";
		xpath = "//img[@id='movedown" + e + "ActivitySearchpage']";
		return isDisplayed(driver, FindElement(driver, xpath, "down", action.SCROLLANDBOOLEAN, timeOut), "Visibility",
				timeOut, "down");
	}

	public WebElement getMoveTopColToDisplay(String projectName, EnableDisable ed, int timeOut) {
		String xpath = "", e = "";
		if (ed == EnableDisable.Disable)
			e = "disable";
		else
			e = "enable";
		xpath = "//img[@id='top" + e + "ActivitySearchpage']";
		return isDisplayed(driver, FindElement(driver, xpath, "top", action.SCROLLANDBOOLEAN, timeOut), "Visibility",
				timeOut, "top");
	}

	public WebElement getMoveBottomColToDisplay(String projectName, EnableDisable ed, int timeOut) {
		String xpath = "", e = "";
		if (ed == EnableDisable.Disable)
			e = "disable";
		else
			e = "enable";
		xpath = "//img[@id='bottom" + e + "ActivitySearchpage']";
		return isDisplayed(driver, FindElement(driver, xpath, "Bottom", action.SCROLLANDBOOLEAN, timeOut), "Visibility",
				timeOut, "Bottom");
	}

	@FindBy(xpath = "//div[contains(@class,'InsufficientPermissions')]//div[@class='PopupContentStart']")
	private WebElement insufficientErrorMsg;

	public WebElement getinsufficientErrorMsg(String projectName, int timeOut) {

		return isDisplayed(driver, insufficientErrorMsg, "Visibility", timeOut, "insufficientErrorMsg");
	}

	@FindBy(xpath = "//a[@id='advanceflter_AddRowNew']")
	private WebElement addRowFilter;

	public WebElement getaddRowFilter(String projectName, int timeOut) {

		return isDisplayed(driver, addRowFilter, "Visibility", timeOut, "addRowFilter");
	}

	@FindBy(xpath = "//a[@title='Add Filter Logic']")
	private WebElement filterLogicLink;

	public WebElement getfilterLogicLink(String projectName, int timeOut) {

		return isDisplayed(driver, filterLogicLink, "Visibility", timeOut, "filterLogicLink");
	}

	public WebElement clearApplyButtonOnAdvancedFilter(String projectName, String clearOrApply, int timeOut) {
		if (clearOrApply.equalsIgnoreCase("Apply"))
			clearOrApply = "Apply";
		else if (clearOrApply.equalsIgnoreCase("Clear"))
			clearOrApply = "Clear";
		String xpath = "//div[@id='filterGridContactDiv1']//a[@title='" + clearOrApply + "']";
		return isDisplayed(driver, FindElement(driver, xpath, "clearOrApply link", action.BOOLEAN, timeOut),
				"Visibility", timeOut, "clearOrApply link");
	}

	public WebElement getEditButton(String projectName, int timeOut) {
		return isDisplayed(driver, editButton_Lighting, "Visibility", timeOut, "Edit Button Lighting");
	}

	public List<WebElement> getCrossIconOfSelectedItem(String label, int timeOut) {

		String xpath = "//span[text()='" + label
				+ "']/ancestor::label/following-sibling::div//li//a[@class='deleteAction']";
		return FindElements(driver, xpath, "delete icon cross icon");
	}

	public List<WebElement> getDropdownListOnSearchActivitiesAttachmentSettings(String projectName, int timeOut) {
		String xpath = "//td[@class='td2']//select[contains(@name,'page:form:advancefilterid')]";
		return FindElements(driver, xpath, "dropdown list");
	}

	public WebElement getTextBoxInSearchActAttachSettings(String projectName, LeftRight lr, int count, int timeOut) {
		String side = lr.toString().toLowerCase();
		String xpath = "//input[@id='activityinput" + side + "colmn" + count + "']";

		return isDisplayed(driver, FindElement(driver, xpath, "textbox", action.SCROLLANDBOOLEAN, timeOut),
				"Visibility", timeOut, "textbox in search activities/attachments");
	}

	public boolean selectSuggestionInTextboxInSearchActAttach(String projectName, String field, int timeOut) {
		String xpath = "//ul//li//a//span[text()='" + field + "']";
		WebElement ele = FindElement(driver, xpath, "field suggestion", action.BOOLEAN, timeOut);
		ele = isDisplayed(driver, ele, "visibility", timeOut, "field suggestion");
		if (click(driver, ele, "field suggestion", action.BOOLEAN)) {
			return true;
		} else
			return false;
	}

	public WebElement getPlusIconInSearchActAttach(String projectName, LeftRight lr, int count, int timeOut) {
		String xpath = "";
		if (count == 1) {
			if (lr == LeftRight.Right)
				xpath = "//a[@id='Auto_activityinputrighRow']";
			else
				xpath = "//a[@id='Auto_activityinputleftRow']";
		} else
			xpath = "//a[@id='Auto_activity" + lr.toString() + "RowCount" + count + "']";
		return isDisplayed(driver, FindElement(driver, xpath, "textbox", action.SCROLLANDBOOLEAN, timeOut),
				"Visibility", timeOut, "plus icon in search activities/attachments");
	}

	@FindBy(xpath = "//span[contains(@id,'page:form:advancefilterid:adv_cmp')]//a[@title='Close']")
	private WebElement crossIconForSearchActivitiesAttachment;

	public WebElement getcrossIconForSearchActivitiesAttachment(String projectName, int timeOut) {
		return isDisplayed(driver, crossIconForSearchActivitiesAttachment, "Visibility", timeOut,
				"crossIconForSearchActivitiesAttachment");
	}

	@FindBy(xpath = "//input[@title='Cancel']")
	private WebElement cancelForSearchActivitiesAttachment;

	public WebElement getcancelForSearchActivitiesAttachment(String projectName, int timeOut) {
		return isDisplayed(driver, cancelForSearchActivitiesAttachment, "Visibility", timeOut,
				"cancelForSearchActivitiesAttachment");
	}

	public WebElement revertToDefaultsSearchActivitiesAttachment(String projectName, EnableDisable ed, int timeOut) {
		String xpath = "", i = "";
		if (ed == EnableDisable.Disable)
			i = "de";
		xpath = "//button[@title='Revert to Default'][@id='" + i + "activebtn']";
		return isDisplayed(driver, FindElement(driver, xpath, "textbox", action.SCROLLANDBOOLEAN, timeOut),
				"Visibility", timeOut, "revert to default search activities/attachments");

	}

	public WebElement getCrossIconOfTextboxInSearchActivitiesAttachment(String projectName, LeftRight lr, int count,
			int timeOut) {
		String side = lr.toString().toLowerCase();
		String xpath = "//input[@id='activityinput" + side + "colmn" + count
				+ "']/..//following-sibling::a[@title='Delete']";
		return isDisplayed(driver, FindElement(driver, xpath, "textbox", action.SCROLLANDBOOLEAN, timeOut),
				"Visibility", timeOut, "cross icon beside search activities/attachments");
	}

	public WebElement getWarningPopupSearchActivitiesAttachmentYesOrNo(String projectName, YesNo yn, int timeOut) {
		String xpath = "//div[@id='WarningPopUpId']//input[@value='" + yn.toString() + "']";
		return isDisplayed(driver, FindElement(driver, xpath, "textbox", action.SCROLLANDBOOLEAN, timeOut),
				"Visibility", timeOut, "yes/no warning popup search activities/attachments");
	}

	@FindBy(xpath = "//div[@id='WarningPopUpId']//div[@class='PopupContentStart']")
	private WebElement revertToDefaultErrorPopup;

	public WebElement getrevertToDefaultErrorPopup(String projectName, int timeOut) {
		return isDisplayed(driver, revertToDefaultErrorPopup, "Visibility", timeOut, "revertToDefaultErrorPopup");
	}

	@FindBy(xpath = "//div[@id='addFilterlogic']//a[@class='helpLink']")
	private WebElement infoLink;

	/**
	 * @return the infoLink
	 */
	public WebElement getInfoLink(String projectName, int timeOut) {
		return isDisplayed(driver, infoLink, "Visibility", timeOut, "Info Link");
	}

	public List<WebElement> getRowRemoveIcon() {
		return FindElements(driver, "//img[@title='Remove Row']", "remove icon");
	}

	@FindBy(xpath = "//img[@title='Remove Row']")
	private WebElement rowRemoveIcon1;

	/**
	 * @return the addFilterLogicLink
	 */
	public WebElement getRowRemoveIcon1(String projectName, int timeOut) {
		return isDisplayed(driver, rowRemoveIcon1, "Visibility", timeOut, "Remove Row Icon");
	}

	@FindBy(xpath = "//a[text()='Add Filter Logic']")
	private WebElement addFilterLogicLink;

	/**
	 * @return the addFilterLogicLink
	 */
	public WebElement getAddFilterLogicLink(String projectName, int timeOut) {
		return isDisplayed(driver, addFilterLogicLink, "Visibility", timeOut, "Add Filter Logic Link");
	}

	@FindBy(xpath = "//a[text()='Clear Filter Logic']")
	private WebElement clearFilterLogicLink;

	/**
	 * @return the addFilterLogicLink
	 */
	public WebElement getClearFilterLogicLink(String projectName, int timeOut) {
		return isDisplayed(driver, clearFilterLogicLink, "Visibility", timeOut, "Clear Filter Logic Link");
	}

	@FindBy(xpath = "//label[text()='Filter Logic']/following-sibling::input")
	private WebElement filterLogicInputBox;

	/**
	 * @return the addFilterLogicLink
	 */
	public WebElement getFilterLogicInputBox(String projectName, int timeOut) {
		return isDisplayed(driver, filterLogicInputBox, "Visibility", timeOut, "Filter Logic Input Box");
	}

	/**
	 * @return the radioButtonforNewInstitution
	 */
	public WebElement getRadioButtonforRecordType(String recordType, int timeOut) {
		String xpath = "//div[@class='changeRecordTypeRow']//span[text()='" + recordType + "']/../..//input";
		WebElement ele = null;
		ele = FindElement(driver, xpath, "radio button of record type " + recordType, action.SCROLLANDBOOLEAN, timeOut);
		ele = isDisplayed(driver, ele, "visibility", timeOut, "radio button of record type " + recordType);
		if (ele != null) {
			return ele;
		} else {
			xpath = "//fieldset//span[contains(text(),'" + recordType + "')]/preceding-sibling::span";
			ele = FindElement(driver, xpath, "radio button of record type " + recordType, action.SCROLLANDBOOLEAN,
					timeOut);
			return isDisplayed(driver, ele, "visibility", timeOut, "radio button of record type " + recordType);
		}

	}

	/**
	 * @return the radioButtonforNewInstitution
	 */
	public WebElement getRadioButtonforRecordType(String recordType, boolean creationFromTaskLayout, int timeOut) {
		String class1 = "";
		if (creationFromTaskLayout)
			class1 = "flexipageComponent";
		else
			class1 = "changeRecordTypeRow";
		String xpath = "//div[@class='" + class1 + "']//span[text()='" + recordType + "']/../..//input";
		WebElement ele = null;
		ele = FindElement(driver, xpath, "radio button of record type " + recordType, action.SCROLLANDBOOLEAN, timeOut);
		return isDisplayed(driver, ele, "visibility", timeOut, "radio button of record type " + recordType);
	}

	public WebElement getRadioButtonforRecordTypeNavigationPopup(String recordType, int timeOut) {
		String class1 = "";
		String xpath = "//span[text()='" + recordType + "']/preceding-sibling::input";
		WebElement ele = null;
		ele = FindElement(driver, xpath, "radio button of record type " + recordType, action.SCROLLANDBOOLEAN, timeOut);
		return isDisplayed(driver, ele, "visibility", timeOut, "radio button of record type " + recordType);
	}

	public List<WebElement> createdRelatedContactNameOnPopUp(String projectName) {
		List<WebElement> e = FindElements(driver, "//div[@id='conDIVid']//a", "created Contact Name Popup");
		return e;
	}

	@FindBy(xpath = "//frame[@title='Results']")
	private WebElement emailUploadPageFrame;

	/**
	 * @return the addFilterLogicLink
	 */
	public WebElement getDeleteButton(String projectName, int timeOut) {
		WebElement ele = null;

		String xpath = "//*[@title='Delete' or text()='Delete']";
		List<WebElement> list = FindElements(driver, xpath, "Delete Button");

		for (WebElement element : list) {
			ele = isDisplayed(driver, element, "Visibility", timeOut, "Delete Button");
			if (ele != null) {

				ele = element;
				break;
			}

		}
		return ele;
	}

	@FindBy(xpath = "//input[@title='Clone']")
	private WebElement cloneButton;

	public WebElement getcloneButton(String projectName, int timeOut) {
		return isDisplayed(driver, cloneButton, "Visibility", timeOut, "clone Button");
	}

	@FindBy(xpath = "//div//h1/div[contains(text(),'Event')]/..")
	private WebElement eventName;

	public WebElement geteventName(String projectName, int timeOut) {
		return isDisplayed(driver, eventName, "Visibility", timeOut, "event Name");
	}

	public WebElement clickOnDocumentOnEmailPage(String projectName, String docName, int timeOut) {
		String xpath = "//span[@title='" + docName + "']";
		return isDisplayed(driver, FindElement(driver, xpath, "document", action.BOOLEAN, timeOut), "visibility",
				timeOut, "document");
	}

	@FindBy(xpath = "//a[@title='Send List Email']")
	private WebElement sendListEmail;

	public WebElement getsendListEmail(String projectName, int timeOut) {
		return isDisplayed(driver, sendListEmail, "Visibility", timeOut, "sendListEmail Button");
	}

	public WebElement getAnyMsg(String projectName, String msg, int timeOut) {
		String xpath = "//*[contains(text(),'" + msg + "')]";
		WebElement ele = FindElement(driver, xpath, msg, action.SCROLLANDBOOLEAN, timeOut);
		return ele;
	}

	@FindBy(xpath = "//*[text()='Edit Name']/..")
	private WebElement editName;

	public WebElement getEditName(String projectName, int timeOut) {
		return isDisplayed(driver, editName, "Visibility", timeOut, "Edit Name");
	}

	/**
	 * @return the addFilterLogicLink
	 */
	public WebElement getDeleteButtonPopUp(String projectName, int timeOut) {
		WebElement ele = null;

		String xpath = "//div[contains(@class,'forceModalActionContainer')]//button[@title='Delete' or text()='Delete']";
		List<WebElement> list = FindElements(driver, xpath, "Delete Button PopUp");

		for (WebElement element : list) {
			ele = isDisplayed(driver, element, "Visibility", timeOut, "Delete Button PopUp");
			if (ele != null) {

				ele = element;
				break;
			}

		}
		return ele;
	}

	@FindBy(xpath = "//div[contains(@class,'forceModalActionContainer')]//button[@title='Delete']")

	private WebElement deleteButtonOnDeletePopUp;

	/**
	 * @return the deleteButtonOnDeletePopUp
	 */

	public WebElement getDeleteButtonOnDeletePopUp(String projectName, int timeOut) {
		return isDisplayed(driver, deleteButtonOnDeletePopUp, "Visibility", timeOut, "Delete Button on Delete Popup");
	}

	@FindBy(xpath = "//h2[contains(text(),'Delete')]/../following-sibling::div//*[@title='Cancel']")
	private WebElement cancelButtonOnDeletePopUp;

	/**
	 * @return the deleteButtonOnDeletePopUp
	 */

	public WebElement getCancelButtonOnDeletePopUp(String projectName, int timeOut) {
		return isDisplayed(driver, cancelButtonOnDeletePopUp, "Visibility", timeOut, "cancel Button on Delete Popup");
	}

	@FindBy(xpath = "//button[@title='List View Controls']")
	private WebElement listViewControls;

	public WebElement getlistViewControlsButton(String projectName, int timeOut) {
		return isDisplayed(driver, listViewControls, "Visibility", timeOut, "listViewControlsButton");
	}

	@FindBy(xpath = "//li//a//span[text()='New']")
	private WebElement newButtonListView;

	/**
	 * @return the addFilterLogicLink
	 */
	public WebElement getnewButtonListView(String projectName, int timeOut) {
		return isDisplayed(driver, newButtonListView, "Visibility", timeOut, "newButtonListView");
	}

	public WebElement getlistNameTextBox(String projectName, String listNameOrListAPIName, int timeOut) {

		String xpath = "//label[text()='" + listNameOrListAPIName + "']//following-sibling::div//input";

		return isDisplayed(driver, FindElement(driver, xpath, "listNameTextBox", action.SCROLLANDBOOLEAN, timeOut),
				"Visibility", timeOut, "listNameTextBox");
	}

	@FindBy(xpath = "//span[contains(text(),'All users')]/../preceding-sibling::input")
	private WebElement allUsersCheckbox;

	/**
	 * @return the addFilterLogicLink
	 */
	public WebElement getallUsersRB(String projectName, int timeOut) {
		return isDisplayed(driver, allUsersCheckbox, "Visibility", timeOut, "allUsersCheckbox");
	}

	@FindBy(xpath = "//h2[text()='New List View']/../..//span[text()='Save']/..")
	private WebElement listViewSaveButton;

	public WebElement getlistViewSaveButton(String projectName, int timeOut) {
		return isDisplayed(driver, listViewSaveButton, "Visibility", timeOut, "listViewSaveButton");
	}

	/**
	 * @return the folrulaTextBox
	 */
	public WebElement getOfficeLocationSDGLink(int timeOut) {

		WebElement ele = FindElement(driver, "//a[text()='Office Location']", "office Location SDG Link",
				action.BOOLEAN, timeOut);
		scrollDownThroughWebelement(driver, ele, "office Location SDG Link");

		return isDisplayed(driver, ele, "Visibility", timeOut, "office Location SDG Link");
	}

	@FindBy(xpath = "//*[text()='Details']")
	private WebElement detailsTab_Lighting;

	/**
	 * @param environment
	 * @param timeOut
	 * @return
	 */
	public WebElement getdetailsTab_Lighting(String environment, TabName TabName, int timeOut) {
		return isDisplayed(driver, detailsTab_Lighting, "Visibility", timeOut, "Details Tab");
	}

	public WebElement getdoneButton(String projectName, int timeOut) {
		return driver.findElement(By.xpath("//div[@class='modal-footer slds-modal__footer']//button[@type='submit']"));
	}

	@FindBy(xpath = "//div[contains(@class,'SecondaryDisplayManager')]//button[text()='Save']")
	private WebElement filterSave;

	public WebElement getfilterSave(String projectName, int timeOut) {
		return isDisplayed(driver, filterSave, "Visibility", timeOut, "filterSave");
	}

	@FindBy(xpath = "//div[contains(@class,'slds-grid primaryFieldRow')]//*[text()='Show more actions']/../..")
	// @FindBy(xpath = "//div[@id='completeDiv' and
	// @class='cActivityTimeline']/..//img")
	private WebElement activityLineItemsDropdown;

	public WebElement getactivityLineItemsDropdown(String projectName, int timeOut) {
		return isDisplayed(driver, activityLineItemsDropdown, "Visibility", timeOut, "activityLineItemsDropdown");
	}

	@FindBy(xpath = "//div[@class='Next_steps']//h2[contains(text(),'Next Steps')]")
	private WebElement nextStepsHead;

	public WebElement getnextStepsHead(String projectName, int timeOut) {
		return isDisplayed(driver, nextStepsHead, "Visibility", timeOut, "nextStepsHead");
	}

	@FindBy(xpath = "//div[contains(@class,'past_activity')]")
	private WebElement pastActivitiesHead;

	public WebElement getpastActivitiesHead(String projectName, int timeOut) {
		return isDisplayed(driver, pastActivitiesHead, "Visibility", timeOut, "pastActivitiesHead");
	}

	@FindBy(xpath = "//div[contains(@class,'past_activity')]/following-sibling::div//div[contains(@class,'emptyListContent')]")
	private WebElement pastActivitiesMessage;

	public WebElement getpastActivitiesMessage(String projectName, int timeOut) {
		return isDisplayed(driver, pastActivitiesMessage, "Visibility", timeOut, "pastActivitiesMessage");
	}

	@FindBy(xpath = "//div[@class='Next_steps']//h2[contains(text(),'Next Steps')]/../following-sibling::div//div[contains(@class,'emptyListContent')]")
	private WebElement nextStepsMessage;

	public WebElement getnextStepsMessage(String projectName, int timeOut) {
		return isDisplayed(driver, nextStepsMessage, "Visibility", timeOut, "nextStepsMessage");
	}

	public WebElement moreStepsBtn(String projectName, EnableDisable ed, int timeOut) {
		String xpath = "";
		WebElement ele = null;
		if (EnableDisable.Disable == ed) {
			xpath = "//button[contains(@class,'moresteps')][@disabled='true']";
		} else
			xpath = "//h2[contains(text(),'Next Steps')]/following-sibling::button[contains(@class,'moresteps')]";
		ele = FindElement(driver, xpath, "more steps btn", action.BOOLEAN, timeOut);
		return isDisplayed(driver, ele, "Visibility", timeOut, "more steps btn");

	}

	public WebElement loadMorePastActivitiesBtn(String projectName, EnableDisable ed, int timeOut) {
		String xpath = "";
		int i;
		WebElement ele = null;
		if (EnableDisable.Disable == ed) {
			xpath = "//button[contains(text(),'More Past Activities')][@disabled='true']";
		} else
			xpath = "//button[contains(text(),'More Past Activities')]";
		ele = FindElement(driver, xpath, "loadMorePast", action.BOOLEAN, timeOut);
		return isDisplayed(driver, ele, "Visibility", timeOut, "loadMorePast");

	}

	@FindBy(xpath = "//button[contains(text(),'More Past Activities')]/following-sibling::div//button")
	private WebElement dropdownBtnMorePastAct;

	public WebElement dropdownBtnMorePastAct(String projectName, int timeOut) {
		return isDisplayed(driver, dropdownBtnMorePastAct, "Visibility", timeOut, "dropdown Btn of Load More Past Act");
	}

	@FindBy(xpath = "//input[contains(@title,'Search')]")
	private WebElement searchSalesforce;

	public WebElement getsearchSalesforce(String projectName, int timeOut) {
		return isDisplayed(driver, searchSalesforce, "Visibility", timeOut, "search Salesforce textbox");
	}

	@FindBy(xpath = "//div[@class='container']//div[@class='slds-modal__footer']//button/span[text()='Cancel']")
	private WebElement cancelBtnAtActivityTimeLineFilterPopuP;

	public WebElement getCancelBtnAtActivityTimeLineFilterPopuP(String projectName, int timeOut) {
		return isDisplayed(driver, cancelBtnAtActivityTimeLineFilterPopuP, "Visibility", timeOut,
				"cancel Btn At ActivityTimeLine Filter PopuP");
	}

	@FindBy(xpath = "//div[@class='container']//div[@class='slds-modal__footer']//button/span[text()='Apply']")
	private WebElement applyBtnAtActivityTimeLineFilterPopuP;

	public WebElement getApplyBtnAtActivityTimeLineFilterPopuP(String projectName, int timeOut) {
		return isDisplayed(driver, applyBtnAtActivityTimeLineFilterPopuP, "Visibility", timeOut,
				"Apply Btn At ActivityTimeLine Filter PopuP");
	}

	@FindBy(xpath = "//h2[contains(text(),'Delete')]/../following-sibling::div//div")
	private WebElement deleteTaskText;

	public WebElement getdeleteTaskText(String projectName, int timeOut) {
		return isDisplayed(driver, deleteTaskText, "Visibility", timeOut, "deleteTaskText");
	}

	public WebElement getCheckboxOfRestoreItemOnRecycleBin(String projectName, String restoreItem, int timeOut) {
		String xpath = "//span[@title='" + restoreItem + "']/../../preceding-sibling::td//input/..";
		return isDisplayed(driver,
				FindElement(driver, xpath, "checkbox : " + restoreItem, action.SCROLLANDBOOLEAN, timeOut), "visibility",
				timeOut, "checkbox");
	}

	@FindBy(xpath = "//div[@title='Restore']")
	private WebElement restoreButtonOnRecycleBin;

	public WebElement getRestoreButtonOnRecycleBin(String projectName, int timeOut) {
		return isDisplayed(driver, restoreButtonOnRecycleBin, "Visibility", timeOut, "restore Button On Recycle Bin");
	}

	@FindBy(xpath = "//div[@class='listRelatedObject setupBlock']//td//input[@title='New Values']")
	private WebElement newButtonOnMeetingType;

	public WebElement getNewButtonOnMeetingType(String projectName, int timeOut) {
		return isDisplayed(driver, newButtonOnMeetingType, "Visibility", timeOut, "new Button On Meeting Type");
	}

	@FindBy(xpath = "//textarea[@title='Meeting Type']")
	private WebElement meetingTypePickListValuesTextArea;

	public WebElement getMeetingTypePickListValuesTextArea(String projectName, int timeOut) {
		return isDisplayed(driver, meetingTypePickListValuesTextArea, "Visibility", timeOut,
				"meeting Type PickList Values TextArea");
	}

	@FindBy(xpath = "//iframe[@title='Activity Custom Field: Meeting Type ~ Salesforce - Enterprise Edition']")
	private WebElement meetingTypeFrame;

	@FindBy(xpath = "//iframe[@title='Add Picklist Values: Meeting Type ~ Salesforce - Enterprise Edition']")
	private WebElement addPickListMeetingTypeFrame;

	public WebElement verifyEvent(String projectName, String eventName, int timeOut) {
		String xpath = "//div//h1/div[contains(text(),'Event')]/..//*[text()='" + eventName + "']";
		return isDisplayed(driver, FindElement(driver, xpath, "event", action.SCROLLANDBOOLEAN, timeOut), "Visibility",
				timeOut, "event");

	}

	@FindBy(xpath = "//a[@title='New Meeting' and @class='actionClass newWindowCss']")
	private WebElement newMeetingNewTabIconAfterMouseHover;

	public WebElement getNewMeetingNewTabIconAfterMouseHover(String projectName, int timeOut) {
		return isDisplayed(driver, newMeetingNewTabIconAfterMouseHover, "Visibility", timeOut,
				"new Meeting New Tab Icon After MouseHover");
	}

	@FindBy(xpath = "//a[@class='headerLink']//button[@title='Close']")
	private WebElement pagePopUp;

	/**
	 * @return the searchIcon_Lighting
	 */
	public WebElement getPagePopUp(String projectName, int timeOut) {
		return isDisplayed(driver, pagePopUp, "Visibility", timeOut, "Page POP UP");
	}

	@FindBy(xpath = "//li[@data-aura-class='uiMenuItem onesetupSetupMenuItem']/a[@title='Edit Page']")
	private WebElement editPageOnSetUp;

	/**
	 * @return the userMenuSetupLink
	 */
	public WebElement getEditPageOnSetUp(int timeOut) {
		WebElement ele = null;
		ele = editPageOnSetUp;
		return isDisplayed(driver, ele, "Visibility", timeOut, "Edit Page");
	}

	@FindBy(xpath = "//*[text()='Status']/..//div//input")
	private WebElement statusDropDownList;

	/**
	 * @return the statusDropDownList
	 */
	public WebElement getStatus(String projectName, int timeOut) {
		return isDisplayed(driver, statusDropDownList, "Visibility", timeOut, "Status ");
	}

	@FindBy(xpath = "//*[@id='parentDiv']/div")
	private WebElement defaultImageXpath;

	public WebElement getDefaultImageXpath(int timeOut) {
		return isDisplayed(driver, defaultImageXpath, "Visibility", timeOut, "default image xpath");
	}

	@FindBy(xpath = "//*[contains(@data-component-id,'DisplayFieldSet')]//img")
	private WebElement uploadedImageRelativeXpath;

//	@FindBy(xpath = "//*[@id='parentDiv']//div[contains(@class,'imageIcon')]")
//	private WebElement updatePhotoCameraIcon;

	public WebElement getUploadedImageRelativeXpath(int timeOut) {
		return isDisplayed(driver, uploadedImageRelativeXpath, "Visibility", timeOut, "update photo camera icon");
	}

	public WebElement getUpdatePhotoCameraIcon(int timeOut) {

		String xpath = "//*[@id='parentDiv']//div[contains(@class,'imageIcon')]";
		WebElement ele = null;
		ele = FindElement(driver, xpath, "", action.SCROLLANDBOOLEAN, timeOut);
		if (ele != null) {
			((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('class','imageIcon show');", ele);
			xpath = "//*[@id='parentDiv']//div[contains(@class,'imageIcon show')]";
			ele = FindElement(driver, xpath, "", action.SCROLLANDBOOLEAN, timeOut);
			return isDisplayed(driver, ele, "Visibility", timeOut, "update photo camera icon");
		}
		return null;

	}

	public WebElement updateAndDeletePhotoXpath(IconType iconType, int timeOut) {
		String photo = "";
		if (iconType.toString().equalsIgnoreCase(IconType.updatePhoto.toString())) {
			photo = "Update Photo";
		} else {
			photo = "Delete Photo";
		}
		String xpath = "//*[@class='actionMenu']//a[@title='" + photo + "']";
		WebElement ele = FindElement(driver, xpath, "", action.SCROLLANDBOOLEAN, timeOut);
		return isDisplayed(driver, ele, "Visibility", timeOut, iconType + " xpath");
	}
	//// *[text()='Upload Files']
	// input[@name='fileUploader']

	@FindBy(xpath = "//input[@name='fileUploader']")
	private WebElement uploadImageXpath;

	public WebElement getUploadImageXpath(int timeOut) {
		return isDisplayed(driver, uploadImageXpath, "Visibility", timeOut, "upload image xpath");
	}

	@FindBy(xpath = "//div[@id='parentDiv']//img")
	private WebElement imgLink;

	public WebElement getimgLink(String projectName, int timeOut) {
		return isDisplayed(driver, imgLink, "Visibility", timeOut, "send Button on List Email");

	}

	public WebElement getImgForObject(String object, int timeOut) {
		String xpath = "//*[text()='" + object + "']/../../preceding-sibling::*//img";
		WebElement ele = FindElement(driver, xpath, "", action.SCROLLANDBOOLEAN, timeOut);
		return isDisplayed(driver, ele, "Visibility", timeOut, "img for " + object);
	}

	public WebElement getCustomNumberOfImg(String object, String record, int timeOut) {
		String xpath = "//article[contains(@class,'RelatedListAccordion')]//a[text()='" + object
				+ "']/../../../following-sibling::div//a[text()='" + record + "']/../preceding-sibling::div/*/*/*";
		WebElement ele = FindElement(driver, xpath, "", action.SCROLLANDBOOLEAN, timeOut);
		return isDisplayed(driver, ele, "Visibility", timeOut, "img for " + object);
	}

	@FindBy(xpath = "//*[@name='SaveEdit']")
	private WebElement navigationTabSaveBtn;

	public WebElement getNavigationTabSaveBtn(String projectName, int timeOut) {
		return isDisplayed(driver, navigationTabSaveBtn, "Visibility", timeOut, "Save Button");

	}

	@FindBy(xpath = "//div[@class='slds-global-header__logo']")
	private WebElement headerImg;

	public WebElement getHeaderImg(String projectName, int timeOut) {
		return isDisplayed(driver, headerImg, "Visibility", timeOut, "Header Image");

	}

	@FindBy(xpath = "//div[@class='forcePageError']/p")
	private WebElement invalidImageErrorMsg;

	public WebElement getInvalidImageErrorMsg(int timeOut) {
		return isDisplayed(driver, invalidImageErrorMsg, "Visibility", timeOut, "invalid image error message");
	}

	@FindBy(xpath = "//footer//*[text()='Cancel']")
	private WebElement cancelBtn;

	public WebElement getCancelBtn(int timeOut) {
		return isDisplayed(driver, cancelBtn, "Visibility", timeOut, "cancel button");
	}

	@FindBy(xpath = "//*[@data-aura-class='cFileUploader']//*[contains(@class,'slds-p-around_medium')]/div[2]")
	private WebElement uploadImageErrorMsg;

	public WebElement getUploadImageErrorMsg(int timeOut) {
		return isDisplayed(driver, uploadImageErrorMsg, "Visibility", timeOut, "upload image error message");
	}

	@FindBy(xpath = "//*[@data-aura-class='cFileUploader']//*[contains(@class,'slds-p-around_medium')]/div[4]/div")
	private WebElement currentPhotoText;

	public WebElement getCurrentPhotoText(int timeOut) {
		return isDisplayed(driver, currentPhotoText, "Visibility", timeOut, "current photo text message");
	}

	@FindBy(xpath = "//*[@data-aura-class='cFileUploader']//*[contains(@class,'slds-p-around_medium')]/div[5]")
	private WebElement UpdatePhotodefaultImageXpath;

	public WebElement getUpdatePhotodefaultImageXpath(int timeOut) {
		return isDisplayed(driver, UpdatePhotodefaultImageXpath, "Visibility", timeOut,
				"update photo default image xpath");
	}

	@FindBy(xpath = "//*[@data-aura-class='cFileUploader']//h2[text()='Update Photo']")
	private WebElement updatePhotoTextXpath;

	public WebElement getUpdatePhotoTextXpath(int timeOut) {
		return isDisplayed(driver, updatePhotoTextXpath, "Visibility", timeOut, "update photo text xpath");
	}

	@FindBy(xpath = "//*[@data-aura-class='cFileUploader']//*[text()='close']")
	private WebElement updatePhotoCrossIcon;

	public WebElement getUpdatePhotoCrossIcon(int timeOut) {
		return isDisplayed(driver, updatePhotoCrossIcon, "Visibility", timeOut, "update photo cross icon");
	}

	@FindBy(xpath = "//div[contains(@class,'deletePopup')]/div/div")
	private WebElement deletePhotoPopUpErrorMsg;

	public WebElement getDeletePhotoPopUpErrorMsg(int timeOut) {
		return isDisplayed(driver, deletePhotoPopUpErrorMsg, "Visibility", timeOut, "delete photo popup error message");
	}

	public WebElement deletePhotoPopUpCrossCancelDeleteButton(Buttons buttons, int timeOut) {
		String xpath = "";
		String button = buttons.toString().replace("_", " ");
		if (buttons.toString().equalsIgnoreCase(Buttons.close.toString())) {
			xpath = "//div[contains(@class,'deletePopup')]//button/span[text()='" + button + "']";
		} else {
			xpath = "//div[contains(@class,'deletePopup')]//button[text()='" + button + "']";
		}
		WebElement ele = FindElement(driver, xpath, "", action.SCROLLANDBOOLEAN, timeOut);
		return isDisplayed(driver, ele, "Visibility", timeOut, button + " delete popUp xpath ");

	}

	@FindBy(xpath = "//footer//button[@title='Close']")
	private WebElement footerCloseButton;

	public WebElement getfooterCloseButton(String projectName, int timeOut) {
		return isDisplayed(driver, footerCloseButton, "Visibility", timeOut, "footerCloseButton");

	}

	@FindBy(xpath = "//div[contains(@class,'sdgborder')]//button[@title='Save' or text()='Save']")
	private WebElement sdgSave;

	public WebElement getsdgSaveButton(String projectName, int timeOut) {
		return isDisplayed(driver, sdgSave, "Visibility", timeOut, "sdgSaveButton");

	}

	@FindBy(xpath = "//div[contains(@class,'sdgborder')]//button[@title='Cancel' or text()='Cancel']")
	private WebElement sdgCancel;

	public WebElement getsdgCancelButton(String projectName, int timeOut) {
		return isDisplayed(driver, sdgCancel, "Visibility", timeOut, "sdgCancelbutton");

	}

	@FindBy(xpath = "//a[@title='Upload Files']")
	private WebElement uploadFiles;

	public WebElement getuploadFilesButton(String projectName, int timeOut) {
		return isDisplayed(driver, uploadFiles, "Visibility", timeOut, "uploadFiles");

	}

	@FindBy(xpath = "//span[text()='Delete Photo']/..")
	private WebElement deletePhotoButton;

	public WebElement getdeletePhotoButton(String projectName, int timeOut) {
		return isDisplayed(driver, deletePhotoButton, "Visibility", timeOut, "deletePhotoButton");

	}

	@FindBy(xpath = "(//*[contains(text(),'Actions')]/../../..//following-sibling::div//button[@title='Reload.'])[2]")
	private WebElement actionsSDGRefresh;

	public WebElement getactionsSDGRefresh(String projectName, int timeOut) {
		return isDisplayed(driver, actionsSDGRefresh, "Visibility", timeOut, "actionsSDGRefresh");

	}

	@FindBy(xpath = "//h2[contains(@class,'inlineTitle')]")
	private WebElement taskPopUpHeader;

	@FindBy(xpath = "//h2[@id='modal-heading-01']")
	private WebElement taskPopUpHeader1;

	/**
	 * @return the navigationPopUpHeader
	 */
	public WebElement getTaskPopUpHeader(String projectName, int timeOut) {
		WebElement ele = isDisplayed(driver, taskPopUpHeader, "Visibility", timeOut, "tASK PopUp Header");

		if (ele == null) {
			return isDisplayed(driver, taskPopUpHeader1, "Visibility", timeOut, "tASK PopUp Header");

		} else
			return ele;
	}

	@FindBy(xpath = "//iframe[@title='Report Viewer']")
	private WebElement accountReferralFrame;

	@FindBy(xpath = "//iframe[@title='dashboard']")
	private WebElement dashboardFrame;
	@FindBy(xpath = "//iframe[contains(@title,'Record Type: Portfolio')]")
	private WebElement RTPortfolioCFrame;

	@FindBy(xpath = "//button[@title='Clear Selection']")
	private WebElement crossInSDGEdit;

	public WebElement getcrossInSDGEdit(String projectName, int timeOut) {
		return isDisplayed(driver, crossInSDGEdit, "Visibility", timeOut, "crossInSDGEdit");

	}

	/**
	 * @return the saveButton
	 */
	public WebElement getSaveButton(String environment, String mode, int timeOut) {
		ThreadSleep(2000);
		if (mode.equalsIgnoreCase(Mode.Classic.toString())) {
			return isDisplayed(driver, saveButtonClassic, "Visibility", timeOut, "Save Button Classic");
		} else {
			return isDisplayed(driver, saveButtonLighting, "Visibility", timeOut, "Save Button Lighting");
		}

	}

	@FindBy(xpath = "//span[@class='aw-bars-box ']")
	private WebElement emailProspectSelectProspectsGridScrollBox;

	/**
	 * @return the emailProspectSelectProspectsGridScrollBox
	 */
	public WebElement getEmailProspectSelectProspectsGridScrollBox(int timeOut) {
		return isDisplayed(driver, emailProspectSelectProspectsGridScrollBox, "Visibility", timeOut,
				"email prospect select prospect grid scroll box");
	}

	@FindBy(xpath = "(//div[@class='step_1']//a[@title='Next'])[2]")
	private WebElement emailProspectStep1NextBtn;

	/**
	 * @return the emailProspectStep1NextBtn
	 */
	public WebElement getEmailProspectStep1NextBtn(int timeOut) {
		return isDisplayed(driver, emailProspectStep1NextBtn, "Visibility", timeOut,
				"email prospect steps 1 next button");
	}

	@FindBy(xpath = "//div[@class='step_2']//a[@title='Next']")
	private WebElement emailProspectStep2NextBtn;

	/**
	 * @return the emailProspectStep2NextBtn
	 */
	public WebElement getEmailProspectStep2NextBtn(int timeOut) {
		return isDisplayed(driver, emailProspectStep2NextBtn, "Visibility", timeOut,
				"email prospect steps 2 nect button");
	}

	public WebElement getEmailProspectSendBtn(TopOrBottom topOrBottom, int timeOut) {

		WebElement ele = null;
		String xpath = null;

		if (TopOrBottom.TOP.equals(topOrBottom)) {
			xpath = "(//div[@class='step_3']//a[@title='Send'])[1]";
		} else {
			xpath = "(//div[@class='step_3']//a[@title='Send'])[2]";
		}

		ele = FindElement(driver, xpath, "Send Button : " + topOrBottom, action.SCROLLANDBOOLEAN, timeOut);
		return isDisplayed(driver, ele, "Visibility", timeOut, "send button : " + topOrBottom);
	}

	@FindBy(xpath = "//a[text()='Finished']")
	private WebElement emailProspectFinishBtn;

	/**
	 * @return the emailProspectFinishBtn
	 */
	public WebElement getEmailProspectFinishBtn(int timeOut) {
		return isDisplayed(driver, emailProspectFinishBtn, "Visibility", timeOut, "email prospect finish button");
	}

	@FindBy(xpath = "//select[contains(@id,'page') and contains(@id,'frm') and contains(@id,'sl1')]")
	private WebElement emailProspectFolderDropDownList;

	/**
	 * @return the emailProspectFolderDropDownList
	 */
	public WebElement getEmailProspectFolderDropDownList(int timeOut) {
		return isDisplayed(driver, emailProspectFolderDropDownList, "Visibility", timeOut,
				"email prospect folder drop downlist");
	}

	@FindBy(xpath = "(//span[@class='aw-bars-box '])[2]")
	private WebElement emailProspectStep2CustomEmailtemplateScrollBox;

	/**
	 * @return the emailProspectStep2CustomEmailtemplateScrollBox
	 */
	public WebElement getEmailProspectStep2CustomEmailtemplateScrollBox(int timeOut) {
		return isDisplayed(driver, emailProspectStep2CustomEmailtemplateScrollBox, "Visibility", timeOut,
				"email prospect custom email template scroll box");
	}

	public WebElement getCustomTabCrossIcon(String projectName, int timeOut) {
		List<WebElement> eleList = FindElements(driver, "//*[@title='Close this window' or text()='Close this window']",
				"Cross Icon");
		try {
			for (int i = eleList.size() - 1; i >= 0; i++) {
				WebElement webElement = eleList.get(i);
				webElement = isDisplayed(driver, webElement, "Visibility", 2, "Cross Icon");
				if (webElement != null) {
					return webElement;
				} else {

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
		return null;

	}

	public WebElement getCustomTabCancelBtn(String projectName, int timeOut) {
		List<WebElement> eleList = FindElements(driver, "//*[@title='Cancel' or text()='Cancel']", "Cancel Button");
		try {
			for (int i = eleList.size() - 1; i >= 0; i++) {
				WebElement webElement = eleList.get(i);
				webElement = isDisplayed(driver, webElement, "Visibility", 2, "Cross Icon");
				if (webElement != null) {
					return webElement;
				} else {

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
		return null;

	}

	public WebElement getSDGGridDropDown(SDGGridName sdgGridName, String labelName, int timeOut) {
		String xpath = "//*[text()='" + labelName + "']/../following-sibling::*//select[@class='slds-select']";
		WebElement ele = FindElement(driver, xpath, "SDG grid drop down list " + sdgGridName, action.SCROLLANDBOOLEAN,
				timeOut);
		return isDisplayed(driver, ele, "Visibility", timeOut, "SDG grid drop down list " + sdgGridName);

	}

	@FindBy(xpath = "//*[@class='outPopupBox']//h2")
	private WebElement popUpHeader;

	@FindBy(xpath = "//*[@class='actionBody']//h2")
	private WebElement popUpHeader1;

	/**
	 * @return the navigationPopUpHeader
	 */
	public WebElement getPopUpHeader(String projectName, int timeOut) {
		WebElement ele = isDisplayed(driver, popUpHeader, "Visibility", 10, "PopUp Header");

		if (ele == null) {
			return isDisplayed(driver, popUpHeader1, "Visibility", 10, "PopUp Header");

		} else
			return ele;
	}

	@FindBy(xpath = "//h2[@title='We hit a snag.']")
	private WebElement hitASnagElement;

	/**
	 * @return the navigationPopUpHeader
	 */
	public WebElement getHitASnagElement(String projectName, int timeOut) {
		WebElement ele = isDisplayed(driver, hitASnagElement, "Visibility", timeOut, "PopUp Header");
		return ele;
	}

	public WebElement getPopUpHeader1(String projectName, int timeOut) {

		return isDisplayed(driver, popUpHeader1, "Visibility", 10, "PopUp Header");

	}

	@FindBy(xpath = "//*[text()='View Calendar']")
	private WebElement calenderIcon;

	/**
	 * @return the calenderIcon
	 */
	public WebElement getCalenderIcon(int timeOut) {
		return isDisplayed(driver, calenderIcon, "Visibility", timeOut, "View Calendar");
	}

	@FindBy(xpath = "//button[text()='New Event' and contains(@class,'new-event-button')]")
	private WebElement newEventBtn;

	/**
	 * @return the emailProspectFolderDropDownList
	 */
	public WebElement getNewEventBtn(int timeOut) {
		return isDisplayed(driver, newEventBtn, "Visibility", timeOut, "Calender Cell Icon");
	}

	@FindBy(xpath = "//*[contains(text(),' New ')]/../following-sibling::footer/*[@title='Save' or text()='Save']")
	private WebElement taskNewSaveBtn;

	public WebElement getTaskSaveBtn(String projectName, int timeOut) {
		return isDisplayed(driver, taskNewSaveBtn, "Visibility", timeOut, "New Task Save Button");
	}

	@FindBy(xpath = "//*[contains(text(),' Edit') ]/../following-sibling::footer/*[@title='Save' or text()='Save']")
	private WebElement taskEditSaveBtn;

	public WebElement geTaskEditSaveBtn(String projectName, int timeOut) {
		return isDisplayed(driver, taskEditSaveBtn, "Visibility", timeOut, "Edit Task Save Button");
	}

	@FindBy(xpath = "//*[@name='secondaryFields']//p")
	private WebElement secondaryField;

	public WebElement getSecondaryField(String projectName, int timeOut) {
		return isDisplayed(driver, secondaryField, "Visibility", timeOut, "Secondary Field");
	}

	public WebElement getDropdownOnCreationPopUp(String projectName, PageName pageName, String label, action action,
			int timeOut) {
		String xpath = "";
		label = label.replace("_", " ");
		xpath = "//label[text()='" + label + "']/following-sibling::div//input";
		WebElement ele = FindElement(driver, xpath, label, action, timeOut);
		return isDisplayed(driver, ele, "Visibility", timeOut, "Drop Down : " + label);
	}

	@FindBy(xpath = "//button[@title='Move selection to Chosen']")
	private WebElement addButtonMultipleBox_Lightning;

	public WebElement getAddButtonMultipleBox(int timeOut) {
		return isDisplayed(driver, addButtonMultipleBox_Lightning, "Visibility", timeOut,
				"addButtonMultipleBox Select Box Mode Lightning");

	}

	public WebElement getHeaderSectionGrid(String sectionName, action action, int timeOut) {
		String xpath2 = "//*[@class='test-id__section-header-title slds-truncate' and text()='" + sectionName
				+ "']/../..//button";
		WebElement element = FindElement(driver, xpath2, "Section :" + sectionName, action, timeOut);
		return isDisplayed(driver, element, "Visibility", timeOut, "Section :" + sectionName);
	}

	public List<WebElement> getFieldLabelsOfSection(String sectionName, action action, int timeOut) {
		String xpath = "//*[@class='test-id__section-header-title slds-truncate' and text()='" + sectionName
				+ "']/../../..//*[@class='test-id__field-label']";
		return FindElements(driver, xpath, "label field of section:" + sectionName);
	}

	@FindBy(xpath = "//nav[@aria-label='Breadcrumbs']//span")
	private WebElement pageHeaderName;

	public WebElement getPageHeaderName(int timeOut) {

		return isDisplayed(driver, pageHeaderName, "Visibility", timeOut, "Page header name");

	}

	@FindBy(xpath = "//*[@class='listViewManagerHeaderButton filterButton']//button")
	private WebElement filterButton;

	public WebElement getFilterButton(int timeOut) {

		return isDisplayed(driver, filterButton, "Visibility", timeOut, "filter button");

	}

	public List<WebElement> getListOfFilterPanelValue(int timeOut) {

		return FindElements(driver, "//div[@class='slds-panel__body panelBody']//li/div", "Filter value");

	}

	@FindBy(xpath = "//div[text()='Filter by Owner']/ancestor::a")
	private WebElement filterByOwnerBtn;

	public WebElement getfilterByOwnerBtn(String projectName, int timeOut) {
		return isDisplayed(driver, filterByOwnerBtn, "Visibility", timeOut, "filterByOwnerBtn");
	}

	public WebElement getListFilterSection(String projectName, String tab, int timeOut) {
		tab = tab.toLowerCase();
		String xpath = "//div[contains(text(),'Filter')]/following-sibling::span[contains(text(),'" + tab
				+ "')]/ancestor::a";
		return isDisplayed(driver, FindElement(driver, xpath, "ListFilterSection", action.SCROLLANDBOOLEAN, timeOut),
				"Visibility", timeOut, "ListFilterSection");

	}

	@FindBy(xpath = "//span[contains(text(),'All ')]/../..//input")
	private WebElement allCheckboxForFilter;

	public WebElement getallCheckboxForFilter(String projectName, int timeOut) {
		return isDisplayed(driver, allCheckboxForFilter, "Visibility", timeOut, "allCheckboxForFilter");
	}

	@FindBy(xpath = "//span[text()='Done']/..")
	private WebElement doneButtonListView;

	public WebElement getdoneButtonListView(String projectName, int timeOut) {
		return isDisplayed(driver, doneButtonListView, "Visibility", timeOut, "doneButtonListView");
	}

	@FindBy(xpath = "//a[text()='Add Filter']")
	private WebElement addFilterBtn;

	public WebElement getaddFilterBtn(String projectName, int timeOut) {
		return isDisplayed(driver, addFilterBtn, "Visibility", timeOut, "addFilterBtn");
	}

	@FindBy(xpath = "//label[text()='Field']/..//button")
	private WebElement filterFielddropdown;

	public WebElement getfilterFielddropdown(String projectName, int timeOut) {
		return isDisplayed(driver, filterFielddropdown, "Visibility", timeOut, "filterFielddropdown");
	}

	@FindBy(xpath = "//label[text()='Field']/parent::lightning-combobox//span[@class='slds-truncate']")
	private List<WebElement> filterFielddropdownlist;

	public List<WebElement> getfilterFielddropdownlist(String projectName, int timeOut) {
		return filterFielddropdownlist;
	}

	@FindBy(xpath = "//button[@aria-label='Operator, equals']")
	private WebElement filterOperatordropdown;

	public WebElement getFilterOperatordropdown(String projectName, int timeOut) {
		return isDisplayed(driver, filterOperatordropdown, "Visibility", timeOut, "OperatorFielddropdown");
	}

	@FindBy(xpath = "//label[text()='Operator']/parent::lightning-combobox//span[@class='slds-truncate']")
	private List<WebElement> filterOperatordropdownlist;

	public List<WebElement> getfilterOperatordropdownlist(String projectName, int timeOut) {
		return filterOperatordropdownlist;
	}

	@FindBy(xpath = "//span[text()='Value']/parent::label/following-sibling::input")
	private WebElement filterValuefield;

	public WebElement getfilterValuefield(String projectName, int timeOut) {
		return isDisplayed(driver, filterValuefield, "Visibility", timeOut, "filterValuefield");
	}

	@FindBy(xpath = "//span[text()='Done']")
	private WebElement filterDoneBtn;

	public WebElement getfilterDoneBtn(String projectName, int timeOut) {
		return isDisplayed(driver, filterDoneBtn, "Visibility", timeOut, "filterDoneBtn");
	}

	@FindBy(xpath = "//div[text()='Value']/..//a")
	private WebElement filterValueDropDown;

	public WebElement getfilterValueDropDown(String projectName, int timeOut) {
		return isDisplayed(driver, filterValueDropDown, "Visibility", timeOut, "filterValueDropDown");
	}

	@FindBy(xpath = "//div[@role='menu']//li/a")
	private List<WebElement> filterValueDropdownlist;

	public List<WebElement> getfilterValueDropdownlist(String projectName, int timeOut) {
		return filterValueDropdownlist;
	}

	@FindBy(xpath = "//li//a//span[text()='Delete']")
	private WebElement deleteButtonListView;

	public WebElement getdeleteButtonListView(String projectName, int timeOut) {
		return isDisplayed(driver, deleteButtonListView, "Visibility", timeOut, "deleteButtonListView");
	}

	@FindBy(xpath = "//span[text()='Delete']/parent::button")
	private WebElement deleteConfirmButtonListView;

	public WebElement getdeleteConfirmButtonListView(String projectName, int timeOut) {
		return isDisplayed(driver, deleteConfirmButtonListView, "Visibility", timeOut, "deleteConfirmButtonListView");
	}

	@FindBy(xpath = "//input[@placeholder='Search this list...']")
	private WebElement listSearchBox;

	public WebElement listSearchBox(int timeOut) {
		return isDisplayed(driver, listSearchBox, "Visibility", timeOut, "List Search Box");
	}

	public WebElement getSelectEditOfFundName(String fundName, int timeOut) {
		String xpath = "//tbody//a[text()='" + fundName
				+ "']/ancestor::th/following-sibling::td//ul[contains(@class,'oneActionsRibbon')]//a";
		WebElement ele = FindElement(driver, xpath, "select Edit of: " + fundName, action.SCROLLANDBOOLEAN, timeOut);
		return isDisplayed(driver, ele, "Visibility", timeOut, "select Edit of: " + fundName);
	}

	public WebElement getFundNameElement(String fundName, int timeOut) {
		String xpath = "//tbody//a[text()='" + fundName + "']";
		WebElement ele = FindElement(driver, xpath, "Record Found: " + fundName, action.SCROLLANDBOOLEAN, timeOut);
		return isDisplayed(driver, ele, "Visibility", timeOut, "Record Found: " + fundName);
	}

	@FindBy(xpath = "//a[@title='Delete']")
	private WebElement deleteRecordButton;

	public WebElement deleteRecordButton(int timeOut) {
		return isDisplayed(driver, deleteRecordButton, "Visibility", timeOut, "Delete Record Button");

	}

	public WebElement getUserNameHeader(String userName, int timeOut) {
		String xpath = "//h2[contains(text(),'" + userName + "')]";
		WebElement ele = FindElement(driver, xpath, "User Header Found: " + userName, action.SCROLLANDBOOLEAN, timeOut);
		try {
			return isDisplayed(driver, ele, "Visibility", timeOut, "User Header Found: " + userName);

		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver, ele, "Visibility", timeOut, "User Header Found: " + userName);
		}
	}

	@FindBy(xpath = "//tbody//tr[1]//th//a")
	private WebElement firstElementOfTable;

	public WebElement firstElementOfTable(int timeOut) {
		return isDisplayed(driver, firstElementOfTable, "Visibility", timeOut, "firstElementOfTable");

	}

	public WebElement firmNameHeader(String FirmName, int timeOut) {

		String xpath = "//div[contains(@class,'windowViewMode-normal')]//lightning-formatted-text[text()='" + FirmName
				+ "']";
		try {
			return isDisplayed(driver,
					FindElement(driver, xpath, "Text Found: " + FirmName, action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Header: " + FirmName);
		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver,
					FindElement(driver, xpath, "Text Found: " + FirmName, action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Header: " + FirmName);
		}
	}

	@FindBy(xpath = "//button[@title='Show filters']")
	private WebElement showFilter;

	public WebElement getshowFilter(int timeOut) {
		return isDisplayed(driver, showFilter, "Visibility", timeOut, "Show Filter");

	}

	@FindBy(xpath = "//a[text()='Remove All']")
	private WebElement removeAll;

	public WebElement getremoveAll(int timeOut) {
		return isDisplayed(driver, removeAll, "Visibility", timeOut, "Remove All");

	}

	@FindBy(xpath = "//a[text()='Users']/ancestor::li[@aria-expanded='false']")
	private WebElement userarialextendedicon;

	public WebElement getuserarialextendedicon(int timeOut) {
		return isDisplayed(driver, userarialextendedicon, "Visibility", timeOut, "User tab Arial extended icon");

	}

	public WebElement filteryOwnerRadioButton(String filterByOwnerRadioButton, int timeOut) {
		String xpath = "//span[contains(text(),'" + filterByOwnerRadioButton + "')]/../..//input";
		WebElement ele = FindElement(driver, xpath, "User Header Found: " + filterByOwnerRadioButton,
				action.SCROLLANDBOOLEAN, timeOut);
		try {
			return isDisplayed(driver, ele, "Visibility", timeOut, "Radio Button Found: " + filterByOwnerRadioButton);

		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver, ele, "Visibility", timeOut, "Radio Button Found: " + filterByOwnerRadioButton);
		}
	}

	public WebElement getManageInvestorFilterApplyButton(Workspace workspace, int timeOut) {
		String workspaceSelector = "";
		if (workspace.toString().equalsIgnoreCase(Workspace.FundraisingWorkspace.toString())) {
			workspaceSelector = "FR";
		} else {
			workspaceSelector = "INV";
		}
		return isDisplayed(driver,
				FindElement(driver,
						"//div[@id='filterGridContactDivId_MInvestorMIN" + workspaceSelector + "']//a[@title='Apply']",
						workspace + " Apply button", action.BOOLEAN, 30),
				"visibility", 60, workspace + "Apply button");
	}

	@FindBy(xpath = "//button[text()='Insert Selected Data']/parent::lightning-button")
	private WebElement insertSelectedButton;

	/**
	 * @return the insertSelectedButton
	 */
	public WebElement getInsertSelectedButton(int timeOut) {
		return isDisplayed(driver, insertSelectedButton, "Visibility", timeOut, "Look up insert Selected");
	}

	@FindBy(xpath = "//a[@title='Select Year']")
	private WebElement year;

	/**
	 * @return the year
	 */
	public WebElement getYear(int timeOut) {
		return isDisplayed(driver, year, "Visibility", timeOut, "Year");
	}

	@FindBy(xpath = "//a[@title='Previous 15 Years']")
	private WebElement yearBack;

	/**
	 * @return the year
	 */
	public WebElement getYearBack(int timeOut) {
		return isDisplayed(driver, yearBack, "Visibility", timeOut, "Year");
	}

	@FindBy(xpath = "//a[@title='Select Month']")
	private WebElement selectMonth;

	/**
	 * @return the selectMonth
	 */
	public WebElement getSelectMonth(int timeOut) {
		return isDisplayed(driver, selectMonth, "Visibility", timeOut, "Month");
	}

	@FindBy(id = "dtediv1")
	private WebElement calendarIcon;

	/**
	 * @return the calendarIcon
	 */
	public WebElement getCalendarIcon(int timeOut) {
		return isDisplayed(driver, calendarIcon, "Visibility", timeOut, "Calendar Icon");
	}

	@FindBy(xpath = "//a[text()='Nav Fund']")
	private WebElement NavFund;

	/**
	 * @return the calendarIcon
	 */
	public WebElement NavFund(int timeOut) {
		return isDisplayed(driver, NavFund, "Visibility", timeOut, "NavFund");
	}

	@FindBy(xpath = "//button[text()='Email Fundraising Contacts']")
	private WebElement CreateFundraisingLWC;

	/**
	 * @return the calendarIcon
	 */
	public WebElement CreateFundraisingLWC(int timeOut) {
		return isDisplayed(driver, CreateFundraisingLWC, "Visibility", timeOut, "CreateFundraisingLWC");
	}

	@FindBy(xpath = "//div[text()='Fund Name']/parent::div//input")
	private WebElement inputBoxFundName;

	/**
	 * @return the calendarIcon
	 */
	public WebElement inputBoxFundName(int timeOut) {
		return isDisplayed(driver, inputBoxFundName, "Visibility", timeOut, "inputBoxFundName");
	}

	@FindBy(xpath = "//div[text()='Fund Name']/parent::div//input/parent::div/following-sibling::div//li//lightning-base-combobox-formatted-text[@title='Nav Fund']")
	private WebElement navFundDropDown;

	/**
	 * @return the calendarIcon
	 */
	public WebElement navFundDropDown(int timeOut) {
		return isDisplayed(driver, navFundDropDown, "Visibility", timeOut, "navFundDropDown");
	}

	@FindBy(xpath = "//input[@name='name']//ancestor::lightning-input")
	private WebElement fieldInputBox;

	/**
	 * @return the calendarIcon
	 */
	public WebElement fieldInputBox(int timeOut) {
		return isDisplayed(driver, fieldInputBox, "Visibility", timeOut, "fieldInputBox");
	}

	public WebElement filterField(String filterName, int timeOut) {
		String xpath = "//ul[@role='presentation']//li//span//span[@title='" + filterName + "']";

		try {
			return FindElement(driver, xpath, "Filter Found: " + filterName, action.SCROLLANDBOOLEAN, timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Filter Found: " + filterName, action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	public WebElement operatorInputBox(int timeOut) {
		String xpath = "//div//lightning-combobox//lightning-base-combobox//button[@name='']";

		try {
			return FindElement(driver, xpath, "operatorInputBox", action.SCROLLANDBOOLEAN, timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "operatorInputBox", action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	public List<WebElement> operatorValues() {
		return FindElements(driver,
				"//div//lightning-combobox//lightning-base-combobox//button[@name='']//parent::div//following-sibling::div//lightning-base-combobox-item/span/span",
				"Operator Values");
	}

	public WebElement valueInputBox(int timeOut) {
		String xpath = "(//lightning-input//input)[2]";

		try {
			return FindElement(driver, xpath, "valueInputBox", action.SCROLLANDBOOLEAN, timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "valueInputBox", action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	// lightning-calendar//select

	public WebElement searchClearButton(int timeOut) {
		String xpath = "//button[@data-element-id='searchClear']";

		try {
			return FindElement(driver, xpath, "searchClearButton", action.SCROLLANDBOOLEAN, timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "searchClearButton", action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	public WebElement timeInpuBox(int timeOut) {
		String xpath = "//lightning-timepicker//input";

		try {
			return FindElement(driver, xpath, "timeInpuBox", action.SCROLLANDBOOLEAN, timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "timeInpuBox", action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	public WebElement monthInDatePicker(int timeOut) {

		String xpath = "//lightning-calendar//h2";
		try {
			return isDisplayed(driver, FindElement(driver, xpath, "Month Element ", action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Month Element ");
		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver, FindElement(driver, xpath, "Month Element ", action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Month Element ");
		}
	}

	public WebElement alternateMonthInDatePicker(int timeOut) {

		String xpath = "//div[contains(@class,'datepicker__filter--month')]//h2";
		try {
			return isDisplayed(driver, FindElement(driver, xpath, "Month Element ", action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Alternate Month Element ");
		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver, FindElement(driver, xpath, "Month Element ", action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Alternate Month Element ");
		}
	}

	@FindBy(xpath = "//lightning-select//select")
	private WebElement yearSelectInDatePicker;

	public WebElement yearSelectInDatePicker(int timeOut) {
		return isDisplayed(driver, yearSelectInDatePicker, "Visibility", timeOut, "yearSelectInDatePicker");

	}

	public List<WebElement> dateSelectorInDatePicker() {
		return FindElements(driver,
				"//table[@class='slds-datepicker__month']//tr//td[not(contains(@class,'slds-day_adjacent-month'))]/span",
				"dateSelector");
	}

	@FindBy(xpath = "//lightning-calendar//button[@title='Previous Month']")
	private WebElement previousMonthButtonInDatePicker;

	public WebElement previousMonthButtonInDatePicker(int timeOut) {
		return isDisplayed(driver, previousMonthButtonInDatePicker, "Visibility", timeOut,
				"previousMonthButtonInDatePicker");

	}

	@FindBy(xpath = "//lightning-calendar//button[@title='Next Month']")
	private WebElement nextMonthButtonInDatePicker;

	public WebElement nextMonthButtonInDatePicker(int timeOut) {
		return isDisplayed(driver, nextMonthButtonInDatePicker, "Visibility", timeOut, "nextMonthButtonInDatePicker");

	}

	@FindBy(xpath = "//button[text()='Search']")
	private WebElement searchButton;

	public WebElement searchButton(int timeOut) {
		return isDisplayed(driver, searchButton, "Visibility", timeOut, "searchButton");

	}

	@FindBy(xpath = "//button[text()='Clear']")
	private WebElement clearButton;

	public WebElement clearButton(int timeOut) {
		return isDisplayed(driver, clearButton, "Visibility", timeOut, "clearButton");

	}

	@FindBy(xpath = "//div[@data-id='filterdiv']/preceding-sibling::div//button")
	private WebElement firstFilterGridBtn;

	public WebElement firstFilterGridBtn(int timeOut) {
		return isDisplayed(driver, firstFilterGridBtn, "Visibility", timeOut, "firstFilterGridBtn");

	}

	public WebElement firstFilterGrid(int timeOut) {
		String xpath = "//div[@data-id='filterdiv']";
		return FindElement(driver, xpath, "firstFilterGrid", action.BOOLEAN, timeOut);

	}

	@FindBy(xpath = "//div[contains(@class,'slds-modal__container')]//header//lightning-primitive-icon/ancestor::button")
	private WebElement closePopupButton;

	public WebElement closePopupButton(int timeOut) {
		return isDisplayed(driver, closePopupButton, "Visibility", timeOut, "closePopupButton");

	}

	@FindBy(xpath = "//button[text()='Apply']")
	private WebElement applyButton;

	public WebElement applyButton(int timeOut) {
		return isDisplayed(driver, applyButton, "Visibility", timeOut, "applyButton");

	}

	public List<WebElement> filterList() {
		return FindElements(driver, "//ul[@role='presentation']//li//span//span", "Filter List");
	}

	@FindBy(xpath = "//button[@role='button']/parent::div")
	private WebElement clickedOnRecentlyViewed;

	public WebElement getClickedOnRecentlyViewed(int timeOut) {
		return isDisplayed(driver, clickedOnRecentlyViewed, "Visibility", timeOut, "Recently Viewed");
	}

	@FindBy(xpath = "//span[@class='currentScopeLabel']")
	private WebElement scopeLabelFilter;

	public WebElement getscopeLabelFilter(int timeOut) {
		return isDisplayed(driver, scopeLabelFilter, "Visibility", timeOut, "scope lebel filter");
	}

	@FindBy(xpath = "//div[@id='filterPanelFieldCriterion1']//div[@class='fieldLabel']")
	private WebElement filterFieldLabel1;

	public WebElement getfilterFieldLabel1(int timeOut) {
		return isDisplayed(driver, filterFieldLabel1, "Visibility", timeOut, "filter field label");
	}

	@FindBy(xpath = "//div[@id='filterPanelFieldCriterion1']//span[@class='test-operatorWrapper']")
	private WebElement filterOperator1;

	public WebElement getfilterOperator1(int timeOut) {
		return isDisplayed(driver, filterOperator1, "Visibility", timeOut, "filter Operator");
	}

	@FindBy(xpath = "//div[@id='filterPanelFieldCriterion0']//div[@class='fieldLabel']")
	private WebElement filterFieldLabel;

	public WebElement getfilterFieldLabel(int timeOut) {
		return isDisplayed(driver, filterFieldLabel, "Visibility", timeOut, "filter field label");
	}

	@FindBy(xpath = "//div[@id='filterPanelFieldCriterion0']//span[@class='test-operatorWrapper']")
	private WebElement filterOperator;

	public WebElement getfilterOperator(int timeOut) {
		return isDisplayed(driver, filterOperator, "Visibility", timeOut, "filter Operator");
	}

	@FindBy(xpath = "//div[@id='filterPanelFieldCriterion0']//span[@class='test-operandsWrapper']")
	private WebElement filterOperand;

	public WebElement getfilterOperand(int timeOut) {
		return isDisplayed(driver, filterOperand, "Visibility", timeOut, "filter Operand");
	}

	@FindBy(xpath = "//label[text()='Filter Logic']")
	private WebElement filterLogic;

	public WebElement filterLogic(int timeOut) {
		return isDisplayed(driver, filterLogic, "Visibility", timeOut, "filter Logic");
	}

	public List<WebElement> highlightPanelLabels() {
		return FindElements(driver,
				"//slot[@name='secondaryFields']/records-highlights-details-item/div/p[contains(@class,'slds-text-title')]",
				"highlightPanelLabels");
	}

	public List<WebElement> highlightPanelLabelsValues() {
		return FindElements(driver,
				"//slot[@name='secondaryFields']/records-highlights-details-item/div/p[contains(@class,'slds-text-body--regular')]",
				"highlightPanelLabels");
	}

	/**
	 * @author Ankur Huria
	 * @param itemName
	 * @return webElement for created item on Page
	 */
	public WebElement verifyCreatedItemOnPage(String itemName) {
		WebElement ele;
		String xpath = "";

		xpath = "//div/lightning-formatted-text[text()='" + itemName + "']";
		ele = FindElement(driver, xpath, "Header : " + itemName, action.BOOLEAN, 30);
		ele = isDisplayed(driver, ele, "Visibility", 10, itemName);
		return ele;
	}

	public List<WebElement> listOfButtons() {
		return FindElements(driver,
				"//ul[@class='slds-button-group-list']/li//button[contains(@class,'slds-button_neutral')]",
				"listOfButtons");
	}

	@FindBy(xpath = "//div[@class='forceVirtualActionMarker forceVirtualAction']//a")
	private WebElement downArrowButton;

	public WebElement downArrowButton(int timeOut) {
		return isDisplayed(driver, downArrowButton, "Visibility", timeOut, "Down Arrow Button");
	}

	public List<WebElement> dropDownButtonsList() {
		return FindElements(driver, "//div[contains(@class,'slds-dropdown__list')]//a", "DropDown Buttons List");
	}

	public List<WebElement> tabsInPage() {
		return FindElements(driver, "//ul[@role='tablist']/li/a", "Tabs in Page");
	}

	public WebElement sectionBelowTaskAndEventSection(int timeOut) {
		String xpath = "//div[contains(@class,'slds-size_1-of-1 row row-main')]/div[contains(@class,'region-sidebar-right')][2]";

		try {
			return FindElement(driver, xpath, "sectionBelowTaskAndEventSection", action.SCROLLANDBOOLEAN, timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "sectionBelowTaskAndEventSection", action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	public List<WebElement> recordLayoutSectionHeaders() {
		return FindElements(driver,
				"//records-record-layout-section//h3/button/span/following-sibling::span[contains(@class,'test-id__section-header-title')]",
				"Record Layout Section Headers");
	}

	public List<WebElement> recordLayoutSectionHeaderLabels(String SectionHeader) {
		return FindElements(driver,
				"//records-record-layout-section//h3/button/span/following-sibling::span[contains(@class,'test-id__section-header-title')][text()='"
						+ SectionHeader
						+ "']/ancestor::h3/following-sibling::div//records-record-layout-item//div[contains(@class,'test-id__field-label-container')]/span",
				"Record Layout Section Header Labels");
	}

	public WebElement getTabInPage(String tabName, int timeOut) {
		String xpath = "//lightning-tab-bar/ul[@class='slds-tabs_default__nav']//li[not(contains(@class,'slds-tabs_default__overflow-button'))]/a[text()='"
				+ tabName + "']";
		WebElement ele = FindElement(driver, xpath, "Tab Name:  " + tabName, action.SCROLLANDBOOLEAN, timeOut);
		try {
			return ele;

		} catch (StaleElementReferenceException e) {
			return ele;
		}

	}

	public WebElement getSDGName(String sdgName, int timeOut) {
		String xpath = "//article//header//h2//a[text()='" + sdgName + "']";
		WebElement ele = FindElement(driver, xpath, "SDG Name:  " + sdgName, action.SCROLLANDBOOLEAN, timeOut);
		try {
			return ele;

		} catch (StaleElementReferenceException e) {
			return ele;
		}
	}

	public List<WebElement> columnsOfSDG(String sdgName) {
		return FindElements(driver,
				"//a[text()='" + sdgName + "']/ancestor::article//thead//th[contains(@class,'navpeI')]//span",
				"Records");
	}

	public WebElement sdgButtonName(String sdgName, String buttonName, int timeOut) {
		String xpath = "//a[text()=\"" + sdgName + "\"]/ancestor::header//div//button[text() = \"" + buttonName + "\"]";
		WebElement ele = FindElement(driver, xpath, "SDG Button Name: " + buttonName, action.SCROLLANDBOOLEAN, timeOut);
		try {
			return ele;

		} catch (StaleElementReferenceException e) {
			return ele;
		}
	}

	public List<WebElement> firmsInDropDown() {
		return FindElements(driver,
				"//ul[@aria-label='Recent Firms']//li//lightning-base-combobox-item/span/following-sibling::span/span[1]/span",
				"Firms in Drop Down");
	}

	public WebElement firmInputBox(int timeOut) {
		return FindElement(driver, "//input[@placeholder='Search Firms...']", "firmInputBox", action.SCROLLANDBOOLEAN,
				timeOut);

	}

	public WebElement ContactInputBox(int timeOut) {
		return FindElement(driver, "//input[@placeholder='Search Contacts...']", "ContactInputBox",
				action.SCROLLANDBOOLEAN, timeOut);

	}

	public WebElement calendarInputBox(String labelName, int timeOut) {
		return FindElement(driver, "//label[text()='" + labelName + "']/parent::div/div/input", "calendarInputBox",
				action.SCROLLANDBOOLEAN, timeOut);

	}

	public WebElement popupcalendarInputBox(String labelName, int timeOut) {
		return FindElement(driver, "//span[text()='" + labelName + "']/../..//input[@type='text']", "calendarInputBox",
				action.SCROLLANDBOOLEAN, timeOut);

	}

	public WebElement roleAvailableInNewAffiliationOfContact(String Section, int timeOut) {
		return FindElement(driver, "//input[@placeholder='Search Firms...']", "firmInputBox", action.SCROLLANDBOOLEAN,
				timeOut);

	}

	public List<WebElement> chosenOrAvailableDataForLabel(String label, String Section) {
		return FindElements(driver, "//div[text()=\"" + label + "\"]/following-sibling::div//span[text()=\"" + Section
				+ "\"]/parent::div//li/div", "chosenOrAvailableDataForLabel");
	}

	public WebElement moveSectionToChosenOrAvailableButton(String label, String button, int timeOut) {
		return FindElement(driver, "//div[text()='" + label
				+ "']/following-sibling::div//button[@title='Move selection to " + button + "']",
				"moveSectionToChoseOrAvailableButton", action.SCROLLANDBOOLEAN, timeOut);

	}

	/*
	 * public List<WebElement> detailPageLabelValues( String Section) { return
	 * FindElements(driver, "//span[text()=\""+Section+
	 * "\"]/ancestor::h3/following-sibling::div//div//records-record-layout-item//div/span/parent::div/following-sibling::div",
	 * "detailPageLabelValues"); }
	 */

	public List<WebElement> detailPageLabelValues(String Section) {
		return FindElements(driver, "//span[text()=\"" + Section
				+ "\"]/ancestor::h3/following-sibling::div//div//records-record-layout-item//div/div[contains(@class,\'slds-form-element_readonly\')]//span[contains(@class,\'test-id__field-label\') or contains(@class,\'test-id__field-value\')]",
				"detailPageLabelValues");
	}

	public WebElement recordDropDown(String label, int timeOut) {
		return FindElement(driver, "//label[text()='" + label + "']/parent::lightning-combobox//button",
				"DropDown: " + label, action.SCROLLANDBOOLEAN, timeOut);

	}

	public WebElement recordTextBox(String label, int timeOut) {
		return FindElement(driver, "//label[text()='" + label
				+ "']/ancestor::div[@class='slds-form-element__row'  or contains(@class,'label-stacked')]//div/input",
				"DropDown: " + label, action.SCROLLANDBOOLEAN, timeOut);

	}

	public WebElement searchDropDownBoxThroughSDG(String label, int timeOut) {
		return FindElement(driver,
				"//label[text()=\"" + label
						+ "\"]/following-sibling::div//div[contains(@class,\"slds-combobox__form-element\")]/input",
				"searchDropDownBoxThroughSDG", action.SCROLLANDBOOLEAN, timeOut);

	}

	public WebElement createButtonInSDGRecordWindowOfSearchDropDown(String label, int timeOut) {
		String inDropDownCreateButton = "//ul[@aria-label=\'Recent " + label
				+ "']//li//lightning-base-combobox-item/span/following-sibling::span/span[1]/span/ancestor::ul/following-sibling::lightning-base-combobox-item";

		try {
			return FindElement(driver, inDropDownCreateButton, "createButtonInSDGRecordWindowOfSearchDropDown",
					action.SCROLLANDBOOLEAN, timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, inDropDownCreateButton, "createButtonInSDGRecordWindowOfSearchDropDown",
					action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	public WebElement activityTimelineTab(String tabName, int timeOut) {
		String xpath = "//div[contains(@class,'region-sidebar-right')]//div[@class='uiTabBar']//li[contains(@class,'uiTabItem')]/a/span[2][text()='"
				+ tabName + "']/parent::a";

		try {
			return FindElement(driver, xpath, "activityTimelineTab: " + tabName, action.SCROLLANDBOOLEAN, timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "activityTimelineTab: " + tabName, action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	@FindBy(xpath = "//div[contains(@class,'dummyControlsContainer')]/button[@title='Add']")
	private WebElement addTaskButtonInActivityTimeline;

	public WebElement addTaskButtonInActivityTimeline(int timeOut) {
		return isDisplayed(driver, addTaskButtonInActivityTimeline, "Visibility", timeOut, "Connections");

	}

	public WebElement activityTimelineSearchDropDown(String labelTextBox, int timeOut) {
		String xpath = "//label[text()='" + labelTextBox + "']/..//input";

		try {
			return FindElement(driver, xpath, "activityTimelineSearchDropDown: " + labelTextBox,
					action.SCROLLANDBOOLEAN, timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "activityTimelineSearchDropDown: " + labelTextBox,
					action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	public WebElement activityTimelineSmallDropDownInDoubleDropDown(String tab, String labelTextBox, int timeOut) {
		String xpath = "//span[text()='" + labelTextBox
				+ "']/parent::label/following-sibling::div/div/div/div[contains(@class,'uiMenu')]//a";

		String xpathEmail = "//span[text()='" + labelTextBox
				+ "']/parent::label/parent::div/div//div[contains(@class,'inputWrapper')]/div[contains(@class,'entityMenu')]//a";

		if (tab.equalsIgnoreCase("Email"))

		{
			try {
				return FindElement(driver, xpathEmail, "activityTimelineSmallDropDownInDoubleDropDown: " + labelTextBox,
						action.SCROLLANDBOOLEAN, timeOut);

			} catch (StaleElementReferenceException e) {
				return FindElement(driver, xpathEmail, "activityTimelineSmallDropDownInDoubleDropDown: " + labelTextBox,
						action.SCROLLANDBOOLEAN, timeOut);
			}
		} else {
			try {
				return FindElement(driver, xpath, "activityTimelineSmallDropDownInDoubleDropDown: " + labelTextBox,
						action.SCROLLANDBOOLEAN, timeOut);

			} catch (StaleElementReferenceException e) {
				return FindElement(driver, xpath, "activityTimelineSmallDropDownInDoubleDropDown: " + labelTextBox,
						action.SCROLLANDBOOLEAN, timeOut);
			}
		}
	}

	public WebElement activityTimelineSearchDropDownInDoubleDropDown(String tab, String labelTextBox, int timeOut) {
		String xpath = "//span[text()='" + labelTextBox
				+ "']/parent::label/following-sibling::div/div/div/div[contains(@class,'autocompleteWrapper')]/input";

		String xpathEmail = "//span[text()='" + labelTextBox
				+ "']/parent::label/parent::div/div//div[contains(@class,'inputWrapper')]/div[contains(@class,'autocompleteWrapper')]/input";

		if (tab.equalsIgnoreCase("Email")) {
			try {
				return FindElement(driver, xpathEmail,
						"activityTimelineSearchDropDownInDoubleDropDown: " + labelTextBox, action.SCROLLANDBOOLEAN,
						timeOut);

			} catch (StaleElementReferenceException e) {
				return FindElement(driver, xpathEmail,
						"activityTimelineSearchDropDownInDoubleDropDown: " + labelTextBox, action.SCROLLANDBOOLEAN,
						timeOut);
			}
		} else {

			try {
				return FindElement(driver, xpath, "activityTimelineSearchDropDownInDoubleDropDown: " + labelTextBox,
						action.SCROLLANDBOOLEAN, timeOut);

			} catch (StaleElementReferenceException e) {
				return FindElement(driver, xpath, "activityTimelineSearchDropDownInDoubleDropDown: " + labelTextBox,
						action.SCROLLANDBOOLEAN, timeOut);
			}
		}
	}

	public WebElement activityTimelineDropDownElement(String labelTextBox, int timeOut) {
		String xpath = "//span[text()='" + labelTextBox + "']/parent::span/following-sibling::div/div/div//a";

		try {
			return FindElement(driver, xpath, "activityTimelineDropDownElement: " + labelTextBox,
					action.SCROLLANDBOOLEAN, timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "activityTimelineDropDownElement: " + labelTextBox,
					action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	public WebElement activityTimelineTextBoxElement(String labelTextBox, int timeOut) {
		String xpath = "//span[text()='" + labelTextBox + "']/parent::label/following-sibling::input";

		try {
			return FindElement(driver, xpath, "activityTimelineTextBoxElement: " + labelTextBox,
					action.SCROLLANDBOOLEAN, timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "activityTimelineTextBoxElement: " + labelTextBox,
					action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	public WebElement activityTimelineToTextBoxElement(String labelTextBox, int timeOut) {
		String xpath = "//span[text()='" + labelTextBox + "']/ancestor::div[contains(@class,'uiInput')]//input";

		try {
			return FindElement(driver, xpath, "activityTimelineTextToBoxElement: " + labelTextBox,
					action.SCROLLANDBOOLEAN, timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "activityTimelineTextToBoxElement: " + labelTextBox,
					action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	public WebElement activityTimelineBodyTextBoxElement(String labelTextBox, int timeOut) {
		String xpath = "//body[contains(@class,'cke_editable')]";

		try {
			return FindElement(driver, xpath, "activityTimelineTextBodyBoxElement: " + labelTextBox,
					action.SCROLLANDBOOLEAN, timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "activityTimelineTextBodyBoxElement: " + labelTextBox,
					action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	public WebElement activityTimelineDateElement(String label, String subLabel, int timeOut) {
		String xpath = "//legend[text()=\"" + label + "\"]/parent::fieldset//label[text()=\"" + subLabel
				+ "\"]/parent::div/div/input";

		try {
			return FindElement(driver, xpath, "activityTimelineDateTimeElement: " + label + " & " + subLabel,
					action.SCROLLANDBOOLEAN, timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "activityTimelineDateTimeElement: " + label + " & " + subLabel,
					action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	public WebElement activityTimelineTimeElement(String label, String subLabel, int timeOut) {
		String xpath = "//legend[text()=\"" + label + "\"]/parent::fieldset//label[text()=\"" + subLabel
				+ "\"]/parent::lightning-timepicker//div/input";

		try {
			return FindElement(driver, xpath, "activityTimelineDateTimeElement: " + label + " & " + subLabel,
					action.SCROLLANDBOOLEAN, timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "activityTimelineDateTimeElement: " + label + " & " + subLabel,
					action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	@FindBy(xpath = "//span[text()='Send']/parent::button")
	private WebElement sendButtonInActivityTimeline;

	public WebElement sendButtonInActivityTimeline(int timeOut) {
		return isDisplayed(driver, sendButtonInActivityTimeline, "Visibility", timeOut, "Connections");

	}

	@FindBy(xpath = "//span[text()='Email sent.']")
	private WebElement emailSentMsg;

	public WebElement emailSentMsg(int timeOut) {
		return isDisplayed(driver, emailSentMsg, "Visibility", timeOut, "emailSentMsg");

	}

	@FindBy(xpath = "//span[contains(@class,'toastMessage slds-text-heading--small')]")
	private WebElement ActivityTimeLineCreatedMsg;

	public WebElement ActivityTimeLineCreatedMsg(int timeOut) {
		return isDisplayed(driver, ActivityTimeLineCreatedMsg, "Visibility", timeOut, "ActivityTimeLineCreatedMsg");

	}

	public String searchDropDownListInNewRecordForm(String label) {
		return "//span[text()='" + label
				+ "']/parent::label/following-sibling::div//div[contains(@class,'listContent')]/ul/li[not(contains(@class,'invisible'))]//div[contains(@class,'primaryLabel')]";
	}

	@FindBy(xpath = "//iframe[@title='Email Body']")
	private WebElement emailBodyIframe;

	public WebElement getemailBodyIframe(int timeOut) {
		return isDisplayed(driver, emailBodyIframe, "Visibility", timeOut, "email body Iframe");

	}

	@FindBy(xpath = "//iframe[@title='CK Editor Container']")
	private WebElement ckEditorIframe;

	public WebElement getckEditorIframe(int timeOut) {
		return isDisplayed(driver, ckEditorIframe, "Visibility", timeOut, "ck editor Iframe");

	}

	public List<WebElement> sdgGridAllHeadersLabelNameList(String sdgGridName) {

		String xpath = "//div[contains(@data-component-id,'navpeII_sdg')]//a[text()='" + sdgGridName
				+ "']/../../../../../following-sibling::div//table/thead/tr/th";
		List<WebElement> ele = FindElements(driver, xpath, "SDG grid header label name " + sdgGridName);

		return ele;
	}

	public List<WebElement> sdgGridColumnsDataList(String Title, int CloumnIndex) {
		// index start from 2 in Deal SDG grid.

		String xpath = "//div[contains(@data-component-id,'navpeII_sdg')]//a[text()='" + Title
				+ "']/../../../../../following-sibling::div//table/tbody/tr/td[" + CloumnIndex + "]";
		List<WebElement> ele = FindElements(driver, xpath, "SDG grid " + Title + " column data ");

		return ele;
	}

	public WebElement searchDropDownInputInNewRecordForm(String labelName, int timeOut) {
		String xpath = "//label//span[text()='" + labelName
				+ "']/parent::label/following-sibling::div//div[@class='autocompleteWrapper slds-grow']/input";

		try {
			return FindElement(driver, xpath, "searchDropDownInputInNewRecordForm", action.SCROLLANDBOOLEAN, timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "searchDropDownInputInNewRecordForm", action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	public WebElement datePickerInputInNewRecordForm(String labelName, int timeOut) {
		String xpath = "//span[text()='" + labelName + "']/parent::label/following-sibling::div/input";

		try {
			return FindElement(driver, xpath, "datePickerInputInNewRecordForm", action.SCROLLANDBOOLEAN, timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "datePickerInputInNewRecordForm", action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	public WebElement dropDownInputInNewRecordForm(String labelName, int timeOut) {
		String xpath = "//span[text()='" + labelName + "']/parent::span/following-sibling::div//a";

		try {
			return FindElement(driver, xpath, "dropDownInputInNewRecordForm", action.SCROLLANDBOOLEAN, timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "dropDownInputInNewRecordForm", action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	public String dropDownListInNewRecordForm(String label) {
		return "//div[contains(@class,'visible positioned')]/div/ul/li/a";
	}

	public WebElement textBoxInNewRecordForm(String labelName, int timeOut) {
		String xpath = "//span[text()='" + labelName + "']/parent::label/following-sibling::input";

		try {
			return FindElement(driver, xpath, "textBoxInNewRecordForm", action.SCROLLANDBOOLEAN, timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "textBoxInNewRecordForm", action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	public WebElement textAreaInNewRecordForm(String labelName, int timeOut) {
		String xpath = "//span[text()='" + labelName + "']/parent::label/following-sibling::textarea";

		try {
			return FindElement(driver, xpath, "textAreaInNewRecordForm", action.SCROLLANDBOOLEAN, timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "textAreaInNewRecordForm", action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	@FindBy(xpath = "//div[contains(@class,'datepicker__filter--month')]//a[@title='Go to previous month']")
	private WebElement alteratePreviousMonthButtonInDatePicker;

	public WebElement alteratePreviousMonthButtonInDatePicker(int timeOut) {
		return isDisplayed(driver, alteratePreviousMonthButtonInDatePicker, "Visibility", timeOut,
				"alteratePreviousMonthButtonInDatePicker");

	}

	public WebElement pageLevelCreateRecordPopupSaveOrCancelButton(String buttonName, int timeOut) {
		String xpath = "//footer/button/span[text()='" + buttonName + "']/parent::button";

		try {
			return FindElement(driver, xpath, "pageLevelCreateRecordPopupSaveOrCancelButton", action.SCROLLANDBOOLEAN,
					timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "pageLevelCreateRecordPopupSaveOrCancelButton", action.SCROLLANDBOOLEAN,
					timeOut);
		}
	}

	public WebElement buttonInRecordPage(String buttonName, int timeOut) {
		String xpath = "//div[contains(@class,'primaryFieldRow')]//button[text()='" + buttonName + "']";

		try {
			return FindElement(driver, xpath, "buttonInMainContactPage: " + buttonName, action.SCROLLANDBOOLEAN,
					timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "buttonInMainContactPage: " + buttonName, action.SCROLLANDBOOLEAN,
					timeOut);
		}
	}

	public WebElement detailPageHeader(String detailPageHeader, int timeOut) {
		String xpath = "//div[contains(@class,'slds-media__body')]/h1/div[text()='" + detailPageHeader + "']";

		try {
			return FindElement(driver, xpath, "Detail Page Header: " + detailPageHeader, action.SCROLLANDBOOLEAN,
					timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Detail Page Header: " + detailPageHeader, action.SCROLLANDBOOLEAN,
					timeOut);
		}
	}

	@FindBy(xpath = "//span[text()='Your changes are saved.']")
	private WebElement saveConfirmationMsg;

	public WebElement getsaveConfirmationMsg(int timeOut) {
		return isDisplayed(driver, saveConfirmationMsg, "Visibility", timeOut, "save confirmation message");
	}

	@FindBy(xpath = "//span[text()='Or drop files']")
	private WebElement dropFileVisible;

	public WebElement getdropFileVisible(int timeOut) {
		return isDisplayed(driver, dropFileVisible, "Visibility", timeOut, "Or drop file button Visible");
	}

	@FindBy(xpath = "//li[@title='Files']")
	private WebElement FilesTabPage;

	public WebElement getFilesTabPage(int timeOut) {
		return isDisplayed(driver, FilesTabPage, "Visibility", timeOut, "FilesTabPage");
	}

	@FindBy(xpath = "//span[text()='Done']")
	private WebElement ClickedOnDoneButton;

	public WebElement getClickedOnDoneButton(int timeOut) {
		return isDisplayed(driver, ClickedOnDoneButton, "Visibility", timeOut, "ClickedOnDoneButton");
	}

	public WebElement getFileName(int timeOut) {

		return FindElement(driver,
				"//div[@class='slds-show_inline-block slds-float_left slds-p-left--x-small slds-truncate slds-m-right_x-small']//span",
				"FileName", action.SCROLLANDBOOLEAN, timeOut);

	}

	public WebElement getUploadFileButton(int timeOut) {
		return FindElement(driver, "//span[text()='Upload Files']", "UploadFileButton", action.SCROLLANDBOOLEAN,
				timeOut);

	}

	@FindBy(xpath = "//h2[@class='slds-card__header-title']//span[contains(@class,'slds-shrink')]")
	private WebElement UploadedFileCount;

	public WebElement getUploadedFileCount(int timeOut) {
		return isDisplayed(driver, UploadedFileCount, "Visibility", timeOut, "Uploaded File Count");
	}

	@FindBy(xpath = "//input[@class='slds-file-selector__input slds-assistive-text']")
	private WebElement fileUpload;

	public WebElement getfileUpload(int timeOut) {
		return isDisplayed(driver, fileUpload, "Visibility", timeOut, "File Upload");
	}

	@FindBy(xpath = "//span[contains(text(),'1 file was added')]")
	private WebElement fileUploadConfirmationMsg;

	public WebElement getfileUploadConfirmationMsg(int timeOut) {
		return isDisplayed(driver, fileUploadConfirmationMsg, "Visibility", timeOut,
				"File Upload Confirmation Message");
	}

	@FindBy(xpath = "//p[contains(@class,'secondaryFields')]/span[@class='uiOutputDateTime']")
	private WebElement fileUploadDate;

	public WebElement getfileUploadDate(int timeOut) {
		return isDisplayed(driver, fileUploadDate, "Visibility", timeOut, "Uploaded File Date");
	}

	@FindBy(xpath = "//p[contains(@class,'secondaryFields')]/span[@class='forceChatterFileSize']")
	private WebElement fileUploadSize;

	public WebElement getfileUploadSize(int timeOut) {
		return isDisplayed(driver, fileUploadSize, "Visibility", timeOut, "Uploaded file Size");
	}

	@FindBy(xpath = "//p[contains(@class,'secondaryFields')]/span[@class='itemLabel slds-truncate uiOutputText']")
	private WebElement fileUploadType;

	public WebElement getfileUploadType(int timeOut) {
		return isDisplayed(driver, fileUploadType, "Visibility", timeOut, "Uploaded file type");
	}

	@FindBy(xpath = "//span[text()='Upload Files']")
	private WebElement uploadFileVisible;

	public WebElement getuploadFileVisible(int timeOut) {
		return isDisplayed(driver, uploadFileVisible, "Visibility", timeOut, "Upload File Visible");
	}

	@FindBy(xpath = "//h2[@class='slds-card__header-title']/a")
	private WebElement fileCountVisible;

	public WebElement getfileCountVisible(int timeOut) {
		return isDisplayed(driver, fileCountVisible, "Visibility", timeOut, "file Count visible");
	}

	@FindBy(xpath = "//div[text()='Add Files']")
	private WebElement addFileVisible;

	public WebElement getaddFileVisible(int timeOut) {
		return isDisplayed(driver, addFileVisible, "Visibility", timeOut, "Add File button Visible");
	}

	public WebElement getTabNameOnPage(String tabName, int timeOut) {
		String xPath = "//ul[@role='tablist']//a[text()='" + tabName + "']";

		return isDisplayed(driver, FindElement(driver, xPath, tabName + " tab name", action.SCROLLANDBOOLEAN, timeOut),
				"Visibility", timeOut, tabName + " tab name");
	}

	public WebElement getVerificationPartTabNameOnPage(String tabName, int timeOut) {
		String xPath = "//ul[@role='tablist']//a[text()='" + tabName + "']/..";

		return isDisplayed(driver, FindElement(driver, xPath, tabName + " tab name", action.SCROLLANDBOOLEAN, timeOut),
				"Visibility", timeOut, tabName + " tab name");
	}

	public WebElement getTaggedRecordName(String taggedTabName, String recordName, int timeOut) {

		return FindElement(driver, "//span[text()='" + taggedTabName
				+ "']/ancestor::table//lightning-formatted-url//a[text()='" + recordName + "']", "tagged",
				action.SCROLLANDBOOLEAN, timeOut);

	}

	public WebElement getTaggedRecordTimeReference(String taggedTabName, String recordName, String timeReferenceCount,
			int timeOut) {

		return FindElement(driver,
				"//span[text()='" + taggedTabName + "']/ancestor::table//lightning-formatted-url//a[text()='"
						+ recordName + "']/ancestor::tr//td//button[text()='" + timeReferenceCount + "']",
				"tagged", action.SCROLLANDBOOLEAN, timeOut);

	}

	public WebElement getTaggedRecordName(String tagTabName, int timeOut) {

		return FindElement(driver,
				"//div[@class='slds-radio_button-group']//span[contains(text(),'" + tagTabName + "')]",
				"tagged tab name", action.SCROLLANDBOOLEAN, timeOut);

	}

	@FindBy(xpath = "//footer//button[text()='Tag']")
	private WebElement footerTagButton;

	public WebElement getfooterTagButton(int timeOut) {
		return isDisplayed(driver, footerTagButton, "Visibility", timeOut, "footer tag button");
	}

	@FindBy(xpath = "//label[text()='Subject']/..//input[contains(@data-id,'combobox')]")
	private WebElement subjectInput;

	public WebElement getSubjectInput(int timeOut) {
		return isDisplayed(driver, subjectInput, "Visibility", timeOut, "Subject Input");
	}

	public WebElement getSubjectInput(String subjectName, int timeOut) {

		String xpath = "//label[text()='" + subjectName + "']/..//input[contains(@data-id,'combobox')]";
		try {
			return FindElement(driver, xpath, "Header: " + subjectName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + subjectName, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	@FindBy(xpath = "//div[label[text()='Notes']]//textarea")
	private WebElement notesText;

	public WebElement getNotesText(int timeOut) {
		return isDisplayed(driver, notesText, "Visibility", timeOut, "Notes text");
	}

	public WebElement dealNameLinkInAcuityTab(String dealName, int timeOut) {

		try {
			return FindElement(driver,
					"//span[text()='Deals']/ancestor::div[@class='slds-m-bottom_xx-small']//lightning-datatable[contains(@class,'dealDataTable')]//tbody/tr/th//a[text()='"
							+ dealName + "']",
					"Deal Name: " + dealName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver,
					"//span[text()='Deals']/ancestor::div[@class='slds-m-bottom_xx-small']//lightning-datatable[contains(@class,'dealDataTable')]//tbody/tr/th//a[text()='"
							+ dealName + "']",
					"Deal Name: " + dealName, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement dealRecordPage(String dealName, int timeOut) {

		try {
			return FindElement(driver,
					"//div[text()='Deal']/parent::h1//lightning-formatted-text[text()='" + dealName + "']",
					"Deal Header: " + dealName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver,
					"//div[text()='Deal']/parent::h1//lightning-formatted-text[text()='\"+dealName+\"']",
					"Deal Header: " + dealName, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement EmailRecordPage(String subject, int timeOut) {

		try {
			return FindElement(driver, "//div[text()='" + subject + "']", "Deal Header: " + subject,
					action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver,
					"//div[text()='Deal']/parent::h1//lightning-formatted-text[text()='\"+dealName+\"']",
					"Deal Header: " + subject, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement FundRaisingRecordPage(String fundraisingsName, int timeOut) {

		try {
			return FindElement(
					driver, "//div[text()='Fundraising']/parent::h1//lightning-formatted-text[text()='"
							+ fundraisingsName + "']",
					"Deal Header: " + fundraisingsName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(
					driver, "//div[text()='Fundraising']/parent::h1//lightning-formatted-text[text()='"
							+ fundraisingsName + "']",
					"Deal Header: " + fundraisingsName, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement CompanyRecordPage(String companyname, int timeOut) {

		try {
			return FindElement(driver,
					"//div[text()='Firm']/parent::h1//lightning-formatted-text[text()='" + companyname + "']",
					"Company header: " + companyname, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver,
					"//div[text()='Firm']/parent::h1//lightning-formatted-text[text()='\"+dealName+\"']",
					"Company header: " + companyname, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement contactDealCount(String contactName, int timeOut) {

		String xpath = "//a[text()='" + contactName
				+ "']/ancestor::td[@data-label='Name']/..//td[@data-label='Deals']//span//button";
		try {
			return FindElement(driver, xpath, "Contact Header: " + contactName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Contact Header: " + contactName, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement connectionTeamMember(String teamMember, int timeOut) {

		String xpath = "//button[text()='" + teamMember + "']/ancestor::th[@data-label='Name']";
		try {
			return FindElement(driver, xpath, "Header: " + teamMember, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + teamMember, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement DealContactname(String contactName, int timeOut) {

		String xpath = "//a[text()='" + contactName + "']";
		try {
			return FindElement(driver, xpath, "Header: " + contactName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + contactName, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement connectionTitle(String teamMember, String title, int timeOut) {

		String xpath = "//button[text()='" + teamMember
				+ "']/ancestor::th[@data-label='Name']/following-sibling::td[@data-label='Title']//button";
		try {
			return FindElement(driver, xpath, "Header: " + title, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + title, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement connectionDealsCount(String teamMember, String deals, int timeOut) {

		String xpath = "//button[text()='" + teamMember
				+ "']/ancestor::th[@data-label='Name']/following-sibling::td[@data-label='Deals']//button";
		try {
			return FindElement(driver, xpath, "Header: " + deals, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + deals, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement connectionMeetingCallsCount(String teamMember, String meetingAndCalls, int timeOut) {

		String xpath = "//button[text()='" + teamMember
				+ "']/ancestor::th[@data-label='Name']/following-sibling::td[@data-label='Meetings and Calls']//button";
		try {
			return FindElement(driver, xpath, "Header: " + meetingAndCalls, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + meetingAndCalls, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement connectionEmailCount(String teamMember, String email, int timeOut) {

		String xpath = "//button[text()='" + teamMember
				+ "']/ancestor::th[@data-label='Name']/following-sibling::td[@data-label='Emails']//button";
		try {
			return FindElement(driver, xpath, "Header: " + email, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + email, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement dealAcuityDealName(String dealName, int timeOut) {

		String xpath = "//a[text()='" + dealName + "']/ancestor::th[@data-label='Deal Name']";
		try {
			return FindElement(driver, xpath, "Header: " + dealName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + dealName, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement dealTeamAcuityDealName(String dealName, int timeOut) {

		String xpath = "//a[text()='" + dealName + "']/ancestor::th[@data-label='Name']";
		try {
			return FindElement(driver, xpath, "Header: " + dealName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + dealName, action.SCROLLANDBOOLEAN, timeOut);
		}

	}
	
	public WebElement dealTeamAcuityUserName(String Name, int timeOut) {

		String xpath = "//button[text()='" + Name + "']/ancestor::th[@data-label='Name']";
		try {
			return FindElement(driver, xpath, "Header: " + Name, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + Name, action.SCROLLANDBOOLEAN, timeOut);
		}

	}
	
	public WebElement InteractionRecord(String Name, int timeOut) {

		String xpath = "//span[contains(text(),'Interactions')]/ancestor::div//a[text()='"+ Name +"']";
		try {
			return FindElement(driver, xpath, "Header: " + Name, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + Name, action.SCROLLANDBOOLEAN, timeOut);
		}

	}
	
	public WebElement dealAcuity2DealName(String dealName, int timeOut) {

		String xpath = "//a[text()='" + dealName + "']/ancestor::th[@data-label='Deal']";
		try {
			return FindElement(driver, xpath, "Header: " + dealName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + dealName, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement dealScoreAcuity(String score, int timeOut) {

		String xpath = "//a[text()='" + score + "']/ancestor::th[@data-label='Deal Quality Score']";
		try {
			return FindElement(driver, xpath, "Header: " + score, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + score, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement dealAcuityhighestStageReachedName(String dealName, String highestStageReached, int timeOut) {

		String xpath = "//a[text()='" + dealName
				+ "']/ancestor::th[@data-label='Deal Name']/following-sibling::td[@data-label='Highest Stage Reached']//span";
		try {
			return FindElement(driver, xpath, "Header: " + highestStageReached, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + highestStageReached, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement dealAcuity2CompanyName(String dealName, String company, int timeOut) {

		String xpath = "//a[text()='" + dealName
				+ "']/ancestor::th[@data-label='Deal']/following-sibling::td[@data-label='Company']//span";
		try {
			return FindElement(driver, xpath, "Header: " + company, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + company, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement dealAcuityStageName(String dealName, String stage, int timeOut) {

		String xpath = "//a[text()='" + dealName
				+ "']/ancestor::th[@data-label='Deal Name']/following-sibling::td[@data-label='Stage']//span//*[text()='"
				+ stage + "']";
		try {
			return FindElement(driver, xpath, "Header: " + stage, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + stage, action.SCROLLANDBOOLEAN, timeOut);
		}

	}
	
	public WebElement dealTeamAcuityTitleName(String dealName, String stage, int timeOut) {

		String xpath = "//a[text()='" + dealName + "']/ancestor::th[@data-label='Name']/following-sibling::td/ancestor::div//span[@title='Title']/ancestor::div//lightning-base-formatted-text[text()='" + stage + "']";
		try {
			return FindElement(driver, xpath, "Header: " + stage, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + stage, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement dealTeamAcuityRole(String dealName, String role, int timeOut) {

		String xpath = "//a[text()='" + dealName + "']/ancestor::th[@data-label='Name']/following-sibling::td/ancestor::div//span[@title='Role']/ancestor::div//*[text()='" + role + "']";
		try {
			return FindElement(driver, xpath, "Header: " + role, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + role, action.SCROLLANDBOOLEAN, timeOut);
		}

	}
	
	public WebElement dealTeamAcuityUserTitle(String dealName, String title, int timeOut) {

		String xpath = "//button[text()='" + dealName + "']/ancestor::th[@data-label='Name']/following-sibling::td/ancestor::div//span[@title='Title']/ancestor::div//lightning-base-formatted-text[text()='" + title + "']";
		try {
			return FindElement(driver, xpath, "Header: " + title, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + title, action.SCROLLANDBOOLEAN, timeOut);
		}

	}
	
	
	public WebElement dealTeamAcuityRoleForInternal(String dealName, String role, int timeOut) {

		String xpath = "//button[text()='" + dealName + "']/ancestor::th[@data-label='Name']/following-sibling::td/ancestor::div//span[@title='Role']/ancestor::div//span[text()='" + role + "']";
		try {
			return FindElement(driver, xpath, "Header: " + role, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + role, action.SCROLLANDBOOLEAN, timeOut);
		}

	}
	
	public WebElement dealTeamAcuityDeals(String dealName, String dealCount, int timeOut) {

		String xpath = "//a[text()='" + dealName + "']/ancestor::th[@data-label='Name']/following-sibling::td/ancestor::div//span[@title='Deals']/ancestor::div//lightning-base-formatted-text[text()='" + dealCount + " 'and @name='dealRef']";
		try {
			return FindElement(driver, xpath, "Header: " + dealCount, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + dealCount, action.SCROLLANDBOOLEAN, timeOut);
		}

	}
	
	public WebElement dealTeamAcuityMeetingsAndCalls(String dealName, String meetingCount, int timeOut) {

		String xpath = "//a[text()='" + dealName + "']/ancestor::th[@data-label='Name']/following-sibling::td/ancestor::div//span[@title='Meetings and Calls']/ancestor::div//lightning-base-formatted-text[text()='" + meetingCount +  " 'and @name=' meetCallRef']";
		try {
			return FindElement(driver, xpath, "Header: " + meetingCount, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + meetingCount, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement dealTeamAcuityEmail(String dealName, String emailsCount, int timeOut) {

		String xpath = "//a[text()='" + dealName + "']/ancestor::th[@data-label='Name']/following-sibling::td/ancestor::div//span[@title='Emails']/ancestor::div//lightning-base-formatted-text[text()='" + emailsCount +  " 'and @name=' emailRef']";
		try {
			return FindElement(driver, xpath, "Header: " + emailsCount, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + emailsCount, action.SCROLLANDBOOLEAN, timeOut);
		}

	}
	
	public WebElement dealAcuityHSRName(String dealName, String hsr, int timeOut) {

		String xpath = "//a[text()='" + dealName
				+ "']/ancestor::th[@data-label='Deal Name']/following-sibling::td[@data-label='Highest Stage Reached']//span//*[text()='"
				+ hsr + "']";
		try {
			return FindElement(driver, xpath, "Header: " + hsr, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + hsr, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement dealAcuity2StageName(String dealName, String stage, int timeOut) {

		String xpath = "//a[text()='" + dealName
				+ "']/ancestor::th[@data-label='Deal']/following-sibling::td[@data-label='Stage']//span//*[text()='"
				+ stage + "']";
		try {
			return FindElement(driver, xpath, "Header: " + stage, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + stage, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement dealAcuityDateReceived(String dealName, String dateReceived, int timeOut) {

		String xpath = "//a[text()='" + dealName
				+ "']/ancestor::th[@data-label='Deal Name']/following-sibling::td[@data-label='Date Received']//span//*[text()='"
				+ dateReceived + "']";
		try {
			return FindElement(driver, xpath, "Header: " + dateReceived, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + dateReceived, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement dealTeamAcuityAccountName(String dealName, String accountName, int timeOut) {

		String xpath = "//a[text()='"+ dealName +"']/ancestor::th[@data-label='Name']/ancestor::div//th[@aria-label='Firm']/ancestor::div//span//*[text()='"+ accountName +"']";
		try {
			return FindElement(driver, xpath, "Header: " + accountName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + accountName, action.SCROLLANDBOOLEAN, timeOut);
		}

	}
	
	public WebElement dealAcuityDateReceived2(String dealName, int timeOut) {

		String xpath = "//a[text()='" + dealName + "']/ancestor::tr//td[@data-label='Date Received']//div/*";
		try {
			return FindElement(driver, xpath, "Header: " + "dateReceived", action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + "dateReceived", action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement FundraisingAcuityTargetCloseDate2(String fundraisingsName, int timeOut) {

		String xpath = "//a[text()='" + fundraisingsName
				+ "']/ancestor::th[@data-label='Fundraising Name']/following-sibling::td[@data-label='Target Close Date']//div/*";
		try {
			return FindElement(driver, xpath, "Header: " + "dateReceived", action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + "dateReceived", action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement FundraisingAcuityTargetCloseDateCoinvestement2(String CompanyName, int timeOut) {

		String xpath = "//a[text()='" + CompanyName
				+ "']/ancestor::th[@data-label='Company']/following-sibling::td[@data-label='Target Close Date']//div/*";
		try {
			return FindElement(driver, xpath, "Header: " + "dateReceived", action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + "dateReceived", action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement dealAcuity2DateReceived(String dealName, String dateReceived, int timeOut) {

		String xpath = "//a[text()='" + dealName
				+ "']/ancestor::th[@data-label='Deal']/following-sibling::td[@data-label='Date Received']//span//*[text()='"
				+ dateReceived + "']";
		try {
			return FindElement(driver, xpath, "Header: " + dateReceived, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + dateReceived, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement connectionPopUpDealsCount(String teamMember, String deals, int timeOut) {

		String xpath = "//lightning-base-formatted-text[text()='" + teamMember
				+ "']/ancestor::th[@data-label='Name']/..//td[@data-col-key-value='dealRef-button-2']//button";
		try {
			return FindElement(driver, xpath, "Header: " + deals, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + deals, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement connectionPopUpEmailCount(String teamMember, String email, int timeOut) {

		String xpath = "//lightning-base-formatted-text[text()='" + teamMember
				+ "']/ancestor::th[@data-label='Name']/..//td[@data-col-key-value='emailRef-button-4']//button";
		try {
			return FindElement(driver, xpath, "Header: " + email, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + email, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement dealAcuityPopUpCompanyName(String dealName, String company, int timeOut) {

		String xpath = "//a[text()='" + dealName
				+ "']/ancestor::th[@data-label='Deal']/following-sibling::td[@data-label='Company']//span//*[text()='"
				+ company + "']";
		try {
			return FindElement(driver, xpath, "Header: " + company, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + company, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement dealAcuityPopUpStageName(String dealName, String stage, int timeOut) {

		String xpath = "//div[@class='slds-modal__container']//a[text()='" + dealName
				+ "']/ancestor::th[@data-label='Deal Name']/following-sibling::td[@data-label='Stage']//span//*[text()='"
				+ stage + "']";
		try {
			return FindElement(driver, xpath, "Header: " + stage, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + stage, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement dealAcuityPopUpDateReceived(String dealName, String dateReceived, int timeOut) {

		String xpath = "//div[@class='slds-modal__container']//a[text()='" + dealName
				+ "']/ancestor::th[@data-label='Deal Name']/following-sibling::td[@data-label='Date Received']//span//*[text()='"
				+ dateReceived + "']";
		try {
			return FindElement(driver, xpath, "Header: " + dateReceived, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + dateReceived, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement teamMemberDealCount(String teamMemberName, int timeOut) {

		String xpath = "//*[text()='" + teamMemberName
				+ "']/ancestor::th[@data-label='Name']/..//td[@data-label='Deals']//span//button";
		try {
			return FindElement(driver, xpath, "TeamMember Header: " + teamMemberName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "TeamMember Header: " + teamMemberName, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement teamMemberpopupDealCount(String teamMemberName, int timeOut) {

		String xpath = "//*[text()='" + teamMemberName
				+ "']/ancestor::th[@data-label='Name']/..//button[@name='dealRef']";
		try {
			return FindElement(driver, xpath, "TeamMember Header: " + teamMemberName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "TeamMember Header: " + teamMemberName, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement fundraisingsAcuityFundraisingsName(String fundraisingsName, int timeOut) {

		String xpath = "//a[text()='" + fundraisingsName + "']/ancestor::th[@data-label='Fundraising Name']//a";
		try {
			return FindElement(driver, xpath, "Header: " + fundraisingsName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + fundraisingsName, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement fundraisingsAcuityFundName(String fundraisingsName, String fund, int timeOut) {

		String xpath = "//a[text()='" + fundraisingsName
				+ "']/ancestor::th[@data-label='Fundraising Name']/following-sibling::td[@data-label='Fund Name']//span//a";
		try {
			return FindElement(driver, xpath, "Header: " + fund, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + fund, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement fundraisingsAcuityStageName(String fundraisingsName, String stage, int timeOut) {

		String xpath = "//a[text()='" + fundraisingsName
				+ "']/ancestor::th[@data-label='Fundraising Name']/following-sibling::td[@data-label='Stage']//span//*[text()='"
				+ stage + "']";
		try {
			return FindElement(driver, xpath, "Header: " + stage, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + stage, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement fundrasingsAcuityTargetClosedDate(String fundraisingsName, String targetClosedDate, int timeOut) {

		String xpath = "//a[text()='" + fundraisingsName
				+ "']/ancestor::th[@data-label='Fundraising Name']/following-sibling::td[@data-label='Target Close Date']//span//*[text()='"
				+ targetClosedDate + "']";
		try {
			return FindElement(driver, xpath, "Header: " + targetClosedDate, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + targetClosedDate, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement fundraisingsAcuityFundraisingsCompany(String CompanyName, int timeOut) {

		String xpath = "//a[text()='" + CompanyName + "']/ancestor::th[@data-label='Company']//a";
		try {
			return FindElement(driver, xpath, "Header: " + CompanyName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + CompanyName, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement fundraisingsAcuityFundNameCoinvestment(String CompanyName, String fund, int timeOut) {

		String xpath = "//a[text()='" + CompanyName
				+ "']/ancestor::th[@data-label='Fundraising Name']/following-sibling::td[@data-label='Fund Name']//span//a";
		try {
			return FindElement(driver, xpath, "Header: " + fund, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + fund, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement fundraisingsAcuityStageNameCoinvestment(String CompanyName, String stage, int timeOut) {

		String xpath = "//a[text()='" + CompanyName
				+ "']/ancestor::th[@data-label='Company']/following-sibling::td[@data-label='Stage']//span//*[text()='"
				+ stage + "']";
		try {
			return FindElement(driver, xpath, "Header: " + stage, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + stage, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement activityTimelineButton(String btnName, int timeOut) {

		String xPath = "//div[@class=\"menuList\" and text()='" + btnName + "']";

		return isDisplayed(driver, FindElement(driver, xPath, btnName + " button", action.SCROLLANDBOOLEAN, timeOut),
				"Visibility", timeOut, btnName + " button");
	}

	public WebElement getSectionBtn(String sectionName, int timeOut) {
		String xPath = "//span[@class=\"slds-accordion__summary-content\" and text()='" + sectionName + "']";

		return isDisplayed(driver,
				FindElement(driver, xPath, sectionName + " section", action.SCROLLANDBOOLEAN, timeOut), "Visibility",
				timeOut, sectionName + " section");
	}

	public WebElement getNotePopUpSectionDetail(String sectionName, int timeOut) {
		String xPath = "//span[@class=\"slds-accordion__summary-content\" and text()='" + sectionName
				+ "']/ancestor::h3/../following-sibling::div";

		return isDisplayed(driver,
				FindElement(driver, xPath, sectionName + " section", action.SCROLLANDBOOLEAN, timeOut), "Visibility",
				timeOut, sectionName + " section");
	}

	public WebElement getfooterSaveOrCancelButton(String btnName, int timeOut) {
		String xPath = "//footer//button[text()='" + btnName + "']";

		return isDisplayed(driver, FindElement(driver, xPath, btnName + " button", action.SCROLLANDBOOLEAN, timeOut),
				"Visibility", timeOut, btnName + " button");
	}

	@FindBy(xpath = "//div[text()='Success']")
	private WebElement successMsg;

	public WebElement getSuccessMsg(int timeOut) {
		return isDisplayed(driver, successMsg, "Visibility", timeOut, "Sucsess Message");
	}

	@FindBy(xpath = "//div[text()='Task']/parent::h1//div/span")
	private WebElement taskDetailPageHeader;

	public WebElement taskDetailPageHeader(int timeOut) {
		return isDisplayed(driver, taskDetailPageHeader, "Visibility", timeOut, "taskDetailPageHeader");
	}

	@FindBy(xpath = "//div[text()='Event']/parent::h1//div/span")
	private WebElement eventDetailPageHeader;

	public WebElement eventDetailPageHeader(int timeOut) {
		return isDisplayed(driver, eventDetailPageHeader, "Visibility", timeOut, "eventDetailPageHeader");
	}

	@FindBy(xpath = "//span[text()='Interactions']/ancestor::div[contains(@class,'slds-p-bottom_none')]//a[text()='View All']")
	private WebElement interactionViewAllBtn;

	public WebElement getInteractionViewAllBtn(int timeOut) {
		return isDisplayed(driver, interactionViewAllBtn, "Visibility", timeOut, "View All Interaction button");
	}

	public WebElement getIntractionSubjectName(String intractionSubjectName, int timeOut) {

		return FindElement(driver,
				"//h2[contains(text(),'All Interactions')]/ancestor::div[@class='slds-modal__container']//td[@data-label='Subject']//a[text()='"
						+ intractionSubjectName + "']",
				"Intraction", action.SCROLLANDBOOLEAN, timeOut);

	}

	public List<WebElement> activityTimeLineListUnderCommunicationTab() {
		return FindElements(driver, "//a[contains(@class,'subjectLink')]", "activityTimeLineListUnderCommunicationTab");
	}

	public WebElement recordTypeRadioButton(String recordTypeRadioButton, int timeOut) {
		String xpath = "//span[text()='" + recordTypeRadioButton + "']/../preceding-sibling::div/input";

		try {
			return FindElement(driver, xpath, "recordTypeRadioButton: " + recordTypeRadioButton,
					action.SCROLLANDBOOLEAN, timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "recordTypeRadioButton: " + recordTypeRadioButton,
					action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	@FindBy(xpath = "//span[text()='Next']/parent::button")
	private WebElement nextButtonOnForm;

	public WebElement nextButtonOnForm(int timeOut) {

		return isDisplayed(driver, nextButtonOnForm, "Visibility", timeOut, "nextButtonOnForm");
	}

	public List<WebElement> searchItemsInResearch() {
		return FindElements(driver, "//div[contains(@class,'slds-table_header-fixed_container')]//table//tbody//tr",
				"searchItemsInResearch");
	}

	public WebElement noResultMsgInResearch(int timeOut) {

		String xpath = "//div[contains(@class,'noResultsTitle')]";

		try {
			return FindElement(driver, xpath, "No Result Msg in Research", action.SCROLLANDBOOLEAN, timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "No Result Msg in Research", action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public List<WebElement> researchSideNavLinksWithResults() {
		return FindElements(driver,
				"//lightning-vertical-navigation-item-badge[contains(@class,'slds-nav-vertical__item')]/a/span/ancestor::lightning-vertical-navigation-item-badge/a",
				"researchSideNavLinksWithResults");
	}

	public List<WebElement> researchSideNavCountResultsExceptAllCategories() {
		return FindElements(driver,
				"//lightning-vertical-navigation-item-badge[contains(@class,'slds-nav-vertical__item')]/a/span/ancestor::lightning-vertical-navigation-item-badge/a[not(text()='All Categories')]/span",
				"researchSideNavCountResultsExceptAllCategories");
	}

	public List<WebElement> researchSideNavLabelsWhichHasCountResultsExceptAllCategories() {
		return FindElements(driver,
				"//lightning-vertical-navigation-item-badge[contains(@class,'slds-nav-vertical__item')]/a/span/ancestor::lightning-vertical-navigation-item-badge/a[not(text()='All Categories')]",
				"researchSideNavLabelsWhichHasCountResultsExceptAllCategories");
	}
	/*
	 * public List<WebElement> researchSideNavResultsExceptAllCategories() { return
	 * FindElements(driver,
	 * "//lightning-vertical-navigation-item-badge[contains(@class,'slds-nav-vertical__item')]/a/span/ancestor::lightning-vertical-navigation-item-badge/a[not(text()='All Categories')]"
	 * , "researchSideNavResultsExceptAllCategories"); }
	 */

	public List<WebElement> researchResultsGridCounts() {
		return FindElements(driver,
				"//div[contains(@class,'windowViewMode-normal')]//div[contains(@class,'slds-col slds-size_1-of-1')]//span[contains(@class,'slds-page-header__title')]",
				"researchResultsGridCounts");
	}

	@FindBy(xpath = "//lightning-vertical-navigation-item-badge[contains(@class,'slds-nav-vertical__item')]/a/span/ancestor::lightning-vertical-navigation-item-badge/a[text()='All Categories']/span")
	private WebElement researchAllCategoriesCount;

	public WebElement researchAllCategoriesCount(int timeOut) {

		return isDisplayed(driver, researchAllCategoriesCount, "Visibility", timeOut, "researchAllCategoriesCount");
	}

	public List<WebElement> recordsUnderGridInResearchResults(String gridName) {
		return FindElements(driver,
				"//div[contains(@class,'slds-table_header-fixed_container')]//table//tbody//tr/ancestor::div[contains(@class,'slds-size_1-of-1')]//ul/li[2]/span[contains(text(),'"
						+ gridName + " ("
						+ "')]/ancestor::div[@class ='slds-grid slds-wrap']/following-sibling::div//tbody/tr",
				"recordsUnderGridInResearchResults");
	}

	public List<String> listOfRecordTypes() {
		return FindElements(driver, "//tbody//tr/td/a/span", "listOfRecordTypes").stream().map(x -> x.getText())
				.collect(Collectors.toList());

	}

	@FindBy(xpath = "//span[text()='Interactions']/ancestor::div[contains(@class,'slds-p-bottom_none')]//a[text()='View All']")
	private WebElement viewAllBtnOnIntration;

	public WebElement getViewAllBtnOnIntration(int timeOut) {
		return isDisplayed(driver, viewAllBtnOnIntration, "Visibility", timeOut, "view All button");
	}

	@FindBy(xpath = "//div[contains(@class,'slds-page-header__title')]//span")
	private WebElement pageHeaderTitle;

	public WebElement getPageHeaderTitle(int timeOut) {
		return isDisplayed(driver, pageHeaderTitle, "Visibility", timeOut, "page header title");
	}

	@FindBy(xpath = "//section//h2[contains(@class,\"slds-text-heading_small slds-hyphenate\")]")
	private WebElement activitySubjetLinkPopupHeaderOnInteraction;

	public WebElement activitySubjetLinkPopupHeaderOnInteraction(int timeOut) {
		return isDisplayed(driver, activitySubjetLinkPopupHeaderOnInteraction, "Visibility", timeOut,
				"activitySubjetLinkPopupHeaderOnInteraction");
	}

	public WebElement dealAcuityPopUpDealName(String dealName, int timeOut) {

		String xpath = "//a[text()='" + dealName + "']/ancestor::th[@data-label='Deal']//a";
		try {
			return FindElement(driver, xpath, "Header: " + dealName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + dealName, action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	@FindBy(xpath = "//header/button[@title='Close']")
	private WebElement connectionClosePopupButton;

	public WebElement connectionClosePopupButton(int timeOut) {
		return isDisplayed(driver, connectionClosePopupButton, "Visibility", timeOut, "connectionClosePopupButton");
	}

	public WebElement contactNameUserIconButton(String contactName, int timeOut) {

		String xpath = "//td[@data-label='Name']//a[text()='" + contactName
				+ "']/ancestor::td/preceding-sibling::td//button";
		try {
			return FindElement(driver, xpath, "Header: " + contactName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + contactName, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement connectionPopUpTeamMember(String teamMember, int timeOut) {

		String xpath = "//th[@data-label='Name']//lightning-base-formatted-text[text()='" + teamMember + "']";
		try {
			return FindElement(driver, xpath, "Header: " + teamMember, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + teamMember, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement connectionPopUpTitle(String teamMember, String title, int timeOut) {

		String xpath = "//lightning-base-formatted-text[text()='" + teamMember
				+ "']/ancestor::th[@data-label='Name']/..//td[@data-label='Title']//lightning-base-formatted-text";
		try {
			return FindElement(driver, xpath, "Header: " + title, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + title, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement connectionPopUpMeetingCallsCount(String teamMember, String meetingAndCalls, int timeOut) {

		String xpath = "//lightning-base-formatted-text[text()='" + teamMember
				+ "']/ancestor::th[@data-label='Name']/..//td[@data-col-key-value='meetCallRef-button-3']//button";
		try {
			return FindElement(driver, xpath, "Header: " + meetingAndCalls, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + meetingAndCalls, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement contactMeetingAndCallCount(String contactName, int timeOut) {
		String xpath = "//a[text()='" + contactName
				+ "']/ancestor::td[@data-label='Name']/..//td[@data-label='Meetings and Calls']//span//button";
		try {
			return FindElement(driver, xpath, "Contact Header: " + contactName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Contact Header: " + contactName, action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	public WebElement contactConnectionsCount(String contactName, int timeOut) {
		String xpath = "//a[text()='" + contactName
				+ "']/ancestor::tr//td[@role='gridcell']//button[@name='Connections']";
		try {
			return FindElement(driver, xpath, "Contact Header: " + contactName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Contact Header: " + contactName, action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	@FindBy(xpath = "//h2[contains(@class,'slds-text-heading_medium') and contains(text(),'Meetings and Calls')]")
	private WebElement meetingAndCallPopUp;

	public WebElement getMeetingAndCallPopUp(int timeOut) {
		return isDisplayed(driver, meetingAndCallPopUp, "Visibility", timeOut, "Meeting and calls popup");
	}

	@FindBy(xpath = "//li[contains(@class,'slds-dropdown-trigger_click')]//button[@class='slds-button slds-button_icon-border-filled']")
	private WebElement actionEroBtn;

	public WebElement getactionEroBtn(int timeOut) {
		return isDisplayed(driver, actionEroBtn, "Visibility", timeOut, "Action aero button");
	}

	@FindBy(xpath = "//a[@role='menuitem']/span[text()='Export']")
	private WebElement exportBtn;

	public WebElement getExportBtn(int timeOut) {
		return isDisplayed(driver, exportBtn, "Visibility", timeOut, "Export button");
	}

	@FindBy(xpath = "//h2[text()='Export']")
	private WebElement exportPopup;

	public WebElement getExportPopup(int timeOut) {
		return isDisplayed(driver, exportPopup, "Visibility", timeOut, "Export Popup");
	}

	@FindBy(xpath = "//h2[text()='Export']/ancestor::div[contains(@class,'slds-modal__container')]//button[@title='Close this window']")
	private WebElement exportPopupCloseBtn;

	public WebElement getexportPopupCloseBtn(int timeOut) {
		return isDisplayed(driver, exportPopupCloseBtn, "Visibility", timeOut, "Export Popup close button");
	}

	public WebElement getUtilityRecord(String utilityRecordName, int timeOut) {
		String xpath = "//ul[contains(@class,'utilitybar')]//li//span[text()='" + utilityRecordName + "']";
		try {
			return FindElement(driver, xpath, "Utility header: " + utilityRecordName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Utility header: " + utilityRecordName, action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	@FindBy(xpath = "//*[local-name()='svg' and @class='slds-icon slds-icon-text-default slds-icon_small']/../..")
	private WebElement notificationIcon;

	public WebElement getNotificationIcon() {
		return notificationIcon;
	}

	@FindBy(xpath = "//div[contains(@class,'slds-grid slds-wrap slds-border_top')]//child::a")
	private List<WebElement> notificationOptions;

	public List<WebElement> getNotificationOptions() {
		return notificationOptions;
	}

	@FindBy(xpath = "//div[contains(@class,'slds-grid slds-wrap slds-border_top')]//child::button[text()='Add Note']")
	private List<WebElement> notificationButtons;

	public List<WebElement> getnotificationButtons() {
		return notificationButtons;
	}

	public WebElement editButtonOnInteractionCard(String subjectName, int timeOut) {
		String xpath = "//a[text()='" + subjectName + "']/../preceding-sibling::div//button[@title='Edit Note']";
		WebElement ele = FindElement(driver, xpath, "Header Found: " + subjectName, action.SCROLLANDBOOLEAN, timeOut);
		try {
			return isDisplayed(driver, ele, "Visibility", timeOut, "Header Found: " + subjectName);

		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver, ele, "Visibility", timeOut, "] Header Found: " + subjectName);
		}
	}

	public WebElement suggestedTagHeading(int timeOut) {
		String xpath = "//header//h2[text()='Suggested Tags']";
		WebElement ele = FindElement(driver, xpath, "Suggested Tags", action.SCROLLANDBOOLEAN, timeOut);
		try {
			return isDisplayed(driver, ele, "Visibility", timeOut, "Suggested Tags");

		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver, ele, "Visibility", timeOut, "Suggested Tags");
		}
	}

	public List<WebElement> listOfColumnsOfSuggestedTags() {
		return FindElements(driver,
				"//h2[text()=\"Suggested Tags\"]/ancestor::section//lightning-datatable[@class=\"seletedtag-datatable\"]//table//thead//th[@aria-label]",
				"listOfColumnsOfSuggestedTags");
	}

	@FindBy(xpath = "//lightning-layout-item//p[contains(@class,'slds-m-top_small')]")
	private WebElement suggestedTagCountOfCheckBoxes;

	public WebElement suggestedTagCountOfCheckBoxes() {
		return suggestedTagCountOfCheckBoxes;
	}

	public List<WebElement> suggestedTagFooterButtons() {
		return FindElements(driver, "//section//footer//button", "suggestedTagFooterButtons");
	}

	@FindBy(xpath = "//h2[text()=\"Suggested Tags\"]/parent::header/following-sibling::div//tr/th//input[@class=\"datatable-select-all\"]")
	private WebElement suggestedTagsCheckBoxAllInput;

	public WebElement suggestedTagsCheckBoxAllInput() {
		return suggestedTagsCheckBoxAllInput;
	}

	public WebElement assignedToVerificationInAdvance(String fieldName, int timeOut) {

		String xpath = "//div[@class='slds-modal__container']//span[text()='Advanced']/ancestor::section[contains(@class,'slds-accordion__section')]/div[2]//lightning-layout//label[text()='"
				+ fieldName + "']/../div//span/span[2]";
		try {
			return isDisplayed(driver,
					FindElement(driver, xpath, "Text Found: " + fieldName, action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Header: " + fieldName);
		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver,
					FindElement(driver, xpath, "Text Found: " + fieldName, action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Header: " + fieldName);
		}
	}

	public WebElement statusVerificationInAdvanced(String fieldName, int timeOut) {

		String xpath = "//div[@class='slds-modal__container']//span[text()='Advanced']/ancestor::section[contains(@class,'slds-accordion__section')]/div[2]//lightning-layout//label[text()='"
				+ fieldName + "']/../div//button/span";
		try {
			return isDisplayed(driver,
					FindElement(driver, xpath, "Text Found: " + fieldName, action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Header: " + fieldName);
		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver,
					FindElement(driver, xpath, "Text Found: " + fieldName, action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Header: " + fieldName);
		}
	}

	public WebElement dueDateOnlyVerificationInAdvanced(String fieldName, int timeOut) {

		String xpath = "//div[@class='slds-modal__container']//span[text()='Advanced']/ancestor::section[contains(@class,'slds-accordion__section')]/div[2]//lightning-layout//label[text()='"
				+ fieldName + "']/../div//input";
		try {
			return isDisplayed(driver,
					FindElement(driver, xpath, "Text Found: " + fieldName, action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Header: " + fieldName);
		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver,
					FindElement(driver, xpath, "Text Found: " + fieldName, action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Header: " + fieldName);
		}
	}

	public WebElement priorityVerificationInAdvanced(String fieldName, int timeOut) {

		String xpath = "//div[@class='slds-modal__container']//span[text()='Advanced']/ancestor::section[contains(@class,'slds-accordion__section')]/div[2]//lightning-layout//label[text()='"
				+ fieldName + "']/../div//button/span";
		try {
			return isDisplayed(driver,
					FindElement(driver, xpath, "Text Found: " + fieldName, action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Header: " + fieldName);
		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver,
					FindElement(driver, xpath, "Text Found: " + fieldName, action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Header: " + fieldName);
		}
	}

	public WebElement subjectVerificationInTasks(String fieldName, int timeOut) {

		String xpath = "//div[@class='slds-modal__container']//span[text()='Tasks']/ancestor::div[@class='slds-accordion__summary']/following-sibling::div//label[text()='"
				+ fieldName + "']/../div//input";
		try {
			return isDisplayed(driver,
					FindElement(driver, xpath, "Text Found: " + fieldName, action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Header: " + fieldName);
		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver,
					FindElement(driver, xpath, "Text Found: " + fieldName, action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Header: " + fieldName);
		}
	}

	public WebElement assignedToVerificationInTasks(String fieldName, int timeOut) {

		String xpath = "//div[@class='slds-modal__container']//span[text()='Tasks']/ancestor::div[@class='slds-accordion__summary']/following-sibling::div//label[text()='"
				+ fieldName + "']/../div//span/span[2]";
		try {
			return isDisplayed(driver,
					FindElement(driver, xpath, "Text Found: " + fieldName, action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Header: " + fieldName);
		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver,
					FindElement(driver, xpath, "Text Found: " + fieldName, action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Header: " + fieldName);
		}
	}

	public WebElement statusVerificationInTasks(String fieldName, int timeOut) {

		String xpath = "//div[@class='slds-modal__container']//span[text()='Tasks']/ancestor::div[@class='slds-accordion__summary']/following-sibling::div//label[text()='"
				+ fieldName + "']/../div//button/span";
		try {
			return isDisplayed(driver,
					FindElement(driver, xpath, "Text Found: " + fieldName, action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Header: " + fieldName);
		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver,
					FindElement(driver, xpath, "Text Found: " + fieldName, action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Header: " + fieldName);
		}
	}

	public WebElement dueDateOnlyVerificationInTasks(String fieldName, int timeOut) {

		String xpath = "//div[@class='slds-modal__container']//span[text()='Tasks']/ancestor::div[@class='slds-accordion__summary']/following-sibling::div//label[text()='"
				+ fieldName + "']/../div//input";
		try {
			return isDisplayed(driver,
					FindElement(driver, xpath, "Text Found: " + fieldName, action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Header: " + fieldName);
		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver,
					FindElement(driver, xpath, "Text Found: " + fieldName, action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Header: " + fieldName);
		}
	}

	public WebElement testCustomObjectTextBoxInput(String fieldName, int timeOut) {

		String xpath = "//label[text()='" + fieldName + "']/following-sibling::div/input";
		try {
			return isDisplayed(driver,
					FindElement(driver, xpath, "Text Found: " + fieldName, action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Header: " + fieldName);
		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver,
					FindElement(driver, xpath, "Text Found: " + fieldName, action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Header: " + fieldName);
		}
	}

	public WebElement testCustomObjectFooterButton(String buttonName, int timeOut) {

		String xpath = "//records-form-footer//li//button[text()='" + buttonName + "']";
		try {
			return isDisplayed(driver,
					FindElement(driver, xpath, "Text Found: " + buttonName, action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Header: " + buttonName);
		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver,
					FindElement(driver, xpath, "Text Found: " + buttonName, action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Header: " + buttonName);
		}
	}

	public WebElement testCustomObjectNewButton(int timeOut) {

		String xpath = "//div[text()='New']/parent::a";
		try {
			return isDisplayed(driver, FindElement(driver, xpath, "New Button", action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Header: " + "New Button");
		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver, FindElement(driver, xpath, "New Button", action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Header: " + "New Button");
		}
	}

	public WebElement notePopUpHeading(String headerName, int timeOut) {

		String xpath = "//section[contains(@class,\"slds-fade-in-open\")]//div[@class=\"slds-modal__container\"]//h2[contains(text(), \""
				+ headerName + "\")]";
		try {
			return isDisplayed(driver,
					FindElement(driver, xpath, "Popup Heading: " + headerName, action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Popup Heading: " + headerName);
		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver,
					FindElement(driver, xpath, "Popup Heading: " + headerName, action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Popup Heading: " + headerName);
		}
	}

	public WebElement notePopUpCrossButton(int timeOut) {

		String xpath = "//section[contains(@class,'slds-fade-in-open')]//div[@class='slds-modal__container']//button[@title='Close']";
		try {
			return isDisplayed(driver, FindElement(driver, xpath, "Cross Button", action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Header: " + "Cross Button");
		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver, FindElement(driver, xpath, "Cross Button", action.SCROLLANDBOOLEAN, timeOut),
					"Visibility", timeOut, "Header: " + "Cross Button");
		}
	}

	public WebElement notePopUpAddMoreButton(int timeOut) {

		String xpath = "//section[contains(@class,'slds-fade-in-open')]//div[@class='slds-modal__container']//button[text()='Add More']";
		try {
			return FindElement(driver, xpath, "Add More Button", action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Add More Button", action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	public List<WebElement> notePopUpFooterButtons() {
		return FindElements(driver,
				"//section[contains(@class,'slds-fade-in-open')]//div[@class='slds-modal__container']//footer//button",
				"notePopUpFooterButtons");
	}

	public WebElement taskSectonInNotePopUpNotExpanded(int timeOut) {
		String xPath = "//span[@class=\"slds-accordion__summary-content\" and text()='Tasks']/ancestor::button[@aria-expanded='false']";

		return isDisplayed(driver, FindElement(driver, xPath, "Task" + " section", action.SCROLLANDBOOLEAN, timeOut),
				"Visibility", timeOut, "Task" + " section");
	}

	public WebElement crossButtonOfRelatedAssociation(String relatedAssociationName, int timeOut) {

		String xpath = "//div/lightning-pill/span/span[2][text()='" + relatedAssociationName
				+ "']/preceding-sibling::span/following-sibling::lightning-button-icon/button";
		try {
			return FindElement(driver, xpath, "Cross Button of Related Association: " + relatedAssociationName,
					action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Cross Button of Related Association: " + relatedAssociationName,
					action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	public List<WebElement> taggedRelatedToInNotePopUp() {
		return FindElements(driver, "//div/lightning-pill[not(contains(@class,'d_flex'))]/span/span[2]",
				"taggedRelatedToInNotePopUp");
	}

	public WebElement relatedAssocitionWithIcon(String relatedAssociationName, String recordType, int timeOut) {

		if (recordType.equalsIgnoreCase("Firm") || recordType.equalsIgnoreCase("Account")) {
			String xpath = "//div/lightning-pill[not(contains(@class,'d_flex'))]/span/span[2][text()='"
					+ relatedAssociationName + "']/preceding-sibling::span//*[@data-key='account']";
			try {
				return FindElement(driver, xpath, recordType + " & its Icon: " + relatedAssociationName,
						action.SCROLLANDBOOLEAN, timeOut);
			} catch (StaleElementReferenceException e) {
				return FindElement(driver, xpath, recordType + " & its Icon: " + relatedAssociationName,
						action.SCROLLANDBOOLEAN, timeOut);
			}
		} else if (recordType.equalsIgnoreCase("Deal")) {
			String xpath = "//div/lightning-pill[not(contains(@class,'d_flex'))]/span/span[2][text()='"
					+ relatedAssociationName + "']/preceding-sibling::span//*[@data-key='custom47']";
			try {
				return FindElement(driver, xpath, recordType + " & its Icon: " + relatedAssociationName,
						action.SCROLLANDBOOLEAN, timeOut);
			} catch (StaleElementReferenceException e) {
				return FindElement(driver, xpath, recordType + " & its Icon: " + relatedAssociationName,
						action.SCROLLANDBOOLEAN, timeOut);
			}
		} else if (recordType.equalsIgnoreCase("Contact")) {

			String xpath = "//div/lightning-pill[not(contains(@class,'d_flex'))]/span/span[2][text()='"
					+ relatedAssociationName + "']/preceding-sibling::span//*[@data-key='contact']";
			try {
				return FindElement(driver, xpath, recordType + " & its Icon: " + relatedAssociationName,
						action.SCROLLANDBOOLEAN, timeOut);
			} catch (StaleElementReferenceException e) {
				return FindElement(driver, xpath, recordType + " & its Icon: " + relatedAssociationName,
						action.SCROLLANDBOOLEAN, timeOut);
			}

		} else if (recordType.equalsIgnoreCase("Fund")) {

			String xpath = "//div/lightning-pill[not(contains(@class,'d_flex'))]/span/span[2][text()='"
					+ relatedAssociationName + "']/preceding-sibling::span//*[@data-key='custom34']";
			try {
				return FindElement(driver, xpath, recordType + " & its Icon: " + relatedAssociationName,
						action.SCROLLANDBOOLEAN, timeOut);
			} catch (StaleElementReferenceException e) {
				return FindElement(driver, xpath, recordType + " & its Icon: " + relatedAssociationName,
						action.SCROLLANDBOOLEAN, timeOut);
			}

		} else if (recordType.equalsIgnoreCase("Fundraising")) {

			String xpath = "//div/lightning-pill[not(contains(@class,'d_flex'))]/span/span[2][text()='"
					+ relatedAssociationName + "']/preceding-sibling::span//*[@data-key='custom3']";
			try {
				return FindElement(driver, xpath, recordType + " & its Icon: " + relatedAssociationName,
						action.SCROLLANDBOOLEAN, timeOut);
			} catch (StaleElementReferenceException e) {
				return FindElement(driver, xpath, recordType + " & its Icon: " + relatedAssociationName,
						action.SCROLLANDBOOLEAN, timeOut);
			}

		} else if (recordType.equalsIgnoreCase("User")) {

			String xpath = "//div/lightning-pill[not(contains(@class,'d_flex'))]/span/span[2][text()='"
					+ relatedAssociationName + "']/preceding-sibling::span//*[@data-key='user']";
			try {
				return FindElement(driver, xpath, recordType + " & its Icon: " + relatedAssociationName,
						action.SCROLLANDBOOLEAN, timeOut);
			} catch (StaleElementReferenceException e) {
				return FindElement(driver, xpath, recordType + " & its Icon: " + relatedAssociationName,
						action.SCROLLANDBOOLEAN, timeOut);
			}

		}

		else if (recordType.equalsIgnoreCase("CustomObject")) {
			String xpath = "//div/lightning-pill[not(contains(@class,'d_flex'))]/span/span[2][text()='"
					+ relatedAssociationName + "']/preceding-sibling::span//*[@data-key='custom20']";
			try {
				return FindElement(driver, xpath, recordType + " & its Icon: " + relatedAssociationName,
						action.SCROLLANDBOOLEAN, timeOut);
			} catch (StaleElementReferenceException e) {
				return FindElement(driver, xpath, recordType + " & its Icon: " + relatedAssociationName,
						action.SCROLLANDBOOLEAN, timeOut);
			}

		}

		else {

			log(LogStatus.ERROR, "Please Provide the correct Icon Name, Provided by you: " + recordType, YesNo.No);
			sa.assertTrue(false, "Please Provide the correct Icon Name, Provided by you: " + recordType);
			return null;
		}

	}

	public WebElement crossIconButtonInNotePopUp(int timeOut) {
		String xPath = "//header/button[@title='Close']";

		return isDisplayed(driver, FindElement(driver, xPath, "Cross icon", action.SCROLLANDBOOLEAN, timeOut),
				"Visibility", timeOut, "Cross Icon");
	}

	public WebElement subjectOfInteractionCard(String subjectName, int timeOut) {
		String xpath = "//a[@class=\"interaction_sub subject_text\" and text()=\"" + subjectName + "\"]";
		WebElement ele = FindElement(driver, xpath, "subjectOfInteractionCard: " + subjectName, action.SCROLLANDBOOLEAN,
				timeOut);
		try {
			return isDisplayed(driver, ele, "Visibility", timeOut, "subjectOfInteractionCard: " + subjectName);

		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver, ele, "Visibility", timeOut, "subjectOfInteractionCard: " + subjectName);
		}
	}

	public WebElement subjectOfInteractionPage(String subjectName, int timeOut) {

		String xpath = "//td[@data-label=\"Subject\"]//button[@name=\"subject\" and text()='" + subjectName + "']";
		WebElement ele = FindElement(driver, xpath, "subject of Interaction page: " + subjectName,
				action.SCROLLANDBOOLEAN, timeOut);
		try {
			return isDisplayed(driver, ele, "Visibility", timeOut, "subject of Interaction page: " + subjectName);

		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver, ele, "Visibility", timeOut, "subject of Interaction page: " + subjectName);
		}
	}

	public WebElement popupCloseButton(String popupName, int timeOut) {
		String xpath = "//h2[contains(text(),'" + popupName + "')]/..//lightning-icon[@title='Close']/parent::button";
		WebElement ele = FindElement(driver, xpath, popupName + " close button", action.SCROLLANDBOOLEAN, timeOut);
		try {
			return isDisplayed(driver, ele, "Visibility", timeOut, popupName + " close button");
		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver, ele, "Visibility", timeOut, popupName + " close button");
		}
	}

	public List<String> acuityViewAllPopUpIcons() {
		return FindElements(driver,
				"//h2[contains(text(),'All Interactions')]/..//following-sibling::div//th[@data-label='Type']//lightning-icon",
				"acuityViewAllPopUpIcons").stream().map(x -> CommonLib.getAttribute(driver, x, "Icons", "class"))
				.collect(Collectors.toList());

	}

	public List<String> acuityViewAllPopUpDates() {
		return FindElements(driver,
				"//h2[contains(text(),'All Interactions')]/..//following-sibling::div//tr//td[@data-label='Date']//lightning-base-formatted-text",
				"acuityViewAllPopUpDates").stream().map(x -> CommonLib.getText(driver, x, "Dates", action.BOOLEAN))
				.collect(Collectors.toList());

	}

	public List<String> acuityViewAllPopUpSubjects() {
		return FindElements(driver,
				"//h2[contains(text(),'All Interactions')]/..//following-sibling::div//tr//td[@data-label='Subject']//a",
				"acuityViewAllPopUpSubjects").stream()
				.map(x -> CommonLib.getText(driver, x, "Subjects", action.BOOLEAN)).collect(Collectors.toList());

	}

	public List<String> acuityViewAllPopUpDetails() {
		return FindElements(driver,
				"//h2[contains(text(),'All Interactions')]/..//following-sibling::div//tr//td[@data-label='Details']//button",
				"acuityViewAllPopUpDescriptions").stream()
				.map(x -> CommonLib.getText(driver, x, "Details", action.BOOLEAN)).collect(Collectors.toList());

	}

	public List<String> acuityViewAllPopUpAssignedTo() {
		return FindElements(driver,
				"//h2[contains(text(),'All Interactions')]/..//following-sibling::div//tr//td[@data-label='Assigned To']//a",
				"acuityViewAllPopUpAssignedTo").stream()
				.map(x -> CommonLib.getText(driver, x, "AssignedTo", action.BOOLEAN)).collect(Collectors.toList());

	}

	public WebElement valueOfLabelInDetailPage(String labelName, int timeOut) {
		String xpath = "//span[normalize-space(text()) ='" + labelName + "']/parent::div/following-sibling::div";

		try {
			return FindElement(driver, xpath, "User Header Found: " + labelName, action.BOOLEAN, timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "User Header Found: " + labelName, action.BOOLEAN, timeOut);
		}
	}

	@FindBy(xpath = "//p[text()='No items to display.']")
	private WebElement ErrorMsg;

	/**
	 * @return the navigationPopUpHeader
	 */
	public WebElement getErrorMsg(int timeOut) {
		WebElement ele = isDisplayed(driver, ErrorMsg, "Visibility", timeOut, "ErrorMsg");
		return ele;
	}

	@FindBy(xpath = "//span[contains(text(),'Deals With')]")
	private WebElement DealCountPopHeader;

	public WebElement getDealCountPopHeader(int timeOut) {
		WebElement ele = isDisplayed(driver, DealCountPopHeader, "Visibility", timeOut, "DealCountPopHeader");
		return ele;
	}

	@FindBy(xpath = "//a[@title='ADENCOM']")
	private WebElement anywhereonpage;

	public WebElement getanywhereonpage(int timeOut) {
		WebElement ele = isDisplayed(driver, anywhereonpage, "Visibility", timeOut, "anywhereonpage");
		return ele;
	}

	public WebElement Time(String tagName, int timeOut) {
		String xpath = "//span[text()='" + tagName + "']/ancestor::table//button[@name='timesRef']";
		WebElement ele = FindElement(driver, xpath, tagName + " close button", action.SCROLLANDBOOLEAN, timeOut);
		try {
			return isDisplayed(driver, ele, "Visibility", timeOut, tagName + " close button");

		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver, ele, "Visibility", timeOut, tagName + " close button");
		}
	}

	@FindBy(xpath = "//div[contains(@class,'recordTypeName')]/following-sibling::lightning-button-icon/button")
	private WebElement editRecordTypeButton;

	public WebElement geteditRecordTypeButton(String projectName, int timeOut) {
		return isDisplayed(driver, editRecordTypeButton, "Visibility", timeOut, "editRecordTypeButton");
	}

	@FindBy(xpath = "//div/p//b[text() = \"You don't have any notifications right now.\"]")
	private WebElement notificationMsgInRecordPage;

	public WebElement notificationMsgInRecordPage(int timeOut) {
		return isDisplayed(driver, notificationMsgInRecordPage, "Visibility", timeOut, "notificationMsgInRecordPage");
	}

	@FindBy(xpath = "//section/lightning-layout//slot/span[text()='Notifications']")
	private WebElement notificationHeaderInRecordDetailsPage;

	public WebElement notificationHeaderInRecordDetailsPage(int timeOut) {
		return isDisplayed(driver, notificationHeaderInRecordDetailsPage, "Visibility", timeOut,
				"notificationHeaderInRecordDetailsPage");
	}

	@FindBy(xpath = "//section/lightning-layout//slot//lightning-icon[@title='Close']")
	private WebElement notificationCloseIconInRecordDetailsPage;

	public WebElement notificationCloseIconInRecordDetailsPage(int timeOut) {
		return isDisplayed(driver, notificationCloseIconInRecordDetailsPage, "Visibility", timeOut,
				"notificationCloseIconInRecordDetailsPage");
	}

	@FindBy(xpath = "//div[text()='Edit']/parent::a")
	private WebElement editButtonInEventDetailPage;

	public WebElement editButtonInEventDetailPage(int timeOut) {
		return isDisplayed(driver, editButtonInEventDetailPage, "Visibility", timeOut, "editButtonInEventDetailPage");
	}

	@FindBy(xpath = "//div[text()='Delete']/parent::a")
	private WebElement deleteButtonInEventDetailPage;

	public WebElement deleteButtonInEventDetailPage(int timeOut) {
		return isDisplayed(driver, deleteButtonInEventDetailPage, "Visibility", timeOut,
				"deleteButtonInEventDetailPage");
	}

	public WebElement eventNotPopUpAdvanceSectionDateTime(String parentLabelName, String subLabelName, int timeOut) {
		String xpath = "//legend[text()=\"" + parentLabelName + "\"]/parent::fieldset//label[text()=\"" + subLabelName
				+ "\"]/following-sibling::div//input";

		try {
			return FindElement(driver, xpath, subLabelName + " of " + parentLabelName, action.SCROLLANDBOOLEAN,
					timeOut);

		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, subLabelName + " of " + parentLabelName, action.SCROLLANDBOOLEAN,
					timeOut);
		}
	}

	@FindBy(xpath = "//lightning-icon[@title='Filter' and contains(@class,'filtr-icon')]")
	private WebElement filterIconOnInteractionPopup;

	public WebElement getFilterIconOnInteractionPopup(int timeOut) {
		return isDisplayed(driver, filterIconOnInteractionPopup, "Visibility", timeOut,
				"filter icon on interaction popup");
	}

	@FindBy(xpath = "//div//section[contains(@class,'myfilter')]//h3")
	private WebElement headingOnFilterSectionInteractionPopup;

	public WebElement getheadingOnFilterSectionInteractionPopup(int timeOut) {
		return isDisplayed(driver, headingOnFilterSectionInteractionPopup, "Visibility", timeOut,
				"filter heading on filter section of interaction popup");
	}

	@FindBy(xpath = "//div//section[contains(@class,'myfilter')]//lightning-icon[@title='Close']")
	private WebElement closeIconOnFilterSectiOnInteractionPopup;

	public WebElement getcloseIconOnFilterSectiOnInteractionPopup(int timeOut) {
		return isDisplayed(driver, closeIconOnFilterSectiOnInteractionPopup, "Visibility", timeOut,
				"close icon on filter section of interaction popup");
	}

	@FindBy(xpath = "//lightning-icon[@title='Filter' and contains(@class,'filtr-icon')]")
	private WebElement filterIconOnMeetingAndCallPopup;

	public WebElement getfilterIconOnMeetingAndCallPopup(int timeOut) {
		return isDisplayed(driver, filterIconOnMeetingAndCallPopup, "Visibility", timeOut,
				"filter icon on Meeting and call popup");
	}

	@FindBy(xpath = "//section[contains(@class,'myfilter')]//h3")
	private WebElement headingOnFilterSectionMeetingAndCallPopup;

	public WebElement getheadingOnFilterSectionMeetingAndCallPopup(int timeOut) {
		return isDisplayed(driver, headingOnFilterSectionMeetingAndCallPopup, "Visibility", timeOut,
				"filter heading on filter section of meeting and call popup");
	}

	@FindBy(xpath = "//section[contains(@class,'myfilter')]//lightning-icon[@title='Close']")
	private WebElement closeIconOnFilterSectiOnMeetingAndCallPopup;

	public WebElement getcloseIconOnFilterSectiOnMeetingAndCallPopup(int timeOut) {
		return isDisplayed(driver, closeIconOnFilterSectiOnMeetingAndCallPopup, "Visibility", timeOut,
				"close icon on filter section of interaction popup");
	}

	@FindBy(xpath = "//td[@class='pbButton']//input[@title='Edit']")
	private WebElement EditUserLink;

	/**
	 * @return the newUserLink
	 */
	public WebElement getEditUserLink(int timeOut) {
		return isDisplayed(driver, EditUserLink, "Visibility", timeOut, "Edit User Link");
	}

	@FindBy(xpath = "//input[@name='active']")
	private WebElement ActiveUserCheckBox;

	/**
	 * @return the salesforceCRMContentUserCheckBox
	 */
	public WebElement getActiveUserCheckBox(int timeOut) {
		return isDisplayed(driver, ActiveUserCheckBox, "Visibility", timeOut, "Active User Check Box");
	}

	@FindBy(xpath = "//input[@id='simpleDialog0button0']")
	private WebElement popupOKbutton;

	/**
	 * @return the salesforceCRMContentUserCheckBox
	 */
	public WebElement getpopupOKbutton(int timeOut) {
		return isDisplayed(driver, popupOKbutton, "Visibility", timeOut, "pop up OK button");
	}

	public WebElement addButtonOnInteractionCard(String subjectName, int timeOut) {
		String xpath = "//a[text()='" + subjectName + "']/../preceding-sibling::div//button[@title='Add Note']";
		WebElement ele = FindElement(driver, xpath, "Header Found: " + subjectName, action.SCROLLANDBOOLEAN, timeOut);
		try {
			return isDisplayed(driver, ele, "Visibility", timeOut, "Header Found: " + subjectName);

		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver, ele, "Visibility", timeOut, "] Header Found: " + subjectName);
		}
	}

	public WebElement getEditButton(int timeOut) {
		return isDisplayed(driver, editButton, "Visibility", timeOut, "Edit button");
	}

	@FindBy(xpath = "//button[@class='slds-button slds-button_neutral' and @name='Edit']")
	private WebElement editButton;

	public WebElement getEditButtonOnActivityPage(int timeOut) {
		return isDisplayed(driver, editButtonOnActivityPage, "Visibility", timeOut, "Edit button");
	}

	@FindBy(xpath = "//a[@class='forceActionLink']/div[@title='Edit']")
	private WebElement editButtonOnActivityPage;

	public WebElement addNoteButtonInNotificationOfRecordDetailPage(String eventName, int timeOut) {
		String xpath = "//b[text()=\"" + eventName
				+ "\"]/ancestor::div[contains(@class,\"slds-border_top\")]//div//lightning-button/button[text()=\"Add Note\"]";
		WebElement ele = FindElement(driver, xpath, "Header Found: " + eventName, action.SCROLLANDBOOLEAN, timeOut);
		try {
			return isDisplayed(driver, ele, "Visibility", timeOut, "Header Found: " + eventName);

		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver, ele, "Visibility", timeOut, "] Header Found: " + eventName);
		}
	}

	public WebElement linkOfEventInNotificationOfRecordDetailPage(String eventName, int timeOut) {
		String xpath = "//b[text()=\"" + eventName + "\"]/ancestor::div[contains(@class,\"slds-border_top\")]//div//a";
		WebElement ele = FindElement(driver, xpath, "Header Found: " + eventName, action.SCROLLANDBOOLEAN, timeOut);
		try {
			return isDisplayed(driver, ele, "Visibility", timeOut, "Header Found: " + eventName);

		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver, ele, "Visibility", timeOut, "] Header Found: " + eventName);
		}
	}

	@FindBy(xpath = "//lightning-icon[@title=\"Notifications\"]/following-sibling::div[@class=\"countDot\"]/span")
	private WebElement countOfAcuityNotificationInRecordDetailPage;

	public WebElement countOfAcuityNotificationInRecordDetailPage(int timeOut) {
		return isDisplayed(driver, countOfAcuityNotificationInRecordDetailPage, "Visibility", timeOut,
				"countOfAcuityNotificationInRecordDetailPage");
	}

	public WebElement eventDetailPageHeader(String eventName, int timeOut) {
		String xpath = "//span[text()=\"" + eventName + "\"]/ancestor::h1/div[text()=\"Event\"]";
		WebElement ele = FindElement(driver, xpath, "Header Found: " + eventName, action.SCROLLANDBOOLEAN, timeOut);
		try {
			return isDisplayed(driver, ele, "Visibility", timeOut, "Header Found: " + eventName);

		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver, ele, "Visibility", timeOut, "] Header Found: " + eventName);
		}
	}

	public WebElement recordDetailPageHeader(String recordName, int timeOut) {
		String xpath = "//*[(contains(@class,\"custom-truncate\") or @slot=\"primaryField\") and text()=\"" + recordName
				+ "\"]";
		WebElement ele = FindElement(driver, xpath, "Header Found: " + recordName, action.SCROLLANDBOOLEAN, timeOut);
		try {
			return isDisplayed(driver, ele, "Visibility", timeOut, "Header Found: " + recordName);

		} catch (StaleElementReferenceException e) {
			return isDisplayed(driver, ele, "Visibility", timeOut, "Header Found: " + recordName);
		}
	}

	public WebElement contactname(String contactName, int timeOut) {

		String xpath = "//a[text()='" + contactName + "']";
		try {
			return FindElement(driver, xpath, "Contact Header: " + contactName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Contact Header: " + contactName, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement Username(String UserName, int timeOut) {

		String xpath = "//a[text()='" + UserName + "']";
		try {
			return FindElement(driver, xpath, "Contact Header: " + UserName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Contact Header: " + UserName, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement ContactRecordPage(String contactname, int timeOut) {

		try {
			return FindElement(driver, "//div[text()='Contact']/parent::h1//span[text()='" + contactname + "']",
					"Contact Header: " + contactname, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver,
					"//div[text()='Deal']/parent::h1//lightning-formatted-text[text()='\"+dealName+\"']",
					"Contact Header: " + contactname, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement UserRecordPage(String Username, int timeOut) {

		try {
			return FindElement(driver, "//b//span[text()='" + Username + "']", "Contact Header: " + Username,
					action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, "//span//span[text()='" + Username + "']", "Contact Header: " + Username,
					action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	@FindBy(xpath = "//div[@class='slds-modal__container']//div[text()='No items to display']")
	private WebElement contactEmailCountpopup;

	public WebElement getcontactEmailCountpopup(int timeOut) {
		return isDisplayed(driver, contactEmailCountpopup, "Visibility", timeOut, "contactEmailCountpopup");
	}

	public WebElement contactPopUpTO(String subject, String Toname, int timeOut) {

		String xpath = "//a[text()='" + subject + "']/ancestor::tr//button[@name = 'to' and text()='" + Toname + "']";
		try {
			return FindElement(driver, xpath, "for to: " + Toname, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "for to: " + Toname, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement ToPopup(String Toname, int timeOut) {

		String xpath = "//div[@class='slds-modal__container']//a[text()='" + Toname + "']";
		try {
			return FindElement(driver, xpath, "for to: " + Toname, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "for to: " + Toname, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	@FindBy(xpath = "//h2[text()='New Contact']")
	private WebElement Contactpopupheader;

	public WebElement getContactpopupheader(int timeOut) {
		return isDisplayed(driver, Contactpopupheader, "Visibility", timeOut, "Contactpopupheader");
	}

	@FindBy(xpath = "//h2[text()='New Financing']")
	private WebElement NewFinanacingpopupheader;

	public WebElement getNewFinanacingpopupheader(int timeOut) {
		return isDisplayed(driver, NewFinanacingpopupheader, "Visibility", timeOut, "NewFinanacingpopupheader");
	}

	@FindBy(xpath = "//h2[text()='New Deal']")
	private WebElement NewDealpopupheader;

	public WebElement getNewDealpopupheader(int timeOut) {
		return isDisplayed(driver, NewDealpopupheader, "Visibility", timeOut, "NewDealpopupheader");
	}

	@FindBy(xpath = "//h2[text()='New Sourced Deal']")
	private WebElement NewSourcedDealpopupheader;

	public WebElement getNewSourcedDealpopupheader(int timeOut) {
		return isDisplayed(driver, NewSourcedDealpopupheader, "Visibility", timeOut, "NewSourcedDealpopupheader");
	}

	@FindBy(xpath = "//div[@class='slds-page-header__name-title']//h1")
	private WebElement Connectionpopupheader;

	public WebElement getConnectionpopupheader(int timeOut) {
		return isDisplayed(driver, Connectionpopupheader, "Visibility", timeOut, "Connectionpopupheader");
	}

	public WebElement CCPopup(String CCname, int timeOut) {

		String xpath = "//div[@class='slds-modal__container']//a[text()='" + CCname + "']";
		try {
			return FindElement(driver, xpath, "for to: " + CCname, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "for to: " + CCname, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement contactPopUpCC(String subject, String CCname, int timeOut) {

		String xpath = "//a[text()='" + subject + "']/ancestor::tr//button[@name = 'cc' and text()='" + CCname + "']";
		try {
			return FindElement(driver, xpath, "for CC: " + CCname, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "for CC: " + CCname, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement connectionicon(String contactname, int timeOut) {

		String xpath = "//a[text()='" + contactname + "']/ancestor::tr//button[@name='Connections']";
		try {
			return FindElement(driver, xpath, "Header: " + contactname, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + contactname, action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	public WebElement DownloadIcon(String contactname, int timeOut) {
		WebElement ele;
		String xpath = "//a[text()='" + contactname + "']/ancestor::tr//button[@name='downloadIcon']";
		return ele = isDisplayed(driver,
				FindElement(driver, xpath, "Download Icon Found: " + contactname, action.SCROLLANDBOOLEAN, timeOut),
				"Visibility", 10, "Download Icon");
	}

	public WebElement NewFinancingIcon(int timeOut) {
		WebElement ele;
		String xpath = "//*[@title='New Financing']";
		return ele = isDisplayed(driver, FindElement(driver, xpath, "New Financing Icon: " + "NewFinancingIcon",
				action.SCROLLANDBOOLEAN, timeOut), "Visibility", 10, "New Financing Icon");
	}

	public WebElement NewDealIcon(int timeOut) {
		WebElement ele;
		String xpath = "//*[@title='New Deal']";
		return ele = isDisplayed(driver,
				FindElement(driver, xpath, "New Deal Icon: " + "NewDealIcon", action.SCROLLANDBOOLEAN, timeOut),
				"Visibility", 10, "New Deal Icon");
	}

	public WebElement NewSourcedDealIcon(int timeOut) {
		WebElement ele;
		String xpath = "//*[@title='New Sourced Deal']";
		return ele = isDisplayed(driver, FindElement(driver, xpath, "New Sourced Deal Icon: " + "NewSourcedDealIcon",
				action.SCROLLANDBOOLEAN, timeOut), "Visibility", 10, "New Sourced Deal Icon");
	}

	public WebElement NewCoinvestmentFundraisingIcon(int timeOut) {
		WebElement ele;
		String xpath = "//*[@title='New Fundraising']";
		return ele = isDisplayed(driver,
				FindElement(driver, xpath, "New Coinvestment Fundraising Icon: " + "NewCoinvestmentFundraisingIcon",
						action.SCROLLANDBOOLEAN, timeOut),
				"Visibility", 10, "New Coinvestment Fundraising Icon");
	}

	public WebElement DateReciviedSortingIcon(int timeOut) {
		WebElement ele;
		String xpath = "//li[@class='sortby_css']//button[@name='progress']";
		return ele = isDisplayed(driver, FindElement(driver, xpath,
				"Date Recivied Sorting Icon: " + "DateReciviedSortingIcon", action.SCROLLANDBOOLEAN, timeOut),
				"Visibility", 10, "Date Recivied Sorting Icon");
	}

	public WebElement sortingorder(String order, int timeOut) {
		WebElement ele;
		String xpath = "//li[@class='sortby_css']//*[@data-value='" + order + "']";
		return ele = isDisplayed(driver, FindElement(driver, xpath,
				"Date Recivied Sorting Icon: " + "DateReciviedSortingIcon", action.SCROLLANDBOOLEAN, timeOut),
				"Visibility", 10, "Date Recivied Sorting Icon");
	}

//	public WebElement dealAcuityDateReceived2(String dealName, int timeOut) {
//
//		String xpath = "//a[text()='" + dealName
//				+ "']/ancestor::tr//td[@data-label='Date Received']//div/*";
//		try {
//			return FindElement(driver, xpath, "Header: " + "dateReceived", action.SCROLLANDBOOLEAN, timeOut);
//		} catch (StaleElementReferenceException e) {
//			return FindElement(driver, xpath, "Header: " + "dateReceived", action.SCROLLANDBOOLEAN, timeOut);
//		}
//
//	}

	public WebElement CoinvestmentTab(int timeOut, action action) {
		WebElement ele;
		String xpath = "//input[@name='radioGroupss']/..//span[text()='Co-Investments']";
		return ele = isDisplayed(driver,
				FindElement(driver, xpath, "Coinvestment Tab: " + "CoinvestmentTab", action.SCROLLANDBOOLEAN, timeOut),
				"Visibility", 10, "Coinvestmen tTab");
	}

	public WebElement ExternalTab(int timeOut, action action) {
		WebElement ele;
		String xpath = "//input[contains(@name,'radioGroups')]/..//span[text()='External']";
		return ele = isDisplayed(driver,
				FindElement(driver, xpath, "External Tab: " + "ExternalTab", action.SCROLLANDBOOLEAN, timeOut),
				"Visibility", 10, "External Tab");
	}
	
	public WebElement InternalTab(int timeOut, action action) {
		WebElement ele;
		String xpath = "//input[@name='radioGroups']/..//span[text()='Internal']";
		return ele = isDisplayed(driver,
				FindElement(driver, xpath, "Internal Tab: " + "InternalTab", action.SCROLLANDBOOLEAN, timeOut),
				"Visibility", 10, "Internal Tab");
	}

	public WebElement SourcedTab(int timeOut, action action) {
		WebElement ele;
		String xpath = "//input[@name='radioGroups']/..//span[text()='Sourced']";
		return ele = isDisplayed(driver,
				FindElement(driver, xpath, "Sourced Tab: " + "SourcedTab", action.SCROLLANDBOOLEAN, timeOut),
				"Visibility", 10, "Sourced Tab");
	}

	public WebElement contactEmailCount(String contactName, int timeOut) {

		String xpath = "//*[text()='" + contactName + "']//ancestor::tr//button[@name='emailRef']";
		try {
			return FindElement(driver, xpath, "Contact Header: " + contactName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Contact Header: " + contactName, action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	public WebElement contactEmailCountAcuity(String contactName, int timeOut) {

		String xpath = "//*[text()='" + contactName + "']//ancestor::tr//button[@name='emailRef']";
		try {
			return FindElement(driver, xpath, "Contact Header: " + contactName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Contact Header: " + contactName, action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	public WebElement contactPopUpEmailsubject(String subject, int timeOut) {

		String xpath = "//a[text()='" + subject + "']";
		try {
			return FindElement(driver, xpath, "Header: " + subject, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Header: " + subject, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	@FindBy(xpath = "//h2[contains(text(),'Emails with')]/../following-sibling::div//lightning-icon[@title='Filter']")
	private WebElement filterIconOnEmailPopup;

	public WebElement getfilterIconOnEmailPopup(int timeOut) {
		return isDisplayed(driver, filterIconOnEmailPopup, "Visibility", timeOut, "filter Icon On Email Popup");
	}

	@FindBy(xpath = "//h2[contains(text(),'Emails with')]/../following-sibling::div//section//h3")
	private WebElement headingOnFilterSectionEmailPopup;

	public WebElement getheadingOnFilterSectionEmailPopup(int timeOut) {
		return isDisplayed(driver, headingOnFilterSectionEmailPopup, "Visibility", timeOut,
				"heading On Filter Section Email Popup");
	}

	@FindBy(xpath = "//h2[contains(text(),'Emails with')]/../following-sibling::div//section//lightning-icon[@title='Close']")
	private WebElement closeIconOnFilterSectiOnEmailPopup;

	public WebElement getcloseIconOnFilterSectiOnEmailPopup(int timeOut) {
		return isDisplayed(driver, closeIconOnFilterSectiOnEmailPopup, "Visibility", timeOut,
				"close Icon On Filter SectiOn Email Popup");
	}

	@FindBy(xpath = "//div[contains(@class,'slds-theme--error')]//span[text()='Error Occured While Loading Component Attempt to de-reference a null object']")
	private WebElement ComponentErrorMsg;

	public WebElement getComponentErrorMsg(int timeOut) {
		return isDisplayed(driver, ComponentErrorMsg, "Visibility", timeOut, "Component Error Msg");
	}

	@FindBy(xpath = "//span[text()='This site can�t be reached']")
	private WebElement pageloadErrorMsg;

	public WebElement getpageloadErrorMsg(int timeOut) {
		return isDisplayed(driver, pageloadErrorMsg, "Visibility", timeOut, "page load Error Msg");
	}

	public WebElement apierrormsg(int timeOut) {

		String xpath = "//span[text()=' An Error occurred in API']";
		try {
			return FindElement(driver, xpath, "api error msg", action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "api error msg", action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement Componenterrormsg(int timeOut) {

		String xpath = "//div[contains(@class,'slds-theme--error')]//span[contains(@class,'toastMessage')]";
		try {
			return FindElement(driver, xpath, "component error msg", action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "component error msg", action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement recordsNameOnTaggedSection(String tagNameOnTaggedSection, int timeOut) {

		String xpath = "//span[text()='" + tagNameOnTaggedSection + "']/ancestor::table//lightning-formatted-url//a";
		try {
			return FindElement(driver, xpath, "Record name: " + tagNameOnTaggedSection, action.SCROLLANDBOOLEAN,
					timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Record name: " + tagNameOnTaggedSection, action.SCROLLANDBOOLEAN,
					timeOut);
		}

	}

	public WebElement getTabName(String tabName, int timeOut) {

		String xpath = "//div[contains(@class,'entityNameTitle') and text()='" + tabName + "']";
		try {
			return FindElement(driver, xpath, "Tab name: " + tabName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Tab name: " + tabName, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement getDetailsOnInteractionPage(String subjectName, int timeOut) {

		String xpath = "//button[text()='" + subjectName + "']/ancestor::tr/td[@data-label='Details']//button";
		try {
			return FindElement(driver, xpath, "Tab name: " + subjectName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Tab name: " + subjectName, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement getHighlightedCompanyName(String companyName, int timeOut) {

		String xpath = "//a[text()='" + companyName + "']//ancestor::th[contains(@class,'refCellHighlightCls')]";
		try {
			return FindElement(driver, xpath, "Tab name: " + companyName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Tab name: " + companyName, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement getHeadingNameOfTabOnTaggedSection(String headingName, int timeOut) {

		String xpath = "//span[@class=\"slds-truncate\" and @title='" + headingName + "']";
		try {
			return FindElement(driver, xpath, "Tab name: " + headingName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Tab name: " + headingName, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	@FindBy(xpath = "//span[@class='slds-th__action']//lightning-icon[@title='Times Referenced']")
	private WebElement timeReferenceIconOnTaggedSection;

	public WebElement getTimeReferenceIconOnTaggedSection(int timeOut) {
		return isDisplayed(driver, timeReferenceIconOnTaggedSection, "Visibility", timeOut,
				"time reference icon on tagged section");
	}

	@FindBy(xpath = "//span[@class='slds-th__action']//span[@title='Summary']")
	private WebElement summaryColumn;

	public WebElement getSummaryColumn(int timeOut) {
		return isDisplayed(driver, summaryColumn, "Visibility", timeOut, "summary column");
	}

	public WebElement getMessageOnTaggedSection(String tabName, String message, int timeOut) {

		String xpath = "//input[@value='" + tabName + "']/ancestor::div[@class=\"slds-p-right_small\"]//div[text()='"
				+ message + "']";
		try {
			return FindElement(driver, xpath, "message on tab : " + tabName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "message on tab: " + tabName, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	@FindBy(xpath = "//span[@title='Interactions']/ancestor::div/following-sibling::div[@class='slds-grid less_cards']/div")
	private WebElement messageOnInteractionSection;

	public WebElement getMessageOnInteractionSection(int timeOut) {
		return isDisplayed(driver, messageOnInteractionSection, "Visibility", timeOut,
				"message on Interaction section");
	}

	public WebElement getConnectionIconOfContact(String contactName, int timeOut) {

		String xpath = "//a[text()='" + contactName + "']/ancestor::tr//button[@title='Connections']";
		try {
			return FindElement(driver, xpath, "Connection icon of : " + contactName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Connection icon of : " + contactName, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement getHeadingOfConnectionPage(String contactName, int timeOut) {

		String xpath = "//span[text()='Connections of " + contactName + "']";
		try {
			return FindElement(driver, xpath, "Connection heading of : " + contactName, action.SCROLLANDBOOLEAN,
					timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Connection heading of : " + contactName, action.SCROLLANDBOOLEAN,
					timeOut);
		}

	}

	public WebElement getMeetingAndCallCount(String name, int timeOut) {

		String xpath = "//*[text()='" + name
				+ "']/ancestor::tr/td[contains(@data-col-key-value,'meetCallRef-button')]//button";
		try {
			return FindElement(driver, xpath, "Meeting and call count", action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Meeting and call count", action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	@FindBy(xpath = "//input[@name=\"Search\"]")
	private WebElement allInteractionSearchBox;

	public WebElement allInteractionSearchBox(int timeOut) {
		return isDisplayed(driver, allInteractionSearchBox, "Visibility", timeOut, "allInteractionSearchBox");
	}

	public WebElement getActivityTimelineSubjectinAllIntearctionPage(String activitSubjectName, int timeOut) {

		String xpath = "//td//span//div//button[text()=\"" + activitSubjectName + "\"]";
		try {
			return FindElement(driver, xpath, "Activity Timeline Subject: " + activitSubjectName,
					action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Activity Timeline Subject: " + activitSubjectName,
					action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	public WebElement getSubjectNameOnInteractionPage(String subjectName, int timeOut) {

		String xpath = "//span[contains(text(),'All Interactions With')]/ancestor::div//td[@data-label='Subject']//button[text()='"
				+ subjectName + "']";
		try {
			return FindElement(driver, xpath, "subject name on Interaction page", action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "subject name on Interaction page", action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	public WebElement getEditButtonOnPopup(String subjectName, int timeOut) {

		String xpath = "//h2[text()='" + subjectName + "']/ancestor::slot//button[@title='Edit']";
		try {
			return FindElement(driver, xpath, "edit button Interaction page", action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "edit button on Interaction page", action.SCROLLANDBOOLEAN, timeOut);
		}
	}

	@FindBy(xpath = "//h2[contains(@class,'slds-text-heading_medium')]/ancestor::div[@class='slds-modal__container']//button[@title='Cancel']")
	private WebElement cancelButtonPopup;

	public WebElement getCancelButtonPopup(int timeOut) {
		return isDisplayed(driver, cancelButtonPopup, "Visibility", timeOut, "cancel button on popup");
	}

	public WebElement getDetailsOnInteractionCard(String subjectName, int timeOut) {

		String xpath = "//a[text()='" + subjectName
				+ "']/ancestor::lightning-card//div[contains(@class,'slds-text-title')]";
		try {
			return FindElement(driver, xpath, "Tab name: " + subjectName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Tab name: " + subjectName, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement valueOfLabelInSubjectLinkPopUpInInteractionSection(String labelName, int timeOut) {

		String xpath = "//section//div[@class=\"slds-carousel\"]/lightning-layout//label[text()=\"" + labelName
				+ "\"]/following-sibling::*";
		try {
			return FindElement(driver, xpath, "Label name: " + labelName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Label name: " + labelName, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public WebElement valueOfClassificationInSubjectLinkPopUpInInteractionSection(int timeOut) {

		String xpath = "//section//div[@class=\"slds-carousel\"]/lightning-layout//h2/span[2]";
		try {
			return FindElement(driver, xpath, "Classification", action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Classification", action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public List<String> valueOfTagsInSubjectLinkPopUpInInteractionSection(String labelName) {

		String xpath = "//section//div[@class=\"slds-carousel\"]/lightning-layout//label[text()=\"" + labelName
				+ "\"]/following-sibling::*//lightning-pill//span/span/following-sibling::span";
		return FindElements(driver, xpath).stream().map(x -> x.getText()).collect(Collectors.toList());

	}

	public List<String> iconOfTagsInSubjectLinkPopUpInInteractionSection(String labelName) {

		String xpath = "//section//div[@class=\"slds-carousel\"]/lightning-layout//label[text()=\"" + labelName
				+ "\"]/following-sibling::*//lightning-pill/span/span//lightning-primitive-icon/*";
		return FindElements(driver, xpath).stream().map(x -> CommonLib.getAttribute(driver, x, "Icon", "data-key"))
				.collect(Collectors.toList());

	}

	public WebElement iconOfTagsInSubjectLinkPopUpInInteractionSection(String labelName, String relatedAssociationName,
			String recordType, int timeOut) {

		if (recordType.equalsIgnoreCase("Firm") || recordType.equalsIgnoreCase("Account")) {

			String xpath = "//section//div[@class=\"slds-carousel\"]/lightning-layout//label[text()=\"" + labelName
					+ "\"]/following-sibling::*//lightning-pill/span/span/following-sibling::span[text()=\""
					+ relatedAssociationName + "\"]/..//lightning-primitive-icon/*[@data-key=\"account\"]";
			try {
				return FindElement(driver, xpath, recordType + " & its Icon: " + relatedAssociationName,
						action.SCROLLANDBOOLEAN, timeOut);
			} catch (StaleElementReferenceException e) {
				return FindElement(driver, xpath, recordType + " & its Icon: " + relatedAssociationName,
						action.SCROLLANDBOOLEAN, timeOut);
			}
		} else if (recordType.equalsIgnoreCase("Deal")) {

			String xpath = "//section//div[@class=\"slds-carousel\"]/lightning-layout//label[text()=\"" + labelName
					+ "\"]/following-sibling::*//lightning-pill/span/span/following-sibling::span[text()=\""
					+ relatedAssociationName + "\"]/..//lightning-primitive-icon/*[@data-key=\"custom47\"]";
			try {
				return FindElement(driver, xpath, recordType + " & its Icon: " + relatedAssociationName,
						action.SCROLLANDBOOLEAN, timeOut);
			} catch (StaleElementReferenceException e) {
				return FindElement(driver, xpath, recordType + " & its Icon: " + relatedAssociationName,
						action.SCROLLANDBOOLEAN, timeOut);
			}
		} else if (recordType.equalsIgnoreCase("Contact")) {

			String xpath = "//section//div[@class=\"slds-carousel\"]/lightning-layout//label[text()=\"" + labelName
					+ "\"]/following-sibling::*//lightning-pill/span/span/following-sibling::span[text()=\""
					+ relatedAssociationName + "\"]/..//lightning-primitive-icon/*[@data-key=\"contact\"]";
			try {
				return FindElement(driver, xpath, recordType + " & its Icon: " + relatedAssociationName,
						action.SCROLLANDBOOLEAN, timeOut);
			} catch (StaleElementReferenceException e) {
				return FindElement(driver, xpath, recordType + " & its Icon: " + relatedAssociationName,
						action.SCROLLANDBOOLEAN, timeOut);
			}

		} else if (recordType.equalsIgnoreCase("Fund")) {

			String xpath = "//section//div[@class=\"slds-carousel\"]/lightning-layout//label[text()=\"" + labelName
					+ "\"]/following-sibling::*//lightning-pill/span/span/following-sibling::span[text()=\""
					+ relatedAssociationName + "\"]/..//lightning-primitive-icon/*[@data-key=\"custom34\"]";
			try {
				return FindElement(driver, xpath, recordType + " & its Icon: " + relatedAssociationName,
						action.SCROLLANDBOOLEAN, timeOut);
			} catch (StaleElementReferenceException e) {
				return FindElement(driver, xpath, recordType + " & its Icon: " + relatedAssociationName,
						action.SCROLLANDBOOLEAN, timeOut);
			}

		} else if (recordType.equalsIgnoreCase("Fundraising")) {

			String xpath = "//section//div[@class=\"slds-carousel\"]/lightning-layout//label[text()=\"" + labelName
					+ "\"]/following-sibling::*//lightning-pill/span/span/following-sibling::span[text()=\""
					+ relatedAssociationName + "\"]/..//lightning-primitive-icon/*[@data-key=\"custom3\"]";
			try {
				return FindElement(driver, xpath, recordType + " & its Icon: " + relatedAssociationName,
						action.SCROLLANDBOOLEAN, timeOut);
			} catch (StaleElementReferenceException e) {
				return FindElement(driver, xpath, recordType + " & its Icon: " + relatedAssociationName,
						action.SCROLLANDBOOLEAN, timeOut);
			}

		} else if (recordType.equalsIgnoreCase("User")) {

			String xpath = "//section//div[@class=\"slds-carousel\"]/lightning-layout//label[text()=\"" + labelName
					+ "\"]/following-sibling::*//lightning-pill/span/span/following-sibling::span[text()=\""
					+ relatedAssociationName + "\"]/..//lightning-primitive-icon/*[@data-key=\"user\"]";
			try {
				return FindElement(driver, xpath, recordType + " & its Icon: " + relatedAssociationName,
						action.SCROLLANDBOOLEAN, timeOut);
			} catch (StaleElementReferenceException e) {
				return FindElement(driver, xpath, recordType + " & its Icon: " + relatedAssociationName,
						action.SCROLLANDBOOLEAN, timeOut);
			}

		}

		else if (recordType.equalsIgnoreCase("CustomObject")) {

			String xpath = "//section//div[@class=\"slds-carousel\"]/lightning-layout//label[text()=\"" + labelName
					+ "\"]/following-sibling::*//lightning-pill/span/span/following-sibling::span[text()=\""
					+ relatedAssociationName + "\"]/..//lightning-primitive-icon/*[@data-key=\"custom20\"]";
			try {
				return FindElement(driver, xpath, recordType + " & its Icon: " + relatedAssociationName,
						action.SCROLLANDBOOLEAN, timeOut);
			} catch (StaleElementReferenceException e) {
				return FindElement(driver, xpath, recordType + " & its Icon: " + relatedAssociationName,
						action.SCROLLANDBOOLEAN, timeOut);
			}

		}

		else {

			log(LogStatus.ERROR, "Please Provide the correct Icon Name, Provided by you: " + recordType, YesNo.No);
			sa.assertTrue(false, "Please Provide the correct Icon Name, Provided by you: " + recordType);
			return null;
		}

	}

	public WebElement iconOfSubjectLinkPopUpInInteractionSection(int timeOut) {

		String xpath = "//section//h2[contains(@class,\"slds-text-heading_small slds-hyphenate\")]/ancestor:: lightning-layout-item/preceding-sibling::lightning-layout-item//lightning-primitive-icon/*";
		WebElement iconLocator = FindElement(driver, xpath, "Icon", action.SCROLLANDBOOLEAN, timeOut);

		return iconLocator;

	}

	public WebElement attachmentIconOfSubjectLinkPopUpInInteractionSection(int timeOut) {

		String xpath = "//section//lightning-layout-item[contains(@class,\"slds-carousel__panel\")]//lightning-icon//lightning-primitive-icon/*[@data-key=\"attach\"]";
		WebElement attachmentIconLocator = FindElement(driver, xpath, "Icon", action.SCROLLANDBOOLEAN, timeOut);

		return attachmentIconLocator;

	}

	public WebElement editButtonOfSubjectLinkPopUpInInteractionSection(int timeOut) {

		String xpath = "//section//lightning-layout-item[contains(@class,'slds-carousel__panel')]//lightning-button";
		String xpath2 = "//button[text()='Edjidst']";
		WebElement editButton = isDisplayed(driver, FindElement(driver, xpath, "editButton", action.BOOLEAN, timeOut),
				"visibility", timeOut, "editButton", action.BOOLEAN);
		// section//lightning-layout-item[contains(@class,'slds-carousel__panel')]//lightning-button
		return editButton;

	}

	public WebElement typeOfSubjectLinkPopUpInInteractionSection(int timeOut) {

		String xpath = "//section//lightning-layout-item[contains(@class,\"slds-carousel__panel\")]//h2/span[1]";
		WebElement type = FindElement(driver, xpath, "type", action.SCROLLANDBOOLEAN, timeOut);

		return type;

	}

	public WebElement crossButtonOfSubjectLinkPopUpInInteractionSection(int timeOut) {

		String xpath = "//section//button[@title='Close']";
		WebElement crossButton = FindElement(driver, xpath, "Close", action.SCROLLANDBOOLEAN, timeOut);

		return crossButton;

	}

	public WebElement popUpSaveButton(int timeOut) {

		String xpath = "//button[@name=\"SaveEdit\"]";
		WebElement type = FindElement(driver, xpath, "popUpSaveButton", action.SCROLLANDBOOLEAN, timeOut);

		return type;

	}

	public WebElement pickListSaveButton(int timeOut) {

		String xpath = "//td[@id=\"bottomButtonRow\"]/input[@name=\"save\"]";
		WebElement type = FindElement(driver, xpath, "pickListSaveButton", action.SCROLLANDBOOLEAN, timeOut);

		return type;

	}

	public List<String> getAllValuesOfSubjectInTaskPopUp() {
		return FindElements(driver, "//section//div/ul[contains(@class,\"slds-listbox\")]/li[@data-id]",
				"getAllValuesOfSubjectInTaskPopUp").stream().map(x -> x.getText()).collect(Collectors.toList());
	}

	@FindBy(xpath = "//header//h2/following-sibling::lightning-icon")
	private WebElement notePopupExpandCollapseButton;

	public WebElement notePopupExpandCollapseButton(int timeOut) {
		return isDisplayed(driver, notePopupExpandCollapseButton, "Visibility", timeOut,
				"notePopupExpandCollapseButton");
	}

	@FindBy(xpath = "//input[@class=\"slds-input\" and @type=\"search\" and @placeholder=\"Search\"]")
	private WebElement searchRelatedRecord;

	public WebElement getSearchRelatedRecord(int timeOut) {
		return isDisplayed(driver, searchRelatedRecord, "Visibility", timeOut, "search related record");
	}

	@FindBy(xpath = "//ul[@class='slds-button-group-list']//button[text()='Create Task']")
	private WebElement createTaskButton;

	public WebElement getCreateTaskButton(int timeOut) {
		return isDisplayed(driver, createTaskButton, "Visibility", timeOut, "create task button");
	}

	@FindBy(xpath = "//lightning-icon[@title='Log a Call']//lightning-primitive-icon")
	private WebElement createLogaCallButton;

	public WebElement getCreateLogaCallButton(int timeOut) {
		return isDisplayed(driver, createLogaCallButton, "Visibility", timeOut, "Log a Call button");
	}

	@FindBy(xpath = "//lightning-icon[@title='Add Contact']")
	private WebElement addContactIcon;

	public WebElement getAddContactIcon(int timeOut) {
		return isDisplayed(driver, addContactIcon, "Visibility", timeOut, "Add contact icon");
	}

	@FindBy(xpath = "//label[@class='slds-radio_button__label']//span[text()='External']")
	private WebElement externalTabOnConnectionSection;

	public WebElement getExternalTabOnConnectionSection(int timeOut) {
		return isDisplayed(driver, externalTabOnConnectionSection, "Visibility", timeOut,
				"External tab on connection section");
	}

	@FindBy(xpath = "//label[@class='slds-radio_button__label']//span[text()='Internal']")
	private WebElement internalTabOnConnectionSection;

	public WebElement getInternalTabOnConnectionSection(int timeOut) {
		return isDisplayed(driver, internalTabOnConnectionSection, "Visibility", timeOut,
				"Internal tab on connection section");
	}

	@FindBy(xpath = "//input[@class='slds-input' and @type='search']")
	private WebElement searchBoxOnTheme;

	public WebElement getSearchBoxOnTheme(int timeOut) {
		return isDisplayed(driver, searchBoxOnTheme, "Visibility", timeOut, "Search box on theme");
	}

	public WebElement getThemeName(String themeName, int timeOut) {

		String xpath = "//th[@data-label='Theme Name']//a[text()='" + themeName + "']";
		WebElement type = FindElement(driver, xpath, "Theme name", action.SCROLLANDBOOLEAN, timeOut);

		return type;

	}

	public WebElement getThemeNameOnDetailsPage(String themeName, int timeOut) {

		String xpath = "//lightning-formatted-text[text()='PE Theme 1']";
		WebElement type = FindElement(driver, xpath, "Theme name", action.SCROLLANDBOOLEAN, timeOut);

		return type;

	}

	@FindBy(xpath = "//div[contains(@id,\"toastDescription\")]//span[contains(@class,\"toastMessage\")]")
	private WebElement errorMsgInTopOfNotePopup;

	public WebElement errorMsgInTopOfNotePopup(int timeOut) {
		return isDisplayed(driver, errorMsgInTopOfNotePopup, "Visibility", timeOut, "errorMsgInTopOfNotePopup");
	}

	@FindBy(xpath = "//h2[text()=\"Review the errors on this page.\"]/ancestor::div/p")
	private WebElement errorMsgInFieldLevelOfNotePopup;

	public WebElement errorMsgInFieldLevelOfNotePopup(int timeOut) {
		return isDisplayed(driver, errorMsgInFieldLevelOfNotePopup, "Visibility", timeOut,
				"errorMsgInFieldLevelOfNotePopup");
	}

	@FindBy(xpath = "//span[text()='Log a Call' or text()='new_direct_message']/ancestor::lightning-icon")
	private WebElement logACallIconButtonInInteraction;

	public WebElement logACallIconButtonInInteraction(int timeOut) {
		return isDisplayed(driver, logACallIconButtonInInteraction, "Visibility", timeOut,
				"logACallIconButtonInInteraction");
	}

	/**
	 * @return the searchPopSearchTextBoxCrossIcon
	 */
	@FindBy(xpath = "//button[@title='Close this window']")
	private WebElement NewFinancingPopupCrossIcon;

	public WebElement getNewFinancingPopupCrossIcon(int timeOut) {
		return isDisplayed(driver, NewFinancingPopupCrossIcon, "Visibility", timeOut, "New Financing Popup Cross Icon");
	}

	@FindBy(xpath = "//footer//span[text()='Cancel']")
	private WebElement NewFinancingPopupCancelIcon;

	/**
	 * @return the searchPopSearchTextBoxCrossIcon
	 */
	public WebElement getNewFinancingPopupCancelIcon(int timeOut) {
		return isDisplayed(driver, NewFinancingPopupCancelIcon, "Visibility", timeOut,
				"New Financing Popup Cancel Icon");
	}

	public List<WebElement> createRecordPopUpNameInputBoxes() {

		String xpath = "//h1[text()=\"Create Records\"]/../following-sibling::div//lightning-layout-item//input[@type=\"text\"]";
		List<WebElement> listOfNameElements = FindElements(driver, xpath, "createRecordPopUpNameInputBox");
		if (listOfNameElements.size() == 0) {
			return listOfNameElements = FindElements(driver, xpath, "createRecordPopUpNameInputBox");
		} else
			return listOfNameElements;
	}

	public List<WebElement> getsortingDateRecived(int timeOut) {

		String xpath = "//*[@class='for_desk dealDataTable tabcont shadowremovedatatable']//td[@data-label='Date Received']//lightning-formatted-date-time";
		List<WebElement> listOfNameElements = FindElements(driver, xpath, "sorting Date Recived");
		if (listOfNameElements.size() == 0) {
			return listOfNameElements = FindElements(driver, xpath, "sorting Date Recived");
		} else
			return listOfNameElements;
	}

	public List<WebElement> getsortingStage(int timeOut) {

		String xpath = "//*[@class='for_desk dealDataTable tabcont shadowremovedatatable']//td[@data-label='Stage']";
		List<WebElement> listOfNameElements = FindElements(driver, xpath, "sorting Stage");
		if (listOfNameElements.size() == 0) {
			return listOfNameElements = FindElements(driver, xpath, "sorting Stage");
		} else
			return listOfNameElements;
	}

	public List<WebElement> getsortingStage1(int timeOut) {

		String xpath = "//*[@class='for_desk dealDataTable tabcont shadowremovedatatable']//lightning-primitive-cell-factory[@data-label='Stage']//lightning-base-formatted-text";
		List<WebElement> listOfNameElements = FindElements(driver, xpath, "sorting Stage1");
		if (listOfNameElements.size() == 0) {
			return listOfNameElements = FindElements(driver, xpath, "sorting Stage1");
		} else
			return listOfNameElements;
	}

	public List<WebElement> getsortintTCD(int timeOut) {

		String xpath = "//*[@class='for_desk dealDataTable tabcont shadowremovedatatable']//lightning-primitive-cell-factory[@data-label='Stage']//lightning-base-formatted-text";
		List<WebElement> listOfNameElements = FindElements(driver, xpath, "sorting target close date");
		if (listOfNameElements.size() == 0) {
			return listOfNameElements = FindElements(driver, xpath, "sorting target close date");
		} else
			return listOfNameElements;
	}

	@FindBy(xpath = "//h1[text()=\"Create Records\"]/../following-sibling::div//lightning-layout-item//input[@type=\"text\"]/parent::div/following::div[contains(@id,\"help-message\")]")
	private WebElement errorMsgInCreateRecordPopUp;

	public WebElement errorMsgInCreateRecordPopUp(int timeOut) {
		return isDisplayed(driver, errorMsgInCreateRecordPopUp, "Visibility", timeOut, "errorMsgInCreateRecordPopUp");
	}

	public List<WebElement> createRecordPopUpCheckBoxes() {

		String xpath = "//h1[text()=\"Create Records\"]/../following-sibling::div//lightning-layout-item//input[@name=\"input1\"]";
		List<WebElement> listOfNameElements = FindElements(driver, xpath, "createRecordPopUpNameInputBox");
		if (listOfNameElements.size() == 0) {
			return listOfNameElements = FindElements(driver, xpath, "createRecordPopUpNameInputBox");
		} else
			return listOfNameElements;
	}

	public List<WebElement> createRecordPopUpAccountRadioButtons() {

		String xpath = "//h1[text()=\"Create Records\"]/../following-sibling::div//lightning-layout-item//input[@value=\"Account\"]";
		List<WebElement> listOfNameElements = FindElements(driver, xpath, "createRecordPopUpNameInputBox");
		if (listOfNameElements.size() == 0) {
			return listOfNameElements = FindElements(driver, xpath, "createRecordPopUpNameInputBox");
		} else
			return listOfNameElements;
	}

	public List<WebElement> createRecordPopUpContactRadioButtons() {

		String xpath = "//h1[text()=\"Create Records\"]/../following-sibling::div//lightning-layout-item//input[@value=\"Contact\"]";
		List<WebElement> listOfNameElements = FindElements(driver, xpath, "createRecordPopUpNameInputBox");
		if (listOfNameElements.size() == 0) {
			return listOfNameElements = FindElements(driver, xpath, "createRecordPopUpNameInputBox");
		} else
			return listOfNameElements;
	}

	public WebElement createRecordPopUpAccountComboBoxes(Integer index, int timeOut) {
		String xpath = "(//h1[text()=\"Create Records\"]/../following-sibling::div//lightning-layout-item//input[@type=\"text\"])["
				+ index
				+ "]/ancestor::lightning-layout-item/following-sibling::lightning-layout-item//button[contains(@class,\"slds-combobox__input\")]";
		return FindElement(driver, xpath, "createRecordPopUpAccountComboBoxes", action.SCROLLANDBOOLEAN, timeOut);

	}

	public WebElement createRecordPopUpAccountRecordType(String recordType, int timeOut) {
		String path = "//h1[text()=\"Create Records\"]/../following-sibling::div//lightning-layout-item//span[text()=\""
				+ recordType + "\"]/ancestor::lightning-base-combobox-item";
		return FindElement(driver, path, recordType, action.SCROLLANDBOOLEAN, timeOut);

	}

	public WebElement createRecordPopUpContactAccountDropDownValue(String accountName, int timeOut) {
		String path = "//h1[text()=\"Create Records\"]/../following-sibling::div//lightning-layout-item//li[@role=\"listitem\" and text()=\""
				+ accountName + "\"]";
		return FindElement(driver, path, accountName, action.SCROLLANDBOOLEAN, timeOut);

	}

	public List<WebElement> createRecordPopUpContactInputSuggestionBoxes() {

		String xpath = "//h1[text()=\"Create Records\"]/../following-sibling::div//lightning-layout-item[5 and contains(@class,\"lookup_css_h\")]";
		List<WebElement> listOfNameElements = FindElements(driver, xpath, "createRecordPopUpNameInputBox");
		if (listOfNameElements.size() == 0) {
			return listOfNameElements = FindElements(driver, xpath, "createRecordPopUpNameInputBox");
		} else
			return listOfNameElements;
	}

	public WebElement createRecordPopUpFooterButtonName(String footerButtonName, int timeOut) {
		String path = "//h1[text()=\"Create Records\"]/../following-sibling::div/button[text()=\"" + footerButtonName
				+ "\"]";
		return FindElement(driver, path, footerButtonName, action.SCROLLANDBOOLEAN, timeOut);

	}

	public List<String> addContactsToDealTeamPopUpContactNames() {

		String xpath = "//h1[text()=\"Add Contacts to Deal Team\"]/../following-sibling::div//lightning-layout[contains(@class,\"slds-p-around_x-small\")]//lightning-layout-item[2]";
		List<String> listOfNameElements = FindElements(driver, xpath, "createRecordPopUpNameInputBox").stream()
				.map(x -> x.getText()).collect(Collectors.toList());
		if (listOfNameElements.size() == 0) {
			return listOfNameElements = FindElements(driver, xpath, "addContactsToDealTeamPopUpContactNames").stream()
					.map(x -> x.getText()).collect(Collectors.toList());
		} else
			return listOfNameElements;
	}

	public List<WebElement> addContactsToDealTeamPopUpCheckBoxes() {

		String xpath = "//h1[text()=\"Add Contacts to Deal Team\"]/../following-sibling::div//lightning-layout[contains(@class,\"slds-p-around_x-small\")]//lightning-layout-item[1]//input";
		List<WebElement> listOfNameElements = FindElements(driver, xpath, "addContactsToDealTeamPopUpCheckBoxes");
		if (listOfNameElements.size() == 0) {
			return listOfNameElements = FindElements(driver, xpath, "addContactsToDealTeamPopUpCheckBoxes");
		} else
			return listOfNameElements;
	}

	@FindBy(xpath = "//h1[text()=\"Add Contacts to Deal Team\"]/../following-sibling::div//lightning-layout//lightning-input[@data-id=\"dealGlobalCheckId\"]//input")
	private WebElement addContactsToDealTeamPopUpAllRecordCheckBox;

	public WebElement addContactsToDealTeamPopUpAllRecordCheckBox(int timeOut) {
		return isDisplayed(driver, addContactsToDealTeamPopUpAllRecordCheckBox, "Visibility", timeOut,
				"addContactsToDealTeamPopUpAllRecordCheckBox");
	}

	public List<WebElement> addContactsToDealTeamPopUpRoleDropDown() {

		String xpath = "//h1[text()=\"Add Contacts to Deal Team\"]/../following-sibling::div//lightning-layout[contains(@class,\"slds-p-around_x-small\")]//lightning-layout-item[4]//button";
		List<WebElement> listOfNameElements = FindElements(driver, xpath, "addContactsToDealTeamPopUpRoleDropDown");
		if (listOfNameElements.size() == 0) {
			return listOfNameElements = FindElements(driver, xpath, "addContactsToDealTeamPopUpRoleDropDown");
		} else
			return listOfNameElements;
	}

	public List<WebElement> addContactsToDealTeamPopUpRoleDropDownValues() {

		String xpath = "//h1[text()=\"Add Contacts to Deal Team\"]/../following-sibling::div//lightning-layout[contains(@class,\"slds-p-around_x-small\")]//lightning-base-combobox-item";
		List<WebElement> listOfNameElements = FindElements(driver, xpath,
				"addContactsToDealTeamPopUpRoleDropDownValues");
		if (listOfNameElements.size() == 0) {
			return listOfNameElements = FindElements(driver, xpath, "addContactsToDealTeamPopUpRoleDropDownValues");
		} else
			return listOfNameElements;
	}

	public WebElement addContactsToDealTeamPopUpFooterButtonName(String footerButtonName, int timeOut) {
		String path = "//h1[text()=\"Add Contacts to Deal Team\"]/../following-sibling::div/button[text()=\""
				+ footerButtonName + "\"]";
		return FindElement(driver, path, footerButtonName, action.SCROLLANDBOOLEAN, timeOut);

	}

	public List<String> addToFundraisingContactsTeamPopUpContactNames() {

		String xpath = "//h1[text()=\"Add to Fundraising Contacts\"]/../following-sibling::div//lightning-layout[contains(@class,\"slds-p-around_x-small\")]//lightning-layout-item[2]";
		List<String> listOfNameElements = FindElements(driver, xpath, "createRecordPopUpNameInputBox").stream()
				.map(x -> x.getText()).collect(Collectors.toList());
		if (listOfNameElements.size() == 0) {
			return listOfNameElements = FindElements(driver, xpath, "addContactsToDealTeamPopUpContactNames").stream()
					.map(x -> x.getText()).collect(Collectors.toList());
		} else
			return listOfNameElements;
	}

	public List<WebElement> addToFundraisingContactsPopUpCheckBoxes() {

		String xpath = "//h1[text()=\"Add to Fundraising Contacts\"]/../following-sibling::div//lightning-layout[contains(@class,\"slds-p-around_x-small\")]//lightning-layout-item[1]//input";
		List<WebElement> listOfNameElements = FindElements(driver, xpath, "addToFundraisingContactsPopUpCheckBoxes");
		if (listOfNameElements.size() == 0) {
			return listOfNameElements = FindElements(driver, xpath, "addContactsToDealTeamPopUpCheckBoxes");
		} else
			return listOfNameElements;
	}

	@FindBy(xpath = "//h1[text()=\"Add to Fundraising Contacts\"]/../following-sibling::div//lightning-layout[1]//input")
	private WebElement addToFundraisingContactsPopUpAllRecordCheckBox;

	public WebElement addToFundraisingContactsPopUpAllRecordCheckBox(int timeOut) {
		return isDisplayed(driver, addToFundraisingContactsPopUpAllRecordCheckBox, "Visibility", timeOut,
				"addToFundraisingContactsPopUpAllRecordCheckBox");
	}

	public List<WebElement> addToFundraisingContactsPopUpRoleDropDown() {

		String xpath = "//h1[text()=\"Add to Fundraising Contacts\"]/../following-sibling::div//lightning-layout[contains(@class,\"slds-p-around_x-small\")]//lightning-layout-item[4]//button";
		List<WebElement> listOfNameElements = FindElements(driver, xpath, "addContactsToDealTeamPopUpRoleDropDown");
		if (listOfNameElements.size() == 0) {
			return listOfNameElements = FindElements(driver, xpath, "addContactsToDealTeamPopUpRoleDropDown");
		} else
			return listOfNameElements;
	}

	public List<WebElement> addToFundraisingContactsPopUpRoleDropDownValues() {

		String xpath = "//h1[text()=\"Add to Fundraising Contacts\"]/../following-sibling::div//lightning-layout[contains(@class,\"slds-p-around_x-small\")]//lightning-base-combobox-item";
		List<WebElement> listOfNameElements = FindElements(driver, xpath,
				"addContactsToDealTeamPopUpRoleDropDownValues");
		if (listOfNameElements.size() == 0) {
			return listOfNameElements = FindElements(driver, xpath, "addContactsToDealTeamPopUpRoleDropDownValues");
		} else
			return listOfNameElements;
	}

	public WebElement addToFundraisingContactsPopUpFooterButtonName(String footerButtonName, int timeOut) {
		String path = "//h1[text()=\"Add to Fundraising Contacts\"]/../following-sibling::div/button[text()=\""
				+ footerButtonName + "\"]";
		return FindElement(driver, path, footerButtonName, action.SCROLLANDBOOLEAN, timeOut);

	}

	public WebElement getParticipantOnMeetingAndCallPopup(String subjectName, int timeOut) {
		String xPath = "//button[text()='" + subjectName
				+ "']/ancestor::td[@data-label='Subject']/../td[@data-label='Participants']//button";
		return FindElement(driver, xPath, subjectName, action.SCROLLANDBOOLEAN, timeOut);

	}

	public WebElement getTagOnMeetingAndCallPopup(String subjectName, int timeOut) {
		String xPath = "//button[text()='" + subjectName
				+ "']/ancestor::td[@data-label='Subject']/../td[@data-label='Tags']//button";
		return FindElement(driver, xPath, subjectName, action.SCROLLANDBOOLEAN, timeOut);

	}

	@FindBy(xpath = "//header//h2[text()='Participants ']")
	private WebElement headingOfParticipantsPopup;

	public WebElement getHeadingOfParticipantsPopup(int timeOut) {
		return isDisplayed(driver, headingOfParticipantsPopup, "Visibility", timeOut, "heading of participant popup");
	}

	@FindBy(xpath = "//header//h2[text()='Tags ']")
	private WebElement headingOfTagPopup;

	public WebElement getHeadingOfTagPopup(int timeOut) {
		return isDisplayed(driver, headingOfTagPopup, "Visibility", timeOut, "heading of tag popup");
	}

	@FindBy(xpath = "//header//h2[text()='Participants ']/..//lightning-icon[@title='Close']")
	private WebElement closeIconOfParticipantPopup;

	public WebElement getCloseIconOfParticipantPopup(int timeOut) {
		return isDisplayed(driver, closeIconOfParticipantPopup, "Visibility", timeOut,
				"close icon of participant popup");
	}

	@FindBy(xpath = "//header//h2[text()='Tags ']/..//lightning-icon[@title='Close']")
	private WebElement closeIconOfTagPopup;

	public WebElement getCloseIconOfTagPopup(int timeOut) {
		return isDisplayed(driver, closeIconOfTagPopup, "Visibility", timeOut, "close icon of tag popup");
	}

	@FindBy(xpath = "//header//h2[text()='Participants ']/../..//button[@title='OK']")
	private WebElement okButtonOnParticipantPopup;

	public WebElement getOkButtonOnParticipantPopup(int timeOut) {
		return isDisplayed(driver, okButtonOnParticipantPopup, "Visibility", timeOut, "Ok button of participant popup");
	}

	@FindBy(xpath = "//header//h2[text()='Tags ']/../..//button[@title='OK']")
	private WebElement tagButtonOnParticipantPopup;

	public WebElement getOkButtonOnTagsPopup(int timeOut) {
		return isDisplayed(driver, tagButtonOnParticipantPopup, "Visibility", timeOut,
				"Tag button of participant popup");
	}

	public List<WebElement> getRecordsOfParticipantTagPopup() {

		String xpath = "//header//h2[text()='Participants ']/../following-sibling::div//*[@class='no_underline tagsScreen']";
		List<WebElement> listOfNameElements = FindElements(driver, xpath, "Records on participant tag");
		if (listOfNameElements.size() == 0) {
			return listOfNameElements = FindElements(driver, xpath, "Records on participant tag");
		} else
			return listOfNameElements;
	}

	public List<WebElement> getRecordsOfTagPopup() {

		String xpath = "//header//h2[text()='Tags ']/../following-sibling::div//a";
		List<WebElement> listOfNameElements = FindElements(driver, xpath, "Records on Tag");
		if (listOfNameElements.size() == 0) {
			return listOfNameElements = FindElements(driver, xpath, "Records on tag");
		} else
			return listOfNameElements;
	}

	public WebElement createRecordPopUpContactInputSuggestionBoxes(Integer index, int timeOut) {
		index = index + 1;
		String path = "(//h1[text()=\"Create Records\"]/../following-sibling::div//lightning-layout-item//input[@type=\"text\"])["
				+ index
				+ "]/ancestor::lightning-layout-item/following-sibling::lightning-layout-item//*[@placeholder=\"Search Accounts\" or contains(@class,\"slds-combobox__input\")]";
		return FindElement(driver, path, "createRecordPopUpContactInputSuggestionBoxes", action.SCROLLANDBOOLEAN,
				timeOut);

	}

	public WebElement createRecordsPopupSuccessMsg(int timeOut) {
		return isDisplayed(driver, createRecordsPopupSuccessMsg, "Visibility", timeOut, "createRecordsPopupSuccessMsg");
	}

	@FindBy(xpath = "//div[contains(@id,\"toast\")]/span[text()=\"Record was created.\"]")
	private WebElement createRecordsPopupSuccessMsg;

	public WebElement infoIconOfSectionName(String sectionName, int timeOut) {

		String path = "//span[text()='" + sectionName + "']/../..//lightning-helptext//button/lightning-primitive-icon";
		return FindElement(driver, path, "info icon of section", action.BOOLEAN, timeOut);
	}

	// Deal Team Added Successfully
	public WebElement addContactsToDealTeamPopupSuccessMsg(int timeOut) {
		return isDisplayed(driver, addContactsToDealTeamPopupSuccessMsg, "Visibility", timeOut,
				"createRecordsPopupSuccessMsg");
	}

	@FindBy(xpath = "//div[contains(@id,\"toast\")]/span")
	private WebElement addContactsToDealTeamPopupSuccessMsg;

	public WebElement infoPopupMessageOfSection(int timeOut) {

		String path = "//lightning-primitive-bubble[@role='tooltip']//div[@class='slds-popover__body']";
		return FindElement(driver, path, "info popup message", action.BOOLEAN, timeOut);
	}

	// lightning-primitive-bubble[@role='tooltip']//div[@class='slds-popover__body']

	public WebElement createRecordsPopupHeader(int timeOut) {
		return isDisplayed(driver, createRecordsPopupHeader, "Visibility", timeOut, "createRecordsPopupHeader");
	}

	@FindBy(xpath = "//h1[text()=\"Create Records\"]")
	private WebElement createRecordsPopupHeader;

	public WebElement addContactsToDealTeamPopUpHeader(int timeOut) {
		return isDisplayed(driver, addContactsToDealTeamPopUpHeader, "Visibility", timeOut,
				"addContactsToDealTeamPopUpHeader");
	}

	@FindBy(xpath = "//h1[text()=\"Add Contacts to Deal Team\"]")
	private WebElement addContactsToDealTeamPopUpHeader;

	public WebElement addToFundraisingContactsPopUpHeader(int timeOut) {
		return isDisplayed(driver, addToFundraisingContactsPopUpHeader, "Visibility", timeOut,
				"addToFundraisingContactsPopUpHeader");
	}
	
	@FindBy(xpath = "//input[@id='thePage:theForm:theBlock:manyWhoPref']")
	private WebElement allowUserToRelateMulipleTaskCheckbox;

	public WebElement getAllowUserToRelateMulipleTaskCheckbox(int timeOut) {
		return isDisplayed(driver, allowUserToRelateMulipleTaskCheckbox, "Visibility", timeOut,
				"allowUserToRelateMulipleTaskCheckbox");
	}

	@FindBy(xpath = "//input[@id='thePage:theForm:theBlock:buttons:submit']")
	private WebElement activitySettingSubmitButton;

	public WebElement getActivitySettingSubmitButton(int timeOut) {
		return isDisplayed(driver, activitySettingSubmitButton, "Visibility", timeOut,
				"activitySettingSubmitButton");
	}

	@FindBy(xpath = "//h1[text()=\"Add to Fundraising Contacts\"]")
	private WebElement addToFundraisingContactsPopUpHeader;

	public WebElement valueOfLabelInDetailSectionUnderSuggestedTag(String labelName, int timeOut) {

		String xpath = "//section//div[contains(@id,\"lgt-accordion-section\")]//label[text()=\"" + labelName
				+ "\"]/following-sibling::*";
		try {
			return FindElement(driver, xpath, "Label name: " + labelName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Label name: " + labelName, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public List<String> valueOfTagsInDetailSectionUnderSuggestedTag(String labelName) {

		String xpath = "//section//div[contains(@id,\"lgt-accordion-section\")]//label[text()=\"" + labelName
				+ "\"]/following-sibling::*//lightning-pill//span/span/following-sibling::span";
		return FindElements(driver, xpath).stream().map(x -> x.getText()).collect(Collectors.toList());

	}

	public WebElement detailsButtonUnderSuggestedTag(int timeOut) {
		return isDisplayed(driver, detailsButtonUnderSuggestedTag, "Visibility", timeOut,
				"detailsButtonUnderSuggestedTag");
	}

	@FindBy(xpath = "//span[text()=\"Details\"]/ancestor::button")
	private WebElement detailsButtonUnderSuggestedTag;

	public WebElement taskSubjectOfInteractionCard(String subjectName, int timeOut) {

		String xPath = "//a[@class=\"interaction_sub subject_text\" and text()='" + subjectName + "']";
		return FindElement(driver, xPath, "info popup message", action.BOOLEAN, timeOut);
	}

	public WebElement recordNameInNotesSuggestionBox(String recordName, int timeOut) {

		String xpath = "//span[contains(@class,\"slds-listbox__option-text_entity\")][text()=\"" + recordName
				+ "\"]/ancestor::div[contains(@class,\"slds-listbox__option_has-meta\")]";
		try {
			return FindElement(driver, xpath, "Label name: " + recordName, action.SCROLLANDBOOLEAN, timeOut);
		} catch (StaleElementReferenceException e) {
			return FindElement(driver, xpath, "Label name: " + recordName, action.SCROLLANDBOOLEAN, timeOut);
		}

	}

	public List<String> recordNameListInNotesSuggestionBox() {

		String xpath = "//div[@class=\"hover\"]//span[contains(@class,\"slds-listbox__option-text_entity\")]/ancestor::div[contains(@class,\"slds-listbox__option_has-meta\")]/span[2]";
		return FindElements(driver, xpath).stream().map(x -> x.getText()).collect(Collectors.toList());

	}

	public WebElement headingOfInteractionPage(String recordName, int timeOut) {

		String path = "//span[@class=\"slds-page-header__title slds-truncate\" and text()=\"All Interactions With "
				+ recordName + "\"]";
		return FindElement(driver, path, "info popup message", action.BOOLEAN, timeOut);
	}

	public WebElement getRecordofInteractionPage(String recordName, int timeOut) {

		String path = "//header//h2[text()='Participants ']/../following-sibling::div//a[text()='" + recordName + "']";
		return FindElement(driver, path, "record " + recordName + " on participant popup", action.BOOLEAN, timeOut);
	}

	public WebElement getRecordofTagPopup(String recordName, int timeOut) {

		String path = "//header//h2[text()='Tags ']/../following-sibling::div//a[text()='" + recordName + "']";
		return FindElement(driver, path, "record " + recordName + " on participant popup", action.BOOLEAN, timeOut);
	}

	public WebElement getObjectPageName(String objectName, int timeOut) {

		String path = "//div[contains(@class,'entityNameTitle') and text()='" + objectName + "']";
		return FindElement(driver, path, "Object: " + objectName + "", action.BOOLEAN, timeOut);
	}

	public WebElement getRecordNameOnPage(String recordName, int timeOut) {

		String path = "//div[contains(@class,'highlights')]//*[text()='" + recordName + "']";
		return FindElement(driver, path, "record name: " + recordName + "", action.BOOLEAN, timeOut);
	}

	public WebElement getTagRecordNameOnActivityPopup(String recordName, int timeOut) {

		String path = "//label[text()=\"Tags\"]/..//span[@class=\"slds-pill__label\" and text()='" + recordName + "']";
		return FindElement(driver, path, "record name: " + recordName + "", action.BOOLEAN, timeOut);
	}

	public WebElement getParticipantColumn(String subjectName, int timeOut) {

		String path = "//button[@name=\"subject\" and text()='" + subjectName
				+ "']/ancestor::tr//td[@data-label='Participants']//button";
		return FindElement(driver, path, "record name: " + subjectName, action.BOOLEAN, timeOut);
	}

	public WebElement getTagsColumn(String subjectName, int timeOut) {

		String path = "//button[@name=\"subject\" and text()='" + subjectName
				+ "']/ancestor::tr//td[@data-label='Tags']//button";
		return FindElement(driver, path, "record name: " + subjectName, action.BOOLEAN, timeOut);
	}
	

	public List<WebElement> listOfemailCategory(int timeout) {
		return FindElements(driver,
				"//table//th[@data-label='Category']//button");
	}
	public WebElement getEmailDetail(String subject,int timeOut) {

		String path = "//*[text()='"+ subject + "']/ancestor::tr";
		return FindElement(driver, path, "subject name: "+subject, action.BOOLEAN, timeOut);
	}
	
	public WebElement getContactNameFromContactSection(String contactName, int timeOut) {

		String path = "//span[text()='Contacts']/ancestor::div//td[@data-label='Name']//a[text()='" + contactName
				+ "']";
		return FindElement(driver, path, "contact name: " + contactName, action.BOOLEAN, timeOut);
	}

	public WebElement getEditButtonOnEventDetailsPage(int timeOut) {

		String path = "//div[text()='Event']/ancestor::div//div[text()='Edit']";
		return FindElement(driver, path, "Edit button", action.BOOLEAN, timeOut);
	}


	public WebElement plusIconButtonInThemeOfAccount(String accountName, int timeOut) {

		String path = "//span[contains(text(), \"" + accountName
				+ "\")]/ancestor::div[contains(@class,\"slds-size_1-of-1\")]/div//lightning-icon[@data-id=\"Account\"][1]";
		return FindElement(driver, path, "plusIconButtonInThemeOfAccount", action.BOOLEAN, timeOut);
	}

	public WebElement addToThemePopUpSearchBox(int timeOut) {
		return isDisplayed(driver, addToThemePopUpSearchBox, "Visibility", timeOut, "addToThemePopUpSearchBox");
	}

	@FindBy(xpath = "//input[@placeholder=\"Search...\"]")
	private WebElement addToThemePopUpSearchBox;

	public WebElement addToThemePopUpSearchBoxDropDownValue(String accountName, int timeOut) {

		String path = "//span[text()=\"" + accountName + "\"]/parent::span/parent::div";
		return FindElement(driver, path, "addToThemePopUpSearchBoxDropDownValue", action.BOOLEAN, timeOut);
	}

	public WebElement addToThemePopUpSaveButton(int timeOut) {
		return isDisplayed(driver, addToThemePopUpSaveButton, "Visibility", timeOut, "addToThemePopUpSaveButton");
	}

	@FindBy(xpath = "//footer//button[text()=\"Save\"]")
	private WebElement addToThemePopUpSaveButton;

	public WebElement addToThemeLogNoteButton(String accountName, int timeOut) {

		String path = "//a[text()=\"" + accountName + "\"]/ancestor::tr//td//button[@title=\"Log Note\"]";
		return FindElement(driver, path, "addToThemeLogNoteButton", action.BOOLEAN, timeOut);
	}
	
	

	public WebElement getMeetingAndCallCountOfDealteam(String dealName, int timeOut) {

		String path = "//a[text()='"+dealName+"']/ancestor::td[@data-label='Name']/../td[@data-label='Meetings and Calls']//button";
		return FindElement(driver, path, "Meeting and call count", action.BOOLEAN, timeOut);
	}
	
	

	public WebElement getCOnnectionIconOfDealteam(String dealName, int timeOut) {

		String path = "//a[text()='"+dealName+"']/ancestor::td[@data-label='Name']/../th//button";
		return FindElement(driver, path, "Meeting and call count", action.BOOLEAN, timeOut);
	}
	
	public WebElement getMeetingAndCallCountOnConnectionIconOfDealteam(String userName, int timeOut) {

		String path = "//lightning-base-formatted-text[text()='"+userName+"']/ancestor::th[@data-label='Name']/../td[@data-label='Meetings and Calls']//button";
		return FindElement(driver, path, "Meeting and call count", action.BOOLEAN, timeOut);
	}
	
	public WebElement getConnectionIconOfFundraisingContactRecord(String contactName, int timeOut) {

		String path = "//a[text()="+contactName+"]/ancestor::td[@data-label='Name']/../td//button[@title='Connections']";
		return FindElement(driver, path, "Meeting and call count", action.BOOLEAN, timeOut);
	}
	

	
}
