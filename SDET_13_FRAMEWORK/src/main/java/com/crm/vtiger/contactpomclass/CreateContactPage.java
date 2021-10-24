package com.crm.vtiger.contactpomclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;
import com.crm.vtiger.pomclass.OrganizationPage;
/**
 * 
 * @author Nitheesha
 *
 */
public class CreateContactPage extends WebDriverUtility{
	WebDriver driver;
	public CreateContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "lastname")
	private WebElement lastNameTF;

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@alt='Select']")
	private WebElement organizationSaluation;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getLastNameTF() {
		return lastNameTF;
	}

	public WebElement getOrganizationSaluation() {
		return organizationSaluation;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	/**
	 * create contact with mandatory fields
	 * @param lastName
	 */
	public void createContact(String lastName) {
		lastNameTF.sendKeys(lastName);
		saveBtn.click();
	}
	/**
	 * create conatct using organization name
	 * @param lastName
	 * @param organizationName
	 * @param childWindowText
	 * @param parentWindowText
	 */
	public void createContactWithOrganization(String lastName,String organizationName,String childWindowText,String parentWindowText) {
		lastNameTF.sendKeys(lastName);	
		organizationSaluation.click();
		switchToWindow(driver, childWindowText);
		OrganizationPage orgPage = new OrganizationPage(driver);
		orgPage.getSearchTF().sendKeys(organizationName);
		orgPage.getSearchBtn().click();
		driver.findElement(By.linkText(organizationName)).click();
		switchToWindow(driver, parentWindowText);
		saveBtn.click();
	}

}
