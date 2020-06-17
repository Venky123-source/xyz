package frame.qa.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import frame.qa.crm.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLable;
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(name="client_lookup")
	WebElement companyname;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLable() {
		return contactsLable.isDisplayed();
	}

	public void selectContacts(String name) {
		driver.findElement(By.xpath("//a[text()='" + name + "']//parent::td"
				+ "[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//"
				+ "input[@name='contact_id']")).click();

	}
	
	public void createNewConatct(String title, String ftName, String ltName, String comp) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		
		firstname.sendKeys(ftName);
		lastname.sendKeys(ltName);
		companyname.sendKeys(comp);
		saveBtn.click();
		
		
	}
	
	

}
