package pages;

import org.openqa.selenium.WebDriver;

    public class HomePage extends BasePage {

        public HomePage(WebDriver driver) {
            super(driver);
        }

        public static final String HOME_URL = "https://tms47.lightning.force.com/lightning/page/home";

        public HomePage openHomePage(String URL) {
            driver.get(HOME_URL);
            return this;
        }
    }

