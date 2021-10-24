package com.comcast.crm.organizationtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.pomclass.CreateOrganizationPage;
import com.crm.vtiger.pomclass.HomePage;
import com.crm.vtiger.pomclass.OragnizationInformationPage;
import com.crm.vtiger.pomclass.OrganizationPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
/**
 * 
 * @author Deepak
 *
 */
public class CreateOrganizationTest extends BaseClass{

	@Epic("VT_01 Organization module")
	@Story("Create a organization with mandatory fileds")
	@Severity(SeverityLevel.CRITICAL)
	@Description("create a organization with madatory fields and verify the organization name")
	
	@Test(groups = "smokeTest")
	public void createOrganizationTest() throws Throwable
	{
		/* read test Data*/
		
		String orgName=eUtil.getExcelData("org", 1, 2)+"_"+JavaUtility.getRandomData();

		/*step 2 : navigate to Org page */
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();
		
		/*step 3 : navigate to Create New Org Page */
		OrganizationPage oPage  = new OrganizationPage(driver);
		oPage.getCreateOrganizationIMG().click();
		
		/*step 4 : navigate to Create New Org Page */
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createOrganization(orgName);
		
		/*step 5 : verify the OrgName */
		OragnizationInformationPage oip = new OragnizationInformationPage(driver);
		String actOrgSuccessFullMsg = oip.getOrganizationInfo().getText();
		 String actOrgNAme = oip.getOrgNameEDtInfo().getText();
		 
		 boolean status = actOrgSuccessFullMsg.contains(orgName);
		 Assert.assertTrue(status);
		 Assert.assertEquals(actOrgNAme, orgName);

	}
	
	@Epic("VT_01 Organization module for industry drop down")
	@Story("create a oragnization with industry dropdown")
	@Severity(SeverityLevel.MINOR)
	@Description("create a oragnization with industry dropdown and verify industry")
	
	
	@Test(groups = "regressionTest")
	public void createOrgWithIndustryTest() throws Throwable
	{
		String orgName=eUtil.getExcelData("org", 4, 2)+"_"+JavaUtility.getRandomData();
		String industryType=eUtil.getExcelData("org", 4, 3);
		
		/*step 2 : navigate to Org page */
		OrganizationPage opage = homePAge.clickOnOrganizationLink();
		
		/*step 3 : navigate to Create New Org Page */
		CreateOrganizationPage cop = opage.clickOnCreateOrganizationIMG();
		 
		/*step 4 : navigate to Create New Org Page */
		  OragnizationInformationPage ongino = cop.createOrganization(orgName, industryType);
		  
		  /*step 5 : verify the OrgName */
		   Assert.assertEquals(orgName, ongino.getOrgNameEDtInfo().getText());

	}


}
