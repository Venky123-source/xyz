package frame.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import frame.qa.crm.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'User: Demo User')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement ContactsLink;

	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyUserName() {
		return userNameLabel.isDisplayed();

	}

	public ContactsPage clickOnContactsLink() {
		ContactsLink.click();
		return new ContactsPage();

	}

	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();

	}

	public TasksPage clickOnTaskLink() {
		tasksLink.click();
		return new TasksPage();

	}
	
	public void clickOnNewContactsLink() {
		Actions action = new Actions(driver);
		action.moveToElement(newContactsLink).build().perform();
		newContactsLink.click();
	}

}
