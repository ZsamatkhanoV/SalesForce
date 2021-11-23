package tests;

import objects.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {

        public static final String LOGIN = "zstest123-pp5x@force.com";
        public static final String PASSWORD = "Gq2KPsXekAb*ySd%";
        WebElement accountName = driver.findElement (By.xpath("//*[@class='custom-truncate uiOutputText']"));
        WebElement billingAddress = driver.findElement (By.xpath("//*[contains(text(),'Billing Address')]"));

        @Test
        public void createAccountTest() {
            Account realAccount = new Account("TMS Account", "www.TMS-QA.by", "SMTH");
            loginPage.openLoginPage()
                    .login(LOGIN,PASSWORD);
            newAccountModalPage.openNewModalPage()
                    .create(realAccount);
            softAssert.assertEquals(accountName.getText(), "TMS", "Error");
            softAssert.assertEquals(billingAddress.getAttribute("getInnerText"), "Test Address", "Error");
        }
    }
