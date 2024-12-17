package lesson4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class AlertsDemo {
    @Test
    public void openWebsite(){
        // Инициализация WebDriverManager
        WebDriverManager.chromedriver().setup();

        //создание экземпляра драйвера
        WebDriver driver = new ChromeDriver();

        //открытие веб-страницы
        driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");

        //попап 1
        WebElement popup1 = driver.findElement(By.id("alertBox"));
        Actions actions = new Actions(driver);
        actions.click(popup1).build().perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Переключение на alert
        Alert alert = driver.switchTo().alert();

        // Получение текста алерта
        String alertText = alert.getText();
        System.out.println("Текст алерта: " + alertText);

        // Принять алерт
        alert.accept();

        //попап 2
        WebElement popup2 = driver.findElement(By.id("confirmBox"));
        actions.click(popup2).build().perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Переключение на alert
        Alert alert1 = driver.switchTo().alert();

        // Получить текст алерта
        String alertText1 = alert.getText();
        System.out.println("Текст алерта: " + alertText1);

        // Принять алерт
        alert.accept();

        //попап 3
        WebElement popup3 = driver.findElement(By.id("promptBox"));
        actions.click(popup3).build().perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Переключение на alert
        Alert alert2 = driver.switchTo().alert();
        alert2.sendKeys("Final step of this task");

        // Принять (OK) алерт
        alert.accept();

            // Получить текст алерта
        WebElement popupBoxOutput = driver.findElement(By.xpath("//*[@id=\"output\"]"));
        String text = popupBoxOutput.getText();
        System.out.println("Текст алерта: " + text);

        driver.quit();
    }

}
