package com.comcast.crm.conatcttest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.contactpomclass.ContactInformationPage;
import com.crm.vtiger.contactpomclass.ContactPage;
import com.crm.vtiger.contactpomclass.CreateContactPage;
import com.crm.vtiger.pomclass.CreateOrganizationPage;
import com.crm.vtiger.pomclass.HomePage;
import com.crm.vtiger.pomclass.OragnizationInformationPage;
import com.crm.vtiger.pomclass.OrganizationPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Listeners(com.crm.vtiger.GenericUtils.ListenerIMP.class)
public class CreateContact extends BaseClass{

	@Epic("VT_02 Conatact module") 
	@Story("Create a contact with mandatory filed")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Create a contact with madatory field and verify")
	
	@Test(groups = "smokeTest")  
	public void createContact() throws Throwable
	{
		
		String lastName=eUtil.getExcelData("contact", 1, 2)+"_"+JavaUtility.getRandomData();
		//Navigate to contacts
		homePAge =new HomePage(driver);
		homePAge.clickOnContactLink();
		
		//Create Contact with organization
		ContactPage contactPage=new ContactPage(driver);
		contactPage.clickOnCreateContactIMG();
		// navigate to create contact page
		CreateContactPage createContactPage=new CreateContactPage(driver);
		createContactPage.createContact(lastName);
		//verify
		ContactInformationPage contactInfoPage=new ContactInformationPage(driver);
		String actualContactText=contactInfoPage.getContactText();
		Assert.assertTrue(actualContactText.contains(lastName));
		
	}

	
	@Epic("VT_02 Conatact module for oranization")
	@Story("Create a contact with Organization")
	@Severity(SeverityLevel.MINOR)
	@Description("Create a contact with organization and verify the contact and organization")
	
	@Test(groups = "regressionTest")
	public void createContactWithOrg() throws Throwable
	{
		String orgName=eUtil.getExcelData("org", 1, 2)+"_"+JavaUtility.getRandomData();

		//Navigate to organizations
		homePAge=new HomePage(driver);
		homePAge.clickOnOrganizationLink();

		//create organization
		OrganizationPage orgPage=new OrganizationPage(driver);
		orgPage.clickOnCreateOrganizationIMG();

		//create organization
		CreateOrganizationPage createOrgPage=new CreateOrganizationPage(driver);
		createOrgPage.createOrganization(orgName);


		//verification
		OragnizationInformationPage orgInfoPage=new OragnizationInformationPage(driver);
		String actualOrgName=orgInfoPage.getOrganizationText();
		Assert.assertTrue(actualOrgName.contains(orgName));
		
		String lastName=eUtil.getExcelData("contact", 4, 2)+"_"+JavaUtility.getRandomData();
		
		
		//Navigate to contacts
		homePAge =new HomePage(driver);
		homePAge.clickOnContactLink();
		
		//Create Contact with organization
		ContactPage contactPage=new ContactPage(driver);
		contactPage.clickOnCreateContactIMG();
		
		//create contact with organizationName
		CreateContactPage createContactPage=new CreateContactPage(driver);
		createContactPage.createContactWithOrganization(lastName, 
				orgName, "Accounts", "Contacts");
		//verification
		ContactInformationPage contactInfoPage=new ContactInformationPage(driver);
		String actualContactText=contactInfoPage.getContactText();
		Assert.assertTrue(actualContactText.contains(lastName));
		String actualOrgNameInContact=contactInfoPage.getOrganizationText();
		Assert.assertEquals(actualOrgNameInContact, orgName);
		
	}

}
