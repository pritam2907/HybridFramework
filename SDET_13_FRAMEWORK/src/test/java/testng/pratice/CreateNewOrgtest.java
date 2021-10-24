package testng.pratice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CreateNewOrgtest {
	@BeforeSuite
	public void configBS() {
		System.out.println("================ ======connect to DB & confgiure extend report===========================");
	}
	
	@BeforeClass
	public void configBC() {
		System.out.println("===========launch the browser==========");    
		
	}
	
	@BeforeMethod
	public void configBM() {
		System.out.println("==login to app==="); 
	}

	@Test
	public void creatOrgtest(){  
		System.out.println("navigate to Orgnization page");
		System.out.println("create new HDFC Org");              
		System.out.println("verify the org");             	
	}
	
	@Test
	public void searchOrgTest(){
		System.out.println("execute query insert SBM Org in to database");
		System.out.println("search SBM org ");
		System.out.println("verify the orgname & industried");
	}
	
	@Test
	public void editOrgTest(){
		System.out.println("execute query insert Org YESBANK in to database");
		System.out.println("edit YESBANK - Airtel Org");
		System.out.println("verify the orgname & industried");
	}
	
	@Test
	public void deleteOrgTest(){
		System.out.println("execute query insert SBI Org in to database");
		System.out.println("delete SBI Org");
		System.out.println("verify the orgname & industried");

	}

	@AfterMethod
	public void configAM() {
		System.out.println("==logout to app==="); 
	}

	@AfterClass
	public void configAC() {
                    
		System.out.println("===============closse the browser============");    
	}
	
	@AfterSuite
	public void configAS() {
		System.out.println("======================dissconnect to DB= & get result backUP==========================");
	}

}
