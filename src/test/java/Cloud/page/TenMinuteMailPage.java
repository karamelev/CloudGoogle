package Cloud.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TenMinuteMailPage extends AbstractPage {

    private static final String TEN_MIN_EMAIL_URL = "https://10minutemail.com/";

    @FindBy(id="mail_address")
    private WebElement mailAddress;

    @FindBy(xpath = "//*[@id='mail_messages_content']//span[text()='Google Cloud Platform Price Estimate']")
    private WebElement openEmail;

    @FindBy(xpath = "//*[@id='mobilepadding']//h3[contains(text(), 'USD')]")
    private WebElement price;

    public TenMinuteMailPage(WebDriver driver) {
        super(driver);
    }

    public String getTenMinMail(){
        driver.get(TEN_MIN_EMAIL_URL);
        logger.info("Open 10 min mail page ");
        waitForPresenceOfElement(mailAddress);
        String newEmail;
        do{
            newEmail = mailAddress.getAttribute("value");
        }
        while (!(newEmail.contains("@")));
        logger.info("Got email: " + newEmail );
        return newEmail;
    }

    public String getPrice(){
        new WebDriverWait(driver, Duration.ofMinutes(1)).until(ExpectedConditions.elementToBeClickable(openEmail));
        openEmail.click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", price);
        String priceInEmail = waitForPresenceOfElement(price).getText();
        logger.info("Got price from email " + priceInEmail);
        return priceInEmail;
    }
}