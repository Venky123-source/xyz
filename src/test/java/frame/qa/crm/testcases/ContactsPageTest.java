package frame.qa.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import frame.qa.crm.base.TestBase;
import frame.qa.crm.pages.ContactsPage;
import frame.qa.crm.pages.HomePage;
import frame.qa.crm.pages.LoginPage;
import frame.qa.crm.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName= "Contacts";
	

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginpage = new LoginPage();
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();

	}

	@Test(priority = 1)
	public void verifyContactsPageLable() {
		Assert.assertTrue(contactsPage.verifyContactsLable(), "not a match");

	}

	@Test(priority = 2)
	public void selectContactsTest() {
		contactsPage.selectContacts("Aakash Patel");

	}

	@Test(priority = 3)
	public void selectMultipleContactsTest() {
		contactsPage.selectContacts("Aakash Patel");
		contactsPage.selectContacts("Ajay Kumar");
	}

	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
		
		}
	
	@Test(priority = 4, dataProvider="getTestData")
	public void validateCreateNewContact(String title , String firstname, String lastname, String company) {
		homePage.clickOnNewContactsLink();
//		contactsPage.createNewConatct("Mr.", "venky", "peter", "Google");
		contactsPage.createNewConatct(title, firstname, lastname, company);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
