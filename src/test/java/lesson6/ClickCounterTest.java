package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClickCounterTest {

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
    }

    @Test

    public void waitingElements (){
        ClickCounter.openPage();
        ClickCounter.textResetChecking();
        ClickCounter.valueCounter00Checking();
        ClickCounter.addingValue();
        ClickCounter.valueCounter5Checking();
        ClickCounter.reductionValue();
        ClickCounter.valueCounter3Checking();
        ClickCounter.resettingCounter();
    }

        @AfterMethod

    public void closing(){
            driver.quit();
        }

}
