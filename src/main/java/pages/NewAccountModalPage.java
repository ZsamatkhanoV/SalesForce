package pages;

import elements.DropDownField;
import objects.Account;
import elements.InputField;
import elements.TextField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewAccountModalPage extends BasePage {

    public NewAccountModalPage(WebDriver driver) {
        super(driver);
    }

    public static final String SAVE_BUTTON_XPATH = "//*[contains(@class,'forceActionButton')]//*[text()='Save']";
    public static final String URL = "https://tms47.lightning.force.com/lightning/o/Account/new";

    public NewAccountModalPage openNewModalPage() {
        openUrl(URL);
        return this;
    }

    public void create(Account account) {
        new InputField(driver, "Account Name").writeInputText(account.getAccountName());
        new InputField(driver, "Website").writeInputText(account.getWebSite());
        new TextField(driver, "Description").writeText(account.getDescription());
        new TextField(driver, "Billing Street").writeText(account.getBillingAddress());
        new DropDownField(driver, "Industry").selectOption(account.getIndustryType());
        clickSave();
    }

        public NewAccountModalPage clickSave() {
            driver.findElement(By.xpath(SAVE_BUTTON_XPATH)).click();
            return this;
        }
}

