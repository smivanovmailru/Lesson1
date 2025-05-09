package lesson4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class W3School {
    @Test

    public void openningWebSiteW3() throws InterruptedException {
        // Инициализация WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Создание экземпляра WebDriver
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);

        // Открытие веб-страницы
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
        //driver.manage().window().maximize();
        //работа с iframe
        WebElement frame1 = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(frame1);
       //ввод first name
        WebElement firstNameField = driver.findElement(By.xpath("//*[@id=\"fname\"]"));
        firstNameField.clear();
        firstNameField.sendKeys("Siarhei");
        //ввод last name
        WebElement lastNameField = driver.findElement(By.xpath("//*[@id=\"lname\"]"));
        lastNameField.clear();
        lastNameField.sendKeys("Ivanou");
        //нажатие на Submit
        WebElement submit = driver.findElement(By.xpath("/html/body/form/input[3]"));
        actions.click(submit).build().perform();
           //find element /html/body/div[2]/p/text()[1]
        //WebElement note = driver.findElement(By.className("w3-panel"));
        ////strong[text() = 'Note:']
        Thread.sleep(3000);
        WebElement note = driver.findElement(By.xpath("(//p)[2]"));
        String text = note.getText();
        System.out.println("Текст нотификашки W3: " + text);
        

    }
}
