package frame.qa.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import frame.qa.crm.base.TestBase;
import frame.qa.crm.pages.ContactsPage;
import frame.qa.crm.pages.HomePage;
import frame.qa.crm.pages.LoginPage;
import frame.qa.crm.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;

	public HomePageTest() {
		super();
	}
	
//	test cases should be separated -- independent with each other
//	before each test case - launch the browser and login
//	after each test case - close the browser

	@BeforeMethod
	public void setup() {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginpage = new LoginPage();
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "not a match");
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyUserName());

	}

	@Test(priority = 3)
	public void verifyContactsLinkTest() {
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
