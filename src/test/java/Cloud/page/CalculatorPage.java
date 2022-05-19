package Cloud.page;

import Cloud.model.ComputeEngine;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='cloud-site']//iframe")
    private WebElement frameMain;

    @FindBy(xpath = "//iframe[@id='myFrame']")
    private WebElement frameCalculator;
    
    @FindBy(xpath="//md-tab-item/div[@title='Compute Engine']")
    private WebElement computeEngine;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']")
    private WebElement computeEngineForm;

    @FindBy(name = "quantity")
    private WebElement numberOfInstances;

    @FindBy(id = "select_76")
    private WebElement selectOperatingSystem;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement checkBoxAddGPUs;

    @FindBy(xpath = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement addToEstimate;

    @FindBy(xpath="//*[@id='compute']//b[contains(text(), 'Cost')]")
    private WebElement resultPrice;

    @FindBy(id="email_quote")
    private WebElement emailEstimate;

    @FindBy(id="input_477")
    private WebElement email;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmail;

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage chooseElementFromDropDownBox(String nameOfDropDownBox, String nameOfRequiredElement){
        WebElement dropDownBox  = getDropDownBoxElement(nameOfDropDownBox);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",dropDownBox);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",
                waitForPresenceOfElement(getElementFromMenuContainer(dropDownBox, nameOfRequiredElement)));
        return this;
    }

    public WebElement getDropDownBoxElement(String nameOfDropDownBox){
        WebElement requiredElement = computeEngineForm.findElement(By.xpath("//*[@placeholder = '" + nameOfDropDownBox + "']"));
        return requiredElement;
    }

    public WebElement getElementFromMenuContainer(WebElement webElement, String nameOfElementInDropDownList) {
        String idOfSelectMenuContainer = webElement.getAttribute("aria-owns");
        WebElement requiredElementFromDropDown = driver.findElement(By.xpath
                ("//*[@id='" + idOfSelectMenuContainer + "']//md-option/div[contains(text(),'" + nameOfElementInDropDownList + "')]"));
        return requiredElementFromDropDown;
    }

    public String getResult(String typeOfRequiredElement){
        String result = driver.findElement(By.xpath("//*[@id='compute']//*[contains(text(), '" + typeOfRequiredElement + "')]")).getText();
        return result;
    }

    public CalculatorPage goToFrame(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameMain));
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameCalculator));
        return this;
    }

    public CalculatorPage activateComputeEngineSection(){
        goToFrame();
        waitForPresenceOfElement(computeEngine).click();
        waitForPresenceOfElement(computeEngineForm);
        return this;
    }

    public CalculatorPage fillInTheForm(ComputeEngine computeEngine){
        setNumberOfInstances(computeEngine);
        setOperatingSystem(computeEngine);
        chooseElementFromDropDownBox("VM Class", computeEngine.getVmClass());
        chooseElementFromDropDownBox("Series", computeEngine.getSeriesOfInstanceType());
        chooseElementFromDropDownBox("Instance type", computeEngine.getInstanceType());
        addGPUs();
        chooseElementFromDropDownBox("Number of GPUs", computeEngine.getNumberOfGPUs());
        chooseElementFromDropDownBox("GPU type", computeEngine.getGpuType());
        chooseElementFromDropDownBox("Local SSD", computeEngine.getSsd());
        chooseElementFromDropDownBox("Datacenter location", computeEngine.getDatacenterLocation());
        chooseElementFromDropDownBox("Committed usage", computeEngine.getCommittedUsage());
        addToEstimate();
        logger.info("Filled calculator form");
        return this;
    }

    private CalculatorPage setNumberOfInstances(ComputeEngine computeEngine){
        waitForPresenceOfElement(numberOfInstances).sendKeys(computeEngine.getNumberOfInstances());
        return this;
    }

    private CalculatorPage setOperatingSystem(ComputeEngine computeEngine){
        waitForPresenceOfElement(selectOperatingSystem).click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",
                getElementFromMenuContainer(selectOperatingSystem, computeEngine.getOperatingSystem()));
        return this;
    }

    private CalculatorPage addGPUs(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",(waitForPresenceOfElement(checkBoxAddGPUs)));
        return this;
    }

    private CalculatorPage addToEstimate(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",waitForPresenceOfElement(addToEstimate));
        return this;
    }

    public void sendEmail(String tenMinEmail){
        goToFrame();
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",emailEstimate);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",waitForPresenceOfElement(email));
        waitForPresenceOfElement(email).sendKeys(tenMinEmail);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",sendEmail);
        logger.info("Sent email");
    }

    public String getPrice(){
        String price = resultPrice.getText();
        logger.info("Got price from calculator page " + price);
        return price;
    }
}