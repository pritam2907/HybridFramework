package com.crm.vtiger.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility{
	WebDriver driver;
	public CreateOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement organizationNameTF;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getOrganizationNameTF() {
		return organizationNameTF;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	/**
	 * Use this method to create organization by entering mandatory field
	 * @param organizationName
	 */
	public OragnizationInformationPage createOrganization(String organizationName) {
		organizationNameTF.sendKeys(organizationName);
		saveBtn.click();
		return new OragnizationInformationPage(driver);
	}
	
	/**
	 * Create organziation with industry dropdown
	 * @param organizationName
	 * @param industryType
	 */
	public OragnizationInformationPage createOrganization(String organizationName,String industryType) {
		organizationNameTF.sendKeys(organizationName);
		SelectOption(industryDropDown, industryType);
		saveBtn.click();
		return new OragnizationInformationPage(driver);
	}

}
