package Cloud.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class GoogleCloudPage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com";
    private static final String SEARCH_REQUEST = "Google Cloud Platform Pricing Calculator";

    @FindBy(xpath = "//input[@name='q']")
    private WebElement search;

    @FindBy(xpath = "//form[@class='devsite-search-form']//*[@id='devsite-suggest-header-product']/..//*[@id='suggestion-product-0']")
    private WebElement requiredProductLink;

    public GoogleCloudPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPage openPage(){
        driver.get(HOMEPAGE_URL);
        waitElementToBeClickable(search);
        logger.info("Open page " + HOMEPAGE_URL);
        return this;
    }
    public GoogleCloudPage makeSearchRequest(){

        search.click();
        search.sendKeys(SEARCH_REQUEST);
        return this;
    }

    public CalculatorPage openCalculatorPage(){
        logger.info("Open page " + SEARCH_REQUEST);
        return new CalculatorPage(driver);
    }
}
