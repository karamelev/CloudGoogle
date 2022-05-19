package Cloud.test;

import Cloud.driver.DriverSingleton;
import Cloud.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;

    @BeforeMethod()
    public void setUp()
    {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {
        DriverSingleton.closeDriver();
    }

    @Listeners({TestListener.class})
    public static class CommonCondition {
        private WebDriver driver;

        @BeforeMethod()
        public void setUp()
        {
            driver = DriverSingleton.getDriver();
        }

        @AfterMethod(alwaysRun = true)
        public void stopBrowser()
        {
            DriverSingleton.closeDriver();
        }

    }
}
