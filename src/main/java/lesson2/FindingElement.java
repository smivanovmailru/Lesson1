package lesson2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import java.util.NoSuchElementException;

import static org.testng.Assert.assertEquals;


public class FindingElement {
    @Test
    public static void main(String[] args) {
        //Закомитил часть когда ниже + return false внизу. Но все же думаю, что так делать не надо и это уже лишнее.
     /*   String text = "Your message has been successfully sent to our team.";
        findingTextOnThePage(text);
    }

    public static boolean findingTextOnThePage(String text) {*/
        // Инициализация WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Создание экземпляра WebDriver
        WebDriver driver = new ChromeDriver();

        // Открытие веб-страницы
        driver.get("http://www.automationpractice.pl/index.php?controller=contact");

        // Выбор значения в "Subject Heading"
        WebElement subjectHeading = driver.findElement(By.id("id_contact"));

        // Создание объекта Select (класс. Позволяет управлять элементами дроп-дауна на страницах)
        Select dropdown = new Select(subjectHeading);

        // Выбор опции  в дроп-дауне
        dropdown.selectByVisibleText("Customer service");

        // Поиск поля имейла
        WebElement email = driver.findElement(By.id("email"));

        // Ввод имейла в поле
        email.sendKeys("qwe@mail.com");

        // Поиск поля "Order reference"
        WebElement orderReference = driver.findElement(By.id("id_order"));

        // Ввод значения в поле
        orderReference.sendKeys("1");

        // Поиск поля "Message"
        WebElement message = driver.findElement(By.id("message"));

        // Ввод значения в поле
        message.sendKeys("Test Message");

        // Поиск кнопки
        WebElement button = driver.findElement(By.id("submitMessage"));
        button.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            }

        // Поиск сообщения "Your message has been successfully sent to our team."
        WebElement successMessage = driver.findElement(By.xpath("//*[@id='center_column']/p"));
        String receivedMessage = successMessage.getText();
        assertEquals("Your message has been successfully sent to our team.", receivedMessage, "Что то пошло не так, но в твоем случае все так.");

                driver.quit();
 //   return false;
    }

}
