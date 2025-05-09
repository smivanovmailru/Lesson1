package lesson6;

import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ClickCounter {

    public static WebDriver driver;
    private static WebDriverWait wait;


    public static By counter = By.id("counter");
    public static By plusBtn = By.id("plus-btn");
    public static By minusBtn = By.id("minus-btn");
    public static By reset = By.id("reset");

    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
          }

    public static void openPage(){
        driver.get("https://www.clickspeedtester.com/click-counter/");
    }

    public static void textResetChecking() {
        String expectedText = "Reset";
        //работа с iFrame
        WebElement frame1 = driver.findElement(By.xpath("//*[@id=\"post-2902\"]/div[3]/iframe"));
        driver.switchTo().frame(frame1);
        //driver.findElement(reset); хотел таким образом, но тогда ошибка в reset.getText, т.к. reset это объект типа By, а не WebElement.
        WebElement reset = driver.findElement(By.id("reset"));
        String actualText = reset.getText();
        Assert.assertEquals(expectedText, actualText, "Text is not \"reset\"");
    }

    public static void valueCounter00Checking() {
        String expectedValue = "00";
        WebElement count = driver.findElement(By.id("counter"));
        String  actualValue = count.getText();
        Assert.assertEquals(expectedValue, actualValue, "not equals");
    }

    public static void addingValue(){
        Actions actions = new Actions(driver);
        WebElement plusBtn = driver.findElement(By.id("plus-btn"));
        for (int i = 0; i < 5; i++) {
            actions.click(plusBtn).build().perform();
            }
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public static void valueCounter5Checking(){
        String expectedValue = "5";
        WebElement count = driver.findElement(By.id("counter"));
        String actualValue = count.getText();
        Assert.assertEquals(expectedValue, actualValue, "not equals");
    }

    public static void reductionValue(){
        Actions actions = new Actions(driver);
        WebElement minusBtn = driver.findElement(By.id("minus-btn"));
        for (int i = 0; i < 2; i++){
            actions.click(minusBtn).build().perform();
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public static void valueCounter3Checking(){
        String expectedValue = "3";
        WebElement count = driver.findElement(By.id("counter"));
        String actualValue = count.getText();
        Assert.assertEquals(expectedValue, actualValue,"not equals");
        }

    public static void resettingCounter(){
        Actions actions = new Actions(driver);
        WebElement reset = driver.findElement(By.id("reset"));
        actions.click(reset).build().perform();
    }


}
