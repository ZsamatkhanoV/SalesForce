package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDownField {

    WebDriver driver;
    String label;

    public DropDownField(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    private static final String DROP_XPATH = "//*[contains(text(),'%s')]/ancestor::*[contains(@class,'uiInputSelect')]//a";
    private static final String SELECT_XPATH = "//*[@class='select-options']/descendant::a[contains(text(),'%s')]";

    public void selectOption(String option) {
        System.out.println(String.format("Select option: %s from dropdown: %s", option, label));
        driver.findElement(By.xpath(String.format(DROP_XPATH, label))).click();
        driver.findElement(By.xpath(String.format(SELECT_XPATH, option))).click();
    }
}
